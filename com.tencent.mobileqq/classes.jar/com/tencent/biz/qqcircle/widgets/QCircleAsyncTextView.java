package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.qqcircle.beans.Friend;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vve;
import vxx;
import vxy;
import vxz;
import vya;

public class QCircleAsyncTextView
  extends AsyncRichTextView
{
  public static final Pattern a;
  public int a;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
  }
  
  public QCircleAsyncTextView(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_Int = -16777216;
  }
  
  public QCircleAsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -16777216;
  }
  
  public QCircleAsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -16777216;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    int i = 0;
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start();
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        int m = str1.indexOf(",nick:");
        int n = str1.length();
        String str2 = str1.substring(m + ",nick:".length(), n - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
        str2 = "@" + str2;
        paramString.replace(j - i, k - i, str2);
        j = str1.length();
        k = str2.length();
        i += j - k;
      }
      return paramString.toString();
    }
    catch (Exception localException)
    {
      QLog.e("QCircleAsyncTextView", 1, localException, new Object[0]);
    }
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, vya paramvya)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramInt2 < paramInt1) || (paramSpannableStringBuilder.length() < paramInt2)) {
      return;
    }
    paramvya = new vxx(this, paramvya);
    setHighlightColor(getResources().getColor(2131167247));
    paramSpannableStringBuilder.setSpan(paramvya, paramInt1, paramInt2, 33);
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt, Drawable paramDrawable)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramInt < 0) || (paramInt > paramSpannableStringBuilder.length()) || (paramDrawable == null)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableStringBuilder);
    paramSpannableStringBuilder.clear();
    paramSpannableStringBuilder.append(localSpannableStringBuilder.subSequence(0, paramInt)).append(" ");
    if (paramInt < localSpannableStringBuilder.length()) {
      paramSpannableStringBuilder.append(localSpannableStringBuilder.subSequence(paramInt, localSpannableStringBuilder.length()));
    }
    paramSpannableStringBuilder.setSpan(new VerticalCenterImageSpan(paramDrawable), paramInt, paramInt + 1, 33);
  }
  
  public MovementMethod getDefaultMovementMethod()
  {
    return vve.a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    while ((paramMotionEvent.getAction() != 1) || (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 500L)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public boolean performClick()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.performClick();
  }
  
  public void setAtSpan(SpannableStringBuilder paramSpannableStringBuilder, vxz paramvxz)
  {
    if (TextUtils.isEmpty(paramSpannableStringBuilder)) {}
    for (;;)
    {
      return;
      Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramSpannableStringBuilder);
      int i = 0;
      try
      {
        while (localMatcher.find())
        {
          int j = localMatcher.start() - i;
          int k = localMatcher.end();
          String str1 = localMatcher.group();
          int n = str1.indexOf("uin:");
          int i1 = "uin:".length();
          int m = str1.indexOf(",nick:");
          String str2 = str1.substring(n + i1, m);
          n = str1.length();
          String str3 = str1.substring(m + ",nick:".length(), n - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
          Friend localFriend = new Friend();
          localFriend.mUin = Long.parseLong(str2);
          localFriend.mName = str3;
          str2 = "@" + localFriend.mName;
          paramSpannableStringBuilder.replace(j, k - i, str2);
          i += str1.length() - str2.length();
          a(paramSpannableStringBuilder, j, str2.length() + j, new vxy(this, paramvxz, localFriend));
        }
        return;
      }
      catch (Exception paramSpannableStringBuilder)
      {
        QLog.e("QCircleAsyncTextView", 1, paramSpannableStringBuilder, new Object[0]);
      }
    }
  }
  
  public void setClickAreaTextColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setRichText(CharSequence paramCharSequence, vxz paramvxz)
  {
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    setAtSpan(paramCharSequence, paramvxz);
    setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView
 * JD-Core Version:    0.7.0.1
 */