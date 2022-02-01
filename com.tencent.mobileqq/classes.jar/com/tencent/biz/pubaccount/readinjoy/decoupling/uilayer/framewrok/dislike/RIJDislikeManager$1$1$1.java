package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class RIJDislikeManager$1$1$1
  implements Runnable
{
  RIJDislikeManager$1$1$1(RIJDislikeManager.1.1 param1) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().remove(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().e(true);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().notifyDataSetChanged();
    int i = 2131699744;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      i = 2131699745;
    }
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a() instanceof BaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), -1, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a()).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        long l = 0L;
        if ((this.a.jdField_a_of_type_JavaLangObject instanceof DislikeInfo)) {
          l = ((DislikeInfo)this.a.jdField_a_of_type_JavaLangObject).a;
        }
        ReadInJoyLogicEngine.a().a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), (AdvertisementInfo)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b());
        ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
        if ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a() instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
          ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.a());
          ((JSONObject)localObject).put("feeds_type", "" + RIJFeedsType.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          ((JSONObject)localObject).put("rowkey", ReadinjoyReportUtils.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007059", "0X8007059", 0, 0, "", "", RIJDislikeManager.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
        }
        while (!(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a() instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a() instanceof PluginBaseActivity)) {
            break;
          }
          QQToast.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), -1, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a()).g());
          break;
        }
        ((JSONObject)localObject).put("folder_status", 1);
        ReportController.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike.RIJDislikeManager.1.1.1
 * JD-Core Version:    0.7.0.1
 */