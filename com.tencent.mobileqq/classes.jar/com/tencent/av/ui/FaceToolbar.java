package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jus;

public class FaceToolbar
  extends BaseToolbar
  implements View.OnClickListener, EffectConfigBase.IEffectConfigCallback, QAVPtvTemplateAdapter.IItemDownloadMgr
{
  public static String TAG = "FaceToolbar";
  static String unbaleInfo;
  RedDotTextView btnFace;
  RedDotTextView btnPendant;
  View lineFace;
  View linePendant;
  QAVPtvTemplateAdapter mAdapterFace;
  QAVPtvTemplateAdapter mAdapterPendant;
  QAVPtvTemplateAdapter.IEffectCallback mFaceClickCallback = new jus(this);
  EffectFaceManager mFaceManager;
  ArrayList mFaceTmpList;
  RedTouch mFaceTxRedTouch;
  HorizontalListView mListView;
  ArrayList mPeandantTmpList;
  RedTouch mPendantTxRedTouch;
  int mSelectTab = 0;
  EffectSupportManager mSupportManager;
  BaseToolbar.UIInfo mUIInfo = null;
  
  public FaceToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ArrayList getList(String paramString)
  {
    boolean bool1 = false;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject1).jdField_a_of_type_JavaLangString = "-1";
    localArrayList.add(0, localObject1);
    boolean bool2 = this.mSupportManager.a(3, "normal");
    boolean bool3 = this.mSupportManager.a(3, "interact");
    AVLog.d(TAG, "getList|type=" + paramString + "|" + bool2 + "|" + bool3);
    if ("pendant".equals(paramString))
    {
      localObject1 = new QavListItemBase.ItemInfo();
      ((QavListItemBase.ItemInfo)localObject1).jdField_a_of_type_JavaLangString = "0";
      ((QavListItemBase.ItemInfo)localObject1).jdField_b_of_type_JavaLangString = String.valueOf(2130840276);
      if (!bool3) {
        bool1 = true;
      }
      ((QavListItemBase.ItemInfo)localObject1).jdField_c_of_type_Boolean = bool1;
      ((QavListItemBase.ItemInfo)localObject1).d = "取消挂件";
      localArrayList.add(localObject1);
    }
    localObject1 = this.mFaceManager.a(paramString);
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (FaceItem)((Iterator)localObject1).next();
        if (((FaceItem)localObject2).isShow())
        {
          localObject2 = getListItemInfoFromEmotionInfo((FaceItem)localObject2, bool2, bool3);
          if (("pendant".equals(paramString)) && (!checkPeerFaceSupport()) && (((QavListItemBase.ItemInfo)localObject2).jdField_a_of_type_JavaLangString.equals("huanlian")) && (bool3) && (bool2)) {
            ((QavListItemBase.ItemInfo)localObject2).jdField_c_of_type_Boolean = true;
          }
          localArrayList.add(localObject2);
        }
      }
    }
    return localArrayList;
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
    if ((!paramBoolean1) || ((!paramBoolean2) && (paramFaceItem.isInteract()))) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localItemInfo.jdField_c_of_type_Boolean = paramBoolean1;
      if (!localItemInfo.jdField_c_of_type_Boolean) {
        break;
      }
      localItemInfo.jdField_a_of_type_Boolean = true;
      return localItemInfo;
    }
    localItemInfo.jdField_a_of_type_Boolean = paramFaceItem.isUsable();
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
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramVideoController != null)
    {
      bool1 = bool2;
      if (!paramVideoController.a().g)
      {
        unbaleInfo = paramVideoController.a().getString(2131429247);
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean checkDimmStatus(QavListItemBase.ItemInfo paramItemInfo)
  {
    int k = 0;
    SessionInfo localSessionInfo = this.mApp.a().a();
    if (paramItemInfo.jdField_c_of_type_Boolean)
    {
      int i;
      int m;
      if ("huanlian".equalsIgnoreCase(paramItemInfo.jdField_a_of_type_JavaLangString))
      {
        if (!this.mSupportManager.a(3, "SUPPORT_SWITCH_FACE"))
        {
          i = 2131429590;
          paramItemInfo = (AVActivity)this.mActivity.get();
          if ((i != 0) && (paramItemInfo != null)) {
            paramItemInfo.a(79, paramItemInfo.getString(i), 3000L, 1);
          }
          return true;
        }
        m = this.mSupportManager.a(3, "SUPPORT_SWITCH_FACE");
        if (m == -1) {
          i = 2131429605;
        }
      }
      for (;;)
      {
        int j = k;
        if (this.mApp.a().b(localSessionInfo.jdField_c_of_type_JavaLangString) == 2)
        {
          j = k;
          if (m == -1) {
            j = 1;
          }
        }
        if (j == 0) {
          break;
        }
        i = 2131429606;
        break;
        if (m == 0)
        {
          i = 2131429604;
          continue;
          paramItemInfo = (FaceItem)this.mFaceManager.a(paramItemInfo.jdField_a_of_type_JavaLangString);
          if ((paramItemInfo != null) && (paramItemInfo.isInteract()))
          {
            if (!this.mSupportManager.a(3, "interact"))
            {
              i = 2131429590;
              break;
            }
            i = this.mSupportManager.a(3, "interact");
            if (i == -1)
            {
              i = 2131429592;
              break;
            }
            if (i == 0)
            {
              i = 2131429591;
              break;
            }
          }
          i = 0;
          break;
        }
        i = 0;
      }
    }
    return false;
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
      if (localVideoController.b(localVideoController.a().jdField_c_of_type_JavaLangString) != 2)
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
    int j = 4;
    boolean bool2 = true;
    if (this.mListView == null) {
      return;
    }
    Object localObject;
    int i;
    boolean bool1;
    if (this.mSelectTab != paramInt)
    {
      localObject = this.linePendant;
      if (paramInt != 2) {
        break label186;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.lineFace;
      i = j;
      if (paramInt == 1) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      localObject = this.btnPendant;
      if (paramInt != 2) {
        break label191;
      }
      bool1 = true;
      label75:
      ((RedDotTextView)localObject).setSelected(bool1);
      localObject = this.btnFace;
      if (paramInt != 1) {
        break label197;
      }
      bool1 = bool2;
      label97:
      ((RedDotTextView)localObject).setSelected(bool1);
      localObject = this.mApp.a().a(this.mApp.a().a().jdField_c_of_type_JavaLangString) + "";
      if (paramInt != 2) {
        break label203;
      }
      this.mListView.setAdapter(this.mAdapterPendant);
      this.mAdapterPendant.notifyDataSetChanged();
      MagicDataReport.b((String)localObject);
    }
    for (;;)
    {
      this.mSelectTab = paramInt;
      setLastSelectedIndex();
      return;
      label186:
      i = 4;
      break;
      label191:
      bool1 = false;
      break label75;
      label197:
      bool1 = false;
      break label97;
      label203:
      this.mListView.setAdapter(this.mAdapterFace);
      this.mAdapterFace.notifyDataSetChanged();
      MagicDataReport.c((String)localObject);
    }
  }
  
  protected BaseToolbar.UIInfo getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.UIInfo();
      this.mUIInfo.d = 2;
      this.mUIInfo.g = 2130969361;
      this.mUIInfo.e = 103412;
      this.mUIInfo.f = 2130840127;
      this.mUIInfo.jdField_a_of_type_JavaLangString = this.mApp.getApp().getResources().getString(2131428735);
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
    AVLog.c(TAG, "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.mApp.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131366257: 
    default: 
      return;
    case 2131366258: 
      chooseTab(2);
      this.mApp.f(getRedTouchUIAppid() + "." + 103431 + "");
      updateRedDot();
      return;
    }
    chooseTab(1);
    this.mApp.f(getRedTouchUIAppid() + "." + 103430 + "");
    updateRedDot();
  }
  
  protected void onCreate(AVActivity paramAVActivity)
  {
    AVLog.d(TAG, "onCreate.");
    this.mFaceManager = ((EffectFaceManager)this.mApp.a(3));
    this.mSupportManager = ((EffectSupportManager)this.mApp.a(5));
    this.mSelectTab = 0;
    this.mListView = ((HorizontalListView)this.toolbarView.findViewById(2131366248));
    this.mListView.setStayDisplayOffsetZero(true);
    this.linePendant = this.toolbarView.findViewById(2131366259);
    this.lineFace = this.toolbarView.findViewById(2131366257);
    this.btnPendant = ((RedDotTextView)this.toolbarView.findViewById(2131366258));
    this.btnFace = ((RedDotTextView)this.toolbarView.findViewById(2131366256));
    this.btnPendant.setOnClickListener(this);
    this.btnFace.setOnClickListener(this);
    this.mPendantTxRedTouch = new RedTouch(this.mApp.getApplication(), this.btnPendant).a(53).a();
    this.mFaceTxRedTouch = new RedTouch(this.mApp.getApplication(), this.btnFace).a(53).a();
    this.mFaceTmpList = getList("face");
    this.mPeandantTmpList = getList("pendant");
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
    chooseTab(1);
  }
  
  protected void onDestroy(VideoAppInterface paramVideoAppInterface)
  {
    this.mFaceManager.b(this);
    this.mListView = null;
    this.mAdapterFace = null;
    this.mAdapterPendant = null;
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
  }
  
  public void onDownloadFinish(FaceItem paramFaceItem, boolean paramBoolean)
  {
    if ("face".equalsIgnoreCase(paramFaceItem.getType())) {
      if (this.mAdapterFace != null) {
        this.mAdapterFace.a(paramFaceItem.getId(), paramBoolean);
      }
    }
    while ((!"pendant".equalsIgnoreCase(paramFaceItem.getType())) || (this.mAdapterPendant == null)) {
      return;
    }
    this.mAdapterPendant.a(paramFaceItem.getId(), paramBoolean);
  }
  
  protected void onHide()
  {
    this.mFaceManager.b(this);
  }
  
  public void onItemSelectedChanged(FaceItem paramFaceItem)
  {
    AVLog.c(TAG, "onItemSelectedChanged current[" + paramFaceItem + "]");
    EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.mApp.a(8);
    if ((localEffectOperateManager != null) && (localEffectOperateManager.b()) && (paramFaceItem != null))
    {
      AVLog.c(TAG, "onItemSelectedChanged type: " + paramFaceItem.getType() + ", id: " + paramFaceItem.getId());
      paramFaceItem = paramFaceItem.getType();
      if ("pendant".equals(paramFaceItem)) {
        chooseTab(2);
      }
      for (;;)
      {
        localEffectOperateManager.b(false);
        return;
        if ("face".equals(paramFaceItem)) {
          chooseTab(1);
        }
      }
    }
    setLastSelectedIndex();
  }
  
  public void onProgressUpdate(FaceItem paramFaceItem, int paramInt)
  {
    if ("face".equalsIgnoreCase(paramFaceItem.getType())) {
      if (this.mAdapterFace != null) {
        this.mAdapterFace.a(paramFaceItem.getId(), paramInt);
      }
    }
    while ((!"pendant".equalsIgnoreCase(paramFaceItem.getType())) || (this.mAdapterPendant == null)) {
      return;
    }
    this.mAdapterPendant.a(paramFaceItem.getId(), paramInt);
  }
  
  protected void onShow(int paramInt, boolean paramBoolean)
  {
    setLastSelectedIndex();
    this.mFaceManager.a(this);
  }
  
  void setLastSelectedIndex()
  {
    if (this.mSelectTab != 2) {
      return;
    }
    Object localObject = (FaceItem)this.mFaceManager.a();
    if (localObject == null) {}
    for (localObject = "0";; localObject = ((FaceItem)localObject).getId())
    {
      AVLog.c(TAG, "setLastSelectedIndex:" + (String)localObject);
      EffectToolbar.setLastSelectedIndex((String)localObject, this.mPeandantTmpList, this.mAdapterPendant, this.mListView);
      return;
    }
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = (FaceItem)this.mFaceManager.a(paramItemInfo.jdField_a_of_type_JavaLangString);
    if (paramAppInterface != null)
    {
      this.mFaceManager.a(paramAppInterface);
      return;
    }
    AVLog.e(TAG, "ItemDownloadMgr:startDownloadTemplate failed item = null");
    paramIDownloadCallback.a(paramItemInfo.jdField_a_of_type_JavaLangString, false);
  }
  
  public void update(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
    {
      this.mFaceTmpList = getList("face");
      this.mPeandantTmpList = getList("pendant");
      this.mAdapterFace.a(this.mFaceTmpList);
      this.mAdapterPendant.a(this.mPeandantTmpList);
      if (this.mSelectTab != 0) {
        break label150;
      }
    }
    label150:
    for (int i = 2;; i = this.mSelectTab)
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
      if ("face".equalsIgnoreCase(paramArrayOfObject.getType()))
      {
        this.mAdapterFace.c(str, i);
        break;
      }
      if (!"pendant".equalsIgnoreCase(paramArrayOfObject.getType())) {
        break;
      }
      this.mAdapterPendant.c(str, i);
      break;
    }
  }
  
  void updateRedDot()
  {
    super.updateRedDot();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = this.mApp.a(getRedTouchUIAppid() + "." + 103431 + "");
    if ((this.mPendantTxRedTouch != null) && (localAppInfo != null))
    {
      this.mPendantTxRedTouch.a(localAppInfo);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "updateRedDot, UIAppid[103431], flag[" + localAppInfo.iNewFlag.get() + "]");
      }
    }
    localAppInfo = this.mApp.a(getRedTouchUIAppid() + "." + 103430 + "");
    if ((this.mFaceTxRedTouch != null) && (localAppInfo != null))
    {
      this.mFaceTxRedTouch.a(localAppInfo);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "updateRedDot, UIAppid[103430], flag[" + localAppInfo.iNewFlag.get() + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.FaceToolbar
 * JD-Core Version:    0.7.0.1
 */