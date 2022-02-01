import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

public class beyx
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  public beyx(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a != null) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a.size() - 1))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a.size();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a(paramInt, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyx
 * JD-Core Version:    0.7.0.1
 */