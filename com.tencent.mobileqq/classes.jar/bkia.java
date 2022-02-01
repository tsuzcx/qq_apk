import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bkia
  implements INetEngine.INetEngineListener
{
  bkia(bkhz parambkhz, String paramString, bkhx parambkhx) {}
  
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    if (this.jdField_a_of_type_Bkhz.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq) {
      this.jdField_a_of_type_Bkhz.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.mReqUrl, Integer.valueOf(paramNetResp.mResult), Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_JavaLangString }));
    }
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (!paramNetResp.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          paramNetResp = paramNetResp.getParent();
          FileUtils.uncompressZip(localHttpNetReq.mOutPath, paramNetResp, false);
          bkhy.a(this.jdField_a_of_type_Bkhx.b);
          i = 1;
          if (i == 0) {
            break;
          }
          if (this.jdField_a_of_type_Bkhz.jdField_a_of_type_Bkib != null)
          {
            this.jdField_a_of_type_Bkhz.jdField_a_of_type_Bkib.a(100);
            this.jdField_a_of_type_Bkhz.jdField_a_of_type_Bkib.a(0, "Download Complete!!!");
          }
          this.jdField_a_of_type_Bkhz.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (Exception paramNetResp)
        {
          paramNetResp.printStackTrace();
        }
        int i = 0;
      }
    } while (this.jdField_a_of_type_Bkhz.jdField_a_of_type_Bkib == null);
    this.jdField_a_of_type_Bkhz.jdField_a_of_type_Bkib.a(2, "");
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bkhz.jdField_a_of_type_Bkib != null) {
        this.jdField_a_of_type_Bkhz.jdField_a_of_type_Bkib.a(i);
      }
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkia
 * JD-Core Version:    0.7.0.1
 */