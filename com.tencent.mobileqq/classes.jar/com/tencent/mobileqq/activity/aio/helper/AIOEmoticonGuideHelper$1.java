package com.tencent.mobileqq.activity.aio.helper;

import agso;
import android.os.Message;
import android.text.TextUtils;
import aran;
import aria;
import arib;
import askx;
import asle;
import beqz;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AIOEmoticonGuideHelper$1
  implements Runnable
{
  public AIOEmoticonGuideHelper$1(agso paramagso) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble start loadConObj.");
    }
    arib localarib = (arib)aran.a().a(545);
    if (localarib == null) {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "config bean is null.");
      }
    }
    for (;;)
    {
      return;
      if (agso.a(this.this$0) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "chat pie is null.");
        }
      }
      else if (agso.a(this.this$0, localarib))
      {
        Object localObject = localarib.a.a;
        if (ThemeUtil.isNowThemeIsNight(agso.a(this.this$0).a, false, null)) {
          localObject = localarib.a.b;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!beqz.b((String)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("aio_emoticon_guide.helper", 2, "file no download.");
            }
            URLDrawable.getDrawable((String)localObject).startDownload(false);
            return;
          }
          int i = localarib.a.c;
          int j = localarib.a.d;
          boolean bool;
          if (j == 1) {
            bool = asle.d(i);
          }
          while (bool)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 2;
            ((Message)localObject).obj = localarib;
            agso.a(this.this$0).sendMessage((Message)localObject);
            return;
            if (j == 2) {
              bool = askx.b(askx.b(i));
            } else {
              bool = false;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper.1
 * JD-Core Version:    0.7.0.1
 */