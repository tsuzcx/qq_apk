package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;

public class StoryNickNameView
  extends TextView
  implements IEventReceiver
{
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache;
  private StoryNickNameView.UserInfoReceiver jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView$UserInfoReceiver;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  
  public StoryNickNameView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryNickNameView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public StoryNickNameView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private QQUserUIItem a(String paramString)
  {
    return (QQUserUIItem)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView$UserInfoReceiver = new StoryNickNameView.UserInfoReceiver(this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestUserInfoAsync : ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    SLog.d("Q.qqstoryStoryNickNameView", ((StringBuilder)localObject).toString());
    localObject = new QQUserUIItem.UserID("", this.jdField_a_of_type_JavaLangString);
    GetUserInfoHandler localGetUserInfoHandler = new GetUserInfoHandler();
    localGetUserInfoHandler.jdField_a_of_type_JavaLangString = "Q.qqstoryStoryNickNameView";
    localGetUserInfoHandler.a(1, (QQUserUIItem.UserID)localObject, this.jdField_a_of_type_JavaLangString);
  }
  
  private void b(QQUserUIItem paramQQUserUIItem)
  {
    this.jdField_a_of_type_AndroidUtilLruCache.put(paramQQUserUIItem.getUnionId(), paramQQUserUIItem);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(LruCache<String, QQUserUIItem> paramLruCache)
  {
    AssertUtils.checkNotNull(paramLruCache);
    this.jdField_a_of_type_AndroidUtilLruCache = paramLruCache;
  }
  
  protected void a(QQUserUIItem paramQQUserUIItem)
  {
    AssertUtils.checkNotNull(paramQQUserUIItem);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInfoRespond ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" name = ");
    ((StringBuilder)localObject).append(paramQQUserUIItem.getDisplayName());
    SLog.d("Q.qqstoryStoryNickNameView", ((StringBuilder)localObject).toString());
    localObject = paramQQUserUIItem.getDisplayName();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localObject = String.format(this.jdField_b_of_type_JavaLangString, new Object[] { paramQQUserUIItem.getDisplayName() });
    }
    setText((CharSequence)localObject);
  }
  
  public boolean isValidate()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView$UserInfoReceiver);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView$UserInfoReceiver);
  }
  
  public void setFormat(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setUnionId(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      setVisibility(8);
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    boolean bool;
    if (this.jdField_a_of_type_AndroidUtilLruCache != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool, "it must prepare this view before setUnionId!!");
    setVisibility(0);
    this.jdField_b_of_type_Boolean = true;
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    setText("");
    paramString = a(this.jdField_a_of_type_JavaLangString);
    if (paramString == null)
    {
      b();
      return;
    }
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryNickNameView
 * JD-Core Version:    0.7.0.1
 */