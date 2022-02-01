package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class PokePanel$3
  extends CallBacker
{
  PokePanel$3(PokePanel paramPokePanel) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramLong == 21L)
    {
      boolean bool3 = paramString1.equals("poke.effectList");
      paramString3 = "poke.item.res.";
      paramString2 = "";
      boolean bool2 = false;
      boolean bool1 = false;
      if ((bool3) && (paramInt1 == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.PokePanel", 2, "download vas poke list, refresh now.");
        }
        paramString1 = PokePanel.a(this.a);
        ThreadManager.getUIHandler().post(new PokePanel.3.1(this, paramString1));
      }
      else
      {
        if (paramString1.startsWith("poke.item.effect."))
        {
          paramString2 = paramString1.substring(17, paramString1.length());
          if (paramInt1 != 0) {
            bool1 = true;
          }
          paramString1 = "poke.item.effect.";
          break label173;
        }
        if (paramString1.startsWith("poke.item.res."))
        {
          String str = paramString1.substring(14, paramString1.length());
          paramString1 = paramString3;
          paramString2 = str;
          bool1 = bool2;
          if (paramInt1 == 0) {
            break label173;
          }
          bool1 = true;
          paramString1 = paramString3;
          paramString2 = str;
          break label173;
        }
      }
      paramString1 = "";
      bool1 = bool2;
      label173:
      if (!TextUtils.isEmpty(paramString1)) {
        ThreadManager.getUIHandler().post(new PokePanel.3.2(this, paramString1, paramString2, bool1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanel.3
 * JD-Core Version:    0.7.0.1
 */