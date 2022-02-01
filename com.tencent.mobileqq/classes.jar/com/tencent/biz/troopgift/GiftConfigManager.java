package com.tencent.biz.troopgift;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GiftConfigManager
{
  protected static SharedPreferences a(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_gift_config_");
    localStringBuilder.append(paramString);
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static GiftConfigManager.ActivityTabInfo a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList();
        localObject = paramJSONObject.getString("title");
        paramJSONObject = paramJSONObject.getJSONArray("actionList");
        i = 0;
        if (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          GiftConfigManager.ImgEntryItem localImgEntryItem = new GiftConfigManager.ImgEntryItem();
          localImgEntryItem.a = localJSONObject.optString("img");
          localImgEntryItem.b = localJSONObject.optString("jumpUrl");
          if ((TextUtils.isEmpty(localImgEntryItem.a)) || (TextUtils.isEmpty(localImgEntryItem.b))) {
            break label220;
          }
          localArrayList.add(localImgEntryItem);
          break label220;
        }
        paramJSONObject = (JSONObject)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject = HardCodeUtil.a(2131903238);
        }
        localObject = paramJSONObject;
        if (paramJSONObject.length() > 4) {
          localObject = paramJSONObject.substring(0, 4);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localArrayList.size() > 0))
        {
          paramJSONObject = new GiftConfigManager.ActivityTabInfo();
          paramJSONObject.a = ((String)localObject);
          paramJSONObject.b = localArrayList;
          return paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseActivityTabInfo exp:");
          ((StringBuilder)localObject).append(paramJSONObject.toString());
          QLog.e("GiftConfigManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      return null;
      label220:
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    try
    {
      String str = paramQQAppInterface.getCurrentUin();
      int k = b(str);
      int j = paramConfig.version.get();
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("handleGiftEntryConfig, local=");
      paramQQAppInterface.append(k);
      paramQQAppInterface.append(" svr=");
      paramQQAppInterface.append(j);
      paramQQAppInterface.append("content_list_size=");
      int i;
      if (paramConfig.msg_content_list == null) {
        i = 0;
      } else {
        i = paramConfig.msg_content_list.size();
      }
      paramQQAppInterface.append(i);
      QLog.d("GiftConfigManager", 1, paramQQAppInterface.toString());
      if ((k != j) && (paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        i = 0;
        while (i < paramConfig.msg_content_list.size())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("content task_id :");
          paramQQAppInterface.append(i);
          paramQQAppInterface.append(", ");
          paramQQAppInterface.append(((ConfigurationService.Content)paramConfig.msg_content_list.get(i)).task_id.get());
          QLog.d("GiftConfigManager", 1, paramQQAppInterface.toString());
          i += 1;
        }
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
        if (paramQQAppInterface != null)
        {
          if (paramQQAppInterface.compress.get() == 1)
          {
            Object localObject = OlympicUtil.a(paramQQAppInterface.content.get().toByteArray());
            paramConfig = null;
            paramQQAppInterface = paramConfig;
            if (localObject != null) {
              try
              {
                paramQQAppInterface = new String((byte[])localObject, "UTF-8");
              }
              catch (Exception paramQQAppInterface)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("handleGiftEntryConfig|uncompress failed");
                ((StringBuilder)localObject).append(paramQQAppInterface);
                QLog.e("GiftConfigManager", 1, ((StringBuilder)localObject).toString());
                paramQQAppInterface = paramConfig;
              }
            }
          }
          else
          {
            paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
          }
          if (paramQQAppInterface != null)
          {
            if (QLog.isColorLevel())
            {
              paramConfig = new StringBuilder();
              paramConfig.append("handleGiftEntryConfig content");
              paramConfig.append(paramQQAppInterface);
              QLog.i("GiftConfigManager", 2, paramConfig.toString());
            }
            try
            {
              paramConfig = new JSONObject(paramQQAppInterface);
              paramQQAppInterface = paramConfig.optJSONObject("activityInfo");
              if (paramQQAppInterface == null) {
                paramQQAppInterface = "";
              } else {
                paramQQAppInterface = paramQQAppInterface.toString();
              }
              a(str, "activityTabInfo", paramQQAppInterface);
              paramQQAppInterface = paramConfig.optJSONObject("profileCard");
              if (paramQQAppInterface != null)
              {
                paramQQAppInterface = paramQQAppInterface.optJSONObject("giftItem");
                if (paramQQAppInterface == null) {
                  paramQQAppInterface = "";
                } else {
                  paramQQAppInterface = paramQQAppInterface.toString();
                }
                a(str, "profileCardItem", paramQQAppInterface);
              }
              else
              {
                a(str, "profileCardItem", "");
              }
              paramQQAppInterface = paramConfig.optJSONObject("panelEntry");
              if (paramQQAppInterface != null) {
                a(str, "panelEntry", paramQQAppInterface.toString());
              } else {
                a(str, "panelEntry", "");
              }
              a(str, j);
              return;
            }
            catch (Exception paramQQAppInterface)
            {
              paramConfig = new StringBuilder();
              paramConfig.append("handleGiftEntryConfig failed");
              paramConfig.append(paramQQAppInterface);
              QLog.e("GiftConfigManager", 1, paramConfig.toString());
              return;
            }
          }
          QLog.e("GiftConfigManager", 1, "handleGiftEntryConfig config_content==null");
          return;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("GiftConfigManager", 1, "handleGiftEntryConfig exp:", paramQQAppInterface);
    }
  }
  
  protected static void a(String paramString, int paramInt)
  {
    a(paramString).edit().putInt("configVersion", paramInt).commit();
  }
  
  protected static void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1).edit().putString(paramString2, paramString3).commit();
  }
  
  public static int b(String paramString)
  {
    return a(paramString).getInt("configVersion", 0);
  }
  
  public static GiftConfigManager.TextEntryItem b(JSONObject paramJSONObject)
  {
    try
    {
      localObject = paramJSONObject.getString("title");
      paramJSONObject = paramJSONObject.getString("jumpUrl");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramJSONObject)))
      {
        GiftConfigManager.TextEntryItem localTextEntryItem = new GiftConfigManager.TextEntryItem();
        localTextEntryItem.a = ((String)localObject);
        localTextEntryItem.b = paramJSONObject;
        return localTextEntryItem;
      }
    }
    catch (Exception paramJSONObject)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseProfileCardGiftItem exp:");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        QLog.e("GiftConfigManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static GiftConfigManager.ImgEntryItem c(JSONObject paramJSONObject)
  {
    try
    {
      localObject = paramJSONObject.getString("icon");
      String str = paramJSONObject.getString("jumpUrl");
      int i = paramJSONObject.getInt("width");
      int j = paramJSONObject.getInt("height");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)) && (i > 0) && (j > 0))
      {
        paramJSONObject = new GiftConfigManager.ImgEntryItem();
        paramJSONObject.a = ((String)localObject);
        paramJSONObject.b = str;
        paramJSONObject.c = i;
        paramJSONObject.d = j;
        return paramJSONObject;
      }
    }
    catch (Exception paramJSONObject)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parsePanelEntryItem exp:");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        QLog.e("GiftConfigManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.GiftConfigManager
 * JD-Core Version:    0.7.0.1
 */