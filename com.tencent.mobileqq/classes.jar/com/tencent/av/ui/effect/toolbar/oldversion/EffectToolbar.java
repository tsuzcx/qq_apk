package com.tencent.av.ui.effect.toolbar.oldversion;

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
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.QavListItemHelper;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.utils.VideoUtil;
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
  extends BaseToolbarOldVersion
  implements View.OnClickListener, EffectConfigBase.IEffectConfigCallback<PendantItem>, IItemDownloadMgr
{
  private static final String TAG = "EffectToolbar";
  QAVPtvTemplateAdapter mAdapter;
  Button mEarbackBtn = null;
  IEffectCallback mEffectClickCallback = new EffectToolbar.1(this);
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
    Object localObject1 = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject1).a = "-1";
    localArrayList.add(localObject1);
    localObject1 = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject1).a = "0";
    ((QavListItemBase.ItemInfo)localObject1).b = String.valueOf(2130843209);
    ((QavListItemBase.ItemInfo)localObject1).k = HardCodeUtil.a(2131902029);
    localArrayList.add(localObject1);
    this.mPtvTemplateInfoMap.clear();
    localObject1 = this.mPendantManager.c(null);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addItem_with_Double_Video_type, size[");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        ((StringBuilder)localObject2).append("]");
        QLog.i("EffectToolbar", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PendantItem)((Iterator)localObject1).next();
        if ((((PendantItem)localObject2).isShow()) && (EffectFilterTools.a((PendantItem)localObject2)) && ((!PendantItem.isPanorama(((PendantItem)localObject2).getKind())) || ((VideoUtil.a(this.mApp, false)) && (PanoramaAccessManager.a()))))
        {
          localArrayList.add(QavListItemHelper.a(0, (PendantItem)localObject2));
          this.mPtvTemplateInfoMap.put(((PendantItem)localObject2).getId(), localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  @Nullable
  private String getCurrentPendantId()
  {
    Object localObject = this.mPendantManager.k;
    StringBuilder localStringBuilder = null;
    if (localObject != null)
    {
      localObject = this.mPendantManager.k;
      this.mPendantManager.k = null;
    }
    else
    {
      PendantItem localPendantItem = (PendantItem)this.mPendantManager.c();
      localObject = localStringBuilder;
      if (localPendantItem != null) {
        if (!localPendantItem.isShow()) {
          localObject = localStringBuilder;
        } else {
          localObject = localPendantItem.getId();
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentPendantId, id[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      QLog.w("EffectToolbar", 1, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private void handlerObserver(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    int i = ((Integer)paramObservable[0]).intValue();
    if (i != 168)
    {
      if (i != 171) {
        return;
      }
      setLastItem();
      return;
    }
    paramObject = (FaceItem)paramObservable[1];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TYPE_NOTIFY_FACE_ITEM_STATE_CHANGE :");
    if (paramObject == null) {
      paramObservable = "null";
    } else {
      paramObservable = paramObject.getId();
    }
    localStringBuilder.append(paramObservable);
    AVLog.printAllUserLog("EffectToolbar", localStringBuilder.toString());
    if (paramObject != null) {
      setLastItem();
    }
  }
  
  private void postSetCurrentItemById(long paramLong, String paramString)
  {
    notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
    this.mApp.a().post(new EffectToolbar.2(this, paramString, paramLong));
    boolean bool3 = this.mApp.d(3);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString = (FaceItem)((EffectFaceManager)this.mApp.c(3)).c();
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramString.getId())) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("postSetCurrentItemById, isInDoubleScreenPendant[");
      paramString.append(bool1);
      paramString.append("], seq[");
      paramString.append(paramLong);
      paramString.append("]");
      QLog.w("EffectToolbar", 1, paramString.toString());
    }
    if (bool1) {
      VideoController.f().e(3, "START_0");
    }
  }
  
  private void setLastItem()
  {
    String str;
    if (this.mApp.d(3))
    {
      localObject = (FaceItem)((EffectFaceManager)this.mApp.c(3)).c();
      str = null;
      if (localObject != null)
      {
        if (!((FaceItem)localObject).isSameType("pendant"))
        {
          if (((FaceItem)localObject).isSameType("face")) {
            return;
          }
          if (!((FaceItem)localObject).isSameType("voicesticker")) {}
        }
      }
      else {
        str = getCurrentPendantId();
      }
    }
    else
    {
      str = getCurrentPendantId();
    }
    Object localObject = str;
    if (str == null) {
      localObject = "0";
    }
    setLastSelectedIndex((String)localObject, this.mTemplateList, this.mAdapter, this.mListView);
  }
  
  static int setLastSelectedIndex(String paramString, ArrayList<QavListItemBase.ItemInfo> paramArrayList, QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter, HorizontalListView paramHorizontalListView)
  {
    int k = -1;
    int j = k;
    if (paramArrayList != null)
    {
      j = k;
      if (paramQAVPtvTemplateAdapter != null)
      {
        if (paramHorizontalListView == null) {
          return -1;
        }
        int i = 1;
        for (;;)
        {
          j = k;
          if (i >= paramArrayList.size()) {
            break;
          }
          if (((QavListItemBase.ItemInfo)paramArrayList.get(i)).a.equals(paramString))
          {
            j = i;
            break;
          }
          i += 1;
        }
        setSelectedListViewItemAndShow(paramHorizontalListView, paramQAVPtvTemplateAdapter, j);
      }
    }
    return j;
  }
  
  private void updateEarbackBtn()
  {
    int i;
    if (this.mApp.b().k().bX) {
      i = 2130843329;
    } else {
      i = 2130843328;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 1;
      localUIInfo.h = 2131625811;
      localUIInfo.f = 2130843305;
      localUIInfo.g = this.mApp.getApp().getString(2131893688);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null) {
      return ((AVActivity)this.mActivity.get()).getResources().getString(2131893218);
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    return isOpenAvatar2D(false) ^ true;
  }
  
  public boolean isEffectBtnNormal()
  {
    if (!EffectsRenderController.c()) {
      return false;
    }
    if (isOpenAvatar2D(false)) {
      return false;
    }
    boolean bool = EffectsRenderController.e();
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectEnable", 4, String.format("特效按钮可用, bSuc[%s]", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject1);
    AVLog.printColorLog("EffectToolbar", localStringBuilder.toString());
    this.mApp.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430486)
    {
      this.mApp.b().k().bX ^= true;
      if (this.mApp.b().k().cr != 0) {
        this.mApp.b().k(this.mApp.b().k().bX);
      }
      updateEarbackBtn();
      if (!this.mApp.b().k().bX) {
        TipsUtil.a(this.mApp, 1017);
      }
      BaseToolbar.keepInToolbar(this.mApp, -1009L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    this.mPendantManager = ((EffectPendantTools)this.mApp.c(2));
    this.mObserver = new EffectToolbar.MyDataObserver(this);
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131435195));
    this.mListView.setStayDisplayOffsetZero(true);
    this.mTemplateList = addItem_with_Double_Video_type();
    this.mAdapter = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mTemplateList, this.mListView);
    this.mAdapter.a(false);
    this.mAdapter.b(true);
    this.mAdapter.a(this.mEffectClickCallback);
    this.mAdapter.a(this);
    this.mListView.setAdapter(this.mAdapter);
    setLastItem();
    this.mEarbackBtn = ((Button)this.toolbarView.findViewById(2131430486));
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
    QAVPtvTemplateAdapter localQAVPtvTemplateAdapter = this.mAdapter;
    if (localQAVPtvTemplateAdapter != null) {
      localQAVPtvTemplateAdapter.a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  protected void onHide(long paramLong)
  {
    this.mApp.b(this.mObserver);
    this.mPendantManager.b(paramLong, this);
  }
  
  public void onItemSelectedChanged(long paramLong, PendantItem paramPendantItem)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onItemSelectedChanged, current[");
    ((StringBuilder)localObject).append(paramPendantItem);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    int i = 1;
    QLog.w("EffectToolbar", 1, (String)localObject);
    if (paramPendantItem == null)
    {
      paramPendantItem = VideoController.f().m(false);
      if (paramPendantItem != null) {
        paramPendantItem.a(paramLong);
      }
    }
    paramPendantItem = (EffectOperateManager)this.mApp.c(8);
    if ((paramPendantItem != null) && (paramPendantItem.h()))
    {
      String str = paramPendantItem.c();
      setLastSelectedIndex(str, this.mTemplateList, this.mAdapter, this.mListView);
      paramPendantItem.c(false);
      if (str == null) {
        return;
      }
      localObject = null;
      for (;;)
      {
        paramPendantItem = (PendantItem)localObject;
        if (i >= this.mTemplateList.size()) {
          break;
        }
        if (((QavListItemBase.ItemInfo)this.mTemplateList.get(i)).a.equals(str))
        {
          paramPendantItem = (QavListItemBase.ItemInfo)this.mTemplateList.get(i);
          break;
        }
        i += 1;
      }
      if ((!str.isEmpty()) && (paramPendantItem != null) && (paramPendantItem.j > 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemSelectedChanged voiceid : ");
        ((StringBuilder)localObject).append(paramPendantItem.j);
        QLog.i("EffectToolbar", 2, ((StringBuilder)localObject).toString());
        this.mApp.b().k().cs = paramPendantItem.j;
        this.mEarbackBtn.setVisibility(0);
        updateEarbackBtn();
      }
      else
      {
        this.mApp.b().k().cs = 0;
        this.mEarbackBtn.setVisibility(4);
      }
      this.mApp.b().am();
    }
  }
  
  public void onProgressUpdate(PendantItem paramPendantItem, int paramInt)
  {
    QAVPtvTemplateAdapter localQAVPtvTemplateAdapter = this.mAdapter;
    if (localQAVPtvTemplateAdapter != null) {
      localQAVPtvTemplateAdapter.a(paramPendantItem.getId(), paramInt);
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
    paramAppInterface = (PendantItem)this.mPendantManager.b(paramItemInfo.a);
    if (paramAppInterface != null)
    {
      this.mPendantManager.b(paramLong, paramAppInterface);
      return;
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("startDownloadTemplate, item为空, seq[");
    paramAppInterface.append(paramLong);
    paramAppInterface.append("]");
    QLog.w("EffectToolbar", 1, paramAppInterface.toString());
    paramIDownloadCallback.a(paramLong, paramItemInfo.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.EffectToolbar
 * JD-Core Version:    0.7.0.1
 */