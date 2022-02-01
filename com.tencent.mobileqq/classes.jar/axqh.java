import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyTribeAppController.2.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axqh
  implements auky
{
  axqh(axqg paramaxqg) {}
  
  public void a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    do
    {
      return;
      localObject = audf.a().b() + paramString;
      if (!new File((String)localObject).exists()) {
        break;
      }
      auku.a((String)localObject);
    } while (!QLog.isColorLevel());
    QLog.d(axqg.a(this.a), 2, "UniformDownloadUtil.installAPK,savePath=" + (String)localObject);
    return;
    axqg.a(this.a).post(new NearbyTribeAppController.2.1(this));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("_filename_from_dlg", paramString);
    ((Bundle)localObject).putLong("_filesize_from_dlg", paramLong);
    ((Bundle)localObject).putString("_notify_name_dialog", anvx.a(2131706852));
    ((Bundle)localObject).putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_hdsp_nearby");
    QLog.e(axqg.a(this.a), 1, "这里已经下架，如果依然发现该log，异常case");
    auht.a().a("https://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk", (Bundle)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqh
 * JD-Core Version:    0.7.0.1
 */