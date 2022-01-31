package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.boundaries.StoryDepends.QimUtil;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;

public class StoryUserBadgeView
  extends ImageView
  implements View.OnClickListener, IEventReceiver
{
  private int jdField_a_of_type_Int = 10003;
  private UserManager jdField_a_of_type_ComTencentBizQqstoryModelUserManager;
  private StoryUserBadgeView.UserIconUpdateReceiver jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView$UserIconUpdateReceiver;
  private String jdField_a_of_type_JavaLangString;
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
    this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager = ((UserManager)SuperManager.a(2));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView$UserIconUpdateReceiver = new StoryUserBadgeView.UserIconUpdateReceiver(this);
    super.setVisibility(8);
  }
  
  private void c()
  {
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.b(this.jdField_a_of_type_JavaLangString);
    UIUtils.a(this);
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
      if (StoryDepends.QimUtil.a())
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
          UIUtils.a(this, str, 50, 50, null, null);
          return;
        }
        super.setImageResource(2130843814);
        return;
      }
      super.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.a(localQQUserUIItem.qq))
    {
      this.jdField_a_of_type_Int = 10002;
      super.setVisibility(0);
      super.setOnClickListener(this);
      super.setImageResource(2130843812);
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
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      SLog.e("Q.qqstory.StoryUserBadge", "reportExposure the null user item");
      return;
    }
    if (((QQUserUIItem)localObject).isMe()) {}
    for (String str = "1";; str = "2")
    {
      localObject = ((QQUserUIItem)localObject).getUserIconUrlKey();
      StoryReportor.a("home_page", "exp_medal", this.b, 0, new String[] { str, localObject });
      return;
    }
  }
  
  protected void a(@NonNull String paramString)
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
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView$UserIconUpdateReceiver);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      SLog.e("Q.qqstory.StoryUserBadge", this.jdField_a_of_type_JavaLangString + ",userItem is null ! plz fix it!");
      return;
    }
    if ((this.jdField_a_of_type_Int == 10000) || (this.jdField_a_of_type_Int == 10001))
    {
      if (TextUtils.isEmpty(((QQUserUIItem)localObject).getUserIconJumpURL()))
      {
        SLog.e("Q.qqstory.StoryUserBadge", ((QQUserUIItem)localObject).getUnionId() + ",icon jump url is null!!");
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
      StoryReportor.a("home_page", "clk_medal", this.b, 0, new String[] { paramView, localObject });
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
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView$UserIconUpdateReceiver);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void setUnionID(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      AssertUtils.a(false, "It is not allow to set the null union id!!!!!!");
    }
    this.b = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryUserBadgeView
 * JD-Core Version:    0.7.0.1
 */