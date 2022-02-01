package com.tencent.mobileqq.activity.contacts.troop;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;

public class BuddyListTroop
  extends BuddyListItem
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131693107 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839650 };
  private static final int[] c = { 2131371189 };
  private DiscussionManager jdField_a_of_type_ComTencentMobileqqAppDiscussionManager;
  private int jdField_b_of_type_Int;
  
  public BuddyListTroop(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(this.jdField_a_of_type_AndroidContentContext);
    if (paramInt == 2) {
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof BuddyListTroop.TroopDisChildTag)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559174, null);
      paramViewGroup = new BuddyListTroop.TroopDisChildTag();
      paramView = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379092));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131368603));
      ((RelativeLayout.LayoutParams)paramViewGroup.d.getLayoutParams()).leftMargin = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379094));
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setBackgroundResource(2130839537);
      if (this.jdField_b_of_type_Int != 2) {
        break label279;
      }
      localObject = (DiscussionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_b_of_type_Int = 101;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionInfo)localObject).discussionName);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject).uin)) }));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167040));
      a(paramView, paramInt2, paramViewGroup, paramOnClickListener);
      return paramView;
      paramViewGroup = (BuddyListTroop.TroopDisChildTag)paramView.getTag();
      break;
      label279:
      localObject = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject).troopuin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_b_of_type_Int = 4;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localObject).getTroopDisplayName());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    paramInt = 0;
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfSwipRightMenuItem.length < 0)
      {
        paramArrayOfSwipRightMenuItem[0].jdField_b_of_type_Int = 0;
        paramArrayOfSwipRightMenuItem[0].jdField_a_of_type_Int = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfSwipRightMenuItem[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
      }
    }
  }
  
  public int[] a()
  {
    return c;
  }
  
  public int[] b()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] c()
  {
    return jdField_b_of_type_ArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.BuddyListTroop
 * JD-Core Version:    0.7.0.1
 */