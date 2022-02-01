import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class arqy
  implements View.OnClickListener
{
  arqy(arqx paramarqx, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    arro localarro = (arro)this.jdField_a_of_type_Arqx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_Arqx.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    asaz localasaz = new asaz();
    localasaz.c = 4;
    localasaz.e = localarro.a(localCustomEmotionData);
    localasaz.jdField_d_of_type_Int = 2;
    localasaz.jdField_d_of_type_JavaLangString = localCustomEmotionData.eId;
    localasaz.f = localCustomEmotionData.url;
    localasaz.h = localCustomEmotionData.RomaingType;
    localasaz.jdField_g_of_type_Int = localCustomEmotionData.emoId;
    localasaz.jdField_g_of_type_JavaLangString = localCustomEmotionData.resid;
    AIOEmotionFragment.a(this.jdField_a_of_type_Arqx.jdField_a_of_type_AndroidContentContext, localasaz, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqy
 * JD-Core Version:    0.7.0.1
 */