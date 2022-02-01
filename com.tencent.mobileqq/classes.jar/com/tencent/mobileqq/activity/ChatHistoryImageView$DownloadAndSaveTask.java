package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Message;
import com.dataline.util.file.FileUtil;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

class ChatHistoryImageView$DownloadAndSaveTask
  implements Runnable
{
  volatile int jdField_a_of_type_Int = 0;
  AIORichMediaInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<AIORichMediaInfo> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  volatile boolean c = true;
  volatile boolean d = false;
  volatile boolean e = false;
  
  public ChatHistoryImageView$DownloadAndSaveTask(ArrayList<AIORichMediaInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramBoolean1);
    this.jdField_a_of_type_Boolean = paramBoolean2;
    boolean bool;
    this.b = bool;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[setDownloadState] ");
      ((StringBuilder)???).append(paramBoolean);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.e = paramBoolean;
      if (!this.e)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(102, (this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_Int) * 60000L);
      }
      else
      {
        this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(102);
      }
      return;
    }
  }
  
  public void run()
  {
    int i;
    Object localObject5;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      this.d = true;
      this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(102, this.jdField_a_of_type_JavaUtilArrayList.size() * 60000L);
      i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (!this.c)
        {
          this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(101);
          return;
        }
        ??? = (AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (AIOImageData.class.isInstance(((AIORichMediaInfo)???).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          AIOImageData localAIOImageData = (AIOImageData)((AIORichMediaInfo)???).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          localObject5 = localAIOImageData.b;
          if ((!"I:N".equals(localObject5)) && (!new File((String)localObject5).exists()))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo)???);
            ((AIORichMediaInfo)???).jdField_a_of_type_Boolean = true;
            this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localAIOImageData.jdField_f_of_type_Long, localAIOImageData.jdField_f_of_type_Int, 2);
            synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo)
            {
              bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_a_of_type_Boolean;
              if (bool) {
                try
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.wait();
                }
                catch (InterruptedException localInterruptedException1)
                {
                  localInterruptedException1.printStackTrace();
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        bool = this.e;
        if (bool) {}
        File localFile;
        int k;
        int m;
        int n;
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait();
        }
        catch (InterruptedException localInterruptedException2) {}
      }
      this.jdField_a_of_type_Int += 1;
      ??? = this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(100);
      ((Message)???).arg1 = 1;
      i += 1;
      ((Message)???).arg2 = (i * 100 / this.jdField_a_of_type_JavaUtilArrayList.size() / 2);
      this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)???);
      break;
      this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(102);
      this.d = false;
      if (!this.c)
      {
        this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(101);
        return;
      }
      localFile = new File(AppConstants.SDCARD_IMG_SAVE);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      k = 0;
      m = 0;
      for (i = 0; k < this.jdField_a_of_type_JavaUtilArrayList.size(); i = n)
      {
        ??? = this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(100);
        ((Message)???).arg1 = 2;
        if (this.jdField_a_of_type_Boolean) {
          ((Message)???).arg2 = ((this.jdField_a_of_type_JavaUtilArrayList.size() + k) * 100 / this.jdField_a_of_type_JavaUtilArrayList.size() / 2);
        } else {
          ((Message)???).arg2 = (k * 100 / this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)???);
        if (!this.c)
        {
          this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(101);
          return;
        }
        Object localObject4 = (AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        ??? = null;
        int j;
        if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject4).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject4 = ((AIOImageData)((AIORichMediaInfo)localObject4).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(2);
          ??? = localObject4;
          if (localObject4 == null)
          {
            j = m;
            n = i;
            if (!QLog.isColorLevel()) {
              break label1095;
            }
            QLog.e("ChatHistoryImageView", 2, "[DownloadAndSaveTask.run] image not exist, skip save.");
            j = m;
            n = i;
            break label1095;
          }
        }
        else if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject4).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject5 = (AIOFilePicData)((AIORichMediaInfo)localObject4).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          localObject4 = ((AIOFilePicData)localObject5).a(20);
          ??? = localObject4;
          if (localObject4 == null)
          {
            localObject4 = ((AIOFilePicData)localObject5).a(18);
            ??? = localObject4;
            if (localObject4 == null)
            {
              localObject4 = ((AIOFilePicData)localObject5).a(16);
              ??? = localObject4;
              if (localObject4 == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("ChatHistoryImageView", 2, "[DownloadAndSaveTask.run] file pic not exist, skip save.");
                }
                n = i + 1;
                j = m;
                break label1095;
              }
            }
          }
        }
        if (??? == null)
        {
          j = m;
          n = i;
        }
        else
        {
          long l = Utils.getUsableSpace(Environment.getExternalStorageDirectory());
          if (((File)???).length() > l)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatHistoryImageView", 2, "SaveAllImage SAVE_FAILED_SDCARD_FULL");
            }
            FMToastUtil.a(HardCodeUtil.a(2131701826));
            this.c = false;
            this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(101);
            return;
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(((File)???).getName());
          ((StringBuilder)localObject4).append(".jpg");
          localObject5 = new File(localFile, ((StringBuilder)localObject4).toString());
          localObject4 = localObject5;
          if (((File)localObject5).exists())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(((File)???).getName());
            ((StringBuilder)localObject4).append("_");
            ((StringBuilder)localObject4).append(NetConnInfoCenter.getServerTimeMillis());
            ((StringBuilder)localObject4).append(".jpg");
            localObject5 = new File(localFile, ((StringBuilder)localObject4).toString());
            localObject4 = localObject5;
            if (QLog.isColorLevel())
            {
              QLog.d("ChatHistoryImageView", 2, "target file exist, add fileName suffix");
              localObject4 = localObject5;
            }
          }
          bool = ((File)localObject4).exists();
          if ((!bool) && (!FileUtil.a((File)???, (File)localObject4)))
          {
            if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryImageView", 2, "SaveAllImage SAVE_FAILED_SD_UNABLE");
              }
              FMToastUtil.a(HardCodeUtil.a(2131701859));
              this.c = false;
              this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(101);
              return;
            }
            j = m;
            n = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ChatHistoryImageView", 2, "SaveAllImage SAVE_FAILED_UNKNOWN");
              j = m;
              n = i;
            }
          }
          else
          {
            m += 1;
            ImageUtil.a(this.this$0.jdField_a_of_type_AndroidAppActivity, ((File)localObject4).getAbsolutePath());
            j = m;
            n = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ChatHistoryImageView", 2, new Object[] { "target file copy filed, save to sys album, target exist:", Boolean.valueOf(bool) });
              n = i;
              j = m;
            }
          }
        }
        label1095:
        k += 1;
        m = j;
      }
      if (m == this.jdField_a_of_type_JavaUtilArrayList.size() - i)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(this.this$0.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689882));
        ((StringBuilder)???).append(AppConstants.SDCARD_IMG_SAVE);
        FMToastUtil.b(((StringBuilder)???).toString());
      }
      else if (m > 0)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(String.format(Locale.CHINA, this.this$0.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689881), new Object[] { Integer.valueOf(m), Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - i - m) }));
        ((StringBuilder)???).append(AppConstants.SDCARD_IMG_SAVE);
        FMToastUtil.b(((StringBuilder)???).toString());
      }
      else
      {
        FMToastUtil.a(HardCodeUtil.a(2131701858));
      }
      this.c = false;
      this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(101);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.DownloadAndSaveTask
 * JD-Core Version:    0.7.0.1
 */