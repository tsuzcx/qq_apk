import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;

public class azkw
  implements azlq
{
  public azkw(NewTroopContactView paramNewTroopContactView) {}
  
  public ArrayList<ResultRecord> a()
  {
    return this.a.c;
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Azkk.notifyDataSetChanged();
    if (this.a.jdField_a_of_type_Azkk.getGroupCount() > 0)
    {
      Groups localGroups1 = this.a.jdField_a_of_type_Azkk.a(1007L);
      Groups localGroups2 = this.a.jdField_a_of_type_Azkk.a(1008L);
      if ((localGroups1 != null) || (localGroups2 != null))
      {
        this.a.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.a(0);
        this.a.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setIsNeedScrollPositionTop(true);
        this.a.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.smoothScrollToPositionFromTop(1, 0, 0);
      }
      if (localGroups1 != null) {
        this.a.jdField_a_of_type_Azlo.a();
      }
      if (localGroups2 != null) {
        this.a.jdField_a_of_type_Azlo.c();
      }
    }
  }
  
  public ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.c.size())
    {
      localArrayList.add(((ResultRecord)this.a.c.get(i)).a);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azkw
 * JD-Core Version:    0.7.0.1
 */