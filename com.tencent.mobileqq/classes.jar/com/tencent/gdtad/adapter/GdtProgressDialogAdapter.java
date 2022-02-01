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
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
    {
      this.a.dismiss();
      this.a = null;
    }
  }
  
  public boolean isShowing(Context paramContext)
  {
    paramContext = this.a;
    return (paramContext != null) && (paramContext.isShowing());
  }
  
  public void show(Context paramContext, AdProgressDialog.Params paramParams)
  {
    if (paramContext != null)
    {
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
    paramContext = this.a;
    if (paramContext != null) {
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtProgressDialogAdapter
 * JD-Core Version:    0.7.0.1
 */