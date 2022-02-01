package com.tencent.mobileqq.activity.emogroupstore;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qphone.base.util.BaseApplication;

class PicSelectAdapter$2
  implements DialogInterface.OnClickListener
{
  PicSelectAdapter$2(PicSelectAdapter paramPicSelectAdapter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      VasH5PayUtil.a(PicSelectAdapter.a(this.a), PicSelectAdapter.a(this.a), "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", PicSelectAdapter.a(this.a).getApp().getString(2131719674), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.PicSelectAdapter.2
 * JD-Core Version:    0.7.0.1
 */