package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.content.Intent;

class GdtMotiveVideoFragment$3
  implements IMotiveVideoView
{
  GdtMotiveVideoFragment$3(GdtMotiveVideoFragment paramGdtMotiveVideoFragment) {}
  
  public Activity a()
  {
    return this.a.getQBaseActivity();
  }
  
  public void a()
  {
    Activity localActivity = a();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    Activity localActivity = a();
    if (localActivity != null) {
      localActivity.setResult(paramInt, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoFragment.3
 * JD-Core Version:    0.7.0.1
 */