package com.tencent.av.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.util.PhoneContactFaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa02.cmd0xa02.TinyID2UserAccInfo;

@Deprecated
public class PstnUtils
{
  private static Bitmap a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByMobile(paramString);
    if (localObject1 != null) {
      localObject1 = ContactUtils.c(((PhoneContact)localObject1).name);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ContactUtils.c(paramString);
    }
    paramString = new PhoneContactFaceDrawable(paramQQAppInterface.getApp(), (String)localObject2);
    int i = paramString.getIntrinsicWidth();
    int j = paramString.getIntrinsicHeight();
    if (paramString.getOpacity() != -1) {
      paramQQAppInterface = Bitmap.Config.ARGB_8888;
    } else {
      paramQQAppInterface = Bitmap.Config.RGB_565;
    }
    paramQQAppInterface = Bitmap.createBitmap(i, j, paramQQAppInterface);
    localObject1 = new Canvas(paramQQAppInterface);
    paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
    paramString.draw((Canvas)localObject1);
    return paramQQAppInterface;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPstnInfoFromQCallRecent --> uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ,uinType = ");
      localStringBuilder.append(paramInt);
      QLog.d("PstnUtils", 2, localStringBuilder.toString());
    }
    if (paramQQAppInterface != null)
    {
      if (paramString == null) {
        return null;
      }
      paramQQAppInterface = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.c(paramString, paramInt);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.pstnInfo;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("getPstnInfoFromQCallRecent --> value = ");
            paramString.append(paramQQAppInterface);
            QLog.d("PstnUtils", 2, paramString.toString());
          }
          return paramQQAppInterface;
        }
      }
    }
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnUtils", 2, "hideCharacterInPhoneNumbe--> phoneNumber is null");
      }
      return null;
    }
    if (paramString.length() < paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PstnUtils", 2, "hideCharacterInPhoneNumbe--> phoneNumber less ncount");
      }
      return paramString;
    }
    if (paramString.length() < paramInt + 3) {
      return paramString;
    }
    String str = paramString.substring(paramString.length() - 2, paramString.length());
    paramString = paramString.substring(0, 3);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("***");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String a(ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.get(i);
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject1.put("a", localAVPhoneUserInfo.account);
        localJSONObject1.put("at", localAVPhoneUserInfo.accountType);
        localJSONObject2.put("m", localAVPhoneUserInfo.telInfo.mobile);
        localJSONObject2.put("n", localAVPhoneUserInfo.telInfo.nation);
        localJSONObject2.put("p", localAVPhoneUserInfo.telInfo.prefix);
        localJSONObject2.put("ns", localAVPhoneUserInfo.telInfo.nationState);
        localJSONObject1.put("ti", localJSONObject2);
        localJSONArray.put(localJSONObject1);
        i += 1;
      }
      paramArrayList = localJSONArray.toString();
      return paramArrayList;
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList<AVPhoneUserInfo> a(String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject1 = paramString.getJSONObject(i);
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("ti");
        AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
        localAVPhoneUserInfo.account = localJSONObject1.optLong("a", 0L);
        localAVPhoneUserInfo.accountType = localJSONObject1.optInt("at", -1);
        localAVPhoneUserInfo.telInfo.mobile = localJSONObject2.optString("m", "");
        localAVPhoneUserInfo.telInfo.nation = localJSONObject2.optString("n", "");
        localAVPhoneUserInfo.telInfo.prefix = localJSONObject2.optString("p", "");
        localAVPhoneUserInfo.telInfo.nationState = localJSONObject2.optInt("ns", 0);
        if (-1 != localAVPhoneUserInfo.accountType) {
          localArrayList.add(localAVPhoneUserInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList<AVPhoneUserInfo> a(List<cmd0xa02.TinyID2UserAccInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return localArrayList;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (cmd0xa02.TinyID2UserAccInfo)localIterator.next();
        AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
        localAVPhoneUserInfo.account = paramList.uint64_tinyid.get();
        localAVPhoneUserInfo.accountType = paramList.uint32_useracctype.get();
        paramList = paramList.str_useracc_identifier.get();
        if ((!TextUtils.isEmpty(paramList)) && (paramList.length() >= 5))
        {
          String str;
          if (paramList.contains("-"))
          {
            paramList = paramList.split("-");
            str = paramList[0];
            paramList = paramList[1];
          }
          else
          {
            str = paramList.substring(0, 4);
            paramList = paramList.substring(4, paramList.length());
          }
          localAVPhoneUserInfo.telInfo.nation = str;
          localAVPhoneUserInfo.telInfo.mobile = paramList;
          if (!TextUtils.isEmpty(localAVPhoneUserInfo.telInfo.nation)) {
            localAVPhoneUserInfo.telInfo.nationState = 1;
          }
          localArrayList.add(localAVPhoneUserInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<Bitmap> a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramQQAppInterface, paramString, paramInt1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" ==== getRealAVPhoneBitmap === pstnInfo : ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("PstnUtils", 2, ((StringBuilder)localObject2).toString());
    if (localObject1 != null)
    {
      if (((String)localObject1).length() == 0) {
        return null;
      }
      localObject2 = a((String)localObject1);
      if (localObject2 != null)
      {
        if (((ArrayList)localObject2).size() == 0) {
          return null;
        }
        localObject1 = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (localObject1 == null) {
          return null;
        }
        Map localMap = ((DiscussionManager)localObject1).b(paramString);
        IPhoneContactService localIPhoneContactService = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        ArrayList localArrayList = new ArrayList();
        paramInt2 = Math.min(paramInt2, ((ArrayList)localObject2).size());
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localObject1 = (AVPhoneUserInfo)((ArrayList)localObject2).get(paramInt1);
          String str = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
          if ((str != null) && (str.length() != 0))
          {
            paramString = localIPhoneContactService.queryPhoneContactByMobile(str);
            if (paramString != null) {
              paramString = paramString.uin;
            } else {
              paramString = null;
            }
            if ((paramString != null) && (paramString.length() != 0))
            {
              if ((localMap == null) || (!localMap.containsKey(paramString)))
              {
                paramString = new StringBuilder();
                paramString.append(((AVPhoneUserInfo)localObject1).telInfo.nation);
                paramString.append(str);
                localObject1 = paramQQAppInterface.getFaceBitmap(11, paramString.toString(), (byte)3, true, 0);
                paramString = (String)localObject1;
                if (localObject1 == null) {
                  paramString = a(paramQQAppInterface, str);
                }
                localArrayList.add(paramString);
              }
            }
            else {
              localArrayList.add(a(paramQQAppInterface, str));
            }
          }
          paramInt1 += 1;
        }
        return localArrayList;
      }
    }
    return null;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = c(paramQQAppInterface, paramString, paramInt);
    return (paramQQAppInterface != null) && (paramQQAppInterface.size() > 0);
  }
  
  public static List<AVPhoneUserInfo> c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = a(paramQQAppInterface, paramString, paramInt);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" ==== getRealAVPhoneUserInfo === pstnInfo : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("PstnUtils", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      if (((String)localObject1).length() == 0) {
        return null;
      }
      Object localObject3 = a((String)localObject1);
      if (localObject3 != null)
      {
        if (((ArrayList)localObject3).size() == 0) {
          return null;
        }
        localObject1 = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (localObject1 == null) {
          return null;
        }
        paramString = ((DiscussionManager)localObject1).b(paramString);
        localObject2 = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        localObject1 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)((Iterator)localObject3).next();
          paramQQAppInterface = localAVPhoneUserInfo.telInfo.mobile;
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length() != 0))
          {
            paramQQAppInterface = ((IPhoneContactService)localObject2).queryPhoneContactByMobile(paramQQAppInterface);
            if (paramQQAppInterface != null) {
              paramQQAppInterface = paramQQAppInterface.uin;
            } else {
              paramQQAppInterface = null;
            }
            if ((paramQQAppInterface != null) && (paramQQAppInterface.length() != 0))
            {
              if ((paramString == null) || (!paramString.containsKey(paramQQAppInterface))) {
                ((ArrayList)localObject1).add(localAVPhoneUserInfo);
              }
            }
            else {
              ((ArrayList)localObject1).add(localAVPhoneUserInfo);
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(" ==== getRealAVPhoneUserInfo === list : ");
          paramQQAppInterface.append(((ArrayList)localObject1).toString());
          QLog.i("PstnUtils", 2, paramQQAppInterface.toString());
        }
        return localObject1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PstnUtils
 * JD-Core Version:    0.7.0.1
 */