import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class avrn
  implements avrl
{
  private amdj jdField_a_of_type_Amdj;
  private View jdField_a_of_type_AndroidViewView;
  private avrm jdField_a_of_type_Avrm;
  private avru jdField_a_of_type_Avru = new avrp(null);
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131369721);
    localView.setBackgroundResource(2130850319);
    LebaRoundLayout localLebaRoundLayout = (LebaRoundLayout)localView.findViewById(2131376827);
    localLebaRoundLayout.a = bgtn.b(16.0F);
    localLebaRoundLayout.setVisibility(8);
    localView.findViewById(2131366102).setBackgroundResource(2130850330);
    paramView.findViewById(2131378223).setVisibility(8);
    ((FrameLayout)paramView.findViewById(2131366673)).setVisibility(8);
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131375355);
    bgtn.a(paramView, null);
    paramView.setBackgroundResource(2130839394);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).height = bgtn.a(56.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LebaRoundLayout)paramView.findViewById(2131376825);
    ((LebaRoundLayout)localObject).a = bgtn.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369787);
    ((ImageView)localObject).setImageResource(2130845320);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bgtn.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = bgtn.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = bgtn.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131376618);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bgtn.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362937)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bgtn.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (bgtn.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369788)).getLayoutParams()).leftMargin = bgtn.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131375566)).getLayoutParams()).leftMargin = bgtn.a(14.0F);
  }
  
  private void c(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374344);
    bgtn.a(paramView, null);
    paramView.setBackgroundResource(2130839394);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    localObject = (LebaRoundLayout)paramView.findViewById(2131376825);
    ((LebaRoundLayout)localObject).a = bgtn.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369787);
    ((ImageView)localObject).setImageResource(2130845324);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bgtn.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = bgtn.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = bgtn.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131376618);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bgtn.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362937)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bgtn.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (bgtn.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374349)).getLayoutParams()).leftMargin = bgtn.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374350)).getLayoutParams()).leftMargin = bgtn.a(14.0F);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Avru != null) {
      return this.jdField_a_of_type_Avru.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Amdj != null) {
      this.jdField_a_of_type_Amdj.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Amdj != null) {
      this.jdField_a_of_type_Amdj.a(paramInt1, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Avru != null) {
      this.jdField_a_of_type_Avru.a();
    }
  }
  
  public void a(ajve paramajve)
  {
    QLog.i("Q.lebatab.LebaListController", 1, "init list ");
    QQAppInterface localQQAppInterface = paramajve.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    List localList = paramajve.jdField_a_of_type_JavaUtilList;
    Context localContext = paramajve.jdField_a_of_type_AndroidContentContext;
    FPSXListView localFPSXListView = paramajve.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramajve.jdField_a_of_type_AndroidViewView;
    avrm localavrm = paramajve.jdField_a_of_type_Avrm;
    this.jdField_a_of_type_AndroidViewView = paramajve.jdField_a_of_type_AndroidViewView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "initView lebaSV == null ");
      return;
    }
    if (localavrm != null) {
      this.jdField_a_of_type_Avrm = localavrm;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() == null) {
        localFPSXListView.setOverscrollHeader(localContext.getResources().getDrawable(2130850222));
      }
      if (localView == null) {}
    }
    catch (Exception paramajve)
    {
      try
      {
        if (localFPSXListView.getHeaderViewsCount() <= 0) {
          localFPSXListView.addHeaderView(localView);
        }
        a(localView);
        b(localView);
        c(localView);
      }
      catch (Exception paramajve)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Amdj == null)
            {
              this.jdField_a_of_type_Amdj = new amdj(localContext, localList, 2131559089, 2131559090, localQQAppInterface, localFPSXListView, new avro(this));
              localFPSXListView.setAdapter(this.jdField_a_of_type_Amdj);
            }
            this.jdField_a_of_type_Amdj.a(localQQAppInterface);
            this.jdField_a_of_type_Amdj.a(localList);
            this.jdField_a_of_type_Amdj.a(this.jdField_a_of_type_Avru);
            return;
            paramajve = paramajve;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramajve);
            continue;
            paramajve = paramajve;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramajve);
          }
        }
        catch (Exception paramajve)
        {
          for (;;)
          {
            QLog.i("Q.lebatab.LebaListController", 1, "setAdapter ", paramajve);
          }
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public int b()
  {
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      b(this.jdField_a_of_type_AndroidViewView);
      c(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_Amdj != null) {
      this.jdField_a_of_type_Amdj.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Amdj != null) {
      this.jdField_a_of_type_Amdj.notifyDataSetChanged();
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrn
 * JD-Core Version:    0.7.0.1
 */