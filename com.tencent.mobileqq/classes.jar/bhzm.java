import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.PinnedFooterExpandableListView;

public class bhzm
  implements View.OnClickListener
{
  public bhzm(PinnedFooterExpandableListView paramPinnedFooterExpandableListView1, PinnedFooterExpandableListView paramPinnedFooterExpandableListView2) {}
  
  public void onClick(View paramView)
  {
    if (PinnedFooterExpandableListView.a(this.b) != null) {
      PinnedFooterExpandableListView.a(this.b).a(this.a, this.b.a, this.b.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhzm
 * JD-Core Version:    0.7.0.1
 */