import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
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
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import java.util.List;

public class avrq
  implements avrl
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 18;
  private View jdField_a_of_type_AndroidViewView;
  public aqxv a;
  private avru jdField_a_of_type_Avru = new avrt(null);
  private avsj jdField_a_of_type_Avsj;
  private avsk jdField_a_of_type_Avsk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  private List<arcs> jdField_a_of_type_JavaUtilList;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  
  private void a(View paramView)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    int i;
    Object localObject2;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("2101".equals(localObject1)) || ("1103".equals(localObject1)) || ("2920".equals(localObject1)) || (bcnj.a((String)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label177;
      }
      localObject1 = paramView.findViewById(2131369721);
      bgtn.a((View)localObject1, null);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376827);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = bgtn.b(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(2131376828);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label167;
      }
      ((View)localObject2).setBackgroundResource(2130850200);
      label128:
      bgtn.a(((View)localObject1).findViewById(2131366102), null);
    }
    for (;;)
    {
      paramView.findViewById(2131378223).setVisibility(0);
      ((FrameLayout)paramView.findViewById(2131366673)).setVisibility(0);
      return;
      i = 0;
      break;
      label167:
      ((View)localObject2).setBackgroundResource(2130850222);
      break label128;
      label177:
      localObject1 = paramView.findViewById(2131369721);
      ((View)localObject1).setBackgroundResource(2130850319);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376827);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = bgtn.b(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(8);
      ((View)localObject1).findViewById(2131366102).setBackgroundResource(2130850330);
    }
  }
  
  private boolean a(ImageView paramImageView, Drawable paramDrawable, String paramString)
  {
    this.jdField_a_of_type_Aqxv = aqxw.c();
    if (!this.jdField_a_of_type_Aqxv.a())
    {
      paramDrawable.clearColorFilter();
      paramImageView.setImageDrawable(paramDrawable);
      paramImageView.setBackground(null);
      paramImageView.setPadding(0, 0, 0, 0);
      return false;
    }
    try
    {
      int i = paramImageView.getResources().getIdentifier(paramString, "drawable", "com.tencent.mobileqq");
      if (!SkinEngine.getInstances().checkResExist(i))
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "addPersonalBackgroundToIcon ： 主题包没有该资源");
        paramDrawable.clearColorFilter();
        paramImageView.setImageDrawable(paramDrawable);
        paramImageView.setBackground(null);
        paramImageView.setPadding(0, 0, 0, 0);
        return false;
      }
      paramImageView.setBackground(paramImageView.getResources().getDrawable(i));
      paramDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
      paramString = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      i = paramString.width;
      int j = paramString.height;
      int k = bclx.a(this.jdField_a_of_type_Int);
      paramImageView.setPadding((i - k) / 2, (j - k) / 2, (i - k) / 2, (j - k) / 2);
      paramImageView.setImageDrawable(paramDrawable);
      paramImageView.invalidate();
      return true;
    }
    catch (Exception paramString)
    {
      QLog.i("Q.lebatab.LebaTabletController", 1, "addPersonalBackgroundToIcon Exception : " + paramString.toString());
      paramDrawable.clearColorFilter();
      paramImageView.setImageDrawable(paramDrawable);
      paramImageView.setBackground(null);
      paramImageView.setPadding(0, 0, 0, 0);
    }
    return false;
  }
  
  private void b(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375355);
    bgtn.a(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = bgtn.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = bgtn.a(16.0F);
    if (this.jdField_b_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = bgtn.a(72.0F);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)localRelativeLayout.findViewById(2131376825);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = bgtn.b(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131376819);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label314;
      }
      ((View)localObject).setBackgroundResource(2130840465);
    }
    for (;;)
    {
      localObject = (ImageView)localRelativeLayout.findViewById(2131369787);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = bgtn.b(32.0F);
      localLayoutParams.height = bgtn.b(32.0F);
      localLayoutParams.leftMargin = bgtn.a(12.0F);
      a((ImageView)localObject, paramView.getResources().getDrawable(2130845334), "skin_leba_haoyoudongtai_bg");
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131376618);
      ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).width = bgtn.a(19.0F);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362937)).getLayoutParams();
      paramView.width = bgtn.a(9.0F);
      paramView.height = bgtn.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131369788)).getLayoutParams()).leftMargin = bgtn.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131375566)).getLayoutParams()).leftMargin = bgtn.a(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = bgtn.a(56.0F);
      break;
      label314:
      ((View)localObject).setBackgroundResource(2130839394);
    }
  }
  
  private void c(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131374344);
    bgtn.a(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = bgtn.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = bgtn.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = bgtn.a(12.0F);
    if (this.jdField_b_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = bgtn.a(72.0F);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)localRelativeLayout.findViewById(2131376825);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = bgtn.b(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131376819);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label342;
      }
      ((View)localObject).setBackgroundResource(2130840465);
    }
    for (;;)
    {
      localObject = (ImageView)localRelativeLayout.findViewById(2131369787);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = bgtn.b(32.0F);
      localLayoutParams.height = bgtn.b(32.0F);
      localLayoutParams.leftMargin = bgtn.a(12.0F);
      if (a((ImageView)localObject, paramView.getResources().getDrawable(2130845323), "skin_leba_xiaoshijie_bg")) {
        ((ImageView)localObject).setImageDrawable(paramView.getResources().getDrawable(2130845325));
      }
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131376618);
      ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).width = bgtn.a(19.0F);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362937)).getLayoutParams();
      paramView.width = bgtn.a(9.0F);
      paramView.height = bgtn.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374349)).getLayoutParams()).leftMargin = bgtn.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374350)).getLayoutParams()).leftMargin = bgtn.a(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = bgtn.a(56.0F);
      break;
      label342:
      ((View)localObject).setBackgroundResource(2130839394);
    }
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        aqpg localaqpg = (aqpg)aqlk.a().a(614);
        if (localaqpg == null)
        {
          QLog.i("Q.lebatab.LebaTabletController", 1, "configBean == null");
          return;
        }
        if (localaqpg.jdField_a_of_type_Int == 1)
        {
          i = 1;
          QLog.i("Q.lebatab.LebaTabletController", 1, "loadQzoneStyle " + i);
          if (i == this.jdField_b_of_type_Int) {
            break;
          }
          this.jdField_b_of_type_Int = i;
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
    if (this.jdField_a_of_type_Avru != null) {
      return this.jdField_a_of_type_Avru.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Avsj != null) {
      this.jdField_a_of_type_Avsj.c();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Float = (-this.jdField_a_of_type_AndroidViewView.getY());
      this.jdField_b_of_type_Float = this.jdField_a_of_type_Float;
    }
    e();
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Avsk != null) {
      this.jdField_a_of_type_Avsk.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this.jdField_a_of_type_AndroidViewView, paramInt1, this.jdField_b_of_type_Int, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Avsj != null) {
      this.jdField_a_of_type_Avsj.b();
    }
    if (this.jdField_a_of_type_Avru != null) {
      this.jdField_a_of_type_Avru.a();
    }
  }
  
  public void a(ajve paramajve)
  {
    QLog.i("Q.lebatab.LebaTabletController", 1, "init table");
    List localList = paramajve.jdField_a_of_type_JavaUtilList;
    FPSXListView localFPSXListView = paramajve.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramajve.jdField_a_of_type_AndroidViewView;
    avrm localavrm = paramajve.jdField_a_of_type_Avrm;
    Context localContext = paramajve.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramajve.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
      catch (Exception paramajve)
      {
        for (;;)
        {
          label157:
          QLog.i("Q.lebatab.LebaTabletController", 1, "addHeaderView", paramajve);
        }
      }
      try
      {
        paramajve = localFPSXListView.getAdapter();
        if ((paramajve == null) || (!(paramajve instanceof avrs))) {
          localFPSXListView.setAdapter(new avrs());
        }
      }
      catch (Exception paramajve)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setAdapter", paramajve);
        break label157;
      }
      if (this.jdField_a_of_type_Avsk == null) {
        this.jdField_a_of_type_Avsk = new avsk(localContext);
      }
      if ((this.jdField_a_of_type_Avsk.jdField_a_of_type_AndroidWidgetLinearLayout == null) && (localView != null)) {
        this.jdField_a_of_type_Avsk.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131378223));
      }
      this.jdField_a_of_type_Avsk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_Avsk.jdField_a_of_type_Avru = this.jdField_a_of_type_Avru;
      this.jdField_a_of_type_Avsk.jdField_a_of_type_Avrm = localavrm;
      this.jdField_a_of_type_Avsk.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Avsj == null) {
        this.jdField_a_of_type_Avsj = new avsj(localContext);
      }
      if ((this.jdField_a_of_type_Avsj.a == null) && (localView != null)) {
        this.jdField_a_of_type_Avsj.a = ((FrameLayout)localView.findViewById(2131366673));
      }
      this.jdField_a_of_type_Avsj.c();
      return;
    }
    catch (Exception paramajve)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", paramajve);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      float f = -this.jdField_a_of_type_AndroidViewView.getY();
      if (f > this.jdField_b_of_type_Float) {
        this.jdField_b_of_type_Float = f;
      }
      if (f < this.jdField_a_of_type_Float) {
        this.jdField_a_of_type_Float = f;
      }
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
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
    if (this.jdField_a_of_type_Avsj != null) {
      this.jdField_a_of_type_Avsj.c();
    }
    if (this.jdField_a_of_type_Avsk != null) {
      this.jdField_a_of_type_Avsk.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Avsj != null)
    {
      this.jdField_a_of_type_Avsj.a();
      this.jdField_a_of_type_Avsj.a = null;
    }
    if (this.jdField_a_of_type_Avsk != null)
    {
      this.jdField_a_of_type_Avsk.a();
      this.jdField_a_of_type_Avsk.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrq
 * JD-Core Version:    0.7.0.1
 */