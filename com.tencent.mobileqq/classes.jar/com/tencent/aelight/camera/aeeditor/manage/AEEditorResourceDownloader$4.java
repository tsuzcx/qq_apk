package com.tencent.aelight.camera.aeeditor.manage;

import com.tencent.aelight.camera.ae.util.AEDownloader.DownloadListener;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;

class AEEditorResourceDownloader$4
  implements AEDownloader.DownloadListener
{
  AEEditorResourceDownloader$4(AEEditorResourceDownloader paramAEEditorResourceDownloader, AEEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener, String paramString1, AEEditorDownloadResBean paramAEEditorDownloadResBean, String paramString2, String paramString3) {}
  
  public void a(int paramInt)
  {
    AEEditorResourceDownloader.ResDownLoadListener localResDownLoadListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader$ResDownLoadListener;
    if (localResDownLoadListener != null) {
      localResDownLoadListener.a(paramInt);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool3 = false;
    if (paramNetResp == null)
    {
      paramNetResp = this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader$ResDownLoadListener;
      if (paramNetResp != null) {
        paramNetResp.a(false);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader.a(this.jdField_a_of_type_JavaLangString, false);
      return;
    }
    boolean bool1;
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    String str = this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader.c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downLoadOneResInternal-onDownloadFinish---isSuccess=");
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append(", id=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorDownloadResBean.getId());
    AEQLog.b(str, ((StringBuilder)localObject2).toString());
    boolean bool2 = bool3;
    if (bool1)
    {
      str = FileUtils.calcMd5(this.b);
      if ((str != null) && (str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)))
      {
        try
        {
          bool2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader.a(this.b, this.c, this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorDownloadResBean.getId(), this.jdField_a_of_type_JavaLangString);
        }
        catch (Exception localException)
        {
          localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("downLoadOneResInternal-onDownloadFinish---unZipFile failed, id=");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorDownloadResBean.getId());
          AEQLog.a((String)localObject2, localStringBuilder.toString(), localException);
          localException.printStackTrace();
          bool2 = bool3;
        }
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downLoadOneResInternal-onDownloadFinish---MD5 check failed, id=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorDownloadResBean.getId());
        AEQLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
        bool2 = bool3;
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader.a(bool1, paramNetResp.mErrCode, paramNetResp.reqCost, this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorDownloadResBean.getId());
    if (!bool2) {
      FileUtils.deleteDirectory(this.c);
    }
    FileUtils.deleteFile(this.b);
    paramNetResp = this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader.c;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("downLoadOneResInternal-onDownloadFinish---REAL result=");
    ((StringBuilder)localObject1).append(bool2);
    ((StringBuilder)localObject1).append(", id=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAelightCameraAeeditorDataAEEditorDownloadResBean.getId());
    AEQLog.b(paramNetResp, ((StringBuilder)localObject1).toString());
    paramNetResp = this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader$ResDownLoadListener;
    if (paramNetResp != null) {
      paramNetResp.a(bool2);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorResourceDownloader.a(this.jdField_a_of_type_JavaLangString, bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */