import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import dov.com.qq.im.ae.download.AEResDownload.1;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class bnkr
{
  private static Map<String, ShortVideoResourceManager.SVConfigItem> a = new ConcurrentHashMap();
  
  public static void a(@NonNull bnkt parambnkt, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bcya parambcya)
  {
    ThreadManager.excute(new AEResDownload.1(parambnkt, paramList, parambcya), 128, null, false);
  }
  
  private static void c(@NonNull bnkt parambnkt, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bcya parambcya)
  {
    int i;
    Object localObject;
    if ((llq.d()) && (Build.VERSION.SDK_INT >= 15))
    {
      bnrh.b("AEResDownload", "support isNeon");
      i = 0;
      if (i >= paramList.size()) {
        break label480;
      }
      localObject = (ShortVideoResourceManager.SVConfigItem)paramList.get(i);
      if ((!((ShortVideoResourceManager.SVConfigItem)localObject).name.startsWith(parambnkt.b)) || (((ShortVideoResourceManager.SVConfigItem)localObject).versionCode != parambnkt.c)) {
        break label116;
      }
    }
    label217:
    label480:
    for (paramList = (List<ShortVideoResourceManager.SVConfigItem>)localObject;; paramList = null)
    {
      if (paramList == null)
      {
        bnrh.d("AEResDownload", "[realDownloadResource EROOR]");
        parambcya.onDownloadFinish("", -101, null);
        return;
        bnrh.d("AEResDownload", "Neon is not Support");
        parambcya.onDownloadFinish("", -1, null);
        return;
        label116:
        i += 1;
        break;
      }
      i = bnky.a(parambnkt.a);
      if (i >= Integer.valueOf(paramList.name.substring(parambnkt.b.length())).intValue())
      {
        if (TextUtils.isEmpty(bnky.a(parambnkt))) {
          bnrh.d("AEResDownload", "[realDownloadResourceInternal] local exist but finalPath is null");
        }
      }
      else
      {
        localObject = new HttpNetReq();
        ((HttpNetReq)localObject).mCallback = new bnks(parambcya, parambnkt);
        if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!paramList.check64BitReady())) {
          break label413;
        }
        ((HttpNetReq)localObject).mReqUrl = paramList.arm64v8a_url;
        ((HttpNetReq)localObject).mHttpMethod = 0;
        ((HttpNetReq)localObject).mOutPath = (bnky.c() + paramList.name);
        ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        ((HttpNetReq)localObject).bAcceptNegativeContentLength = true;
        ((HttpNetReq)localObject).setUserData(paramList.name);
        parambnkt = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (parambnkt != null) {
          break label425;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          bnrh.d("AEResDownload", "[realDownloadResourceInternal] need new DownLoadEngine");
          parambnkt = new HttpCommunicator(parambnkt, 4);
          parambnkt.start();
          new OldHttpEngine(parambnkt, false).sendReq((NetReq)localObject);
        }
        a.put(paramList.name, paramList);
        return;
        if (TextUtils.isEmpty(bnky.b(parambnkt)))
        {
          bnrh.d("AEResDownload", "[realDownloadResourceInternal] local exist but unzipPath is null");
          break;
        }
        bnrh.d("AEResDownload", "[realDownloadResource info] local exist");
        parambcya.onDownloadFinish(paramList.name, 1, bnky.a(parambnkt.b + i));
        return;
        ((HttpNetReq)localObject).mReqUrl = paramList.armv7a_url;
        break label217;
        if (!parambnkt.isLogin())
        {
          i = 1;
        }
        else if (parambnkt.getManager(QQManagerFactory.MGR_NET_ENGINE) == null)
        {
          i = 1;
        }
        else
        {
          parambcya = parambnkt.getNetEngine(0);
          if (parambcya == null)
          {
            i = 1;
          }
          else
          {
            parambcya.sendReq((NetReq)localObject);
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkr
 * JD-Core Version:    0.7.0.1
 */