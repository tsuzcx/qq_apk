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
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (this.b.equals("2010741172")))
      {
        paramView = this.a.getMessageFacade().a(this.b, this.c, this.d);
        if (paramView != null)
        {
          paramView = XMLMessageUtils.a(paramView);
          if (paramView != null)
          {
            paramView = (PAMessage.Item)paramView.items.get(0);
            if (paramView.url != null) {
              PublicAccountUtilImpl.access$100(this.a, this.f, paramView.url);
            }
          }
        }
        this.a.getMessageFacade().h(this.b, this.c, this.d);
        if (this.e) {
          PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.a, this.b, "Pb_account_lifeservice", "mp_msg_sys_9", "aio_delete");
        } else {
          PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.a, this.b, "Pb_account_lifeservice", "mp_msg_sys_8", "aio_delete");
        }
        this.a.getMessageFacade().g(this.b, this.c);
      }
    }
    else
    {
      this.a.getMessageFacade().h(this.b, this.c, this.d);
      if (this.e) {
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.a, this.b, "Pb_account_lifeservice", "mp_msg_sys_9", "aio_delete");
      } else {
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.a, this.b, "Pb_account_lifeservice", "mp_msg_sys_8", "aio_delete");
      }
      this.a.getMessageFacade().g(this.b, this.c);
    }
    this.g.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.3
 * JD-Core Version:    0.7.0.1
 */