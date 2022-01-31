import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;

class anbq
  implements View.OnClickListener
{
  anbq(anbp paramanbp, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    paramView = (ancg)this.jdField_a_of_type_Anbp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_Anbp.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    ankl localankl = new ankl();
    localankl.jdField_c_of_type_Int = 4;
    localankl.jdField_d_of_type_JavaLangString = paramView.a(localCustomEmotionData);
    localankl.jdField_d_of_type_Int = 2;
    localankl.jdField_c_of_type_JavaLangString = localCustomEmotionData.eId;
    localankl.e = localCustomEmotionData.url;
    localankl.jdField_g_of_type_JavaLangString = localCustomEmotionData.RomaingType;
    localankl.jdField_g_of_type_Int = localCustomEmotionData.emoId;
    localankl.f = localCustomEmotionData.resid;
    AIOEmotionFragment.a(this.jdField_a_of_type_Anbp.jdField_a_of_type_AndroidContentContext, localankl, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anbq
 * JD-Core Version:    0.7.0.1
 */