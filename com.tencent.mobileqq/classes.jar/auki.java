import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class auki
  implements INetEngine.INetEngineListener
{
  auki(auke paramauke, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3)
    {
      QLog.d("qqidentification_server", 2, "identification res download repeating ");
      return;
    }
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = paramNetResp.mReq.mOutPath;
      String str = FileUtils.calcMd5(paramNetResp);
      if ((str == null) || (!str.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      try
      {
        FileUtils.uncompressZip(paramNetResp, this.b, false);
        QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but unzip is failed");
      }
      catch (IOException localIOException1)
      {
        try
        {
          auke.a(this.jdField_a_of_type_Auke).destroy();
          auke.a(this.jdField_a_of_type_Auke, null);
          bool = true;
          FileUtils.deleteFile(paramNetResp);
          if (QLog.isColorLevel()) {
            QLog.d("qqidentification_server", 2, "downloadRes.onResp download path : " + this.b);
          }
          QLog.d("qqidentification_server", 1, new Object[] { "download face res success : ", Boolean.valueOf(bool) });
          if (bool)
          {
            bfyz.c(this.b);
            bfyz.b(this.jdField_a_of_type_Int);
            bfyz.c(aukc.b());
          }
          auke.a(this.jdField_a_of_type_Auke, 1, bool);
          return;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            boolean bool = true;
          }
        }
        localIOException1 = localIOException1;
        bool = false;
      }
      continue;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but md5 is mismatched ");
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "downloadRes.onResp download succ but md5 is mismatched,fileSize = " + FileUtils.getFileSizes(paramNetResp) + ",md5 = " + localIOException1 + ",url = " + this.c);
      }
      bool = false;
      continue;
      QLog.d("qqidentification_server", 1, new Object[] { "downloadRes.onResp failed  isSuccess is false, code is : ", Integer.valueOf(paramNetResp.mErrCode), " msg : ", paramNetResp.mErrDesc });
      bool = false;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auki
 * JD-Core Version:    0.7.0.1
 */