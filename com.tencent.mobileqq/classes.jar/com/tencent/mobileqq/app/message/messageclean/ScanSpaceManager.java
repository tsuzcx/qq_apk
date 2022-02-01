package com.tencent.mobileqq.app.message.messageclean;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
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
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  private void c()
  {
    String str1 = FMSettings.a().b();
    String str2 = FMSettings.a().a();
    jdField_a_of_type_JavaUtilArrayList.clear();
    if (!TextUtils.isEmpty(str1))
    {
      jdField_a_of_type_JavaUtilArrayList.add(str1);
      QLog.d("ScanSpaceManager", 2, " need scan file path1 = " + str1);
    }
    if (!TextUtils.isEmpty(str2))
    {
      jdField_a_of_type_JavaUtilArrayList.add(str2);
      QLog.d("ScanSpaceManager", 2, " need scan file path2 = " + str2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScanSpaceManager", 2, " need scan file path1 = " + str1 + " path2 = " + str2);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener.b();
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
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
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
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener.a(paramMessage.arg1);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIScanSpaceListener.a(this.b, this.jdField_a_of_type_Long - this.b - this.c, this.c, this.jdField_a_of_type_Long);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager
 * JD-Core Version:    0.7.0.1
 */