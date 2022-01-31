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

public class atgq
  implements atgl
{
  private akfc jdField_a_of_type_Akfc;
  private View jdField_a_of_type_AndroidViewView;
  private atgp jdField_a_of_type_Atgp;
  private atgx jdField_a_of_type_Atgx = new atgs(null);
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131369312);
    localView.setBackgroundResource(2130849660);
    LebaRoundLayout localLebaRoundLayout = (LebaRoundLayout)localView.findViewById(2131376018);
    localLebaRoundLayout.a = bdkf.b(16.0F);
    localLebaRoundLayout.setVisibility(8);
    localView.findViewById(2131365849).setBackgroundResource(2130849671);
    paramView.findViewById(2131377345).setVisibility(8);
    ((FrameLayout)paramView.findViewById(2131366419)).setVisibility(8);
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374583);
    bdkf.a(paramView, null);
    paramView.setBackgroundResource(2130839216);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).height = bdkf.a(56.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LebaRoundLayout)paramView.findViewById(2131376016);
    ((LebaRoundLayout)localObject).a = bdkf.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369376);
    ((ImageView)localObject).setImageResource(2130844851);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bdkf.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = bdkf.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = bdkf.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131375829);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bdkf.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362824)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bdkf.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (bdkf.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369377)).getLayoutParams()).leftMargin = bdkf.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374789)).getLayoutParams()).leftMargin = bdkf.a(14.0F);
  }
  
  private void c(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131373588);
    bdkf.a(paramView, null);
    paramView.setBackgroundResource(2130839216);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    localObject = (LebaRoundLayout)paramView.findViewById(2131376016);
    ((LebaRoundLayout)localObject).a = bdkf.b(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369376);
    ((ImageView)localObject).setImageResource(2130844853);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bdkf.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = bdkf.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = bdkf.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131375829);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = bdkf.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362824)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = bdkf.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (bdkf.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131373594)).getLayoutParams()).leftMargin = bdkf.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131373596)).getLayoutParams()).leftMargin = bdkf.a(14.0F);
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
    if (this.jdField_a_of_type_Akfc != null) {
      this.jdField_a_of_type_Akfc.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Akfc != null) {
      this.jdField_a_of_type_Akfc.a(paramInt1, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Atgx != null) {
      this.jdField_a_of_type_Atgx.a();
    }
  }
  
  public void a(atgn paramatgn)
  {
    QLog.i("Q.lebatab.LebaListController", 1, "init list ");
    QQAppInterface localQQAppInterface = paramatgn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    List localList = paramatgn.jdField_a_of_type_JavaUtilList;
    Context localContext = paramatgn.jdField_a_of_type_AndroidContentContext;
    FPSXListView localFPSXListView = paramatgn.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramatgn.jdField_a_of_type_AndroidViewView;
    atgp localatgp = paramatgn.jdField_a_of_type_Atgp;
    this.jdField_a_of_type_AndroidViewView = paramatgn.jdField_a_of_type_AndroidViewView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "initView lebaSV == null ");
      return;
    }
    if (localatgp != null) {
      this.jdField_a_of_type_Atgp = localatgp;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() == null) {
        localFPSXListView.setOverscrollHeader(localContext.getResources().getDrawable(2130849573));
      }
      if (localView == null) {}
    }
    catch (Exception paramatgn)
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
      catch (Exception paramatgn)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Akfc == null)
            {
              this.jdField_a_of_type_Akfc = new akfc(localContext, localList, 2131559022, 2131559023, localQQAppInterface, localFPSXListView, new atgr(this));
              localFPSXListView.setAdapter(this.jdField_a_of_type_Akfc);
            }
            this.jdField_a_of_type_Akfc.a(localQQAppInterface);
            this.jdField_a_of_type_Akfc.a(localList);
            this.jdField_a_of_type_Akfc.a(this.jdField_a_of_type_Atgx);
            return;
            paramatgn = paramatgn;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramatgn);
            continue;
            paramatgn = paramatgn;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramatgn);
          }
        }
        catch (Exception paramatgn)
        {
          for (;;)
          {
            QLog.i("Q.lebatab.LebaListController", 1, "setAdapter ", paramatgn);
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
    if (this.jdField_a_of_type_Akfc != null) {
      this.jdField_a_of_type_Akfc.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Akfc != null) {
      this.jdField_a_of_type_Akfc.notifyDataSetChanged();
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgq
 * JD-Core Version:    0.7.0.1
 */