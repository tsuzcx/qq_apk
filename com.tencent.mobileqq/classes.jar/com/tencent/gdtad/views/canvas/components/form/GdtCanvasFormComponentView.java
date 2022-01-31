package com.tencent.gdtad.views.canvas.components.form;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtActionReporter;
import com.tencent.gdtad.statistics.GdtActionReporter.Params;
import com.tencent.gdtad.views.GdtViewStatus;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasButtonData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasButtonView;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;
import qlh;
import qlk;
import qll;
import qlo;
import qlr;

public class GdtCanvasFormComponentView
  extends GdtCanvasComponentView
  implements GdtCanvasFormListener
{
  private int jdField_a_of_type_Int = -1;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new qlk(this);
  private GdtCanvasFormComponentData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private qlo jdField_a_of_type_Qlo;
  
  public GdtCanvasFormComponentView(Context paramContext, WeakReference paramWeakReference, GdtCanvasFormComponentData paramGdtCanvasFormComponentData)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasFormComponentData);
  }
  
  private void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData.isValid()))
    {
      GdtLog.d("GdtCanvasFormComponentView", "initViews error");
      return;
    }
    setFocusable(true);
    setFocusableInTouchMode(true);
    setBackgroundColor(a().backgroundColor);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Object localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).setMargins(a().padding, a().paddingTop, a().padding, a().paddingBottom);
    addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    if (a().title != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new TextView(paramContext);
        ((TextView)localObject).setText(a().title.text);
        ((TextView)localObject).setTextColor(a().title.color);
        ((TextView)localObject).setTextSize(0, a().title.size);
        ((TextView)localObject).setTypeface(null, 1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 1;
        localLinearLayout.addView((View)localObject, localLayoutParams);
      }
      this.jdField_a_of_type_Qlo = new qlo(paramContext, a().table, new WeakReference(this));
      localObject = new LinearLayout.LayoutParams(-1, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(0, a().padding, 0, 0);
      }
      localLinearLayout.addView(this.jdField_a_of_type_Qlo, (ViewGroup.LayoutParams)localObject);
      paramContext = new GdtCanvasButtonView(paramContext, a().button);
      localObject = new LinearLayout.LayoutParams(-1, a().buttonHeight);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, a().padding, 0, 0);
      localLinearLayout.addView(paramContext, (ViewGroup.LayoutParams)localObject);
      paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
  }
  
  private void a(Context paramContext, GdtCanvasFormComponentData paramGdtCanvasFormComponentData)
  {
    g();
    if ((paramGdtCanvasFormComponentData == null) || (!paramGdtCanvasFormComponentData.isValid()))
    {
      GdtLog.d("GdtCanvasFormComponentView", "init error");
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData = paramGdtCanvasFormComponentData;
    qlr.a(new WeakReference(a()));
    qll.a(new WeakReference(a()), new WeakReference(a()));
    a(paramContext);
    this.jdField_a_of_type_ComTencentGdtadViewsGdtViewStatus = new GdtViewStatus(new WeakReference(this), new WeakReference(this));
    a(true);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((a() == null) || (!a().isValid())) {
      GdtLog.d("GdtCanvasFormComponentView", "showLoading error");
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getContext(), getResources().getDimensionPixelSize(2131558448));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在" + a().button.text.text);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    } while ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        GdtLog.d("GdtCanvasFormComponentView", "showLoading", localThrowable);
      }
    }
  }
  
  private boolean b()
  {
    if ((a() == null) || (!a().isValid()))
    {
      GdtLog.d("GdtCanvasFormComponentView", "validate error");
      return false;
    }
    GdtCanvasFormError localGdtCanvasFormError = a().validate();
    if (localGdtCanvasFormError == null)
    {
      GdtLog.d("GdtCanvasFormComponentView", "validate error");
      return false;
    }
    if (localGdtCanvasFormError.jdField_a_of_type_Int == 2) {
      return true;
    }
    a(localGdtCanvasFormError);
    return false;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Qlo == null)
    {
      GdtLog.d("GdtCanvasFormComponentView", "reset error");
      return;
    }
    this.jdField_a_of_type_Qlo.a();
  }
  
  private void j()
  {
    qlh.a(a(), a(), new WeakReference(this));
  }
  
  public GdtViewStatus a()
  {
    return null;
  }
  
  public GdtCanvasFormComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFormGdtCanvasFormComponentData;
  }
  
  public void a(GdtCanvasFormError paramGdtCanvasFormError)
  {
    if ((paramGdtCanvasFormError == null) || (a() == null) || (!a().isValid())) {
      GdtLog.d("GdtCanvasFormComponentView", "showError error");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramGdtCanvasFormError.jdField_a_of_type_Int != 1) {
              break;
            }
            this.jdField_a_of_type_Int = -1;
            this.jdField_a_of_type_Qlo.a(-1);
          } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), 2, a().button.text.text + "成功", 0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
          return;
          if (paramGdtCanvasFormError.jdField_a_of_type_Int != 4) {
            break;
          }
          this.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_Qlo.a(-1);
        } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), 1, a().button.text.text + "失败", 0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
        return;
        if (paramGdtCanvasFormError.jdField_a_of_type_Int != 2) {
          break;
        }
      } while ((paramGdtCanvasFormError.b != -1) && (paramGdtCanvasFormError.b != this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Qlo.a(-1);
      return;
      if ((paramGdtCanvasFormError.b == -1) || (TextUtils.isEmpty(paramGdtCanvasFormError.toString()))) {
        break;
      }
      this.jdField_a_of_type_Int = paramGdtCanvasFormError.b;
      this.jdField_a_of_type_Qlo.a(this.jdField_a_of_type_Int);
    } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), 1, paramGdtCanvasFormError.toString(), 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
    return;
    GdtLog.d("GdtCanvasFormComponentView", "showError error");
  }
  
  public void b(GdtCanvasFormError paramGdtCanvasFormError)
  {
    int j = 0;
    b(false);
    a(paramGdtCanvasFormError);
    int i = j;
    if (paramGdtCanvasFormError != null)
    {
      i = j;
      if (paramGdtCanvasFormError.jdField_a_of_type_Int == 1) {
        i = 1;
      }
    }
    if (i != 0) {
      i();
    }
    GdtActionReporter.Params localParams = new GdtActionReporter.Params();
    if (a() != null)
    {
      paramGdtCanvasFormError = a().ad;
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtCanvasFormError;
      if (i == 0) {
        break label92;
      }
    }
    label92:
    for (i = 22;; i = 23)
    {
      localParams.jdField_a_of_type_Int = i;
      GdtActionReporter.a(localParams);
      return;
      paramGdtCanvasFormError = null;
      break;
    }
  }
  
  public void h()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentView
 * JD-Core Version:    0.7.0.1
 */