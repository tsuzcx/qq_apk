package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import java.util.HashMap;
import java.util.Map;

class QQSettingMe$4
  implements IElementDynamicParams
{
  QQSettingMe$4(QQSettingMe paramQQSettingMe) {}
  
  public Map<String, Object> getElementDynamicParams()
  {
    HashMap localHashMap = new HashMap();
    int i;
    if ((QQSettingMe.b(this.a) != null) && (QQSettingMe.b(this.a).c())) {
      i = 1;
    } else {
      i = 0;
    }
    localHashMap.put("is_red_tips_em", Integer.valueOf(i));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.4
 * JD-Core Version:    0.7.0.1
 */