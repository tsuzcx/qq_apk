package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike;

import android.content.Context;
import bcef;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import odq;
import org.json.JSONException;
import org.json.JSONObject;
import pay;
import ped;
import peg;
import pgo;
import pgp;
import pkm;
import slt;
import uhv;

public class RIJDislikeManager$1$1$1
  implements Runnable
{
  public RIJDislikeManager$1$1$1(pgp parampgp) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().remove(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().e(true);
    this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a().notifyDataSetChanged();
    int i = 2131698822;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      i = 2131698823;
    }
    if ((this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a() instanceof BaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a(), -1, this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a().getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a()).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a().a(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Int, this.a.jdField_a_of_type_Pgo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        long l = 0L;
        if ((this.a.jdField_a_of_type_JavaLangObject instanceof DislikeInfo)) {
          l = ((DislikeInfo)this.a.jdField_a_of_type_JavaLangObject).a;
        }
        pkm.a().a(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a(), (AdvertisementInfo)this.a.jdField_a_of_type_Pgo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().b());
        ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
        if ((this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a() instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", pay.d);
          ((JSONObject)localObject).put("kandian_mode", pay.e());
          ((JSONObject)localObject).put("feeds_type", "" + pay.a(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          ((JSONObject)localObject).put("rowkey", uhv.a(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          odq.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", pay.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
        }
        while (!(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a() instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a() instanceof PluginBaseActivity)) {
            break;
          }
          QQToast.a(this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a(), -1, this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a().getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Pgo.jdField_a_of_type_Ped.a().a()).g());
          break;
        }
        ((JSONObject)localObject).put("folder_status", 1);
        bcef.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("RIJDislikeManager", 2, "showDislikeDialog JSONException:" + localJSONException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike.RIJDislikeManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */