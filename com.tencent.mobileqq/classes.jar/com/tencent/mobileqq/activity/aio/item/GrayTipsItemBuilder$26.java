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
    if (NetworkUtil.isNetSupport(this.a.c))
    {
      paramView = (FriendListHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.a.d.b);
      paramView.gatherContacts((short)1, localArrayList, false);
      return;
    }
    QQToast.makeText(this.a.c, this.a.c.getResources().getString(2131889169), 1).show(((BaseActivity)this.a.c).getTitleBarHeight());
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.26
 * JD-Core Version:    0.7.0.1
 */