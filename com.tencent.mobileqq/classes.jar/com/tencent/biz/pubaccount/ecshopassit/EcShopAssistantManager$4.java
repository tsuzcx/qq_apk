package com.tencent.biz.pubaccount.ecshopassit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.os.MqqHandler;

class EcShopAssistantManager$4
  extends BroadcastReceiver
{
  EcShopAssistantManager$4(EcShopAssistantManager paramEcShopAssistantManager) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (this.a.c == null) {
        return;
      }
      ??? = paramIntent.getAction();
      Object localObject;
      if ("action_get_PA_head".equals(???))
      {
        ??? = paramIntent.getStringExtra("uin");
        if (!TextUtils.isEmpty(???))
        {
          if (this.a.E == null) {
            return;
          }
          paramIntent = this.a.E.getBitmapFromCache(1, ???);
          if (paramIntent != null)
          {
            localObject = new Intent("action_decode_finish");
            ((Intent)localObject).putExtra("bitmap", paramIntent);
            ((Intent)localObject).putExtra("uin", ???);
            BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
            return;
          }
          this.a.E.requestDecodeFace(???, 1, true);
          return;
        }
        return;
      }
      int i;
      if ("action_shop_set_read".equals(???))
      {
        localObject = paramIntent.getStringExtra("uin");
        i = paramIntent.getIntExtra("unReadNum", 0);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        bool = paramIntent.getBooleanExtra("needDelete", false);
        synchronized (EcShopAssistantManager.b(this.a))
        {
          paramIntent = (EcShopData)EcShopAssistantManager.b(this.a).get(localObject);
          if (paramIntent == null) {
            break label953;
          }
          ??? = null;
          paramIntent = this.a.c.getMessageFacade();
          if (paramIntent != null) {
            ??? = paramIntent.getLastMessage((String)localObject, 1008);
          }
          if (??? != null)
          {
            RecentUtil.b(this.a.c, (String)localObject, 1008);
            paramIntent = this.a.c.getConversationFacade();
            if (paramIntent != null) {
              paramIntent.a(???.frienduin, ???.istroop, true);
            }
          }
          if (!bool) {
            break label953;
          }
          this.a.c((String)localObject);
          if (((String)localObject).equals(EcShopAssistantManager.s))
          {
            l = EcShopAssistantManager.j().getLong("ad_id", 0L);
            ??? = (EcshopReportHandler)this.a.c.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
            if (??? != null) {
              ???.a(134246438, null, null, null, null, l, false);
            }
            ??? = EcShopAssistantManager.j().edit();
            ???.remove("ad_id");
            ???.putBoolean("is_ad_added", false);
            ???.commit();
            EcShopAssistantManager.s = "";
            return;
          }
          ??? = new StringBuilder();
          ???.append("");
          ???.append(i);
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", (String)localObject, "0X80064D2", "0X80064D2", 0, 0, ???.toString(), "", "", "");
          return;
        }
      }
      if ("action_folder_set_read".equals(???))
      {
        ??? = paramIntent.getStringExtra("uin");
        if (!TextUtils.isEmpty(???))
        {
          ??? = this.a.c.getMessageFacade().getLastMessage(???, 1008);
          if (??? != null) {
            this.a.a(???.time);
          }
        }
        ??? = EcShopAssistantManager.j();
        this.a.B = false;
        if (???.getBoolean("folder_reddot", false)) {
          ???.edit().putBoolean("folder_reddot", false).commit();
        }
        ??? = this.a.c.getHandler(Conversation.class);
        if (??? != null) {
          ???.sendEmptyMessage(1009);
        }
      }
      else
      {
        if ("action_folder_destroy".equals(???))
        {
          if (paramIntent.getLongExtra("stay_time", 0L) >= this.a.x) {
            EcShopAssistantManager.j().edit().putLong("last_stay_folder", System.currentTimeMillis());
          }
          this.a.G = false;
          return;
        }
        if ("action_folder_msg_change".equals(???))
        {
          ??? = paramIntent.getStringExtra("msg");
          i = paramIntent.getIntExtra("type", -1);
          paramIntent = this.a.c();
          if ((!TextUtils.isEmpty(???)) && (paramIntent != null))
          {
            paramIntent = EcShopAssistantManager.j().edit();
            paramIntent.putString("str_ecshop_diy", ???);
            paramIntent.putInt("last_show_time1", (int)(System.currentTimeMillis() / 1000L));
            paramIntent.putInt("FOLDER_MSG_TYPE", i);
            paramIntent.putString("PUSH_JUMP_URL", "");
            paramIntent.commit();
          }
        }
        else
        {
          if ("action_set_folder_tab_red".equals(???))
          {
            EcShopAssistantManager.j().edit().putBoolean("folder_tab_red", true).commit();
            return;
          }
          if ("action_follow_status".equals(???))
          {
            ??? = paramIntent.getStringExtra("puin");
            if (TextUtils.isEmpty(???)) {}
          }
        }
      }
    }
    try
    {
      l = Long.parseLong(???);
    }
    catch (Exception paramIntent)
    {
      label813:
      break label813;
    }
    long l = -1L;
    if (l == -1L) {
      return;
    }
    boolean bool = ((IPublicAccountDataManager)this.a.c.getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(l));
    paramIntent = new Intent("action_follow_status_finish");
    paramIntent.putExtra("isFollow", bool);
    paramIntent.putExtra("uin", String.valueOf(l));
    BaseApplicationImpl.getContext().sendBroadcast(paramIntent);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("follow_status uin:");
      paramIntent.append(???);
      paramIntent.append(",isfollow:");
      paramIntent.append(bool);
      QLog.i("EcShopAssistantManager", 2, paramIntent.toString());
    }
    label953:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.4
 * JD-Core Version:    0.7.0.1
 */