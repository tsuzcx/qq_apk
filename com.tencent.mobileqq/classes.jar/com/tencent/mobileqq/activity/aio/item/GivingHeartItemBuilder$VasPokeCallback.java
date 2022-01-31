package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class GivingHeartItemBuilder$VasPokeCallback
  extends VasQuickUpdateManager.CallBacker
{
  public GivingHeartItemBuilder$VasPokeCallback(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    int i = 1;
    String str;
    if (paramLong == 21L)
    {
      paramString3 = "";
      paramString2 = Integer.valueOf(0);
      if (!paramString1.startsWith("poke.item.effect.")) {
        break label242;
      }
      str = paramString1.substring("poke.item.effect.".length(), paramString1.length());
      paramVasQuickUpdateManager = Integer.valueOf(str);
      paramString2 = paramVasQuickUpdateManager;
      paramString3 = str;
      if (!PokeItemHelper.c.contains(paramVasQuickUpdateManager)) {
        break label334;
      }
      PokeItemHelper.c.remove(paramVasQuickUpdateManager);
      paramString3 = str;
      paramString2 = paramVasQuickUpdateManager;
      paramInt2 = 1;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString3)) && (paramInt2 != 0) && (!PokeItemHelper.c.contains(paramString2)) && (!PokeItemHelper.c.contains(paramString2)))
      {
        if (PokeItemHelper.a("bubble", paramString2.intValue())) {
          break label315;
        }
        paramInt2 = 1;
        label142:
        if (PokeItemHelper.a("/normal.png", paramString2.intValue())) {
          break label321;
        }
        label155:
        boolean bool = PokeItemHelper.b.contains(paramString2);
        paramString3 = this.a.a;
        if ((paramInt2 == 0) || (i == 0) || (!bool)) {
          break label327;
        }
      }
      label315:
      label321:
      label327:
      for (paramString2 = "戳一戳动画下载失败，请稍候重试。";; paramString2 = "")
      {
        VasUtils.a(paramString3, paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, "vas poke download id: " + paramString1 + " , errorcode: " + paramInt1);
        }
        return;
        label242:
        if (!paramString1.startsWith("poke.item.res.")) {
          break label334;
        }
        str = paramString1.substring("poke.item.res.".length(), paramString1.length());
        paramVasQuickUpdateManager = Integer.valueOf(str);
        paramString2 = paramVasQuickUpdateManager;
        paramString3 = str;
        if (!PokeItemHelper.d.contains(paramVasQuickUpdateManager)) {
          break label334;
        }
        PokeItemHelper.d.remove(paramVasQuickUpdateManager);
        paramString3 = str;
        paramString2 = paramVasQuickUpdateManager;
        paramInt2 = 1;
        break;
        paramInt2 = 0;
        break label142;
        i = 0;
        break label155;
      }
      label334:
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.VasPokeCallback
 * JD-Core Version:    0.7.0.1
 */