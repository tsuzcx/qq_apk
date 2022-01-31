import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class amji
  implements AsyncBack
{
  amji(amjh paramamjh) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ComicHelper", 2, "Finish update offline pkg. code = " + paramInt + ", entry = " + this.a.jdField_a_of_type_Int);
    }
    switch (paramInt)
    {
    }
    for (int i = 0;; i = 1)
    {
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_comic_file", 4);
      int k = paramString.getInt("totalOfflinePkgDownloadCount", 0);
      if (i != 0) {
        j = k + 1;
      }
      if (j != k) {
        paramString.edit().putInt("totalOfflinePkgDownloadCount", j).apply();
      }
      if (i != 0)
      {
        long l = NetConnInfoCenter.getServerTime();
        paramString = new StringBuilder();
        paramString.append(paramInt + "|");
        paramString.append(j + "|");
        paramString.append(l + "|");
        paramString.append("|||||");
        DcReportUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sendtdbank|b_sng_qqvip_qqcomic|offlinePkgDownload", paramString.toString(), true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amji
 * JD-Core Version:    0.7.0.1
 */