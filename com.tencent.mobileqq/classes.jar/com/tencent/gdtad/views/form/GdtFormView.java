package com.tencent.gdtad.views.form;

import aase;
import aatw;
import aatx;
import aauc;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bety;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.form.AdFormViewListener;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormCommitListener;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormErrorListener;
import com.tencent.ad.tangram.canvas.views.xijing.AdButtonView;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.canvas.views.xijing.a;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.form.framework.GdtFormTableView;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class GdtFormView
  extends LinearLayout
  implements AdFormCommitListener, AdFormErrorListener
{
  private int jdField_a_of_type_Int = -1;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aatw(this);
  private bety jdField_a_of_type_Bety;
  private AdFormData jdField_a_of_type_ComTencentAdTangramCanvasViewsFormAdFormData;
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private GdtFormTableView jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<AdFormViewListener> jdField_a_of_type_JavaLangRefWeakReference;
  
  public GdtFormView(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    super(paramContext);
    a(paramContext, paramGdtAd, paramAdFormData);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView == null)
    {
      aase.d("GdtFormView", "reset error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a();
  }
  
  private void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentAdTangramCanvasViewsFormAdFormData == null) || (!this.jdField_a_of_type_ComTencentAdTangramCanvasViewsFormAdFormData.isValid()))
    {
      aase.d("GdtFormView", "initViews error");
      return;
    }
    setFocusable(true);
    setFocusableInTouchMode(true);
    setBackgroundColor(a().backgroundColor);
    setOrientation(1);
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
        addView((View)localObject, localLayoutParams);
      }
      this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView = new GdtFormTableView(paramContext, a().table, new WeakReference(this));
      Object localObject = new LinearLayout.LayoutParams(-1, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).setMargins(0, a().padding, 0, 0);
      }
      addView(this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView, (ViewGroup.LayoutParams)localObject);
      paramContext = new AdButtonView(paramContext, a().button);
      localObject = new LinearLayout.LayoutParams(-1, a().buttonHeight);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, a().padding, 0, 0);
      addView(paramContext, (ViewGroup.LayoutParams)localObject);
      paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
  }
  
  private void a(Context paramContext, GdtAd paramGdtAd, AdFormData paramAdFormData)
  {
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (paramGdtAd.actionSetId == -2147483648L) || (paramAdFormData == null) || (!paramAdFormData.isValid()))
    {
      aase.d("GdtFormView", "init error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    this.jdField_a_of_type_ComTencentAdTangramCanvasViewsFormAdFormData = paramAdFormData;
    aauc.a(new WeakReference(a()));
    a(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a() == null) || (!a().isValid())) {
      aase.d("GdtFormView", "showLoading error");
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing()));
      this.jdField_a_of_type_Bety = new bety(getContext(), getResources().getDimensionPixelSize(2131298914));
      this.jdField_a_of_type_Bety.setCancelable(false);
      this.jdField_a_of_type_Bety.a(alud.a(2131705566) + a().button.text.text);
      this.jdField_a_of_type_Bety.show();
      return;
    } while ((paramBoolean) || (this.jdField_a_of_type_Bety == null));
    if (this.jdField_a_of_type_Bety.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Bety.dismiss();
      this.jdField_a_of_type_Bety = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        aase.d("GdtFormView", "showLoading", localThrowable);
      }
    }
  }
  
  private void a(boolean paramBoolean, AdFormError paramAdFormError)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((AdFormViewListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onCommitted(paramBoolean, paramAdFormError);
    }
  }
  
  private boolean a()
  {
    if ((a() == null) || (!a().isValid()))
    {
      aase.d("GdtFormView", "validate error");
      return false;
    }
    AdFormError localAdFormError = a().validate();
    if (localAdFormError == null)
    {
      aase.d("GdtFormView", "validate error");
      return false;
    }
    if (localAdFormError.type == 2) {
      return true;
    }
    onError(localAdFormError);
    return false;
  }
  
  private void b()
  {
    aatx.a(getContext(), a(), a(), new WeakReference(this));
  }
  
  protected AdFormData a()
  {
    return this.jdField_a_of_type_ComTencentAdTangramCanvasViewsFormAdFormData;
  }
  
  protected GdtAd a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  }
  
  public void afterCommit(AdFormError paramAdFormError)
  {
    boolean bool = true;
    a(false);
    onError(paramAdFormError);
    if ((paramAdFormError != null) && (paramAdFormError.type == 1)) {}
    for (;;)
    {
      if (bool) {
        a();
      }
      a(bool, paramAdFormError);
      return;
      bool = false;
    }
  }
  
  public void beforeCommit()
  {
    a(true);
  }
  
  public void onError(AdFormError paramAdFormError)
  {
    if ((paramAdFormError == null) || (a() == null) || (!a().isValid())) {
      aase.d("GdtFormView", "onError error");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramAdFormError.type != 1) {
                break;
              }
              this.jdField_a_of_type_Int = -1;
              this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
            } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()));
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), 2, a().button.text.text + alud.a(2131705565), 0);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
            return;
            if (paramAdFormError.type != 4) {
              break;
            }
            this.jdField_a_of_type_Int = -1;
            this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
          } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), 1, a().button.text.text + alud.a(2131705568), 0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
          return;
          if (paramAdFormError.type != 7) {
            break;
          }
          this.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
        } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), 1, alud.a(2131705567), 0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
        return;
        if (paramAdFormError.type != 2) {
          break;
        }
      } while ((paramAdFormError.index != -1) && (paramAdFormError.index != this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
      return;
      if ((paramAdFormError.index == -1) || (TextUtils.isEmpty(paramAdFormError.toString()))) {
        break;
      }
      this.jdField_a_of_type_Int = paramAdFormError.index;
      this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(this.jdField_a_of_type_Int);
    } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), 1, paramAdFormError.toString(), 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
    return;
    aase.d("GdtFormView", "onError error");
  }
  
  public void setListener(WeakReference<AdFormViewListener> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.form.GdtFormView
 * JD-Core Version:    0.7.0.1
 */