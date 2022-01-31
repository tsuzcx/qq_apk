package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import umc;
import uqs;
import uwa;
import uwm;
import wxe;
import wxj;
import xqq;
import xsm;
import xwv;

public class StoryUserBadgeView
  extends ImageView
  implements View.OnClickListener, IEventReceiver
{
  private int jdField_a_of_type_Int = 10003;
  private String jdField_a_of_type_JavaLangString;
  private uwm jdField_a_of_type_Uwm;
  private xwv jdField_a_of_type_Xwv;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public StoryUserBadgeView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public StoryUserBadgeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public StoryUserBadgeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Uwm = ((uwm)uwa.a(2));
    this.jdField_a_of_type_Xwv = new xwv(this);
    super.setVisibility(8);
  }
  
  private void c()
  {
    if ("-1".equals(this.jdField_a_of_type_JavaLangString))
    {
      wxe.e("Q.qqstory.StoryUserBadge", "union id = -1, so ignore update");
      return;
    }
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_Uwm.b(this.jdField_a_of_type_JavaLangString);
    xsm.a(this);
    if (localQQUserUIItem == null)
    {
      this.jdField_a_of_type_Int = 10003;
      super.setVisibility(8);
      super.setOnClickListener(null);
      return;
    }
    String str = localQQUserUIItem.getUserIconUrl();
    if ((!TextUtils.isEmpty(str)) || (localQQUserUIItem.isVipButNoFriend()))
    {
      if (uqs.a())
      {
        if (localQQUserUIItem.isVipButNoFriend()) {}
        for (int i = 10000;; i = 10001)
        {
          this.jdField_a_of_type_Int = i;
          super.setVisibility(0);
          super.setOnClickListener(this);
          if (TextUtils.isEmpty(str)) {
            break;
          }
          xsm.a(this, str, 50, 50, null, null);
          return;
        }
        super.setImageResource(2130846385);
        return;
      }
      super.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_Uwm.a(localQQUserUIItem.qq))
    {
      this.jdField_a_of_type_Int = 10002;
      super.setVisibility(0);
      super.setOnClickListener(this);
      super.setImageResource(2130846383);
      return;
    }
    this.jdField_a_of_type_Int = 10003;
    super.setVisibility(8);
    super.setOnClickListener(null);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_Uwm.b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      wxe.e("Q.qqstory.StoryUserBadge", "reportExposure the null user item");
      return;
    }
    if (((QQUserUIItem)localObject).isMe()) {}
    for (String str = "1";; str = "2")
    {
      localObject = ((QQUserUIItem)localObject).getUserIconUrlKey();
      wxj.a("home_page", "exp_medal", this.b, 0, new String[] { str, localObject });
      return;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    setUnionID(paramString, this.b);
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Boolean = true;
    umc.a().registerSubscriber(this.jdField_a_of_type_Xwv);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Uwm.b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      wxe.e("Q.qqstory.StoryUserBadge", this.jdField_a_of_type_JavaLangString + ",userItem is null ! plz fix it!");
      return;
    }
    if ((this.jdField_a_of_type_Int == 10000) || (this.jdField_a_of_type_Int == 10001))
    {
      if (TextUtils.isEmpty(((QQUserUIItem)localObject).getUserIconJumpURL()))
      {
        wxe.e("Q.qqstory.StoryUserBadge", ((QQUserUIItem)localObject).getUnionId() + ",icon jump url is null!!");
        return;
      }
      paramView = new Intent(getContext(), QQBrowserActivity.class);
      paramView.putExtra("url", ((QQUserUIItem)localObject).getUserIconJumpURL());
      getContext().startActivity(paramView);
      if (!((QQUserUIItem)localObject).isMe()) {
        break label210;
      }
    }
    label210:
    for (paramView = "1";; paramView = "2")
    {
      localObject = ((QQUserUIItem)localObject).getIconJumpUrlKey();
      wxj.a("home_page", "clk_medal", this.b, 0, new String[] { paramView, localObject });
      return;
      if (this.jdField_a_of_type_Int != 10002) {
        break;
      }
      paramView = new Intent(getContext(), SpecailCareListActivity.class);
      getContext().startActivity(paramView);
      break;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Boolean = false;
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Xwv);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void setUnionID(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      xqq.a(false, "It is not allow to set the null union id!!!!!!");
      return;
    }
    this.b = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryUserBadgeView
 * JD-Core Version:    0.7.0.1
 */