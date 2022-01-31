package com.tencent.mobileqq.activity.contact;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.adapter.contacts.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.widget.AlphaDrawable;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.Map;

public class FriendItemLayout
  extends FrameLayout
{
  private static int jdField_a_of_type_Int;
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap(5);
  private BuddyListFriends.BuddyChildTag jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag;
  
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
    int j = ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.getLayoutParams()).leftMargin;
    int i = j;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.getVisibility() != 8)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.a();
      if (jdField_a_of_type_JavaUtilMap.containsKey(localObject))
      {
        i = ((Integer)jdField_a_of_type_JavaUtilMap.get(localObject)).intValue();
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setFixedWidth(i);
        i = i + jdField_a_of_type_Int + j;
      }
    }
    else
    {
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 8)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = i;
        j = i + (((FrameLayout.LayoutParams)localObject).width + jdField_a_of_type_Int);
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 8)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = j;
        i = j + (((FrameLayout.LayoutParams)localObject).width + jdField_a_of_type_Int);
      }
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams()).leftMargin = i;
      j = getContext().getResources().getDimensionPixelSize(2131558646);
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.e.getVisibility() != 8) {
        i = j + this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.e.getLayoutParams().width;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.g.getVisibility() != 8) {
        j = i + this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.g.getLayoutParams().width;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.f.getVisibility() != 8) {
        i = j + this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.f.getLayoutParams().width;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.h.getVisibility() != 8) {
        j = i + this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.h.getLayoutParams().width;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        i = j + this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().width;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.i.getVisibility() == 8) {
        break label470;
      }
      i += this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.i.getLayoutParams().width;
    }
    label470:
    for (;;)
    {
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).rightMargin = i;
      return;
      i = (int)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.a().measureText((CharSequence)localObject, 0, ((CharSequence)localObject).length());
      jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(i));
      break;
    }
  }
  
  public BuddyListFriends.BuddyChildTag a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag = new BuddyListFriends.BuddyChildTag();
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362724));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)findViewById(2131363921));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)findViewById(2131363923));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363924));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363925));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)findViewById(2131363926));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363909));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.e = ((ImageView)findViewById(2131363912));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.f = ((ImageView)findViewById(2131363911));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131363922));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.g = ((ImageView)findViewById(2131363916));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.h = ((ImageView)findViewById(2131363918));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable = new AlphaDrawable(getContext());
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_d_of_type_ComTencentWidgetAlphaDrawable = new AlphaDrawable(getContext());
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable = new AlphaDrawable(getContext());
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363919));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.i = ((ImageView)findViewById(2131363914));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable = new AlphaDrawable(getContext());
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363920));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(RichStatus.sActionColor, 1);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 1);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(19);
    if (jdField_a_of_type_Int == 0) {
      jdField_a_of_type_Int = getContext().getResources().getDimensionPixelSize(2131558644);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    a();
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.FriendItemLayout
 * JD-Core Version:    0.7.0.1
 */