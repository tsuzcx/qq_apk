import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class blvm
  implements INetEngine.INetEngineListener
{
  blvm(bbrg parambbrg, AEResInfo paramAEResInfo) {}
  
  public void onResp(NetResp paramNetResp)
  {
    bmbx.b("AEResDownload", "[onResp] start");
    NetReq localNetReq = paramNetResp.mReq;
    String str3 = (String)localNetReq.getUserData();
    bmbx.b("AEResDownload", "[onResp] key:" + str3);
    if (str3 == null)
    {
      bmbx.d("AEResDownload", "[onResp] key=null ");
      this.jdField_a_of_type_Bbrg.onDownloadFinish("", -1, "");
      return;
    }
    try
    {
      if (paramNetResp.mResult != 0) {
        break label774;
      }
      bmbx.b("AEResDownload", "[onResp] NetResp.ResultOk");
      localObject2 = (ShortVideoResourceManager.SVConfigItem)blvl.a().get(str3);
      str4 = localNetReq.mOutPath;
      bmbx.b("AEResDownload", "[onResp]filePath=" + str4 + ",resp.mResult=" + paramNetResp.mResult + ",mHttpCode=" + paramNetResp.mHttpCode + ",mErrCode=" + paramNetResp.mErrCode + ",mErrDesc=" + paramNetResp.mErrDesc);
      if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!((ShortVideoResourceManager.SVConfigItem)localObject2).check64BitReady())) {
        break label497;
      }
      String str2 = ((ShortVideoResourceManager.SVConfigItem)localObject2).arm64v8a_md5;
      i = AEResUtil.verifyResource(str3, str2, str4);
      if (i != 0) {
        break label733;
      }
      bmbx.b("AEResDownload", "[onResp] verifyResource:success=");
      str1 = AEResUtil.getZipFilePath((String)localNetReq.getUserData());
      try
      {
        if (!FileUtils.rename(str4, str1)) {
          break label704;
        }
        localObject2 = ((ShortVideoResourceManager.SVConfigItem)localObject2).name.substring(this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo.resPrefix.length());
        str2 = str2 + '_' + (String)localObject2;
        str4 = AEResUtil.getUnzipFilePathBase();
        str4 = str4 + str2 + File.separator;
        File localFile = new File(str4);
        bool = localFile.mkdirs();
        bmbx.b("AEResDownload", "[onResp] unzipFile:[exists]mkOK=" + bool);
        if (localFile.exists()) {
          break label507;
        }
        bmbx.d("AEResDownload", "[onResp] unzipFile.exists=false[error]");
        this.jdField_a_of_type_Bbrg.onDownloadFinish(str3, -118, str1);
        return;
      }
      catch (SecurityException localSecurityException1) {}
    }
    catch (SecurityException localSecurityException2)
    {
      for (;;)
      {
        Object localObject2;
        String str4;
        int i;
        boolean bool;
        String str1 = "";
      }
    }
    bmbx.a("AEResDownload", "[SecurityException]", localSecurityException1);
    i = -1;
    for (;;)
    {
      label774:
      try
      {
        if (this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo.isPredownload)
        {
          localObject1 = (PreDownloadController)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(193);
          if ((localObject1 != null) && (((PreDownloadController)localObject1).isEnable()))
          {
            if (i != 0) {
              continue;
            }
            ((PreDownloadController)localObject1).preDownloadSuccess((String)paramNetResp.mRespProperties.get("param_url"), paramNetResp.mTotalFileLen);
          }
        }
      }
      catch (Throwable paramNetResp)
      {
        Object localObject1;
        label497:
        label507:
        bmbx.a("AEResDownload", "[onResp] isPredownload callback ERROR", paramNetResp);
        label704:
        label733:
        continue;
      }
      this.jdField_a_of_type_Bbrg.onDownloadFinish(str3, i, str1);
      return;
      localObject1 = ((ShortVideoResourceManager.SVConfigItem)localObject2).armv7a_md5;
      break;
      try
      {
        FileUtils.uncompressZip(str1, str4, false);
        bool = AEResUtil.copyAEResFileToFinalDir((String)localObject2, str4);
        bmbx.b("AEResDownload", "[onResp]  copyResFileToFinalDir copyOK=" + bool);
        if (!bool) {
          continue;
        }
        if (AEResUtil.saveAEResUnzipFinalPath((String)localObject2)) {
          if (AEResUtil.saveAEResUnzipPath((String)localObject1, this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo))
          {
            bmbx.d("AEResDownload", "[onResp] copyResFileToFinalDir.SUCCESS");
            i = 0;
          }
          else
          {
            bmbx.d("AEResDownload", "[onResp] storeNewPendantUnzipPath.error");
            i = -118;
            FileUtils.deleteFile(localNetReq.mOutPath);
            FileUtils.deleteFile(str1);
          }
        }
      }
      catch (IOException localIOException)
      {
        bmbx.a("AEResDownload", "[onResp] unzip.error:", localIOException);
        i = -118;
        FileUtils.deleteFile(localNetReq.mOutPath);
        FileUtils.deleteFile(str1);
      }
      bmbx.d("AEResDownload", "[onResp] saveAEResUnzipFinalPath.error");
      i = -118;
      FileUtils.deleteFile(localNetReq.mOutPath);
      FileUtils.deleteFile(str1);
      break label866;
      bmbx.d("AEResDownload", "[onResp] storeUnzipFinalPath.error");
      i = -118;
      FileUtils.deleteFile(localNetReq.mOutPath);
      FileUtils.deleteFile(str1);
      break label866;
      i = -3;
      bmbx.d("AEResDownload", "[onResp] ShortVideoResourceStatus.RES_RENAME_VERIFY_ERROR");
      FileUtils.deleteFile(localNetReq.mOutPath);
      FileUtils.deleteFile(str1);
      break label866;
      bmbx.d("AEResDownload", "[onResp] verifyResource.error:" + i);
      FileUtils.deleteFile(localNetReq.mOutPath);
      str1 = "";
      break label866;
      bmbx.d("AEResDownload", "[onResp] download.error:" + paramNetResp.mResult);
      FileUtils.deleteFile(localNetReq.mOutPath);
      i = -117;
      str1 = "";
      break label866;
      localIOException.preDownloadSuccess((String)paramNetResp.mRespProperties.get("param_url"), -1L);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (String)paramNetReq.getUserData();
    if (paramNetReq == null)
    {
      bmbx.d("AEResDownload", "[onUpdateProgeress] key = null");
      return;
    }
    this.jdField_a_of_type_Bbrg.onUpdateProgress(paramNetReq, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvm
 * JD-Core Version:    0.7.0.1
 */