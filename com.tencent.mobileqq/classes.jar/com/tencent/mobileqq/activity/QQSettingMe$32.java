package com.tencent.mobileqq.activity;

import MQQ.LhLogoResources;
import aeau;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import bgff;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasApngUtil;

public class QQSettingMe$32
  implements Runnable
{
  QQSettingMe$32(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    this.this$0.a.setVisibility(8);
    if ((bgff.a() != 1) || (!bgff.a())) {}
    do
    {
      return;
      localObject = bgff.a(bgff.b());
    } while (localObject == null);
    this.this$0.a.setVisibility(0);
    bgff.a("0X800B231", bgff.a(), bgff.b());
    Object localObject = ((LhLogoResources)localObject).logoUrl;
    Drawable localDrawable = URLDrawableHelper.TRANSPARENT;
    localObject = VasApngUtil.getApngURLDrawable((String)localObject, new int[] { 1 }, localDrawable, null, null);
    this.this$0.a.setImageDrawable((Drawable)localObject);
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      this.this$0.a.setColorFilter(1996488704);
    }
    for (;;)
    {
      this.this$0.a.setOnClickListener(new aeau(this));
      return;
      this.this$0.a.setColorFilter(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.32
 * JD-Core Version:    0.7.0.1
 */