package com.tencent.gdtad.aditem;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.mini.api.IPrePullListener;
import org.json.JSONObject;

class GdtPreLoader$1$1
  implements IPrePullListener
{
  GdtPreLoader$1$1(GdtPreLoader.1 param1) {}
  
  public void onPrePullCallback(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GdtLog.b("GdtPreLoader", String.format("MiniAppPrePullManager.getInstance().prePullAppinfoByLink end:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.1.1
 * JD-Core Version:    0.7.0.1
 */