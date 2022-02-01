package com.tencent.aelight.camera.aeeditor.manage;

import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AEEditorEffectGroupListBean
  implements Serializable
{
  public static final String TAG = "AEEditorEffectGroupListBean";
  public List<AEEditorEffectGroupListBean.AEEditorEffectGroupItem> effectGroups = new ArrayList();
  public String version = "";
  
  private static void a(List<AEEditorEffectGroupListBean.AEEditorEffectGroupItem> paramList, JSONArray paramJSONArray)
  {
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0)) {
      i = 0;
    }
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      AEEditorEffectGroupListBean.AEEditorEffectGroupItem localAEEditorEffectGroupItem = new AEEditorEffectGroupListBean.AEEditorEffectGroupItem();
      localAEEditorEffectGroupItem.effectGroupID = ((JSONObject)localObject).optString("effectGroupID");
      localAEEditorEffectGroupItem.effectGroupName = ((JSONObject)localObject).optString("effectGroupName");
      localObject = ((JSONObject)localObject).optJSONArray("effects");
      b(localAEEditorEffectGroupItem.effects, (JSONArray)localObject);
      paramList.add(localAEEditorEffectGroupItem);
      i += 1;
      continue;
      AEQLog.d("AEEditorEffectGroupListBean", "group list empty.");
    }
  }
  
  private static void b(List<AEEditorEffectGroupListBean.AEEditorEffectItem> paramList, JSONArray paramJSONArray)
  {
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0)) {
      i = 0;
    }
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      AEEditorEffectGroupListBean.AEEditorEffectItem localAEEditorEffectItem = new AEEditorEffectGroupListBean.AEEditorEffectItem();
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$002(localAEEditorEffectItem, localJSONObject.optString("effectID"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$102(localAEEditorEffectItem, localJSONObject.optString("effectName"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$202(localAEEditorEffectItem, localJSONObject.optString("thumbURL"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$302(localAEEditorEffectItem, localJSONObject.optInt("hideApplyAll"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$402(localAEEditorEffectItem, localJSONObject.optInt("hideAlphaBar"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$502(localAEEditorEffectItem, localJSONObject.optInt("disableForImage"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$602(localAEEditorEffectItem, localJSONObject.optInt("disableForVideo"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$702(localAEEditorEffectItem, localJSONObject.optInt("imageShowLevel"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$802(localAEEditorEffectItem, localJSONObject.optInt("videoShowLevel"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$902(localAEEditorEffectItem, localJSONObject.optString("effectType"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1002(localAEEditorEffectItem, localJSONObject.optInt("netStylizeType"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1102(localAEEditorEffectItem, localJSONObject.optInt("preDownload"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1202(localAEEditorEffectItem, localJSONObject.optString("resourceMD5"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1302(localAEEditorEffectItem, localJSONObject.optString("resourceURL"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1402(localAEEditorEffectItem, localJSONObject.optInt("uploadMaxSize"));
      paramList.add(localAEEditorEffectItem);
      i += 1;
      continue;
      AEQLog.d("AEEditorEffectGroupListBean", "effect list is empty.");
    }
  }
  
  public static AEEditorEffectGroupListBean parse(String paramString)
  {
    AEEditorEffectGroupListBean localAEEditorEffectGroupListBean = new AEEditorEffectGroupListBean();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        localAEEditorEffectGroupListBean.version = paramString.optString("version");
        paramString = paramString.optJSONArray("effectGroups");
        a(localAEEditorEffectGroupListBean.effectGroups, paramString);
        return localAEEditorEffectGroupListBean;
      }
      catch (Exception paramString)
      {
        AEQLog.d("AEEditorEffectGroupListBean", paramString.toString());
      }
    }
    return localAEEditorEffectGroupListBean;
  }
  
  public static AEEditorEffectGroupListBean.AEEditorEffectItem parseEffectList(MetaMaterial paramMetaMaterial)
  {
    AEEditorEffectGroupListBean.AEEditorEffectItem localAEEditorEffectItem = new AEEditorEffectGroupListBean.AEEditorEffectItem();
    AEEditorEffectGroupListBean.AEEditorEffectItem.access$002(localAEEditorEffectItem, paramMetaMaterial.id);
    AEEditorEffectGroupListBean.AEEditorEffectItem.access$202(localAEEditorEffectItem, paramMetaMaterial.thumbUrl);
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("name"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$102(localAEEditorEffectItem, (String)paramMetaMaterial.additionalFields.get("name"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("hideApplyAll"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$302(localAEEditorEffectItem, Integer.parseInt((String)paramMetaMaterial.additionalFields.get("hideApplyAll")));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("hideAlphaBar"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$402(localAEEditorEffectItem, Integer.parseInt((String)paramMetaMaterial.additionalFields.get("hideAlphaBar")));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("disableForImage"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$502(localAEEditorEffectItem, Integer.parseInt((String)paramMetaMaterial.additionalFields.get("disableForImage")));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("disableForVideo"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$602(localAEEditorEffectItem, Integer.parseInt((String)paramMetaMaterial.additionalFields.get("disableForVideo")));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("imageShowLevel"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$702(localAEEditorEffectItem, Integer.parseInt((String)paramMetaMaterial.additionalFields.get("imageShowLevel")));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("videoShowLevel"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$802(localAEEditorEffectItem, Integer.parseInt((String)paramMetaMaterial.additionalFields.get("videoShowLevel")));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("effectType"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$902(localAEEditorEffectItem, (String)paramMetaMaterial.additionalFields.get("effectType"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("netStylizeType"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1002(localAEEditorEffectItem, Integer.parseInt((String)paramMetaMaterial.additionalFields.get("netStylizeType")));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("preDownload"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1102(localAEEditorEffectItem, Integer.parseInt((String)paramMetaMaterial.additionalFields.get("preDownload")));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMetaMaterial.additionalFields.get("uploadMaxSize"))) {
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1402(localAEEditorEffectItem, Integer.parseInt((String)paramMetaMaterial.additionalFields.get("uploadMaxSize")));
    }
    AEEditorEffectGroupListBean.AEEditorEffectItem.access$1202(localAEEditorEffectItem, paramMetaMaterial.packageMd5);
    AEEditorEffectGroupListBean.AEEditorEffectItem.access$1302(localAEEditorEffectItem, paramMetaMaterial.packageUrl);
    return localAEEditorEffectItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectGroupListBean
 * JD-Core Version:    0.7.0.1
 */