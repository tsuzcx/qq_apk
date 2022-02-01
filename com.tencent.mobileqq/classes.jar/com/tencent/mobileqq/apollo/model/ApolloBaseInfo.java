package com.tencent.mobileqq.apollo.model;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloABTestApi;
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
import org.json.JSONException;
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
  @notColumn
  public ApolloCmQQStatusData apolloCmQQStatusData;
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
    Object localObject = this.mApolloDress3D;
    paramAppRuntime = null;
    if (localObject == null) {
      return null;
    }
    if (((ApolloDress)localObject).dressMap != null)
    {
      if (this.mApolloDress3D.dressMap.isEmpty()) {
        return null;
      }
      Iterator localIterator = this.mApolloDress3D.dressMap.entrySet().iterator();
      localObject = new JSONArray();
      for (;;)
      {
        paramAppRuntime = (AppRuntime)localObject;
        if (!localIterator.hasNext()) {
          break;
        }
        ((JSONArray)localObject).put(String.valueOf(((ApolloDress.Dress)((Map.Entry)localIterator.next()).getValue()).id));
      }
    }
    return paramAppRuntime;
  }
  
  public JSONObject getFaceModel(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    getApolloDress3D();
    paramAppRuntime = this.mApolloDress3D;
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramAppRuntime.faceData)) {
        return null;
      }
      try
      {
        paramAppRuntime = MD5Utils.toMD5(this.mApolloDress3D.faceData);
        localObject = new JSONObject();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("/face/");
        localStringBuilder.append(paramAppRuntime);
        localStringBuilder.append(File.separator);
        ((JSONObject)localObject).put("path", localStringBuilder.toString());
        return localObject;
      }
      catch (Exception paramAppRuntime)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFaceModel e");
        ((StringBuilder)localObject).append(paramAppRuntime);
        QLog.e("ApolloBaseInfo", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public String getModel()
  {
    if (is3D()) {
      return "3D";
    }
    return "2D";
  }
  
  public int getRole3D(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    getApolloDress3D();
    paramAppRuntime = this.mApolloDress3D;
    if ((paramAppRuntime != null) && (paramAppRuntime.roleId > 0)) {
      return this.mApolloDress3D.roleId;
    }
    return -1;
  }
  
  public boolean is3D()
  {
    return (this.cmshow3dFlag & 0x1) == 1;
  }
  
  public boolean isApolloEmoticonWhiteUser()
  {
    return (this.apolloAISwitch & 0x10) == 16;
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
  
  public void setQQApolloStatus()
  {
    boolean bool = ((IApolloABTestApi)QRoute.api(IApolloABTestApi.class)).canCmStatusExp();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("check shouldShowCmStatus: ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("ApolloBaseInfo", 1, ((StringBuilder)localObject).toString());
    if (!bool)
    {
      this.apolloCmQQStatusData = null;
      return;
    }
    try
    {
      localObject = new JSONObject(this.apolloDataBuffer).optJSONObject("qq_status");
      if (localObject == null)
      {
        QLog.e("ApolloBaseInfo", 1, "qqStatus js obj empty");
        return;
      }
      if ((this.apolloCmQQStatusData == null) || (this.apolloCmQQStatusData.apolloQQTs != ((JSONObject)localObject).optLong("ts", 0L)))
      {
        this.apolloCmQQStatusData = ((ApolloCmQQStatusData)new Gson().fromJson(String.valueOf(localObject), ApolloCmQQStatusData.class));
        this.apolloCmQQStatusData.refreshSettings();
        QLog.d("ApolloBaseInfo", 1, this.apolloCmQQStatusData.toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloBaseInfo", 1, localThrowable, new Object[0]);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ApolloBaseInfo", 1, "parse json data error", localJSONException);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloBaseInfo
 * JD-Core Version:    0.7.0.1
 */