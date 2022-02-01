package com.tencent.mobileqq.activity.home.framejumpentry;

import android.os.Bundle;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.app.FrameFragment;

public class TabJumpHelper$NowFramePlugin
  extends TabJumpHelper.BaseJumpFramePlugin
{
  public TabJumpHelper$NowFramePlugin(TabJumpHelper paramTabJumpHelper)
  {
    super(paramTabJumpHelper);
  }
  
  public void a(FrameFragment paramFrameFragment, Bundle paramBundle, int paramInt, String paramString)
  {
    paramFrameFragment = (Now)paramFrameFragment.a(Now.class);
    if (paramFrameFragment != null)
    {
      paramFrameFragment.b = paramBundle.getBoolean("extra_from_share");
      paramFrameFragment.a = paramBundle.getString("new_video_extra_info");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.framejumpentry.TabJumpHelper.NowFramePlugin
 * JD-Core Version:    0.7.0.1
 */