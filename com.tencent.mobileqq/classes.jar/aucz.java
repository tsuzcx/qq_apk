import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aucz
  implements View.OnClickListener
{
  aucz(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    bdll.b(null, "dc00898", "", "", "0X800AEE0", "0X800AEE0", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = auog.a(this.jdField_a_of_type_JavaLangString);
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if (l <= 10485760L)
      {
        int i = aunj.b(this.jdField_a_of_type_JavaLangString);
        Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i);
        localWXShareHelper.a(this.jdField_a_of_type_JavaLangString, localBitmap);
        bdll.b(null, "dc00898", "", "", "0X800AEE1", "0X800AEE1", 0, 0, "", "", "", "");
      }
      else
      {
        bdll.b(null, "dc00898", "", "", "0X800AEE2", "0X800AEE2", 0, 0, "", "", "", "");
        aumw.a(this.jdField_a_of_type_AndroidAppActivity, "", 2131697486, new auda(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucz
 * JD-Core Version:    0.7.0.1
 */