package com.tencent.biz.pubaccount;

import android.view.View;
import com.tencent.biz.ui.MenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class PublicAccountMenuBar$2
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountMenuBar$2(PublicAccountMenuBar paramPublicAccountMenuBar, List paramList, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    try
    {
      if (PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar)) {
        return;
      }
      PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar, true);
      if (paramInt == 0)
      {
        PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar, false);
        return;
      }
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      return;
    }
    paramView = (MenuItem)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    if (paramView == null)
    {
      PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar, false);
      return;
    }
    PublicAccountMenuBar.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountMenuBar, paramView);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountMenuBar.2
 * JD-Core Version:    0.7.0.1
 */