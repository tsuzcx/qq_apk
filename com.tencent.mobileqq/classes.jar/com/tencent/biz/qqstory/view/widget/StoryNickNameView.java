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
  private String a;
  private StoryNickNameView.UserInfoReceiver b;
  private boolean c;
  private LruCache<String, QQUserUIItem> d;
  private boolean e = false;
  private String f;
  
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
    return (QQUserUIItem)this.d.get(paramString);
  }
  
  private void a()
  {
    this.b = new StoryNickNameView.UserInfoReceiver(this);
    this.c = false;
  }
  
  private void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestUserInfoAsync : ");
    ((StringBuilder)localObject).append(this.a);
    SLog.d("Q.qqstoryStoryNickNameView", ((StringBuilder)localObject).toString());
    localObject = new QQUserUIItem.UserID("", this.a);
    GetUserInfoHandler localGetUserInfoHandler = new GetUserInfoHandler();
    localGetUserInfoHandler.f = "Q.qqstoryStoryNickNameView";
    localGetUserInfoHandler.a(1, (QQUserUIItem.UserID)localObject, this.a);
  }
  
  private void b(QQUserUIItem paramQQUserUIItem)
  {
    this.d.put(paramQQUserUIItem.getUnionId(), paramQQUserUIItem);
  }
  
  public void a(LruCache<String, QQUserUIItem> paramLruCache)
  {
    AssertUtils.checkNotNull(paramLruCache);
    this.d = paramLruCache;
  }
  
  protected void a(QQUserUIItem paramQQUserUIItem)
  {
    AssertUtils.checkNotNull(paramQQUserUIItem);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInfoRespond ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" name = ");
    ((StringBuilder)localObject).append(paramQQUserUIItem.getDisplayName());
    SLog.d("Q.qqstoryStoryNickNameView", ((StringBuilder)localObject).toString());
    localObject = paramQQUserUIItem.getDisplayName();
    if (!TextUtils.isEmpty(this.f)) {
      localObject = String.format(this.f, new Object[] { paramQQUserUIItem.getDisplayName() });
    }
    setText((CharSequence)localObject);
  }
  
  public String getUnionId()
  {
    return this.a;
  }
  
  public boolean isValidate()
  {
    return this.e;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    StoryDispatcher.a().registerSubscriber(this.b);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    StoryDispatcher.a().unRegisterSubscriber(this.b);
  }
  
  public void setFormat(String paramString)
  {
    this.f = paramString;
  }
  
  public void setUnionId(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      setVisibility(8);
      this.a = "";
      this.e = false;
      return;
    }
    boolean bool;
    if (this.d != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool, "it must prepare this view before setUnionId!!");
    setVisibility(0);
    this.e = true;
    if (TextUtils.equals(this.a, paramString)) {
      return;
    }
    this.a = paramString;
    setText("");
    paramString = a(this.a);
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