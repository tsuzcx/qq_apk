package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class NewFriendTabEmptyBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private boolean a;
  
  public NewFriendTabEmptyBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public View a(int paramInt, View paramView)
  {
    NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder localNewFriendTabEmptyHolder;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder)))
    {
      localNewFriendTabEmptyHolder = new NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561409, null);
      localNewFriendTabEmptyHolder.a = ((LinearLayout)paramView.findViewById(2131365279));
      localNewFriendTabEmptyHolder.b = ((LinearLayout)paramView.findViewById(2131365274));
      localObject = (ThemeImageView)paramView.findViewById(2131366337);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(ThemeImageWrapper.MODE_SQURE);
      paramView.setTag(localNewFriendTabEmptyHolder);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166) - ViewUtils.a(80.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramView, paramInt);
      localNewFriendTabEmptyHolder.a.setVisibility(8);
      localNewFriendTabEmptyHolder.b.setVisibility(0);
      return paramView;
      localNewFriendTabEmptyHolder = (NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder)paramView.getTag();
    }
    a(paramView, paramInt);
    localNewFriendTabEmptyHolder.a.setVisibility(0);
    localNewFriendTabEmptyHolder.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendTabEmptyBuilder
 * JD-Core Version:    0.7.0.1
 */