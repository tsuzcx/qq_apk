package com.tencent.mobileqq.apollo.debug.page;

import amsa;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public abstract class CmGameDebugBaseFragment
  extends ReportV4Fragment
{
  public amsa a;
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(amsa paramamsa)
  {
    this.a = paramamsa;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.page.CmGameDebugBaseFragment
 * JD-Core Version:    0.7.0.1
 */