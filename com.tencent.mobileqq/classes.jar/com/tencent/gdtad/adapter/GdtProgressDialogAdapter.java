package com.tencent.gdtad.adapter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.dialog.AdProgressDialog.Params;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class GdtProgressDialogAdapter
  implements AdProgressDialogAdapter
{
  private QQProgressDialog a;
  
  public void dismiss()
  {
    if ((this.a != null) && (this.a.isShowing()))
    {
      this.a.dismiss();
      this.a = null;
    }
  }
  
  public boolean isShowing(Context paramContext)
  {
    return (this.a != null) && (this.a.isShowing());
  }
  
  public void show(Context paramContext, AdProgressDialog.Params paramParams)
  {
    if (paramContext == null) {}
    for (;;)
    {
      if (this.a != null) {
        this.a.show();
      }
      return;
      if (this.a == null) {
        this.a = new QQProgressDialog(paramContext);
      }
      if (paramParams != null)
      {
        this.a.b(paramParams.yOffset);
        this.a.setCancelable(paramParams.cancelable);
        if (!TextUtils.isEmpty(paramParams.message)) {
          this.a.a(paramParams.message);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtProgressDialogAdapter
 * JD-Core Version:    0.7.0.1
 */