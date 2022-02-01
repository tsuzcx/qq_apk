package com.tencent.av.ui.effect.toolbar.newversion;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.adapter.MaterialAdapter;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.ui.effect.view.MaterialRecyclerView;
import com.tencent.av.utils.AVUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterToolbar
  extends BaseToolbarNewVersion
  implements EffectConfigBase.IEffectConfigCallback<FilterItem>, IItemDownloadMgr
{
  private MaterialAdapter mAdapter;
  Context mContext = null;
  IEffectCallback mFilterClickCallback = new FilterToolbar.1(this);
  private EffectFilterTools mFilterManager;
  private EffectMaterialManager mMaterialManager;
  private MaterialRecyclerView mRecyclerView;
  private BaseToolbar.UIInfo mUIInfo;
  
  public FilterToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private void setLastItem()
  {
    Object localObject = (FilterItem)this.mFilterManager.c();
    if (localObject == null) {
      localObject = "0";
    } else {
      localObject = ((FilterItem)localObject).getId();
    }
    this.mMaterialManager.f((String)localObject);
    this.mMaterialManager.m();
  }
  
  ArrayList<QavListItemBase.ItemInfo> convertItemInfo(List<FilterItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterItem localFilterItem = (FilterItem)paramList.next();
        QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
        localItemInfo.a = localFilterItem.getId();
        localItemInfo.b = localFilterItem.getNewIcon();
        localItemInfo.d = localFilterItem.isUsable();
        localItemInfo.c = localFilterItem.getDisplayName();
        localItemInfo.k = localFilterItem.getDesc();
        localItemInfo.f = 8;
        if ("EMPTY".equals(localItemInfo.a))
        {
          localItemInfo.d = true;
          localItemInfo.n = false;
        }
        else
        {
          localItemInfo.n = true;
        }
        localArrayList.add(localItemInfo);
      }
    }
    return localArrayList;
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 8;
      localUIInfo.h = 2131625729;
      localUIInfo.f = 2130842979;
      localUIInfo.g = this.mApp.getApp().getString(2131893678);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131893217);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    if (QLog.isColorLevel())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isEffectBtnEnable : ");
      localStringBuilder.append(isOpenAvatar2D(true) ^ true);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return isOpenAvatar2D(true) ^ true;
  }
  
  public boolean isEffectBtnNormal()
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isEffectBtnNormal : ");
      if ((!isOpenAvatar2D(true)) && (EffectFilterTools.a(this.mContext))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    bool1 = bool2;
    if (!isOpenAvatar2D(true))
    {
      bool1 = bool2;
      if (EffectFilterTools.a(this.mContext)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mContext = paramAVActivity;
    this.mRecyclerView = ((MaterialRecyclerView)this.toolbarView.findViewById(2131438905));
    this.mFilterManager = ((EffectFilterTools)this.mApp.c(1));
    this.mMaterialManager = ((EffectMaterialManager)this.mApp.c(15));
    ArrayList localArrayList = convertItemInfo(this.mFilterManager.c(null));
    this.mAdapter = new MaterialAdapter(this.mApp, paramAVActivity, localArrayList, this.mRecyclerView, 3, false);
    this.mAdapter.a(this.mFilterClickCallback);
    this.mAdapter.a(this);
    this.mRecyclerView.setAdapter(this.mAdapter);
    this.mMaterialManager.f(null);
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mFilterManager.b(paramLong, this);
    this.mMaterialManager.f(null);
  }
  
  public void onDownloadFinish(long paramLong, FilterItem paramFilterItem, boolean paramBoolean)
  {
    MaterialAdapter localMaterialAdapter = this.mAdapter;
    if (localMaterialAdapter != null) {
      localMaterialAdapter.a(paramLong, paramFilterItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide(long paramLong)
  {
    this.mFilterManager.b(paramLong, this);
  }
  
  public void onItemSelectedChanged(long paramLong, FilterItem paramFilterItem)
  {
    setLastItem();
  }
  
  public void onProgressUpdate(FilterItem paramFilterItem, int paramInt)
  {
    MaterialAdapter localMaterialAdapter = this.mAdapter;
    if (localMaterialAdapter != null) {
      localMaterialAdapter.a(paramFilterItem.getId(), paramInt);
    }
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mFilterManager.a(paramLong, this);
    setLastItem();
    AVUtil.f(104);
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (FilterItem)this.mFilterManager.b(paramItemInfo.a);
    if (paramAppInterface != null)
    {
      this.mFilterManager.b(paramLong, paramAppInterface);
      return;
    }
    paramAppInterface = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownloadTemplate, item为空, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(paramAppInterface, 1, localStringBuilder.toString());
    paramIDownloadCallback.a(paramLong, paramItemInfo.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.FilterToolbar
 * JD-Core Version:    0.7.0.1
 */