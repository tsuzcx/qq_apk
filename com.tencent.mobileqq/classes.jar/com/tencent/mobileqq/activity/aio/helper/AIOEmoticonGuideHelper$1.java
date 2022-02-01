package com.tencent.mobileqq.activity.aio.helper;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.EmoticonGuideConfBean;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
    QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean localSystemAndEmojiConfBean = QQSysAndEmojiConfProcessor.a();
    if (localSystemAndEmojiConfBean == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "config bean is null.");
      }
      return;
    }
    if (AIOEmoticonGuideHelper.a(this.this$0) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "chat pie is null.");
      }
      return;
    }
    if (!AIOEmoticonGuideHelper.a(this.this$0, localSystemAndEmojiConfBean)) {
      return;
    }
    Object localObject = localSystemAndEmojiConfBean.n.c;
    QQAppInterface localQQAppInterface = AIOEmoticonGuideHelper.a(this.this$0).d;
    boolean bool = false;
    if (ThemeUtil.isNowThemeIsNight(localQQAppInterface, false, null)) {
      localObject = localSystemAndEmojiConfBean.n.d;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (!AbsDownloader.hasFile((String)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "file no download.");
      }
      URLDrawable.getDrawable((String)localObject).startDownload(false);
      return;
    }
    int i = localSystemAndEmojiConfBean.n.e;
    int j = localSystemAndEmojiConfBean.n.f;
    if (j == 1) {
      bool = QQSysFaceUtil.isEmoReady(i);
    } else if (j == 2) {
      bool = QQEmojiUtil.isEmoReady(QQEmojiUtil.getEmojiLocalId(i));
    }
    if (!bool) {
      return;
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 2;
    ((Message)localObject).obj = localSystemAndEmojiConfBean;
    AIOEmoticonGuideHelper.b(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper.1
 * JD-Core Version:    0.7.0.1
 */