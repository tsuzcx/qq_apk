package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWriteWatchWordPresenter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class SheetItemClickProcessor$WatchWordAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$WatchWordAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("rowkey", "");
    paramString3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("topicId", "");
    paramActionSheetItem = this.jdField_a_of_type_OrgJsonJSONObject.optString("title", "");
    if (!TextUtils.isEmpty(paramString2))
    {
      SheetItemClickProcessor.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesSheetItemClickProcessor).rijWatchWordPresenter.a(paramString2, paramString1, paramString3, paramActionSheetItem);
      return;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      SheetItemClickProcessor.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesSheetItemClickProcessor).rijWatchWordPresenter.a(paramString3, paramString1, paramActionSheetItem);
      return;
    }
    QLog.e(SheetItemClickProcessor.a, 1, "args is illegal: " + this.jdField_a_of_type_OrgJsonJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.SheetItemClickProcessor.WatchWordAction
 * JD-Core Version:    0.7.0.1
 */