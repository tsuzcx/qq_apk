package com.tencent.mobileqq.auto.engine.main.fragment;

import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.qcircle.api.interfaces.QCircleHookPluginIntentCallBack;

class ASPluginFragment$1
  implements QCircleHookPluginIntentCallBack
{
  ASPluginFragment$1(ASPluginFragment paramASPluginFragment) {}
  
  public void getPluginIntent(Intent paramIntent)
  {
    this.a.getMainHandler().post(new ASPluginFragment.1.1(this, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.main.fragment.ASPluginFragment.1
 * JD-Core Version:    0.7.0.1
 */