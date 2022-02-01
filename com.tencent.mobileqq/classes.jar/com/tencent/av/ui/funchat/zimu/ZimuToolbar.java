package com.tencent.av.ui.funchat.zimu;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AudioTransClientInfoHandler;
import com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend;
import com.tencent.av.business.handler.BusinessHandlerFactory;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.ui.effect.toolbar.oldversion.BaseToolbarOldVersion;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZimuToolbar
  extends BaseToolbarOldVersion
  implements EffectConfigBase.IEffectConfigCallback<ZimuItem>, IItemDownloadMgr
{
  private static final String TAG = "ZimuToolbar";
  private static final int ZIMU_CPU_CORE_THRESHOLD = 8;
  private static final int ZIMU_CPU_FREQ_THRESHOLD = 1800000;
  private ZimuToolbar.QAVZimuAdapter mAdapter;
  private ZimuToolbar.MyItemEvent mItemEvent;
  private HorizontalListView mListView;
  private EffectSupportManager mSupportManager;
  BaseToolbar.UIInfo mUIInfo = null;
  private EffectZimuManager mZimuManager;
  
  public ZimuToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private void cancleZimu(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancleZimu, 取消字幕选择, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], isTranslation[");
    localStringBuilder.append(this.mZimuManager.l());
    localStringBuilder.append("]");
    QLog.w("ZimuToolbar", 1, localStringBuilder.toString());
    this.mZimuManager.a("onSelectZimuItem", paramLong);
    new ControlUIObserver.ZimuRequest(paramLong, "onSelectZimuItem", 3, paramString).a(this.mApp);
    AudioTransClientInfoHandlerExtend.a(this.mApp, "onSelectZimuItem", paramLong, "EMPTY_ITEM", false);
  }
  
  private boolean checkDimmStatus(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkDimmStatus id = ");
    localStringBuilder.append(paramString);
    AVLog.printColorLog("ZimuToolbar", localStringBuilder.toString());
    int i = this.mSupportManager.b(0, "735");
    int j = this.mSupportManager.b(0, "750");
    if (i != -1)
    {
      if (i == 0)
      {
        i = 2131893232;
        break label87;
      }
    }
    else if (j != 1)
    {
      i = 2131893233;
      break label87;
    }
    i = 0;
    label87:
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
    if (i >= 4)
    {
      long l = VcSystemInfo.getMaxCpuFreq();
      if ((l != 0L) && (l >= 1800000L)) {
        return true;
      }
    }
    return false;
  }
  
  private void onSelectZimuItem(long paramLong, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (checkDimmStatus(paramString)) {
        return;
      }
      if ("0".equalsIgnoreCase(paramString))
      {
        cancleZimu(paramLong, paramString);
        return;
      }
      selectZimu(paramLong, paramString);
    }
  }
  
  private void selectZimu(long paramLong, String paramString)
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
      QLog.w("ZimuToolbar", 1, localStringBuilder.toString());
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("selectZimu, 字幕item无变更, same, id[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("]");
      QLog.w("ZimuToolbar", 1, ((StringBuilder)localObject1).toString());
    }
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
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("convertItemInfo, invalidate item, id[");
          if (paramList == null) {
            paramList = "null";
          } else {
            paramList = paramList.getId();
          }
          ((StringBuilder)localObject).append(paramList);
          ((StringBuilder)localObject).append("]");
          QLog.i("ZimuToolbar", 2, ((StringBuilder)localObject).toString());
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
      localUIInfo.h = 2131625809;
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
  
  ArrayList<QavListItemBase.ItemInfo> insertEmptyItem(ArrayList<QavListItemBase.ItemInfo> paramArrayList)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.a = "-1";
    paramArrayList.add(0, localItemInfo);
    localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.a = "0";
    localItemInfo.b = String.valueOf(2130843209);
    localItemInfo.k = HardCodeUtil.a(2131913940);
    paramArrayList.add(1, localItemInfo);
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
  
  protected void notifyEvent(Integer paramInteger, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject);
    AVLog.printColorLog("ZimuToolbar", localStringBuilder.toString());
    this.mApp.a(new Object[] { paramInteger, paramObject });
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mSupportManager = ((EffectSupportManager)this.mApp.c(5));
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131435195));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mZimuManager = ((EffectZimuManager)this.mApp.c(0));
    ArrayList localArrayList2 = convertItemInfo(this.mZimuManager.c(null));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2.size() > 0) {
      localArrayList1 = insertEmptyItem(localArrayList2);
    }
    this.mAdapter = new ZimuToolbar.QAVZimuAdapter(this.mApp, paramAVActivity, localArrayList1, this.mListView, this);
    this.mItemEvent = new ZimuToolbar.MyItemEvent(this);
    this.mAdapter.a(false);
    this.mAdapter.a(this.mItemEvent);
    this.mAdapter.a(this);
    this.mAdapter.b(true);
    this.mListView.setAdapter(this.mAdapter);
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mZimuManager.b(paramLong, this);
    this.mApp.e(0);
    this.mListView = null;
    this.mAdapter = null;
  }
  
  public void onDownloadFinish(long paramLong, ZimuItem paramZimuItem, boolean paramBoolean)
  {
    ZimuToolbar.QAVZimuAdapter localQAVZimuAdapter = this.mAdapter;
    if (localQAVZimuAdapter != null) {
      localQAVZimuAdapter.a(paramLong, paramZimuItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide(long paramLong)
  {
    this.mZimuManager.b(paramLong, this);
  }
  
  public void onItemSelectedChanged(long paramLong, ZimuItem paramZimuItem)
  {
    if (this.mAdapter == null) {
      return;
    }
    if (paramZimuItem == null) {
      paramZimuItem = "0";
    } else {
      paramZimuItem = paramZimuItem.getId();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onItemSelectedChanged begin, id[");
    localStringBuilder.append(paramZimuItem);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("ZimuToolbar", 1, localStringBuilder.toString());
    this.mAdapter.a("onItemSelectedChanged", paramLong, paramZimuItem);
    VideoController.f().k();
  }
  
  public void onProgressUpdate(ZimuItem paramZimuItem, int paramInt)
  {
    ZimuToolbar.QAVZimuAdapter localQAVZimuAdapter = this.mAdapter;
    if (localQAVZimuAdapter != null) {
      localQAVZimuAdapter.a(paramZimuItem.getId(), paramInt);
    }
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = convertItemInfo(this.mZimuManager.c(null));
    Object localObject1 = localObject2;
    if (((ArrayList)localObject2).size() > 0) {
      localObject1 = insertEmptyItem((ArrayList)localObject2);
    }
    this.mAdapter.a((ArrayList)localObject1);
    this.mAdapter.notifyDataSetChanged();
    this.toolbarView.requestLayout();
    localObject1 = (ZimuItem)this.mZimuManager.c();
    if (localObject1 == null) {
      localObject1 = "0";
    } else {
      localObject1 = ((ZimuItem)localObject1).getId();
    }
    this.mAdapter.a("onShow", paramLong, (String)localObject1);
    if (paramInt != getUIInfo().d) {
      EffectZimuManager.DataReport.a("0X80085CA", "");
    }
    this.mZimuManager.a(paramLong, this);
    if (!((String)localObject1).equalsIgnoreCase("0"))
    {
      localObject2 = this.mZimuManager;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow_");
      localStringBuilder.append((String)localObject1);
      ((EffectZimuManager)localObject2).a(localStringBuilder.toString(), false, paramLong, null);
    }
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (ZimuItem)this.mZimuManager.b(paramItemInfo.a);
    if (paramAppInterface != null)
    {
      this.mZimuManager.b(paramLong, paramAppInterface);
      return;
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("startDownloadTemplate, item为空, seq[");
    paramAppInterface.append(paramLong);
    paramAppInterface.append("]");
    QLog.w("ZimuToolbar", 1, paramAppInterface.toString());
    paramIDownloadCallback.a(paramLong, paramItemInfo.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuToolbar
 * JD-Core Version:    0.7.0.1
 */