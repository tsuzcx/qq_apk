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
  private static final String[] a = { ".", "..", "..." };
  private Timer b;
  private int c = 0;
  private String d = ".";
  private String e = "";
  private String f;
  private AppRuntime g;
  private ColorStateList h;
  private VoiceTextShowAnimator.LoadingTextListner i;
  
  private SpannableString f()
  {
    SpannableString localSpannableString = new SpannableString(this.f);
    if (this.e.length() > 4) {
      j = 3;
    } else {
      j = 1;
    }
    int k = this.e.length() - j;
    int j = k;
    if (k < 0) {
      j = 0;
    }
    if (QQTheme.isNowThemeIsNight())
    {
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), 0, j, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(this.h.getDefaultColor()), j, this.f.length(), 33);
      return localSpannableString;
    }
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#03081a")), 0, j, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(this.h.getDefaultColor()), j, this.f.length(), 33);
    return localSpannableString;
  }
  
  public void a()
  {
    this.b.schedule(new VoiceTextShowAnimator.1(this), 0L, 100L);
  }
  
  public void a(AppRuntime paramAppRuntime, ColorStateList paramColorStateList, VoiceTextShowAnimator.LoadingTextListner paramLoadingTextListner)
  {
    this.h = paramColorStateList;
    this.g = paramAppRuntime;
    this.b = new Timer();
    this.i = paramLoadingTextListner;
  }
  
  public boolean a(String paramString)
  {
    return paramString.length() - this.e.length() < 3;
  }
  
  public SpannableString b(String paramString)
  {
    if (paramString.length() - this.e.length() < 3) {
      this.e = paramString;
    } else {
      this.e = paramString.substring(0, this.e.length() + 3 - 1);
    }
    paramString = new StringBuilder();
    paramString.append(this.e);
    paramString.append(this.d);
    this.f = paramString.toString();
    return f();
  }
  
  public void b()
  {
    Timer localTimer = this.b;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.b = null;
    }
    this.c = 0;
    this.e = "";
    this.f = "";
    this.d = "";
  }
  
  public SpannableString c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131913771));
    ((StringBuilder)localObject).append(this.d);
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(this.h.getDefaultColor()), 0, ((SpannableString)localObject).length(), 33);
    return localObject;
  }
  
  public int d()
  {
    return this.f.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator
 * JD-Core Version:    0.7.0.1
 */