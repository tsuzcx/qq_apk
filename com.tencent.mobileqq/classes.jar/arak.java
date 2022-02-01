import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class arak
  implements View.OnClickListener
{
  arak(araj paramaraj, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    arba localarba = (arba)this.jdField_a_of_type_Araj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_Araj.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    FavoriteEmoticonInfo localFavoriteEmoticonInfo = new FavoriteEmoticonInfo();
    localFavoriteEmoticonInfo.type = 4;
    localFavoriteEmoticonInfo.path = localarba.a(localCustomEmotionData);
    localFavoriteEmoticonInfo.src_type = 2;
    localFavoriteEmoticonInfo.eId = localCustomEmotionData.eId;
    localFavoriteEmoticonInfo.url = localCustomEmotionData.url;
    localFavoriteEmoticonInfo.roamingType = localCustomEmotionData.RomaingType;
    localFavoriteEmoticonInfo.emoId = localCustomEmotionData.emoId;
    localFavoriteEmoticonInfo.resID = localCustomEmotionData.resid;
    AIOEmotionFragment.a(this.jdField_a_of_type_Araj.jdField_a_of_type_AndroidContentContext, localFavoriteEmoticonInfo, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arak
 * JD-Core Version:    0.7.0.1
 */