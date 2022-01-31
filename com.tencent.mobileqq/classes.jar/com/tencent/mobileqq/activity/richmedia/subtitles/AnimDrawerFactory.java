package com.tencent.mobileqq.activity.richmedia.subtitles;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgTranslator;
import com.tencent.qphone.base.util.QLog;

public class AnimDrawerFactory
{
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 2;
    }
    if (paramInt == 3) {
      return 3;
    }
    return 0;
  }
  
  public static BaseAnimDrawer a(int paramInt)
  {
    QLog.d("AnimDrawerFactory", 2, "create drawer by type: " + paramInt);
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new BarrageDrawer();
    case 2: 
      return new PacmanDrawer();
    }
    return new MovieDrawer();
  }
  
  public static BaseAnimDrawer a(String paramString, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(Base64.decode(paramString.getBytes(), 0), paramFloat1, paramFloat2, paramInt);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("AnimDrawerFactory", 2, "subtitle base64decode exception:" + paramString.toString());
    }
    return null;
  }
  
  public static BaseAnimDrawer a(byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, int paramInt)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 4)) {
      localObject = null;
    }
    BaseAnimDrawer localBaseAnimDrawer;
    do
    {
      return localObject;
      localBaseAnimDrawer = a(DoodleMsgTranslator.a(paramArrayOfByte, 0));
      localObject = localBaseAnimDrawer;
    } while (localBaseAnimDrawer == null);
    localBaseAnimDrawer.a(BaseApplicationImpl.getApplication(), paramFloat1, paramFloat2, paramInt, paramArrayOfByte, 4, paramArrayOfByte.length - 4, true);
    return localBaseAnimDrawer;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.subtitles.AnimDrawerFactory
 * JD-Core Version:    0.7.0.1
 */