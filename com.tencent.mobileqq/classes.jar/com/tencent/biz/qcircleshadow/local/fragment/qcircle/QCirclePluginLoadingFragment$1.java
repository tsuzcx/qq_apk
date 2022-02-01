package com.tencent.biz.qcircleshadow.local.fragment.qcircle;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import androidx.fragment.app.FragmentActivity;
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
      QCirclePluginLoadingFragment.b(this.a);
      if (this.a.getActivity() != null) {
        this.a.getActivity().finish();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.fragment.qcircle.QCirclePluginLoadingFragment.1
 * JD-Core Version:    0.7.0.1
 */