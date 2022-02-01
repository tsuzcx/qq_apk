package com.tencent.mobileqq.activity.aio.helper;

import agfm;
import android.os.Message;
import android.text.TextUtils;
import aqxe;
import arew;
import arex;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AIOEmoticonGuideHelper$1
  implements Runnable
{
  public AIOEmoticonGuideHelper$1(agfm paramagfm) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble start loadConObj.");
    }
    arex localarex = (arex)aqxe.a().a(545);
    if (localarex == null) {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "config bean is null.");
      }
    }
    for (;;)
    {
      return;
      if (agfm.a(this.this$0) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "chat pie is null.");
        }
      }
      else if (agfm.a(this.this$0, localarex))
      {
        Object localObject = localarex.a.a;
        if (ThemeUtil.isNowThemeIsNight(agfm.a(this.this$0).app, false, null)) {
          localObject = localarex.a.b;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!AbsDownloader.hasFile((String)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("aio_emoticon_guide.helper", 2, "file no download.");
            }
            URLDrawable.getDrawable((String)localObject).startDownload(false);
            return;
          }
          int i = localarex.a.c;
          int j = localarex.a.d;
          boolean bool;
          if (j == 1) {
            bool = QQSysFaceUtil.isEmoReady(i);
          }
          while (bool)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 2;
            ((Message)localObject).obj = localarex;
            agfm.a(this.this$0).sendMessage((Message)localObject);
            return;
            if (j == 2) {
              bool = QQEmojiUtil.isEmoReady(QQEmojiUtil.getEmojiLocalId(i));
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