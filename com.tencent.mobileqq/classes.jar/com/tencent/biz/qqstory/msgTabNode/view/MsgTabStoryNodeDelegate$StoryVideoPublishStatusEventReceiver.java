package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class MsgTabStoryNodeDelegate$StoryVideoPublishStatusEventReceiver
  extends QQUIEventReceiver
{
  public MsgTabStoryNodeDelegate$StoryVideoPublishStatusEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    Object localObject2;
    Object localObject1;
    int i;
    if ((paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramStoryVideoPublishStatusEvent.jdField_b_of_type_Boolean))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "upload event: mFakeStoryVideoItem:  isUploading: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploading()), ", isUploadFaul: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail()), ", isUploadSucc: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()), ", isCancel: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel()) });
      }
      Object localObject3 = ((MsgTabStoryManager)paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250)).a();
      localObject2 = paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(((MsgTabNodeInfo)localObject3).jdField_a_of_type_Int, ((MsgTabNodeInfo)localObject3).jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new MsgTabNodeInfo(((MsgTabNodeInfo)localObject3).jdField_a_of_type_Int, ((MsgTabNodeInfo)localObject3).jdField_a_of_type_JavaLangString);
        ((MsgTabNodeInfo)localObject1).jdField_b_of_type_Long = QQStoryContext.a().a();
        paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a((MsgTabNodeInfo)localObject1, false);
      }
      int j = ((MsgTabNodeInfo)localObject1).a();
      int k = ((MsgTabNodeInfo)localObject3).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "upload status change, currentUploadStatus: ", Integer.valueOf(j), "\tnewUploadStatus: ", Integer.valueOf(k) });
      }
      ((MsgTabNodeInfo)localObject1).a((MsgTabNodeInfo)localObject3);
      if (paramStoryVideoPublishStatusEvent.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
        break label525;
      }
      paramStoryVideoPublishStatusEvent = paramStoryVideoPublishStatusEvent.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      if (!paramStoryVideoPublishStatusEvent.isUploadSuc()) {
        break label564;
      }
      localObject2 = new MsgTabNodeVideoInfo();
      ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Boolean = false;
      ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long = paramStoryVideoPublishStatusEvent.mVideoIndex;
      if (((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long == 0L) {
        ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long = paramStoryVideoPublishStatusEvent.mCreateTime;
      }
      if (((MsgTabNodeInfo)localObject1).jdField_a_of_type_JavaUtilList.indexOf(localObject2) == -1) {
        break label533;
      }
      i = 1;
      label337:
      if (i != 0) {
        break label538;
      }
      ((MsgTabNodeInfo)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
      ((MsgTabNodeInfo)localObject1).jdField_b_of_type_Int += 1;
      ((MsgTabNodeInfo)localObject1).d = (paramStoryVideoPublishStatusEvent.mCreateTime / 1000L);
      if (((MsgTabNodeInfo)localObject1).jdField_b_of_type_JavaUtilList == null) {
        ((MsgTabNodeInfo)localObject1).jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      localObject3 = new MsgTabVideoData();
      ((MsgTabVideoData)localObject3).jdField_a_of_type_JavaLangString = paramStoryVideoPublishStatusEvent.mAttachedFeedId;
      ((MsgTabVideoData)localObject3).b = paramStoryVideoPublishStatusEvent.mVid;
      ((MsgTabVideoData)localObject3).jdField_a_of_type_Boolean = false;
      ((MsgTabVideoData)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoPublishStatusEvent;
      ((MsgTabNodeInfo)localObject1).jdField_b_of_type_JavaUtilList.add(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "add videoInfo to list , videoInfo=", localObject2, ", \nnodeInfo=", localObject1, ", \nnow videoList=", ((MsgTabNodeInfo)localObject1).jdField_a_of_type_JavaUtilList });
      }
      i = 1;
      label503:
      if (j != k) {
        break label569;
      }
    }
    for (;;)
    {
      if (i != 0) {
        paramMsgTabStoryNodeDelegate.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a((MsgTabNodeInfo)localObject1, true);
      }
      return;
      label525:
      paramStoryVideoPublishStatusEvent = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      break;
      label533:
      i = 0;
      break label337;
      label538:
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "add videoInfo to list , but exist!!! videoInfo=", localObject2 });
      }
      label564:
      i = 0;
      break label503;
      label569:
      i = 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryVideoUploadManager.StoryVideoPublishStatusEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.StoryVideoPublishStatusEventReceiver
 * JD-Core Version:    0.7.0.1
 */