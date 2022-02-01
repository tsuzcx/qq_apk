package com.tencent.mobileqq.activity.photo;

import ajnr;
import ajpz;
import anca;
import andd;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bcef;
import beyx;
import bfai;
import bfeb;
import bfed;
import bfef;
import bfur;
import bfvf;
import bfvo;
import bjnw;
import bjon;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class TroopPhotoController
  implements Observer
{
  protected static int MAX_MENU_ITEM_COUNT = 7;
  public static final int MENU_ITEM_CANCEL = 16;
  protected static final int MENU_ITEM_SELECT_PHOTO = 14;
  protected static final int MENU_ITEM_TAKE_PHOTO = 13;
  public static final String SHOWN_UPLOADED_DIALOG = "has_shown_same_city_picture_uploaded_dialog";
  public static final String TAG = "TroopPhotoController";
  public static Uri uploadPhotoUri;
  protected Handler handler = new Handler(Looper.getMainLooper());
  AccountObserver mAccountObserver = new TroopPhotoController.8(this);
  protected Activity mActivity;
  public QQAppInterface mApp;
  Context mCtx;
  protected int[] mCurShowItemIndex;
  List<ajnr> mInfos = new ArrayList();
  protected bfai mManger;
  protected String[] mMenuItems;
  protected List<TroopPhotoController.OnDataChangeListener> mOnDataChangeListeners = new ArrayList();
  WeakReference<TroopPhotoController.OnGotoBigPicListener> mOnGotoBigPicListener;
  WeakReference<TroopPhotoController.OnUploadListener> mOnUploadListener;
  int mSelectPos = -1;
  int mSubmitTime = 0;
  andd mTroopAvatarObserver = new TroopPhotoController.9(this);
  public TroopInfo mTroopInfo;
  protected TroopInfoData mTroopInfoData;
  String mTroopUin;
  protected int mType = 0;
  public ArrayList<TroopClipPic> mUploadPaths = new ArrayList();
  
  public TroopPhotoController(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.mCtx = paramContext;
    this.mActivity = paramActivity;
    this.mApp = paramQQAppInterface;
    this.mTroopUin = paramString;
    updateTroopInfo();
    paramContext = (anca)this.mApp.getBusinessHandler(20);
    this.mManger = new bfai(this.mTroopUin, bfeb.class, paramContext);
    this.mManger.a(this);
    this.mApp.addObserver(this.mTroopAvatarObserver, true);
  }
  
  private void enterSnapshot()
  {
    uploadPhotoUri = ProfileActivity.a(this.mActivity, 257);
  }
  
  private ajnr getItem(long paramLong)
  {
    Iterator localIterator = this.mInfos.iterator();
    while (localIterator.hasNext())
    {
      ajnr localajnr = (ajnr)localIterator.next();
      if (localajnr.jdField_a_of_type_Long == paramLong) {
        return localajnr;
      }
    }
    return null;
  }
  
  private void makeItemSelected()
  {
    if (this.mSelectPos >= this.mInfos.size()) {
      this.mSelectPos = (this.mInfos.size() - 1);
    }
    if (this.mSelectPos < 0) {
      return;
    }
    int i = 0;
    label41:
    if (i < this.mInfos.size()) {
      if (this.mSelectPos != i) {
        break label86;
      }
    }
    label86:
    for (((ajnr)this.mInfos.get(i)).jdField_d_of_type_Boolean = true;; ((ajnr)this.mInfos.get(i)).jdField_d_of_type_Boolean = false)
    {
      i += 1;
      break label41;
      break;
    }
  }
  
  public static void showToast(String paramString)
  {
    showToast(paramString, 0);
  }
  
  public static void showToast(String paramString, int paramInt)
  {
    int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299076);
    QQToast.a(BaseApplicationImpl.getContext(), paramInt, paramString, 1).b(i);
  }
  
  public void addDataChangeListener(TroopPhotoController.OnDataChangeListener paramOnDataChangeListener)
  {
    if (!this.mOnDataChangeListeners.contains(paramOnDataChangeListener)) {
      this.mOnDataChangeListeners.add(paramOnDataChangeListener);
    }
  }
  
  public void buildAndShowAlertWindow(boolean paramBoolean)
  {
    Activity localActivity = this.mActivity;
    QQCustomDialog localQQCustomDialog = bfur.a(localActivity, 230);
    localQQCustomDialog.setTitle(null);
    if (paramBoolean) {
      localQQCustomDialog.setMessage(localActivity.getResources().getString(2131693050));
    }
    for (;;)
    {
      localQQCustomDialog.setPositiveButton(localActivity.getResources().getString(2131693067), new bfvf());
      localQQCustomDialog.setPositiveButtonContentDescription(localActivity.getResources().getString(2131693067));
      localQQCustomDialog.show();
      return;
      localQQCustomDialog.setMessage(localActivity.getResources().getString(2131693049));
    }
  }
  
  protected boolean checkEnterTroopAvatarWallEdit(String paramString1, String paramString2)
  {
    if (!(this.mActivity instanceof TroopAvatarWallEditActivity))
    {
      TroopPhotoController.OnGotoBigPicListener localOnGotoBigPicListener;
      Bundle localBundle;
      if (this.mOnGotoBigPicListener != null)
      {
        localOnGotoBigPicListener = (TroopPhotoController.OnGotoBigPicListener)this.mOnGotoBigPicListener.get();
        if (localOnGotoBigPicListener != null)
        {
          localBundle = new Bundle();
          localBundle.putString("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
          localBundle.putString("key_clip_info", paramString2);
          if (this.mType != 0) {
            break label105;
          }
        }
      }
      label105:
      for (boolean bool = true;; bool = false)
      {
        localBundle.putBoolean("IS_COVER", bool);
        localBundle.putBoolean("IS_EDIT", true);
        localOnGotoBigPicListener.gotoBigPic(localBundle);
        return true;
        localOnGotoBigPicListener = null;
        break;
      }
    }
    return false;
  }
  
  protected boolean filterPicsUpload(String paramString)
  {
    if ((this.mTroopInfo.troopTypeExt == 2) || (this.mTroopInfo.troopTypeExt == 3) || (this.mTroopInfo.troopTypeExt == 4))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth < 100) || (localOptions.outHeight < 100))
      {
        QQToast.a(this.mActivity, 2131696711, 1).a();
        return true;
      }
    }
    return false;
  }
  
  public ajnr getAvatar()
  {
    return null;
  }
  
  @NonNull
  public List<ajnr> getCoverList()
  {
    return this.mInfos;
  }
  
  protected void initVerifyFlag(ajnr paramajnr)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(52)).b(this.mTroopInfo.troopuin);
    if ((localTroopInfo != null) && ((localTroopInfo.troopTypeExt == 2) || (localTroopInfo.troopTypeExt == 4)) && (localTroopInfo.isAdmin()))
    {
      paramajnr.jdField_c_of_type_Boolean = true;
      if ((!this.mApp.getPreferences().getBoolean("has_shown_same_city_picture_uploaded_dialog", false)) && (this.mActivity != null) && (!this.mActivity.isFinishing()))
      {
        bfur.a(this.mActivity, 230, null, this.mActivity.getString(2131695566), null, this.mActivity.getString(2131695556), new bfvf(), null).show();
        this.mApp.getPreferences().edit().putBoolean("has_shown_same_city_picture_uploaded_dialog", true).commit();
      }
    }
  }
  
  protected boolean isStillUploading(String paramString)
  {
    return this.mUploadPaths.size() == 0;
  }
  
  protected void notifyAdd(ajnr paramajnr)
  {
    Iterator localIterator = this.mOnDataChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).onAddItem(paramajnr);
    }
  }
  
  protected void notifyDataSetChanged()
  {
    Iterator localIterator = this.mOnDataChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).onDataSetChanged();
    }
    if (this.mSelectPos >= this.mInfos.size())
    {
      this.mSelectPos = this.mInfos.size();
      notifyItemSelect(this.mSelectPos);
    }
  }
  
  protected void notifyDel(ajnr paramajnr)
  {
    Iterator localIterator = this.mOnDataChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).onDelItem(paramajnr);
    }
    if (this.mSelectPos >= this.mInfos.size())
    {
      makeItemSelected();
      notifyItemSelect(this.mSelectPos);
    }
  }
  
  protected void notifyItemSelect(int paramInt)
  {
    Iterator localIterator = this.mOnDataChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).onItemSelect(paramInt);
    }
  }
  
  protected void notifyUpdate(ajnr paramajnr, bfed parambfed)
  {
    Iterator localIterator = this.mOnDataChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).onUpdateItem(paramajnr, parambfed);
    }
  }
  
  public void onDeleteItem(int paramInt)
  {
    Object localObject = (ajnr)this.mInfos.get(paramInt);
    ArrayList localArrayList;
    if (beyx.b(((ajnr)localObject).jdField_c_of_type_JavaLangString))
    {
      bcef.b(this.mApp, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "del_head", 0, 0, this.mTroopInfo.troopuin, "", "", "");
      localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(((ajnr)localObject).jdField_c_of_type_JavaLangString));
      this.mManger.a(this.mTroopInfo.troopuin, 2, localArrayList);
    }
    this.mInfos.remove(localObject);
    notifyDel((ajnr)localObject);
    if ((((ajnr)localObject).jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(((ajnr)localObject).jdField_c_of_type_JavaLangString)) && (beyx.b(((ajnr)localObject).jdField_c_of_type_JavaLangString)))
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(this.mTroopInfo.mTroopPicList);
      Iterator localIterator = localArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
          if (((ajnr)localObject).jdField_c_of_type_JavaLangString.equals(localTroopClipPic.id))
          {
            localArrayList.remove(localTroopClipPic);
            paramInt = 1;
            i = paramInt;
            if (paramInt != 0)
            {
              this.mTroopInfo.mTroopPicList.clear();
              this.mTroopInfo.mTroopPicList.addAll(localArrayList);
              this.mTroopInfo.mTroopVerifyingPics.remove(((ajnr)localObject).jdField_c_of_type_JavaLangString);
            }
          }
        }
      }
    }
    for (int i = paramInt;; i = 0)
    {
      if ((this.mApp != null) && (i != 0))
      {
        localObject = (TroopManager)this.mApp.getManager(52);
        if (localObject != null) {
          ThreadManager.post(new TroopPhotoController.6(this, (TroopManager)localObject), 8, null, false);
        }
      }
      return;
      paramInt = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    this.mManger.b(this);
    this.mApp.removeObserver(this.mTroopAvatarObserver);
    this.mOnDataChangeListeners.clear();
  }
  
  public void onGetTroopAuthSubmitTime(int paramInt)
  {
    this.mSubmitTime = paramInt;
  }
  
  public void onInsertAvatarFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, "onInsertAvatarFailed " + paramInt);
    }
    showToast(ajpz.a(BaseApplicationImpl.getContext(), -1));
    Iterator localIterator = this.mInfos.iterator();
    while (localIterator.hasNext())
    {
      ajnr localajnr = (ajnr)localIterator.next();
      if ((localajnr.jdField_b_of_type_Int == 2) || (localajnr.jdField_a_of_type_Boolean))
      {
        localIterator.remove();
        notifyDel(localajnr);
      }
    }
    this.mUploadPaths.clear();
    this.mManger.a(this.mTroopInfo.troopuin);
  }
  
  public void onItemSelect(int paramInt)
  {
    this.mSelectPos = paramInt;
    makeItemSelected();
    notifyItemSelect(paramInt);
  }
  
  public boolean onPicPicked(String paramString1, String paramString2)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onPicPicked clip=%s path=%s", new Object[] { paramString2, paramString1 }));
    }
    if (filterPicsUpload(paramString1)) {}
    TroopClipPic localTroopClipPic;
    do
    {
      do
      {
        return false;
      } while (checkEnterTroopAvatarWallEdit(paramString1, paramString2));
      localTroopClipPic = new TroopClipPic();
      localTroopClipPic.id = paramString1;
      localTroopClipPic.clipInfo = paramString2;
      localTroopClipPic.type = this.mType;
      localTroopClipPic.ts = SystemClock.uptimeMillis();
    } while (this.mInfos.size() >= 7);
    paramString1 = new ajnr();
    paramString1.jdField_b_of_type_JavaLangString = localTroopClipPic.id;
    paramString1.jdField_d_of_type_JavaLangString = localTroopClipPic.clipInfo;
    paramString1.jdField_b_of_type_Int = 2;
    paramString1.jdField_a_of_type_Boolean = true;
    paramString1.jdField_c_of_type_JavaLangString = null;
    paramString1.jdField_d_of_type_Int = localTroopClipPic.type;
    paramString1.jdField_a_of_type_Long = localTroopClipPic.ts;
    this.mInfos.add(paramString1);
    this.mUploadPaths.add(localTroopClipPic);
    notifyAdd(paramString1);
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onPicPicked uploadPaths=[size=%d, %s]", new Object[] { Integer.valueOf(this.mUploadPaths.size()), Arrays.toString(this.mInfos.toArray()) }));
    }
    if (this.mOnUploadListener == null)
    {
      paramString1 = localObject;
      if ((paramString1 == null) || (!paramString1.onBeforeUpload(this.mType))) {
        break label332;
      }
    }
    label332:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        startUpload();
      }
      bcef.b(this.mApp, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.mTroopInfo.troopuin, "", "", "");
      return true;
      paramString1 = (TroopPhotoController.OnUploadListener)this.mOnUploadListener.get();
      break;
    }
  }
  
  public void onPickPic()
  {
    int i = 3;
    int j = 0;
    if (this.mActivity == null) {
      return;
    }
    if (((this.mTroopInfoData.dwGroupFlagExt & 0x800) != 0L) || (this.mSubmitTime > 0))
    {
      if (this.mSubmitTime > 0) {}
      for (boolean bool = true;; bool = false)
      {
        buildAndShowAlertWindow(bool);
        bcef.b(this.mApp, "dc00899", "Grp_certified", "", "data", "exp_edit_head", 3, 0, this.mTroopInfo.troopuin, "", "", "");
        return;
      }
    }
    if (this.mCurShowItemIndex == null) {
      this.mCurShowItemIndex = new int[MAX_MENU_ITEM_COUNT];
    }
    this.mCurShowItemIndex[0] = 13;
    this.mCurShowItemIndex[1] = 14;
    this.mCurShowItemIndex[2] = 16;
    while (i < MAX_MENU_ITEM_COUNT)
    {
      this.mCurShowItemIndex[i] = -1;
      i += 1;
    }
    if (this.mMenuItems == null) {
      this.mMenuItems = this.mActivity.getResources().getStringArray(2130968636);
    }
    bjnw localbjnw = (bjnw)bjon.a(this.mActivity, null);
    i = j;
    if (i < this.mCurShowItemIndex.length)
    {
      if (this.mCurShowItemIndex[i] == 16) {
        localbjnw.d(this.mMenuItems[this.mCurShowItemIndex[i]]);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.mCurShowItemIndex[i] >= 0) && (this.mCurShowItemIndex[i] < this.mMenuItems.length)) {
          localbjnw.a(this.mMenuItems[this.mCurShowItemIndex[i]], 1);
        }
      }
    }
    localbjnw.a(new TroopPhotoController.5(this, localbjnw));
    localbjnw.show();
  }
  
  public void onSnapShotBack()
  {
    if (uploadPhotoUri != null)
    {
      Object localObject = uploadPhotoUri;
      localObject = bfvo.b(this.mActivity, (Uri)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ajpz.a(this.mActivity, (String)localObject, ajpz.d(this.mType));
      }
    }
  }
  
  public void onUpdateTroopAvatarWallList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Object localObject1;
    if (this.mApp != null)
    {
      if (paramBoolean) {
        updateTroopInfo();
      }
      if (this.mTroopInfo != null)
      {
        localObject1 = new ArrayList();
        ajpz.a((List)localObject1, this.mTroopInfo);
        Object localObject2 = this.mManger.a();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            bfef localbfef = (bfef)((Iterator)localObject2).next();
            if ((localbfef != null) && (localbfef.jdField_b_of_type_Int != 1)) {
              if (((List)localObject1).size() == 7)
              {
                ((Iterator)localObject2).remove();
              }
              else
              {
                ajnr localajnr = new ajnr();
                localajnr.jdField_b_of_type_JavaLangString = localbfef.jdField_a_of_type_JavaLangString;
                localajnr.jdField_c_of_type_Int = localbfef.jdField_a_of_type_Int;
                localajnr.jdField_d_of_type_Int = localbfef.jdField_b_of_type_Int;
                localajnr.jdField_b_of_type_Int = 2;
                localajnr.jdField_a_of_type_Boolean = true;
                localajnr.jdField_a_of_type_Long = localbfef.jdField_a_of_type_Long;
                localajnr.jdField_d_of_type_JavaLangString = localbfef.jdField_b_of_type_JavaLangString;
                ((List)localObject1).add(localajnr);
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bserver=%b size=%d info=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(((List)localObject1).size()), localObject1.toString() }));
        }
        localObject1 = new TroopPhotoController.7(this, (List)localObject1);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label298;
        }
        ((Runnable)localObject1).run();
      }
    }
    return;
    label298:
    this.handler.post((Runnable)localObject1);
  }
  
  public void removeDataChangeListener(TroopPhotoController.OnDataChangeListener paramOnDataChangeListener)
  {
    this.mOnDataChangeListeners.remove(paramOnDataChangeListener);
  }
  
  public void setOnGotoBigPicListener(TroopPhotoController.OnGotoBigPicListener paramOnGotoBigPicListener)
  {
    if (paramOnGotoBigPicListener != null) {
      this.mOnGotoBigPicListener = new WeakReference(paramOnGotoBigPicListener);
    }
  }
  
  public void setUploadListener(TroopPhotoController.OnUploadListener paramOnUploadListener)
  {
    if (paramOnUploadListener != null) {
      this.mOnUploadListener = new WeakReference(paramOnUploadListener);
    }
  }
  
  public void startUpload()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, "startUpload");
    }
    AccountManager localAccountManager = (AccountManager)this.mApp.getManager(0);
    String str = TroopUtils.getLocalSkey(this.mApp);
    if (str == null)
    {
      localAccountManager.updateSKey(this.mAccountObserver);
      return;
    }
    startUpload(this.mUploadPaths, this.mTroopInfo.troopcode, str, this.mApp.getCurrentAccountUin());
  }
  
  public void startUpload(TroopClipPic paramTroopClipPic, String paramString1, String paramString2, String paramString3)
  {
    if ((paramTroopClipPic == null) || (paramString1 == null) || (paramString3 == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramTroopClipPic);
    this.mManger.a(TroopUploadingThread.class, this.mApp, localArrayList, paramString1, paramString2, paramString3, null);
  }
  
  public void startUpload(ArrayList<TroopClipPic> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayList == null) || (paramString1 == null) || (paramString3 == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TroopClipPic localTroopClipPic = (TroopClipPic)paramArrayList.next();
        ajnr localajnr = getItem(localTroopClipPic.ts);
        if ((localajnr != null) && (!localajnr.jdField_b_of_type_Boolean))
        {
          localajnr.jdField_b_of_type_Boolean = true;
          localArrayList.add(localTroopClipPic);
        }
      }
    } while (localArrayList.size() == 0);
    this.mManger.a(TroopUploadingThread.class, this.mApp, localArrayList, paramString1, paramString2, paramString3, null);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof bfed));
        paramObservable = (bfed)paramObject;
      } while (paramObservable.jdField_d_of_type_Int != this.mType);
      paramObject = getItem(paramObservable.jdField_a_of_type_Long);
    } while (paramObject == null);
    switch (paramObservable.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      paramObject.jdField_c_of_type_Int = paramObservable.jdField_b_of_type_Int;
      this.handler.post(new TroopPhotoController.1(this, paramObject, paramObservable));
      return;
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(paramObservable.jdField_b_of_type_Int), Integer.valueOf(paramObservable.jdField_c_of_type_Int), paramObject }));
      }
      int i = paramObservable.jdField_b_of_type_Int;
      paramObservable = new TroopPhotoController.2(this, paramObservable, paramObject, i);
      this.handler.post(paramObservable);
      ajpz.a(i, paramObject.jdField_b_of_type_JavaLangString, this.mTroopInfo.troopuin);
      return;
    }
    bcef.b(this.mApp, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.mTroopInfo.troopuin, String.valueOf(paramObservable.jdField_b_of_type_Int), "", "");
    if (TextUtils.isEmpty(paramObservable.jdField_a_of_type_JavaLangString)) {}
    for (paramObservable = ajpz.a(this.mActivity, paramObservable.jdField_b_of_type_Int);; paramObservable = paramObservable.jdField_a_of_type_JavaLangString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("update() failed info=%s", new Object[] { paramObject }));
      }
      paramObservable = new TroopPhotoController.3(this, paramObject, paramObservable);
      this.handler.post(paramObservable);
      return;
    }
  }
  
  protected boolean update2DB(int paramInt, ajnr paramajnr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramajnr }));
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject = this.mInfos.iterator();
    int i = 0;
    ajnr localajnr;
    String str;
    while (((Iterator)localObject).hasNext())
    {
      localajnr = (ajnr)((Iterator)localObject).next();
      if (localajnr != null) {
        str = localajnr.jdField_c_of_type_JavaLangString;
      }
    }
    label439:
    for (;;)
    {
      try
      {
        j = Integer.parseInt(str);
        if ((str == null) || (j < 0)) {
          break label439;
        }
        if (localajnr.jdField_b_of_type_Int == 1)
        {
          TroopClipPic localTroopClipPic = new TroopClipPic();
          localTroopClipPic.id = str;
          localTroopClipPic.clipInfo = localajnr.jdField_d_of_type_JavaLangString;
          localTroopClipPic.type = localajnr.jdField_d_of_type_Int;
          localArrayList.add(localTroopClipPic);
          if (localajnr.jdField_c_of_type_Boolean) {
            localHashSet.add(str);
          }
        }
        if (!str.equals(String.valueOf(paramInt))) {
          break label439;
        }
        i = 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int j = -1;
        continue;
      }
      if (i != 0)
      {
        this.mInfos.remove(paramajnr);
        notifyDel(paramajnr);
        return false;
      }
      paramajnr.jdField_c_of_type_JavaLangString = String.valueOf(paramInt);
      paramajnr.jdField_b_of_type_Int = 1;
      paramajnr.jdField_a_of_type_Boolean = false;
      localObject = new TroopClipPic();
      ((TroopClipPic)localObject).id = paramajnr.jdField_c_of_type_JavaLangString;
      ((TroopClipPic)localObject).type = paramajnr.jdField_d_of_type_Int;
      ((TroopClipPic)localObject).clipInfo = paramajnr.jdField_d_of_type_JavaLangString;
      localArrayList.add(localObject);
      if (paramajnr.jdField_c_of_type_Boolean) {
        localHashSet.add(paramajnr.jdField_c_of_type_JavaLangString);
      }
      if (this.mApp != null)
      {
        paramajnr = (TroopManager)this.mApp.getManager(52);
        if (paramajnr != null)
        {
          localObject = paramajnr.b(String.valueOf(this.mTroopInfo.troopuin));
          if ((localObject != null) && (localArrayList.size() > 0))
          {
            ((TroopInfo)localObject).mTroopPicList.clear();
            ((TroopInfo)localObject).mTroopPicList.addAll(localArrayList);
            ((TroopInfo)localObject).mTroopVerifyingPics.clear();
            ((TroopInfo)localObject).mTroopVerifyingPics.addAll(localHashSet);
            ThreadManager.post(new TroopPhotoController.4(this, paramajnr, (TroopInfo)localObject), 8, null, false);
          }
        }
      }
      return true;
    }
  }
  
  protected void updateTroopInfo()
  {
    this.mTroopInfo = ((TroopManager)this.mApp.getManager(52)).b(String.valueOf(this.mTroopUin));
    this.mTroopInfoData = new TroopInfoData();
    this.mTroopInfoData.troopUin = this.mTroopUin;
    this.mTroopInfoData.updateForTroopChatSetting(this.mTroopInfo, this.mCtx.getResources(), this.mApp.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController
 * JD-Core Version:    0.7.0.1
 */