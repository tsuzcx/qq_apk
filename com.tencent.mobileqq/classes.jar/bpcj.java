import android.widget.TextView;
import dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout;
import dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView;

public class bpcj
  implements bpcu
{
  private bpcj(MoreLyricLayout paramMoreLyricLayout) {}
  
  public void a(long paramLong)
  {
    bpam.a("MoreLyricLayout", "onScroll() position => " + paramLong);
    MoreLyricLayout.a(this.a);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    MoreLyricLayout.a(this.a, paramLong1);
    String str = LyricWithBuoyView.a((int)paramLong1);
    TextView localTextView = null;
    if (MoreLyricLayout.a(this.a) != null) {
      localTextView = MoreLyricLayout.a(this.a).a();
    }
    if (localTextView != null) {
      localTextView.setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpcj
 * JD-Core Version:    0.7.0.1
 */