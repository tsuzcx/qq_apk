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
    SLog.d("Q.qqstoryStoryNickNameView", "requestUserInfoAsync : " + this.jdField_a_of_type_JavaLangString);
    QQUserUIItem.UserID localUserID = new QQUserUIItem.UserID("", this.jdField_a_of_type_JavaLangString);
    GetUserInfoHandler localGetUserInfoHandler = new GetUserInfoHandler();
    localGetUserInfoHandler.jdField_a_of_type_JavaLangString = "Q.qqstoryStoryNickNameView";
    localGetUserInfoHandler.a(1, localUserID, this.jdField_a_of_type_JavaLangString);
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
    AssertUtils.a(paramLruCache);
    this.jdField_a_of_type_AndroidUtilLruCache = paramLruCache;
  }
  
  protected void a(QQUserUIItem paramQQUserUIItem)
  {
    AssertUtils.a(paramQQUserUIItem);
    SLog.d("Q.qqstoryStoryNickNameView", "onInfoRespond " + this.jdField_a_of_type_JavaLangString + " name = " + paramQQUserUIItem.getDisplayName());
    String str = paramQQUserUIItem.getDisplayName();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      str = String.format(this.jdField_b_of_type_JavaLangString, new Object[] { paramQQUserUIItem.getDisplayName() });
    }
    setText(str);
  }
  
  public boolean isValidate()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView$UserInfoReceiver);
  }
  
  public void onDetachedFromWindow()
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
    if (this.jdField_a_of_type_AndroidUtilLruCache != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool, "it must prepare this view before setUnionId!!");
      setVisibility(0);
      this.jdField_b_of_type_Boolean = true;
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      setText("");
      paramString = a(this.jdField_a_of_type_JavaLangString);
      if (paramString != null) {
        break label95;
      }
      b();
      return;
    }
    label95:
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryNickNameView
 * JD-Core Version:    0.7.0.1
 */