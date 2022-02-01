import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel;
import java.util.List;

public class astm
  extends RecyclerView.OnScrollListener
{
  public astm(RelatedEmotionPanel paramRelatedEmotionPanel) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    AbstractGifImage.pauseAll();
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if ((!paramRecyclerView.canScrollVertically(1)) && (RelatedEmotionPanel.a(this.a) == 1) && (!RelatedEmotionPanel.a(this.a)) && (RelatedEmotionPanel.a(this.a).a() != null))
    {
      RelatedEmotionPanel.a(this.a, true);
      bdll.b(RelatedEmotionPanel.a(this.a), "dc00898", "", this.a.a, "0X800B156", "0X800B156", 0, 0, RelatedEmotionPanel.a(this.a).a().size() + "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astm
 * JD-Core Version:    0.7.0.1
 */