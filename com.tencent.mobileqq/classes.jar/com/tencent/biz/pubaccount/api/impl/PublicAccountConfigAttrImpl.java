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
      localPaConfigInfo.a = paramJSONObject.optInt("type");
      localPaConfigInfo.b = paramJSONObject.optString("title");
      localPaConfigInfo.c = paramJSONObject.optString("content");
      localPaConfigInfo.d = paramJSONObject.optInt("follow_handle");
      localPaConfigInfo.e = paramJSONObject.optInt("event_id");
      localPaConfigInfo.f = paramJSONObject.optInt("state");
      localPaConfigInfo.g = paramJSONObject.optInt("state_id");
      localPaConfigInfo.h = paramJSONObject.optString("url");
      localPaConfigInfo.i = paramJSONObject.optInt("confirm_flag");
      localPaConfigInfo.j = paramJSONObject.optString("confirm_tips");
      localPaConfigInfo.k = paramJSONObject.optString("pic_url");
      localPaConfigInfo.l = paramJSONObject.optString("lng");
      localPaConfigInfo.m = paramJSONObject.optString("lat");
      localPaConfigInfo.n = paramJSONObject.optString("phone_number");
      localPaConfigInfo.o = paramJSONObject.optInt("width");
      localPaConfigInfo.p = paramJSONObject.optInt("height");
      localPaConfigInfo.q = paramJSONObject.optString("icon");
      localPaConfigInfo.r = paramJSONObject.optString("vid");
      if ((localPaConfigInfo.a == 3) && (localPaConfigInfo.e == 23) && (!TextUtils.isEmpty(localPaConfigInfo.c)))
      {
        paramJSONObject = new DynamicInfo();
        paramJSONObject.a(localPaConfigInfo.c);
        if ((TextUtils.isEmpty(localPaConfigInfo.k)) && (!TextUtils.isEmpty(paramJSONObject.f.b))) {
          localPaConfigInfo.k = paramJSONObject.f.b;
        }
        if ((TextUtils.isEmpty(localPaConfigInfo.b)) && (!TextUtils.isEmpty(paramJSONObject.a)))
        {
          localPaConfigInfo.b = paramJSONObject.a;
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
    paramPaConfigInfo.a = paramConfigInfo.type.get();
    paramPaConfigInfo.b = paramConfigInfo.title.get();
    paramPaConfigInfo.c = paramConfigInfo.content.get();
    paramPaConfigInfo.e = paramConfigInfo.event_id.get();
    paramPaConfigInfo.h = paramConfigInfo.url.get();
    paramPaConfigInfo.f = paramConfigInfo.state.get();
    paramPaConfigInfo.g = paramConfigInfo.state_id.get();
    paramPaConfigInfo.i = paramConfigInfo.confirm_flag.get();
    paramPaConfigInfo.j = paramConfigInfo.confirm_tips.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl
 * JD-Core Version:    0.7.0.1
 */