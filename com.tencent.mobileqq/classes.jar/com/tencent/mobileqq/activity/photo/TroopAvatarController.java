package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.UploadItem;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class TroopAvatarController
  extends TroopPhotoController
{
  private AvatarInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo;
  private TroopClipPic jdField_a_of_type_ComTencentMobileqqDataTroopTroopClipPic;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new TroopAvatarController.2(this);
  private AvatarInfo b;
  
  public TroopAvatarController(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, paramActivity, paramQQAppInterface, paramString);
    this.mType = 1;
  }
  
  public AvatarInfo getAvatar()
  {
    if (this.b != null) {
      return this.b;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo;
  }
  
  public List<AvatarInfo> getCoverList()
  {
    return null;
  }
  
  protected void notifyAdd(AvatarInfo paramAvatarInfo) {}
  
  protected void notifyDataSetChanged()
  {
    Iterator localIterator = this.mOnDataChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).onDataSetChanged();
    }
  }
  
  protected void notifyDel(AvatarInfo paramAvatarInfo) {}
  
  protected void notifyItemSelect(int paramInt) {}
  
  protected void notifyUpdate(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    super.notifyUpdate(paramAvatarInfo, paramUploadState);
  }
  
  public void onDeleteItem(int paramInt) {}
  
  public void onItemSelect(int paramInt) {}
  
  public boolean onPicPicked(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onNewIntent clip=%s path=%s", new Object[] { paramString2, paramString1 }));
    }
    if (filterPicsUpload(paramString1)) {}
    while (checkEnterTroopAvatarWallEdit(paramString1, paramString2)) {
      return false;
    }
    TroopClipPic localTroopClipPic = new TroopClipPic();
    localTroopClipPic.id = paramString1;
    localTroopClipPic.clipInfo = paramString2;
    localTroopClipPic.type = this.mType;
    localTroopClipPic.ts = SystemClock.uptimeMillis();
    paramString1 = new AvatarInfo();
    paramString1.jdField_b_of_type_JavaLangString = localTroopClipPic.id;
    paramString1.jdField_d_of_type_JavaLangString = localTroopClipPic.clipInfo;
    paramString1.jdField_b_of_type_Int = 2;
    paramString1.jdField_a_of_type_Boolean = true;
    paramString1.jdField_c_of_type_JavaLangString = "-1";
    paramString1.jdField_d_of_type_Int = localTroopClipPic.type;
    paramString1.jdField_a_of_type_Long = localTroopClipPic.ts;
    paramString2 = this.mManger.a();
    if (paramString2 != null)
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        UploadItem localUploadItem = (UploadItem)paramString2.next();
        if ((localUploadItem != null) && (localUploadItem.jdField_b_of_type_Int == 1)) {
          paramString2.remove();
        }
      }
    }
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopClipPic = localTroopClipPic;
    notifyDataSetChanged();
    startUpload();
    ReportController.b(this.mApp, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.mTroopInfo.troopuin, "", "", "");
    return true;
  }
  
  public void onUpdateTroopAvatarWallList(boolean paramBoolean)
  {
    Object localObject3 = null;
    UploadItem localUploadItem = null;
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Object localObject1;
    Object localObject2;
    if (this.mApp != null)
    {
      if (paramBoolean) {
        updateTroopInfo();
      }
      if (this.mTroopInfo != null)
      {
        paramBoolean = this.mTroopInfoData.hasSetNewTroopHead;
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList hasHead=%b id=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.mTroopInfo.mTroopAvatarId) }));
        }
        if (!paramBoolean) {
          break label436;
        }
        int i = this.mTroopInfo.mTroopAvatarId;
        if (i <= 0) {
          break label431;
        }
        localObject1 = new AvatarInfo();
        ((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(i);
        ((AvatarInfo)localObject1).jdField_d_of_type_Int = 1;
        ((AvatarInfo)localObject1).jdField_b_of_type_Int = 1;
        ((AvatarInfo)localObject1).jdField_c_of_type_Boolean = this.mTroopInfo.mTroopVerifyingPics.contains(((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString);
        if (localObject1 != null) {
          break label425;
        }
        localObject2 = new AvatarInfo();
        ((AvatarInfo)localObject2).jdField_c_of_type_JavaLangString = AvatarInfo.jdField_a_of_type_JavaLangString;
        ((AvatarInfo)localObject2).jdField_d_of_type_Int = 1;
        ((AvatarInfo)localObject2).jdField_b_of_type_Int = 3;
      }
    }
    for (;;)
    {
      ArrayList localArrayList = this.mManger.a();
      if (localArrayList != null)
      {
        Iterator localIterator = localArrayList.iterator();
        localObject1 = localUploadItem;
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localUploadItem = (UploadItem)localIterator.next();
          if (localUploadItem != null)
          {
            localObject3 = localObject1;
            if (localUploadItem.jdField_b_of_type_Int == 1)
            {
              if (localObject1 != null)
              {
                localIterator.remove();
              }
              else
              {
                localObject3 = new AvatarInfo();
                ((AvatarInfo)localObject3).jdField_b_of_type_JavaLangString = localUploadItem.jdField_a_of_type_JavaLangString;
                ((AvatarInfo)localObject3).jdField_c_of_type_Int = localUploadItem.jdField_a_of_type_Int;
                ((AvatarInfo)localObject3).jdField_d_of_type_Int = localUploadItem.jdField_b_of_type_Int;
                ((AvatarInfo)localObject3).jdField_b_of_type_Int = 2;
                ((AvatarInfo)localObject3).jdField_a_of_type_Boolean = true;
                ((AvatarInfo)localObject3).jdField_a_of_type_Long = localUploadItem.jdField_a_of_type_Long;
                ((AvatarInfo)localObject3).jdField_d_of_type_JavaLangString = localUploadItem.jdField_b_of_type_JavaLangString;
              }
            }
            else {
              localObject1 = localObject3;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList uploadItems=%s", new Object[] { localArrayList }));
      }
      localObject1 = new TroopAvatarController.1(this, (AvatarInfo)localObject2, (AvatarInfo)localObject3);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        ((Runnable)localObject1).run();
        return;
      }
      this.handler.post((Runnable)localObject1);
      return;
      label425:
      localObject2 = localObject1;
      continue;
      label431:
      localObject1 = null;
      break;
      label436:
      localObject2 = null;
    }
  }
  
  public void startUpload()
  {
    AccountManager localAccountManager = (AccountManager)this.mApp.getManager(0);
    String str = TroopUtils.a(this.mApp);
    if (str == null)
    {
      localAccountManager.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    startUpload(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopClipPic, this.mTroopInfo.troopcode, str, this.mApp.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopClipPic = null;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    TroopUploadingThread.UploadState localUploadState;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof TroopUploadingThread.UploadState));
        localUploadState = (TroopUploadingThread.UploadState)paramObject;
      } while (localUploadState.jdField_d_of_type_Int != this.mType);
      long l = localUploadState.jdField_a_of_type_Long;
      paramObject = this.b;
      if ((paramObject != null) && (paramObject.jdField_a_of_type_Long == l))
      {
        switch (localUploadState.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 0: 
          paramObject.jdField_c_of_type_Int = localUploadState.jdField_b_of_type_Int;
          this.handler.post(new TroopAvatarController.3(this, paramObject, localUploadState));
          return;
        case 1: 
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(localUploadState.jdField_b_of_type_Int), Integer.valueOf(localUploadState.jdField_c_of_type_Int), paramObject }));
          }
          int i = localUploadState.jdField_b_of_type_Int;
          paramObservable = new TroopAvatarController.4(this, localUploadState, paramObject, i);
          this.handler.post(paramObservable);
          TroopPhotoUtil.a(i, paramObject.jdField_b_of_type_JavaLangString, this.mTroopInfo.troopuin);
          return;
        }
        ReportController.b(this.mApp, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.mTroopInfo.troopuin, String.valueOf(localUploadState.jdField_b_of_type_Int), "", "");
        if (TextUtils.isEmpty(localUploadState.jdField_a_of_type_JavaLangString)) {}
        for (paramObservable = TroopPhotoUtil.a(this.mActivity, localUploadState.jdField_b_of_type_Int);; paramObservable = localUploadState.jdField_a_of_type_JavaLangString)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() failed result=%d info=%s", new Object[] { Integer.valueOf(localUploadState.jdField_b_of_type_Int), paramObject }));
          }
          paramObservable = new TroopAvatarController.5(this, paramObservable);
          this.handler.post(paramObservable);
          return;
        }
      }
    } while (localUploadState.jdField_a_of_type_Int != 1);
    this.mManger.a(this.mTroopInfo.troopuin);
  }
  
  protected boolean update2DB(int paramInt, AvatarInfo paramAvatarInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramAvatarInfo }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAvatarInfo.jdField_c_of_type_JavaLangString;
      try
      {
        i = Integer.parseInt((String)localObject);
        if ((localObject != null) && (i >= 0) && (i == paramInt)) {
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int i = -1;
        }
      }
    }
    Object localObject = new HashSet();
    if (paramAvatarInfo.jdField_c_of_type_Boolean) {
      ((Set)localObject).add(paramAvatarInfo.jdField_c_of_type_JavaLangString);
    }
    if (this.mApp != null)
    {
      paramAvatarInfo = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramAvatarInfo != null)
      {
        TroopInfo localTroopInfo = paramAvatarInfo.b(String.valueOf(this.mTroopInfo.troopuin));
        if (localTroopInfo != null)
        {
          localTroopInfo.mTroopAvatarId = paramInt;
          localTroopInfo.mTroopVerifyingPics.addAll((Collection)localObject);
          ThreadManager.post(new TroopAvatarController.6(this, paramAvatarInfo, localTroopInfo), 8, null, false);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController
 * JD-Core Version:    0.7.0.1
 */