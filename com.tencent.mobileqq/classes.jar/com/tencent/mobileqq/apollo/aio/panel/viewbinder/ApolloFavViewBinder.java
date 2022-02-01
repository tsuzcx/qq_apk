package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListView;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
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
    int i = this.b;
    if (i != 4)
    {
      if (i != 5)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setDivider(null);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setVerticalScrollBarEnabled(true);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setEdgeEffectEnabled(false);
          this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setSelector(2130851081);
        }
        return this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setDivider(null);
        this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setVerticalScrollBarEnabled(true);
        this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setEdgeEffectEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setSelector(2130851081);
      }
      return this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView;
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558612, null);
  }
  
  public ApolloInfo a(String paramString)
  {
    return new ApolloMainInfo(paramString);
  }
  
  public ArrayList<ApolloInfo> a(int paramInt)
  {
    int i = this.b;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (i == 0)
    {
      localArrayList1 = localArrayList2;
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
          return null;
        }
        i = a();
        localArrayList1 = localArrayList2;
        if (paramInt >= 0)
        {
          if (paramInt >= i) {
            return null;
          }
          localArrayList1 = localArrayList2;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView != null)
          {
            paramInt = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.getFirstVisiblePosition() * this.f;
            i = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.getLastVisiblePosition();
            int j = this.f;
            localArrayList2 = new ArrayList();
            for (;;)
            {
              localArrayList1 = localArrayList2;
              if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
                break;
              }
              localArrayList1 = localArrayList2;
              if (paramInt > (i + 1) * j - 1) {
                break;
              }
              localArrayList2.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
              paramInt += 1;
            }
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public void a(View paramView, int paramInt)
  {
    c(paramView);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter.a(paramBaseChatPie);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloFavViewBinder
 * JD-Core Version:    0.7.0.1
 */