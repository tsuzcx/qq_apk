import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asgm
  implements View.OnClickListener
{
  asgm(asgl paramasgl, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    ashc localashc = (ashc)this.jdField_a_of_type_Asgl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_Asgl.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    asqn localasqn = new asqn();
    localasqn.c = 4;
    localasqn.e = localashc.a(localCustomEmotionData);
    localasqn.jdField_d_of_type_Int = 2;
    localasqn.jdField_d_of_type_JavaLangString = localCustomEmotionData.eId;
    localasqn.f = localCustomEmotionData.url;
    localasqn.h = localCustomEmotionData.RomaingType;
    localasqn.jdField_g_of_type_Int = localCustomEmotionData.emoId;
    localasqn.jdField_g_of_type_JavaLangString = localCustomEmotionData.resid;
    AIOEmotionFragment.a(this.jdField_a_of_type_Asgl.jdField_a_of_type_AndroidContentContext, localasqn, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgm
 * JD-Core Version:    0.7.0.1
 */