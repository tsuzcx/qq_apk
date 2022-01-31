package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import umc;
import uxh;
import vdj;
import wxe;
import xqq;
import xws;

public class StoryNickNameView
  extends TextView
  implements IEventReceiver
{
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache;
  private String jdField_a_of_type_JavaLangString;
  private xws jdField_a_of_type_Xws;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
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
    this.jdField_a_of_type_Xws = new xws(this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b()
  {
    wxe.d("Q.qqstoryStoryNickNameView", "requestUserInfoAsync : " + this.jdField_a_of_type_JavaLangString);
    uxh localuxh = new uxh("", this.jdField_a_of_type_JavaLangString);
    vdj localvdj = new vdj();
    localvdj.jdField_a_of_type_JavaLangString = "Q.qqstoryStoryNickNameView";
    localvdj.a(1, localuxh, this.jdField_a_of_type_JavaLangString);
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
    xqq.a(paramLruCache);
    this.jdField_a_of_type_AndroidUtilLruCache = paramLruCache;
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    xqq.a(paramQQUserUIItem);
    wxe.d("Q.qqstoryStoryNickNameView", "onInfoRespond " + this.jdField_a_of_type_JavaLangString + " name = " + paramQQUserUIItem.getDisplayName());
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    umc.a().registerSubscriber(this.jdField_a_of_type_Xws);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Xws);
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
      xqq.a(bool, "it must prepare this view before setUnionId!!");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryNickNameView
 * JD-Core Version:    0.7.0.1
 */