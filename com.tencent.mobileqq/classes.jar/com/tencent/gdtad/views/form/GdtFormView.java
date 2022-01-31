package com.tencent.gdtad.views.form;

import ajya;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bcqf;
import bcql;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.form.framework.GdtFormTableView;
import com.tencent.gdtad.views.xijing.GdtButtonData;
import com.tencent.gdtad.views.xijing.GdtButtonView;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.lang.ref.WeakReference;
import yxp;
import zaf;
import zag;
import zah;
import zai;
import zaj;
import zak;
import zap;

public class GdtFormView
  extends LinearLayout
  implements zai, zak
{
  private int jdField_a_of_type_Int = -1;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new zag(this);
  private bcqf jdField_a_of_type_Bcqf;
  private bcql jdField_a_of_type_Bcql;
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private GdtFormData jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData;
  private GdtFormTableView jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView;
  private WeakReference<zah> jdField_a_of_type_JavaLangRefWeakReference;
  
  public GdtFormView(Context paramContext, GdtAd paramGdtAd, GdtFormData paramGdtFormData)
  {
    super(paramContext);
    a(paramContext, paramGdtAd, paramGdtFormData);
  }
  
  private void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData.isValid()))
    {
      yxp.d("GdtFormView", "initViews error");
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
      yxp.d("GdtFormView", "init error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    this.jdField_a_of_type_ComTencentGdtadViewsFormGdtFormData = paramGdtFormData;
    zap.a(new WeakReference(a()));
    a(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((a() == null) || (!a().isValid())) {
      yxp.d("GdtFormView", "showLoading error");
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing()));
      this.jdField_a_of_type_Bcqf = new bcqf(getContext(), getResources().getDimensionPixelSize(2131298865));
      this.jdField_a_of_type_Bcqf.setCancelable(false);
      this.jdField_a_of_type_Bcqf.a(ajya.a(2131705182) + a().button.text.text);
      this.jdField_a_of_type_Bcqf.show();
      return;
    } while ((paramBoolean) || (this.jdField_a_of_type_Bcqf == null));
    if (this.jdField_a_of_type_Bcqf.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      this.jdField_a_of_type_Bcqf = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        yxp.d("GdtFormView", "showLoading", localThrowable);
      }
    }
  }
  
  private void a(boolean paramBoolean, zaf paramzaf)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((zah)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramBoolean, paramzaf);
    }
  }
  
  private boolean a()
  {
    if ((a() == null) || (!a().isValid()))
    {
      yxp.d("GdtFormView", "validate error");
      return false;
    }
    zaf localzaf = a().validate();
    if (localzaf == null)
    {
      yxp.d("GdtFormView", "validate error");
      return false;
    }
    if (localzaf.jdField_a_of_type_Int == 2) {
      return true;
    }
    a(localzaf);
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView == null)
    {
      yxp.d("GdtFormView", "reset error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a();
  }
  
  private void c()
  {
    zaj.a(a(), a(), new WeakReference(this));
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
  
  public void a(zaf paramzaf)
  {
    if ((paramzaf == null) || (a() == null) || (!a().isValid())) {
      yxp.d("GdtFormView", "onError error");
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
              if (paramzaf.jdField_a_of_type_Int != 1) {
                break;
              }
              this.jdField_a_of_type_Int = -1;
              this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
            } while ((this.jdField_a_of_type_Bcql != null) && (this.jdField_a_of_type_Bcql.c()));
            this.jdField_a_of_type_Bcql = bcql.a(getContext(), 2, a().button.text.text + ajya.a(2131705181), 0);
            this.jdField_a_of_type_Bcql.a();
            return;
            if (paramzaf.jdField_a_of_type_Int != 4) {
              break;
            }
            this.jdField_a_of_type_Int = -1;
            this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
          } while ((this.jdField_a_of_type_Bcql != null) && (this.jdField_a_of_type_Bcql.c()));
          this.jdField_a_of_type_Bcql = bcql.a(getContext(), 1, a().button.text.text + ajya.a(2131705184), 0);
          this.jdField_a_of_type_Bcql.a();
          return;
          if (paramzaf.jdField_a_of_type_Int != 7) {
            break;
          }
          this.jdField_a_of_type_Int = -1;
          this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
        } while ((this.jdField_a_of_type_Bcql != null) && (this.jdField_a_of_type_Bcql.c()));
        this.jdField_a_of_type_Bcql = bcql.a(getContext(), 1, ajya.a(2131705183), 0);
        this.jdField_a_of_type_Bcql.a();
        return;
        if (paramzaf.jdField_a_of_type_Int != 2) {
          break;
        }
      } while ((paramzaf.b != -1) && (paramzaf.b != this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(-1);
      return;
      if ((paramzaf.b == -1) || (TextUtils.isEmpty(paramzaf.toString()))) {
        break;
      }
      this.jdField_a_of_type_Int = paramzaf.b;
      this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableView.a(this.jdField_a_of_type_Int);
    } while ((this.jdField_a_of_type_Bcql != null) && (this.jdField_a_of_type_Bcql.c()));
    this.jdField_a_of_type_Bcql = bcql.a(getContext(), 1, paramzaf.toString(), 0);
    this.jdField_a_of_type_Bcql.a();
    return;
    yxp.d("GdtFormView", "onError error");
  }
  
  public void b(zaf paramzaf)
  {
    boolean bool = true;
    a(false);
    a(paramzaf);
    if ((paramzaf != null) && (paramzaf.jdField_a_of_type_Int == 1)) {}
    for (;;)
    {
      if (bool) {
        b();
      }
      a(bool, paramzaf);
      return;
      bool = false;
    }
  }
  
  public void setListener(WeakReference<zah> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.GdtFormView
 * JD-Core Version:    0.7.0.1
 */