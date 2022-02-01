package com.tencent.gamecenter.wadl.util;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class GameCenterUtil
{
  private static String a;
  public static HashSet<String> a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashSet.add("13169");
    jdField_a_of_type_JavaUtilHashSet.add("13032");
    jdField_a_of_type_JavaUtilHashSet.add("12820");
  }
  
  public static String a()
  {
    String str = "";
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    }
    EIPCResult localEIPCResult;
    do
    {
      do
      {
        do
        {
          return localObject;
          WadlQIPCConnector.a().a();
          localObject = new Bundle();
          localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.getUin", (Bundle)localObject);
          localObject = str;
        } while (localEIPCResult == null);
        localObject = str;
      } while (!localEIPCResult.isSuccess());
      localObject = str;
    } while (localEIPCResult.data == null);
    return localEIPCResult.data.getString("uin");
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static String b()
  {
    String str = "";
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      localObject = ((TicketManager)((AppRuntime)localObject).getManager(2)).getSkey(((AppRuntime)localObject).getAccount());
    }
    EIPCResult localEIPCResult;
    do
    {
      do
      {
        do
        {
          return localObject;
          WadlQIPCConnector.a().a();
          localObject = new Bundle();
          localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.getSkey", (Bundle)localObject);
          localObject = str;
        } while (localEIPCResult == null);
        localObject = str;
      } while (!localEIPCResult.isSuccess());
      localObject = str;
    } while (localEIPCResult.data == null);
    return localEIPCResult.data.getString("skey");
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      DisplayMetrics localDisplayMetrics = MobileQQ.sMobileQQ.getResources().getDisplayMetrics();
      jdField_a_of_type_JavaLangString = localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels;
    }
    return jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.GameCenterUtil
 * JD-Core Version:    0.7.0.1
 */