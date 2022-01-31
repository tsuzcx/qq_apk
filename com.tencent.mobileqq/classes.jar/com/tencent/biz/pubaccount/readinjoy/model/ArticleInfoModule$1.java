package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.List;
import nrt;
import org.json.JSONObject;
import ors;
import pew;
import pve;
import srs;

public class ArticleInfoModule$1
  implements Runnable
{
  public ArticleInfoModule$1(pew parampew, pve parampve, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = pew.a(this.this$0, this.jdField_a_of_type_Pve);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.jdField_a_of_type_Long));
      localToServiceMsg.getAttributes().put("feedsRequestVersion", Long.valueOf(this.b));
      if (this.jdField_a_of_type_Pve.a != null) {
        localToServiceMsg.getAttributes().put("request_extra_data_key", this.jdField_a_of_type_Pve.a);
      }
      localToServiceMsg.getAttributes().put("auto_refresh_src", Integer.valueOf(this.jdField_a_of_type_Pve.h));
      if ((this.jdField_a_of_type_Pve.i & 0x40) != 0) {
        localToServiceMsg.getAttributes().put("recommendFlag", Integer.valueOf(this.jdField_a_of_type_Pve.i));
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      long l2 = -1L;
      long l1 = l2;
      if (this.jdField_a_of_type_Pve.jdField_b_of_type_JavaUtilList != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Pve.jdField_b_of_type_JavaUtilList.size() >= 1) {
          l1 = ((Long)this.jdField_a_of_type_Pve.jdField_b_of_type_JavaUtilList.get(0)).longValue();
        }
      }
      localJSONObject.put("preload_red_pnt_push_articleID", l1);
      nrt.a(null, "", "0X8009482", "0X8009482", 0, 0, localJSONObject.toString(), "", "", "", false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if ((this.jdField_a_of_type_Pve.jdField_b_of_type_Int == 0) && (ors.a())) {
      this.this$0.a("-1", 1, 0);
    }
    this.this$0.a(localToServiceMsg);
    srs.a().a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.1
 * JD-Core Version:    0.7.0.1
 */