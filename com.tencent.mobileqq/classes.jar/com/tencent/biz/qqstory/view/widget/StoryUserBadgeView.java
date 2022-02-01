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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import wjj;
import wnz;
import wth;
import wtt;
import yuk;
import yup;
import znw;
import zps;
import zub;

public class StoryUserBadgeView
  extends ImageView
  implements View.OnClickListener, IEventReceiver
{
  private int jdField_a_of_type_Int = 10003;
  private String jdField_a_of_type_JavaLangString;
  private wtt jdField_a_of_type_Wtt;
  private zub jdField_a_of_type_Zub;
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
    this.jdField_a_of_type_Wtt = ((wtt)wth.a(2));
    this.jdField_a_of_type_Zub = new zub(this);
    super.setVisibility(8);
  }
  
  private void c()
  {
    if ("-1".equals(this.jdField_a_of_type_JavaLangString))
    {
      yuk.e("Q.qqstory.StoryUserBadge", "union id = -1, so ignore update");
      return;
    }
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_Wtt.b(this.jdField_a_of_type_JavaLangString);
    zps.a(this);
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
      if (wnz.a())
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
          zps.a(this, str, 50, 50, null, null);
          return;
        }
        super.setImageResource(2130846840);
        return;
      }
      super.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_Wtt.a(localQQUserUIItem.qq))
    {
      this.jdField_a_of_type_Int = 10002;
      super.setVisibility(0);
      super.setOnClickListener(this);
      super.setImageResource(2130846838);
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
    Object localObject = this.jdField_a_of_type_Wtt.b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      yuk.e("Q.qqstory.StoryUserBadge", "reportExposure the null user item");
      return;
    }
    if (((QQUserUIItem)localObject).isMe()) {}
    for (String str = "1";; str = "2")
    {
      localObject = ((QQUserUIItem)localObject).getUserIconUrlKey();
      yup.a("home_page", "exp_medal", this.b, 0, new String[] { str, localObject });
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
    wjj.a().registerSubscriber(this.jdField_a_of_type_Zub);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.jdField_a_of_type_Wtt.b(this.jdField_a_of_type_JavaLangString);
    if (localObject2 == null) {
      yuk.e("Q.qqstory.StoryUserBadge", this.jdField_a_of_type_JavaLangString + ",userItem is null ! plz fix it!");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Int != 10000) && (this.jdField_a_of_type_Int != 10001)) {
        break label186;
      }
      if (!TextUtils.isEmpty(((QQUserUIItem)localObject2).getUserIconJumpURL())) {
        break;
      }
      yuk.e("Q.qqstory.StoryUserBadge", ((QQUserUIItem)localObject2).getUnionId() + ",icon jump url is null!!");
    }
    Object localObject1 = new Intent(getContext(), QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", ((QQUserUIItem)localObject2).getUserIconJumpURL());
    getContext().startActivity((Intent)localObject1);
    label144:
    if (((QQUserUIItem)localObject2).isMe()) {}
    for (localObject1 = "1";; localObject1 = "2")
    {
      localObject2 = ((QQUserUIItem)localObject2).getIconJumpUrlKey();
      yup.a("home_page", "clk_medal", this.b, 0, new String[] { localObject1, localObject2 });
      break;
      label186:
      if (this.jdField_a_of_type_Int != 10002) {
        break label144;
      }
      localObject1 = new Intent(getContext(), SpecailCareListActivity.class);
      getContext().startActivity((Intent)localObject1);
      break label144;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Boolean = false;
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Zub);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void setUnionID(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      znw.a(false, "It is not allow to set the null union id!!!!!!");
      return;
    }
    this.b = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryUserBadgeView
 * JD-Core Version:    0.7.0.1
 */