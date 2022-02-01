package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import amqx;
import android.graphics.Bitmap;
import android.text.TextUtils;
import anho;
import awkj;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.HeadRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class FaceDecoderImpl
  extends FaceDecoderBase
  implements FaceDecodeTask.DecodeCompletionListener
{
  private static final String TAG = "Q.qqhead.FaceDecoderImpl";
  private QQAppInterface mAppIntf;
  private FaceDecoderImpl.MyDiscussionObserver mDiscussObserver;
  private FaceDecoderImpl.MyFriendListObserver mFriendListObserver;
  private FaceDecoderImpl.MyTroopHeaderObserver mTroopHeaderObserver;
  
  public FaceDecoderImpl(QQAppInterface paramQQAppInterface)
  {
    this.maxDecodingTask = 4;
    this.mAppIntf = paramQQAppInterface;
  }
  
  public void destory()
  {
    QQAppInterface localQQAppInterface = this.mAppIntf;
    FaceDecoderImpl.MyDiscussionObserver localMyDiscussionObserver = this.mDiscussObserver;
    FaceDecoderImpl.MyFriendListObserver localMyFriendListObserver = this.mFriendListObserver;
    FaceDecoderImpl.MyTroopHeaderObserver localMyTroopHeaderObserver = this.mTroopHeaderObserver;
    this.mAppIntf = null;
    this.mDiscussObserver = null;
    this.mTroopHeaderObserver = null;
    this.mFriendListObserver = null;
    if (localQQAppInterface != null)
    {
      if (localMyDiscussionObserver != null) {
        localQQAppInterface.removeObserver(localMyDiscussionObserver);
      }
      if (localMyFriendListObserver != null) {
        localQQAppInterface.removeObserver(localMyFriendListObserver);
      }
      if (localMyTroopHeaderObserver != null) {
        localQQAppInterface.removeObserver(localMyTroopHeaderObserver);
      }
    }
    super.destory();
  }
  
  public Bitmap getBitmapFromCache(int paramInt1, String paramString, int paramInt2, byte paramByte, int paramInt3)
  {
    if (this.mAppIntf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "getBitmapFromCache, mApp is null");
      }
      return null;
    }
    if ((paramInt1 == 1001) && (paramString != null) && (!GroupIconHelper.a(paramString))) {}
    for (Object localObject = GroupIconHelper.a(paramString);; localObject = paramString)
    {
      if ((paramInt1 == 4) && (!TroopUtils.hasSetTroopHead(paramString))) {
        paramInt1 = 113;
      }
      for (;;)
      {
        if (paramInt1 == 113) {
          paramByte = 3;
        }
        paramByte = anho.a(paramByte);
        localObject = this.mAppIntf.getFaceBitmapCacheKey(paramInt1, (String)localObject, paramByte, paramInt2, paramInt3, true);
        localObject = this.mAppIntf.getBitmapFromCache((String)localObject);
        if ((localObject != null) && (paramInt1 == 1001))
        {
          amqx localamqx = (amqx)this.mAppIntf.getBusinessHandler(6);
          if ((localamqx != null) && (localamqx.a() != null)) {
            localamqx.a().f(paramString);
          }
          if (this.mDiscussObserver == null)
          {
            this.mDiscussObserver = new FaceDecoderImpl.MyDiscussionObserver(this, null);
            this.mAppIntf.addObserver(this.mDiscussObserver);
          }
        }
        return localObject;
      }
    }
  }
  
  public void onDecodeTaskCompleted(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if ((paramFaceInfo == null) || (this.mAppIntf == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompleted, faceInfo=" + paramFaceInfo.toString());
    }
    this.iRunningRequests -= 1;
    if ((!this.mReadyRequests.isEmpty()) && (!this.mPause)) {
      runNextTask();
    }
    FaceInfo localFaceInfo = (FaceInfo)this.mInProgress.remove(paramFaceInfo.b());
    int j;
    if (localFaceInfo != null)
    {
      j = FaceInfo.r;
      if (paramBitmap == null) {
        break label161;
      }
    }
    label161:
    for (int i = FaceInfo.f;; i = FaceInfo.g)
    {
      localFaceInfo.a(j, i);
      if ((this.mDecodeTaskCompletionListener == null) || (paramBitmap == null)) {
        break;
      }
      this.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
      return;
    }
  }
  
  public void onDecodeTaskCompletedNeedDownload(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (this.mAppIntf == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompletedNeedDownload, faceInfo=" + paramFaceInfo.toString());
      }
      this.iRunningRequests -= 1;
      paramAppInterface = (FaceInfo)this.mInProgress.get(paramFaceInfo.b());
      if (paramAppInterface != null)
      {
        if (this.mFriendListObserver == null)
        {
          this.mFriendListObserver = new FaceDecoderImpl.MyFriendListObserver(this, null);
          this.mAppIntf.addObserver(this.mFriendListObserver);
        }
        FaceDecoder.requestDownloadFace(this.mAppIntf, paramAppInterface);
      }
    } while ((this.mPause) || (this.mReadyRequests.isEmpty()) || (this.iRunningRequests >= this.maxDecodingTask));
    runNextTask();
  }
  
  protected void onUpdateHead(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (this.mAppIntf == null) {}
    label181:
    do
    {
      Object localObject;
      do
      {
        Bitmap localBitmap;
        do
        {
          return;
          localObject = FaceInfo.a(paramInt1, paramString, paramInt2, paramInt3);
          if ((paramInt1 == 101) && ((!paramBoolean) || (this.mPause))) {
            break label181;
          }
          localBitmap = getBitmapFromCache(paramInt1, paramString, paramInt2, (byte)3, paramInt3);
          if (localBitmap == null) {
            break;
          }
          localObject = (FaceInfo)this.mInProgress.remove(localObject);
          if (localObject != null) {
            ((FaceInfo)localObject).a(FaceInfo.r, FaceInfo.f);
          }
        } while (this.mDecodeTaskCompletionListener == null);
        this.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), paramInt1, paramString, localBitmap);
        return;
        paramString = (FaceInfo)this.mInProgress.get(localObject);
        if (paramString != null)
        {
          enqueueDecode(paramString);
          return;
        }
        paramString = (FaceInfo)this.mRefreshMap.remove(localObject);
      } while (paramString == null);
      paramString.a(FaceInfo.j);
      this.mInProgress.put(localObject, paramString);
      enqueueDecode(paramString);
      return;
      paramString = (FaceInfo)this.mInProgress.remove(localObject);
    } while (paramString == null);
    paramInt2 = FaceInfo.r;
    if (!paramBoolean) {}
    for (paramInt1 = FaceInfo.g;; paramInt1 = FaceInfo.h)
    {
      paramString.a(paramInt2, paramInt1);
      return;
    }
  }
  
  public boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> paramArrayList)
  {
    return false;
  }
  
  public void refreshFaceWithTimeStamp(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L) || (this.mAppIntf == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 == 32) && (paramInt2 != 200) && (paramInt2 != 202) && (paramInt2 != 204));
      if (paramInt1 == 32) {}
      for (byte b = 1;; b = 0)
      {
        FaceInfo localFaceInfo = new FaceInfo(paramInt1, paramString, false, b, 3, false, paramInt2, false, paramInt3);
        String str = FaceInfo.a(paramInt1, paramString, paramInt2, paramInt3);
        if (this.mRefreshMap.get(str) == null) {
          this.mRefreshMap.put(str, localFaceInfo);
        }
        if (this.mFriendListObserver == null)
        {
          this.mFriendListObserver = new FaceDecoderImpl.MyFriendListObserver(this, null);
          this.mAppIntf.addObserver(this.mFriendListObserver);
        }
        if (paramInt1 != 32) {
          break;
        }
        this.mAppIntf.refreshStrangerFaceWithTimeStamp(paramString, paramInt2, paramLong);
        return;
      }
      if (paramInt1 == 16)
      {
        this.mAppIntf.refreshQCallFaceWithTimeStamp(paramString, paramInt2, paramLong);
        return;
      }
    } while (paramInt1 != 116);
    this.mAppIntf.refreshApolloFaceWithTimeStamp(paramString, paramInt3, paramLong);
  }
  
  public boolean requestDecodeFace(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace fail. type=" + paramInt2 + ", uin=" + paramString);
      }
      return false;
    }
    byte b = 3;
    if (paramInt3 == 0) {
      if ((paramInt2 != 101) && (paramInt2 != 1001)) {}
    }
    String str;
    for (b = 3;; b = (byte)paramInt3)
    {
      paramInt3 = anho.a(b);
      str = FaceInfo.a(paramInt2, paramString, paramInt1, paramInt4);
      FaceInfo localFaceInfo = (FaceInfo)this.mInProgress.get(str);
      if ((localFaceInfo == null) || (localFaceInfo.a(FaceInfo.j, 300000L))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.b) && (!paramBoolean2)) {
        localFaceInfo.b = false;
      }
      localFaceInfo.c = paramInt3;
      return true;
    }
    paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, paramByte, paramInt3, false, paramInt1, paramBoolean3, paramInt4);
    paramString.a(FaceInfo.j);
    this.mInProgress.put(str, paramString);
    enqueueDecode(paramString);
    return true;
  }
  
  public boolean requestDecodeFaceWithFaceInfo(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo)
  {
    return false;
  }
  
  protected void runNextTask()
  {
    Object localObject1 = null;
    if (this.mReadyRequests.isEmpty()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, mReadyRequests is empty");
    }
    label204:
    do
    {
      return;
      try
      {
        localObject2 = (FaceInfo)this.mReadyRequests.removeFirst();
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, faceinfo=" + ((FaceInfo)localObject2).toString());
          }
          if (((((FaceInfo)localObject2).jdField_a_of_type_Int == 101) || (((FaceInfo)localObject2).jdField_a_of_type_Int == 1001)) && (this.mDiscussObserver == null))
          {
            this.mDiscussObserver = new FaceDecoderImpl.MyDiscussionObserver(this, null);
            this.mAppIntf.addObserver(this.mDiscussObserver);
          }
          if (((((FaceInfo)localObject2).jdField_a_of_type_Int == 4) || (((FaceInfo)localObject2).jdField_a_of_type_Int == 113)) && (!TroopUtils.hasSetTroopHead(((FaceInfo)localObject2).jdField_a_of_type_JavaLangString)))
          {
            if (this.mTroopHeaderObserver == null) {
              this.mTroopHeaderObserver = new FaceDecoderImpl.MyTroopHeaderObserver(this, null);
            }
            this.mAppIntf.addObserver(this.mTroopHeaderObserver);
          }
          this.iRunningRequests += 1;
          FaceDecodeTask.execute(FaceDecodeTask.getFaceDecodeTask(this.mAppIntf, (FaceInfo)localObject2, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localObject2;
          localObject2 = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject2;
        break label204;
      }
      if (localObject1 != null) {
        this.iRunningRequests -= 1;
      }
    } while (!QLog.isColorLevel());
    awkj.a("Q.qqhead.FaceDecoderImpl", new Object[] { "runNextTask", localObject2, localObject1 });
  }
  
  public void setAppRuntime(AppInterface paramAppInterface)
  {
    if (this.mAppIntf != paramAppInterface)
    {
      destory();
      if ((paramAppInterface instanceof QQAppInterface)) {
        this.mAppIntf = ((QQAppInterface)paramAppInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoderImpl
 * JD-Core Version:    0.7.0.1
 */