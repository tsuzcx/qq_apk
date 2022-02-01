package com.tencent.mobileqq.activity.aio.helper;

import agjn;
import android.os.Message;
import android.text.TextUtils;
import aqlk;
import aqso;
import aqsp;
import arvj;
import arvq;
import bdsh;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AIOEmoticonGuideHelper$1
  implements Runnable
{
  public AIOEmoticonGuideHelper$1(agjn paramagjn) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble start loadConObj.");
    }
    aqsp localaqsp = (aqsp)aqlk.a().a(545);
    if (localaqsp == null) {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "config bean is null.");
      }
    }
    for (;;)
    {
      return;
      if (agjn.a(this.this$0) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "chat pie is null.");
        }
      }
      else if (agjn.a(this.this$0, localaqsp))
      {
        Object localObject = localaqsp.a.a;
        if (ThemeUtil.isNowThemeIsNight(agjn.a(this.this$0).a, false, null)) {
          localObject = localaqsp.a.b;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!bdsh.b((String)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("aio_emoticon_guide.helper", 2, "file no download.");
            }
            URLDrawable.getDrawable((String)localObject).startDownload(false);
            return;
          }
          int i = localaqsp.a.c;
          int j = localaqsp.a.d;
          boolean bool;
          if (j == 1) {
            bool = arvq.d(i);
          }
          while (bool)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 2;
            ((Message)localObject).obj = localaqsp;
            agjn.a(this.this$0).sendMessage((Message)localObject);
            return;
            if (j == 2) {
              bool = arvj.b(arvj.b(i));
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