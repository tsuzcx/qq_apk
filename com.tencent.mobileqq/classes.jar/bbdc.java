import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;

public class bbdc
  extends ClickableSpan
{
  public bbdc(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, bbej parambbej) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), QQBrowserActivity.class);
    paramView.putExtra("url", String.format("https://buluo.qq.com/mobile/topic_video_group.html?themeid=%d&_bid=128&_wwv=1024&_wv=1027&webview=1", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bbej.h) }));
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().startActivity(paramView);
    if (this.jdField_a_of_type_Bbej.c == 31) {}
    for (paramView = "1";; paramView = "2")
    {
      azqs.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_theme", 0, 0, this.jdField_a_of_type_Bbej.d, this.jdField_a_of_type_Bbej.b + "", "", paramView);
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-18432);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdc
 * JD-Core Version:    0.7.0.1
 */