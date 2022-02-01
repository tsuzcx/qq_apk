import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.hiboom.FontBubble;
import com.tencent.mobileqq.hiboom.FontBubblePanelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class avjw
  extends RecyclerView.Adapter<FontBubblePanelView<T>.avjx>
{
  public avjw(FontBubblePanelView paramFontBubblePanelView) {}
  
  public FontBubblePanelView<T>.avjx a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(2131563052, paramViewGroup, false);
    return new avjx(this.a, paramViewGroup);
  }
  
  public void a(FontBubblePanelView<T>.avjx paramFontBubblePanelView, int paramInt)
  {
    if (paramInt < FontBubblePanelView.a(this.a).size()) {
      this.a.a(paramFontBubblePanelView, (FontBubble)FontBubblePanelView.a(this.a).get(paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramFontBubblePanelView, paramInt, getItemId(paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjw
 * JD-Core Version:    0.7.0.1
 */