package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import bdll;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import ocd;
import org.json.JSONException;
import org.json.JSONObject;
import ozs;
import pfa;
import sel;
import sez;
import sfa;
import ubg;

public class ReadInJoyBaseAdapter$23$1$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$23$1$1(sfa paramsfa) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.b.remove(this.a.jdField_a_of_type_Sez.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    sel.a(this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel, true);
    this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.notifyDataSetChanged();
    int i = 2131698587;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Sez.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      i = 2131698588;
    }
    if ((this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a instanceof BaseActivity)) {
      QQToast.a(this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a, -1, this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a.getString(i), 0).b(((BaseActivity)this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a(this.a.jdField_a_of_type_Sez.jdField_a_of_type_Int, this.a.jdField_a_of_type_Sez.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_a_of_type_JavaUtilArrayList);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.jdField_a_of_type_Sez.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
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
        pfa.a().a(this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a, (AdvertisementInfo)this.a.jdField_a_of_type_Sez.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, this.a.jdField_a_of_type_JavaUtilArrayList, false);
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.c);
        ((JSONObject)localObject).put("tag_num", this.a.jdField_a_of_type_JavaUtilArrayList.size());
        if ((this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", ozs.d);
          ((JSONObject)localObject).put("kandian_mode", ozs.e());
          ((JSONObject)localObject).put("feeds_type", "" + ozs.a(this.a.jdField_a_of_type_Sez.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          ((JSONObject)localObject).put("rowkey", ubg.a(this.a.jdField_a_of_type_Sez.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
          localObject = ((JSONObject)localObject).toString();
          ocd.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", ozs.a(this.a.jdField_a_of_type_JavaUtilArrayList), (String)localObject, false);
        }
        while (!(this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a instanceof PluginBaseActivity)) {
            break;
          }
          QQToast.a(this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a, -1, this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a.getString(i), 0).b(((PluginBaseActivity)this.a.jdField_a_of_type_Sez.jdField_a_of_type_Sel.a).g());
          break;
        }
        ((JSONObject)localObject).put("folder_status", 1);
        bdll.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.23.1.1
 * JD-Core Version:    0.7.0.1
 */