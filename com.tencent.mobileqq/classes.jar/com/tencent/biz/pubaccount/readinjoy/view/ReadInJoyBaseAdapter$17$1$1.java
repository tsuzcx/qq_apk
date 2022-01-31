package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import axqy;
import bcql;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import nol;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import osg;
import ram;
import rar;
import ras;
import shu;

public class ReadInJoyBaseAdapter$17$1$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$17$1$1(ras paramras) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.b.remove(this.a.jdField_a_of_type_Rar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    ram.a(this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram, true);
    this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.notifyDataSetChanged();
    int i = 2131699674;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Rar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      i = 2131699675;
    }
    if ((this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a instanceof BaseActivity)) {
      bcql.a(this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a, -1, this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a.getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a(this.a.jdField_a_of_type_Rar.jdField_a_of_type_Int, this.a.jdField_a_of_type_Rar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Rar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
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
        osg.a().a(this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a, (AdvertisementInfo)this.a.jdField_a_of_type_Rar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.c);
        ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
        if ((this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", onh.d);
          ((JSONObject)localObject).put("kandian_mode", onh.e());
          ((JSONObject)localObject).put("feeds_type", "" + onh.a(this.a.jdField_a_of_type_Rar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          ((JSONObject)localObject).put("rowkey", shu.a(this.a.jdField_a_of_type_Rar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          nol.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", onh.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
        }
        while (!(this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a instanceof PluginBaseActivity)) {
            break;
          }
          bcql.a(this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a, -1, this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a.getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Rar.jdField_a_of_type_Ram.a).g());
          break;
        }
        ((JSONObject)localObject).put("folder_status", 1);
        axqy.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
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