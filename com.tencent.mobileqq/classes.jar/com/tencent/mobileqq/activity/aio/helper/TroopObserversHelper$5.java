package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troopAddFrd.Scene;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopObserversHelper$5
  extends TroopObserver
{
  TroopObserversHelper$5(TroopObserversHelper paramTroopObserversHelper) {}
  
  private void a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo != null) && (TroopObserversHelper.b(this.a).a == 1) && (TroopObserversHelper.b(this.a).b.equals(paramTroopInfo.troopuin)))
    {
      TroopObserversHelper.b(this.a).e = paramTroopInfo.getTroopDisplayName();
      TroopObserversHelper.d(this.a).C.setText(TroopObserversHelper.b(this.a).e);
      if (AppSetting.e)
      {
        paramTroopInfo = TroopObserversHelper.d(this.a).C.getText().toString();
        TroopObserversHelper.d(this.a).C.setContentDescription(paramTroopInfo);
        TroopObserversHelper.g(this.a).setTitle(TroopObserversHelper.d(this.a).C.getText());
      }
    }
  }
  
  protected void onBatchTroopCardDefaultNick(boolean paramBoolean, Object paramObject)
  {
    TroopObserversHelper.d(this.a).j().removeMessages(24);
    Object localObject = TroopObserversHelper.d(this.a).ao;
    int i = 1;
    if ((localObject != null) && (TroopObserversHelper.d(this.a).ao.isShowing()))
    {
      if ((TroopObserversHelper.d(this.a).ao != null) && (MultiMsgManager.a().e != 2)) {
        TroopObserversHelper.d(this.a).ao.dismiss();
      }
      MultiMsgManager.a().d.clear();
      if ((paramBoolean) && (paramObject != null))
      {
        MultiMsgManager.a().d.putAll((Map)paramObject);
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onBatchTroopCardDefaultNick = ");
          ((StringBuilder)localObject).append(paramObject);
          QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isDevelopLevel())
      {
        QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
      }
      if (MultiMsgManager.a().d.size() == 0)
      {
        QQToast.makeText(TroopObserversHelper.g(this.a), 2131896472, 0).show(TroopObserversHelper.g(this.a).getTitleBarHeight());
        return;
      }
      if (paramObject != null)
      {
        if (MultiMsgManager.a().e == 6)
        {
          ((MultiFavoriteHelper)TroopObserversHelper.d(this.a).q(11)).a((Map)paramObject, MultiMsgManager.a().c, MultiMsgManager.a().e);
          return;
        }
        ((MultiForwardHelper)TroopObserversHelper.d(this.a).q(1)).a((Map)paramObject, MultiMsgManager.a().c, MultiMsgManager.a().e);
      }
      return;
    }
    localObject = new HashMap();
    if ((!paramBoolean) && ((paramObject instanceof Integer))) {
      i = ((Integer)paramObject).intValue();
    } else if (paramBoolean) {
      i = 0;
    }
    paramObject = new StringBuilder();
    paramObject.append(i);
    paramObject.append("");
    ((HashMap)localObject).put("result", paramObject.toString());
    paramObject = new StringBuilder();
    paramObject.append(NetworkUtil.getSystemNetwork(BaseApplication.getContext()));
    paramObject.append("");
    ((HashMap)localObject).put("netType", paramObject.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(TroopObserversHelper.a(this.a).getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, (HashMap)localObject, "");
  }
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    if ((TroopObserversHelper.b(this.a).a == 1) && (TroopObserversHelper.b(this.a).b.equals(paramString1)))
    {
      TroopObserversHelper.b(this.a).e = paramString2;
      TroopObserversHelper.d(this.a).C.setText(paramString2);
      if (AppSetting.e)
      {
        TroopObserversHelper.d(this.a).C.setContentDescription(paramString2);
        TroopObserversHelper.d(this.a).aX().setTitle(paramString2);
      }
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      a(((TroopManager)TroopObserversHelper.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).f(paramString));
    }
  }
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    TroopObserversHelper.a(this.a, paramBoolean, paramObject);
  }
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      if ((TroopObserversHelper.b(this.a).a == 1000) || (TroopObserversHelper.b(this.a).a == 1020))
      {
        int i = 0;
        while (i < paramArrayList.size())
        {
          TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
          if ((localTroopMemberCardInfo != null) && (TroopObserversHelper.b(this.a).b.equals(localTroopMemberCardInfo.memberuin)))
          {
            String str = localTroopMemberCardInfo.name;
            if (str != null)
            {
              paramArrayList = str;
              if (!"".equals(str)) {}
            }
            else
            {
              paramArrayList = localTroopMemberCardInfo.nick;
            }
            if ((paramArrayList == null) || ("".equals(paramArrayList))) {
              break;
            }
            TroopObserversHelper.b(this.a).e = paramArrayList;
            TroopObserversHelper.d(this.a).C.setText(TroopObserversHelper.b(this.a).e);
            if (!AppSetting.e) {
              break;
            }
            paramArrayList = TroopObserversHelper.d(this.a).C.getText().toString();
            TroopObserversHelper.d(this.a).C.setContentDescription(paramArrayList);
            TroopObserversHelper.g(this.a).setTitle(TroopObserversHelper.d(this.a).C.getText());
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), TroopObserversHelper.b(this.a).b)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(150);
      localStringBuilder.append("onOIDB0X899_0_Ret");
      localStringBuilder.append("| isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("| troopuin = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("| nFlag = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("| strErorMsg = ");
      localStringBuilder.append(paramString);
      QLog.i("TroopObserversHelper", 2, localStringBuilder.toString());
    }
    if ((paramInt1 == 2) && (paramBoolean)) {
      TroopObserversHelper.a(this.a, paramList);
    }
  }
  
  protected void onTroopBatchAddFrdsReadyForTip(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    Object localObject = TroopObserversHelper.g(this.a).getIntent().getStringExtra("uin");
    boolean bool = false;
    QLog.i("TroopObserversHelper", 1, String.format("troopBatchAddFrd.onTroopBatchAddFrdsReadyForTip suc_troopUin_type_intentUIn=%b_%s_%d_%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt), localObject }));
    if ((paramBoolean) && (Scene.a(paramInt)) && (paramString.equalsIgnoreCase((String)localObject))) {
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 5))
      {
        if ((paramInt == 4) && (paramList != null) && (paramList.size() > 0))
        {
          if (!TroopObserversHelper.d(this.a).ck)
          {
            localObject = (String)paramList.get(0);
            bool = TroopObserversHelper.d(this.a).e((String)localObject);
            localObject = (TroopAddFriendTipsHelper)TroopObserversHelper.d(this.a).q(28);
            paramBoolean = bool;
            if (localObject != null)
            {
              ((TroopAddFriendTipsHelper)localObject).a(bool, paramString);
              paramBoolean = bool;
            }
          }
          else
          {
            TroopObserversHelper.d(this.a).g((String)paramList.get(0));
            paramBoolean = bool;
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("onTroopBatchAddFrdsReadyForTip  isScrolling = ");
            paramString.append(TroopObserversHelper.d(this.a).ck);
            paramString.append(",visible = ");
            paramString.append(paramBoolean);
            paramString.append(",targetUins = ");
            paramString.append(paramList);
            QLog.d("TroopObserversHelper", 2, paramString.toString());
          }
        }
      }
      else
      {
        paramList = (TroopAddFriendTipsHelper)TroopObserversHelper.d(this.a).q(28);
        if (paramList != null) {
          paramList.a(true, paramString);
        }
      }
    }
  }
  
  protected void onTroopInfoUpdate(String paramString)
  {
    if ((paramString != null) && (paramString.equals(TroopObserversHelper.b(this.a).b)))
    {
      paramString = ((TroopManager)TroopObserversHelper.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).g(paramString);
      if (paramString != null)
      {
        TroopObserversHelper.b(this.a).e = paramString.getTroopDisplayName();
        Object localObject = TroopObserversHelper.g(this.a).getIntent();
        ((Intent)localObject).putExtra("uinname", paramString.getTroopDisplayName());
        TroopObserversHelper.d(this.a).c((Intent)localObject);
        TroopObserversHelper.d(this.a).bW();
        localObject = TroopObserversHelper.f(this.a);
        if (localObject != null) {
          ((TroopClassControllerManager)localObject).a(paramString.dwGroupClassExt, true, TroopObserversHelper.d(this.a), TroopObserversHelper.b(this.a).b);
        }
        TroopObserversHelper.h(this.a);
        TroopObserversHelper.d(this.a).bI();
        ((StudyRoomManager)TroopObserversHelper.a(this.a).getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(TroopObserversHelper.b(this.a).b);
      }
    }
  }
  
  protected void onUpdateRecentList()
  {
    TroopObserversHelper.d(this.a).bI();
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    TroopBlockDialogHelper localTroopBlockDialogHelper = (TroopBlockDialogHelper)TroopObserversHelper.d(this.a).q(76);
    if (localTroopBlockDialogHelper != null) {
      localTroopBlockDialogHelper.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.5
 * JD-Core Version:    0.7.0.1
 */