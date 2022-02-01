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
  private static final int[] k = { 2131890181 };
  private static final int[] l = { 2130839699 };
  private static final int[] m = { 2131438137 };
  private DiscussionManager n;
  private int o;
  
  public BuddyListTroop(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.o = paramInt;
    this.a = a(this.e);
    if (paramInt == 2) {
      this.n = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    }
    this.b = 0;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListTroop.TroopDisChildTag)))
    {
      paramViewGroup = (BuddyListTroop.TroopDisChildTag)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(this.e).inflate(2131624728, null);
      paramViewGroup = new BuddyListTroop.TroopDisChildTag();
      paramView = this.a.createView(this.e, paramView, paramViewGroup, -1);
      paramViewGroup.e = ((TextView)paramView.findViewById(2131447063));
      paramViewGroup.r = ((ImageView)paramView.findViewById(2131435219));
      ((RelativeLayout.LayoutParams)paramViewGroup.r.getLayoutParams()).leftMargin = AIOUtils.b(12.0F, this.e.getResources());
      paramViewGroup.f = ((TextView)paramView.findViewById(2131447065));
      paramView.setTag(paramViewGroup);
    }
    paramViewGroup.leftView.setBackgroundResource(2130839577);
    Object localObject;
    if (this.o == 2)
    {
      localObject = (DiscussionInfo)this.f;
      paramViewGroup.p = ((DiscussionInfo)localObject).uin;
      paramViewGroup.c = localObject;
      paramViewGroup.q = 101;
      paramViewGroup.e.setText(((DiscussionInfo)localObject).discussionName);
      paramViewGroup.f.setVisibility(0);
      paramViewGroup.f.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.n.c(((DiscussionInfo)localObject).uin)) }));
    }
    else
    {
      localObject = (TroopInfo)this.f;
      paramViewGroup.p = ((TroopInfo)localObject).troopuin;
      paramViewGroup.c = localObject;
      paramViewGroup.q = 4;
      paramViewGroup.e.setText(((TroopInfo)localObject).getTroopDisplayName());
      paramViewGroup.f.setVisibility(8);
    }
    paramViewGroup.e.setTextColor(this.e.getResources().getColor(2131168001));
    a(paramView, paramInt2, paramViewGroup, paramOnClickListener);
    return paramView;
  }
  
  protected void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    if (paramArrayOfSwipRightMenuItem != null)
    {
      if (paramArrayOfSwipRightMenuItem.length <= 0) {
        return;
      }
      int i = paramArrayOfSwipRightMenuItem.length;
      paramInt = 0;
      if (i > 0)
      {
        paramArrayOfSwipRightMenuItem[0].menuId = 0;
        paramArrayOfSwipRightMenuItem[0].menuType = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].menuId = -1;
        paramArrayOfSwipRightMenuItem[paramInt].menuType = -1;
        paramInt += 1;
      }
    }
  }
  
  protected int[] c()
  {
    return m;
  }
  
  protected int[] d()
  {
    return k;
  }
  
  protected int[] e()
  {
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.BuddyListTroop
 * JD-Core Version:    0.7.0.1
 */