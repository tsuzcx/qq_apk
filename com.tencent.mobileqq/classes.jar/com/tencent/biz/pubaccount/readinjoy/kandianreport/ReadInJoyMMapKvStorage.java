package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.app.ActivityManager;
import android.os.Environment;
import android.text.TextUtils;
import bkwm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import pay;
import ypi;

public class ReadInJoyMMapKvStorage
{
  public static final String NAME_DEFAULT = "global";
  private static final String TAG = "kandianreport.ReadInJoyMMapKvStorage";
  private static Map<String, ReadInJoyMMapKvStorage> mMapHelperMap = new ConcurrentHashMap();
  private static String mmkvRootPath;
  private Map<String, String> dataMap = new HashMap();
  private int expiredTime;
  private int mMMapCurrentSize;
  private MappedByteBuffer mMMapDataBuffer;
  private int mMMapFileSize;
  private String mMMapFilepath;
  private int mMMapMaxSize = 16777216;
  private RandomAccessFile mMMapMemoryMappedFile;
  private int mMMapMinSize = 4096;
  private String mMMapName = "";
  private int mNumberOfKeysWithDuplicated;
  
  private ReadInJoyMMapKvStorage(String paramString)
  {
    this.mMMapFilepath = (mmkvRootPath + "/" + paramString);
    this.mMMapName = paramString;
    init();
  }
  
  private boolean ensureMemorySize(int paramInt)
  {
    this.mMMapCurrentSize = sizeAfterRemoveDuplicatedKeys();
    return this.mMMapCurrentSize + paramInt <= this.mMMapFileSize;
  }
  
  private boolean expandMMapFile()
  {
    localObject3 = null;
    try
    {
      if (this.mMMapFileSize * 2 <= this.mMMapMaxSize) {
        break label59;
      }
      QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, String.format("memory not enough, mMMapFileSize: %d mMMapMaxSize: %d", new Object[] { Integer.valueOf(this.mMMapFileSize), Integer.valueOf(this.mMMapMaxSize) }));
      bool = false;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          RandomAccessFile localRandomAccessFile;
          localObject3 = this.mMMapMemoryMappedFile;
          MappedByteBuffer localMappedByteBuffer2 = this.mMMapDataBuffer;
          this.mMMapMemoryMappedFile = localRandomAccessFile;
          this.mMMapDataBuffer = localMappedByteBuffer1;
          this.mMMapDataBuffer.position(this.mMMapCurrentSize);
          releaseMMapFile((RandomAccessFile)localObject3);
          releaseMMapMemory(localMappedByteBuffer2);
          bool = true;
        }
        catch (Throwable localThrowable4)
        {
          boolean bool;
          MappedByteBuffer localMappedByteBuffer1;
          localObject3 = localObject2;
          Object localObject2 = localThrowable4;
          continue;
        }
        localThrowable1 = localThrowable1;
        localMappedByteBuffer1 = null;
        QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, localThrowable1.getStackTrace() + "");
        releaseMMapFile((RandomAccessFile)localObject3);
        releaseMMapMemory(localMappedByteBuffer1);
        this.mMMapFileSize /= 2;
        try
        {
          this.mMMapMemoryMappedFile = new RandomAccessFile(this.mMMapFilepath, "rw");
          this.mMMapDataBuffer = this.mMMapMemoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, this.mMMapFileSize);
          this.mMMapDataBuffer.position(this.mMMapCurrentSize);
          bool = false;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, localThrowable2.getStackTrace() + "");
          bool = false;
        }
      }
    }
    finally {}
    return bool;
    label59:
    this.mMMapFileSize *= 2;
    localRandomAccessFile = new RandomAccessFile(this.mMMapFilepath, "rw");
  }
  
  public static ReadInJoyMMapKvStorage getInstance()
  {
    return getInstance("global");
  }
  
  public static ReadInJoyMMapKvStorage getInstance(String paramString)
  {
    if (mMapHelperMap.containsKey(paramString)) {
      return (ReadInJoyMMapKvStorage)mMapHelperMap.get(paramString);
    }
    if (mmkvRootPath == null) {
      resetRootPath();
    }
    try
    {
      if (mMapHelperMap.containsKey(paramString))
      {
        QLog.d("kandianreport.ReadInJoyMMapKvStorage", 2, "contains key: " + paramString);
        paramString = (ReadInJoyMMapKvStorage)mMapHelperMap.get(paramString);
        return paramString;
      }
    }
    finally {}
    QLog.d("kandianreport.ReadInJoyMMapKvStorage", 2, "create key: " + paramString);
    ReadInJoyMMapKvStorage localReadInJoyMMapKvStorage = new ReadInJoyMMapKvStorage(paramString);
    mMapHelperMap.put(paramString, localReadInJoyMMapKvStorage);
    return localReadInJoyMMapKvStorage;
  }
  
  private void init()
  {
    try
    {
      Object localObject = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
      if ((localObject != null) && (((ActivityManager)localObject).getMemoryClass() * 1024 * 1024 / 10 > this.mMMapMaxSize)) {
        this.mMMapMaxSize = (((ActivityManager)localObject).getMemoryClass() * 1024 * 1024 / 10);
      }
      this.mMMapFileSize = readMMapSize();
      if (this.mMMapFileSize == 0) {
        this.mMMapFileSize = this.mMMapMinSize;
      }
      if (!ypi.e(this.mMMapFilepath)) {
        ypi.a(this.mMMapFilepath);
      }
      this.mMMapMemoryMappedFile = new RandomAccessFile(this.mMMapFilepath, "rw");
      this.mMMapDataBuffer = this.mMMapMemoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, this.mMMapFileSize);
      this.mMMapDataBuffer.rewind();
      int j = this.mMMapDataBuffer.getInt();
      this.mNumberOfKeysWithDuplicated = j;
      this.mMMapCurrentSize += 4;
      int i = 0;
      while (i < j)
      {
        int k = this.mMMapDataBuffer.getInt();
        this.mMMapCurrentSize += 4;
        localObject = new byte[k];
        this.mMMapDataBuffer.get((byte[])localObject);
        this.mMMapCurrentSize = (k + this.mMMapCurrentSize);
        String str = new String((byte[])localObject);
        k = this.mMMapDataBuffer.getInt();
        this.mMMapCurrentSize += 4;
        localObject = null;
        if (k != 0)
        {
          localObject = new byte[k];
          this.mMMapDataBuffer.get((byte[])localObject);
          localObject = new String((byte[])localObject);
          this.mMMapCurrentSize = (k + this.mMMapCurrentSize);
        }
        this.dataMap.put(str, localObject);
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, localThrowable.getStackTrace() + "");
      if (!ensureMemorySize(0)) {
        expandMMapFile();
      }
    }
  }
  
  private int readMMapSize()
  {
    return (int)new File(this.mMMapFilepath).length();
  }
  
  private void releaseMMapFile(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile != null) {}
    try
    {
      paramRandomAccessFile.close();
      paramRandomAccessFile.getChannel().close();
      return;
    }
    catch (IOException paramRandomAccessFile)
    {
      QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, paramRandomAccessFile.getStackTrace() + "");
    }
  }
  
  private void releaseMMapMemory(MappedByteBuffer paramMappedByteBuffer)
  {
    if (paramMappedByteBuffer != null) {
      paramMappedByteBuffer.clear();
    }
  }
  
  public static void resetRootPath()
  {
    AppRuntime localAppRuntime = pay.a();
    StringBuilder localStringBuilder;
    try
    {
      localStringBuilder = new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/tencent/MobileQQ/rijmmkv/");
      if (localAppRuntime != null) {}
      for (String str1 = localAppRuntime.getAccount();; str1 = "default")
      {
        mmkvRootPath = VFSAssistantUtils.getSDKPrivatePath(str1);
        return;
      }
      str2 = localAppRuntime.getAccount();
    }
    catch (Throwable localThrowable)
    {
      QLog.d("kandianreport.ReadInJoyMMapKvStorage", 1, localThrowable.getMessage());
      localStringBuilder = new StringBuilder().append(BaseApplicationImpl.getApplication().getFilesDir().getParent()).append("/tencent/MobileQQ/rijmmkv/");
      if (localAppRuntime == null) {}
    }
    for (;;)
    {
      mmkvRootPath = str2;
      return;
      String str2 = "default";
    }
  }
  
  private int sizeAfterRemoveDuplicatedKeys()
  {
    if (this.mMMapDataBuffer != null)
    {
      this.mMMapDataBuffer.clear();
      this.mMMapDataBuffer.rewind();
      this.mMMapDataBuffer.putInt(this.dataMap.size());
      Iterator localIterator = this.dataMap.entrySet().iterator();
      int i = 4;
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.mMMapDataBuffer.putInt(((String)localEntry.getKey()).getBytes().length);
        this.mMMapDataBuffer.put(((String)localEntry.getKey()).getBytes());
        label176:
        int k;
        if (localEntry.getValue() != null)
        {
          this.mMMapDataBuffer.putInt(((String)localEntry.getValue()).getBytes().length);
          this.mMMapDataBuffer.put(((String)localEntry.getValue()).getBytes());
          k = ((String)localEntry.getKey()).getBytes().length;
          if (localEntry.getValue() == null) {
            break label240;
          }
        }
        label240:
        for (int j = ((String)localEntry.getValue()).getBytes().length;; j = 0)
        {
          i = j + (k + 8) + i;
          break;
          this.mMMapDataBuffer.putInt(0);
          break label176;
        }
      }
      this.mNumberOfKeysWithDuplicated = this.dataMap.size();
      return i;
    }
    return 0;
  }
  
  public int getExpiredTime()
  {
    this.expiredTime = ((Integer)bkwm.a("kandianreport_mmkv_expired_" + this.mMMapName, Integer.valueOf(0))).intValue();
    return this.expiredTime;
  }
  
  /* Error */
  public String getValeForKey(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/tencent/biz/pubaccount/readinjoy/kandianreport/ReadInJoyMMapKvStorage:dataMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 169 2 0
    //   12: ifeq +21 -> 33
    //   15: aload_0
    //   16: getfield 47	com/tencent/biz/pubaccount/readinjoy/kandianreport/ReadInJoyMMapKvStorage:dataMap	Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface 173 2 0
    //   25: checkcast 100	java/lang/String
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: aconst_null
    //   34: astore_1
    //   35: goto -6 -> 29
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	ReadInJoyMMapKvStorage
    //   0	43	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	29	38	finally
  }
  
  public void invalidate()
  {
    try
    {
      if (this.mMMapDataBuffer != null) {
        this.mMMapDataBuffer.clear();
      }
      this.dataMap.clear();
      releaseMMapFile(this.mMMapMemoryMappedFile);
      this.mNumberOfKeysWithDuplicated = 0;
      this.mMMapCurrentSize = 0;
      if ((!TextUtils.isEmpty(this.mMMapFilepath)) && (ypi.e(this.mMMapFilepath))) {
        new File(this.mMMapFilepath).delete();
      }
      mMapHelperMap.remove(this.mMMapName);
      return;
    }
    finally {}
  }
  
  public void setExpiredTime(int paramInt)
  {
    try
    {
      this.expiredTime = paramInt;
      bkwm.a("kandianreport_mmkv_expired_" + this.mMMapName, Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean update(String paramString1, String paramString2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, "key is empty");
          return bool;
        }
        int j = paramString1.getBytes().length;
        if (paramString2 != null)
        {
          i = paramString2.getBytes().length;
          i += j + 8;
          if ((this.mMMapCurrentSize + i <= this.mMMapFileSize) || (ensureMemorySize(i)) || (expandMMapFile())) {
            break label128;
          }
          QLog.e("kandianreport.ReadInJoyMMapKvStorage", 2, "expand map file error key " + paramString1 + " value " + paramString2);
          continue;
        }
        int i = 0;
      }
      finally {}
      continue;
      try
      {
        label128:
        this.mMMapDataBuffer.putInt(paramString1.getBytes().length);
        this.mMMapCurrentSize += 4;
        this.mMMapDataBuffer.put(paramString1.getBytes());
        this.mMMapCurrentSize += paramString1.getBytes().length;
        if (paramString2 != null)
        {
          this.mMMapDataBuffer.putInt(paramString2.getBytes().length);
          this.mMMapCurrentSize += 4;
          this.mMMapDataBuffer.put(paramString2.getBytes());
        }
        for (this.mMMapCurrentSize += paramString2.getBytes().length;; this.mMMapCurrentSize += 4)
        {
          this.mNumberOfKeysWithDuplicated += 1;
          this.mMMapDataBuffer.putInt(0, this.mNumberOfKeysWithDuplicated);
          this.dataMap.put(paramString1, paramString2);
          bool = true;
          break;
          this.mMMapDataBuffer.putInt(0);
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("kandianreport.ReadInJoyMMapKvStorage", 1, paramString1.getStackTrace() + "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage
 * JD-Core Version:    0.7.0.1
 */