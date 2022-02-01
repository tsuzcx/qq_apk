import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class anqg
  extends anqh
  implements View.OnClickListener
{
  public anqg(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext);
    this.c = 4;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.f = 2;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setDivider(null);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setVerticalScrollBarEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setEdgeEffectEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setSelector(2130850739);
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView;
  }
  
  public annl a(String paramString)
  {
    return new annm(paramString);
  }
  
  public ArrayList<annl> a(int paramInt)
  {
    if ((this.b != 9) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    do
    {
      return null;
      i = a();
    } while ((paramInt < 0) || (paramInt >= i) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView == null));
    paramInt = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.getFirstVisiblePosition() * this.f;
    int i = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.getLastVisiblePosition();
    int j = this.f;
    ArrayList localArrayList = new ArrayList();
    while ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt <= (i + 1) * j - 1))
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public void a(View paramView, int paramInt)
  {
    c(paramView);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    if (this.jdField_a_of_type_Anpk != null) {
      this.jdField_a_of_type_Anpk.a(paramBaseChatPie);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqg
 * JD-Core Version:    0.7.0.1
 */