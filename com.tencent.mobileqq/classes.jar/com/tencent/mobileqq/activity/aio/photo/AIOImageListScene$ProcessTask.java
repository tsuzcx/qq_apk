package com.tencent.mobileqq.activity.aio.photo;

import android.os.AsyncTask;
import android.os.Environment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class AIOImageListScene$ProcessTask
  extends AsyncTask<Integer, Integer, Integer>
{
  AIORichMediaInfo[] a;
  boolean b = true;
  AIORichMediaInfo c;
  int d;
  
  public AIOImageListScene$ProcessTask(ArrayList<AIORichMediaInfo> paramArrayList)
  {
    Object localObject;
    this.a = ((AIORichMediaInfo[])localObject.toArray(new AIORichMediaInfo[0]));
  }
  
  private int a(AIORichMediaInfo[] paramArrayOfAIORichMediaInfo, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, Integer... paramVarArgs)
  {
    if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_UNMOUNT");
      }
      return 23;
    }
    File localFile = new File(AppConstants.SDCARD_IMG_SAVE);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfAIORichMediaInfo.length)
    {
      Object localObject = paramArrayOfAIORichMediaInfo[paramInt1];
      if (!paramBoolean) {
        return 1;
      }
      int i;
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        localObject = (AIOImageData)((AIORichMediaInfo)localObject).a;
        publishProgress(new Integer[] { Integer.valueOf(paramInt2 * 100 / paramVarArgs.length + paramInt1 * 100 / paramVarArgs.length / paramArrayOfAIORichMediaInfo.length & 0xFFFF | paramInt3 << 16) });
        i = AIOImageListScene.a(this.e, null, (AIOImageData)localObject, localFile);
        if (i != 20) {
          return i;
        }
      }
      else if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        localObject = (AIOFilePicData)((AIORichMediaInfo)localObject).a;
        publishProgress(new Integer[] { Integer.valueOf(paramInt2 * 100 / paramVarArgs.length + paramInt1 * 100 / paramVarArgs.length / paramArrayOfAIORichMediaInfo.length & 0xFFFF | paramInt3 << 16) });
        i = AIOImageListScene.a(this.e, null, (AIOFilePicData)localObject, localFile);
        if (i != 20) {
          return i;
        }
      }
      paramInt1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_COMPLETE");
    }
    return 20;
  }
  
  protected Integer a(Integer... paramVarArgs)
  {
    try
    {
      if (!QLog.isColorLevel()) {
        break label560;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ProcessTask start:");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject).toString());
    }
    catch (Throwable paramVarArgs)
    {
      for (;;)
      {
        Object localObject;
        int k;
        int m;
        int i1;
        int n;
        String str;
        label362:
        continue;
        label560:
        int i = 0;
        int j = 0;
        continue;
        label567:
        i = 0;
        continue;
        label572:
        i += 1;
        continue;
        label579:
        if (k == 2) {
          i = 30;
        } else {
          i = 10;
        }
        label594:
        j += 1;
      }
    }
    if (j < paramVarArgs.length)
    {
      k = paramVarArgs[j].intValue();
      if (!this.b) {
        return Integer.valueOf(1);
      }
      m = j * 100;
      i1 = m / paramVarArgs.length;
      n = k << 16;
      publishProgress(new Integer[] { Integer.valueOf(i1 & 0xFFFF | n) });
      if (k == 0) {
        break label567;
      }
      if (k != 1)
      {
        if (k == 2) {
          break label567;
        }
        break label594;
      }
      return Integer.valueOf(a(this.a, this.b, i1, j, k, paramVarArgs));
      if (i >= this.a.length) {
        break label579;
      }
      if (!this.b) {
        return Integer.valueOf(1);
      }
      publishProgress(new Integer[] { Integer.valueOf(m / paramVarArgs.length + i * 100 / paramVarArgs.length / this.a.length & 0xFFFF | n) });
      ??? = this.a[i];
      if (!AIOImageData.class.isInstance(???.a)) {
        break label572;
      }
      localObject = (AIOImageData)???.a;
      str = ((AIOImageData)localObject).b;
      if ("I:N".equals(str)) {
        break label572;
      }
      this.c = ???;
      if ((this.b) && ((str == null) || (!new File(str).exists())))
      {
        this.c.e = true;
        this.e.w.a(((AIOImageData)localObject).L, ((AIOImageData)localObject).M, 2);
      }
    }
    try
    {
      synchronized (this.c)
      {
        if (this.c.e) {
          this.c.wait();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label362;
    }
    if (((AIOImageData)localObject).f)
    {
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("Download Failed @@, index: ");
        paramVarArgs.append(i);
        paramVarArgs.append(", downloadPath:");
        paramVarArgs.append(((AIOImageData)localObject).b);
        QLog.d("AIOImageListScene", 2, paramVarArgs.toString());
      }
      this.d = (this.a.length - i);
      return Integer.valueOf(11);
      throw paramVarArgs;
    }
    if (!this.b) {
      return Integer.valueOf(1);
    }
    if (((AIOImageData)localObject).c(2) == null)
    {
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("Download Failed, index: ");
        paramVarArgs.append(i);
        paramVarArgs.append(", downloadPath:");
        paramVarArgs.append(((AIOImageData)localObject).b);
        QLog.d("AIOImageListScene", 2, paramVarArgs.toString());
      }
      this.d = (this.a.length - i);
      return Integer.valueOf(11);
      return Integer.valueOf(i);
      return Integer.valueOf(2);
    }
  }
  
  protected void a(Integer paramInteger)
  {
    this.e.b(paramInteger.intValue(), this.d);
    this.e.x = null;
  }
  
  protected void b(Integer... paramVarArgs)
  {
    int i = paramVarArgs[(paramVarArgs.length - 1)].intValue();
    this.e.c(i >> 16, 0xFFFF & i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.ProcessTask
 * JD-Core Version:    0.7.0.1
 */