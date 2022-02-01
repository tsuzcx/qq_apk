package com.tencent.av.wtogether.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.JniSimpleInfoMng;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.data.WTReqUrlResult;
import com.tencent.av.wtogether.data.WTVideoInfo;
import com.tencent.av.wtogether.data.WTogetherRoom;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.DownloadRespInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class WTogetherUtil
{
  public static final HashMap<Long, Integer> a = new HashMap();
  
  static
  {
    a.put(Long.valueOf(204L), Integer.valueOf(203));
    a.put(Long.valueOf(1L), Integer.valueOf(1));
    a.put(Long.valueOf(3L), Integer.valueOf(3));
    a.put(Long.valueOf(101L), Integer.valueOf(101));
    a.put(Long.valueOf(102L), Integer.valueOf(102));
    a.put(Long.valueOf(103L), Integer.valueOf(103));
    a.put(Long.valueOf(201L), Integer.valueOf(201));
    a.put(Long.valueOf(202L), Integer.valueOf(202));
    a.put(Long.valueOf(203L), Integer.valueOf(203));
    a.put(Long.valueOf(204L), Integer.valueOf(204));
    a.put(Long.valueOf(107L), Integer.valueOf(107));
  }
  
  public static int a()
  {
    return (int)(ImmersiveUtils.getScreenWidth() * 9.0F / 16.0F);
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight(paramContext);
    }
    return i;
  }
  
  public static SuperPlayerVideoInfo a(WTVideoInfo paramWTVideoInfo)
  {
    if (paramWTVideoInfo == null)
    {
      localObject = null;
      return localObject;
    }
    int i = paramWTVideoInfo.jdField_a_of_type_Int;
    Object localObject = paramWTVideoInfo.jdField_b_of_type_JavaLangString;
    String str1 = a();
    String str2 = paramWTVideoInfo.d;
    int j = paramWTVideoInfo.a();
    String str3 = paramWTVideoInfo.g;
    label68:
    int k;
    if (paramWTVideoInfo.jdField_a_of_type_Long == 0L)
    {
      paramWTVideoInfo = (Integer)a.get(Long.valueOf(204L));
      k = paramWTVideoInfo.intValue();
      if (i != 0) {
        break label130;
      }
      paramWTVideoInfo = SuperPlayerFactory.createVideoInfoForUrl((String)localObject, 101, MD5Utils.toMD5((String)localObject));
    }
    for (;;)
    {
      localObject = paramWTVideoInfo;
      if (paramWTVideoInfo == null) {
        break;
      }
      paramWTVideoInfo.setIsDisableTVideoCache(true);
      paramWTVideoInfo.setTVideoLoginCookie(str1);
      return paramWTVideoInfo;
      paramWTVideoInfo = (Integer)a.get(Long.valueOf(paramWTVideoInfo.jdField_a_of_type_Long));
      break label68;
      label130:
      if (i == 3) {
        paramWTVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(j, str2);
      } else if ((i == 2) || (i == 1)) {
        paramWTVideoInfo = SuperPlayerFactory.createVideoInfoForUrl((String)localObject, k, MD5Utils.toMD5((String)localObject));
      } else if (i == 4) {
        paramWTVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(j, str2, str3);
      } else {
        paramWTVideoInfo = null;
      }
    }
  }
  
  public static String a()
  {
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localObject = ((TicketManager)((AppInterface)localObject).getManager(2)).getSkey(str);
    str = "uin=" + SwiftBrowserCookieMonster.a(str) + "; skey=" + (String)localObject;
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether", 4, "getPlayerCookie, cookie[" + str + "]");
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = VideoController.a();
    if (localObject1 != null) {}
    for (localObject1 = ((VideoController)localObject1).a();; localObject1 = null)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((JniSimpleInfoMng)localObject1).a(AVUtil.a(paramString), false, true) == 1) {
          localObject2 = BaseApplicationImpl.getApplication().getResources().getString(2131695947);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether", 4, "getWatchTogetherInviteTip, peer[" + paramString + "], tip[" + (String)localObject2 + "]");
      }
      return localObject2;
    }
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte, String paramString, WTReqUrlResult paramWTReqUrlResult)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    DownloadRespInfo localDownloadRespInfo = new DownloadRespInfo();
    long l;
    boolean bool;
    if ((paramInt == 1002) || (paramInt == 1013))
    {
      l = -100001L;
      bool = false;
    }
    label64:
    int i;
    label85:
    Object localObject;
    for (;;)
    {
      if ((l == 0L) && (localDownloadRespInfo.jdField_c_of_type_JavaLangString == null) && (localDownloadRespInfo.jdField_b_of_type_JavaLangString == null))
      {
        paramInt = 1;
        if ((l != -91245L) && (l != -7010L)) {
          break label326;
        }
        i = 1;
        if (((paramInt == 0) && (i == 0)) || (paramWTReqUrlResult.jdField_c_of_type_Int >= 3) || (paramWTReqUrlResult.jdField_c_of_type_Int < 0)) {
          break label332;
        }
        paramWTReqUrlResult.jdField_b_of_type_Boolean = true;
        return;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          paramWTReqUrlResult.jdField_c_of_type_Boolean = false;
          l = -100003L;
          bool = false;
        }
        else
        {
          localObject = new cmd0x346.RspBody();
          try
          {
            ((cmd0x346.RspBody)localObject).mergeFrom(paramArrayOfByte);
            if (((cmd0x346.RspBody)localObject).msg_apply_download_rsp.has()) {
              break label217;
            }
            paramWTReqUrlResult.jdField_c_of_type_Boolean = false;
            l = -100003L;
            bool = false;
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            paramWTReqUrlResult.jdField_c_of_type_Boolean = false;
            l = -100003L;
            bool = false;
          }
          catch (Throwable paramArrayOfByte)
          {
            paramWTReqUrlResult.jdField_c_of_type_Boolean = false;
            l = -100003L;
            bool = false;
          }
          continue;
          label217:
          if (!((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.has()) {
            break label607;
          }
          if (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.get() == 1) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      DownloadRespInfo.a(localDownloadRespInfo, (cmd0x346.ApplyDownloadRsp)((cmd0x346.RspBody)localObject).msg_apply_download_rsp.get(), bool, paramString);
      l = localDownloadRespInfo.jdField_a_of_type_Long;
      paramWTReqUrlResult.jdField_c_of_type_Boolean = true;
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether", 4, "decodeApplyDownloadRsp, retCode[" + l + "]");
      }
      break;
      bool = false;
      continue;
      paramInt = 0;
      break label64;
      label326:
      i = 0;
      break label85;
      label332:
      localObject = localDownloadRespInfo.d;
      String str = localDownloadRespInfo.jdField_b_of_type_JavaLangString;
      paramInt = localDownloadRespInfo.jdField_a_of_type_Short;
      paramInt = localDownloadRespInfo.jdField_b_of_type_Short;
      paramString = localDownloadRespInfo.jdField_c_of_type_JavaLangString;
      paramArrayOfByte = paramString;
      if (bool) {
        paramArrayOfByte = paramString + "&isthumb=0";
      }
      if (l == -100001L)
      {
        paramWTReqUrlResult.d = -100001;
        paramWTReqUrlResult.jdField_c_of_type_Boolean = false;
      }
      while ((str == null) || (str.length() == 0))
      {
        paramWTReqUrlResult.d = -100004;
        if (l == 0L) {
          paramWTReqUrlResult.d = -100005;
        }
        paramWTReqUrlResult.jdField_c_of_type_JavaLangString = localResources.getString(2131691044);
        paramWTReqUrlResult.jdField_c_of_type_Boolean = false;
        return;
        if ((l == -25081L) || (l == -6101L) || (l == -7003L))
        {
          paramWTReqUrlResult.jdField_c_of_type_Boolean = false;
          paramWTReqUrlResult.d = ((int)l);
          paramWTReqUrlResult.jdField_c_of_type_JavaLangString = localResources.getString(2131692793);
          return;
        }
        if (!paramWTReqUrlResult.jdField_c_of_type_Boolean)
        {
          paramWTReqUrlResult.d = -100003;
          paramWTReqUrlResult.jdField_c_of_type_JavaLangString = localResources.getString(2131691044);
          return;
        }
      }
      paramWTReqUrlResult.a = ("https://" + str + ":" + paramInt + paramArrayOfByte);
      paramWTReqUrlResult.jdField_b_of_type_JavaLangString = ((String)localObject);
      paramWTReqUrlResult.d = ((int)l);
      paramWTReqUrlResult.jdField_c_of_type_JavaLangString = null;
      paramWTReqUrlResult.jdField_c_of_type_Boolean = true;
      return;
      label607:
      bool = false;
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramActivity == null)) {
      return;
    }
    paramActivity = DialogUtil.a(paramActivity, 230).setTitle(null).setMessage(paramString).setNegativeButton(2131695980, new WTogetherUtil.1());
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, "", paramString3, paramString2, 25054, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString4)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WTogether", 2, "safetyReport param null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogether", 2, String.format("safetyReport [%s, %s, %s, %s, %s]", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt), paramString5 }));
    }
    ThreadManager.excute(new WTogetherUtil.2(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt), 16, null, false);
  }
  
  public static void a(Context paramContext)
  {
    if (!(paramContext instanceof AVActivity)) {}
    do
    {
      return;
      paramContext = ((AVActivity)paramContext).a;
    } while (paramContext == null);
    paramContext.b();
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.leftMargin = paramInt1;
    paramView.rightMargin = paramInt2;
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (paramVideoAppInterface != null) {}
    for (paramVideoAppInterface = (WTogetherMng)paramVideoAppInterface.a(15);; paramVideoAppInterface = null)
    {
      if (paramVideoAppInterface == null)
      {
        paramVideoAppInterface = null;
        if (paramVideoAppInterface != null) {
          break label55;
        }
      }
      label55:
      for (paramVideoAppInterface = null;; paramVideoAppInterface = paramVideoAppInterface.a)
      {
        if ((paramVideoAppInterface == null) || (paramVideoAppInterface.a() == 0)) {
          break label63;
        }
        return true;
        paramVideoAppInterface = paramVideoAppInterface.b(localSessionInfo);
        break;
      }
      label63:
      return false;
    }
  }
  
  public static boolean a(String paramString)
  {
    int i = 0;
    VideoController localVideoController = VideoController.a();
    int j;
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (localVideoController != null))
    {
      i = localVideoController.c(paramString);
      j = localVideoController.b(paramString);
      if ((i >= 126) && ((j == 4) || (j == 2) || (j == 3))) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether", 2, "isPeerSupportWT, uin[" + paramString + "], sdk[" + i + "], terminal[" + j + "], support[" + bool + "]");
      }
      return bool;
      bool = false;
      continue;
      j = 0;
      bool = false;
    }
  }
  
  public static boolean b()
  {
    if (QLog.isDevelopLevel())
    {
      boolean bool1 = AppNetConnInfo.isNetSupport();
      boolean bool2 = AppNetConnInfo.isWifiConn();
      QLog.i("WTogether", 4, "isNoneWifiConn, isNetSupport[" + bool1 + "], isWifiConn[" + bool2 + "]");
    }
    return (AppNetConnInfo.isNetSupport()) && (!AppNetConnInfo.isWifiConn());
  }
  
  public static boolean b(String paramString)
  {
    int i = 0;
    VideoController localVideoController = VideoController.a();
    int j;
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (localVideoController != null))
    {
      i = localVideoController.c(paramString);
      j = localVideoController.b(paramString);
      if ((i >= 128) && ((j == 4) || (j == 2) || (j == 3))) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether", 2, "isPeerSupportPaidRes, uin[" + paramString + "], sdk[" + i + "], terminal[" + j + "], support[" + bool + "]");
      }
      return bool;
      bool = false;
      continue;
      j = 0;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTogetherUtil
 * JD-Core Version:    0.7.0.1
 */