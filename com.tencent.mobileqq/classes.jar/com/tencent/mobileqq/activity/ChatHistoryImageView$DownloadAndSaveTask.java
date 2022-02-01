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
  ArrayList<AIORichMediaInfo> a;
  AIORichMediaInfo b;
  boolean c;
  boolean d;
  volatile boolean e = true;
  volatile boolean f = false;
  volatile boolean g = false;
  volatile int h = 0;
  final Object i = new Object();
  
  public ChatHistoryImageView$DownloadAndSaveTask(ArrayList<AIORichMediaInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = new ArrayList(paramBoolean1);
    this.c = paramBoolean2;
    boolean bool;
    this.d = bool;
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
    synchronized (this.i)
    {
      this.g = paramBoolean;
      if (!this.g)
      {
        this.i.notifyAll();
        this.this$0.y.sendEmptyMessageDelayed(102, (this.a.size() - this.h) * 60000L);
      }
      else
      {
        this.this$0.y.removeMessages(102);
      }
      return;
    }
  }
  
  public void run()
  {
    int j;
    Object localObject5;
    boolean bool;
    if (this.c)
    {
      this.f = true;
      this.this$0.y.sendEmptyMessageDelayed(102, this.a.size() * 60000L);
      j = 0;
      if (j < this.a.size())
      {
        if (!this.e)
        {
          this.this$0.y.sendEmptyMessage(101);
          return;
        }
        ??? = (AIORichMediaInfo)this.a.get(j);
        if (AIOImageData.class.isInstance(((AIORichMediaInfo)???).a))
        {
          AIOImageData localAIOImageData = (AIOImageData)((AIORichMediaInfo)???).a;
          localObject5 = localAIOImageData.b;
          if ((!"I:N".equals(localObject5)) && (!new File((String)localObject5).exists()))
          {
            this.b = ((AIORichMediaInfo)???);
            ((AIORichMediaInfo)???).e = true;
            this.this$0.c.a(localAIOImageData.L, localAIOImageData.M, 2);
            synchronized (this.b)
            {
              bool = this.b.e;
              if (bool) {
                try
                {
                  this.b.wait();
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
      synchronized (this.i)
      {
        bool = this.g;
        if (bool) {}
        File localFile;
        int m;
        int n;
        int i1;
        try
        {
          this.i.wait();
        }
        catch (InterruptedException localInterruptedException2) {}
      }
      this.h += 1;
      ??? = this.this$0.y.obtainMessage(100);
      ((Message)???).arg1 = 1;
      j += 1;
      ((Message)???).arg2 = (j * 100 / this.a.size() / 2);
      this.this$0.y.sendMessage((Message)???);
      break;
      this.this$0.y.removeMessages(102);
      this.f = false;
      if (!this.e)
      {
        this.this$0.y.sendEmptyMessage(101);
        return;
      }
      localFile = new File(AppConstants.SDCARD_IMG_SAVE);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      m = 0;
      n = 0;
      for (j = 0; m < this.a.size(); j = i1)
      {
        ??? = this.this$0.y.obtainMessage(100);
        ((Message)???).arg1 = 2;
        if (this.c) {
          ((Message)???).arg2 = ((this.a.size() + m) * 100 / this.a.size() / 2);
        } else {
          ((Message)???).arg2 = (m * 100 / this.a.size());
        }
        this.this$0.y.sendMessage((Message)???);
        if (!this.e)
        {
          this.this$0.y.sendEmptyMessage(101);
          return;
        }
        Object localObject4 = (AIORichMediaInfo)this.a.get(m);
        ??? = null;
        int k;
        if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject4).a))
        {
          localObject4 = ((AIOImageData)((AIORichMediaInfo)localObject4).a).c(2);
          ??? = localObject4;
          if (localObject4 == null)
          {
            k = n;
            i1 = j;
            if (!QLog.isColorLevel()) {
              break label1096;
            }
            QLog.e("ChatHistoryImageView", 2, "[DownloadAndSaveTask.run] image not exist, skip save.");
            k = n;
            i1 = j;
            break label1096;
          }
        }
        else if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject4).a))
        {
          localObject5 = (AIOFilePicData)((AIORichMediaInfo)localObject4).a;
          localObject4 = ((AIOFilePicData)localObject5).c(20);
          ??? = localObject4;
          if (localObject4 == null)
          {
            localObject4 = ((AIOFilePicData)localObject5).c(18);
            ??? = localObject4;
            if (localObject4 == null)
            {
              localObject4 = ((AIOFilePicData)localObject5).c(16);
              ??? = localObject4;
              if (localObject4 == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("ChatHistoryImageView", 2, "[DownloadAndSaveTask.run] file pic not exist, skip save.");
                }
                i1 = j + 1;
                k = n;
                break label1096;
              }
            }
          }
        }
        if (??? == null)
        {
          k = n;
          i1 = j;
        }
        else
        {
          long l = Utils.getUsableSpace(Environment.getExternalStorageDirectory());
          if (((File)???).length() > l)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatHistoryImageView", 2, "SaveAllImage SAVE_FAILED_SDCARD_FULL");
            }
            FMToastUtil.a(HardCodeUtil.a(2131899844));
            this.e = false;
            this.this$0.y.sendEmptyMessage(101);
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
              FMToastUtil.a(HardCodeUtil.a(2131899876));
              this.e = false;
              this.this$0.y.sendEmptyMessage(101);
              return;
            }
            k = n;
            i1 = j;
            if (QLog.isColorLevel())
            {
              QLog.d("ChatHistoryImageView", 2, "SaveAllImage SAVE_FAILED_UNKNOWN");
              k = n;
              i1 = j;
            }
          }
          else
          {
            n += 1;
            ImageUtil.b(this.this$0.b, ((File)localObject4).getAbsolutePath());
            k = n;
            i1 = j;
            if (QLog.isColorLevel())
            {
              QLog.d("ChatHistoryImageView", 2, new Object[] { "target file copy filed, save to sys album, target exist:", Boolean.valueOf(bool) });
              i1 = j;
              k = n;
            }
          }
        }
        label1096:
        m += 1;
        n = k;
      }
      if (n == this.a.size() - j)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(this.this$0.b.getResources().getString(2131886523));
        ((StringBuilder)???).append(AppConstants.SDCARD_IMG_SAVE);
        FMToastUtil.b(((StringBuilder)???).toString());
      }
      else if (n > 0)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(String.format(Locale.CHINA, this.this$0.b.getResources().getString(2131886522), new Object[] { Integer.valueOf(n), Integer.valueOf(this.a.size() - j - n) }));
        ((StringBuilder)???).append(AppConstants.SDCARD_IMG_SAVE);
        FMToastUtil.b(((StringBuilder)???).toString());
      }
      else
      {
        FMToastUtil.a(HardCodeUtil.a(2131899875));
      }
      this.e = false;
      this.this$0.y.sendEmptyMessage(101);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.DownloadAndSaveTask
 * JD-Core Version:    0.7.0.1
 */