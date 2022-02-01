package com.tencent.mobileqq.activity.aio.voicetextpanel.anim;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQTheme;
import java.util.Timer;
import mqq.app.AppRuntime;

public class VoiceTextShowAnimator
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { ".", "..", "..." };
  private int jdField_a_of_type_Int = 0;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private VoiceTextShowAnimator.LoadingTextListner jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator$LoadingTextListner;
  private String jdField_a_of_type_JavaLangString = ".";
  private Timer jdField_a_of_type_JavaUtilTimer;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private String b = "";
  private String c;
  
  private SpannableString b()
  {
    SpannableString localSpannableString = new SpannableString(this.c);
    if (this.b.length() > 4) {
      i = 3;
    } else {
      i = 1;
    }
    int j = this.b.length() - i;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    if (QQTheme.a())
    {
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), 0, i, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor()), i, this.c.length(), 33);
      return localSpannableString;
    }
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#03081a")), 0, i, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor()), i, this.c.length(), 33);
    return localSpannableString;
  }
  
  public int a()
  {
    return this.c.length();
  }
  
  public SpannableString a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131716329));
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor()), 0, ((SpannableString)localObject).length(), 33);
    return localObject;
  }
  
  public SpannableString a(String paramString)
  {
    if (paramString.length() - this.b.length() < 3) {
      this.b = paramString;
    } else {
      this.b = paramString.substring(0, this.b.length() + 3 - 1);
    }
    paramString = new StringBuilder();
    paramString.append(this.b);
    paramString.append(this.jdField_a_of_type_JavaLangString);
    this.c = paramString.toString();
    return b();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilTimer.schedule(new VoiceTextShowAnimator.1(this), 0L, 100L);
  }
  
  public void a(AppRuntime paramAppRuntime, ColorStateList paramColorStateList, VoiceTextShowAnimator.LoadingTextListner paramLoadingTextListner)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator$LoadingTextListner = paramLoadingTextListner;
  }
  
  public boolean a(String paramString)
  {
    return paramString.length() - this.b.length() < 3;
  }
  
  public void b()
  {
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_Int = 0;
    this.b = "";
    this.c = "";
    this.jdField_a_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator
 * JD-Core Version:    0.7.0.1
 */