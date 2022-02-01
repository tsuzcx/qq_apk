package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ChatHistoryTroopMemberFragment$34
  extends Handler
{
  ChatHistoryTroopMemberFragment$34(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.getBaseActivity() != null)
    {
      if (this.a.getBaseActivity().isFinishing()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("handleMessage,msg.what:");
        ((StringBuilder)???).append(paramMessage.what);
        QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)???).toString());
      }
      int i = paramMessage.what;
      boolean bool2 = true;
      double d1;
      double d2;
      int j;
      boolean bool1;
      switch (i)
      {
      case 3: 
      case 4: 
      case 10: 
      default: 
      case 15: 
        if ((this.a.L != null) && (this.a.L.isShowing()))
        {
          this.a.L.dismiss();
          return;
        }
        break;
      case 14: 
        this.a.aP.setVisibility(0);
        return;
      case 13: 
        paramMessage = this.a;
        paramMessage.bp += ChatHistoryTroopMemberFragment.bq;
        if ((this.a.bp > this.a.aR.getProgress()) && (this.a.bp < 90.0D) && (ChatHistoryTroopMemberFragment.m(this.a) > 0))
        {
          i = (int)this.a.bp;
          d1 = ChatHistoryTroopMemberFragment.m(this.a);
          d2 = this.a.bp;
          Double.isNaN(d1);
          j = (int)(d1 * d2 / 100.0D);
          paramMessage = this.a;
          ChatHistoryTroopMemberFragment.a(paramMessage, j, ChatHistoryTroopMemberFragment.m(paramMessage), i);
          this.a.bn.sendMessageDelayed(this.a.bn.obtainMessage(13), 800L);
          return;
        }
        break;
      case 12: 
        synchronized (this.a)
        {
          ChatHistoryTroopMemberFragment.n(this.a);
          Object localObject2 = (List)paramMessage.obj;
          if ((localObject2 == null) && (this.a.az != 14)) {
            return;
          }
          if (this.a.aP.getVisibility() == 0)
          {
            this.a.bn.removeMessages(13);
            i = paramMessage.arg1;
            d1 = i;
            Double.isNaN(d1);
            i = ChatHistoryTroopMemberFragment.m(this.a);
            d2 = i;
            Double.isNaN(d2);
            d1 = d1 * 1.0D / d2;
            d1 = Math.min(d1 + 0.9D, 1.0D);
            i = (int)(100.0D * d1);
            if (i > this.a.aR.getProgress())
            {
              j = ChatHistoryTroopMemberFragment.m(this.a);
              d2 = j;
              Double.isNaN(d2);
              j = (int)(d2 * d1);
              ChatHistoryTroopMemberFragment.a(this.a, j, ChatHistoryTroopMemberFragment.m(this.a), i);
            }
          }
          if (localObject2 != null) {
            this.a.J.addAll((Collection)localObject2);
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleMessage, mJobCount left:");
            ((StringBuilder)localObject2).append(ChatHistoryTroopMemberFragment.o(this.a));
            ((StringBuilder)localObject2).append("mATroopMemberList.size():");
            ((StringBuilder)localObject2).append(this.a.J.size());
            QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
          }
          if (ChatHistoryTroopMemberFragment.o(this.a) <= 0) {
            ChatHistoryTroopMemberFragment.b(this.a, true);
          }
          if ((ChatHistoryTroopMemberFragment.k(this.a)) && (ChatHistoryTroopMemberFragment.p(this.a)))
          {
            if (this.a.J.isEmpty()) {
              return;
            }
            this.a.D();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleMessage real totalTime:");
              ((StringBuilder)localObject2).append(System.currentTimeMillis() - ChatHistoryTroopMemberFragment.q(this.a));
              ((StringBuilder)localObject2).append("start refreshUI");
              QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject2).toString());
            }
            if (this.a.bc.getProxyManager() != null) {
              this.a.bc.getProxyManager().notifyRefreshTroopMember();
            }
            paramMessage.obj = this.a.K.b();
            ChatHistoryTroopMemberFragment.a(this.a, paramMessage);
          }
          return;
        }
      case 11: 
        paramMessage = (TroopInfo)paramMessage.obj;
        if (paramMessage.troopowneruin != null) {
          this.a.C = paramMessage.troopowneruin;
        }
        if (paramMessage.Administrator != null) {
          this.a.D = paramMessage.Administrator;
        }
        ??? = this.a;
        bool1 = bool2;
        if (!((ChatHistoryTroopMemberFragment)???).bc.getCurrentAccountUin().equals(paramMessage.troopowneruin)) {
          if ((this.a.D != null) && (this.a.D.contains(this.a.bc.getCurrentAccountUin()))) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        ((ChatHistoryTroopMemberFragment)???).t = bool1;
        if ((this.a.C != null) && (this.a.C.equals(this.a.bc.getCurrentAccountUin()))) {
          this.a.aK = "0";
        } else if ((this.a.D != null) && (this.a.D.contains(this.a.bc.getCurrentAccountUin()))) {
          this.a.aK = "1";
        }
        if (this.a.K != null)
        {
          this.a.K.c();
          return;
        }
        break;
      case 9: 
        if (this.a.K != null)
        {
          this.a.K.c();
          return;
        }
        break;
      case 8: 
        paramMessage = (Object[])paramMessage.obj;
        bool1 = ((Boolean)paramMessage[0]).booleanValue();
        paramMessage = (ArrayList)paramMessage[1];
        ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).inviteMember(this.a.getActivity(), this.a.w, bool1, paramMessage, 1);
        return;
      case 7: 
        if ((this.a.L != null) && (this.a.L.isShowing())) {
          this.a.L.dismiss();
        }
        QQToast.makeText(this.a.getBaseActivity(), this.a.getString(2131888431), 0).show(this.a.M.getHeight());
        return;
      case 6: 
        if (this.a.K != null)
        {
          if (this.a.K.e != null) {
            this.a.K.e.clear();
          }
          this.a.K.c();
        }
        if ((this.a.L != null) && (this.a.L.isShowing())) {
          this.a.L.dismiss();
        }
        QQToast.makeText(this.a.getBaseActivity(), this.a.getString(2131888432), 0).show(this.a.M.getHeight());
        ChatHistoryTroopMemberFragment.c(this.a);
        return;
      case 5: 
        this.a.D();
        return;
      case 2: 
        this.a.D();
      case 1: 
        ChatHistoryTroopMemberFragment.a(this.a, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.34
 * JD-Core Version:    0.7.0.1
 */