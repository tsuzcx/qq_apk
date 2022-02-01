package com.tencent.aelight.camera.aioeditor.capture.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.adapter.MusicProviderGridAdapter;
import com.tencent.aelight.camera.aioeditor.capture.adapter.MusicProviderPagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.DoodleMusicCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerSceneListener;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.LoadMusicStepListener;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ViewPagerScroller;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;

public class MusicProviderView
  extends ProviderView
  implements Handler.Callback, CaptureComboManager.CaptureComboListener, QIMSlidingTabView.IOnTabCheckListener, BounceViewPager.PageChangedObserver, AdapterView.OnItemClickListener
{
  public static boolean a = false;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  MusicProviderPagerAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter;
  public CaptureConfigUpdateObserver a;
  MusicPlayerSceneListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerSceneListener = new MusicProviderView.3(this);
  QIMMusicConfigManager.LoadMusicStepListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager$LoadMusicStepListener = new MusicProviderView.4(this);
  private QimMusicPlayer jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
  MusicDownloadListener jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener = new MusicProviderView.2(this);
  public MusicItemInfo a;
  BounceViewPager jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  List<DoodleMusicCategoryItem> jdField_a_of_type_JavaUtilList;
  public int b;
  public MusicItemInfo b;
  public boolean b;
  public int c;
  private MusicItemInfo c;
  public int d = -1;
  private boolean e = false;
  private boolean f = true;
  private boolean g;
  
  public MusicProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver = new MusicProviderView.1(this);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3) {
      return 5;
    }
    if ((paramInt != 4) && (paramInt != 12) && (paramInt != 8))
    {
      if (paramInt == 11) {
        return 4;
      }
      return 2;
    }
    return 3;
  }
  
  public static MusicItemInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = ((QIMMusicConfigManager)QIMManager.a(2)).a();
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        DoodleMusicCategoryItem localDoodleMusicCategoryItem = (DoodleMusicCategoryItem)localArrayList.get(i);
        if ((localDoodleMusicCategoryItem != null) && (localDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList != null))
        {
          int j = 0;
          while (j < localDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.size())
          {
            MusicItemInfo localMusicItemInfo = (MusicItemInfo)localDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.get(j);
            if ((localMusicItemInfo != null) && (paramString.equals(localMusicItemInfo.getLocalPath()))) {
              return localMusicItemInfo;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  private List<DoodleMusicCategoryItem> a(List<DoodleMusicCategoryItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(64);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DoodleMusicCategoryItem localDoodleMusicCategoryItem = (DoodleMusicCategoryItem)paramList.next();
      if (localDoodleMusicCategoryItem.jdField_b_of_type_Boolean)
      {
        localArrayList.add(localDoodleMusicCategoryItem);
        localStringBuilder.append(localDoodleMusicCategoryItem.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(",");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, new Object[] { "filterMusicList, ", localStringBuilder.toString() });
    }
    return localArrayList;
  }
  
  private void b(MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.a(107, new Object[] { paramMusicItemInfo });
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "initData");
    }
    Object localObject2 = ((QIMMusicConfigManager)QIMManager.a(2)).a();
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = a((List)localObject2);
    }
    Object localObject3 = null;
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundle(MusicProviderView.class.getSimpleName());
    } else {
      paramBundle = null;
    }
    localObject2 = localObject3;
    if (paramBundle != null)
    {
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        int j = 0;
        this.jdField_b_of_type_Int = paramBundle.getInt("capture_mode", 0);
        localObject2 = (MusicItemInfo)paramBundle.getParcelable("select_music");
        paramBundle = paramBundle.getString("select_music_local_path");
        if ((localObject2 != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((MusicItemInfo)localObject2).setPath(paramBundle);
        }
        this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
        if (localObject2 != null)
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("restore music");
            paramBundle.append(((MusicItemInfo)localObject2).mMusicName);
            QLog.i("MusicProviderView", 2, paramBundle.toString());
          }
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            paramBundle = (DoodleMusicCategoryItem)((List)localObject1).get(i);
            if (paramBundle.jdField_a_of_type_JavaLangString.equals(((MusicItemInfo)localObject2).mTagName)) {
              while (j < paramBundle.jdField_a_of_type_JavaUtilList.size())
              {
                if (((MusicItemInfo)localObject2).equals((MusicItemInfo)paramBundle.jdField_a_of_type_JavaUtilList.get(j)))
                {
                  this.jdField_c_of_type_Int = i;
                  this.d = j;
                }
                j += 1;
              }
            }
            i += 1;
          }
        }
      }
    }
    if (localObject2 == null) {
      new MusicItemInfo().mType = 2;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter == null) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    int k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter.a();
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter.a(i);
      if (localObject != null)
      {
        int m = ((GridView)localObject).getChildCount();
        int j = 0;
        while (j < m)
        {
          View localView = ((GridView)localObject).getChildAt(j);
          ((MusicProviderGridAdapter)((GridView)localObject).getAdapter()).a(localView);
          j += 1;
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUI cost ");
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l);
      QLog.d("MusicProviderView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected int a()
  {
    return 2131560879;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager;
    if (localObject != null) {
      ((BounceViewPager)localObject).b(this);
    }
    ((QIMMusicConfigManager)QIMManager.a(2)).b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager$LoadMusicStepListener);
    if (this.jdField_g_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
      if (localObject != null) {
        ((QimMusicPlayer)localObject).e();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localObject != null)
    {
      ((QimMusicPlayer)localObject).b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerSceneListener);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt1 == 1001)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnActivityResult qqMusic resultCode = ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(", data = ");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.d("MusicProviderView", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if ((paramInt2 == 0) && (this.jdField_g_of_type_Int == 0))
    {
      paramIntent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
      if (paramIntent != null)
      {
        localObject = this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
        if (localObject == null)
        {
          paramIntent.a(this.jdField_g_of_type_Int);
          return;
        }
        if (localObject != null)
        {
          if ((this.f) && (!this.jdField_g_of_type_Boolean))
          {
            paramIntent.a((MusicItemInfo)localObject, this.jdField_g_of_type_Int);
            return;
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("selectCategoryAndItem category= ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" categoryName= ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",itemId=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("MusicProviderView", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    int k;
    int j;
    for (;;)
    {
      k = this.jdField_a_of_type_JavaUtilList.size();
      j = -1;
      if (i >= k) {
        break;
      }
      if (((paramInt != -1) && (((DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == paramInt)) || ((paramString1 != null) && (paramString1.equals(((DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))) {
        break label170;
      }
      i += 1;
    }
    i = 0;
    label170:
    a().onTabChecked(i);
    Object localObject = (DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    paramString1 = null;
    paramInt = j;
    try
    {
      k = Integer.valueOf(paramString2).intValue();
      paramInt = k;
      j = k;
      if (QLog.isColorLevel())
      {
        paramInt = k;
        paramString2 = new StringBuilder();
        paramInt = k;
        paramString2.append("selectCategoryAndItem itemID= ");
        paramInt = k;
        paramString2.append(k);
        paramInt = k;
        QLog.d("MusicProviderView", 2, paramString2.toString());
        j = k;
      }
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      j = paramInt;
    }
    paramInt = 0;
    while (paramInt < ((DoodleMusicCategoryItem)localObject).jdField_a_of_type_JavaUtilList.size())
    {
      paramString2 = (MusicItemInfo)((DoodleMusicCategoryItem)localObject).jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramString2.mItemId == j)
      {
        paramString1 = paramString2;
        break label341;
      }
      paramInt += 1;
    }
    paramInt = 0;
    label341:
    if ((paramString1 != null) && (QLog.isColorLevel()))
    {
      paramString2 = new StringBuilder();
      paramString2.append(hashCode());
      paramString2.append("selectCategoryAndItem itemInfo= ");
      paramString2.append(paramString1.mMusicName);
      paramString2.append(",index=");
      paramString2.append(i);
      paramString2.append(",pos=");
      paramString2.append(paramInt);
      QLog.d("MusicProviderView", 2, paramString2.toString());
    }
    if (paramString1 != null)
    {
      postDelayed(new MusicProviderView.5(this, paramInt), 500L);
      a(paramString1);
      h();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.setIndicateColor(getContext().getResources().getColor(2131166325));
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131560879, this, false));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager = ((BounceViewPager)this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter = new MusicProviderPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
    new ViewPagerScroller(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager);
    a(false);
    g();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicCaptureConfigUpdateObserver);
    paramBundle = (QIMMusicConfigManager)QIMManager.a(2);
    paramBundle.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQIMMusicConfigManager$LoadMusicStepListener);
    paramBundle.e();
    ((CaptureComboManager)QIMManager.a(5)).a(this);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer = ((QimMusicPlayer)QIMManager.a().c(8));
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerSceneListener);
    paramBundle = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    int i;
    if (this.jdField_g_of_type_Int == 0) {
      i = QQFilterRenderManagerHolder.jdField_b_of_type_Int;
    } else {
      i = QQFilterRenderManagerHolder.jdField_c_of_type_Int;
    }
    paramBundle.c(i);
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData) {}
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramComboSet = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
      if (paramComboSet != null) {
        paramComboSet.f();
      }
    }
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    a(paramMusicItemInfo, false);
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, boolean paramBoolean)
  {
    if (paramMusicItemInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 2, "startMusic itemInfo=null");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer = ((QimMusicPlayer)QIMManager.a().c(8));
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.b(paramMusicItemInfo))
    {
      if ((this.jdField_g_of_type_Int == 0) && (!paramBoolean))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(paramMusicItemInfo, this.jdField_g_of_type_Int);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(paramMusicItemInfo);
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.c(paramBoolean ^ true);
        }
      }
      if (QLog.isColorLevel())
      {
        paramMusicItemInfo = new StringBuilder();
        paramMusicItemInfo.append("startMusic checkMusicCanPlay mCaptureScene");
        paramMusicItemInfo.append(this.jdField_g_of_type_Int);
        QLog.d("MusicProviderView", 2, paramMusicItemInfo.toString());
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(paramMusicItemInfo, this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(paramMusicItemInfo);
      Message localMessage = Message.obtain(this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 6, paramMusicItemInfo);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(localMessage, 60000L);
      QIMCommonLoadingProgress.a(paramMusicItemInfo).a();
      if (QLog.isColorLevel())
      {
        paramMusicItemInfo = new StringBuilder();
        paramMusicItemInfo.append("startMusic requestDownLoadMusicInfo");
        paramMusicItemInfo.append(this.jdField_g_of_type_Int);
        QLog.d("MusicProviderView", 2, paramMusicItemInfo.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 2, "updateData MusicProviderView not init");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "updateData");
    }
    Object localObject = (QIMMusicConfigManager)QIMManager.a(2);
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem();
    this.jdField_a_of_type_JavaUtilList = ((QIMMusicConfigManager)localObject).a(paramBoolean);
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaUtilList);
    localObject = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      QIMSlidingItemView.SlidingItemData localSlidingItemData = new QIMSlidingItemView.SlidingItemData();
      localSlidingItemData.jdField_a_of_type_JavaLangString = ((DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
      if (((DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == 999)
      {
        localSlidingItemData.jdField_a_of_type_Int = 2130844598;
        localSlidingItemData.jdField_b_of_type_Int = 2130844599;
      }
      else
      {
        localSlidingItemData.jdField_a_of_type_Int = 0;
        localSlidingItemData.jdField_b_of_type_Int = 0;
      }
      ((ArrayList)localObject).add(localSlidingItemData);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.initTabItemsWithIconString((ArrayList)localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(j);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(j);
  }
  
  public void b()
  {
    super.b();
    QimMusicPlayer localQimMusicPlayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localQimMusicPlayer != null) {
      localQimMusicPlayer.a(this.jdField_g_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    jdField_a_of_type_Boolean = false;
  }
  
  public void b(int paramInt) {}
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
    ((CaptureComboManager)QIMManager.a(5)).a(this);
  }
  
  public boolean b()
  {
    QimMusicPlayer localQimMusicPlayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localQimMusicPlayer == null) {
      return false;
    }
    return localQimMusicPlayer.b();
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProviderShow isAccountChange=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" isInit=");
      localStringBuilder.append(d());
      QLog.i("MusicProviderView", 2, localStringBuilder.toString());
    }
    if ((this.e) && (d())) {
      a(false);
    } else {
      h();
    }
    this.e = false;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public void d()
  {
    super.d();
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "music tab onResume");
    }
    ((CaptureComboManager)QIMManager.a(5)).a(this);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localObject != null)
    {
      ((QimMusicPlayer)localObject).a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerSceneListener);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
      int i;
      if (this.jdField_g_of_type_Int == 0) {
        i = QQFilterRenderManagerHolder.jdField_b_of_type_Int;
      } else {
        i = QQFilterRenderManagerHolder.jdField_c_of_type_Int;
      }
      ((QimMusicPlayer)localObject).c(i);
    }
    if (this.jdField_g_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
      if ((localObject != null) && (this.f))
      {
        localObject = ((QimMusicPlayer)localObject).a();
        if ((localObject != null) && (((MusicItemInfo)localObject).mRecognitionOffset == -1.0F) && (!this.jdField_g_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.c();
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAdapterMusicProviderPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager != null)) {
      a(true);
    }
  }
  
  public void f()
  {
    if (QIMManager.a().a(5)) {
      ((CaptureComboManager)QIMManager.a().c(5)).b(this);
    }
    if (this.jdField_g_of_type_Int == 0)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
      if (localObject != null)
      {
        this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((QimMusicPlayer)localObject).a();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onStop  mSaveMusicInfo=");
          localObject = this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
          if (localObject != null) {
            localObject = ((MusicItemInfo)localObject).mMusicName;
          }
          localStringBuilder.append(localObject);
          QLog.d("MusicProviderView", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.b(this.jdField_g_of_type_Int);
      }
    }
  }
  
  public void g()
  {
    int i = this.jdField_c_of_type_Int;
    if (i != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(i);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMSlidingTabView.onTabChecked(this.jdField_c_of_type_Int);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 6: 
      paramMessage = (MusicItemInfo)paramMessage.obj;
      if (!paramMessage.isFileExist())
      {
        if (paramMessage.isDownloading())
        {
          Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
          if (localObject != null) {
            ((QimMusicPlayer)localObject).a(paramMessage);
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
          if ((localObject != null) && (TextUtils.equals(((MusicItemInfo)localObject).mMusicName, paramMessage.mMusicName))) {
            QQToast.a(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131707073), 0).a();
          }
          h();
          return false;
        }
      }
      else
      {
        QIMCommonLoadingProgress.a(paramMessage).b();
        return false;
      }
      break;
    case 5: 
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131707072), 0).a();
      h();
      return false;
    case 4: 
      if (paramMessage.obj != null)
      {
        b((MusicItemInfo)paramMessage.obj);
        return false;
      }
      break;
    case 3: 
      a(false);
      return false;
    case 2: 
      h();
      return false;
    case 1: 
      boolean bool;
      if ((getContext() instanceof AppActivity)) {
        bool = ((AppActivity)getContext()).isResume() ^ true;
      } else if (((getContext() instanceof BaseActivity)) && (!((BaseActivity)getContext()).isResume())) {
        bool = true;
      } else {
        bool = false;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, bool);
      h();
    }
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem() >= this.jdField_a_of_type_JavaUtilList.size()) {
      return;
    }
    paramAdapterView = (DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem());
    if (paramInt >= paramAdapterView.jdField_a_of_type_JavaUtilList.size()) {
      return;
    }
    ((QIMMusicConfigManager)QIMManager.a(2)).a = paramAdapterView;
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)paramAdapterView.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("onItemClick,  type:");
      paramAdapterView.append(localMusicItemInfo.mType);
      paramAdapterView.append("  ");
      paramAdapterView.append(localMusicItemInfo);
      QLog.d("MusicProviderView", 2, paramAdapterView.toString());
    }
    if (localMusicItemInfo.mType == 4)
    {
      paramAdapterView = (Activity)getContext();
      paramView = new Intent(paramAdapterView, QQBrowserActivity.class);
      paramInt = a(this.h);
      paramView.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { DeviceInfoUtil.a(), "", Integer.valueOf(paramInt) }));
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 1, new Object[] { "music busType:", Integer.valueOf(paramInt) });
      }
      if (SlideShowPhotoListManager.a().b() == 22) {
        LpReportInfo_pf00064.allReport(680, 3, 3);
      }
      paramView.putExtra("finish_animation_up_down", true);
      paramAdapterView.startActivityForResult(paramView, 1001);
      paramAdapterView.overridePendingTransition(2130771993, 0);
      return;
    }
    if (localMusicItemInfo.isWsBanner())
    {
      WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, localMusicItemInfo, 2);
      return;
    }
    if (localMusicItemInfo.mType == 3)
    {
      if (SlideShowPhotoListManager.a().b() == 22) {
        LpReportInfo_pf00064.allReport(680, 3, 2);
      }
    }
    else if ((localMusicItemInfo.mType == 1) && (SlideShowPhotoListManager.a().b() == 22)) {
      LpReportInfo_pf00064.allReport(680, 3, 4);
    }
    paramAdapterView = null;
    QimMusicPlayer localQimMusicPlayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localQimMusicPlayer != null) {
      paramAdapterView = localQimMusicPlayer.b();
    }
    if ((localMusicItemInfo.mType == 5) && ((localMusicItemInfo.equals(paramAdapterView)) || (!localMusicItemInfo.isFileExist())))
    {
      b(localMusicItemInfo);
      return;
    }
    paramView.setSelected(true);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    h();
    ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_g_of_type_Int, (Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void onTabChecked(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.setCurrentItem(paramInt);
    }
  }
  
  public void setChangeMusicEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setIsGuideMode(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setPreSelectTagIndex(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView
 * JD-Core Version:    0.7.0.1
 */