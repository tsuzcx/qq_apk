package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

class MsgTabStoryNodeDelegate$4
  extends SimpleJob<Object>
{
  MsgTabStoryNodeDelegate$4(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, String paramString1, MsgTabNodeInfo paramMsgTabNodeInfo, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = MsgTabStoryNodeDelegate.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, this.jdField_a_of_type_JavaLangString);
    if ((paramJobContext != null) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.e, paramJobContext.mVid)))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.g = paramJobContext.mVideoThumbnailUrl;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.e = paramJobContext.mVid;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.f = paramJobContext.mAttachedFeedId;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.i = "";
      ThreadManager.getUIHandler().post(new MsgTabStoryNodeDelegate.4.1(this));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.4
 * JD-Core Version:    0.7.0.1
 */