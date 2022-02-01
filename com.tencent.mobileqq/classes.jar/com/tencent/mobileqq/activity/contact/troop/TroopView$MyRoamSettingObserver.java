package com.tencent.mobileqq.activity.contact.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import java.util.Map;

public class TroopView$MyRoamSettingObserver
  extends RoamSettingObserver
{
  protected TroopView$MyRoamSettingObserver(TroopView paramTroopView) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      this.a.l();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView.MyRoamSettingObserver
 * JD-Core Version:    0.7.0.1
 */