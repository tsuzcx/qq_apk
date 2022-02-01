package com.tencent.biz.pubaccount.readinjoy.viola.utils;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class ViolaBizUtils$3
  implements Runnable
{
  ViolaBizUtils$3(List paramList, int paramInt, String paramString1, boolean paramBoolean, BridgeModule paramBridgeModule, String paramString2) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    Collections.sort(this.jdField_a_of_type_JavaUtilList);
    JSONArray localJSONArray = RIJUgcUtils.a(this.jdField_a_of_type_JavaUtilList);
    ThreadManagerV2.getUIHandlerV2().post(new ViolaBizUtils.3.1(this, localJSONObject, localJSONArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils.3
 * JD-Core Version:    0.7.0.1
 */