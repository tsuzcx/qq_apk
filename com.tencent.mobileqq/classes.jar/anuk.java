import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;

public class anuk
  extends anrh
{
  public anuk(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    if (!(this.a instanceof BaseActivity)) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return true;
          localObject1 = ((BaseActivity)this.a).getIntent();
        } while (localObject1 == null);
        localObject2 = ((Intent)localObject1).getExtras();
      } while (localObject2 == null);
      localObject1 = ((Bundle)localObject2).getString("localAPKPath");
      localObject2 = ((Bundle)localObject2).getString("sourceId");
      if (QLog.isColorLevel()) {
        QLog.d("WadlAction", 1, "gamecenter installApk, pkgName=" + this.e + ",localAPKPath=" + (String)localObject1 + ",sourceId=" + (String)localObject2);
      }
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    Intent localIntent = FileProvider7Helper.openApkIntent(this.a, (String)localObject1);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "biz_src_zf_games";
    }
    localIntent.putExtra("big_brother_source_key", (String)localObject1);
    this.a.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anuk
 * JD-Core Version:    0.7.0.1
 */