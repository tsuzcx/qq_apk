package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import azmj;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import nrt;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import owy;
import rqj;
import rqo;
import rqp;
import szp;

public class ReadInJoyBaseAdapter$17$1$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$17$1$1(rqp paramrqp) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.b.remove(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    rqj.a(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj, true);
    this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.notifyDataSetChanged();
    int i = 2131700042;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      i = 2131700043;
    }
    if ((this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a instanceof BaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a, -1, this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a.getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Int, this.a.jdField_a_of_type_Rqo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
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
        owy.a().a(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a, (AdvertisementInfo)this.a.jdField_a_of_type_Rqo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.c);
        ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
        if ((this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", ors.d);
          ((JSONObject)localObject).put("kandian_mode", ors.e());
          ((JSONObject)localObject).put("feeds_type", "" + ors.a(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          ((JSONObject)localObject).put("rowkey", szp.a(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          nrt.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", ors.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
        }
        while (!(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a instanceof PluginBaseActivity)) {
            break;
          }
          QQToast.a(this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a, -1, this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a.getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Rqo.jdField_a_of_type_Rqj.a).g());
          break;
        }
        ((JSONObject)localObject).put("folder_status", 1);
        azmj.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.17.1.1
 * JD-Core Version:    0.7.0.1
 */