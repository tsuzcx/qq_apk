package com.tencent.av.business.manager;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Checker
  implements Handler.Callback
{
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, Checker.ItemRecord> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) && (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(1))) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
    }
  }
  
  private void b(String paramString, Checker.ItemRecord paramItemRecord)
  {
    if (paramItemRecord == null)
    {
      a();
      return;
    }
    if (paramItemRecord.a())
    {
      a();
      return;
    }
    if (paramItemRecord.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase == null)
    {
      paramItemRecord.jdField_a_of_type_Int += 1;
      a();
      return;
    }
    paramItemRecord.jdField_a_of_type_Int += 1;
    ThreadManager.excute(new Checker.1(this, paramItemRecord, paramString), 16, null, false);
  }
  
  public void a(EffectConfigBase.ItemBase paramItemBase, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramItemBase == null)
    {
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(localObject))) {
        break label51;
      }
    }
    label51:
    Checker.ItemRecord localItemRecord1;
    do
    {
      return;
      localObject = paramItemBase.getId();
      break;
      if (QLog.isColorLevel()) {
        QLog.i("Checker", 2, "addToCheck, item[" + paramItemBase + "]");
      }
      Checker.ItemRecord localItemRecord2 = (Checker.ItemRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      localItemRecord1 = localItemRecord2;
      if (localItemRecord2 == null)
      {
        localItemRecord1 = new Checker.ItemRecord(paramItemBase, paramArrayList, paramBoolean);
        localItemRecord1.jdField_a_of_type_JavaLangString = paramString1;
        localItemRecord1.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localItemRecord1);
      }
    } while (localItemRecord1.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    a();
  }
  
  void a(String paramString, Checker.ItemRecord paramItemRecord)
  {
    boolean bool = paramItemRecord.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase.isUsable();
    int j;
    if ((bool) && (!FileUtils.a(paramItemRecord.jdField_b_of_type_JavaLangString))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      try
      {
        FileUtils.a(paramItemRecord.jdField_a_of_type_JavaLangString, paramItemRecord.jdField_b_of_type_JavaLangString, false);
        paramItemRecord.jdField_b_of_type_Boolean = true;
        if ((!paramItemRecord.jdField_b_of_type_Boolean) && (paramItemRecord.a()) && (paramItemRecord.jdField_a_of_type_Boolean))
        {
          FileUtils.e(paramItemRecord.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("Checker", 2, "realCheck, del zip id[" + paramString + "], path[" + paramItemRecord.jdField_a_of_type_JavaLangString + "]");
          }
        }
        return;
        if ((bool) && (paramItemRecord.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 0;
          label144:
          if (i < paramItemRecord.jdField_a_of_type_JavaUtilArrayList.size())
          {
            String str = (String)paramItemRecord.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (TextUtils.isEmpty(str)) {}
            label327:
            for (;;)
            {
              i += 1;
              break label144;
              if (paramItemRecord.jdField_b_of_type_JavaLangString.endsWith(File.separator)) {}
              for (str = paramItemRecord.jdField_b_of_type_JavaLangString + str;; str = paramItemRecord.jdField_b_of_type_JavaLangString + File.separator + str)
              {
                if (FileUtils.a(str)) {
                  break label327;
                }
                if (!QLog.isColorLevel()) {
                  break label371;
                }
                QLog.i("Checker", 2, "realCheck, id[" + paramString + "], unExistFile[" + str + "]");
                i = 1;
                j = i;
                if (i == 0) {
                  break;
                }
                FileUtils.a(paramItemRecord.jdField_b_of_type_JavaLangString);
                j = i;
                break;
              }
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramItemRecord.jdField_b_of_type_Boolean = false;
          QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + paramItemRecord + "]", localIOException);
          continue;
          label371:
          int i = 1;
          continue;
          i = 0;
        }
        j = 0;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      paramMessage = null;
      if (!TextUtils.isEmpty(str)) {
        paramMessage = (Checker.ItemRecord)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      b(str, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.Checker
 * JD-Core Version:    0.7.0.1
 */