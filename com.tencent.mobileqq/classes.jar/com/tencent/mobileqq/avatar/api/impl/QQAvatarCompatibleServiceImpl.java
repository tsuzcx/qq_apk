package com.tencent.mobileqq.avatar.api.impl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.face.FaceConstant.HeadConfig;
import com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QQAvatarCompatibleServiceImpl
  implements IQQAvatarCompatibleService
{
  private static final int MAX_TRY_COUNT = 3;
  public static final String QQ_HEAD_QAIF = "Q.qqhead.qaif";
  private Object faceDecodeFailMapLock = new Object();
  private AppInterface mApp;
  private HashMap<String, Integer> mFaceDecodeFailMap;
  
  private void freePartBitmapCache()
  {
    if (GlobalImageCache.a != null)
    {
      int i = GlobalImageCache.a.size() * 3 / 4;
      GlobalImageCache.a.trimToSize(i);
    }
  }
  
  private void getBitmapFromNet(int paramInt1, String paramString, byte paramByte, boolean paramBoolean1, int paramInt2, Bitmap paramBitmap, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    if (((paramBitmap == null) && (paramBoolean1) && (!paramBoolean3)) || (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.", 2, "getFaceBitmap needUpdate, faceType=" + paramInt1 + ", uin=" + paramString + ", shape=" + paramByte);
      }
      if (!paramBoolean3) {
        break label153;
      }
    }
    label153:
    for (byte b = 1;; b = 2)
    {
      paramBitmap = (IQQAvatarHandlerService)this.mApp.getRuntimeService(IQQAvatarHandlerService.class, "");
      switch (paramInt1)
      {
      default: 
        return;
      }
    }
    paramBitmap.getMobileQQHead(paramString, b);
    return;
    paramBitmap.getTroopHead(paramString, b);
    return;
    paramBitmap.getCustomHead(paramString, (byte)0, b);
    return;
    paramBitmap.getStrangerHead(paramString, paramInt2, (byte)1, b);
    return;
    paramBitmap.getQCallHead(paramString, paramInt2, (byte)1, b);
    return;
    paramBitmap.getApolloHead(paramString, (byte)1, b, paramInt3);
  }
  
  private boolean isGetFaceBitmapParamInValid(int paramInt, String paramString)
  {
    return ((paramInt == 11) && (!StringUtil.d(paramString))) || (TextUtils.isEmpty(paramString));
  }
  
  private boolean isSpecialFaceType(int paramInt, String paramString)
  {
    return (paramInt == 1) && (paramString != null) && ((paramString.equals(AppConstants.QQBROADCAST_MSG_UIN)) || (paramString.equals(AppConstants.LBS_HELLO_UIN)) || (paramString.equals(AppConstants.VOTE_MSG_UIN)) || (paramString.equals(AppConstants.SYSTEM_MSG_UIN)));
  }
  
  private Bitmap realGetFaceBitmap(int paramInt1, String paramString, byte paramByte1, int paramInt2, boolean paramBoolean, byte paramByte2, int paramInt3)
  {
    QQAvatarDataServiceImpl localQQAvatarDataServiceImpl = (QQAvatarDataServiceImpl)this.mApp.getRuntimeService(IQQAvatarDataService.class, "");
    String str1 = localQQAvatarDataServiceImpl.getFaceBitmapCacheKey(paramInt1, paramString, paramByte1, paramInt3, paramInt2, false);
    Object localObject1 = localQQAvatarDataServiceImpl.getBitmapFromCache(str1);
    paramByte2 = 0;
    boolean bool1;
    String str2;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult;
    boolean bool2;
    label218:
    Bitmap localBitmap;
    if (localObject1 == null) {
      if ((paramBoolean) || (paramInt1 == 116))
      {
        localObject1 = localQQAvatarDataServiceImpl.getQQHeadSetting(paramInt1, paramString, paramInt3);
        bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
        if (((Pair)localObject1).second != null)
        {
          paramByte2 = ((Setting)((Pair)localObject1).second).bHeadType;
          str2 = localQQAvatarDataServiceImpl.getCustomFaceFilePath(paramInt1, paramString, paramInt3, paramInt2);
          localBitmapDecodeResult = decodeFace(str2);
          if (localBitmapDecodeResult.jdField_a_of_type_Int != 0) {
            QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decodeFile fail, faceType=" + paramInt1 + ", uin=" + paramString + ", result=" + localBitmapDecodeResult.jdField_a_of_type_Int + ", facePath=" + str2);
          }
          if ((!bool1) && (localBitmapDecodeResult.jdField_a_of_type_Int == 1)) {
            return null;
          }
          if (localBitmapDecodeResult.jdField_a_of_type_Int != 2)
          {
            bool2 = true;
            localBitmap = localBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap;
            if ((localBitmap == null) && (localBitmapDecodeResult.jdField_a_of_type_Int != 1) && (bool2))
            {
              if (paramInt1 != 4) {
                break label491;
              }
              localObject1 = "troop_" + paramString;
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.faceDecodeFailMapLock)
      {
        if (this.mFaceDecodeFailMap == null) {
          this.mFaceDecodeFailMap = new HashMap();
        }
        Integer localInteger = (Integer)this.mFaceDecodeFailMap.get(localObject1);
        if (localInteger == null)
        {
          i = 0;
          QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + (String)localObject1 + ", nDecodeFailCount = " + i);
          if (i < 3)
          {
            i += 1;
            this.mFaceDecodeFailMap.put(localObject1, Integer.valueOf(i));
            FileUtils.e(str2);
            QLog.i("Q.qqhead.qaif", 1, "getFaceBitmap|file is damaged, key = " + (String)localObject1 + ", del the damaged file,nDecodeFailCount=" + i);
          }
          localObject1 = localQQAvatarDataServiceImpl.putSdcardBitmapToCache(paramInt1, paramString, paramByte1, str1, localBitmap, str2, localBitmapDecodeResult, paramByte2);
          getBitmapFromNet(paramInt1, paramString, paramByte1, paramBoolean, paramInt3, (Bitmap)localObject1, bool1, bool2, paramInt2);
          return localObject1;
          bool2 = false;
          break label218;
        }
        int i = localInteger.intValue();
      }
      label491:
      localObject1 = paramString;
      continue;
      break;
      bool1 = false;
      break;
      bool2 = false;
      bool1 = false;
    }
  }
  
  @NonNull
  public BitmapManager.BitmapDecodeResult decodeFace(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = FaceConstant.HeadConfig.FACE_BITMAP_CONFIG;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    int i = 0;
    do
    {
      BitmapManager.a(paramString, localOptions, localBitmapDecodeResult);
      if (localBitmapDecodeResult.jdField_a_of_type_Int == 1) {
        freePartBitmapCache();
      }
      i += 1;
    } while ((i < 2) && (localBitmapDecodeResult.jdField_a_of_type_Int == 1));
    return localBitmapDecodeResult;
  }
  
  public Bitmap getFaceBitmap(int paramInt1, String paramString, byte paramByte1, int paramInt2, boolean paramBoolean, byte paramByte2, int paramInt3)
  {
    if (isSpecialFaceType(paramInt1, paramString)) {
      return BaseImageUtil.d();
    }
    if ((paramInt1 == 32) && (AppConstants.LBS_HELLO_UIN.equals(paramString))) {
      return SkinUtils.a(BaseApplication.getContext().getResources().getDrawable(2130840554));
    }
    if (isGetFaceBitmapParamInValid(paramInt1, paramString)) {
      return null;
    }
    if ((paramInt1 == 101) || (paramInt1 == 1001)) {
      paramByte1 = 3;
    }
    for (;;)
    {
      if ((paramInt1 == 4) && (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(paramString))) {
        paramInt1 = 113;
      }
      for (;;)
      {
        if (paramInt1 == 113) {
          paramByte1 = 3;
        }
        for (;;)
        {
          return realGetFaceBitmap(paramInt1, paramString, AvatarUtil.a(paramByte1), paramInt2, paramBoolean, paramByte2, paramInt3);
        }
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarCompatibleServiceImpl
 * JD-Core Version:    0.7.0.1
 */