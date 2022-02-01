package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import java.util.Map;

public class ForwardTroopListFragment$MyRoamSettingObserver
  extends RoamSettingObserver
{
  protected ForwardTroopListFragment$MyRoamSettingObserver(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      this.a.a();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.MyRoamSettingObserver
 * JD-Core Version:    0.7.0.1
 */