package com.tencent.gdtad.views.form;

import ajyc;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bcpq;
import bcpw;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.form.framework.GdtFormTableView;
import com.tencent.gdtad.views.xijing.GdtButtonData;
import com.tencent.gdtad.views.xijing.GdtButtonView;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.lang.ref.WeakReference;
import yxs;
import zai;
import zaj;
import zak;
import zal;
import zam;
import zan;
import zas;

public class GdtFormView
  extends LinearLayout
  implements zal, zan
{
  private int jdField_a_of_type_Int = -1;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new zaj(this);
  private bcpq jdField_a_of_type_Bcpq;
  private bcpw jdField_a_of_type_Bcpw;
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private GdtFormData jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData;
  private GdtFormTableView jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView;
  private WeakReference<zak> jdField_a_of_type_JavaLangRefWeakReference;
  
  public GdtFormView(Context paramContext, GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    super(paramContext);
    a(paramContext, paramGdtAd, paramGdtFormData);
  }
  
  private void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData.isValid()))
    {
      yxs.d("GdtFormView", "initViews error");
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
      yxs.d("GdtFormView", "init error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData = paramGdtFormData;
    zas.a(new WeakReference(a()));
    a(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a() == null) || (!a().isValid())) {
      yxs.d("GdtFormView", "showLoading error");
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing()));
      this.jdField_a_of_type_Bcpq = new bcpq(getContext(), getResources().getDimensionPixelSize(2131298865));
      this.jdField_a_of_type_Bcpq.setCancelable(false);
      this.jdField_a_of_type_Bcpq.a(ajyc.a(2131705171) + a().button.text.text);
      this.jdField_a_of_type_Bcpq.show();
      return;
    } while ((paramBoolean) || (this.jdField_a_of_type_Bcpq == null));
    if (this.jdField_a_of_type_Bcpq.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Bcpq.dismiss();
      this.jdField_a_of_type_Bcpq = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        yxs.d("GdtFormView", "showLoading", localThrowable);
      }
    }
  }
  
  private void a(boolean paramBoolean, zai paramzai)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((zak)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramBoolean, paramzai);
    }
  }
  
  private boolean a()
  {
    if ((a() == null) || (!a().isValid()))
    {
      yxs.d("GdtFormView", "validate error");
      return false;
    }
    zai localzai = a().validate();
    if (localzai == null)
    {
      yxs.d("GdtFormView", "validate error");
      return false;
    }
    if (localzai.jdField_a_of_type_Int == 2) {
      return true;
    }
    a(localzai);
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView == null)
    {
      yxs.d("GdtFormView", "reset error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a();
  }
  
  private void c()
  {
    zam.a(a(), a(), new WeakReference(this));
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
  
  public void a(zai paramzai)
  {
    if ((paramzai == null) || (a() == null) || (!a().isValid())) {
      yxs.d("GdtFormView", "onError error");
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
              if (paramzai.jdField_a_of_type_Int != 1) {
                break;
              }
              this.jdField_a_of_type_Int = -1;
              this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
            } while ((this.jdField_a_of_type_Bcpw != null) && (this.jdField_a_of_type_Bcpw.c()));
            this.jdField_a_of_type_Bcpw = bcpw.a(getContext(), 2, a().button.text.text + ajyc.a(2131705170), 0);
            this.jdField_a_of_type_Bcpw.a();
            return;
            if (paramzai.jdField_a_of_type_Int != 4) {
              break;
            }
            this.jdField_a_of_type_Int = -1;
            this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
          } while ((this.jdField_a_of_type_Bcpw != null) && (this.jdField_a_of_type_Bcpw.c()));
          this.jdField_a_of_type_Bcpw = bcpw.a(getContext(), 1, a().button.text.text + ajyc.a(2131705173), 0);
          this.jdField_a_of_type_Bcpw.a();
          return;
          if (paramzai.jdField_a_of_type_Int != 7) {
            break;
          }
          this.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
        } while ((this.jdField_a_of_type_Bcpw != null) && (this.jdField_a_of_type_Bcpw.c()));
        this.jdField_a_of_type_Bcpw = bcpw.a(getContext(), 1, ajyc.a(2131705172), 0);
        this.jdField_a_of_type_Bcpw.a();
        return;
        if (paramzai.jdField_a_of_type_Int != 2) {
          break;
        }
      } while ((paramzai.b != -1) && (paramzai.b != this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
      return;
      if ((paramzai.b == -1) || (TextUtils.isEmpty(paramzai.toString()))) {
        break;
      }
      this.jdField_a_of_type_Int = paramzai.b;
      this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(this.jdField_a_of_type_Int);
    } while ((this.jdField_a_of_type_Bcpw != null) && (this.jdField_a_of_type_Bcpw.c()));
    this.jdField_a_of_type_Bcpw = bcpw.a(getContext(), 1, paramzai.toString(), 0);
    this.jdField_a_of_type_Bcpw.a();
    return;
    yxs.d("GdtFormView", "onError error");
  }
  
  public void b(zai paramzai)
  {
    boolean bool = true;
    a(false);
    a(paramzai);
    if ((paramzai != null) && (paramzai.jdField_a_of_type_Int == 1)) {}
    for (;;)
    {
      if (bool) {
        b();
      }
      a(bool, paramzai);
      return;
      bool = false;
    }
  }
  
  public void setListener(WeakReference<zak> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.GdtFormView
 * JD-Core Version:    0.7.0.1
 */