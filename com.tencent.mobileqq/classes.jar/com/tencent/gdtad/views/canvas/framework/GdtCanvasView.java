package com.tencent.gdtad.views.canvas.framework;

import adaj;
import ajjy;
import albk;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentData;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentView;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentData;
import com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentView;
import com.tencent.gdtad.views.canvas.components.fixedbutton.GdtCanvasFixedButtonComponentData;
import com.tencent.gdtad.views.canvas.components.fixedbutton.GdtCanvasFixedButtonComponentView;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData;
import com.tencent.gdtad.views.canvas.components.pictures.GdtCanvasMultiPictureComponentData;
import com.tencent.gdtad.views.xijing.GdtButtonData;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;
import yny;
import yob;
import yod;
import yoe;
import yon;
import yox;
import ypk;
import ypr;
import yqd;
import yqn;
import yqo;
import ysn;

public class GdtCanvasView
  extends FrameLayout
  implements albk, yqo
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private GdtCanvasData jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData;
  private GdtCanvasAppBtnComponentView jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView;
  private GdtCanvasFixedButtonComponentView jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView;
  private GdtCanvasPageView jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView;
  private GdtCanvasScrollView jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasScrollView;
  public String a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected yon a;
  private boolean jdField_a_of_type_Boolean;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private GdtCanvasFixedButtonComponentView jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView;
  private yon jdField_b_of_type_Yon = new yon();
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  public GdtCanvasView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Yon = new yon();
    g();
  }
  
  public GdtCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Yon = new yon();
    g();
  }
  
  public GdtCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Yon = new yon();
    g();
  }
  
  private adaj a(yqd paramyqd)
  {
    adaj localadaj = new adaj();
    paramyqd.jdField_a_of_type_Adaj = localadaj;
    localadaj.a(paramyqd.jdField_a_of_type_JavaLangString, paramyqd.b, paramyqd.c, paramyqd.d, paramyqd.jdField_a_of_type_Float, paramyqd.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localadaj.setFixSize(0, 0);
    localadaj.setMaxSize(0, 0);
    localadaj.setMinSize(0, 0);
    return localadaj;
  }
  
  private Activity a()
  {
    if ((getContext() instanceof Activity)) {
      return (Activity)getContext();
    }
    return null;
  }
  
  private static Drawable a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Base64.decode(paramString, 0);
      if ((paramString != null) && (paramString.length > 0))
      {
        paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
        if (paramString != null)
        {
          paramString = new BitmapDrawable(paramString);
          yny.a("GdtCanvasView", "base 64 cost :" + (System.currentTimeMillis() - l));
          return paramString;
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArkAppView localArkAppView = new ArkAppView(getContext(), null);
    localArkAppView.setBorderType(0);
    localArkAppView.setOnTouchListener(localArkAppView);
    localArkAppView.post(new GdtCanvasView.4(this, localArkAppView, paramString1, paramString2, paramString3, paramString4));
    localArkAppView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow();
    paramString1 = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2131493532, null);
    paramString1.addView(localArkAppView);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(paramString1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(paramInt2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(-1));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(LayoutInflater.from(getContext()).inflate(2131493534, null), 81, 0, 0);
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if ((paramLong < 0L) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.isValid())) {
      yny.d("GdtCanvasView", "reportLoadTimeForAction error");
    }
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    yoe localyoe = new yoe();
    Object localObject;
    if (a() != null)
    {
      localObject = a().ad;
      localyoe.jdField_a_of_type_ComTencentGdtadAditemGdtAd = ((GdtAd)localObject);
      localObject = localyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type;
      if (!paramBoolean) {
        break label123;
      }
    }
    label123:
    for (int i = 3;; i = 4)
    {
      ((PBUInt32Field)localObject).set(i);
      localyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(paramLong);
      yod.a(localyoe);
      return;
      localObject = null;
      break;
    }
  }
  
  private void a(ArkAppView paramArkAppView, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    yny.d("GdtCanvasView", "initSelectWindow");
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
    paramArkAppView.initArkView(a(new yqd(yqd.a(paramString1, paramString2, "0.0.0.1", paramString4, f1, null, null))), false);
    paramArkAppView.setVisibility(0);
  }
  
  private void a(String paramString)
  {
    GdtCanvasPageData localGdtCanvasPageData;
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData != null)
    {
      localGdtCanvasPageData = this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.getPage(0);
      if (localGdtCanvasPageData != null) {
        break label21;
      }
    }
    label21:
    do
    {
      do
      {
        return;
        Object localObject1;
        while (!((Iterator)localObject1).hasNext())
        {
          do
          {
            localObject1 = localGdtCanvasPageData.components;
          } while ((localObject1 == null) || (localGdtCanvasPageData.isFloatingBarStyleSetted));
          localObject1 = ((List)localObject1).iterator();
        }
        localObject2 = (GdtCanvasComponentData)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (!(localObject2 instanceof GdtCanvasMultiPictureComponentData)));
      localObject2 = (GdtCanvasMultiPictureComponentData)localObject2;
    } while (((GdtCanvasMultiPictureComponentData)localObject2).imageList == null);
    Object localObject2 = ((GdtCanvasMultiPictureComponentData)localObject2).imageList.iterator();
    label108:
    Object localObject3;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (GdtCanvasPictureComponentData)((Iterator)localObject2).next();
      if (((GdtCanvasPictureComponentData)localObject3).id == paramString)
      {
        localGdtCanvasPageData.floatingBarTextColor = ((GdtCanvasPictureComponentData)localObject3).floatingBarTextColor;
        localGdtCanvasPageData.floatingBarBackgroundColor = ((GdtCanvasPictureComponentData)localObject3).floatingBarBackgroundColor;
        localObject3 = new GdtCanvasAppBtnComponentData();
        ((GdtCanvasAppBtnComponentData)localObject3).id = paramString;
        ((GdtCanvasAppBtnComponentData)localObject3).button.text.text = ajjy.a(2131639380);
        ((GdtCanvasAppBtnComponentData)localObject3).button.text.color = localGdtCanvasPageData.floatingBarTextColor;
        ((GdtCanvasAppBtnComponentData)localObject3).button.backgroundColor = localGdtCanvasPageData.floatingBarBackgroundColor;
        ((GdtCanvasAppBtnComponentData)localObject3).button.text.size = ypk.b(1080, 54);
        i = ypk.c(getContext());
        if (i <= 0) {
          break label336;
        }
      }
    }
    for (;;)
    {
      ((GdtCanvasAppBtnComponentData)localObject3).width = i;
      ((GdtCanvasAppBtnComponentData)localObject3).height = ypk.a(50.0F, getContext().getResources());
      ((GdtCanvasAppBtnComponentData)localObject3).gravity = 17;
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView = new GdtCanvasAppBtnComponentView(getContext(), new WeakReference(this), (GdtCanvasAppBtnComponentData)localObject3, true);
      localObject3 = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView, (ViewGroup.LayoutParams)localObject3);
      localGdtCanvasPageData.isFloatingBarStyleSetted = true;
      break label108;
      break;
      label336:
      i = 1080;
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).getString("formModuleId");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView == null))
    {
      yny.d("GdtCanvasView", "arkViewResize error");
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("formModuleId");
      int i = paramString.getInt("width");
      int j = paramString.getInt("height");
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.a(str, i, j);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str1 = paramString.getString("action");
      if ("show".equals(str1))
      {
        int i = paramString.optInt("width");
        int j = paramString.getInt("height");
        Object localObject = paramString.getJSONObject("meta");
        paramString = ((JSONObject)localObject).getString("app");
        str1 = ((JSONObject)localObject).getString("view");
        String str2 = ((JSONObject)localObject).getString("ver");
        localObject = ((JSONObject)localObject).getJSONObject("meta").toString();
        AdThreadManager.INSTANCE.post(new GdtCanvasView.2(this, i, j, paramString, str1, str2, (String)localObject), 0);
        return;
      }
      if ("hide".equals(str1))
      {
        AdThreadManager.INSTANCE.post(new GdtCanvasView.3(this), 0);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    int i1 = 0;
    Object localObject1;
    int j;
    int i;
    int m;
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.fixedButtonComponentDataList;
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break label464;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        i = ((GdtCanvasFixedButtonComponentData)((Iterator)localObject1).next()).whiteSpace + i;
        j = 1;
      }
      m = j;
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.webFixedButtonComponentDataList;
      int k;
      int n;
      Object localObject2;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        k = 0;
        j = i;
        n = k;
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break label212;
        }
        localObject2 = (GdtCanvasButtonComponentData)((Iterator)localObject1).next();
        if (!((GdtCanvasButtonComponentData)localObject2).isFixed) {
          break label459;
        }
        GdtCanvasButtonComponentView localGdtCanvasButtonComponentView = new GdtCanvasButtonComponentView(getContext(), new WeakReference(this), (GdtCanvasButtonComponentData)GdtCanvasButtonComponentData.class.cast(localObject2));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localGdtCanvasButtonComponentView);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        j += ((GdtCanvasButtonComponentData)localObject2).whiteSpace;
      }
      label448:
      label459:
      for (i = 1;; i = k)
      {
        k = i;
        break;
        n = 0;
        label212:
        localObject1 = this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.appFixedButtonComponentDataList;
        k = i1;
        j = i;
        if (localObject1 != null)
        {
          k = i1;
          j = i;
          if (((ArrayList)localObject1).size() > 0)
          {
            i1 = 0;
            k = 0;
            j = i;
            i = i1;
            if (k < ((ArrayList)localObject1).size())
            {
              if ((((ArrayList)localObject1).get(k) == null) || (GdtCanvasAppBtnComponentData.class.cast(((ArrayList)localObject1).get(k)) == null)) {
                break label448;
              }
              localObject2 = (GdtCanvasAppBtnComponentData)GdtCanvasAppBtnComponentData.class.cast(((ArrayList)localObject1).get(k));
              localObject2 = new GdtCanvasAppBtnComponentView(getContext(), new WeakReference(this), (GdtCanvasAppBtnComponentData)localObject2, ((GdtCanvasAppBtnComponentData)localObject2).canShowProgress);
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2);
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              i = j + ((GdtCanvasAppBtnComponentData)((ArrayList)localObject1).get(k)).whiteSpace;
              j = 1;
            }
          }
        }
        for (;;)
        {
          i1 = k + 1;
          k = j;
          j = i;
          i = k;
          k = i1;
          break;
          k = i;
          if (((n != 0) || (m != 0) || (k != 0)) && (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView != null))
          {
            localObject1 = this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.a();
            if (localObject1 != null) {
              ((LinearLayout)localObject1).setPadding(((LinearLayout)localObject1).getPaddingLeft(), ((LinearLayout)localObject1).getPaddingTop(), ((LinearLayout)localObject1).getPaddingRight(), ((LinearLayout)localObject1).getPaddingBottom() + j);
            }
          }
          return;
          i1 = j;
          j = i;
          i = i1;
        }
      }
      label464:
      m = 0;
      i = 0;
    }
  }
  
  private void e(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("action");
      if ("show".equals(paramString))
      {
        if ((getContext() != null) && (getResources() != null)) {
          AdProgressDialog.show(getContext(), ypk.a(60.0F, getResources()));
        }
      }
      else if ("hide".equals(paramString))
      {
        AdProgressDialog.dismiss();
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.fixedButtonComponentDataList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          GdtCanvasFixedButtonComponentData localGdtCanvasFixedButtonComponentData = (GdtCanvasFixedButtonComponentData)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(localGdtCanvasFixedButtonComponentData.position)) {
            if (localGdtCanvasFixedButtonComponentData.position.toLowerCase().equals("top"))
            {
              this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.setVisibility(0);
              this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.a(getContext(), localGdtCanvasFixedButtonComponentData, this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.ad, new WeakReference(this));
            }
            else if (localGdtCanvasFixedButtonComponentData.position.toLowerCase().equals("bottom"))
            {
              this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.setVisibility(0);
              this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.a(getContext(), localGdtCanvasFixedButtonComponentData, this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.ad, new WeakReference(this));
            }
          }
        }
      }
    }
  }
  
  private void f(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.getInt("type");
      String str = paramString.getString("text");
      int j = paramString.getInt("duration");
      AdToast.show(getContext(), i, str, j);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void g()
  {
    ypr.a();
    d();
    inflate(getContext(), 2131493534, this);
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView = ((GdtCanvasFixedButtonComponentView)findViewById(2131301359));
    this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView = ((GdtCanvasFixedButtonComponentView)findViewById(2131301347));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301346));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131300775));
    try
    {
      findViewById(2131301348).setBackgroundDrawable(a("iVBORw0KGgoAAAANSUhEUgAAABQAAAB4CAYAAADyv9IsAAABZ0lEQVR4AWIAAkC7Y8DZMBRFYaMQBAqBYhAMhkCgEJTS//9/Bnd8Hme77zmVRh++nbPem+/dh5l3Fd6DB7KEM72PoYt3FN4quP+m4AahjQMItygtbMgNQrFQCYR6QXcmQLHgF3bhFYmOHbUP4dVJXqgvL2f7XajpwjW7jN1VEMJGxCMY6kXdS1BcdKFBuOCfBcm+ErVPoY0mobgMQgPHE34HC5I9P4+SJS1ckpkhvdiFOwu/6jNA8SBeE10lu//CAwhnNcRsZk8JhaAFPaRcX6qFLrrwScJPdDEXv8cfH3hNp+6zEjo5gPCihphd2BNC+UEpTJBfVJcyKbTRhU8WTkj2f4WTEb7Onk8ldNGFBuFZDTE7syeE8oNCmAClhkkkhTa6sI2xFI5BORzz8wDFhBiIy0QaLzy+cECyVwkHJ3mhvryc7XehpgtPwVCTAgqrUQ9wQS5rQQlKO1348QcnJLvej+LkxYU/s5xl0uh1oCUAAAAASUVORK5CYII="));
      findViewById(2131298701).setOnClickListener(new yqn(this));
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasScrollView = new GdtCanvasScrollView(getContext());
      ArkAppNotifyCenter.setNotify("com.tencent.xijing.form", new WeakReference(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        yny.d("GdtCanvasView", "init error", localThrowable);
      }
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.isValid()))
    {
      yny.d("GdtCanvasView", "reportStayTimeForAction error");
      return;
    }
    yoe localyoe = new yoe();
    if (a() != null) {}
    for (GdtAd localGdtAd = a().ad;; localGdtAd = null)
    {
      localyoe.jdField_a_of_type_ComTencentGdtadAditemGdtAd = localGdtAd;
      localyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.landing_page_action_type.set(7);
      localyoe.jdField_a_of_type_TencentGdtLanding_page_collect_data$LandingPageCollectData.latency_ms.set(this.jdField_b_of_type_Yon.a());
      yod.a(localyoe);
      return;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData == null) {}
    String str;
    do
    {
      do
      {
        return;
        str = this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.firstPictureComponentIdWithHotArea;
      } while ((TextUtils.isEmpty(str)) || ((!ypr.a()) && ((!this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.getAutoDownLoad()) || (!yox.a()))));
      a(str);
    } while (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView == null);
    a(str, false);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView != null) {
      return this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.getScrollY();
    }
    return 0;
  }
  
  protected long a()
  {
    long l = -2147483648L;
    if (this.jdField_a_of_type_Yon != null)
    {
      this.jdField_a_of_type_Yon.b();
      l = this.jdField_a_of_type_Yon.a();
    }
    this.jdField_a_of_type_Yon = null;
    return l;
  }
  
  public GdtCanvasData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData;
  }
  
  public GdtCanvasPageView a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.a();
    }
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView != null) && (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.d();
    }
    if ((this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView != null) && (this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.getVisibility() == 0)) {
      this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.d();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView.d();
    }
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    AdProgressDialog.dismiss();
    ArkAppNotifyCenter.setNotify("com.tencent.xijing.form", null);
    h();
    a(this.jdField_b_of_type_Yon.a(), false);
    ypr.a();
  }
  
  public void a(GdtCanvasComponentData paramGdtCanvasComponentData, long paramLong, boolean paramBoolean)
  {
    if ((paramGdtCanvasComponentData == null) || (!paramGdtCanvasComponentData.isValid()) || (a() == null) || (!a().isValid())) {
      yny.d("GdtCanvasView", "onLoaded error");
    }
    label218:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Boolean) || (!paramBoolean) || (a() == null) || (!a().isValid())) {}
      for (;;)
      {
        if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilSet == null) || (!paramGdtCanvasComponentData.isAddToLoadStatistics)) {
          break label218;
        }
        this.c &= paramBoolean;
        this.jdField_a_of_type_JavaUtilSet.add(paramGdtCanvasComponentData.id);
        if (this.jdField_a_of_type_JavaUtilSet.size() != a().getToLoadIdsize()) {
          break;
        }
        a(a(), this.c);
        return;
        Object localObject = a().getPage(0);
        if ((localObject != null) && (((GdtCanvasPageData)localObject).isValid()))
        {
          localObject = ((GdtCanvasPageData)localObject).getPageFirstImageComponentData();
          if ((localObject != null) && (((GdtCanvasComponentData)localObject).isValid()) && (TextUtils.equals(paramGdtCanvasComponentData.id, ((GdtCanvasComponentData)localObject).id)))
          {
            ysn.a(a().ad);
            this.jdField_a_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ("backTop".equals(paramString1)) {
      a(paramString1, false, paramString3, paramString4);
    }
    if (("form".equals(paramString1)) && (!TextUtils.isEmpty(paramString4))) {
      a(paramString1, false, paramString3, paramString4);
    }
    if (("link".equals(paramString1)) && (!TextUtils.isEmpty(paramString3))) {
      a(paramString1, false, paramString3, paramString4);
    }
    if (("top".equals(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      a(paramString2, true);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.getVisibility() == 0) || (this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.getVisibility() == 0))
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.h();
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.getVisibility() == 0)
        {
          this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.h();
          return;
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() <= 0) {
          break;
        }
        if (paramBoolean)
        {
          int i = 0;
          while (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
          {
            paramString = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i);
            if ((paramString != null) && ((paramString instanceof GdtCanvasAppBtnComponentView)) && (((GdtCanvasAppBtnComponentView)paramString).a() != null) && (((GdtCanvasAppBtnComponentView)paramString).a().canShowProgress)) {
              ((GdtCanvasAppBtnComponentView)paramString).h();
            }
            i += 1;
          }
        }
      }
      if (this.jdField_b_of_type_AndroidWidgetFrameLayout.getVisibility() == 8) {
        a(paramString);
      }
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView != null)) {
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView.h();
      }
      paramString = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    } while (this.jdField_b_of_type_AndroidWidgetFrameLayout.getVisibility() != 0);
    paramString.addRule(3, this.jdField_b_of_type_AndroidWidgetFrameLayout.getId());
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    if (("backTop".equals(paramString1)) && (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView != null)) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.fullScroll(33);
    }
    if (("form".equals(paramString1)) && (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView != null)) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.a(paramString3);
    }
    if (("link".equals(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      yny.a("GdtCanvasView", "click link :" + paramString2);
      if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.isValid())) {
        break label142;
      }
      ysn.c(this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.ad);
    }
    for (;;)
    {
      yob.a(getContext(), paramString2);
      if ("top".equals(paramString1)) {}
      return;
      label142:
      yny.d("GdtCanvasView", "reportOpenWebPageAsync error");
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.a()) {
      return true;
    }
    if (a() != null)
    {
      a().finish();
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2.equals("toast_event"))
    {
      yny.a("GdtCanvasView", "toast_event" + paramString3);
      f(paramString3);
    }
    for (;;)
    {
      return true;
      if (paramString2.equals("loading_event"))
      {
        yny.a("GdtCanvasView", "loading_event" + paramString3);
        e(paramString3);
      }
      else if (paramString2.equals("xijing_form_select_event"))
      {
        yny.a("GdtCanvasView", "xijing_form_select_event" + paramString3);
        d(paramString3);
      }
      else if (paramString2.equals("xijing_form_resize_event"))
      {
        yny.a("GdtCanvasView", "xijing_form_resize_event" + paramString3);
        c(paramString3);
      }
      else if (paramString2.equals("xijing_form_input_focus_event"))
      {
        yny.a("GdtCanvasView", "xijing_form_input_focus_event" + paramString3);
        b(paramString3);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.c();
    }
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView != null) && (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.f();
    }
    if ((this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView != null) && (this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.getVisibility() == 0)) {
      this.jdField_b_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.f();
    }
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView.f();
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i);
        if ((localView != null) && ((localView instanceof GdtCanvasComponentView))) {
          ((GdtCanvasComponentView)localView).f();
        }
        i += 1;
      }
    }
    this.jdField_b_of_type_Yon.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.b();
    }
    this.jdField_b_of_type_Yon.b();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Yon != null) {
      this.jdField_a_of_type_Yon.a();
    }
  }
  
  public void setData(GdtCanvasData paramGdtCanvasData)
  {
    if ((paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid())) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData = paramGdtCanvasData;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298317));
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView = new GdtCanvasPageView(getContext(), new WeakReference(this), this.jdField_a_of_type_ComTencentGdtadViewsCanvasGdtCanvasData.getPage(0));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView);
    f();
    e();
    paramGdtCanvasData = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.getVisibility() == 0) {
      paramGdtCanvasData.addRule(3, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentView.getId());
    }
    i();
  }
  
  public void setPageViewTopMargin(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.setPageViewLayoutParams(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasView
 * JD-Core Version:    0.7.0.1
 */