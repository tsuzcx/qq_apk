package com.tencent.mobileqq.app.utils;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

public class NicknameAppendNetStateUtil
{
  public static void a(AppRuntime paramAppRuntime, TextView paramTextView, String paramString)
  {
    ReportController.a(paramAppRuntime, "dc00898", "", "", "0X800BC3A", "0X800BC3A", 0, 0, "", "", "", "");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("（无网络）");
    localObject1 = ((StringBuilder)localObject1).toString();
    float f3 = paramTextView.getPaint().measureText((String)localObject1);
    float f2 = ((ViewGroup)paramTextView.getParent()).getWidth();
    Object localObject2 = paramTextView.getLayoutParams();
    float f1 = f2;
    if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      f1 = f2 - ((ViewGroup.MarginLayoutParams)localObject2).leftMargin - ((ViewGroup.MarginLayoutParams)localObject2).rightMargin;
    }
    if (f1 < f3)
    {
      f2 = paramTextView.getPaint().measureText("...（无网络）");
      do
      {
        if (paramString.length() == 1)
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append(paramString);
          paramAppRuntime.append("（无网络）");
          paramTextView.setText(paramAppRuntime.toString());
          return;
        }
        localObject1 = paramString.substring(0, paramString.length() - 1);
        paramString = (String)localObject1;
      } while (paramTextView.getPaint().measureText((String)localObject1) + f2 > f1);
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append("...（无网络）");
      localObject1 = paramString.toString();
    }
    paramString = new SpannableStringBuilder((CharSequence)localObject1);
    paramString.setSpan(new NicknameAppendNetStateUtil.1(paramAppRuntime), ((String)localObject1).length() - 5, ((String)localObject1).length(), 34);
    paramTextView.setText(paramString);
    paramTextView.setHighlightColor(0);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.NicknameAppendNetStateUtil
 * JD-Core Version:    0.7.0.1
 */