package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.CityRes;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse.EmojiPack;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DoodleEmojiItem
  implements Cloneable
{
  public static final String POI_PASTER_LIST = "poi_poster_list";
  public String config;
  public String download_icon;
  public String download_url;
  public String download_wording;
  @Deprecated
  public int hide;
  public String icon;
  public Map<String, Map<String, InformationFacePackage.CityRes>> mCityRes;
  public List<InformationFacePackage.Item> mInfoItemList;
  public List<LocationFacePackage.Item> mItemList;
  public String mLocalEmojiFolderPath;
  public int mask;
  public String md5;
  public String name;
  public String pack_id;
  public String random_position;
  public int type;
  
  public DoodleEmojiItem() {}
  
  public DoodleEmojiItem(GetEmojiPackInfoListResponse.EmojiPack paramEmojiPack)
  {
    this.pack_id = paramEmojiPack.a;
    this.icon = paramEmojiPack.jdField_b_of_type_JavaLangString;
    this.download_icon = paramEmojiPack.c;
    this.name = paramEmojiPack.d;
    this.download_url = paramEmojiPack.e;
    this.config = paramEmojiPack.g;
    this.md5 = paramEmojiPack.f;
    this.type = paramEmojiPack.jdField_b_of_type_Int;
  }
  
  public DoodleEmojiItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.pack_id = paramString1;
    this.icon = paramString2;
    this.download_icon = null;
    this.name = paramString3;
    this.download_url = paramString4;
    this.config = paramString5;
    this.md5 = paramString6;
    this.type = 1;
    this.mask = 0;
  }
  
  public static DoodleEmojiItem getDoodleEmojiItemFromJsonObj(JSONObject paramJSONObject)
  {
    DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)JSONUtils.a(paramJSONObject, DoodleEmojiItem.class);
    int i;
    if (localDoodleEmojiItem != null)
    {
      i = localDoodleEmojiItem.type;
      if ((i != 1) && (i != 2)) {}
    }
    try
    {
      localDoodleEmojiItem.mItemList = LocationFacePackage.a(paramJSONObject.getJSONArray("poi_poster_list"));
      return localDoodleEmojiItem;
    }
    catch (JSONException paramJSONObject)
    {
      label141:
      break label141;
    }
    if (i == 3)
    {
      localDoodleEmojiItem.mInfoItemList = InformationFacePackage.a(paramJSONObject.getJSONArray("info_poster_list"));
      localDoodleEmojiItem.mCityRes = InformationFacePackage.a(paramJSONObject.optJSONArray("city_res"));
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "parsed information item list");
      }
      paramJSONObject = (QIMInformationPasterManager)QIMManager.a().c(12);
      if (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMInformationPasterManager", 2, "batchPullAllRes");
        }
        paramJSONObject.a(localDoodleEmojiItem.mInfoItemList);
        return localDoodleEmojiItem;
      }
      paramJSONObject.a(localDoodleEmojiItem);
      return localDoodleEmojiItem;
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, paramJSONObject, new Object[0]);
      }
      paramJSONObject.printStackTrace();
      return null;
    }
    return localDoodleEmojiItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (DoodleEmojiItem)paramObject;
      return this.pack_id.equals(paramObject.pack_id);
    }
    return false;
  }
  
  public String getLocalEmojiFolderPath()
  {
    return this.mLocalEmojiFolderPath;
  }
  
  public int hashCode()
  {
    return this.pack_id.hashCode();
  }
  
  public void setLocalEmojiFolderPath(String paramString)
  {
    this.mLocalEmojiFolderPath = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoodleEmojiItem{pack_id='");
    localStringBuilder.append(this.pack_id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", icon='");
    localStringBuilder.append(this.icon);
    localStringBuilder.append('\'');
    localStringBuilder.append(", download_icon='");
    localStringBuilder.append(this.download_icon);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", download_url='");
    localStringBuilder.append(this.download_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLocalEmojiFolderPath='");
    localStringBuilder.append(this.mLocalEmojiFolderPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", config='");
    localStringBuilder.append(this.config);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mask=");
    localStringBuilder.append(this.mask);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem
 * JD-Core Version:    0.7.0.1
 */