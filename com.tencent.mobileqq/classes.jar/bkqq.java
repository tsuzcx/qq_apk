import android.app.Activity;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class bkqq
  implements aqrq
{
  bkqq(bkqp parambkqp, Activity paramActivity) {}
  
  public void onColorNoteAnimFinish()
  {
    if ((bkqp.a(this.jdField_a_of_type_Bkqp) != null) && (bkqp.a(this.jdField_a_of_type_Bkqp).isInternalApp())) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    AnimUtil.clearAnim(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqq
 * JD-Core Version:    0.7.0.1
 */