package com.app.hubert.guide.core;

import com.app.hubert.guide.lifecycle.FragmentLifecycleAdapter;
import com.app.hubert.guide.util.LogUtil;

class Controller$4
  extends FragmentLifecycleAdapter
{
  Controller$4(Controller paramController) {}
  
  public void onDestroyView()
  {
    LogUtil.i("ListenerFragment.onDestroyView");
    this.this$0.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.app.hubert.guide.core.Controller.4
 * JD-Core Version:    0.7.0.1
 */