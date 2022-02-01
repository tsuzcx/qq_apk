package com.tencent.av.business.manager;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.ItemBase;
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
  private final ConcurrentHashMap<String, Checker.ItemRecord> a = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> b = new ConcurrentLinkedQueue();
  private WeakReferenceHandler c = new WeakReferenceHandler(Looper.getMainLooper(), this);
  
  private void a()
  {
    if ((this.b.size() > 0) && (!this.c.hasMessages(1))) {
      this.c.sendEmptyMessage(1);
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
    if (paramItemRecord.a == null)
    {
      paramItemRecord.e += 1;
      a();
      return;
    }
    paramItemRecord.e += 1;
    ThreadManager.excute(new Checker.1(this, paramItemRecord, paramString), 16, null, false);
  }
  
  public void a(ItemBase paramItemBase, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    String str;
    if (paramItemBase == null) {
      str = null;
    } else {
      str = paramItemBase.getId();
    }
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (this.b.contains(str)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addToCheck, item[");
        ((StringBuilder)localObject).append(paramItemBase);
        ((StringBuilder)localObject).append("]");
        QLog.i("Checker", 2, ((StringBuilder)localObject).toString());
      }
      Checker.ItemRecord localItemRecord = (Checker.ItemRecord)this.a.get(str);
      Object localObject = localItemRecord;
      if (localItemRecord == null)
      {
        localObject = new Checker.ItemRecord(paramItemBase, paramArrayList, paramBoolean);
        ((Checker.ItemRecord)localObject).c = paramString1;
        ((Checker.ItemRecord)localObject).d = paramString2;
        this.a.put(str, localObject);
      }
      if (((Checker.ItemRecord)localObject).a()) {
        return;
      }
      this.b.offer(str);
      a();
    }
  }
  
  void a(String paramString, Checker.ItemRecord paramItemRecord)
  {
    boolean bool = paramItemRecord.a.isUsable();
    int j;
    StringBuilder localStringBuilder2;
    if ((bool) && (!FileUtils.fileExists(paramItemRecord.d)))
    {
      j = 1;
    }
    else if ((bool) && (paramItemRecord.b.size() > 0))
    {
      int i = 0;
      while (i < paramItemRecord.b.size())
      {
        String str = (String)paramItemRecord.b.get(i);
        if (!TextUtils.isEmpty(str))
        {
          if (paramItemRecord.d.endsWith(File.separator))
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(paramItemRecord.d);
            localStringBuilder2.append(str);
            str = localStringBuilder2.toString();
          }
          else
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(paramItemRecord.d);
            localStringBuilder2.append(File.separator);
            localStringBuilder2.append(str);
            str = localStringBuilder2.toString();
          }
          if (!FileUtils.fileExists(str))
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("realCheck, id[");
              localStringBuilder2.append(paramString);
              localStringBuilder2.append("], unExistFile[");
              localStringBuilder2.append(str);
              localStringBuilder2.append("]");
              QLog.i("Checker", 2, localStringBuilder2.toString());
            }
            i = 1;
            break label262;
          }
        }
        i += 1;
      }
      i = 0;
      label262:
      j = i;
      if (i != 0)
      {
        FileUtils.deleteDirectory(paramItemRecord.d);
        j = i;
      }
    }
    else
    {
      j = 0;
    }
    if (j != 0)
    {
      try
      {
        FileUtils.uncompressZip(paramItemRecord.c, paramItemRecord.d, false);
        paramItemRecord.g = true;
      }
      catch (IOException localIOException)
      {
        paramItemRecord.g = false;
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("realCheck, uncompressZip fail, record[");
        localStringBuilder2.append(paramItemRecord);
        localStringBuilder2.append("]");
        QLog.i("Checker", 2, localStringBuilder2.toString(), localIOException);
      }
      if ((!paramItemRecord.g) && (paramItemRecord.a()) && (paramItemRecord.f))
      {
        FileUtils.deleteFile(paramItemRecord.c);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("realCheck, del zip id[");
          localStringBuilder1.append(paramString);
          localStringBuilder1.append("], path[");
          localStringBuilder1.append(paramItemRecord.c);
          localStringBuilder1.append("]");
          QLog.i("Checker", 2, localStringBuilder1.toString());
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      String str = (String)this.b.poll();
      paramMessage = null;
      if (!TextUtils.isEmpty(str)) {
        paramMessage = (Checker.ItemRecord)this.a.get(str);
      }
      b(str, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.Checker
 * JD-Core Version:    0.7.0.1
 */