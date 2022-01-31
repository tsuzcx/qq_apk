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

public class atlc
  implements atku
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private atlg jdField_a_of_type_Atlg = new atlf(null);
  private atll jdField_a_of_type_Atll;
  private atlm jdField_a_of_type_Atlm;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  private List<aozs> jdField_a_of_type_JavaUtilList;
  private float b;
  
  private void a(View paramView)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    int i;
    Object localObject2;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("2101".equals(localObject1)) || ("1103".equals(localObject1)) || ("2920".equals(localObject1)) || (azmk.a((String)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label177;
      }
      localObject1 = paramView.findViewById(2131369330);
      bdoo.a((View)localObject1, null);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376071);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = bdoo.b(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(2131376072);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label167;
      }
      ((View)localObject2).setBackgroundResource(2130849640);
      label128:
      bdoo.a(((View)localObject1).findViewById(2131365851), null);
    }
    for (;;)
    {
      paramView.findViewById(2131377399).setVisibility(0);
      ((FrameLayout)paramView.findViewById(2131366421)).setVisibility(0);
      return;
      i = 0;
      break;
      label167:
      ((View)localObject2).setBackgroundResource(2130849646);
      break label128;
      label177:
      localObject1 = paramView.findViewById(2131369330);
      ((View)localObject1).setBackgroundResource(2130849733);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376071);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = bdoo.b(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(8);
      ((View)localObject1).findViewById(2131365851).setBackgroundResource(2130849744);
    }
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374634);
    bdoo.a(paramView, null);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = bdoo.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = bdoo.a(16.0F);
    if (this.jdField_a_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = bdoo.a(72.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)paramView.findViewById(2131376069);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = bdoo.b(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = paramView.findViewById(2131376064);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label289;
      }
      ((View)localObject).setBackgroundResource(2130840284);
    }
    for (;;)
    {
      localObject = (ImageView)paramView.findViewById(2131369394);
      ((ImageView)localObject).setImageResource(2130844934);
      localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bdoo.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bdoo.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bdoo.a(12.0F);
      localObject = (RelativeLayout)paramView.findViewById(2131375881);
      ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bdoo.a(19.0F);
      localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362824)).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bdoo.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bdoo.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369395)).getLayoutParams()).leftMargin = bdoo.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374840)).getLayoutParams()).leftMargin = bdoo.a(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = bdoo.a(56.0F);
      break;
      label289:
      ((View)localObject).setBackgroundResource(2130839217);
    }
  }
  
  private void c(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131373640);
    bdoo.a(paramView, null);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = bdoo.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = bdoo.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = bdoo.a(12.0F);
    if (this.jdField_a_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = bdoo.a(72.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)paramView.findViewById(2131376069);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = bdoo.b(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = paramView.findViewById(2131376064);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label298;
      }
      ((View)localObject).setBackgroundResource(2130840284);
    }
    for (;;)
    {
      localObject = (ImageView)paramView.findViewById(2131369394);
      ((ImageView)localObject).setImageResource(2130844924);
      localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bdoo.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bdoo.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bdoo.a(12.0F);
      localObject = (RelativeLayout)paramView.findViewById(2131375881);
      ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bdoo.a(19.0F);
      localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362824)).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bdoo.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bdoo.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131373646)).getLayoutParams()).leftMargin = bdoo.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131373647)).getLayoutParams()).leftMargin = bdoo.a(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = bdoo.a(56.0F);
      break;
      label298:
      ((View)localObject).setBackgroundResource(2130839217);
    }
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        aonz localaonz = (aonz)aoks.a().a(614);
        if (localaonz == null)
        {
          QLog.i("Q.lebatab.LebaTabletController", 1, "configBean == null");
          return;
        }
        if (localaonz.jdField_a_of_type_Int == 1)
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
    if (this.jdField_a_of_type_Atlg != null) {
      return this.jdField_a_of_type_Atlg.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Atll != null) {
      this.jdField_a_of_type_Atll.c();
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
    if (this.jdField_a_of_type_Atlm != null) {
      this.jdField_a_of_type_Atlm.a(this.jdField_a_of_type_Float, this.b, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this.jdField_a_of_type_AndroidViewView, paramInt1, this.jdField_a_of_type_Int, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Atll != null) {
      this.jdField_a_of_type_Atll.b();
    }
    if (this.jdField_a_of_type_Atlg != null) {
      this.jdField_a_of_type_Atlg.a();
    }
  }
  
  public void a(atkw paramatkw)
  {
    QLog.i("Q.lebatab.LebaTabletController", 1, "init table");
    List localList = paramatkw.jdField_a_of_type_JavaUtilList;
    FPSXListView localFPSXListView = paramatkw.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramatkw.jdField_a_of_type_AndroidViewView;
    atky localatky = paramatkw.jdField_a_of_type_Atky;
    Context localContext = paramatkw.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramatkw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
      catch (Exception paramatkw)
      {
        for (;;)
        {
          label157:
          QLog.i("Q.lebatab.LebaTabletController", 1, "addHeaderView", paramatkw);
        }
      }
      try
      {
        paramatkw = localFPSXListView.getAdapter();
        if ((paramatkw == null) || (!(paramatkw instanceof atle))) {
          localFPSXListView.setAdapter(new atle());
        }
      }
      catch (Exception paramatkw)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setAdapter", paramatkw);
        break label157;
      }
      if (this.jdField_a_of_type_Atlm == null) {
        this.jdField_a_of_type_Atlm = new atlm(localContext);
      }
      if ((this.jdField_a_of_type_Atlm.jdField_a_of_type_AndroidWidgetLinearLayout == null) && (localView != null)) {
        this.jdField_a_of_type_Atlm.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131377399));
      }
      this.jdField_a_of_type_Atlm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_Atlm.jdField_a_of_type_Atlg = this.jdField_a_of_type_Atlg;
      this.jdField_a_of_type_Atlm.jdField_a_of_type_Atky = localatky;
      this.jdField_a_of_type_Atlm.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Atll == null) {
        this.jdField_a_of_type_Atll = new atll(localContext);
      }
      if ((this.jdField_a_of_type_Atll.a == null) && (localView != null)) {
        this.jdField_a_of_type_Atll.a = ((FrameLayout)localView.findViewById(2131366421));
      }
      this.jdField_a_of_type_Atll.c();
      return;
    }
    catch (Exception paramatkw)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", paramatkw);
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
    if (this.jdField_a_of_type_Atll != null) {
      this.jdField_a_of_type_Atll.c();
    }
    if (this.jdField_a_of_type_Atlm != null) {
      this.jdField_a_of_type_Atlm.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Atll != null)
    {
      this.jdField_a_of_type_Atll.a();
      this.jdField_a_of_type_Atll.a = null;
    }
    if (this.jdField_a_of_type_Atlm != null)
    {
      this.jdField_a_of_type_Atlm.a();
      this.jdField_a_of_type_Atlm.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atlc
 * JD-Core Version:    0.7.0.1
 */