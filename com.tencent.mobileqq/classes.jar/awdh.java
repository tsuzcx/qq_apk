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

public class awdh
  implements awdf
{
  private amhy jdField_a_of_type_Amhy;
  private View jdField_a_of_type_AndroidViewView;
  private awdg jdField_a_of_type_Awdg;
  private awdo jdField_a_of_type_Awdo = new awdj(null);
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131369975);
    localView.setBackgroundResource(2130850356);
    LebaRoundLayout localLebaRoundLayout = (LebaRoundLayout)localView.findViewById(2131376986);
    localLebaRoundLayout.a = ViewUtils.dpToPx(16.0F);
    localLebaRoundLayout.setVisibility(8);
    localView.findViewById(2131366280).setBackgroundResource(2130850367);
    paramView.findViewById(2131378435).setVisibility(8);
    ((FrameLayout)paramView.findViewById(2131366869)).setVisibility(8);
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131375502);
    ViewUtils.setViewBackground(paramView, null);
    paramView.setBackgroundResource(2130839458);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(56.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LebaRoundLayout)paramView.findViewById(2131376984);
    ((LebaRoundLayout)localObject).a = ViewUtils.dpToPx(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131370049);
    ((ImageView)localObject).setImageResource(2130845299);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131376781);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = ViewUtils.dip2px(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362986)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.dip2px(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (ViewUtils.dip2px(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131370050)).getLayoutParams()).leftMargin = ViewUtils.dip2px(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131375716)).getLayoutParams()).leftMargin = ViewUtils.dip2px(14.0F);
  }
  
  private void c(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374485);
    ViewUtils.setViewBackground(paramView, null);
    paramView.setBackgroundResource(2130839458);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(56.0F);
    localObject = (LebaRoundLayout)paramView.findViewById(2131376984);
    ((LebaRoundLayout)localObject).a = ViewUtils.dpToPx(16.0F);
    ((LebaRoundLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131370049);
    ((ImageView)localObject).setImageResource(2130845303);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131376781);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = ViewUtils.dip2px(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362986)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.dip2px(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (ViewUtils.dip2px(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374490)).getLayoutParams()).leftMargin = ViewUtils.dip2px(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374491)).getLayoutParams()).leftMargin = ViewUtils.dip2px(14.0F);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Awdo != null) {
      return this.jdField_a_of_type_Awdo.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Amhy != null) {
      this.jdField_a_of_type_Amhy.a();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Amhy != null) {
      this.jdField_a_of_type_Amhy.a(paramInt1, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Awdo != null) {
      this.jdField_a_of_type_Awdo.a();
    }
  }
  
  public void a(ajzu paramajzu)
  {
    QLog.i("Q.lebatab.LebaListController", 1, "init list ");
    QQAppInterface localQQAppInterface = paramajzu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    List localList = paramajzu.jdField_a_of_type_JavaUtilList;
    Context localContext = paramajzu.jdField_a_of_type_AndroidContentContext;
    FPSXListView localFPSXListView = paramajzu.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramajzu.jdField_a_of_type_AndroidViewView;
    awdg localawdg = paramajzu.jdField_a_of_type_Awdg;
    this.jdField_a_of_type_AndroidViewView = paramajzu.jdField_a_of_type_AndroidViewView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "initView lebaSV == null ");
      return;
    }
    if (localawdg != null) {
      this.jdField_a_of_type_Awdg = localawdg;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() == null) {
        localFPSXListView.setOverscrollHeader(localContext.getResources().getDrawable(2130850257));
      }
      if (localView == null) {}
    }
    catch (Exception paramajzu)
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
      catch (Exception paramajzu)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Amhy == null)
            {
              this.jdField_a_of_type_Amhy = new amhy(localContext, localList, 2131559125, 2131559126, localQQAppInterface, localFPSXListView, new awdi(this));
              localFPSXListView.setAdapter(this.jdField_a_of_type_Amhy);
            }
            this.jdField_a_of_type_Amhy.a(localQQAppInterface);
            this.jdField_a_of_type_Amhy.a(localList);
            this.jdField_a_of_type_Amhy.a(this.jdField_a_of_type_Awdo);
            return;
            paramajzu = paramajzu;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramajzu);
            continue;
            paramajzu = paramajzu;
            QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramajzu);
          }
        }
        catch (Exception paramajzu)
        {
          for (;;)
          {
            QLog.i("Q.lebatab.LebaListController", 1, "setAdapter ", paramajzu);
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
    if (this.jdField_a_of_type_Amhy != null) {
      this.jdField_a_of_type_Amhy.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Amhy != null) {
      this.jdField_a_of_type_Amhy.notifyDataSetChanged();
    }
  }
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdh
 * JD-Core Version:    0.7.0.1
 */