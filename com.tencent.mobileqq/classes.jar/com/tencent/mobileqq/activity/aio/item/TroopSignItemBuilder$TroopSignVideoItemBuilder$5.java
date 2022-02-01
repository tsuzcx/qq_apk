package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class TroopSignItemBuilder$TroopSignVideoItemBuilder$5
  implements AsyncBack
{
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkUpByBusinessId:2833|param:" + paramString + "|code:" + paramInt);
    }
    if ((paramInt == 0) && (paramString == null))
    {
      paramString = TroopSignItemBuilder.TroopSignVideoItemBuilder.a.entrySet().iterator();
      while (paramString.hasNext()) {
        ((TroopSignItemBuilder.TroopSignVideoItemBuilder.IOnOfflineResCallback)((Map.Entry)paramString.next()).getValue()).a(paramInt);
      }
      TroopSignItemBuilder.TroopSignVideoItemBuilder.a.clear();
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */