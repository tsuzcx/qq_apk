import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.FastScroller;

public class begd
  extends AdapterView<ListAdapter>.behh
{
  public begd(AbsListView paramAbsListView)
  {
    super(paramAbsListView);
  }
  
  public void onChanged()
  {
    super.onChanged();
    if (this.a.mFastScroller != null) {
      this.a.mFastScroller.c();
    }
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
    if (this.a.mFastScroller != null) {
      this.a.mFastScroller.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     begd
 * JD-Core Version:    0.7.0.1
 */