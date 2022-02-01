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
    if ((PromotionDevice.a()) && (this.c))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes = new PromotionRes((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a(this);
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      paramBasePromotionInfo = this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo;
      if ((paramBasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo))
      {
        paramBasePromotionInfo = ((PromotionUtils.ARTransferDoorInfo)paramBasePromotionInfo).a;
        a("doTransferDoor", null, false);
      }
      else
      {
        paramBasePromotionInfo = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramBasePromotionInfo);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArUtilsPromotionUtils$BasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo)) {
      ThreadManager.getUIHandler().postDelayed(new ScanEntryProviderContainerView.2(this), 1000L);
    }
    QLog.d("ScanEntryProviderContainerView", 2, "doTransferDoor device not support");
  }
  
  private void g()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560961, null);
    addView(localView);
    this.jdField_a_of_type_AndroidViewView = localView;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131376930));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363732));
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder = new ScanEntryProviderViewBuilder(1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void h()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
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
      if ((localObject != null) && (localScanEntryProviderViewItem != null))
      {
        int n;
        if (localScanEntryProviderViewItem.jdField_a_of_type_Int == 1) {
          n = i1 - 1;
        } else {
          n = 0;
        }
        localObject = new FrameAnimationDrawable((int[])localObject, localImageView, n);
        localImageView.setTag(Integer.valueOf(localScanEntryProviderViewItem.jdField_a_of_type_Int));
        localImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        localImageView.setContentDescription(arrayOfString[m]);
        this.jdField_a_of_type_ComTencentMobileqqArViewFrameAnimationViewWraper.a(localScanEntryProviderViewItem.jdField_a_of_type_Int, (FrameAnimationDrawable)localObject);
      }
      m += 1;
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle.getBoolean("COLD_START", false);
    int m = paramBundle.getInt("fromSource", 1);
    int n = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showProviderEntry index=");
    ((StringBuilder)localObject).append(n);
    QLog.i("ScanEntryProviderContainerView", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int == n)
    {
      QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry value equal return");
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
    if (localObject != null)
    {
      ((ScanEntryProviderView)localObject).g();
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.c(false);
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.setVisibility(8);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(n)))
    {
      localObject = (ScanEntryProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(n));
    }
    else
    {
      ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a(paramInt, this.jdField_a_of_type_AndroidContentContext, this);
      localObject = localScanEntryProviderView;
      if (localScanEntryProviderView != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(n), localScanEntryProviderView);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localScanEntryProviderView);
        localObject = localScanEntryProviderView;
      }
    }
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
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
    if (paramBundle != null)
    {
      paramBundle.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.f();
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
      if (paramBundle != null) {
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.a(paramBundle);
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem;
      if (paramBundle != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
        if ((localObject instanceof ARScanEntryView)) {
          ((ARScanEntryView)localObject).a(paramBundle);
        }
      }
      if ((paramInt != 2) && (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.c())) {
        a(true);
      } else if (paramInt == 2) {
        a(false);
      }
    }
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X8008F23", "0X8008F23", 0, 0, Integer.toString(m), "0", "0", "");
      return;
    }
    if (paramInt == 2) {
      ReportController.b(null, "dc00898", "", "", "0X8009C7B", "0X8009C7B", 0, 0, "", "0", "0", "");
    }
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
    if (d())
    {
      h();
      return;
    }
    PromotionEntry localPromotionEntry = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry;
    if (localPromotionEntry == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry = new PromotionEntry(this);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPromotionItem);
      return;
    }
    localPromotionEntry.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "PromotionEntry has already exist");
    }
  }
  
  public void a(PromotionConfigInfo.PromotionItem paramPromotionItem, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPromotionResComplete, promotionItem[");
    localStringBuilder.append(paramPromotionItem);
    localStringBuilder.append("], ready[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]isAlreadyEnterPromotion=");
    localStringBuilder.append(d());
    QLog.d("ScanEntryProviderContainerView", 1, localStringBuilder.toString());
    if ((!this.i) && (d()))
    {
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
      if (d())
      {
        paramPromotionItem = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
        if ((paramPromotionItem != null) && ((paramPromotionItem instanceof ARScanEntryView))) {
          ((ARScanEntryView)paramPromotionItem).e(true);
        }
      }
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem = paramPromotionItem;
    }
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
    if (localScanEntryProviderView != null) {
      localScanEntryProviderView.a(paramARCommonConfigInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
  }
  
  public void a(PromotionUtils.BasePromotionInfo paramBasePromotionInfo, boolean paramBoolean)
  {
    QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry with bundle");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("COLD_START", true);
    localBundle.putBoolean("hide_album", this.b ^ true);
    if ((!paramBoolean) && (((paramBasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo)) || ((paramBasePromotionInfo instanceof PromotionUtils.NonePromotion)))) {
      a(paramBasePromotionInfo);
    }
    if ((!paramBoolean) && (paramBasePromotionInfo != null) && ((paramBasePromotionInfo == null) || (paramBasePromotionInfo.c)))
    {
      paramBoolean = paramBasePromotionInfo.c;
      if ((paramBasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo))
      {
        localBundle.putInt("fromSource", 2);
        a(3, PromotionUtils.a(localBundle));
        ReportController.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 3, 0, "", "", "", "");
        return;
      }
      if (paramBoolean)
      {
        localBundle.putLong("recognitionMask", paramBasePromotionInfo.jdField_a_of_type_Long);
        localBundle.putBoolean("NoLimitParams", false);
        localBundle.putBoolean("enableARCloud", paramBasePromotionInfo.jdField_a_of_type_Boolean);
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.k = true;
        localBundle.putInt("fromSource", 2);
        a(3, localBundle);
      }
      return;
    }
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.k = true;
    }
    a(1, localBundle);
  }
  
  public void a(String paramString)
  {
    ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
    if (localScanEntryProviderView != null) {
      localScanEntryProviderView.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePromotionResProgress Progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ScanEntryProviderContainerView", 2, ((StringBuilder)localObject).toString());
    }
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionResProgress not show,because not under promotion mode");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
    if ((localObject != null) && ((localObject instanceof ARScanEntryView))) {
      ((ARScanEntryView)localObject).a(paramString, true);
    }
  }
  
  public void a(String paramString, PromotionConfigInfo.PromotionItem paramPromotionItem, boolean paramBoolean)
  {
    paramPromotionItem = new StringBuilder();
    paramPromotionItem.append("enterTransferDoorMode[");
    paramPromotionItem.append(paramString);
    paramPromotionItem.append("], mIsTransferDoorMode[");
    paramPromotionItem.append(this.d);
    paramPromotionItem.append("], ready[");
    paramPromotionItem.append(paramBoolean);
    paramPromotionItem.append("]");
    QLog.d("ScanEntryProviderContainerView", 1, paramPromotionItem.toString());
    this.d = true;
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAllowShowEntryChange enable ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ScanEntryProviderContainerView", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.c)
    {
      QLog.d("ScanEntryProviderContainerView", 1, "onAllowShowEntryChange refuse ,becauseof h5 not allowed show entry");
      return;
    }
    if (!this.f)
    {
      this.e = paramBoolean;
      return;
    }
    boolean bool2 = this.g;
    boolean bool1 = false;
    if ((!bool2) || ((bool2) && (!this.h) && (this.jdField_a_of_type_Int != 2)) || (this.jdField_a_of_type_Int == 1)) {
      paramBoolean = false;
    }
    if ((this.e == paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null)) {
      return;
    }
    this.e = paramBoolean;
    if ((this.e) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry == null) && (!this.d))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes;
      if (localObject != null) {
        ((PromotionRes)localObject).f(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry;
    if (localObject != null)
    {
      if (this.d) {
        paramBoolean = bool1;
      } else {
        paramBoolean = this.e;
      }
      ((PromotionEntry)localObject).a(paramBoolean);
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
    ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
    if (localScanEntryProviderView != null) {
      return localScanEntryProviderView.a();
    }
    return false;
  }
  
  public void b()
  {
    ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
    if (localScanEntryProviderView != null) {
      localScanEntryProviderView.c();
    }
  }
  
  public void b(PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onPromotionEntryClick ");
    boolean bool;
    if (paramPromotionItem != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject1).append(bool);
    QLog.d("ScanEntryProviderContainerView", 1, ((StringBuilder)localObject1).toString());
    if ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null))
    {
      if (paramPromotionItem == null) {
        return;
      }
      if (PromotionResDownload.a(false, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramPromotionItem) != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes == null)
        {
          QLog.d("ScanEntryProviderContainerView", 1, "operateBtnOnClick, 资源还没准备好");
          PromotionUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPromotionItem.a);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("operateBtnOnClick, 资源还没准备好, TotalProgress[");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a());
          ((StringBuilder)localObject1).append("], isDownloading[");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a());
          ((StringBuilder)localObject1).append("], isDownloadError[");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.b());
          ((StringBuilder)localObject1).append("]");
          QLog.w("ScanEntryProviderContainerView", 1, ((StringBuilder)localObject1).toString());
          this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.c(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        }
        bool = false;
      }
      else
      {
        bool = true;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
      if ((localObject1 instanceof ARScanEntryView))
      {
        localObject1 = (ARScanEntryView)localObject1;
        if (!((ARScanEntryView)localObject1).b())
        {
          QLog.d("ScanEntryProviderContainerView", 1, "onPromotionEntryClick refuse,AREngine not ready");
          return;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem;
        if (localObject2 != null) {
          ((ARScanEntryView)localObject1).a((PromotionConfigInfo.PromotionItem)localObject2);
        }
        ((ARScanEntryView)localObject1).a("onPromotionEntryClick", paramPromotionItem, bool);
        ReportController.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 2, 0, "", "", "", "");
        if (!bool)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes;
          if (localObject2 != null) {
            ((PromotionRes)localObject2).a(true);
          }
          ((ARScanEntryView)localObject1).a("operateBtnOnClick1", true);
        }
      }
      else
      {
        int m = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderViewBuilder.a(3);
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(m)))
        {
          localObject1 = (ARScanEntryView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
          ((ScanEntryProviderView)localObject1).g();
          ((ScanEntryProviderView)localObject1).c(true);
          this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(m));
        }
        localObject1 = PromotionUtils.a(null);
        ((Bundle)localObject1).putString("Title", paramPromotionItem.b);
        a(3, (Bundle)localObject1);
        ReportController.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 1, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(false, paramPromotionItem);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes;
      if (localObject1 != null) {
        ((PromotionRes)localObject1).a(true);
      }
      a("onClickOperateEntry", paramPromotionItem, bool);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNotifyBottomControllerPanelVisiable enable");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ScanEntryProviderContainerView", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.k) && (!this.d))
    {
      if (this.j == paramBoolean) {
        return;
      }
      this.j = paramBoolean;
      localObject = new ScanEntryProviderContainerView.7(this, paramBoolean);
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        ((Runnable)localObject).run();
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post((Runnable)localObject);
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "isEngineReady = ");
    }
    ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
    if (localScanEntryProviderView == null) {
      return false;
    }
    if ((localScanEntryProviderView instanceof ARScanEntryView)) {
      return ((ARScanEntryView)localScanEntryProviderView).b();
    }
    return false;
  }
  
  public void c()
  {
    ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
    if (localScanEntryProviderView != null) {
      localScanEntryProviderView.d();
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
      PromotionEntry localPromotionEntry = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry;
      if ((localPromotionEntry != null) && (localPromotionEntry.jdField_a_of_type_Boolean))
      {
        QLog.d("ScanEntryProviderContainerView", 1, "autoEnterTransferDoorMode, 已经点过入口");
        return true;
      }
    }
    return false;
  }
  
  public void e()
  {
    ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
    if ((localScanEntryProviderView != null) && ((localScanEntryProviderView instanceof ARScanEntryView))) {
      ((ARScanEntryView)localScanEntryProviderView).h();
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ScanEntryProviderView)((Map.Entry)((Iterator)localObject).next()).getValue()).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes;
    if (localObject != null)
    {
      ((PromotionRes)localObject).b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry;
    if (localObject != null)
    {
      ((PromotionEntry)localObject).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArViewFrameAnimationViewWraper;
    if (localObject != null) {
      ((FrameAnimationViewWraper)localObject).b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView
 * JD-Core Version:    0.7.0.1
 */