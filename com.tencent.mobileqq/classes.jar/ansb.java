import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;

class ansb
  implements View.OnClickListener
{
  ansb(ansa paramansa, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    paramView = (ansr)this.jdField_a_of_type_Ansa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_Ansa.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    aoau localaoau = new aoau();
    localaoau.jdField_c_of_type_Int = 4;
    localaoau.jdField_d_of_type_JavaLangString = paramView.a(localCustomEmotionData);
    localaoau.jdField_d_of_type_Int = 2;
    localaoau.jdField_c_of_type_JavaLangString = localCustomEmotionData.eId;
    localaoau.e = localCustomEmotionData.url;
    localaoau.jdField_g_of_type_JavaLangString = localCustomEmotionData.RomaingType;
    localaoau.jdField_g_of_type_Int = localCustomEmotionData.emoId;
    localaoau.f = localCustomEmotionData.resid;
    AIOEmotionFragment.a(this.jdField_a_of_type_Ansa.jdField_a_of_type_AndroidContentContext, localaoau, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ansb
 * JD-Core Version:    0.7.0.1
 */