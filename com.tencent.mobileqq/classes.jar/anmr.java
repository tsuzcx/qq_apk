import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class anmr
  implements View.OnTouchListener
{
  public anmr(AIOEmotionFragment paramAIOEmotionFragment, int paramInt, MessageForPic paramMessageForPic) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a("0X800A7E7");
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.b.setBackgroundColor(Color.parseColor("#F7F7F7"));
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a("0X800A7E9");
        EmojiHomeUiPlugin.openEmojiDetailPage(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a().getAccount(), 8, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.picExtraData.emojiPkgId, false, false);
      }
    }
    while (paramMotionEvent.getAction() != 0)
    {
      return false;
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a("0X800A7E8");
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.getActivity(), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.picExtraData.webUrl);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.getActivity().startActivity(paramView);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.b.setBackgroundColor(Color.parseColor("#DEDEDE"));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anmr
 * JD-Core Version:    0.7.0.1
 */