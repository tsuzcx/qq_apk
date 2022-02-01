package com.tencent.av.screenshare;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ScreenShareQQCustomDialog
  extends QQCustomDialog
{
  private Handler a = new Handler(Looper.getMainLooper());
  private int b;
  private int c;
  private boolean d;
  private String e;
  private String f;
  
  public ScreenShareQQCustomDialog(Context paramContext, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.b = paramInt2;
    this.c = paramInt2;
    this.d = paramBoolean;
    this.e = paramString1;
    this.f = paramString2;
  }
  
  private Runnable a()
  {
    return new ScreenShareQQCustomDialog.1(this);
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.b > 0)
    {
      this.lBtn.setText(this.e);
      this.rBtn.setText(String.format("%s(%d)", new Object[] { this.f, Integer.valueOf(this.b) }));
      this.a.postDelayed(paramRunnable, 1000L);
      return;
    }
    this.lBtn.setText(this.e);
    this.rBtn.setText(this.f);
    this.b = this.c;
    this.rBtn.setEnabled(true);
  }
  
  public void a(Typeface paramTypeface, ColorStateList paramColorStateList)
  {
    this.title.setTypeface(paramTypeface);
    this.lBtn.setTextColor(paramColorStateList);
    this.rBtn.setTextColor(paramColorStateList);
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.a.removeCallbacksAndMessages(null);
  }
  
  public void onBackPressed() {}
  
  public void show()
  {
    super.show();
    if ((this.d) && (this.b > 0))
    {
      this.lBtn.setText(this.e);
      this.lBtn.setEnabled(true);
      this.rBtn.setText(String.format("%s(%d)", new Object[] { this.f, Integer.valueOf(this.b) }));
      this.rBtn.setEnabled(false);
      this.a.postDelayed(a(), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareQQCustomDialog
 * JD-Core Version:    0.7.0.1
 */