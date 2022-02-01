package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryDepends;
import com.tencent.biz.qqstory.boundaries.StoryDepends.QimUtil;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class StoryQIMBadgeView
  extends ImageView
  implements View.OnClickListener
{
  private static final LruCache<String, Boolean> jdField_a_of_type_AndroidUtilLruCache = new LruCache(50);
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  
  public StoryQIMBadgeView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StoryQIMBadgeView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public StoryQIMBadgeView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  @RequiresApi(api=21)
  public StoryQIMBadgeView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
  }
  
  public static void b()
  {
    jdField_a_of_type_AndroidUtilLruCache.evictAll();
  }
  
  protected void a()
  {
    if (StoryDepends.b()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new StoryQIMBadgeView.1(this);
    }
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem != null) && (!TextUtils.isEmpty(paramQQUserUIItem.qq)))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramQQUserUIItem;
      if (StoryDepends.b())
      {
        if ((!this.jdField_a_of_type_Boolean) && (jdField_a_of_type_AndroidUtilLruCache.get(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq) != null))
        {
          a(((Boolean)jdField_a_of_type_AndroidUtilLruCache.get(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq)).booleanValue());
          return;
        }
        if (!this.jdField_a_of_type_Boolean) {
          setVisibility(8);
        }
        paramQQUserUIItem = QQStoryContext.a();
        if (paramQQUserUIItem != null)
        {
          paramQQUserUIItem = (FriendListHandler)paramQQUserUIItem.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          if (paramQQUserUIItem != null) {
            paramQQUserUIItem.getOnlineInfo(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
          }
        }
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVipButNoFriend());
      }
      return;
    }
    setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    UIUtils.a(this);
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = StoryDepends.QimUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          return;
        }
      }
      UIUtils.a(this, this.jdField_a_of_type_JavaLangString, getMeasuredWidth(), getMeasuredHeight(), null, null);
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    setVisibility(i);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (StoryDepends.b())
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a();
      FriendListObserver localFriendListObserver = this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
      if (localFriendListObserver != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(localFriendListObserver);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)
    {
      Context localContext = paramView.getContext();
      String str = StoryDepends.QimUtil.b(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_operation_bar", true);
      localContext.startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (StoryDepends.b())
    {
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localAppInterface != null)
      {
        FriendListObserver localFriendListObserver = this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
        if (localFriendListObserver != null)
        {
          localAppInterface.removeObserver(localFriendListObserver);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
        }
      }
    }
  }
  
  public void setForceRefresh(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView
 * JD-Core Version:    0.7.0.1
 */