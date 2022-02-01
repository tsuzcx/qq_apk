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
    HashMap localHashMap = a;
    Long localLong = Long.valueOf(204L);
    Integer localInteger = Integer.valueOf(203);
    localHashMap.put(localLong, localInteger);
    a.put(Long.valueOf(1L), Integer.valueOf(1));
    a.put(Long.valueOf(3L), Integer.valueOf(3));
    a.put(Long.valueOf(101L), Integer.valueOf(101));
    a.put(Long.valueOf(102L), Integer.valueOf(102));
    a.put(Long.valueOf(103L), Integer.valueOf(103));
    a.put(Long.valueOf(201L), Integer.valueOf(201));
    a.put(Long.valueOf(202L), Integer.valueOf(202));
    a.put(Long.valueOf(203L), localInteger);
    a.put(localLong, Integer.valueOf(204));
    a.put(Long.valueOf(107L), Integer.valueOf(107));
  }
  
  public static int a(Context paramContext)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      return ImmersiveUtils.getStatusBarHeight(paramContext);
    }
    return 0;
  }
  
  public static SuperPlayerVideoInfo a(WTVideoInfo paramWTVideoInfo)
  {
    Object localObject = null;
    if (paramWTVideoInfo == null) {
      return null;
    }
    int i = paramWTVideoInfo.a;
    String str4 = paramWTVideoInfo.c;
    String str1 = d();
    String str2 = paramWTVideoInfo.e;
    int j = paramWTVideoInfo.d();
    String str3 = paramWTVideoInfo.i;
    if (paramWTVideoInfo.j == 0L) {
      paramWTVideoInfo = a.get(Long.valueOf(204L));
    } else {
      paramWTVideoInfo = a.get(Long.valueOf(paramWTVideoInfo.j));
    }
    int k = ((Integer)paramWTVideoInfo).intValue();
    if (i == 0)
    {
      paramWTVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(str4, 101, MD5Utils.toMD5(str4));
    }
    else if (i == 3)
    {
      paramWTVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(j, str2);
    }
    else if ((i != 2) && (i != 1))
    {
      paramWTVideoInfo = localObject;
      if (i == 4) {
        paramWTVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(j, str2, str3);
      }
    }
    else
    {
      paramWTVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(str4, k, MD5Utils.toMD5(str4));
    }
    if (paramWTVideoInfo != null)
    {
      paramWTVideoInfo.setIsDisableTVideoCache(true);
      paramWTVideoInfo.setTVideoLoginCookie(str1);
    }
    return paramWTVideoInfo;
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = VideoController.f();
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = ((VideoController)localObject1).aG();
    } else {
      localObject2 = null;
    }
    localObject1 = localObject3;
    if (localObject2 != null)
    {
      localObject1 = localObject3;
      if (((JniSimpleInfoMng)localObject2).a(AVUtil.c(paramString), false, true) == 1) {
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131893724);
      }
    }
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getWatchTogetherInviteTip, peer[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], tip[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.i("WTogether", 4, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte, String paramString, WTReqUrlResult paramWTReqUrlResult)
  {
    Resources localResources = BaseApplication.getContext().getResources();
    DownloadRespInfo localDownloadRespInfo = new DownloadRespInfo();
    long l1 = -100003L;
    if ((paramInt != 1002) && (paramInt != 1013)) {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
        localObject = new cmd0x346.RspBody();
      }
    }
    try
    {
      ((cmd0x346.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (!((cmd0x346.RspBody)localObject).msg_apply_download_rsp.has())
      {
        paramWTReqUrlResult.l = false;
        break label242;
      }
      boolean bool1;
      if ((((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.has()) && (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.get() == 1)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      DownloadRespInfo.a(localDownloadRespInfo, (cmd0x346.ApplyDownloadRsp)((cmd0x346.RspBody)localObject).msg_apply_download_rsp.get(), bool1, paramString);
      long l2 = localDownloadRespInfo.a;
      paramWTReqUrlResult.l = true;
      l1 = l2;
      bool2 = bool1;
      if (!QLog.isDevelopLevel()) {
        break label245;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("decodeApplyDownloadRsp, retCode[");
      paramArrayOfByte.append(l2);
      paramArrayOfByte.append("]");
      QLog.i("WTogether", 4, paramArrayOfByte.toString());
      l1 = l2;
      bool2 = bool1;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      boolean bool2;
      int i;
      String str;
      break label221;
    }
    catch (Throwable paramArrayOfByte)
    {
      label213:
      break label213;
    }
    paramWTReqUrlResult.l = false;
    break label242;
    label221:
    paramWTReqUrlResult.l = false;
    break label242;
    paramWTReqUrlResult.l = false;
    break label242;
    l1 = -100001L;
    label242:
    bool2 = false;
    label245:
    if ((l1 == 0L) && (localDownloadRespInfo.f == null) && (localDownloadRespInfo.d == null)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((l1 != -91245L) && (l1 != -7010L)) {
      i = 0;
    } else {
      i = 1;
    }
    if (((paramInt != 0) || (i != 0)) && (paramWTReqUrlResult.f < 3) && (paramWTReqUrlResult.f >= 0))
    {
      paramWTReqUrlResult.g = true;
      return;
    }
    Object localObject = localDownloadRespInfo.g;
    str = localDownloadRespInfo.d;
    paramInt = localDownloadRespInfo.e;
    paramInt = localDownloadRespInfo.n;
    paramString = localDownloadRespInfo.f;
    paramArrayOfByte = paramString;
    if (bool2)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append("&isthumb=0");
      paramArrayOfByte = paramArrayOfByte.toString();
    }
    if (l1 == -100001L)
    {
      paramWTReqUrlResult.j = -100001;
      paramWTReqUrlResult.l = false;
    }
    else
    {
      if ((l1 == -25081L) || (l1 == -6101L) || (l1 == -7003L)) {
        break label612;
      }
      if (!paramWTReqUrlResult.l)
      {
        paramWTReqUrlResult.j = -100003;
        paramWTReqUrlResult.k = localResources.getString(2131887903);
        return;
      }
    }
    if ((str != null) && (str.length() != 0))
    {
      paramString = new StringBuilder();
      paramString.append("https://");
      paramString.append(str);
      paramString.append(":");
      paramString.append(paramInt);
      paramString.append(paramArrayOfByte);
      paramWTReqUrlResult.h = paramString.toString();
      paramWTReqUrlResult.i = ((String)localObject);
      paramWTReqUrlResult.j = ((int)l1);
      paramWTReqUrlResult.k = null;
      paramWTReqUrlResult.l = true;
      return;
    }
    paramWTReqUrlResult.j = -100004;
    if (l1 == 0L) {
      paramWTReqUrlResult.j = -100005;
    }
    paramWTReqUrlResult.k = localResources.getString(2131887903);
    paramWTReqUrlResult.l = false;
    return;
    label612:
    paramWTReqUrlResult.l = false;
    paramWTReqUrlResult.j = ((int)l1);
    paramWTReqUrlResult.k = localResources.getString(2131889822);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramActivity == null) {
        return;
      }
      paramActivity = DialogUtil.a(paramActivity, 230).setTitle(null).setMessage(paramString).setNegativeButton(2131893757, new WTogetherUtil.1());
      paramActivity.setCancelable(false);
      paramActivity.show();
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, "", paramString3, paramString2, 25054, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString4)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether", 2, String.format("safetyReport [%s, %s, %s, %s, %s]", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt), paramString5 }));
      }
      ThreadManager.excute(new WTogetherUtil.2(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt), 16, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WTogether", 2, "safetyReport param null");
    }
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
    SessionInfo localSessionInfo = SessionMgr.a().b();
    Object localObject = null;
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface = (WTogetherMng)paramVideoAppInterface.c(17);
    } else {
      paramVideoAppInterface = null;
    }
    if (paramVideoAppInterface == null) {
      paramVideoAppInterface = null;
    } else {
      paramVideoAppInterface = paramVideoAppInterface.b(localSessionInfo);
    }
    if (paramVideoAppInterface == null) {
      paramVideoAppInterface = localObject;
    } else {
      paramVideoAppInterface = paramVideoAppInterface.g;
    }
    return (paramVideoAppInterface != null) && (paramVideoAppInterface.e() != 0);
  }
  
  public static int b()
  {
    return (int)(ImmersiveUtils.getScreenWidth() * 9.0F / 16.0F);
  }
  
  public static void b(Context paramContext)
  {
    if (!(paramContext instanceof AVActivity)) {
      return;
    }
    paramContext = ((AVActivity)paramContext).L;
    if (paramContext != null) {
      paramContext.m();
    }
  }
  
  public static boolean b(String paramString)
  {
    Object localObject = VideoController.f();
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    int j;
    int i;
    if ((!bool1) && (localObject != null))
    {
      int k = ((VideoController)localObject).i(paramString);
      int m = ((VideoController)localObject).g(paramString);
      j = m;
      i = k;
      bool1 = bool2;
      if (k >= 126) {
        if ((m != 4) && (m != 2))
        {
          j = m;
          i = k;
          bool1 = bool2;
          if (m != 3) {}
        }
        else
        {
          bool1 = true;
          j = m;
          i = k;
        }
      }
    }
    else
    {
      j = 0;
      i = 0;
      bool1 = bool2;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isPeerSupportWT, uin[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], sdk[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], terminal[");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("], support[");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public static boolean c()
  {
    if (QLog.isDevelopLevel())
    {
      boolean bool1 = AppNetConnInfo.isNetSupport();
      boolean bool2 = AppNetConnInfo.isWifiConn();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNoneWifiConn, isNetSupport[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], isWifiConn[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("]");
      QLog.i("WTogether", 4, localStringBuilder.toString());
    }
    return (AppNetConnInfo.isNetSupport()) && (!AppNetConnInfo.isWifiConn());
  }
  
  public static boolean c(String paramString)
  {
    Object localObject = VideoController.f();
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    int j;
    int i;
    if ((!bool1) && (localObject != null))
    {
      int k = ((VideoController)localObject).i(paramString);
      int m = ((VideoController)localObject).g(paramString);
      j = m;
      i = k;
      bool1 = bool2;
      if (k >= 128) {
        if ((m != 4) && (m != 2))
        {
          j = m;
          i = k;
          bool1 = bool2;
          if (m != 3) {}
        }
        else
        {
          bool1 = true;
          j = m;
          i = k;
        }
      }
    }
    else
    {
      j = 0;
      i = 0;
      bool1 = bool2;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isPeerSupportPaidRes, uin[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], sdk[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], terminal[");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("], support[");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public static String d()
  {
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localObject = ((TicketManager)((AppInterface)localObject).getManager(2)).getSkey(str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(SwiftBrowserCookieMonster.a(str));
    localStringBuilder.append("; skey=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPlayerCookie, cookie[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether", 4, ((StringBuilder)localObject).toString());
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTogetherUtil
 * JD-Core Version:    0.7.0.1
 */