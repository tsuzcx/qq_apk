package com.tencent.gdtad.adapter;

import android.content.Context;
import com.tencent.ad.tangram.toast.AdToastAdapter;
import com.tencent.mobileqq.widget.QQToast;

public class GdtToastAdapter
  implements AdToastAdapter
{
  public void show(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    int i = 2;
    if (paramInt1 == 1) {
      paramInt1 = 1;
    } else if (paramInt1 == 2) {
      paramInt1 = i;
    } else {
      paramInt1 = 0;
    }
    QQToast.makeText(paramContext, paramInt1, paramCharSequence, paramInt2).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtToastAdapter
 * JD-Core Version:    0.7.0.1
 */