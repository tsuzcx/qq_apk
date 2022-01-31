import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLDrawableHandler.Adapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class bdua
  extends QIPCModule
  implements ApngSoLoader
{
  private static bdua jdField_a_of_type_Bdua;
  public static String a;
  private CopyOnWriteArrayList<Integer> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private CopyOnWriteArrayList<URLDrawableHandler> b = new CopyOnWriteArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "action_download_apng_so";
  }
  
  private bdua(String paramString)
  {
    super(paramString);
  }
  
  public static bdua a()
  {
    try
    {
      if (jdField_a_of_type_Bdua == null) {
        jdField_a_of_type_Bdua = new bdua("VasApngIPCModule");
      }
      bdua localbdua = jdField_a_of_type_Bdua;
      return localbdua;
    }
    finally {}
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(184);
    if (paramQQAppInterface != null)
    {
      QLog.e("VasApngUtil.IPCModule", 1, "start download so");
      paramQQAppInterface.downloadItem(1004L, "libAPNG_813", "VasApngUtil.IPCModule");
      return true;
    }
    QLog.d("VasApngUtil.IPCModule", 1, "load fail no manager");
    return false;
  }
  
  private void b(int paramInt)
  {
    callbackResult(paramInt, EIPCResult.createResult(0, null));
  }
  
  public void a()
  {
    a(new URLDrawableHandler.Adapter(), true);
  }
  
  public void a(int paramInt)
  {
    QLog.d("VasApngUtil.IPCModule", 1, "onDownloadCompleted: errCode=" + paramInt);
    String str1;
    String str2;
    if (paramInt == 0)
    {
      str1 = bdom.a();
      str2 = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "apng.zip";
      if (bdom.a(str2, str1, "libAPNG_release_813.so"))
      {
        QLog.d("VasApngUtil.IPCModule", 1, "unzip apng zip success");
        b();
        VasQuickUpdateEngine.safeDeleteFile(new File(str2));
      }
    }
    for (;;)
    {
      b();
      return;
      QLog.e("VasApngUtil.IPCModule", 1, new Object[] { "unzip error, libDir=" + str1, " zipPath=" + str2 });
      continue;
      QLog.e("VasApngUtil.IPCModule", 1, "apng download error: " + paramInt);
    }
  }
  
  public void a(URLDrawableHandler paramURLDrawableHandler, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.e("VasApngUtil.IPCModule", 1, "load by others");
      paramURLDrawableHandler.onFileDownloadSucceed(0L);
    }
    Object localObject;
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication();
      if (localObject == null)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "load fail null application");
        paramURLDrawableHandler.onFileDownloadFailed(10000);
        return;
      }
      if (b())
      {
        QLog.e("VasApngUtil.IPCModule", 1, "load exists so success");
        paramURLDrawableHandler.onFileDownloadSucceed(0L);
        return;
      }
      if (!paramBoolean)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "second try so not exists");
        paramURLDrawableHandler.onFileDownloadFailed(10001);
        return;
      }
      if (FlatBuffersParser.c())
      {
        QLog.e("VasApngUtil.IPCModule", 1, "isX86 can't download apng.so");
        paramURLDrawableHandler.onFileDownloadFailed(10004);
        return;
      }
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject == null)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "load fail null runtime");
        paramURLDrawableHandler.onFileDownloadFailed(10002);
        return;
      }
      if (!(localObject instanceof QQAppInterface)) {
        break;
      }
      this.b.add(paramURLDrawableHandler);
    } while (a((QQAppInterface)localObject));
    this.b.remove(paramURLDrawableHandler);
    paramURLDrawableHandler.onFileDownloadFailed(10003);
    return;
    QLog.e("VasApngUtil.IPCModule", 1, "child progress callServer to load");
    QIPCClientHelper.getInstance().callServer("VasApngIPCModule", jdField_a_of_type_JavaLangString, null, new bdub(this, paramURLDrawableHandler));
  }
  
  public boolean a()
  {
    String str = bdom.a();
    return (!TextUtils.isEmpty(str)) && (new File(str + "libAPNG_release_813.so").exists());
  }
  
  void b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (URLDrawableHandler)localIterator.next();
      a((URLDrawableHandler)localObject, false);
      localArrayList.add(localObject);
    }
    this.b.removeAll(localArrayList);
    localArrayList = new ArrayList();
    localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (Integer)localIterator.next();
      b(((Integer)localObject).intValue());
      localArrayList.add(localObject);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.removeAll(localArrayList);
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("VasApngUtil.IPCModule", 2, "loadSoLib: already loaded");
            bool1 = bool2;
          }
          return bool1;
        }
        String str = bdom.a();
        if (!TextUtils.isEmpty(str))
        {
          str = str + "libAPNG_release_813.so";
          if (new File(str).exists())
          {
            QLog.d("VasApngUtil.IPCModule", 1, "loadSoLib: libAPNG_release_813.so");
            try
            {
              System.load(str);
              this.jdField_a_of_type_Boolean = true;
              QLog.d("VasApngUtil.IPCModule", 1, "libAPNG.so load success.");
              bool1 = bool2;
            }
            catch (Throwable localThrowable)
            {
              QLog.d("VasApngUtil.IPCModule", 1, "libAPNG.so load failed. :", localThrowable);
              VasQuickUpdateEngine.safeDeleteFile(new File(str));
              azqs.b(null, "CliOper", "", "", "Font_Mall", "0X80073FE", 0, 0, "101", "", "", "");
              break label206;
            }
          }
          QLog.e("VasApngUtil.IPCModule", 1, "loadSoLib not exists: " + str);
        }
      }
      finally {}
      label206:
      boolean bool1 = false;
    }
  }
  
  public boolean isLoaded()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void load(URLDrawableHandler paramURLDrawableHandler)
  {
    a(paramURLDrawableHandler, true);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasApngUtil.IPCModule", 2, "onCall action = " + paramString);
    }
    if (jdField_a_of_type_JavaLangString.equals(paramString))
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(Integer.valueOf(paramInt));
      paramBundle = BaseApplicationImpl.getApplication();
      if (paramBundle == null)
      {
        paramString = null;
        if ((paramBundle == null) || (!(paramString instanceof QQAppInterface)) || (!a((QQAppInterface)paramString))) {
          break label96;
        }
      }
    }
    label96:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return null;
        paramString = paramBundle.getRuntime();
      }
      QLog.e("VasApngUtil.IPCModule", 1, "download fail to start, application:" + paramBundle + " runtime:" + paramString);
      b(paramInt);
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramInt);
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "callbacks.remove error : " + paramString.getMessage());
        return null;
      }
    }
    QLog.d("VasApngUtil.IPCModule", 2, "onCall action = " + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdua
 * JD-Core Version:    0.7.0.1
 */