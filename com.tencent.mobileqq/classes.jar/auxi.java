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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class auxi
  implements auxg
{
  private aljx jdField_a_of_type_Aljx;
  private View jdField_a_of_type_AndroidViewView;
  private auxh jdField_a_of_type_Auxh;
  private auxp jdField_a_of_type_Auxp = new auxk(null);
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131369805);
    localView.setBackgroundResource(2130850252);
    LebaRoundLayout localLebaRoundLayout = (LebaRoundLayout)localView.findViewById(2131376718);
    localLebaRoundLayout.a = ViewUtils.dpToPx(16.0F);
    localLebaRoundLayout.setVisibility(8);
    localView.findViewById(2131366179).setBackgroundResource(2130850263);
    paramView.findViewById(2131378147).setVisibility(8);
    ((FrameLayout)paramView.findViewById(2131366753)).setVisibility(8);
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131375260);
    ViewUtils.setViewBackground(paramView, null);
    paramView.setBackgroundResource(2130839437);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(56.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LebaRoundLayout)paramView.findViewById(2131376716);
    ((LebaRoundLayout)localObject).a = ViewUtils.dpToPx(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369879);
    ((ImageView)localObject).setImageResource(2130845214);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131376522);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = ViewUtils.dip2px(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362969)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.dip2px(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (ViewUtils.dip2px(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369880)).getLayoutParams()).leftMargin = ViewUtils.dip2px(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131375474)).getLayoutParams()).leftMargin = ViewUtils.dip2px(14.0F);
  }
  
  private void c(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374248);
    ViewUtils.setViewBackground(paramView, null);
    paramView.setBackgroundResource(2130839437);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    localObject = (LebaRoundLayout)paramView.findViewById(2131376716);
    ((LebaRoundLayout)localObject).a = ViewUtils.dpToPx(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369879);
    ((ImageView)localObject).setImageResource(2130845218);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131376522);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = ViewUtils.dip2px(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362969)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.dip2px(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (ViewUtils.dip2px(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374253)).getLayoutParams()).leftMargin = ViewUtils.dip2px(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374254)).getLayoutParams()).leftMargin = ViewUtils.dip2px(14.0F);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Auxp != null) {
      return this.jdField_a_of_type_Auxp.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aljx != null) {
      this.jdField_a_of_type_Aljx.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Aljx != null) {
      this.jdField_a_of_type_Aljx.a(paramInt1, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Auxp != null) {
      this.jdField_a_of_type_Auxp.a();
    }
  }
  
  public void a(ajeg paramajeg)
  {
    QLog.i("Q.lebatab.LebaListController", 1, "init list ");
    QQAppInterface localQQAppInterface = paramajeg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    List localList = paramajeg.jdField_a_of_type_JavaUtilList;
    Context localContext = paramajeg.jdField_a_of_type_AndroidContentContext;
    FPSXListView localFPSXListView = paramajeg.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramajeg.jdField_a_of_type_AndroidViewView;
    auxh localauxh = paramajeg.jdField_a_of_type_Auxh;
    this.jdField_a_of_type_AndroidViewView = paramajeg.jdField_a_of_type_AndroidViewView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "initView lebaSV == null ");
      return;
    }
    if (localauxh != null) {
      this.jdField_a_of_type_Auxh = localauxh;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() == null) {
        localFPSXListView.setOverscrollHeader(localContext.getResources().getDrawable(2130850155));
      }
      if (localView == null) {}
    }
    catch (Exception paramajeg)
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
      catch (Exception paramajeg)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Aljx == null)
            {
              this.jdField_a_of_type_Aljx = new aljx(localContext, localList, 2131559097, 2131559098, localQQAppInterface, localFPSXListView, new auxj(this));
              localFPSXListView.setAdapter(this.jdField_a_of_type_Aljx);
            }
            this.jdField_a_of_type_Aljx.a(localQQAppInterface);
            this.jdField_a_of_type_Aljx.a(localList);
            this.jdField_a_of_type_Aljx.a(this.jdField_a_of_type_Auxp);
            return;
            paramajeg = paramajeg;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramajeg);
            continue;
            paramajeg = paramajeg;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramajeg);
          }
        }
        catch (Exception paramajeg)
        {
          for (;;)
          {
            QLog.i("Q.lebatab.LebaListController", 1, "setAdapter ", paramajeg);
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
    if (this.jdField_a_of_type_Aljx != null) {
      this.jdField_a_of_type_Aljx.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aljx != null) {
      this.jdField_a_of_type_Aljx.notifyDataSetChanged();
    }
  }
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxi
 * JD-Core Version:    0.7.0.1
 */