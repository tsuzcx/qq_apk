import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.ApolloPanelListView;
import java.util.ArrayList;
import java.util.List;

public class anqf
  extends anst
{
  public anqf(Context paramContext, SessionInfo paramSessionInfo)
  {
    super(null, paramContext);
    this.c = 2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.f = 4;
  }
  
  public View a()
  {
    switch (this.b)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView.setDivider(null);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView.setVerticalScrollBarEnabled(true);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView.setEdgeEffectEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView.setSelector(2130850683);
      }
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView;
    case 4: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558672, null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView.setDivider(null);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView.setVerticalScrollBarEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView.setEdgeEffectEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView.setSelector(2130850683);
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView;
  }
  
  public anra a(String paramString)
  {
    return new anrg(paramString);
  }
  
  public ArrayList<anra> a(int paramInt)
  {
    if ((this.b != 0) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    do
    {
      return null;
      i = a();
    } while ((paramInt < 0) || (paramInt >= i) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView == null));
    paramInt = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView.getFirstVisiblePosition() * this.f;
    int i = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelListView.getLastVisiblePosition();
    int j = this.f;
    ArrayList localArrayList = new ArrayList();
    while ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt <= (i + 1) * j - 1))
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public void a(View paramView, int paramInt)
  {
    c(paramView);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    if (this.jdField_a_of_type_Ansm != null) {
      this.jdField_a_of_type_Ansm.a(paramBaseChatPie);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqf
 * JD-Core Version:    0.7.0.1
 */