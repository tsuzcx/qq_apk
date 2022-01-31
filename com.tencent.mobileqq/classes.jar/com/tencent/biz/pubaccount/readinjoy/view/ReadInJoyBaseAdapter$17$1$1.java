package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import axqw;
import bcpw;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import noo;
import onk;
import org.json.JSONException;
import org.json.JSONObject;
import osj;
import rap;
import rau;
import rav;
import shx;

public class ReadInJoyBaseAdapter$17$1$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$17$1$1(rav paramrav) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.b.remove(this.a.jdField_a_of_type_Rau.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    rap.a(this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap, true);
    this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.notifyDataSetChanged();
    int i = 2131699663;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Rau.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      i = 2131699664;
    }
    if ((this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a instanceof BaseActivity)) {
      bcpw.a(this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a, -1, this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a.getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a(this.a.jdField_a_of_type_Rau.jdField_a_of_type_Int, this.a.jdField_a_of_type_Rau.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Rau.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        long l2 = 0L;
        long l1 = l2;
        if (this.a.jdField_a_of_type_JavaLangObject != null)
        {
          l1 = l2;
          if ((this.a.jdField_a_of_type_JavaLangObject instanceof DislikeInfo)) {
            l1 = ((DislikeInfo)this.a.jdField_a_of_type_JavaLangObject).a;
          }
        }
        osj.a().a(this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a, (AdvertisementInfo)this.a.jdField_a_of_type_Rau.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.c);
        ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
        if ((this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", onk.d);
          ((JSONObject)localObject).put("kandian_mode", onk.e());
          ((JSONObject)localObject).put("feeds_type", "" + onk.a(this.a.jdField_a_of_type_Rau.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          ((JSONObject)localObject).put("rowkey", shx.a(this.a.jdField_a_of_type_Rau.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          noo.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", onk.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
        }
        while (!(this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a instanceof PluginBaseActivity)) {
            break;
          }
          bcpw.a(this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a, -1, this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a.getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Rau.jdField_a_of_type_Rap.a).g());
          break;
        }
        ((JSONObject)localObject).put("folder_status", 1);
        axqw.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.17.1.1
 * JD-Core Version:    0.7.0.1
 */