package com.tencent.biz.pubaccount.readinjoy.ugc.account;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewHandler;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSStyleManager;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJUGCPopupPtsLiteBuilder
{
  private Context jdField_a_of_type_AndroidContentContext;
  private PTSLiteItemViewHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewHandler;
  
  public RIJUGCPopupPtsLiteBuilder(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewHandler = new PTSLiteItemViewHandler(paramContext);
    b();
    a(paramViewGroup);
  }
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tips", RIJUGCAddAccountFragment.a() + " " + RIJUGCAddAccountAladdinUtils.a());
      localJSONObject.put("edit_profile_text", RIJUGCAddAccountAladdinUtils.c());
      localJSONObject.put("use_origin_account_text", RIJUGCAddAccountAladdinUtils.b());
      localJSONObject.put("accountUin", ReadInJoyUtils.a());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("RIJUGCPopupPtsLiteBuilder", 1, "[getJsonData] error, e = " + localJSONException);
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    Object localObject;
    do
    {
      return;
      localObject = PTSStyleManager.a().a("default_feeds", "ugc_account_popup");
      String str = a();
      localObject = new PTSItemData.Builder().withItemID("RIJUGCPopupPtsLiteBuilder").withPageName("ugc_account_popup").withFrameTreeJson((String)localObject).withJsonData(str).build();
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewHandler.a(null, (PTSItemData)localObject);
    } while (localObject == null);
    paramViewGroup.addView((View)localObject);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewHandler.a(new RIJUGCPopupPtsLiteBuilder.1(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteItemViewHandler.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCPopupPtsLiteBuilder
 * JD-Core Version:    0.7.0.1
 */