package com.tencent.biz.qqstory.network.handler;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
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
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class GetUserInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<ConvertUinAndUnionIdRequest, ConvertUinAndUnionIdResponse>
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public SoftReference<GetUserInfoHandler.OnGetUserInfoCallback> a;
  public List<QQUserUIItem.UserID> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  private List<QQUserUIItem.UserID> b;
  
  public GetUserInfoHandler()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public GetUserInfoHandler(int paramInt, List<QQUserUIItem.UserID> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public GetUserInfoHandler(GetUserInfoHandler.OnGetUserInfoCallback paramOnGetUserInfoCallback)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramOnGetUserInfoCallback);
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
    localConvertUinAndUnionIdRequest.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localConvertUinAndUnionIdRequest.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    CmdTaskManger.a().a(localConvertUinAndUnionIdRequest, this);
  }
  
  public void a(int paramInt, QQUserUIItem.UserID paramUserID, String paramString)
  {
    a(paramInt, paramUserID, paramString, false, false);
  }
  
  public void a(int paramInt, QQUserUIItem.UserID paramUserID, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      SLog.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramUserID, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new ConvertUinAndUnionIdRequest();
      ((ConvertUinAndUnionIdRequest)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((ConvertUinAndUnionIdRequest)localObject).jdField_c_of_type_Int = paramInt;
      ((ConvertUinAndUnionIdRequest)localObject).jdField_a_of_type_JavaUtilList.add(paramUserID);
      ((ConvertUinAndUnionIdRequest)localObject).jdField_c_of_type_Boolean = paramUserID.a();
      ((ConvertUinAndUnionIdRequest)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((ConvertUinAndUnionIdRequest)localObject).b = paramBoolean2;
      CmdTaskManger.a().a((NetworkRequest)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, List<QQUserUIItem.UserID> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      SLog.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new ConvertUinAndUnionIdRequest();
      ((ConvertUinAndUnionIdRequest)localObject).jdField_c_of_type_Int = paramInt;
      ((ConvertUinAndUnionIdRequest)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      CmdTaskManger.a().a((NetworkRequest)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull ConvertUinAndUnionIdRequest paramConvertUinAndUnionIdRequest, @Nullable ConvertUinAndUnionIdResponse arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    GetUserInfoHandler.UpdateUserInfoEvent localUpdateUserInfoEvent = new GetUserInfoHandler.UpdateUserInfoEvent();
    localUpdateUserInfoEvent.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.jdField_a_of_type_JavaUtilList;
      ??? = new ArrayList();
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localUserManager.a(localQQUserUIItem));
      }
      localUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList = ???;
      localUpdateUserInfoEvent.jdField_a_of_type_JavaLangString = paramConvertUinAndUnionIdRequest.jdField_a_of_type_JavaLangString;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ???;
        if (paramConvertUinAndUnionIdRequest.jdField_c_of_type_Boolean)
        {
          ((StoryConfigManager)SuperManager.a(10)).b("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      StoryDispatcher.a().dispatch(localUpdateUserInfoEvent);
      b();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((paramConvertUinAndUnionIdRequest.jdField_c_of_type_Int != 1) || (paramConvertUinAndUnionIdRequest.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramConvertUinAndUnionIdRequest = paramConvertUinAndUnionIdRequest.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramConvertUinAndUnionIdRequest.hasNext()) {
          break;
        }
        paramErrorMessage = ((QQUserUIItem.UserID)paramConvertUinAndUnionIdRequest.next()).b;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.remove(paramErrorMessage);
      }
      SLog.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localUpdateUserInfoEvent.jdField_a_of_type_JavaLangString = paramConvertUinAndUnionIdRequest.jdField_a_of_type_JavaLangString;
      StoryDispatcher.a().dispatch(localUpdateUserInfoEvent);
      c();
    }
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null)) {
      ((GetUserInfoHandler.OnGetUserInfoCallback)this.jdField_a_of_type_JavaLangRefSoftReference.get()).a(localUpdateUserInfoEvent);
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(new QQUserUIItem.UserID("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserInfoHandler
 * JD-Core Version:    0.7.0.1
 */