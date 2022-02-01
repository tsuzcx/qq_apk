package com.tencent.gdtad.api.feedback;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

final class GdtFeedbackModel$GdtFeedbackItemModel
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  private Drawable a(String paramString)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      String str = GdtFeedbackModel.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gdtFeedbackItemDrawable url=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(localException);
      AdLog.e(str, localStringBuilder.toString());
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(this.jdField_a_of_type_JavaLangString);
  }
  
  private void b()
  {
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.c)) {
      localDrawable = a(this.d);
    } else {
      localDrawable = null;
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localDrawable;
  }
  
  private void c()
  {
    try
    {
      GdtReporter.doCgiReport(this.e.replace("__ACT_TYPE__", String.valueOf(this.jdField_b_of_type_Int)));
      label19:
      String str = GdtFeedbackModel.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" is reported");
      AdLog.i(str, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackModel.GdtFeedbackItemModel
 * JD-Core Version:    0.7.0.1
 */