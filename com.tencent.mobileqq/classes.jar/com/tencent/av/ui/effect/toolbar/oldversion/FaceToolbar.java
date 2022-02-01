package com.tencent.av.ui.effect.toolbar.oldversion;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;

public class FaceToolbar
  extends BaseToolbarOldVersion
  implements View.OnClickListener, EffectConfigBase.IEffectConfigCallback<FaceItem>, IItemDownloadMgr
{
  public static String TAG = "FaceToolbar";
  static String unbaleInfo;
  FrameLayout btnFace;
  FrameLayout btnPendant;
  FrameLayout btnVoiceSticker;
  View lineFace;
  View linePendant;
  View lineVoiceSticker;
  QAVPtvTemplateAdapter mAdapterFace;
  QAVPtvTemplateAdapter mAdapterPendant;
  QAVPtvTemplateAdapter mAdapterVoiceSticker;
  private ControlUIObserver mControlUIObs = null;
  IEffectCallback mFaceClickCallback = new FaceToolbar.3(this);
  EffectFaceManager mFaceManager;
  ArrayList<QavListItemBase.ItemInfo> mFaceTmpList;
  HorizontalListView mListView;
  ArrayList<QavListItemBase.ItemInfo> mPeandantTmpList;
  private RedTouch mRedTouchInteractiveVideo;
  int mSelectTab = 0;
  EffectSupportManager mSupportManager;
  BaseToolbar.UIInfo mUIInfo = null;
  ArrayList<QavListItemBase.ItemInfo> mVoiceStickerTmpList;
  
  public FaceToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<QavListItemBase.ItemInfo> getList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject).a = "-1";
    localArrayList.add(0, localObject);
    boolean bool2 = PtuResChecker.a().b();
    boolean bool3 = this.mSupportManager.a(3, "normal");
    boolean bool4 = this.mSupportManager.a(3, "interact");
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getList, type[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], supportNormal[");
    localStringBuilder.append(bool3);
    localStringBuilder.append("], supportInteract[");
    localStringBuilder.append(bool4);
    localStringBuilder.append("], supportCreative[");
    localStringBuilder.append(false);
    localStringBuilder.append("], isSOExist[");
    localStringBuilder.append(bool2);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if ("pendant".equals(paramString))
    {
      localObject = new QavListItemBase.ItemInfo();
      ((QavListItemBase.ItemInfo)localObject).a = "0";
      ((QavListItemBase.ItemInfo)localObject).b = String.valueOf(2130843209);
      ((QavListItemBase.ItemInfo)localObject).h = (bool4 ^ true);
      ((QavListItemBase.ItemInfo)localObject).k = this.mApp.getApp().getString(2131893183);
      localArrayList.add(localObject);
    }
    paramString = this.mFaceManager.c(paramString);
    if ((paramString != null) && (paramString.size() != 0))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = (FaceItem)paramString.next();
        if (((FaceItem)localObject).isShow())
        {
          boolean bool1;
          if ((bool4) && (bool2)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localArrayList.add(getListItemInfoFromEmotionInfo((FaceItem)localObject, bool3, bool1));
        }
      }
    }
    return localArrayList;
  }
  
  static QavListItemBase.ItemInfo getListItemFromInteractiveFilterItemInfo(FaceItem paramFaceItem, boolean paramBoolean)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.f = 3;
    localItemInfo.a = paramFaceItem.getId();
    localItemInfo.c = paramFaceItem.getText();
    localItemInfo.b = paramFaceItem.getIconUrl();
    localItemInfo.g = paramFaceItem.getVipLevel();
    localItemInfo.k = paramFaceItem.getDesc();
    localItemInfo.h = (paramBoolean ^ true);
    if (localItemInfo.h) {
      localItemInfo.d = true;
    } else {
      localItemInfo.d = paramFaceItem.isUsable();
    }
    localItemInfo.m = paramFaceItem;
    return localItemInfo;
  }
  
  static QavListItemBase.ItemInfo getListItemInfoFromEmotionInfo(FaceItem paramFaceItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.f = 1;
    localItemInfo.a = paramFaceItem.getId();
    localItemInfo.c = paramFaceItem.getText();
    localItemInfo.b = paramFaceItem.getIconUrl();
    localItemInfo.g = paramFaceItem.getVipLevel();
    localItemInfo.k = paramFaceItem.getDesc();
    if ((paramBoolean1) && ((paramBoolean2) || (!paramFaceItem.isInteract()))) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    localItemInfo.h = paramBoolean1;
    if (localItemInfo.h) {
      localItemInfo.d = true;
    } else {
      localItemInfo.d = paramFaceItem.isUsable();
    }
    localItemInfo.m = paramFaceItem;
    return localItemInfo;
  }
  
  public static String getUnbaleInfo(VideoController paramVideoController)
  {
    if (unbaleInfo == null) {
      isEnable(paramVideoController);
    }
    return unbaleInfo;
  }
  
  public static boolean isEnable(VideoController paramVideoController)
  {
    if ((paramVideoController != null) && (!paramVideoController.k().I))
    {
      unbaleInfo = paramVideoController.i().getString(2131893211);
      return false;
    }
    return true;
  }
  
  boolean checkDimmStatus(QavListItemBase.ItemInfo paramItemInfo)
  {
    if (paramItemInfo.h)
    {
      EffectsRenderController.m();
      Object localObject = (FaceItem)this.mFaceManager.b(paramItemInfo.a);
      int k;
      if (localObject != null)
      {
        if (((FaceItem)localObject).isInteract()) {
          localObject = "interact";
        } else {
          localObject = "normal";
        }
        boolean bool1 = this.mSupportManager.a(3, (String)localObject);
        int i = 2131893239;
        int j;
        if (!bool1)
        {
          j = 0;
          i = 2131893241;
        }
        else
        {
          j = this.mSupportManager.b(3, (String)localObject);
          if (j == -1) {}
          while (j == 0)
          {
            j = 0;
            break;
          }
          j = 1;
          i = 2131893556;
        }
        k = i;
        if (j != 0)
        {
          k = i;
          if ((paramItemInfo.m instanceof FaceItem))
          {
            localObject = (FaceItem)paramItemInfo.m;
            bool1 = PtuResChecker.a().b();
            boolean bool2 = this.mSupportManager.a(3, "normal");
            boolean bool3 = this.mSupportManager.a(3, "interact");
            if ((bool2) && (((bool3) && (bool1)) || (!((FaceItem)localObject).isInteract()))) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            paramItemInfo.h = bool1;
            k = i;
          }
        }
      }
      else
      {
        k = 0;
      }
      if ((!paramItemInfo.h) && ((paramItemInfo.m instanceof FaceItem)))
      {
        localObject = (FaceItem)paramItemInfo.m;
        paramItemInfo.d = ((FaceItem)localObject).isUsable();
        if (((FaceItem)localObject).isSameType("face"))
        {
          paramItemInfo = this.mAdapterFace;
          if (paramItemInfo != null) {
            paramItemInfo.notifyDataSetChanged();
          }
        }
        else if (((FaceItem)localObject).isSameType("pendant"))
        {
          paramItemInfo = this.mAdapterPendant;
          if (paramItemInfo != null) {
            paramItemInfo.notifyDataSetChanged();
          }
        }
        else if (((FaceItem)localObject).isSameType("voicesticker"))
        {
          paramItemInfo = this.mAdapterVoiceSticker;
          if (paramItemInfo != null) {
            paramItemInfo.notifyDataSetChanged();
          }
        }
      }
      paramItemInfo = (AVActivity)this.mActivity.get();
      if ((k != 0) && (paramItemInfo != null)) {
        TipsUtil.a(this.mApp, 1010, k);
      }
      if (k != 0) {
        return true;
      }
    }
    return false;
  }
  
  public void chooseTab(int paramInt)
  {
    if (this.mListView == null) {
      return;
    }
    if (this.mSelectTab != paramInt)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("chooseTab, tab[");
        localStringBuilder.append(this.mSelectTab);
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      Object localObject = this.linePendant;
      int j = 4;
      if (paramInt == 2) {
        i = 0;
      } else {
        i = 4;
      }
      ((View)localObject).setVisibility(i);
      localObject = this.lineFace;
      if (paramInt == 1) {
        i = 0;
      } else {
        i = 4;
      }
      ((View)localObject).setVisibility(i);
      localObject = this.lineVoiceSticker;
      int i = j;
      if (paramInt == 3) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      localObject = this.btnPendant;
      boolean bool;
      if (paramInt == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((FrameLayout)localObject).setSelected(bool);
      localObject = this.btnFace;
      if (paramInt == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((FrameLayout)localObject).setSelected(bool);
      localObject = this.btnVoiceSticker;
      if (paramInt == 3) {
        bool = true;
      } else {
        bool = false;
      }
      ((FrameLayout)localObject).setSelected(bool);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mApp.b().p(this.mApp.b().k().s));
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      if (paramInt == 2)
      {
        this.mListView.setAdapter(this.mAdapterPendant);
        this.mAdapterPendant.notifyDataSetChanged();
        MagicDataReport.b((String)localObject);
      }
      else if (paramInt == 1)
      {
        this.mListView.setAdapter(this.mAdapterFace);
        this.mAdapterFace.notifyDataSetChanged();
        MagicDataReport.c((String)localObject);
      }
      else if (paramInt == 3)
      {
        this.mListView.setAdapter(this.mAdapterVoiceSticker);
        this.mAdapterVoiceSticker.notifyDataSetChanged();
        MagicDataReport.d((String)localObject);
      }
      this.mSelectTab = paramInt;
      setToolbarBK(false);
      this.mApp.a().postDelayed(new FaceToolbar.2(this), 1000L);
    }
    setLastSelectedIndex();
  }
  
  void enterDoubleScreen()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.b().p(this.mApp.b().k().s));
    localStringBuilder.append("");
    MagicDataReport.a(localStringBuilder.toString());
    this.mApp.b().e(4, "1");
    ((AVActivity)this.mActivity.get()).a(2, false);
  }
  
  void enterOriginScreen()
  {
    ((AVActivity)this.mActivity.get()).h(false);
  }
  
  void fixDimmed(int paramInt)
  {
    if (this.mSupportManager == null) {
      return;
    }
    if (paramInt == 0)
    {
      boolean bool2 = PtuResChecker.a().b();
      boolean bool3 = this.mSupportManager.a(3, "normal");
      boolean bool4 = this.mSupportManager.a(3, "interact");
      Object localObject2;
      if (QLog.isDevelopLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fixDimmed, supportNormal[");
        ((StringBuilder)localObject2).append(bool3);
        ((StringBuilder)localObject2).append("], supportInteract[");
        ((StringBuilder)localObject2).append(bool4);
        ((StringBuilder)localObject2).append("], isSOExist[");
        ((StringBuilder)localObject2).append(bool2);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = this.mPeandantTmpList;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (QavListItemBase.ItemInfo)((Iterator)localObject1).next();
          if ((((QavListItemBase.ItemInfo)localObject2).m instanceof FaceItem))
          {
            FaceItem localFaceItem = (FaceItem)((QavListItemBase.ItemInfo)localObject2).m;
            boolean bool1;
            if ((bool3) && (((bool4) && (bool2)) || (!localFaceItem.isInteract()))) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            ((QavListItemBase.ItemInfo)localObject2).h = bool1;
          }
        }
        localObject1 = this.mAdapterPendant;
        if (localObject1 != null) {
          ((QAVPtvTemplateAdapter)localObject1).notifyDataSetChanged();
        }
      }
    }
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      BaseToolbar.UIInfo localUIInfo = this.mUIInfo;
      localUIInfo.d = 2;
      localUIInfo.h = 2131625812;
      localUIInfo.f = 2130842988;
      localUIInfo.g = this.mApp.getApp().getString(2131893679);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    return getUnbaleInfo(this.mApp.b());
  }
  
  public boolean isEffectBtnEnable()
  {
    return true ^ isOpenAvatar2D(true);
  }
  
  public boolean isEffectBtnNormal()
  {
    return (!isOpenAvatar2D(true)) && (isEnable(this.mApp.b()));
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject2);
    AVLog.printColorLog(str, localStringBuilder.toString());
    this.mApp.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.c();
    BaseToolbar.keepInToolbar(this.mApp, l);
    if ((paramView.getId() != 2131429955) && (paramView.getId() != 2131429885)) {
      enterOriginScreen();
    } else {
      enterDoubleScreen();
    }
    int i = paramView.getId();
    if (i != 2131429885)
    {
      if (i != 2131429955)
      {
        if (i == 2131430072) {
          chooseTab(3);
        }
      }
      else {
        chooseTab(2);
      }
    }
    else {
      chooseTab(1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAG, onCreate, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.mFaceManager = ((EffectFaceManager)this.mApp.c(3));
    this.mSupportManager = ((EffectSupportManager)this.mApp.c(5));
    this.mSelectTab = 0;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131435195));
    this.mListView.setStayDisplayOffsetZero(true);
    this.linePendant = this.toolbarView.findViewById(2131437223);
    this.lineFace = this.toolbarView.findViewById(2131437215);
    this.lineVoiceSticker = this.toolbarView.findViewById(2131437235);
    this.btnPendant = ((FrameLayout)this.toolbarView.findViewById(2131429955));
    this.btnFace = ((FrameLayout)this.toolbarView.findViewById(2131429885));
    this.btnVoiceSticker = ((FrameLayout)this.toolbarView.findViewById(2131430072));
    boolean bool = EffectsRenderController.c();
    if (!bool) {
      this.btnPendant.setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, isAEModuleEnable[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], isCCropEnable[");
      localStringBuilder.append(false);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.btnPendant.setOnClickListener(this);
    this.btnFace.setOnClickListener(this);
    this.btnVoiceSticker.setOnClickListener(this);
    this.mFaceTmpList = getList("face");
    this.mPeandantTmpList = getList("pendant");
    this.mVoiceStickerTmpList = getList("voicesticker");
    this.mAdapterFace = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mFaceTmpList, this.mListView);
    this.mAdapterFace.a(this.mFaceClickCallback);
    this.mAdapterFace.a(this);
    this.mAdapterFace.a(false);
    this.mAdapterFace.b(false);
    this.mAdapterPendant = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mPeandantTmpList, this.mListView);
    this.mAdapterPendant.a(this.mFaceClickCallback);
    this.mAdapterPendant.a(this);
    this.mAdapterPendant.a(false);
    this.mAdapterPendant.b(true);
    this.mAdapterVoiceSticker = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mVoiceStickerTmpList, this.mListView);
    this.mAdapterVoiceSticker.a(this.mFaceClickCallback);
    this.mAdapterVoiceSticker.a(this);
    this.mAdapterVoiceSticker.a(false);
    this.mAdapterVoiceSticker.b(false);
    paramAVActivity = (FaceItem)this.mFaceManager.c();
    if (paramAVActivity != null)
    {
      if (paramAVActivity.isSameType("pendant")) {
        chooseTab(2);
      } else {
        chooseTab(1);
      }
    }
    else if (this.mVoiceStickerTmpList.size() > 1)
    {
      chooseTab(3);
    }
    else
    {
      this.btnVoiceSticker.setVisibility(8);
      chooseTab(1);
    }
    if (!PtuResChecker.a().b())
    {
      if (this.mControlUIObs == null) {
        this.mControlUIObs = new FaceToolbar.1(this);
      }
      this.mApp.a(this.mControlUIObs);
    }
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    Object localObject = this.mControlUIObs;
    if (localObject != null)
    {
      paramVideoAppInterface.b((Observer)localObject);
      this.mControlUIObs = null;
    }
    this.mFaceManager.b(paramLong, this);
    this.mListView = null;
    this.mAdapterFace = null;
    this.mAdapterPendant = null;
    this.mAdapterVoiceSticker = null;
    paramVideoAppInterface = this.mFaceTmpList;
    if (paramVideoAppInterface != null)
    {
      paramVideoAppInterface = paramVideoAppInterface.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        localObject = (QavListItemBase.ItemInfo)paramVideoAppInterface.next();
        if ((!"0".equals(((QavListItemBase.ItemInfo)localObject).a)) && (!TextUtils.isEmpty(((QavListItemBase.ItemInfo)localObject).b))) {
          URLDrawable.removeMemoryCacheByUrl(((QavListItemBase.ItemInfo)localObject).b);
        }
      }
    }
    this.mFaceTmpList = null;
    paramVideoAppInterface = this.mPeandantTmpList;
    if (paramVideoAppInterface != null)
    {
      paramVideoAppInterface = paramVideoAppInterface.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        localObject = (QavListItemBase.ItemInfo)paramVideoAppInterface.next();
        if ((!"0".equals(((QavListItemBase.ItemInfo)localObject).a)) && (!TextUtils.isEmpty(((QavListItemBase.ItemInfo)localObject).b))) {
          URLDrawable.removeMemoryCacheByUrl(((QavListItemBase.ItemInfo)localObject).b);
        }
      }
    }
    this.mPeandantTmpList = null;
    paramVideoAppInterface = this.mVoiceStickerTmpList;
    if (paramVideoAppInterface != null)
    {
      paramVideoAppInterface = paramVideoAppInterface.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        localObject = (QavListItemBase.ItemInfo)paramVideoAppInterface.next();
        if ((!"0".equals(((QavListItemBase.ItemInfo)localObject).a)) && (!TextUtils.isEmpty(((QavListItemBase.ItemInfo)localObject).b))) {
          URLDrawable.removeMemoryCacheByUrl(((QavListItemBase.ItemInfo)localObject).b);
        }
      }
    }
    this.mVoiceStickerTmpList = null;
  }
  
  public void onDownloadFinish(long paramLong, FaceItem paramFaceItem, boolean paramBoolean)
  {
    if (paramFaceItem == null) {
      return;
    }
    QAVPtvTemplateAdapter localQAVPtvTemplateAdapter;
    if (paramFaceItem.isSameType("face"))
    {
      localQAVPtvTemplateAdapter = this.mAdapterFace;
      if (localQAVPtvTemplateAdapter != null) {
        localQAVPtvTemplateAdapter.a(paramLong, paramFaceItem.getId(), paramBoolean);
      }
    }
    else if (paramFaceItem.isSameType("pendant"))
    {
      localQAVPtvTemplateAdapter = this.mAdapterPendant;
      if (localQAVPtvTemplateAdapter != null) {
        localQAVPtvTemplateAdapter.a(paramLong, paramFaceItem.getId(), paramBoolean);
      }
    }
    else if (paramFaceItem.isSameType("voicesticker"))
    {
      localQAVPtvTemplateAdapter = this.mAdapterVoiceSticker;
      if (localQAVPtvTemplateAdapter != null) {
        localQAVPtvTemplateAdapter.a(paramLong, paramFaceItem.getId(), paramBoolean);
      }
    }
  }
  
  protected void onHide(long paramLong)
  {
    this.mFaceManager.b(paramLong, this);
    setToolbarBK(true);
  }
  
  public void onItemSelectedChanged(long paramLong, FaceItem paramFaceItem)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onItemSelectedChanged, seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], current[");
    ((StringBuilder)localObject2).append(paramFaceItem);
    ((StringBuilder)localObject2).append("], mSelectTab[");
    ((StringBuilder)localObject2).append(this.mSelectTab);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = (EffectOperateManager)this.mApp.c(8);
    if ((localObject1 != null) && (((EffectOperateManager)localObject1).h()) && (paramFaceItem != null))
    {
      localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemSelectedChanged type: ");
      localStringBuilder.append(paramFaceItem.getType());
      localStringBuilder.append(", id: ");
      localStringBuilder.append(paramFaceItem.getId());
      AVLog.printColorLog((String)localObject2, localStringBuilder.toString());
      paramFaceItem = paramFaceItem.getType();
      if ("pendant".equals(paramFaceItem)) {
        chooseTab(2);
      } else if ("face".equals(paramFaceItem)) {
        chooseTab(1);
      } else if ("voicesticker".equals(paramFaceItem)) {
        chooseTab(3);
      }
      ((EffectOperateManager)localObject1).c(false);
      return;
    }
    setLastSelectedIndex();
  }
  
  public void onProgressUpdate(FaceItem paramFaceItem, int paramInt)
  {
    QAVPtvTemplateAdapter localQAVPtvTemplateAdapter;
    if (paramFaceItem.isSameType("face"))
    {
      localQAVPtvTemplateAdapter = this.mAdapterFace;
      if (localQAVPtvTemplateAdapter != null) {
        localQAVPtvTemplateAdapter.a(paramFaceItem.getId(), paramInt);
      }
    }
    else if (paramFaceItem.isSameType("pendant"))
    {
      localQAVPtvTemplateAdapter = this.mAdapterPendant;
      if (localQAVPtvTemplateAdapter != null) {
        localQAVPtvTemplateAdapter.a(paramFaceItem.getId(), paramInt);
      }
    }
    else if (paramFaceItem.isSameType("voicesticker"))
    {
      localQAVPtvTemplateAdapter = this.mAdapterVoiceSticker;
      if (localQAVPtvTemplateAdapter != null) {
        localQAVPtvTemplateAdapter.a(paramFaceItem.getId(), paramInt);
      }
    }
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    setLastSelectedIndex();
    this.mFaceManager.a(paramLong, this);
    if (((AVActivity)this.mActivity.get()).q())
    {
      if (this.mSelectTab == 3)
      {
        QLog.w(TAG, 1, "onShow, 重新选择tab");
        chooseTab(1);
      }
    }
    else
    {
      paramInt = this.mSelectTab;
      if ((paramInt == 1) || (paramInt == 2)) {
        enterDoubleScreen();
      }
    }
    setToolbarBK(false);
  }
  
  void setLastSelectedIndex()
  {
    Object localObject = this.mFaceManager;
    if (localObject == null) {
      return;
    }
    if (this.mSelectTab == 2)
    {
      localObject = (FaceItem)((EffectFaceManager)localObject).c();
      if (localObject == null) {
        localObject = "0";
      } else {
        localObject = ((FaceItem)localObject).getId();
      }
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLastSelectedIndex:");
      localStringBuilder.append((String)localObject);
      AVLog.printColorLog(str, localStringBuilder.toString());
      EffectToolbar.setLastSelectedIndex((String)localObject, this.mPeandantTmpList, this.mAdapterPendant, this.mListView);
    }
  }
  
  void setToolbarBK(boolean paramBoolean)
  {
    AVActivity localAVActivity = (AVActivity)this.mActivity.get();
    if ((localAVActivity != null) && (localAVActivity.K != null) && (localAVActivity.K.am() != null))
    {
      if (!paramBoolean)
      {
        int i = this.mSelectTab;
        if ((i != 1) && (i != 2))
        {
          localAVActivity.K.am().setRootBackground(Boolean.valueOf(false), 0, 2130843186);
          return;
        }
      }
      localAVActivity.K.am().setRootBackground(Boolean.valueOf(true), 0, 0);
    }
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (FaceItem)this.mFaceManager.b(paramItemInfo.a);
    if (paramAppInterface != null)
    {
      this.mFaceManager.b(paramLong, paramAppInterface);
      return;
    }
    paramAppInterface = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownloadTemplate, item为空, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(paramAppInterface, 1, localStringBuilder.toString());
    paramIDownloadCallback.a(paramLong, paramItemInfo.a, false);
  }
  
  public void update(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
    {
      this.mFaceTmpList = getList("face");
      this.mPeandantTmpList = getList("pendant");
      this.mVoiceStickerTmpList = getList("voicesticker");
      this.mAdapterFace.a(this.mFaceTmpList);
      this.mAdapterPendant.a(this.mPeandantTmpList);
      this.mAdapterVoiceSticker.a(this.mVoiceStickerTmpList);
    }
    else if (paramArrayOfObject.length == 2)
    {
      String str = (String)paramArrayOfObject[0];
      i = ((Integer)paramArrayOfObject[1]).intValue();
      paramArrayOfObject = (FaceItem)this.mFaceManager.b(str);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.isSameType("face")) {
          this.mAdapterFace.c(str, i);
        } else if (paramArrayOfObject.isSameType("pendant")) {
          this.mAdapterPendant.c(str, i);
        } else if (paramArrayOfObject.isSameType("voicesticker")) {
          this.mAdapterVoiceSticker.c(str, i);
        }
      }
    }
    int j = this.mSelectTab;
    int i = j;
    if (j == 0) {
      i = 3;
    }
    chooseTab(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.FaceToolbar
 * JD-Core Version:    0.7.0.1
 */