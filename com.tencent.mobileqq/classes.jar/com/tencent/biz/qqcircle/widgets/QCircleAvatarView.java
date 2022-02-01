package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.QCircleDrawableCacheUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.picload.avatar.AvatarOption;
import cooperation.qqcircle.picload.avatar.QCircleAvatarLoader;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleAvatarView
  extends FrameLayout
{
  private static final int j = 2130845204;
  private QCircleRoundImageView a;
  private SquareImageView b;
  private int c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private int h;
  private int i;
  
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
  
  private void setAvatar(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser != null)
    {
      if (this.a == null) {
        return;
      }
      String str = paramStUser.icon.iconUrl.get();
      if (!TextUtils.isEmpty(str))
      {
        QCircleFeedPicLoader.g().loadImage(new Option().setTargetView(this.a).setUrl(str), null);
        return;
      }
      if (!TextUtils.isEmpty(paramStUser.id.get())) {
        setAvatarByUin(paramStUser.id.get());
      }
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cn);
    if (paramContext != null)
    {
      this.c = ((int)paramContext.getDimension(R.styleable.cs, ViewUtils.a(24.0F)));
      this.d = ((int)paramContext.getDimension(R.styleable.cp, ViewUtils.a(24.0F)));
      this.e = paramContext.getColor(R.styleable.ct, 0);
      this.f = ((int)paramContext.getDimension(R.styleable.cu, 0.0F));
      this.g = paramContext.getBoolean(R.styleable.co, true);
      this.h = ((int)paramContext.getDimension(R.styleable.cr, 0.0F));
      this.i = ((int)paramContext.getDimension(R.styleable.cq, 0.0F));
      paramContext.recycle();
    }
    this.a = new QCircleRoundImageView(getContext(), null, 0);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    int k = this.f;
    if (k != 0) {
      this.a.setPadding(k, k, k, k);
    }
    this.a.setLayoutParams(paramContext);
    this.a.setRoundRect(DisplayUtil.e() / 2);
    this.a.setBackgroundDrawable(null);
    k = this.e;
    if (k != 0) {
      this.a.setBackgroundColor(k);
    }
    super.addView(this.a);
  }
  
  public ImageView getAvatarView()
  {
    return this.a;
  }
  
  public void setAvatarByUin(String paramString)
  {
    if (this.a != null)
    {
      FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
      localStUser.id.set(paramString);
      if ((!QCirclePluginUtil.b(localStUser)) && (QCircleConfigHelper.ag()))
      {
        paramString = new AvatarOption().setUin(paramString);
        paramString.setTargetView(this.a).setLoadingDrawable(QCircleDrawableCacheUtils.a(j)).setFromPreLoad(false);
        QCircleAvatarLoader.g().loadAvatar(paramString);
        return;
      }
      this.a.setImageDrawable(QCirclePluginGlobalInfo.a(paramString));
      this.a.setTag(HostUIHelper.getInstance().getHostResourceId("id", "qcircle_avatar_tag_id"), paramString);
    }
  }
  
  public void setIsAuth(int paramInt)
  {
    Object localObject;
    if (this.b == null)
    {
      this.b = new SquareImageView(getContext(), null, 0);
      localObject = new FrameLayout.LayoutParams(this.c, this.d);
      ((FrameLayout.LayoutParams)localObject).gravity = 85;
      ((FrameLayout.LayoutParams)localObject).rightMargin = this.h;
      ((FrameLayout.LayoutParams)localObject).bottomMargin = this.i;
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.b.setRoundRect(90);
      QCircleFeedPicLoader.g().loadImage(new Option().setUrl(QCircleConfigHelper.y()).setTargetView(this.b), null);
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
    if ((this.g) && (paramInt != 0))
    {
      if (paramInt == 2) {
        localObject = QCircleConfigHelper.z();
      } else {
        localObject = QCircleConfigHelper.y();
      }
      QCircleFeedPicLoader.g().loadImage(new Option().setUrl((String)localObject).setTargetView(this.b), null);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void setUser(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser == null) {
      return;
    }
    setAvatar(paramStUser);
    setIsAuth(QCirclePluginUtil.e(paramStUser));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAvatarView
 * JD-Core Version:    0.7.0.1
 */