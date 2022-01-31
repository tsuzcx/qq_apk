package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.widget.QQToast;
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
import jua;
import jub;
import juc;

public class EffectToolbar
  extends BaseToolbar
  implements View.OnClickListener, EffectConfigBase.IEffectConfigCallback, QAVPtvTemplateAdapter.IItemDownloadMgr
{
  private static final String TAG = "EffectToolbar";
  QAVPtvTemplateAdapter mAdapter;
  public Button mEarbackBtn = null;
  QAVPtvTemplateAdapter.IEffectCallback mEffectClickCallback = new jua(this);
  boolean mEnableGesture = false;
  HorizontalListView mListView;
  protected juc mObserver;
  private EffectPendantTools mPendantManager;
  public Map mPtvTemplateInfoMap = new HashMap();
  ArrayList mTemplateList = null;
  BaseToolbar.UIInfo mUIInfo = null;
  
  public EffectToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  @Nullable
  private String getCurrentPendantId()
  {
    Object localObject = (PendantItem)this.mPendantManager.a();
    if ((localObject == null) || (!((PendantItem)localObject).isShow())) {}
    for (localObject = null;; localObject = ((PendantItem)localObject).getId())
    {
      if (QLog.isColorLevel()) {
        QLog.i("EffectToolbar", 2, String.format("getCurrentPendantId", new Object[0]));
      }
      return localObject;
    }
  }
  
  private void handlerObserver(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    default: 
      return;
    }
    paramObject = (FaceItem)paramObservable[1];
    StringBuilder localStringBuilder = new StringBuilder().append("TYPE_NOTIFY_FACE_ITEM_STATE_CHANGE :");
    if (paramObject == null) {}
    for (paramObservable = "null";; paramObservable = paramObject.getId())
    {
      AVLog.d("EffectToolbar", paramObservable);
      if (paramObject == null) {
        break;
      }
      setLastItem();
      return;
    }
  }
  
  private void postSetCurrentItemById(String paramString)
  {
    notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
    this.mApp.a().post(new jub(this, paramString));
    boolean bool;
    if (this.mApp.a(3))
    {
      paramString = (FaceItem)((EffectFaceManager)this.mApp.a(3)).a();
      if ((paramString != null) && (TextUtils.isEmpty(paramString.getId()))) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EffectToolbar", 2, "isInDoubleScreenPendant:" + bool);
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
  
  private QavListItemBase.ItemInfo ptvData2AVData(PendantItem paramPendantItem)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.jdField_a_of_type_Int = 0;
    localItemInfo.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localItemInfo.b = paramPendantItem.getIconurl();
    localItemInfo.jdField_c_of_type_JavaLangString = paramPendantItem.getName();
    localItemInfo.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localItemInfo.jdField_c_of_type_Int = paramPendantItem.getVoiceId();
    localItemInfo.d = paramPendantItem.getDesc();
    return localItemInfo;
  }
  
  private void setLastItem()
  {
    Object localObject1;
    if (this.mApp.a(3))
    {
      localObject1 = (FaceItem)((EffectFaceManager)this.mApp.a(3)).a();
      if (localObject1 != null) {
        if ("pendant".equalsIgnoreCase(((FaceItem)localObject1).getType())) {
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
      } while ("face".equalsIgnoreCase(((FaceItem)localObject1).getType()));
      localObject1 = null;
      continue;
      localObject1 = getCurrentPendantId();
      continue;
      localObject1 = getCurrentPendantId();
    }
  }
  
  static int setLastSelectedIndex(String paramString, ArrayList paramArrayList, QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter, HorizontalListView paramHorizontalListView)
  {
    int j;
    if ((paramArrayList == null) || (paramQAVPtvTemplateAdapter == null) || (paramHorizontalListView == null))
    {
      j = -1;
      return j;
    }
    int i = 1;
    label21:
    if (i < paramArrayList.size()) {
      if (!((QavListItemBase.ItemInfo)paramArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
    }
    for (;;)
    {
      j = i;
      if (!paramQAVPtvTemplateAdapter.a(i)) {
        break;
      }
      if (i >= paramHorizontalListView.getFirstVisiblePosition())
      {
        j = i;
        if (i <= paramHorizontalListView.getLastVisiblePosition()) {
          break;
        }
      }
      int k = 0;
      j = k;
      if (i > 0)
      {
        j = k;
        if (i > QAVPtvTemplateAdapter.a(paramQAVPtvTemplateAdapter.jdField_a_of_type_AndroidContentContext)) {
          j = paramQAVPtvTemplateAdapter.b + paramQAVPtvTemplateAdapter.jdField_a_of_type_Int * (i - 1);
        }
      }
      paramHorizontalListView.a(j);
      return i;
      i += 1;
      break label21;
      i = -1;
    }
  }
  
  public static void showCloseEarbackToast(Context paramContext)
  {
    paramContext = QQToast.a(paramContext, 2, 2131429607, 1);
    paramContext.a();
    paramContext.a();
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130840361;
    if (this.mApp.a().a().aC) {
      i = 2130840362;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  ArrayList addItem_with_Double_Video_type(VideoAppInterface paramVideoAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject).jdField_a_of_type_JavaLangString = "-1";
    localArrayList.add(localObject);
    localObject = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject).jdField_a_of_type_JavaLangString = "0";
    ((QavListItemBase.ItemInfo)localObject).b = String.valueOf(2130840282);
    ((QavListItemBase.ItemInfo)localObject).d = "取消挂件";
    localArrayList.add(localObject);
    this.mPtvTemplateInfoMap.clear();
    boolean bool = EffectFilterTools.b(paramVideoAppInterface.getApp().getBaseContext());
    this.mEnableGesture = GestureMgr.a().c();
    paramVideoAppInterface = this.mPendantManager.a(null);
    if ((paramVideoAppInterface != null) && (!paramVideoAppInterface.isEmpty()))
    {
      AVLog.d("EffectSettingUi", String.format("双人挂件, size[%s], isSupport[%s], bEnableGesture[%s]", new Object[] { Integer.valueOf(paramVideoAppInterface.size()), Boolean.valueOf(bool), Boolean.valueOf(this.mEnableGesture) }));
      paramVideoAppInterface = paramVideoAppInterface.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        localObject = (PendantItem)paramVideoAppInterface.next();
        if (((PendantItem)localObject).isShow())
        {
          QavListItemBase.ItemInfo localItemInfo = ptvData2AVData((PendantItem)localObject);
          if ((!((PendantItem)localObject).hasGesture()) || ((bool) && (this.mEnableGesture)))
          {
            localArrayList.add(localItemInfo);
            this.mPtvTemplateInfoMap.put(((PendantItem)localObject).getId(), localObject);
          }
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
      this.mUIInfo.d = 1;
      this.mUIInfo.g = 2130969361;
      this.mUIInfo.e = 103414;
      this.mUIInfo.f = 2130840343;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getResources().getString(2131428742);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131428736);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    boolean bool = EffectsRenderController.a();
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectEnable", 4, String.format("特效按钮可用, bSuc[%s]", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AVLog.c("EffectToolbar", "notifyEvent :" + paramInteger + "|" + paramObject1);
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
    if (!this.mApp.a().a().aC) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.aC = bool;
      if (this.mApp.a().a().S != 0) {
        this.mApp.a().b(this.mApp.a().a().aC);
      }
      updateEarbackBtn();
      if (!this.mApp.a().a().aC) {
        showCloseEarbackToast((Context)this.mActivity.get());
      }
      EffectSettingUi.a(this.mApp);
      return;
    }
  }
  
  protected void onCreate(AVActivity paramAVActivity)
  {
    this.mPendantManager = ((EffectPendantTools)this.mApp.a(2));
    this.mObserver = new juc(this);
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131366275));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mTemplateList = addItem_with_Double_Video_type(this.mApp);
    this.mAdapter = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mTemplateList, this.mListView);
    ViewGroup.LayoutParams localLayoutParams = this.mListView.getLayoutParams();
    localLayoutParams.height = (this.mAdapter.jdField_a_of_type_Int + AIOUtils.a(30.0F, paramAVActivity.getResources()));
    this.mListView.setLayoutParams(localLayoutParams);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mEffectClickCallback);
    this.mAdapter.a(this);
    this.mListView.setAdapter(this.mAdapter);
    setLastItem();
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131366282));
    this.mEarbackBtn.setOnClickListener(this);
    AVEffectPendantReport.c();
  }
  
  protected void onDestroy(VideoAppInterface paramVideoAppInterface)
  {
    this.mPendantManager.b(this);
    this.mListView = null;
    this.mAdapter = null;
  }
  
  public void onDownloadFinish(PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (this.mAdapter != null) {
      this.mAdapter.a(paramPendantItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide()
  {
    this.mApp.b(this.mObserver);
    this.mPendantManager.b(this);
  }
  
  public void onItemSelectedChanged(PendantItem paramPendantItem)
  {
    QLog.w("EffectToolbar", 1, "onItemSelectedChanged, current[" + paramPendantItem + "]");
    if (paramPendantItem == null)
    {
      paramPendantItem = VideoController.a().a(((AVActivity)this.mActivity.get()).getApplicationContext());
      if (paramPendantItem != null) {
        paramPendantItem.b();
      }
    }
    paramPendantItem = (EffectOperateManager)this.mApp.a(8);
    String str;
    if ((paramPendantItem != null) && (paramPendantItem.b()))
    {
      str = paramPendantItem.a();
      setLastSelectedIndex(str, this.mTemplateList, this.mAdapter, this.mListView);
      paramPendantItem.b(false);
      if (str != null) {}
    }
    else
    {
      return;
    }
    int i = 1;
    paramPendantItem = null;
    if (i < this.mTemplateList.size())
    {
      if (!((QavListItemBase.ItemInfo)this.mTemplateList.get(i)).jdField_a_of_type_JavaLangString.equals(str)) {
        break label289;
      }
      paramPendantItem = (QavListItemBase.ItemInfo)this.mTemplateList.get(i);
    }
    label289:
    for (;;)
    {
      i += 1;
      break;
      if ((!str.isEmpty()) && (paramPendantItem != null) && (paramPendantItem.jdField_c_of_type_Int > 0))
      {
        QLog.i("EffectToolbar", 2, "onItemSelectedChanged voiceid : " + paramPendantItem.jdField_c_of_type_Int);
        this.mApp.a().a().T = paramPendantItem.jdField_c_of_type_Int;
        this.mEarbackBtn.setVisibility(0);
        updateEarbackBtn();
      }
      for (;;)
      {
        this.mApp.a().K();
        return;
        this.mApp.a().a().T = 0;
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
  
  protected void onShow(int paramInt, boolean paramBoolean)
  {
    setLastItem();
    this.mApp.a(this.mObserver);
    this.mPendantManager.a(this);
    if (this.mEarbackBtn.isShown()) {
      updateEarbackBtn();
    }
    if (QLog.isColorLevel()) {
      QLog.i("EffectToolbar", 2, String.format("onShow", new Object[0]));
    }
    AVEffectPendantReport.c();
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (PendantItem)this.mPendantManager.a(paramItemInfo.jdField_a_of_type_JavaLangString);
    if (paramAppInterface != null)
    {
      this.mPendantManager.a(paramAppInterface);
      return;
    }
    AVLog.e("EffectToolbar", "ItemDownloadMgr:startDownloadTemplate failed item = null");
    paramIDownloadCallback.a(paramItemInfo.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar
 * JD-Core Version:    0.7.0.1
 */