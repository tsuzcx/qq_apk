package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class GivingHeartItemBuilder$VasPokeCallback
  extends CallBacker
{
  public GivingHeartItemBuilder$VasPokeCallback(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramLong == 21L)
    {
      paramInt2 = 0;
      boolean bool1 = paramString1.startsWith("poke.item.effect.");
      String str = "";
      Object localObject1;
      Object localObject2;
      if (bool1)
      {
        localObject1 = paramString1.substring(17, paramString1.length());
        localObject2 = Integer.valueOf((String)localObject1);
        paramString2 = (String)localObject1;
        paramString3 = (String)localObject2;
        if (PokeItemHelper.c.contains(localObject2))
        {
          PokeItemHelper.c.remove(localObject2);
          paramString3 = (String)localObject2;
          paramString2 = (String)localObject1;
        }
      }
      else
      {
        for (;;)
        {
          paramInt2 = 1;
          break label166;
          if (!paramString1.startsWith("poke.item.res.")) {
            break;
          }
          localObject2 = paramString1.substring(14, paramString1.length());
          localObject1 = Integer.valueOf((String)localObject2);
          paramString2 = (String)localObject2;
          paramString3 = (String)localObject1;
          if (!PokeItemHelper.d.contains(localObject1)) {
            break label166;
          }
          PokeItemHelper.d.remove(localObject1);
          paramString2 = (String)localObject2;
          paramString3 = (String)localObject1;
        }
        paramString3 = Integer.valueOf(0);
        paramString2 = "";
      }
      label166:
      if ((!TextUtils.isEmpty(paramString2)) && (paramInt2 != 0) && (!PokeItemHelper.c.contains(paramString3)) && (!PokeItemHelper.c.contains(paramString3)))
      {
        bool1 = PokeItemHelper.a("bubble", paramString3.intValue());
        boolean bool2 = PokeItemHelper.a("/normal.png", paramString3.intValue());
        boolean bool3 = PokeItemHelper.b.contains(paramString3);
        paramString3 = this.a.a;
        paramString2 = str;
        if ((bool1 ^ true))
        {
          paramString2 = str;
          if ((bool2 ^ true))
          {
            paramString2 = str;
            if (bool3) {
              paramString2 = HardCodeUtil.a(2131705374);
            }
          }
        }
        VasUtils.a(paramString3, paramString2);
      }
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("vas poke download id: ");
        paramString2.append(paramString1);
        paramString2.append(" , errorcode: ");
        paramString2.append(paramInt1);
        QLog.d("GivingHeart", 2, paramString2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.VasPokeCallback
 * JD-Core Version:    0.7.0.1
 */