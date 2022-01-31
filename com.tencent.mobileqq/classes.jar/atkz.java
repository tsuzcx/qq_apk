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

public class atkz
  implements atku
{
  private akjr jdField_a_of_type_Akjr;
  private View jdField_a_of_type_AndroidViewView;
  private atky jdField_a_of_type_Atky;
  private atlg jdField_a_of_type_Atlg = new atlb(null);
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131369330);
    localView.setBackgroundResource(2130849733);
    LebaRoundLayout localLebaRoundLayout = (LebaRoundLayout)localView.findViewById(2131376071);
    localLebaRoundLayout.a = bdoo.b(16.0F);
    localLebaRoundLayout.setVisibility(8);
    localView.findViewById(2131365851).setBackgroundResource(2130849744);
    paramView.findViewById(2131377399).setVisibility(8);
    ((FrameLayout)paramView.findViewById(2131366421)).setVisibility(8);
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374634);
    bdoo.a(paramView, null);
    paramView.setBackgroundResource(2130839217);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).height = bdoo.a(56.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LebaRoundLayout)paramView.findViewById(2131376069);
    ((LebaRoundLayout)localObject).a = bdoo.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369394);
    ((ImageView)localObject).setImageResource(2130844923);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bdoo.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = bdoo.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = bdoo.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131375881);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bdoo.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362824)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bdoo.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (bdoo.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369395)).getLayoutParams()).leftMargin = bdoo.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374840)).getLayoutParams()).leftMargin = bdoo.a(14.0F);
  }
  
  private void c(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131373640);
    bdoo.a(paramView, null);
    paramView.setBackgroundResource(2130839217);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    localObject = (LebaRoundLayout)paramView.findViewById(2131376069);
    ((LebaRoundLayout)localObject).a = bdoo.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369394);
    ((ImageView)localObject).setImageResource(2130844925);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bdoo.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = bdoo.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = bdoo.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131375881);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bdoo.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362824)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bdoo.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (bdoo.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131373646)).getLayoutParams()).leftMargin = bdoo.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131373647)).getLayoutParams()).leftMargin = bdoo.a(14.0F);
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
    if (this.jdField_a_of_type_Akjr != null) {
      this.jdField_a_of_type_Akjr.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Akjr != null) {
      this.jdField_a_of_type_Akjr.a(paramInt1, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Atlg != null) {
      this.jdField_a_of_type_Atlg.a();
    }
  }
  
  public void a(atkw paramatkw)
  {
    QLog.i("Q.lebatab.LebaListController", 1, "init list ");
    QQAppInterface localQQAppInterface = paramatkw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    List localList = paramatkw.jdField_a_of_type_JavaUtilList;
    Context localContext = paramatkw.jdField_a_of_type_AndroidContentContext;
    FPSXListView localFPSXListView = paramatkw.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramatkw.jdField_a_of_type_AndroidViewView;
    atky localatky = paramatkw.jdField_a_of_type_Atky;
    this.jdField_a_of_type_AndroidViewView = paramatkw.jdField_a_of_type_AndroidViewView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "initView lebaSV == null ");
      return;
    }
    if (localatky != null) {
      this.jdField_a_of_type_Atky = localatky;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() == null) {
        localFPSXListView.setOverscrollHeader(localContext.getResources().getDrawable(2130849646));
      }
      if (localView == null) {}
    }
    catch (Exception paramatkw)
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
      catch (Exception paramatkw)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Akjr == null)
            {
              this.jdField_a_of_type_Akjr = new akjr(localContext, localList, 2131559021, 2131559022, localQQAppInterface, localFPSXListView, new atla(this));
              localFPSXListView.setAdapter(this.jdField_a_of_type_Akjr);
            }
            this.jdField_a_of_type_Akjr.a(localQQAppInterface);
            this.jdField_a_of_type_Akjr.a(localList);
            this.jdField_a_of_type_Akjr.a(this.jdField_a_of_type_Atlg);
            return;
            paramatkw = paramatkw;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramatkw);
            continue;
            paramatkw = paramatkw;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramatkw);
          }
        }
        catch (Exception paramatkw)
        {
          for (;;)
          {
            QLog.i("Q.lebatab.LebaListController", 1, "setAdapter ", paramatkw);
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
    if (this.jdField_a_of_type_Akjr != null) {
      this.jdField_a_of_type_Akjr.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Akjr != null) {
      this.jdField_a_of_type_Akjr.notifyDataSetChanged();
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkz
 * JD-Core Version:    0.7.0.1
 */