package com.tencent.biz.pubaccount.ecshopassit.aio;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.ecshopassit.EcshopNewServlet;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils;
import com.tencent.biz.pubaccount.ecshopassit.utils.ReportUtil;
import com.tencent.biz.pubaccount.ecshopassit.view.MinusViewBotomView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet;

public class EcshopMinusViewChatPie
  implements IEcshopChatPie
{
  private List<ChatMessage> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  private void a(List<ChatMessage> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      paramList = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((paramList != null) && (EcshopUtils.a(EcshopUtils.a(paramList)))) {
        this.jdField_a_of_type_JavaUtilList.remove(paramList);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {
      paramContext.sendBroadcast(new Intent("com.tencent.biz.pubaccount.ecshop.tabpage.finish"));
    }
    ReportUtil.a().a.clear();
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    EcshopUtils.a(paramMessageRecord.uniseq);
  }
  
  public void a(List<ChatMessage> paramList, IEcshopChatPie.IRefreshCallback paramIRefreshCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopMinusViewChatPie", 2, "messageArrayList.size: " + this.jdField_a_of_type_JavaUtilList.size());
    }
    a(paramList);
    paramList = EcshopUtils.a(paramList);
    if ((paramList != null) && (EcshopUtils.a(EcshopUtils.a(paramList))))
    {
      paramList.saveExtInfoToExtStr("add_title", "minus_view_title_first");
      this.jdField_a_of_type_JavaUtilList.add(0, paramList);
    }
    if (paramIRefreshCallback != null) {
      paramIRefreshCallback.a(this.jdField_a_of_type_JavaUtilList);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    paramList = new qq_ad.QQAdGet();
    try
    {
      if (EcshopUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime())) {
        paramList.trigger_type.set(22);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EcshopMinusViewChatPie", 2, "<<<<<<<<<<<<<<sendRequest<<<<<<<<<");
        }
        EcshopNewServlet.a(paramList.toByteArray(), "trpc.qqshop.adpush.PushService.GetAd", new EcshopMinusViewChatPie.1(this, paramIRefreshCallback));
        return;
        paramList.trigger_type.set(18);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramList.trigger_type.set(22);
      }
    }
  }
  
  public boolean a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    paramContext = new MinusViewBotomView(paramContext);
    paramContext.setTag("echopMinusViewBotomView");
    paramContext.setBtnText(EcshopConfUtil.a());
    paramRelativeLayout.addView(paramContext);
    paramContext = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
    if (paramContext != null)
    {
      paramContext.width = -1;
      paramContext.height = -2;
      paramContext.addRule(12);
    }
    return true;
  }
  
  public boolean a(RelativeLayout paramRelativeLayout)
  {
    return (paramRelativeLayout != null) && (paramRelativeLayout.findViewWithTag("echopMinusViewBotomView") != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.aio.EcshopMinusViewChatPie
 * JD-Core Version:    0.7.0.1
 */