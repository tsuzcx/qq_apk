package com.tencent.biz.pubaccount.weishi_new.push;

import UserGrowth.stAnnexation;
import UserGrowth.stPopWindowsButton;
import UserGrowth.stPopWindowsConfig;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;
import rzj;

public class WSPushOpDialogModel
  implements Parcelable
{
  public static final Parcelable.Creator<WSPushOpDialogModel> CREATOR = new rzj();
  public stPopWindowsConfig mStPopWindowsConfig;
  
  public WSPushOpDialogModel() {}
  
  public WSPushOpDialogModel(Parcel paramParcel)
  {
    this.mStPopWindowsConfig = ((stPopWindowsConfig)paramParcel.readSerializable());
  }
  
  protected static WSPushOpDialogModel parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      WSPushOpDialogModel localWSPushOpDialogModel = new WSPushOpDialogModel();
      stPopWindowsConfig localstPopWindowsConfig = new stPopWindowsConfig();
      localstPopWindowsConfig.windowsid = paramJSONObject.optInt("windows_id");
      localstPopWindowsConfig.type = paramJSONObject.optInt("type");
      localstPopWindowsConfig.title = paramJSONObject.optString("title");
      localstPopWindowsConfig.text = paramJSONObject.optString("text");
      localstPopWindowsConfig.remark = paramJSONObject.optString("remark");
      localstPopWindowsConfig.bg_img_url = paramJSONObject.optString("bg_img_url");
      localstPopWindowsConfig.scene = paramJSONObject.optInt("scene");
      localstPopWindowsConfig.h5url = paramJSONObject.optString("h5_url");
      localstPopWindowsConfig.schema_url = paramJSONObject.optString("scheme_url");
      Object localObject = paramJSONObject.optJSONObject("button");
      if (localObject != null)
      {
        stPopWindowsButton localstPopWindowsButton = new stPopWindowsButton();
        localstPopWindowsButton.title = ((JSONObject)localObject).optString("title");
        localstPopWindowsConfig.jp_button = localstPopWindowsButton;
      }
      paramJSONObject = paramJSONObject.optJSONObject("annexation");
      if (paramJSONObject != null)
      {
        localObject = new stAnnexation();
        ((stAnnexation)localObject).money = paramJSONObject.optInt("money");
        localstPopWindowsConfig.annexation = ((stAnnexation)localObject);
      }
      localWSPushOpDialogModel.mStPopWindowsConfig = localstPopWindowsConfig;
      return localWSPushOpDialogModel;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(this.mStPopWindowsConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushOpDialogModel
 * JD-Core Version:    0.7.0.1
 */