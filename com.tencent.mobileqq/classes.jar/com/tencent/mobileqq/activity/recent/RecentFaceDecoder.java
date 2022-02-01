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
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
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
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatCenterManager;
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
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.NearbyCardManager;
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
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ImageUtil.c();
    case 4: 
      return ImageUtil.a();
    case 101: 
    case 113: 
    case 1001: 
      return ImageUtil.b();
    case 11: 
      return ImageUtil.c();
    case 102: 
      return ImageUtil.b(102);
    case 107: 
      return ImageUtil.b(107);
    case 103: 
      return ImageUtil.f();
    case 32: 
      return ImageUtil.c();
    case 115: 
      return ImageUtil.a(true);
    }
    return Util.a(6);
  }
  
  public static Pair<Integer, Integer> a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return new Pair(jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)), Integer.valueOf(-2147483648));
    }
    if (jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return new Pair(Integer.valueOf(-2147483648), jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
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
    int j = -2147483648;
    int i;
    if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramString)) {
      i = 2130840552;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      if (AppConstants.MSG_BOX_INTERACT_UIN.equals(paramString))
      {
        i = 2130845784;
      }
      else if (AppConstants.MSG_BOX_FOLLOW_UIN.equals(paramString))
      {
        i = 2130845783;
      }
      else if (AppConstants.MSG_BOX_MYMOMMENT_UIN.equals(paramString))
      {
        i = 2130845785;
      }
      else if (AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN.equals(paramString))
      {
        i = 2130845782;
      }
      else if (AppConstants.MSG_BOX_YANZHI_UIN.equals(paramString))
      {
        i = 2130845786;
      }
      else
      {
        j = 32;
        i = -2147483648;
      }
    }
  }
  
  private Drawable b(int paramInt, String paramString)
  {
    if (TempChatPluginManager.a.contains(Integer.valueOf(paramInt)))
    {
      AbstractTempChatPlugin localAbstractTempChatPlugin = ((TempChatPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(paramInt);
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
      if ((paramString != null) && (paramString.a() != null)) {}
      for (paramString = paramString.a();; paramString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplication.getContext(), 3)) {
        return ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
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
    int k = 2130845117;
    int j = -2147483648;
    int i;
    switch (paramInt)
    {
    default: 
      paramInt = -2147483648;
      i = j;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(i), Integer.valueOf(paramInt));
      HotChatManager localHotChatManager = paramQQAppInterface.getHotChatMng(false);
      HotChatCenterManager localHotChatCenterManager = (HotChatCenterManager)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
      if ((localHotChatCenterManager != null) && (localHotChatCenterManager.a(paramString))) {
        paramInt = 1;
      }
      for (;;)
      {
        if (((localHotChatManager != null) && (localHotChatManager.b(paramString))) || (paramInt != 0))
        {
          if (paramInt != 0)
          {
            paramInt = 2130838645;
            i = j;
            break;
            paramInt = 0;
            continue;
          }
          paramInt = HotChatManager.a(paramString, paramQQAppInterface);
          i = j;
          break;
        }
      }
      if (TroopUtils.a(paramString))
      {
        i = 4;
        paramInt = -2147483648;
      }
      else
      {
        i = 113;
        paramInt = -2147483648;
        continue;
        if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString))
        {
          paramInt = 2130840558;
          i = j;
        }
        else
        {
          i = 103;
          paramInt = -2147483648;
          continue;
          i = 104;
          paramInt = 2130839706;
          continue;
          i = 106;
          paramInt = 2130847401;
          continue;
          if (TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon())) {}
          for (paramInt = ServiceAccountFolderManager.a();; paramInt = 2147483647)
          {
            i = 112;
            break;
          }
          paramInt = k;
          i = j;
          if (!TextUtils.equals(paramString, AppConstants.CONFESS_UIN))
          {
            paramInt = k;
            i = j;
            if (TextUtils.equals(paramString, AppConstants.CONFESS_FRD_REC_UIN))
            {
              paramInt = 2130845118;
              i = j;
            }
          }
        }
      }
    }
  }
  
  private static Pair<Integer, Integer> b(String paramString)
  {
    int i = 2130840559;
    int k = -2147483648;
    int j;
    if (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(paramString)) {
      j = k;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      j = k;
      if (!String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(paramString)) {
        if (String.valueOf(AppConstants.SAME_STATE_BOX_UIN).equals(paramString))
        {
          i = 2130840562;
          j = k;
        }
        else if (AppConstants.VOTE_MSG_UIN.equals(paramString))
        {
          i = 2130840711;
          j = k;
        }
        else if (AppConstants.NEW_KANDIAN_UIN.equals(paramString))
        {
          j = 110;
          i = -2147483648;
        }
        else
        {
          j = 1;
          i = -2147483648;
        }
      }
    }
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
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1033), Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1044), Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1045), Integer.valueOf(1));
  }
  
  private static void d()
  {
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6000), Integer.valueOf(2130844376));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6003), Integer.valueOf(2130844371));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(4000), Integer.valueOf(2130840547));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9002), Integer.valueOf(2130844849));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(5000), Integer.valueOf(2130840560));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(5001), Integer.valueOf(2130842748));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(7200), Integer.valueOf(2130840555));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9000), Integer.valueOf(2130840559));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9503), Integer.valueOf(2130840556));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(9999), Integer.valueOf(2130839735));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(1031), Integer.valueOf(2130840535));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(6004), Integer.valueOf(2130851006));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(10011), Integer.valueOf(2130851004));
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(10012), Integer.valueOf(2130840272));
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
    Pair localPair = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString);
    int i = ((Integer)localPair.first).intValue();
    int j = ((Integer)localPair.second).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable uintype = " + paramInt + ", uin = " + paramString + ", isGetResFace = " + paramBoolean + ", faceType = " + i + ", faceResId = " + j);
    }
    if (j == 2147483647) {}
    try
    {
      paramString = a(i, paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = localDrawable;
    }
    if (i != -2147483648) {
      paramString = a(paramString, i);
    } else if ((j != -2147483648) && (paramBoolean)) {
      paramString = BaseApplication.getContext().getResources().getDrawable(j);
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
    if (paramRecentBaseData.getRecentUserType() == 8)
    {
      i = paramRecentBaseData.mExtraType;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "getFaceDrawable type = " + i);
      }
      if (i != 0) {
        if (i == 25)
        {
          localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
          if (localObject == null) {
            break label415;
          }
        }
      }
    }
    label415:
    for (Object localObject = ((PhoneContactManager)localObject).c(paramRecentBaseData.mPhoneNumber);; localObject = null)
    {
      if (localObject != null)
      {
        localObject = FaceDrawable.getMobileFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.mPhoneNumber, (byte)3);
        paramRecentBaseData = (RecentBaseData)localObject;
        if (localObject == null) {
          paramRecentBaseData = ImageUtil.c();
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentFaceDecoder", 2, "getFaceDrawable end");
        }
        return paramRecentBaseData;
        paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(16, paramRecentBaseData.getRecentUserUin(), (byte)3, true, 16);
        if (paramRecentBaseData == null)
        {
          paramRecentBaseData = ImageUtil.c();
        }
        else
        {
          paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
          continue;
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramRecentBaseData.getRecentUserUin(), (byte)3, true);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = ImageUtil.c();
          }
          else
          {
            paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
            continue;
            paramRecentBaseData = a(i, paramRecentBaseData.getRecentUserUin());
            continue;
            if (j == 26)
            {
              paramRecentBaseData = OpenSDKUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin());
            }
            else if (j == 1034)
            {
              j = 2130845099;
              i = j;
              if ((paramRecentBaseData instanceof RecentItemConfessMsg))
              {
                i = j;
                if (((RecentItemConfessMsg)paramRecentBaseData).mConfessInfo.confessorSex == 1) {
                  i = 2130845100;
                }
              }
              paramRecentBaseData = BaseApplication.getContext().getResources().getDrawable(i);
            }
            else if (ImaxAdUtil.a(j, paramRecentBaseData))
            {
              paramRecentBaseData = a(114, ((RecentItemImaxADData)paramRecentBaseData).mHeaderUrl);
            }
            else if (j == 10007)
            {
              paramRecentBaseData = GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin());
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
          }
        }
      }
    }
  }
  
  public Drawable a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable facetype = " + paramInt + ", uin = " + paramString);
    }
    Object localObject2 = b(paramString, paramInt);
    if (localObject2 != null) {
      return localObject2;
    }
    if (this.jdField_a_of_type_Boolean)
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
    if (paramInt == 103) {}
    for (int i = 1;; i = paramInt)
    {
      Object localObject1 = null;
      int j;
      if (NearbyCardManager.a(paramString))
      {
        j = 202;
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
        {
          if (paramInt != 32) {
            break label323;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(i, paramString, j);
        }
        label167:
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("requestDecodeFace| [").append(paramString).append(",").append(paramInt).append(",").append(localObject1).append("], isPausing=");
          if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
            break label339;
          }
          localObject2 = "null";
          label231:
          QLog.i("Q.recent", 4, localObject2);
        }
        if (localObject1 != null) {
          break label410;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()))
        {
          if (i != 32) {
            break label356;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeStrangeFace(paramString, j, true, false);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 2");
        }
        return a(paramInt);
        j = 200;
        break;
        label323:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(i, paramString);
        break label167;
        label339:
        localObject2 = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing());
        break label231;
        label356:
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, i, true, (byte)0);
        if ((i == 1001) && (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(101, paramString) == null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 101, true, (byte)0);
        }
      }
      label410:
      if (paramInt == 103)
      {
        localObject2 = BaseApplication.getContext().getResources().getDrawable(2130840542);
        if ((localObject2 instanceof SkinnableBitmapDrawable)) {
          ((SkinnableBitmapDrawable)localObject2).setGravity(81);
        }
        if ((localObject2 instanceof BitmapDrawable)) {
          ((BitmapDrawable)localObject2).setGravity(81);
        }
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      }
      for (localObject1 = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1), localObject2 });; localObject1 = new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1))
      {
        localObject2 = localObject1;
        if (!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramString)) {
          break;
        }
        return KandianSubscribeManager.a((Drawable)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  public Drawable a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    paramString1 = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, (byte)3);
    try
    {
      QLog.d("RecentFaceDecoder", 2, "getAppletsFolderDrawable width = " + paramInt1 + ", height = " + paramInt2 + ", url = " + paramString2 + ", urlSimple = " + paramString3);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = AIOUtils.a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources());
      localURLDrawableOptions.mRequestHeight = AIOUtils.a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getResources());
      localURLDrawableOptions.mLoadingDrawable = paramString1;
      localURLDrawableOptions.mFailedDrawable = paramString1;
      if (QQTheme.e())
      {
        if (!TextUtils.isEmpty(paramString3))
        {
          paramInt1 = Math.min(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight);
          paramString3 = URLDrawable.getDrawable(paramString3, localURLDrawableOptions);
          paramString3.setTag(new int[] { paramInt1, paramInt1, (int)(paramInt1 * 0.07142858F) });
          paramString3.setDecodeHandler(URLDrawableDecodeHandler.j);
          return paramString3;
        }
      }
      else if (!TextUtils.isEmpty(paramString2))
      {
        paramString3 = URLDrawable.getDrawable(paramString2, localURLDrawableOptions);
        return paramString3;
      }
    }
    catch (Exception paramString3)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentFaceDecoder", 2, "getAppletsFolderDrawable illegal url format: " + paramString2);
      }
    }
    return paramString1;
  }
  
  public URLDrawable a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1000: 
      paramString = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
      localDrawable = ImageUtil.a();
      return URLDrawable.getDrawable(paramString.iconUrl, localDrawable, localDrawable);
    case 112: 
      paramString = BaseApplicationImpl.sApplication.getResources().getDrawable(ServiceAccountFolderManager.a());
      return URLDrawable.getDrawable(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon(), paramString, paramString);
    }
    Drawable localDrawable = ImageUtil.c();
    paramString = URLDrawable.getDrawable(paramString, localDrawable, localDrawable);
    paramString.setDecodeHandler(URLDrawableDecodeHandler.a);
    return paramString;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setAppRuntime(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void b()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentFaceDecoder
 * JD-Core Version:    0.7.0.1
 */