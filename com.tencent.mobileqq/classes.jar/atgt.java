import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class atgt
  implements atgl
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private atgx jdField_a_of_type_Atgx = new atgw(null);
  private athc jdField_a_of_type_Athc;
  private athd jdField_a_of_type_Athd;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  private List<aovj> jdField_a_of_type_JavaUtilList;
  private float b;
  
  private void a(View paramView)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    int i;
    Object localObject2;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("2101".equals(localObject1)) || ("1103".equals(localObject1)) || ("2920".equals(localObject1)) || (azib.a((String)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label177;
      }
      localObject1 = paramView.findViewById(2131369312);
      bdkf.a((View)localObject1, null);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376018);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = bdkf.b(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(2131376019);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label167;
      }
      ((View)localObject2).setBackgroundResource(2130849567);
      label128:
      bdkf.a(((View)localObject1).findViewById(2131365849), null);
    }
    for (;;)
    {
      paramView.findViewById(2131377345).setVisibility(0);
      ((FrameLayout)paramView.findViewById(2131366419)).setVisibility(0);
      return;
      i = 0;
      break;
      label167:
      ((View)localObject2).setBackgroundResource(2130849573);
      break label128;
      label177:
      localObject1 = paramView.findViewById(2131369312);
      ((View)localObject1).setBackgroundResource(2130849660);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376018);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = bdkf.b(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(8);
      ((View)localObject1).findViewById(2131365849).setBackgroundResource(2130849671);
    }
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374583);
    bdkf.a(paramView, null);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = bdkf.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = bdkf.a(16.0F);
    if (this.jdField_a_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = bdkf.a(72.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)paramView.findViewById(2131376016);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = bdkf.b(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = paramView.findViewById(2131376011);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label289;
      }
      ((View)localObject).setBackgroundResource(2130840283);
    }
    for (;;)
    {
      localObject = (ImageView)paramView.findViewById(2131369376);
      ((ImageView)localObject).setImageResource(2130844862);
      localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bdkf.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bdkf.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bdkf.a(12.0F);
      localObject = (RelativeLayout)paramView.findViewById(2131375829);
      ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bdkf.a(19.0F);
      localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362824)).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bdkf.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bdkf.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369377)).getLayoutParams()).leftMargin = bdkf.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374789)).getLayoutParams()).leftMargin = bdkf.a(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = bdkf.a(56.0F);
      break;
      label289:
      ((View)localObject).setBackgroundResource(2130839216);
    }
  }
  
  private void c(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131373588);
    bdkf.a(paramView, null);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = bdkf.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = bdkf.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = bdkf.a(12.0F);
    if (this.jdField_a_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = bdkf.a(72.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)paramView.findViewById(2131376016);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = bdkf.b(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = paramView.findViewById(2131376011);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label298;
      }
      ((View)localObject).setBackgroundResource(2130840283);
    }
    for (;;)
    {
      localObject = (ImageView)paramView.findViewById(2131369376);
      ((ImageView)localObject).setImageResource(2130844852);
      localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bdkf.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bdkf.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bdkf.a(12.0F);
      localObject = (RelativeLayout)paramView.findViewById(2131375829);
      ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bdkf.a(19.0F);
      localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362824)).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bdkf.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bdkf.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131373594)).getLayoutParams()).leftMargin = bdkf.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131373596)).getLayoutParams()).leftMargin = bdkf.a(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = bdkf.a(56.0F);
      break;
      label298:
      ((View)localObject).setBackgroundResource(2130839216);
    }
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        aojq localaojq = (aojq)aogj.a().a(614);
        if (localaojq == null)
        {
          QLog.i("Q.lebatab.LebaTabletController", 1, "configBean == null");
          return;
        }
        if (localaojq.jdField_a_of_type_Int == 1)
        {
          i = 1;
          QLog.i("Q.lebatab.LebaTabletController", 1, "loadQzoneStyle " + i);
          if (i == this.jdField_a_of_type_Int) {
            break;
          }
          this.jdField_a_of_type_Int = i;
          if (this.jdField_a_of_type_AndroidViewView == null) {
            break;
          }
          b(this.jdField_a_of_type_AndroidViewView);
          c(this.jdField_a_of_type_AndroidViewView);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "loadQzoneStyle", localException);
        return;
      }
      int i = 0;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Atgx != null) {
      return this.jdField_a_of_type_Atgx.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Athc != null) {
      this.jdField_a_of_type_Athc.c();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Float = (-this.jdField_a_of_type_AndroidViewView.getY());
      this.b = this.jdField_a_of_type_Float;
    }
    e();
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Athd != null) {
      this.jdField_a_of_type_Athd.a(this.jdField_a_of_type_Float, this.b, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this.jdField_a_of_type_AndroidViewView, paramInt1, this.jdField_a_of_type_Int, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Athc != null) {
      this.jdField_a_of_type_Athc.b();
    }
    if (this.jdField_a_of_type_Atgx != null) {
      this.jdField_a_of_type_Atgx.a();
    }
  }
  
  public void a(atgn paramatgn)
  {
    QLog.i("Q.lebatab.LebaTabletController", 1, "init table");
    List localList = paramatgn.jdField_a_of_type_JavaUtilList;
    FPSXListView localFPSXListView = paramatgn.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramatgn.jdField_a_of_type_AndroidViewView;
    atgp localatgp = paramatgn.jdField_a_of_type_Atgp;
    Context localContext = paramatgn.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramatgn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = localList;
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = localFPSXListView;
    this.jdField_a_of_type_AndroidViewView = localView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaTabletController", 1, "initView lebaSV == null ");
      return;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() != null) {
        localFPSXListView.setOverscrollHeader(null);
      }
      e();
      if (localView != null) {}
      try
      {
        if (localFPSXListView.getHeaderViewsCount() <= 0) {
          localFPSXListView.addHeaderView(localView);
        }
        a(localView);
        b(localView);
        c(localView);
      }
      catch (Exception paramatgn)
      {
        for (;;)
        {
          label157:
          QLog.i("Q.lebatab.LebaTabletController", 1, "addHeaderView", paramatgn);
        }
      }
      try
      {
        paramatgn = localFPSXListView.getAdapter();
        if ((paramatgn == null) || (!(paramatgn instanceof atgv))) {
          localFPSXListView.setAdapter(new atgv());
        }
      }
      catch (Exception paramatgn)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setAdapter", paramatgn);
        break label157;
      }
      if (this.jdField_a_of_type_Athd == null) {
        this.jdField_a_of_type_Athd = new athd(localContext);
      }
      if ((this.jdField_a_of_type_Athd.jdField_a_of_type_AndroidWidgetLinearLayout == null) && (localView != null)) {
        this.jdField_a_of_type_Athd.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131377345));
      }
      this.jdField_a_of_type_Athd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_Athd.jdField_a_of_type_Atgx = this.jdField_a_of_type_Atgx;
      this.jdField_a_of_type_Athd.jdField_a_of_type_Atgp = localatgp;
      this.jdField_a_of_type_Athd.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Athc == null) {
        this.jdField_a_of_type_Athc = new athc(localContext);
      }
      if ((this.jdField_a_of_type_Athc.a == null) && (localView != null)) {
        this.jdField_a_of_type_Athc.a = ((FrameLayout)localView.findViewById(2131366419));
      }
      this.jdField_a_of_type_Athc.c();
      return;
    }
    catch (Exception paramatgn)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", paramatgn);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      float f = -this.jdField_a_of_type_AndroidViewView.getY();
      if (f > this.b) {
        this.b = f;
      }
      if (f < this.jdField_a_of_type_Float) {
        this.jdField_a_of_type_Float = f;
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      b(this.jdField_a_of_type_AndroidViewView);
      c(this.jdField_a_of_type_AndroidViewView);
    }
    c();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Athc != null) {
      this.jdField_a_of_type_Athc.c();
    }
    if (this.jdField_a_of_type_Athd != null) {
      this.jdField_a_of_type_Athd.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Athc != null)
    {
      this.jdField_a_of_type_Athc.a();
      this.jdField_a_of_type_Athc.a = null;
    }
    if (this.jdField_a_of_type_Athd != null)
    {
      this.jdField_a_of_type_Athd.a();
      this.jdField_a_of_type_Athd.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgt
 * JD-Core Version:    0.7.0.1
 */