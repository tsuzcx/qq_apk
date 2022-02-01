package com.tencent.ad.tangram.canvas.views.form;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormTableData;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public final class AdFormDataBuilder
{
  private static final String TAG = "AdFormDataBuilder";
  
  public static AdFormData build(Context paramContext, JSONObject paramJSONObject, int paramInt)
  {
    int i = 0;
    if ((paramJSONObject == null) || (JSONObject.NULL.equals(paramJSONObject)))
    {
      AdLog.e("AdFormDataBuilder", "getFormComponent error");
      return null;
    }
    AdFormData localAdFormData = new AdFormData();
    Object localObject;
    try
    {
      localAdFormData.formId = paramJSONObject.getLong("formId");
      localAdFormData.padding = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 60);
      localAdFormData.backgroundColor = getColor(paramJSONObject.getString("backgroundColor"), 0);
      localObject = paramJSONObject.getJSONObject("title");
      if (((JSONObject)localObject).getBoolean("visible"))
      {
        localAdFormData.title = new AdTextData();
        localAdFormData.title.text = ((JSONObject)localObject).getString("text");
        localAdFormData.title.color = getColor(((JSONObject)localObject).getString("fontColor"), 0);
        localAdFormData.title.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, ((JSONObject)localObject).getInt("fontSize"));
      }
      localObject = paramJSONObject.getJSONObject("submitButton");
      localAdFormData.button.text.text = ((JSONObject)localObject).getString("text");
      localAdFormData.button.text.color = getColor(((JSONObject)localObject).getString("fontColor"), 0);
      localAdFormData.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 40);
      localAdFormData.button.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 6);
      localAdFormData.button.backgroundColor = getColor(((JSONObject)localObject).getString("backgroundColor"), 0);
      localAdFormData.buttonHeight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 124);
      localAdFormData.table.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 6);
      localAdFormData.table.borderWidth = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 3);
      localAdFormData.table.borderColor = getColor("#EAEAEB", 0);
      localAdFormData.table.borderColorError = getColor("#FE6C6C", 0);
      paramJSONObject = paramJSONObject.getJSONArray("items");
      if (paramJSONObject.length() <= 0)
      {
        AdLog.e("AdFormDataBuilder", "getFormComponent error");
        return null;
      }
    }
    catch (JSONException paramContext)
    {
      AdLog.e("AdFormDataBuilder", "getFormComponent", paramContext);
      return null;
    }
    while (i < paramJSONObject.length())
    {
      localObject = getFormItem(paramContext, paramJSONObject.getJSONObject(i), paramInt);
      if (!localAdFormData.table.addItem((AdFormItemData)localObject)) {
        AdLog.e("AdFormDataBuilder", "getFormComponent error");
      }
      i += 1;
    }
    return localAdFormData;
  }
  
  private static int getColor(String paramString, int paramInt)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      AdLog.e("AdFormDataBuilder", "getColor error", paramString);
    }
    return paramInt;
  }
  
  private static AdFormItemData getFormItem(Context paramContext, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject == null) || (JSONObject.NULL.equals(paramJSONObject)))
    {
      AdLog.e("AdFormDataBuilder", "getFormItem error");
      return null;
    }
    int i;
    try
    {
      i = paramJSONObject.getInt("type");
      switch (i)
      {
      default: 
        AdLog.e("AdFormDataBuilder", "getFormItem error");
        return null;
      }
    }
    catch (JSONException paramContext)
    {
      AdLog.e("AdFormDataBuilder", "getFormItem", paramContext);
      return null;
    }
    return getFormItemTextBox(paramContext, paramJSONObject, paramInt, i);
  }
  
  private static com.tencent.ad.tangram.canvas.views.form.textbox.a getFormItemTextBox(Context paramContext, JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if ((paramJSONObject == null) || (JSONObject.NULL.equals(paramJSONObject)))
    {
      AdLog.e("AdFormDataBuilder", "getFormItemTextBox error");
      return null;
    }
    com.tencent.ad.tangram.canvas.views.form.textbox.a locala = new com.tencent.ad.tangram.canvas.views.form.textbox.a();
    if (!initFormItem(paramContext, paramJSONObject, paramInt1, locala, paramInt2))
    {
      AdLog.e("AdFormDataBuilder", "getFormItemTextBox error");
      return null;
    }
    locala.regexType = paramJSONObject.optInt("regexType", -2147483648);
    locala.content.color = getColor("#333333", 0);
    locala.content.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 40);
    locala.content.lengthMax = paramJSONObject.optInt("maxLength", -2147483648);
    return locala;
  }
  
  private static boolean initFormItem(Context paramContext, JSONObject paramJSONObject, int paramInt1, AdFormItemData paramAdFormItemData, int paramInt2)
  {
    if ((paramJSONObject == null) || (JSONObject.NULL.equals(paramJSONObject)) || (paramAdFormItemData == null))
    {
      AdLog.e("AdFormDataBuilder", "initFormItem error");
      return false;
    }
    try
    {
      if (paramJSONObject.getInt("type") != paramInt2)
      {
        AdLog.e("AdFormDataBuilder", "initFormItem type error");
        return false;
      }
    }
    catch (JSONException paramContext)
    {
      AdLog.e("AdFormDataBuilder", "initFormItem", paramContext);
      return false;
    }
    paramAdFormItemData.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 60);
    paramAdFormItemData.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 60);
    paramAdFormItemData.backgroundColor = getColor("#FDFEFF", 0);
    paramAdFormItemData.required = paramJSONObject.getBoolean("require");
    paramAdFormItemData.title.text = paramJSONObject.getString("name");
    paramAdFormItemData.title.color = getColor("#333333", 0);
    paramAdFormItemData.title.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 40);
    paramAdFormItemData.titlePaddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 60);
    paramAdFormItemData.titlePaddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 15);
    paramAdFormItemData.contentPaddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 15);
    paramAdFormItemData.contentPaddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 60);
    if (paramJSONObject.has("placeholder"))
    {
      paramAdFormItemData.placeholder = new AdTextData();
      paramAdFormItemData.placeholder.text = paramJSONObject.optString("placeholder");
      paramAdFormItemData.placeholder.color = getColor("#B9BDC2", 0);
      paramAdFormItemData.placeholder.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 40);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.AdFormDataBuilder
 * JD-Core Version:    0.7.0.1
 */