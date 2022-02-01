package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class GrayTipsItemBuilder$26
  extends ClickableSpan
{
  GrayTipsItemBuilder$26(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.isNetSupport(this.a.jdField_a_of_type_AndroidContentContext))
    {
      paramView = (FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramView.gatherContacts((short)1, localArrayList, false);
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692183), 1).b(((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.26
 * JD-Core Version:    0.7.0.1
 */