import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView.UpdateTroopMembersFaceTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfxt
  implements View.OnClickListener
{
  public bfxt(TroopMoreDetailView.UpdateTroopMembersFaceTask paramUpdateTroopMembersFaceTask, TroopMoreDetailView paramTroopMoreDetailView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxt
 * JD-Core Version:    0.7.0.1
 */