import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class axgs
{
  int jdField_a_of_type_Int = 0;
  ayrv jdField_a_of_type_Ayrv;
  DownloadInfo jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c;
  
  axgs()
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  boolean a(DownloadInfo paramDownloadInfo)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == paramDownloadInfo) || (((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_model)) || (paramDownloadInfo.MD5_zip_model.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo.MD5_zip_model))) && ((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_so)) || (paramDownloadInfo.MD5_zip_so.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo.MD5_zip_so))))) {
        break label382;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavGesture", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
      }
      if (!bool)
      {
        return this.jdField_a_of_type_Boolean;
        bool = true;
      }
      else
      {
        if (this.jdField_a_of_type_Ayrv != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = ((AppInterface)localObject).getNetEngine(0);
            if (localObject != null)
            {
              QLog.d("QavGesture", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Ayrv.a() }));
              ((ayry)localObject).b(this.jdField_a_of_type_Ayrv);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = paramDownloadInfo;
        this.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Ayrv = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!axgw.d(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo))
        {
          this.jdField_c_of_type_Int |= 0x1;
          this.jdField_a_of_type_Int += 1;
        }
        if (!axgw.c(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo))
        {
          this.jdField_c_of_type_Int |= 0x2;
          this.jdField_a_of_type_Int += 1;
        }
        if ((axgw.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo)) && (!axgw.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo)))
        {
          this.jdField_c_of_type_Int |= 0x3;
          this.jdField_a_of_type_Int += 1;
        }
        QLog.d("QavGesture", 1, String.format("DownloadContrl, mResFlag[%s], mInfo[%s]", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo }));
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, 3);
        return this.jdField_a_of_type_Boolean;
        label382:
        bool = false;
      }
    }
  }
  
  boolean a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    String str2;
    String str1;
    int i;
    if (!axgw.d(paramDownloadInfo))
    {
      str2 = paramDownloadInfo.url_zip_so;
      str1 = paramDownloadInfo.MD5_zip_so;
      i = 1;
    }
    String str3;
    boolean bool2;
    for (;;)
    {
      str3 = axgw.b() + str1;
      if (paramInt >= 0) {
        break label154;
      }
      QLog.d("QavGesture", 1, String.format("downloadRes, 下载死循环了. res_flag[%s], info[%s]", new Object[] { Integer.valueOf(i), paramDownloadInfo }));
      axgr.a(-3);
      bool2 = false;
      return bool2;
      if ((paramDownloadInfo.enable) && (!axgw.c(paramDownloadInfo)))
      {
        str2 = paramDownloadInfo.url_zip_model;
        str1 = paramDownloadInfo.MD5_zip_model;
        i = 2;
      }
      else
      {
        if ((!axgw.a(paramDownloadInfo)) || (axgw.b(paramDownloadInfo))) {
          break;
        }
        str2 = paramDownloadInfo.url_zip_gamemodel;
        str1 = paramDownloadInfo.MD5_zip_gamemodel;
        i = 3;
      }
    }
    axgr.a(100);
    return false;
    label154:
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = new axgt(this, str1, paramDownloadInfo, i, paramInt);
    localayrv.a(i + "_" + str1);
    localayrv.jdField_a_of_type_JavaLangString = str2;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.jdField_c_of_type_JavaLangString = new File(str3).getPath();
    localayrv.jdField_c_of_type_Int = bbev.a(aysy.a().a());
    paramDownloadInfo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramDownloadInfo instanceof QQAppInterface))
    {
      paramDownloadInfo = ((QQAppInterface)paramDownloadInfo).getNetEngine(0);
      if (paramDownloadInfo != null)
      {
        this.jdField_a_of_type_Ayrv = localayrv;
        paramDownloadInfo.a(this.jdField_a_of_type_Ayrv);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        axgr.a(-2);
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QavGesture", 2, String.format("downloadRes, res_flag[%s], md5[%s], etr[%s]", new Object[] { Integer.valueOf(i), str1, Boolean.valueOf(bool1) }));
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgs
 * JD-Core Version:    0.7.0.1
 */