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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import java.util.List;

public class auxl
  implements auxg
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 18;
  private View jdField_a_of_type_AndroidViewView;
  public aqhi a;
  private auxp jdField_a_of_type_Auxp = new auxo(null);
  private auyh jdField_a_of_type_Auyh;
  private auyi jdField_a_of_type_Auyi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  private List<aqmf> jdField_a_of_type_JavaUtilList;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  
  private void a(View paramView)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    int i;
    Object localObject2;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("2101".equals(localObject1)) || ("1103".equals(localObject1)) || ("2920".equals(localObject1)) || (bbyp.a((String)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label177;
      }
      localObject1 = paramView.findViewById(2131369805);
      ViewUtils.setViewBackground((View)localObject1, null);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376718);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = ViewUtils.dpToPx(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(2131376719);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label167;
      }
      ((View)localObject2).setBackgroundResource(2130850133);
      label128:
      ViewUtils.setViewBackground(((View)localObject1).findViewById(2131366179), null);
    }
    for (;;)
    {
      paramView.findViewById(2131378147).setVisibility(0);
      ((FrameLayout)paramView.findViewById(2131366753)).setVisibility(0);
      return;
      i = 0;
      break;
      label167:
      ((View)localObject2).setBackgroundResource(2130850155);
      break label128;
      label177:
      localObject1 = paramView.findViewById(2131369805);
      ((View)localObject1).setBackgroundResource(2130850252);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376718);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = ViewUtils.dpToPx(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(8);
      ((View)localObject1).findViewById(2131366179).setBackgroundResource(2130850263);
    }
  }
  
  private boolean a(ImageView paramImageView, Drawable paramDrawable, String paramString)
  {
    this.jdField_a_of_type_Aqhi = aqhj.c();
    if (!this.jdField_a_of_type_Aqhi.a())
    {
      paramDrawable.clearColorFilter();
      paramImageView.setImageDrawable(paramDrawable);
      ViewUtils.setViewBackground(paramImageView, null);
      paramImageView.setPadding(0, 0, 0, 0);
      return false;
    }
    try
    {
      int i = this.jdField_a_of_type_Aqhi.a(paramString);
      if (!SkinEngine.getInstances().checkResExist(i))
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "addPersonalBackgroundToIcon ： 主题包没有该资源");
        paramDrawable.clearColorFilter();
        paramImageView.setImageDrawable(paramDrawable);
        ViewUtils.setViewBackground(paramImageView, null);
        paramImageView.setPadding(0, 0, 0, 0);
        return false;
      }
      ViewUtils.setViewBackground(paramImageView, paramImageView.getResources().getDrawable(i));
      paramDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
      paramString = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      i = paramString.width;
      int j = paramString.height;
      int k = ScreenUtil.dip2px(this.jdField_a_of_type_Int);
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
      ViewUtils.setViewBackground(paramImageView, null);
      paramImageView.setPadding(0, 0, 0, 0);
    }
    return false;
  }
  
  private void b(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375260);
    ViewUtils.setViewBackground(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(16.0F);
    if (this.jdField_b_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(72.0F);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)localRelativeLayout.findViewById(2131376716);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = ViewUtils.dpToPx(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131376711);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label310;
      }
      ((View)localObject).setBackgroundResource(2130840511);
    }
    for (;;)
    {
      localObject = (ImageView)localRelativeLayout.findViewById(2131369879);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = ViewUtils.dpToPx(32.0F);
      localLayoutParams.height = ViewUtils.dpToPx(32.0F);
      localLayoutParams.leftMargin = ViewUtils.dip2px(12.0F);
      a((ImageView)localObject, paramView.getResources().getDrawable(2130845228), "skin_leba_haoyoudongtai_bg");
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131376522);
      ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).width = ViewUtils.dip2px(19.0F);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362969)).getLayoutParams();
      paramView.width = ViewUtils.dip2px(9.0F);
      paramView.height = ViewUtils.dip2px(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131369880)).getLayoutParams()).leftMargin = ViewUtils.dip2px(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131375474)).getLayoutParams()).leftMargin = ViewUtils.dip2px(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(56.0F);
      break;
      label310:
      ((View)localObject).setBackgroundResource(2130839437);
    }
  }
  
  private void c(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131374248);
    ViewUtils.setViewBackground(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(16.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = ViewUtils.dip2px(12.0F);
    if (this.jdField_b_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(72.0F);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)localRelativeLayout.findViewById(2131376716);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = ViewUtils.dpToPx(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131376711);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label338;
      }
      ((View)localObject).setBackgroundResource(2130840511);
    }
    for (;;)
    {
      localObject = (ImageView)localRelativeLayout.findViewById(2131369879);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = ViewUtils.dpToPx(32.0F);
      localLayoutParams.height = ViewUtils.dpToPx(32.0F);
      localLayoutParams.leftMargin = ViewUtils.dip2px(12.0F);
      if (a((ImageView)localObject, paramView.getResources().getDrawable(2130845217), "skin_leba_xiaoshijie_bg")) {
        ((ImageView)localObject).setImageDrawable(paramView.getResources().getDrawable(2130845219));
      }
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131376522);
      ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).width = ViewUtils.dip2px(19.0F);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362969)).getLayoutParams();
      paramView.width = ViewUtils.dip2px(9.0F);
      paramView.height = ViewUtils.dip2px(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374253)).getLayoutParams()).leftMargin = ViewUtils.dip2px(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374254)).getLayoutParams()).leftMargin = ViewUtils.dip2px(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(56.0F);
      break;
      label338:
      ((View)localObject).setBackgroundResource(2130839437);
    }
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        apye localapye = (apye)apub.a().a(614);
        if (localapye == null)
        {
          QLog.i("Q.lebatab.LebaTabletController", 1, "configBean == null");
          return;
        }
        if (localapye.jdField_a_of_type_Int == 1)
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
    if (this.jdField_a_of_type_Auxp != null) {
      return this.jdField_a_of_type_Auxp.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Auyh != null) {
      this.jdField_a_of_type_Auyh.c();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Float = (-this.jdField_a_of_type_AndroidViewView.getY());
      this.jdField_b_of_type_Float = this.jdField_a_of_type_Float;
    }
    f();
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Auyi != null)
    {
      this.jdField_a_of_type_Auyi.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this.jdField_a_of_type_AndroidViewView, paramInt1, this.jdField_b_of_type_Int, paramBoolean, paramInt2);
      this.jdField_a_of_type_Auyi.b();
    }
    if (this.jdField_a_of_type_Auyh != null) {
      this.jdField_a_of_type_Auyh.b();
    }
    if (this.jdField_a_of_type_Auxp != null) {
      this.jdField_a_of_type_Auxp.a();
    }
  }
  
  public void a(ajeg paramajeg)
  {
    QLog.i("Q.lebatab.LebaTabletController", 1, "init table");
    List localList = paramajeg.jdField_a_of_type_JavaUtilList;
    FPSXListView localFPSXListView = paramajeg.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramajeg.jdField_a_of_type_AndroidViewView;
    auxh localauxh = paramajeg.jdField_a_of_type_Auxh;
    Context localContext = paramajeg.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramajeg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
      f();
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
      catch (Exception paramajeg)
      {
        for (;;)
        {
          label157:
          QLog.i("Q.lebatab.LebaTabletController", 1, "addHeaderView", paramajeg);
        }
      }
      try
      {
        paramajeg = localFPSXListView.getAdapter();
        if ((paramajeg == null) || (!(paramajeg instanceof auxn))) {
          localFPSXListView.setAdapter(new auxn());
        }
      }
      catch (Exception paramajeg)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setAdapter", paramajeg);
        break label157;
      }
      if (this.jdField_a_of_type_Auyi == null) {
        this.jdField_a_of_type_Auyi = new auyi(localContext);
      }
      if ((this.jdField_a_of_type_Auyi.jdField_a_of_type_AndroidWidgetLinearLayout == null) && (localView != null)) {
        this.jdField_a_of_type_Auyi.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131378147));
      }
      this.jdField_a_of_type_Auyi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_Auyi.jdField_a_of_type_Auxp = this.jdField_a_of_type_Auxp;
      this.jdField_a_of_type_Auyi.jdField_a_of_type_Auxh = localauxh;
      this.jdField_a_of_type_Auyi.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Auyh == null) {
        this.jdField_a_of_type_Auyh = new auyh(localContext);
      }
      if ((this.jdField_a_of_type_Auyh.a == null) && (localView != null)) {
        this.jdField_a_of_type_Auyh.a = ((FrameLayout)localView.findViewById(2131366753));
      }
      this.jdField_a_of_type_Auyh.c();
      return;
    }
    catch (Exception paramajeg)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", paramajeg);
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
    if (this.jdField_a_of_type_Auyh != null) {
      this.jdField_a_of_type_Auyh.c();
    }
    if (this.jdField_a_of_type_Auyi != null) {
      this.jdField_a_of_type_Auyi.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Auyh != null)
    {
      this.jdField_a_of_type_Auyh.a();
      this.jdField_a_of_type_Auyh.a = null;
    }
    if (this.jdField_a_of_type_Auyi != null)
    {
      this.jdField_a_of_type_Auyi.a();
      this.jdField_a_of_type_Auyi.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      a(this.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxl
 * JD-Core Version:    0.7.0.1
 */