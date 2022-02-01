package com.tencent.mobileqq.activity.contacts.mayknow;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReportExposeConfigProcessor
  extends IQConfigProcessor<ContactReportUtils.ReportExposeIntervalConfig>
{
  @NonNull
  public ContactReportUtils.ReportExposeIntervalConfig a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new ContactReportUtils.ReportExposeIntervalConfig();
  }
  
  @Nullable
  public ContactReportUtils.ReportExposeIntervalConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    int j;
    int i;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("ReportExposeConfigProcessor", 2, "onParsed :" + paramArrayOfQConfItem);
      if (paramArrayOfQConfItem != null)
      {
        j = paramArrayOfQConfItem.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfQConfItem[i];
          if (localObject1 != null) {
            QLog.d("ReportExposeConfigProcessor", 2, "onParsed item: " + ((QConfItem)localObject1).a);
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      j = paramArrayOfQConfItem.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfQConfItem[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((QConfItem)localObject2).a))) {
          try
          {
            localObject1 = new ContactReportUtils.ReportExposeIntervalConfig();
            localObject2 = new JSONObject(((QConfItem)localObject2).a);
            if (((JSONObject)localObject2).has("enable")) {
              ((ContactReportUtils.ReportExposeIntervalConfig)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).getBoolean("enable");
            }
            if (((JSONObject)localObject2).has("interval")) {
              ((ContactReportUtils.ReportExposeIntervalConfig)localObject1).jdField_a_of_type_Long = ((JSONObject)localObject2).getLong("interval");
            }
            return localObject1;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("ReportExposeConfigProcessor", 1, localThrowable, new Object[0]);
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void a(ContactReportUtils.ReportExposeIntervalConfig paramReportExposeIntervalConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onUpdate");
    }
    if (paramReportExposeIntervalConfig != null) {
      ContactReportUtils.a(paramReportExposeIntervalConfig);
    }
  }
  
  public Class<ContactReportUtils.ReportExposeIntervalConfig> clazz()
  {
    return ContactReportUtils.ReportExposeIntervalConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportExposeConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 438;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.ReportExposeConfigProcessor
 * JD-Core Version:    0.7.0.1
 */