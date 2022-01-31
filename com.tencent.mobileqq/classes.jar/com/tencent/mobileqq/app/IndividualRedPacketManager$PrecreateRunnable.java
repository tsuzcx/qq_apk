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

public class IndividualRedPacketManager$PrecreateRunnable
  implements Handler.Callback
{
  int jdField_a_of_type_Int = 0;
  IndividualRedPacketResDownloader.Char300Info jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference b;
  
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
    if ((localObject == null) || (localIndividualRedPacketManager == null) || (localIndividualRedPacketManager.c.get())) {
      QLog.d(IndividualRedPacketManager.b(), 1, "preCreatePersonalFontImg return!");
    }
    while (localIndividualRedPacketManager.b().getBoolean("font_precreate_finish", false)) {
      return;
    }
    QLog.d(IndividualRedPacketManager.b(), 1, "preCreatePersonalFontImg start!");
    int i = localIndividualRedPacketManager.b().getInt("font_precreate_index", 0);
    localObject = localIndividualRedPacketManager.a.obtainMessage();
    ((Message)localObject).what = i;
    localIndividualRedPacketManager.a.sendMessage((Message)localObject);
  }
  
  void a(int paramInt)
  {
    Object localObject2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    IndividualRedPacketManager localIndividualRedPacketManager = (IndividualRedPacketManager)this.b.get();
    if ((localObject2 == null) || (localIndividualRedPacketManager == null)) {}
    Object localObject1;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a();
      if (paramInt >= str.length())
      {
        localObject1 = new File(IndividualRedPacketManager.a(4)).listFiles();
        localObject2 = localIndividualRedPacketManager.b().edit();
        if ((localObject1 != null) && (localObject1.length >= str.length())) {
          ((SharedPreferences.Editor)localObject2).putBoolean("font_precreate_finish", true);
        }
        for (;;)
        {
          paramInt = localIndividualRedPacketManager.b().getInt("font_precreate_count", 0);
          ((SharedPreferences.Editor)localObject2).putInt("font_precreate_count", paramInt + 1);
          ((SharedPreferences.Editor)localObject2).commit();
          QLog.d(IndividualRedPacketManager.b(), 1, "preCreatePersonalFontImg create count = " + paramInt);
          return;
          ((SharedPreferences.Editor)localObject2).putInt("font_precreate_index", 0);
        }
      }
      localObject1 = "0";
      if (localIndividualRedPacketManager.a()) {
        localObject1 = "1";
      }
    } while ((localIndividualRedPacketManager.e.get()) || (Thread.currentThread().isInterrupted()));
    String str = str.substring(paramInt, paramInt + 1);
    if (new File(IndividualRedPacketManager.a("", str, 4, 0, 0)).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e(IndividualRedPacketManager.b(), 2, "preCreatePersonalFontImg exists : " + str + " address = " + IndividualRedPacketManager.a("", str, 4, 0, 0));
      }
      localIndividualRedPacketManager.b().edit().putInt("font_precreate_index", paramInt + 1).commit();
      localObject1 = localIndividualRedPacketManager.a.obtainMessage();
      ((Message)localObject1).what = (paramInt + 1);
      localIndividualRedPacketManager.a.sendMessageDelayed((Message)localObject1, 500L);
      return;
    }
    long l1 = System.currentTimeMillis();
    Bitmap localBitmap = localIndividualRedPacketManager.a(str, true);
    long l2;
    if (localBitmap != null)
    {
      this.jdField_a_of_type_Int = 0;
      l2 = System.currentTimeMillis();
      localIndividualRedPacketManager.b().edit().putInt("font_precreate_index", paramInt + 1).commit();
      if (paramInt % 100 == 0) {
        ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject1, "1", String.valueOf(l2 - l1), str);
      }
      if (!localBitmap.isRecycled()) {
        localBitmap.recycle();
      }
    }
    do
    {
      localObject1 = localIndividualRedPacketManager.a.obtainMessage();
      ((Message)localObject1).what = (paramInt + 1);
      localIndividualRedPacketManager.a.sendMessageDelayed((Message)localObject1, 5000L);
      return;
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(IndividualRedPacketManager.b(), 2, "preCreatePersonalFontImg " + str + "fail");
      }
      if (paramInt % 100 == 0) {
        ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject1, "0", String.valueOf(l2 - l1), str);
      }
      this.jdField_a_of_type_Int += 1;
    } while (this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.b);
    QLog.e(IndividualRedPacketManager.b(), 1, "preCreatePersonalFontImg fail count = " + this.jdField_a_of_type_Int + " max failcount = " + this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.b);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    a(paramMessage.what);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.PrecreateRunnable
 * JD-Core Version:    0.7.0.1
 */