package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.apollo.model.ApolloTagButtonData;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class ApolloTagActionViewBinder$ApolloActionTagsAdapter$1
  implements View.OnClickListener
{
  ApolloTagActionViewBinder$ApolloActionTagsAdapter$1(ApolloTagActionViewBinder.ApolloActionTagsAdapter paramApolloActionTagsAdapter, Button paramButton, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidWidgetButton;
    int i;
    if (paramView != null)
    {
      if (paramView.getText() == null) {
        return;
      }
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter).size())
        {
          if (i == this.jdField_a_of_type_Int) {
            break label262;
          }
          ((ApolloTagButtonData)ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter).get(i)).isSelected = false;
          break label262;
        }
        paramView = (ApolloTagButtonData)ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter).get(this.jdField_a_of_type_Int);
        if (((ApolloTagButtonData)ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter).get(this.jdField_a_of_type_Int)).isSelected) {
          break label269;
        }
        bool = true;
        paramView.isSelected = bool;
        paramView = this.jdField_a_of_type_AndroidWidgetButton.getText().toString();
        bool = ((ApolloTagButtonData)ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter).get(this.jdField_a_of_type_Int)).isSelected;
        if (bool) {
          ApolloDtReportUtil.a.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter.a.d), paramView);
        } else {
          ApolloDtReportUtil.a.remove(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter.a.d));
        }
        ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter, ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter, paramView));
        ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter, bool);
        this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter.a.a(paramView, bool);
        this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter.notifyDataSetChanged();
        return;
      }
      catch (Exception paramView)
      {
        QLog.e("[cmshow]ApolloActionTagsAdapter", 1, paramView, new Object[0]);
      }
      return;
      label262:
      i += 1;
      continue;
      label269:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.ApolloActionTagsAdapter.1
 * JD-Core Version:    0.7.0.1
 */