import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView;
import com.tencent.mobileqq.together.ui.RoundRectView;
import com.tencent.mobileqq.utils.ViewUtils;

public class bene
{
  benf a = null;
  benf b = null;
  
  void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (this.a == null) {
        this.a = new benf();
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370030));
      this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView = ((RoundRectView)paramView.findViewById(2131369996));
      this.a.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370029));
      this.a.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370038));
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)paramView.findViewById(2131370026));
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370011));
      this.a.jdField_a_of_type_Bemr = new bemr();
    } while (this.a.jdField_a_of_type_Bemr.a() == null);
    this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_Bemr.a());
  }
  
  void a(bekd parambekd, View.OnClickListener paramOnClickListener, Context paramContext)
  {
    if ((parambekd == null) || (paramOnClickListener == null) || (paramContext == null)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setAllRadius(ViewUtils.dpToPx(12.0F));
    this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setBgColor(parambekd.d);
    this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setTag(parambekd);
    this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setOnClickListener(paramOnClickListener);
    if (AppSetting.c) {
      this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setContentDescription(parambekd.jdField_a_of_type_JavaLangString);
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(parambekd.jdField_a_of_type_JavaLangString);
    if (parambekd.jdField_a_of_type_Boolean)
    {
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.a.jdField_a_of_type_Bemr.a(parambekd.jdField_a_of_type_JavaUtilArrayList);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(parambekd.a());
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(ViewUtils.dpToPx(12.0F));
      if (TextUtils.isEmpty(parambekd.c)) {
        break;
      }
      paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
      paramOnClickListener.mLoadingDrawable = bekd.a(paramContext, parambekd);
      paramOnClickListener.mFailedDrawable = bekd.a(paramContext, parambekd);
      parambekd = URLDrawable.getDrawable(parambekd.c, paramOnClickListener);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageDrawable(parambekd);
      return;
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageResource(parambekd.e);
  }
  
  void b(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (this.b == null) {
        this.b = new benf();
      }
      this.b.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376712));
      this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView = ((RoundRectView)paramView.findViewById(2131376677));
      this.b.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376711));
      this.b.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376722));
      this.b.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)paramView.findViewById(2131376708));
      this.b.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376695));
      this.b.jdField_a_of_type_Bemr = new bemr();
    } while (this.b.jdField_a_of_type_Bemr.a() == null);
    this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.b.jdField_a_of_type_Bemr.a());
  }
  
  void b(bekd parambekd, View.OnClickListener paramOnClickListener, Context paramContext)
  {
    if ((parambekd == null) || (paramOnClickListener == null) || (paramContext == null)) {
      return;
    }
    this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setAllRadius(ViewUtils.dpToPx(12.0F));
    this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setBgColor(parambekd.d);
    this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setTag(parambekd);
    this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setOnClickListener(paramOnClickListener);
    if (AppSetting.c) {
      this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setContentDescription(parambekd.jdField_a_of_type_JavaLangString);
    }
    this.b.jdField_a_of_type_AndroidWidgetTextView.setText(parambekd.jdField_a_of_type_JavaLangString);
    if (parambekd.jdField_a_of_type_Boolean)
    {
      this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.b.jdField_a_of_type_Bemr.a(parambekd.jdField_a_of_type_JavaUtilArrayList);
    }
    for (;;)
    {
      this.b.jdField_b_of_type_AndroidWidgetTextView.setText(parambekd.a());
      this.b.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(ViewUtils.dpToPx(12.0F));
      if (TextUtils.isEmpty(parambekd.c)) {
        break;
      }
      paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
      paramOnClickListener.mLoadingDrawable = bekd.a(paramContext, parambekd);
      paramOnClickListener.mFailedDrawable = bekd.a(paramContext, parambekd);
      parambekd = URLDrawable.getDrawable(parambekd.c, paramOnClickListener);
      this.b.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageDrawable(parambekd);
      return;
      this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.b.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageResource(parambekd.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bene
 * JD-Core Version:    0.7.0.1
 */