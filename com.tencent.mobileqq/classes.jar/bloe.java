import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PinnedHeadAndFootExpandableListView;

public class bloe
  implements View.OnClickListener
{
  public bloe(PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView1, PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView2) {}
  
  public void onClick(View paramView)
  {
    if (this.b.jdField_a_of_type_Blog != null) {
      this.b.jdField_a_of_type_Blog.a(this.a, this.b.jdField_a_of_type_AndroidViewView, this.b.f);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bloe
 * JD-Core Version:    0.7.0.1
 */