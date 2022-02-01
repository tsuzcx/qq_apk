import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.FixSizeImageView;

class aynn
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  View b;
  
  public aynn(aymu paramaymu, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131363110));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378016));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371719));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380254));
    this.b = paramView.findViewById(2131363105);
  }
  
  private void a()
  {
    boolean bool2 = false;
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
        boolean bool1;
        if (this.jdField_a_of_type_Int == 2)
        {
          localStringBuilder.append(aymu.a(this.jdField_a_of_type_Aymu).getString(2131718296, new Object[] { str })).append(aymu.a(this.jdField_a_of_type_Aymu).getString(2131690560));
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView != null)
          {
            bool1 = bool2;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getTag(2131380254) instanceof Boolean)) {
              bool1 = ((Boolean)this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.getTag(2131380254)).booleanValue();
            }
          }
          if ((i <= 0) || (bool1)) {
            break label318;
          }
          if (i != 1) {
            break label278;
          }
          localStringBuilder.append(" 有一条未读");
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView.setContentDescription(localStringBuilder.toString());
          return;
          if (this.jdField_a_of_type_Int == 2)
          {
            localStringBuilder.append(aymu.a(this.jdField_a_of_type_Aymu).getString(2131718297, new Object[] { str })).append(aymu.a(this.jdField_a_of_type_Aymu).getString(2131690560));
            break;
          }
          localStringBuilder.append(str).append(aymu.a(this.jdField_a_of_type_Aymu).getString(2131690560));
          break;
          label278:
          if (i == 2)
          {
            localStringBuilder.append(" 有两条未读");
          }
          else if (i > 0)
          {
            localStringBuilder.append(" 有").append(i).append("条未读");
            continue;
            label318:
            if (bool1) {
              localStringBuilder.append(" 有最新消息");
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i;
    int j;
    if (paramInt > 0) {
      if (paramBoolean)
      {
        i = 1;
        if (this.jdField_a_of_type_Int != 2) {
          break label89;
        }
        if (!paramBoolean) {
          break label82;
        }
        j = 2130850388;
        label26:
        bkjh.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, paramInt, j, 99, null);
        label40:
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131380254, Boolean.valueOf(paramBoolean));
      a();
      return;
      i = 3;
      break;
      label82:
      j = 2130850392;
      break label26;
      label89:
      bkjh.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, paramInt, 2130850395, 99, null);
      break label40;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynn
 * JD-Core Version:    0.7.0.1
 */