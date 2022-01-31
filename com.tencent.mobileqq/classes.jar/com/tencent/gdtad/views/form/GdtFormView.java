package com.tencent.gdtad.views.form;

import ajjy;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bbms;
import bbmy;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.form.framework.GdtFormTableView;
import com.tencent.gdtad.views.xijing.GdtButtonData;
import com.tencent.gdtad.views.xijing.GdtButtonView;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.lang.ref.WeakReference;
import yny;
import yqq;
import yqr;
import yqs;
import yqt;
import yqu;
import yqv;
import yra;

public class GdtFormView
  extends LinearLayout
  implements yqt, yqv
{
  private int jdField_a_of_type_Int = -1;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new yqr(this);
  private bbms jdField_a_of_type_Bbms;
  private bbmy jdField_a_of_type_Bbmy;
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private GdtFormData jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData;
  private GdtFormTableView jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView;
  private WeakReference<yqs> jdField_a_of_type_JavaLangRefWeakReference;
  
  public GdtFormView(Context paramContext, GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    super(paramContext);
    a(paramContext, paramGdtAd, paramGdtFormData);
  }
  
  private void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData.isValid()))
    {
      yny.d("GdtFormView", "initViews error");
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
      paramContext = new GdtButtonView(paramContext, a().button);
      localObject = new LinearLayout.LayoutParams(-1, a().buttonHeight);
      ((LinearLayout.LayoutParams)localObject).setMargins(0, a().padding, 0, 0);
      addView(paramContext, (ViewGroup.LayoutParams)localObject);
      paramContext.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
  }
  
  private void a(Context paramContext, GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    if ((paramGdtAd == null) || (!paramGdtAd.isValid()) || (paramGdtAd.actionSetId == -2147483648L) || (paramGdtFormData == null) || (!paramGdtFormData.isValid()))
    {
      yny.d("GdtFormView", "init error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData = paramGdtFormData;
    yra.a(new WeakReference(a()));
    a(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a() == null) || (!a().isValid())) {
      yny.d("GdtFormView", "showLoading error");
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()));
      this.jdField_a_of_type_Bbms = new bbms(getContext(), getResources().getDimensionPixelSize(2131167766));
      this.jdField_a_of_type_Bbms.setCancelable(false);
      this.jdField_a_of_type_Bbms.a(ajjy.a(2131639386) + a().button.text.text);
      this.jdField_a_of_type_Bbms.show();
      return;
    } while ((paramBoolean) || (this.jdField_a_of_type_Bbms == null));
    if (this.jdField_a_of_type_Bbms.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Bbms.dismiss();
      this.jdField_a_of_type_Bbms = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        yny.d("GdtFormView", "showLoading", localThrowable);
      }
    }
  }
  
  private void a(boolean paramBoolean, yqq paramyqq)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((yqs)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramBoolean, paramyqq);
    }
  }
  
  private boolean a()
  {
    if ((a() == null) || (!a().isValid()))
    {
      yny.d("GdtFormView", "validate error");
      return false;
    }
    yqq localyqq = a().validate();
    if (localyqq == null)
    {
      yny.d("GdtFormView", "validate error");
      return false;
    }
    if (localyqq.jdField_a_of_type_Int == 2) {
      return true;
    }
    a(localyqq);
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView == null)
    {
      yny.d("GdtFormView", "reset error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a();
  }
  
  private void c()
  {
    yqu.a(a(), a(), new WeakReference(this));
  }
  
  protected GdtAd a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  }
  
  protected GdtFormData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData;
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(yqq paramyqq)
  {
    if ((paramyqq == null) || (a() == null) || (!a().isValid())) {
      yny.d("GdtFormView", "onError error");
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
              if (paramyqq.jdField_a_of_type_Int != 1) {
                break;
              }
              this.jdField_a_of_type_Int = -1;
              this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
            } while ((this.jdField_a_of_type_Bbmy != null) && (this.jdField_a_of_type_Bbmy.c()));
            this.jdField_a_of_type_Bbmy = bbmy.a(getContext(), 2, a().button.text.text + ajjy.a(2131639385), 0);
            this.jdField_a_of_type_Bbmy.a();
            return;
            if (paramyqq.jdField_a_of_type_Int != 4) {
              break;
            }
            this.jdField_a_of_type_Int = -1;
            this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
          } while ((this.jdField_a_of_type_Bbmy != null) && (this.jdField_a_of_type_Bbmy.c()));
          this.jdField_a_of_type_Bbmy = bbmy.a(getContext(), 1, a().button.text.text + ajjy.a(2131639388), 0);
          this.jdField_a_of_type_Bbmy.a();
          return;
          if (paramyqq.jdField_a_of_type_Int != 7) {
            break;
          }
          this.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
        } while ((this.jdField_a_of_type_Bbmy != null) && (this.jdField_a_of_type_Bbmy.c()));
        this.jdField_a_of_type_Bbmy = bbmy.a(getContext(), 1, ajjy.a(2131639387), 0);
        this.jdField_a_of_type_Bbmy.a();
        return;
        if (paramyqq.jdField_a_of_type_Int != 2) {
          break;
        }
      } while ((paramyqq.b != -1) && (paramyqq.b != this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
      return;
      if ((paramyqq.b == -1) || (TextUtils.isEmpty(paramyqq.toString()))) {
        break;
      }
      this.jdField_a_of_type_Int = paramyqq.b;
      this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(this.jdField_a_of_type_Int);
    } while ((this.jdField_a_of_type_Bbmy != null) && (this.jdField_a_of_type_Bbmy.c()));
    this.jdField_a_of_type_Bbmy = bbmy.a(getContext(), 1, paramyqq.toString(), 0);
    this.jdField_a_of_type_Bbmy.a();
    return;
    yny.d("GdtFormView", "onError error");
  }
  
  public void b(yqq paramyqq)
  {
    boolean bool = true;
    a(false);
    a(paramyqq);
    if ((paramyqq != null) && (paramyqq.jdField_a_of_type_Int == 1)) {}
    for (;;)
    {
      if (bool) {
        b();
      }
      a(bool, paramyqq);
      return;
      bool = false;
    }
  }
  
  public void setListener(WeakReference<yqs> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.GdtFormView
 * JD-Core Version:    0.7.0.1
 */