package com.tencent.mobileqq.activity.home.framejumpentry;

import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class TabJumpHelper$LebaFramePlugin
  extends TabJumpHelper.BaseJumpFramePlugin
{
  public TabJumpHelper$LebaFramePlugin(TabJumpHelper paramTabJumpHelper)
  {
    super(paramTabJumpHelper);
  }
  
  public void a(FrameFragment paramFrameFragment, Bundle paramBundle, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "back from campus_notice %d", new Object[] { Integer.valueOf(DrawerFrame.a) }));
    }
    if (DrawerFrame.a == 0) {
      DrawerFrame.a = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.framejumpentry.TabJumpHelper.LebaFramePlugin
 * JD-Core Version:    0.7.0.1
 */