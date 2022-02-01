package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import bmug;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CheckQZoneOatFile
  extends AsyncStep
{
  public int a()
  {
    if ((BaseApplicationImpl.sProcessId == 1) && (19 < Build.VERSION.SDK_INT)) {
      bmug.a().b();
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckQZoneOatFile
 * JD-Core Version:    0.7.0.1
 */