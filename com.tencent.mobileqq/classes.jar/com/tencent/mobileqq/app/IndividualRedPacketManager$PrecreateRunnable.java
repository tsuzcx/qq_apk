package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.Char300Info;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class IndividualRedPacketManager$PrecreateRunnable
  implements Handler.Callback
{
  int jdField_a_of_type_Int = 0;
  IndividualRedPacketResDownloader.Char300Info jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<IndividualRedPacketManager> b;
  
  public IndividualRedPacketManager$PrecreateRunnable(IndividualRedPacketManager paramIndividualRedPacketManager, QQAppInterface paramQQAppInterface, IndividualRedPacketResDownloader.Char300Info paramChar300Info)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramIndividualRedPacketManager);
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info = paramChar300Info;
  }
  
  public void a()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    IndividualRedPacketManager localIndividualRedPacketManager = (IndividualRedPacketManager)this.b.get();
    if ((localObject != null) && (localIndividualRedPacketManager != null) && (!localIndividualRedPacketManager.c.get()))
    {
      if (localIndividualRedPacketManager.b().getBoolean("font_precreate_finish", false)) {
        return;
      }
      QLog.d(IndividualRedPacketManager.b(), 1, "preCreatePersonalFontImg start!");
      int i = localIndividualRedPacketManager.b().getInt("font_precreate_index", 0);
      localObject = localIndividualRedPacketManager.a.obtainMessage();
      ((Message)localObject).what = i;
      localIndividualRedPacketManager.a.sendMessage((Message)localObject);
      return;
    }
    QLog.d(IndividualRedPacketManager.b(), 1, "preCreatePersonalFontImg return!");
  }
  
  void a(int paramInt)
  {
    Object localObject3 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject2 = (IndividualRedPacketManager)this.b.get();
    if (localObject3 != null)
    {
      if (localObject2 == null) {
        return;
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a();
      Object localObject1;
      if (paramInt >= str.length())
      {
        localObject1 = new File(IndividualRedPacketManager.a(4)).listFiles();
        localObject3 = ((IndividualRedPacketManager)localObject2).b().edit();
        if ((localObject1 != null) && (localObject1.length >= str.length())) {
          ((SharedPreferences.Editor)localObject3).putBoolean("font_precreate_finish", true);
        } else {
          ((SharedPreferences.Editor)localObject3).putInt("font_precreate_index", 0);
        }
        paramInt = ((IndividualRedPacketManager)localObject2).b().getInt("font_precreate_count", 0);
        ((SharedPreferences.Editor)localObject3).putInt("font_precreate_count", paramInt + 1);
        ((SharedPreferences.Editor)localObject3).commit();
        localObject1 = IndividualRedPacketManager.b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("preCreatePersonalFontImg create count = ");
        ((StringBuilder)localObject2).append(paramInt);
        QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return;
      }
      if (((IndividualRedPacketManager)localObject2).a()) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      if (!((IndividualRedPacketManager)localObject2).e.get())
      {
        if (Thread.currentThread().isInterrupted()) {
          return;
        }
        int i = paramInt + 1;
        str = str.substring(paramInt, i);
        if (new File(IndividualRedPacketManager.a("", str, 4, 0, 0)).exists())
        {
          if (QLog.isColorLevel())
          {
            localObject1 = IndividualRedPacketManager.b();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("preCreatePersonalFontImg exists : ");
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append(" address = ");
            ((StringBuilder)localObject3).append(IndividualRedPacketManager.a("", str, 4, 0, 0));
            QLog.e((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          }
          ((IndividualRedPacketManager)localObject2).b().edit().putInt("font_precreate_index", i).commit();
          localObject1 = ((IndividualRedPacketManager)localObject2).a.obtainMessage();
          ((Message)localObject1).what = i;
          ((IndividualRedPacketManager)localObject2).a.sendMessageDelayed((Message)localObject1, 500L);
          return;
        }
        long l1 = System.currentTimeMillis();
        Object localObject4 = ((IndividualRedPacketManager)localObject2).a(str, true);
        long l2;
        if (localObject4 != null)
        {
          this.jdField_a_of_type_Int = 0;
          l2 = System.currentTimeMillis();
          ((IndividualRedPacketManager)localObject2).b().edit().putInt("font_precreate_index", i).commit();
          if (paramInt % 100 == 0) {
            ReportController.b((AppRuntime)localObject3, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject1, "1", String.valueOf(l2 - l1), str);
          }
          if (!((Bitmap)localObject4).isRecycled()) {
            ((Bitmap)localObject4).recycle();
          }
        }
        else
        {
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel())
          {
            localObject4 = IndividualRedPacketManager.b();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("preCreatePersonalFontImg ");
            localStringBuilder.append(str);
            localStringBuilder.append("fail");
            QLog.d((String)localObject4, 2, localStringBuilder.toString());
          }
          if (paramInt % 100 == 0) {
            ReportController.b((AppRuntime)localObject3, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject1, "0", String.valueOf(l2 - l1), str);
          }
          this.jdField_a_of_type_Int += 1;
          if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.b)
          {
            localObject1 = IndividualRedPacketManager.b();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("preCreatePersonalFontImg fail count = ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
            ((StringBuilder)localObject2).append(" max failcount = ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.b);
            QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            return;
          }
        }
        localObject1 = ((IndividualRedPacketManager)localObject2).a.obtainMessage();
        ((Message)localObject1).what = i;
        ((IndividualRedPacketManager)localObject2).a.sendMessageDelayed((Message)localObject1, 5000L);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    a(paramMessage.what);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.PrecreateRunnable
 * JD-Core Version:    0.7.0.1
 */