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

public class bhiz
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "livepluginso.jar";
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Map<String, bhja> jdField_a_of_type_JavaUtilMap;
  
  bhiz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(this.jdField_a_of_type_AndroidContentContext).getCommonDownloader();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.enableResumeTransfer(true);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private static void a()
  {
    String str = bhkh.a(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty(str)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(str + jdField_a_of_type_JavaLangString);
    } while (!localFile.exists());
    try
    {
      bhoh.b(localFile, new File(str));
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
  
  private void a(bhja parambhja)
  {
    if (parambhja != null)
    {
      Object localObject = bhja.a(parambhja);
      if (localObject != null) {
        ((bhjb)localObject).a(parambhja);
      }
      localObject = bhkh.a(BaseApplicationImpl.getContext()) + jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveSoDownloader", 2, "downloadSoInner url:" + bhja.a(parambhja) + "     path:" + (String)localObject);
      }
      if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(bhja.a(parambhja), (String)localObject, new bhjc(this, parambhja)))
      {
        localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3);
        ((Message)localObject).obj = parambhja;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  private void a(bhja parambhja, int paramInt1, int paramInt2)
  {
    parambhja = new HashMap();
    parambhja.put("ret_code", String.valueOf(paramInt1));
    parambhja.put("refer", String.valueOf(paramInt2));
    if ((BaseApplicationImpl.getApplication() != null) && (BaseApplicationImpl.getApplication().getRuntime() != null)) {
      axrn.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actQZLiveDownloadSoReport", true, 0L, 0L, parambhja, null);
    }
  }
  
  private void b(bhja parambhja)
  {
    if (parambhja != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.cancel(bhja.a(parambhja), new bhjc(this, parambhja));
    }
  }
  
  public void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramString;
  }
  
  public void a(String paramString, bhjb parambhjb, int paramInt)
  {
    bhja localbhja = new bhja();
    bhja.a(localbhja, paramString);
    bhja.a(localbhja, parambhjb);
    bhja.a(localbhja, paramInt);
    if ((bhkh.a(BaseApplicationImpl.getContext())) && (parambhjb != null))
    {
      parambhjb.d(localbhja);
      return;
    }
    paramString = Message.obtain();
    paramString.what = 0;
    paramString.obj = localbhja;
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
      if ((paramMessage.obj instanceof bhja))
      {
        paramMessage = (bhja)paramMessage.obj;
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhja.a(paramMessage))) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilMap.put(bhja.a(paramMessage), paramMessage);
        a(paramMessage);
        return true;
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage))
          {
            Object localObject = (bhja)this.jdField_a_of_type_JavaUtilMap.get(paramMessage);
            a((bhja)localObject, 3, bhja.a((bhja)localObject));
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage);
            b((bhja)localObject);
            continue;
            if ((paramMessage.obj instanceof bhja))
            {
              paramMessage = (bhja)paramMessage.obj;
              if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhja.a(paramMessage)))
              {
                a(paramMessage, 1, bhja.a(paramMessage));
                this.jdField_a_of_type_JavaUtilMap.remove(bhja.a(paramMessage));
                localObject = bhja.a(paramMessage);
                if (localObject != null)
                {
                  ((bhjb)localObject).b(paramMessage);
                  continue;
                  if ((paramMessage.obj instanceof bhja))
                  {
                    paramMessage = (bhja)paramMessage.obj;
                    if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhja.a(paramMessage)))
                    {
                      a(paramMessage, 2, bhja.a(paramMessage));
                      this.jdField_a_of_type_JavaUtilMap.remove(bhja.a(paramMessage));
                      localObject = bhja.a(paramMessage);
                      if (localObject != null)
                      {
                        ((bhjb)localObject).c(paramMessage);
                        continue;
                        if ((paramMessage.obj instanceof bhja))
                        {
                          paramMessage = (bhja)paramMessage.obj;
                          if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhja.a(paramMessage)))
                          {
                            localObject = bhja.a(paramMessage);
                            a();
                            LocalMultiProcConfig.putInt("QzoneLiveSoVersion", QzoneConfig.getInstance().getConfig("LiveSetting", "LivePluginSOVersion", 5));
                            if (bhkh.a(BaseApplicationImpl.getContext()))
                            {
                              a(paramMessage, 0, bhja.a(paramMessage));
                              this.jdField_a_of_type_JavaUtilMap.remove(bhja.a(paramMessage));
                              if (localObject != null) {
                                ((bhjb)localObject).d(paramMessage);
                              }
                            }
                            else if (localObject != null)
                            {
                              ((bhjb)localObject).c(paramMessage);
                              continue;
                              if ((paramMessage.obj instanceof bhja))
                              {
                                paramMessage = (bhja)paramMessage.obj;
                                if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhja.a(paramMessage)))
                                {
                                  localObject = bhja.a(paramMessage);
                                  if (localObject != null) {
                                    ((bhjb)localObject).e(paramMessage);
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
 * Qualified Name:     bhiz
 * JD-Core Version:    0.7.0.1
 */