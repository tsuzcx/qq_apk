package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ApolloViewBinder$1
  implements AbsListView.OnScrollListener
{
  ApolloViewBinder$1(ApolloViewBinder paramApolloViewBinder) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramInt = paramAbsListView.getFirstVisiblePosition();
      if (paramInt > ApolloViewBinder.a(this.a)) {
        paramInt = 0;
      }
      break;
    }
    while ((paramInt >= 0) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "slideupdown", "", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), this.a.d, new String[] { String.valueOf(paramInt) });
      if (this.a.d != 9) {
        break;
      }
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "y_bqtabupdown", "", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" });
      return;
      if (ApolloViewBinder.a(this.a) > paramInt)
      {
        paramInt = 1;
        continue;
        ApolloViewBinder.a(this.a, paramAbsListView.getFirstVisiblePosition());
      }
      else
      {
        paramInt = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloViewBinder.1
 * JD-Core Version:    0.7.0.1
 */