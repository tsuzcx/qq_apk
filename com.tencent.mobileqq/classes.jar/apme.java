import android.text.TextUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class apme
  implements HttpEngineTask.IHttpEngineTask
{
  apme(apmd paramapmd, apmj paramapmj) {}
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {
      QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((HttpNetReq)paramNetResp.mReq).mReqUrl);
    }
    for (;;)
    {
      return;
      int i;
      synchronized (apmd.a(this.jdField_a_of_type_Apmd))
      {
        if (apmd.a(this.jdField_a_of_type_Apmd) != null)
        {
          i = 0;
          label67:
          if (i < apmd.a(this.jdField_a_of_type_Apmd).size())
          {
            if (!((apmj)apmd.a(this.jdField_a_of_type_Apmd).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Apmj.jdField_a_of_type_JavaLangString)) {
              break label342;
            }
            apmd.a(this.jdField_a_of_type_Apmd).remove(i);
          }
        }
      }
      synchronized (apmd.a(this.jdField_a_of_type_Apmd))
      {
        ??? = (apmi)apmd.a(this.jdField_a_of_type_Apmd).get(this.jdField_a_of_type_Apmj.b);
        if (paramNetResp.mResult == 0)
        {
          if (apmd.a(this.jdField_a_of_type_Apmd) != null) {
            apmd.a(this.jdField_a_of_type_Apmd).preDownloadSuccess(this.jdField_a_of_type_Apmj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apmj.jdField_a_of_type_Long);
          }
          ??? = new File(((HttpNetReq)paramNetResp.mReq).mOutPath);
          String str = aznv.a(((File)???).getAbsolutePath());
          if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Apmj.b))) && (this.jdField_a_of_type_Apmj.jdField_a_of_type_Int != 1))
          {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((HttpNetReq)paramNetResp.mReq).mReqUrl + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
            if (??? == null) {
              continue;
            }
            ((apmi)???).a(false, this.jdField_a_of_type_Apmj);
            return;
            label342:
            i += 1;
            break label67;
            paramNetResp = finally;
            throw paramNetResp;
          }
        }
      }
      for (boolean bool = true; ??? != null; bool = false)
      {
        ((apmi)???).a(bool, this.jdField_a_of_type_Apmj);
        return;
        if (apmd.a(this.jdField_a_of_type_Apmd) != null) {
          apmd.a(this.jdField_a_of_type_Apmd).preDownloadSuccess(this.jdField_a_of_type_Apmj.jdField_a_of_type_JavaLangString, -1L);
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((HttpNetReq)???).mReqUrl + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    synchronized (apmd.a(this.jdField_a_of_type_Apmd))
    {
      apmi localapmi = (apmi)apmd.a(this.jdField_a_of_type_Apmd).get(this.jdField_a_of_type_Apmj.b);
      if (localapmi != null) {
        localapmi.a(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apme
 * JD-Core Version:    0.7.0.1
 */