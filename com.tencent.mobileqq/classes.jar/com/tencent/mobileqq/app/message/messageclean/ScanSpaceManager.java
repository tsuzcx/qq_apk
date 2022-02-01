package com.tencent.mobileqq.app.message.messageclean;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ScanSpaceManager
  implements Handler.Callback
{
  public static final ArrayList<String> a;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IScanSpaceListener jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener;
  private volatile boolean jdField_a_of_type_Boolean = false;
  public long b = 0L;
  public long c = 0L;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  }
  
  public ScanSpaceManager()
  {
    this.jdField_a_of_type_Long = 0L;
    c();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(1);
      ((Message)localObject).arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
  }
  
  private void c()
  {
    String str1 = FMSettings.a().getDefaultRecvPath();
    String str2 = FMSettings.a().getOtherRecvPath();
    jdField_a_of_type_JavaUtilArrayList.clear();
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(str1))
    {
      jdField_a_of_type_JavaUtilArrayList.add(str1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" need scan file path1 = ");
      localStringBuilder.append(str1);
      QLog.d("ScanSpaceManager", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(str2))
    {
      jdField_a_of_type_JavaUtilArrayList.add(str2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" need scan file path2 = ");
      localStringBuilder.append(str2);
      QLog.d("ScanSpaceManager", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" need scan file path1 = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" path2 = ");
      localStringBuilder.append(str2);
      QLog.d("ScanSpaceManager", 2, localStringBuilder.toString());
    }
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 200L);
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Long - this.b - this.c;
    }
    return 0L;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      IScanSpaceListener localIScanSpaceListener = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener;
      if (localIScanSpaceListener != null)
      {
        localIScanSpaceListener.b();
        this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener.a(0);
      }
      StorageReport.a().post(new ScanSpaceManager.ScanSpaceTask(this));
    }
  }
  
  public void a(IScanSpaceListener paramIScanSpaceListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener = paramIScanSpaceListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.c;
    }
    return 0L;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    StorageReport.a();
    jdField_a_of_type_JavaUtilArrayList.clear();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener = null;
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2)
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener;
        if (paramMessage != null)
        {
          long l1 = this.b;
          long l2 = this.jdField_a_of_type_Long;
          long l3 = this.c;
          paramMessage.a(l1, l2 - l1 - l3, l3, l2);
        }
      }
    }
    else
    {
      IScanSpaceListener localIScanSpaceListener = this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener;
      if (localIScanSpaceListener != null) {
        localIScanSpaceListener.a(paramMessage.arg1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager
 * JD-Core Version:    0.7.0.1
 */