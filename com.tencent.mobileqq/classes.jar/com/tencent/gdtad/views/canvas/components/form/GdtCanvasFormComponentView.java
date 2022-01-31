package com.tencent.gdtad.views.canvas.components.form;

import adaj;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasPageData;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.ark_form_data.ArkFormData;
import tencent.gdt.ark_form_data.ArkFormData.FormInfo;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import ynv;
import yny;
import yod;
import yoe;
import ypk;
import ypm;
import yqa;
import yqb;
import yqc;
import yqd;
import yqo;

public class GdtCanvasFormComponentView
  extends GdtCanvasComponentView
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private adaj jdField_a_of_type_Adaj;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup.MarginLayoutParams jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams;
  private GdtCanvasFormComponentData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public GdtCanvasFormComponentView(Context paramContext, WeakReference<yqo> paramWeakReference, GdtCanvasFormComponentData paramGdtCanvasFormComponentData)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasFormComponentData);
  }
  
  private adaj a(yqd paramyqd)
  {
    adaj localadaj = new adaj();
    paramyqd.jdField_a_of_type_Adaj = localadaj;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
    localadaj.a(paramyqd.jdField_a_of_type_JavaLangString, paramyqd.b, paramyqd.c, paramyqd.d, paramyqd.jdField_a_of_type_Float, paramyqd.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localadaj.setFixSize(i, j);
    localadaj.setMaxSize(i, j);
    localadaj.setMinSize(i, j);
    return localadaj;
  }
  
  @SuppressLint({"NewApi"})
  private JSONObject a(GdtAd paramGdtAd)
  {
    if ((a() == null) || (TextUtils.isEmpty(a().id)) || (paramGdtAd.getCanvas() == null)) {
      return null;
    }
    paramGdtAd = new JSONObject(paramGdtAd.getCanvas());
    JSONArray localJSONArray1 = paramGdtAd.getJSONObject("content").getJSONArray("modules");
    JSONArray localJSONArray2 = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < localJSONArray1.length())
      {
        if (((JSONObject)localJSONArray1.get(i)).getString("id").equals(a().id)) {
          localJSONArray2.put(localJSONArray1.get(i));
        }
      }
      else
      {
        do
        {
          localJSONArray1.remove(0);
        } while (localJSONArray1.length() > 0);
        localJSONArray1.put(localJSONArray2.get(0));
        return paramGdtAd;
      }
      i += 1;
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView == null)) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
    int i = j - paramInt;
    if (i > j / 4)
    {
      Rect localRect = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getInputRect();
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLocationOnScreen(arrayOfInt);
      this.c = arrayOfInt[1];
      j = ypk.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth(), localRect.bottom) + arrayOfInt[1];
      i = ypk.d(getContext()) - i;
      if (i < j)
      {
        ThreadManager.getUIHandler().postDelayed(new GdtCanvasFormComponentView.5(this, i - j), 5L);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.clearFocus();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.post(new GdtCanvasFormComponentView.6(this));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      ((yqo)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setPageViewTopMargin(this.jdField_b_of_type_Int);
    }
  }
  
  private void a(long paramLong)
  {
    yoe localyoe = new yoe();
    if (a() != null) {}
    for (GdtAd localGdtAd = a().ad;; localGdtAd = null)
    {
      localyoe.jdField_a_of_type_ComTencentGdtadAditemGdtAd = localGdtAd;
      localyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(62);
      localyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(paramLong - this.jdField_a_of_type_Long);
      yod.a(localyoe);
      return;
    }
  }
  
  private void a(Context paramContext)
  {
    if (!b()) {
      yny.d("GdtCanvasFormComponentView", "initViews error");
    }
    do
    {
      return;
      setFocusable(true);
      setFocusableInTouchMode(true);
      j();
    } while (!d());
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    b(paramContext);
  }
  
  private void a(Context paramContext, GdtCanvasFormComponentData paramGdtCanvasFormComponentData)
  {
    g();
    if ((paramGdtCanvasFormComponentData == null) || (TextUtils.isEmpty(paramGdtCanvasFormComponentData.id)))
    {
      yny.d("GdtCanvasFormComponentView", "init error");
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData = paramGdtCanvasFormComponentData;
    a(paramContext);
    this.jdField_a_of_type_Ypm = new ypm(new WeakReference(this), new WeakReference(this));
    a(true);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      yny.d("GdtCanvasFormComponentView", "initArkContainer error");
      return;
    }
    float f2 = 0.0F;
    float f1 = f2;
    if (getContext() != null)
    {
      f1 = f2;
      if (getContext().getResources() != null)
      {
        f1 = f2;
        if (getContext().getResources().getDisplayMetrics() != null) {
          f1 = getContext().getResources().getDisplayMetrics().scaledDensity;
        }
      }
    }
    String str1 = "com.tencent.xijing.form";
    String str4 = "form";
    String str2 = str1;
    String str3 = str4;
    if (a() != null)
    {
      str2 = str1;
      str3 = str4;
      if (a().getPage(0) != null)
      {
        if (!TextUtils.isEmpty(a().getPage(0).arkApp)) {
          str1 = a().getPage(0).arkApp;
        }
        str2 = str1;
        str3 = str4;
        if (!TextUtils.isEmpty(a().getPage(0).arkView))
        {
          str3 = a().getPage(0).arkView;
          str2 = str1;
        }
      }
    }
    this.jdField_a_of_type_Adaj = a(new yqd(yqd.a(str2, str3, "0.0.0.1", paramString, f1, null, null)));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.initArkView(this.jdField_a_of_type_Adaj, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setVisibility(0);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = new ArkAppView(paramContext, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new yqa(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    if ((getContext() != null) && ((getContext() instanceof Activity)))
    {
      paramContext = (FrameLayout)((Activity)getContext()).findViewById(16908290);
      if (paramContext != null)
      {
        this.jdField_a_of_type_AndroidViewView = paramContext.getChildAt(0);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new yqb(this));
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setInputCallback(new yqc(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.post(new GdtCanvasFormComponentView.4(this));
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    this.jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams = ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLayoutParams());
    if (this.jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams != null) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewViewGroup$MarginLayoutParams.topMargin;
    }
  }
  
  private boolean b()
  {
    return (a() != null) && (a().isValid()) && (a() != null) && (a().isValid()) && (a().ad.actionSetId != -2147483648L);
  }
  
  private boolean c()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getRootView() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView == null) || (getContext() == null) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    if ((a() == null) || (a().ad == null)) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject1 = new ark_form_data.ArkFormData();
        Object localObject2 = a().ad;
        ((ark_form_data.ArkFormData)localObject1).ad_info.product_type.set(((GdtAd)localObject2).getProductType());
        ((ark_form_data.ArkFormData)localObject1).ad_info.display_info.advertiser_info.advertiser_id.set(((GdtAd)localObject2).getAdvertiserId());
        ((ark_form_data.ArkFormData)localObject1).ad_info.report_info.landing_page_report_url.set(((GdtAd)localObject2).getUrlForLandingPage());
        ((ark_form_data.ArkFormData)localObject1).ad_info.report_info.trace_info.traceid.set(((GdtAd)localObject2).getTraceId());
        JSONObject localJSONObject = a((GdtAd)localObject2);
        if (localJSONObject != null)
        {
          ((ark_form_data.ArkFormData)localObject1).ad_info.dest_info.canvas_json.set(localJSONObject.toString());
          ((ark_form_data.ArkFormData)localObject1).ad_info.dest_info.dest_type.set(((GdtAd)localObject2).getDestType());
          ((ark_form_data.ArkFormData)localObject1).form_info.form_module_id.set(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData.id);
          ((ark_form_data.ArkFormData)localObject1).form_info.index.set(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData.index);
          localObject1 = ynv.a((PBField)localObject1);
          if ((localObject1 != null) && ((localObject1 instanceof JSONObject))) {
            this.jdField_a_of_type_JavaLangString = localObject1.toString();
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("gdt", localObject1);
            this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).toString();
            yny.d("GdtCanvasFormComponentView", "after filter cancas_json:" + this.jdField_a_of_type_JavaLangString);
            return true;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return false;
  }
  
  private void h()
  {
    if (c()) {}
    int i;
    do
    {
      return;
      Rect localRect = new Rect();
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
      }
      i = localRect.bottom - localRect.top;
    } while (i == this.jdField_a_of_type_Int);
    a(i);
  }
  
  private void i()
  {
    if (c()) {}
    int i;
    do
    {
      return;
      Rect localRect = new Rect();
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
      }
      i = localRect.bottom - localRect.top;
    } while (i != this.jdField_a_of_type_Int);
    a(i);
  }
  
  private void j()
  {
    yoe localyoe = new yoe();
    if (a() != null) {}
    for (GdtAd localGdtAd = a().ad;; localGdtAd = null)
    {
      localyoe.jdField_a_of_type_ComTencentGdtadAditemGdtAd = localGdtAd;
      localyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(61);
      yod.a(localyoe);
      return;
    }
  }
  
  public GdtCanvasFormComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData;
  }
  
  public ypm a()
  {
    return this.jdField_a_of_type_Ypm;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setFocused(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if ((!paramBoolean) && (getContext() != null)) {
      this.jdField_a_of_type_Int = ypk.d(getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentView
 * JD-Core Version:    0.7.0.1
 */