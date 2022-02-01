import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ScaleXSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.mobileqq.now.widget.RoundedRectImageView;
import com.tencent.qphone.base.util.QLog;

public class ayeb
{
  private static final String a = ayeb.class.getSimpleName();
  
  public static void a(FragmentActivity paramFragmentActivity, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ayea))
    {
      paramViewHolder = (ayea)paramViewHolder;
      if (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if (paramInt != 3) {
          break label30;
        }
        c(paramFragmentActivity, paramViewHolder);
      }
    }
    return;
    label30:
    b(paramFragmentActivity, paramViewHolder);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, RecyclerView.ViewHolder paramViewHolder, ayeh paramayeh, int paramInt)
  {
    if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()) || (paramViewHolder == null) || (paramayeh == null)) {
      return;
    }
    paramViewHolder = (aycp)paramViewHolder;
    paramViewHolder.jdField_a_of_type_Int = paramInt;
    if (paramViewHolder.jdField_a_of_type_AndroidViewView != null) {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(new ayec(paramFragmentActivity, paramayeh, paramInt));
    }
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramayeh.jdField_c_of_type_JavaLangString);
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetRoundedRectImageView != null)
    {
      int i = paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetRoundedRectImageView.getWidth() / 2;
      int j = paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetRoundedRectImageView.getHeight() / 2;
      axlp localaxlp = axlp.a();
      RoundedRectImageView localRoundedRectImageView = paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetRoundedRectImageView;
      String str = paramayeh.b;
      Drawable localDrawable = paramFragmentActivity.getResources().getDrawable(2130841420);
      ColorDrawable localColorDrawable = new ColorDrawable(13553358);
      paramInt = i;
      if (i == 0) {
        paramInt = 300;
      }
      i = j;
      if (j == 0) {
        i = 350;
      }
      localaxlp.a(localRoundedRectImageView, str, localDrawable, localColorDrawable, paramInt, i, null, false);
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView != null) {
      axlp.a().a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowWidgetCircleImageView, paramayeh.j, paramFragmentActivity.getResources().getDrawable(2130841412), new ColorDrawable(13553358), 30, 30, null, true);
    }
    if (paramViewHolder.b != null) {
      paramViewHolder.b.setText("" + paramayeh.jdField_c_of_type_Int);
    }
    if (paramViewHolder.c != null)
    {
      paramFragmentActivity = paramayeh.b();
      if ((paramFragmentActivity == null) || (paramFragmentActivity.length() <= 0)) {
        break label335;
      }
      paramViewHolder.c.setText(paramFragmentActivity);
      paramViewHolder.c.setVisibility(0);
    }
    for (;;)
    {
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView != null)
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.setAnimationRes(2130841415);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.a();
      }
      ayej.c(paramayeh.f);
      return;
      label335:
      paramViewHolder.c.setVisibility(8);
    }
  }
  
  private static void b(FragmentActivity paramFragmentActivity, ayea paramayea)
  {
    Object localObject = "暂无数据，请刷新页面";
    if (paramFragmentActivity != null) {
      localObject = paramFragmentActivity.getResources().getString(2131717273);
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new UnderlineSpan(), 6, 8, 33);
    ((SpannableString)localObject).setSpan(new ScaleXSpan(1.1F), 6, 8, 33);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#00CAFC")), 6, 8, 33);
    try
    {
      paramayea.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#878B99"));
      if (paramayea.b != null) {
        paramayea.b.setVisibility(0);
      }
      if (paramayea.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramayea.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        paramayea.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramayea.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramayea.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ayed(paramFragmentActivity, paramayea));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        QLog.d(a, 2, "parse color error: " + localIllegalArgumentException.toString());
      }
    }
  }
  
  private static void c(FragmentActivity paramFragmentActivity, ayea paramayea)
  {
    if (paramayea.b != null) {
      paramayea.b.setVisibility(4);
    }
    if (paramayea.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = AnimationUtils.loadAnimation(paramFragmentActivity, 2130772103);
      ((Animation)localObject).setInterpolator(new LinearInterpolator());
      paramayea.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
      paramayea.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    Object localObject = "加载中";
    if (paramFragmentActivity != null) {
      localObject = paramFragmentActivity.getResources().getString(2131717272);
    }
    paramayea.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    paramayea.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    try
    {
      paramayea.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00CAFC"));
      return;
    }
    catch (IllegalArgumentException paramFragmentActivity)
    {
      QLog.d(a, 2, "parse color error: " + paramFragmentActivity.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayeb
 * JD-Core Version:    0.7.0.1
 */