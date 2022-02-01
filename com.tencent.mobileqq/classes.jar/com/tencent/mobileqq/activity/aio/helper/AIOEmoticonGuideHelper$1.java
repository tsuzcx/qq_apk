package com.tencent.mobileqq.activity.aio.helper;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.EmoticonGuideConfBean;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AIOEmoticonGuideHelper$1
  implements Runnable
{
  AIOEmoticonGuideHelper$1(AIOEmoticonGuideHelper paramAIOEmoticonGuideHelper) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble start loadConObj.");
    }
    QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean localSystemAndEmojiConfBean = (QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)QConfigManager.a().a(545);
    if (localSystemAndEmojiConfBean == null) {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "config bean is null.");
      }
    }
    for (;;)
    {
      return;
      if (AIOEmoticonGuideHelper.a(this.this$0) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "chat pie is null.");
        }
      }
      else if (AIOEmoticonGuideHelper.a(this.this$0, localSystemAndEmojiConfBean))
      {
        Object localObject = localSystemAndEmojiConfBean.a.a;
        if (ThemeUtil.isNowThemeIsNight(AIOEmoticonGuideHelper.a(this.this$0).a, false, null)) {
          localObject = localSystemAndEmojiConfBean.a.b;
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
          int i = localSystemAndEmojiConfBean.a.c;
          int j = localSystemAndEmojiConfBean.a.d;
          boolean bool;
          if (j == 1) {
            bool = QQSysFaceUtil.isEmoReady(i);
          }
          while (bool)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 2;
            ((Message)localObject).obj = localSystemAndEmojiConfBean;
            AIOEmoticonGuideHelper.a(this.this$0).sendMessage((Message)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper.1
 * JD-Core Version:    0.7.0.1
 */