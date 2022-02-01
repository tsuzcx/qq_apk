package com.tencent.mobileqq.activity.home.framejumpentry;

import android.os.Bundle;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.app.FrameFragment;

public class TabJumpHelper$ContactFramePlugin
  extends TabJumpHelper.BaseJumpFramePlugin
{
  public TabJumpHelper$ContactFramePlugin(TabJumpHelper paramTabJumpHelper)
  {
    super(paramTabJumpHelper);
  }
  
  public void a(FrameFragment paramFrameFragment, Bundle paramBundle, int paramInt, String paramString)
  {
    paramFrameFragment = (Contacts)paramFrameFragment.a(Contacts.class);
    if (paramFrameFragment != null) {
      paramFrameFragment.c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.framejumpentry.TabJumpHelper.ContactFramePlugin
 * JD-Core Version:    0.7.0.1
 */