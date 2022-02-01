import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.leba.widget.LebaTableLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import java.util.List;

public class awdk
  implements awdf
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 18;
  private View jdField_a_of_type_AndroidViewView;
  public arkq a;
  private awdo jdField_a_of_type_Awdo = new awdn(null);
  private aweg jdField_a_of_type_Aweg;
  private aweh jdField_a_of_type_Aweh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  private List<arpq> jdField_a_of_type_JavaUtilList;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  
  private void a(View paramView)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeId();
    int i;
    Object localObject2;
    if (("1000".equals(localObject1)) || ("2105".equals(localObject1)) || ("2101".equals(localObject1)) || ("1103".equals(localObject1)) || ("2920".equals(localObject1)) || (bdfk.a((String)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label177;
      }
      localObject1 = paramView.findViewById(2131369975);
      ViewUtils.setViewBackground((View)localObject1, null);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376986);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = ViewUtils.dpToPx(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(2131376987);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label167;
      }
      ((View)localObject2).setBackgroundResource(2130850235);
      label128:
      ViewUtils.setViewBackground(((View)localObject1).findViewById(2131366280), null);
    }
    for (;;)
    {
      paramView.findViewById(2131378435).setVisibility(0);
      ((FrameLayout)paramView.findViewById(2131366869)).setVisibility(0);
      return;
      i = 0;
      break;
      label167:
      ((View)localObject2).setBackgroundResource(2130850257);
      break label128;
      label177:
      localObject1 = paramView.findViewById(2131369975);
      ((View)localObject1).setBackgroundResource(2130850356);
      localObject2 = (LebaRoundLayout)((View)localObject1).findViewById(2131376986);
      ((LebaRoundLayout)localObject2).jdField_a_of_type_Int = ViewUtils.dpToPx(16.0F);
      ((LebaRoundLayout)localObject2).setVisibility(8);
      ((View)localObject1).findViewById(2131366280).setBackgroundResource(2130850367);
    }
  }
  
  private boolean a(ImageView paramImageView, Drawable paramDrawable, String paramString)
  {
    this.jdField_a_of_type_Arkq = arkr.c();
    if (!this.jdField_a_of_type_Arkq.a())
    {
      paramDrawable.clearColorFilter();
      paramImageView.setImageDrawable(paramDrawable);
      ViewUtils.setViewBackground(paramImageView, null);
      paramImageView.setPadding(0, 0, 0, 0);
      return false;
    }
    try
    {
      int i = this.jdField_a_of_type_Arkq.a(paramString);
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
    float f = 16.0F;
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131375502);
    ViewUtils.setViewBackground(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(16.0F);
    if (this.jdField_b_of_type_Int == 1)
    {
      ((LinearLayout.LayoutParams)localObject).topMargin = ViewUtils.dip2px(4.0F);
      ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(72.0F);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)localRelativeLayout.findViewById(2131376984);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = ViewUtils.dpToPx(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131376979);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label366;
      }
      ((View)localObject).setBackgroundResource(2130840549);
      label143:
      localObject = (ImageView)localRelativeLayout.findViewById(2131370049);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = ViewUtils.dpToPx(32.0F);
      localLayoutParams.height = ViewUtils.dpToPx(32.0F);
      if (this.jdField_b_of_type_Int != 1) {
        break label377;
      }
      label192:
      localLayoutParams.leftMargin = ViewUtils.dip2px(f);
      a((ImageView)localObject, paramView.getResources().getDrawable(2130845313), "skin_leba_haoyoudongtai_bg");
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131376781);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (this.jdField_b_of_type_Int != 1) {
        break label384;
      }
    }
    label384:
    for (f = 21.0F;; f = 19.0F)
    {
      ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.dip2px(f);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362986)).getLayoutParams();
      paramView.width = ViewUtils.dip2px(9.0F);
      paramView.height = ViewUtils.dip2px(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131370050)).getLayoutParams()).leftMargin = ViewUtils.dip2px(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131375716)).getLayoutParams()).leftMargin = ViewUtils.dip2px(4.0F);
      return;
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(56.0F);
      break;
      label366:
      ((View)localObject).setBackgroundResource(2130839458);
      break label143;
      label377:
      f = 12.0F;
      break label192;
    }
  }
  
  private void c(View paramView)
  {
    float f2 = 12.0F;
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131374485);
    ViewUtils.setViewBackground(localRelativeLayout, null);
    localRelativeLayout.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(16.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(16.0F);
    if (this.jdField_b_of_type_Int == 1)
    {
      f1 = 11.0F;
      ((LinearLayout.LayoutParams)localObject).topMargin = ViewUtils.dip2px(f1);
      if (this.jdField_b_of_type_Int != 1) {
        break label403;
      }
      f1 = 72.0F;
      label93:
      ((LinearLayout.LayoutParams)localObject).height = ViewUtils.dip2px(f1);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LebaRoundLayout)localRelativeLayout.findViewById(2131376984);
      ((LebaRoundLayout)localObject).jdField_a_of_type_Int = ViewUtils.dpToPx(16.0F);
      ((LebaRoundLayout)localObject).setVisibility(0);
      localObject = localRelativeLayout.findViewById(2131376979);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label410;
      }
      ((View)localObject).setBackgroundResource(2130840549);
      label165:
      localObject = (ImageView)localRelativeLayout.findViewById(2131370049);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.width = ViewUtils.dpToPx(32.0F);
      localLayoutParams.height = ViewUtils.dpToPx(32.0F);
      f1 = f2;
      if (this.jdField_b_of_type_Int == 1) {
        f1 = 16.0F;
      }
      localLayoutParams.leftMargin = ViewUtils.dip2px(f1);
      if (a((ImageView)localObject, paramView.getResources().getDrawable(2130845302), "skin_leba_xiaoshijie_bg")) {
        ((ImageView)localObject).setImageDrawable(paramView.getResources().getDrawable(2130845304));
      }
      paramView = (RelativeLayout)localRelativeLayout.findViewById(2131376781);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (this.jdField_b_of_type_Int != 1) {
        break label421;
      }
    }
    label403:
    label410:
    label421:
    for (float f1 = 21.0F;; f1 = 19.0F)
    {
      ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.dip2px(f1);
      paramView = (RelativeLayout.LayoutParams)((ImageView)paramView.findViewById(2131362986)).getLayoutParams();
      paramView.width = ViewUtils.dip2px(9.0F);
      paramView.height = ViewUtils.dip2px(15.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374490)).getLayoutParams()).leftMargin = ViewUtils.dip2px(8.0F);
      ((RelativeLayout.LayoutParams)((TextView)localRelativeLayout.findViewById(2131374491)).getLayoutParams()).leftMargin = ViewUtils.dip2px(4.0F);
      return;
      f1 = 12.0F;
      break;
      f1 = 56.0F;
      break label93;
      ((View)localObject).setBackgroundResource(2130839458);
      break label165;
    }
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        arbh localarbh = (arbh)aqxe.a().a(614);
        if (localarbh == null)
        {
          QLog.i("Q.lebatab.LebaTabletController", 1, "configBean == null");
          return;
        }
        if (localarbh.jdField_a_of_type_Int == 1)
        {
          i = 1;
          QLog.i("Q.lebatab.LebaTabletController", 1, "loadQzoneStyle=" + i);
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
    if (this.jdField_a_of_type_Awdo != null) {
      return this.jdField_a_of_type_Awdo.a();
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Float = (-this.jdField_a_of_type_AndroidViewView.getY());
      this.jdField_b_of_type_Float = this.jdField_a_of_type_Float;
    }
    f();
    if (this.jdField_a_of_type_Aweh != null) {
      this.jdField_a_of_type_Aweh.a(this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Aweg != null)
    {
      this.jdField_a_of_type_Aweg.a(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Aweg.c();
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Aweh != null)
    {
      this.jdField_a_of_type_Aweh.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this.jdField_a_of_type_AndroidViewView, paramInt1, this.jdField_b_of_type_Int, paramBoolean, paramInt2);
      this.jdField_a_of_type_Aweh.b();
    }
    if (this.jdField_a_of_type_Aweg != null) {
      this.jdField_a_of_type_Aweg.b();
    }
    if (this.jdField_a_of_type_Awdo != null) {
      this.jdField_a_of_type_Awdo.a();
    }
  }
  
  public void a(ajzu paramajzu)
  {
    QLog.i("Q.lebatab.LebaTabletController", 1, "init table");
    List localList = paramajzu.jdField_a_of_type_JavaUtilList;
    FPSXListView localFPSXListView = paramajzu.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramajzu.jdField_a_of_type_AndroidViewView;
    awdg localawdg = paramajzu.jdField_a_of_type_Awdg;
    Context localContext = paramajzu.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramajzu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
      catch (Exception paramajzu)
      {
        for (;;)
        {
          label157:
          QLog.i("Q.lebatab.LebaTabletController", 1, "addHeaderView", paramajzu);
        }
      }
      try
      {
        paramajzu = localFPSXListView.getAdapter();
        if ((paramajzu == null) || (!(paramajzu instanceof awdm))) {
          localFPSXListView.setAdapter(new awdm());
        }
      }
      catch (Exception paramajzu)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setAdapter", paramajzu);
        break label157;
      }
      if (this.jdField_a_of_type_Aweh == null) {
        this.jdField_a_of_type_Aweh = new aweh(localContext);
      }
      this.jdField_a_of_type_Aweh.a(this.jdField_b_of_type_Int);
      if ((this.jdField_a_of_type_Aweh.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout == null) && (localView != null)) {
        this.jdField_a_of_type_Aweh.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout = ((LebaTableLayout)localView.findViewById(2131378435));
      }
      this.jdField_a_of_type_Aweh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_Aweh.jdField_a_of_type_Awdo = this.jdField_a_of_type_Awdo;
      this.jdField_a_of_type_Aweh.jdField_a_of_type_Awdg = localawdg;
      this.jdField_a_of_type_Aweh.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Aweg == null) {
        this.jdField_a_of_type_Aweg = new aweg(localContext);
      }
      if ((this.jdField_a_of_type_Aweg.a == null) && (localView != null)) {
        this.jdField_a_of_type_Aweg.a = ((FrameLayout)localView.findViewById(2131366869));
      }
      this.jdField_a_of_type_Aweg.a(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Aweg.c();
      return;
    }
    catch (Exception paramajzu)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaTabletController", 1, "setOverscrollHeader", paramajzu);
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
    if (this.jdField_a_of_type_Aweg != null) {
      this.jdField_a_of_type_Aweg.c();
    }
    if (this.jdField_a_of_type_Aweh != null) {
      this.jdField_a_of_type_Aweh.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aweg != null)
    {
      this.jdField_a_of_type_Aweg.a();
      this.jdField_a_of_type_Aweg.a = null;
    }
    if (this.jdField_a_of_type_Aweh != null)
    {
      this.jdField_a_of_type_Aweh.a();
      this.jdField_a_of_type_Aweh.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaTableLayout = null;
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
 * Qualified Name:     awdk
 * JD-Core Version:    0.7.0.1
 */