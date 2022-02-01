package com.tencent.av.ui.effect.toolbar.newversion;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.opengl.effects.TipsInfo;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.QavListItemHelper;
import com.tencent.av.ui.effect.adapter.MaterialTabAdapter;
import com.tencent.av.ui.effect.data.MaterialCategory;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.ui.effect.view.EffectViewPager;
import com.tencent.av.ui.effect.view.QavEffectSlidingTabView;
import com.tencent.av.ui.effect.view.QavEffectSlidingTabView.IOnTabCheckListener;
import com.tencent.av.ui.effect.view.QavEffectSlidingTabView.TabIcon;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.VideoUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Avatar2dToolbarV2
  extends BaseToolbarNewVersion
  implements ViewTreeObserver.OnScrollChangedListener, ViewPager.OnPageChangeListener, EffectConfigBase.IEffectConfigCallback<Avatar2dItem>, IItemDownloadMgr, QavEffectSlidingTabView.IOnTabCheckListener
{
  public static final String AVATAR2D_BG_CATEGORY = "10002";
  public static final String AVATAR2D_FIGURE_CATEGORY = "10001";
  public static final int AVATAR_BG_TAB_INDEX = 1;
  public static final int AVATAR_FIGURE_TAB_INDEX = 0;
  public static final String TAG = "Avatar2dToolbarV2";
  IEffectCallback mEffectClickCallback = new Avatar2dToolbarV2.7(this);
  private boolean mIsOpenAvatar2DRspRecv = false;
  private QavListItemBase.ItemInfo mItemInfoWaitToSet = null;
  private EffectAvatar2dManager mManager = null;
  private ViewGroup mMaterialListContainer;
  private EffectMaterialManager mMaterialManager = null;
  private MaterialTabAdapter mPageAdapter;
  private List<MaterialCategory> mTabList = new CopyOnWriteArrayList();
  private ViewGroup mTipsContainer;
  private Button mTipsHandleButton;
  private TextView mTipsTextView;
  private QavEffectSlidingTabView mTopTabBar;
  BaseToolbar.UIInfo mUIInfo = null;
  private EffectViewPager mViewPager;
  
  public Avatar2dToolbarV2(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<MaterialCategory> constructCategory()
  {
    ArrayList localArrayList = new ArrayList();
    MaterialCategory localMaterialCategory = new MaterialCategory();
    localMaterialCategory.c = true;
    localMaterialCategory.b = getAVActivity().getResources().getString(2131893208);
    localMaterialCategory.a = "10001";
    localMaterialCategory.d = new ArrayList(getAvatar2dItemList("10001"));
    localArrayList.add(localMaterialCategory);
    if (localMaterialCategory.d.size() >= 1)
    {
      localMaterialCategory = new MaterialCategory();
      localMaterialCategory.b = getAVActivity().getResources().getString(2131893207);
      localMaterialCategory.c = true;
      localMaterialCategory.a = "10002";
      localMaterialCategory.d = new ArrayList(getAvatar2dItemList("10002"));
      localArrayList.add(localMaterialCategory);
    }
    return localArrayList;
  }
  
  private ArrayList<QavListItemBase.ItemInfo> getAvatar2dItemList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject1).a = "0";
    ((QavListItemBase.ItemInfo)localObject1).f = getType(paramString);
    int i;
    if ("10002".equals(paramString)) {
      i = 2130843208;
    } else {
      i = 2130843205;
    }
    ((QavListItemBase.ItemInfo)localObject1).b = String.valueOf(i);
    ((QavListItemBase.ItemInfo)localObject1).k = HardCodeUtil.a(2131902029);
    localArrayList.add(localObject1);
    localObject1 = this.mManager.c(null);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addItem_with_Double_Video_type, size[");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        ((StringBuilder)localObject2).append("]");
        QLog.i("Avatar2dToolbarV2", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Avatar2dItem)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((Avatar2dItem)localObject2).b())) && (TextUtils.equals(((Avatar2dItem)localObject2).b(), paramString))) {
          localArrayList.add(QavListItemHelper.a(getType(paramString), (Avatar2dItem)localObject2, true));
        }
      }
    }
    return localArrayList;
  }
  
  private ArrayList<QavEffectSlidingTabView.TabIcon> getTabNameList()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mTabList.size())
    {
      MaterialCategory localMaterialCategory = (MaterialCategory)this.mTabList.get(i);
      if (localMaterialCategory != null)
      {
        QavEffectSlidingTabView.TabIcon localTabIcon = new QavEffectSlidingTabView.TabIcon();
        localTabIcon.a = localMaterialCategory.b;
        if ("10001".equals(localMaterialCategory.a)) {
          localTabIcon.b = isShowRedDot(13);
        } else if ("10002".equals(localMaterialCategory.a)) {
          localTabIcon.b = isShowRedDot(14);
        }
        localArrayList.add(localTabIcon);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private int getType(String paramString)
  {
    if ("10001".equals(paramString)) {
      return 6;
    }
    if ("10002".equals(paramString)) {
      return 7;
    }
    QLog.e("Avatar2dToolbarV2", 1, " getType: invalid categoryId");
    return -1;
  }
  
  private void setLastItem()
  {
    Avatar2dItem localAvatar2dItem = (Avatar2dItem)((EffectAvatar2dManager)this.mApp.c(16)).c();
    String str2 = "0";
    String str1;
    if (localAvatar2dItem == null) {
      str1 = "0";
    } else {
      str1 = localAvatar2dItem.getId();
    }
    if (localAvatar2dItem != null) {
      str2 = localAvatar2dItem.d();
    }
    this.mMaterialManager.d(str1);
    this.mMaterialManager.e(str2);
    this.mMaterialManager.l();
  }
  
  private void updateCurrentItemInfo(QavListItemBase.ItemInfo paramItemInfo, long paramLong)
  {
    if (paramItemInfo == null) {
      return;
    }
    boolean bool = TextUtils.equals("0", paramItemInfo.a);
    Avatar2dItem localAvatar2dItem = null;
    if (bool)
    {
      paramItemInfo = this.mManager;
      if (paramItemInfo != null) {
        paramItemInfo.a(paramLong, null);
      }
    }
    else
    {
      EffectAvatar2dManager localEffectAvatar2dManager = this.mManager;
      if (localEffectAvatar2dManager != null) {
        localAvatar2dItem = (Avatar2dItem)localEffectAvatar2dManager.b(paramItemInfo.a);
      }
      if (localAvatar2dItem != null)
      {
        if (TextUtils.isEmpty(localAvatar2dItem.getId())) {
          return;
        }
        if (this.mManager != null)
        {
          localAvatar2dItem.i(getBgMaterialPath(this.mMaterialManager.r()));
          localAvatar2dItem.j(this.mMaterialManager.r());
          this.mManager.a(paramLong, localAvatar2dItem);
        }
      }
    }
  }
  
  int getAudioOrVideo()
  {
    VideoAppInterface localVideoAppInterface = this.mApp;
    int j = 1;
    int i = j;
    if (localVideoAppInterface != null)
    {
      i = j;
      if (this.mApp.b() != null)
      {
        i = j;
        if (this.mApp.b().k() != null)
        {
          if (this.mApp.b().k().g == 1) {
            return 1;
          }
          i = 2;
        }
      }
    }
    return i;
  }
  
  public String getBgMaterialPath(String paramString)
  {
    paramString = (Avatar2dItem)this.mManager.b(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mManager.a(paramString));
      localStringBuilder.append(paramString.a());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString.a());
      localStringBuilder.append(".pag");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 9;
      localUIInfo.h = 2131625728;
      localUIInfo.f = 0;
      localUIInfo.g = this.mApp.getApp().getString(2131893677);
    }
    return this.mUIInfo;
  }
  
  boolean isCameraOpened(long paramLong)
  {
    if (getAVActivity() != null) {
      return CameraUtils.a(getAVActivity()).isCameraOpened(paramLong);
    }
    return false;
  }
  
  public void notifyOpenAvatar2DRspStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == paramBoolean2) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    this.mIsOpenAvatar2DRspRecv = paramBoolean2;
    if (!paramBoolean1)
    {
      EffectMaterialManager localEffectMaterialManager = this.mMaterialManager;
      if (localEffectMaterialManager != null) {
        localEffectMaterialManager.q();
      }
      this.mManager.a(false);
      return;
    }
    updateCurrentItemInfo(this.mItemInfoWaitToSet, AudioHelper.c());
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mManager = ((EffectAvatar2dManager)this.mApp.c(16));
    this.mMaterialManager = ((EffectMaterialManager)this.mApp.c(15));
    this.mMaterialListContainer = ((ViewGroup)this.toolbarView.findViewById(2131444982));
    this.mTopTabBar = ((QavEffectSlidingTabView)this.toolbarView.findViewById(2131447748));
    this.mTopTabBar.setTabCheckListener(this);
    this.mTopTabBar.getViewTreeObserver().addOnScrollChangedListener(this);
    this.mTopTabBar.setInterceptor(new Avatar2dToolbarV2.1(this));
    this.mViewPager = ((EffectViewPager)this.toolbarView.findViewById(2131449829));
    this.mPageAdapter = new MaterialTabAdapter(getAVActivity(), this.mApp, 6);
    this.mPageAdapter.a(this);
    this.mPageAdapter.a(this.mEffectClickCallback);
    this.mPageAdapter.a(this.mTabList);
    this.mViewPager.setOnPageChangeListener(this);
    this.mViewPager.setAdapter(this.mPageAdapter);
    this.mTipsContainer = ((ViewGroup)this.toolbarView.findViewById(2131437581));
    this.mTipsTextView = ((TextView)this.toolbarView.findViewById(2131448810));
    this.mTipsHandleButton = ((Button)this.toolbarView.findViewById(2131430061));
    updateData();
    this.mMaterialManager.d(null);
    this.mMaterialManager.e(null);
    if (isShowRedDot(13)) {
      AVRedTouchUtil.b(this.mApp, 13);
    }
    this.mIsOpenAvatar2DRspRecv = this.mApp.b().k().cv;
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mManager.b(paramLong, this);
    this.mMaterialManager.s();
    this.mIsOpenAvatar2DRspRecv = false;
    this.mMaterialManager.d(null);
    this.mMaterialManager.e(null);
  }
  
  public void onDownloadFinish(long paramLong, Avatar2dItem paramAvatar2dItem, boolean paramBoolean)
  {
    MaterialTabAdapter localMaterialTabAdapter = this.mPageAdapter;
    if (localMaterialTabAdapter != null) {
      localMaterialTabAdapter.a(paramLong, paramAvatar2dItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide(long paramLong)
  {
    this.mManager.b(paramLong, this);
  }
  
  public void onItemSelectedChanged(long paramLong, Avatar2dItem paramAvatar2dItem)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemSelectedChanged, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], current[");
      localStringBuilder.append(paramAvatar2dItem);
      localStringBuilder.append("]");
      QLog.i("Avatar2dToolbarV2", 4, localStringBuilder.toString());
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    BaseToolbar.keepInToolbar(this.mApp, -1054L);
  }
  
  public void onPageSelected(int paramInt)
  {
    Avatar2dItem localAvatar2dItem = (Avatar2dItem)this.mManager.c();
    if ((paramInt == 1) && (localAvatar2dItem == null))
    {
      TipsInfo.a().b(BaseApplication.getContext().getString(2131893206));
      TipsInfo.a().a(1500);
      this.mViewPager.setCurrentItem(0);
      return;
    }
    this.mTopTabBar.a(paramInt);
  }
  
  public void onProgressUpdate(Avatar2dItem paramAvatar2dItem, int paramInt)
  {
    MaterialTabAdapter localMaterialTabAdapter = this.mPageAdapter;
    if (localMaterialTabAdapter != null) {
      localMaterialTabAdapter.a(paramAvatar2dItem.getId(), paramInt);
    }
  }
  
  public void onScrollChanged() {}
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mManager.a(paramLong, this);
    if ((this.mMaterialManager.t()) && (!isCameraOpened(paramLong))) {
      showFirstShowTip();
    } else if (!hasCameraPermission()) {
      showPermissionTip();
    } else {
      this.mTipsContainer.setVisibility(8);
    }
    setAvatar2DFirstTipsState();
    if (isCameraOpened(paramLong)) {
      this.mMaterialManager.u();
    }
    AVUtil.f(101);
    setLastItem();
  }
  
  public void onTabChecked(int paramInt)
  {
    this.mViewPager.setCurrentItem(paramInt);
    MaterialCategory localMaterialCategory = (MaterialCategory)this.mTabList.get(paramInt);
    if (("10001".equals(localMaterialCategory.a)) && (isShowRedDot(13)))
    {
      AVRedTouchUtil.b(this.mApp, 13);
      return;
    }
    if (("10002".equals(localMaterialCategory.a)) && (isShowRedDot(14))) {
      AVRedTouchUtil.b(this.mApp, 14);
    }
  }
  
  void requestCameraPermission(long paramLong)
  {
    Object localObject = getAVActivity();
    if (VideoUtil.a((Context)localObject))
    {
      Avatar2dToolbarV2.2 local2 = new Avatar2dToolbarV2.2(this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkSelfPermission, begin, permission[android.permission.CAMERA], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("Avatar2dToolbarV2", 1, localStringBuilder.toString());
      ((AVActivity)localObject).requestPermissions(local2, 0, new String[] { "android.permission.CAMERA" });
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkSelfPermission, fail, permission[android.permission.CAMERA], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("Avatar2dToolbarV2", 1, ((StringBuilder)localObject).toString());
  }
  
  void showFirstShowTip()
  {
    this.mTipsContainer.setVisibility(0);
    this.mTipsTextView.setText(Html.fromHtml(getAVActivity().getResources().getString(2131893121)));
    this.mTipsHandleButton.setText(getAVActivity().getResources().getString(2131890029));
    this.mTipsHandleButton.setOnClickListener(new Avatar2dToolbarV2.3(this));
    this.mTipsContainer.setOnTouchListener(new Avatar2dToolbarV2.4(this));
    ReportController.b(null, "dc00898", "", "", "0X800BCDF", "0X800BCDF", 1, 0, "", "", "", "");
  }
  
  void showPermissionTip()
  {
    this.mTipsContainer.setVisibility(0);
    this.mTipsTextView.setText(Html.fromHtml(getAVActivity().getResources().getString(2131893123)));
    this.mTipsHandleButton.setText(getAVActivity().getResources().getString(2131891076));
    this.mTipsHandleButton.setOnClickListener(new Avatar2dToolbarV2.5(this));
    this.mTipsContainer.setOnTouchListener(new Avatar2dToolbarV2.6(this));
    ReportController.b(null, "dc00898", "", "", "0X800BCE5", "0X800BCE5", 0, 0, "", "", "", "");
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (Avatar2dItem)this.mManager.b(paramItemInfo.a);
    if (paramAppInterface != null)
    {
      this.mManager.b(paramLong, paramAppInterface);
      return;
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("startDownloadTemplate, item为空, seq[");
    paramAppInterface.append(paramLong);
    paramAppInterface.append("]");
    QLog.w("Avatar2dToolbarV2", 1, paramAppInterface.toString());
    paramIDownloadCallback.a(paramLong, paramItemInfo.a, false);
  }
  
  public void updateData()
  {
    this.mTabList = new ArrayList(constructCategory());
    Object localObject = this.mPageAdapter;
    if (localObject != null)
    {
      ((MaterialTabAdapter)localObject).a(this.mTabList);
      this.mPageAdapter.notifyDataSetChanged();
    }
    localObject = this.mViewPager;
    if (localObject != null) {
      ((EffectViewPager)localObject).setAdapter(this.mPageAdapter);
    }
    localObject = this.mTopTabBar;
    if (localObject != null)
    {
      ((QavEffectSlidingTabView)localObject).a(getTabNameList());
      this.mTopTabBar.setTabCheckListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.Avatar2dToolbarV2
 * JD-Core Version:    0.7.0.1
 */