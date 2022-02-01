package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.HeadRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public abstract class FaceDecoderBase
{
  static final int LENGTH_LIMIT = 5;
  static final String TAG = "FaceDecoderBase";
  static final long TIMEOUT_REQDECODE = 300000L;
  protected int iRunningRequests = 0;
  DecodeTaskCompletionListener mDecodeTaskCompletionListener = null;
  Hashtable<String, FaceInfo> mInProgress = new Hashtable();
  boolean mPause = false;
  LinkedList<FaceInfo> mReadyRequests = new LinkedList();
  Hashtable<String, FaceInfo> mRefreshMap = new Hashtable();
  boolean mStatDecodeTime = false;
  boolean mUserJustTouchDown = false;
  int maxDecodingTask = 10;
  
  public void cancelPendingRequests()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FaceDecoderBase", 2, "cancelPendingRequests");
    }
    this.mInProgress.clear();
    this.mReadyRequests.clear();
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FaceDecoderBase", 2, "destory");
    }
    cancelPendingRequests();
    this.iRunningRequests = 0;
    this.mDecodeTaskCompletionListener = null;
    this.mPause = false;
  }
  
  protected void enqueueDecode(FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enqueueDecode, iRunningRequests=");
      localStringBuilder.append(this.iRunningRequests);
      localStringBuilder.append(", pause=");
      localStringBuilder.append(this.mPause);
      localStringBuilder.append(",faceinfo=");
      localStringBuilder.append(paramFaceInfo.toString());
      QLog.e("FaceDecoderBase", 2, localStringBuilder.toString());
    }
    try
    {
      this.mReadyRequests.remove(paramFaceInfo);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FaceDecoderBase", 2, "enqueueDecode", localException);
      }
    }
    if (paramFaceInfo.h) {
      this.mReadyRequests.addLast(paramFaceInfo);
    } else {
      this.mReadyRequests.addFirst(paramFaceInfo);
    }
    paramFaceInfo.a(FaceInfo.w);
    if ((this.iRunningRequests < this.maxDecodingTask) && (!this.mPause)) {
      runNextTask();
    }
  }
  
  public abstract Bitmap getBitmapFromCache(int paramInt1, String paramString, int paramInt2, byte paramByte, int paramInt3);
  
  public boolean isPausing()
  {
    return this.mPause;
  }
  
  public boolean ismUserJustTouchDown()
  {
    return this.mUserJustTouchDown;
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FaceDecoderBase", 2, "cancelPendingRequests");
    }
    this.mPause = true;
  }
  
  public abstract boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> paramArrayList);
  
  public abstract void refreshFaceWithTimeStamp(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3);
  
  public final boolean requestDecodeFace(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3)
  {
    return requestDecodeFace(paramString, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramByte, paramInt3, 100, false);
  }
  
  public abstract boolean requestDecodeFace(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3);
  
  public abstract boolean requestDecodeFaceWithFaceInfo(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo);
  
  public void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FaceDecoderBase", 2, "resume");
    }
    this.mPause = false;
    while ((this.iRunningRequests < this.maxDecodingTask) && (!this.mReadyRequests.isEmpty())) {
      runNextTask();
    }
  }
  
  protected abstract void runNextTask();
  
  public abstract void setAppRuntime(AppInterface paramAppInterface);
  
  public void setDecodeTaskCompletionListener(DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.mDecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
  }
  
  public void setStatDecodeTime(boolean paramBoolean)
  {
    this.mStatDecodeTime = paramBoolean;
  }
  
  public void setUserTouchDown(boolean paramBoolean)
  {
    this.mUserJustTouchDown = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoderBase
 * JD-Core Version:    0.7.0.1
 */