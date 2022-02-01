package com.tencent.biz.qqcircle.fragments.content;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostImagePreviewHelper;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickLayout;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleStickConfig;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.utils.QFSSafeListUtils;
import com.tencent.biz.qqcircle.immersive.utils.QFSShareInfoUtils;
import com.tencent.biz.qqcircle.utils.QCircleDrawableCacheUtils;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;

public class QCircleContentImage
  extends QCircleBaseWidgetView<FeedBlockData>
  implements URLDrawableDownListener
{
  private QCircleMultiTouchImageView a;
  private int b;
  private boolean c = false;
  private int d = 2;
  private int e = 0;
  private int f = 0;
  private QCircleExpandStickLayout g;
  private QCircleContentImage.OnPictureContentListener h;
  private FeedBlockData i;
  private int j;
  private IQFSFeedIoc k;
  
  public QCircleContentImage(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private Option a(URLImageView paramURLImageView, FeedCloudMeta.StImage paramStImage)
  {
    Option localOption = new Option().setLoadingDrawable(getResources().getDrawable(2130853309));
    if (paramStImage != null)
    {
      if (paramURLImageView == null) {
        return localOption;
      }
      int m = paramStImage.height.get();
      int n = paramStImage.width.get();
      if (m > 0)
      {
        if (n <= 0) {
          return localOption;
        }
        paramURLImageView = QCircleHostImagePreviewHelper.getTargetSize(n, m);
        if (paramURLImageView != null)
        {
          m = paramURLImageView[0];
          n = paramURLImageView[1];
          localOption.setRequestWidth(m);
          localOption.setRequestHeight(n);
        }
      }
    }
    return localOption;
  }
  
  private void a()
  {
    if (this.k != null)
    {
      Object localObject = this.i;
      if (localObject != null)
      {
        localObject = QFSShareInfoUtils.a(((FeedBlockData)localObject).b());
        ((QCircleShareInfo)localObject).a = this.i;
        ((QCircleShareInfo)localObject).c.mDataPosition = this.b;
        ((QCircleShareInfo)localObject).e = this.j;
        ((QCircleShareInfo)localObject).b = this.i.b();
        ((QCircleShareInfo)localObject).r = getReportBean();
        if ((getReportBean() != null) && ("pg_ks_explore_page".equals(Integer.valueOf(getReportBean().getPageId())))) {
          ((QCircleShareInfo)localObject).l = true;
        }
        this.k.a("event_open_share", new Object[] { localObject });
        return;
      }
    }
    QLog.w("Stick-PIC-QCircleContentImage", 1, "[handleShare] mIQFSFeedIoc or mBlockData is null");
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    QCircleContentImage.OnPictureContentListener localOnPictureContentListener = this.h;
    if (localOnPictureContentListener == null)
    {
      QLog.d("Stick-PIC-QCircleContentImage", 1, "[notifyScaleChange] picture content listener should not be null.");
      return;
    }
    localOnPictureContentListener.a(paramFloat1, paramFloat2, paramFloat3);
  }
  
  private void a(int paramInt1, Option paramOption, FeedBlockData paramFeedBlockData, int paramInt2)
  {
    if (paramInt1 != 6) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed;
    if (paramFeedBlockData == null) {
      localStFeed = null;
    } else {
      localStFeed = paramFeedBlockData.b();
    }
    if (localStFeed == null) {
      return;
    }
    if (paramOption == null) {
      return;
    }
    String str = paramOption.getUrl();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleStateChang] feedId:");
    localStringBuilder.append(localStFeed.id.get());
    localStringBuilder.append(" url:");
    localStringBuilder.append(str);
    localStringBuilder.append("state callback:");
    localStringBuilder.append(paramInt1);
    QLog.d("Stick-PIC-QCircleContentImage", 1, localStringBuilder.toString());
    RFThreadManager.getUIHandler().postDelayed(new QCircleContentImage.UpdateConfigStick(this, paramFeedBlockData, paramOption, paramInt2), 110L);
  }
  
  private void a(FeedBlockData paramFeedBlockData, int paramInt, FeedCloudMeta.StImage paramStImage, String paramString)
  {
    paramStImage = a(this.a, paramStImage).setTargetView(this.a).setUrl(paramString).setFailDrawable(QCircleDrawableCacheUtils.a(2130845241)).setLoadingDrawable(getPicLoadingDrawable()).setPredecode(true);
    QCircleFeedPicLoader.g().loadImage(paramStImage, new QCircleContentImage.QCirclePicStateListenerImpl(paramFeedBlockData, paramInt, this));
  }
  
  private void a(FeedBlockData paramFeedBlockData, Option paramOption, int paramInt)
  {
    this.i = paramFeedBlockData;
    this.j = paramInt;
    if (paramOption == null) {
      return;
    }
    if (this.g == null) {
      return;
    }
    if (paramOption != null)
    {
      paramFeedBlockData = QCircleStickConfig.a().a(this.e).b(this.f).c(paramOption.getRequestWidth()).d(paramOption.getRequestHeight()).a(paramFeedBlockData).e(paramInt).a(true).a(ImageView.ScaleType.FIT_CENTER);
      this.g.a(paramFeedBlockData);
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleMultiTouchImageView localQCircleMultiTouchImageView = this.a;
    if (localQCircleMultiTouchImageView != null)
    {
      localQCircleMultiTouchImageView.setOnDoubleTabListener(new QCircleContentImage.1(this, paramStFeed));
      this.a.setOnScaleChangeListener(new QCircleContentImage.2(this, paramStFeed));
      this.a.setOnViewTapListener(new QCircleContentImage.3(this, paramStFeed));
      this.a.setOnScaleBeginListener(new QCircleContentImage.4(this));
      this.a.setOnScaleEndListener(new QCircleContentImage.5(this));
      this.a.setOnLongClickListener(new QCircleContentImage.6(this));
    }
  }
  
  private void b(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (this.a == null) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = paramFeedBlockData.b();
    if (localStFeed == null)
    {
      QLog.d("Stick-PIC-QCircleContentImage", 1, "[loadViewImage] feed should not be null.");
      return;
    }
    FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)QFSSafeListUtils.a(localStFeed.images.get(), this.dataPosInList);
    if (localStImage == null)
    {
      QLog.d("Stick-PIC-QCircleContentImage", 1, "[loadViewImage] image should not be null.");
      return;
    }
    String str1 = localStImage.picUrl.get();
    String str3 = QCircleFeedPicLoader.getUniKeyFromUrl(str1);
    String str2 = (String)this.a.getTag(2131441759);
    if ((str1 != null) && (!TextUtils.isEmpty(str3)) && (!str3.equals(str2)))
    {
      this.a.setTag(2131441759, str3);
      a(paramFeedBlockData, paramInt, localStImage, str1);
    }
    else
    {
      a(paramFeedBlockData, a(this.a, localStImage), paramInt);
      paramFeedBlockData = new StringBuilder();
      paramFeedBlockData.append("same url, not need load oncemore!feedId:");
      paramFeedBlockData.append(localStFeed.id.get());
      paramFeedBlockData.append(" url:");
      paramFeedBlockData.append(str1);
      paramFeedBlockData.append(" urlkey :");
      paramFeedBlockData.append(str2);
      QLog.d("Stick-PIC-QCircleContentImage", 1, paramFeedBlockData.toString());
    }
    a(localStFeed);
    this.c = false;
  }
  
  private FeedCloudMeta.StImage c(FeedBlockData paramFeedBlockData, int paramInt)
  {
    if (paramFeedBlockData == null) {
      paramFeedBlockData = null;
    } else {
      paramFeedBlockData = paramFeedBlockData.b();
    }
    if (paramFeedBlockData == null)
    {
      QLog.d("Stick-PIC-QCircleContentImage", 1, "[getSelectedImage] feed should not be null.");
      return null;
    }
    return (FeedCloudMeta.StImage)QFSSafeListUtils.a(paramFeedBlockData.images.get(), paramInt);
  }
  
  private Drawable getPicLoadingDrawable()
  {
    if ((this.dataPosInList == 0) && (getReportBean() != null) && ((getInteractor() instanceof QCircleInteractor)))
    {
      QCircleInteractor localQCircleInteractor = (QCircleInteractor)getInteractor();
      if (localQCircleInteractor.e() != null) {
        return localQCircleInteractor.e();
      }
      return getResources().getDrawable(2130853309);
    }
    return getResources().getDrawable(2130853309);
  }
  
  public void a(int paramInt)
  {
    FeedBlockData localFeedBlockData = (FeedBlockData)getData();
    FeedCloudMeta.StImage localStImage = c(localFeedBlockData, paramInt);
    a(localFeedBlockData, a(this.a, localStImage), paramInt);
  }
  
  protected void a(FeedBlockData paramFeedBlockData, int paramInt)
  {
    b(paramFeedBlockData, paramInt);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    QCircleMultiTouchImageView localQCircleMultiTouchImageView = this.a;
    if (localQCircleMultiTouchImageView != null) {
      return localQCircleMultiTouchImageView.a(paramFloat1, paramFloat2);
    }
    return true;
  }
  
  public void b(int paramInt)
  {
    QCircleMultiTouchImageView localQCircleMultiTouchImageView = this.a;
    if (localQCircleMultiTouchImageView != null) {
      localQCircleMultiTouchImageView.setTag(2131441759, "");
    }
    QLog.d("Stick-PIC-QCircleContentImage", 1, new Object[] { "[reloadPicImage] position: ", Integer.valueOf(paramInt) });
    b((FeedBlockData)getData(), paramInt);
  }
  
  public ImageView getCover()
  {
    return this.a;
  }
  
  public Drawable getImageDrawable()
  {
    QCircleMultiTouchImageView localQCircleMultiTouchImageView = this.a;
    if (localQCircleMultiTouchImageView != null) {
      return localQCircleMultiTouchImageView.getDrawable();
    }
    return null;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  protected String getLogTag()
  {
    return "Stick-PIC-QCircleContentImage";
  }
  
  public int getVerticalPos()
  {
    return this.b;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QCircleMultiTouchImageView localQCircleMultiTouchImageView = this.a;
    if (localQCircleMultiTouchImageView != null) {
      localQCircleMultiTouchImageView.b();
    }
    if ((getInteractor() instanceof QCircleInteractor)) {
      ((QCircleInteractor)getInteractor()).f();
    }
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = new QCircleMultiTouchImageView(getContext());
    addView(this.a, new FrameLayout.LayoutParams(-1, -1));
    this.g = new QCircleExpandStickLayout(getContext());
    addView(this.g, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = this.a;
    if (paramView != null) {
      paramView.a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.e = getMeasuredWidth();
    this.f = getMeasuredHeight();
    QLog.d("Stick-PIC-QCircleContentImage", 1, new Object[] { "[QCircleContentImage] mMeasureWidth: ", Integer.valueOf(this.e), " | mMeasureHeight: ", Integer.valueOf(this.f) });
  }
  
  public void release()
  {
    QCircleMultiTouchImageView localQCircleMultiTouchImageView = this.a;
    if (localQCircleMultiTouchImageView != null) {
      localQCircleMultiTouchImageView.setImageDrawable(null);
    }
  }
  
  public void setIQFSFeedIoc(IQFSFeedIoc paramIQFSFeedIoc)
  {
    this.k = paramIQFSFeedIoc;
  }
  
  public void setMeasureHeight(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setMeasureWidth(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnPictureContentListener(QCircleContentImage.OnPictureContentListener paramOnPictureContentListener)
  {
    this.h = paramOnPictureContentListener;
  }
  
  public void setPlayScene(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    QCircleExpandStickLayout localQCircleExpandStickLayout = this.g;
    if (localQCircleExpandStickLayout != null) {
      localQCircleExpandStickLayout.setReportBean(paramQCircleReportBean);
    }
  }
  
  public void setVerticalPos(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage
 * JD-Core Version:    0.7.0.1
 */