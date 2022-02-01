package com.tencent.mobileqq.activity;

import MQQ.LhLogoResources;
import afic;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import beyq;
import bhyu;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasApngUtil;

public class QQSettingMe$31
  implements Runnable
{
  QQSettingMe$31(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    this.this$0.a.setVisibility(8);
    if ((bhyu.a() != 1) || (!bhyu.a())) {}
    do
    {
      return;
      localObject = bhyu.a(bhyu.b());
    } while (localObject == null);
    this.this$0.a.setVisibility(0);
    bhyu.a("0X800B231", bhyu.a(), bhyu.b());
    Object localObject = ((LhLogoResources)localObject).logoUrl;
    Drawable localDrawable = beyq.a;
    localObject = VasApngUtil.getApngURLDrawable((String)localObject, new int[] { 1 }, localDrawable, null, null);
    this.this$0.a.setImageDrawable((Drawable)localObject);
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      this.this$0.a.setColorFilter(1996488704);
    }
    for (;;)
    {
      this.this$0.a.setOnClickListener(new afic(this));
      return;
      this.this$0.a.setColorFilter(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.31
 * JD-Core Version:    0.7.0.1
 */