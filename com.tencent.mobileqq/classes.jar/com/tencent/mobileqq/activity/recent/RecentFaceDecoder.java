package com.tencent.mobileqq.activity.recent;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class RecentFaceDecoder
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener;
  public FaceDecoder a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface, FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this(paramQQAppInterface, paramDecodeTaskCompletionListener, false);
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface, FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(BaseApplication.getContext(), paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramDecodeTaskCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramBoolean;
  }
  
  private Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ImageUtil.b();
    case 4: 
    case 113: 
      return ImageUtil.c();
    case 101: 
    case 1001: 
      return ImageUtil.e();
    case 11: 
      return ImageUtil.b();
    case 102: 
      return ImageUtil.b(102);
    case 107: 
      return ImageUtil.b(107);
    case 103: 
      return ImageUtil.f();
    }
    return ImageUtil.b();
  }
  
  public static Pair a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int k = -2147483648;
    int m = 2130839203;
    int n = 1;
    int i = m;
    int j = k;
    switch (paramInt)
    {
    default: 
      i = -2147483648;
      j = k;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      i = m;
      j = k;
      if (!String.valueOf(AppConstants.F).equals(paramString))
      {
        i = m;
        j = k;
        if (!String.valueOf(AppConstants.H).equals(paramString)) {
          if (String.valueOf(AppConstants.v).equals(paramString))
          {
            i = 2130839206;
            j = k;
          }
          else if (AppConstants.D.equals(paramString))
          {
            i = 2130839279;
            j = k;
          }
          else if (AppConstants.ar.equals(paramString))
          {
            j = 110;
            i = -2147483648;
          }
          else
          {
            i = -2147483648;
            j = 1;
            continue;
            if (String.valueOf(AppConstants.G).equals(paramString))
            {
              i = 2130839197;
              j = k;
            }
            else if (AppConstants.ag.equals(paramString))
            {
              i = 2130842720;
              j = k;
            }
            else if (AppConstants.ah.equals(paramString))
            {
              i = 2130842719;
              j = k;
            }
            else
            {
              j = 32;
              i = -2147483648;
              continue;
              j = 102;
              i = 2130841551;
              continue;
              j = 107;
              i = 2130841549;
              continue;
              i = -2147483648;
              j = 104;
              continue;
              j = 11;
              i = -2147483648;
              continue;
              j = 101;
              i = -2147483648;
              continue;
              j = 1001;
              i = -2147483648;
              continue;
              HotChatManager localHotChatManager = paramQQAppInterface.a(false);
              HotChatCenterManager localHotChatCenterManager = (HotChatCenterManager)paramQQAppInterface.getManager(254);
              if ((localHotChatCenterManager != null) && (localHotChatCenterManager.a(paramString))) {
                paramInt = n;
              }
              for (;;)
              {
                if (((localHotChatManager != null) && (localHotChatManager.b(paramString))) || (paramInt != 0))
                {
                  if (paramInt != 0)
                  {
                    i = 2130838079;
                    j = k;
                    break;
                    paramInt = 0;
                    continue;
                  }
                  i = HotChatManager.a(paramString, paramQQAppInterface);
                  j = k;
                  break;
                }
              }
              if (TroopUtils.a(paramString))
              {
                j = 4;
                i = -2147483648;
              }
              else
              {
                j = 113;
                i = -2147483648;
                continue;
                i = 2130839196;
                j = k;
                continue;
                i = 2130842116;
                j = k;
                continue;
                i = 2130839204;
                j = k;
                continue;
                i = 2130840590;
                j = k;
                continue;
                if (AppConstants.w.equals(paramString))
                {
                  i = 2130839202;
                  j = k;
                }
                else
                {
                  j = 103;
                  i = -2147483648;
                  continue;
                  i = 2130839199;
                  j = k;
                  continue;
                  i = 2130838726;
                  j = 104;
                  continue;
                  j = 108;
                  i = -2147483648;
                  continue;
                  j = 105;
                  i = -2147483648;
                  continue;
                  j = 111;
                  i = -2147483648;
                  continue;
                  j = 106;
                  i = 2130843784;
                  continue;
                  if (TextUtils.isEmpty(PublicAccountConfigUtil.g)) {}
                  for (i = ServiceAccountFolderManager.a();; i = 2147483647)
                  {
                    j = 112;
                    break;
                  }
                  i = 2130839200;
                  j = k;
                  continue;
                  i = 2130838762;
                  j = k;
                  continue;
                  i = 2130839189;
                  j = k;
                  continue;
                  i = ((ChangeMachineManager)paramQQAppInterface.getManager(182)).a();
                  j = k;
                  continue;
                  if (TextUtils.equals(paramString, AppConstants.aE))
                  {
                    i = 2130842340;
                    j = k;
                  }
                  else if (TextUtils.equals(paramString, AppConstants.aF))
                  {
                    i = 2130842341;
                    j = k;
                  }
                  else
                  {
                    i = 2130842340;
                    j = k;
                    continue;
                    i = -2147483648;
                    j = 1;
                    continue;
                    i = 2130846070;
                    j = k;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, true);
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean)
  {
    Pair localPair = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString);
    int i = ((Integer)localPair.first).intValue();
    int j = ((Integer)localPair.second).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable uintype = " + paramInt + ", uin = " + paramString + ", isGetResFace = " + paramBoolean + ", faceType = " + i + ", faceResId = " + j);
    }
    if (j == 2147483647) {}
    try
    {
      return a(i, paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    if (i != -2147483648) {
      return a(paramString, i);
    }
    if ((j != -2147483648) && (paramBoolean))
    {
      paramString = BaseApplication.getContext().getResources().getDrawable(j);
      return paramString;
    }
    return null;
  }
  
  public Drawable a(RecentBaseData paramRecentBaseData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable start");
    }
    int j = paramRecentBaseData.a();
    int i;
    if (paramRecentBaseData.a() == 8)
    {
      i = paramRecentBaseData.g;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "getFaceDrawable type = " + i);
      }
      if (i != 0) {
        if (i == 25)
        {
          localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
          if (localObject == null) {
            break label390;
          }
        }
      }
    }
    label390:
    for (Object localObject = ((PhoneContactManager)localObject).c(paramRecentBaseData.f);; localObject = null)
    {
      if (localObject != null)
      {
        localObject = FaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.f, (byte)3);
        paramRecentBaseData = (RecentBaseData)localObject;
        if (localObject == null) {
          paramRecentBaseData = ImageUtil.b();
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentFaceDecoder", 2, "getFaceDrawable end");
        }
        return paramRecentBaseData;
        paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16, paramRecentBaseData.a(), (byte)3, true, 16);
        if (paramRecentBaseData == null)
        {
          paramRecentBaseData = ImageUtil.b();
        }
        else
        {
          paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
          continue;
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramRecentBaseData.a(), (byte)3, true);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = ImageUtil.b();
          }
          else
          {
            paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
            continue;
            paramRecentBaseData = a(i, paramRecentBaseData.a());
            continue;
            if (j == 26)
            {
              paramRecentBaseData = OpenSDKUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.a());
            }
            else if (j == 1034)
            {
              j = 2130842338;
              i = j;
              if ((paramRecentBaseData instanceof RecentItemConfessMsg))
              {
                i = j;
                if (((RecentItemConfessMsg)paramRecentBaseData).a.confessorSex == 1) {
                  i = 2130842339;
                }
              }
              paramRecentBaseData = BaseApplication.getContext().getResources().getDrawable(i);
            }
            else if (ImaxAdUtil.a(j, paramRecentBaseData))
            {
              paramRecentBaseData = a(114, ((RecentItemImaxADData)paramRecentBaseData).g);
            }
            else
            {
              localObject = paramRecentBaseData.a();
              i = j;
              if ((paramRecentBaseData instanceof RecentCallItem))
              {
                i = j;
                if (((RecentCallItem)paramRecentBaseData).b()) {
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
    if (paramInt == 104) {
      return DeviceHeadMgr.getInstance().getDeviceHeadDrawableByDin(paramString);
    }
    if (paramInt == 105)
    {
      paramString = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 1);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return PublicAccountConfigUtil.a(BaseApplication.getContext(), 1);
    }
    if (paramInt == 111)
    {
      paramString = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 3);
      if ((paramString != null) && (paramString.a() != null)) {}
      for (paramString = paramString.a();; paramString = PublicAccountConfigUtil.a(BaseApplication.getContext(), 3)) {
        return ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
    }
    if (paramInt == 106) {
      return EcShopAssistantManager.a(BaseApplication.getContext());
    }
    if (paramInt == 108) {
      return ((BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137)).a();
    }
    if (paramInt == 110)
    {
      paramString = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 2);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return PublicAccountConfigUtil.a(BaseApplication.getContext(), 2);
    }
    if (paramInt == 112) {
      return BaseApplicationImpl.sApplication.getResources().getDrawable(ServiceAccountFolderManager.a());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString, false, 0);
      return null;
    }
    if ((this.b) && (!this.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 1");
      }
      return a(paramInt);
    }
    if (paramInt == 103) {}
    for (int i = 1;; i = paramInt)
    {
      Bitmap localBitmap;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
        if (paramInt == 32) {
          localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramString, 200);
        }
      }
      for (;;)
      {
        Object localObject;
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("requestDecodeFace| [").append(paramString).append(",").append(paramInt).append(",").append(localBitmap).append("], isPausing=");
          if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null)
          {
            localObject = "null";
            label403:
            QLog.i("Q.recent", 4, localObject);
          }
        }
        else
        {
          if (localBitmap != null) {
            break label560;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()))
          {
            if (i != 32) {
              break label512;
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 200, true, false);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 2");
          }
          return a(paramInt);
          localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramString);
          break;
          localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a());
          break label403;
          label512:
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, i, true, (byte)0);
          if ((i == 1001) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(101, paramString) == null)) {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 101, true, (byte)0);
          }
        }
        label560:
        if (paramInt == 103)
        {
          paramString = BaseApplication.getContext().getResources().getDrawable(2130839192);
          if ((paramString instanceof SkinnableBitmapDrawable)) {
            ((SkinnableBitmapDrawable)paramString).setGravity(81);
          }
          if ((paramString instanceof BitmapDrawable)) {
            ((BitmapDrawable)paramString).setGravity(81);
          }
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          return new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), localBitmap), paramString });
        }
        return new BitmapDrawable(BaseApplication.getContext().getResources(), localBitmap);
        localBitmap = null;
      }
    }
  }
  
  public URLDrawable a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1000: 
      paramString = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramString);
      localDrawable = ImageUtil.c();
      return URLDrawable.getDrawable(paramString.iconUrl, localDrawable, localDrawable);
    case 112: 
      paramString = BaseApplicationImpl.sApplication.getResources().getDrawable(ServiceAccountFolderManager.a());
      return URLDrawable.getDrawable(PublicAccountConfigUtil.g, paramString, paramString);
    }
    Drawable localDrawable = ImageUtil.b();
    paramString = URLDrawable.getDrawable(paramString, localDrawable, localDrawable);
    paramString.setDecodeHandler(URLDrawableDecodeHandler.a);
    return paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void b()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentFaceDecoder
 * JD-Core Version:    0.7.0.1
 */