package com.tencent.mobileqq.activity;

import MQQ.LhLogoResources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.mobileqq.vas.VasApngUtil;

class QQSettingMe$32
  implements Runnable
{
  QQSettingMe$32(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    this.this$0.a.setVisibility(8);
    if ((PrettyAccountUtil.a() != 1) || (!PrettyAccountUtil.a())) {}
    do
    {
      return;
      localObject = PrettyAccountUtil.a(PrettyAccountUtil.b());
    } while (localObject == null);
    this.this$0.a.setVisibility(0);
    PrettyAccountUtil.a("0X800B231", PrettyAccountUtil.a(), PrettyAccountUtil.b());
    Object localObject = ((LhLogoResources)localObject).logoUrl;
    Drawable localDrawable = URLDrawableHelper.TRANSPARENT;
    localObject = VasApngUtil.getApngURLDrawable((String)localObject, new int[] { 1 }, localDrawable, null, null);
    this.this$0.a.setImageDrawable((Drawable)localObject);
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      this.this$0.a.setColorFilter(1996488704);
    }
    for (;;)
    {
      this.this$0.a.setOnClickListener(new QQSettingMe.32.1(this));
      QQSettingMe.g(this.this$0);
      return;
      this.this$0.a.setColorFilter(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.32
 * JD-Core Version:    0.7.0.1
 */