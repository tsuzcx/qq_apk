package com.tencent.av.ui.funchat.zimu;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import anzj;
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
import lbj;
import lff;
import lfy;
import lfz;
import lgq;
import lih;
import liw;
import lix;
import liy;
import llk;
import mbb;
import mch;
import mcz;
import mhp;
import mih;
import mii;
import mpa;
import mpb;

public class ZimuToolbar
  extends BaseToolbar
  implements lgq<ZimuItem>, mhp
{
  private static final String TAG = "ZimuToolbar";
  private static final int ZIMU_CPU_CORE_THRESHOLD = 8;
  private static final int ZIMU_CPU_FREQ_THRESHOLD = 1800000;
  private boolean mARZimuEnable;
  private mpb mAdapter;
  private mpa mItemEvent;
  private HorizontalListView mListView;
  private lih mSupportManager;
  mch mUIInfo = null;
  private lix mZimuManager;
  
  public ZimuToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private void cancleZimu(long paramLong, String paramString)
  {
    QLog.w("ZimuToolbar", 1, "cancleZimu, 取消字幕选择, seq[" + paramLong + "], isTranslation[" + this.mZimuManager.c() + "]");
    this.mZimuManager.a("onSelectZimuItem", paramLong);
    new mcz(paramLong, "onSelectZimuItem", 3, paramString).a(this.mApp);
    lfz.a(this.mApp, "onSelectZimuItem", paramLong, "EMPTY_ITEM", false);
  }
  
  private boolean checkDimmStatus(String paramString)
  {
    lbj.c("ZimuToolbar", "checkDimmStatus id = " + paramString);
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
        mbb.a(this.mApp, 1010, i);
      }
      return false;
      if (j == 1) {
        break;
      }
      i = 2131694868;
      continue;
      i = 2131694867;
    }
  }
  
  private boolean checkNeedUpdateList()
  {
    boolean bool = this.mARZimuEnable;
    this.mARZimuEnable = liw.a();
    return (!bool) || (!this.mARZimuEnable);
  }
  
  public static boolean isShow(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null) {
      return lix.a(paramVideoAppInterface);
    }
    return false;
  }
  
  public static boolean isSupport()
  {
    int i = llk.e();
    if (i >= 8) {}
    long l;
    do
    {
      return true;
      if (i < 4) {
        break;
      }
      l = llk.d();
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
        bool = ((lfy)this.mApp.a(1)).a();
        QLog.w("ZimuToolbar", 1, "selectZimu, 选择新字幕, id[" + str + "->" + paramString + "], isSuccessCreateTranslation[" + bool + "], seq[" + paramLong + "], isTranslation[" + this.mZimuManager.c() + "], ZimuItem[" + localZimuItem + "]");
        new mcz(paramLong, "onSelectZimuItem", 1, paramString).a(this.mApp);
        if (!bool) {
          break label211;
        }
        lfz.a(this.mApp, "onSelectZimuItem", paramLong, paramString, true);
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
  
  ArrayList<mii> convertItemInfo(List<ZimuItem> paramList)
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
          localObject = new mii();
          ((mii)localObject).jdField_a_of_type_JavaLangString = paramList.getId();
          ((mii)localObject).b = paramList.getIconurl();
          ((mii)localObject).jdField_a_of_type_Boolean = paramList.isUsable();
          ((mii)localObject).c = paramList.getId();
          ((mii)localObject).d = paramList.getDesc();
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public mch getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mch();
      this.mUIInfo.d = 6;
      this.mUIInfo.f = 2131559781;
      this.mUIInfo.e = 2130842266;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131695315);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131694856);
    }
    return "";
  }
  
  ArrayList<mii> insertEmptyItem(ArrayList<mii> paramArrayList)
  {
    mii localmii = new mii();
    localmii.jdField_a_of_type_JavaLangString = "-1";
    paramArrayList.add(0, localmii);
    localmii = new mii();
    localmii.jdField_a_of_type_JavaLangString = "0";
    localmii.b = String.valueOf(2130842169);
    localmii.d = anzj.a(2131715809);
    paramArrayList.add(1, localmii);
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
    lbj.c("ZimuToolbar", "notifyEvent :" + paramInteger + "|" + paramObject);
    this.mApp.a(new Object[] { paramInteger, paramObject });
  }
  
  public void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mSupportManager = ((lih)this.mApp.a(5));
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368193));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mZimuManager = ((lix)this.mApp.a(0));
    ArrayList localArrayList2 = convertItemInfo(this.mZimuManager.a(null));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2.size() > 0) {
      localArrayList1 = insertEmptyItem(localArrayList2);
    }
    this.mAdapter = new mpb(this.mApp, paramAVActivity, localArrayList1, this.mListView, this);
    this.mItemEvent = new mpa(this);
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
    lff locallff;
    for (paramZimuItem = "0";; paramZimuItem = paramZimuItem.getId())
    {
      QLog.w("ZimuToolbar", 1, "onItemSelectedChanged begin, id[" + paramZimuItem + "], seq[" + paramLong + "]");
      this.mAdapter.a("onItemSelectedChanged", paramLong, paramZimuItem);
      locallff = VideoController.a().a();
      if (!liw.a(paramZimuItem)) {
        break;
      }
      locallff.a.set(4);
      return;
    }
    locallff.a.clear(4);
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
          if (liw.a(localZimuItem.getId())) {
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
      if (liw.a((String)localObject1))
      {
        localObject2 = localObject1;
        if (!this.mARZimuEnable) {
          localObject2 = "0";
        }
      }
      this.mAdapter.a("onShow", paramLong, (String)localObject2);
      if (paramInt != getUIInfo().d) {
        liy.a("0X80085CA", "");
      }
      this.mZimuManager.a(paramLong, this);
      if (!((String)localObject2).equalsIgnoreCase("0")) {
        this.mZimuManager.a("onShow_" + (String)localObject2, false, paramLong, null);
      }
      return;
    }
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, mii parammii, mih parammih)
  {
    paramAppInterface = (ZimuItem)this.mZimuManager.a(parammii.jdField_a_of_type_JavaLangString);
    if (paramAppInterface != null)
    {
      this.mZimuManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("ZimuToolbar", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammih.a(paramLong, parammii.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuToolbar
 * JD-Core Version:    0.7.0.1
 */