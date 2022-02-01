package com.tencent.biz.subscribe.comment;

import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceConstant.HeadConfig;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterfaceUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.MD5;

public class LocalHeadFetchUtils
{
  public static Pair<Boolean, Setting> a(int paramInt1, String paramString, int paramInt2)
  {
    String str = QQAppInterface.getFaceSettingKey(paramInt1, paramString, paramInt2);
    paramString = QQEntityManagerFactoryProxy.a(paramString).createEntityManager();
    if ((!TextUtils.isEmpty(str)) && (paramString != null)) {
      paramString = (Setting)paramString.find(Setting.class, str);
    } else {
      paramString = null;
    }
    if (paramString == null) {
      return new Pair(Boolean.valueOf(true), paramString);
    }
    boolean bool = false;
    if (((paramInt1 == 1) || (paramInt1 == 4) || (paramInt1 == 11) || (paramInt1 == 16) || (paramInt1 == 32)) && ((paramString == null) || (System.currentTimeMillis() - paramString.updateTimestamp > 86400000L))) {
      bool = true;
    }
    return new Pair(Boolean.valueOf(bool), paramString);
  }
  
  public static BitmapManager.BitmapDecodeResult a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = FaceConstant.HeadConfig.FACE_BITMAP_CONFIG;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    int i = 0;
    do
    {
      BitmapManager.a(paramString, localOptions, localBitmapDecodeResult);
      if (localBitmapDecodeResult.b == 1) {
        NearbyAppInterfaceUtils.a();
      }
      i += 1;
    } while ((i < 2) && (localBitmapDecodeResult.b == 1));
    return localBitmapDecodeResult;
  }
  
  public static String a(Setting paramSetting, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = paramSetting;
    if (paramSetting == null)
    {
      localObject = paramSetting;
      if (paramString != null)
      {
        localObject = paramSetting;
        if (paramInt1 != 101)
        {
          localObject = paramSetting;
          if (paramInt1 != 1001) {
            localObject = (Setting)a(paramInt1, paramString, paramInt2).second;
          }
        }
      }
    }
    paramSetting = new StringBuilder(256);
    if (paramInt1 == 32)
    {
      if (SystemUtil.a()) {
        paramSetting.append(AppConstants.PATH_HEAD_STRANGER);
      } else {
        paramSetting.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
      }
    }
    else if (SystemUtil.a()) {
      paramSetting.append(AppConstants.PATH_HEAD_HD);
    } else {
      paramSetting.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
    }
    localObject = a((Setting)localObject, paramString, paramInt1);
    paramInt1 = ((Integer)localObject[0]).intValue();
    if (paramInt1 != -56)
    {
      if (paramInt1 != -55)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 16)
          {
            if (paramInt1 != 32)
            {
              if (paramInt1 != 101)
              {
                if (paramInt1 != 113)
                {
                  if (paramInt1 == 1001)
                  {
                    paramSetting.append("dis_pstn_g_");
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append(paramString);
                    ((StringBuilder)localObject).append(paramString);
                    paramString = ((StringBuilder)localObject).toString();
                  }
                }
                else {
                  paramSetting.append("new_troop_b_");
                }
              }
              else
              {
                paramSetting.append("dis_g_");
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(paramString);
                ((StringBuilder)localObject).append(paramString);
                paramString = ((StringBuilder)localObject).toString();
              }
            }
            else
            {
              paramSetting.append("stranger_");
              paramSetting.append(Integer.toString(paramInt2));
              paramSetting.append("_");
            }
          }
          else
          {
            paramSetting.append("qcall_");
            paramSetting.append(Integer.toString(paramInt2));
            paramSetting.append("_");
          }
        }
        else {
          paramSetting.append("troop_");
        }
      }
      else
      {
        paramSetting.append("sys_");
        paramString = (String)localObject[1];
      }
    }
    else
    {
      paramSetting.append("troop_sys_b_");
      paramString = (String)localObject[1];
    }
    localObject = MD5.toMD5(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    localObject = MD5.toMD5(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    paramSetting.append(MD5.toMD5(localStringBuilder.toString()));
    paramSetting.append(".jpg_");
    return paramSetting.toString();
  }
  
  private static Object[] a(Setting paramSetting, String paramString, int paramInt)
  {
    String str = paramString;
    int i = paramInt;
    if (paramSetting != null)
    {
      str = paramString;
      i = paramInt;
      if (paramInt != 101)
      {
        str = paramString;
        i = paramInt;
        if (paramInt != 1001)
        {
          str = paramString;
          i = paramInt;
          if (paramString != null)
          {
            str = paramString;
            i = paramInt;
            if (paramSetting.bHeadType == 0)
            {
              str = String.valueOf(paramSetting.systemHeadID);
              if (paramInt == 4) {
                i = -56;
              } else if (paramInt == 16) {
                i = 16;
              } else if (paramInt == 116) {
                i = 116;
              } else {
                i = -55;
              }
            }
          }
        }
      }
    }
    return new Object[] { Integer.valueOf(i), str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.LocalHeadFetchUtils
 * JD-Core Version:    0.7.0.1
 */