package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.List;
import olh;
import org.json.JSONObject;
import qep;
import qit;
import qxs;
import udc;

public class RIJGetArticleListHandler$1
  implements Runnable
{
  public RIJGetArticleListHandler$1(qit paramqit, qxs paramqxs, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = qit.a(this.this$0, this.jdField_a_of_type_Qxs);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.jdField_a_of_type_Long));
      localToServiceMsg.getAttributes().put("feedsRequestVersion", Long.valueOf(this.b));
      if (this.jdField_a_of_type_Qxs.jdField_a_of_type_AndroidOsBundle != null) {
        localToServiceMsg.getAttributes().put("request_extra_data_key", this.jdField_a_of_type_Qxs.jdField_a_of_type_AndroidOsBundle);
      }
      localToServiceMsg.getAttributes().put("auto_refresh_src", Integer.valueOf(this.jdField_a_of_type_Qxs.h));
      if ((this.jdField_a_of_type_Qxs.i & 0x40) != 0) {
        localToServiceMsg.getAttributes().put("recommendFlag", Integer.valueOf(this.jdField_a_of_type_Qxs.i));
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      long l2 = -1L;
      long l1 = l2;
      if (this.jdField_a_of_type_Qxs.jdField_b_of_type_JavaUtilList != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Qxs.jdField_b_of_type_JavaUtilList.size() >= 1) {
          l1 = ((Long)this.jdField_a_of_type_Qxs.jdField_b_of_type_JavaUtilList.get(0)).longValue();
        }
      }
      localJSONObject.put("preload_red_pnt_push_articleID", l1);
      olh.a(null, "", "0X8009482", "0X8009482", 0, 0, localJSONObject.toString(), "", "", "", false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if ((this.jdField_a_of_type_Qxs.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_Qxs.jdField_a_of_type_Long == -1L)) {
      this.this$0.a.a("-1", 1, 0);
    }
    this.this$0.a.a(localToServiceMsg);
    udc.a().a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetArticleListHandler.1
 * JD-Core Version:    0.7.0.1
 */