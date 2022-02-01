import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class anio
{
  anim jdField_a_of_type_Anim = null;
  aniq jdField_a_of_type_Aniq;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(anim paramanim, int paramInt)
  {
    String str1;
    if (!anin.b(paramanim))
    {
      String str2 = paramanim.a;
      str1 = paramanim.b;
      String str3 = anin.a(paramanim);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new anip(this, str1, paramanim);
      localHttpNetReq.setUserData(str1);
      localHttpNetReq.mReqUrl = str2;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(str3).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      paramanim = amwn.a().getNetEngine(0);
      if (paramanim == null) {
        break label206;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
      paramanim.sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Aniq != null)) {
        this.jdField_a_of_type_Aniq.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Aniq != null) {
        this.jdField_a_of_type_Aniq.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(anim paramanim, aniq paramaniq)
  {
    this.jdField_a_of_type_Aniq = paramaniq;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Anim == paramanim) || (TextUtils.isEmpty(paramanim.b)) || (paramanim.b.equals(this.jdField_a_of_type_Anim.b))) {
        break label214;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
      }
      if (!bool)
      {
        return this.jdField_a_of_type_Boolean;
        bool = true;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null)
        {
          paramaniq = amwn.a().getNetEngine(0);
          if (paramaniq != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.getUserData() }));
            paramaniq.cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
          }
        }
        this.jdField_a_of_type_Anim = paramanim;
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Anim }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Anim, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anio
 * JD-Core Version:    0.7.0.1
 */