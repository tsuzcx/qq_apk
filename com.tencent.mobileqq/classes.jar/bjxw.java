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

public class bjxw
  implements ApkUpdateListener
{
  protected static bjxw a;
  public static final String a;
  protected ConcurrentLinkedQueue<bjxx> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bjxw.class.getName();
  }
  
  protected bjxw()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    ApkUpdateSDK.getInstance().init(bjjo.a().a());
    ApkUpdateSDK.getInstance().addListener(this);
  }
  
  public static bjxw a()
  {
    try
    {
      if (jdField_a_of_type_Bjxw == null) {
        jdField_a_of_type_Bjxw = new bjxw();
      }
      bjxw localbjxw = jdField_a_of_type_Bjxw;
      return localbjxw;
    }
    finally {}
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 55	bjxw:jdField_a_of_type_Bjxw	Lbjxw;
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
    //   6	2	1	localbjxw	bjxw
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
        bjtx.a(jdField_a_of_type_JavaLangString, "onDestroy>>>", localException);
      }
    }
    finally {}
  }
  
  public void a(bjxx parambjxx)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(parambjxx);
      return;
    }
    finally
    {
      parambjxx = finally;
      throw parambjxx;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    String str2 = paramDownloadInfo.e;
    String str3 = paramDownloadInfo.l;
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    int i;
    for (String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + bjwq.jdField_a_of_type_JavaLangString + "newApkDir";; str1 = bjjo.a().a().getFilesDir().getAbsolutePath())
    {
      File localFile = new File(str1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      str1 = str1 + "/" + str2 + ".newGen.apk";
      bjtx.b(jdField_a_of_type_JavaLangString, "patchNewApk>>>>>packageName=" + str2 + ", patchPath=" + str3 + ", newApkPath=" + str1);
      i = ApkUpdateSDK.getInstance().patchNewApk(str2, str3, str1);
      if (i != 0) {
        break label421;
      }
      bjtx.b(jdField_a_of_type_JavaLangString, anzj.a(2131714688));
      paramDownloadInfo.l = str1;
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (anvl.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.a = false;
      }
      if ((!"com.tencent.mobileqq".equals(paramDownloadInfo.e)) || (!bjwq.a().b())) {
        break label403;
      }
      paramDownloadInfo.j = bjwq.a().a(paramDownloadInfo);
      if (paramDownloadInfo.j == 0) {
        break;
      }
      bjtx.d(jdField_a_of_type_JavaLangString, "updateManager patchNewApk write code fail......");
      paramDownloadInfo.a(-2);
      bjwq.a().e(paramDownloadInfo);
      bjwq.a().a(paramDownloadInfo, paramDownloadInfo.j, null);
      return;
    }
    paramDownloadInfo.a(4);
    bjwq.a().e(paramDownloadInfo);
    bjtx.c(jdField_a_of_type_JavaLangString, "info.path = " + paramDownloadInfo.l);
    bjwq.a().a(4, paramDownloadInfo);
    if (paramDownloadInfo.a) {
      bjwq.a().c(paramDownloadInfo);
    }
    bjvg.a("300", paramDownloadInfo.h, paramDownloadInfo.c, paramDownloadInfo.o);
    ThreadManager.getSubThreadHandler().post(new UpdateManager.1(this, str1, paramDownloadInfo));
    return;
    label403:
    ThreadManager.getSubThreadHandler().post(new UpdateManager.2(this, str1, paramDownloadInfo));
    return;
    label421:
    bjtx.e(jdField_a_of_type_JavaLangString, anzj.a(2131714689) + i);
    bjwq.a().a(-24, paramDownloadInfo);
  }
  
  public void a(List<String> paramList)
  {
    bjtx.b(jdField_a_of_type_JavaLangString, "checkUpdate>>> list size:" + paramList.size());
    ApkUpdateSDK.getInstance().checkUpdate(paramList);
  }
  
  public void b(bjxx parambjxx)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(parambjxx);
      return;
    }
    finally
    {
      parambjxx = finally;
      throw parambjxx;
    }
  }
  
  public void b(List<ApkUpdateParam> paramList)
  {
    bjtx.b(jdField_a_of_type_JavaLangString, "checkUpdate>>> list size:" + paramList.size());
    ApkUpdateSDK.getInstance().checkUpdateList(paramList);
  }
  
  public void onCheckUpdateFailed(String paramString)
  {
    bjtx.c(jdField_a_of_type_JavaLangString, "onCheckUpdateFailed>>>errMsg=" + paramString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext()) {
      ((bjxx)localIterator.next()).a(paramString);
    }
  }
  
  public void onCheckUpdateSucceed(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext()) {
        ((bjxx)localIterator.next()).a(paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxw
 * JD-Core Version:    0.7.0.1
 */