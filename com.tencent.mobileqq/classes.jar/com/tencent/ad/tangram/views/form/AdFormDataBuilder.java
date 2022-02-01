package com.tencent.ad.tangram.views.form;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.form.framework.d;
import com.tencent.ad.tangram.views.form.framework.g;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public final class AdFormDataBuilder
{
  private static final String TAG = "AdFormDataBuilder";
  
  public static AdFormData build(Context paramContext, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      AdFormData localAdFormData = new AdFormData();
      try
      {
        localAdFormData.formId = paramJSONObject.getLong("formId");
        localAdFormData.padding = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt, 60);
        Object localObject = paramJSONObject.getString("backgroundColor");
        int i = 0;
        localAdFormData.backgroundColor = getColor((String)localObject, 0);
        localObject = paramJSONObject.getJSONObject("title");
        boolean bool = ((JSONObject)localObject).getBoolean("visible");
        if (bool)
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
        while (i < paramJSONObject.length())
        {
          localObject = getFormItem(paramContext, paramJSONObject.getJSONObject(i), paramInt);
          if (!localAdFormData.table.addItem((d)localObject)) {
            AdLog.e("AdFormDataBuilder", "getFormComponent error");
          }
          i += 1;
        }
        return localAdFormData;
      }
      catch (JSONException paramContext)
      {
        AdLog.e("AdFormDataBuilder", "getFormComponent", paramContext);
        return null;
      }
    }
    AdLog.e("AdFormDataBuilder", "getFormComponent error");
    return null;
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
  
  private static d getFormItem(Context paramContext, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject))) {
      try
      {
        int i = paramJSONObject.getInt("type");
        if (i != 0)
        {
          AdLog.e("AdFormDataBuilder", "getFormItem error");
          return null;
        }
        return getFormItemTextBox(paramContext, paramJSONObject, paramInt, i);
      }
      catch (JSONException paramContext)
      {
        AdLog.e("AdFormDataBuilder", "getFormItem", paramContext);
        return null;
      }
    }
    AdLog.e("AdFormDataBuilder", "getFormItem error");
    return null;
  }
  
  private static com.tencent.ad.tangram.views.form.textbox.a getFormItemTextBox(Context paramContext, JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)))
    {
      com.tencent.ad.tangram.views.form.textbox.a locala = new com.tencent.ad.tangram.views.form.textbox.a();
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
    AdLog.e("AdFormDataBuilder", "getFormItemTextBox error");
    return null;
  }
  
  private static boolean initFormItem(Context paramContext, JSONObject paramJSONObject, int paramInt1, d paramd, int paramInt2)
  {
    if ((paramJSONObject != null) && (!JSONObject.NULL.equals(paramJSONObject)) && (paramd != null)) {
      try
      {
        if (paramJSONObject.getInt("type") != paramInt2)
        {
          AdLog.e("AdFormDataBuilder", "initFormItem type error");
          return false;
        }
        paramd.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 60);
        paramd.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 60);
        paramd.backgroundColor = getColor("#FDFEFF", 0);
        paramd.required = paramJSONObject.getBoolean("require");
        paramd.title.text = paramJSONObject.getString("name");
        paramd.title.color = getColor("#333333", 0);
        paramd.title.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 40);
        paramd.titlePaddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 60);
        paramd.titlePaddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 15);
        paramd.contentPaddingLeft = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 15);
        paramd.contentPaddingRight = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 60);
        if (paramJSONObject.has("placeholder"))
        {
          paramd.placeholder = new AdTextData();
          paramd.placeholder.text = paramJSONObject.optString("placeholder");
          paramd.placeholder.color = getColor("#B9BDC2", 0);
          paramd.placeholder.size = AdUIUtils.getValueDependsOnScreenWidth(paramContext, paramInt1, 40);
        }
        return true;
      }
      catch (JSONException paramContext)
      {
        AdLog.e("AdFormDataBuilder", "initFormItem", paramContext);
        return false;
      }
    }
    AdLog.e("AdFormDataBuilder", "initFormItem error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.AdFormDataBuilder
 * JD-Core Version:    0.7.0.1
 */