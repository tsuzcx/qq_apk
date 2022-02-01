package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class PokePanel$4
  implements IApolloExtensionObserver
{
  PokePanel$4(PokePanel paramPokePanel) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    Object localObject = (Bundle)paramObject;
    if (((Bundle)localObject).getInt("fromType") != 0) {
      return;
    }
    int i = ((Bundle)localObject).getInt("id");
    int j = ((Bundle)localObject).getInt("feeType");
    if (j == 4) {
      paramObject = "vip";
    } else if (j == 5) {
      paramObject = "svip";
    } else {
      paramObject = "free";
    }
    String str;
    if (paramBoolean)
    {
      str = ((Bundle)localObject).getString("name");
      localObject = ((Bundle)localObject).getString("minVersion");
      ChatActivityFacade.a(PokePanel.a(this.a), BaseApplicationImpl.getContext(), PokePanel.c(this.a), 126, i, str, (String)localObject);
      if (true == PokeItemHelper.l) {
        PokeItemHelper.l = false;
      }
    }
    for (;;)
    {
      break;
      long l = ((Bundle)localObject).getLong("result");
      str = ((Bundle)localObject).getString("msg");
      this.a.j = ((Bundle)localObject).getInt("id", 0);
      localObject = HardCodeUtil.a(2131906107);
      if (l == 0L)
      {
        this.a.k = 1;
        if (true == PokeItemHelper.l) {
          PokeItemHelper.l = false;
        }
        return;
      }
      if (l == 4002L)
      {
        this.a.k = 2;
        str = HardCodeUtil.a(2131906109);
      }
      for (;;)
      {
        break;
        if (l == 5002L)
        {
          this.a.k = 4;
          str = HardCodeUtil.a(2131906108);
        }
        else
        {
          this.a.k = 1;
          localObject = HardCodeUtil.a(2131899883);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("vas poke auth fail, result: ");
          localStringBuilder.append(l);
          QLog.e("Q.aio.PokePanel", 1, localStringBuilder.toString());
        }
      }
      if (l != 0L)
      {
        PokeItemHelper.a(PokePanel.a(this.a), (Activity)this.a.getContext(), str, (String)localObject, this.a.j, this.a.k);
        VasWebviewUtil.a("", "poke", "vipTip", "", 0, 0, 0, "", String.valueOf(i), paramObject, "", "", "", "", 0, 0, 0, 0);
      }
    }
    VasWebviewUtil.a("", "poke", "send", "", 0, paramBoolean ^ true, 0, "", String.valueOf(i), paramObject, "", "", "", "", 0, 0, 0, 0);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 23) {
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanel.4
 * JD-Core Version:    0.7.0.1
 */