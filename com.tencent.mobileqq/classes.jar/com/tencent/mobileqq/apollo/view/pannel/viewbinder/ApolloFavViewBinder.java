package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListView;
import java.util.ArrayList;
import java.util.List;

public class ApolloFavViewBinder
  extends ApolloViewBinder
{
  public ApolloFavViewBinder(Context paramContext, SessionInfo paramSessionInfo)
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
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setDivider(null);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setVerticalScrollBarEnabled(true);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setEdgeEffectEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setSelector(2130851165);
      }
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView;
    case 4: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558713, null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setDivider(null);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setVerticalScrollBarEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setEdgeEffectEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setSelector(2130851165);
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView;
  }
  
  public ApolloInfo a(String paramString)
  {
    return new ApolloMainInfo(paramString);
  }
  
  public ArrayList<ApolloInfo> a(int paramInt)
  {
    if ((this.b != 0) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
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
  
  public void a(View paramView, int paramInt)
  {
    c(paramView);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListAdapter.a(paramBaseChatPie);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloFavViewBinder
 * JD-Core Version:    0.7.0.1
 */