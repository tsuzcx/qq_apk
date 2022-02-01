package com.tencent.biz.qcircleshadow.local.fragment.flashshow;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.auto.engine.event.ASEngineEnterEvent;

class FSPluginLoadingFragment$1
  implements DialogInterface.OnKeyListener
{
  FSPluginLoadingFragment$1(FSPluginLoadingFragment paramFSPluginLoadingFragment) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((FSPluginLoadingFragment.a(this.a) != null) && (FSPluginLoadingFragment.a(this.a).isShowing())) {
        FSPluginLoadingFragment.a(this.a).dismiss();
      }
      paramDialogInterface = new ASEngineEnterEvent("flash-show-app");
      paramDialogInterface.setCancel(true);
      SimpleEventBus.getInstance().dispatchEvent(paramDialogInterface);
      if (this.a.getActivity() != null)
      {
        this.a.getActivity().finish();
        this.a.getActivity().overridePendingTransition(0, 0);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.flashshow.FSPluginLoadingFragment.1
 * JD-Core Version:    0.7.0.1
 */