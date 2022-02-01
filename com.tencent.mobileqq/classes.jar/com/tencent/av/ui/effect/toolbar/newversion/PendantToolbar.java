package com.tencent.av.ui.effect.toolbar.newversion;

import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.EffectController;
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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

public class PendantToolbar
  extends BaseToolbarNewVersion
  implements ViewTreeObserver.OnScrollChangedListener, ViewPager.OnPageChangeListener, EffectConfigBase.IEffectConfigCallback<PendantItem>, IItemDownloadMgr, QavEffectSlidingTabView.IOnTabCheckListener
{
  public static final String TAG = "PendantToolbar";
  IEffectCallback mEffectClickCallback = new PendantToolbar.2(this);
  private EffectMaterialManager mEffectMaterialManager;
  protected PendantToolbar.MyDataObserver mObserver;
  private MaterialTabAdapter mPageAdapter;
  private EffectPendantTools mPendantManager;
  private List<MaterialCategory> mTabList = new CopyOnWriteArrayList();
  private QavEffectSlidingTabView mTopTabBar;
  BaseToolbar.UIInfo mUIInfo = null;
  private EffectViewPager mViewPager;
  
  public PendantToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private void addRecent()
  {
    this.mEffectMaterialManager.a(new ArrayList(20));
    MaterialCategory localMaterialCategory = new MaterialCategory();
    localMaterialCategory.a = "-9999";
    localMaterialCategory.b = getAVActivity().getResources().getString(2131893220);
    Object localObject = constructItem("0", String.valueOf(2130843209), "", "");
    this.mEffectMaterialManager.c().add(localObject);
    localObject = this.mEffectMaterialManager.a(getAVActivity(), "recent_pendant_list_key", this.mTabList);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      this.mEffectMaterialManager.c().addAll((Collection)localObject);
    }
    localMaterialCategory.d = this.mEffectMaterialManager.c();
    this.mTabList.add(0, localMaterialCategory);
  }
  
  @Nullable
  private String getCurrentPendantId()
  {
    Object localObject = this.mPendantManager.k;
    StringBuilder localStringBuilder = null;
    if (localObject != null)
    {
      localObject = this.mPendantManager.k;
      this.mPendantManager.k = null;
    }
    else
    {
      PendantItem localPendantItem = (PendantItem)this.mPendantManager.c();
      localObject = localStringBuilder;
      if (localPendantItem != null) {
        if (!localPendantItem.isShow()) {
          localObject = localStringBuilder;
        } else {
          localObject = localPendantItem.getId();
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentPendantId, id[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      QLog.w("PendantToolbar", 1, localStringBuilder.toString());
    }
    return localObject;
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
  
  private void handlerObserver(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    if (((Integer)paramObservable[0]).intValue() != 168) {
      return;
    }
    paramObject = (FaceItem)paramObservable[1];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TYPE_NOTIFY_FACE_ITEM_STATE_CHANGE :");
    if (paramObject == null) {
      paramObservable = "null";
    } else {
      paramObservable = paramObject.getId();
    }
    localStringBuilder.append(paramObservable);
    AVLog.printAllUserLog("PendantToolbar", localStringBuilder.toString());
    if (paramObject != null) {
      setLastItem();
    }
  }
  
  private void postSetCurrentItemById(long paramLong, String paramString)
  {
    notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
    this.mApp.a().post(new PendantToolbar.1(this, paramString, paramLong));
    boolean bool3 = this.mApp.d(3);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString = (FaceItem)((EffectFaceManager)this.mApp.c(3)).c();
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramString.getId())) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("postSetCurrentItemById, isInDoubleScreenPendant[");
      paramString.append(bool1);
      paramString.append("], seq[");
      paramString.append(paramLong);
      paramString.append("]");
      QLog.w("PendantToolbar", 1, paramString.toString());
    }
    if (bool1) {
      VideoController.f().e(3, "START_0");
    }
  }
  
  private void recentPendantClickReport(PendantItem paramPendantItem)
  {
    if (paramPendantItem == null) {
      return;
    }
    int i = 0;
    int j = -1;
    while (i < this.mEffectMaterialManager.c().size())
    {
      if (((QavListItemBase.ItemInfo)this.mEffectMaterialManager.c().get(i)).a.equals(paramPendantItem.getId())) {
        j = i;
      }
      i += 1;
    }
    if (j != -1) {
      ReportController.b(null, "dc00898", "", "", "0X800BC11", "0X800BC11", 0, 0, String.valueOf(j), "", "", paramPendantItem.getName());
    }
  }
  
  private void setLastItem()
  {
    String str;
    if (this.mApp.d(3))
    {
      localObject = (FaceItem)((EffectFaceManager)this.mApp.c(3)).c();
      str = null;
      if (localObject != null)
      {
        if (!((FaceItem)localObject).isSameType("pendant"))
        {
          if (((FaceItem)localObject).isSameType("face")) {
            return;
          }
          if (!((FaceItem)localObject).isSameType("voicesticker")) {}
        }
      }
      else {
        str = getCurrentPendantId();
      }
    }
    else
    {
      str = getCurrentPendantId();
    }
    Object localObject = str;
    if (str == null) {
      localObject = "0";
    }
    this.mEffectMaterialManager.b((String)localObject);
    this.mEffectMaterialManager.p();
  }
  
  public ArrayList<MaterialCategory> constructCategory()
  {
    QavListItemBase.ItemInfo localItemInfo = constructItem("0", String.valueOf(2130843209), "", "");
    Object localObject1 = this.mPendantManager.c(null);
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      PendantItem localPendantItem = (PendantItem)((Iterator)localObject1).next();
      if (localPendantItem.isShow())
      {
        Object localObject2 = localArrayList.iterator();
        int i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          MaterialCategory localMaterialCategory = (MaterialCategory)((Iterator)localObject2).next();
          if (localMaterialCategory.a.equals(localPendantItem.getCategoryId()))
          {
            i = 1;
            localMaterialCategory.d.add(QavListItemHelper.a(0, localPendantItem));
          }
        }
        if (i == 0)
        {
          localObject2 = new MaterialCategory();
          ((MaterialCategory)localObject2).a = localPendantItem.getCategoryId();
          ((MaterialCategory)localObject2).b = localPendantItem.getCategoryName();
          ((MaterialCategory)localObject2).d.add(localItemInfo);
          ((MaterialCategory)localObject2).d.add(QavListItemHelper.a(0, localPendantItem));
          localArrayList.add(localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  public QavListItemBase.ItemInfo constructItem(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString3 = new QavListItemBase.ItemInfo();
    paramString3.a = paramString1;
    paramString3.c = paramString1;
    paramString3.b = paramString2;
    paramString3.e = false;
    return paramString3;
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 1;
      localUIInfo.h = 2131625731;
      localUIInfo.f = 2130843305;
      localUIInfo.g = this.mApp.getApp().getString(2131893688);
    }
    return this.mUIInfo;
  }
  
  public boolean isEffectBtnEnable()
  {
    return isOpenAvatar2D(false) ^ true;
  }
  
  public boolean isEffectBtnNormal()
  {
    if (isOpenAvatar2D(false)) {
      return false;
    }
    return super.isEffectBtnNormal();
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject1);
    AVLog.printColorLog("PendantToolbar", localStringBuilder.toString());
    this.mApp.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mPendantManager = ((EffectPendantTools)this.mApp.c(2));
    this.mEffectMaterialManager = ((EffectMaterialManager)this.mApp.c(15));
    this.mTabList = new ArrayList(constructCategory());
    addRecent();
    this.mTopTabBar = ((QavEffectSlidingTabView)this.toolbarView.findViewById(2131447748));
    this.mTopTabBar.setTabCheckListener(this);
    this.mTopTabBar.getViewTreeObserver().addOnScrollChangedListener(this);
    this.mTopTabBar.a(getTabNameList());
    this.mTopTabBar.setTabCheckListener(this);
    this.mViewPager = ((EffectViewPager)this.toolbarView.findViewById(2131449829));
    this.mPageAdapter = new MaterialTabAdapter(getAVActivity(), this.mApp, 1);
    this.mPageAdapter.a(this);
    this.mPageAdapter.a(this.mEffectClickCallback);
    this.mPageAdapter.a(this.mTabList);
    this.mViewPager.setOnPageChangeListener(this);
    this.mViewPager.setAdapter(this.mPageAdapter);
    if (this.mTabList.size() > this.mEffectMaterialManager.v()) {
      this.mViewPager.setCurrentItem(this.mEffectMaterialManager.v());
    }
    this.mObserver = new PendantToolbar.MyDataObserver(this);
    this.mEffectMaterialManager.b(null);
    setLastItem();
    AVUtil.f(100);
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mPendantManager.b(paramLong, this);
    this.mEffectMaterialManager.b(getAVActivity(), "recent_pendant_list_key", this.mEffectMaterialManager.c());
    this.mEffectMaterialManager.a(new ArrayList());
    this.mEffectMaterialManager.b(null);
  }
  
  public void onDownloadFinish(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if ((paramPendantItem != null) && (paramPendantItem.getId() != null))
    {
      localObject1 = this.mPendantManager.c(null).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PendantItem)((Iterator)localObject1).next();
        if (paramPendantItem.getId().equals(((PendantItem)localObject2).getId())) {
          ((PendantItem)localObject2).setUsable(true);
        }
      }
      localObject1 = this.mTabList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((MaterialCategory)((Iterator)localObject1).next()).d.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          QavListItemBase.ItemInfo localItemInfo = (QavListItemBase.ItemInfo)((Iterator)localObject2).next();
          if (paramPendantItem.getId().equals(localItemInfo.a)) {
            localItemInfo.d = true;
          }
        }
      }
    }
    Object localObject1 = this.mPageAdapter;
    if (localObject1 != null) {
      ((MaterialTabAdapter)localObject1).a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide(long paramLong)
  {
    this.mPendantManager.b(paramLong, this);
    this.mApp.b(this.mObserver);
  }
  
  public void onItemSelectedChanged(long paramLong, PendantItem paramPendantItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onItemSelectedChanged, current[");
    localStringBuilder.append(paramPendantItem);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("PendantToolbar", 1, localStringBuilder.toString());
    if (paramPendantItem == null)
    {
      paramPendantItem = VideoController.f().m(false);
      if (paramPendantItem != null) {
        paramPendantItem.a(paramLong);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    BaseToolbar.keepInToolbar(this.mApp, -1054L);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.mTopTabBar.a(paramInt);
    this.mEffectMaterialManager.c(paramInt);
    if (paramInt == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800BC10", "0X800BC10", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800BC0F", "0X800BC0F", 0, 0, "", "", ((MaterialCategory)this.mTabList.get(paramInt)).b, "");
  }
  
  public void onProgressUpdate(PendantItem paramPendantItem, int paramInt)
  {
    MaterialTabAdapter localMaterialTabAdapter = this.mPageAdapter;
    if (localMaterialTabAdapter != null) {
      localMaterialTabAdapter.a(paramPendantItem.getId(), paramInt);
    }
  }
  
  public void onScrollChanged() {}
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mPendantManager.a(paramLong, this);
    this.mApp.a(this.mObserver);
    setLastItem();
  }
  
  public void onTabChecked(int paramInt)
  {
    this.mViewPager.setCurrentItem(paramInt);
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (PendantItem)this.mPendantManager.b(paramItemInfo.a);
    if (paramAppInterface != null)
    {
      this.mPendantManager.b(paramLong, paramAppInterface);
      return;
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("startDownloadTemplate, item为空, seq[");
    paramAppInterface.append(paramLong);
    paramAppInterface.append("]");
    QLog.w("PendantToolbar", 1, paramAppInterface.toString());
    paramIDownloadCallback.a(paramLong, paramItemInfo.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.PendantToolbar
 * JD-Core Version:    0.7.0.1
 */