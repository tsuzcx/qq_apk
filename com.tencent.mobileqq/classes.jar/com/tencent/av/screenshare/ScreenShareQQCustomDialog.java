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
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ScreenShareQQCustomDialog(Context paramContext, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Runnable a()
  {
    return new ScreenShareQQCustomDialog.1(this);
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      this.lBtn.setText(String.format("%s(%d)", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) }));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, 1000L);
      return;
    }
    this.lBtn.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = this.b;
    this.lBtn.setEnabled(true);
  }
  
  public void a(Typeface paramTypeface, ColorStateList paramColorStateList)
  {
    this.title.setTypeface(paramTypeface);
    this.rBtn.setTypeface(paramTypeface);
    this.lBtn.setTypeface(paramTypeface);
    this.lBtn.setTextColor(paramColorStateList);
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onBackPressed() {}
  
  public void show()
  {
    super.show();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int > 0))
    {
      this.lBtn.setText(String.format("%s(%d)", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) }));
      this.lBtn.setEnabled(false);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(a(), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareQQCustomDialog
 * JD-Core Version:    0.7.0.1
 */