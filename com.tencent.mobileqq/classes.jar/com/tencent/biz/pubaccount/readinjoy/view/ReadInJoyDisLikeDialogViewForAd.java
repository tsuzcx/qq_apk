package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView;

public class ReadInJoyDisLikeDialogViewForAd
  extends ReadInJoyDisLikeDialogView
{
  public ReadInJoyDisLikeDialogViewForAd(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    super.a(paramContext);
    this.e = Boolean.valueOf(false);
    if (this.d != null) {
      this.d.setText(HardCodeUtil.a(2131910299));
    }
    if (this.c != null) {
      this.c.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd
 * JD-Core Version:    0.7.0.1
 */