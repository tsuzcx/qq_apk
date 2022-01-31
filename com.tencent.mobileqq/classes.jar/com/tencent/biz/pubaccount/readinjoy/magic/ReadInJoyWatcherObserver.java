package com.tencent.biz.pubaccount.readinjoy.magic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.FileObserver;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidAPs;
import com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidAPs.NotAndroidAppProcessException;
import com.tencent.biz.pubaccount.readinjoy.magic.utils.DebounceCallback;
import com.tencent.biz.pubaccount.readinjoy.magic.utils.Debouncer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lrm;
import lrn;

public class ReadInJoyWatcherObserver
  extends FileObserver
  implements DebounceCallback
{
  private AndroidAPs jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicModelsAndroidAPs;
  private Debouncer jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebouncer = new Debouncer(this, 60000);
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private final lrn jdField_a_of_type_Lrn;
  
  ReadInJoyWatcherObserver(Context paramContext, lrn paramlrn)
  {
    super("/dev/cpuctl/apps/bg_non_interactive/tasks", 8);
    this.jdField_a_of_type_Lrn = paramlrn;
    this.jdField_a_of_type_JavaLangRunnable = new lrm(this, new WeakReference(paramContext));
  }
  
  private List a(@NonNull List paramList)
  {
    int i = Process.myPid();
    Iterator localIterator = paramList.iterator();
    AndroidAPs localAndroidAPs;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localAndroidAPs = (AndroidAPs)localIterator.next();
    } while (localAndroidAPs.b != i);
    for (;;)
    {
      paramList.remove(localAndroidAPs);
      return paramList;
      localAndroidAPs = null;
    }
  }
  
  private void a(AndroidAPs paramAndroidAPs)
  {
    if (this.jdField_a_of_type_Lrn != null) {
      this.jdField_a_of_type_Lrn.a(paramAndroidAPs);
    }
  }
  
  private static List b(Context paramContext, Set paramSet)
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = new File("/proc").listFiles();
    paramContext = paramContext.getPackageManager();
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfFile[i];
      if (((File)localObject).isDirectory()) {}
      for (;;)
      {
        try
        {
          k = Integer.parseInt(((File)localObject).getName());
          if (paramSet.contains(Integer.valueOf(k))) {
            continue;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int k;
          continue;
        }
        i += 1;
        break;
        try
        {
          localObject = new AndroidAPs(k);
          if ((((AndroidAPs)localObject).jdField_a_of_type_Boolean) && ((((AndroidAPs)localObject).jdField_a_of_type_Int < 1000) || (((AndroidAPs)localObject).jdField_a_of_type_Int > 9999)) && (!((AndroidAPs)localObject).jdField_a_of_type_JavaLangString.contains(":")) && (paramContext.getLaunchIntentForPackage(((AndroidAPs)localObject).a()) != null)) {
            localArrayList.add(localObject);
          }
        }
        catch (AndroidAPs.NotAndroidAppProcessException localNotAndroidAppProcessException) {}catch (IOException localIOException)
        {
          QLog.e("CgroupFileObserver", 2, "getRunningForegroundApps: ", localIOException);
        }
      }
    }
    return localArrayList;
  }
  
  /* Error */
  private static Set b(File paramFile)
  {
    // Byte code:
    //   0: new 189	java/util/HashSet
    //   3: dup
    //   4: invokespecial 190	java/util/HashSet:<init>	()V
    //   7: astore_3
    //   8: new 192	java/util/Scanner
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 195	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   16: astore_1
    //   17: aload_1
    //   18: astore_0
    //   19: aload_1
    //   20: invokevirtual 198	java/util/Scanner:hasNextInt	()Z
    //   23: ifeq +44 -> 67
    //   26: aload_1
    //   27: astore_0
    //   28: aload_3
    //   29: aload_1
    //   30: invokevirtual 201	java/util/Scanner:nextInt	()I
    //   33: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   36: invokeinterface 202 2 0
    //   41: pop
    //   42: goto -25 -> 17
    //   45: astore_2
    //   46: aload_1
    //   47: astore_0
    //   48: ldc 177
    //   50: iconst_2
    //   51: ldc 204
    //   53: aload_2
    //   54: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   57: aload_1
    //   58: ifnull +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 207	java/util/Scanner:close	()V
    //   65: aload_3
    //   66: areturn
    //   67: aload_1
    //   68: ifnull -3 -> 65
    //   71: aload_1
    //   72: invokevirtual 207	java/util/Scanner:close	()V
    //   75: aload_3
    //   76: areturn
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 207	java/util/Scanner:close	()V
    //   88: aload_1
    //   89: athrow
    //   90: astore_1
    //   91: goto -11 -> 80
    //   94: astore_2
    //   95: aconst_null
    //   96: astore_1
    //   97: goto -51 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramFile	File
    //   16	56	1	localScanner	java.util.Scanner
    //   77	12	1	localObject1	Object
    //   90	1	1	localObject2	Object
    //   96	1	1	localObject3	Object
    //   45	9	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   94	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   7	69	3	localHashSet	java.util.HashSet
    // Exception table:
    //   from	to	target	type
    //   19	26	45	java/io/FileNotFoundException
    //   28	42	45	java/io/FileNotFoundException
    //   8	17	77	finally
    //   19	26	90	finally
    //   28	42	90	finally
    //   48	57	90	finally
    //   8	17	94	java/io/FileNotFoundException
  }
  
  public void a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onEvent(int paramInt, @Nullable String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebouncer.a(Integer.valueOf(8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.ReadInJoyWatcherObserver
 * JD-Core Version:    0.7.0.1
 */