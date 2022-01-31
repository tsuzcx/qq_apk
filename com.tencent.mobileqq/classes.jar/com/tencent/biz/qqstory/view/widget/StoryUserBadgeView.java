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
import sgi;
import sky;
import sqg;
import sqs;
import urk;
import urp;
import vkw;
import vms;
import vrb;

public class StoryUserBadgeView
  extends ImageView
  implements View.OnClickListener, IEventReceiver
{
  private int jdField_a_of_type_Int = 10003;
  private String jdField_a_of_type_JavaLangString;
  private sqs jdField_a_of_type_Sqs;
  private vrb jdField_a_of_type_Vrb;
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
    this.jdField_a_of_type_Sqs = ((sqs)sqg.a(2));
    this.jdField_a_of_type_Vrb = new vrb(this);
    super.setVisibility(8);
  }
  
  private void c()
  {
    if ("-1".equals(this.jdField_a_of_type_JavaLangString))
    {
      urk.e("Q.qqstory.StoryUserBadge", "union id = -1, so ignore update");
      return;
    }
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_Sqs.b(this.jdField_a_of_type_JavaLangString);
    vms.a(this);
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
      if (sky.a())
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
          vms.a(this, str, 50, 50, null, null);
          return;
        }
        super.setImageResource(2130845745);
        return;
      }
      super.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_Sqs.a(localQQUserUIItem.qq))
    {
      this.jdField_a_of_type_Int = 10002;
      super.setVisibility(0);
      super.setOnClickListener(this);
      super.setImageResource(2130845743);
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
    Object localObject = this.jdField_a_of_type_Sqs.b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      urk.e("Q.qqstory.StoryUserBadge", "reportExposure the null user item");
      return;
    }
    if (((QQUserUIItem)localObject).isMe()) {}
    for (String str = "1";; str = "2")
    {
      localObject = ((QQUserUIItem)localObject).getUserIconUrlKey();
      urp.a("home_page", "exp_medal", this.b, 0, new String[] { str, localObject });
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
    sgi.a().registerSubscriber(this.jdField_a_of_type_Vrb);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_Sqs.b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      urk.e("Q.qqstory.StoryUserBadge", this.jdField_a_of_type_JavaLangString + ",userItem is null ! plz fix it!");
      return;
    }
    if ((this.jdField_a_of_type_Int == 10000) || (this.jdField_a_of_type_Int == 10001))
    {
      if (TextUtils.isEmpty(((QQUserUIItem)localObject).getUserIconJumpURL()))
      {
        urk.e("Q.qqstory.StoryUserBadge", ((QQUserUIItem)localObject).getUnionId() + ",icon jump url is null!!");
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
      urp.a("home_page", "clk_medal", this.b, 0, new String[] { paramView, localObject });
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
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Vrb);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void setUnionID(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      vkw.a(false, "It is not allow to set the null union id!!!!!!");
      return;
    }
    this.b = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryUserBadgeView
 * JD-Core Version:    0.7.0.1
 */