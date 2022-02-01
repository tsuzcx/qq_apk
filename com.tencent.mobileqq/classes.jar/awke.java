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

public class awke
  implements awkc
{
  private ampd jdField_a_of_type_Ampd;
  private View jdField_a_of_type_AndroidViewView;
  private awkd jdField_a_of_type_Awkd;
  private awkl jdField_a_of_type_Awkl = new awkg(null);
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131369816);
    localView.setBackgroundResource(2130850331);
    LebaRoundLayout localLebaRoundLayout = (LebaRoundLayout)localView.findViewById(2131376964);
    localLebaRoundLayout.a = bhtq.b(16.0F);
    localLebaRoundLayout.setVisibility(8);
    localView.findViewById(2131366151).setBackgroundResource(2130850342);
    paramView.findViewById(2131378380).setVisibility(8);
    ((FrameLayout)paramView.findViewById(2131366723)).setVisibility(8);
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131375492);
    bhtq.a(paramView, null);
    paramView.setBackgroundResource(2130839402);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).height = bhtq.a(56.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LebaRoundLayout)paramView.findViewById(2131376962);
    ((LebaRoundLayout)localObject).a = bhtq.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369885);
    ((ImageView)localObject).setImageResource(2130845335);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bhtq.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = bhtq.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = bhtq.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131376751);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bhtq.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362955)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bhtq.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (bhtq.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369886)).getLayoutParams()).leftMargin = bhtq.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131375706)).getLayoutParams()).leftMargin = bhtq.a(14.0F);
  }
  
  private void c(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374480);
    bhtq.a(paramView, null);
    paramView.setBackgroundResource(2130839402);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    localObject = (LebaRoundLayout)paramView.findViewById(2131376962);
    ((LebaRoundLayout)localObject).a = bhtq.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369885);
    ((ImageView)localObject).setImageResource(2130845339);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bhtq.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = bhtq.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = bhtq.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131376751);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bhtq.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362955)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bhtq.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (bhtq.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374485)).getLayoutParams()).leftMargin = bhtq.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374486)).getLayoutParams()).leftMargin = bhtq.a(14.0F);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Awkl != null) {
      return this.jdField_a_of_type_Awkl.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ampd != null) {
      this.jdField_a_of_type_Ampd.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Ampd != null) {
      this.jdField_a_of_type_Ampd.a(paramInt1, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Awkl != null) {
      this.jdField_a_of_type_Awkl.a();
    }
  }
  
  public void a(akgn paramakgn)
  {
    QLog.i("Q.lebatab.LebaListController", 1, "init list ");
    QQAppInterface localQQAppInterface = paramakgn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    List localList = paramakgn.jdField_a_of_type_JavaUtilList;
    Context localContext = paramakgn.jdField_a_of_type_AndroidContentContext;
    FPSXListView localFPSXListView = paramakgn.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramakgn.jdField_a_of_type_AndroidViewView;
    awkd localawkd = paramakgn.jdField_a_of_type_Awkd;
    this.jdField_a_of_type_AndroidViewView = paramakgn.jdField_a_of_type_AndroidViewView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "initView lebaSV == null ");
      return;
    }
    if (localawkd != null) {
      this.jdField_a_of_type_Awkd = localawkd;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() == null) {
        localFPSXListView.setOverscrollHeader(localContext.getResources().getDrawable(2130850234));
      }
      if (localView == null) {}
    }
    catch (Exception paramakgn)
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
      catch (Exception paramakgn)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Ampd == null)
            {
              this.jdField_a_of_type_Ampd = new ampd(localContext, localList, 2131559089, 2131559090, localQQAppInterface, localFPSXListView, new awkf(this));
              localFPSXListView.setAdapter(this.jdField_a_of_type_Ampd);
            }
            this.jdField_a_of_type_Ampd.a(localQQAppInterface);
            this.jdField_a_of_type_Ampd.a(localList);
            this.jdField_a_of_type_Ampd.a(this.jdField_a_of_type_Awkl);
            return;
            paramakgn = paramakgn;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramakgn);
            continue;
            paramakgn = paramakgn;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramakgn);
          }
        }
        catch (Exception paramakgn)
        {
          for (;;)
          {
            QLog.i("Q.lebatab.LebaListController", 1, "setAdapter ", paramakgn);
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
    if (this.jdField_a_of_type_Ampd != null) {
      this.jdField_a_of_type_Ampd.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ampd != null) {
      this.jdField_a_of_type_Ampd.notifyDataSetChanged();
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awke
 * JD-Core Version:    0.7.0.1
 */