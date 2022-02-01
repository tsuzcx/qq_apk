import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bltl
{
  bltj jdField_a_of_type_Bltj = null;
  bltn jdField_a_of_type_Bltn;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(bltj parambltj, int paramInt)
  {
    String str1;
    if (!bltk.b(parambltj))
    {
      String str2 = parambltj.a;
      str1 = parambltj.b;
      String str3 = bltk.a(parambltj);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new bltm(this, str1, parambltj);
      localHttpNetReq.setUserData(str1);
      localHttpNetReq.mReqUrl = str2;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(str3).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      parambltj = amwn.a().getNetEngine(0);
      if (parambltj == null) {
        break label206;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
      parambltj.sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Bltn != null)) {
        this.jdField_a_of_type_Bltn.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Bltn != null) {
        this.jdField_a_of_type_Bltn.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(bltj parambltj, bltn parambltn)
  {
    this.jdField_a_of_type_Bltn = parambltn;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Bltj == parambltj) || (TextUtils.isEmpty(parambltj.b)) || (parambltj.b.equals(this.jdField_a_of_type_Bltj.b))) {
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
          parambltn = amwn.a().getNetEngine(0);
          if (parambltn != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.getUserData() }));
            parambltn.cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
          }
        }
        this.jdField_a_of_type_Bltj = parambltj;
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Bltj }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Bltj, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltl
 * JD-Core Version:    0.7.0.1
 */