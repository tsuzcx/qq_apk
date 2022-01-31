package com.tencent.av.ui;

import alpo;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import azbx;
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
import lek;
import lid;
import ljn;
import ljs;
import lju;
import lkl;
import lkp;
import lkt;
import lrz;
import lsa;
import mdd;
import mej;
import mfx;
import mfy;
import mjk;
import mjp;
import mjq;
import mki;
import mkj;

public class EffectToolbar
  extends BaseToolbar
  implements View.OnClickListener, ljn<PendantItem>, mjq
{
  private static final String TAG = "EffectToolbar";
  mjk mAdapter;
  public Button mEarbackBtn = null;
  mjp mEffectClickCallback = new mfx(this);
  HorizontalListView mListView;
  protected mfy mObserver;
  private lkt mPendantManager;
  public Map<String, PendantItem> mPtvTemplateInfoMap = new HashMap();
  ArrayList<mkj> mTemplateList = null;
  mej mUIInfo = null;
  
  public EffectToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<mkj> addItem_with_Double_Video_type()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new mkj();
    ((mkj)localObject).jdField_a_of_type_JavaLangString = "-1";
    localArrayList.add(localObject);
    localObject = new mkj();
    ((mkj)localObject).jdField_a_of_type_JavaLangString = "0";
    ((mkj)localObject).b = String.valueOf(2130841837);
    ((mkj)localObject).d = alpo.a(2131704372);
    localArrayList.add(localObject);
    this.mPtvTemplateInfoMap.clear();
    localObject = this.mPendantManager.a(null);
    boolean bool;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      bool = ljs.a();
      if ((!bool) || (AEFilterSupport.a())) {
        break label284;
      }
      bool = azbx.a().c();
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
        if ((localPendantItem.isShow()) && (ljs.a(localPendantItem)) && ((!localPendantItem.hasGesture()) || (bool)) && ((!PendantItem.isPanorama(localPendantItem.getKind())) || ((EffectSettingUi.a(this.mApp, false)) && (lkl.a()))))
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
        lek.d("EffectToolbar", paramObservable);
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
      paramString = (FaceItem)((lju)this.mApp.a(3)).a();
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
  
  private mkj ptvData2AVData(PendantItem paramPendantItem)
  {
    mkj localmkj = new mkj();
    localmkj.jdField_a_of_type_Int = 0;
    localmkj.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localmkj.b = paramPendantItem.getIconurl();
    localmkj.jdField_c_of_type_JavaLangString = paramPendantItem.getName();
    localmkj.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localmkj.jdField_c_of_type_Int = paramPendantItem.getVoiceId();
    localmkj.d = paramPendantItem.getDesc();
    return localmkj;
  }
  
  private void setLastItem()
  {
    Object localObject1;
    if (this.mApp.a(3))
    {
      localObject1 = (FaceItem)((lju)this.mApp.a(3)).a();
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
  
  static int setLastSelectedIndex(String paramString, ArrayList<mkj> paramArrayList, mjk parammjk, HorizontalListView paramHorizontalListView)
  {
    if ((paramArrayList == null) || (parammjk == null) || (paramHorizontalListView == null)) {
      return -1;
    }
    int i = 1;
    if (i < paramArrayList.size()) {
      if (!((mkj)paramArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
    }
    for (;;)
    {
      setSelectedListViewItemAndShow(paramHorizontalListView, parammjk, i);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130841950;
    if (this.mApp.a().a().az) {
      i = 2130841951;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected mej getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new mej();
      this.mUIInfo.d = 1;
      this.mUIInfo.f = 2131559641;
      this.mUIInfo.e = 2130841929;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131696385);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131695933);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    if (!lsa.a()) {
      return false;
    }
    boolean bool = lsa.d();
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectEnable", 4, String.format("特效按钮可用, bSuc[%s]", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    lek.c("EffectToolbar", "notifyEvent :" + paramInteger + "|" + paramObject1);
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
    if (!this.mApp.a().a().az) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.az = bool;
      if (this.mApp.a().a().T != 0) {
        this.mApp.a().c(this.mApp.a().a().az);
      }
      updateEarbackBtn();
      if (!this.mApp.a().a().az) {
        mdd.a(this.mApp, 1017);
      }
      EffectSettingUi.a(this.mApp, -1009L);
      return;
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mPendantManager = ((lkt)this.mApp.a(2));
    this.mObserver = new mfy(this);
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131367793));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mTemplateList = addItem_with_Double_Video_type();
    this.mAdapter = new mjk(this.mApp, paramAVActivity, this.mTemplateList, this.mListView);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mEffectClickCallback);
    this.mAdapter.a(this);
    this.mListView.setAdapter(this.mAdapter);
    setLastItem();
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364101));
    this.mEarbackBtn.setOnClickListener(this);
    lkp.c();
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
      if (!((mkj)this.mTemplateList.get(i)).jdField_a_of_type_JavaLangString.equals(str)) {}
    }
    for (paramPendantItem = (mkj)this.mTemplateList.get(i);; paramPendantItem = null)
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
    lkp.c();
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, mkj parammkj, mki parammki)
  {
    paramAppInterface = (PendantItem)this.mPendantManager.a(parammkj.jdField_a_of_type_JavaLangString);
    if (paramAppInterface != null)
    {
      this.mPendantManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("EffectToolbar", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammki.a(paramLong, parammkj.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar
 * JD-Core Version:    0.7.0.1
 */