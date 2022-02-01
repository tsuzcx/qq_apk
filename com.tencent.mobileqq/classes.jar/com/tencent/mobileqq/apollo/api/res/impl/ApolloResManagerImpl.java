package com.tencent.mobileqq.apollo.api.res.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl.OnQueryBaseInfoListener;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.model.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager;
import com.tencent.mobileqq.apollo.api.res.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
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
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloResManagerImpl
  implements IApolloResManager
{
  public static final String ERRMSG_APOLLO_BASE_INFO_IS_NULL = "apolloBaseInfo is null";
  public static final String ERRMSG_APOLLO_STATUS_NOT_OPEN = "apolloStatus not open";
  public static final String ERRMSG_DOWNLOAD_ERROR = "download error";
  public static final String ERRMSG_DRESS_3D_DATA_IS_NULL = "dress3DData is null";
  public static final String ERRMSG_DRESS_ID_ILLEGAL = "dressId illegal ";
  public static final String ERRMSG_EXCEPTION = "exception";
  public static final String ERRMSG_PARAMETER_ERROR = "parameter error";
  public static final String ERRMSG_SUCCESS = "success";
  public static final String ERRMSG_VAS_EXTENSION_HANDLER_IS_NULL = "VasExtensionHandler is null";
  public static final int ERROR_CODE_APOLLO_BASE_INFO_IS_NULL = -5005;
  public static final int ERROR_CODE_APOLLO_STATUS_NOT_OPEN = -5006;
  public static final int ERROR_CODE_DOWNLOAD_ERROR = -5003;
  public static final int ERROR_CODE_DRESS_3D_DATA_IS_NULL = -5007;
  public static final int ERROR_CODE_DRESS_ID_ILLEGAL = -5002;
  public static final int ERROR_CODE_EXCEPTION = -5008;
  public static final int ERROR_CODE_PARAMETER_ERROR = -5001;
  public static final int ERROR_CODE_SUCCESS = 0;
  public static final int ERROR_CODE_VAS_EXTENSION_HANDLER_IS_NULL = -5004;
  public static final String TAG = "cm_res";
  private ApolloExtensionHandlerImpl.OnQueryBaseInfoListener mBaseInfoListener;
  
  private AtomicInteger getDownloadCount(List<Integer> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
  
  private int[] getDressArray(List<Integer> paramList)
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
  
  @NotNull
  private ApolloExtensionHandlerImpl.OnQueryBaseInfoListener getOnQueryBaseInfoListener(IApolloManagerService paramIApolloManagerService, String paramString, ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener, QQAppInterface paramQQAppInterface)
  {
    return new ApolloResManagerImpl.2(this, paramString, paramQQAppInterface, paramIApolloManagerService, paramApolloUserDressInfoListener);
  }
  
  private void handleBaseInfoListener(QQAppInterface paramQQAppInterface, IApolloManagerService paramIApolloManagerService, String paramString, ApolloBaseInfo paramApolloBaseInfo, ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    if (paramApolloBaseInfo == null)
    {
      QLog.d("cm_res", 1, "handleBaseInfoListener  apolloBaseInfo is null");
      paramApolloUserDressInfoListener.a(null, "apolloBaseInfo is null", -5005);
      return;
    }
    if ((paramApolloBaseInfo.apolloStatus == 0) || (paramApolloBaseInfo.apolloStatus == 2))
    {
      paramApolloUserDressInfoListener.a(null, "apolloStatus not open" + paramApolloBaseInfo.apolloStatus, -5006);
      return;
    }
    handlePraseApolloBaseInfo(paramIApolloManagerService, paramApolloBaseInfo, paramString, paramApolloUserDressInfoListener, paramQQAppInterface, true);
  }
  
  private void handleCallbackGetUserDressInfo(ApolloBaseInfo paramApolloBaseInfo, ApolloDress paramApolloDress, String paramString, ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    try
    {
      ApolloResManagerImpl.ApolloDressInfo localApolloDressInfo = new ApolloResManagerImpl.ApolloDressInfo();
      localApolloDressInfo.a(paramString);
      localApolloDressInfo.a(paramApolloBaseInfo.getApolloDress3D().dressMap);
      paramApolloDress = MD5Utils.toMD5(paramApolloDress.faceData);
      localApolloDressInfo.a(new JSONObject(FileUtils.b(new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/" + paramApolloDress + File.separator + "face.json"))));
      localApolloDressInfo.b("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + paramApolloBaseInfo.getApolloDress3D().roleId);
      paramApolloUserDressInfoListener.a(localApolloDressInfo, "success", 0);
      return;
    }
    catch (Throwable paramApolloBaseInfo)
    {
      QLog.e("cm_res", 1, "getApolloUserDressInfo error ,", paramApolloBaseInfo);
      paramApolloUserDressInfoListener.a(null, "exception", -5008);
    }
  }
  
  private boolean handlePraseApolloBaseInfo(IApolloManagerService paramIApolloManagerService, ApolloBaseInfo paramApolloBaseInfo, String paramString, ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    ApolloDress localApolloDress = paramApolloBaseInfo.getApolloDress3D();
    if (localApolloDress != null)
    {
      paramBoolean = needDownloadRoleRes(localApolloDress);
      ArrayList localArrayList = needDownloadDressList(localApolloDress);
      boolean bool = needDownloadFaceRes(localApolloDress);
      if ((!paramBoolean) && (!bool) && (localArrayList.size() == 0)) {
        handleCallbackGetUserDressInfo(paramApolloBaseInfo, localApolloDress, paramString, paramApolloUserDressInfoListener);
      }
      for (;;)
      {
        return true;
        paramApolloBaseInfo = getDownloadCount(localArrayList, paramBoolean, bool);
        AtomicInteger localAtomicInteger1 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        if ((paramBoolean) || (localArrayList.size() > 0)) {
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(paramQQAppInterface, paramString, new ApolloResManagerImpl.3(this, localAtomicInteger2, localAtomicInteger1, paramApolloBaseInfo, paramIApolloManagerService, paramString, paramApolloUserDressInfoListener), localApolloDress.roleId, getDressArray(localArrayList), -1, -1, false);
        }
        if (bool) {
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(paramQQAppInterface, localApolloDress.faceData, new ApolloResManagerImpl.4(this, localAtomicInteger2, localAtomicInteger1, paramApolloBaseInfo, paramIApolloManagerService, paramString, paramApolloUserDressInfoListener));
        }
      }
    }
    if ((paramBoolean) && (paramApolloUserDressInfoListener != null)) {
      paramApolloUserDressInfoListener.a(null, "dress3DData is null", -5007);
    }
    return false;
  }
  
  private void handleShouldCallBack(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, IApolloManagerService paramIApolloManagerService, String paramString, ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    if (paramAtomicInteger1.get() == paramAtomicInteger2.get())
    {
      if (paramAtomicInteger3.get() == paramAtomicInteger1.get())
      {
        paramAtomicInteger1 = paramIApolloManagerService.getApolloBaseInfo(paramString);
        handleCallbackGetUserDressInfo(paramAtomicInteger1, paramAtomicInteger1.getApolloDress3D(), paramString, paramApolloUserDressInfoListener);
      }
    }
    else {
      return;
    }
    paramApolloUserDressInfoListener.a(null, "download error", -5003);
  }
  
  private ArrayList<Integer> needDownloadDressList(ApolloDress paramApolloDress)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramApolloDress.dressMap != null) && (!paramApolloDress.dressMap.isEmpty()))
    {
      paramApolloDress = paramApolloDress.dressMap.entrySet().iterator();
      JSONArray localJSONArray = new JSONArray();
      while (paramApolloDress.hasNext())
      {
        ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)paramApolloDress.next()).getValue();
        localJSONArray.put(String.valueOf(localDress.id));
        if (!ApolloUtilImpl.checkDressRes(localDress.id)) {
          localArrayList.add(Integer.valueOf(localDress.id));
        }
      }
    }
    return localArrayList;
  }
  
  private boolean needDownloadFaceRes(ApolloDress paramApolloDress)
  {
    return (!TextUtils.isEmpty(paramApolloDress.faceData)) && (!ApolloUtilImpl.check3DFaceRes(paramApolloDress.faceData));
  }
  
  private boolean needDownloadRoleRes(ApolloDress paramApolloDress)
  {
    return (paramApolloDress.roleId > 0) && (!ApolloUtilImpl.checkRoleRes(paramApolloDress.roleId));
  }
  
  public void getApolloDressInfo(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList, IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener)
  {
    if (((paramQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.size() == 0) || (paramApolloDressInfoListener == null)) && (paramApolloDressInfoListener != null)) {
      paramApolloDressInfoListener.a(null, "parameter error", -5001);
    }
    ThreadManager.getSubThreadHandler().post(new ApolloResManagerImpl.5(this, paramArrayList, paramApolloDressInfoListener, paramQQAppInterface));
  }
  
  public void getApolloRoleInfo(QQAppInterface paramQQAppInterface, int paramInt, ApolloResManagerImpl.ApolloRoleInfoListener paramApolloRoleInfoListener)
  {
    QLog.d("cm_res", 1, " getApolloRoleInfo roleId : " + paramInt);
    if (((paramQQAppInterface == null) || (paramInt < 0) || (paramApolloRoleInfoListener == null)) && (paramApolloRoleInfoListener != null)) {
      paramApolloRoleInfoListener.a(null, "parameter error", -5001);
    }
    ThreadManager.getSubThreadHandler().post(new ApolloResManagerImpl.6(this, paramInt, paramApolloRoleInfoListener, paramQQAppInterface));
  }
  
  public void getApolloUserDressInfo(QQAppInterface paramQQAppInterface, String paramString, ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    QLog.d("cm_res", 1, " getApolloUserDressInfo requestUin : " + paramString);
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramApolloUserDressInfoListener == null))
    {
      if (paramApolloUserDressInfoListener != null) {
        paramApolloUserDressInfoListener.a(null, "parameter error", -5001);
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloResManagerImpl.1(this, paramQQAppInterface, paramString, paramApolloUserDressInfoListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl
 * JD-Core Version:    0.7.0.1
 */