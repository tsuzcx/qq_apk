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
  private SquareImageView a;
  private SquareImageView b;
  private int c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private int h;
  private int i;
  private int j = 2130845036;
  
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
      this.c = ((int)paramContext.getDimension(4, DisplayUtil.a(getContext(), 24.0F)));
      this.d = ((int)paramContext.getDimension(1, DisplayUtil.a(getContext(), 24.0F)));
      this.e = paramContext.getColor(5, 0);
      this.f = ((int)paramContext.getDimension(6, 0.0F));
      this.g = paramContext.getBoolean(0, true);
      this.h = ((int)paramContext.getDimension(3, 0.0F));
      this.i = ((int)paramContext.getDimension(2, 0.0F));
      paramContext.recycle();
    }
    this.a = new SquareImageView(getContext(), null, 0);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    int k = this.f;
    if (k != 0) {
      this.a.setPadding(k, k, k, k);
    }
    this.a.setLayoutParams(paramContext);
    this.a.setRoundRect(90);
    this.a.setBackgroundDrawable(getResources().getDrawable(2130841060));
    k = this.e;
    if (k != 0) {
      this.a.setBackgroundColor(k);
    }
    super.addView(this.a);
  }
  
  public SquareImageView getAvatarView()
  {
    return this.a;
  }
  
  public void setAuthDrawable(int paramInt)
  {
    this.j = paramInt;
    SquareImageView localSquareImageView = this.b;
    if (localSquareImageView != null) {
      localSquareImageView.setBackgroundResource(paramInt);
    }
  }
  
  public void setAvatar(AppInterface paramAppInterface, String paramString)
  {
    SquareImageView localSquareImageView = this.a;
    if (localSquareImageView != null) {
      localSquareImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(paramAppInterface, 1, 4, paramString));
    }
  }
  
  public void setAvatarUrl(String paramString)
  {
    SquareImageView localSquareImageView = this.a;
    if (localSquareImageView != null) {
      localSquareImageView.setImageURL(paramString);
    }
  }
  
  public void setIsAuth(boolean paramBoolean)
  {
    if (this.b == null)
    {
      this.b = new SquareImageView(getContext(), null, 0);
      Object localObject = new FrameLayout.LayoutParams(this.c, this.d);
      ((FrameLayout.LayoutParams)localObject).gravity = 85;
      ((FrameLayout.LayoutParams)localObject).rightMargin = this.h;
      ((FrameLayout.LayoutParams)localObject).bottomMargin = this.i;
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.b.setRoundRect(90);
      this.b.setBackgroundResource(this.j);
      localObject = this.b;
      int k;
      if (this.g) {
        k = 0;
      } else {
        k = 8;
      }
      ((SquareImageView)localObject).setVisibility(k);
      super.addView(this.b);
    }
    if ((this.g) && (paramBoolean))
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
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