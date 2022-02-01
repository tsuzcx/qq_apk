import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class blrd
  implements IAsyncQimeiListener
{
  public void onQimeiDispatch(Qimei paramQimei)
  {
    if ((paramQimei != null) && (TextUtils.isEmpty(blrb.b()))) {
      blrb.a(paramQimei.getQimeiNew());
    }
    if (QLog.isColorLevel()) {
      QLog.i("VipComicReportUtils", 1, "getQimei onQimeiDispatch qimei:" + blrb.b());
    }
    BaseApplicationImpl.getContext().getSharedPreferences("fileSystemInfo_", 4).edit().putString("qimei_new", blrb.b()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrd
 * JD-Core Version:    0.7.0.1
 */