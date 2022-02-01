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

public class bdgb
{
  bdgc a = null;
  bdgc b = null;
  
  void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (this.a == null) {
        this.a = new bdgc();
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369860));
      this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView = ((RoundRectView)paramView.findViewById(2131369826));
      this.a.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369859));
      this.a.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369868));
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)paramView.findViewById(2131369856));
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369841));
      this.a.jdField_a_of_type_Bdfo = new bdfo();
    } while (this.a.jdField_a_of_type_Bdfo.a() == null);
    this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_Bdfo.a());
  }
  
  void a(bddb parambddb, View.OnClickListener paramOnClickListener, Context paramContext)
  {
    if ((parambddb == null) || (paramOnClickListener == null) || (paramContext == null)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setAllRadius(ViewUtils.dpToPx(12.0F));
    this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setBgColor(parambddb.d);
    this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setTag(parambddb);
    this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setOnClickListener(paramOnClickListener);
    if (AppSetting.c) {
      this.a.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setContentDescription(parambddb.jdField_a_of_type_JavaLangString);
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(parambddb.jdField_a_of_type_JavaLangString);
    if (parambddb.jdField_a_of_type_Boolean)
    {
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.a.jdField_a_of_type_Bdfo.a(parambddb.jdField_a_of_type_JavaUtilArrayList);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(parambddb.a());
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(ViewUtils.dpToPx(12.0F));
      if (TextUtils.isEmpty(parambddb.c)) {
        break;
      }
      paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
      paramOnClickListener.mLoadingDrawable = bddb.a(paramContext, parambddb);
      paramOnClickListener.mFailedDrawable = bddb.a(paramContext, parambddb);
      parambddb = URLDrawable.getDrawable(parambddb.c, paramOnClickListener);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageDrawable(parambddb);
      return;
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageResource(parambddb.e);
  }
  
  void b(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (this.b == null) {
        this.b = new bdgc();
      }
      this.b.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376457));
      this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView = ((RoundRectView)paramView.findViewById(2131376422));
      this.b.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376456));
      this.b.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376467));
      this.b.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)paramView.findViewById(2131376453));
      this.b.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376440));
      this.b.jdField_a_of_type_Bdfo = new bdfo();
    } while (this.b.jdField_a_of_type_Bdfo.a() == null);
    this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.b.jdField_a_of_type_Bdfo.a());
  }
  
  void b(bddb parambddb, View.OnClickListener paramOnClickListener, Context paramContext)
  {
    if ((parambddb == null) || (paramOnClickListener == null) || (paramContext == null)) {
      return;
    }
    this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setAllRadius(ViewUtils.dpToPx(12.0F));
    this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setBgColor(parambddb.d);
    this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setTag(parambddb);
    this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setOnClickListener(paramOnClickListener);
    if (AppSetting.c) {
      this.b.jdField_a_of_type_ComTencentMobileqqTogetherUiRoundRectView.setContentDescription(parambddb.jdField_a_of_type_JavaLangString);
    }
    this.b.jdField_a_of_type_AndroidWidgetTextView.setText(parambddb.jdField_a_of_type_JavaLangString);
    if (parambddb.jdField_a_of_type_Boolean)
    {
      this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.b.jdField_a_of_type_Bdfo.a(parambddb.jdField_a_of_type_JavaUtilArrayList);
    }
    for (;;)
    {
      this.b.jdField_b_of_type_AndroidWidgetTextView.setText(parambddb.a());
      this.b.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(ViewUtils.dpToPx(12.0F));
      if (TextUtils.isEmpty(parambddb.c)) {
        break;
      }
      paramOnClickListener = URLDrawable.URLDrawableOptions.obtain();
      paramOnClickListener.mLoadingDrawable = bddb.a(paramContext, parambddb);
      paramOnClickListener.mFailedDrawable = bddb.a(paramContext, parambddb);
      parambddb = URLDrawable.getDrawable(parambddb.c, paramOnClickListener);
      this.b.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageDrawable(parambddb);
      return;
      this.b.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.b.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageResource(parambddb.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgb
 * JD-Core Version:    0.7.0.1
 */