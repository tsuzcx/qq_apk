package com.tencent.biz.pubaccount.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.bean.VideoAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PublicAccountConfigAttrImpl
  implements IPublicAccountConfigAttr
{
  public List<IPublicAccountConfigAttr.PaConfigInfo> configs;
  public int type;
  
  public PublicAccountConfigAttrImpl()
  {
    this.type = 0;
    this.configs = new ArrayList();
  }
  
  public PublicAccountConfigAttrImpl(int paramInt, mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo)
  {
    this.type = paramInt;
    if (paramConfigGroupInfo == null) {
      return;
    }
    paramConfigGroupInfo = paramConfigGroupInfo.config_info.get();
    this.configs = new ArrayList(paramConfigGroupInfo.size());
    paramConfigGroupInfo = paramConfigGroupInfo.iterator();
    while (paramConfigGroupInfo.hasNext())
    {
      IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = new IPublicAccountConfigAttr.PaConfigInfo();
      initPaConfigInfo(localPaConfigInfo, (mobileqq_mp.ConfigInfo)paramConfigGroupInfo.next());
      this.configs.add(localPaConfigInfo);
    }
  }
  
  public PublicAccountConfigAttrImpl(mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo)
  {
    this(0, paramConfigGroupInfo);
  }
  
  private static IPublicAccountConfigAttr.PaConfigInfo parser(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = new IPublicAccountConfigAttr.PaConfigInfo();
    try
    {
      localPaConfigInfo.jdField_a_of_type_Int = paramJSONObject.optInt("type");
      localPaConfigInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
      localPaConfigInfo.jdField_b_of_type_JavaLangString = paramJSONObject.optString("content");
      localPaConfigInfo.jdField_b_of_type_Int = paramJSONObject.optInt("follow_handle");
      localPaConfigInfo.jdField_c_of_type_Int = paramJSONObject.optInt("event_id");
      localPaConfigInfo.jdField_d_of_type_Int = paramJSONObject.optInt("state");
      localPaConfigInfo.jdField_e_of_type_Int = paramJSONObject.optInt("state_id");
      localPaConfigInfo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
      localPaConfigInfo.jdField_f_of_type_Int = paramJSONObject.optInt("confirm_flag");
      localPaConfigInfo.jdField_d_of_type_JavaLangString = paramJSONObject.optString("confirm_tips");
      localPaConfigInfo.jdField_e_of_type_JavaLangString = paramJSONObject.optString("pic_url");
      localPaConfigInfo.jdField_f_of_type_JavaLangString = paramJSONObject.optString("lng");
      localPaConfigInfo.jdField_g_of_type_JavaLangString = paramJSONObject.optString("lat");
      localPaConfigInfo.jdField_h_of_type_JavaLangString = paramJSONObject.optString("phone_number");
      localPaConfigInfo.jdField_g_of_type_Int = paramJSONObject.optInt("width");
      localPaConfigInfo.jdField_h_of_type_Int = paramJSONObject.optInt("height");
      localPaConfigInfo.i = paramJSONObject.optString("icon");
      localPaConfigInfo.j = paramJSONObject.optString("vid");
      if ((localPaConfigInfo.jdField_a_of_type_Int == 3) && (localPaConfigInfo.jdField_c_of_type_Int == 23) && (!TextUtils.isEmpty(localPaConfigInfo.jdField_b_of_type_JavaLangString)))
      {
        paramJSONObject = new DynamicInfo();
        paramJSONObject.a(localPaConfigInfo.jdField_b_of_type_JavaLangString);
        if ((TextUtils.isEmpty(localPaConfigInfo.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramJSONObject.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_JavaLangString))) {
          localPaConfigInfo.jdField_e_of_type_JavaLangString = paramJSONObject.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_JavaLangString;
        }
        if ((TextUtils.isEmpty(localPaConfigInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramJSONObject.jdField_a_of_type_JavaLangString)))
        {
          localPaConfigInfo.jdField_a_of_type_JavaLangString = paramJSONObject.jdField_a_of_type_JavaLangString;
          return localPaConfigInfo;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localPaConfigInfo;
  }
  
  public List<IPublicAccountConfigAttr> castToPaConfigAttrs(List<mobileqq_mp.ConfigGroupInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new PublicAccountConfigAttrImpl((mobileqq_mp.ConfigGroupInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public List<IPublicAccountConfigAttr.PaConfigInfo> getConfigs()
  {
    return this.configs;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void initPaConfigInfo(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, mobileqq_mp.ConfigInfo paramConfigInfo)
  {
    paramPaConfigInfo.jdField_a_of_type_Int = paramConfigInfo.type.get();
    paramPaConfigInfo.jdField_a_of_type_JavaLangString = paramConfigInfo.title.get();
    paramPaConfigInfo.jdField_b_of_type_JavaLangString = paramConfigInfo.content.get();
    paramPaConfigInfo.jdField_c_of_type_Int = paramConfigInfo.event_id.get();
    paramPaConfigInfo.jdField_c_of_type_JavaLangString = paramConfigInfo.url.get();
    paramPaConfigInfo.jdField_d_of_type_Int = paramConfigInfo.state.get();
    paramPaConfigInfo.jdField_e_of_type_Int = paramConfigInfo.state_id.get();
    paramPaConfigInfo.jdField_f_of_type_Int = paramConfigInfo.confirm_flag.get();
    paramPaConfigInfo.jdField_d_of_type_JavaLangString = paramConfigInfo.confirm_tips.get();
  }
  
  public List<IPublicAccountConfigAttr> parser(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    for (;;)
    {
      int j;
      try
      {
        int k = paramJSONArray.length();
        int i = 0;
        if (i < k)
        {
          Object localObject = paramJSONArray.getJSONObject(i);
          PublicAccountConfigAttrImpl localPublicAccountConfigAttrImpl = new PublicAccountConfigAttrImpl();
          localPublicAccountConfigAttrImpl.type = ((JSONObject)localObject).optInt("type");
          localObject = ((JSONObject)localObject).getJSONArray("config");
          int m = ((JSONArray)localObject).length();
          j = 0;
          if (j < m)
          {
            IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = parser(((JSONArray)localObject).getJSONObject(j));
            if (localPaConfigInfo != null) {
              localPublicAccountConfigAttrImpl.configs.add(localPaConfigInfo);
            }
          }
          else
          {
            localArrayList.add(localPublicAccountConfigAttrImpl);
            i += 1;
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl
 * JD-Core Version:    0.7.0.1
 */