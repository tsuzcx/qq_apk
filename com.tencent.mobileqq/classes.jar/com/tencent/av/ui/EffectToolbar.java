package com.tencent.av.ui;

import ajyc;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import axgp;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import lcl;
import lgf;
import lhp;
import lhu;
import lhw;
import lin;
import lir;
import liv;
import lpy;
import lpz;
import mat;
import mbz;
import mdm;
import mdn;
import mgx;
import mhc;
import mhd;
import mhv;
import mhw;

public class EffectToolbar
  extends BaseToolbar
  implements View.OnClickListener, lhp<PendantItem>, mhd
{
  private static final String TAG = "EffectToolbar";
  mgx mAdapter;
  public Button mEarbackBtn = null;
  mhc mEffectClickCallback = new mdm(this);
  HorizontalListView mListView;
  protected mdn mObserver;
  private liv mPendantManager;
  public Map<String, PendantItem> mPtvTemplateInfoMap = new HashMap();
  ArrayList<mhw> mTemplateList = null;
  mbz mUIInfo = null;
  
  public EffectToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<mhw> addItem_with_Double_Video_type()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new mhw();
    ((mhw)localObject).jdField_a_of_type_JavaLangString = "-1";
    localArrayList.add(localObject);
    localObject = new mhw();
    ((mhw)localObject).jdField_a_of_type_JavaLangString = "0";
    ((mhw)localObject).b = String.valueOf(2130841686);
    ((mhw)localObject).d = ajyc.a(2131703989);
    localArrayList.add(localObject);
    this.mPtvTemplateInfoMap.clear();
    localObject = this.mPendantManager.a(null);
    boolean bool;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      bool = lhu.a();
      if ((!bool) || (AEFilterSupport.a())) {
        break label284;
      }
      bool = axgp.a().c();
    }
    label284:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EffectToolbar", 2, "addItem_with_Double_Video_type, isSupportGesture[" + bool + "], size[" + ((List)localObject).size() + "]");
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PendantItem localPendantItem = (PendantItem)((Iterator)localObject).next();
        if ((localPendantItem.isShow()) && (lhu.a(localPendantItem)) && ((!localPendantItem.hasGesture()) || (bool)) && ((!PendantItem.isPanorama(localPendantItem.getKind())) || ((EffectSettingUi.a(this.mApp, false)) && (lin.a()))))
        {
          localArrayList.add(ptvData2AVData(localPendantItem));
          this.mPtvTemplateInfoMap.put(localPendantItem.getId(), localPendantItem);
        }
      }
      return localArrayList;
    }
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
        lcl.d("EffectToolbar", paramObservable);
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
      paramString = (FaceItem)((lhw)this.mApp.a(3)).a();
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
  
  private mhw ptvData2AVData(PendantItem paramPendantItem)
  {
    mhw localmhw = new mhw();
    localmhw.jdField_a_of_type_Int = 0;
    localmhw.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localmhw.b = paramPendantItem.getIconurl();
    localmhw.jdField_c_of_type_JavaLangString = paramPendantItem.getName();
    localmhw.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localmhw.jdField_c_of_type_Int = paramPendantItem.getVoiceId();
    localmhw.d = paramPendantItem.getDesc();
    return localmhw;
  }
  
  private void setLastItem()
  {
    Object localObject1;
    if (this.mApp.a(3))
    {
      localObject1 = (FaceItem)((lhw)this.mApp.a(3)).a();
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
  
  static int setLastSelectedIndex(String paramString, ArrayList<mhw> paramArrayList, mgx parammgx, HorizontalListView paramHorizontalListView)
  {
    if ((paramArrayList == null) || (parammgx == null) || (paramHorizontalListView == null)) {
      return -1;
    }
    int i = 1;
    if (i < paramArrayList.size()) {
      if (!((mhw)paramArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
    }
    for (;;)
    {
      setSelectedListViewItemAndShow(paramHorizontalListView, parammgx, i);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130841797;
    if (this.mApp.a().a().ay) {
      i = 2130841798;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected mbz getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mbz();
      this.mUIInfo.d = 1;
      this.mUIInfo.f = 2131559588;
      this.mUIInfo.e = 2130841776;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131696212);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131695772);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    if (!lpz.a()) {
      return false;
    }
    boolean bool = lpz.d();
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectEnable", 4, String.format("特效按钮可用, bSuc[%s]", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    lcl.c("EffectToolbar", "notifyEvent :" + paramInteger + "|" + paramObject1);
    this.mApp.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = this.mApp.a().a();
    if (!this.mApp.a().a().ay) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.ay = bool;
      if (this.mApp.a().a().T != 0) {
        this.mApp.a().c(this.mApp.a().a().ay);
      }
      updateEarbackBtn();
      if (!this.mApp.a().a().ay) {
        mat.a(this.mApp, 1017);
      }
      EffectSettingUi.a(this.mApp, -1009L);
      return;
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mPendantManager = ((liv)this.mApp.a(2));
    this.mObserver = new mdn(this);
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131367664));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mTemplateList = addItem_with_Double_Video_type();
    this.mAdapter = new mgx(this.mApp, paramAVActivity, this.mTemplateList, this.mListView);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mEffectClickCallback);
    this.mAdapter.a(this);
    this.mListView.setAdapter(this.mAdapter);
    setLastItem();
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364040));
    this.mEarbackBtn.setOnClickListener(this);
    lir.c();
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
      if (!((mhw)this.mTemplateList.get(i)).jdField_a_of_type_JavaLangString.equals(str)) {}
    }
    for (paramPendantItem = (mhw)this.mTemplateList.get(i);; paramPendantItem = null)
    {
      if ((!str.isEmpty()) && (paramPendantItem != null) && (paramPendantItem.jdField_c_of_type_Int > 0))
      {
        QLog.i("EffectToolbar", 2, "onItemSelectedChanged voiceid : " + paramPendantItem.jdField_c_of_type_Int);
        this.mApp.a().a().U = paramPendantItem.jdField_c_of_type_Int;
        this.mEarbackBtn.setVisibility(0);
        updateEarbackBtn();
      }
      for (;;)
      {
        this.mApp.a().A();
        return;
        i += 1;
        break;
        this.mApp.a().a().U = 0;
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
    lir.c();
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, mhw parammhw, mhv parammhv)
  {
    paramAppInterface = (PendantItem)this.mPendantManager.a(parammhw.jdField_a_of_type_JavaLangString);
    if (paramAppInterface != null)
    {
      this.mPendantManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("EffectToolbar", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammhv.a(paramLong, parammhw.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar
 * JD-Core Version:    0.7.0.1
 */