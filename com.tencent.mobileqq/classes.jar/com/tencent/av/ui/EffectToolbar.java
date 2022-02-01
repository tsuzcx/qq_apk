package com.tencent.av.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.av.business.manager.panorama.PanoramaAccessManager;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.tips.TipsUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
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

public class EffectToolbar
  extends BaseToolbar
  implements View.OnClickListener, EffectConfigBase.IEffectConfigCallback<PendantItem>, QAVPtvTemplateAdapter.IItemDownloadMgr
{
  private static final String TAG = "EffectToolbar";
  QAVPtvTemplateAdapter mAdapter;
  Button mEarbackBtn = null;
  QAVPtvTemplateAdapter.IEffectCallback mEffectClickCallback = new EffectToolbar.1(this);
  HorizontalListView mListView;
  protected EffectToolbar.MyDataObserver mObserver;
  private EffectPendantTools mPendantManager;
  Map<String, PendantItem> mPtvTemplateInfoMap = new HashMap();
  ArrayList<QavListItemBase.ItemInfo> mTemplateList = null;
  BaseToolbar.UIInfo mUIInfo = null;
  
  public EffectToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<QavListItemBase.ItemInfo> addItem_with_Double_Video_type()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject).a = "-1";
    localArrayList.add(localObject);
    localObject = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject).a = "0";
    ((QavListItemBase.ItemInfo)localObject).b = String.valueOf(2130842368);
    ((QavListItemBase.ItemInfo)localObject).jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131704017);
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
        if ((localPendantItem.isShow()) && (EffectFilterTools.a(localPendantItem)) && ((!PendantItem.isPanorama(localPendantItem.getKind())) || ((EffectSettingUi.a(this.mApp, false)) && (PanoramaAccessManager.a()))))
        {
          localArrayList.add(QavListItemHelper.a(0, localPendantItem));
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
    if (this.mPendantManager.jdField_d_of_type_JavaLangString != null)
    {
      localObject = this.mPendantManager.jdField_d_of_type_JavaLangString;
      this.mPendantManager.jdField_d_of_type_JavaLangString = null;
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
        AVLog.printAllUserLog("EffectToolbar", paramObservable);
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
      paramString = (FaceItem)((EffectFaceManager)this.mApp.a(3)).a();
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
      localObject1 = (FaceItem)((EffectFaceManager)this.mApp.a(3)).a();
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
  
  static int setLastSelectedIndex(String paramString, ArrayList<QavListItemBase.ItemInfo> paramArrayList, QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter, HorizontalListView paramHorizontalListView)
  {
    if ((paramArrayList == null) || (paramQAVPtvTemplateAdapter == null) || (paramHorizontalListView == null)) {
      return -1;
    }
    int i = 1;
    if (i < paramArrayList.size()) {
      if (!((QavListItemBase.ItemInfo)paramArrayList.get(i)).a.equals(paramString)) {}
    }
    for (;;)
    {
      setSelectedListViewItemAndShow(paramHorizontalListView, paramQAVPtvTemplateAdapter, i);
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private void updateEarbackBtn()
  {
    int i = 2130842482;
    if (this.mApp.a().a().aC) {
      i = 2130842483;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      this.mUIInfo.jdField_d_of_type_Int = 1;
      this.mUIInfo.g = 2131559898;
      this.mUIInfo.f = 2130842461;
      this.mUIInfo.a = this.mApp.getApp().getString(2131695911);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131695452);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    if (!EffectsRenderController.b()) {
      return false;
    }
    boolean bool = EffectsRenderController.d();
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectEnable", 4, String.format("特效按钮可用, bSuc[%s]", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AVLog.printColorLog("EffectToolbar", "notifyEvent :" + paramInteger + "|" + paramObject1);
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
    SessionInfo localSessionInfo = this.mApp.a().a();
    if (!this.mApp.a().a().aC) {}
    for (boolean bool = true;; bool = false)
    {
      localSessionInfo.aC = bool;
      if (this.mApp.a().a().U != 0) {
        this.mApp.a().c(this.mApp.a().a().aC);
      }
      updateEarbackBtn();
      if (!this.mApp.a().a().aC) {
        TipsUtil.a(this.mApp, 1017);
      }
      EffectSettingUi.a(this.mApp, -1009L);
      break;
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mPendantManager = ((EffectPendantTools)this.mApp.a(2));
    this.mObserver = new EffectToolbar.MyDataObserver(this);
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368580));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mTemplateList = addItem_with_Double_Video_type();
    this.mAdapter = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mTemplateList, this.mListView);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mEffectClickCallback);
    this.mAdapter.a(this);
    this.mListView.setAdapter(this.mAdapter);
    setLastItem();
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131364562));
    this.mEarbackBtn.setOnClickListener(this);
    AVEffectPendantReport.c();
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
      paramPendantItem = VideoController.a().a(false);
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
      if (!((QavListItemBase.ItemInfo)this.mTemplateList.get(i)).a.equals(str)) {}
    }
    for (paramPendantItem = (QavListItemBase.ItemInfo)this.mTemplateList.get(i);; paramPendantItem = null)
    {
      if ((!str.isEmpty()) && (paramPendantItem != null) && (paramPendantItem.jdField_d_of_type_Int > 0))
      {
        QLog.i("EffectToolbar", 2, "onItemSelectedChanged voiceid : " + paramPendantItem.jdField_d_of_type_Int);
        this.mApp.a().a().V = paramPendantItem.jdField_d_of_type_Int;
        this.mEarbackBtn.setVisibility(0);
        updateEarbackBtn();
      }
      for (;;)
      {
        this.mApp.a().y();
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
    AVEffectPendantReport.c();
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (PendantItem)this.mPendantManager.a(paramItemInfo.a);
    if (paramAppInterface != null)
    {
      this.mPendantManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w("EffectToolbar", 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    paramIDownloadCallback.a(paramLong, paramItemInfo.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar
 * JD-Core Version:    0.7.0.1
 */