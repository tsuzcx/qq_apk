package com.tencent.av.ui.funchat.zimu;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import anvx;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import lbd;
import lfe;
import lge;
import lgf;
import lgw;
import lin;
import ljc;
import ljd;
import lje;
import llq;
import mbf;
import mcl;
import mdd;
import mhu;
import mim;
import min;
import mpg;
import mph;

public class ZimuToolbar
  extends BaseToolbar
  implements lgw<ZimuItem>, mhu
{
  private static final String TAG = "ZimuToolbar";
  private static final int ZIMU_CPU_CORE_THRESHOLD = 8;
  private static final int ZIMU_CPU_FREQ_THRESHOLD = 1800000;
  private boolean mARZimuEnable;
  private mph mAdapter;
  private mpg mItemEvent;
  private HorizontalListView mListView;
  private lin mSupportManager;
  mcl mUIInfo = null;
  private ljd mZimuManager;
  
  public ZimuToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private void cancleZimu(long paramLong, String paramString)
  {
    QLog.w("ZimuToolbar", 1, "cancleZimu, 取消字幕选择, seq[" + paramLong + "], isTranslation[" + this.mZimuManager.c() + "]");
    this.mZimuManager.a("onSelectZimuItem", paramLong);
    new mdd(paramLong, "onSelectZimuItem", 3, paramString).a(this.mApp);
    lgf.a(this.mApp, "onSelectZimuItem", paramLong, "EMPTY_ITEM", false);
  }
  
  private boolean checkDimmStatus(String paramString)
  {
    lbd.f("ZimuToolbar", "checkDimmStatus id = " + paramString);
    int i = this.mSupportManager.a(0, "735");
    int j = this.mSupportManager.a(0, "750");
    switch (i)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramString = (AVActivity)this.mActivity.get();
      if ((i != 0) && (paramString != null)) {
        mbf.a(this.mApp, 1010, i);
      }
      return false;
      if (j == 1) {
        break;
      }
      i = 2131695222;
      continue;
      i = 2131695221;
    }
  }
  
  private boolean checkNeedUpdateList()
  {
    boolean bool = this.mARZimuEnable;
    this.mARZimuEnable = ljc.a();
    return (!bool) || (!this.mARZimuEnable);
  }
  
  public static boolean isShow(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null) {
      return ljd.a(paramVideoAppInterface);
    }
    return false;
  }
  
  public static boolean isSupport()
  {
    int i = llq.e();
    if (i >= 8) {}
    long l;
    do
    {
      return true;
      if (i < 4) {
        break;
      }
      l = llq.d();
    } while ((l != 0L) && (l >= 1800000L));
    return false;
  }
  
  private void onSelectZimuItem(long paramLong, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (checkDimmStatus(paramString))) {
      return;
    }
    if ("0".equalsIgnoreCase(paramString))
    {
      cancleZimu(paramLong, paramString);
      return;
    }
    selectZimu(paramLong, paramString);
  }
  
  private void selectZimu(long paramLong, String paramString)
  {
    ZimuItem localZimuItem = (ZimuItem)this.mZimuManager.a();
    if (localZimuItem != null) {}
    for (String str = localZimuItem.getId();; str = null)
    {
      int i;
      if (!TextUtils.equals(str, paramString))
      {
        i = 1;
        if (i == 0) {
          break label241;
        }
        bool = ((lge)this.mApp.a(1)).a();
        QLog.w("ZimuToolbar", 1, "selectZimu, 选择新字幕, id[" + str + "->" + paramString + "], isSuccessCreateTranslation[" + bool + "], seq[" + paramLong + "], isTranslation[" + this.mZimuManager.c() + "], ZimuItem[" + localZimuItem + "]");
        new mdd(paramLong, "onSelectZimuItem", 1, paramString).a(this.mApp);
        if (!bool) {
          break label211;
        }
        lgf.a(this.mApp, "onSelectZimuItem", paramLong, paramString, true);
        this.mZimuManager.b("onSelectZimuItem_" + paramString, paramLong);
      }
      label211:
      label241:
      while (!QLog.isDevelopLevel())
      {
        boolean bool;
        return;
        i = 0;
        break;
        this.mZimuManager.a("onSelectZimuItem_" + paramString, true, paramLong, null);
        return;
      }
      QLog.w("ZimuToolbar", 1, "selectZimu, 字幕item无变更, same, id[" + paramString + "]");
      return;
    }
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
  
  ArrayList<min> convertItemInfo(List<ZimuItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (ZimuItem)localIterator.next();
        Object localObject;
        if ((paramList == null) || (TextUtils.equals(paramList.getId(), "liveshow")))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder().append("convertItemInfo, invalidate item, id[");
            if (paramList == null) {}
            for (paramList = "null";; paramList = paramList.getId())
            {
              QLog.i("ZimuToolbar", 2, paramList + "]");
              break;
            }
          }
        }
        else
        {
          localObject = new min();
          ((min)localObject).jdField_a_of_type_JavaLangString = paramList.getId();
          ((min)localObject).b = paramList.getIconurl();
          ((min)localObject).jdField_a_of_type_Boolean = paramList.isUsable();
          ((min)localObject).c = paramList.getId();
          ((min)localObject).d = paramList.getDesc();
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public mcl getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mcl();
      this.mUIInfo.d = 6;
      this.mUIInfo.f = 2131559820;
      this.mUIInfo.e = 2130842322;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131695671);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131695210);
    }
    return "";
  }
  
  ArrayList<min> insertEmptyItem(ArrayList<min> paramArrayList)
  {
    min localmin = new min();
    localmin.jdField_a_of_type_JavaLangString = "-1";
    paramArrayList.add(0, localmin);
    localmin = new min();
    localmin.jdField_a_of_type_JavaLangString = "0";
    localmin.b = String.valueOf(2130842225);
    localmin.d = anvx.a(2131716391);
    paramArrayList.add(1, localmin);
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
    lbd.f("ZimuToolbar", "notifyEvent :" + paramInteger + "|" + paramObject);
    this.mApp.a(new Object[] { paramInteger, paramObject });
  }
  
  public void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mSupportManager = ((lin)this.mApp.a(5));
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368362));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mZimuManager = ((ljd)this.mApp.a(0));
    ArrayList localArrayList2 = convertItemInfo(this.mZimuManager.a(null));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2.size() > 0) {
      localArrayList1 = insertEmptyItem(localArrayList2);
    }
    this.mAdapter = new mph(this.mApp, paramAVActivity, localArrayList1, this.mListView, this);
    this.mItemEvent = new mpg(this);
    this.mAdapter.a(this.mItemEvent);
    this.mAdapter.a(this);
    this.mAdapter.b(true);
    this.mListView.setAdapter(this.mAdapter);
  }
  
  public void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mZimuManager.b(paramLong, this);
    this.mApp.c(0);
    this.mListView = null;
    this.mAdapter = null;
  }
  
  public void onDownloadFinish(long paramLong, ZimuItem paramZimuItem, boolean paramBoolean)
  {
    if (this.mAdapter != null) {
      this.mAdapter.a(paramLong, paramZimuItem.getId(), paramBoolean);
    }
  }
  
  public void onHide(long paramLong)
  {
    this.mZimuManager.b(paramLong, this);
  }
  
  public void onItemSelectedChanged(long paramLong, ZimuItem paramZimuItem)
  {
    if (this.mAdapter == null) {
      return;
    }
    if (paramZimuItem == null) {}
    lfe locallfe;
    for (paramZimuItem = "0";; paramZimuItem = paramZimuItem.getId())
    {
      QLog.w("ZimuToolbar", 1, "onItemSelectedChanged begin, id[" + paramZimuItem + "], seq[" + paramLong + "]");
      this.mAdapter.a("onItemSelectedChanged", paramLong, paramZimuItem);
      locallfe = VideoController.a().a();
      if (!ljc.a(paramZimuItem)) {
        break;
      }
      locallfe.a.set(4);
      return;
    }
    locallfe.a.clear(4);
  }
  
  public void onProgressUpdate(ZimuItem paramZimuItem, int paramInt)
  {
    if (this.mAdapter != null) {
      this.mAdapter.a(paramZimuItem.getId(), paramInt);
    }
  }
  
  public void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
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
          if (ljc.a(localZimuItem.getId())) {
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
      if (ljc.a((String)localObject1))
      {
        localObject2 = localObject1;
        if (!this.mARZimuEnable) {
          localObject2 = "0";
        }
      }
      this.mAdapter.a("onShow", paramLong, (String)localObject2);
      if (paramInt != getUIInfo().d) {
        lje.a("0X80085CA", "");
      }
      this.mZimuManager.a(paramLong, this);
      if (!((String)localObject2).equalsIgnoreCase("0")) {
        this.mZimuManager.a("onShow_" + (String)localObject2, false, paramLong, null);
      }
      return;
    }
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, min parammin, mim parammim)
  {
    paramAppInterface = (ZimuItem)this.mZimuManager.a(parammin.jdField_a_of_type_JavaLangString);
    if (paramAppInterface != null)
    {
      this.mZimuManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("ZimuToolbar", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammim.a(paramLong, parammin.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuToolbar
 * JD-Core Version:    0.7.0.1
 */