import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;

class ansg
  implements View.OnClickListener
{
  ansg(ansf paramansf, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    paramView = (answ)this.jdField_a_of_type_Ansf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_Ansf.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    aoaz localaoaz = new aoaz();
    localaoaz.jdField_c_of_type_Int = 4;
    localaoaz.jdField_d_of_type_JavaLangString = paramView.a(localCustomEmotionData);
    localaoaz.jdField_d_of_type_Int = 2;
    localaoaz.jdField_c_of_type_JavaLangString = localCustomEmotionData.eId;
    localaoaz.e = localCustomEmotionData.url;
    localaoaz.jdField_g_of_type_JavaLangString = localCustomEmotionData.RomaingType;
    localaoaz.jdField_g_of_type_Int = localCustomEmotionData.emoId;
    localaoaz.f = localCustomEmotionData.resid;
    AIOEmotionFragment.a(this.jdField_a_of_type_Ansf.jdField_a_of_type_AndroidContentContext, localaoaz, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ansg
 * JD-Core Version:    0.7.0.1
 */