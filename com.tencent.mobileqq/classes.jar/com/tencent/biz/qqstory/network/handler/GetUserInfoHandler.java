package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.ConvertUinAndUnionIdRequest;
import com.tencent.biz.qqstory.network.response.ConvertUinAndUnionIdResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetUserInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback
{
  public GetUserInfoHandler.OnGetUserInfoCallback a;
  String a;
  public List a;
  public int b;
  
  public GetUserInfoHandler() {}
  
  public GetUserInfoHandler(int paramInt, List paramList)
  {
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public GetUserInfoHandler(GetUserInfoHandler.OnGetUserInfoCallback paramOnGetUserInfoCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback = paramOnGetUserInfoCallback;
  }
  
  public static void d()
  {
    GetUserInfoHandler localGetUserInfoHandler = new GetUserInfoHandler();
    if (TextUtils.isEmpty(QQStoryContext.a().b()))
    {
      long l = QQStoryContext.a().a();
      localGetUserInfoHandler.a(0, new QQUserUIItem.UserID(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().b();
    localGetUserInfoHandler.a(1, new QQUserUIItem.UserID("", str), str);
  }
  
  public void a()
  {
    ConvertUinAndUnionIdRequest localConvertUinAndUnionIdRequest = new ConvertUinAndUnionIdRequest();
    localConvertUinAndUnionIdRequest.c = this.b;
    localConvertUinAndUnionIdRequest.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    CmdTaskManger.a().a(localConvertUinAndUnionIdRequest, this);
  }
  
  public void a(int paramInt, QQUserUIItem.UserID paramUserID, String paramString)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      SLog.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramUserID, localObject });
      localObject = new ConvertUinAndUnionIdRequest();
      ((ConvertUinAndUnionIdRequest)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((ConvertUinAndUnionIdRequest)localObject).c = paramInt;
      ((ConvertUinAndUnionIdRequest)localObject).jdField_a_of_type_JavaUtilList.add(paramUserID);
      ((ConvertUinAndUnionIdRequest)localObject).jdField_a_of_type_Boolean = paramUserID.a();
      CmdTaskManger.a().a((NetworkRequest)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      SLog.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new ConvertUinAndUnionIdRequest();
      ((ConvertUinAndUnionIdRequest)localObject).c = paramInt;
      ((ConvertUinAndUnionIdRequest)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      CmdTaskManger.a().a((NetworkRequest)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull ConvertUinAndUnionIdRequest paramConvertUinAndUnionIdRequest, @Nullable ConvertUinAndUnionIdResponse paramConvertUinAndUnionIdResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    GetUserInfoHandler.UpdateUserInfoEvent localUpdateUserInfoEvent = new GetUserInfoHandler.UpdateUserInfoEvent();
    localUpdateUserInfoEvent.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = paramConvertUinAndUnionIdResponse.jdField_a_of_type_JavaUtilList;
      paramConvertUinAndUnionIdResponse = new ArrayList();
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        paramConvertUinAndUnionIdResponse.add(localUserManager.a(localQQUserUIItem));
      }
      localUpdateUserInfoEvent.errorInfo = paramErrorMessage;
      localUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList = paramConvertUinAndUnionIdResponse;
      localUpdateUserInfoEvent.jdField_a_of_type_JavaLangString = paramConvertUinAndUnionIdRequest.jdField_a_of_type_JavaLangString;
      if (paramConvertUinAndUnionIdResponse.size() == 1)
      {
        paramConvertUinAndUnionIdResponse = (QQUserUIItem)paramConvertUinAndUnionIdResponse.get(0);
        localUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramConvertUinAndUnionIdResponse;
        if (paramConvertUinAndUnionIdRequest.jdField_a_of_type_Boolean)
        {
          ((StoryConfigManager)SuperManager.a(10)).b("qqstory_my_uin", paramConvertUinAndUnionIdResponse.qq);
          QQStoryContext.a().a(paramConvertUinAndUnionIdResponse.uid);
          if (paramConvertUinAndUnionIdResponse.uid.equals("0_1000")) {
            SLog.e("Q.qqstory.user.GetUserInfoHandler", "****server like shit return default unionId!!!!!!!!!!!!!");
          }
        }
      }
      Dispatchers.get().dispatch(localUpdateUserInfoEvent);
      b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback.a(localUpdateUserInfoEvent);
      }
      return;
      SLog.b("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localUpdateUserInfoEvent.errorInfo = paramErrorMessage;
      localUpdateUserInfoEvent.jdField_a_of_type_JavaLangString = paramConvertUinAndUnionIdRequest.jdField_a_of_type_JavaLangString;
      Dispatchers.get().dispatch(localUpdateUserInfoEvent);
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserInfoHandler
 * JD-Core Version:    0.7.0.1
 */