package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import bcst;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import oat;
import org.json.JSONException;
import org.json.JSONObject;
import pha;
import pmh;
import snh;
import snv;
import snw;
import ube;

public class ReadInJoyBaseAdapter$23$1$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$23$1$1(snw paramsnw) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.b.remove(this.a.jdField_a_of_type_Snv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    snh.a(this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh, true);
    this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.notifyDataSetChanged();
    int i = 2131698480;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Snv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      i = 2131698481;
    }
    if ((this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a instanceof BaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a, -1, this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a.getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a(this.a.jdField_a_of_type_Snv.jdField_a_of_type_Int, this.a.jdField_a_of_type_Snv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Snv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
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
        pmh.a().a(this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a, (AdvertisementInfo)this.a.jdField_a_of_type_Snv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.c);
        ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
        if ((this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", pha.d);
          ((JSONObject)localObject).put("kandian_mode", pha.e());
          ((JSONObject)localObject).put("feeds_type", "" + pha.a(this.a.jdField_a_of_type_Snv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          ((JSONObject)localObject).put("rowkey", ube.a(this.a.jdField_a_of_type_Snv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          oat.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", pha.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
        }
        while (!(this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a instanceof PluginBaseActivity)) {
            break;
          }
          QQToast.a(this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a, -1, this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a.getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Snv.jdField_a_of_type_Snh.a).g());
          break;
        }
        ((JSONObject)localObject).put("folder_status", 1);
        bcst.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.23.1.1
 * JD-Core Version:    0.7.0.1
 */