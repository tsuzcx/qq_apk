package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import rjh;

class BridgeModule$36
  implements Runnable
{
  BridgeModule$36(BridgeModule paramBridgeModule, List paramList, int paramInt, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    Collections.sort(this.jdField_a_of_type_JavaUtilList);
    JSONArray localJSONArray = rjh.a(this.jdField_a_of_type_JavaUtilList);
    ThreadManagerV2.getUIHandlerV2().post(new BridgeModule.36.1(this, localJSONObject, localJSONArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.36
 * JD-Core Version:    0.7.0.1
 */