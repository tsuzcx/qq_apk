package com.tencent.mobileqq.activity.contacts.friend;

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
  private BuddyListFriends.BuddyChildTag jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag;
  
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
    int j = ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.getLayoutParams()).leftMargin;
    int i = j;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.getVisibility() != 8)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.a();
      if (jdField_a_of_type_JavaUtilMap.containsKey(localObject))
      {
        i = ((Integer)jdField_a_of_type_JavaUtilMap.get(localObject)).intValue();
      }
      else
      {
        i = (int)this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.a().measureText((CharSequence)localObject, 0, ((CharSequence)localObject).length());
        jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(i));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setFixedWidth(i);
      i = j + (i + jdField_a_of_type_Int);
    }
    j = i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView != null)
    {
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.getVisibility() != 8)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a();
        if (jdField_a_of_type_JavaUtilMap.containsKey(localObject))
        {
          j = ((Integer)jdField_a_of_type_JavaUtilMap.get(localObject)).intValue();
        }
        else
        {
          j = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a();
          jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(j));
        }
        j = i + (j + jdField_a_of_type_Int);
      }
    }
    i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8)
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = j;
      i = j + (((FrameLayout.LayoutParams)localObject).width + jdField_a_of_type_Int);
    }
    j = i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 8)
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = i;
      j = i + (((FrameLayout.LayoutParams)localObject).width + jdField_a_of_type_Int);
    }
    i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8)
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = j;
      i = j + (((FrameLayout.LayoutParams)localObject).width + jdField_a_of_type_Int);
    }
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams()).leftMargin = i;
    i = getContext().getResources().getDimensionPixelSize(2131296811);
    i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag, i);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).rightMargin = i;
  }
  
  public BuddyListFriends.BuddyChildTag a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag = new BuddyListFriends.BuddyChildTag();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.d = ((ImageView)findViewById(2131368343));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)findViewById(2131378461));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)findViewById(2131379798));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369507));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369457));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369459));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)findViewById(2131378463));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.c = ((ImageView)findViewById(2131369520));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)findViewById(2131371664));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369398));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371856));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView = ((OnlineStatusView)findViewById(2131366371));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(RichStatus.sActionColor, 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(19);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setViewStyle(2);
    }
    if (jdField_a_of_type_Int == 0) {
      jdField_a_of_type_Int = getContext().getResources().getDimensionPixelSize(2131296819);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListFriends$BuddyChildTag;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    a();
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout
 * JD-Core Version:    0.7.0.1
 */