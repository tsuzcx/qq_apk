package com.tencent.mobileqq.apollo.api.model;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloDress
  implements Cloneable
{
  public static final String[] DRESS_UNIT_DESCRIPTION_ARRAY = { HardCodeUtil.a(2131700413), HardCodeUtil.a(2131700410), HardCodeUtil.a(2131700406), HardCodeUtil.a(2131700412), HardCodeUtil.a(2131700411), HardCodeUtil.a(2131700407), HardCodeUtil.a(2131700409) };
  public static final Map<String, Integer> DRESS_UNIT_MAP = new ApolloDress.1();
  public int belongCombId;
  public int combIsCollected;
  public HashMap<Integer, ApolloDress.Dress> dressMap;
  public String faceData;
  public int feeType;
  public boolean isAIRole = false;
  public int mRoleGender;
  public int roleId;
  public long roleTimeStamp;
  public int tag;
  
  public static ApolloDress parseApolloDress(String paramString)
  {
    boolean bool = true;
    ApolloDress localApolloDress = new ApolloDress();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Object localObject1 = localJSONObject.getJSONObject("role");
        localApolloDress.roleId = ((JSONObject)localObject1).getInt("id");
        if (((JSONObject)localObject1).optInt("aiFlag", 0) == 1)
        {
          localApolloDress.isAIRole = bool;
          localApolloDress.roleTimeStamp = ((JSONObject)localObject1).optLong("ts");
          localApolloDress.feeType = ((JSONObject)localObject1).optInt("feeType");
          localApolloDress.tag = ((JSONObject)localObject1).optInt("tag");
          localApolloDress.mRoleGender = localJSONObject.optInt("sex");
          localApolloDress.belongCombId = localJSONObject.optInt("belongCombId");
          localApolloDress.combIsCollected = localJSONObject.optInt("combIsCollected");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDress", 2, "parseApolloDress data:" + paramString);
          }
          paramString = localJSONObject.getJSONArray("dresslist");
          int i = 0;
          if (i < paramString.length())
          {
            Object localObject2 = paramString.getJSONObject(i);
            localObject1 = new ApolloDress.Dress();
            ((ApolloDress.Dress)localObject1).id = ((JSONObject)localObject2).getInt("id");
            ((ApolloDress.Dress)localObject1).ts = ((JSONObject)localObject2).getLong("ts");
            ((ApolloDress.Dress)localObject1).feeType = ((JSONObject)localObject2).optInt("feeType");
            ((ApolloDress.Dress)localObject1).tag = ((JSONObject)localObject2).optInt("tag");
            ((ApolloDress.Dress)localObject1).attachPart = new ArrayList();
            localObject2 = ((JSONObject)localObject2).getJSONArray("parts");
            int j = 0;
            if (j < ((JSONArray)localObject2).length())
            {
              ((ApolloDress.Dress)localObject1).attachPart.add(((JSONArray)localObject2).getString(j));
              j += 1;
              continue;
            }
            if (localApolloDress.dressMap == null) {
              localApolloDress.dressMap = new HashMap();
            }
            localApolloDress.dressMap.put(Integer.valueOf(((ApolloDress.Dress)localObject1).id), localObject1);
            i += 1;
            continue;
          }
          if ((localApolloDress.dressMap == null) || (localApolloDress.dressMap.size() < 7)) {
            QLog.e("ApolloDress", 2, "parseApolloDress role dress do not complete :" + localJSONObject.toString());
          }
          return localApolloDress;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloDress", 2, "parseApolloDress failed", paramString);
        }
        return null;
      }
      bool = false;
    }
  }
  
  public static ApolloDress parseApolloDress3D(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while ((!paramJSONObject.has("role")) || (!paramJSONObject.has("dresslist"))) {
      return null;
    }
    ApolloDress localApolloDress = new ApolloDress();
    localApolloDress.mRoleGender = paramJSONObject.optInt("sex");
    Object localObject1 = paramJSONObject.optJSONObject("role");
    if (localObject1 != null)
    {
      localApolloDress.roleId = ((JSONObject)localObject1).optInt("id");
      localApolloDress.roleTimeStamp = ((JSONObject)localObject1).optLong("ts");
    }
    localObject1 = paramJSONObject.optJSONArray("dresslist");
    if (localObject1 != null)
    {
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        ApolloDress.Dress localDress = new ApolloDress.Dress();
        localDress.id = ((JSONObject)localObject2).optInt("id");
        localDress.ts = ((JSONObject)localObject2).optLong("ts");
        localDress.attachPart = new ArrayList();
        localObject2 = ((JSONObject)localObject2).optJSONArray("parts");
        int j = 0;
        while ((localObject2 != null) && (j < ((JSONArray)localObject2).length()))
        {
          localDress.attachPart.add(((JSONArray)localObject2).optString(j));
          j += 1;
        }
        if (localApolloDress.dressMap == null) {
          localApolloDress.dressMap = new HashMap();
        }
        localApolloDress.dressMap.put(Integer.valueOf(localDress.id), localDress);
        i += 1;
      }
    }
    localApolloDress.faceData = paramJSONObject.optString("faceData");
    return localApolloDress;
  }
  
  public static ApolloDress parseApolloPetDress(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("petList");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = parseApolloDress(paramString.getJSONObject(0).toString());
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloPet", 2, "parseApolloPetDress failed", paramString);
      }
    }
    return null;
  }
  
  protected Object clone()
  {
    Object localObject = null;
    try
    {
      ApolloDress localApolloDress = (ApolloDress)super.clone();
      localObject = localApolloDress;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.dressMap != null) {
      localObject.dressMap = ((HashMap)this.dressMap.clone());
    }
    return localObject;
  }
  
  public String encode()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.roleId + "|");
    if (this.dressMap != null)
    {
      Iterator localIterator = new TreeSet(this.dressMap.keySet()).iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(localIterator.next()).append("|");
      }
    }
    return localStringBuilder.toString();
  }
  
  public int[] getDressIds()
  {
    if ((this.dressMap == null) || (this.dressMap.keySet().size() == 0)) {
      return ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(this.roleId);
    }
    Object localObject = this.dressMap.keySet();
    int[] arrayOfInt = new int[((Set)localObject).size()];
    localObject = ((Set)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = ((Integer)((Iterator)localObject).next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ApolloDress{");
    localStringBuffer.append("roleId=").append(this.roleId);
    localStringBuffer.append(", mRoleGender=").append(this.mRoleGender);
    localStringBuffer.append(", roleTimeStamp=").append(this.roleTimeStamp);
    localStringBuffer.append(", feeType=").append(this.feeType);
    localStringBuffer.append(", tag=").append(this.tag);
    localStringBuffer.append(", isAIRole=").append(this.isAIRole);
    localStringBuffer.append(", belongCombId=").append(this.belongCombId);
    localStringBuffer.append(", combIsCollected=").append(this.combIsCollected);
    localStringBuffer.append(", faceData='").append(this.faceData).append('\'');
    if (this.dressMap != null)
    {
      Object localObject = this.dressMap.keySet();
      localStringBuffer.append(",ids [");
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuffer.append((Integer)((Iterator)localObject).next()).append(",");
      }
      localStringBuffer.append("]");
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloDress
 * JD-Core Version:    0.7.0.1
 */