package com.tencent.mobileqq.ar.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.mobileqq.education.request.api.IStudyRuntimeService;
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
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@TargetApi(11)
public class ScanEntryProviderContainerView
  extends FrameLayout
  implements ScanEntryResourceDelegate.OnAREntryResourcePreapreListener, ScanEntryContainerViewListener, PromotionEntry.OnARPromotionEntryListenr, PromotionRes.ARTransferPromotionResStatusCallBack
{
  private boolean A = false;
  private boolean B = true;
  private boolean C = false;
  private int D = 0;
  private FrameAnimationViewWraper E = new FrameAnimationViewWraper();
  private View.OnTouchListener F = new ScanEntryProviderContainerView.1(this);
  private ScanEntryProviderContainerView.onVoiceScanStatusListener G = new ScanEntryProviderContainerView.3(this);
  private PromotionConfigInfo.PromotionItem H;
  protected Context a;
  protected AppInterface b;
  View c;
  FrameLayout d;
  LinearLayout e;
  private ScanEntryProviderViewBuilder f;
  private HashMap<Integer, ScanEntryProviderView> g = new HashMap();
  private ScanEntryProviderView h = null;
  private int i = -1;
  private boolean j = false;
  private ScanEntryResourceDelegate k;
  private ARCommonConfigInfo l;
  private UniformGLRenderManager m;
  private Rect n;
  private boolean o = true;
  private Handler p;
  private boolean q = true;
  private boolean r = false;
  private PromotionUtils.BasePromotionInfo s = null;
  private boolean t = false;
  private PromotionEntry u = null;
  private PromotionRes v = null;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private long z = 0L;
  
  public ScanEntryProviderContainerView(Context paramContext)
  {
    super(paramContext);
    k();
  }
  
  public ScanEntryProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    k();
  }
  
  public ScanEntryProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k();
  }
  
  private void a(View paramView, String paramString)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)((ScanTorchActivity)this.a).findViewById(2131445273);
    BubbleTextView localBubbleTextView = new BubbleTextView(this.a);
    localBubbleTextView.setId(2131445270);
    localBubbleTextView.setText(paramString);
    localBubbleTextView.setTextSize(2, 14.0F);
    localBubbleTextView.setTextColor(Color.parseColor("#000000"));
    localBubbleTextView.e = Color.parseColor("#ffffff");
    localBubbleTextView.setPadding(20, 20, 20, 40);
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(2, 2131429655);
    localRelativeLayout.addView(localBubbleTextView, paramString);
    localBubbleTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ScanEntryProviderContainerView.8(this, paramView, localBubbleTextView, paramString));
  }
  
  private void a(PromotionUtils.BasePromotionInfo paramBasePromotionInfo)
  {
    QLog.d("ScanEntryProviderContainerView", 2, "preparePromotionResource");
    this.s = paramBasePromotionInfo;
    if ((PromotionDevice.a()) && (this.q))
    {
      if (this.v == null)
      {
        this.v = new PromotionRes((ScanTorchActivity)this.a);
        this.v.a(this);
        this.v.a(this.b);
      }
      paramBasePromotionInfo = this.s;
      if ((paramBasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo))
      {
        paramBasePromotionInfo = ((PromotionUtils.ARTransferDoorInfo)paramBasePromotionInfo).a;
        a("doTransferDoor", null, false);
      }
      else
      {
        paramBasePromotionInfo = null;
      }
      this.v.a(this.b, paramBasePromotionInfo);
      return;
    }
    if ((this.s instanceof PromotionUtils.ARTransferDoorInfo)) {
      ThreadManager.getUIHandler().postDelayed(new ScanEntryProviderContainerView.2(this), 1000L);
    }
    QLog.d("ScanEntryProviderContainerView", 2, "doTransferDoor device not support");
  }
  
  private void k()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131627302, null);
    addView(localView);
    this.c = localView;
    this.d = ((FrameLayout)localView.findViewById(2131445290));
    this.e = ((LinearLayout)localView.findViewById(2131429655));
    this.f = new ScanEntryProviderViewBuilder(1);
    this.p = new Handler();
  }
  
  private void l()
  {
    Object localObject = (ImageView)findViewById(2131445410);
    if ((localObject != null) && (((ImageView)localObject).getVisibility() != 0)) {
      return;
    }
    localObject = (IStudyRuntimeService)BaseApplicationImpl.sApplication.getRuntime().getRuntimeService(IStudyRuntimeService.class, "all");
    if (((IStudyRuntimeService)localObject).getShowScanAnswerSearchTip())
    {
      a(findViewById(2131445410), this.a.getString(2131888845));
      ((IStudyRuntimeService)localObject).saveShowScanAnswerSearchTip(true);
    }
  }
  
  private void m()
  {
    LinearLayout localLinearLayout = this.e;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
    }
  }
  
  private void n()
  {
    View localView = findViewById(2131445270);
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void a()
  {
    this.f.a(this.D);
    this.f.a();
    int[] arrayOfInt = this.f.b();
    String[] arrayOfString = this.f.c();
    int i3 = this.f.d();
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      ScanEntryProviderViewBuilder.ScanEntryProviderViewItem localScanEntryProviderViewItem = this.f.b(i1);
      ImageView localImageView = (ImageView)findViewById(arrayOfInt[i1]);
      Object localObject = this.f.c(i1);
      if ((localObject != null) && (localScanEntryProviderViewItem != null))
      {
        int i2;
        if (localScanEntryProviderViewItem.a == 1) {
          i2 = i3 - 1;
        } else {
          i2 = 0;
        }
        localObject = new FrameAnimationDrawable((int[])localObject, localImageView, i2);
        localImageView.setVisibility(0);
        localImageView.setTag(Integer.valueOf(localScanEntryProviderViewItem.a));
        localImageView.setOnTouchListener(this.F);
        localImageView.setContentDescription(arrayOfString[i1]);
        this.E.a(localScanEntryProviderViewItem.a, (FrameAnimationDrawable)localObject);
      }
      i1 += 1;
    }
    if (this.D == 1) {
      l();
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle.getBoolean("COLD_START", false);
    int i1 = paramBundle.getInt("fromSource", 1);
    int i2 = this.f.d(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showProviderEntry index=");
    ((StringBuilder)localObject).append(i2);
    QLog.i("ScanEntryProviderContainerView", 1, ((StringBuilder)localObject).toString());
    if (this.i == i2)
    {
      QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry value equal return");
      return;
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((ScanEntryProviderView)localObject).g();
      this.h.c(false);
      this.h.setVisibility(8);
    }
    if (this.g.containsKey(Integer.valueOf(i2)))
    {
      localObject = (ScanEntryProviderView)this.g.get(Integer.valueOf(i2));
    }
    else
    {
      ScanEntryProviderView localScanEntryProviderView = this.f.a(paramInt, this.a, this);
      localObject = localScanEntryProviderView;
      if (localScanEntryProviderView != null)
      {
        this.g.put(Integer.valueOf(i2), localScanEntryProviderView);
        this.d.addView(localScanEntryProviderView);
        localObject = localScanEntryProviderView;
      }
    }
    if ((localObject != null) && (!((ScanEntryProviderView)localObject).D))
    {
      ((ScanEntryProviderView)localObject).setAppInterface(this.b);
      ((ScanEntryProviderView)localObject).a(paramBundle);
      ((ScanEntryProviderView)localObject).setRectAreas(this.n);
      if (paramInt == 1) {
        ((QRScanEntryView)localObject).setVoiceScanStatusListener(this.G);
      }
    }
    this.i = i2;
    this.h = ((ScanEntryProviderView)localObject);
    paramBundle = this.h;
    if (paramBundle != null)
    {
      paramBundle.setVisibility(0);
      this.h.f();
      paramBundle = this.l;
      if (paramBundle != null) {
        this.h.a(paramBundle);
      }
      paramBundle = this.H;
      if (paramBundle != null)
      {
        localObject = this.h;
        if ((localObject instanceof ARScanEntryView)) {
          ((ARScanEntryView)localObject).a(paramBundle);
        }
      }
      if ((paramInt != 2) && (this.h.n())) {
        a(true);
      } else if (paramInt == 2) {
        a(false);
      }
    }
    paramInt = this.i;
    if (paramInt == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X8008F23", "0X8008F23", 0, 0, Integer.toString(i1), "0", "0", "");
      return;
    }
    if (paramInt == 2) {
      ReportController.b(null, "dc00898", "", "", "0X8009C7B", "0X8009C7B", 0, 0, "", "0", "0", "");
    }
  }
  
  public void a(Rect paramRect)
  {
    if ((paramRect != null) && (!paramRect.equals(this.n)))
    {
      this.n = paramRect;
      Iterator localIterator = this.g.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ScanEntryProviderView localScanEntryProviderView = (ScanEntryProviderView)((Map.Entry)localIterator.next()).getValue();
        if ((localScanEntryProviderView != null) && (localScanEntryProviderView.D)) {
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
    if (j())
    {
      m();
      return;
    }
    PromotionEntry localPromotionEntry = this.u;
    if (localPromotionEntry == null)
    {
      this.u = new PromotionEntry(this);
      this.u.a(this.b, paramPromotionItem);
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
    localStringBuilder.append(j());
    QLog.d("ScanEntryProviderContainerView", 1, localStringBuilder.toString());
    if ((!this.A) && (j()))
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
      if ((paramPromotionItem == null) && (j()))
      {
        ThreadManager.getUIHandler().postDelayed(new ScanEntryProviderContainerView.5(this), 1000L);
        return;
      }
      if (j())
      {
        paramPromotionItem = this.h;
        if ((paramPromotionItem != null) && ((paramPromotionItem instanceof ARScanEntryView))) {
          ((ARScanEntryView)paramPromotionItem).f(true);
        }
      }
      return;
    }
    if (paramBoolean) {
      this.H = paramPromotionItem;
    }
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    ScanEntryProviderView localScanEntryProviderView = this.h;
    if (localScanEntryProviderView != null) {
      localScanEntryProviderView.a(paramARCommonConfigInfo);
    }
    this.l = paramARCommonConfigInfo;
  }
  
  public void a(PromotionUtils.BasePromotionInfo paramBasePromotionInfo, boolean paramBoolean)
  {
    QLog.i("ScanEntryProviderContainerView", 1, "showProviderEntry with bundle");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("COLD_START", true);
    localBundle.putBoolean("hide_album", this.o ^ true);
    if ((!paramBoolean) && (((paramBasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo)) || ((paramBasePromotionInfo instanceof PromotionUtils.NonePromotion)))) {
      a(paramBasePromotionInfo);
    }
    if ((!paramBoolean) && (paramBasePromotionInfo != null) && ((paramBasePromotionInfo == null) || (paramBasePromotionInfo.l)))
    {
      paramBoolean = paramBasePromotionInfo.l;
      if ((paramBasePromotionInfo instanceof PromotionUtils.ARTransferDoorInfo))
      {
        localBundle.putInt("fromSource", 2);
        a(3, PromotionUtils.a(localBundle));
        ReportController.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 3, 0, "", "", "", "");
        return;
      }
      if (paramBoolean)
      {
        localBundle.putLong("recognitionMask", paramBasePromotionInfo.g);
        localBundle.putBoolean("NoLimitParams", false);
        localBundle.putBoolean("enableARCloud", paramBasePromotionInfo.j);
        ((ViewGroup)this.c).removeView(this.e);
        this.C = true;
        localBundle.putInt("fromSource", 2);
        a(3, localBundle);
      }
      return;
    }
    if (paramBoolean)
    {
      ((ViewGroup)this.c).removeView(this.e);
      this.C = true;
    }
    a(1, localBundle);
  }
  
  public void a(String paramString)
  {
    ScanEntryProviderView localScanEntryProviderView = this.h;
    if (localScanEntryProviderView != null) {
      localScanEntryProviderView.i_(paramString);
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
    if (!j())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionResProgress not show,because not under promotion mode");
      }
      return;
    }
    Object localObject = this.h;
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
    paramPromotionItem.append(this.r);
    paramPromotionItem.append("], ready[");
    paramPromotionItem.append(paramBoolean);
    paramPromotionItem.append("]");
    QLog.d("ScanEntryProviderContainerView", 1, paramPromotionItem.toString());
    this.r = true;
    m();
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
    if (!this.q)
    {
      QLog.d("ScanEntryProviderContainerView", 1, "onAllowShowEntryChange refuse ,becauseof h5 not allowed show entry");
      return;
    }
    if (!this.w)
    {
      this.t = paramBoolean;
      return;
    }
    boolean bool2 = this.x;
    boolean bool1 = false;
    if ((!bool2) || ((bool2) && (!this.y) && (this.i != 2)) || (this.i == 1)) {
      paramBoolean = false;
    }
    if ((this.t == paramBoolean) && (this.u != null)) {
      return;
    }
    this.t = paramBoolean;
    if ((this.t) && (this.u == null) && (!this.r))
    {
      localObject = this.v;
      if (localObject != null) {
        ((PromotionRes)localObject).g(this.b);
      }
      return;
    }
    Object localObject = this.u;
    if (localObject != null)
    {
      if (this.r) {
        paramBoolean = bool1;
      } else {
        paramBoolean = this.t;
      }
      ((PromotionEntry)localObject).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "updatePromotionEntryVisiableInfo");
    }
    this.w = true;
    this.x = paramBoolean1;
    this.y = paramBoolean2;
    this.p.post(new ScanEntryProviderContainerView.6(this));
  }
  
  public void b()
  {
    ScanEntryProviderView localScanEntryProviderView = this.h;
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
    if ((this.h != null) && (this.u != null))
    {
      if (paramPromotionItem == null) {
        return;
      }
      if (PromotionResDownload.a(false, this.b.getCurrentAccountUin(), paramPromotionItem) != null)
      {
        if (this.v == null)
        {
          QLog.d("ScanEntryProviderContainerView", 1, "operateBtnOnClick, 资源还没准备好");
          PromotionUtil.a(this.b).a(this.b, paramPromotionItem.e);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("operateBtnOnClick, 资源还没准备好, TotalProgress[");
          ((StringBuilder)localObject1).append(this.v.b());
          ((StringBuilder)localObject1).append("], isDownloading[");
          ((StringBuilder)localObject1).append(this.v.d());
          ((StringBuilder)localObject1).append("], isDownloadError[");
          ((StringBuilder)localObject1).append(this.v.e());
          ((StringBuilder)localObject1).append("]");
          QLog.w("ScanEntryProviderContainerView", 1, ((StringBuilder)localObject1).toString());
          this.v.c(this.b);
        }
        bool = false;
      }
      else
      {
        bool = true;
      }
      localObject1 = this.h;
      if ((localObject1 instanceof ARScanEntryView))
      {
        localObject1 = (ARScanEntryView)localObject1;
        if (!((ARScanEntryView)localObject1).k())
        {
          QLog.d("ScanEntryProviderContainerView", 1, "onPromotionEntryClick refuse,AREngine not ready");
          return;
        }
        Object localObject2 = this.H;
        if (localObject2 != null) {
          ((ARScanEntryView)localObject1).a((PromotionConfigInfo.PromotionItem)localObject2);
        }
        ((ARScanEntryView)localObject1).a("onPromotionEntryClick", paramPromotionItem, bool);
        ReportController.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 2, 0, "", "", "", "");
        if (!bool)
        {
          localObject2 = this.v;
          if (localObject2 != null) {
            ((PromotionRes)localObject2).a(true);
          }
          ((ARScanEntryView)localObject1).a("operateBtnOnClick1", true);
        }
      }
      else
      {
        int i1 = this.f.d(3);
        if (this.g.containsKey(Integer.valueOf(i1)))
        {
          localObject1 = (ARScanEntryView)this.g.get(Integer.valueOf(i1));
          ((ScanEntryProviderView)localObject1).g();
          ((ScanEntryProviderView)localObject1).c(true);
          this.g.remove(Integer.valueOf(i1));
        }
        localObject1 = PromotionUtils.a(null);
        ((Bundle)localObject1).putString("Title", paramPromotionItem.f);
        a(3, (Bundle)localObject1);
        ReportController.b(null, "dc00898", "", "", "0X80098C7", "0X80098C7", 1, 0, "", "", "", "");
      }
      this.u.a(false, paramPromotionItem);
      localObject1 = this.v;
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
    if ((!this.C) && (!this.r))
    {
      if (this.B == paramBoolean) {
        return;
      }
      this.B = paramBoolean;
      localObject = new ScanEntryProviderContainerView.7(this, paramBoolean);
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        ((Runnable)localObject).run();
        return;
      }
      this.p.post((Runnable)localObject);
    }
  }
  
  public void c()
  {
    ScanEntryProviderView localScanEntryProviderView = this.h;
    if (localScanEntryProviderView != null) {
      localScanEntryProviderView.d();
    }
  }
  
  public boolean d()
  {
    ScanEntryProviderView localScanEntryProviderView = this.h;
    if (localScanEntryProviderView != null) {
      return localScanEntryProviderView.a();
    }
    return false;
  }
  
  public void e()
  {
    QLog.i("ScanEntryProviderContainerView", 1, "doOnWindowFocusFirstTimeVisiable");
    if ((!this.r) && (this.q)) {
      a(true);
    }
  }
  
  public void f()
  {
    ScanEntryProviderView localScanEntryProviderView = this.h;
    if ((localScanEntryProviderView != null) && ((localScanEntryProviderView instanceof ARScanEntryView))) {
      ((ARScanEntryView)localScanEntryProviderView).h();
    }
  }
  
  public void g()
  {
    Object localObject = this.g.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ScanEntryProviderView)((Map.Entry)((Iterator)localObject).next()).getValue()).e();
    }
    localObject = this.v;
    if (localObject != null)
    {
      ((PromotionRes)localObject).b(this.b);
      this.v = null;
    }
    localObject = this.u;
    if (localObject != null)
    {
      ((PromotionEntry)localObject).a(this.b);
      this.u = null;
    }
    localObject = this.E;
    if (localObject != null) {
      ((FrameAnimationViewWraper)localObject).b();
    }
    this.A = true;
  }
  
  public ARCommonConfigInfo getARCommonConfig()
  {
    return this.l;
  }
  
  public int getBottomHeight()
  {
    return this.n.bottom;
  }
  
  public PromotionRes getPromotionManager()
  {
    return this.v;
  }
  
  public UniformGLRenderManager getRenderEngine()
  {
    return this.m;
  }
  
  public RelativeLayout getTopView()
  {
    return (RelativeLayout)this.c;
  }
  
  public ScanEntryResourceDelegate getUniformResManger()
  {
    return this.k;
  }
  
  public boolean h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanEntryProviderContainerView", 2, "isEngineReady = ");
    }
    ScanEntryProviderView localScanEntryProviderView = this.h;
    if (localScanEntryProviderView == null) {
      return false;
    }
    if ((localScanEntryProviderView instanceof ARScanEntryView)) {
      return ((ARScanEntryView)localScanEntryProviderView).k();
    }
    return false;
  }
  
  public boolean i()
  {
    return this.t;
  }
  
  public boolean j()
  {
    if (PromotionDevice.a())
    {
      if ((this.s instanceof PromotionUtils.ARTransferDoorInfo)) {
        return true;
      }
      PromotionEntry localPromotionEntry = this.u;
      if ((localPromotionEntry != null) && (localPromotionEntry.b))
      {
        QLog.d("ScanEntryProviderContainerView", 1, "autoEnterTransferDoorMode, 已经点过入口");
        return true;
      }
    }
    return false;
  }
  
  public void setEntranceType(int paramInt)
  {
    this.D = paramInt;
  }
  
  public void setInitEnv(AppInterface paramAppInterface, Context paramContext)
  {
    this.b = paramAppInterface;
    this.a = paramContext;
  }
  
  public void setRenderEngine(UniformGLRenderManager paramUniformGLRenderManager)
  {
    this.m = paramUniformGLRenderManager;
  }
  
  public void setScanRect(Rect paramRect, boolean paramBoolean)
  {
    this.n = paramRect;
    this.o = paramBoolean;
  }
  
  public void setUniformResManager(ScanEntryResourceDelegate paramScanEntryResourceDelegate)
  {
    this.k = paramScanEntryResourceDelegate;
    this.k.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView
 * JD-Core Version:    0.7.0.1
 */