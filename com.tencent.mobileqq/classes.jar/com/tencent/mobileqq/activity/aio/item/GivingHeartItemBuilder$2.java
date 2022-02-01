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
      ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 126, i, str, (String)localObject);
      if (true == PokeItemHelper.a) {
        PokeItemHelper.a = false;
      }
    }
    else
    {
      long l = ((Bundle)localObject).getLong("result");
      str = ((Bundle)localObject).getString("msg");
      this.a.jdField_a_of_type_Int = ((Bundle)localObject).getInt("id", 0);
      localObject = HardCodeUtil.a(2131705367);
      if (l == 0L)
      {
        this.a.d = 1;
        if (true == PokeItemHelper.a) {
          PokeItemHelper.a = false;
        }
        return;
      }
      if (l == 4002L)
      {
        this.a.d = 2;
        str = HardCodeUtil.a(2131705372);
      }
      for (;;)
      {
        break;
        if (l == 5002L)
        {
          this.a.d = 4;
          str = HardCodeUtil.a(2131705371);
        }
        else
        {
          this.a.d = 1;
          localObject = HardCodeUtil.a(2131705370);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("vas poke auth fail, result: ");
          localStringBuilder.append(l);
          QLog.e("GivingHeart", 1, localStringBuilder.toString());
        }
      }
      if (l != 0L)
      {
        PokeItemHelper.a(this.a.b, (Activity)this.a.jdField_a_of_type_AndroidContentContext, str, (String)localObject, this.a.jdField_a_of_type_Int, this.a.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */