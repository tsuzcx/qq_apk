import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonWebBean;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public class asff
  implements View.OnTouchListener
{
  public asff(SearchEmoticonFragment paramSearchEmoticonFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.b.setBackgroundColor(Color.parseColor("#F7F7F7"));
      if (SearchEmoticonFragment.a(this.a).d == 1)
      {
        EmojiHomeUiPlugin.openEmojiDetailPage(this.a.getActivity(), this.a.a().getAccount(), 8, SearchEmoticonFragment.a(this.a).e, false, false);
        bcst.b(null, "dc00898", "", "", "0X8009EAF", "0X8009EAF", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return false;
      if (SearchEmoticonFragment.a(this.a).d == 2)
      {
        MiniAppLauncher.launchMiniAppById(SearchEmoticonFragment.a(this.a), SearchEmoticonFragment.a(this.a).g, null, null, null, null, 1005);
        bcst.b(null, "dc00898", "", "", "0X8009EB1", "0X8009EB1", 0, 0, "", "", "", "");
        continue;
        if (paramMotionEvent.getAction() == 0)
        {
          this.a.b.setBackgroundColor(Color.parseColor("#DEDEDE"));
          bcst.b(null, "dc00898", "", "", "0X8009EAE", "0X8009EAE", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asff
 * JD-Core Version:    0.7.0.1
 */