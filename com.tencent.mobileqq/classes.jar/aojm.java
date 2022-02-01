import android.text.TextUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class aojm
  implements INetEngine.INetEngineListener
{
  aojm(aojl paramaojl, aojp paramaojp, aojo paramaojo) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3)
    {
      QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((HttpNetReq)paramNetResp.mReq).mReqUrl);
      return;
    }
    synchronized (aojl.a(this.jdField_a_of_type_Aojl))
    {
      int i;
      if (aojl.a(this.jdField_a_of_type_Aojl) != null)
      {
        i = 0;
        if (i < aojl.a(this.jdField_a_of_type_Aojl).size())
        {
          if (!((aojp)aojl.a(this.jdField_a_of_type_Aojl).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Aojp.jdField_a_of_type_JavaLangString)) {
            break label268;
          }
          aojl.a(this.jdField_a_of_type_Aojl).remove(i);
        }
      }
      if (paramNetResp.mResult == 0)
      {
        ??? = new File(((HttpNetReq)paramNetResp.mReq).mOutPath);
        String str = ayja.a(((File)???).getAbsolutePath());
        if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Aojp.b))) && (this.jdField_a_of_type_Aojp.jdField_a_of_type_Int != 1))
        {
          QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((HttpNetReq)paramNetResp.mReq).mReqUrl + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
          this.jdField_a_of_type_Aojo.a(false, this.jdField_a_of_type_Aojp);
          return;
          label268:
          i += 1;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Aojo.a(bool, this.jdField_a_of_type_Aojp);
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((HttpNetReq)paramNetReq).mReqUrl + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    this.jdField_a_of_type_Aojo.a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojm
 * JD-Core Version:    0.7.0.1
 */