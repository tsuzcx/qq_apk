package com.tencent.mobileqq.ar.view;

import amts;
import amtu;
import amtz;
import amuc;
import amue;
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
import anga;
import angd;
import ange;
import angk;
import angl;
import angm;
import angn;
import anhi;
import anhl;
import anhx;
import anhy;
import ania;
import anib;
import anic;
import anid;
import awbr;
import awby;
import awcd;
import azqs;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.olympic.activity.PromotionEntry;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

@TargetApi(11)
public class ScanEntryProviderContainerView
  extends FrameLayout
  implements angd, anhx, awbr, awcd
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private amts jdField_a_of_type_Amts;
  protected Context a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new anhy(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private anga jdField_a_of_type_Anga;
  private ange jdField_a_of_type_Ange;
  private angm jdField_a_of_type_Angm;
  private anhl jdField_a_of_type_Anhl = new anhl();
  private anib jdField_a_of_type_Anib = new ania(this);
  private anic jdField_a_of_type_Anic;
  private awby jdField_a_of_type_Awby;
  protected AppInterface a;
  private ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  private ScanEntryProviderView jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView;
  private PromotionEntry jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry;
  private HashMap<Integer, ScanEntryProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i = true;
  private boolean j;
  
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
  
  private void a(angm paramangm)
  {
    QLog.d("ScanEntryProviderContainerView", 2, "preparePromotionResource");
    this.jdField_a_of_type_Angm = paramangm;
    if ((!amtu.a()) || (!this.b))
    {
      if ((this.jdField_a_of_type_Angm instanceof angl)) {
        ThreadManager.getUIHandler().postDelayed(new ScanEntryProviderContainerView.2(this), 1000L);
      }
      QLog.d("ScanEntryProviderContainerView", 2, "doTransferDoor device not support");
      return;
    }
    if (this.jdField_a_of_type_Awby == null)
    {
      this.jdField_a_of_type_Awby = new awby((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Awby.a(this);
      this.jdField_a_of_type_Awby.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    if ((this.jdField_a_of_type_Angm instanceof angl))
    {
      paramangm = ((angl)this.jdField_a_of_type_Angm).a;
      a("doTransferDoor", null, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Awby.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramangm);
      return;
      paramangm = null;
    }
  }
  
  private void g()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560837, null);
    addView(localView);
    this.jdField_a_of_type_AndroidViewView = localView;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131376152));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131363393));
    this.jdField_a_of_type_Anic = new anic(1);
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
  
  public anga a()
  {
    return this.jdField_a_of_type_Anga;
  }
  
  public ange a()
  {
    return this.jdField_a_of_type_Ange;
  }
  
  public awby a()
  {
    return this.jdField_a_of_type_Awby;
  }
  
  public ARCommonConfigInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Anic.a();
    int[] arrayOfInt = this.jdField_a_of_type_Anic.a();
    String[] arrayOfString = this.jdField_a_of_type_Anic.a();
    int n = this.jdField_a_of_type_Anic.a();
    int k = 0;
    while (k < arrayOfInt.length)
    {
      anid localanid = this.jdField_a_of_type_Anic.a(k);
      ImageView localImageView = (ImageView)findViewById(arrayOfInt[k]);
      Object localObject = this.jdField_a_of_type_Anic.a(k);
      if (localObject == null)
      {
        k += 1;
      }
      else
      {
        if (localanid.jdField_a_of_type_Int == 1) {}
        for (int m = n - 1;; m = 0)
        {
          localObject = new anhi((int[])localObject, localImageView, m);
          localImageView.setTag(Integer.valueOf(localanid.jdField_a_of_type_Int));
          localImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          localImageView.setContentDescription(arrayOfString[k]);
          this.jdField_a_of_type_Anhl.a(localanid.jdField_a_of_type_Int, (anhi)localObject);
          break;
        }
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle.getBoolean("COLD_START", false);
    int k = paramBundle.getInt("fromSource", 1);
    int m = this.jdField_a_of_type_Anic.a(paramInt);
    QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry index=" + m);
    if (this.jdField_a_of_type_Int == m) {
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
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(m)))
      {
        localObject = (ScanEntryProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(m));
        if ((localObject != null) && (!((ScanEntryProviderView)localObject).k))
        {
          ((ScanEntryProviderView)localObject).setAppInterface(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          ((ScanEntryProviderView)localObject).a(paramBundle);
          ((ScanEntryProviderView)localObject).setRectAreas(this.jdField_a_of_type_AndroidGraphicsRect);
          if (paramInt == 1) {
            ((QRScanEntryView)localObject).setVoiceScanStatusListener(this.jdField_a_of_type_Anib);
          }
        }
        this.jdField_a_of_type_Int = m;
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView = ((ScanEntryProviderView)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.f();
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo);
          }
          if ((this.jdField_a_of_type_Amts != null) && ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView))) {
            ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).a(this.jdField_a_of_type_Amts);
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
        azqs.b(null, "CliOper", "", "", "0X8008F23", "0X8008F23", 0, 0, Integer.toString(k), "0", "0", "");
        return;
        ScanEntryProviderView localScanEntryProviderView = this.jdField_a_of_type_Anic.a(paramInt, this.jdField_a_of_type_AndroidContentContext, this);
        localObject = localScanEntryProviderView;
        if (localScanEntryProviderView == null) {
          break;
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(m), localScanEntryProviderView);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localScanEntryProviderView);
        localObject = localScanEntryProviderView;
        break;
        if (paramInt == 2) {
          a(false);
        }
      }
    } while (this.jdField_a_of_type_Int != 2);
    azqs.b(null, "dc00898", "", "", "0X8009C7B", "0X8009C7B", 0, 0, "", "0", "0", "");
  }
  
  public void a(amts paramamts)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "notifyPromotionEntryReady");
    }
    if (c()) {
      h();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry = new PromotionEntry(this);
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramamts);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(true);
    } while (!QLog.isColorLevel());
    QLog.d("ScanEntryProviderContainerView", 2, "PromotionEntry has already exist");
  }
  
  public void a(amts paramamts, boolean paramBoolean)
  {
    QLog.d("ScanEntryProviderContainerView", 1, "onPromotionResComplete, promotionItem[" + paramamts + "], ready[" + paramBoolean + "]isAlreadyEnterPromotion=" + c());
    if ((this.h) || (!c())) {
      if (paramBoolean) {
        this.jdField_a_of_type_Amts = paramamts;
      }
    }
    do
    {
      return;
      if (paramBoolean)
      {
        paramamts = new ScanEntryProviderContainerView.4(this, paramamts);
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          paramamts.run();
          return;
        }
        ThreadManager.getUIHandler().post(paramamts);
        return;
      }
      if ((paramamts == null) && (c()))
      {
        ThreadManager.getUIHandler().postDelayed(new ScanEntryProviderContainerView.5(this), 1000L);
        return;
      }
    } while ((!c()) || (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView == null) || (!(this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView)));
    ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).e(true);
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
  
  public void a(angm paramangm, boolean paramBoolean)
  {
    QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry with bundle");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("COLD_START", true);
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      localBundle.putBoolean("hide_album", bool);
      if ((!paramBoolean) && (((paramangm instanceof angl)) || ((paramangm instanceof angn)))) {
        a(paramangm);
      }
      if ((!paramBoolean) && (paramangm != null) && ((paramangm == null) || (paramangm.c))) {
        break label123;
      }
      if (paramBoolean)
      {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.j = true;
      }
      a(1, localBundle);
    }
    label123:
    do
    {
      return;
      bool = false;
      break;
      paramBoolean = paramangm.c;
      if ((paramangm instanceof angl))
      {
        localBundle.putInt("fromSource", 2);
        a(3, angk.a(localBundle));
        azqs.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 3, 0, "", "", "", "");
        return;
      }
    } while (!paramBoolean);
    localBundle.putLong("recognitionMask", paramangm.jdField_a_of_type_Long);
    localBundle.putBoolean("NoLimitParams", false);
    localBundle.putBoolean("enableARCloud", paramangm.jdField_a_of_type_Boolean);
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.j = true;
    localBundle.putInt("fromSource", 2);
    a(3, localBundle);
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.a(paramARCommonConfigInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
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
    if (!c()) {
      if (QLog.isColorLevel()) {
        QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionResProgress not show,because not under promotion mode");
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView == null) || (!(this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView instanceof ARScanEntryView))) {
      return;
    }
    ((ARScanEntryView)this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView).a(paramString, true);
  }
  
  public void a(String paramString, amts paramamts, boolean paramBoolean)
  {
    QLog.d("ScanEntryProviderContainerView", 1, "enterTransferDoorMode[" + paramString + "], mIsTransferDoorMode[" + this.c + "], ready[" + paramBoolean + "]");
    this.c = true;
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "onAllowShowEntryChange enable " + paramBoolean);
    }
    if (!this.b) {
      QLog.d("ScanEntryProviderContainerView", 1, "onAllowShowEntryChange refuse ,becauseof h5 not allowed show entry");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!this.e)
          {
            this.d = paramBoolean;
            return;
          }
          if ((!this.f) || ((this.f) && (!this.g) && (this.jdField_a_of_type_Int != 2)) || (this.jdField_a_of_type_Int == 1)) {
            paramBoolean = false;
          }
        } while ((this.d == paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null));
        this.d = paramBoolean;
        if ((!this.d) || (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null) || (this.c)) {
          break;
        }
      } while (this.jdField_a_of_type_Awby == null);
      this.jdField_a_of_type_Awby.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry == null);
    PromotionEntry localPromotionEntry = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry;
    if (this.c) {}
    for (paramBoolean = bool;; paramBoolean = this.d)
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
    this.e = true;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    this.jdField_a_of_type_AndroidOsHandler.post(new ScanEntryProviderContainerView.6(this));
  }
  
  public boolean a()
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
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.c();
    }
  }
  
  public void b(amts paramamts)
  {
    Object localObject = new StringBuilder().append("onPromotionEntryClick ");
    if (paramamts != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ScanEntryProviderContainerView", 1, bool);
      if ((this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) && (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null) && (paramamts != null)) {
        break;
      }
      return;
    }
    if (amtz.a(false, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramamts) != null) {
      if (this.jdField_a_of_type_Awby == null)
      {
        QLog.d("ScanEntryProviderContainerView", 1, "operateBtnOnClick, 资源还没准备好");
        amuc.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramamts.a);
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
          QLog.w("ScanEntryProviderContainerView", 1, "operateBtnOnClick, 资源还没准备好, TotalProgress[" + this.jdField_a_of_type_Awby.a() + "], isDownloading[" + this.jdField_a_of_type_Awby.a() + "], isDownloadError[" + this.jdField_a_of_type_Awby.b() + "]");
          this.jdField_a_of_type_Awby.c(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          bool = false;
          continue;
          bool = true;
        }
        else
        {
          if (this.jdField_a_of_type_Amts != null) {
            ((ARScanEntryView)localObject).a(this.jdField_a_of_type_Amts);
          }
          ((ARScanEntryView)localObject).a("onPromotionEntryClick", paramamts, bool);
          azqs.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 2, 0, "", "", "", "");
          if (!bool)
          {
            if (this.jdField_a_of_type_Awby != null) {
              this.jdField_a_of_type_Awby.a(true);
            }
            ((ARScanEntryView)localObject).a("operateBtnOnClick1", true);
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(false, paramamts);
      if (this.jdField_a_of_type_Awby != null) {
        this.jdField_a_of_type_Awby.a(true);
      }
      a("onClickOperateEntry", paramamts, bool);
      return;
      int k = this.jdField_a_of_type_Anic.a(3);
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(k)))
      {
        localObject = (ARScanEntryView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        ((ScanEntryProviderView)localObject).g();
        ((ScanEntryProviderView)localObject).c(true);
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(k));
      }
      localObject = angk.a(null);
      ((Bundle)localObject).putString("Title", paramamts.b);
      a(3, (Bundle)localObject);
      azqs.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 1, 0, "", "", "", "");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "onNotifyBottomControllerPanelVisiable enable" + paramBoolean);
    }
    if ((this.j) || (this.c) || (this.i == paramBoolean)) {
      return;
    }
    this.i = paramBoolean;
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
    return this.d;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryProviderView.d();
    }
  }
  
  public boolean c()
  {
    if (amtu.a())
    {
      if ((this.jdField_a_of_type_Angm instanceof angl)) {
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
  
  public void d()
  {
    QLog.i("ScanEntryProviderContainerView", 1, "doOnWindowFocusFirstTimeVisiable");
    if ((!this.c) && (this.b)) {
      a(true);
    }
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
    if (this.jdField_a_of_type_Awby != null)
    {
      this.jdField_a_of_type_Awby.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_Awby = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry = null;
    }
    if (this.jdField_a_of_type_Anhl != null) {
      this.jdField_a_of_type_Anhl.b();
    }
    this.h = true;
  }
  
  public void setInitEnv(AppInterface paramAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void setRenderEngine(ange paramange)
  {
    this.jdField_a_of_type_Ange = paramange;
  }
  
  public void setScanRect(Rect paramRect, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setUniformResManager(anga paramanga)
  {
    this.jdField_a_of_type_Anga = paramanga;
    this.jdField_a_of_type_Anga.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView
 * JD-Core Version:    0.7.0.1
 */