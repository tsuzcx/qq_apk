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

public class bhii
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "livepluginso.jar";
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bhij> jdField_a_of_type_JavaUtilMap;
  
  bhii(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext).getCommonDownloader();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private static void a()
  {
    String str = bhjq.a(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty(str)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(str + jdField_a_of_type_JavaLangString);
    } while (!localFile.exists());
    try
    {
      bhnq.b(localFile, new File(str));
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
  
  private void a(bhij parambhij)
  {
    if (parambhij != null)
    {
      Object localObject = bhij.a(parambhij);
      if (localObject != null) {
        ((bhik)localObject).a(parambhij);
      }
      localObject = bhjq.a(BaseApplicationImpl.getContext()) + jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "downloadSoInner url:" + bhij.a(parambhij) + "     path:" + (String)localObject);
      }
      if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(bhij.a(parambhij), (String)localObject, new bhil(this, parambhij)))
      {
        localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
        ((Message)localObject).obj = parambhij;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private void a(bhij parambhij, int paramInt1, int paramInt2)
  {
    parambhij = new HashMap();
    parambhij.put("ret_code", String.valueOf(paramInt1));
    parambhij.put("refer", String.valueOf(paramInt2));
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      axrl.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actQZLiveDownloadSoReport", true, 0L, 0L, parambhij, null);
    }
  }
  
  private void b(bhij parambhij)
  {
    if (parambhij != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.cancel(bhij.a(parambhij), new bhil(this, parambhij));
    }
  }
  
  public void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramString;
  }
  
  public void a(String paramString, bhik parambhik, int paramInt)
  {
    bhij localbhij = new bhij();
    bhij.a(localbhij, paramString);
    bhij.a(localbhij, parambhik);
    bhij.a(localbhij, paramInt);
    if ((bhjq.a(BaseApplicationImpl.getContext())) && (parambhik != null))
    {
      parambhik.d(localbhij);
      return;
    }
    paramString = Message.obtain();
    paramString.what = 0;
    paramString.obj = localbhij;
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
      if ((paramMessage.obj instanceof bhij))
      {
        paramMessage = (bhij)paramMessage.obj;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhij.a(paramMessage))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilMap.put(bhij.a(paramMessage), paramMessage);
        a(paramMessage);
        return true;
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage))
          {
            Object localObject = (bhij)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
            a((bhij)localObject, 3, bhij.a((bhij)localObject));
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
            b((bhij)localObject);
            continue;
            if ((paramMessage.obj instanceof bhij))
            {
              paramMessage = (bhij)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhij.a(paramMessage)))
              {
                a(paramMessage, 1, bhij.a(paramMessage));
                this.jdField_a_of_type_JavaUtilMap.remove(bhij.a(paramMessage));
                localObject = bhij.a(paramMessage);
                if (localObject != null)
                {
                  ((bhik)localObject).b(paramMessage);
                  continue;
                  if ((paramMessage.obj instanceof bhij))
                  {
                    paramMessage = (bhij)paramMessage.obj;
                    if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhij.a(paramMessage)))
                    {
                      a(paramMessage, 2, bhij.a(paramMessage));
                      this.jdField_a_of_type_JavaUtilMap.remove(bhij.a(paramMessage));
                      localObject = bhij.a(paramMessage);
                      if (localObject != null)
                      {
                        ((bhik)localObject).c(paramMessage);
                        continue;
                        if ((paramMessage.obj instanceof bhij))
                        {
                          paramMessage = (bhij)paramMessage.obj;
                          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhij.a(paramMessage)))
                          {
                            localObject = bhij.a(paramMessage);
                            a();
                            LocalMultiProcConfig.putInt("QzoneLiveSoVersion", QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5));
                            if (bhjq.a(BaseApplicationImpl.getContext()))
                            {
                              a(paramMessage, 0, bhij.a(paramMessage));
                              this.jdField_a_of_type_JavaUtilMap.remove(bhij.a(paramMessage));
                              if (localObject != null) {
                                ((bhik)localObject).d(paramMessage);
                              }
                            }
                            else if (localObject != null)
                            {
                              ((bhik)localObject).c(paramMessage);
                              continue;
                              if ((paramMessage.obj instanceof bhij))
                              {
                                paramMessage = (bhij)paramMessage.obj;
                                if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhij.a(paramMessage)))
                                {
                                  localObject = bhij.a(paramMessage);
                                  if (localObject != null) {
                                    ((bhik)localObject).e(paramMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhii
 * JD-Core Version:    0.7.0.1
 */