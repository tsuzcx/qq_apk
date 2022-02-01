import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class axmi
  implements HttpEngineTask.IHttpEngineTask
{
  axmi(axmf paramaxmf, String paramString, String[] paramArrayOfString, axmk paramaxmk) {}
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramHttpEngineTask.httpReq.mReqUrl }));
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    String str = ((HttpNetReq)paramNetResp.mReq).mReqUrl;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(paramNetResp.mResult) }));
    }
    switch (paramNetResp.mResult)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_Axmf.a == null) {
        break;
      }
    }
    for (Object localObject = (PreDownloadController)this.jdField_a_of_type_Axmf.a.get();; localObject = null)
    {
      if (localObject != null) {
        ((PreDownloadController)localObject).preDownloadSuccess(str, paramNetResp.mTotalFileLen);
      }
      paramNetResp = (HttpNetReq)paramNetResp.mReq;
      if (axmf.a(paramNetResp.mOutPath, this.jdField_a_of_type_JavaLangString))
      {
        localObject = new File(axmf.a(this.jdField_a_of_type_JavaLangString));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool1 = axmf.b(paramNetResp.mOutPath, axmf.a(this.jdField_a_of_type_JavaLangString));
        boolean bool2 = axmf.b(str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfJavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        axmf.a(this.jdField_a_of_type_Axmf, str, this.jdField_a_of_type_JavaLangString, bool2, this.jdField_a_of_type_Axmk);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
      }
      axmf.a(paramNetResp.mOutPath);
      axmf.a(this.jdField_a_of_type_Axmf, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Axmk);
      return;
      if (this.jdField_a_of_type_Axmf.a != null) {}
      for (paramNetResp = (PreDownloadController)this.jdField_a_of_type_Axmf.a.get();; paramNetResp = null)
      {
        if (paramNetResp != null) {
          paramNetResp.preDownloadSuccess(str, -1L);
        }
        axmf.a(this.jdField_a_of_type_Axmf, str, this.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_Axmk);
        return;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((HttpNetReq)paramNetReq).mReqUrl, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axmi
 * JD-Core Version:    0.7.0.1
 */