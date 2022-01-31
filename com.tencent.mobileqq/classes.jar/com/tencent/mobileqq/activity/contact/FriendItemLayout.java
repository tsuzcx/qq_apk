package com.tencent.mobileqq.activity.contact;

import aidu;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.Map;

public class FriendItemLayout
  extends FrameLayout
{
  private static int jdField_a_of_type_Int;
  private static Map<CharSequence, Integer> jdField_a_of_type_JavaUtilMap = new HashMap(5);
  private aidu jdField_a_of_type_Aidu;
  
  public FriendItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FriendItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    int j = ((FrameLayout.LayoutParams)this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.getLayoutParams()).leftMargin;
    int i = j;
    Object localObject;
    if (this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.getVisibility() != 8)
    {
      localObject = this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.a();
      if (jdField_a_of_type_JavaUtilMap.containsKey(localObject))
      {
        i = ((Integer)jdField_a_of_type_JavaUtilMap.get(localObject)).intValue();
        this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setFixedWidth(i);
        i = i + jdField_a_of_type_Int + j;
      }
    }
    else
    {
      j = i;
      if (this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView != null)
      {
        j = i;
        if (this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.getVisibility() != 8)
        {
          localObject = this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a();
          if (!jdField_a_of_type_JavaUtilMap.containsKey(localObject)) {
            break label414;
          }
          j = ((Integer)jdField_a_of_type_JavaUtilMap.get(localObject)).intValue();
        }
      }
    }
    for (;;)
    {
      j = i + (j + jdField_a_of_type_Int);
      i = j;
      if (this.jdField_a_of_type_Aidu.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 8)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_Aidu.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = j;
        i = j + (((FrameLayout.LayoutParams)localObject).width + jdField_a_of_type_Int);
      }
      j = i;
      if (this.jdField_a_of_type_Aidu.c.getVisibility() != 8)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_Aidu.c.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = i;
        j = i + (((FrameLayout.LayoutParams)localObject).width + jdField_a_of_type_Int);
      }
      i = j;
      if (this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = j;
        i = j + (((FrameLayout.LayoutParams)localObject).width + jdField_a_of_type_Int);
      }
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_Aidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams()).leftMargin = i;
      i = getContext().getResources().getDimensionPixelSize(2131165605);
      i = this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this, this.jdField_a_of_type_Aidu, i);
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_Aidu.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).rightMargin = i;
      return;
      i = (int)this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.a().measureText((CharSequence)localObject, 0, ((CharSequence)localObject).length());
      jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(i));
      break;
      label414:
      j = this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a();
      jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(j));
    }
  }
  
  public aidu a()
  {
    this.jdField_a_of_type_Aidu = new aidu();
    this.jdField_a_of_type_Aidu.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302061));
    this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)findViewById(2131311221));
    this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)findViewById(2131312449));
    this.jdField_a_of_type_Aidu.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303063));
    this.jdField_a_of_type_Aidu.c = ((ImageView)findViewById(2131303023));
    this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131303025));
    this.jdField_a_of_type_Aidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)findViewById(2131311223));
    this.jdField_a_of_type_Aidu.d = ((ImageView)findViewById(2131303072));
    this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)findViewById(2131304936));
    this.jdField_a_of_type_Aidu.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131302971));
    this.jdField_a_of_type_Aidu.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131305138));
    this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView = ((OnlineStatusView)findViewById(2131300194));
    this.jdField_a_of_type_Aidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(RichStatus.sActionColor, 1);
    this.jdField_a_of_type_Aidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 1);
    this.jdField_a_of_type_Aidu.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(19);
    if (this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView != null) {
      this.jdField_a_of_type_Aidu.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setViewStyle(2);
    }
    if (jdField_a_of_type_Int == 0) {
      jdField_a_of_type_Int = getContext().getResources().getDimensionPixelSize(2131165613);
    }
    return this.jdField_a_of_type_Aidu;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    a();
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.FriendItemLayout
 * JD-Core Version:    0.7.0.1
 */