package com.tencent.mobileqq.apollo.model;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloBaseInfo
  extends Entity
{
  public static final int MASK_3D = 1;
  public static final int MASK_3D_WHITELIST = 2;
  public static final int MASK_EMOTICON_ACTION = 16;
  private static final String TAG = "ApolloBaseInfo";
  public int apolloAIOStatus;
  public int apolloAISwitch;
  public int apolloCardStatus;
  public String apolloDataBuffer;
  public int apolloDrawerStatus;
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
  public String mBallImg = "";
  public String mBallImgPath = "";
  public String mBgImg = "";
  public String mBgImgPath = "";
  public String mLevel = "0";
  public String petNick;
  public int superYellowDiamondFlag;
  @unique
  public String uin;
  public int uinType;
  
  public static int calcSelfMemorySize()
  {
    return 284;
  }
  
  public static void saveSelfApolloDress(AppRuntime paramAppRuntime, String paramString)
  {
    ApolloDress localApolloDress1;
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        long l = new JSONObject(paramString).optLong("ts");
        localObject = (IApolloDaoManagerService)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
        localApolloBaseInfo = ((IApolloDaoManagerService)localObject).getApolloBaseInfo(paramAppRuntime.getCurrentAccountUin());
        ApolloDress localApolloDress2 = localApolloBaseInfo.getApolloDress();
        localApolloBaseInfo.setApolloDress(l, paramString);
        localApolloDress1 = localApolloBaseInfo.getApolloDress();
        str = "";
        if (localApolloDress2 == null) {
          paramString = "";
        } else {
          paramString = localApolloDress2.encode();
        }
      }
      catch (Exception paramAppRuntime)
      {
        Object localObject;
        ApolloBaseInfo localApolloBaseInfo;
        String str;
        QLog.e("ApolloBaseInfo", 2, paramAppRuntime.getMessage());
      }
      str = localApolloDress1.encode();
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.equals(paramString, str))) {
        localApolloBaseInfo.apolloHistoryDress = paramString;
      }
      localApolloBaseInfo.appearAction = null;
      ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).delAllGifCache();
      ((IApolloDaoManagerService)localObject).saveOrUpdateApolloBaseInfo(localApolloBaseInfo);
      paramAppRuntime = (IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
      if (paramAppRuntime != null)
      {
        localObject = new ArrayList(1);
        ((List)localObject).add(localApolloBaseInfo);
        paramAppRuntime.updateUserDress((List)localObject);
      }
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("save history self dress: ");
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(", new dres: ");
        paramAppRuntime.append(str);
        QLog.d("ApolloBaseInfo", 2, paramAppRuntime.toString());
        return;
      }
      return;
      if (localApolloDress1 != null) {
        break;
      }
    }
  }
  
  public void downCmLevelImg(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("def/petName/ballImg/");
    localStringBuilder.append(this.mBallImg.hashCode());
    this.mBallImgPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApolloConstant.a);
    localStringBuilder.append("/");
    localStringBuilder.append(this.mBallImgPath);
    localStringBuilder.append(".png");
    paramString1 = new DownloadTask(paramString1, new File(localStringBuilder.toString()));
    ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download(paramString1, MobileQQ.sMobileQQ.waitAppRuntime(null));
    paramString1 = new StringBuilder();
    paramString1.append("def/petName/bgImg/");
    paramString1.append(this.mBgImg.hashCode());
    this.mBgImgPath = paramString1.toString();
    paramString1 = new StringBuilder();
    paramString1.append(ApolloConstant.a);
    paramString1.append("/");
    paramString1.append(this.mBgImgPath);
    paramString1.append(".png");
    paramString1 = new DownloadTask(paramString2, new File(paramString1.toString()));
    int i = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download(paramString1, MobileQQ.sMobileQQ.waitAppRuntime(null));
    paramString1 = new StringBuilder();
    paramString1.append("save downCmLevelImg result: ");
    paramString1.append(i);
    QLog.d("ApolloBaseInfo", 2, paramString1.toString());
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
    Object localObject = this.apolloDress;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    int i;
    if ((this.apolloDress != null) && (!paramBoolean) && (!TextUtils.isEmpty(this.apolloHistoryDress))) {
      if (this.apolloHistory == null)
      {
        this.apolloHistory = new ApolloDress();
        this.apolloHistory.dressMap = new HashMap();
        localObject = this.apolloHistoryDress.split("\\|");
        i = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (i < localObject.length)
        {
          Integer localInteger = Integer.valueOf(Integer.parseInt(localObject[i]));
          if (i == 0)
          {
            this.apolloHistory.roleId = localInteger.intValue();
            continue;
          }
          this.apolloHistory.dressMap.put(localInteger, null);
          continue;
        }
        localArrayList.add(this.apolloHistory);
      }
      catch (Exception localException)
      {
        continue;
        i += 1;
      }
      this.apolloHistory = null;
      localObject = this.apolloHistory;
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      if (localArrayList.size() == 0) {
        return null;
      }
      return (ApolloDress[])localArrayList.toArray(new ApolloDress[0]);
    }
  }
  
  public ApolloDress getApolloDress3D()
  {
    if ((this.mApolloDress3D == null) && (!TextUtils.isEmpty(this.mApollo3DDataBuffer))) {
      try
      {
        this.mApolloDress3D = ApolloDress.parseApolloDress3D(new JSONObject(this.mApollo3DDataBuffer));
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getApolloDress3D ");
        localStringBuilder.append(localException);
        QLog.e("ApolloBaseInfo", 1, localStringBuilder.toString());
      }
    }
    return this.mApolloDress3D;
  }
  
  public ApolloDress getApolloPetDress()
  {
    if ((this.apolloPetDress == null) && (!TextUtils.isEmpty(this.apolloDataBuffer))) {
      this.apolloPetDress = ApolloDress.parseApolloPetDress(this.apolloDataBuffer);
    }
    return this.apolloPetDress;
  }
  
  public JSONArray getDress3D(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    getApolloDress3D();
    Object localObject2 = this.mApolloDress3D;
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    if (((ApolloDress)localObject2).dressMap != null)
    {
      if (this.mApolloDress3D.dressMap.isEmpty()) {
        return null;
      }
      localObject1 = this.mApolloDress3D.dressMap.entrySet().iterator();
      localObject2 = new JSONArray();
      Object localObject3 = new ArrayList();
      while (((Iterator)localObject1).hasNext())
      {
        ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)((Iterator)localObject1).next()).getValue();
        ((JSONArray)localObject2).put(String.valueOf(localDress.id));
        if (!((IApolloUtil)QRoute.api(IApolloUtil.class)).isDressResExist(localDress.id)) {
          ((List)localObject3).add(Integer.valueOf(localDress.id));
        }
      }
      localObject1 = localObject2;
      if (((List)localObject3).size() > 0)
      {
        localObject1 = new int[((List)localObject3).size()];
        int i = 0;
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject1[i] = ((Integer)((Iterator)localObject3).next()).intValue();
          i += 1;
        }
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(paramAppRuntime, paramAppRuntime.getCurrentAccountUin(), null, -1, (int[])localObject1, -1, -1, true);
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public JSONObject getFaceModel(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    getApolloDress3D();
    Object localObject = this.mApolloDress3D;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((ApolloDress)localObject).faceData)) {
        return null;
      }
      try
      {
        localObject = MD5Utils.toMD5(this.mApolloDress3D.faceData);
        if (paramBoolean)
        {
          if (((IApolloUtil)QRoute.api(IApolloUtil.class)).is3DFaceResExist(this.mApolloDress3D.faceData))
          {
            paramAppRuntime = new JSONObject();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("/face/");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(File.separator);
            paramAppRuntime.put("path", localStringBuilder.toString());
            return paramAppRuntime;
          }
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(paramAppRuntime, this.mApolloDress3D.faceData, null);
          return null;
        }
        paramAppRuntime = new JSONObject();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("/face/");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(File.separator);
        paramAppRuntime.put("path", localStringBuilder.toString());
        return paramAppRuntime;
      }
      catch (Exception paramAppRuntime)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFaceModel e");
        ((StringBuilder)localObject).append(paramAppRuntime);
        QLog.e("ApolloBaseInfo", 1, ((StringBuilder)localObject).toString());
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
  
  public int getRole3D(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    getApolloDress3D();
    ApolloDress localApolloDress = this.mApolloDress3D;
    if ((localApolloDress != null) && (localApolloDress.roleId > 0))
    {
      if (paramBoolean)
      {
        if (((IApolloUtil)QRoute.api(IApolloUtil.class)).isRoleResExist(this.mApolloDress3D.roleId)) {
          return this.mApolloDress3D.roleId;
        }
        QLog.i("ApolloBaseInfo", 1, "getRole3D checkExistAndDownload but no exist, start download");
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(paramAppRuntime, paramAppRuntime.getCurrentAccountUin(), null, this.mApolloDress3D.roleId, null, -1, -1, true);
        return -1;
      }
      return this.mApolloDress3D.roleId;
    }
    return -1;
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
    return this.apolloStatus == 1;
  }
  
  public void setApolloDress(long paramLong, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setApolloDress:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("apollo_pet", 2, ((StringBuilder)localObject).toString());
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
      paramString = new JSONObject(this.apolloDataBuffer);
      localObject = paramString.optJSONArray("petList");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        this.hasPet = true;
        this.petNick = ((JSONArray)localObject).getJSONObject(0).optString("strBrand");
      }
      else
      {
        this.hasPet = false;
      }
      paramString = paramString.optJSONArray("partnerPetInfoList");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = paramString.getJSONObject(0);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.optInt("level"));
        ((StringBuilder)localObject).append("");
        this.mLevel = ((StringBuilder)localObject).toString();
        paramString = paramString.optJSONObject("icon");
        this.mBallImg = paramString.optString("ball_img");
        this.mBgImg = paramString.optString("bg_img");
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("save partnerPetInfoList level: ");
          paramString.append(this.mLevel);
          paramString.append(", ball_img: ");
          paramString.append(this.mBallImg);
          paramString.append(", bg_img: ");
          paramString.append(this.mBgImg);
          QLog.d("ApolloBaseInfo", 2, paramString.toString());
        }
        downCmLevelImg(this.mBallImg, this.mBgImg);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloBaseInfo", 1, "parse pet nick error:", paramString);
    }
  }
  
  public void setApolloDress3D(AppInterface paramAppInterface, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramAppInterface == null) {
        return;
      }
      if ((QLog.isColorLevel()) || (this.uin.equals(paramAppInterface.getCurrentAccountUin())))
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("setApolloDress3D:");
        paramAppInterface.append(paramJSONObject.toString());
        QLog.w("ApolloBaseInfo", 1, paramAppInterface.toString());
      }
      long l = paramJSONObject.optLong("ts");
      if (this.apolloLocalTS <= l)
      {
        this.apolloServerTS = l;
        this.apolloLocalTS = l;
      }
      else
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("setApolloDress3D apolloLocalTS > ts apolloLocalTS:");
        paramAppInterface.append(this.apolloLocalTS);
        paramAppInterface.append(" apolloServerTS:");
        paramAppInterface.append(this.apolloServerTS);
        paramAppInterface.append(" ts:");
        paramAppInterface.append(l);
        QLog.e("ApolloBaseInfo", 1, paramAppInterface.toString());
      }
      this.mApollo3DDataBuffer = paramJSONObject.toString();
      this.mApolloDress3D = ApolloDress.parseApolloDress3D(paramJSONObject);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloBaseInfo{uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", apolloVipFlag=");
    localStringBuilder.append(this.apolloVipFlag);
    localStringBuilder.append(", apolloVipLevel=");
    localStringBuilder.append(this.apolloVipLevel);
    localStringBuilder.append(", apolloStatus=");
    localStringBuilder.append(this.apolloStatus);
    localStringBuilder.append(", apolloDrawerStatus=");
    localStringBuilder.append(this.apolloDrawerStatus);
    localStringBuilder.append(", apolloCardStatus=");
    localStringBuilder.append(this.apolloCardStatus);
    localStringBuilder.append(", apolloAIOStatus=");
    localStringBuilder.append(this.apolloAIOStatus);
    localStringBuilder.append(", cmshow3dFlag=");
    localStringBuilder.append(this.cmshow3dFlag);
    localStringBuilder.append(", apolloLocalTS= ");
    localStringBuilder.append(this.apolloLocalTS);
    localStringBuilder.append(", apolloServerTS= ");
    localStringBuilder.append(this.apolloServerTS);
    localStringBuilder.append(", apolloUpdateTime= ");
    localStringBuilder.append(this.apolloUpdateTime);
    localStringBuilder.append(", apolloAISwitch= ");
    localStringBuilder.append(this.apolloAISwitch);
    localStringBuilder.append(", apolloDataBuffer='");
    localStringBuilder.append(this.apolloDataBuffer);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mApollo3DDataBuffer='");
    localStringBuilder.append(this.mApollo3DDataBuffer);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloBaseInfo
 * JD-Core Version:    0.7.0.1
 */