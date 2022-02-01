package com.tencent.av.ui.effect.toolbar.newversion;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AudioTransClientInfoHandler;
import com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend;
import com.tencent.av.business.handler.BusinessHandlerFactory;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.adapter.MaterialAdapter;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.ui.effect.view.MaterialRecyclerView;
import com.tencent.av.utils.AVUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubtitlesToolbar
  extends BaseToolbarNewVersion
  implements EffectConfigBase.IEffectConfigCallback<ZimuItem>, IItemDownloadMgr
{
  private static final int ZIMU_CPU_CORE_THRESHOLD = 8;
  private static final int ZIMU_CPU_FREQ_THRESHOLD = 1800000;
  private MaterialAdapter mAdapter;
  private EffectMaterialManager mMaterialManager;
  private MaterialRecyclerView mRecyclerView;
  IEffectCallback mSubTitleClickCallback = new SubtitlesToolbar.1(this);
  private EffectSupportManager mSupportManager;
  private BaseToolbar.UIInfo mUIInfo;
  private EffectZimuManager mZimuManager;
  
  public SubtitlesToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private void cancelSubTitle(long paramLong, String paramString)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancleZimu, 取消字幕选择, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], isTranslation[");
    localStringBuilder.append(this.mZimuManager.l());
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.mZimuManager.a("onSelectZimuItem", paramLong);
    new ControlUIObserver.ZimuRequest(paramLong, "onSelectZimuItem", 3, paramString).a(this.mApp);
    AudioTransClientInfoHandlerExtend.a(this.mApp, "onSelectZimuItem", paramLong, "EMPTY_ITEM", false);
  }
  
  private boolean checkDimStatus(String paramString)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkDimStatus id = ");
    localStringBuilder.append(paramString);
    AVLog.printColorLog(str, localStringBuilder.toString());
    int i = this.mSupportManager.b(0, "735");
    int j = this.mSupportManager.b(0, "750");
    if (i != -1)
    {
      if (i == 0)
      {
        i = 2131893232;
        break label93;
      }
    }
    else if (j != 1)
    {
      i = 2131893233;
      break label93;
    }
    i = 0;
    label93:
    paramString = (AVActivity)this.mActivity.get();
    if ((i != 0) && (paramString != null)) {
      TipsUtil.a(this.mApp, 1010, i);
    }
    return false;
  }
  
  public static boolean isSupport()
  {
    int i = VcSystemInfo.getNumCores();
    if (i >= 8) {
      return true;
    }
    return (i >= 4) && (VcSystemInfo.getMaxCpuFreq() >= 1800000L);
  }
  
  private void onSelectSubTitleItem(long paramLong, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (checkDimStatus(paramString)) {
        return;
      }
      if ("0".equalsIgnoreCase(paramString))
      {
        cancelSubTitle(paramLong, paramString);
        return;
      }
      selectSubTitle(paramLong, paramString);
    }
  }
  
  private void selectSubTitle(long paramLong, String paramString)
  {
    Object localObject2 = (ZimuItem)this.mZimuManager.c();
    Object localObject1;
    if (localObject2 != null) {
      localObject1 = ((ZimuItem)localObject2).getId();
    } else {
      localObject1 = null;
    }
    if ((TextUtils.equals((CharSequence)localObject1, paramString) ^ true))
    {
      boolean bool = ((AudioTransClientInfoHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.b)).a();
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("selectZimu, 选择新字幕, id[");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("->");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isSuccessCreateTranslation[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], isTranslation[");
      localStringBuilder.append(this.mZimuManager.l());
      localStringBuilder.append("], ZimuItem[");
      localStringBuilder.append(localObject2);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      new ControlUIObserver.ZimuRequest(paramLong, "onSelectZimuItem", 1, paramString).a(this.mApp);
      if (bool)
      {
        AudioTransClientInfoHandlerExtend.a(this.mApp, "onSelectZimuItem", paramLong, paramString, true);
        localObject1 = this.mZimuManager;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onSelectZimuItem_");
        ((StringBuilder)localObject2).append(paramString);
        ((EffectZimuManager)localObject1).b(((StringBuilder)localObject2).toString(), paramLong);
        return;
      }
      localObject1 = this.mZimuManager;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onSelectZimuItem_");
      ((StringBuilder)localObject2).append(paramString);
      ((EffectZimuManager)localObject1).a(((StringBuilder)localObject2).toString(), true, paramLong, null);
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("selectZimu, 字幕item无变更, same, id[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void setLastItem()
  {
    Object localObject = (ZimuItem)this.mZimuManager.c();
    if (localObject == null) {
      localObject = "0";
    } else {
      localObject = ((ZimuItem)localObject).getId();
    }
    this.mMaterialManager.h((String)localObject);
    this.mMaterialManager.o();
  }
  
  ArrayList<QavListItemBase.ItemInfo> convertItemInfo(List<ZimuItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (ZimuItem)localIterator.next();
        Object localObject;
        if ((paramList != null) && (!TextUtils.equals(paramList.getId(), "liveshow")) && (!TextUtils.equals(paramList.getId(), "spit")))
        {
          localObject = new QavListItemBase.ItemInfo();
          ((QavListItemBase.ItemInfo)localObject).a = paramList.getId();
          ((QavListItemBase.ItemInfo)localObject).b = paramList.getIconUrl();
          ((QavListItemBase.ItemInfo)localObject).d = paramList.isUsable();
          ((QavListItemBase.ItemInfo)localObject).c = paramList.getId();
          ((QavListItemBase.ItemInfo)localObject).k = paramList.getDesc();
          localArrayList.add(localObject);
        }
        else if (QLog.isColorLevel())
        {
          localObject = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("convertItemInfo, invalidate item, id[");
          if (paramList == null) {
            paramList = "null";
          } else {
            paramList = paramList.getId();
          }
          localStringBuilder.append(paramList);
          localStringBuilder.append("]");
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
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
      localUIInfo.d = 6;
      localUIInfo.h = 2131625732;
      localUIInfo.f = 2130843309;
      localUIInfo.g = this.mApp.getApp().getString(2131893691);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131893219);
    }
    return "";
  }
  
  ArrayList<QavListItemBase.ItemInfo> insertNoneItem(ArrayList<QavListItemBase.ItemInfo> paramArrayList)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.a = "0";
    localItemInfo.b = String.valueOf(2130843209);
    localItemInfo.k = HardCodeUtil.a(2131913940);
    paramArrayList.add(0, localItemInfo);
    return paramArrayList;
  }
  
  public boolean isCreated()
  {
    return super.isCreated();
  }
  
  public boolean isEffectBtnEnable()
  {
    return true ^ isOpenAvatar2D(true);
  }
  
  public boolean isEffectBtnNormal()
  {
    return (!isOpenAvatar2D(true)) && (isSupport());
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mSupportManager = ((EffectSupportManager)this.mApp.c(5));
    this.mRecyclerView = ((MaterialRecyclerView)this.toolbarView.findViewById(2131438906));
    this.mMaterialManager = ((EffectMaterialManager)this.mApp.c(15));
    this.mZimuManager = ((EffectZimuManager)this.mApp.c(0));
    ArrayList localArrayList2 = convertItemInfo(this.mZimuManager.c(null));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2.size() > 0) {
      localArrayList1 = insertNoneItem(localArrayList2);
    }
    this.mAdapter = new MaterialAdapter(this.mApp, paramAVActivity, localArrayList1, this.mRecyclerView, 5, false);
    this.mAdapter.a(this.mSubTitleClickCallback);
    this.mAdapter.a(this);
    this.mRecyclerView.setAdapter(this.mAdapter);
    this.mMaterialManager.h(null);
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mZimuManager.b(paramLong, this);
    this.mMaterialManager.h(null);
  }
  
  public void onDownloadFinish(long paramLong, ZimuItem paramZimuItem, boolean paramBoolean)
  {
    MaterialAdapter localMaterialAdapter = this.mAdapter;
    if (localMaterialAdapter != null) {
      localMaterialAdapter.a(paramLong, paramZimuItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide(long paramLong)
  {
    this.mZimuManager.b(paramLong, this);
  }
  
  public void onItemSelectedChanged(long paramLong, ZimuItem paramZimuItem)
  {
    setLastItem();
  }
  
  public void onProgressUpdate(ZimuItem paramZimuItem, int paramInt)
  {
    MaterialAdapter localMaterialAdapter = this.mAdapter;
    if (localMaterialAdapter != null) {
      localMaterialAdapter.b(paramZimuItem.getId(), paramInt);
    }
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mZimuManager.a(paramLong, this);
    setLastItem();
    AVUtil.f(105);
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (ZimuItem)this.mZimuManager.b(paramItemInfo.a);
    if (paramAppInterface != null)
    {
      this.mZimuManager.b(paramLong, paramAppInterface);
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
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.SubtitlesToolbar
 * JD-Core Version:    0.7.0.1
 */