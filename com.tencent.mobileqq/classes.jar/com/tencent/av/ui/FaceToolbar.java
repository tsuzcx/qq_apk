package com.tencent.av.ui;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.av.AVLog;
import com.tencent.av.QavABTestUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.opengl.effects.AEKitAbilityInfo;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.tips.TipsUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaceToolbar
  extends BaseToolbar
  implements View.OnClickListener, EffectConfigBase.IEffectConfigCallback<FaceItem>, QAVPtvTemplateAdapter.IItemDownloadMgr
{
  public static String TAG = "FaceToolbar";
  static String unbaleInfo = null;
  FrameLayout btnFace;
  FrameLayout btnInteractiveVideo;
  FrameLayout btnPendant;
  FrameLayout btnVoiceSticker;
  View lineFace;
  View lineInteractiveVideo;
  View linePendant;
  View lineVoiceSticker;
  QAVPtvTemplateAdapter mAdapterFace;
  QAVPtvTemplateAdapter mAdapterInteractiveVideo;
  QAVPtvTemplateAdapter mAdapterPendant;
  QAVPtvTemplateAdapter mAdapterVoiceSticker;
  private ControlUIObserver mControlUIObs = null;
  QAVPtvTemplateAdapter.IEffectCallback mFaceClickCallback = new FaceToolbar.3(this);
  EffectFaceManager mFaceManager;
  ArrayList<QavListItemBase.ItemInfo> mFaceTmpList;
  ArrayList<QavListItemBase.ItemInfo> mInteractiveVideoTmpList;
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
    ((QavListItemBase.ItemInfo)localObject).jdField_a_of_type_JavaLangString = "-1";
    localArrayList.add(0, localObject);
    boolean bool3 = PtuResChecker.a().a();
    boolean bool1;
    boolean bool4;
    boolean bool5;
    if ((AEKitAbilityInfo.b()) && (PtuResChecker.a().a()))
    {
      bool1 = true;
      bool4 = this.mSupportManager.a(3, "normal");
      bool5 = this.mSupportManager.a(3, "interact");
      boolean bool6 = this.mSupportManager.a(3, "creative");
      QLog.w(TAG, 1, "getList, type[" + paramString + "], supportNormal[" + bool4 + "], supportInteract[" + bool5 + "], supportCreative[" + bool6 + "], isSOExist[" + bool3 + "], isLibPagSOExist[" + bool1 + "]");
      if ("pendant".equals(paramString))
      {
        localObject = new QavListItemBase.ItemInfo();
        ((QavListItemBase.ItemInfo)localObject).jdField_a_of_type_JavaLangString = "0";
        ((QavListItemBase.ItemInfo)localObject).jdField_b_of_type_JavaLangString = String.valueOf(2130842368);
        if (bool5) {
          break label409;
        }
        bool2 = true;
        label216:
        ((QavListItemBase.ItemInfo)localObject).jdField_c_of_type_Boolean = bool2;
        ((QavListItemBase.ItemInfo)localObject).d = this.mApp.getApp().getString(2131695425);
        localArrayList.add(localObject);
      }
      if ("creativecop".equals(paramString))
      {
        localObject = new QavListItemBase.ItemInfo();
        ((QavListItemBase.ItemInfo)localObject).jdField_a_of_type_JavaLangString = "0";
        ((QavListItemBase.ItemInfo)localObject).jdField_b_of_type_JavaLangString = String.valueOf(2130842368);
        if (bool5) {
          break label414;
        }
        bool2 = true;
        label289:
        ((QavListItemBase.ItemInfo)localObject).jdField_c_of_type_Boolean = bool2;
        ((QavListItemBase.ItemInfo)localObject).d = this.mApp.getApp().getString(2131695425);
        localArrayList.add(localObject);
      }
      if (!"creativecop".equals(paramString)) {
        break label424;
      }
      paramString = this.mFaceManager.a(paramString);
      if ((paramString == null) || (paramString.size() == 0)) {
        break label515;
      }
      paramString = paramString.iterator();
      label358:
      if (!paramString.hasNext()) {
        break label515;
      }
      localObject = (FaceItem)paramString.next();
      if ((!bool6) || (!bool1)) {
        break label419;
      }
    }
    label409:
    label414:
    label419:
    for (boolean bool2 = true;; bool2 = false)
    {
      localArrayList.add(getListItemFromInteractiveFilterItemInfo((FaceItem)localObject, bool2));
      break label358;
      bool1 = false;
      break;
      bool2 = false;
      break label216;
      bool2 = false;
      break label289;
    }
    label424:
    paramString = this.mFaceManager.a(paramString);
    if ((paramString != null) && (paramString.size() != 0))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject = (FaceItem)paramString.next();
        if (((FaceItem)localObject).isShow())
        {
          if ((bool5) && (bool3)) {}
          for (bool1 = true;; bool1 = false)
          {
            localArrayList.add(getListItemInfoFromEmotionInfo((FaceItem)localObject, bool4, bool1));
            break;
          }
        }
      }
    }
    label515:
    return localArrayList;
  }
  
  static QavListItemBase.ItemInfo getListItemFromInteractiveFilterItemInfo(FaceItem paramFaceItem, boolean paramBoolean)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.jdField_a_of_type_Int = 3;
    localItemInfo.jdField_a_of_type_JavaLangString = paramFaceItem.getId();
    localItemInfo.jdField_c_of_type_JavaLangString = paramFaceItem.getText();
    localItemInfo.jdField_b_of_type_JavaLangString = paramFaceItem.getIconurl();
    localItemInfo.jdField_b_of_type_Int = paramFaceItem.getVipLevel();
    localItemInfo.d = paramFaceItem.getDesc();
    if (!paramBoolean)
    {
      paramBoolean = true;
      localItemInfo.jdField_c_of_type_Boolean = paramBoolean;
      if (!localItemInfo.jdField_c_of_type_Boolean) {
        break label88;
      }
    }
    label88:
    for (localItemInfo.jdField_a_of_type_Boolean = true;; localItemInfo.jdField_a_of_type_Boolean = paramFaceItem.isUsable())
    {
      localItemInfo.jdField_a_of_type_JavaLangObject = paramFaceItem;
      return localItemInfo;
      paramBoolean = false;
      break;
    }
  }
  
  static QavListItemBase.ItemInfo getListItemInfoFromEmotionInfo(FaceItem paramFaceItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.jdField_a_of_type_Int = 1;
    localItemInfo.jdField_a_of_type_JavaLangString = paramFaceItem.getId();
    localItemInfo.jdField_c_of_type_JavaLangString = paramFaceItem.getText();
    localItemInfo.jdField_b_of_type_JavaLangString = paramFaceItem.getIconurl();
    localItemInfo.jdField_b_of_type_Int = paramFaceItem.getVipLevel();
    localItemInfo.d = paramFaceItem.getDesc();
    if ((!paramBoolean1) || ((!paramBoolean2) && (paramFaceItem.isInteract())))
    {
      paramBoolean1 = true;
      localItemInfo.jdField_c_of_type_Boolean = paramBoolean1;
      if (!localItemInfo.jdField_c_of_type_Boolean) {
        break label99;
      }
    }
    label99:
    for (localItemInfo.jdField_a_of_type_Boolean = true;; localItemInfo.jdField_a_of_type_Boolean = paramFaceItem.isUsable())
    {
      localItemInfo.jdField_a_of_type_JavaLangObject = paramFaceItem;
      return localItemInfo;
      paramBoolean1 = false;
      break;
    }
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
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramVideoController != null)
    {
      bool1 = bool2;
      if (!paramVideoController.a().k)
      {
        unbaleInfo = paramVideoController.a().getString(2131695448);
        bool1 = false;
      }
    }
    return bool1;
  }
  
  boolean checkDimmStatus(QavListItemBase.ItemInfo paramItemInfo)
  {
    int j = 2131695471;
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    boolean bool3;
    int i;
    label99:
    int k;
    if (paramItemInfo.jdField_c_of_type_Boolean)
    {
      EffectsRenderController.g();
      AEKitAbilityInfo.a(this.mApp);
      localObject = (FaceItem)this.mFaceManager.a(paramItemInfo.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        break label567;
      }
      bool3 = ((FaceItem)localObject).isInCreative();
      if (!bool3) {
        break label313;
      }
      bool1 = this.mSupportManager.a(3, "creative");
      if ((!AEKitAbilityInfo.b()) || (!PtuResChecker.a().a())) {
        break label295;
      }
      i = 1;
      if (bool1) {
        break label300;
      }
      i = 0;
      k = j;
      if (i != 0)
      {
        k = j;
        if ((paramItemInfo.jdField_a_of_type_JavaLangObject instanceof FaceItem))
        {
          localObject = (FaceItem)paramItemInfo.jdField_a_of_type_JavaLangObject;
          bool1 = PtuResChecker.a().a();
          if ((!AEKitAbilityInfo.b()) || (!PtuResChecker.a().a())) {
            break label397;
          }
          i = 1;
          label153:
          if (!bool3) {
            break label408;
          }
          if ((this.mSupportManager.a(3, "creative")) && (i != 0)) {
            break label402;
          }
          bool1 = true;
          label178:
          paramItemInfo.jdField_c_of_type_Boolean = bool1;
          k = j;
        }
      }
    }
    for (;;)
    {
      if ((!paramItemInfo.jdField_c_of_type_Boolean) && ((paramItemInfo.jdField_a_of_type_JavaLangObject instanceof FaceItem)))
      {
        localObject = (FaceItem)paramItemInfo.jdField_a_of_type_JavaLangObject;
        paramItemInfo.jdField_a_of_type_Boolean = ((FaceItem)localObject).isUsable();
        if (!((FaceItem)localObject).isSameType("face")) {
          break label476;
        }
        if (this.mAdapterFace != null) {
          this.mAdapterFace.notifyDataSetChanged();
        }
      }
      for (;;)
      {
        paramItemInfo = (AVActivity)this.mActivity.get();
        if ((k != 0) && (paramItemInfo != null)) {
          TipsUtil.a(this.mApp, 1010, k);
        }
        bool1 = bool2;
        if (k != 0) {
          bool1 = true;
        }
        return bool1;
        label295:
        i = 0;
        break;
        label300:
        if (i == 0) {
          break label558;
        }
        j = 2131695783;
        i = 1;
        break label99;
        label313:
        if (((FaceItem)localObject).isInteract()) {}
        for (localObject = "interact";; localObject = "normal")
        {
          if (this.mSupportManager.a(3, (String)localObject)) {
            break label350;
          }
          i = 0;
          break;
        }
        label350:
        i = this.mSupportManager.a(3, (String)localObject);
        if (i == -1)
        {
          i = 0;
          j = 2131695469;
          break label99;
        }
        if (i == 0)
        {
          i = 0;
          j = 2131695469;
          break label99;
        }
        j = 2131695783;
        i = 1;
        break label99;
        label397:
        i = 0;
        break label153;
        label402:
        bool1 = false;
        break label178;
        label408:
        bool3 = this.mSupportManager.a(3, "normal");
        boolean bool4 = this.mSupportManager.a(3, "interact");
        if ((!bool3) || (((!bool4) || (!bool1)) && (((FaceItem)localObject).isInteract()))) {}
        for (bool1 = true;; bool1 = false)
        {
          paramItemInfo.jdField_c_of_type_Boolean = bool1;
          k = j;
          break;
        }
        label476:
        if (((FaceItem)localObject).isSameType("pendant"))
        {
          if (this.mAdapterPendant != null) {
            this.mAdapterPendant.notifyDataSetChanged();
          }
        }
        else if (((FaceItem)localObject).isSameType("voicesticker"))
        {
          if (this.mAdapterVoiceSticker != null) {
            this.mAdapterVoiceSticker.notifyDataSetChanged();
          }
        }
        else if ((((FaceItem)localObject).isSameType("creativecop")) && (this.mAdapterInteractiveVideo != null)) {
          this.mAdapterInteractiveVideo.notifyDataSetChanged();
        }
      }
      label558:
      j = 2131695783;
      i = 0;
      break label99;
      label567:
      k = 0;
    }
  }
  
  public void chooseTab(int paramInt)
  {
    if (this.mListView == null) {
      return;
    }
    Object localObject;
    int i;
    label125:
    boolean bool;
    if (this.mSelectTab != paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(TAG, 1, "chooseTab, tab[" + this.mSelectTab + "->" + paramInt + "]");
      }
      if ((this.mFaceManager != null) && (this.mSelectTab == 4)) {
        this.mFaceManager.a("chooseTab", null);
      }
      localObject = this.linePendant;
      if (paramInt != 2) {
        break label360;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.lineFace;
      if (paramInt != 1) {
        break label365;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.lineVoiceSticker;
      if (paramInt != 3) {
        break label370;
      }
      i = 0;
      label144:
      ((View)localObject).setVisibility(i);
      localObject = this.lineInteractiveVideo;
      if ((paramInt != 4) || (!AEKitAbilityInfo.b())) {
        break label375;
      }
      i = 0;
      label169:
      ((View)localObject).setVisibility(i);
      localObject = this.btnPendant;
      if (paramInt != 2) {
        break label380;
      }
      bool = true;
      label188:
      ((FrameLayout)localObject).setSelected(bool);
      localObject = this.btnFace;
      if (paramInt != 1) {
        break label385;
      }
      bool = true;
      label207:
      ((FrameLayout)localObject).setSelected(bool);
      localObject = this.btnVoiceSticker;
      if (paramInt != 3) {
        break label390;
      }
      bool = true;
      label226:
      ((FrameLayout)localObject).setSelected(bool);
      localObject = this.btnInteractiveVideo;
      if (paramInt != 4) {
        break label395;
      }
      bool = true;
      label245:
      ((FrameLayout)localObject).setSelected(bool);
      localObject = this.mApp.a().a(this.mApp.a().a().d) + "";
      if (paramInt != 2) {
        break label400;
      }
      this.mListView.setAdapter(this.mAdapterPendant);
      this.mAdapterPendant.notifyDataSetChanged();
      MagicDataReport.b((String)localObject);
    }
    for (;;)
    {
      this.mSelectTab = paramInt;
      setToolbarBK(false);
      this.mApp.a().postDelayed(new FaceToolbar.2(this), 1000L);
      setLastSelectedIndex();
      return;
      label360:
      i = 4;
      break;
      label365:
      i = 4;
      break label125;
      label370:
      i = 4;
      break label144;
      label375:
      i = 4;
      break label169;
      label380:
      bool = false;
      break label188;
      label385:
      bool = false;
      break label207;
      label390:
      bool = false;
      break label226;
      label395:
      bool = false;
      break label245;
      label400:
      if (paramInt == 1)
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
      else if (paramInt == 4)
      {
        this.mListView.setAdapter(this.mAdapterInteractiveVideo);
        this.mAdapterInteractiveVideo.notifyDataSetChanged();
        ReportController.b(null, "CliOper", "", "", "0X800A74B", "0X800A74B", 0, 0, "", "", "", "");
      }
    }
  }
  
  void enterDoubleScreen()
  {
    MagicDataReport.a(this.mApp.a().a(this.mApp.a().a().d) + "");
    this.mApp.a().a(4, "1");
    ((AVActivity)this.mActivity.get()).a(2, false);
  }
  
  void enterOriginScreen()
  {
    ((AVActivity)this.mActivity.get()).h(false);
  }
  
  void fixDimmed(int paramInt)
  {
    if (this.mSupportManager == null) {}
    label312:
    do
    {
      boolean bool2;
      boolean bool3;
      QavListItemBase.ItemInfo localItemInfo;
      boolean bool1;
      do
      {
        do
        {
          do
          {
            boolean bool4;
            do
            {
              return;
              if (paramInt != 0) {
                break;
              }
              bool2 = PtuResChecker.a().a();
              bool3 = this.mSupportManager.a(3, "normal");
              bool4 = this.mSupportManager.a(3, "interact");
              if (QLog.isDevelopLevel()) {
                QLog.w(TAG, 1, "fixDimmed, supportNormal[" + bool3 + "], supportInteract[" + bool4 + "], isSOExist[" + bool2 + "]");
              }
            } while (this.mPeandantTmpList == null);
            localIterator = this.mPeandantTmpList.iterator();
            while (localIterator.hasNext())
            {
              localItemInfo = (QavListItemBase.ItemInfo)localIterator.next();
              if ((localItemInfo.jdField_a_of_type_JavaLangObject instanceof FaceItem))
              {
                FaceItem localFaceItem = (FaceItem)localItemInfo.jdField_a_of_type_JavaLangObject;
                if ((!bool3) || (((!bool4) || (!bool2)) && (localFaceItem.isInteract()))) {}
                for (bool1 = true;; bool1 = false)
                {
                  localItemInfo.jdField_c_of_type_Boolean = bool1;
                  break;
                }
              }
            }
          } while (this.mAdapterPendant == null);
          this.mAdapterPendant.notifyDataSetChanged();
          return;
        } while (paramInt != 1);
        if ((!AEKitAbilityInfo.b()) || (!PtuResChecker.a().a())) {
          break;
        }
        bool1 = true;
        bool3 = this.mSupportManager.a(3, "creative");
        if (QLog.isDevelopLevel()) {
          QLog.w(TAG, 1, "fixDimmed, ] supportCreative[" + bool3 + "], isSoReady[" + bool1 + "]");
        }
      } while (this.mInteractiveVideoTmpList == null);
      Iterator localIterator = this.mInteractiveVideoTmpList.iterator();
      if (localIterator.hasNext())
      {
        localItemInfo = (QavListItemBase.ItemInfo)localIterator.next();
        if ((!bool3) || (!bool1)) {}
        for (bool2 = true;; bool2 = false)
        {
          localItemInfo.jdField_c_of_type_Boolean = bool2;
          break label312;
          bool1 = false;
          break;
        }
      }
    } while (this.mAdapterInteractiveVideo == null);
    this.mAdapterInteractiveVideo.notifyDataSetChanged();
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      this.mUIInfo.d = 2;
      this.mUIInfo.g = 2131559899;
      this.mUIInfo.f = 2130842166;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131695902);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    return getUnbaleInfo(this.mApp.a());
  }
  
  public boolean isEffectBtnEnable()
  {
    return isEnable(this.mApp.a());
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AVLog.printColorLog(TAG, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.mApp.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.b();
    EffectSettingUi.a(this.mApp, l);
    if ((paramView.getId() == 2131364076) || (paramView.getId() == 2131364002))
    {
      enterDoubleScreen();
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      enterOriginScreen();
      break;
      chooseTab(2);
      continue;
      chooseTab(1);
      continue;
      chooseTab(3);
      continue;
      chooseTab(4);
      if (this.mRedTouchInteractiveVideo != null)
      {
        AVRedTouchUtil.a(this.mApp, this.mRedTouchInteractiveVideo, 5);
        this.mRedTouchInteractiveVideo = null;
      }
    }
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    QLog.w(TAG, 1, "TAG, onCreate, seq[" + paramLong + "]");
    this.mFaceManager = ((EffectFaceManager)this.mApp.a(3));
    this.mSupportManager = ((EffectSupportManager)this.mApp.a(5));
    this.mSelectTab = 0;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131368580));
    this.mListView.setStayDisplayOffsetZero(true);
    this.linePendant = this.toolbarView.findViewById(2131370402);
    this.lineFace = this.toolbarView.findViewById(2131370392);
    this.lineVoiceSticker = this.toolbarView.findViewById(2131370415);
    this.lineInteractiveVideo = this.toolbarView.findViewById(2131370398);
    this.btnPendant = ((FrameLayout)this.toolbarView.findViewById(2131364076));
    this.btnFace = ((FrameLayout)this.toolbarView.findViewById(2131364002));
    this.btnVoiceSticker = ((FrameLayout)this.toolbarView.findViewById(2131364187));
    this.btnInteractiveVideo = ((FrameLayout)this.toolbarView.findViewById(2131364032));
    boolean bool1 = EffectsRenderController.b();
    boolean bool2 = AEKitAbilityInfo.b();
    if (!bool1) {
      this.btnPendant.setVisibility(8);
    }
    if ((!bool1) || (!bool2)) {
      this.btnInteractiveVideo.setVisibility(8);
    }
    if (QavABTestUtils.d()) {
      this.btnInteractiveVideo.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onCreate, isAEModuleEnable[" + bool1 + "], isCCropEnable[" + bool2 + "]");
    }
    this.btnPendant.setOnClickListener(this);
    this.btnFace.setOnClickListener(this);
    this.btnVoiceSticker.setOnClickListener(this);
    this.btnInteractiveVideo.setOnClickListener(this);
    Object localObject;
    if (this.mRedTouchInteractiveVideo == null)
    {
      localObject = this.toolbarView.findViewById(2131370398);
      this.mRedTouchInteractiveVideo = AVRedTouchUtil.a(this.mApp, (View)localObject, 5);
    }
    this.mFaceTmpList = getList("face");
    this.mPeandantTmpList = getList("pendant");
    this.mVoiceStickerTmpList = getList("voicesticker");
    if (bool2)
    {
      localObject = getList("creativecop");
      this.mInteractiveVideoTmpList = ((ArrayList)localObject);
      this.mAdapterFace = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mFaceTmpList, this.mListView);
      this.mAdapterFace.a(this.mFaceClickCallback);
      this.mAdapterFace.a(this);
      this.mAdapterFace.a(false);
      this.mAdapterFace.b(false);
      this.mAdapterPendant = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mPeandantTmpList, this.mListView);
      this.mAdapterPendant.a(this.mFaceClickCallback);
      this.mAdapterPendant.a(this);
      this.mAdapterPendant.a(true);
      this.mAdapterPendant.b(true);
      this.mAdapterVoiceSticker = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mVoiceStickerTmpList, this.mListView);
      this.mAdapterVoiceSticker.a(this.mFaceClickCallback);
      this.mAdapterVoiceSticker.a(this);
      this.mAdapterVoiceSticker.a(false);
      this.mAdapterVoiceSticker.b(false);
      this.mAdapterInteractiveVideo = new QAVPtvTemplateAdapter(this.mApp, paramAVActivity, this.mInteractiveVideoTmpList, this.mListView);
      this.mAdapterInteractiveVideo.a(this.mFaceClickCallback);
      this.mAdapterInteractiveVideo.a(this);
      this.mAdapterInteractiveVideo.a(true);
      this.mAdapterInteractiveVideo.b(true);
      paramAVActivity = (FaceItem)this.mFaceManager.a();
      if (paramAVActivity == null) {
        break label803;
      }
      if (!paramAVActivity.isSameType("creativecop")) {
        break label778;
      }
      chooseTab(4);
      label705:
      bool1 = PtuResChecker.a().a();
      if ((!AEKitAbilityInfo.b()) || (!PtuResChecker.a().a())) {
        break label839;
      }
    }
    label778:
    label803:
    label839:
    for (int i = 1;; i = 0)
    {
      if ((!bool1) || (i == 0))
      {
        if (this.mControlUIObs == null) {
          this.mControlUIObs = new FaceToolbar.1(this);
        }
        this.mApp.a(this.mControlUIObs);
      }
      return;
      localObject = null;
      break;
      if (paramAVActivity.isSameType("pendant"))
      {
        chooseTab(2);
        break label705;
      }
      chooseTab(1);
      break label705;
      if (this.mVoiceStickerTmpList.size() > 1)
      {
        chooseTab(3);
        break label705;
      }
      this.btnVoiceSticker.setVisibility(8);
      chooseTab(1);
      break label705;
    }
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    if (this.mControlUIObs != null)
    {
      paramVideoAppInterface.b(this.mControlUIObs);
      this.mControlUIObs = null;
    }
    this.mFaceManager.b(paramLong, this);
    this.mListView = null;
    this.mAdapterFace = null;
    this.mAdapterPendant = null;
    this.mAdapterVoiceSticker = null;
    QavListItemBase.ItemInfo localItemInfo;
    if (this.mFaceTmpList != null)
    {
      paramVideoAppInterface = this.mFaceTmpList.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        localItemInfo = (QavListItemBase.ItemInfo)paramVideoAppInterface.next();
        if ((!"0".equals(localItemInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localItemInfo.jdField_b_of_type_JavaLangString))) {
          URLDrawable.removeMemoryCacheByUrl(localItemInfo.jdField_b_of_type_JavaLangString);
        }
      }
    }
    this.mFaceTmpList = null;
    if (this.mPeandantTmpList != null)
    {
      paramVideoAppInterface = this.mPeandantTmpList.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        localItemInfo = (QavListItemBase.ItemInfo)paramVideoAppInterface.next();
        if ((!"0".equals(localItemInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localItemInfo.jdField_b_of_type_JavaLangString))) {
          URLDrawable.removeMemoryCacheByUrl(localItemInfo.jdField_b_of_type_JavaLangString);
        }
      }
    }
    this.mPeandantTmpList = null;
    if (this.mVoiceStickerTmpList != null)
    {
      paramVideoAppInterface = this.mVoiceStickerTmpList.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        localItemInfo = (QavListItemBase.ItemInfo)paramVideoAppInterface.next();
        if ((!"0".equals(localItemInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localItemInfo.jdField_b_of_type_JavaLangString))) {
          URLDrawable.removeMemoryCacheByUrl(localItemInfo.jdField_b_of_type_JavaLangString);
        }
      }
    }
    this.mVoiceStickerTmpList = null;
    if (this.mInteractiveVideoTmpList != null)
    {
      paramVideoAppInterface = this.mInteractiveVideoTmpList.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        localItemInfo = (QavListItemBase.ItemInfo)paramVideoAppInterface.next();
        if ((!"0".equals(localItemInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localItemInfo.jdField_b_of_type_JavaLangString))) {
          URLDrawable.removeMemoryCacheByUrl(localItemInfo.jdField_b_of_type_JavaLangString);
        }
      }
    }
    this.mInteractiveVideoTmpList = null;
  }
  
  public void onDownloadFinish(long paramLong, FaceItem paramFaceItem, boolean paramBoolean)
  {
    if (paramFaceItem == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramFaceItem.isSameType("face")) {
              break;
            }
          } while (this.mAdapterFace == null);
          this.mAdapterFace.a(paramLong, paramFaceItem.getId(), paramBoolean);
          return;
          if (!paramFaceItem.isSameType("pendant")) {
            break;
          }
        } while (this.mAdapterPendant == null);
        this.mAdapterPendant.a(paramLong, paramFaceItem.getId(), paramBoolean);
        return;
        if (!paramFaceItem.isSameType("voicesticker")) {
          break;
        }
      } while (this.mAdapterVoiceSticker == null);
      this.mAdapterVoiceSticker.a(paramLong, paramFaceItem.getId(), paramBoolean);
      return;
    } while ((!paramFaceItem.isSameType("creativecop")) || (this.mAdapterInteractiveVideo == null));
    this.mAdapterInteractiveVideo.a(paramLong, paramFaceItem.getId(), paramBoolean);
  }
  
  protected void onHide(long paramLong)
  {
    this.mFaceManager.b(paramLong, this);
    setToolbarBK(true);
    if (this.mSelectTab == 4) {
      this.mFaceManager.a("onHide", null);
    }
  }
  
  public void onItemSelectedChanged(long paramLong, FaceItem paramFaceItem)
  {
    QLog.w(TAG, 1, "onItemSelectedChanged, seq[" + paramLong + "], current[" + paramFaceItem + "], mSelectTab[" + this.mSelectTab + "]");
    if ((this.mSelectTab != 4) && (paramFaceItem != null) && ("creativecop".equals(paramFaceItem.getType())))
    {
      chooseTab(4);
      return;
    }
    EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.mApp.a(8);
    if ((localEffectOperateManager != null) && (localEffectOperateManager.a()) && (paramFaceItem != null))
    {
      AVLog.printColorLog(TAG, "onItemSelectedChanged type: " + paramFaceItem.getType() + ", id: " + paramFaceItem.getId());
      paramFaceItem = paramFaceItem.getType();
      if ("pendant".equals(paramFaceItem)) {
        chooseTab(2);
      }
      for (;;)
      {
        localEffectOperateManager.c(false);
        return;
        if ("face".equals(paramFaceItem)) {
          chooseTab(1);
        } else if ("voicesticker".equals(paramFaceItem)) {
          chooseTab(3);
        } else if ("creativecop".equals(paramFaceItem)) {
          chooseTab(4);
        }
      }
    }
    setLastSelectedIndex();
  }
  
  public void onProgressUpdate(FaceItem paramFaceItem, int paramInt)
  {
    if (paramFaceItem.isSameType("face")) {
      if (this.mAdapterFace != null) {
        this.mAdapterFace.a(paramFaceItem.getId(), paramInt);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!paramFaceItem.isSameType("pendant")) {
            break;
          }
        } while (this.mAdapterPendant == null);
        this.mAdapterPendant.a(paramFaceItem.getId(), paramInt);
        return;
        if (!paramFaceItem.isSameType("voicesticker")) {
          break;
        }
      } while (this.mAdapterVoiceSticker == null);
      this.mAdapterVoiceSticker.a(paramFaceItem.getId(), paramInt);
      return;
    } while ((!paramFaceItem.isSameType("creativecop")) || (this.mAdapterInteractiveVideo == null));
    this.mAdapterInteractiveVideo.a(paramFaceItem.getId(), paramInt);
  }
  
  protected void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    setLastSelectedIndex();
    this.mFaceManager.a(paramLong, this);
    if (((AVActivity)this.mActivity.get()).d()) {
      if (this.mSelectTab == 3)
      {
        QLog.w(TAG, 1, "onShow, 重新选择tab");
        chooseTab(1);
      }
    }
    for (;;)
    {
      setToolbarBK(false);
      return;
      if ((this.mSelectTab == 1) || (this.mSelectTab == 2)) {
        enterDoubleScreen();
      }
    }
  }
  
  void setLastSelectedIndex()
  {
    if (this.mFaceManager == null) {}
    while ((this.mSelectTab != 2) && (this.mSelectTab != 4)) {
      return;
    }
    FaceItem localFaceItem = (FaceItem)this.mFaceManager.a();
    String str;
    int i;
    if (localFaceItem == null)
    {
      str = "0";
      AVLog.printColorLog(TAG, "setLastSelectedIndex:" + str);
      if (this.mSelectTab != 2) {
        break label133;
      }
      i = 1;
      label80:
      if ((localFaceItem != null) && ((localFaceItem == null) || (!localFaceItem.isSameType("creativecop")))) {
        break label138;
      }
    }
    label133:
    label138:
    for (int j = 1;; j = 0)
    {
      if (i == 0) {
        break label143;
      }
      EffectToolbar.setLastSelectedIndex(str, this.mPeandantTmpList, this.mAdapterPendant, this.mListView);
      return;
      str = localFaceItem.getId();
      break;
      i = 0;
      break label80;
    }
    label143:
    if (j != 0) {}
    for (;;)
    {
      EffectToolbar.setLastSelectedIndex(str, this.mInteractiveVideoTmpList, this.mAdapterInteractiveVideo, this.mListView);
      return;
      str = "0";
    }
  }
  
  void setToolbarBK(boolean paramBoolean)
  {
    AVActivity localAVActivity = (AVActivity)this.mActivity.get();
    if ((localAVActivity != null) && (localAVActivity.a != null) && (localAVActivity.a.a() != null))
    {
      if ((paramBoolean) || (this.mSelectTab == 1) || (this.mSelectTab == 2)) {
        localAVActivity.a.a().a(Boolean.valueOf(true), 0, 0);
      }
    }
    else {
      return;
    }
    localAVActivity.a.a().a(Boolean.valueOf(false), 0, 2130842353);
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (FaceItem)this.mFaceManager.a(paramItemInfo.jdField_a_of_type_JavaLangString);
    if (paramAppInterface != null)
    {
      this.mFaceManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w(TAG, 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    paramIDownloadCallback.a(paramLong, paramItemInfo.jdField_a_of_type_JavaLangString, false);
  }
  
  public void update(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
    {
      this.mFaceTmpList = getList("face");
      this.mPeandantTmpList = getList("pendant");
      this.mVoiceStickerTmpList = getList("voicesticker");
      this.mInteractiveVideoTmpList = getList("creativecop");
      this.mAdapterFace.a(this.mFaceTmpList);
      this.mAdapterPendant.a(this.mPeandantTmpList);
      this.mAdapterVoiceSticker.a(this.mVoiceStickerTmpList);
      this.mAdapterInteractiveVideo.a(this.mInteractiveVideoTmpList);
      if (this.mSelectTab != 0) {
        break label230;
      }
    }
    label230:
    for (int i = 3;; i = this.mSelectTab)
    {
      chooseTab(i);
      return;
      if (paramArrayOfObject.length != 2) {
        break;
      }
      String str = (String)paramArrayOfObject[0];
      i = ((Integer)paramArrayOfObject[1]).intValue();
      paramArrayOfObject = (FaceItem)this.mFaceManager.a(str);
      if (paramArrayOfObject == null) {
        break;
      }
      if (paramArrayOfObject.isSameType("face"))
      {
        this.mAdapterFace.c(str, i);
        break;
      }
      if (paramArrayOfObject.isSameType("pendant"))
      {
        this.mAdapterPendant.c(str, i);
        break;
      }
      if (paramArrayOfObject.isSameType("voicesticker"))
      {
        this.mAdapterVoiceSticker.c(str, i);
        break;
      }
      if (!paramArrayOfObject.isSameType("creativecop")) {
        break;
      }
      this.mAdapterInteractiveVideo.c(str, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.FaceToolbar
 * JD-Core Version:    0.7.0.1
 */