package com.tencent.mobileqq.app.message.messageclean;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class FileCleanManager
{
  private int jdField_a_of_type_Int;
  private IFileScanListener jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIFileScanListener;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, FileInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  
  public FileCleanManager(IFileScanListener paramIFileScanListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIFileScanListener = paramIFileScanListener;
  }
  
  private int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return 0;
        }
        return this.jdField_c_of_type_Int;
      }
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_a_of_type_Int;
  }
  
  private String a()
  {
    return RmVFSUtils.getVFSPath(AbsDownloader.CHAT_IMAGE_ROOT);
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "";
        }
        return this.jdField_c_of_type_JavaLangString;
      }
      return this.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  private void a(String paramString, int paramInt)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      File[] arrayOfFile = paramString.listFiles();
      if (arrayOfFile != null)
      {
        if (arrayOfFile.length == 0) {
          return;
        }
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          if (localFile.isDirectory())
          {
            a(localFile.getAbsolutePath(), paramInt);
          }
          else
          {
            int k = a(paramInt);
            paramString = localFile.getAbsolutePath();
            int m = paramString.length();
            FileInfo localFileInfo = new FileInfo();
            if (m > k) {
              paramString = paramString.substring(k, m);
            } else {
              paramString = "";
            }
            localFileInfo.jdField_a_of_type_JavaLangString = paramString;
            localFileInfo.jdField_a_of_type_Long = localFile.length();
            localFileInfo.jdField_a_of_type_Int = paramInt;
            localFileInfo.jdField_b_of_type_Int = 0;
            paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
            if (paramString == null) {
              break;
            }
            paramString.put(localFile.getName(), localFileInfo);
          }
          i += 1;
        }
      }
    }
  }
  
  private String b()
  {
    return SVUtils.c();
  }
  
  private String c()
  {
    return AppConstants.SDCARD_FILE_SAVE_PATH;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIFileScanListener != null) && (a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIFileScanListener.a();
      if (QLog.isColorLevel()) {
        QLog.e("FileCleanManager", 2, "fileScanNotify onScanFinish");
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_b_of_type_JavaLangString = b();
    this.jdField_c_of_type_JavaLangString = c();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaLangString.length();
    this.jdField_b_of_type_Int = this.jdField_b_of_type_JavaLangString.length();
    this.jdField_c_of_type_Int = this.jdField_c_of_type_JavaLangString.length();
  }
  
  private void e()
  {
    a(this.jdField_a_of_type_JavaLangString, 1);
  }
  
  private void f()
  {
    a(this.jdField_b_of_type_JavaLangString, 2);
  }
  
  private void g()
  {
    a(this.jdField_c_of_type_JavaLangString, 3);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null)
    {
      localConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
  }
  
  public String a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(paramFileInfo.jdField_a_of_type_Int));
    localStringBuffer.append(paramFileInfo.jdField_a_of_type_JavaLangString);
    return localStringBuffer.toString();
  }
  
  public ConcurrentHashMap<String, FileInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    h();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    d();
    ThreadManager.getFileThreadHandler().post(new FileCleanManager.1(this));
    ThreadManager.getFileThreadHandler().post(new FileCleanManager.2(this));
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.remove(paramString);
      }
    }
  }
  
  public void a(String paramString, FileInfo paramFileInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramFileInfo != null))
    {
      ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(paramString, paramFileInfo);
      }
    }
  }
  
  public void a(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        FileUtils.deleteFile((String)paramList.next());
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
  
  public void b()
  {
    h();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanIFileScanListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager
 * JD-Core Version:    0.7.0.1
 */