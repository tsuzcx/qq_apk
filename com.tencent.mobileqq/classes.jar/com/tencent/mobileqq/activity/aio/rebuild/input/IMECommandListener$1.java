package com.tencent.mobileqq.activity.aio.rebuild.input;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.voicechange.VoiceChangeModeParams;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class IMECommandListener$1
  implements Runnable
{
  IMECommandListener$1(IMECommandListener paramIMECommandListener, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, Context paramContext, View paramView) {}
  
  public void run()
  {
    Object localObject1 = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getRecorderParam();
    Object localObject2 = TransFileUtil.getTransferFilePath(this.a.getCurrentAccountUin(), null, 2, null);
    localObject2 = MessageForPtt.getLocalFilePath(((RecordParams.RecorderParam)localObject1).c, (String)localObject2);
    String str = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(".")).concat(".pcm");
    if (!FileUtils.copyFile(this.b, str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "copy failed, return");
      }
      return;
    }
    ((AudioPanelAioHelper)IMECommandListener.a(this.this$0).a(128)).i();
    long l = 0L;
    Object localObject3 = new File(str);
    if (((File)localObject3).exists()) {
      l = ((File)localObject3).length();
    }
    double d1 = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getMillisecond(this.c, 2, 2, l);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("file size = ");
      ((StringBuilder)localObject3).append(l);
      ((StringBuilder)localObject3).append(" timelength = ");
      ((StringBuilder)localObject3).append(d1);
      QLog.d("sougouptt", 2, ((StringBuilder)localObject3).toString());
    }
    localObject3 = new VoiceChangeBasicParams((String)localObject2, this.c, ((RecordParams.RecorderParam)localObject1).b, ((RecordParams.RecorderParam)localObject1).c, 0);
    ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToStart(this.a.getApp(), (VoiceChangeBasicParams)localObject3, null, null, VoiceChangeModeParams.a(str));
    ((AudioPanelAioHelper)IMECommandListener.a(this.this$0).a(128)).a((String)localObject2, (int)d1, (RecordParams.RecorderParam)localObject1, this.d);
    localObject1 = (InputMethodManager)this.e.getSystemService("input_method");
    if (localObject1 != null)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("PCMFilePath", this.b);
      ((InputMethodManager)localObject1).sendAppPrivateCommand(this.f, "com.tencent.mobileqq_handleCompleted", (Bundle)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.IMECommandListener.1
 * JD-Core Version:    0.7.0.1
 */