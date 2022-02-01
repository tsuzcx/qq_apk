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
  private QimMusicPlayer G;
  private boolean H = false;
  private MusicItemInfo I = null;
  private boolean J = true;
  private boolean K = false;
  BounceViewPager b;
  MusicProviderPagerAdapter c;
  List<DoodleMusicCategoryItem> d;
  int e = 0;
  WeakReferenceHandler f = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public MusicItemInfo g;
  public MusicItemInfo h;
  public int i = 0;
  public int j = -1;
  public int k = -1;
  public boolean l = true;
  long m;
  public CaptureConfigUpdateObserver n = new MusicProviderView.1(this);
  MusicDownloadListener o = new MusicProviderView.2(this);
  MusicPlayerSceneListener p = new MusicProviderView.3(this);
  QIMMusicConfigManager.LoadMusicStepListener q = new MusicProviderView.4(this);
  
  public MusicProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static MusicItemInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = ((QIMMusicConfigManager)QIMManager.a(2)).e();
    if (localArrayList != null)
    {
      int i1 = 0;
      while (i1 < localArrayList.size())
      {
        DoodleMusicCategoryItem localDoodleMusicCategoryItem = (DoodleMusicCategoryItem)localArrayList.get(i1);
        if ((localDoodleMusicCategoryItem != null) && (localDoodleMusicCategoryItem.d != null))
        {
          int i2 = 0;
          while (i2 < localDoodleMusicCategoryItem.d.size())
          {
            MusicItemInfo localMusicItemInfo = (MusicItemInfo)localDoodleMusicCategoryItem.d.get(i2);
            if ((localMusicItemInfo != null) && (paramString.equals(localMusicItemInfo.getLocalPath()))) {
              return localMusicItemInfo;
            }
            i2 += 1;
          }
        }
        i1 += 1;
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
      if (localDoodleMusicCategoryItem.e)
      {
        localArrayList.add(localDoodleMusicCategoryItem);
        localStringBuilder.append(localDoodleMusicCategoryItem.c);
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
    if (this.F != null) {
      this.F.a(107, new Object[] { paramMusicItemInfo });
    }
  }
  
  public static int c(int paramInt)
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
  
  private void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "initData");
    }
    Object localObject2 = ((QIMMusicConfigManager)QIMManager.a(2)).e();
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
        int i2 = 0;
        this.i = paramBundle.getInt("capture_mode", 0);
        localObject2 = (MusicItemInfo)paramBundle.getParcelable("select_music");
        paramBundle = paramBundle.getString("select_music_local_path");
        if ((localObject2 != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((MusicItemInfo)localObject2).setPath(paramBundle);
        }
        this.h = null;
        if (localObject2 != null)
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("restore music");
            paramBundle.append(((MusicItemInfo)localObject2).mMusicName);
            QLog.i("MusicProviderView", 2, paramBundle.toString());
          }
          int i1 = 0;
          while (i1 < ((List)localObject1).size())
          {
            paramBundle = (DoodleMusicCategoryItem)((List)localObject1).get(i1);
            if (paramBundle.c.equals(((MusicItemInfo)localObject2).mTagName)) {
              while (i2 < paramBundle.d.size())
              {
                if (((MusicItemInfo)localObject2).equals((MusicItemInfo)paramBundle.d.get(i2)))
                {
                  this.j = i1;
                  this.k = i2;
                }
                i2 += 1;
              }
            }
            i1 += 1;
          }
        }
      }
    }
    if (localObject2 == null) {
      new MusicItemInfo().mType = 2;
    }
    this.l = true;
  }
  
  private void j()
  {
    if (this.c == null) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    int i3 = this.c.a();
    int i1 = 0;
    Object localObject;
    while (i1 < i3)
    {
      localObject = this.c.a(i1);
      if (localObject != null)
      {
        int i4 = ((GridView)localObject).getChildCount();
        int i2 = 0;
        while (i2 < i4)
        {
          View localView = ((GridView)localObject).getChildAt(i2);
          ((MusicProviderGridAdapter)((GridView)localObject).getAdapter()).a(localView);
          i2 += 1;
        }
      }
      i1 += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUI cost ");
      ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l1);
      QLog.d("MusicProviderView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a()
  {
    super.a();
    if (this.s != null) {
      this.s.unRegistObserver(this.n);
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((BounceViewPager)localObject).b(this);
    }
    ((QIMMusicConfigManager)QIMManager.a(2)).b(this.q);
    if (this.D == 0)
    {
      localObject = this.G;
      if (localObject != null) {
        ((QimMusicPlayer)localObject).e();
      }
    }
    localObject = this.G;
    if (localObject != null)
    {
      ((QimMusicPlayer)localObject).b(this.p);
      this.G = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.v.onTabChecked(paramInt);
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
    if ((paramInt2 == 0) && (this.D == 0))
    {
      paramIntent = this.G;
      if (paramIntent != null)
      {
        localObject = this.I;
        if (localObject == null)
        {
          paramIntent.a(this.D);
          return;
        }
        if (localObject != null)
        {
          if ((this.J) && (!this.K))
          {
            paramIntent.a((MusicItemInfo)localObject, this.D);
            return;
          }
          this.G.a(this.I);
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
    int i1 = 0;
    int i3;
    int i2;
    for (;;)
    {
      i3 = this.d.size();
      i2 = -1;
      if (i1 >= i3) {
        break;
      }
      if (((paramInt != -1) && (((DoodleMusicCategoryItem)this.d.get(i1)).a == paramInt)) || ((paramString1 != null) && (paramString1.equals(((DoodleMusicCategoryItem)this.d.get(i1)).c)))) {
        break label170;
      }
      i1 += 1;
    }
    i1 = 0;
    label170:
    getmBottomTabBar().onTabChecked(i1);
    Object localObject = (DoodleMusicCategoryItem)this.d.get(this.b.getCurrentItem());
    paramString1 = null;
    paramInt = i2;
    try
    {
      i3 = Integer.valueOf(paramString2).intValue();
      paramInt = i3;
      i2 = i3;
      if (QLog.isColorLevel())
      {
        paramInt = i3;
        paramString2 = new StringBuilder();
        paramInt = i3;
        paramString2.append("selectCategoryAndItem itemID= ");
        paramInt = i3;
        paramString2.append(i3);
        paramInt = i3;
        QLog.d("MusicProviderView", 2, paramString2.toString());
        i2 = i3;
      }
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      i2 = paramInt;
    }
    paramInt = 0;
    while (paramInt < ((DoodleMusicCategoryItem)localObject).d.size())
    {
      paramString2 = (MusicItemInfo)((DoodleMusicCategoryItem)localObject).d.get(paramInt);
      if (paramString2.mItemId == i2)
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
      paramString2.append(i1);
      paramString2.append(",pos=");
      paramString2.append(paramInt);
      QLog.d("MusicProviderView", 2, paramString2.toString());
    }
    if (paramString1 != null)
    {
      postDelayed(new MusicProviderView.5(this, paramInt), 500L);
      a(paramString1);
      j();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.v.setTabCheckListener(this);
    this.v.setIndicateColor(getContext().getResources().getColor(2131167113));
    if (this.w == null) {
      this.b = ((BounceViewPager)LayoutInflater.from(getContext()).inflate(2131627202, this, false));
    } else {
      this.b = ((BounceViewPager)this.w);
    }
    this.c = new MusicProviderPagerAdapter(this.r, this);
    this.c.a(new ArrayList());
    this.c.a(this);
    this.b.a(this);
    this.b.setAdapter(this.c);
    a(this.b);
    new ViewPagerScroller(this.r).a(this.b);
    a(false);
    g();
    this.s.registObserver(this.n);
    paramBundle = (QIMMusicConfigManager)QIMManager.a(2);
    paramBundle.a(this.q);
    paramBundle.h();
    ((CaptureComboManager)QIMManager.a(5)).a(this);
    if (this.G == null) {
      this.G = ((QimMusicPlayer)QIMManager.a().d(8));
    }
    this.G.a(this.p);
    paramBundle = this.G;
    int i1;
    if (this.D == 0) {
      i1 = QQFilterRenderManagerHolder.b;
    } else {
      i1 = QQFilterRenderManagerHolder.c;
    }
    paramBundle.c(i1);
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData) {}
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramComboSet = this.G;
      if (paramComboSet != null) {
        paramComboSet.k();
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
    if (this.G == null) {
      this.G = ((QimMusicPlayer)QIMManager.a().d(8));
    }
    if (this.G.b(paramMusicItemInfo))
    {
      if ((this.D == 0) && (!paramBoolean))
      {
        this.G.a(paramMusicItemInfo, this.D);
      }
      else
      {
        this.G.a(paramMusicItemInfo);
        if (this.F != null) {
          this.F.c(paramBoolean ^ true);
        }
      }
      if (QLog.isColorLevel())
      {
        paramMusicItemInfo = new StringBuilder();
        paramMusicItemInfo.append("startMusic checkMusicCanPlay mCaptureScene");
        paramMusicItemInfo.append(this.D);
        QLog.d("MusicProviderView", 2, paramMusicItemInfo.toString());
      }
    }
    else
    {
      this.g = paramMusicItemInfo;
      this.G.a(paramMusicItemInfo, this.o);
      this.f.removeCallbacksAndMessages(paramMusicItemInfo);
      Message localMessage = Message.obtain(this.f, 6, paramMusicItemInfo);
      this.f.sendMessageDelayed(localMessage, 60000L);
      QIMCommonLoadingProgress.a(paramMusicItemInfo).a();
      if (QLog.isColorLevel())
      {
        paramMusicItemInfo = new StringBuilder();
        paramMusicItemInfo.append("startMusic requestDownLoadMusicInfo");
        paramMusicItemInfo.append(this.D);
        QLog.d("MusicProviderView", 2, paramMusicItemInfo.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!l())
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
    int i2 = this.b.getCurrentItem();
    this.d = ((QIMMusicConfigManager)localObject).a(paramBoolean);
    this.d = a(this.d);
    localObject = new ArrayList();
    int i1 = 0;
    while (i1 < this.d.size())
    {
      QIMSlidingItemView.SlidingItemData localSlidingItemData = new QIMSlidingItemView.SlidingItemData();
      localSlidingItemData.a = ((DoodleMusicCategoryItem)this.d.get(i1)).c;
      if (((DoodleMusicCategoryItem)this.d.get(i1)).a == 999)
      {
        localSlidingItemData.b = 2130845971;
        localSlidingItemData.c = 2130845972;
      }
      else
      {
        localSlidingItemData.b = 0;
        localSlidingItemData.c = 0;
      }
      ((ArrayList)localObject).add(localSlidingItemData);
      i1 += 1;
    }
    this.v.initTabItemsWithIconString((ArrayList)localObject);
    this.c.a(this.d);
    this.c.notifyDataSetChanged();
    this.b.setAdapter(this.c);
    this.v.onTabChecked(i2);
    this.b.setCurrentItem(i2);
  }
  
  public void b()
  {
    super.b();
    QimMusicPlayer localQimMusicPlayer = this.G;
    if (localQimMusicPlayer != null) {
      localQimMusicPlayer.a(this.D);
    }
    this.g = null;
    this.h = null;
    a = false;
  }
  
  public void b(int paramInt) {}
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
    ((CaptureComboManager)QIMManager.a(5)).a(this);
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProviderShow isAccountChange=");
      localStringBuilder.append(this.H);
      localStringBuilder.append(" isInit=");
      localStringBuilder.append(l());
      QLog.i("MusicProviderView", 2, localStringBuilder.toString());
    }
    if ((this.H) && (l())) {
      a(false);
    } else {
      j();
    }
    this.H = false;
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
    Object localObject = this.G;
    if (localObject != null)
    {
      ((QimMusicPlayer)localObject).a(this.p);
      localObject = this.G;
      int i1;
      if (this.D == 0) {
        i1 = QQFilterRenderManagerHolder.b;
      } else {
        i1 = QQFilterRenderManagerHolder.c;
      }
      ((QimMusicPlayer)localObject).c(i1);
    }
    if (this.D == 0)
    {
      localObject = this.G;
      if ((localObject != null) && (this.J))
      {
        localObject = ((QimMusicPlayer)localObject).i();
        if ((localObject != null) && (((MusicItemInfo)localObject).mRecognitionOffset == -1.0F) && (!this.K)) {
          this.G.a();
        }
      }
    }
    if ((this.c != null) && (this.b != null)) {
      a(true);
    }
  }
  
  public void f()
  {
    if (QIMManager.a().c(5)) {
      ((CaptureComboManager)QIMManager.a().d(5)).b(this);
    }
    if (this.D == 0)
    {
      Object localObject = this.G;
      if (localObject != null)
      {
        this.I = ((QimMusicPlayer)localObject).i();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onStop  mSaveMusicInfo=");
          localObject = this.I;
          if (localObject != null) {
            localObject = ((MusicItemInfo)localObject).mMusicName;
          }
          localStringBuilder.append(localObject);
          QLog.d("MusicProviderView", 2, localStringBuilder.toString());
        }
        this.G.b(this.D);
      }
    }
  }
  
  public void g()
  {
    int i1 = this.j;
    if (i1 != -1)
    {
      this.b.setCurrentItem(i1);
      this.v.onTabChecked(this.j);
    }
  }
  
  protected int getInflateLayout()
  {
    return 2131627202;
  }
  
  public boolean h()
  {
    QimMusicPlayer localQimMusicPlayer = this.G;
    if (localQimMusicPlayer == null) {
      return false;
    }
    return localQimMusicPlayer.l();
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
          Object localObject = this.G;
          if (localObject != null) {
            ((QimMusicPlayer)localObject).c(paramMessage);
          }
          localObject = this.g;
          if ((localObject != null) && (TextUtils.equals(((MusicItemInfo)localObject).mMusicName, paramMessage.mMusicName))) {
            QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131904913), 0).show();
          }
          j();
          return false;
        }
      }
      else
      {
        QIMCommonLoadingProgress.a(paramMessage).c();
        return false;
      }
      break;
    case 5: 
      QQToast.makeText(this.r, HardCodeUtil.a(2131904912), 0).show();
      j();
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
      j();
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
      a(this.g, bool);
      j();
    }
    return false;
  }
  
  public boolean i()
  {
    return this.J;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.b.getCurrentItem() >= this.d.size()) {
      return;
    }
    paramAdapterView = (DoodleMusicCategoryItem)this.d.get(this.b.getCurrentItem());
    if (paramInt >= paramAdapterView.d.size()) {
      return;
    }
    ((QIMMusicConfigManager)QIMManager.a(2)).e = paramAdapterView;
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)paramAdapterView.d.get(paramInt);
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
      paramInt = c(this.E);
      paramView.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { DeviceInfoUtil.b(), "", Integer.valueOf(paramInt) }));
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 1, new Object[] { "music busType:", Integer.valueOf(paramInt) });
      }
      if (SlideShowPhotoListManager.a().e() == 22) {
        LpReportInfo_pf00064.allReport(680, 3, 3);
      }
      paramView.putExtra("finish_animation_up_down", true);
      paramAdapterView.startActivityForResult(paramView, 1001);
      paramAdapterView.overridePendingTransition(2130771996, 0);
      return;
    }
    if (localMusicItemInfo.isWsBanner())
    {
      WeishiGuideUtils.a(this.r, localMusicItemInfo, 2);
      return;
    }
    if (localMusicItemInfo.mType == 3)
    {
      if (SlideShowPhotoListManager.a().e() == 22) {
        LpReportInfo_pf00064.allReport(680, 3, 2);
      }
    }
    else if ((localMusicItemInfo.mType == 1) && (SlideShowPhotoListManager.a().e() == 22)) {
      LpReportInfo_pf00064.allReport(680, 3, 4);
    }
    paramAdapterView = null;
    QimMusicPlayer localQimMusicPlayer = this.G;
    if (localQimMusicPlayer != null) {
      paramAdapterView = localQimMusicPlayer.j();
    }
    if ((localMusicItemInfo.mType == 5) && ((localMusicItemInfo.equals(paramAdapterView)) || (!localMusicItemInfo.isFileExist())))
    {
      b(localMusicItemInfo);
      return;
    }
    paramView.setSelected(true);
    this.g = localMusicItemInfo;
    a(this.g);
    j();
    ((CaptureComboManager)QIMManager.a(5)).a(this.D, (Activity)this.r);
  }
  
  public void onTabChecked(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > this.d.size()) {
        return;
      }
      this.e = paramInt;
      this.b.setCurrentItem(paramInt);
    }
  }
  
  public void setChangeMusicEnabled(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public void setIsGuideMode(boolean paramBoolean)
  {
    this.K = paramBoolean;
  }
  
  public void setPreSelectTagIndex(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView
 * JD-Core Version:    0.7.0.1
 */