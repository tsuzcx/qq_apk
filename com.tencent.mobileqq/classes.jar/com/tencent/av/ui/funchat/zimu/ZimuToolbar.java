package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AudioTransClientInfoHandler;
import com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend;
import com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend.ZimuCMD;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.zimu.ARZimuUtil;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.BaseToolbar.UIInfo;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IItemDownloadMgr;
import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kea;
import keb;

public class ZimuToolbar
  extends BaseToolbar
  implements EffectConfigBase.IEffectConfigCallback, QAVPtvTemplateAdapter.IItemDownloadMgr
{
  private static final String TAG = "ZimuToolbar";
  private static final int ZIMU_CPU_CORE_THRESHOLD = 8;
  private static final int ZIMU_CPU_FREQ_THRESHOLD = 1800000;
  private boolean mARZimuEnable;
  private keb mAdapter;
  private kea mItemEvent;
  private HorizontalListView mListView;
  private EffectSupportManager mSupportManager;
  BaseToolbar.UIInfo mUIInfo = null;
  private EffectZimuManager mZimuManager;
  
  public ZimuToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private boolean checkDimmStatus(String paramString)
  {
    AVLog.c("ZimuToolbar", "checkDimmStatus id = " + paramString);
    int i = this.mSupportManager.a(0, "735");
    int j = this.mSupportManager.a(0, "750");
    label70:
    int k;
    switch (i)
    {
    default: 
      i = 0;
      k = i;
      if (paramString.equals("liveshow")) {
        if (this.mSupportManager.a(0, "live") == 1) {
          break label171;
        }
      }
      break;
    }
    label171:
    for (j = 1;; j = 0)
    {
      k = i;
      if (j != 0)
      {
        k = i;
        if (i == 0) {
          k = 2131429676;
        }
      }
      paramString = (AVActivity)this.mActivity.get();
      if ((k != 0) && (paramString != null)) {
        paramString.a(79, paramString.getString(k), 3000L, 1);
      }
      return false;
      if (j == 1) {
        break;
      }
      i = 2131429676;
      break label70;
      i = 2131429677;
      break label70;
    }
  }
  
  private boolean checkNeedUpdateList()
  {
    boolean bool = this.mARZimuEnable;
    this.mARZimuEnable = ARZimuUtil.a();
    return (!bool) || (!this.mARZimuEnable);
  }
  
  public static boolean isShow(Context paramContext)
  {
    if (paramContext != null) {
      return EffectZimuManager.a(paramContext);
    }
    return false;
  }
  
  public static boolean isSupport()
  {
    int i = VcSystemInfo.e();
    if (i >= 8) {}
    long l;
    do
    {
      return true;
      if (i < 4) {
        break;
      }
      l = VcSystemInfo.c();
    } while ((l != 0L) && (l >= 1800000L));
    return false;
  }
  
  private void onZimuChanged(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (checkDimmStatus(paramString))) {}
    for (;;)
    {
      return;
      if ("0".equalsIgnoreCase(paramString))
      {
        this.mZimuManager.c();
        notifyEvent(Integer.valueOf(6006), paramString);
        this.mApp.a().a(7, "EMPTY_ITEM");
        return;
      }
      ZimuItem localZimuItem = (ZimuItem)this.mZimuManager.a();
      int i;
      if (localZimuItem == null) {
        i = 1;
      }
      while (i != 0)
      {
        notifyEvent(Integer.valueOf(6005), paramString);
        if (((AudioTransClientInfoHandler)this.mApp.a(1)).a())
        {
          paramString = AudioTransClientInfoHandlerExtend.a(this.mApp, paramString);
          this.mApp.a().a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_JavaLangString);
        }
        if (localZimuItem != null) {
          break label171;
        }
        this.mZimuManager.a(true, null);
        return;
        if (!paramString.equalsIgnoreCase(localZimuItem.getId())) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    label171:
    this.mZimuManager.d();
  }
  
  public static void sendSupportionToPeer(VideoController paramVideoController)
  {
    if (paramVideoController != null) {
      if (!isSupport()) {
        break label22;
      }
    }
    label22:
    for (String str = "SUPPORT_TRUE";; str = "SUPPORT_FALSE")
    {
      paramVideoController.a(7, str);
      return;
    }
  }
  
  ArrayList convertItemInfo(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ZimuItem localZimuItem = (ZimuItem)paramList.next();
        QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
        localItemInfo.jdField_a_of_type_JavaLangString = localZimuItem.getId();
        localItemInfo.b = localZimuItem.getIconurl();
        localItemInfo.jdField_a_of_type_Boolean = localZimuItem.isUsable();
        localItemInfo.c = localZimuItem.getId();
        localItemInfo.d = localZimuItem.getDesc();
        if ((TextUtils.isEmpty(localItemInfo.d)) && (localItemInfo.jdField_a_of_type_JavaLangString.equals("liveshow"))) {
          localItemInfo.d = this.mApp.getApp().getResources().getString(2131429674);
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
      this.mUIInfo.d = 6;
      this.mUIInfo.g = 2130969358;
      this.mUIInfo.e = 103417;
      this.mUIInfo.f = 2130840341;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getResources().getString(2131428740);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131428732);
    }
    return "";
  }
  
  ArrayList insertEmptyItem(ArrayList paramArrayList)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.jdField_a_of_type_JavaLangString = "-1";
    paramArrayList.add(0, localItemInfo);
    localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.jdField_a_of_type_JavaLangString = "0";
    localItemInfo.b = String.valueOf(2130840276);
    localItemInfo.d = "取消字幕";
    paramArrayList.add(1, localItemInfo);
    return paramArrayList;
  }
  
  public boolean isCreated()
  {
    return super.isCreated();
  }
  
  public boolean isEffectBtnEnable()
  {
    return isSupport();
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject)
  {
    AVLog.c("ZimuToolbar", "notifyEvent :" + paramInteger + "|" + paramObject);
    this.mApp.a(new Object[] { paramInteger, paramObject });
  }
  
  protected void onCreate(AVActivity paramAVActivity)
  {
    super.onCreate(paramAVActivity);
    this.mSupportManager = ((EffectSupportManager)this.mApp.a(5));
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131366248));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mZimuManager = ((EffectZimuManager)this.mApp.a(0));
    ArrayList localArrayList = convertItemInfo(this.mZimuManager.a(null));
    Object localObject = localArrayList;
    if (localArrayList.size() > 0) {
      localObject = insertEmptyItem(localArrayList);
    }
    this.mAdapter = new keb(this.mApp, paramAVActivity, (ArrayList)localObject, this.mListView, this);
    localObject = this.mListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (this.mAdapter.jdField_a_of_type_Int + AIOUtils.a(30.0F, paramAVActivity.getResources()));
    this.mListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mItemEvent = new kea(this);
    this.mAdapter.a(this.mItemEvent);
    this.mAdapter.a(this);
    this.mAdapter.b(true);
    this.mListView.setAdapter(this.mAdapter);
  }
  
  protected void onDestroy(VideoAppInterface paramVideoAppInterface)
  {
    super.onDestroy(paramVideoAppInterface);
    this.mZimuManager.b(this);
    this.mApp.c(0);
    this.mListView = null;
    this.mAdapter = null;
  }
  
  public void onDownloadFinish(ZimuItem paramZimuItem, boolean paramBoolean)
  {
    if (this.mAdapter != null) {
      this.mAdapter.a(paramZimuItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide()
  {
    super.onHide();
    this.mZimuManager.b(this);
  }
  
  public void onItemSelectedChanged(ZimuItem paramZimuItem)
  {
    if (paramZimuItem == null) {}
    for (paramZimuItem = "0";; paramZimuItem = paramZimuItem.getId())
    {
      if (this.mAdapter != null) {
        this.mAdapter.a(paramZimuItem);
      }
      return;
    }
  }
  
  public void onProgressUpdate(ZimuItem paramZimuItem, int paramInt)
  {
    if (this.mAdapter != null) {
      this.mAdapter.a(paramZimuItem.getId(), paramInt);
    }
  }
  
  protected void onShow(int paramInt, boolean paramBoolean)
  {
    super.onShow(paramInt, paramBoolean);
    Object localObject2;
    if (checkNeedUpdateList())
    {
      localObject1 = this.mZimuManager.a(null);
      if (!this.mARZimuEnable)
      {
        localObject2 = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          ZimuItem localZimuItem = (ZimuItem)localIterator.next();
          if (ARZimuUtil.a(localZimuItem.getId())) {
            ((List)localObject2).add(localZimuItem);
          }
        }
        ((List)localObject1).removeAll((Collection)localObject2);
      }
      localObject2 = convertItemInfo((List)localObject1);
      localObject1 = localObject2;
      if (((ArrayList)localObject2).size() > 0) {
        localObject1 = insertEmptyItem((ArrayList)localObject2);
      }
      this.mAdapter.a((ArrayList)localObject1);
      this.mAdapter.notifyDataSetChanged();
      this.toolbarView.requestLayout();
    }
    Object localObject1 = (ZimuItem)this.mZimuManager.a();
    if (localObject1 == null) {}
    for (localObject1 = "0";; localObject1 = ((ZimuItem)localObject1).getId())
    {
      localObject2 = localObject1;
      if (ARZimuUtil.a((String)localObject1))
      {
        localObject2 = localObject1;
        if (!this.mARZimuEnable) {
          localObject2 = "0";
        }
      }
      this.mAdapter.a((String)localObject2);
      if (paramInt != getUIInfo().d) {
        EffectZimuManager.DataReport.a("0X80085CA", "");
      }
      this.mZimuManager.a(this);
      if (!((String)localObject2).equalsIgnoreCase("0")) {
        this.mZimuManager.a(false, null);
      }
      return;
    }
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (ZimuItem)this.mZimuManager.a(paramItemInfo.jdField_a_of_type_JavaLangString);
    if (paramAppInterface != null)
    {
      this.mZimuManager.a(paramAppInterface);
      return;
    }
    AVLog.e("ZimuToolbar", "ItemDownloadMgr:startDownloadTemplate failed item = null");
    paramIDownloadCallback.a(paramItemInfo.jdField_a_of_type_JavaLangString, false);
  }
  
  public void update(Object[] paramArrayOfObject)
  {
    super.update(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuToolbar
 * JD-Core Version:    0.7.0.1
 */