package com.tencent.ilive.sorely;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ilive.R.id;
import com.tencent.ilive.R.layout;

public class SoLoading
{
  private Dialog loading;
  private TextView tipTextView;
  
  public SoLoading(Context paramContext, String paramString)
  {
    View localView = LayoutInflater.from(paramContext).inflate(R.layout.loading_dialog, null);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(R.id.dialog_view);
    ImageView localImageView = (ImageView)localView.findViewById(2131368591);
    this.tipTextView = ((TextView)localView.findViewById(R.id.tipTextView));
    if (!TextUtils.isEmpty(paramString)) {
      this.tipTextView.setText(paramString);
    }
    localImageView.startAnimation(AnimationUtils.loadAnimation(paramContext, 2130772098));
    this.loading = new Dialog(paramContext, 2131756040);
    this.loading.setCancelable(false);
    this.loading.setContentView(localLinearLayout, new LinearLayout.LayoutParams(-1, -1));
  }
  
  public void dismiss()
  {
    if (this.loading.isShowing()) {
      this.loading.dismiss();
    }
  }
  
  public void show()
  {
    if (!this.loading.isShowing()) {
      this.loading.show();
    }
  }
  
  public void updateText(String paramString)
  {
    this.tipTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.sorely.SoLoading
 * JD-Core Version:    0.7.0.1
 */