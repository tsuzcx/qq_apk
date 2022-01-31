package com.tencent.biz.qqstory.view.widget;

import ajjh;
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
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import sku;
import sky;
import vms;
import vqz;

public class StoryQIMBadgeView
  extends ImageView
  implements View.OnClickListener
{
  private static final LruCache<String, Boolean> jdField_a_of_type_AndroidUtilLruCache = new LruCache(50);
  private ajjh jdField_a_of_type_Ajjh;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
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
    if (sku.b()) {
      this.jdField_a_of_type_Ajjh = new vqz(this);
    }
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (TextUtils.isEmpty(paramQQUserUIItem.qq))) {
      setVisibility(8);
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramQQUserUIItem;
        if (!sku.b()) {
          break;
        }
        if ((!this.jdField_a_of_type_Boolean) && (jdField_a_of_type_AndroidUtilLruCache.get(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq) != null))
        {
          a(((Boolean)jdField_a_of_type_AndroidUtilLruCache.get(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq)).booleanValue());
          return;
        }
        if (!this.jdField_a_of_type_Boolean) {
          setVisibility(8);
        }
        paramQQUserUIItem = QQStoryContext.a();
      } while (paramQQUserUIItem == null);
      paramQQUserUIItem = (FriendListHandler)paramQQUserUIItem.getBusinessHandler(1);
    } while (paramQQUserUIItem == null);
    paramQQUserUIItem.c(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
    return;
    a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVipButNoFriend());
  }
  
  public void a(boolean paramBoolean)
  {
    vms.a(this);
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = sky.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          return;
        }
      }
      vms.a(this, this.jdField_a_of_type_JavaLangString, getMeasuredWidth(), getMeasuredHeight(), null, null);
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (sku.b())
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a();
      if (this.jdField_a_of_type_Ajjh != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null) {
      return;
    }
    paramView = paramView.getContext();
    String str = sky.b(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
    Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    paramView.startActivity(localIntent);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((sku.b()) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_Ajjh != null))
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    }
  }
  
  public void setForceRefresh(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView
 * JD-Core Version:    0.7.0.1
 */