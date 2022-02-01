package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.app.Activity;
import android.content.ClipboardManager;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class SheetItemClickProcessor$CopyLinkAction
  extends SheetItemClickProcessor.ClickAction
{
  SheetItemClickProcessor$CopyLinkAction(SheetItemClickProcessor paramSheetItemClickProcessor1, Activity paramActivity, SheetItemClickProcessor paramSheetItemClickProcessor2, JSONObject paramJSONObject)
  {
    super(paramSheetItemClickProcessor1, paramActivity, paramSheetItemClickProcessor2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString1);
    QRUtils.a(2, 2131691374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.SheetItemClickProcessor.CopyLinkAction
 * JD-Core Version:    0.7.0.1
 */