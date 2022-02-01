package com.tencent.mobileqq.activity.qcircle.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import feedcloud.FeedCloudMeta.StUser;

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
  private int e;
  private int f;
  private int g = 2130844178;
  
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
      this.jdField_a_of_type_Int = ((int)paramContext.getDimension(4, DisplayUtil.a(getContext(), 24.0F)));
      this.jdField_b_of_type_Int = ((int)paramContext.getDimension(1, DisplayUtil.a(getContext(), 24.0F)));
      this.c = paramContext.getColor(5, 0);
      this.d = ((int)paramContext.getDimension(6, 0.0F));
      this.jdField_a_of_type_Boolean = paramContext.getBoolean(0, true);
      this.e = ((int)paramContext.getDimension(3, 0.0F));
      this.f = ((int)paramContext.getDimension(2, 0.0F));
      paramContext.recycle();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = new SquareImageView(getContext(), null, 0);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    if (this.d != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setPadding(this.d, this.d, this.d, this.d);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(90);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundDrawable(getResources().getDrawable(2130840452));
    if (this.c != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundColor(this.c);
    }
    super.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
  }
  
  public void setAuthDrawable(int paramInt)
  {
    this.g = paramInt;
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundResource(paramInt);
    }
  }
  
  public void setAvatar(AppInterface paramAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(paramAppInterface, 1, 4, paramString));
    }
  }
  
  public void setAvatarUrl(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageURL(paramString);
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
      ((FrameLayout.LayoutParams)localObject).rightMargin = this.e;
      ((FrameLayout.LayoutParams)localObject).bottomMargin = this.f;
      this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(90);
      this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView.setBackgroundResource(this.g);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label137;
      }
    }
    label137:
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
      setIsAuth(QCircleHostUtil.isAuth(paramStUser));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleAvatarView
 * JD-Core Version:    0.7.0.1
 */