import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloManager.20.1;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ammj
  extends bhyn
{
  ammj(amme paramamme) {}
  
  public void onDoneFile(bhyo parambhyo)
  {
    if ((parambhyo == null) || (this.a.a == null)) {}
    String str1;
    do
    {
      return;
      if (parambhyo.a != 0)
      {
        QLog.e("ApolloManager", 1, new Object[] { "preDownloadListener task error:", Integer.valueOf(parambhyo.a()) });
        return;
      }
      str1 = parambhyo.c;
      parambhyo = parambhyo.a();
    } while (parambhyo == null);
    ApolloPreDownloadData localApolloPreDownloadData = (ApolloPreDownloadData)parambhyo.getSerializable(str1);
    if (localApolloPreDownloadData == null)
    {
      QLog.e("ApolloManager", 1, "preDownloadListener res onDoneFile but preDownload data is null");
      return;
    }
    if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir)) {}
    for (parambhyo = ApolloUtil.e(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.zipDir;; parambhyo = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/pre_download/" + localApolloPreDownloadData.resId + ".zip")
    {
      String str2 = ApolloUtil.e(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.dir;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "preDownloadListener res zip done reportId:", localApolloPreDownloadData.reportId, ", url:", str1 });
      }
      ThreadManager.getSubThreadHandler().post(new ApolloManager.20.1(this, localApolloPreDownloadData, parambhyo, str2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammj
 * JD-Core Version:    0.7.0.1
 */