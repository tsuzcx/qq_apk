import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bdac
  implements INetEngine.INetEngineListener
{
  bdac(bdab parambdab, String paramString, DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    if (this.jdField_a_of_type_Bdab.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq) {
      this.jdField_a_of_type_Bdab.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.mReqUrl, Integer.valueOf(paramNetResp.mResult), Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (paramNetResp.exists())
      {
        try
        {
          String str = paramNetResp.getParent();
          FileUtils.uncompressZip(localHttpNetReq.mOutPath, str, false);
          bdaa.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          bdaa.a(-1);
          this.jdField_a_of_type_Bdab.jdField_a_of_type_Boolean = false;
          return;
        }
        paramNetResp.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        bdaa.a(100 / this.jdField_a_of_type_Bdab.jdField_a_of_type_Int + this.jdField_a_of_type_Bdab.b);
        paramNetResp = this.jdField_a_of_type_Bdab;
        paramNetResp.b += 100 / this.jdField_a_of_type_Bdab.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Bdab.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Bdab.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      bdaa.a(i / this.jdField_a_of_type_Bdab.jdField_a_of_type_Int + this.jdField_a_of_type_Bdab.b);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdac
 * JD-Core Version:    0.7.0.1
 */