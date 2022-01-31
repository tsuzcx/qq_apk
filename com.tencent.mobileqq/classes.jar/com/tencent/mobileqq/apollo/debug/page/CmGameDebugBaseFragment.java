package com.tencent.mobileqq.apollo.debug.page;

import aixg;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public abstract class CmGameDebugBaseFragment
  extends Fragment
{
  public aixg a;
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(aixg paramaixg)
  {
    this.a = paramaixg;
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