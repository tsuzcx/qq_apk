package com.tencent.gdtad.basics.motivevideo.title;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

public class GdtMvTitleUtil
{
  public static void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    if (paramImageView == null)
    {
      QLog.i("GdtMvTitleUtil", 1, "refreshVoiceIcon view is null");
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
    paramImageView.setContentDescription(HardCodeUtil.a(paramInt));
  }
  
  public static void a(TextView paramTextView, String paramString, int paramInt)
  {
    if (paramTextView == null)
    {
      QLog.i("GdtMvTitleUtil", 1, "refreshCountDown view is null");
      return;
    }
    paramTextView.setText(paramString);
    paramTextView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.title.GdtMvTitleUtil
 * JD-Core Version:    0.7.0.1
 */