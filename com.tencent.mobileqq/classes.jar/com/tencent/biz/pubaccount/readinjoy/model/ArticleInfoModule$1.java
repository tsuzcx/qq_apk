package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.List;
import noo;
import onk;
import org.json.JSONObject;
import ozr;
import poz;
import sak;

public class ArticleInfoModule$1
  implements Runnable
{
  public ArticleInfoModule$1(ozr paramozr, poz parampoz, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = ozr.a(this.this$0, this.jdField_a_of_type_Poz);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.jdField_a_of_type_Long));
      localToServiceMsg.getAttributes().put("feedsRequestVersion", Long.valueOf(this.b));
      if (this.jdField_a_of_type_Poz.a != null) {
        localToServiceMsg.getAttributes().put("request_extra_data_key", this.jdField_a_of_type_Poz.a);
      }
      if ((this.jdField_a_of_type_Poz.i & 0x40) != 0) {
        localToServiceMsg.getAttributes().put("recommendFlag", Integer.valueOf(this.jdField_a_of_type_Poz.i));
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      long l2 = -1L;
      long l1 = l2;
      if (this.jdField_a_of_type_Poz.jdField_b_of_type_JavaUtilList != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Poz.jdField_b_of_type_JavaUtilList.size() >= 1) {
          l1 = ((Long)this.jdField_a_of_type_Poz.jdField_b_of_type_JavaUtilList.get(0)).longValue();
        }
      }
      localJSONObject.put("preload_red_pnt_push_articleID", l1);
      noo.a(null, "", "0X8009482", "0X8009482", 0, 0, localJSONObject.toString(), "", "", "", false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if ((this.jdField_a_of_type_Poz.jdField_b_of_type_Int == 0) && (onk.a())) {
      this.this$0.a("-1", 1, 0);
    }
    this.this$0.a(localToServiceMsg);
    sak.a().a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.1
 * JD-Core Version:    0.7.0.1
 */