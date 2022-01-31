import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;

final class apuo
  implements ValueCallback<String>
{
  apuo(WeakReference paramWeakReference, Activity paramActivity) {}
  
  public void a(String paramString)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localActivity != null) && (paramString != null) && (paramString.startsWith("http")))
    {
      if (apdc.a().a() == null)
      {
        paramString = new Bundle();
        paramString.putString("_filename_from_dlg", this.jdField_a_of_type_AndroidAppActivity.getString(2131694786));
        paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
        Intent localIntent = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
        localIntent.putExtra("param", paramString);
        localIntent.putExtra("url", "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10386");
        localActivity.sendBroadcast(localIntent);
      }
    }
    else {
      return;
    }
    apug.c(localActivity, "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10386");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apuo
 * JD-Core Version:    0.7.0.1
 */