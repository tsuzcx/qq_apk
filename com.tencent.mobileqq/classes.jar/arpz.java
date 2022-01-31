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

public class arpz
  implements arpr
{
  private float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private arqd jdField_a_of_type_Arqd = new arqc(null);
  private arqh jdField_a_of_type_Arqh;
  private arqi jdField_a_of_type_Arqi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  private List<anec> jdField_a_of_type_JavaUtilList;
  private float b;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131369080);
    bbll.a(localView, null);
    Object localObject = (LebaRoundLayout)localView.findViewById(2131375530);
    ((LebaRoundLayout)localObject).a = bbll.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(0);
    localObject = localView.findViewById(2131375531);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      ((View)localObject).setBackgroundResource(2130849136);
    }
    for (;;)
    {
      bbll.a(localView.findViewById(2131365763), null);
      ((LinearLayout)paramView.findViewById(2131369454)).setVisibility(0);
      ((FrameLayout)paramView.findViewById(2131366322)).setVisibility(0);
      return;
      ((View)localObject).setBackgroundResource(2130849142);
    }
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374125);
    bbll.a(paramView, null);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = bbll.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = bbll.a(16.0F);
    localObject = (LebaRoundLayout)paramView.findViewById(2131375528);
    ((LebaRoundLayout)localObject).a = bbll.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(0);
    localObject = paramView.findViewById(2131375523);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      ((View)localObject).setBackgroundResource(2130840180);
    }
    for (;;)
    {
      localObject = (ImageView)paramView.findViewById(2131369144);
      ((ImageView)localObject).setImageResource(2130844498);
      localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bbll.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bbll.b(32.0F);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = bbll.a(12.0F);
      localObject = (RelativeLayout)paramView.findViewById(2131375343);
      ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bbll.a(19.0F);
      localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362792)).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = bbll.a(9.0F);
      ((RelativeLayout.LayoutParams)localObject).height = bbll.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369145)).getLayoutParams()).leftMargin = bbll.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374331)).getLayoutParams()).leftMargin = bbll.a(4.0F);
      return;
      ((View)localObject).setBackgroundResource(2130839132);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Arqd != null) {
      return this.jdField_a_of_type_Arqd.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arqh != null) {
      this.jdField_a_of_type_Arqh.c();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Float = (-this.jdField_a_of_type_AndroidViewView.getY());
      this.b = this.jdField_a_of_type_Float;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Arqi != null) {
      this.jdField_a_of_type_Arqi.a(this.jdField_a_of_type_Float, this.b, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this.jdField_a_of_type_AndroidViewView, paramInt);
    }
    if (this.jdField_a_of_type_Arqh != null) {
      this.jdField_a_of_type_Arqh.b();
    }
    if (this.jdField_a_of_type_Arqd != null) {
      this.jdField_a_of_type_Arqd.a();
    }
  }
  
  public void a(arpt paramarpt)
  {
    QLog.i("Q.lebatab.LebaTabletController", 1, "init table");
    List localList = paramarpt.jdField_a_of_type_JavaUtilList;
    FPSXListView localFPSXListView = paramarpt.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramarpt.jdField_a_of_type_AndroidViewView;
    arpv localarpv = paramarpt.jdField_a_of_type_Arpv;
    Context localContext = paramarpt.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramarpt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
      catch (Exception paramarpt)
      {
        for (;;)
        {
          label146:
          QLog.i("Q.lebatab.LebaTabletController", 1, "addHeaderView", paramarpt);
        }
      }
      try
      {
        paramarpt = localFPSXListView.getAdapter();
        if ((paramarpt == null) || (!(paramarpt instanceof arqb))) {
          localFPSXListView.setAdapter(new arqb());
        }
      }
      catch (Exception paramarpt)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setAdapter", paramarpt);
        break label146;
      }
      if (this.jdField_a_of_type_Arqi == null) {
        this.jdField_a_of_type_Arqi = new arqi(localContext);
      }
      if ((this.jdField_a_of_type_Arqi.jdField_a_of_type_AndroidWidgetLinearLayout == null) && (localView != null)) {
        this.jdField_a_of_type_Arqi.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131369454));
      }
      this.jdField_a_of_type_Arqi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_Arqi.jdField_a_of_type_Arqd = this.jdField_a_of_type_Arqd;
      this.jdField_a_of_type_Arqi.jdField_a_of_type_Arpv = localarpv;
      this.jdField_a_of_type_Arqi.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Arqh == null) {
        this.jdField_a_of_type_Arqh = new arqh(localContext);
      }
      if ((this.jdField_a_of_type_Arqh.a == null) && (localView != null)) {
        this.jdField_a_of_type_Arqh.a = ((FrameLayout)localView.findViewById(2131366322));
      }
      this.jdField_a_of_type_Arqh.c();
      return;
    }
    catch (Exception paramarpt)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", paramarpt);
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
    if (this.jdField_a_of_type_Arqh != null) {
      this.jdField_a_of_type_Arqh.c();
    }
    if (this.jdField_a_of_type_Arqi != null) {
      this.jdField_a_of_type_Arqi.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Arqh != null)
    {
      this.jdField_a_of_type_Arqh.a();
      this.jdField_a_of_type_Arqh.a = null;
    }
    if (this.jdField_a_of_type_Arqi != null)
    {
      this.jdField_a_of_type_Arqi.a();
      this.jdField_a_of_type_Arqi.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arpz
 * JD-Core Version:    0.7.0.1
 */