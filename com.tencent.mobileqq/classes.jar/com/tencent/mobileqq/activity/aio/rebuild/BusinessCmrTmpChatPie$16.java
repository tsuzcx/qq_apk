package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.controller.QidianHandler.NavigationMenuConfig;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class BusinessCmrTmpChatPie$16
  extends QidianBusinessObserver
{
  BusinessCmrTmpChatPie$16(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void a(boolean paramBoolean, QidianHandler.NavigationMenuConfig paramNavigationMenuConfig)
  {
    if ((paramBoolean) && (paramNavigationMenuConfig != null))
    {
      if ((this.a.ah.b != null) && (this.a.ah.b.equals(String.valueOf(paramNavigationMenuConfig.c))))
      {
        int i = paramNavigationMenuConfig.a;
        paramBoolean = true;
        if (i == 1)
        {
          QidianPubAccountBigDataHandler localQidianPubAccountBigDataHandler = (QidianPubAccountBigDataHandler)this.a.d.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER);
          PubAccountNavigationMenu localPubAccountNavigationMenu = localQidianPubAccountBigDataHandler.a(this.a.ah.b);
          BusinessCmrTmpChatPie localBusinessCmrTmpChatPie = this.a;
          if (paramNavigationMenuConfig.b != 0) {
            paramBoolean = false;
          }
          BusinessCmrTmpChatPie.b(localBusinessCmrTmpChatPie, paramBoolean);
          if ((localPubAccountNavigationMenu != null) && (paramNavigationMenuConfig.b == localPubAccountNavigationMenu.version))
          {
            if (QLog.isColorLevel()) {
              QLog.d("BusinessChatPie", 2, "onGetNatigationStatus show directly");
            }
            if (BusinessCmrTmpChatPie.d(this.a) == 0)
            {
              this.a.a(localPubAccountNavigationMenu);
              return;
            }
            BusinessCmrTmpChatPie.a(this.a, 0);
            return;
          }
          localQidianPubAccountBigDataHandler.a(this.a.ah.b, paramNavigationMenuConfig.d);
          return;
        }
        if (paramNavigationMenuConfig.e == 1) {
          BusinessCmrTmpChatPie.a(this.a, 1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response no need show");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response not the same aio");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response error");
    }
  }
  
  protected void a(boolean paramBoolean, PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if (paramBoolean)
    {
      if ((!BusinessCmrTmpChatPie.e(this.a)) && (BusinessCmrTmpChatPie.d(this.a) != 0))
      {
        BusinessCmrTmpChatPie.a(this.a, 0);
        return;
      }
      this.a.a(paramPubAccountNavigationMenu);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onGetNatigation response error");
    }
  }
  
  protected void b(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if (this.a.ah.b.equals(paramHashMap.uin))
      {
        if ((TextUtils.isEmpty(this.a.ah.e)) || (this.a.ah.e.equals(this.a.ah.b)))
        {
          this.a.ah.e = paramHashMap.nickname;
          this.a.C.setText(this.a.ah.e);
        }
        this.a.z();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo not current uin");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo fail");
    }
  }
  
  protected void e(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    super.e(paramBoolean, paramHashMap);
    if ((paramBoolean) && (paramHashMap != null)) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt(String.valueOf(paramHashMap.get("result")));
        String.valueOf(paramHashMap.get("master_uin"));
        if ((this.a.ah.b != null) && (i == 1))
        {
          long l1 = Long.parseLong(this.a.ah.b);
          paramHashMap = ((QidianPubAccountBigDataHandler)this.a.d.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER)).a(this.a.ah.b);
          QidianHandler localQidianHandler = (QidianHandler)this.a.d.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
          long l2 = this.a.d.getLongAccountUin();
          if (paramHashMap != null)
          {
            i = paramHashMap.version;
            localQidianHandler.a(l1, l2, i, BusinessCmrTmpChatPie.d(this.a), false);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramHashMap)
      {
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.16
 * JD-Core Version:    0.7.0.1
 */