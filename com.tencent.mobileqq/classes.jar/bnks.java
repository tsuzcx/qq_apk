import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class bnks
  implements INetEngine.INetEngineListener
{
  bnks(bcya parambcya, bnkt parambnkt) {}
  
  public void onResp(NetResp paramNetResp)
  {
    bnrh.b("AEResDownload", "[onResp] start");
    NetReq localNetReq = paramNetResp.mReq;
    String str3 = (String)localNetReq.getUserData();
    bnrh.b("AEResDownload", "[onResp] key:" + str3);
    if (str3 == null)
    {
      bnrh.d("AEResDownload", "[onResp] key=null ");
      this.jdField_a_of_type_Bcya.onDownloadFinish("", -1, "");
      return;
    }
    try
    {
      if (paramNetResp.mResult != 0) {
        break label774;
      }
      bnrh.b("AEResDownload", "[onResp] NetResp.ResultOk");
      localObject2 = (ShortVideoResourceManager.SVConfigItem)bnkr.a().get(str3);
      str4 = localNetReq.mOutPath;
      bnrh.b("AEResDownload", "[onResp]filePath=" + str4 + ",resp.mResult=" + paramNetResp.mResult + ",mHttpCode=" + paramNetResp.mHttpCode + ",mErrCode=" + paramNetResp.mErrCode + ",mErrDesc=" + paramNetResp.mErrDesc);
      if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!((ShortVideoResourceManager.SVConfigItem)localObject2).check64BitReady())) {
        break label497;
      }
      String str2 = ((ShortVideoResourceManager.SVConfigItem)localObject2).arm64v8a_md5;
      i = bnky.a(str3, str2, str4);
      if (i != 0) {
        break label733;
      }
      bnrh.b("AEResDownload", "[onResp] verifyResource:success=");
      str1 = bnky.a((String)localNetReq.getUserData());
      try
      {
        if (!FileUtils.rename(str4, str1)) {
          break label704;
        }
        localObject2 = ((ShortVideoResourceManager.SVConfigItem)localObject2).name.substring(this.jdField_a_of_type_Bnkt.jdField_b_of_type_JavaLangString.length());
        str2 = str2 + '_' + (String)localObject2;
        str4 = bnky.a();
        str4 = str4 + str2 + File.separator;
        File localFile = new File(str4);
        bool = localFile.mkdirs();
        bnrh.b("AEResDownload", "[onResp] unzipFile:[exists]mkOK=" + bool);
        if (localFile.exists()) {
          break label507;
        }
        bnrh.d("AEResDownload", "[onResp] unzipFile.exists=false[error]");
        this.jdField_a_of_type_Bcya.onDownloadFinish(str3, -118, str1);
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
    bnrh.a("AEResDownload", "[SecurityException]", localSecurityException1);
    i = -1;
    for (;;)
    {
      label774:
      try
      {
        if (this.jdField_a_of_type_Bnkt.jdField_b_of_type_Boolean)
        {
          localObject1 = (PreDownloadController)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
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
        bnrh.a("AEResDownload", "[onResp] isPredownload callback ERROR", paramNetResp);
        label704:
        label733:
        continue;
      }
      this.jdField_a_of_type_Bcya.onDownloadFinish(str3, i, str1);
      return;
      localObject1 = ((ShortVideoResourceManager.SVConfigItem)localObject2).armv7a_md5;
      break;
      try
      {
        FileUtils.uncompressZip(str1, str4, false);
        bool = bnky.a((String)localObject2, str4);
        bnrh.b("AEResDownload", "[onResp]  copyResFileToFinalDir copyOK=" + bool);
        if (!bool) {
          continue;
        }
        if (bnky.a((String)localObject2)) {
          if (bnky.a((String)localObject1, this.jdField_a_of_type_Bnkt))
          {
            bnrh.d("AEResDownload", "[onResp] copyResFileToFinalDir.SUCCESS");
            i = 0;
          }
          else
          {
            bnrh.d("AEResDownload", "[onResp] storeNewPendantUnzipPath.error");
            i = -118;
            FileUtils.deleteFile(localNetReq.mOutPath);
            FileUtils.deleteFile(str1);
          }
        }
      }
      catch (IOException localIOException)
      {
        bnrh.a("AEResDownload", "[onResp] unzip.error:", localIOException);
        i = -118;
        FileUtils.deleteFile(localNetReq.mOutPath);
        FileUtils.deleteFile(str1);
      }
      bnrh.d("AEResDownload", "[onResp] saveAEResUnzipFinalPath.error");
      i = -118;
      FileUtils.deleteFile(localNetReq.mOutPath);
      FileUtils.deleteFile(str1);
      break label866;
      bnrh.d("AEResDownload", "[onResp] storeUnzipFinalPath.error");
      i = -118;
      FileUtils.deleteFile(localNetReq.mOutPath);
      FileUtils.deleteFile(str1);
      break label866;
      i = -3;
      bnrh.d("AEResDownload", "[onResp] ShortVideoResourceStatus.RES_RENAME_VERIFY_ERROR");
      FileUtils.deleteFile(localNetReq.mOutPath);
      FileUtils.deleteFile(str1);
      break label866;
      bnrh.d("AEResDownload", "[onResp] verifyResource.error:" + i);
      FileUtils.deleteFile(localNetReq.mOutPath);
      str1 = "";
      break label866;
      bnrh.d("AEResDownload", "[onResp] download.error:" + paramNetResp.mResult);
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
      bnrh.d("AEResDownload", "[onUpdateProgeress] key = null");
      return;
    }
    this.jdField_a_of_type_Bcya.onUpdateProgress(paramNetReq, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnks
 * JD-Core Version:    0.7.0.1
 */