import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
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
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class blvl
{
  private static Map<String, ShortVideoResourceManager.SVConfigItem> a = new ConcurrentHashMap();
  
  public static void a(@NonNull AEResInfo paramAEResInfo, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bbrg parambbrg)
  {
    ThreadManager.excute(new AEResDownload.1(paramAEResInfo, paramList, parambbrg), 128, null, false);
  }
  
  private static void c(@NonNull AEResInfo paramAEResInfo, @NonNull List<ShortVideoResourceManager.SVConfigItem> paramList, @NonNull bbrg parambbrg)
  {
    int i;
    Object localObject;
    if ((lld.d()) && (Build.VERSION.SDK_INT >= 15))
    {
      bmbx.b("AEResDownload", "support isNeon");
      i = 0;
      if (i >= paramList.size()) {
        break label480;
      }
      localObject = (ShortVideoResourceManager.SVConfigItem)paramList.get(i);
      if ((!((ShortVideoResourceManager.SVConfigItem)localObject).name.startsWith(paramAEResInfo.resPrefix)) || (((ShortVideoResourceManager.SVConfigItem)localObject).versionCode != paramAEResInfo.resVersion)) {
        break label116;
      }
    }
    label217:
    label480:
    for (paramList = (List<ShortVideoResourceManager.SVConfigItem>)localObject;; paramList = null)
    {
      if (paramList == null)
      {
        bmbx.d("AEResDownload", "[realDownloadResource EROOR]");
        parambbrg.onDownloadFinish("", -101, null);
        return;
        bmbx.d("AEResDownload", "Neon is not Support");
        parambbrg.onDownloadFinish("", -1, null);
        return;
        label116:
        i += 1;
        break;
      }
      i = AEResUtil.getDownloadPackageVersion(paramAEResInfo.index);
      if (i >= Integer.valueOf(paramList.name.substring(paramAEResInfo.resPrefix.length())).intValue())
      {
        if (TextUtils.isEmpty(AEResUtil.getUnzippedPackageDir(paramAEResInfo))) {
          bmbx.d("AEResDownload", "[realDownloadResourceInternal] local exist but finalPath is null");
        }
      }
      else
      {
        localObject = new HttpNetReq();
        ((HttpNetReq)localObject).mCallback = new blvm(parambbrg, paramAEResInfo);
        if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!paramList.check64BitReady())) {
          break label414;
        }
        ((HttpNetReq)localObject).mReqUrl = paramList.arm64v8a_url;
        ((HttpNetReq)localObject).mHttpMethod = 0;
        ((HttpNetReq)localObject).mOutPath = (AEResUtil.getDownloadTmpPath() + paramList.name);
        ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        ((HttpNetReq)localObject).bAcceptNegativeContentLength = true;
        ((HttpNetReq)localObject).setUserData(paramList.name);
        paramAEResInfo = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramAEResInfo != null) {
          break label426;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          bmbx.d("AEResDownload", "[realDownloadResourceInternal] need new DownLoadEngine");
          paramAEResInfo = new HttpCommunicator(paramAEResInfo, 4);
          paramAEResInfo.start();
          new OldHttpEngine(paramAEResInfo, false).sendReq((NetReq)localObject);
        }
        a.put(paramList.name, paramList);
        return;
        if (TextUtils.isEmpty(AEResUtil.getAEResPath(paramAEResInfo)))
        {
          bmbx.d("AEResDownload", "[realDownloadResourceInternal] local exist but unzipPath is null");
          break;
        }
        bmbx.d("AEResDownload", "[realDownloadResource info] local exist");
        parambbrg.onDownloadFinish(paramList.name, 1, AEResUtil.getZipFilePath(paramAEResInfo.resPrefix + i));
        return;
        ((HttpNetReq)localObject).mReqUrl = paramList.armv7a_url;
        break label217;
        if (!paramAEResInfo.isLogin())
        {
          i = 1;
        }
        else if (paramAEResInfo.getManager(21) == null)
        {
          i = 1;
        }
        else
        {
          parambbrg = paramAEResInfo.getNetEngine(0);
          if (parambbrg == null)
          {
            i = 1;
          }
          else
          {
            parambbrg.sendReq((NetReq)localObject);
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvl
 * JD-Core Version:    0.7.0.1
 */