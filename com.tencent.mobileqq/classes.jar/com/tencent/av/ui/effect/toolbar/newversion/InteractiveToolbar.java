package com.tencent.av.ui.effect.toolbar.newversion;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.adapter.MaterialTabAdapter;
import com.tencent.av.ui.effect.data.MaterialCategory;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.ui.effect.view.EffectViewPager;
import com.tencent.av.ui.effect.view.QavEffectSlidingTabView;
import com.tencent.av.ui.effect.view.QavEffectSlidingTabView.IOnTabCheckListener;
import com.tencent.av.ui.effect.view.QavEffectSlidingTabView.TabIcon;
import com.tencent.av.utils.AVUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InteractiveToolbar
  extends BaseToolbarNewVersion
  implements ViewTreeObserver.OnScrollChangedListener, ViewPager.OnPageChangeListener, EffectConfigBase.IEffectConfigCallback<FaceItem>, IItemDownloadMgr, QavEffectSlidingTabView.IOnTabCheckListener
{
  public static final String DOUBLE_PENDANT_CATEGORY = "900003";
  public static final String MAGIC_STICKER_CATEGORY = "900001";
  public static final String MULTI_SCREEN_INTERACT_CATEGORY = "900002";
  public static final int TAB_DOUBLE_PENDANT_INDEX = 2;
  public static final int TAB_MAGIC_STICKER_INDEX = 0;
  public static final int TAB_MULTI_SCREEN_INTERACT_INDEX = 1;
  public static final String TAG = "InteractiveToolbar";
  static String unableInfo;
  private String mCurrentSelectCategory = "900001";
  EffectFaceManager mFaceManager;
  IEffectCallback mInteractiveClickCallback = new InteractiveToolbar.1(this);
  QavListItemBase.ItemInfo mLastClickItemInfo = null;
  EffectMaterialManager mMaterialManager;
  private MaterialTabAdapter mPageAdapter;
  EffectSupportManager mSupportManager;
  private List<MaterialCategory> mTabList = new ArrayList();
  private QavEffectSlidingTabView mTopTabBar;
  private BaseToolbar.UIInfo mUIInfo;
  private EffectViewPager mViewPager;
  
  public InteractiveToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<MaterialCategory> constructCategory()
  {
    boolean bool = EffectsRenderController.c();
    ArrayList localArrayList = new ArrayList();
    MaterialCategory localMaterialCategory = new MaterialCategory();
    localMaterialCategory.c = false;
    localMaterialCategory.b = "魔法贴纸";
    localMaterialCategory.a = "900001";
    localMaterialCategory.d = new ArrayList(getList("voicesticker"));
    localArrayList.add(localMaterialCategory);
    localMaterialCategory = new MaterialCategory();
    localMaterialCategory.b = "跨屏互动";
    localMaterialCategory.c = false;
    localMaterialCategory.a = "900002";
    localMaterialCategory.d = new ArrayList(getList("face"));
    localArrayList.add(localMaterialCategory);
    if (bool)
    {
      localMaterialCategory = new MaterialCategory();
      localMaterialCategory.b = "双人挂件";
      localMaterialCategory.a = "900003";
      localMaterialCategory.d = new ArrayList(getList("pendant"));
      localArrayList.add(localMaterialCategory);
    }
    return localArrayList;
  }
  
  private int getFromType(String paramString)
  {
    if ("900003".equals(paramString)) {
      return 1001;
    }
    if ("900002".equals(paramString)) {
      return 1002;
    }
    if ("900001".equals(paramString)) {
      return 1003;
    }
    return -1;
  }
  
  private ArrayList<QavListItemBase.ItemInfo> getList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool2 = PtuResChecker.a().b();
    boolean bool3 = this.mSupportManager.a(3, "normal");
    boolean bool4 = this.mSupportManager.a(3, "interact");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getList, type[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], supportNormal[");
    ((StringBuilder)localObject).append(bool3);
    ((StringBuilder)localObject).append("], supportInteract[");
    ((StringBuilder)localObject).append(bool4);
    ((StringBuilder)localObject).append("], supportCreative[");
    ((StringBuilder)localObject).append(false);
    ((StringBuilder)localObject).append("], isSOExist[");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append("]");
    QLog.w("InteractiveToolbar", 1, ((StringBuilder)localObject).toString());
    if ("pendant".equals(paramString))
    {
      localObject = new QavListItemBase.ItemInfo();
      ((QavListItemBase.ItemInfo)localObject).a = "0";
      ((QavListItemBase.ItemInfo)localObject).b = String.valueOf(2130843209);
      ((QavListItemBase.ItemInfo)localObject).h = (bool4 ^ true);
      ((QavListItemBase.ItemInfo)localObject).k = this.mApp.getApp().getString(2131893183);
      localArrayList.add(localObject);
    }
    paramString = this.mFaceManager.c(paramString);
    if ((paramString != null) && (paramString.size() != 0))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = (FaceItem)paramString.next();
        if (((FaceItem)localObject).isShow())
        {
          boolean bool1;
          if ((bool4) && (bool2)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localArrayList.add(getListItemInfoFromEmotionInfo((FaceItem)localObject, bool3, bool1));
        }
      }
    }
    return localArrayList;
  }
  
  static QavListItemBase.ItemInfo getListItemInfoFromEmotionInfo(FaceItem paramFaceItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.f = 1;
    localItemInfo.a = paramFaceItem.getId();
    localItemInfo.c = paramFaceItem.getText();
    localItemInfo.b = paramFaceItem.getIconUrl();
    localItemInfo.g = paramFaceItem.getVipLevel();
    localItemInfo.k = paramFaceItem.getDesc();
    if ((paramBoolean1) && ((paramBoolean2) || (!paramFaceItem.isInteract()))) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    localItemInfo.h = paramBoolean1;
    if (localItemInfo.h) {
      localItemInfo.d = true;
    } else {
      localItemInfo.d = paramFaceItem.isUsable();
    }
    localItemInfo.m = paramFaceItem;
    return localItemInfo;
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
        localArrayList.add(localTabIcon);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String getUnableInfo(VideoController paramVideoController)
  {
    if (unableInfo == null) {
      isEnable(paramVideoController);
    }
    return unableInfo;
  }
  
  public static boolean isEnable(VideoController paramVideoController)
  {
    if ((paramVideoController != null) && (!paramVideoController.k().I))
    {
      unableInfo = paramVideoController.i().getString(2131893211);
      return false;
    }
    return true;
  }
  
  private void setLastItem()
  {
    Object localObject = (FaceItem)((EffectFaceManager)this.mApp.c(3)).c();
    if (localObject == null) {
      localObject = "0";
    } else {
      localObject = ((FaceItem)localObject).getId();
    }
    this.mMaterialManager.c((String)localObject);
    this.mMaterialManager.k();
  }
  
  void enterDoubleScreen()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.b().p(this.mApp.b().k().s));
    localStringBuilder.append("");
    MagicDataReport.a(localStringBuilder.toString());
    this.mApp.b().e(4, "1");
    ((AVActivity)this.mActivity.get()).a(2, false);
  }
  
  void enterOriginScreen()
  {
    ((AVActivity)this.mActivity.get()).h(false);
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 2;
      localUIInfo.h = 2131625730;
      localUIInfo.f = 2130842988;
      localUIInfo.g = this.mApp.getApp().getString(2131893679);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    return getUnableInfo(this.mApp.b());
  }
  
  public boolean isEffectBtnEnable()
  {
    return true ^ isOpenAvatar2D(true);
  }
  
  public boolean isEffectBtnNormal()
  {
    return (!isOpenAvatar2D(true)) && (isEnable(this.mApp.b()));
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject2);
    AVLog.printColorLog("InteractiveToolbar", localStringBuilder.toString());
    this.mApp.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    paramAVActivity = new StringBuilder();
    paramAVActivity.append("TAG, onCreate, seq[");
    paramAVActivity.append(paramLong);
    paramAVActivity.append("]");
    QLog.w("InteractiveToolbar", 1, paramAVActivity.toString());
    this.mFaceManager = ((EffectFaceManager)this.mApp.c(3));
    this.mSupportManager = ((EffectSupportManager)this.mApp.c(5));
    this.mMaterialManager = ((EffectMaterialManager)this.mApp.c(15));
    this.mTopTabBar = ((QavEffectSlidingTabView)this.toolbarView.findViewById(2131447748));
    this.mTopTabBar.setTabCheckListener(this);
    this.mTopTabBar.getViewTreeObserver().addOnScrollChangedListener(this);
    this.mViewPager = ((EffectViewPager)this.toolbarView.findViewById(2131449829));
    this.mPageAdapter = new MaterialTabAdapter(getAVActivity(), this.mApp, 2);
    this.mPageAdapter.a(this);
    this.mPageAdapter.a(this.mInteractiveClickCallback);
    this.mPageAdapter.a(new ArrayList());
    this.mViewPager.setOnPageChangeListener(this);
    this.mViewPager.setAdapter(this.mPageAdapter);
    this.mMaterialManager.c(null);
    updateData();
    paramAVActivity = (FaceItem)this.mFaceManager.c();
    if (paramAVActivity != null)
    {
      if (paramAVActivity.isSameType("pendant"))
      {
        this.mViewPager.setCurrentItem(2);
        return;
      }
      if (paramAVActivity.isSameType("face"))
      {
        this.mViewPager.setCurrentItem(1);
        return;
      }
      this.mViewPager.setCurrentItem(0);
      return;
    }
    this.mViewPager.setCurrentItem(0);
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mFaceManager.b(paramLong, this);
    this.mMaterialManager.c(null);
  }
  
  public void onDownloadFinish(long paramLong, FaceItem paramFaceItem, boolean paramBoolean)
  {
    MaterialTabAdapter localMaterialTabAdapter = this.mPageAdapter;
    if (localMaterialTabAdapter != null) {
      localMaterialTabAdapter.a(paramLong, paramFaceItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide(long paramLong)
  {
    this.mFaceManager.b(paramLong, this);
  }
  
  public void onItemSelectedChanged(long paramLong, FaceItem paramFaceItem)
  {
    setLastItem();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.mTopTabBar.a(paramInt);
    this.mCurrentSelectCategory = ((MaterialCategory)this.mTabList.get(paramInt)).a;
    MaterialCategory localMaterialCategory = (MaterialCategory)this.mTabList.get(paramInt);
    if ((!"900002".equals(localMaterialCategory.a)) && (!"900003".equals(localMaterialCategory.a))) {
      enterOriginScreen();
    } else {
      enterDoubleScreen();
    }
    paramInt = getFromType(localMaterialCategory.a);
    if (paramInt != -1) {
      ReportController.b(null, "dc00898", "", "", "0X800BC12", "0X800BC12", paramInt, 0, "", "", "", "");
    }
  }
  
  public void onProgressUpdate(FaceItem paramFaceItem, int paramInt)
  {
    MaterialTabAdapter localMaterialTabAdapter = this.mPageAdapter;
    if (localMaterialTabAdapter != null) {
      localMaterialTabAdapter.a(paramFaceItem.getId(), paramInt);
    }
  }
  
  public void onScrollChanged() {}
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mFaceManager.a(paramLong, this);
    if (((AVActivity)this.mActivity.get()).q())
    {
      if (this.mCurrentSelectCategory.equals("900001"))
      {
        QLog.w("InteractiveToolbar", 1, "onShow, 重新选择tab");
        this.mViewPager.setCurrentItem(0);
      }
    }
    else if ((this.mCurrentSelectCategory.equals("900002")) || (this.mCurrentSelectCategory.equals("900003"))) {
      enterDoubleScreen();
    }
    setLastItem();
    AVUtil.f(103);
  }
  
  public void onTabChecked(int paramInt)
  {
    this.mViewPager.setCurrentItem(paramInt);
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (FaceItem)this.mFaceManager.b(paramItemInfo.a);
    if (paramAppInterface != null)
    {
      this.mFaceManager.b(paramLong, paramAppInterface);
      return;
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("startDownloadTemplate, item为空, seq[");
    paramAppInterface.append(paramLong);
    paramAppInterface.append("]");
    QLog.w("InteractiveToolbar", 1, paramAppInterface.toString());
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
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.InteractiveToolbar
 * JD-Core Version:    0.7.0.1
 */