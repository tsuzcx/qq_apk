package com.tencent.mobileqq.activity.shopping;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;

public class ItemCountView
  extends FrameLayout
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  
  public ItemCountView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ItemCountView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = View.inflate(paramContext, 2131559374, this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramContext.findViewById(2131363486));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramContext.findViewById(2131376434));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131371803));
  }
  
  public void setBg(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setRedCount(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView != null)
    {
      if (!paramBoolean) {
        break label45;
      }
      if (paramInt <= 99) {
        break label37;
      }
    }
    label37:
    for (String str = "99+";; str = String.valueOf(paramInt))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setText(str);
      return;
    }
    label45:
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
  }
  
  public void setTitle(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ItemCountView
 * JD-Core Version:    0.7.0.1
 */