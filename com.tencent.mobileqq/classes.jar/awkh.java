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

public class awkh
  implements awkc
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 18;
  private View jdField_a_of_type_AndroidViewView;
  public arnk a;
  private awkl jdField_a_of_type_Awkl = new awkk(null);
  private awle jdField_a_of_type_Awle;
  private awlf jdField_a_of_type_Awlf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  private List<arsh> jdField_a_of_type_JavaUtilList;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  
  private void a(View paramView)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    int i;
    Object localObject2;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("2101".equals(localObject1)) || ("1103".equals(localObject1)) || ("2920".equals(localObject1)) || (bdgb.a((String)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label177;
      }
      localObject1 = paramView.findViewById(2131369816);
      bhtq.a((View)localObject1, null);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376964);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = bhtq.b(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(2131376965);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label167;
      }
      ((View)localObject2).setBackgroundResource(2130850212);
      label128:
      bhtq.a(((View)localObject1).findViewById(2131366151), null);
    }
    for (;;)
    {
      paramView.findViewById(2131378380).setVisibility(0);
      ((FrameLayout)paramView.findViewById(2131366723)).setVisibility(0);
      return;
      i = 0;
      break;
      label167:
      ((View)localObject2).setBackgroundResource(2130850234);
      break label128;
      label177:
      localObject1 = paramView.findViewById(2131369816);
      ((View)localObject1).setBackgroundResource(2130850331);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376964);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = bhtq.b(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(8);
      ((View)localObject1).findViewById(2131366151).setBackgroundResource(2130850342);
    }
  }
  
  private boolean a(ImageView paramImageView, Drawable paramDrawable, String paramString)
  {
    this.jdField_a_of_type_Arnk = arnl.c();
    if (!this.jdField_a_of_type_Arnk.a())
    {
      paramDrawable.clearColorFilter();
      paramImageView.setImageDrawable(paramDrawable);
      bhtq.a(paramImageView, null);
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
        bhtq.a(paramImageView, null);
        paramImageView.setPadding(0, 0, 0, 0);
        return false;
      }
      bhtq.a(paramImageView, paramImageView.getResources().getDrawable(i));
      paramDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
      paramString = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      i = paramString.width;
      int j = paramString.height;
      int k = bdep.a(this.jdField_a_of_type_Int);
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
      bhtq.a(paramImageView, null);
      paramImageView.setPadding(0, 0, 0, 0);
    }
    return false;
  }
  
  private void b(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375492);
    bhtq.a(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = bhtq.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = bhtq.a(16.0F);
    if (this.jdField_b_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = bhtq.a(72.0F);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)localRelativeLayout.findViewById(2131376962);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = bhtq.b(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131376956);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label312;
      }
      ((View)localObject).setBackgroundResource(2130840475);
    }
    for (;;)
    {
      localObject = (ImageView)localRelativeLayout.findViewById(2131369885);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = bhtq.b(32.0F);
      localLayoutParams.height = bhtq.b(32.0F);
      localLayoutParams.leftMargin = bhtq.a(12.0F);
      a((ImageView)localObject, paramView.getResources().getDrawable(2130845349), "skin_leba_haoyoudongtai_bg");
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131376751);
      ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).width = bhtq.a(19.0F);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362955)).getLayoutParams();
      paramView.width = bhtq.a(9.0F);
      paramView.height = bhtq.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131369886)).getLayoutParams()).leftMargin = bhtq.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131375706)).getLayoutParams()).leftMargin = bhtq.a(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = bhtq.a(56.0F);
      break;
      label312:
      ((View)localObject).setBackgroundResource(2130839402);
    }
  }
  
  private void c(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131374480);
    bhtq.a(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = bhtq.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = bhtq.a(16.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = bhtq.a(12.0F);
    if (this.jdField_b_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = bhtq.a(72.0F);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)localRelativeLayout.findViewById(2131376962);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = bhtq.b(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131376956);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label340;
      }
      ((View)localObject).setBackgroundResource(2130840475);
    }
    for (;;)
    {
      localObject = (ImageView)localRelativeLayout.findViewById(2131369885);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = bhtq.b(32.0F);
      localLayoutParams.height = bhtq.b(32.0F);
      localLayoutParams.leftMargin = bhtq.a(12.0F);
      if (a((ImageView)localObject, paramView.getResources().getDrawable(2130845338), "skin_leba_xiaoshijie_bg")) {
        ((ImageView)localObject).setImageDrawable(paramView.getResources().getDrawable(2130845340));
      }
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131376751);
      ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).width = bhtq.a(19.0F);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362955)).getLayoutParams();
      paramView.width = bhtq.a(9.0F);
      paramView.height = bhtq.a(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374485)).getLayoutParams()).leftMargin = bhtq.a(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374486)).getLayoutParams()).leftMargin = bhtq.a(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = bhtq.a(56.0F);
      break;
      label340:
      ((View)localObject).setBackgroundResource(2130839402);
    }
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        areo localareo = (areo)aran.a().a(614);
        if (localareo == null)
        {
          QLog.i("Q.lebatab.LebaTabletController", 1, "configBean == null");
          return;
        }
        if (localareo.jdField_a_of_type_Int == 1)
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
    if (this.jdField_a_of_type_Awkl != null) {
      return this.jdField_a_of_type_Awkl.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Awle != null) {
      this.jdField_a_of_type_Awle.c();
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
    if (this.jdField_a_of_type_Awlf != null) {
      this.jdField_a_of_type_Awlf.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this.jdField_a_of_type_AndroidViewView, paramInt1, this.jdField_b_of_type_Int, paramBoolean, paramInt2);
    }
    if (this.jdField_a_of_type_Awle != null) {
      this.jdField_a_of_type_Awle.b();
    }
    if (this.jdField_a_of_type_Awkl != null) {
      this.jdField_a_of_type_Awkl.a();
    }
  }
  
  public void a(akgn paramakgn)
  {
    QLog.i("Q.lebatab.LebaTabletController", 1, "init table");
    List localList = paramakgn.jdField_a_of_type_JavaUtilList;
    FPSXListView localFPSXListView = paramakgn.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramakgn.jdField_a_of_type_AndroidViewView;
    awkd localawkd = paramakgn.jdField_a_of_type_Awkd;
    Context localContext = paramakgn.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramakgn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
      catch (Exception paramakgn)
      {
        for (;;)
        {
          label157:
          QLog.i("Q.lebatab.LebaTabletController", 1, "addHeaderView", paramakgn);
        }
      }
      try
      {
        paramakgn = localFPSXListView.getAdapter();
        if ((paramakgn == null) || (!(paramakgn instanceof awkj))) {
          localFPSXListView.setAdapter(new awkj());
        }
      }
      catch (Exception paramakgn)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setAdapter", paramakgn);
        break label157;
      }
      if (this.jdField_a_of_type_Awlf == null) {
        this.jdField_a_of_type_Awlf = new awlf(localContext);
      }
      if ((this.jdField_a_of_type_Awlf.jdField_a_of_type_AndroidWidgetLinearLayout == null) && (localView != null)) {
        this.jdField_a_of_type_Awlf.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131378380));
      }
      this.jdField_a_of_type_Awlf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_Awlf.jdField_a_of_type_Awkl = this.jdField_a_of_type_Awkl;
      this.jdField_a_of_type_Awlf.jdField_a_of_type_Awkd = localawkd;
      this.jdField_a_of_type_Awlf.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Awle == null) {
        this.jdField_a_of_type_Awle = new awle(localContext);
      }
      if ((this.jdField_a_of_type_Awle.a == null) && (localView != null)) {
        this.jdField_a_of_type_Awle.a = ((FrameLayout)localView.findViewById(2131366723));
      }
      this.jdField_a_of_type_Awle.c();
      return;
    }
    catch (Exception paramakgn)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", paramakgn);
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
    if (this.jdField_a_of_type_Awle != null) {
      this.jdField_a_of_type_Awle.c();
    }
    if (this.jdField_a_of_type_Awlf != null) {
      this.jdField_a_of_type_Awlf.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Awle != null)
    {
      this.jdField_a_of_type_Awle.a();
      this.jdField_a_of_type_Awle.a = null;
    }
    if (this.jdField_a_of_type_Awlf != null)
    {
      this.jdField_a_of_type_Awlf.a();
      this.jdField_a_of_type_Awlf.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkh
 * JD-Core Version:    0.7.0.1
 */