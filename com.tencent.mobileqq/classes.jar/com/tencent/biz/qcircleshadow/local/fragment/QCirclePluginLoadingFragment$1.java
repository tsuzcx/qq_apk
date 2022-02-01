package com.tencent.biz.qcircleshadow.local.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.support.v4.app.QFragmentActivity;
import android.view.KeyEvent;
import com.tencent.biz.qcircleshadow.local.widget.QCirclePluginLoadingDialog;

class QCirclePluginLoadingFragment$1
  implements DialogInterface.OnKeyListener
{
  QCirclePluginLoadingFragment$1(QCirclePluginLoadingFragment paramQCirclePluginLoadingFragment) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((QCirclePluginLoadingFragment.a(this.a) != null) && (QCirclePluginLoadingFragment.a(this.a).isShowing())) {
        QCirclePluginLoadingFragment.a(this.a).dismiss();
      }
      if (this.a.getActivity() != null) {
        this.a.getActivity().finish();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.QCirclePluginLoadingFragment.1
 * JD-Core Version:    0.7.0.1
 */