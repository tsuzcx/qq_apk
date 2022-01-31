import android.content.Context;
import android.os.Environment;
import com.tencent.apkupdate.ApkUpdateListener;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.ApkUpdateSDK;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.UpdateManager.1;
import com.tencent.open.downloadnew.UpdateManager.2;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class bchu
  implements ApkUpdateListener
{
  protected static bchu a;
  public static final String a;
  protected ConcurrentLinkedQueue<bchv> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bchu.class.getName();
  }
  
  protected bchu()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    ApkUpdateSDK.getInstance().init(bbtm.a().a());
    ApkUpdateSDK.getInstance().addListener(this);
  }
  
  public static bchu a()
  {
    try
    {
      if (jdField_a_of_type_Bchu == null) {
        jdField_a_of_type_Bchu = new bchu();
      }
      bchu localbchu = jdField_a_of_type_Bchu;
      return localbchu;
    }
    finally {}
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 55	bchu:jdField_a_of_type_Bchu	Lbchu;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localbchu	bchu
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public void a()
  {
    try
    {
      ApkUpdateSDK.getInstance().removeListener(this);
      ApkUpdateSDK.getInstance().destory();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException = localException;
        bcds.a(jdField_a_of_type_JavaLangString, "onDestroy>>>", localException);
      }
    }
    finally {}
  }
  
  public void a(bchv parambchv)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambchv);
      return;
    }
    finally
    {
      parambchv = finally;
      throw parambchv;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    String str2 = paramDownloadInfo.e;
    String str3 = paramDownloadInfo.l;
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    int i;
    for (String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + bcgo.jdField_a_of_type_JavaLangString + "newApkDir";; str1 = bbtm.a().a().getFilesDir().getAbsolutePath())
    {
      File localFile = new File(str1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      str1 = str1 + "/" + str2 + ".newGen.apk";
      bcds.b(jdField_a_of_type_JavaLangString, "patchNewApk>>>>>packageName=" + str2 + ", patchPath=" + str3 + ", newApkPath=" + str1);
      i = ApkUpdateSDK.getInstance().patchNewApk(str2, str3, str1);
      if (i != 0) {
        break label421;
      }
      bcds.b(jdField_a_of_type_JavaLangString, ajjy.a(2131650116));
      paramDownloadInfo.l = str1;
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (ajgd.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.a = false;
      }
      if ((!"com.tencent.mobileqq".equals(paramDownloadInfo.e)) || (!bcgo.a().b())) {
        break label403;
      }
      paramDownloadInfo.j = bcgo.a().a(paramDownloadInfo);
      if (paramDownloadInfo.j == 0) {
        break;
      }
      bcds.d(jdField_a_of_type_JavaLangString, "updateManager patchNewApk write code fail......");
      paramDownloadInfo.a(-2);
      bcgo.a().e(paramDownloadInfo);
      bcgo.a().a(paramDownloadInfo, paramDownloadInfo.j, null);
      return;
    }
    paramDownloadInfo.a(4);
    bcgo.a().e(paramDownloadInfo);
    bcds.c(jdField_a_of_type_JavaLangString, "info.path = " + paramDownloadInfo.l);
    bcgo.a().a(4, paramDownloadInfo);
    if (paramDownloadInfo.a) {
      bcgo.a().c(paramDownloadInfo);
    }
    bcfb.a("300", paramDownloadInfo.h, paramDownloadInfo.c, paramDownloadInfo.o);
    ThreadManager.getSubThreadHandler().post(new UpdateManager.1(this, str1, paramDownloadInfo));
    return;
    label403:
    ThreadManager.getSubThreadHandler().post(new UpdateManager.2(this, str1, paramDownloadInfo));
    return;
    label421:
    bcds.e(jdField_a_of_type_JavaLangString, ajjy.a(2131650117) + i);
    bcgo.a().a(-24, paramDownloadInfo);
  }
  
  public void a(List<String> paramList)
  {
    bcds.b(jdField_a_of_type_JavaLangString, "checkUpdate>>> list size:" + paramList.size());
    ApkUpdateSDK.getInstance().checkUpdate(paramList);
  }
  
  public void b(bchv parambchv)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(parambchv);
      return;
    }
    finally
    {
      parambchv = finally;
      throw parambchv;
    }
  }
  
  public void b(List<ApkUpdateParam> paramList)
  {
    bcds.b(jdField_a_of_type_JavaLangString, "checkUpdate>>> list size:" + paramList.size());
    ApkUpdateSDK.getInstance().checkUpdateList(paramList);
  }
  
  public void onCheckUpdateFailed(String paramString)
  {
    bcds.c(jdField_a_of_type_JavaLangString, "onCheckUpdateFailed>>>errMsg=" + paramString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext()) {
      ((bchv)localIterator.next()).a(paramString);
    }
  }
  
  public void onCheckUpdateSucceed(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext()) {
        ((bchv)localIterator.next()).a(paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bchu
 * JD-Core Version:    0.7.0.1
 */