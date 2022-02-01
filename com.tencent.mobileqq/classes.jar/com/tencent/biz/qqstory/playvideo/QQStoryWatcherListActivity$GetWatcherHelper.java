package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserSimpleInfo;
import com.tencent.biz.qqstory.network.request.GetVideoWatcherListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoWatcherListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class QQStoryWatcherListActivity$GetWatcherHelper
  extends CmdTaskManger.UIThreadCallback<GetVideoWatcherListRequest, GetVideoWatcherListResponse>
  implements GetUserInfoHandler.OnGetUserInfoCallback
{
  int jdField_a_of_type_Int = 0;
  protected long a;
  final GetUserInfoHandler jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler;
  final QQStoryWatcherListActivity jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
  final String jdField_a_of_type_JavaLangString;
  List<qqstory_struct.UserSimpleInfo> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = true;
  protected long b;
  List<qqstory_struct.UserSimpleInfo> b;
  
  public QQStoryWatcherListActivity$GetWatcherHelper(QQStoryWatcherListActivity paramQQStoryWatcherListActivity, String paramString)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity = paramQQStoryWatcherListActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler = new GetUserInfoHandler(this);
  }
  
  private void b()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("GetWatcherHelper: requireWatcherByPage return, currentReqSeek = ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append(", uinCount = ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
          QLog.e("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject1).toString());
        }
        QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, true, true, null);
        return;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      int i = this.jdField_a_of_type_Int;
      this.jdField_b_of_type_JavaUtilList = ((List)localObject1).subList(i, Math.min(i + 20, ((List)localObject1).size()));
      i = this.jdField_b_of_type_JavaUtilList.size();
      if (this.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("GetWatcherHelper: requireWatcherByPage return, because toRequireList.isEmpty(), currentReqSeek = ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append(", uinCount = ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
          QLog.e("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject1).toString());
        }
        QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, true, true, null);
        return;
      }
      Object localObject3 = (UserManager)SuperManager.a(2);
      localObject1 = new ArrayList(i);
      Object localObject2 = new ArrayList(i);
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = ((qqstory_struct.UserSimpleInfo)localIterator.next()).union_id.get().toStringUtf8();
        QQUserUIItem localQQUserUIItem = ((UserManager)localObject3).b(str);
        if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
          ((List)localObject2).add(localQQUserUIItem);
        } else {
          ((List)localObject1).add(new QQUserUIItem.UserID("", str));
        }
      }
      if (((List)localObject1).isEmpty())
      {
        if (QLog.isDevelopLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("GetWatcherHelper: requireWatcherByPage load localData userIDS = ");
          ((StringBuilder)localObject3).append(localObject1);
          QLog.e("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject3).toString());
        }
        this.jdField_a_of_type_Int += i;
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
        boolean bool;
        if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
          bool = true;
        } else {
          bool = false;
        }
        QQStoryWatcherListActivity.b((QQStoryWatcherListActivity)localObject1, true, bool, (List)localObject2);
        return;
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("GetWatcherHelper: requireWatcherByPage requestUserIds = ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.e("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler.a(1, (List)localObject1);
      return;
    }
    QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, true, true, null);
  }
  
  public void a()
  {
    Object localObject = new GetVideoWatcherListRequest();
    ((GetVideoWatcherListRequest)localObject).b = this.jdField_a_of_type_JavaLangString;
    CmdTaskManger.a().a((NetworkRequest)localObject, this);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetWatcherHelper: requireWatcherIds feedId = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.w("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetWatcherHelper: onCallback errorInfo = ");
      ((StringBuilder)localObject).append(paramUpdateUserInfoEvent.a);
      QLog.e("Q.qqstory.player.watcherlist.activity", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool3 = paramUpdateUserInfoEvent.a.isSuccess();
    boolean bool1 = true;
    boolean bool2 = false;
    if (bool3)
    {
      int i = this.jdField_b_of_type_JavaUtilList.size();
      localObject = (UserManager)SuperManager.a(2);
      paramUpdateUserInfoEvent = new ArrayList(i);
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = ((UserManager)localObject).b(((qqstory_struct.UserSimpleInfo)localIterator.next()).union_id.get().toStringUtf8());
        if (localQQUserUIItem != null) {
          paramUpdateUserInfoEvent.add(localQQUserUIItem);
        }
      }
      this.jdField_a_of_type_Int += i;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
      bool1 = bool2;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
        bool1 = true;
      }
      QQStoryWatcherListActivity.b((QQStoryWatcherListActivity)localObject, true, bool1, paramUpdateUserInfoEvent);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.jdField_a_of_type_Boolean)
    {
      paramUpdateUserInfoEvent = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
      if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) {
        bool1 = false;
      }
      QQStoryWatcherListActivity.b(paramUpdateUserInfoEvent, false, bool1, null);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new QQStoryWatcherListActivity.GetWatcherHelper.1(this));
  }
  
  public void a(@NonNull GetVideoWatcherListRequest paramGetVideoWatcherListRequest, @Nullable GetVideoWatcherListResponse paramGetVideoWatcherListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isDevelopLevel())
    {
      paramGetVideoWatcherListRequest = new StringBuilder();
      paramGetVideoWatcherListRequest.append("GetWatcherHelper: onResponseOnUIThread errorMsg = ");
      paramGetVideoWatcherListRequest.append(paramErrorMessage);
      QLog.w("Q.qqstory.player.watcherlist.activity", 2, paramGetVideoWatcherListRequest.toString());
    }
    boolean bool = paramErrorMessage.isSuccess();
    int i = 0;
    if ((bool) && (paramGetVideoWatcherListResponse != null))
    {
      this.jdField_a_of_type_Long = paramGetVideoWatcherListResponse.jdField_a_of_type_Long;
      this.jdField_b_of_type_Long = paramGetVideoWatcherListResponse.jdField_b_of_type_Long;
      long l1 = this.jdField_b_of_type_Long;
      long l2 = this.jdField_a_of_type_Long;
      if (l1 < l2) {
        this.jdField_b_of_type_Long = l2;
      }
      if (this.jdField_b_of_type_Long > 0L)
      {
        paramGetVideoWatcherListRequest = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
        paramErrorMessage = new StringBuilder();
        paramErrorMessage.append(QQStoryWatcherListActivity.a());
        paramErrorMessage.append(UIUtils.a(this.jdField_b_of_type_Long));
        paramGetVideoWatcherListRequest.setTitle(paramErrorMessage.toString());
      }
      this.jdField_a_of_type_JavaUtilList = paramGetVideoWatcherListResponse.jdField_a_of_type_JavaUtilList;
      if (QLog.isDevelopLevel())
      {
        paramGetVideoWatcherListRequest = new StringBuilder();
        paramGetVideoWatcherListRequest.append("GetWatcherHelper: onResponseOnUIThread isSuccess mTotalWatcherCount = ");
        paramGetVideoWatcherListRequest.append(this.jdField_a_of_type_Long);
        paramGetVideoWatcherListRequest.append(", mTotalReadTime = ");
        paramGetVideoWatcherListRequest.append(this.jdField_b_of_type_Long);
        paramGetVideoWatcherListRequest.append(", uinCount = ");
        paramGetVideoWatcherListResponse = this.jdField_a_of_type_JavaUtilList;
        if (paramGetVideoWatcherListResponse != null) {
          i = paramGetVideoWatcherListResponse.size();
        }
        paramGetVideoWatcherListRequest.append(i);
        QLog.w("Q.qqstory.player.watcherlist.activity", 2, paramGetVideoWatcherListRequest.toString());
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime = this.jdField_b_of_type_Long;
        ((FeedManager)SuperManager.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
      }
      b();
      return;
    }
    QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, false, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity.GetWatcherHelper
 * JD-Core Version:    0.7.0.1
 */