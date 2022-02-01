import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class bnec
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "livepluginso.jar";
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bned> jdField_a_of_type_JavaUtilMap;
  
  bnec(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext).getCommonDownloader();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private static void a()
  {
    String str = bnfk.a(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty(str)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(str + jdField_a_of_type_JavaLangString);
    } while (!localFile.exists());
    try
    {
      bnjl.b(localFile, new File(str));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "unZipPluginSo success");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QZoneLiveSoDownloader", 1, "unzipTofolder" + localException.getMessage());
      return;
    }
    finally
    {
      localFile.delete();
    }
  }
  
  private void a(bned parambned)
  {
    if (parambned != null)
    {
      Object localObject = bned.a(parambned);
      if (localObject != null) {
        ((bnee)localObject).a(parambned);
      }
      localObject = bnfk.a(BaseApplicationImpl.getContext()) + jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "downloadSoInner url:" + bned.a(parambned) + "     path:" + (String)localObject);
      }
      if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(bned.a(parambned), (String)localObject, new bnef(this, parambned)))
      {
        localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
        ((Message)localObject).obj = parambned;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private void a(bned parambned, int paramInt1, int paramInt2)
  {
    parambned = new HashMap();
    parambned.put("ret_code", String.valueOf(paramInt1));
    parambned.put("refer", String.valueOf(paramInt2));
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      bdmc.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actQZLiveDownloadSoReport", true, 0L, 0L, parambned, null);
    }
  }
  
  private void b(bned parambned)
  {
    if (parambned != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.cancel(bned.a(parambned), new bnef(this, parambned));
    }
  }
  
  public void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramString;
  }
  
  public void a(String paramString, bnee parambnee, int paramInt)
  {
    bned localbned = new bned();
    bned.a(localbned, paramString);
    bned.a(localbned, parambnee);
    bned.a(localbned, paramInt);
    if ((bnfk.a(BaseApplicationImpl.getContext())) && (parambnee != null))
    {
      parambnee.d(localbned);
      return;
    }
    paramString = Message.obtain();
    paramString.what = 0;
    paramString.obj = localbned;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof bned))
      {
        paramMessage = (bned)paramMessage.obj;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(bned.a(paramMessage))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilMap.put(bned.a(paramMessage), paramMessage);
        a(paramMessage);
        return true;
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage))
          {
            Object localObject = (bned)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
            a((bned)localObject, 3, bned.a((bned)localObject));
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
            b((bned)localObject);
            continue;
            if ((paramMessage.obj instanceof bned))
            {
              paramMessage = (bned)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bned.a(paramMessage)))
              {
                a(paramMessage, 1, bned.a(paramMessage));
                this.jdField_a_of_type_JavaUtilMap.remove(bned.a(paramMessage));
                localObject = bned.a(paramMessage);
                if (localObject != null)
                {
                  ((bnee)localObject).b(paramMessage);
                  continue;
                  if ((paramMessage.obj instanceof bned))
                  {
                    paramMessage = (bned)paramMessage.obj;
                    if (this.jdField_a_of_type_JavaUtilMap.containsKey(bned.a(paramMessage)))
                    {
                      a(paramMessage, 2, bned.a(paramMessage));
                      this.jdField_a_of_type_JavaUtilMap.remove(bned.a(paramMessage));
                      localObject = bned.a(paramMessage);
                      if (localObject != null)
                      {
                        ((bnee)localObject).c(paramMessage);
                        continue;
                        if ((paramMessage.obj instanceof bned))
                        {
                          paramMessage = (bned)paramMessage.obj;
                          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bned.a(paramMessage)))
                          {
                            localObject = bned.a(paramMessage);
                            a();
                            LocalMultiProcConfig.putInt("QzoneLiveSoVersion", QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5));
                            if (bnfk.a(BaseApplicationImpl.getContext()))
                            {
                              a(paramMessage, 0, bned.a(paramMessage));
                              this.jdField_a_of_type_JavaUtilMap.remove(bned.a(paramMessage));
                              if (localObject != null) {
                                ((bnee)localObject).d(paramMessage);
                              }
                            }
                            else if (localObject != null)
                            {
                              ((bnee)localObject).c(paramMessage);
                              continue;
                              if ((paramMessage.obj instanceof bned))
                              {
                                paramMessage = (bned)paramMessage.obj;
                                if (this.jdField_a_of_type_JavaUtilMap.containsKey(bned.a(paramMessage)))
                                {
                                  localObject = bned.a(paramMessage);
                                  if (localObject != null) {
                                    ((bnee)localObject).e(paramMessage);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnec
 * JD-Core Version:    0.7.0.1
 */