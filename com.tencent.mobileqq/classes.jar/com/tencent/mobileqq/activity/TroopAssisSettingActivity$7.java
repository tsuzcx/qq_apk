package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class TroopAssisSettingActivity$7
  extends RoamSettingObserver
{
  TroopAssisSettingActivity$7(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      if (this.a.b == null) {
        return;
      }
      if ((paramBoolean) && (paramMap != null))
      {
        paramString = paramMap.keySet().iterator();
        while (paramString.hasNext())
        {
          String str = (String)paramString.next();
          Integer localInteger = (Integer)paramMap.get(str);
          if (localInteger != null) {
            this.a.c.put(str, localInteger);
          }
        }
        this.a.b.a(this.a.c);
        this.a.b.notifyDataSetChanged();
        this.a.b();
        return;
      }
      this.a.b.notifyDataSetChanged();
      this.a.b();
      QQToast.makeText(this.a.app.getApp(), 1, this.a.getString(2131917580), 0).show(this.a.getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.b == null) {
      return;
    }
    if (paramBoolean1)
    {
      this.a.c = TroopAssistantManager.a().a(this.a.app, this.a.d);
      if (this.a.c == null) {
        return;
      }
      this.a.b.a(this.a.c);
      this.a.b.notifyDataSetChanged();
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity.7
 * JD-Core Version:    0.7.0.1
 */