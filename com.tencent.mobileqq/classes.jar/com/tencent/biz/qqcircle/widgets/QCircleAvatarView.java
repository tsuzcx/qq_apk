package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bdaq;
import bdbk;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import feedcloud.FeedCloudMeta.StUser;
import tql;
import tra;

public class QCircleAvatarView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private SquareImageView jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
  private int c;
  private int d;
  private int e = 2130843537;
  
  public QCircleAvatarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleAvatarView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleAvatarView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QCircleAvatarView);
    if (paramContext != null)
    {
      this.jdField_a_of_type_Int = ((int)paramContext.getDimension(2, bdaq.a(getContext(), 24.0F)));
      this.jdField_b_of_type_Int = ((int)paramContext.getDimension(1, bdaq.a(getContext(), 24.0F)));
      this.c = paramContext.getColor(3, 0);
      this.d = ((int)paramContext.getDimension(4, 0.0F));
      this.jdField_a_of_type_Boolean = paramContext.getBoolean(0, true);
      paramContext.recycle();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = new SquareImageView(getContext(), null, 0);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    if (this.d != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setPadding(this.d, this.d, this.d, this.d);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(90);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundDrawable(getResources().getDrawable(2130840085));
    if (this.c != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundColor(this.c);
    }
    super.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
  }
  
  public void setAuthDrawable(int paramInt)
  {
    this.e = paramInt;
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundResource(paramInt);
    }
  }
  
  public void setAvatar(AppInterface paramAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundDrawable(bdbk.a(paramAppInterface, 1, 4, paramString));
    }
  }
  
  public void setAvatarUrl(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
      tql.a(paramString, this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
    }
  }
  
  public void setIsAuth(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView = new SquareImageView(getContext(), null, 0);
      localObject = new FrameLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      ((FrameLayout.LayoutParams)localObject).gravity = 85;
      this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(90);
      this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundResource(this.e);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label121;
      }
    }
    label121:
    for (int i = 0;; i = 8)
    {
      ((SquareImageView)localObject).setVisibility(i);
      super.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView);
      if ((!this.jdField_a_of_type_Boolean) || (!paramBoolean)) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
  }
  
  public void setUser(AppInterface paramAppInterface, FeedCloudMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (!TextUtils.isEmpty(paramStUser.id.get())))
    {
      setAvatar(paramAppInterface, paramStUser.id.get());
      setIsAuth(tra.c(paramStUser));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAvatarView
 * JD-Core Version:    0.7.0.1
 */