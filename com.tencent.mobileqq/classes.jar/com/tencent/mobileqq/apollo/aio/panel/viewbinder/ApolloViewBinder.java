package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListView;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.PullAndFastScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;

public class ApolloViewBinder
{
  private int jdField_a_of_type_Int;
  public Context a;
  public SessionInfo a;
  protected ApolloPanelListAdapter a;
  protected ApolloPanelListView a;
  protected QQAppInterface a;
  private EmotionPanelListView.PullAndFastScrollListener jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  public List<ApolloInfo> a;
  public int b = 0;
  public int c;
  public int d;
  protected int e = -1;
  protected int f = 4;
  
  public ApolloViewBinder(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public View a()
  {
    return null;
  }
  
  public ApolloPanelListAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter;
  }
  
  public ApolloInfo a(String paramString)
  {
    return null;
  }
  
  public ArrayList<ApolloInfo> a(int paramInt)
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(BaseChatPie paramBaseChatPie) {}
  
  public void a(EmotionPanelListView.PullAndFastScrollListener paramPullAndFastScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener = paramPullAndFastScrollListener;
  }
  
  public void a(List<ApolloInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloViewBinder", 2, new Object[] { "[setHighlightItemIndex] highlightItemIndex=", Integer.valueOf(paramInt) });
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() != 0))
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        this.e = paramInt;
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloViewBinder", 2, new Object[] { "[setHighlightItemIndex] set success, highlightItemIndex=", Integer.valueOf(paramInt) });
        }
      }
      return;
    }
    QLog.e("[cmshow]ApolloViewBinder", 1, "[setHighlightItemIndex] no panel data, set failed");
  }
  
  public View c()
  {
    View localView = a();
    a(localView, 0);
    return localView;
  }
  
  protected void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter = new ApolloPanelListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener == null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ApolloViewBinder.1(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter.a(this.c);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter.b(this.f);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter.c(this.e);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    if ((paramView instanceof ApolloPanelListView))
    {
      paramView = (ApolloPanelListView)paramView;
      paramView.setPullAndFastScrollListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListView$PullAndFastScrollListener);
      paramView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
      paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter);
      int k = this.e;
      if (k != -1)
      {
        int m = this.f;
        int j = k / m;
        int i = j;
        if (k % m != 0) {
          i = j + 1;
        }
        if (i < this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter.getCount()) {
          paramView.smoothScrollToPosition(i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder
 * JD-Core Version:    0.7.0.1
 */