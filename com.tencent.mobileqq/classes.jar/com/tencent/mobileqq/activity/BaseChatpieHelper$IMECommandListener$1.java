package com.tencent.mobileqq.activity;

import adqo;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import bdtd;
import bgmg;
import bhkm;
import bhkp;
import bhkr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class BaseChatpieHelper$IMECommandListener$1
  implements Runnable
{
  public BaseChatpieHelper$IMECommandListener$1(adqo paramadqo, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, Context paramContext, View paramView) {}
  
  public void run()
  {
    long l = 0L;
    Object localObject1 = QQRecorder.a();
    Object localObject2 = bdtd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 2, null);
    localObject2 = MessageForPtt.getLocalFilePath(((QQRecorder.RecorderParam)localObject1).c, (String)localObject2);
    String str = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(".")).concat(".pcm");
    if (!bgmg.d(this.jdField_a_of_type_JavaLangString, str)) {
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "copy failed, return");
      }
    }
    do
    {
      return;
      adqo.a(this.this$0).b = 0L;
      Object localObject3 = new File(str);
      if (((File)localObject3).exists()) {
        l = ((File)localObject3).length();
      }
      double d = QQRecorder.a(this.jdField_a_of_type_Int, 2, 2, l);
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "file size = " + l + " timelength = " + d);
      }
      localObject3 = new bhkm((String)localObject2, this.jdField_a_of_type_Int, ((QQRecorder.RecorderParam)localObject1).b, ((QQRecorder.RecorderParam)localObject1).c, 0);
      bhkp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), (bhkm)localObject3, null, null, bhkr.a(str));
      adqo.a(this.this$0).a((String)localObject2, (int)d, (QQRecorder.RecorderParam)localObject1, this.b);
      localObject1 = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    } while (localObject1 == null);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("PCMFilePath", this.jdField_a_of_type_JavaLangString);
    ((InputMethodManager)localObject1).sendAppPrivateCommand(this.jdField_a_of_type_AndroidViewView, "com.tencent.mobileqq_handleCompleted", (Bundle)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatpieHelper.IMECommandListener.1
 * JD-Core Version:    0.7.0.1
 */