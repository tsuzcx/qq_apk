package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import awqx;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import krx;
import kvq;
import kxa;
import kxi;
import kxl;
import kyo;
import kys;
import ley;
import lfi;
import lqb;
import lrg;
import lsv;
import lsw;
import lwf;
import lwk;
import lwl;
import lxe;
import lxf;
import mqq.app.MobileQQ;

public class FaceToolbar
  extends BaseToolbar
  implements View.OnClickListener, kxa<FaceItem>, lwl
{
  public static String TAG = "FaceToolbar";
  static String unbaleInfo;
  FrameLayout btnFace;
  FrameLayout btnInteractiveVideo;
  FrameLayout btnPendant;
  FrameLayout btnVoiceSticker;
  View lineFace;
  View lineInteractiveVideo;
  View linePendant;
  View lineVoiceSticker;
  BroadcastReceiver mActionReceiver = null;
  lwf mAdapterFace;
  lwf mAdapterInteractiveVideo;
  lwf mAdapterPendant;
  lwf mAdapterVoiceSticker;
  lwk mFaceClickCallback = new lsw(this);
  public kxi mFaceManager;
  ArrayList<lxf> mFaceTmpList;
  ArrayList<lxf> mInteractiveVideoTmpList;
  HorizontalListView mListView;
  ArrayList<lxf> mPeandantTmpList;
  private RedTouch mRedTouchInteractiveVideo;
  int mSelectTab = 0;
  kyo mSupportManager;
  lrg mUIInfo = null;
  ArrayList<lxf> mVoiceStickerTmpList;
  
  public FaceToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList<lxf> getList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new lxf();
    ((lxf)localObject1).jdField_a_of_type_JavaLangString = "-1";
    localArrayList.add(0, localObject1);
    boolean bool3 = kys.b();
    boolean bool1;
    boolean bool4;
    boolean bool5;
    if ((ley.b()) && (ley.a(this.mApp)))
    {
      bool1 = true;
      bool4 = this.mSupportManager.a(3, "normal");
      bool5 = this.mSupportManager.a(3, "interact");
      boolean bool6 = this.mSupportManager.a(3, "creative");
      QLog.w(TAG, 1, "getList, type[" + paramString + "], supportNormal[" + bool4 + "], supportInteract[" + bool5 + "], supportCreative[" + bool6 + "], isSOExist[" + bool3 + "], isLibPagSOExist[" + bool1 + "]");
      if ("pendant".equals(paramString))
      {
        localObject1 = new lxf();
        ((lxf)localObject1).jdField_a_of_type_JavaLangString = "0";
        ((lxf)localObject1).jdField_b_of_type_JavaLangString = String.valueOf(2130841594);
        if (bool5) {
          break label407;
        }
        bool2 = true;
        label214:
        ((lxf)localObject1).jdField_c_of_type_Boolean = bool2;
        ((lxf)localObject1).d = this.mApp.getApp().getString(2131630058);
        localArrayList.add(localObject1);
      }
      if ("creativecop".equals(paramString))
      {
        localObject1 = new lxf();
        ((lxf)localObject1).jdField_a_of_type_JavaLangString = "0";
        ((lxf)localObject1).jdField_b_of_type_JavaLangString = String.valueOf(2130841594);
        if (bool5) {
          break label412;
        }
        bool2 = true;
        label287:
        ((lxf)localObject1).jdField_c_of_type_Boolean = bool2;
        ((lxf)localObject1).d = this.mApp.getApp().getString(2131630058);
        localArrayList.add(localObject1);
      }
      if (!"creativecop".equals(paramString)) {
        break label422;
      }
      paramString = this.mFaceManager.a(paramString);
      if ((paramString == null) || (paramString.size() == 0)) {
        break label574;
      }
      paramString = paramString.iterator();
      label356:
      if (!paramString.hasNext()) {
        break label574;
      }
      localObject1 = (FaceItem)paramString.next();
      if ((!bool6) || (!bool1)) {
        break label417;
      }
    }
    label407:
    label412:
    label417:
    for (boolean bool2 = true;; bool2 = false)
    {
      localArrayList.add(getListItemFromInteractiveFilterItemInfo((FaceItem)localObject1, bool2));
      break label356;
      bool1 = false;
      break;
      bool2 = false;
      break label214;
      bool2 = false;
      break label287;
    }
    label422:
    localObject1 = this.mFaceManager.a(paramString);
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (FaceItem)((Iterator)localObject1).next();
        if (((FaceItem)localObject2).isShow())
        {
          if ((bool5) && (bool3)) {}
          for (bool1 = true;; bool1 = false)
          {
            localObject2 = getListItemInfoFromEmotionInfo((FaceItem)localObject2, bool4, bool1);
            if (("pendant".equals(paramString)) && (!checkPeerFaceSupport()) && (((lxf)localObject2).jdField_a_of_type_JavaLangString.equals("huanlian")) && (bool5) && (bool4) && (bool3)) {
              ((lxf)localObject2).jdField_c_of_type_Boolean = true;
            }
            localArrayList.add(localObject2);
            break;
          }
        }
      }
    }
    label574:
    return localArrayList;
  }
  
  static lxf getListItemFromInteractiveFilterItemInfo(FaceItem paramFaceItem, boolean paramBoolean)
  {
    lxf locallxf = new lxf();
    locallxf.jdField_a_of_type_Int = 3;
    locallxf.jdField_a_of_type_JavaLangString = paramFaceItem.getId();
    locallxf.jdField_c_of_type_JavaLangString = paramFaceItem.getText();
    locallxf.jdField_b_of_type_JavaLangString = paramFaceItem.getIconurl();
    locallxf.jdField_b_of_type_Int = paramFaceItem.getVipLevel();
    locallxf.d = paramFaceItem.getDesc();
    if (!paramBoolean)
    {
      paramBoolean = true;
      locallxf.jdField_c_of_type_Boolean = paramBoolean;
      if (!locallxf.jdField_c_of_type_Boolean) {
        break label88;
      }
    }
    label88:
    for (locallxf.jdField_a_of_type_Boolean = true;; locallxf.jdField_a_of_type_Boolean = paramFaceItem.isUsable())
    {
      locallxf.jdField_a_of_type_JavaLangObject = paramFaceItem;
      return locallxf;
      paramBoolean = false;
      break;
    }
  }
  
  static lxf getListItemInfoFromEmotionInfo(FaceItem paramFaceItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    lxf locallxf = new lxf();
    locallxf.jdField_a_of_type_Int = 1;
    locallxf.jdField_a_of_type_JavaLangString = paramFaceItem.getId();
    locallxf.jdField_c_of_type_JavaLangString = paramFaceItem.getText();
    locallxf.jdField_b_of_type_JavaLangString = paramFaceItem.getIconurl();
    locallxf.jdField_b_of_type_Int = paramFaceItem.getVipLevel();
    locallxf.d = paramFaceItem.getDesc();
    if ((!paramBoolean1) || ((!paramBoolean2) && (paramFaceItem.isInteract())))
    {
      paramBoolean1 = true;
      locallxf.jdField_c_of_type_Boolean = paramBoolean1;
      if (!locallxf.jdField_c_of_type_Boolean) {
        break label99;
      }
    }
    label99:
    for (locallxf.jdField_a_of_type_Boolean = true;; locallxf.jdField_a_of_type_Boolean = paramFaceItem.isUsable())
    {
      locallxf.jdField_a_of_type_JavaLangObject = paramFaceItem;
      return locallxf;
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
        unbaleInfo = paramVideoController.a().getString(2131630081);
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean checkDimmStatus(lxf paramlxf)
  {
    int j = 2131630105;
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int k;
    if (paramlxf.jdField_c_of_type_Boolean)
    {
      lfi.e();
      ley.c(this.mApp);
      if (!"huanlian".equalsIgnoreCase(paramlxf.jdField_a_of_type_JavaLangString)) {
        break label216;
      }
      if (this.mSupportManager.a(3, "SUPPORT_SWITCH_FACE")) {
        break label171;
      }
      i = 2131630105;
      k = i;
    }
    for (;;)
    {
      if ((!paramlxf.jdField_c_of_type_Boolean) && ((paramlxf.jdField_a_of_type_JavaLangObject instanceof FaceItem)))
      {
        localObject = (FaceItem)paramlxf.jdField_a_of_type_JavaLangObject;
        paramlxf.jdField_a_of_type_Boolean = ((FaceItem)localObject).isUsable();
        if (!((FaceItem)localObject).isSameType("face")) {
          break label556;
        }
        if (this.mAdapterFace != null) {
          this.mAdapterFace.notifyDataSetChanged();
        }
      }
      label123:
      paramlxf = (AVActivity)this.mActivity.get();
      if ((k != 0) && (paramlxf != null)) {
        lqb.a(this.mApp, 1010, k);
      }
      bool1 = bool2;
      if (k != 0) {
        bool1 = true;
      }
      return bool1;
      label171:
      i = this.mSupportManager.a(3, "SUPPORT_SWITCH_FACE");
      if (i == -1)
      {
        i = 2131630102;
        break;
      }
      if (i == 0)
      {
        i = 2131630101;
        break;
      }
      paramlxf.jdField_c_of_type_Boolean = false;
      i = 0;
      break;
      label216:
      Object localObject = (FaceItem)this.mFaceManager.a(paramlxf.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        boolean bool3 = ((FaceItem)localObject).isInCreative();
        if (bool3)
        {
          bool1 = this.mSupportManager.a(3, "creative");
          if ((ley.b()) && (ley.a(this.mApp)))
          {
            i = 1;
            label279:
            if (bool1) {
              break label380;
            }
            i = 0;
          }
        }
        for (;;)
        {
          label286:
          k = j;
          if (i == 0) {
            break;
          }
          k = j;
          if (!(paramlxf.jdField_a_of_type_JavaLangObject instanceof FaceItem)) {
            break;
          }
          localObject = (FaceItem)paramlxf.jdField_a_of_type_JavaLangObject;
          bool1 = kys.b();
          if ((ley.b()) && (ley.a(this.mApp)))
          {
            i = 1;
            label338:
            if (!bool3) {
              break label488;
            }
            if ((this.mSupportManager.a(3, "creative")) && (i != 0)) {
              break label482;
            }
          }
          label430:
          label482:
          for (bool1 = true;; bool1 = false)
          {
            paramlxf.jdField_c_of_type_Boolean = bool1;
            k = j;
            break;
            i = 0;
            break label279;
            label380:
            j = 2131630398;
            if (i == 0) {
              break label638;
            }
            i = 1;
            break label286;
            if (((FaceItem)localObject).isInteract()) {}
            for (localObject = "interact";; localObject = "normal")
            {
              if (this.mSupportManager.a(3, (String)localObject)) {
                break label430;
              }
              i = 0;
              break;
            }
            i = this.mSupportManager.a(3, (String)localObject);
            if (i == -1)
            {
              j = 2131630102;
              i = 0;
              break label286;
            }
            if (i == 0)
            {
              j = 2131630100;
              i = 0;
              break label286;
            }
            j = 2131630398;
            i = 1;
            break label286;
            i = 0;
            break label338;
          }
          label488:
          bool3 = this.mSupportManager.a(3, "normal");
          boolean bool4 = this.mSupportManager.a(3, "interact");
          if ((!bool3) || (((!bool4) || (!bool1)) && (((FaceItem)localObject).isInteract()))) {}
          for (bool1 = true;; bool1 = false)
          {
            paramlxf.jdField_c_of_type_Boolean = bool1;
            k = j;
            break;
          }
          label556:
          if (((FaceItem)localObject).isSameType("pendant"))
          {
            if (this.mAdapterPendant == null) {
              break label123;
            }
            this.mAdapterPendant.notifyDataSetChanged();
            break label123;
          }
          if (((FaceItem)localObject).isSameType("voicesticker"))
          {
            if (this.mAdapterVoiceSticker == null) {
              break label123;
            }
            this.mAdapterVoiceSticker.notifyDataSetChanged();
            break label123;
          }
          if ((!((FaceItem)localObject).isSameType("creativecop")) || (this.mAdapterInteractiveVideo == null)) {
            break label123;
          }
          this.mAdapterInteractiveVideo.notifyDataSetChanged();
          break label123;
          label638:
          i = 0;
        }
      }
      k = 0;
    }
  }
  
  public boolean checkPeerFaceSupport()
  {
    boolean bool2 = false;
    int i;
    int j;
    label35:
    int k;
    if (this.mSupportManager.a(3, "normal") == 1)
    {
      i = 1;
      if (this.mSupportManager.a(3, "interact") != 1) {
        break label113;
      }
      j = 1;
      if (this.mSupportManager.a(3, "SUPPORT_SWITCH_FACE") != 1) {
        break label118;
      }
      k = 1;
      label52:
      if ((i == 0) || (j == 0)) {
        break label123;
      }
    }
    label113:
    label118:
    label123:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        break label129;
      }
      VideoController localVideoController = this.mApp.a();
      if (localVideoController.b(localVideoController.a().d) != 2)
      {
        bool1 = bool2;
        if (k == 0) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
      j = 0;
      break label35;
      k = 0;
      break label52;
    }
    label129:
    return bool1;
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
      if ((paramInt != 4) || (!ley.b())) {
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
      kxl.b((String)localObject);
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
        kxl.c((String)localObject);
      }
      else if (paramInt == 3)
      {
        this.mListView.setAdapter(this.mAdapterVoiceSticker);
        this.mAdapterVoiceSticker.notifyDataSetChanged();
        kxl.d((String)localObject);
      }
      else if (paramInt == 4)
      {
        this.mListView.setAdapter(this.mAdapterInteractiveVideo);
        this.mAdapterInteractiveVideo.notifyDataSetChanged();
        awqx.b(null, "CliOper", "", "", "0X800A74B", "0X800A74B", 0, 0, "", "", "", "");
      }
    }
  }
  
  void enterDoubleScreen()
  {
    kxl.a(this.mApp.a().a(this.mApp.a().a().d) + "");
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
    label310:
    do
    {
      boolean bool2;
      boolean bool3;
      lxf locallxf;
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
              bool2 = kys.b();
              bool3 = this.mSupportManager.a(3, "normal");
              bool4 = this.mSupportManager.a(3, "interact");
              if (QLog.isDevelopLevel()) {
                QLog.w(TAG, 1, "fixDimmed, supportNormal[" + bool3 + "], supportInteract[" + bool4 + "], isSOExist[" + bool2 + "]");
              }
            } while (this.mPeandantTmpList == null);
            localIterator = this.mPeandantTmpList.iterator();
            while (localIterator.hasNext())
            {
              locallxf = (lxf)localIterator.next();
              if ((locallxf.jdField_a_of_type_JavaLangObject instanceof FaceItem))
              {
                FaceItem localFaceItem = (FaceItem)locallxf.jdField_a_of_type_JavaLangObject;
                if ((!bool3) || (((!bool4) || (!bool2)) && (localFaceItem.isInteract()))) {}
                for (bool1 = true;; bool1 = false)
                {
                  locallxf.jdField_c_of_type_Boolean = bool1;
                  break;
                }
              }
            }
          } while (this.mAdapterPendant == null);
          this.mAdapterPendant.notifyDataSetChanged();
          return;
        } while (paramInt != 1);
        if ((!ley.b()) || (!ley.a(this.mApp))) {
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
        locallxf = (lxf)localIterator.next();
        if ((!bool3) || (!bool1)) {}
        for (bool2 = true;; bool2 = false)
        {
          locallxf.jdField_c_of_type_Boolean = bool2;
          break label310;
          bool1 = false;
          break;
        }
      }
    } while (this.mAdapterInteractiveVideo == null);
    this.mAdapterInteractiveVideo.notifyDataSetChanged();
  }
  
  protected lrg getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new lrg();
      this.mUIInfo.d = 2;
      this.mUIInfo.f = 2131494018;
      this.mUIInfo.e = 2130841413;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getString(2131630501);
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
  
  public void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    krx.c(TAG, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.mApp.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.b();
    EffectSettingUi.a(this.mApp, l);
    if ((paramView.getId() == 2131298058) || (paramView.getId() == 2131297990))
    {
      enterDoubleScreen();
      switch (paramView.getId())
      {
      }
    }
    do
    {
      return;
      enterOriginScreen();
      break;
      chooseTab(2);
      return;
      chooseTab(1);
      return;
      chooseTab(3);
      return;
      chooseTab(4);
    } while (this.mRedTouchInteractiveVideo == null);
    this.mApp.a(this.mRedTouchInteractiveVideo, 5);
    this.mRedTouchInteractiveVideo = null;
  }
  
  protected void onCreate(long paramLong, AVActivity paramAVActivity)
  {
    QLog.w(TAG, 1, "TAG, onCreate, seq[" + paramLong + "]");
    this.mFaceManager = ((kxi)this.mApp.a(3));
    this.mSupportManager = ((kyo)this.mApp.a(5));
    this.mSelectTab = 0;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131302046));
    this.mListView.setStayDisplayOffsetZero(true);
    this.linePendant = this.toolbarView.findViewById(2131303554);
    this.lineFace = this.toolbarView.findViewById(2131303543);
    this.lineVoiceSticker = this.toolbarView.findViewById(2131303569);
    this.lineInteractiveVideo = this.toolbarView.findViewById(2131303549);
    this.btnPendant = ((FrameLayout)this.toolbarView.findViewById(2131298058));
    this.btnFace = ((FrameLayout)this.toolbarView.findViewById(2131297990));
    this.btnVoiceSticker = ((FrameLayout)this.toolbarView.findViewById(2131298146));
    this.btnInteractiveVideo = ((FrameLayout)this.toolbarView.findViewById(2131298017));
    boolean bool1 = lfi.a();
    boolean bool2 = ley.b();
    if (!bool1) {
      this.btnPendant.setVisibility(8);
    }
    if ((!bool1) || (!bool2)) {
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
      localObject = this.toolbarView.findViewById(2131303549);
      this.mRedTouchInteractiveVideo = this.mApp.a((View)localObject, 5);
    }
    this.mFaceTmpList = getList("face");
    this.mPeandantTmpList = getList("pendant");
    this.mVoiceStickerTmpList = getList("voicesticker");
    if (bool2)
    {
      localObject = getList("creativecop");
      this.mInteractiveVideoTmpList = ((ArrayList)localObject);
      this.mAdapterFace = new lwf(this.mApp, paramAVActivity, this.mFaceTmpList, this.mListView);
      this.mAdapterFace.a(this.mFaceClickCallback);
      this.mAdapterFace.a(this);
      this.mAdapterFace.a(false);
      this.mAdapterFace.b(false);
      this.mAdapterPendant = new lwf(this.mApp, paramAVActivity, this.mPeandantTmpList, this.mListView);
      this.mAdapterPendant.a(this.mFaceClickCallback);
      this.mAdapterPendant.a(this);
      this.mAdapterPendant.a(true);
      this.mAdapterPendant.b(true);
      this.mAdapterVoiceSticker = new lwf(this.mApp, paramAVActivity, this.mVoiceStickerTmpList, this.mListView);
      this.mAdapterVoiceSticker.a(this.mFaceClickCallback);
      this.mAdapterVoiceSticker.a(this);
      this.mAdapterVoiceSticker.a(false);
      this.mAdapterVoiceSticker.b(false);
      this.mAdapterInteractiveVideo = new lwf(this.mApp, paramAVActivity, this.mInteractiveVideoTmpList, this.mListView);
      this.mAdapterInteractiveVideo.a(this.mFaceClickCallback);
      this.mAdapterInteractiveVideo.a(this);
      this.mAdapterInteractiveVideo.a(true);
      this.mAdapterInteractiveVideo.b(true);
      paramAVActivity = (FaceItem)this.mFaceManager.a();
      if (paramAVActivity == null) {
        break label813;
      }
      if (!paramAVActivity.isSameType("creativecop")) {
        break label788;
      }
      chooseTab(4);
      label690:
      bool1 = kys.b();
      if ((!ley.b()) || (!ley.a(this.mApp))) {
        break label849;
      }
    }
    label788:
    label813:
    label849:
    for (int i = 1;; i = 0)
    {
      if (((!bool1) || (i == 0)) && (this.mActionReceiver == null))
      {
        this.mActionReceiver = new lsv(this);
        paramAVActivity = new IntentFilter();
        paramAVActivity.addAction("tencent.video.q2v.ptusoDownloadRet");
        paramAVActivity.addAction("tencent.video.q2v.ptuLibpagDownloadRet");
        this.mApp.getApplication().registerReceiver(this.mActionReceiver, paramAVActivity);
      }
      return;
      localObject = null;
      break;
      if (paramAVActivity.isSameType("pendant"))
      {
        chooseTab(2);
        break label690;
      }
      chooseTab(1);
      break label690;
      if (this.mVoiceStickerTmpList.size() > 1)
      {
        chooseTab(3);
        break label690;
      }
      this.btnVoiceSticker.setVisibility(8);
      chooseTab(1);
      break label690;
    }
  }
  
  protected void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    if (this.mActionReceiver != null)
    {
      paramVideoAppInterface.getApplication().unregisterReceiver(this.mActionReceiver);
      this.mActionReceiver = null;
    }
    this.mFaceManager.b(paramLong, this);
    this.mListView = null;
    this.mAdapterFace = null;
    this.mAdapterPendant = null;
    this.mAdapterVoiceSticker = null;
    lxf locallxf;
    if (this.mFaceTmpList != null)
    {
      paramVideoAppInterface = this.mFaceTmpList.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        locallxf = (lxf)paramVideoAppInterface.next();
        if ((!"0".equals(locallxf.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(locallxf.jdField_b_of_type_JavaLangString))) {
          URLDrawable.removeMemoryCacheByUrl(locallxf.jdField_b_of_type_JavaLangString);
        }
      }
    }
    this.mFaceTmpList = null;
    if (this.mPeandantTmpList != null)
    {
      paramVideoAppInterface = this.mPeandantTmpList.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        locallxf = (lxf)paramVideoAppInterface.next();
        if ((!"0".equals(locallxf.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(locallxf.jdField_b_of_type_JavaLangString))) {
          URLDrawable.removeMemoryCacheByUrl(locallxf.jdField_b_of_type_JavaLangString);
        }
      }
    }
    this.mPeandantTmpList = null;
    if (this.mVoiceStickerTmpList != null)
    {
      paramVideoAppInterface = this.mVoiceStickerTmpList.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        locallxf = (lxf)paramVideoAppInterface.next();
        if ((!"0".equals(locallxf.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(locallxf.jdField_b_of_type_JavaLangString))) {
          URLDrawable.removeMemoryCacheByUrl(locallxf.jdField_b_of_type_JavaLangString);
        }
      }
    }
    this.mVoiceStickerTmpList = null;
    if (this.mInteractiveVideoTmpList != null)
    {
      paramVideoAppInterface = this.mInteractiveVideoTmpList.iterator();
      while (paramVideoAppInterface.hasNext())
      {
        locallxf = (lxf)paramVideoAppInterface.next();
        if ((!"0".equals(locallxf.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(locallxf.jdField_b_of_type_JavaLangString))) {
          URLDrawable.removeMemoryCacheByUrl(locallxf.jdField_b_of_type_JavaLangString);
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
    if ((this.mFaceManager != null) && (this.mSelectTab == 4)) {
      this.mFaceManager.a("onHide", null);
    }
  }
  
  public void onItemSelectedChanged(long paramLong, FaceItem paramFaceItem)
  {
    QLog.w(TAG, 1, "onItemSelectedChanged, seq[" + paramLong + "], current[" + paramFaceItem + "]");
    if ((this.mSelectTab != 4) && (paramFaceItem != null) && ("creativecop".equals(paramFaceItem.getType())))
    {
      chooseTab(4);
      return;
    }
    EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.mApp.a(8);
    if ((localEffectOperateManager != null) && (localEffectOperateManager.a()) && (paramFaceItem != null))
    {
      krx.c(TAG, "onItemSelectedChanged type: " + paramFaceItem.getType() + ", id: " + paramFaceItem.getId());
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
    FaceItem localFaceItem;
    String str;
    int i;
    if ((this.mSelectTab == 2) || (this.mSelectTab == 4))
    {
      localFaceItem = (FaceItem)this.mFaceManager.a();
      if (localFaceItem != null) {
        break label116;
      }
      str = "0";
      krx.c(TAG, "setLastSelectedIndex:" + str);
      if (this.mSelectTab != 2) {
        break label125;
      }
      i = 1;
      label72:
      if ((localFaceItem != null) && ((localFaceItem == null) || (!localFaceItem.isSameType("creativecop")))) {
        break label130;
      }
    }
    label130:
    for (int j = 1;; j = 0)
    {
      if (i == 0) {
        break label135;
      }
      EffectToolbar.setLastSelectedIndex(str, this.mPeandantTmpList, this.mAdapterPendant, this.mListView);
      return;
      label116:
      str = localFaceItem.getId();
      break;
      label125:
      i = 0;
      break label72;
    }
    label135:
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
    localAVActivity.a.a().a(Boolean.valueOf(false), 0, 2130841579);
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, lxf paramlxf, lxe paramlxe)
  {
    paramAppInterface = (FaceItem)this.mFaceManager.a(paramlxf.jdField_a_of_type_JavaLangString);
    if (paramAppInterface != null)
    {
      this.mFaceManager.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w(TAG, 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    paramlxe.a(paramLong, paramlxf.jdField_a_of_type_JavaLangString, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.FaceToolbar
 * JD-Core Version:    0.7.0.1
 */