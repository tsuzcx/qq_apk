import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;

class apnx
  implements View.OnClickListener
{
  apnx(apnw paramapnw, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    paramView = (apon)this.jdField_a_of_type_Apnw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_Apnw.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    apxf localapxf = new apxf();
    localapxf.c = 4;
    localapxf.e = paramView.a(localCustomEmotionData);
    localapxf.jdField_d_of_type_Int = 2;
    localapxf.jdField_d_of_type_JavaLangString = localCustomEmotionData.eId;
    localapxf.f = localCustomEmotionData.url;
    localapxf.h = localCustomEmotionData.RomaingType;
    localapxf.jdField_g_of_type_Int = localCustomEmotionData.emoId;
    localapxf.jdField_g_of_type_JavaLangString = localCustomEmotionData.resid;
    AIOEmotionFragment.a(this.jdField_a_of_type_Apnw.jdField_a_of_type_AndroidContentContext, localapxf, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnx
 * JD-Core Version:    0.7.0.1
 */