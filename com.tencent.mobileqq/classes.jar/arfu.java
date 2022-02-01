import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class arfu
  implements View.OnTouchListener
{
  public arfu(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.b.setBackgroundColor(Color.parseColor("#F7F7F7"));
      EmojiHomeUiPlugin.openEmojiDetailPage(this.a.getActivity(), this.a.a().getAccount(), 8, this.a.a.epId, false, false);
      this.a.a("0X800997F");
    }
    while (paramMotionEvent.getAction() != 0) {
      return false;
    }
    this.a.b.setBackgroundColor(Color.parseColor("#DEDEDE"));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfu
 * JD-Core Version:    0.7.0.1
 */