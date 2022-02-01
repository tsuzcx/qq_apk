package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class PublicAccountUtilImpl$3
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountUtilImpl$3(PublicAccountUtilImpl paramPublicAccountUtilImpl, QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean, Context paramContext, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (this.jdField_a_of_type_JavaLangString.equals("2010741172")))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        if (paramView != null)
        {
          paramView = XMLMessageUtils.a(paramView);
          if (paramView != null)
          {
            paramView = (PAMessage.Item)paramView.items.get(0);
            if (paramView.url != null) {
              PublicAccountUtilImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.url);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_Boolean) {
          PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_9", "aio_delete");
        } else {
          PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_8", "aio_delete");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_9", "aio_delete");
      } else {
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_8", "aio_delete");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.3
 * JD-Core Version:    0.7.0.1
 */