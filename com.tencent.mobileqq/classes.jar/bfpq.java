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

public class bfpq
  implements ApkUpdateListener
{
  protected static bfpq a;
  public static final String a;
  protected ConcurrentLinkedQueue<bfpr> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bfpq.class.getName();
  }
  
  protected bfpq()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    ApkUpdateSDK.getInstance().init(bfbm.a().a());
    ApkUpdateSDK.getInstance().addListener(this);
  }
  
  public static bfpq a()
  {
    try
    {
      if (jdField_a_of_type_Bfpq == null) {
        jdField_a_of_type_Bfpq = new bfpq();
      }
      bfpq localbfpq = jdField_a_of_type_Bfpq;
      return localbfpq;
    }
    finally {}
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 55	bfpq:jdField_a_of_type_Bfpq	Lbfpq;
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
    //   6	2	1	localbfpq	bfpq
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
        bflp.a(jdField_a_of_type_JavaLangString, "onDestroy>>>", localException);
      }
    }
    finally {}
  }
  
  public void a(bfpr parambfpr)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambfpr);
      return;
    }
    finally
    {
      parambfpr = finally;
      throw parambfpr;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    String str2 = paramDownloadInfo.e;
    String str3 = paramDownloadInfo.l;
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    int i;
    for (String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + bfok.jdField_a_of_type_JavaLangString + "newApkDir";; str1 = bfbm.a().a().getFilesDir().getAbsolutePath())
    {
      File localFile = new File(str1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      str1 = str1 + "/" + str2 + ".newGen.apk";
      bflp.b(jdField_a_of_type_JavaLangString, "patchNewApk>>>>>packageName=" + str2 + ", patchPath=" + str3 + ", newApkPath=" + str1);
      i = ApkUpdateSDK.getInstance().patchNewApk(str2, str3, str1);
      if (i != 0) {
        break label421;
      }
      bflp.b(jdField_a_of_type_JavaLangString, alud.a(2131716302));
      paramDownloadInfo.l = str1;
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (alqf.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.a = false;
      }
      if ((!"com.tencent.mobileqq".equals(paramDownloadInfo.e)) || (!bfok.a().b())) {
        break label403;
      }
      paramDownloadInfo.j = bfok.a().a(paramDownloadInfo);
      if (paramDownloadInfo.j == 0) {
        break;
      }
      bflp.d(jdField_a_of_type_JavaLangString, "updateManager patchNewApk write code fail......");
      paramDownloadInfo.a(-2);
      bfok.a().e(paramDownloadInfo);
      bfok.a().a(paramDownloadInfo, paramDownloadInfo.j, null);
      return;
    }
    paramDownloadInfo.a(4);
    bfok.a().e(paramDownloadInfo);
    bflp.c(jdField_a_of_type_JavaLangString, "info.path = " + paramDownloadInfo.l);
    bfok.a().a(4, paramDownloadInfo);
    if (paramDownloadInfo.a) {
      bfok.a().c(paramDownloadInfo);
    }
    bfmy.a("300", paramDownloadInfo.h, paramDownloadInfo.c, paramDownloadInfo.o);
    ThreadManager.getSubThreadHandler().post(new UpdateManager.1(this, str1, paramDownloadInfo));
    return;
    label403:
    ThreadManager.getSubThreadHandler().post(new UpdateManager.2(this, str1, paramDownloadInfo));
    return;
    label421:
    bflp.e(jdField_a_of_type_JavaLangString, alud.a(2131716303) + i);
    bfok.a().a(-24, paramDownloadInfo);
  }
  
  public void a(List<String> paramList)
  {
    bflp.b(jdField_a_of_type_JavaLangString, "checkUpdate>>> list size:" + paramList.size());
    ApkUpdateSDK.getInstance().checkUpdate(paramList);
  }
  
  public void b(bfpr parambfpr)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(parambfpr);
      return;
    }
    finally
    {
      parambfpr = finally;
      throw parambfpr;
    }
  }
  
  public void b(List<ApkUpdateParam> paramList)
  {
    bflp.b(jdField_a_of_type_JavaLangString, "checkUpdate>>> list size:" + paramList.size());
    ApkUpdateSDK.getInstance().checkUpdateList(paramList);
  }
  
  public void onCheckUpdateFailed(String paramString)
  {
    bflp.c(jdField_a_of_type_JavaLangString, "onCheckUpdateFailed>>>errMsg=" + paramString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext()) {
      ((bfpr)localIterator.next()).a(paramString);
    }
  }
  
  public void onCheckUpdateSucceed(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext()) {
        ((bfpr)localIterator.next()).a(paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfpq
 * JD-Core Version:    0.7.0.1
 */