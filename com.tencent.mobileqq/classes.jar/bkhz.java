import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bkhz
{
  bkhx jdField_a_of_type_Bkhx = null;
  bkib jdField_a_of_type_Bkib;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  boolean jdField_a_of_type_Boolean = false;
  
  boolean a(bkhx parambkhx, int paramInt)
  {
    String str1;
    if (!bkhy.b(parambkhx))
    {
      String str2 = parambkhx.a;
      str1 = parambkhx.b;
      String str3 = bkhy.a(parambkhx);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new bkia(this, str1, parambkhx);
      localHttpNetReq.setUserData(str1);
      localHttpNetReq.mReqUrl = str2;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(str3).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      parambkhx = alvx.a().getNetEngine(0);
      if (parambkhx == null) {
        break label206;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
      parambkhx.sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    }
    label206:
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_Bkib != null)) {
        this.jdField_a_of_type_Bkib.a(3, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool) }));
      }
      return bool;
      if (this.jdField_a_of_type_Bkib != null) {
        this.jdField_a_of_type_Bkib.a(0, "So Already Exist!!!");
      }
      return false;
    }
  }
  
  boolean a(bkhx parambkhx, bkib parambkib)
  {
    this.jdField_a_of_type_Bkib = parambkib;
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Bkhx == parambkhx) || (TextUtils.isEmpty(parambkhx.b)) || (parambkhx.b.equals(this.jdField_a_of_type_Bkhx.b))) {
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
          parambkib = alvx.a().getNetEngine(0);
          if (parambkib != null)
          {
            QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.getUserData() }));
            parambkib.cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
          }
        }
        this.jdField_a_of_type_Bkhx = parambkhx;
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
        if (QLog.isColorLevel()) {
          QLog.d("TMG_Downloader", 2, String.format("DownloadContrl, mInfo[%s]", new Object[] { this.jdField_a_of_type_Bkhx }));
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Bkhx, 1);
        return this.jdField_a_of_type_Boolean;
        label214:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhz
 * JD-Core Version:    0.7.0.1
 */