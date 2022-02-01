package com.tencent.av.screenshare;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class ScreenShareDialogUtil$ScreenShareSafeSpan
  extends ClickableSpan
{
  private final Context a;
  private final String b;
  
  public ScreenShareDialogUtil$ScreenShareSafeSpan(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  public void onClick(@NonNull View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", this.b);
    this.a.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a.getResources().getColor(2131167133));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareDialogUtil.ScreenShareSafeSpan
 * JD-Core Version:    0.7.0.1
 */