package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class AEResDownload$2
  implements INetEngineListener
{
  AEResDownload$2(ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, AEResInfo paramAEResInfo) {}
  
  public void onResp(NetResp paramNetResp)
  {
    AEQLog.b("AEResDownload", "[onResp] start");
    NetReq localNetReq = paramNetResp.mReq;
    String str2 = (String)localNetReq.getUserData();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onResp] key:");
    ((StringBuilder)localObject1).append(str2);
    AEQLog.b("AEResDownload", ((StringBuilder)localObject1).toString());
    int i = -1;
    String str1 = "";
    if (str2 == null)
    {
      AEQLog.d("AEResDownload", "[onResp] key=null ");
      this.a.onDownloadFinish("", -1, "");
      return;
    }
    localObject1 = str1;
    label345:
    boolean bool;
    try
    {
      StringBuilder localStringBuilder1;
      if (paramNetResp.mResult == 0)
      {
        localObject1 = str1;
        AEQLog.b("AEResDownload", "[onResp] NetResp.ResultOk");
        localObject1 = str1;
        Object localObject3 = (ShortVideoResourceManager.SVConfigItem)AEResDownload.a().get(str2);
        localObject1 = str1;
        Object localObject4 = localNetReq.mOutPath;
        localObject1 = str1;
        Object localObject2 = new StringBuilder();
        localObject1 = str1;
        ((StringBuilder)localObject2).append("[onResp]filePath=");
        localObject1 = str1;
        ((StringBuilder)localObject2).append((String)localObject4);
        localObject1 = str1;
        ((StringBuilder)localObject2).append(",resp.mResult=");
        localObject1 = str1;
        ((StringBuilder)localObject2).append(paramNetResp.mResult);
        localObject1 = str1;
        ((StringBuilder)localObject2).append(",mHttpCode=");
        localObject1 = str1;
        ((StringBuilder)localObject2).append(paramNetResp.mHttpCode);
        localObject1 = str1;
        ((StringBuilder)localObject2).append(",mErrCode=");
        localObject1 = str1;
        ((StringBuilder)localObject2).append(paramNetResp.mErrCode);
        localObject1 = str1;
        ((StringBuilder)localObject2).append(",mErrDesc=");
        localObject1 = str1;
        ((StringBuilder)localObject2).append(paramNetResp.mErrDesc);
        localObject1 = str1;
        AEQLog.b("AEResDownload", ((StringBuilder)localObject2).toString());
        localObject1 = str1;
        if (VideoEnvironment64BitUtils.checkIs64bit())
        {
          localObject1 = str1;
          if (((ShortVideoResourceManager.SVConfigItem)localObject3).check64BitReady())
          {
            localObject1 = str1;
            localObject2 = ((ShortVideoResourceManager.SVConfigItem)localObject3).arm64v8a_md5;
            break label345;
          }
        }
        localObject1 = str1;
        localObject2 = ((ShortVideoResourceManager.SVConfigItem)localObject3).armv7a_md5;
        localObject1 = str1;
        int j = AEResUtil.a(str2, (String)localObject2, (String)localObject4);
        if (j == 0)
        {
          localObject1 = str1;
          AEQLog.b("AEResDownload", "[onResp] verifyResource:success=");
          localObject1 = str1;
          str1 = AEResUtil.a((String)localNetReq.getUserData());
          localObject1 = str1;
          if (FileUtils.rename((String)localObject4, str1))
          {
            localObject1 = str1;
            localObject3 = ((ShortVideoResourceManager.SVConfigItem)localObject3).name.substring(this.b.resPrefix.length());
            localObject1 = str1;
            localObject4 = new StringBuilder();
            localObject1 = str1;
            ((StringBuilder)localObject4).append((String)localObject2);
            localObject1 = str1;
            ((StringBuilder)localObject4).append('_');
            localObject1 = str1;
            ((StringBuilder)localObject4).append((String)localObject3);
            localObject1 = str1;
            localObject2 = ((StringBuilder)localObject4).toString();
            localObject1 = str1;
            localObject4 = AEResUtil.b();
            localObject1 = str1;
            Object localObject5 = new StringBuilder();
            localObject1 = str1;
            ((StringBuilder)localObject5).append((String)localObject4);
            localObject1 = str1;
            ((StringBuilder)localObject5).append((String)localObject2);
            localObject1 = str1;
            ((StringBuilder)localObject5).append(File.separator);
            localObject1 = str1;
            localObject4 = ((StringBuilder)localObject5).toString();
            localObject1 = str1;
            localObject5 = new File((String)localObject4);
            localObject1 = str1;
            bool = ((File)localObject5).mkdirs();
            localObject1 = str1;
            StringBuilder localStringBuilder2 = new StringBuilder();
            localObject1 = str1;
            localStringBuilder2.append("[onResp] unzipFile:[exists]mkOK=");
            localObject1 = str1;
            localStringBuilder2.append(bool);
            localObject1 = str1;
            AEQLog.b("AEResDownload", localStringBuilder2.toString());
            localObject1 = str1;
            bool = ((File)localObject5).exists();
            j = -118;
            if (!bool)
            {
              localObject1 = str1;
              AEQLog.d("AEResDownload", "[onResp] unzipFile.exists=false[error]");
              localObject1 = str1;
              this.a.onDownloadFinish(str2, -118, str1);
              return;
            }
            localObject1 = str1;
            try
            {
              FileUtils.uncompressZip(str1, (String)localObject4, false);
              localObject1 = str1;
              bool = AEResUtil.a((String)localObject3, (String)localObject4);
              localObject1 = str1;
              localObject4 = new StringBuilder();
              localObject1 = str1;
              ((StringBuilder)localObject4).append("[onResp]  copyResFileToFinalDir copyOK=");
              localObject1 = str1;
              ((StringBuilder)localObject4).append(bool);
              localObject1 = str1;
              AEQLog.b("AEResDownload", ((StringBuilder)localObject4).toString());
              if (bool)
              {
                localObject1 = str1;
                if (AEResUtil.b((String)localObject3))
                {
                  localObject1 = str1;
                  if (AEResUtil.a((String)localObject2, this.b))
                  {
                    localObject1 = str1;
                    AEQLog.d("AEResDownload", "[onResp] copyResFileToFinalDir.SUCCESS");
                    i = 0;
                  }
                  else
                  {
                    localObject1 = str1;
                    AEQLog.d("AEResDownload", "[onResp] storeNewPendantUnzipPath.error");
                    localObject1 = str1;
                    FileUtils.deleteFile(localNetReq.mOutPath);
                    localObject1 = str1;
                    FileUtils.deleteFile(str1);
                    i = j;
                  }
                }
                else
                {
                  localObject1 = str1;
                  AEQLog.d("AEResDownload", "[onResp] saveAEResUnzipFinalPath.error");
                  localObject1 = str1;
                  FileUtils.deleteFile(localNetReq.mOutPath);
                  localObject1 = str1;
                  FileUtils.deleteFile(str1);
                  i = j;
                }
              }
              else
              {
                localObject1 = str1;
                AEQLog.d("AEResDownload", "[onResp] storeUnzipFinalPath.error");
                localObject1 = str1;
                FileUtils.deleteFile(localNetReq.mOutPath);
                localObject1 = str1;
                FileUtils.deleteFile(str1);
                i = j;
              }
            }
            catch (IOException localIOException)
            {
              localObject1 = str1;
              AEQLog.a("AEResDownload", "[onResp] unzip.error:", localIOException);
              localObject1 = str1;
              FileUtils.deleteFile(localNetReq.mOutPath);
              localObject1 = str1;
              FileUtils.deleteFile(str1);
              i = j;
            }
          }
          else
          {
            localObject1 = str1;
            AEQLog.d("AEResDownload", "[onResp] ShortVideoResourceStatus.RES_RENAME_VERIFY_ERROR");
            localObject1 = str1;
            FileUtils.deleteFile(localNetReq.mOutPath);
            localObject1 = str1;
            FileUtils.deleteFile(str1);
            i = -3;
            localObject1 = str1;
            break label1308;
          }
        }
        else
        {
          localObject1 = str1;
          localStringBuilder1 = new StringBuilder();
          localObject1 = str1;
          localStringBuilder1.append("[onResp] verifyResource.error:");
          localObject1 = str1;
          localStringBuilder1.append(j);
          localObject1 = str1;
          AEQLog.d("AEResDownload", localStringBuilder1.toString());
          localObject1 = str1;
          FileUtils.deleteFile(localNetReq.mOutPath);
          localObject1 = str1;
          i = j;
          break label1308;
        }
      }
      else
      {
        localObject1 = str1;
        localStringBuilder1 = new StringBuilder();
        localObject1 = str1;
        localStringBuilder1.append("[onResp] download.error:");
        localObject1 = str1;
        localStringBuilder1.append(paramNetResp.mResult);
        localObject1 = str1;
        AEQLog.d("AEResDownload", localStringBuilder1.toString());
        localObject1 = str1;
        FileUtils.deleteFile(localNetReq.mOutPath);
        i = -117;
        localObject1 = str1;
      }
    }
    catch (SecurityException localSecurityException)
    {
      AEQLog.a("AEResDownload", "[SecurityException]", localSecurityException);
    }
    label1308:
    for (;;)
    {
      IPreDownloadController localIPreDownloadController;
      try
      {
        if (this.b.isPredownload)
        {
          localIPreDownloadController = (IPreDownloadController)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getRuntimeService(IPreDownloadController.class);
          if (localIPreDownloadController != null)
          {
            bool = localIPreDownloadController.isEnable();
            if (bool) {
              if (i == 0) {
                localIPreDownloadController.preDownloadSuccess((String)paramNetResp.mRespProperties.get("param_url"), paramNetResp.mTotalFileLen);
              } else {
                localIPreDownloadController.preDownloadSuccess((String)paramNetResp.mRespProperties.get("param_url"), -1L);
              }
            }
          }
        }
      }
      catch (Throwable paramNetResp)
      {
        AEQLog.a("AEResDownload", "[onResp] isPredownload callback ERROR", paramNetResp);
      }
      this.a.onDownloadFinish(str2, i, (String)localObject1);
      return;
      localObject1 = localIPreDownloadController;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (String)paramNetReq.getUserData();
    if (paramNetReq == null)
    {
      AEQLog.d("AEResDownload", "[onUpdateProgeress] key = null");
      return;
    }
    this.a.onUpdateProgress(paramNetReq, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEResDownload.2
 * JD-Core Version:    0.7.0.1
 */