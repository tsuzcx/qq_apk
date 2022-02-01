package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.content.Context;
import android.graphics.Bitmap;
import anhz;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.HeadRequest;
import java.util.ArrayList;

public class FaceDecoder
{
  public static final int FROM_AIO = 6;
  public static final int FROM_DIS_MEMBER = 5;
  public static final int FROM_DIS_MEMBER_LIST = 1;
  public static final int FROM_TROOP_CHAT_SETTING = 3;
  public static final int FROM_TROOP_CHAT_SETTING_UPDATE = 4;
  public static final int FROM_TROOP_MEMBER = 2;
  FaceDecoderBase mDecoder;
  
  public FaceDecoder(Context paramContext, AppInterface paramAppInterface)
  {
    this(paramAppInterface);
  }
  
  public FaceDecoder(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.mDecoder = new FaceDecoderImpl((QQAppInterface)paramAppInterface);
    }
    while (this.mDecoder == null)
    {
      throw new NullPointerException("can not Instantiation FaceDecoder");
      if ((paramAppInterface instanceof NearbyAppInterface)) {
        this.mDecoder = new anhz((NearbyAppInterface)paramAppInterface);
      }
    }
  }
  
  private byte getFaceShapeType(int paramInt)
  {
    byte b = 3;
    if (paramInt == 115) {
      b = 4;
    }
    return b;
  }
  
  protected static void requestDownloadFace(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramQQAppInterface == null) || (paramFaceInfo == null)) {
      return;
    }
    ThreadManager.post(new FaceDecoder.1(paramFaceInfo, paramQQAppInterface), 10, null, true);
  }
  
  public void cancelPendingRequests()
  {
    this.mDecoder.cancelPendingRequests();
  }
  
  public void destory()
  {
    this.mDecoder.destory();
  }
  
  public Bitmap getBitmapFromCache(int paramInt, String paramString)
  {
    if (paramInt == 32) {
      return null;
    }
    byte b = getFaceShapeType(paramInt);
    if ((paramInt == 101) || (paramInt == 1001)) {
      b = 3;
    }
    return this.mDecoder.getBitmapFromCache(paramInt, paramString, 0, b, 0);
  }
  
  public Bitmap getBitmapFromCache(int paramInt1, String paramString, int paramInt2)
  {
    return getBitmapFromCache(paramInt1, paramString, paramInt2, (byte)3);
  }
  
  public Bitmap getBitmapFromCache(int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    return this.mDecoder.getBitmapFromCache(paramInt1, paramString, paramInt2, paramByte, 0);
  }
  
  public Bitmap getBitmapFromCacheFrom(int paramInt1, String paramString, int paramInt2)
  {
    return getBitmapFromCache(paramInt1, paramString);
  }
  
  public boolean isPausing()
  {
    return this.mDecoder.isPausing();
  }
  
  public boolean ismUserJustTouchDown()
  {
    return this.mDecoder.ismUserJustTouchDown();
  }
  
  public void pause()
  {
    this.mDecoder.pause();
  }
  
  public boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> paramArrayList)
  {
    return this.mDecoder.preloadFacesWithFaceInfo(paramArrayList);
  }
  
  public void refreshFaceWithTimeStamp(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3)
  {
    this.mDecoder.refreshFaceWithTimeStamp(paramInt1, paramString, paramInt2, paramLong, paramInt3);
  }
  
  public boolean requestDecodeApolloFace(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.mDecoder.requestDecodeFace(paramString, 200, paramBoolean1, 116, paramBoolean2, (byte)1, 3, paramInt, false);
  }
  
  public boolean requestDecodeFace(String paramString, int paramInt, boolean paramBoolean)
  {
    return this.mDecoder.requestDecodeFace(paramString, 200, false, paramInt, paramBoolean, (byte)0, getFaceShapeType(paramInt));
  }
  
  public boolean requestDecodeFace(String paramString, int paramInt, boolean paramBoolean, byte paramByte)
  {
    return this.mDecoder.requestDecodeFace(paramString, 200, false, paramInt, paramBoolean, paramByte, getFaceShapeType(paramInt));
  }
  
  public boolean requestDecodeFace(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3)
  {
    return this.mDecoder.requestDecodeFace(paramString, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramByte, paramInt3);
  }
  
  public boolean requestDecodeFaceWithFaceInfo(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo)
  {
    return this.mDecoder.requestDecodeFaceWithFaceInfo(paramString, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramByte, paramInt3, paramQQHeadInfo);
  }
  
  public boolean requestDecodeQCallFace(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.mDecoder.requestDecodeFace(paramString, paramInt, paramBoolean1, 16, paramBoolean2, (byte)1, 3);
  }
  
  public boolean requestDecodeQCallSquareFace(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.mDecoder.requestDecodeFace(paramString, paramInt, paramBoolean1, 16, paramBoolean2, (byte)1, 1);
  }
  
  public boolean requestDecodeStrangeFace(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.mDecoder.requestDecodeFace(paramString, paramInt, paramBoolean1, 32, paramBoolean2, (byte)1, 3);
  }
  
  public boolean requestDecodeStrangeSquareFace(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.mDecoder.requestDecodeFace(paramString, paramInt, paramBoolean1, 32, paramBoolean2, (byte)1, 1);
  }
  
  public void resume()
  {
    this.mDecoder.resume();
  }
  
  public void setAppRuntime(AppInterface paramAppInterface)
  {
    this.mDecoder.setAppRuntime(paramAppInterface);
  }
  
  public void setDecodeTaskCompletionListener(FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.mDecoder.setDecodeTaskCompletionListener(paramDecodeTaskCompletionListener);
  }
  
  public void setStatDecodeTime(boolean paramBoolean)
  {
    this.mDecoder.setStatDecodeTime(paramBoolean);
  }
  
  public void setUserTouchDown(boolean paramBoolean)
  {
    this.mDecoder.setUserTouchDown(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoder
 * JD-Core Version:    0.7.0.1
 */