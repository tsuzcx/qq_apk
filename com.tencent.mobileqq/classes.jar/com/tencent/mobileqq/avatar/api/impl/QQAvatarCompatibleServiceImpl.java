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
      paramBoolean1 = QLog.isColorLevel();
      byte b = 2;
      if (paramBoolean1)
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("getFaceBitmap needUpdate, faceType=");
        paramBitmap.append(paramInt1);
        paramBitmap.append(", uin=");
        paramBitmap.append(paramString);
        paramBitmap.append(", shape=");
        paramBitmap.append(paramByte);
        QLog.i("Q.qqhead.", 2, paramBitmap.toString());
      }
      if (paramBoolean3) {
        b = 1;
      }
      paramBitmap = (IQQAvatarHandlerService)this.mApp.getRuntimeService(IQQAvatarHandlerService.class, "");
      if (paramInt1 != 1)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 11)
          {
            if (paramInt1 != 16)
            {
              if (paramInt1 != 32)
              {
                if (paramInt1 != 116) {
                  return;
                }
                paramBitmap.getApolloHead(paramString, (byte)1, b, paramInt3);
                return;
              }
              paramBitmap.getStrangerHead(paramString, paramInt2, (byte)1, b);
              return;
            }
            paramBitmap.getQCallHead(paramString, paramInt2, (byte)1, b);
            return;
          }
          paramBitmap.getMobileQQHead(paramString, b);
          return;
        }
        paramBitmap.getTroopHead(paramString, b);
        return;
      }
      paramBitmap.getCustomHead(paramString, (byte)0, b);
    }
  }
  
  private boolean isGetFaceBitmapParamInValid(int paramInt, String paramString)
  {
    return ((paramInt == 11) && (!StringUtil.d(paramString))) || (TextUtils.isEmpty(paramString));
  }
  
  private boolean isSpecialFaceType(int paramInt, String paramString)
  {
    boolean bool2 = true;
    if ((paramInt == 1) && (paramString != null))
    {
      bool1 = bool2;
      if (paramString.equals(AppConstants.QQBROADCAST_MSG_UIN)) {
        return bool1;
      }
      bool1 = bool2;
      if (paramString.equals(AppConstants.LBS_HELLO_UIN)) {
        return bool1;
      }
      bool1 = bool2;
      if (paramString.equals(AppConstants.VOTE_MSG_UIN)) {
        return bool1;
      }
      if (paramString.equals(AppConstants.SYSTEM_MSG_UIN)) {
        return true;
      }
    }
    boolean bool1 = false;
    return bool1;
  }
  
  private Bitmap realGetFaceBitmap(int paramInt1, String paramString, byte paramByte1, int paramInt2, boolean paramBoolean, byte paramByte2, int paramInt3)
  {
    QQAvatarDataServiceImpl localQQAvatarDataServiceImpl = (QQAvatarDataServiceImpl)this.mApp.getRuntimeService(IQQAvatarDataService.class, "");
    String str1 = localQQAvatarDataServiceImpl.getFaceBitmapCacheKey(paramInt1, paramString, paramByte1, paramInt3, paramInt2, false);
    Object localObject1 = localQQAvatarDataServiceImpl.getBitmapFromCache(str1);
    boolean bool1;
    boolean bool2;
    if (localObject1 == null)
    {
      if ((!paramBoolean) && (paramInt1 != 116))
      {
        paramByte2 = 0;
        bool1 = false;
      }
      else
      {
        localObject1 = localQQAvatarDataServiceImpl.getQQHeadSetting(paramInt1, paramString, paramInt3);
        bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
        if (((Pair)localObject1).second != null) {
          paramByte2 = ((Setting)((Pair)localObject1).second).bHeadType;
        } else {
          paramByte2 = 0;
        }
      }
      String str2 = localQQAvatarDataServiceImpl.getCustomFaceFilePath(paramInt1, paramString, paramInt3, paramInt2);
      BitmapManager.BitmapDecodeResult localBitmapDecodeResult = decodeFace(str2);
      if (localBitmapDecodeResult.jdField_a_of_type_Int != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFaceBitmap decodeFile fail, faceType=");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(", uin=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", result=");
        ((StringBuilder)localObject1).append(localBitmapDecodeResult.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(", facePath=");
        ((StringBuilder)localObject1).append(str2);
        QLog.i("Q.qqhead.qaif", 2, ((StringBuilder)localObject1).toString());
      }
      if ((!bool1) && (localBitmapDecodeResult.jdField_a_of_type_Int == 1)) {
        return null;
      }
      if (localBitmapDecodeResult.jdField_a_of_type_Int != 2) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      Bitmap localBitmap = localBitmapDecodeResult.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localBitmap == null) && (localBitmapDecodeResult.jdField_a_of_type_Int != 1) && (bool2))
      {
        if (paramInt1 == 4)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("troop_");
          ((StringBuilder)localObject1).append(paramString);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = paramString;
        }
        synchronized (this.faceDecodeFailMapLock)
        {
          if (this.mFaceDecodeFailMap == null) {
            this.mFaceDecodeFailMap = new HashMap();
          }
          Object localObject3 = (Integer)this.mFaceDecodeFailMap.get(localObject1);
          int i;
          if (localObject3 == null) {
            i = 0;
          } else {
            i = ((Integer)localObject3).intValue();
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getFaceBitmap|file is damaged, key = ");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(", nDecodeFailCount = ");
          ((StringBuilder)localObject3).append(i);
          QLog.i("Q.qqhead.qaif", 1, ((StringBuilder)localObject3).toString());
          if (i < 3)
          {
            i += 1;
            this.mFaceDecodeFailMap.put(localObject1, Integer.valueOf(i));
            FileUtils.deleteFile(str2);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getFaceBitmap|file is damaged, key = ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(", del the damaged file,nDecodeFailCount=");
            ((StringBuilder)localObject3).append(i);
            QLog.i("Q.qqhead.qaif", 1, ((StringBuilder)localObject3).toString());
          }
        }
      }
      localObject1 = localQQAvatarDataServiceImpl.putSdcardBitmapToCache(paramInt1, paramString, paramByte1, str1, localBitmap, str2, localBitmapDecodeResult, paramByte2);
    }
    else
    {
      bool1 = false;
      bool2 = false;
    }
    getBitmapFromNet(paramInt1, paramString, paramByte1, paramBoolean, paramInt3, (Bitmap)localObject1, bool1, bool2, paramInt2);
    return localObject1;
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
      return BaseImageUtil.g();
    }
    if ((paramInt1 == 32) && (AppConstants.LBS_HELLO_UIN.equals(paramString))) {
      return SkinUtils.a(BaseApplication.getContext().getResources().getDrawable(2130840423));
    }
    if (isGetFaceBitmapParamInValid(paramInt1, paramString)) {
      return null;
    }
    if ((paramInt1 != 101) && (paramInt1 != 1001)) {
      break label77;
    }
    paramByte1 = 3;
    label77:
    if ((paramInt1 == 4) && (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(paramString))) {
      paramInt1 = 113;
    }
    if (paramInt1 == 113) {
      paramByte1 = 3;
    }
    return realGetFaceBitmap(paramInt1, paramString, AvatarUtil.a(paramByte1), paramInt2, paramBoolean, paramByte2, paramInt3);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarCompatibleServiceImpl
 * JD-Core Version:    0.7.0.1
 */