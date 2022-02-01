package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class SheetItemClickProcessor$SysBrowserAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$SysBrowserAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    if ((paramString2 != null) && (paramString2.contains("kandianshare.html5.qq.com")))
    {
      SheetItemClickProcessor.a(this.a).mShareHelper.b(paramString2);
      return;
    }
    SheetItemClickProcessor.a(this.a).mShareHelper.b(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.SheetItemClickProcessor.SysBrowserAction
 * JD-Core Version:    0.7.0.1
 */