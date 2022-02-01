package com.tencent.biz.qqstory.playmode.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;

final class PlayModeUtils$11
  implements DialogInterface.OnClickListener
{
  PlayModeUtils$11(StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SLog.d("Q.qqstory.player.PlayModeUtils", "onClick delete =%s", new Object[] { this.a });
    StoryVideoUploadManager.a(this.b);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.11
 * JD-Core Version:    0.7.0.1
 */