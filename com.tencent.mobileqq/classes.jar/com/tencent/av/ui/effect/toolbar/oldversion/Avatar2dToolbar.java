package com.tencent.av.ui.effect.toolbar.oldversion;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.opengl.effects.TipsInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.QavListItemHelper;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Avatar2dToolbar
  extends BaseToolbarOldVersion
  implements View.OnClickListener, EffectConfigBase.IEffectConfigCallback<Avatar2dItem>, IItemDownloadMgr
{
  public static final String TAG = "Avatar2dToolbar";
  private QAVPtvTemplateAdapter mAvatar2dAdapter;
  private QAVPtvTemplateAdapter mAvatar2dBgAdapter;
  FrameLayout mAvatar2dBgBtn;
  IEffectCallback mAvatar2dBgClickCallback = new Avatar2dToolbar.2(this);
  ArrayList<QavListItemBase.ItemInfo> mAvatar2dBgList;
  FrameLayout mAvatar2dBtn;
  IEffectCallback mAvatar2dClickCallback = new Avatar2dToolbar.1(this);
  ArrayList<QavListItemBase.ItemInfo> mAvatar2dList;
  private boolean mIsOpenAvatar2DRspRecv = false;
  private QavListItemBase.ItemInfo mItemInfoWaitToSet = null;
  View mLineAvatar2d;
  View mLineAvatar2dBg;
  private HorizontalListView mListView;
  private EffectAvatar2dManager mManager = null;
  private EffectMaterialManager mMaterialManager = null;
  int mSelectTab = 0;
  BaseToolbar.UIInfo mUIInfo = null;
  
  public Avatar2dToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<QavListItemBase.ItemInfo> getAvatar2dItemList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject1).a = "-1";
    localArrayList.add(localObject1);
    localObject1 = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject1).a = "0";
    ((QavListItemBase.ItemInfo)localObject1).b = String.valueOf(2130843209);
    ((QavListItemBase.ItemInfo)localObject1).k = HardCodeUtil.a(2131902029);
    ((QavListItemBase.ItemInfo)localObject1).f = getType(paramString);
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
        QLog.i("Avatar2dToolbar", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Avatar2dItem)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((Avatar2dItem)localObject2).b())) && (TextUtils.equals(((Avatar2dItem)localObject2).b(), paramString))) {
          localArrayList.add(QavListItemHelper.a(getType(paramString), (Avatar2dItem)localObject2, false));
        }
      }
    }
    return localArrayList;
  }
  
  private Avatar2dItem getCurrentAvatarItem()
  {
    Avatar2dItem localAvatar2dItem = (Avatar2dItem)this.mManager.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentAvatarId, item[");
      localStringBuilder.append(localAvatar2dItem);
      localStringBuilder.append("]");
      QLog.w("Avatar2dToolbar", 1, localStringBuilder.toString());
    }
    return localAvatar2dItem;
  }
  
  private int getType(String paramString)
  {
    if ("10001".equals(paramString)) {
      return 6;
    }
    if ("10002".equals(paramString)) {
      return 7;
    }
    QLog.e("Avatar2dToolbar", 1, " getType: invalid categoryId");
    return -1;
  }
  
  private void setLastItem(int paramInt)
  {
    String str1;
    if (getCurrentAvatarItem() == null) {
      str1 = null;
    } else {
      str1 = getCurrentAvatarItem().getId();
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = "0";
    }
    if (paramInt == 1)
    {
      setLastSelectedIndex(str2, this.mAvatar2dList, this.mAvatar2dAdapter, this.mListView);
      return;
    }
    if (paramInt == 2) {
      setLastSelectedIndex(str2, this.mAvatar2dBgList, this.mAvatar2dBgAdapter, this.mListView);
    }
  }
  
  static int setLastSelectedIndex(String paramString, ArrayList<QavListItemBase.ItemInfo> paramArrayList, QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter, HorizontalListView paramHorizontalListView)
  {
    int k = -1;
    int j = k;
    if (paramArrayList != null)
    {
      j = k;
      if (paramQAVPtvTemplateAdapter != null)
      {
        if (paramHorizontalListView == null) {
          return -1;
        }
        int i = 1;
        for (;;)
        {
          j = k;
          if (i >= paramArrayList.size()) {
            break;
          }
          if (((QavListItemBase.ItemInfo)paramArrayList.get(i)).a.equals(paramString))
          {
            j = i;
            break;
          }
          i += 1;
        }
        setSelectedListViewItemAndShow(paramHorizontalListView, paramQAVPtvTemplateAdapter, j);
      }
    }
    return j;
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
          paramItemInfo = getBgMaterialPath(this.mMaterialManager.r());
          localAvatar2dItem.j(this.mMaterialManager.r());
          localAvatar2dItem.i(paramItemInfo);
          this.mManager.a(paramLong, localAvatar2dItem);
        }
      }
    }
  }
  
  public void chooseTab(int paramInt)
  {
    if (this.mListView == null) {
      return;
    }
    if (this.mSelectTab != paramInt)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("chooseTab, tab[");
        ((StringBuilder)localObject).append(this.mSelectTab);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("]");
        QLog.w("Avatar2dToolbar", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.mLineAvatar2d;
      int j = 4;
      boolean bool2 = false;
      if (paramInt == 1) {
        i = 0;
      } else {
        i = 4;
      }
      ((View)localObject).setVisibility(i);
      localObject = this.mLineAvatar2dBg;
      int i = j;
      if (paramInt == 2) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      localObject = this.mAvatar2dBtn;
      if (paramInt == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((FrameLayout)localObject).setSelected(bool1);
      localObject = this.mAvatar2dBgBtn;
      boolean bool1 = bool2;
      if (paramInt == 2) {
        bool1 = true;
      }
      ((FrameLayout)localObject).setSelected(bool1);
      if (paramInt == 1)
      {
        this.mListView.setAdapter(this.mAvatar2dAdapter);
        this.mAvatar2dAdapter.notifyDataSetChanged();
      }
      else if (paramInt == 2)
      {
        this.mListView.setAdapter(this.mAvatar2dBgAdapter);
        this.mAvatar2dBgAdapter.notifyDataSetChanged();
      }
      this.mSelectTab = paramInt;
    }
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
      localUIInfo.h = 2131625723;
      localUIInfo.f = 2130843304;
      localUIInfo.g = this.mApp.getApp().getString(2131893677);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131893215);
    }
    return "";
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
      setLastSelectedIndex("0", this.mAvatar2dList, this.mAvatar2dAdapter, this.mListView);
      this.mManager.a(false);
      return;
    }
    updateCurrentItemInfo(this.mItemInfoWaitToSet, AudioHelper.c());
  }
  
  public void notifyPeerOpenAvatar2D()
  {
    QAVPtvTemplateAdapter localQAVPtvTemplateAdapter = this.mAvatar2dAdapter;
    if (localQAVPtvTemplateAdapter != null) {
      localQAVPtvTemplateAdapter.a(AudioHelper.c(), 2);
    }
  }
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.c();
    BaseToolbar.keepInToolbar(this.mApp, l);
    if (paramView.getId() == 2131429806) {
      chooseTab(1);
    } else if (paramView.getId() == 2131429807) {
      if (this.mManager.c() != null)
      {
        chooseTab(2);
      }
      else
      {
        TipsInfo.a().b(BaseApplication.getContext().getString(2131893206));
        TipsInfo.a().a(1500);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mManager = ((EffectAvatar2dManager)this.mApp.c(16));
    this.mMaterialManager = ((EffectMaterialManager)this.mApp.c(15));
    this.mSelectTab = 0;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131435195));
    HorizontalListView localHorizontalListView = this.mListView;
    int j = 1;
    localHorizontalListView.setStayDisplayOffsetZero(true);
    this.mLineAvatar2d = this.toolbarView.findViewById(2131437210);
    this.mLineAvatar2dBg = this.toolbarView.findViewById(2131437211);
    this.mAvatar2dBtn = ((FrameLayout)this.toolbarView.findViewById(2131429806));
    this.mAvatar2dBgBtn = ((FrameLayout)this.toolbarView.findViewById(2131429807));
    this.mAvatar2dBtn.setOnClickListener(this);
    this.mAvatar2dBgBtn.setOnClickListener(this);
    this.mAvatar2dList = getAvatar2dItemList("10001");
    this.mAvatar2dBgList = getAvatar2dItemList("10002");
    this.mAvatar2dAdapter = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mAvatar2dList, this.mListView);
    this.mAvatar2dAdapter.a(false);
    this.mAvatar2dAdapter.b(true);
    this.mAvatar2dAdapter.a(this.mAvatar2dClickCallback);
    this.mAvatar2dAdapter.a(this);
    this.mAvatar2dBgAdapter = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mAvatar2dBgList, this.mListView);
    this.mAvatar2dBgAdapter.a(false);
    this.mAvatar2dBgAdapter.b(true);
    this.mAvatar2dBgAdapter.a(this.mAvatar2dBgClickCallback);
    this.mAvatar2dBgAdapter.a(this);
    paramAVActivity = getCurrentAvatarItem();
    int i = j;
    if (paramAVActivity != null) {
      if (TextUtils.isEmpty(paramAVActivity.b()))
      {
        i = j;
      }
      else if ("10001".equals(paramAVActivity.b()))
      {
        i = j;
      }
      else
      {
        i = j;
        if ("10002".equals(paramAVActivity.b())) {
          i = 2;
        }
      }
    }
    chooseTab(i);
    setLastItem(i);
    this.mIsOpenAvatar2DRspRecv = this.mApp.b().k().cv;
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mManager.b(paramLong, this);
    this.mMaterialManager.s();
    this.mListView = null;
    this.mAvatar2dAdapter = null;
    this.mIsOpenAvatar2DRspRecv = false;
  }
  
  public void onDownloadFinish(long paramLong, Avatar2dItem paramAvatar2dItem, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFinish, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], isSuc[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], info[");
      ((StringBuilder)localObject).append(paramAvatar2dItem);
      ((StringBuilder)localObject).append("]");
      QLog.i("Avatar2dToolbar", 4, ((StringBuilder)localObject).toString());
    }
    if ("10001".equals(paramAvatar2dItem.b()))
    {
      localObject = this.mAvatar2dAdapter;
      if (localObject != null) {
        ((QAVPtvTemplateAdapter)localObject).a(paramLong, paramAvatar2dItem.getId(), paramBoolean);
      }
    }
    else if ("10002".equals(paramAvatar2dItem.b()))
    {
      localObject = this.mAvatar2dBgAdapter;
      if (localObject != null) {
        ((QAVPtvTemplateAdapter)localObject).a(paramLong, paramAvatar2dItem.getId(), paramBoolean);
      }
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
      QLog.i("Avatar2dToolbar", 4, localStringBuilder.toString());
    }
  }
  
  public void onProgressUpdate(Avatar2dItem paramAvatar2dItem, int paramInt)
  {
    QAVPtvTemplateAdapter localQAVPtvTemplateAdapter;
    if ("10001".equals(paramAvatar2dItem.b()))
    {
      localQAVPtvTemplateAdapter = this.mAvatar2dAdapter;
      if (localQAVPtvTemplateAdapter != null) {
        localQAVPtvTemplateAdapter.a(paramAvatar2dItem.getId(), paramInt);
      }
    }
    else if ("10002".equals(paramAvatar2dItem.b()))
    {
      localQAVPtvTemplateAdapter = this.mAvatar2dBgAdapter;
      if (localQAVPtvTemplateAdapter != null) {
        localQAVPtvTemplateAdapter.a(paramAvatar2dItem.getId(), paramInt);
      }
    }
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mManager.a(paramLong, this);
    setAvatar2DFirstTipsState();
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
    QLog.w("Avatar2dToolbar", 1, paramAppInterface.toString());
    paramIDownloadCallback.a(paramLong, paramItemInfo.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.Avatar2dToolbar
 * JD-Core Version:    0.7.0.1
 */