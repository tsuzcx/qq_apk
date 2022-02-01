package com.tencent.mobileqq.apollo.api.model;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloBaseInfo
  extends Entity
{
  public static final int MASK_3D = 1;
  public static final int MASK_3D_WHITELIST = 2;
  public static final int MASK_EMOTICON_ACTION = 16;
  private static final String TAG = "ApolloBaseInfo";
  public int apolloAISwitch;
  public String apolloDataBuffer;
  @notColumn
  private ApolloDress apolloDress;
  @notColumn
  private ApolloDress apolloHistory;
  public String apolloHistoryDress;
  public long apolloLocalSignTs;
  public long apolloLocalTS;
  @notColumn
  private ApolloDress apolloPetDress;
  public long apolloServerTS;
  public String apolloSignStr;
  public long apolloSignValidTS;
  public int apolloStatus;
  public long apolloUpdateTime;
  public int apolloVipFlag;
  public int apolloVipLevel;
  public String appearAction;
  public int cmshow3dFlag;
  public boolean hasPet;
  public String mApollo3DDataBuffer;
  @notColumn
  public ApolloDress mApolloDress3D;
  public String petNick;
  public int superYellowDiamondFlag;
  @unique
  public String uin;
  public int uinType;
  
  public static int calcSelfMemorySize()
  {
    return 284;
  }
  
  private void changeNewRole(AppInterface paramAppInterface, JSONObject paramJSONObject) {}
  
  public static void saveSelfApollo3DFace(AppInterface paramAppInterface, String paramString) {}
  
  public static void saveSelfApolloDress(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      ApolloBaseInfo localApolloBaseInfo;
      ApolloDress localApolloDress;
      try
      {
        long l = new JSONObject(paramString).optLong("ts");
        localObject2 = (IApolloManagerService)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        localApolloBaseInfo = ((IApolloManagerService)localObject2).getApolloBaseInfo(paramAppInterface.getCurrentAccountUin());
        localApolloDress = localApolloBaseInfo.getApolloDress();
        localApolloBaseInfo.setApolloDress(l, paramString);
        localObject1 = localApolloBaseInfo.getApolloDress();
        if (localApolloDress != null) {
          break label226;
        }
        paramString = "";
      }
      catch (Exception paramAppInterface) {}
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals(paramString, (CharSequence)localObject1))) {
        localApolloBaseInfo.apolloHistoryDress = paramString;
      }
      localApolloBaseInfo.appearAction = null;
      ((IApolloManagerService)localObject2).saveOrUpdateApolloBaseInfo(localApolloBaseInfo);
      paramAppInterface = (IApolloManagerService)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (paramAppInterface != null)
      {
        localObject2 = new ArrayList(1);
        ((List)localObject2).add(localApolloBaseInfo);
        paramAppInterface.updateUserDress((List)localObject2);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloBaseInfo", 2, "save history self dress: " + paramString + ", new dres: " + (String)localObject1);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ApolloBaseInfo", 2, paramAppInterface.getMessage());
      return;
      label226:
      paramString = localApolloDress.encode();
      while (localObject1 != null)
      {
        localObject1 = ((ApolloDress)localObject1).encode();
        break;
      }
      Object localObject1 = "";
    }
  }
  
  public int getAISwitch()
  {
    return this.apolloAISwitch & 0x3;
  }
  
  public ApolloDress getApolloDress()
  {
    if ((this.apolloDress == null) && (!TextUtils.isEmpty(this.apolloDataBuffer))) {
      this.apolloDress = ApolloDress.parseApolloDress(this.apolloDataBuffer);
    }
    return this.apolloDress;
  }
  
  public ApolloDress[] getApolloDress(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(2);
    if ((this.apolloDress == null) && (!TextUtils.isEmpty(this.apolloDataBuffer))) {
      this.apolloDress = ApolloDress.parseApolloDress(this.apolloDataBuffer);
    }
    if (this.apolloDress != null) {
      localArrayList.add(this.apolloDress);
    }
    String[] arrayOfString;
    int i;
    if ((this.apolloDress != null) && (!paramBoolean) && (!TextUtils.isEmpty(this.apolloHistoryDress))) {
      if (this.apolloHistory == null)
      {
        this.apolloHistory = new ApolloDress();
        this.apolloHistory.dressMap = new HashMap();
        arrayOfString = this.apolloHistoryDress.split("\\|");
        i = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (i < arrayOfString.length)
        {
          Integer localInteger = Integer.valueOf(Integer.parseInt(arrayOfString[i]));
          if (i == 0) {
            this.apolloHistory.roleId = localInteger.intValue();
          } else {
            this.apolloHistory.dressMap.put(localInteger, null);
          }
        }
      }
      catch (Exception localException)
      {
        this.apolloHistory = null;
      }
      for (;;)
      {
        if (this.apolloHistory != null) {
          localArrayList.add(this.apolloHistory);
        }
        if (localArrayList.size() != 0) {
          break;
        }
        return null;
        localArrayList.add(this.apolloHistory);
      }
      return (ApolloDress[])localArrayList.toArray(new ApolloDress[0]);
      i += 1;
    }
  }
  
  public ApolloDress getApolloDress3D()
  {
    if ((this.mApolloDress3D == null) && (!TextUtils.isEmpty(this.mApollo3DDataBuffer))) {}
    try
    {
      this.mApolloDress3D = ApolloDress.parseApolloDress3D(new JSONObject(this.mApollo3DDataBuffer));
      return this.mApolloDress3D;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloBaseInfo", 1, "getApolloDress3D " + localException);
      }
    }
  }
  
  public ApolloDress getApolloPetDress()
  {
    if ((this.apolloPetDress == null) && (!TextUtils.isEmpty(this.apolloDataBuffer))) {
      this.apolloPetDress = ApolloDress.parseApolloPetDress(this.apolloDataBuffer);
    }
    return this.apolloPetDress;
  }
  
  public JSONArray getDress3D(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator1 = null;
    getApolloDress3D();
    Object localObject = localIterator1;
    ArrayList localArrayList;
    if (this.mApolloDress3D != null)
    {
      localObject = localIterator1;
      if (this.mApolloDress3D.dressMap != null)
      {
        localObject = localIterator1;
        if (!this.mApolloDress3D.dressMap.isEmpty())
        {
          Iterator localIterator2 = this.mApolloDress3D.dressMap.entrySet().iterator();
          localObject = new JSONArray();
          localArrayList = new ArrayList();
          while (localIterator2.hasNext())
          {
            ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)localIterator2.next()).getValue();
            ((JSONArray)localObject).put(String.valueOf(localDress.id));
            if (!ApolloUtilImpl.checkDressRes(localDress.id)) {
              localArrayList.add(Integer.valueOf(localDress.id));
            }
          }
          if (!paramBoolean) {
            break label283;
          }
          if (!localArrayList.isEmpty()) {
            break label176;
          }
        }
      }
    }
    label176:
    do
    {
      return localObject;
      QLog.i("ApolloBaseInfo", 1, "getDress3D checkExistAndDownload but no exist, start download");
      localObject = localIterator1;
    } while (localArrayList.size() <= 0);
    localObject = new int[localArrayList.size()];
    localIterator1 = localArrayList.iterator();
    int i = 0;
    while (localIterator1.hasNext())
    {
      localObject[i] = ((Integer)localIterator1.next()).intValue();
      i += 1;
    }
    ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), null, -1, (int[])localObject, -1, -1, true);
    return null;
    label283:
    return localObject;
  }
  
  public JSONObject getFaceModel(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    getApolloDress3D();
    if ((this.mApolloDress3D != null) && (!TextUtils.isEmpty(this.mApolloDress3D.faceData))) {
      try
      {
        String str = MD5Utils.toMD5(this.mApolloDress3D.faceData);
        if (paramBoolean)
        {
          if (ApolloUtilImpl.check3DFaceRes(this.mApolloDress3D.faceData))
          {
            paramQQAppInterface = new JSONObject();
            paramQQAppInterface.put("path", "/face/" + str + File.separator);
            return paramQQAppInterface;
          }
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(paramQQAppInterface, this.mApolloDress3D.faceData, null);
          return null;
        }
        paramQQAppInterface = new JSONObject();
        paramQQAppInterface.put("path", "/face/" + str + File.separator);
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloBaseInfo", 1, "getFaceModel e" + paramQQAppInterface);
      }
    }
    return null;
  }
  
  public String getModel()
  {
    if ((this.cmshow3dFlag & 0x1) == 1) {
      return "3D";
    }
    return "2D";
  }
  
  public int getRole3D(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    int j = -1;
    getApolloDress3D();
    int i = j;
    if (this.mApolloDress3D != null)
    {
      i = j;
      if (this.mApolloDress3D.roleId > 0)
      {
        if (!paramBoolean) {
          break label100;
        }
        if (!ApolloUtilImpl.checkRoleRes(this.mApolloDress3D.roleId)) {
          break label58;
        }
        i = this.mApolloDress3D.roleId;
      }
    }
    return i;
    label58:
    QLog.i("ApolloBaseInfo", 1, "getRole3D checkExistAndDownload but no exist, start download");
    ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), null, this.mApolloDress3D.roleId, null, -1, -1, true);
    return -1;
    label100:
    return this.mApolloDress3D.roleId;
  }
  
  public boolean isAIWhiteUser()
  {
    return 1 == (this.apolloAISwitch >> 2 & 0x1);
  }
  
  public boolean isApolloEmoticonWhiteUser()
  {
    return (this.apolloAISwitch & 0x10) == 16;
  }
  
  public boolean isApolloGameWhiteUser()
  {
    return 1 == (this.apolloAISwitch >> 8 & 0x1);
  }
  
  public boolean isApolloStatusOpen()
  {
    return ApolloUtilImpl.isApolloStatusOpen(this);
  }
  
  public void setApolloDress(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("apollo_pet", 2, "setApolloDress:" + paramString);
    }
    this.apolloServerTS = paramLong;
    this.apolloLocalTS = paramLong;
    this.apolloDataBuffer = paramString;
    this.apolloHistory = null;
    this.apolloDress = null;
    this.apolloUpdateTime = NetConnInfoCenter.getServerTime();
    this.apolloDress = ApolloDress.parseApolloDress(this.apolloDataBuffer);
    this.apolloPetDress = ApolloDress.parseApolloPetDress(this.apolloDataBuffer);
    try
    {
      paramString = new JSONObject(this.apolloDataBuffer).optJSONArray("petList");
      if ((paramString != null) && (paramString.length() > 0))
      {
        this.hasPet = true;
        this.petNick = paramString.getJSONObject(0).optString("strBrand");
        return;
      }
      this.hasPet = false;
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloBaseInfo", 1, "parse pet nick error:", paramString);
    }
  }
  
  public void setApolloDress3D(AppInterface paramAppInterface, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramAppInterface == null)) {
      return;
    }
    if ((QLog.isColorLevel()) || (this.uin.equals(paramAppInterface.getCurrentAccountUin()))) {
      QLog.w("ApolloBaseInfo", 1, "setApolloDress3D:" + paramJSONObject.toString());
    }
    long l = paramJSONObject.optLong("ts");
    if (this.apolloLocalTS <= l)
    {
      this.apolloServerTS = l;
      this.apolloLocalTS = l;
    }
    for (;;)
    {
      changeNewRole(paramAppInterface, paramJSONObject);
      this.mApollo3DDataBuffer = paramJSONObject.toString();
      this.mApolloDress3D = ApolloDress.parseApolloDress3D(paramJSONObject);
      return;
      QLog.e("ApolloBaseInfo", 1, "setApolloDress3D apolloLocalTS > ts apolloLocalTS:" + this.apolloLocalTS + " apolloServerTS:" + this.apolloServerTS + " ts:" + l);
    }
  }
  
  public String toString()
  {
    return "ApolloBaseInfo{uin='" + this.uin + '\'' + ", apolloVipFlag=" + this.apolloVipFlag + ", apolloVipLevel=" + this.apolloVipLevel + ", apolloStatus=" + this.apolloStatus + ", cmshow3dFlag=" + this.cmshow3dFlag + ", apolloDataBuffer='" + this.apolloDataBuffer + '\'' + ", mApollo3DDataBuffer='" + this.mApollo3DDataBuffer + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo
 * JD-Core Version:    0.7.0.1
 */