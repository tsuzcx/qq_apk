package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class TroopAssistantActivity$10
  extends RoamSettingObserver
{
  TroopAssistantActivity$10(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      if (paramMap != null)
      {
        if (paramMap.size() == 0) {
          return;
        }
        int i;
        if (("batch_setting".equals(this.a.h)) && (this.a.i != null) && (this.a.i.size() > 0) && (this.a.j != null))
        {
          i = 0;
          while (i < this.a.i.size())
          {
            paramString = String.valueOf(this.a.i.get(i));
            if (((Boolean)this.a.j.getMapRequest().get(paramString)).booleanValue()) {
              return;
            }
            i += 1;
          }
          QQToast.makeText(this.a.app.getApp(), 2, HardCodeUtil.a(2131912481), 0).show(this.a.getTitleBarHeight());
          TroopAssistantActivity.a(this.a);
          return;
        }
        paramString = paramMap.entrySet().iterator();
        while (paramString.hasNext())
        {
          paramMap = (String)((Map.Entry)paramString.next()).getKey();
          i = this.a.app.getTroopMask(paramMap);
          if ((i != 1) && (i != 4))
          {
            if (i == 3) {
              TroopAssistantManager.a().b(paramMap, this.a.app);
            }
          }
          else {
            TroopAssistantManager.a().c(paramMap, this.a.app);
          }
          this.a.c();
        }
        if (this.a.isResume())
        {
          if (paramBoolean)
          {
            QQToast.makeText(this.a.app.getApp(), 2, this.a.getString(2131917581), 0).show(this.a.getTitleBarHeight());
            return;
          }
          QQToast.makeText(this.a.app.getApp(), 1, this.a.getString(2131917580), 0).show(this.a.getTitleBarHeight());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.10
 * JD-Core Version:    0.7.0.1
 */