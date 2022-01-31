import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.share.FilterComboSharePlugin;
import java.io.File;

public class anad
  implements Runnable
{
  public anad(FilterComboSharePlugin paramFilterComboSharePlugin, String paramString, ApplicationInfo paramApplicationInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterComboShare", 2, "shareMsgToSina path:" + this.jdField_a_of_type_JavaLangString);
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.TEXT", "套餐分享");
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.jdField_a_of_type_JavaLangString)));
    }
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentPmApplicationInfo.packageName);
    this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin.startActivityForResult(localIntent, (byte)110);
    if (QLog.isColorLevel()) {
      QLog.d("FilterComboShare", 2, "shareMsgToSina start weibo!");
    }
    this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin.a(true, 3);
    this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin.a();
    FilterComboSharePlugin.a(this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin, this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin.jdField_a_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anad
 * JD-Core Version:    0.7.0.1
 */