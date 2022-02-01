package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.List;

public class ApolloBattleGameViewBinder
  extends ApolloViewBinder
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ApolloBattleGameViewBinder.ApolloBattleGameListAdapter jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter;
  private View jdField_b_of_type_AndroidViewView;
  private List<ApolloBattleGameInfo> jdField_b_of_type_JavaUtilList;
  
  public ApolloBattleGameViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558605, null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131365194));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, 2));
    int i = ViewUtils.a(9.0F);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new ApolloBattleGameViewBinder.GridSpaceingItemDecoration(this, 2, i, i, ViewUtils.a(26.0F)));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131370396);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131371887);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return localView;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    return localView;
  }
  
  public void a()
  {
    ApolloBattleGameViewBinder.ApolloBattleGameListAdapter localApolloBattleGameListAdapter = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter;
    if (localApolloBattleGameListAdapter != null) {
      localApolloBattleGameListAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, List<ApolloBattleGameInfo> paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaUtilList = paramList;
    ApolloBattleGameViewBinder.ApolloBattleGameListAdapter localApolloBattleGameListAdapter = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter;
    if (localApolloBattleGameListAdapter != null) {
      localApolloBattleGameListAdapter.a(paramList);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter = new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.setVisibility(0);
        return;
      }
      localView.setVisibility(8);
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder
 * JD-Core Version:    0.7.0.1
 */