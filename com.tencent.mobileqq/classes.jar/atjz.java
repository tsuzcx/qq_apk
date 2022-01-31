import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.FixSizeImageView;

class atjz
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  View b;
  
  public atjz(atjj paramatjj, View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131297422));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131310831));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305157));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131312825));
    this.b = paramView.findViewById(2131297416);
  }
  
  private void a()
  {
    if (!AppSetting.c) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {}
    for (String str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();; str = "")
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getTag() instanceof Integer))) {}
      for (int i = ((Integer)this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getTag()).intValue();; i = 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.jdField_a_of_type_Int == 2)
        {
          localStringBuilder.append(atjj.a(this.jdField_a_of_type_Atjj).getString(2131653999, new Object[] { str })).append(atjj.a(this.jdField_a_of_type_Atjj).getString(2131625005));
          if (i > 0)
          {
            if (i != 1) {
              break label220;
            }
            localStringBuilder.append(" 有一条未读");
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView.setContentDescription(localStringBuilder.toString());
          return;
          if (this.jdField_a_of_type_Int == 2)
          {
            localStringBuilder.append(atjj.a(this.jdField_a_of_type_Atjj).getString(2131654000, new Object[] { str })).append(atjj.a(this.jdField_a_of_type_Atjj).getString(2131625005));
            break;
          }
          localStringBuilder.append(str).append(atjj.a(this.jdField_a_of_type_Atjj).getString(2131625005));
          break;
          label220:
          if (i == 2) {
            localStringBuilder.append(" 有两条未读");
          } else if (i > 0) {
            localStringBuilder.append(" 有").append(i).append("条未读");
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0) {
      if (this.jdField_a_of_type_Int == 2)
      {
        beih.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, paramInt, 2130849057, 99, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      }
    }
    for (;;)
    {
      a();
      return;
      beih.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, paramInt, 2130849060, 99, null);
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atjz
 * JD-Core Version:    0.7.0.1
 */