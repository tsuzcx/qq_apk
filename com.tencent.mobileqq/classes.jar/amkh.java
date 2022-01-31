import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedFooterExpandableListView.FooterExpandListViewListener;

public class amkh
  implements View.OnClickListener
{
  public amkh(PinnedFooterExpandableListView paramPinnedFooterExpandableListView1, PinnedFooterExpandableListView paramPinnedFooterExpandableListView2) {}
  
  public void onClick(View paramView)
  {
    if (PinnedFooterExpandableListView.a(this.b) != null) {
      PinnedFooterExpandableListView.a(this.b).a(this.a, this.b.a, this.b.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amkh
 * JD-Core Version:    0.7.0.1
 */