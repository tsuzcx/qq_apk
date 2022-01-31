import android.content.Context;
import android.view.View;
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

public class arpx
  implements arpp
{
  private float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private arqb jdField_a_of_type_Arqb = new arqa(null);
  private arqf jdField_a_of_type_Arqf;
  private arqg jdField_a_of_type_Arqg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  private List<andx> jdField_a_of_type_JavaUtilList;
  private float b;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131369080);
    bbkx.a(localView, null);
    Object localObject = (LebaRoundLayout)localView.findViewById(2131375528);
    ((LebaRoundLayout)localObject).a = bbkx.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(0);
    localObject = localView.findViewById(2131375529);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      ((View)localObject).setBackgroundResource(2130849127);
    }
    for (;;)
    {
      bbkx.a(localView.findViewById(2131365764), null);
      ((LinearLayout)paramView.findViewById(2131369455)).setVisibility(0);
      ((FrameLayout)paramView.findViewById(2131366322)).setVisibility(0);
      return;
      ((View)localObject).setBackgroundResource(2130849133);
    }
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374123);
    bbkx.a(paramView, null);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = bbkx.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = bbkx.a(16.0F);
    localObject = (LebaRoundLayout)paramView.findViewById(2131375526);
    ((LebaRoundLayout)localObject).a = bbkx.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(0);
    localObject = paramView.findViewById(2131375521);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      ((View)localObject).setBackgroundResource(2130840183);
    }
    for (;;)
    {
      localObject = (ImageView)paramView.findViewById(2131369144);
      ((ImageView)localObject).setImageResource(2130844497);
      localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bbkx.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bbkx.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bbkx.a(12.0F);
      localObject = (RelativeLayout)paramView.findViewById(2131375341);
      ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bbkx.a(19.0F);
      localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362793)).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bbkx.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bbkx.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369145)).getLayoutParams()).leftMargin = bbkx.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374329)).getLayoutParams()).leftMargin = bbkx.a(4.0F);
      return;
      ((View)localObject).setBackgroundResource(2130839132);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Arqb != null) {
      return this.jdField_a_of_type_Arqb.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arqf != null) {
      this.jdField_a_of_type_Arqf.c();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Float = (-this.jdField_a_of_type_AndroidViewView.getY());
      this.b = this.jdField_a_of_type_Float;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Arqg != null) {
      this.jdField_a_of_type_Arqg.a(this.jdField_a_of_type_Float, this.b, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this.jdField_a_of_type_AndroidViewView, paramInt);
    }
    if (this.jdField_a_of_type_Arqf != null) {
      this.jdField_a_of_type_Arqf.b();
    }
    if (this.jdField_a_of_type_Arqb != null) {
      this.jdField_a_of_type_Arqb.a();
    }
  }
  
  public void a(arpr paramarpr)
  {
    QLog.i("Q.lebatab.LebaTabletController", 1, "init table");
    List localList = paramarpr.jdField_a_of_type_JavaUtilList;
    FPSXListView localFPSXListView = paramarpr.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramarpr.jdField_a_of_type_AndroidViewView;
    arpt localarpt = paramarpr.jdField_a_of_type_Arpt;
    Context localContext = paramarpr.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramarpr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
      if (localView != null) {}
      try
      {
        if (localFPSXListView.getHeaderViewsCount() <= 0) {
          localFPSXListView.addHeaderView(localView);
        }
        a(localView);
        b(localView);
      }
      catch (Exception paramarpr)
      {
        for (;;)
        {
          label146:
          QLog.i("Q.lebatab.LebaTabletController", 1, "addHeaderView", paramarpr);
        }
      }
      try
      {
        paramarpr = localFPSXListView.getAdapter();
        if ((paramarpr == null) || (!(paramarpr instanceof arpz))) {
          localFPSXListView.setAdapter(new arpz());
        }
      }
      catch (Exception paramarpr)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setAdapter", paramarpr);
        break label146;
      }
      if (this.jdField_a_of_type_Arqg == null) {
        this.jdField_a_of_type_Arqg = new arqg(localContext);
      }
      if ((this.jdField_a_of_type_Arqg.jdField_a_of_type_AndroidWidgetLinearLayout == null) && (localView != null)) {
        this.jdField_a_of_type_Arqg.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131369455));
      }
      this.jdField_a_of_type_Arqg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_Arqg.jdField_a_of_type_Arqb = this.jdField_a_of_type_Arqb;
      this.jdField_a_of_type_Arqg.jdField_a_of_type_Arpt = localarpt;
      this.jdField_a_of_type_Arqg.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Arqf == null) {
        this.jdField_a_of_type_Arqf = new arqf(localContext);
      }
      if ((this.jdField_a_of_type_Arqf.a == null) && (localView != null)) {
        this.jdField_a_of_type_Arqf.a = ((FrameLayout)localView.findViewById(2131366322));
      }
      this.jdField_a_of_type_Arqf.c();
      return;
    }
    catch (Exception paramarpr)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", paramarpr);
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
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      b(this.jdField_a_of_type_AndroidViewView);
    }
    c();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Arqf != null) {
      this.jdField_a_of_type_Arqf.c();
    }
    if (this.jdField_a_of_type_Arqg != null) {
      this.jdField_a_of_type_Arqg.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Arqf != null)
    {
      this.jdField_a_of_type_Arqf.a();
      this.jdField_a_of_type_Arqf.a = null;
    }
    if (this.jdField_a_of_type_Arqg != null)
    {
      this.jdField_a_of_type_Arqg.a();
      this.jdField_a_of_type_Arqg.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arpx
 * JD-Core Version:    0.7.0.1
 */