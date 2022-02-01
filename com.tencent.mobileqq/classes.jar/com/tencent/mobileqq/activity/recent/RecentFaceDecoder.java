package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RecentFaceDecoder
{
  private static HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap;
  private static List<Integer> jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1000), Integer.valueOf(10004), Integer.valueOf(1020), Integer.valueOf(1003), Integer.valueOf(1005), Integer.valueOf(1004), Integer.valueOf(1008), Integer.valueOf(10005), Integer.valueOf(1009), Integer.valueOf(1021), Integer.valueOf(1022), Integer.valueOf(1023), Integer.valueOf(1024), Integer.valueOf(1025), Integer.valueOf(7400), Integer.valueOf(8112), Integer.valueOf(10008), Integer.valueOf(10010), Integer.valueOf(10009) });
  private static HashMap<Integer, Integer> jdField_b_of_type_JavaUtilHashMap;
  private static List<Integer> jdField_b_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(1001), Integer.valueOf(1010), Integer.valueOf(10002) });
  protected QQAppInterface a;
  public IFaceDecoder a;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    c();
    d();
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface, DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this(paramQQAppInterface, paramDecodeTaskCompletionListener, false);
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface, DecodeTaskCompletionListener paramDecodeTaskCompletionListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(paramDecodeTaskCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private Drawable a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 11)
        {
          if (paramInt != 32)
          {
            if (paramInt != 107)
            {
              if ((paramInt != 113) && (paramInt != 1001))
              {
                if (paramInt != 115) {
                  if (paramInt == 116) {}
                }
                switch (paramInt)
                {
                default: 
                  return null;
                case 103: 
                  return ImageUtil.b();
                case 102: 
                  return ImageUtil.b(102);
                  return Util.a(6);
                  return ImageUtil.a(true);
                }
              }
              return ImageUtil.d();
            }
            return ImageUtil.b(107);
          }
          return ImageUtil.e();
        }
        return ImageUtil.e();
      }
      return ImageUtil.c();
    }
    return ImageUtil.e();
  }
  
  public static Pair<Integer, Integer> a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    boolean bool = jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt));
    Integer localInteger = Integer.valueOf(-2147483648);
    if (bool) {
      return new Pair(jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)), localInteger);
    }
    if (jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return new Pair(localInteger, jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    }
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) {
      return b(paramString);
    }
    if (jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) {
      return a(paramString);
    }
    return b(paramQQAppInterface, paramInt, paramString);
  }
  
  private static Pair<Integer, Integer> a(String paramString)
  {
    boolean bool = String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramString);
    int j = -2147483648;
    int i;
    if (bool)
    {
      i = 2130840421;
    }
    else if (AppConstants.MSG_BOX_INTERACT_UIN.equals(paramString))
    {
      i = 2130845657;
    }
    else if (AppConstants.MSG_BOX_FOLLOW_UIN.equals(paramString))
    {
      i = 2130845656;
    }
    else if (AppConstants.MSG_BOX_MYMOMMENT_UIN.equals(paramString))
    {
      i = 2130845658;
    }
    else if (AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN.equals(paramString))
    {
      i = 2130845655;
    }
    else if (AppConstants.MSG_BOX_YANZHI_UIN.equals(paramString))
    {
      i = 2130845659;
    }
    else
    {
      i = -2147483648;
      j = 32;
    }
    return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  public static boolean a(int paramInt, RecentBaseData paramRecentBaseData)
  {
    return (paramInt == 10005) && ((paramRecentBaseData instanceof RecentItemImaxADData)) && (!TextUtils.isEmpty(((RecentItemImaxADData)paramRecentBaseData).mHeaderUrl));
  }
  
  private Drawable b(int paramInt, String paramString)
  {
    if (((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTempUinTypeList().contains(Integer.valueOf(paramInt)))
    {
      AbstractTempChatPlugin localAbstractTempChatPlugin = ((ITempChatPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(paramInt);
      if (localAbstractTempChatPlugin != null) {
        return localAbstractTempChatPlugin.a(paramString, TempChatSource.SOURCE_FROM_MAG_TAB);
      }
    }
    return null;
  }
  
  private Drawable b(String paramString, int paramInt)
  {
    if (paramInt == 104) {
      return DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramString);
    }
    if (paramInt == 105)
    {
      paramString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 1);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplication.getContext(), 1);
    }
    if (paramInt == 111)
    {
      paramString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 3);
      if ((paramString != null) && (paramString.a() != null)) {
        paramString = paramString.a();
      } else {
        paramString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplication.getContext(), 3);
      }
      return ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getSpecAggregateAvatarForKanDian(paramString);
    }
    if (paramInt == 106) {
      return EcShopAssistantManager.a(BaseApplication.getContext());
    }
    if (paramInt == 108) {
      return ((BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a();
    }
    if (paramInt == 110)
    {
      paramString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 2);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplication.getContext(), 2);
    }
    if (paramInt == 112) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(ServiceAccountFolderManager.a());
    }
    if (paramInt == 116) {
      return Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    }
    return null;
  }
  
  private static Pair<Integer, Integer> b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int i = 2130844994;
    int j = -2147483648;
    if (paramInt != 1)
    {
      if (paramInt != 1032)
      {
        if (paramInt != 7000)
        {
          if (paramInt != 7120)
          {
            if (paramInt != 7230)
            {
              if (paramInt != 9501)
              {
                paramInt = -2147483648;
                i = j;
              }
              else
              {
                i = 104;
                paramInt = 2130839564;
              }
            }
            else
            {
              if (TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon())) {
                paramInt = ServiceAccountFolderManager.a();
              } else {
                paramInt = 2147483647;
              }
              i = 112;
            }
          }
          else
          {
            i = 106;
            paramInt = 2130847270;
          }
        }
        else if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString))
        {
          paramInt = 2130840427;
          i = j;
        }
        else
        {
          paramInt = -2147483648;
          i = 103;
        }
      }
      else if (TextUtils.equals(paramString, AppConstants.CONFESS_UIN))
      {
        paramInt = i;
        i = j;
      }
      else
      {
        paramInt = i;
        i = j;
        if (TextUtils.equals(paramString, AppConstants.CONFESS_FRD_REC_UIN))
        {
          paramInt = 2130844995;
          i = j;
        }
      }
    }
    else
    {
      HotChatManager localHotChatManager = paramQQAppInterface.getHotChatMng(false);
      if ((localHotChatManager != null) && (localHotChatManager.b(paramString)))
      {
        paramInt = HotChatManager.a(paramString, paramQQAppInterface);
        i = j;
      }
      else if (TroopUtils.a(paramString))
      {
        paramInt = -2147483648;
        i = 4;
      }
      else
      {
        paramInt = -2147483648;
        i = 113;
      }
    }
    return Pair.create(Integer.valueOf(i), Integer.valueOf(paramInt));
  }
  
  private static Pair<Integer, Integer> b(String paramString)
  {
    boolean bool = String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(paramString);
    int i = 2130840428;
    int j = -2147483648;
    if ((!bool) && (!String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(paramString))) {
      if (String.valueOf(AppConstants.SAME_STATE_BOX_UIN).equals(paramString))
      {
        i = 2130840431;
      }
      else if (AppConstants.VOTE_MSG_UIN.equals(paramString))
      {
        i = 2130840586;
      }
      else if (AppConstants.NEW_KANDIAN_UIN.equals(paramString))
      {
        i = -2147483648;
        j = 110;
      }
      else
      {
        i = -2147483648;
        j = 1;
      }
    }
    return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  private static void c()
  {
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6002), Integer.valueOf(104));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1006), Integer.valueOf(11));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3000), Integer.valueOf(101));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3002), Integer.valueOf(1001));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(8113), Integer.valueOf(4));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(9003), Integer.valueOf(108));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7210), Integer.valueOf(105));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7220), Integer.valueOf(111));
    HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
    Integer localInteger = Integer.valueOf(1);
    localHashMap.put(Integer.valueOf(1033), localInteger);
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1044), localInteger);
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1045), localInteger);
  }
  
  private static void d()
  {
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6000), Integer.valueOf(2130844282));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6003), Integer.valueOf(2130844277));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(4000), Integer.valueOf(2130840417));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9002), Integer.valueOf(2130844725));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(5000), Integer.valueOf(2130840429));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(5001), Integer.valueOf(2130842647));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(7200), Integer.valueOf(2130840424));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9000), Integer.valueOf(2130840428));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9503), Integer.valueOf(2130840425));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9999), Integer.valueOf(2130839593));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(1031), Integer.valueOf(2130840405));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6004), Integer.valueOf(2130850946));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(10011), Integer.valueOf(2130850944));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(10012), Integer.valueOf(2130840131));
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, true);
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean)
  {
    Drawable localDrawable = b(paramInt, paramString);
    if (localDrawable != null) {
      return localDrawable;
    }
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString);
    int i = ((Integer)((Pair)localObject).first).intValue();
    int j = ((Integer)((Pair)localObject).second).intValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFaceDrawable uintype = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", uin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isGetResFace = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", faceType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", faceResId = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("RecentFaceDecoder", 2, ((StringBuilder)localObject).toString());
    }
    if (j == 2147483647) {}
    try
    {
      paramString = a(i, paramString);
    }
    catch (Exception paramString)
    {
      label225:
      label232:
      break label225;
    }
    if (i != -2147483648)
    {
      paramString = a(paramString, i);
    }
    else if ((j != -2147483648) && (paramBoolean))
    {
      paramString = BaseApplication.getContext().getResources().getDrawable(j);
      break label232;
      paramString.printStackTrace();
    }
    else
    {
      return localDrawable;
    }
    return paramString;
  }
  
  public Drawable a(RecentBaseData paramRecentBaseData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable start");
    }
    int j = paramRecentBaseData.getRecentUserType();
    int i;
    Object localObject;
    if (paramRecentBaseData.getRecentUserType() == 8)
    {
      i = paramRecentBaseData.mExtraType;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFaceDrawable type = ");
        ((StringBuilder)localObject).append(i);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject).toString());
      }
      if (i != 0)
      {
        if (i == 25)
        {
          IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
          localObject = null;
          if (localIPhoneContactService != null) {
            localObject = localIPhoneContactService.queryContactByCodeNumber(paramRecentBaseData.mPhoneNumber);
          }
          if (localObject != null)
          {
            localObject = FaceDrawable.getMobileFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.mPhoneNumber, (byte)3);
            paramRecentBaseData = (RecentBaseData)localObject;
            if (localObject != null) {
              break label423;
            }
            paramRecentBaseData = ImageUtil.e();
            break label423;
          }
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(16, paramRecentBaseData.getRecentUserUin(), (byte)3, true, 16);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = ImageUtil.e();
            break label423;
          }
        }
        for (paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);; paramRecentBaseData = new BitmapDrawable(paramRecentBaseData))
        {
          break;
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramRecentBaseData.getRecentUserUin(), (byte)3, true);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = ImageUtil.e();
            break;
          }
        }
      }
      else
      {
        paramRecentBaseData = a(i, paramRecentBaseData.getRecentUserUin());
      }
    }
    else if (j == 26)
    {
      paramRecentBaseData = OpenSDKUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin());
    }
    else if (j == 1034)
    {
      j = 2130844976;
      i = j;
      if ((paramRecentBaseData instanceof RecentItemConfessMsg))
      {
        i = j;
        if (((RecentItemConfessMsg)paramRecentBaseData).mConfessInfo.confessorSex == 1) {
          i = 2130844977;
        }
      }
      paramRecentBaseData = BaseApplication.getContext().getResources().getDrawable(i);
    }
    else if (a(j, paramRecentBaseData))
    {
      paramRecentBaseData = a(114, ((RecentItemImaxADData)paramRecentBaseData).mHeaderUrl);
    }
    else if (j == 10007)
    {
      paramRecentBaseData = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getRecentGameMsgDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin());
    }
    else
    {
      localObject = paramRecentBaseData.getRecentUserUin();
      i = j;
      if ((paramRecentBaseData instanceof RecentCallItem))
      {
        i = j;
        if (((RecentCallItem)paramRecentBaseData).a()) {
          i = 3002;
        }
      }
      paramRecentBaseData = a(i, (String)localObject);
    }
    label423:
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable end");
    }
    return paramRecentBaseData;
  }
  
  public Drawable a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getFaceDrawable facetype = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", uin = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("RecentFaceDecoder", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = b(paramString, paramInt);
    if (localObject1 != null) {
      return localObject1;
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    localObject1 = null;
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramInt, paramString, false, 0);
      return null;
    }
    if ((this.jdField_b_of_type_Boolean) && (!this.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 1");
      }
      return a(paramInt);
    }
    int i;
    if (paramInt == 103) {
      i = 1;
    } else {
      i = paramInt;
    }
    int j;
    if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(paramString)) {
      j = 202;
    } else {
      j = 200;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject2 != null) {
      if (paramInt == 32) {
        localObject1 = ((IFaceDecoder)localObject2).getBitmapFromCache(i, paramString, j);
      } else {
        localObject1 = ((IFaceDecoder)localObject2).getBitmapFromCache(i, paramString);
      }
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestDecodeFace| [");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",");
      localStringBuilder.append(localObject1);
      localStringBuilder.append("], isPausing=");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
      if (localObject2 == null) {
        localObject2 = "null";
      } else {
        localObject2 = Boolean.valueOf(((IFaceDecoder)localObject2).isPausing());
      }
      localStringBuilder.append(localObject2);
      QLog.i("Q.recent", 4, localStringBuilder.toString());
    }
    if (localObject1 == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
      if ((localObject1 != null) && (!((IFaceDecoder)localObject1).isPausing())) {
        if (i == 32)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeStrangeFace(paramString, j, true, false);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, i, true, (byte)0);
          if ((i == 1001) && (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(101, paramString) == null)) {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 101, true, (byte)0);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 2");
      }
      return a(paramInt);
    }
    if (paramInt == 103)
    {
      localObject2 = BaseApplication.getContext().getResources().getDrawable(2130840412);
      if ((localObject2 instanceof SkinnableBitmapDrawable)) {
        ((SkinnableBitmapDrawable)localObject2).setGravity(81);
      }
      if ((localObject2 instanceof BitmapDrawable)) {
        ((BitmapDrawable)localObject2).setGravity(81);
      }
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localObject1 = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1), localObject2 });
    }
    else
    {
      localObject1 = new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1);
    }
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString)) {
      return ((IKandianSubscribeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IKandianSubscribeManager.class)).getAggregateAvate((Drawable)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return localObject1;
  }
  
  public Drawable a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    paramString1 = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, (byte)3);
    label298:
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAppletsFolderDrawable width = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", height = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", url = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", urlSimple = ");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("RecentFaceDecoder", 2, ((StringBuilder)localObject).toString());
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(paramInt1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources());
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramString1;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramString1;
      if (QQTheme.f())
      {
        if (TextUtils.isEmpty(paramString3)) {
          break label298;
        }
        paramInt1 = Math.min(((URLDrawable.URLDrawableOptions)localObject).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight);
        paramString3 = URLDrawable.getDrawable(paramString3, (URLDrawable.URLDrawableOptions)localObject);
        paramString3.setTag(new int[] { paramInt1, paramInt1, (int)(paramInt1 * 0.07142858F) });
        paramString3.setDecodeHandler(URLDrawableDecodeHandler.i);
        return paramString3;
      }
      if (TextUtils.isEmpty(paramString2)) {
        break label298;
      }
      paramString3 = URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject);
      return paramString3;
    }
    catch (Exception paramString3)
    {
      label254:
      break label254;
    }
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("getAppletsFolderDrawable illegal url format: ");
      paramString3.append(paramString2);
      QLog.e("RecentFaceDecoder", 2, paramString3.toString());
    }
    return paramString1;
  }
  
  public URLDrawable a(int paramInt, String paramString)
  {
    if (paramInt != 112)
    {
      if (paramInt != 114)
      {
        if (paramInt != 1000) {
          return null;
        }
        paramString = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
        localDrawable = ImageUtil.c();
        return URLDrawable.getDrawable(paramString.iconUrl, localDrawable, localDrawable);
      }
      Drawable localDrawable = ImageUtil.e();
      paramString = URLDrawable.getDrawable(paramString, localDrawable, localDrawable);
      paramString.setDecodeHandler(URLDrawableDecodeHandler.a);
      return paramString;
    }
    paramString = BaseApplicationImpl.sApplication.getResources().getDrawable(ServiceAccountFolderManager.a());
    return URLDrawable.getDrawable(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon(), paramString, paramString);
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public void a()
  {
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.setAppRuntime(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void b()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentFaceDecoder
 * JD-Core Version:    0.7.0.1
 */