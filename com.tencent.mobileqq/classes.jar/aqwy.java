import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.hiboom.FontBubble;
import com.tencent.mobileqq.hiboom.FontBubblePanelView;
import java.util.List;

public class aqwy
  extends RecyclerView.Adapter<FontBubblePanelView<T>.aqwz>
{
  public aqwy(FontBubblePanelView paramFontBubblePanelView) {}
  
  public FontBubblePanelView<T>.aqwz a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(2131562599, paramViewGroup, false);
    return new aqwz(this.a, paramViewGroup);
  }
  
  public void a(FontBubblePanelView<T>.aqwz paramFontBubblePanelView, int paramInt)
  {
    if (paramInt < FontBubblePanelView.a(this.a).size()) {
      this.a.a(paramFontBubblePanelView, (FontBubble)FontBubblePanelView.a(this.a).get(paramInt));
    }
  }
  
  public int getItemCount()
  {
    return FontBubblePanelView.a(this.a).size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((FontBubble)FontBubblePanelView.a(this.a).get(paramInt)).viewType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqwy
 * JD-Core Version:    0.7.0.1
 */