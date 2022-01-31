package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import awqx;
import bbmy;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import ndn;
import obz;
import ogy;
import org.json.JSONException;
import org.json.JSONObject;
import qoe;
import qoj;
import qok;
import rvf;

public class ReadInJoyBaseAdapter$17$1$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$17$1$1(qok paramqok) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.b.remove(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    qoe.a(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe, true);
    this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.notifyDataSetChanged();
    int i = 2131633875;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      i = 2131633876;
    }
    if ((this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a instanceof BaseActivity)) {
      bbmy.a(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a, -1, this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a.getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Int, this.a.jdField_a_of_type_Qoj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
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
        ogy.a().a(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a, (AdvertisementInfo)this.a.jdField_a_of_type_Qoj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.c);
        ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
        if ((this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", obz.d);
          ((JSONObject)localObject).put("kandian_mode", obz.e());
          ((JSONObject)localObject).put("feeds_type", "" + obz.a(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          ((JSONObject)localObject).put("rowkey", rvf.a(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          ndn.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", obz.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
        }
        while (!(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a instanceof PluginBaseActivity)) {
            break;
          }
          bbmy.a(this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a, -1, this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a.getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Qoj.jdField_a_of_type_Qoe.a).g());
          break;
        }
        ((JSONObject)localObject).put("folder_status", 1);
        awqx.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
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