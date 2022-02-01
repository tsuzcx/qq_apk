package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

public class SheetItemClickProcessor$AddVideoToTopicAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$AddVideoToTopicAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("rowkey", "");
    paramInt = this.jdField_a_of_type_OrgJsonJSONObject.optInt("from_page");
    if (paramString1.isEmpty())
    {
      QLog.e(SheetItemClickProcessor.a, 1, "click add video to topic fail, rowkey=" + paramString1);
      return;
    }
    RIJUgcUtils.b(SheetItemClickProcessor.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesSheetItemClickProcessor).getViolaInstance().getActivity(), paramString1, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.SheetItemClickProcessor.AddVideoToTopicAction
 * JD-Core Version:    0.7.0.1
 */