package com.tencent.mobileqq.ar.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionDevice;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;
import com.tencent.mobileqq.ar.ARPromotionMgr.SubProcessPromotionMgr;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate;
import com.tencent.mobileqq.ar.model.ScanEntryResourceDelegate.OnAREntryResourcePreapreListener;
import com.tencent.mobileqq.ar.model.UniformGLRenderManager;
import com.tencent.mobileqq.ar.utils.PromotionUtils;
import com.tencent.mobileqq.ar.utils.PromotionUtils.ARTransferDoorInfo;
import com.tencent.mobileqq.ar.utils.PromotionUtils.BasePromotionInfo;
import com.tencent.mobileqq.ar.utils.PromotionUtils.NonePromotion;
import com.tencent.mobileqq.olympic.activity.PromotionEntry;
import com.tencent.mobileqq.olympic.activity.PromotionEntry.OnARPromotionEntryListenr;
import com.tencent.mobileqq.olympic.activity.PromotionRes;
import com.tencent.mobileqq.olympic.activity.PromotionRes.ARTransferPromotionResStatusCallBack;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

@TargetApi(11)
public class ScanEntryProviderContainerView
  extends FrameLayout
  implements ScanEntryResourceDelegate.OnAREntryResourcePreapreListener, ScanEntryContainerViewListener, PromotionEntry.OnARPromotionEntryListenr, PromotionRes.ARTransferPromotionResStatusCallBack
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 0L;
  protected Context a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ScanEntryProviderContainerView.1(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected AppInterface a;
  private PromotionConfigInfo.PromotionItem jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem;
  private ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  private ScanEntryResourceDelegate jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate;
  private UniformGLRenderManager jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
  private PromotionUtils.BasePromotionInfo jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo = null;
  private FrameAnimationViewWraper jdField_a_of_type_ComTencentMobileqqArViewFrameAnimationViewWraper = new FrameAnimationViewWraper();
  private ScanEntryProviderContainerView.onVoiceScanStatusListener jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$onVoiceScanStatusListener = new ScanEntryProviderContainerView.3(this);
  private ScanEntryProviderView jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView = null;
  private ScanEntryProviderViewBuilder jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder;
  private PromotionEntry jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry = null;
  private PromotionRes jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes = null;
  private HashMap<Integer, ScanEntryProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  private boolean c = true;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = true;
  private boolean k = false;
  
  public ScanEntryProviderContainerView(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public ScanEntryProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  public ScanEntryProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void a(PromotionUtils.BasePromotionInfo paramBasePromotionInfo)
  {
    QLog.d("ScanEntryProviderContainerView", 2, "preparePromotionResource");
    this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo = paramBasePromotionInfo;
    if ((!PromotionDevice.a()) || (!this.c))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo)) {
        ThreadManager.getUIHandler().postDelayed(new ScanEntryProviderContainerView.2(this), 1000L);
      }
      QLog.d("ScanEntryProviderContainerView", 2, "doTransferDoor device not support");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes = new PromotionRes((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a(this);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo))
    {
      paramBasePromotionInfo = ((PromotionUtils.ARTransferDoorInfo)this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo).a;
      a("doTransferDoor", null, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramBasePromotionInfo);
      return;
      paramBasePromotionInfo = null;
    }
  }
  
  private void g()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131561099, null);
    addView(localView);
    this.jdField_a_of_type_AndroidViewView = localView;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131377485));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363802));
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder = new ScanEntryProviderViewBuilder(1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public RelativeLayout a()
  {
    return (RelativeLayout)this.jdField_a_of_type_AndroidViewView;
  }
  
  public ARCommonConfigInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  }
  
  public ScanEntryResourceDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate;
  }
  
  public UniformGLRenderManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
  }
  
  public PromotionRes a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a();
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a();
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a();
    int m = 0;
    while (m < arrayOfInt.length)
    {
      ScanEntryProviderViewBuilder.ScanEntryProviderViewItem localScanEntryProviderViewItem = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a(m);
      ImageView localImageView = (ImageView)findViewById(arrayOfInt[m]);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a(m);
      if ((localObject == null) || (localScanEntryProviderViewItem == null))
      {
        m += 1;
      }
      else
      {
        if (localScanEntryProviderViewItem.jdField_a_of_type_Int == 1) {}
        for (int n = i1 - 1;; n = 0)
        {
          localObject = new FrameAnimationDrawable((int[])localObject, localImageView, n);
          localImageView.setTag(Integer.valueOf(localScanEntryProviderViewItem.jdField_a_of_type_Int));
          localImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          localImageView.setContentDescription(arrayOfString[m]);
          this.jdField_a_of_type_ComTencentMobileqqArViewFrameAnimationViewWraper.a(localScanEntryProviderViewItem.jdField_a_of_type_Int, (FrameAnimationDrawable)localObject);
          break;
        }
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle.getBoolean("COLD_START", false);
    int m = paramBundle.getInt("fromSource", 1);
    int n = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a(paramInt);
    QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry index=" + n);
    if (this.jdField_a_of_type_Int == n) {
      QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry value equal return");
    }
    label392:
    label405:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.g();
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.c(false);
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.setVisibility(8);
      }
      Object localObject;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(n)))
      {
        localObject = (ScanEntryProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(n));
        if ((localObject != null) && (!((ScanEntryProviderView)localObject).k))
        {
          ((ScanEntryProviderView)localObject).setAppInterface(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          ((ScanEntryProviderView)localObject).a(paramBundle);
          ((ScanEntryProviderView)localObject).setRectAreas(this.jdField_a_of_type_AndroidGraphicsRect);
          if (paramInt == 1) {
            ((QRScanEntryView)localObject).setVoiceScanStatusListener(this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderContainerView$onVoiceScanStatusListener);
          }
        }
        this.jdField_a_of_type_Int = n;
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView = ((ScanEntryProviderView)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.f();
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem != null) && ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView))) {
            ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).a(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem);
          }
          if ((paramInt == 2) || (!this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.c())) {
            break label392;
          }
          a(true);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Int != 1) {
          break label405;
        }
        ReportController.b(null, "CliOper", "", "", "0X8008F23", "0X8008F23", 0, 0, Integer.toString(m), "0", "0", "");
        return;
        ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a(paramInt, this.jdField_a_of_type_AndroidContentContext, this);
        localObject = localScanEntryProviderView;
        if (localScanEntryProviderView == null) {
          break;
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(n), localScanEntryProviderView);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localScanEntryProviderView);
        localObject = localScanEntryProviderView;
        break;
        if (paramInt == 2) {
          a(false);
        }
      }
    } while (this.jdField_a_of_type_Int != 2);
    ReportController.b(null, "dc00898", "", "", "0X8009C7B", "0X8009C7B", 0, 0, "", "0", "0", "");
  }
  
  public void a(Rect paramRect)
  {
    if ((paramRect != null) && (!paramRect.equals(this.jdField_a_of_type_AndroidGraphicsRect)))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ScanEntryProviderView localScanEntryProviderView = (ScanEntryProviderView)((Map.Entry)localIterator.next()).getValue();
        if ((localScanEntryProviderView != null) && (localScanEntryProviderView.k)) {
          localScanEntryProviderView.setRectAreas(paramRect);
        }
      }
    }
  }
  
  public void a(PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "notifyPromotionEntryReady");
    }
    if (d()) {
      h();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry = new PromotionEntry(this);
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPromotionItem);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(true);
    } while (!QLog.isColorLevel());
    QLog.d("ScanEntryProviderContainerView", 2, "PromotionEntry has already exist");
  }
  
  public void a(PromotionConfigInfo.PromotionItem paramPromotionItem, boolean paramBoolean)
  {
    QLog.d("ScanEntryProviderContainerView", 1, "onPromotionResComplete, promotionItem[" + paramPromotionItem + "], ready[" + paramBoolean + "]isAlreadyEnterPromotion=" + d());
    if ((this.i) || (!d())) {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem = paramPromotionItem;
      }
    }
    do
    {
      return;
      if (paramBoolean)
      {
        paramPromotionItem = new ScanEntryProviderContainerView.4(this, paramPromotionItem);
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          paramPromotionItem.run();
          return;
        }
        ThreadManager.getUIHandler().post(paramPromotionItem);
        return;
      }
      if ((paramPromotionItem == null) && (d()))
      {
        ThreadManager.getUIHandler().postDelayed(new ScanEntryProviderContainerView.5(this), 1000L);
        return;
      }
    } while ((!d()) || (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView == null) || (!(this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView)));
    ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).e(true);
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.a(paramARCommonConfigInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
  }
  
  public void a(PromotionUtils.BasePromotionInfo paramBasePromotionInfo, boolean paramBoolean)
  {
    QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry with bundle");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("COLD_START", true);
    boolean bool;
    if (!this.b)
    {
      bool = true;
      localBundle.putBoolean("hide_album", bool);
      if ((!paramBoolean) && (((paramBasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo)) || ((paramBasePromotionInfo instanceof PromotionUtils.NonePromotion)))) {
        a(paramBasePromotionInfo);
      }
      if ((!paramBoolean) && (paramBasePromotionInfo != null) && ((paramBasePromotionInfo == null) || (paramBasePromotionInfo.c))) {
        break label123;
      }
      if (paramBoolean)
      {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.k = true;
      }
      a(1, localBundle);
    }
    label123:
    do
    {
      return;
      bool = false;
      break;
      paramBoolean = paramBasePromotionInfo.c;
      if ((paramBasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo))
      {
        localBundle.putInt("fromSource", 2);
        a(3, PromotionUtils.a(localBundle));
        ReportController.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 3, 0, "", "", "", "");
        return;
      }
    } while (!paramBoolean);
    localBundle.putLong("recognitionMask", paramBasePromotionInfo.jdField_a_of_type_Long);
    localBundle.putBoolean("NoLimitParams", false);
    localBundle.putBoolean("enableARCloud", paramBasePromotionInfo.jdField_a_of_type_Boolean);
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.k = true;
    localBundle.putInt("fromSource", 2);
    a(3, localBundle);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionResProgress Progress:" + paramInt);
    }
    if (!d()) {
      if (QLog.isColorLevel()) {
        QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionResProgress not show,because not under promotion mode");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView == null) || (!(this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView))) {
      return;
    }
    ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).a(paramString, true);
  }
  
  public void a(String paramString, PromotionConfigInfo.PromotionItem paramPromotionItem, boolean paramBoolean)
  {
    QLog.d("ScanEntryProviderContainerView", 1, "enterTransferDoorMode[" + paramString + "], mIsTransferDoorMode[" + this.d + "], ready[" + paramBoolean + "]");
    this.d = true;
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "onAllowShowEntryChange enable " + paramBoolean);
    }
    if (!this.c) {
      QLog.d("ScanEntryProviderContainerView", 1, "onAllowShowEntryChange refuse ,becauseof h5 not allowed show entry");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!this.f)
          {
            this.e = paramBoolean;
            return;
          }
          if ((!this.g) || ((this.g) && (!this.h) && (this.jdField_a_of_type_Int != 2)) || (this.jdField_a_of_type_Int == 1)) {
            paramBoolean = false;
          }
        } while ((this.e == paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null));
        this.e = paramBoolean;
        if ((!this.e) || (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null) || (this.d)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes == null);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry == null);
    PromotionEntry localPromotionEntry = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry;
    if (this.d) {}
    for (paramBoolean = bool;; paramBoolean = this.e)
    {
      localPromotionEntry.a(paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionEntryVisiableInfo");
    }
    this.f = true;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.post(new ScanEntryProviderContainerView.6(this));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.a();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.c();
    }
  }
  
  public void b(PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    Object localObject = new StringBuilder().append("onPromotionEntryClick ");
    if (paramPromotionItem != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ScanEntryProviderContainerView", 1, bool);
      if ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null) && (paramPromotionItem != null)) {
        break;
      }
      return;
    }
    if (PromotionResDownload.a(false, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramPromotionItem) != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes == null)
      {
        QLog.d("ScanEntryProviderContainerView", 1, "operateBtnOnClick, 资源还没准备好");
        PromotionUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPromotionItem.a);
        bool = false;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView))
      {
        localObject = (ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
        if (!((ARScanEntryView)localObject).b())
        {
          QLog.d("ScanEntryProviderContainerView", 1, "onPromotionEntryClick refuse,AREngine not ready");
          return;
          QLog.w("ScanEntryProviderContainerView", 1, "operateBtnOnClick, 资源还没准备好, TotalProgress[" + this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a() + "], isDownloading[" + this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a() + "], isDownloadError[" + this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.b() + "]");
          this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.c(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          bool = false;
          continue;
          bool = true;
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem != null) {
            ((ARScanEntryView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem);
          }
          ((ARScanEntryView)localObject).a("onPromotionEntryClick", paramPromotionItem, bool);
          ReportController.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 2, 0, "", "", "", "");
          if (!bool)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes != null) {
              this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a(true);
            }
            ((ARScanEntryView)localObject).a("operateBtnOnClick1", true);
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(false, paramPromotionItem);
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes != null) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a(true);
      }
      a("onClickOperateEntry", paramPromotionItem, bool);
      return;
      int m = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a(3);
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(m)))
      {
        localObject = (ARScanEntryView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
        ((ScanEntryProviderView)localObject).g();
        ((ScanEntryProviderView)localObject).c(true);
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
      }
      localObject = PromotionUtils.a(null);
      ((Bundle)localObject).putString("Title", paramPromotionItem.b);
      a(3, (Bundle)localObject);
      ReportController.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 1, 0, "", "", "", "");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "onNotifyBottomControllerPanelVisiable enable" + paramBoolean);
    }
    if ((this.k) || (this.d) || (this.j == paramBoolean)) {
      return;
    }
    this.j = paramBoolean;
    ScanEntryProviderContainerView.7 local7 = new ScanEntryProviderContainerView.7(this, paramBoolean);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      local7.run();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(local7);
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "isEngineReady = ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView == null) {}
    while (!(this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView)) {
      return false;
    }
    return ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.d();
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public void d()
  {
    QLog.i("ScanEntryProviderContainerView", 1, "doOnWindowFocusFirstTimeVisiable");
    if ((!this.d) && (this.c)) {
      a(true);
    }
  }
  
  public boolean d()
  {
    if (PromotionDevice.a())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo)) {
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.jdField_a_of_type_Boolean))
      {
        QLog.d("ScanEntryProviderContainerView", 1, "autoEnterTransferDoorMode, 已经点过入口");
        return true;
      }
    }
    return false;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) && ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView))) {
      ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).h();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ScanEntryProviderView)((Map.Entry)localIterator.next()).getValue()).e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArViewFrameAnimationViewWraper != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewFrameAnimationViewWraper.b();
    }
    this.i = true;
  }
  
  public void setInitEnv(AppInterface paramAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void setRenderEngine(UniformGLRenderManager paramUniformGLRenderManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager = paramUniformGLRenderManager;
  }
  
  public void setScanRect(Rect paramRect, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    this.b = paramBoolean;
  }
  
  public void setUniformResManager(ScanEntryResourceDelegate paramScanEntryResourceDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate = paramScanEntryResourceDelegate;
    this.jdField_a_of_type_ComTencentMobileqqArModelScanEntryResourceDelegate.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView
 * JD-Core Version:    0.7.0.1
 */