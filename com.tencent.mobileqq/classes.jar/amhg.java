import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class amhg
{
  amhe jdField_a_of_type_Amhe = null;
  amhi jdField_a_of_type_Amhi;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(amhe paramamhe, int paramInt)
  {
    String str1;
    if (!amhf.b(paramamhe))
    {
      String str2 = paramamhe.a;
      str1 = paramamhe.b;
      String str3 = amhf.a(paramamhe);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new amhh(this, str1, paramamhe);
      localHttpNetReq.setUserData(str1);
      localHttpNetReq.mReqUrl = str2;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(str3).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      paramamhe = alvx.a().getNetEngine(0);
      if (paramamhe == null) {
        break label206;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
      paramamhe.sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Amhi != null)) {
        this.jdField_a_of_type_Amhi.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Amhi != null) {
        this.jdField_a_of_type_Amhi.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(amhe paramamhe, amhi paramamhi)
  {
    this.jdField_a_of_type_Amhi = paramamhi;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Amhe == paramamhe) || (TextUtils.isEmpty(paramamhe.b)) || (paramamhe.b.equals(this.jdField_a_of_type_Amhe.b))) {
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
          paramamhi = alvx.a().getNetEngine(0);
          if (paramamhi != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.getUserData() }));
            paramamhi.cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
          }
        }
        this.jdField_a_of_type_Amhe = paramamhe;
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Amhe }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Amhe, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhg
 * JD-Core Version:    0.7.0.1
 */