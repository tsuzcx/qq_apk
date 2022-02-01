package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.StoryDispatcher;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
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
    if ("-1".equals(this.jdField_a_of_type_JavaLangString))
    {
      SLog.e("Q.qqstory.StoryUserBadge", "union id = -1, so ignore update");
      return;
    }
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
    if ((TextUtils.isEmpty(str)) && (!localQQUserUIItem.isVipButNoFriend()))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.a(localQQUserUIItem.qq))
      {
        this.jdField_a_of_type_Int = 10002;
        super.setVisibility(0);
        super.setOnClickListener(this);
        super.setImageResource(2130847060);
        return;
      }
      this.jdField_a_of_type_Int = 10003;
      super.setVisibility(8);
      super.setOnClickListener(null);
      return;
    }
    if (StoryDepends.QimUtil.a())
    {
      int i;
      if (localQQUserUIItem.isVipButNoFriend()) {
        i = 10000;
      } else {
        i = 10001;
      }
      this.jdField_a_of_type_Int = i;
      super.setVisibility(0);
      super.setOnClickListener(this);
      if (!TextUtils.isEmpty(str))
      {
        UIUtils.a(this, str, 50, 50, null, null);
        return;
      }
      super.setImageResource(2130847062);
      return;
    }
    super.setVisibility(8);
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
    String str;
    if (((QQUserUIItem)localObject).isMe()) {
      str = "1";
    } else {
      str = "2";
    }
    localObject = ((QQUserUIItem)localObject).getUserIconUrlKey();
    StoryReportor.a("home_page", "exp_medal", this.b, 0, new String[] { str, localObject });
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
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView$UserIconUpdateReceiver);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.b(this.jdField_a_of_type_JavaLangString);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(",userItem is null ! plz fix it!");
      SLog.e("Q.qqstory.StoryUserBadge", ((StringBuilder)localObject1).toString());
    }
    else
    {
      int i = this.jdField_a_of_type_Int;
      if ((i != 10000) && (i != 10001))
      {
        if (i == 10002)
        {
          localObject1 = new Intent(getContext(), SpecailCareListActivity.class);
          getContext().startActivity((Intent)localObject1);
        }
      }
      else
      {
        if (TextUtils.isEmpty(((QQUserUIItem)localObject2).getUserIconJumpURL()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((QQUserUIItem)localObject2).getUnionId());
          ((StringBuilder)localObject1).append(",icon jump url is null!!");
          SLog.e("Q.qqstory.StoryUserBadge", ((StringBuilder)localObject1).toString());
          break label239;
        }
        localObject1 = new Intent(getContext(), QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", ((QQUserUIItem)localObject2).getUserIconJumpURL());
        getContext().startActivity((Intent)localObject1);
      }
      if (((QQUserUIItem)localObject2).isMe()) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      localObject2 = ((QQUserUIItem)localObject2).getIconJumpUrlKey();
      StoryReportor.a("home_page", "clk_medal", this.b, 0, new String[] { localObject1, localObject2 });
    }
    label239:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Boolean = false;
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView$UserIconUpdateReceiver);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void setUnionID(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AssertUtils.assertTrue(false, "It is not allow to set the null union id!!!!!!");
      return;
    }
    this.b = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryUserBadgeView
 * JD-Core Version:    0.7.0.1
 */