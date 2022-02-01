package com.tencent.mobileqq.addfriend.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import friendlist.EAddFriendSourceID;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import mqq.manager.TicketManager;

public class AddFriendUtil
{
  public static String a = "https://cgi.connect.qq.com/qqconnectwebsite/v3/appinfo/getauth";
  
  public static int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      paramString = arrayOfByte;
    }
    if (paramString.length % 3 == 0) {
      return paramString.length / 3;
    }
    return paramString.length / 3 + 1;
  }
  
  public static String a(AppInterface paramAppInterface, int paramInt)
  {
    String str = "";
    Groups localGroups = ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getGroup(paramInt);
    paramAppInterface = str;
    if (localGroups != null) {
      paramAppInterface = localGroups.group_name;
    }
    return paramAppInterface;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return paramString;
    }
    paramAppInterface = ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
    if (paramAppInterface != null) {
      return paramAppInterface.getFriendNick();
    }
    return paramString;
  }
  
  public static String a(String paramString)
  {
    while (a(paramString) > 32)
    {
      int i = paramString.length();
      if (i >= 2)
      {
        int j = i - 2;
        if (Character.isHighSurrogate(paramString.charAt(j)))
        {
          paramString = paramString.substring(0, j);
          continue;
        }
      }
      paramString = paramString.substring(0, i - 1);
    }
    return paramString;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(a);
    String str = paramAppInterface.getAccount();
    Object localObject = (TicketManager)paramAppInterface.getManager(2);
    paramAppInterface = ((TicketManager)localObject).getSkey(str);
    localObject = ((TicketManager)localObject).getPskey(str, "connect.qq.com");
    localBundle.putString("Referer", "https://cgi.connect.qq.com/");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("p_skey=");
    localStringBuilder2.append((String)localObject);
    localStringBuilder2.append(";p_uin=");
    localStringBuilder2.append(str);
    localStringBuilder2.append(";skey=");
    localStringBuilder2.append(paramAppInterface);
    localStringBuilder2.append(";uin=");
    localStringBuilder2.append(str);
    localBundle.putString("Cookie", localStringBuilder2.toString());
    localStringBuilder1.append("?");
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("appid=");
    paramAppInterface.append(paramString);
    localStringBuilder1.append(paramAppInterface.toString());
    paramAppInterface = new HashMap();
    paramAppInterface.put("BUNDLE", localBundle);
    paramAppInterface.put("CONTEXT", paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("checkApiState params = ");
      paramContext.append(localBundle);
      QLog.i("AddFriendUtil", 2, paramContext.toString());
    }
    new HttpWebCgiAsyncTask2(localStringBuilder1.toString(), "GET", paramCallback, paramInt, paramBundle).a(paramAppInterface);
  }
  
  public static boolean a(int paramInt)
  {
    return (EAddFriendSourceID.a(paramInt)) || (paramInt == 3016) || (paramInt == 3003) || (paramInt == 3093);
  }
  
  public static boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 0) {
      return true;
    }
    return (paramInt1 == 100) && (!paramBoolean);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return (!EAddFriendSourceID.a(paramInt)) && (paramInt != 3016) && (paramInt != 3024) && (!TextUtils.isEmpty(paramString)) && (paramInt != 3093) && (!paramString.equals(String.valueOf(0L)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.utils.AddFriendUtil
 * JD-Core Version:    0.7.0.1
 */