package com.tencent.biz.pubaccount.ecshopassit.view;

import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean.TabConfBean;

class CustomTitleView$6
  implements EcshopMenuDialog.OnClickActionListener
{
  CustomTitleView$6(CustomTitleView paramCustomTitleView) {}
  
  public void a(EcshopMenuDialog.ViewTag paramViewTag)
  {
    if (paramViewTag != null)
    {
      EcshopConfBean.TabConfBean localTabConfBean = paramViewTag.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$TabConfBean;
      paramViewTag = paramViewTag.jdField_a_of_type_ComTencentBizPubaccountEcshopassitRedPointInfo;
      CustomTitleView.a(this.a, localTabConfBean, paramViewTag);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTitleView.6
 * JD-Core Version:    0.7.0.1
 */