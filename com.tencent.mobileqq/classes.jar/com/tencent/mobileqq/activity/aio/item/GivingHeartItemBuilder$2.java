package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class GivingHeartItemBuilder$2
  implements IApolloExtensionObserver
{
  GivingHeartItemBuilder$2(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    Object localObject = (Bundle)paramObject;
    if (1 != ((Bundle)localObject).getInt("fromType")) {
      return;
    }
    int i = ((Bundle)localObject).getInt("id");
    int j = ((Bundle)localObject).getInt("feeType");
    if (4 == j) {
      paramObject = "vip";
    } else if (5 == j) {
      paramObject = "svip";
    } else {
      paramObject = "free";
    }
    String str;
    if (paramBoolean)
    {
      str = ((Bundle)localObject).getString("name");
      localObject = ((Bundle)localObject).getString("minVersion");
      ChatActivityFacade.a(this.a.w, BaseApplicationImpl.getContext(), this.a.f, 126, i, str, (String)localObject);
      if (true == PokeItemHelper.l) {
        PokeItemHelper.l = false;
      }
    }
    else
    {
      long l = ((Bundle)localObject).getLong("result");
      str = ((Bundle)localObject).getString("msg");
      this.a.C = ((Bundle)localObject).getInt("id", 0);
      localObject = HardCodeUtil.a(2131903249);
      if (l == 0L)
      {
        this.a.D = 1;
        if (true == PokeItemHelper.l) {
          PokeItemHelper.l = false;
        }
        return;
      }
      if (l == 4002L)
      {
        this.a.D = 2;
        str = HardCodeUtil.a(2131903253);
      }
      for (;;)
      {
        break;
        if (l == 5002L)
        {
          this.a.D = 4;
          str = HardCodeUtil.a(2131903252);
        }
        else
        {
          this.a.D = 1;
          localObject = HardCodeUtil.a(2131899883);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("vas poke auth fail, result: ");
          localStringBuilder.append(l);
          QLog.e("GivingHeart", 1, localStringBuilder.toString());
        }
      }
      if (l != 0L)
      {
        PokeItemHelper.a(this.a.w, (Activity)this.a.e, str, (String)localObject, this.a.C, this.a.D);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */