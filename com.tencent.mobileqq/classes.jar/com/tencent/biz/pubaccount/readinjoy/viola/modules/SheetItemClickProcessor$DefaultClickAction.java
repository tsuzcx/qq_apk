package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.app.Activity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class SheetItemClickProcessor$DefaultClickAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$DefaultClickAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = null;
    if (paramActionSheetItem.action == 72) {
      paramString1 = paramActionSheetItem.uin;
    }
    SheetItemClickProcessor.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesSheetItemClickProcessor).mShareUtils.a(this.jdField_a_of_type_OrgJsonJSONObject, paramInt, this.jdField_a_of_type_AndroidAppActivity, paramString1, paramActionSheetItem.uinType, paramActionSheetItem.label);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.SheetItemClickProcessor.DefaultClickAction
 * JD-Core Version:    0.7.0.1
 */