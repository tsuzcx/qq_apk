import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyTribeAppController.2.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ausm
  implements arpk
{
  ausm(ausl paramausl) {}
  
  public void a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    do
    {
      return;
      localObject = armo.a().b() + paramString;
      if (!new File((String)localObject).exists()) {
        break;
      }
      arpg.a((String)localObject);
    } while (!QLog.isColorLevel());
    QLog.d(ausl.a(this.a), 2, "UniformDownloadUtil.installAPK,savePath=" + (String)localObject);
    return;
    ausl.a(this.a).post(new NearbyTribeAppController.2.1(this));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("_filename_from_dlg", paramString);
    ((Bundle)localObject).putLong("_filesize_from_dlg", paramLong);
    ((Bundle)localObject).putString("_notify_name_dialog", alpo.a(2131707760));
    ((Bundle)localObject).putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_hdsp_nearby");
    aqwa.a().a("http://pub.idqqimg.com/pc/misc/files/20170706/c221bf304be44e5a9e0441768beacff0.apk", (Bundle)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausm
 * JD-Core Version:    0.7.0.1
 */