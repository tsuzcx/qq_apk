package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.content.Intent;

class GdtMotiveVideoFragment$4
  implements IMotiveVideoView
{
  GdtMotiveVideoFragment$4(GdtMotiveVideoFragment paramGdtMotiveVideoFragment) {}
  
  public void a()
  {
    Activity localActivity = b();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    Activity localActivity = b();
    if (localActivity != null) {
      localActivity.setResult(paramInt, paramIntent);
    }
  }
  
  public Activity b()
  {
    return this.a.getQBaseActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoFragment.4
 * JD-Core Version:    0.7.0.1
 */