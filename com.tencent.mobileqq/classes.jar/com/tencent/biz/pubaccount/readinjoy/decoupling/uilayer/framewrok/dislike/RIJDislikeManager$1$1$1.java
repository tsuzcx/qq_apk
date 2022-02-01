package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike;

import android.content.Context;
import bdla;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import olh;
import org.json.JSONException;
import org.json.JSONObject;
import pne;
import pnh;
import ppr;
import pps;
import ppt;
import pqu;
import pqw;
import prp;
import pvj;
import szd;
import uvs;

public class RIJDislikeManager$1$1$1
  implements Runnable
{
  public RIJDislikeManager$1$1$1(ppt paramppt) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().remove(this.a.jdField_a_of_type_Pps.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().e(true);
    this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a().notifyDataSetChanged();
    int i = 2131699166;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Pps.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      i = 2131699167;
    }
    if ((this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a() instanceof BaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a(), -1, this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a().getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a()).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a().a(this.a.jdField_a_of_type_Pps.jdField_a_of_type_Int, this.a.jdField_a_of_type_Pps.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Pps.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        long l = 0L;
        if ((this.a.jdField_a_of_type_JavaLangObject instanceof DislikeInfo)) {
          l = ((DislikeInfo)this.a.jdField_a_of_type_JavaLangObject).a;
        }
        pvj.a().a(this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a(), (AdvertisementInfo)this.a.jdField_a_of_type_Pps.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().b());
        ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
        if ((this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a() instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", prp.jdField_a_of_type_Int);
          ((JSONObject)localObject).put("kandian_mode", pqu.a());
          ((JSONObject)localObject).put("feeds_type", "" + pqw.a(this.a.jdField_a_of_type_Pps.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          ((JSONObject)localObject).put("rowkey", uvs.a(this.a.jdField_a_of_type_Pps.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          olh.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", ppr.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
        }
        while (!(this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a() instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a() instanceof PluginBaseActivity)) {
            break;
          }
          QQToast.a(this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a(), -1, this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a().getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Pps.jdField_a_of_type_Pne.a().a()).g());
          break;
        }
        ((JSONObject)localObject).put("folder_status", 1);
        bdla.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
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