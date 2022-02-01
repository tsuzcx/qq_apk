package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class SendVideoToFriendHelper$DownloadStatusUpdateReceiver
  extends QQUIEventReceiver<SendVideoToFriendHelper, PlayModeUtils.DownloadStatusChangeEvent>
{
  public SendVideoToFriendHelper$DownloadStatusUpdateReceiver(@NonNull SendVideoToFriendHelper paramSendVideoToFriendHelper)
  {
    super(paramSendVideoToFriendHelper);
  }
  
  public void a(@NonNull SendVideoToFriendHelper paramSendVideoToFriendHelper, @NonNull PlayModeUtils.DownloadStatusChangeEvent paramDownloadStatusChangeEvent)
  {
    if (TextUtils.equals("SendVideoToFriendHelper", paramDownloadStatusChangeEvent.jdField_a_of_type_JavaLangString))
    {
      int i = paramDownloadStatusChangeEvent.jdField_a_of_type_Int;
      if ((i != 1) && (i != 2) && (i != 3)) {
        return;
      }
      SLog.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramDownloadStatusChangeEvent.b);
      SendVideoToFriendHelper.a(paramSendVideoToFriendHelper, false);
      paramSendVideoToFriendHelper.a(paramSendVideoToFriendHelper.jdField_a_of_type_AndroidOsBundle, paramSendVideoToFriendHelper.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramSendVideoToFriendHelper.jdField_a_of_type_JavaLangString, paramDownloadStatusChangeEvent.b);
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayModeUtils.DownloadStatusChangeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.DownloadStatusUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */