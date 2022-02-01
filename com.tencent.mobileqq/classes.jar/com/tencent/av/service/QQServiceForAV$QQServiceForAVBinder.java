package com.tencent.av.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.AvAddFriendService;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.ptu.PtuResDownloadCallbackForQav;
import com.tencent.av.ui.avatar.QavAvatarUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.api.IVideoProcessMonitor;
import com.tencent.av.wtogether.WTogetherRealNameMainProcessHelper;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.QavVideoDownloadHandler;
import com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.qcall.QCallCardHandler;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.troopgag.data.TroopGagInfo;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

class QQServiceForAV$QQServiceForAVBinder
  extends IQQServiceForAV.Stub
{
  QQServiceForAV$QQServiceForAVBinder(QQServiceForAV paramQQServiceForAV) {}
  
  private void a(IBinder paramIBinder)
  {
    Object localObject = new Intent(this.a.getApplicationContext(), UtilsServiceForAV.class);
    this.a.getApplicationContext().stopService((Intent)localObject);
    if (!((IVideoProcessMonitor)QRoute.api(IVideoProcessMonitor.class)).isVideoProcessAlive())
    {
      AVLog.printAllUserLog("QQServiceForAV", "linkToVideoProcessDeath");
      ((IVideoProcessMonitor)QRoute.api(IVideoProcessMonitor.class)).setMonitorBinder(paramIBinder);
      try
      {
        paramIBinder.linkToDeath(new QQServiceForAV.QQServiceForAVBinder.2(this), 0);
        return;
      }
      catch (RemoteException paramIBinder)
      {
        ((IVideoProcessMonitor)QRoute.api(IVideoProcessMonitor.class)).clearMonitorBinder();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("linkToVideoProcessDeath exception msg = ");
        ((StringBuilder)localObject).append(paramIBinder.getMessage());
        AVLog.printErrorLog("QQServiceForAV", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public int a()
  {
    return ((IPhoneContactService)((QQAppInterface)this.a.a()).getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
  }
  
  public int a(int paramInt, String paramString)
  {
    Object localObject = (QQAppInterface)this.a.a();
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    int i = QAVGroupConfig.a((QQAppInterface)localObject, bool, paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getGroupMemberNum, relationType[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], uin[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], 成员数[");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("]");
    QLog.w("QQServiceForAV", 1, ((StringBuilder)localObject).toString());
    return i;
  }
  
  public int a(String paramString)
  {
    return ((QQAppInterface)this.a.a()).getAVNotifyCenter().b(paramString);
  }
  
  public long a(String paramString)
  {
    paramString = ((DiscussionManager)((QQAppInterface)this.a.a()).getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    if (paramString != null) {
      return paramString.mOrigin;
    }
    return 0L;
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getFaceBitmap uinType = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", uin = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", extraUin = ");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", isRound = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject1).toString());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    byte b;
    if (paramBoolean1) {
      b = 4;
    } else {
      b = 5;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 25)
        {
          if (paramInt != 26)
          {
            if (paramInt != 1000)
            {
              if (paramInt != 1001)
              {
                if (paramInt == 1004) {
                  break label498;
                }
                if (paramInt != 1006)
                {
                  if (paramInt != 1010)
                  {
                    if (paramInt == 1024) {
                      break label498;
                    }
                    if (paramInt != 3000)
                    {
                      if (paramInt != 9500)
                      {
                        if (paramInt != 10002)
                        {
                          if ((paramInt == 1020) || (paramInt == 1021)) {
                            break label498;
                          }
                          paramString2 = localQQAppInterface.getFaceBitmap(paramString1, b, true);
                          break label508;
                        }
                      }
                      else
                      {
                        paramString2 = ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(paramString1));
                        paramString2 = DeviceHeadMgr.getInstance().getDeviceHeadByPID(paramString2.productId);
                        break label508;
                      }
                    }
                    else
                    {
                      localObject2 = (BitmapDrawable)((DiscussionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(paramString1, false);
                      paramString2 = (String)localObject1;
                      if (localObject2 == null) {
                        break label508;
                      }
                      paramString2 = ((BitmapDrawable)localObject2).getBitmap();
                      break label508;
                    }
                  }
                }
                else
                {
                  if (paramString1.startsWith("+")) {
                    paramString2 = paramString1;
                  }
                  paramString2 = FaceDrawable.getMobileFaceDrawable(localQQAppInterface, paramString2, b).getLoadedBitmap();
                  break label508;
                }
              }
              paramString2 = FaceDrawable.getStrangerFaceDrawable(localQQAppInterface, 200, paramString1, true).getLoadedBitmap();
              break label508;
            }
          }
          else
          {
            paramString2 = OpenSDKUtils.a(localQQAppInterface, paramString2);
            break label508;
          }
        }
        else
        {
          IPhoneContactService localIPhoneContactService = (IPhoneContactService)localQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
          localObject1 = localObject2;
          if (localIPhoneContactService != null)
          {
            localObject1 = localObject2;
            if (paramString2 != null) {
              localObject1 = localIPhoneContactService.queryContactByCodeNumber(paramString2);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getFaceBitmap contact = ");
            ((StringBuilder)localObject2).append(localObject1);
            QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject2).toString());
          }
          if (localObject1 != null)
          {
            paramString2 = FaceDrawable.getMobileFaceDrawable(localQQAppInterface, paramString2, b).getLoadedBitmap();
            break label508;
          }
          paramString2 = localQQAppInterface.getFaceBitmap(16, paramString1, (byte)3, true, 16);
          break label508;
        }
      }
      else
      {
        paramString2 = localQQAppInterface.getTroopFaceBitmap(paramString1, b, false, false);
        break label508;
      }
    }
    label498:
    paramString2 = localQQAppInterface.getFaceBitmap(paramString1, b, true);
    label508:
    if (paramString2 == null)
    {
      if (!this.a.jdField_b_of_type_JavaUtilArrayList.contains(paramString1)) {
        this.a.jdField_b_of_type_JavaUtilArrayList.add(paramString1);
      }
      localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    }
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = paramString2;
      if (paramBoolean2)
      {
        if (QLog.isColorLevel()) {
          QLog.w("QQServiceForAV", 2, "getFaceBitmap failed, use default face!");
        }
        if (paramInt == 1) {
          return ImageUtil.d();
        }
        if (paramInt == 3000) {
          return ImageUtil.e();
        }
        paramString1 = ImageUtil.f();
      }
    }
    return paramString1;
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    boolean bool1;
    if (QLog.isDevelopLevel())
    {
      paramResultReceiver = new StringBuilder();
      paramResultReceiver.append("requestEvent, mainCmd[");
      paramResultReceiver.append(paramInt1);
      paramResultReceiver.append("], subType[");
      paramResultReceiver.append(paramInt2);
      paramResultReceiver.append("], seq[");
      paramResultReceiver.append(paramInt3);
      paramResultReceiver.append("], buf[");
      boolean bool2 = false;
      if (paramArrayOfByte != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramResultReceiver.append(bool1);
      paramResultReceiver.append("], bundle[");
      bool1 = bool2;
      if (paramBundle != null) {
        bool1 = true;
      }
      paramResultReceiver.append(bool1);
      paramResultReceiver.append("]");
      QLog.d("QQServiceForAV", 1, paramResultReceiver.toString());
      AudioHelper.a("requestEvent", paramBundle);
    }
    if (paramBundle == null) {
      return new Bundle();
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 3)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 5)
          {
            if (paramInt1 != 6)
            {
              if (paramInt1 == 7)
              {
                paramArrayOfByte = paramBundle.getString("red_touch_app_id");
                paramBundle.putParcelable("red_touch_red_app_info", RedTouchUtils.a(((IRedTouchManager)((QQAppInterface)this.a.a()).getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(paramArrayOfByte)));
                return paramBundle;
              }
            }
            else {
              return QAVGroupConfig.a((QQAppInterface)this.a.a(), paramBundle.getString("uin"));
            }
          }
          else {
            return QAVHrMeeting.a((QQAppInterface)this.a.a(), paramBundle);
          }
        }
        else {
          QAVHrMeeting.a((QQAppInterface)this.a.a(), paramBundle);
        }
      }
      else
      {
        paramArrayOfByte = paramBundle.getString("uin");
        paramResultReceiver = (QQAppInterface)this.a.a();
        bool1 = QAVGroupConfig.a("GetInviteFlag", paramResultReceiver, paramArrayOfByte);
        QAVGroupConfig.a("GetInviteFlag", paramResultReceiver, paramArrayOfByte);
        paramBundle.putBoolean("enableInvite", bool1);
        return paramBundle;
      }
    }
    else {
      new Handler(Looper.getMainLooper()).postDelayed(new QQServiceForAV.QQServiceForAVBinder.3(this, paramBundle), 1L);
    }
    return null;
  }
  
  public String a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    return ((TicketManager)localQQAppInterface.getManager(2)).getSkey(localQQAppInterface.getCurrentAccountUin());
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    str1 = paramString1;
    if (paramString1 != null) {
      str1 = paramString1.trim();
    }
    boolean bool = TextUtils.isEmpty(str1);
    String str2 = "";
    paramString1 = str2;
    QQAppInterface localQQAppInterface;
    if (!bool)
    {
      localQQAppInterface = (QQAppInterface)this.a.a();
      if (paramInt != 1006) {}
    }
    try
    {
      paramString1 = a(localQQAppInterface, str1, paramString2);
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        int i;
        Object localObject1;
        Object localObject2;
        label406:
        continue;
        paramString1 = str1;
      }
    }
    if (paramInt == 26)
    {
      paramString1 = OpenSDKUtils.a(localQQAppInterface, paramString2);
    }
    else if (paramInt == 25)
    {
      paramString1 = b(localQQAppInterface, str1, paramString2);
    }
    else if (paramInt == 1)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = ContactUtils.b(localQQAppInterface, str1, paramString2);
      } else {
        paramString1 = ContactUtils.a(localQQAppInterface, str1, false);
      }
    }
    else if (paramInt == 9500)
    {
      paramString1 = ((SmartDeviceProxyMgr)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(str1));
      if (paramString1 == null) {
        break label507;
      }
      paramString1 = SmartDeviceUtil.a(paramString1);
    }
    else
    {
      i = ContactUtils.a(paramInt);
      if (i == -1) {
        paramString1 = ContactUtils.a(localQQAppInterface, str1, paramInt);
      } else {
        paramString1 = ContactUtils.a(localQQAppInterface, str1, paramString2, i, 0);
      }
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject1 = paramString1;
        if (!str1.equals(paramString1)) {}
      }
      else
      {
        localObject1 = ContactUtils.a(localQQAppInterface, str1, true);
      }
      paramString1 = (String)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString1 = str1;
      }
      localObject2 = paramString1;
      if (str1.equals(paramString1))
      {
        localObject2 = (FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject1 = paramString1;
        if (localObject2 != null)
        {
          localObject2 = ((FriendsManager)localObject2).e(str1);
          localObject1 = paramString1;
          if (localObject2 != null) {
            localObject1 = ContactUtils.a((Friends)localObject2);
          }
        }
        if (!str1.equals(localObject1))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
        else
        {
          paramString1 = (FriendListHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          localObject2 = localObject1;
          if (paramString1 != null)
          {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(str1);
            localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
            paramString1.getFriendInfo(str1);
            localObject2 = localObject1;
          }
        }
      }
      paramString1 = (String)localObject2;
      break label406;
      QLog.d("QQServiceForAV", 1, "getDisplayName", paramString1);
      paramString1 = str2;
    }
    for (;;)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getDisplayName, uinType[");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("], uin[");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append("], extraUin[");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("], name[");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("]");
      QLog.w("QQServiceForAV", 1, ((StringBuilder)localObject1).toString());
      return paramString1;
    }
  }
  
  public String a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAvatarDownloadUrl uinType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", uin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", extraUin = ");
      localStringBuilder.append(paramString2);
      QLog.d("QQServiceForAV", 2, localStringBuilder.toString());
    }
    boolean bool = QavAvatarUtil.a(paramInt1);
    StringBuilder localStringBuilder = null;
    paramString2 = localStringBuilder;
    if (bool)
    {
      Setting localSetting = ((QQAppInterface)this.a.a()).getQQHeadSettingFromDB(paramString1);
      paramString2 = localStringBuilder;
      if (localSetting != null)
      {
        paramString2 = localStringBuilder;
        if (!TextUtils.isEmpty(localSetting.uin)) {
          if (TextUtils.isEmpty(localSetting.url)) {
            paramString2 = localStringBuilder;
          } else {
            paramString2 = QavAvatarUtil.a(localSetting.url, paramInt2, localSetting.bFaceFlags);
          }
        }
      }
    }
    if (!this.a.jdField_b_of_type_JavaUtilArrayList.contains(paramString1)) {
      this.a.jdField_b_of_type_JavaUtilArrayList.add(paramString1);
    }
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAvatarDownloadUrl, uin[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], path[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.i("QQServiceForAV", 4, localStringBuilder.toString());
    }
    return paramString2;
  }
  
  String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str1;
    if (!paramString1.startsWith("+"))
    {
      if ((paramString2 != null) && (paramString2.startsWith("+"))) {
        str1 = paramString2;
      } else {
        return "";
      }
    }
    else {
      str1 = paramString1;
    }
    Object localObject = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (localObject != null) {
      localObject = ((IPhoneContactService)localObject).queryContactByCodeNumber(str1);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return ((PhoneContact)localObject).name;
    }
    String str2 = ContactUtils.b(paramQQAppInterface, str1);
    localObject = str2;
    if (str2 == null)
    {
      if (paramString1.startsWith("+")) {
        if ((paramString2 != null) && (!paramString2.startsWith("+"))) {
          paramString1 = paramString2;
        } else {
          paramString1 = null;
        }
      }
      localObject = paramString1;
      if (paramString1 != null)
      {
        ContactUtils.a(paramQQAppInterface, str1, paramString1);
        localObject = paramString1;
      }
    }
    if (localObject != null)
    {
      paramString1 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramString1 != null) {
        paramString1 = paramString1.e((String)localObject);
      } else {
        paramString1 = null;
      }
      if (paramString1 != null)
      {
        paramString1 = ContactUtils.a(paramString1);
        break label192;
      }
    }
    paramString1 = null;
    label192:
    if ((paramString1 != null) && (!paramString1.equals(localObject))) {
      return paramString1;
    }
    paramString1 = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if ((paramString1 != null) && (localObject != null))
    {
      this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      paramQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      paramString1.getFriendInfo((String)localObject);
    }
    return str1;
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)((QQAppInterface)this.a.a()).getRuntimeService(IPhoneContactService.class, "");
    if (localIPhoneContactService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
      }
      return null;
    }
    paramString = localIPhoneContactService.queryPhoneContactByMobile(paramString);
    if ((paramString != null) && (paramString.name != null)) {
      return paramString.name;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopPumpMessage, monbind[");
    ((StringBuilder)localObject).append(this.a.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject).append("], IBinder[");
    ((StringBuilder)localObject).append(((IVideoProcessMonitor)QRoute.api(IVideoProcessMonitor.class)).isVideoProcessAlive());
    ((StringBuilder)localObject).append("]");
    QLog.w("QQServiceForAV", 1, ((StringBuilder)localObject).toString());
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    localObject = localQQAppInterface;
    if (localQQAppInterface == null) {
      localObject = (QQAppInterface)this.a.a();
    }
    ((QQAppInterface)localObject).getMessageFacade().deleteObserver(this.a);
  }
  
  public void a(int paramInt)
  {
    Object localObject = (IEarlyDownloadService)QQServiceForAV.b(this.a).getRuntimeService(IEarlyDownloadService.class, "");
    if (localObject != null)
    {
      localObject = (QavVideoDownloadHandler)((IEarlyDownloadService)localObject).getEarlyHandler("qq.android.qav.video");
      if (localObject != null) {
        ((QavVideoDownloadHandler)localObject).a(false);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject = (QQAppInterface)this.a.a();
    GVideoHandler localGVideoHandler = (GVideoHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
    if (localGVideoHandler != null)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestGrayVideoWebViewConfig, identity[");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("], guin[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("], clientId[");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("], appVersion[");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append("]");
        QLog.w("QQServiceForAV", 1, localStringBuilder.toString());
        ((QQAppInterface)localObject).addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
        localGVideoHandler.a(paramInt1, paramLong);
        return;
      }
      catch (Exception localException)
      {
        ((QQAppInterface)localObject).removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestGrayVideoWebViewConfig-->error,e=");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("QQServiceForAV", 2, "requestGrayVideoWebViewConfig-->can not get TroopHandle");
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject2 = (QQAppInterface)this.a.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (QQAppInterface)this.a.a();
    }
    localObject2 = this.a;
    ((QQServiceForAV)localObject2).jdField_a_of_type_Int = paramInt;
    ((QQServiceForAV)localObject2).jdField_b_of_type_JavaLangString = paramString;
    ((QQServiceForAV)localObject2).jdField_b_of_type_Long = MessageCache.a();
    ((QQAppInterface)localObject1).getMessageFacade().addObserver(this.a);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startPumpMessage uinType = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", peerUin = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",mStartTime:");
      ((StringBuilder)localObject1).append(this.a.jdField_b_of_type_Long);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = (QQAppInterface)this.a.a();
    localObject = this.a;
    ((QQServiceForAV)localObject).jdField_a_of_type_Int = paramInt;
    ((QQServiceForAV)localObject).jdField_b_of_type_JavaLangString = paramString1;
    ((QQServiceForAV)localObject).d = paramString2;
    ((QQServiceForAV)localObject).jdField_b_of_type_Long = MessageCache.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPeerInfo uinType = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", peerUin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", extraUin = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",mStartTime:");
      ((StringBuilder)localObject).append(this.a.jdField_b_of_type_Long);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong)
  {
    ((QQAppInterface)this.a.a()).getAVNotifyCenter().a(paramLong);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportGVideoOnlineTime uin = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" troopuin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" onlineTime");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)this.a.a();
    ((QQAppInterface)localObject).addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
    GVideoHandler localGVideoHandler = (GVideoHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
    if (localGVideoHandler != null) {
      try
      {
        localGVideoHandler.a(paramLong, Long.parseLong(paramString), paramInt);
        return;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo NumberFormatException !", paramString);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo-->can not get TroopHandle");
    }
    ((QQAppInterface)localObject).removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface != null) {
      localQQAppInterface.getMsgCache().a(paramLong1, paramString, paramLong2);
    }
  }
  
  public void a(IQQServiceCallback paramIQQServiceCallback)
  {
    if (paramIQQServiceCallback != null) {
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.unregister(paramIQQServiceCallback);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "unregisterCallback");
    }
    ((QQAppInterface)this.a.a()).mQQServiceRef = null;
  }
  
  public void a(IQQServiceCallback paramIQQServiceCallback, String paramString)
  {
    if (paramIQQServiceCallback != null)
    {
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.register(paramIQQServiceCallback, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "registerCallback");
      }
      a(paramIQQServiceCallback.asBinder());
      paramIQQServiceCallback = (QQAppInterface)this.a.a();
      paramIQQServiceCallback.mQQServiceRef = null;
      paramIQQServiceCallback.mQQServiceRef = new WeakReference(this.a);
    }
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    if (paramIQQServiceLocationCallback == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getAddressConfig IQQServiceLocationCallback is null");
      }
      return;
    }
    Object localObject = (QQAppInterface)this.a.a();
    localObject = (ConditionSearchManager)QQServiceForAV.a(this.a).getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getAddressConfig for IQQServiceLocationCallback");
      }
      if (((ConditionSearchManager)localObject).a() == 1)
      {
        if (((ConditionSearchManager)localObject).a(((ConditionSearchManager)localObject).a(), true) == 0)
        {
          if (QQServiceForAV.a(this.a) == null) {
            QQServiceForAV.a(this.a, new QQServiceForAV.CMSConfigUpdateListener(this, (ConditionSearchManager)localObject, paramIQQServiceLocationCallback));
          } else {
            QQServiceForAV.a(this.a).a(paramIQQServiceLocationCallback);
          }
          ((ConditionSearchManager)localObject).c(QQServiceForAV.a(this.a));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "ConditionSearchManager update RESULT_UPDATE_REMOTE fail");
        }
        a(false, paramIQQServiceLocationCallback);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "ConditionSearchManager config exist");
      }
      a(true, paramIQQServiceLocationCallback);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "Get ConditionSearchManager null");
    }
    a(false, paramIQQServiceLocationCallback);
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    INearbyCardHandler localINearbyCardHandler = (INearbyCardHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
    localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    localINearbyCardHandler.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ProtoUtils.a((QQAppInterface)this.a.a(), new QQServiceForAV.QQServiceForAVBinder.1(this, paramString, paramInt2), paramArrayOfByte, paramString, paramInt1, paramInt2);
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = (AIOAnimationControlManager)((QQAppInterface)this.a.a()).getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if (localObject != null) {
      ((AIOAnimationControlManager)localObject).a(paramString);
    }
    if ((paramLong > 0L) && ((QQServiceForAV.f(this.a) instanceof QQAppInterface)))
    {
      localObject = (QQAppInterface)QQServiceForAV.g(this.a);
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = paramString;
      localSessionInfo.jdField_a_of_type_Int = 1;
      ChatActivityFacade.a((QQAppInterface)localObject, localSessionInfo);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "sendMessageToTroop");
    }
    paramString2 = (QQAppInterface)this.a.a();
    if (paramString2 == null)
    {
      paramString1 = (QQAppInterface)this.a.a();
      return;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    long l = MessageCache.a();
    localMessageRecord.init(paramString2.getCurrentAccountUin(), paramString3, paramString2.getCurrentAccountUin(), paramString1, l, -1000, 1, l);
    localMessageRecord.issend = 1;
    paramString2.getMessageFacade().a(localMessageRecord, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if ((!"1".equals(paramString3)) && (!"2".equals(paramString3)))
    {
      if ("3".equals(paramString3)) {
        this.a.a(paramString1);
      }
    }
    else {
      this.a.a(paramString1, paramString2, paramString3, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("listenTroopListUpdate bListen = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)this.a.a();
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((QQAppInterface)localObject).addObserver(QQServiceForAV.a(this.a));
        return;
      }
      ((QQAppInterface)localObject).removeObserver(QQServiceForAV.a(this.a));
    }
  }
  
  public void a(boolean paramBoolean, IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = -26;
    }
    try
    {
      paramIQQServiceLocationCallback.a(i, "admin_region_config");
      return;
    }
    catch (RemoteException paramIQQServiceLocationCallback)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "Call onGetAddressConfig fail", paramIQQServiceLocationCallback);
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGVideoLevelInfo uins = ");
      ((StringBuilder)localObject).append(paramArrayOfLong.toString());
      ((StringBuilder)localObject).append(" troopuin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)this.a.a();
    ((QQAppInterface)localObject).addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
    GVideoHandler localGVideoHandler = (GVideoHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
    if (localGVideoHandler != null) {
      try
      {
        localGVideoHandler.a(paramArrayOfLong, Long.parseLong(paramString));
        return;
      }
      catch (NumberFormatException paramArrayOfLong)
      {
        QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo NumberFormatException !", paramArrayOfLong);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo-->can not get TroopHandle");
    }
    ((QQAppInterface)localObject).removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
  }
  
  public boolean a()
  {
    return ((QQAppInterface)this.a.a()).isBackgroundPause;
  }
  
  public boolean a(int paramInt)
  {
    if (QQServiceForAV.a(this.a) == null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
      QQServiceForAV.a(this.a, new WTogetherRealNameMainProcessHelper(localQQAppInterface));
    }
    return QQServiceForAV.a(this.a).a(paramInt);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return ((QQAppInterface)this.a.a()).getAVNotifyCenter().a(paramInt, paramLong) > 0L;
  }
  
  public boolean a(long paramLong)
  {
    Object localObject = (QQAppInterface)this.a.a();
    ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    if (localITroopMemberListHandler != null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAdminMemberList, troopUin[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w("QQServiceForAV", 1, localStringBuilder.toString());
        ((QQAppInterface)localObject).addObserver(this.a.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
        localITroopMemberListHandler.a(paramLong, 0L, 2, 0, 0);
        return true;
      }
      catch (Exception localException)
      {
        ((QQAppInterface)localObject).removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getAdminMemberList Exception, troopUin[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]");
        QLog.w("QQServiceForAV", 1, ((StringBuilder)localObject).toString(), localException);
        return false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAdminMemberList null, troopUin[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("QQServiceForAV", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return ((FriendsManager)((QQAppInterface)this.a.a()).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = ((DiscussionManager)((QQAppInterface)this.a.a()).getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    if (paramString != null)
    {
      paramString.mOrigin = paramInt;
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.subCmd = paramInt2;
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "send0x211C2CMsg");
    }
    return localQQAppInterface.getMsgHandler().a().a(paramString, paramInt1, paramArrayOfByte, localFMTransC2CMsgInfo);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryTroopMember troopUin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("memUin:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)this.a.a();
    if (localObject != null)
    {
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER);
      if ((localObject != null) && (((TroopManager)localObject).b(paramString1, paramString2) == null)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)this.a.a();
    ((QQAppInterface)localObject).addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
    GVideoHandler localGVideoHandler = (GVideoHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
    if (localGVideoHandler != null) {
      try
      {
        localGVideoHandler.a(paramString, paramBoolean);
        return true;
      }
      catch (Exception paramString)
      {
        ((QQAppInterface)localObject).removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("joinOrExitOpenTroop-->error,e=");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->can not get TroopHandle");
    }
    ((QQAppInterface)localObject).removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
    return false;
  }
  
  @Deprecated
  public int[] a()
  {
    return new int[3];
  }
  
  public long[] a(String paramString)
  {
    ArrayList localArrayList = ((DiscussionManager)((QQAppInterface)this.a.a()).getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      long[] arrayOfLong = new long[j];
      int i = 0;
      for (;;)
      {
        paramString = arrayOfLong;
        if (i >= j) {
          break;
        }
        paramString = (DiscussionMemberInfo)localArrayList.get(i);
        if (paramString != null) {
          arrayOfLong[i] = Long.valueOf(paramString.memberUin).longValue();
        }
        i += 1;
      }
    }
    paramString = null;
    return paramString;
  }
  
  public String[] a(String paramString)
  {
    Object localObject = (QQAppInterface)this.a.a();
    if (localObject != null)
    {
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null)
      {
        paramString = ((TroopManager)localObject).b(paramString);
        if (paramString == null) {
          return new String[0];
        }
        if (!TextUtils.isEmpty(paramString.Administrator)) {
          return paramString.Administrator.split("\\|");
        }
      }
    }
    return new String[0];
  }
  
  @Deprecated
  public int b()
  {
    return 0;
  }
  
  public int b(String paramString)
  {
    return ((QQAppInterface)this.a.a()).getAvAddFriendService().a(paramString);
  }
  
  public long b(String paramString)
  {
    return ((QQAppInterface)this.a.a()).getAVNotifyCenter().a(paramString);
  }
  
  String b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if ((localObject != null) && (paramString2 != null)) {
      paramString2 = ((IPhoneContactService)localObject).queryContactByCodeNumber(paramString2);
    } else {
      paramString2 = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDisplayName contact = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString2 != null) {
      return paramString2.name;
    }
    paramString2 = ((QCallCardManager)paramQQAppInterface.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a(paramString1);
    paramQQAppInterface = (QCallCardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QCALLCARD_HANDLER);
    paramQQAppInterface.a(paramString1);
    paramQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqQcallQCallCardHandler$OnGetQCallCardListener);
    paramQQAppInterface = str;
    if (paramString2 != null)
    {
      paramQQAppInterface = str;
      if (paramString2.nickname != null) {
        paramQQAppInterface = paramString2.nickname;
      }
    }
    return paramQQAppInterface;
  }
  
  public String b(String paramString)
  {
    Object localObject = (QQAppInterface)this.a.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroopOwner mApp = ");
      localStringBuilder.append(localObject);
      QLog.d("QQServiceForAV", 2, localStringBuilder.toString());
    }
    if (localObject != null)
    {
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null)
      {
        paramString = ((TroopManager)localObject).b(paramString);
        if (paramString == null) {
          return null;
        }
        return paramString.troopowneruin;
      }
    }
    return null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "avStartAddFriendService");
    }
    ((QQAppInterface)this.a.a()).getAvAddFriendService();
  }
  
  public void b(int paramInt, String paramString)
  {
    QQServiceForAV localQQServiceForAV = this.a;
    localQQServiceForAV.jdField_a_of_type_JavaLangString = paramString;
    localQQServiceForAV.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    if (paramIQQServiceLocationCallback == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getUserCurrentLocation IQQServiceLocationCallback is null, no need notify");
      }
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if ((localQQAppInterface.getApp() != null) && (NetworkUtil.isNetSupport(localQQAppInterface.getApp().getApplicationContext())))
    {
      if (QQServiceForAV.a(this.a) == null) {
        QQServiceForAV.a(this.a, new QQServiceForAV.LocationListener());
      }
      QQServiceForAV.a(this.a).a(paramIQQServiceLocationCallback);
      if (QQServiceForAV.a(this.a).a() == 1)
      {
        localQQAppInterface.addObserver(QQServiceForAV.a(this.a));
        ((LBSHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).b();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "We are waiting getUserCurrentLocation response, so need't request again");
      }
    }
    else
    {
      try
      {
        paramIQQServiceLocationCallback.a(false, null);
        return;
      }
      catch (RemoteException paramIQQServiceLocationCallback)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQServiceForAV", 2, "Call getUserCurrentLocation fail", paramIQQServiceLocationCallback);
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("acceptAddFriend :");
      localStringBuilder.append(paramString);
      QLog.e("QQServiceForAV", 2, localStringBuilder.toString());
    }
    ((QQAppInterface)this.a.a()).getAvAddFriendService().c(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = SharedPreUtils.a(((QQAppInterface)this.a.a()).getApplication().getApplicationContext());
    Object localObject = localSharedPreferences.edit();
    if (paramBoolean)
    {
      ((SharedPreferences.Editor)localObject).putBoolean("qav_random_speakeron", true);
      ((SharedPreferences.Editor)localObject).commit();
    }
    else
    {
      ((SharedPreferences.Editor)localObject).putBoolean("qav_random_speakeron", false);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("qav_random_speakeron: ");
      ((StringBuilder)localObject).append(localSharedPreferences.getBoolean("qav_random_speakeron", false));
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface.isVideoChatting())
    {
      long l = localQQAppInterface.getAVNotifyCenter().b();
      int i = localQQAppInterface.getAVNotifyCenter().a();
      if (l > 0L)
      {
        int j = localQQAppInterface.getAVNotifyCenter().b(l);
        if ((i == 1) && (j == 2)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    return ((QQAppInterface)this.a.a()).getAVNotifyCenter().d(paramString);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "requestDecodeStrangeFace");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)localQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(localQQAppInterface);
      this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.a.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    }
    if (paramInt == 25) {
      return this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeQCallFace(paramString, 16, true, false);
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeStrangeFace(paramString, 200, true, false);
  }
  
  public long[] b(String paramString)
  {
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)((QQAppInterface)this.a.a()).getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if (localAIOAnimationControlManager != null) {
      return localAIOAnimationControlManager.a(paramString);
    }
    return null;
  }
  
  @Deprecated
  public int c()
  {
    return 0;
  }
  
  public int c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (BmqqSegmentUtil.c(paramString)) {
        return 1025;
      }
      return 1024;
    }
    return -1;
  }
  
  public String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    paramString = ((IPhoneContactService)QQServiceForAV.c(this.a).getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByMobile(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.uin;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "avStopAddFriendService");
    }
    ((QQAppInterface)this.a.a()).releaseAvAddFriendService();
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("acceptAddFriend :");
      localStringBuilder.append(paramString);
      QLog.e("QQServiceForAV", 2, localStringBuilder.toString());
    }
    ((QQAppInterface)this.a.a()).getAvAddFriendService().b(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playFlowerAnimation play: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mFlowerAnimationActive: ");
      localStringBuilder.append(this.a.jdField_a_of_type_Boolean);
      QLog.d("QQServiceForAV", 2, localStringBuilder.toString());
    }
  }
  
  public boolean c()
  {
    return AppSetting.d;
  }
  
  public boolean c(String paramString)
  {
    if (!(QQServiceForAV.h(this.a) instanceof QQAppInterface)) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.i(this.a);
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label35:
      int i;
      TroopGagMgr localTroopGagMgr;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      break label35;
    }
    l = 0L;
    i = UITools.b(1);
    l = localQQAppInterface.getAVNotifyCenter().a(i, l);
    localTroopGagMgr = (TroopGagMgr)((QQAppInterface)QQServiceForAV.j(this.a)).getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    bool1 = localTroopGagMgr.a(paramString, localQQAppInterface.getCurrentAccountUin());
    bool2 = localTroopGagMgr.a(paramString);
    bool3 = localTroopGagMgr.b(paramString);
    paramString = localTroopGagMgr.a(paramString);
    return (l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (paramString != null) && (paramString.a > 0L)));
  }
  
  public boolean c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("avAddFriend :");
      localStringBuilder.append(paramString);
      QLog.e("QQServiceForAV", 2, localStringBuilder.toString());
    }
    return ((QQAppInterface)this.a.a()).getAvAddFriendService().a(paramString, paramInt);
  }
  
  public int d()
  {
    return -1;
  }
  
  public String d(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    Object localObject3 = null;
    if (bool) {
      return null;
    }
    Object localObject2 = (QQAppInterface)this.a.a();
    localObject2 = ((FriendsManager)QQServiceForAV.d(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString);
    if (localObject2 != null)
    {
      localObject1 = BusinessCardUtils.a(((Card)localObject2).bCardInfo);
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (!((BusinessCard)localObject1).mobilesNum.isEmpty()) {
          localObject2 = (String)((BusinessCard)localObject1).mobilesNum.get(0);
        }
      }
      localObject1 = localObject2;
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getPhoneNumByUin in  list-data phoneNumber:=");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.w("QQServiceForAV", 4, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = (IPhoneContactService)QQServiceForAV.e(this.a).getRuntimeService(IPhoneContactService.class, "");
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        int i = ((IPhoneContactService)localObject3).getSelfBindState();
        if ((i != 9) && (i != 8) && (i != 4))
        {
          localObject2 = localObject1;
          if (i != 2) {}
        }
        else
        {
          localObject2 = localObject1;
          if (PermissionChecker.a().c())
          {
            paramString = ((IPhoneContactService)localObject3).queryPhoneContactByUin(paramString);
            localObject2 = localObject1;
            if (paramString != null) {
              localObject2 = paramString.mobileNo;
            }
          }
        }
      }
      localObject3 = localObject2;
      if (QLog.isDevelopLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getPhoneNumByUin in  PhoneContact phoneNumber:=");
        paramString.append((String)localObject2);
        QLog.w("QQServiceForAV", 4, paramString.toString());
        localObject3 = localObject2;
      }
    }
    return localObject3;
  }
  
  public void d(String paramString)
  {
    ((IRedTouchManager)((QQAppInterface)this.a.a()).getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, String.format("keepVideoProcessAlive keepAlive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    QQServiceForAV.a(this.a, paramBoolean);
  }
  
  public boolean d()
  {
    boolean bool = PtuResChecker.a(new PtuResDownloadCallbackForQav((QQAppInterface)this.a.a()));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEffectsSoLoadIsOk, ret[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w("PtuResCheck", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void e(String paramString)
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)((QQAppInterface)this.a.a()).getRuntimeService(IRedTouchManager.class, "");
    localIRedTouchManager.onRedTouchItemExposure(localIRedTouchManager.getAppInfoByPath(paramString), "");
  }
  
  public boolean e()
  {
    return ((QQAppInterface)this.a.a()).getAVNotifyCenter().b();
  }
  
  public void f(String paramString)
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)((QQAppInterface)this.a.a()).getRuntimeService(IRedTouchManager.class, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("redTouchManagerDismiss, appId ");
      localStringBuilder.append(paramString);
      QLog.d("QQServiceForAVQ.nearby.video_chat", 2, localStringBuilder.toString());
    }
    localIRedTouchManager.dismissRedTouch(paramString);
  }
  
  public boolean f()
  {
    return ((QQAppInterface)this.a.a()).getAVNotifyCenter().a();
  }
  
  public boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "call isQQSVIP ");
    }
    return VasUtil.a((QQAppInterface)this.a.a()).getVipStatus().isSVip();
  }
  
  public boolean h()
  {
    IAvGameManager localIAvGameManager = (IAvGameManager)((QQAppInterface)this.a.a()).getRuntimeService(IAvGameManager.class);
    boolean bool;
    if (localIAvGameManager != null) {
      bool = localIAvGameManager.isAvGameRoomExist();
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isInAVGameRoom, isAvGameRoomExist[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], avGameManager[");
      localStringBuilder.append(localIAvGameManager);
      localStringBuilder.append("]");
      QLog.i("QQServiceForAV", 2, localStringBuilder.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.QQServiceForAVBinder
 * JD-Core Version:    0.7.0.1
 */