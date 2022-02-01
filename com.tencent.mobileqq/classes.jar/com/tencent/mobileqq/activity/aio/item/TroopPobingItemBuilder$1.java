package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.SpecWordEmotionThinkHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ConfigableWordingSetter;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;

class TroopPobingItemBuilder$1
  implements TroopPobingItemBuilder.Callback
{
  TroopPobingItemBuilder$1(TroopPobingItemBuilder paramTroopPobingItemBuilder) {}
  
  public void a(View paramView)
  {
    paramView = (TroopPobingItemBuilder.TroopPobingViewHolder)AIOUtils.b(paramView);
    TroopPobingItemBuilder.w = paramView.q.senderuin;
    Object localObject2 = ((BaseActivity)this.a.e).getChatFragment();
    Object localObject1 = ((TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER)).p();
    if ((localObject2 != null) && (((ChatFragment)localObject2).k() != null))
    {
      localObject2 = (TroopChatPie)((ChatFragment)localObject2).k();
      ((SpecWordEmotionThinkHelper)((TroopChatPie)localObject2).q(41)).a(1);
      ((TroopManager.ConfigableWordingSetter)localObject1).a(this.a.d, this.a.e, ((TroopChatPie)localObject2).Y, this.a.f.b, 0, paramView.q);
    }
    localObject1 = new ReportTask(this.a.d).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_welcome");
    localObject2 = paramView.q.frienduin;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.c(this.a.d, paramView.q.frienduin));
    ((ReportTask)localObject1).a(new String[] { localObject2, "", localStringBuilder.toString() }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击欢迎");
    }
    TroopPobingItemBuilder.a = 1;
  }
  
  public void b(View paramView)
  {
    paramView = (TroopPobingItemBuilder.TroopPobingViewHolder)AIOUtils.b(paramView);
    TroopPobingItemBuilder.w = paramView.q.senderuin;
    TroopManager.ConfigableWordingSetter localConfigableWordingSetter = ((TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER)).p();
    Object localObject = ((BaseActivity)this.a.e).getChatFragment();
    if ((localObject != null) && (((ChatFragment)localObject).k() != null))
    {
      localObject = (TroopChatPie)((ChatFragment)localObject).k();
      localConfigableWordingSetter.a(this.a.d, this.a.e, ((TroopChatPie)localObject).Y, this.a.f.b, 1, paramView.q);
    }
    new ReportTask(this.a.d).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_play").a(new String[] { paramView.q.frienduin }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击撩一下");
    }
    TroopPobingItemBuilder.a = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */