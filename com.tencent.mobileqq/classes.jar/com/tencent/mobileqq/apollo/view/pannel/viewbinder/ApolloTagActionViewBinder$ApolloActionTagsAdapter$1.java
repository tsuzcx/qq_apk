package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.data.ApolloTagButtonData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

class ApolloTagActionViewBinder$ApolloActionTagsAdapter$1
  implements View.OnClickListener
{
  ApolloTagActionViewBinder$ApolloActionTagsAdapter$1(ApolloTagActionViewBinder.ApolloActionTagsAdapter paramApolloActionTagsAdapter, Button paramButton, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_AndroidWidgetButton.getText() == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter).size())
        {
          if (i == this.jdField_a_of_type_Int) {
            break label284;
          }
          ((ApolloTagButtonData)ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter).get(i)).isSelected = false;
          break label284;
        }
        Object localObject = (ApolloTagButtonData)ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter).get(this.jdField_a_of_type_Int);
        if (((ApolloTagButtonData)ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter).get(this.jdField_a_of_type_Int)).isSelected) {
          break label256;
        }
        bool = true;
        ((ApolloTagButtonData)localObject).isSelected = bool;
        localObject = this.jdField_a_of_type_AndroidWidgetButton.getText().toString();
        bool = ((ApolloTagButtonData)ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter).get(this.jdField_a_of_type_Int)).isSelected;
        if (!bool) {
          break label261;
        }
        ApolloDtReportUtil.a.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter.a.d), localObject);
        ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter, ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter, (String)localObject));
        ApolloTagActionViewBinder.ApolloActionTagsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter, bool);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter.a.a((String)localObject, bool);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter.notifyDataSetChanged();
      }
      catch (Exception localException)
      {
        QLog.e("ApolloActionTagsAdapter", 1, localException, new Object[0]);
      }
      break;
      label256:
      boolean bool = false;
      continue;
      label261:
      ApolloDtReportUtil.a.remove(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder$ApolloActionTagsAdapter.a.d));
      continue;
      label284:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.ApolloActionTagsAdapter.1
 * JD-Core Version:    0.7.0.1
 */