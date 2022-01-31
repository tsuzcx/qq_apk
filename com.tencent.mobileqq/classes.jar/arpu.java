import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class arpu
  implements arpp
{
  private aint jdField_a_of_type_Aint;
  private View jdField_a_of_type_AndroidViewView;
  private arpt jdField_a_of_type_Arpt;
  private arqb jdField_a_of_type_Arqb = new arpw(null);
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131369080);
    localView.setBackgroundResource(2130849220);
    LebaRoundLayout localLebaRoundLayout = (LebaRoundLayout)localView.findViewById(2131375528);
    localLebaRoundLayout.a = bbkx.b(16.0F);
    localLebaRoundLayout.setVisibility(8);
    localView.findViewById(2131365764).setBackgroundResource(2130849231);
    ((LinearLayout)paramView.findViewById(2131369455)).setVisibility(8);
    ((FrameLayout)paramView.findViewById(2131366322)).setVisibility(8);
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374123);
    bbkx.a(paramView, null);
    paramView.setBackgroundResource(2130839132);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    localObject = (LebaRoundLayout)paramView.findViewById(2131375526);
    ((LebaRoundLayout)localObject).a = bbkx.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369144);
    ((ImageView)localObject).setImageResource(2130844488);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bbkx.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = bbkx.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = bbkx.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131375341);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bbkx.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362793)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bbkx.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (bbkx.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369145)).getLayoutParams()).leftMargin = bbkx.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374329)).getLayoutParams()).leftMargin = bbkx.a(14.0F);
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
    if (this.jdField_a_of_type_Aint != null) {
      this.jdField_a_of_type_Aint.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aint != null) {
      this.jdField_a_of_type_Aint.a(paramInt);
    }
    if (this.jdField_a_of_type_Arqb != null) {
      this.jdField_a_of_type_Arqb.a();
    }
  }
  
  public void a(arpr paramarpr)
  {
    QLog.i("Q.lebatab.LebaListController", 1, "init list ");
    QQAppInterface localQQAppInterface = paramarpr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    List localList = paramarpr.jdField_a_of_type_JavaUtilList;
    Context localContext = paramarpr.jdField_a_of_type_AndroidContentContext;
    FPSXListView localFPSXListView = paramarpr.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramarpr.jdField_a_of_type_AndroidViewView;
    arpt localarpt = paramarpr.jdField_a_of_type_Arpt;
    this.jdField_a_of_type_AndroidViewView = paramarpr.jdField_a_of_type_AndroidViewView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "initView lebaSV == null ");
      return;
    }
    if (localarpt != null) {
      this.jdField_a_of_type_Arpt = localarpt;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() == null) {
        localFPSXListView.setOverscrollHeader(localContext.getResources().getDrawable(2130849133));
      }
      if (localView == null) {}
    }
    catch (Exception paramarpr)
    {
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
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Aint == null)
            {
              this.jdField_a_of_type_Aint = new aint(localContext, localList, 2131558984, 2131558985, localQQAppInterface, localFPSXListView, new arpv(this));
              localFPSXListView.setAdapter(this.jdField_a_of_type_Aint);
            }
            this.jdField_a_of_type_Aint.a(localQQAppInterface);
            this.jdField_a_of_type_Aint.a(localList);
            this.jdField_a_of_type_Aint.a(this.jdField_a_of_type_Arqb);
            return;
            paramarpr = paramarpr;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramarpr);
            continue;
            paramarpr = paramarpr;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramarpr);
          }
        }
        catch (Exception paramarpr)
        {
          for (;;)
          {
            QLog.i("Q.lebatab.LebaListController", 1, "setAdapter ", paramarpr);
          }
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      b(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_Aint != null) {
      this.jdField_a_of_type_Aint.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aint != null) {
      this.jdField_a_of_type_Aint.notifyDataSetChanged();
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arpu
 * JD-Core Version:    0.7.0.1
 */