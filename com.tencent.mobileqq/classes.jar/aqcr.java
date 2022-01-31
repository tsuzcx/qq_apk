import com.tencent.mobileqq.hiboom.FontBubble;
import com.tencent.mobileqq.hiboom.FontBubblePanelView;
import java.util.List;

public class aqcr
  implements arok<List<FontBubble>>
{
  public aqcr(FontBubblePanelView paramFontBubblePanelView) {}
  
  public void a(List<FontBubble> paramList)
  {
    FontBubblePanelView.a(this.a, paramList);
    FontBubblePanelView.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqcr
 * JD-Core Version:    0.7.0.1
 */