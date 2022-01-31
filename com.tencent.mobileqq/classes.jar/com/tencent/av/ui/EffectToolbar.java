package com.tencent.av.ui;

import ajjy;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import awhj;
import bbmy;
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
import krx;
import kvq;
import kxa;
import kxf;
import kxi;
import kxx;
import kyb;
import kyd;
import lfg;
import lfi;
import lqb;
import lrg;
import lst;
import lsu;
import lwf;
import lwk;
import lwl;
import lxe;
import lxf;

public class EffectToolbar
  extends BaseToolbar
  implements View.OnClickListener, kxa<PendantItem>, lwl
{
  private static final String TAG = "EffectToolbar";
  lwf mAdapter;
  public Button mEarbackBtn = null;
  lwk mEffectClickCallback = new lst(this);
  HorizontalListView mListView;
  protected lsu mObserver;
  private kyd mPendantManager;
  public Map<String, PendantItem> mPtvTemplateInfoMap = new HashMap();
  ArrayList<lxf> mTemplateList = null;
  lrg mUIInfo = null;
  
  public EffectToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<lxf> addItem_with_Double_Video_type()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new lxf();
    ((lxf)localObject).jdField_a_of_type_JavaLangString = "-1";
    localArrayList.add(localObject);
    localObject = new lxf();
    ((lxf)localObject).jdField_a_of_type_JavaLangString = "0";
    ((lxf)localObject).b = String.valueOf(2130841594);
    ((lxf)localObject).d = ajjy.a(2131638204);
    localArrayList.add(localObject);
    this.mPtvTemplateInfoMap.clear();
    localObject = this.mPendantManager.a(null);
    boolean bool;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      bool = kxf.a();
      if ((!bool) || (AEFilterSupport.a())) {
        break label284;
      }
      bool = awhj.a().c();
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
        if ((localPendantItem.isShow()) && (kxf.a(localPendantItem)) && ((!localPendantItem.hasGesture()) || (bool)) && ((!PendantItem.isPanorama(localPendantItem.getKind())) || ((EffectSettingUi.a(this.mApp, false)) && (kxx.a()))))
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
    if (this.mPendantManager.e != null)
    {
      localObject = this.mPendantManager.e;
      this.mPendantManager.e = null;
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
        krx.d("EffectToolbar", paramObservable);
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
      paramString = (FaceItem)((kxi)this.mApp.a(3)).a();
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
  
  private lxf ptvData2AVData(PendantItem paramPendantItem)
  {
    lxf locallxf = new lxf();
    locallxf.jdField_a_of_type_Int = 0;
    locallxf.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    locallxf.b = paramPendantItem.getIconurl();
    locallxf.jdField_c_of_type_JavaLangString = paramPendantItem.getName();
    locallxf.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    locallxf.jdField_c_of_type_Int = paramPendantItem.getVoiceId();
    locallxf.d = paramPendantItem.getDesc();
    return locallxf;
  }
  
  private void setLastItem()
  {
    Object localObject1;
    if (this.mApp.a(3))
    {
      localObject1 = (FaceItem)((kxi)this.mApp.a(3)).a();
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
  
  static int setLastSelectedIndex(String paramString, ArrayList<lxf> paramArrayList, lwf paramlwf, HorizontalListView paramHorizontalListView)
  {
    if ((paramArrayList == null) || (paramlwf == null) || (paramHorizontalListView == null)) {
      return -1;
    }
    int i = 1;
    if (i < paramArrayList.size()) {
      if (!((lxf)paramArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
    }
    for (;;)
    {
      setSelectedListViewItemAndShow(paramHorizontalListView, paramlwf, i);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static void showCloseEarbackToast(Context paramContext)
  {
    paramContext = bbmy.a(paramContext, 2, 2131630555, 1);
    paramContext.a();
    paramContext.a();
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130841702;
    if (this.mApp.a().a().ay) {
      i = 2130841703;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected lrg getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new lrg();
      this.mUIInfo.d = 1;
      this.mUIInfo.f = 2131494017;
      this.mUIInfo.e = 2130841682;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131630509);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131630085);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    if (!lfi.a()) {
      return false;
    }
    boolean bool = lfi.d();
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectEnable", 4, String.format("特效按钮可用, bSuc[%s]", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    krx.c("EffectToolbar", "notifyEvent :" + paramInteger + "|" + paramObject1);
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
      if (this.mApp.a().a().R != 0) {
        this.mApp.a().c(this.mApp.a().a().ay);
      }
      updateEarbackBtn();
      if (!this.mApp.a().a().ay) {
        lqb.a(this.mApp, 1017);
      }
      EffectSettingUi.a(this.mApp, -1009L);
      return;
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mPendantManager = ((kyd)this.mApp.a(2));
    this.mObserver = new lsu(this);
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131302046));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mTemplateList = addItem_with_Double_Video_type();
    this.mAdapter = new lwf(this.mApp, paramAVActivity, this.mTemplateList, this.mListView);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mEffectClickCallback);
    this.mAdapter.a(this);
    this.mListView.setAdapter(this.mAdapter);
    setLastItem();
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131298482));
    this.mEarbackBtn.setOnClickListener(this);
    kyb.c();
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
      if (!((lxf)this.mTemplateList.get(i)).jdField_a_of_type_JavaLangString.equals(str)) {}
    }
    for (paramPendantItem = (lxf)this.mTemplateList.get(i);; paramPendantItem = null)
    {
      if ((!str.isEmpty()) && (paramPendantItem != null) && (paramPendantItem.jdField_c_of_type_Int > 0))
      {
        QLog.i("EffectToolbar", 2, "onItemSelectedChanged voiceid : " + paramPendantItem.jdField_c_of_type_Int);
        this.mApp.a().a().S = paramPendantItem.jdField_c_of_type_Int;
        this.mEarbackBtn.setVisibility(0);
        updateEarbackBtn();
      }
      for (;;)
      {
        this.mApp.a().A();
        return;
        i += 1;
        break;
        this.mApp.a().a().S = 0;
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
    kyb.c();
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, lxf paramlxf, lxe paramlxe)
  {
    paramAppInterface = (PendantItem)this.mPendantManager.a(paramlxf.jdField_a_of_type_JavaLangString);
    if (paramAppInterface != null)
    {
      this.mPendantManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("EffectToolbar", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    paramlxe.a(paramLong, paramlxf.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar
 * JD-Core Version:    0.7.0.1
 */