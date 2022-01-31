import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;

class apjo
  implements View.OnClickListener
{
  apjo(apjn paramapjn, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    paramView = (apke)this.jdField_a_of_type_Apjn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_Apjn.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    apsw localapsw = new apsw();
    localapsw.c = 4;
    localapsw.e = paramView.a(localCustomEmotionData);
    localapsw.jdField_d_of_type_Int = 2;
    localapsw.jdField_d_of_type_JavaLangString = localCustomEmotionData.eId;
    localapsw.f = localCustomEmotionData.url;
    localapsw.h = localCustomEmotionData.RomaingType;
    localapsw.jdField_g_of_type_Int = localCustomEmotionData.emoId;
    localapsw.jdField_g_of_type_JavaLangString = localCustomEmotionData.resid;
    AIOEmotionFragment.a(this.jdField_a_of_type_Apjn.jdField_a_of_type_AndroidContentContext, localapsw, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjo
 * JD-Core Version:    0.7.0.1
 */