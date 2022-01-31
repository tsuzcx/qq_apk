import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.vas.VasApngUtil;

class br
  implements Runnable
{
  br(bq parambq, boolean paramBoolean, Bitmap paramBitmap) {}
  
  public void run()
  {
    Bundle localBundle;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_Bq.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDrawable(2130838339);
      localBundle = new Bundle();
      localBundle.putBoolean("key_use_rect", true);
      localBundle.putBoolean("key_double_bitmap", true);
    }
    for (Object localObject = VasApngUtil.a(BaseApplicationImpl.sApplication.getRuntime(), this.jdField_a_of_type_Bq.jdField_a_of_type_JavaLangString, "-chatBg-", (Drawable)localObject, new int[] { 0 }, "-chatBg-", localBundle);; localObject = new ChatBackgroundDrawable(this.jdField_a_of_type_Bq.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap))
    {
      this.jdField_a_of_type_Bq.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
      this.jdField_a_of_type_Bq.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362036, this.jdField_a_of_type_Bq.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bq.jdField_a_of_type_AndroidViewViewGroup.setTag(2131362037, localObject);
      LiteActivity.a(this.jdField_a_of_type_Bq.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     br
 * JD-Core Version:    0.7.0.1
 */