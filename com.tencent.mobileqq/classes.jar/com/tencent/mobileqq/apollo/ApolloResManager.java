package com.tencent.mobileqq.apollo;

import amme;
import amnx;
import amny;
import amnz;
import amod;
import amoe;
import amof;
import android.text.TextUtils;
import anex;
import bhot;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.data.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloResManager
  implements Manager
{
  private bhot a;
  
  public ApolloResManager(QQAppInterface paramQQAppInterface) {}
  
  @NotNull
  private bhot a(amme paramamme, String paramString, amof paramamof, QQAppInterface paramQQAppInterface)
  {
    return new amnx(this, paramString, paramQQAppInterface, paramamme, paramamof);
  }
  
  private ArrayList<Integer> a(ApolloDress paramApolloDress)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramApolloDress.jdField_a_of_type_JavaUtilHashMap != null) && (!paramApolloDress.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      paramApolloDress = paramApolloDress.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      JSONArray localJSONArray = new JSONArray();
      while (paramApolloDress.hasNext())
      {
        ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)paramApolloDress.next()).getValue();
        localJSONArray.put(String.valueOf(localDress.jdField_a_of_type_Int));
        if (!ApolloUtil.c(localDress.jdField_a_of_type_Int)) {
          localArrayList.add(Integer.valueOf(localDress.jdField_a_of_type_Int));
        }
      }
    }
    return localArrayList;
  }
  
  private AtomicInteger a(List<Integer> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    if ((paramBoolean1) || (paramList.size() > 0)) {
      localAtomicInteger.getAndIncrement();
    }
    if (paramBoolean2) {
      localAtomicInteger.getAndIncrement();
    }
    return localAtomicInteger;
  }
  
  private void a(QQAppInterface paramQQAppInterface, amme paramamme, String paramString, ApolloBaseInfo paramApolloBaseInfo, amof paramamof)
  {
    if (paramApolloBaseInfo == null)
    {
      QLog.d("cm_res", 1, "handleBaseInfoListener  apolloBaseInfo is null");
      paramamof.a(null, "apolloBaseInfo is null", -5005);
      return;
    }
    if ((paramApolloBaseInfo.apolloStatus == 0) || (paramApolloBaseInfo.apolloStatus == 2))
    {
      paramamof.a(null, "apolloStatus not open" + paramApolloBaseInfo.apolloStatus, -5006);
      return;
    }
    a(paramamme, paramApolloBaseInfo, paramString, paramamof, paramQQAppInterface, true);
  }
  
  private void a(ApolloBaseInfo paramApolloBaseInfo, ApolloDress paramApolloDress, String paramString, amof paramamof)
  {
    try
    {
      ApolloResManager.ApolloDressInfo localApolloDressInfo = new ApolloResManager.ApolloDressInfo();
      localApolloDressInfo.a(paramString);
      localApolloDressInfo.a(paramApolloBaseInfo.getApolloDress3D().jdField_a_of_type_JavaUtilHashMap);
      paramApolloDress = MD5Utils.toMD5(paramApolloDress.jdField_a_of_type_JavaLangString);
      localApolloDressInfo.a(new JSONObject(FileUtils.readFileToString(new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/" + paramApolloDress + File.separator + "face.json"))));
      localApolloDressInfo.b("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + paramApolloBaseInfo.getApolloDress3D().jdField_a_of_type_Int);
      paramamof.a(localApolloDressInfo, "success", 0);
      return;
    }
    catch (Throwable paramApolloBaseInfo)
    {
      QLog.e("cm_res", 1, "getApolloUserDressInfo error ,", paramApolloBaseInfo);
      paramamof.a(null, "exception", -5008);
    }
  }
  
  private void a(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, amme paramamme, String paramString, amof paramamof)
  {
    if (paramAtomicInteger1.get() == paramAtomicInteger2.get())
    {
      if (paramAtomicInteger3.get() == paramAtomicInteger1.get())
      {
        paramAtomicInteger1 = paramamme.b(paramString);
        a(paramAtomicInteger1, paramAtomicInteger1.getApolloDress3D(), paramString, paramamof);
      }
    }
    else {
      return;
    }
    paramamof.a(null, "download error", -5003);
  }
  
  private boolean a(amme paramamme, ApolloBaseInfo paramApolloBaseInfo, String paramString, amof paramamof, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    ApolloDress localApolloDress = paramApolloBaseInfo.getApolloDress3D();
    if (localApolloDress != null)
    {
      paramBoolean = a(localApolloDress);
      ArrayList localArrayList = a(localApolloDress);
      boolean bool = b(localApolloDress);
      if ((!paramBoolean) && (!bool) && (localArrayList.size() == 0)) {
        a(paramApolloBaseInfo, localApolloDress, paramString, paramamof);
      }
      for (;;)
      {
        return true;
        paramApolloBaseInfo = a(localArrayList, paramBoolean, bool);
        AtomicInteger localAtomicInteger1 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        if ((paramBoolean) || (localArrayList.size() > 0)) {
          anex.a(paramQQAppInterface, paramString, new amny(this, localAtomicInteger2, localAtomicInteger1, paramApolloBaseInfo, paramamme, paramString, paramamof), localApolloDress.jdField_a_of_type_Int, a(localArrayList), -1, -1, false);
        }
        if (bool) {
          anex.a(paramQQAppInterface, localApolloDress.jdField_a_of_type_JavaLangString, new amnz(this, localAtomicInteger2, localAtomicInteger1, paramApolloBaseInfo, paramamme, paramString, paramamof));
        }
      }
    }
    if ((paramBoolean) && (paramamof != null)) {
      paramamof.a(null, "dress3DData is null", -5007);
    }
    return false;
  }
  
  private boolean a(ApolloDress paramApolloDress)
  {
    return (paramApolloDress.jdField_a_of_type_Int > 0) && (!ApolloUtil.d(paramApolloDress.jdField_a_of_type_Int));
  }
  
  private int[] a(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int[] arrayOfInt = new int[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
        i += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  private boolean b(ApolloDress paramApolloDress)
  {
    return (!TextUtils.isEmpty(paramApolloDress.jdField_a_of_type_JavaLangString)) && (!ApolloUtil.d(paramApolloDress.jdField_a_of_type_JavaLangString));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, amoe paramamoe)
  {
    QLog.d("cm_res", 1, " getApolloRoleInfo roleId : " + paramInt);
    if (((paramQQAppInterface == null) || (paramInt < 0) || (paramamoe == null)) && (paramamoe != null)) {
      paramamoe.a(null, "parameter error", -5001);
    }
    ThreadManager.getSubThreadHandler().post(new ApolloResManager.6(this, paramInt, paramamoe, paramQQAppInterface));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, amof paramamof)
  {
    QLog.d("cm_res", 1, " getApolloUserDressInfo requestUin : " + paramString);
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramamof == null))
    {
      if (paramamof != null) {
        paramamof.a(null, "parameter error", -5001);
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloResManager.1(this, paramQQAppInterface, paramString, paramamof));
  }
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList, amod paramamod)
  {
    if (((paramQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.size() == 0) || (paramamod == null)) && (paramamod != null)) {
      paramamod.onGetApolloDressInfo(null, "parameter error", -5001);
    }
    ThreadManager.getSubThreadHandler().post(new ApolloResManager.5(this, paramArrayList, paramamod, paramQQAppInterface));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloResManager
 * JD-Core Version:    0.7.0.1
 */