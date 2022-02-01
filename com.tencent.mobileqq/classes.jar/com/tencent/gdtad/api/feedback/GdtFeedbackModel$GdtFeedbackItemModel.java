package com.tencent.gdtad.api.feedback;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

final class GdtFeedbackModel$GdtFeedbackItemModel
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private int g;
  private Drawable h;
  private Drawable i;
  
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
      String str = GdtFeedbackModel.e();
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
    this.h = a(this.a);
  }
  
  private void b()
  {
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.c)) {
      localDrawable = a(this.d);
    } else {
      localDrawable = null;
    }
    this.i = localDrawable;
  }
  
  private void c()
  {
    try
    {
      GdtReporter.doCgiReport(this.e.replace("__ACT_TYPE__", String.valueOf(this.g)));
      label19:
      String str = GdtFeedbackModel.e();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackModel.GdtFeedbackItemModel
 * JD-Core Version:    0.7.0.1
 */