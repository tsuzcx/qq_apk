package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;

class FastWebActivity$18
  implements DialogInterface.OnDismissListener
{
  FastWebActivity$18(FastWebActivity paramFastWebActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Context localContext;
    if (!FastWebActivity.a(this.a))
    {
      localContext = this.a.getApplicationContext();
      if (!FastWebActivity.b(this.a)) {
        break label80;
      }
    }
    label80:
    for (paramDialogInterface = "0X8008994";; paramDialogInterface = "0X800898D")
    {
      FastWebShareUtils.a(localContext, paramDialogInterface, 11, this.a.a);
      ReportUtil.a(this.a, this.a.getAppInterface(), this.a.a, -1, -1, true, false);
      FastWebActivity.c(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.18
 * JD-Core Version:    0.7.0.1
 */