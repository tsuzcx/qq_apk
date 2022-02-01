package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeModeParams;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class BaseChatpieHelper$IMECommandListener$1
  implements Runnable
{
  BaseChatpieHelper$IMECommandListener$1(BaseChatpieHelper.IMECommandListener paramIMECommandListener, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, Context paramContext, View paramView) {}
  
  public void run()
  {
    Object localObject1 = QQRecorder.a();
    Object localObject2 = BuddyTransfileProcessor.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 2, null);
    localObject2 = MessageForPtt.getLocalFilePath(((RecordParams.RecorderParam)localObject1).c, (String)localObject2);
    String str = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(".")).concat(".pcm");
    if (!FileUtils.d(this.jdField_a_of_type_JavaLangString, str)) {
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "copy failed, return");
      }
    }
    do
    {
      return;
      BaseChatpieHelper.IMECommandListener.a(this.this$0).bh();
      long l = 0L;
      Object localObject3 = new File(str);
      if (((File)localObject3).exists()) {
        l = ((File)localObject3).length();
      }
      double d = QQRecorder.a(this.jdField_a_of_type_Int, 2, 2, l);
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "file size = " + l + " timelength = " + d);
      }
      localObject3 = new VoiceChangeBasicParams((String)localObject2, this.jdField_a_of_type_Int, ((RecordParams.RecorderParam)localObject1).b, ((RecordParams.RecorderParam)localObject1).c, 0);
      VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), (VoiceChangeBasicParams)localObject3, null, null, VoiceChangeModeParams.a(str));
      BaseChatpieHelper.IMECommandListener.a(this.this$0).a((String)localObject2, (int)d, (RecordParams.RecorderParam)localObject1, this.b);
      localObject1 = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    } while (localObject1 == null);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("PCMFilePath", this.jdField_a_of_type_JavaLangString);
    ((InputMethodManager)localObject1).sendAppPrivateCommand(this.jdField_a_of_type_AndroidViewView, "com.tencent.mobileqq_handleCompleted", (Bundle)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper.IMECommandListener.1
 * JD-Core Version:    0.7.0.1
 */