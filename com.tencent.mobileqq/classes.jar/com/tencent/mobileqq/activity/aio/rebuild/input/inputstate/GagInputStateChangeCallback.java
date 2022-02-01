package com.tencent.mobileqq.activity.aio.rebuild.input.inputstate;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;

public class GagInputStateChangeCallback
  implements IInputStateChangeCallback
{
  protected TextView a;
  
  public void a(int paramInt, AIOContext paramAIOContext)
  {
    if (paramInt == 0)
    {
      paramAIOContext = this.a;
      if (paramAIOContext != null) {
        paramAIOContext.setVisibility(8);
      }
    }
    else if (paramInt == 2)
    {
      Object localObject2 = (FullScreenInputHelper)paramAIOContext.a(24);
      if (this.a == null)
      {
        localObject1 = new TextView(paramAIOContext.b());
        ((TextView)localObject1).setId(2131433932);
        ((TextView)localObject1).setBackgroundResource(2130851969);
        ((TextView)localObject1).setTextSize(1, 17.0F);
        ((TextView)localObject1).setTextColor(paramAIOContext.b().getResources().getColor(2131167971));
        ((TextView)localObject1).setEnabled(false);
        ((TextView)localObject1).setGravity(17);
        paramInt = ((ViewGroup)((FullScreenInputHelper)localObject2).b.getParent()).indexOfChild(((FullScreenInputHelper)localObject2).b);
        localObject2 = new LinearLayout.LayoutParams(paramAIOContext.p().d().f().k(), -2);
        ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(14.0F, paramAIOContext.b().getResources());
        ((LinearLayout.LayoutParams)localObject2).gravity = 80;
        paramAIOContext.p().d().e().a((View)localObject1, paramInt, (ViewGroup.LayoutParams)localObject2);
        this.a = ((TextView)localObject1);
        this.a.setVisibility(8);
      }
      Object localObject1 = ((TroopGagMgr)paramAIOContext.a().getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramAIOContext.O().b, true);
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fightgag.doDisableInputStat text");
        ((StringBuilder)localObject2).append(((SelfGagInfo)localObject1).c);
        QLog.d("GagInputStateChangeCallback", 1, ((StringBuilder)localObject2).toString());
        this.a.setText(((SelfGagInfo)localObject1).c);
        if (paramAIOContext.q().b() == 2) {
          paramAIOContext.q().a(true);
        }
      }
      paramAIOContext = this.a;
      if (paramAIOContext != null) {
        paramAIOContext.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.GagInputStateChangeCallback
 * JD-Core Version:    0.7.0.1
 */