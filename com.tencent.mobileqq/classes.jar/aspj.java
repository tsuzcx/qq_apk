import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aspj
  implements View.OnClickListener
{
  aspj(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    bcef.b(null, "dc00898", "", "", "0X800AEE0", "0X800AEE0", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = FileUtil.getFileSize(this.jdField_a_of_type_JavaLangString);
      WXShareHelper localWXShareHelper = WXShareHelper.getInstance();
      if (l <= 10485760L)
      {
        int i = aszt.b(this.jdField_a_of_type_JavaLangString);
        Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i);
        localWXShareHelper.shareFileToWx(this.jdField_a_of_type_JavaLangString, localBitmap);
        bcef.b(null, "dc00898", "", "", "0X800AEE1", "0X800AEE1", 0, 0, "", "", "", "");
      }
      else
      {
        bcef.b(null, "dc00898", "", "", "0X800AEE2", "0X800AEE2", 0, 0, "", "", "", "");
        aszg.a(this.jdField_a_of_type_AndroidAppActivity, "", 2131697632, new aspk(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspj
 * JD-Core Version:    0.7.0.1
 */