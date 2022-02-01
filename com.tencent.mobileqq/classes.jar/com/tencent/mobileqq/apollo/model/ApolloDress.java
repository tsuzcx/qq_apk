package com.tencent.mobileqq.apollo.model;

import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
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
  public static final String[] DRESS_UNIT_DESCRIPTION_ARRAY = { HardCodeUtil.a(2131898586), HardCodeUtil.a(2131898583), HardCodeUtil.a(2131898579), HardCodeUtil.a(2131898585), HardCodeUtil.a(2131898584), HardCodeUtil.a(2131898580), HardCodeUtil.a(2131898582) };
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
    ApolloDress localApolloDress = new ApolloDress();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Object localObject1 = localJSONObject.getJSONObject("role");
        localApolloDress.roleId = ((JSONObject)localObject1).getInt("id");
        if (((JSONObject)localObject1).optInt("aiFlag", 0) != 1) {
          break label434;
        }
        bool = true;
        localApolloDress.isAIRole = bool;
        localApolloDress.roleTimeStamp = ((JSONObject)localObject1).optLong("ts");
        localApolloDress.feeType = ((JSONObject)localObject1).optInt("feeType");
        localApolloDress.tag = ((JSONObject)localObject1).optInt("tag");
        localApolloDress.mRoleGender = localJSONObject.optInt("sex");
        localApolloDress.belongCombId = localJSONObject.optInt("belongCombId");
        localApolloDress.combIsCollected = localJSONObject.optInt("combIsCollected");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parseApolloDress data:");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("ApolloDress", 2, ((StringBuilder)localObject1).toString());
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
        if (localApolloDress.dressMap != null)
        {
          paramString = localApolloDress;
          if (localApolloDress.dressMap.size() >= 7) {}
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append("parseApolloDress role dress do not complete :");
          paramString.append(localJSONObject.toString());
          QLog.e("ApolloDress", 2, paramString.toString());
          return localApolloDress;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloDress", 1, "parseApolloDress failed", paramString);
        paramString = null;
      }
      return paramString;
      label434:
      boolean bool = false;
    }
  }
  
  public static ApolloDress parseApolloDress3D(JSONObject paramJSONObject)
  {
    ApolloDress localApolloDress = null;
    if (paramJSONObject == null) {
      return null;
    }
    if (paramJSONObject.has("role"))
    {
      if (!paramJSONObject.has("dresslist")) {
        return null;
      }
      localApolloDress = new ApolloDress();
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
    }
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
      QLog.e("[cmshow]ApolloPet", 1, "parseApolloPetDress failed", paramString);
    }
    return null;
  }
  
  protected Object clone()
  {
    Object localObject;
    try
    {
      ApolloDress localApolloDress = (ApolloDress)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
      localObject = null;
    }
    HashMap localHashMap = this.dressMap;
    if (localHashMap != null) {
      localObject.dressMap = ((HashMap)localHashMap.clone());
    }
    return localObject;
  }
  
  public String encode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.roleId);
    localStringBuilder.append("|");
    localStringBuilder = new StringBuilder(localStringBuilder.toString());
    Object localObject = this.dressMap;
    if (localObject != null)
    {
      localObject = new TreeSet(((HashMap)localObject).keySet()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append(((Iterator)localObject).next());
        localStringBuilder.append("|");
      }
    }
    return localStringBuilder.toString();
  }
  
  public int[] getDressIds()
  {
    Object localObject1 = this.dressMap;
    if ((localObject1 != null) && (((HashMap)localObject1).keySet().size() != 0))
    {
      Object localObject2 = this.dressMap.keySet();
      localObject1 = new int[((Set)localObject2).size()];
      int i = 0;
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = ((Integer)((Iterator)localObject2).next()).intValue();
        i += 1;
      }
      return localObject1;
    }
    return ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(this.roleId);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ApolloDress{");
    localStringBuffer.append("roleId=");
    localStringBuffer.append(this.roleId);
    localStringBuffer.append(", mRoleGender=");
    localStringBuffer.append(this.mRoleGender);
    localStringBuffer.append(", roleTimeStamp=");
    localStringBuffer.append(this.roleTimeStamp);
    localStringBuffer.append(", feeType=");
    localStringBuffer.append(this.feeType);
    localStringBuffer.append(", tag=");
    localStringBuffer.append(this.tag);
    localStringBuffer.append(", isAIRole=");
    localStringBuffer.append(this.isAIRole);
    localStringBuffer.append(", belongCombId=");
    localStringBuffer.append(this.belongCombId);
    localStringBuffer.append(", combIsCollected=");
    localStringBuffer.append(this.combIsCollected);
    localStringBuffer.append(", faceData='");
    localStringBuffer.append(this.faceData);
    localStringBuffer.append('\'');
    Object localObject = this.dressMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).keySet();
      localStringBuffer.append(",ids [");
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuffer.append((Integer)((Iterator)localObject).next());
        localStringBuffer.append(",");
      }
      localStringBuffer.append("]");
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloDress
 * JD-Core Version:    0.7.0.1
 */