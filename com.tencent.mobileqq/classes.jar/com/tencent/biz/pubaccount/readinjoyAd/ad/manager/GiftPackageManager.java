package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GiftPackageManager
{
  public static final HashMap<String, List<Long>> a = new HashMap();
  
  public static Pair<List<GiftServiceBean>, List<GiftServiceBean>> a(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://ag.qq.com/community/ajax/getAmsAreaInfo?gameId=");
      ((StringBuilder)localObject1).append(paramString);
      paramString = ((StringBuilder)localObject1).toString();
      localObject1 = new Bundle();
      HttpUtil.addCookie((Bundle)localObject1);
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), paramString, "GET", null, (Bundle)localObject1);
        if (paramString != null)
        {
          localObject1 = new JSONObject(new String(paramString)).optJSONObject("data");
          if (((JSONObject)localObject1).has("system"))
          {
            Object localObject2 = ((JSONObject)localObject1).optJSONArray("system");
            int j = 0;
            paramString = "";
            i = 0;
            int k = ((JSONArray)localObject2).length();
            JSONObject localJSONObject;
            if (i < k)
            {
              localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
              if (!"android".equalsIgnoreCase(localJSONObject.optString("k"))) {
                break label454;
              }
              paramString = localJSONObject.optString("v");
              break label454;
            }
            boolean bool = ((JSONObject)localObject1).has("server");
            if (bool)
            {
              localObject2 = ((JSONObject)localObject1).optJSONArray("server");
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
                GiftServiceBean localGiftServiceBean = new GiftServiceBean();
                localGiftServiceBean.t = localJSONObject.optString("t");
                localGiftServiceBean.v = localJSONObject.optString("v");
                localGiftServiceBean.s = localJSONObject.optString("s");
                localGiftServiceBean.c = localJSONObject.optString("c");
                localGiftServiceBean.ck = localJSONObject.optString("ck");
                if (!paramString.equals(localGiftServiceBean.s)) {
                  break label461;
                }
                localArrayList1.add(localGiftServiceBean);
                break label461;
              }
            }
            if (((JSONObject)localObject1).has("channel"))
            {
              paramString = ((JSONObject)localObject1).optJSONArray("channel");
              i = j;
              if (i < paramString.length())
              {
                localObject1 = paramString.optJSONObject(i);
                localObject2 = new GiftServiceBean();
                ((GiftServiceBean)localObject2).t = ((JSONObject)localObject1).optString("t");
                ((GiftServiceBean)localObject2).v = ((JSONObject)localObject1).optString("v");
                ((GiftServiceBean)localObject2).sk = ((JSONObject)localObject1).optString("sk");
                ((GiftServiceBean)localObject2).ck = ((JSONObject)localObject1).optString("k");
                if (((GiftServiceBean)localObject2).ck.equals("qq")) {
                  localArrayList2.add(localObject2);
                }
                i += 1;
                continue;
              }
            }
          }
        }
        return new Pair(localArrayList2, localArrayList1);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      label454:
      i += 1;
      continue;
      label461:
      i += 1;
    }
  }
  
  public static Pair<Boolean, String> a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://iyouxi3.vip.qq.com/ams3.0.php?_c=page");
    localStringBuilder.append("&rAccountType=1");
    if (!TextUtils.isEmpty(paramString1))
    {
      localStringBuilder.append("&gameId=");
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder.append("&area=");
      localStringBuilder.append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localStringBuilder.append("&partition=");
      localStringBuilder.append(paramString3);
    }
    if (!TextUtils.isEmpty(paramString5))
    {
      localStringBuilder.append("&actid=");
      localStringBuilder.append(paramString5);
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      localStringBuilder.append("&roleid=");
      localStringBuilder.append(paramString4);
    }
    paramString1 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      paramString1 = "1";
    }
    localStringBuilder.append("&platid=");
    localStringBuilder.append(paramString1);
    paramString1 = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount();
    paramString1 = ((TicketManager)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(2)).getSkey(paramString1);
    paramString2 = "";
    if (paramString1 == null) {
      paramString1 = "";
    } else {
      paramString1 = b(paramString1);
    }
    localStringBuilder.append("&g_tk=");
    localStringBuilder.append(paramString1);
    paramString1 = new Bundle();
    HttpUtil.addCookie(paramString1);
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = bool5;
    try
    {
      paramString3 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), localStringBuilder.toString(), "GET", null, paramString1);
      paramString1 = paramString2;
      if (paramString3 != null)
      {
        bool2 = bool5;
        paramString3 = new JSONObject(new String(paramString3));
        boolean bool1 = bool4;
        bool2 = bool5;
        if (paramString3.has("ret"))
        {
          bool1 = bool4;
          bool2 = bool5;
          if (paramString3.optInt("ret") == 0) {
            bool1 = true;
          }
        }
        bool2 = bool1;
        paramString1 = paramString2;
        bool3 = bool1;
        if (paramString3.has("msg"))
        {
          bool2 = bool1;
          paramString1 = paramString3.optString("msg");
          bool3 = bool1;
        }
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      bool3 = bool2;
      paramString1 = paramString2;
    }
    return new Pair(Boolean.valueOf(bool3), paramString1);
  }
  
  public static List<GiftServiceBean> a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder("https://iyouxi3.vip.qq.com/ams3.0.php?_c=queryRoleInfoByGameId");
    if (!TextUtils.isEmpty(paramString1))
    {
      localStringBuilder.append("&gameId=");
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder.append("&area=");
      localStringBuilder.append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localStringBuilder.append("&partition=");
      localStringBuilder.append(paramString3);
    }
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = "1";
    }
    localStringBuilder.append("&platid=");
    localStringBuilder.append(paramString1);
    paramString1 = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount();
    paramString1 = ((TicketManager)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(2)).getSkey(paramString1);
    if (paramString1 == null) {
      paramString1 = "";
    } else {
      paramString1 = b(paramString1);
    }
    localStringBuilder.append("&g_tk=");
    localStringBuilder.append(paramString1);
    paramString1 = new Bundle();
    HttpUtil.addCookie(paramString1);
    try
    {
      paramString1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), localStringBuilder.toString(), "GET", null, paramString1);
      if (paramString1 != null)
      {
        paramString1 = new JSONObject(new String(paramString1)).optJSONArray("data");
        int i = 0;
        while (i < paramString1.length())
        {
          paramString2 = paramString1.optJSONObject(i);
          paramString3 = new GiftServiceBean();
          paramString3.t = paramString2.optString("nick");
          paramString3.ck = paramString2.optString("role_id");
          if ((!TextUtils.isEmpty(paramString3.ck)) && (TextUtils.isEmpty(paramString3.t))) {
            paramString3.t = HardCodeUtil.a(2131903244);
          }
          localArrayList.add(paramString3);
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, long paramLong, int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    GameAdComData localGameAdComData;
    if (paramAdvertisementInfo != null)
    {
      if (paramAdvertisementInfo.gameAdComData == null) {
        return localJSONObject1;
      }
      localGameAdComData = paramAdvertisementInfo.gameAdComData;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("com_id", paramLong);
        localJSONObject2.put("type", paramInt);
        if (!TextUtils.isEmpty(localGameAdComData.C)) {
          localJSONObject2.put("nfa_chainid", localGameAdComData.C);
        }
        localJSONObject2.put("appid", localGameAdComData.h);
        if (!paramAdvertisementInfo.isKolGame) {
          break label146;
        }
        paramAdvertisementInfo = "2";
        localJSONObject2.put("obj_type", paramAdvertisementInfo);
        localJSONObject1.put("game_gift_report", String.valueOf(localJSONObject2));
        return localJSONObject1;
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
      return localJSONObject1;
      label146:
      paramAdvertisementInfo = "1";
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    ThreadManager.executeOnNetWorkThread(new GiftPackageManager.1(paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramInt4));
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong == 0L) {
        return;
      }
      if (!a.containsKey(paramString)) {
        a.put(paramString, new ArrayList());
      }
      paramString = (List)a.get(paramString);
      if (!paramString.contains(Long.valueOf(paramLong))) {
        paramString.add(Long.valueOf(paramLong));
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLong != 0L)
    {
      Object localObject = paramAppInterface;
      if (paramAppInterface == null)
      {
        localObject = paramAppInterface;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
          localObject = paramAppInterface;
          if (localAppRuntime != null)
          {
            localObject = paramAppInterface;
            if ((localAppRuntime instanceof QQAppInterface)) {
              localObject = (QQAppInterface)localAppRuntime;
            }
          }
        }
      }
      if (localObject == null) {
        return false;
      }
      paramAppInterface = ((AppInterface)localObject).getAccount();
      if (TextUtils.isEmpty(paramAppInterface)) {
        return false;
      }
      bool1 = bool2;
      if (a.containsKey(paramAppInterface))
      {
        bool1 = bool2;
        if (((List)a.get(paramAppInterface)).contains(Long.valueOf(paramLong))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String b(String paramString)
  {
    long l = 5381L;
    int i = 0;
    while (i < paramString.length())
    {
      l += (l << 5) + paramString.charAt(i);
      i += 1;
    }
    return String.valueOf(l & 0x7FFFFFFF);
  }
  
  @NonNull
  public static JSONObject b(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("business", 2);
    localJSONObject.put("op_timestamp", System.currentTimeMillis());
    localJSONObject.put("net_type", String.valueOf(PublicAccountAdUtil.a()));
    localJSONObject.put("plat_id", 1);
    localJSONObject.put("imei", AdDeviceInfoUtil.a());
    if (!TextUtils.isEmpty(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount())) {
      localJSONObject.put("uin", Long.valueOf(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount()));
    }
    localJSONObject.put("oper_type", paramInt1);
    localJSONObject.put("game_pkg", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localJSONObject.put("app_id", paramString2);
    }
    localJSONObject.put("gc_version", "");
    localJSONObject.put("idfa", "");
    localJSONObject.put("guid", "");
    localJSONObject.put("channel_id", "");
    localJSONObject.put("adtag", "");
    if (paramInt2 > 0) {
      localJSONObject.put("oper_module", paramInt2);
    }
    if (paramInt3 > 0) {
      localJSONObject.put("oper_id", paramInt3);
    }
    if (paramInt4 > 0) {
      localJSONObject.put("page_id", paramInt4);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager
 * JD-Core Version:    0.7.0.1
 */