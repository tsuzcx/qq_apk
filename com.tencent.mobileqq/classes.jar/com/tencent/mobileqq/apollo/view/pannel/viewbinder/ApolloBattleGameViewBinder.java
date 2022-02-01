package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;

public class ApolloBattleGameViewBinder
  extends ApolloViewBinder
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ApolloBattleGameViewBinder.ApolloBattleGameListAdapter jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter;
  private View jdField_b_of_type_AndroidViewView;
  private List<ApolloBattleGameInfo> jdField_b_of_type_JavaUtilList;
  
  public ApolloBattleGameViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558706, null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131365319));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_AndroidContentContext, 2));
    int i = ViewUtils.a(9.0F);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new ApolloBattleGameViewBinder.GridSpaceingItemDecoration(this, 2, i, i, ViewUtils.a(26.0F)));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131370761);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131372299);
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, List<ApolloBattleGameInfo> paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter.a(paramList);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter = new ApolloBattleGameViewBinder.ApolloBattleGameListAdapter(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloBattleGameViewBinder
 * JD-Core Version:    0.7.0.1
 */