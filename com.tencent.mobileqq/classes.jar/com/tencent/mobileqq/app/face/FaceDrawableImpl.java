package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import antl;
import aoke;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import java.lang.ref.WeakReference;

public class FaceDrawableImpl
  extends FaceDrawable
{
  private static final String TAG = "Q.qqhead.FaceDrawableImpl";
  FaceDrawableImpl.InternalDiscussionObserver mDisObserver;
  FaceDrawableImpl.InternalFriendListObserver mFriendListObserver;
  FaceDrawableImpl.InternalGroupObserver mGroupObserver;
  WeakReference<QQAppInterface> weakApp;
  
  public FaceDrawableImpl(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean2);
    this.weakApp = new WeakReference((QQAppInterface)paramAppInterface);
  }
  
  private Bitmap getBitmapFromCacheInner(boolean paramBoolean)
  {
    if (this.mFaceInfo == null) {
      return null;
    }
    Object localObject1 = this.mFaceInfo.jdField_a_of_type_JavaLangString;
    if (this.mFaceInfo.jdField_a_of_type_Int == 1001) {
      localObject1 = GroupIconHelper.a(this.mFaceInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject2 = (QQAppInterface)this.weakApp.get();
    if (localObject2 == null) {
      return null;
    }
    localObject1 = ((QQAppInterface)localObject2).getBitmapFromCache(((QQAppInterface)localObject2).getFaceBitmapCacheKey(this.mFaceInfo.jdField_a_of_type_Int, (String)localObject1, (byte)this.mFaceInfo.c, this.mFaceInfo.jdField_b_of_type_Int, this.mFaceInfo.d, paramBoolean));
    if ((localObject1 != null) && (this.mFaceInfo.jdField_a_of_type_Int == 1001))
    {
      localObject2 = (antl)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      if ((localObject2 != null) && (((antl)localObject2).a() != null)) {
        ((antl)localObject2).a().f(this.mFaceInfo.jdField_a_of_type_JavaLangString);
      }
    }
    return localObject1;
  }
  
  public void cancel()
  {
    Object localObject = (QQAppInterface)this.weakApp.get();
    if ((!this.mCancelled) && (localObject != null))
    {
      aoke localaoke;
      if (this.mFriendListObserver != null)
      {
        localaoke = (aoke)((QQAppInterface)localObject).getManager(QQManagerFactory.FACE_MANAGER);
        if (localaoke != null) {
          localaoke.b(this.mFriendListObserver);
        }
      }
      if (this.mDisObserver != null)
      {
        localaoke = (aoke)((QQAppInterface)localObject).getManager(QQManagerFactory.FACE_MANAGER);
        if (localaoke != null) {
          localaoke.b(this.mDisObserver);
        }
      }
      if (this.mGroupObserver != null)
      {
        localObject = (aoke)((QQAppInterface)localObject).getManager(QQManagerFactory.FACE_MANAGER);
        if (localObject != null) {
          ((aoke)localObject).b(this.mGroupObserver);
        }
      }
      this.weakApp = null;
    }
    super.cancel();
  }
  
  protected Bitmap getBitmapFromCache()
  {
    return getBitmapFromCacheInner(false);
  }
  
  protected Bitmap getBitmapFromCache(boolean paramBoolean)
  {
    return getBitmapFromCacheInner(paramBoolean);
  }
  
  protected void onNeedDownload()
  {
    if (this.mFriendListObserver == null) {
      this.mFriendListObserver = new FaceDrawableImpl.InternalFriendListObserver(this, this);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      return;
    }
    Object localObject = (aoke)localQQAppInterface.getManager(QQManagerFactory.FACE_MANAGER);
    if (localObject != null) {
      ((aoke)localObject).a(this.mFriendListObserver);
    }
    if ((this.mFaceInfo.jdField_a_of_type_Int == 1) || (this.mFaceInfo.jdField_a_of_type_Int == 11) || (this.mFaceInfo.jdField_a_of_type_Int == 4) || (this.mFaceInfo.jdField_a_of_type_Int == 32) || (this.mFaceInfo.jdField_a_of_type_Int == 16) || (this.mFaceInfo.jdField_a_of_type_Int == 116) || (this.mFaceInfo.jdField_a_of_type_Int == 1001))
    {
      localObject = (FriendListHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (this.mFaceInfo.jdField_a_of_type_Int != 1) {
        break label194;
      }
      ((FriendListHandler)localObject).getCustomHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_a_of_type_Byte, this.mFaceInfo.jdField_b_of_type_Byte);
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      label194:
      if (this.mFaceInfo.jdField_a_of_type_Int == 11) {
        ((FriendListHandler)localObject).getMobileQQHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_b_of_type_Byte);
      } else if (this.mFaceInfo.jdField_a_of_type_Int == 4) {
        ((FriendListHandler)localObject).getTroopHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_b_of_type_Byte);
      } else if (this.mFaceInfo.jdField_a_of_type_Int == 32) {
        ((FriendListHandler)localObject).getStrangerHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_b_of_type_Int, this.mFaceInfo.jdField_a_of_type_Byte, this.mFaceInfo.jdField_b_of_type_Byte);
      } else if (this.mFaceInfo.jdField_a_of_type_Int == 16) {
        ((FriendListHandler)localObject).getQCallHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_b_of_type_Int, this.mFaceInfo.jdField_a_of_type_Byte, this.mFaceInfo.jdField_b_of_type_Byte);
      } else if (this.mFaceInfo.jdField_a_of_type_Int == 116) {
        ((FriendListHandler)localObject).getApolloHead(this.mFaceInfo.jdField_a_of_type_JavaLangString, this.mFaceInfo.jdField_a_of_type_Byte, this.mFaceInfo.jdField_b_of_type_Byte, this.mFaceInfo.d);
      } else if (this.mFaceInfo.jdField_a_of_type_Int == 101) {
        ((antl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(this.mFaceInfo.jdField_a_of_type_JavaLangString, true);
      } else if (this.mFaceInfo.jdField_a_of_type_Int == 1001) {
        ((antl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(GroupIconHelper.a(this.mFaceInfo.jdField_a_of_type_JavaLangString), true);
      }
    }
  }
  
  public void onUpdateHead(boolean paramBoolean, int paramInt, String paramString, Object paramObject)
  {
    if ((this.mCancelled) || (this.mFaceInfo == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != this.mFaceInfo.jdField_a_of_type_Int) || (!this.mFaceInfo.jdField_a_of_type_JavaLangString.equals(paramString)));
      if (paramObject == null) {
        break;
      }
      paramString = (QQAppInterface)this.weakApp.get();
    } while (paramString == null);
    paramString = (aoke)paramString.getManager(QQManagerFactory.FACE_MANAGER);
    if (paramString != null) {
      paramString.b(paramObject);
    }
    if (paramBoolean)
    {
      paramString = getBitmapFromCache();
      if (paramString != null) {
        onDecodeTaskCompleted(this.mFaceInfo, paramString);
      }
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      requestDecode();
      continue;
      onDecodeTaskCompleted(this.mFaceInfo, null);
    }
  }
  
  protected boolean requestDecode()
  {
    if (this.mFaceInfo == null) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.weakApp.get();
    if (localQQAppInterface == null) {
      return false;
    }
    aoke localaoke;
    if ((this.mFaceInfo.jdField_a_of_type_Int == 101) || (this.mFaceInfo.jdField_a_of_type_Int == 1001))
    {
      this.mDisObserver = new FaceDrawableImpl.InternalDiscussionObserver(this, this);
      localaoke = (aoke)localQQAppInterface.getManager(QQManagerFactory.FACE_MANAGER);
      if (localaoke != null) {
        localaoke.a(this.mDisObserver);
      }
    }
    if (((this.mFaceInfo.jdField_a_of_type_Int == 4) || (this.mFaceInfo.jdField_a_of_type_Int == 113)) && (!TroopUtils.hasSetTroopHead(this.mFaceInfo.jdField_a_of_type_JavaLangString)))
    {
      this.mGroupObserver = new FaceDrawableImpl.InternalGroupObserver(this, this);
      localaoke = (aoke)localQQAppInterface.getManager(QQManagerFactory.FACE_MANAGER);
      if (localaoke != null) {
        localaoke.a(this.mGroupObserver);
      }
    }
    FaceDecodeTask.execute(FaceDecodeTask.getFaceDecodeTask(localQQAppInterface, this.mFaceInfo, this));
    return true;
  }
  
  protected void setApp(AppInterface paramAppInterface)
  {
    this.weakApp = new WeakReference((QQAppInterface)paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDrawableImpl
 * JD-Core Version:    0.7.0.1
 */