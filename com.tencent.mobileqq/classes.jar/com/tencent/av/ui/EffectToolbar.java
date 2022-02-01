package com.tencent.av.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import anvx;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import lbd;
import lfe;
import lgw;
import lhb;
import lhd;
import lht;
import lhx;
import lid;
import lpe;
import lph;
import mbf;
import mcl;
import mec;
import med;
import mhn;
import mht;
import mhu;
import mim;
import min;
import mio;

public class EffectToolbar
  extends BaseToolbar
  implements View.OnClickListener, lgw<PendantItem>, mhu
{
  private static final String TAG = "EffectToolbar";
  mhn mAdapter;
  public Button mEarbackBtn = null;
  mht mEffectClickCallback = new mec(this);
  HorizontalListView mListView;
  protected med mObserver;
  private lid mPendantManager;
  public Map<String, PendantItem> mPtvTemplateInfoMap = new HashMap();
  ArrayList<min> mTemplateList = null;
  mcl mUIInfo = null;
  
  public EffectToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<min> addItem_with_Double_Video_type()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new min();
    ((min)localObject).a = "-1";
    localArrayList.add(localObject);
    localObject = new min();
    ((min)localObject).a = "0";
    ((min)localObject).b = String.valueOf(2130842225);
    ((min)localObject).d = anvx.a(2131703469);
    localArrayList.add(localObject);
    this.mPtvTemplateInfoMap.clear();
    localObject = this.mPendantManager.a(null);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EffectToolbar", 2, "addItem_with_Double_Video_type, size[" + ((List)localObject).size() + "]");
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PendantItem localPendantItem = (PendantItem)((Iterator)localObject).next();
        if ((localPendantItem.isShow()) && (lhb.a(localPendantItem)) && ((!PendantItem.isPanorama(localPendantItem.getKind())) || ((EffectSettingUi.a(this.mApp, false)) && (lht.a()))))
        {
          localArrayList.add(mio.a(0, localPendantItem));
          this.mPtvTemplateInfoMap.put(localPendantItem.getId(), localPendantItem);
        }
      }
    }
    return localArrayList;
  }
  
  @Nullable
  private String getCurrentPendantId()
  {
    Object localObject;
    if (this.mPendantManager.d != null)
    {
      localObject = this.mPendantManager.d;
      this.mPendantManager.d = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EffectToolbar", 1, "getCurrentPendantId, id[" + (String)localObject + "]");
      }
      return localObject;
      localObject = (PendantItem)this.mPendantManager.a();
      if ((localObject == null) || (!((PendantItem)localObject).isShow())) {
        localObject = null;
      } else {
        localObject = ((PendantItem)localObject).getId();
      }
    }
  }
  
  private void handlerObserver(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    case 169: 
    case 170: 
    default: 
      return;
    case 168: 
      paramObject = (FaceItem)paramObservable[1];
      StringBuilder localStringBuilder = new StringBuilder().append("TYPE_NOTIFY_FACE_ITEM_STATE_CHANGE :");
      if (paramObject == null) {}
      for (paramObservable = "null";; paramObservable = paramObject.getId())
      {
        lbd.g("EffectToolbar", paramObservable);
        if (paramObject == null) {
          break;
        }
        setLastItem();
        return;
      }
    }
    setLastItem();
  }
  
  private void postSetCurrentItemById(long paramLong, String paramString)
  {
    notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
    this.mApp.a().post(new EffectToolbar.2(this, paramString, paramLong));
    boolean bool;
    if (this.mApp.a(3))
    {
      paramString = (FaceItem)((lhd)this.mApp.a(3)).a();
      if ((paramString != null) && (TextUtils.isEmpty(paramString.getId()))) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EffectToolbar", 1, "postSetCurrentItemById, isInDoubleScreenPendant[" + bool + "], seq[" + paramLong + "]");
      }
      if (bool) {
        VideoController.a().a(3, "START_0");
      }
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private void setLastItem()
  {
    Object localObject1;
    if (this.mApp.a(3))
    {
      localObject1 = (FaceItem)((lhd)this.mApp.a(3)).a();
      if (localObject1 != null) {
        if ((((FaceItem)localObject1).isSameType("pendant")) || (((FaceItem)localObject1).isSameType("creativecop"))) {
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "0";
      }
      setLastSelectedIndex((String)localObject2, this.mTemplateList, this.mAdapter, this.mListView);
      do
      {
        return;
      } while ((((FaceItem)localObject1).isSameType("face")) || (((FaceItem)localObject1).isSameType("voicesticker")));
      localObject1 = null;
      continue;
      localObject1 = getCurrentPendantId();
      continue;
      localObject1 = getCurrentPendantId();
    }
  }
  
  static int setLastSelectedIndex(String paramString, ArrayList<min> paramArrayList, mhn parammhn, HorizontalListView paramHorizontalListView)
  {
    if ((paramArrayList == null) || (parammhn == null) || (paramHorizontalListView == null)) {
      return -1;
    }
    int i = 1;
    if (i < paramArrayList.size()) {
      if (!((min)paramArrayList.get(i)).a.equals(paramString)) {}
    }
    for (;;)
    {
      setSelectedListViewItemAndShow(paramHorizontalListView, parammhn, i);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130842339;
    if (this.mApp.a().a().aA) {
      i = 2130842340;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected mcl getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mcl();
      this.mUIInfo.d = 1;
      this.mUIInfo.f = 2131559822;
      this.mUIInfo.e = 2130842318;
      this.mUIInfo.a = this.mApp.getApp().getString(2131695668);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131695209);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    if (!lph.b()) {
      return false;
    }
    boolean bool = lph.d();
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectEnable", 4, String.format("特效按钮可用, bSuc[%s]", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    lbd.f("EffectToolbar", "notifyEvent :" + paramInteger + "|" + paramObject1);
    this.mApp.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    lfe locallfe = this.mApp.a().a();
    if (!this.mApp.a().a().aA) {}
    for (boolean bool = true;; bool = false)
    {
      locallfe.aA = bool;
      if (this.mApp.a().a().U != 0) {
        this.mApp.a().c(this.mApp.a().a().aA);
      }
      updateEarbackBtn();
      if (!this.mApp.a().a().aA) {
        mbf.a(this.mApp, 1017);
      }
      EffectSettingUi.a(this.mApp, -1009L);
      break;
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mPendantManager = ((lid)this.mApp.a(2));
    this.mObserver = new med(this);
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368362));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mTemplateList = addItem_with_Double_Video_type();
    this.mAdapter = new mhn(this.mApp, paramAVActivity, this.mTemplateList, this.mListView);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mEffectClickCallback);
    this.mAdapter.a(this);
    this.mListView.setAdapter(this.mAdapter);
    setLastItem();
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364454));
    this.mEarbackBtn.setOnClickListener(this);
    lhx.c();
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.mPendantManager.b(paramLong, this);
    this.mListView = null;
    this.mAdapter = null;
  }
  
  public void onDownloadFinish(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (this.mAdapter != null) {
      this.mAdapter.a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide(long paramLong)
  {
    this.mApp.b(this.mObserver);
    this.mPendantManager.b(paramLong, this);
  }
  
  public void onItemSelectedChanged(long paramLong, PendantItem paramPendantItem)
  {
    int i = 1;
    QLog.w("EffectToolbar", 1, "onItemSelectedChanged, current[" + paramPendantItem + "], seq[" + paramLong + "]");
    if (paramPendantItem == null)
    {
      paramPendantItem = VideoController.a().a(((AVActivity)this.mActivity.get()).getApplicationContext());
      if (paramPendantItem != null) {
        paramPendantItem.a(paramLong);
      }
    }
    paramPendantItem = (EffectOperateManager)this.mApp.a(8);
    String str;
    if ((paramPendantItem != null) && (paramPendantItem.a()))
    {
      str = paramPendantItem.a();
      setLastSelectedIndex(str, this.mTemplateList, this.mAdapter, this.mListView);
      paramPendantItem.c(false);
      if (str != null) {}
    }
    else
    {
      return;
    }
    if (i < this.mTemplateList.size()) {
      if (!((min)this.mTemplateList.get(i)).a.equals(str)) {}
    }
    for (paramPendantItem = (min)this.mTemplateList.get(i);; paramPendantItem = null)
    {
      if ((!str.isEmpty()) && (paramPendantItem != null) && (paramPendantItem.c > 0))
      {
        QLog.i("EffectToolbar", 2, "onItemSelectedChanged voiceid : " + paramPendantItem.c);
        this.mApp.a().a().V = paramPendantItem.c;
        this.mEarbackBtn.setVisibility(0);
        updateEarbackBtn();
      }
      for (;;)
      {
        this.mApp.a().z();
        return;
        i += 1;
        break;
        this.mApp.a().a().V = 0;
        this.mEarbackBtn.setVisibility(4);
      }
    }
  }
  
  public void onProgressUpdate(PendantItem paramPendantItem, int paramInt)
  {
    if (this.mAdapter != null) {
      this.mAdapter.a(paramPendantItem.getId(), paramInt);
    }
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    setLastItem();
    this.mApp.a(this.mObserver);
    this.mPendantManager.a(paramLong, this);
    if (this.mEarbackBtn.isShown()) {
      updateEarbackBtn();
    }
    if (QLog.isColorLevel()) {
      QLog.i("EffectToolbar", 2, String.format("onShow", new Object[0]));
    }
    lhx.c();
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, min parammin, mim parammim)
  {
    paramAppInterface = (PendantItem)this.mPendantManager.a(parammin.a);
    if (paramAppInterface != null)
    {
      this.mPendantManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("EffectToolbar", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammim.a(paramLong, parammin.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar
 * JD-Core Version:    0.7.0.1
 */