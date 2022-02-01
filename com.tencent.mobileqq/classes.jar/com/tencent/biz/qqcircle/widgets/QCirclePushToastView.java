package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppInterfaceUtil;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.CellTextView;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StAnimation;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudToastshowsvr.StJumpInfo;
import feedcloud.FeedCloudToastshowsvr.StShowControl;
import feedcloud.FeedCloudToastshowsvr.StShowTime;
import feedcloud.FeedCloudToastshowsvr.StToast;
import feedcloud.FeedCloudToastshowsvr.StToastBackgroundImg;
import feedcloud.FeedCloudToastshowsvr.StToastContent;

public class QCirclePushToastView
  extends QCircleBaseWidgetView<FeedCloudToastshowsvr.StToast>
  implements View.OnClickListener
{
  private View a;
  private CornerURLImageView b;
  private CornerURLImageView c;
  private CellTextView d;
  private CellTextView e;
  private URLImageView f;
  private QCircleLottileAnimView g;
  private QCircleLottileAnimView h;
  private DIYLottieLoader i;
  private DIYLottieLoader j;
  private QCirclePushToastView.ToastHandler k;
  
  public QCirclePushToastView(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public QCirclePushToastView(@NonNull Context paramContext, int paramInt)
  {
    this(paramContext, null, paramInt);
  }
  
  public QCirclePushToastView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCirclePushToastView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    this.k.removeMessages(1);
    this.k.removeMessages(2);
  }
  
  public void a()
  {
    c();
    FeedCloudToastshowsvr.StToast localStToast = (FeedCloudToastshowsvr.StToast)getData();
    if (localStToast != null)
    {
      if ((!TextUtils.isEmpty(localStToast.toastContent.title.get())) && (!TextUtils.isEmpty(localStToast.toastContent.content.get())))
      {
        setVisibility(0);
        long l2 = localStToast.showControl.showTime.showDuration.get();
        long l1 = l2;
        if (l2 < 3000L) {
          l1 = 3000L;
        }
        this.k.sendEmptyMessageDelayed(2, l1);
        localObject = localStToast.toastContent.coverLayerAnimation.animationUrl.get();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          this.h.setVisibility(8);
        }
        else
        {
          this.h.setVisibility(0);
          this.j.fromNetworkWithCacheBitmap(this.h, (String)localObject);
        }
        localObject = AnimationUtils.loadAnimation(getContext(), 2130772340);
        this.a.startAnimation((Animation)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("show toast title=");
        ((StringBuilder)localObject).append(localStToast.toastContent.title.get());
        ((StringBuilder)localObject).append(" content= ");
        ((StringBuilder)localObject).append(localStToast.toastContent.content.get());
        QLog.d("QCirclePushToastView", 1, ((StringBuilder)localObject).toString());
        postDelayed(new QCirclePushToastView.1(this, localStToast), 320L);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(43).setSubActionType(1).setThrActionType(0).setExt6(localStToast.toastId.get()).setExt7(String.valueOf(localStToast.toastType.get())));
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show toast title=");
      ((StringBuilder)localObject).append(localStToast.toastContent.title.get());
      ((StringBuilder)localObject).append(" content= ");
      ((StringBuilder)localObject).append(localStToast.toastContent.content.get());
      QLog.d("QCirclePushToastView", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a(FeedCloudToastshowsvr.StToast paramStToast, int paramInt)
  {
    if (paramStToast != null)
    {
      long l = paramStToast.showControl.showTime.showDuration.get();
      if (l <= 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceivePushToastEvent, not show toast because of showDuration is ");
        ((StringBuilder)localObject).append(l);
        QLog.d("QCirclePushToastView", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = (FeedCloudToastshowsvr.StToastContent)paramStToast.toastContent.get();
      if (localObject != null) {
        try
        {
          String str = ((FeedCloudToastshowsvr.StToastContent)localObject).toastBackgroundImg.backgroundImg.picUrl.get();
          if (!TextUtils.isEmpty(str)) {
            this.b.setImageURL(str);
          }
          float f1 = ViewUtils.a(((FeedCloudToastshowsvr.StToastContent)localObject).toastBackgroundImg.cornerRadius.get() / 2.0F);
          this.b.setRadius(f1);
          this.g.setRadius(f1);
          if (TextUtils.isEmpty(paramStToast.toastContent.rightIconAnimation.animationUrl.get())) {
            this.g.setVisibility(8);
          } else {
            this.g.setVisibility(4);
          }
          str = ((FeedCloudToastshowsvr.StToastContent)localObject).cover.picUrl.get();
          if (TextUtils.isEmpty(str))
          {
            this.c.setVisibility(8);
          }
          else
          {
            this.c.setImageURL(str);
            this.c.setVisibility(0);
          }
          str = ((FeedCloudToastshowsvr.StToastContent)localObject).title.get();
          if (TextUtils.isEmpty(str))
          {
            this.d.setVisibility(8);
          }
          else
          {
            this.d.a(str);
            this.d.setVisibility(0);
          }
          str = ((FeedCloudToastshowsvr.StToastContent)localObject).content.get();
          if (TextUtils.isEmpty(str))
          {
            this.e.setVisibility(8);
          }
          else
          {
            this.e.a(str);
            this.e.setVisibility(0);
          }
          localObject = ((FeedCloudToastshowsvr.StToastContent)localObject).closeButtonImg.picUrl.get();
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            this.f.setVisibility(8);
          }
          else
          {
            this.f.setImageURL((String)localObject);
            this.f.setVisibility(4);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("QCirclePushToastView", 1, localThrowable, new Object[0]);
        }
      }
      paramInt = paramStToast.showControl.showTime.showTimeType.get();
      if ((paramInt != 0) && (paramInt != 1))
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          this.k.removeMessages(1);
          this.k.sendEmptyMessageAtTime(1, paramStToast.showControl.showTime.value.get());
          return;
        }
        this.k.removeMessages(1);
        this.k.sendEmptyMessageDelayed(1, paramStToast.showControl.showTime.value.get());
        return;
      }
      this.k.removeMessages(1);
      this.k.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    QLog.e("QCirclePushToastView", 1, "bindData: data is null!");
  }
  
  public void b()
  {
    c();
    setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2131626944;
  }
  
  protected String getLogTag()
  {
    return "QCirclePushToastView";
  }
  
  public void onClick(View paramView)
  {
    FeedCloudToastshowsvr.StToast localStToast;
    if (paramView.getId() == 2131440906)
    {
      localStToast = (FeedCloudToastshowsvr.StToast)getData();
      if (localStToast != null)
      {
        String str = localStToast.toastContent.jumpInfo.jumpLink.get();
        int m = localStToast.toastContent.jumpInfo.jumpType.get();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Push toast content clicked. jumpUrl: ");
          localStringBuilder.append(str);
          localStringBuilder.append(", jumpType: ");
          localStringBuilder.append(m);
          QLog.d("QCirclePushToastView", 2, localStringBuilder.toString());
        }
        if (m == 1) {
          QCircleHostLauncher.doJumpAction(getContext(), str);
        } else {
          QCircleLauncher.a(getContext(), str, null, -1);
        }
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(43).setSubActionType(2).setThrActionType(0).setExt6(localStToast.toastId.get()).setExt7(String.valueOf(localStToast.toastType.get())));
      }
    }
    else if (paramView.getId() == 2131430817)
    {
      b();
      localStToast = (FeedCloudToastshowsvr.StToast)getData();
      if (localStToast != null) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(43).setSubActionType(3).setThrActionType(0).setExt6(localStToast.toastId.get()).setExt7(String.valueOf(localStToast.toastType.get())));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.a = paramView.findViewById(2131440906);
      this.b = ((CornerURLImageView)paramView.findViewById(2131429246));
      this.c = ((CornerURLImageView)paramView.findViewById(2131431469));
      this.c.setRadius(ViewUtils.a(4.0F));
      this.d = ((CellTextView)paramView.findViewById(2131447578));
      this.e = ((CellTextView)paramView.findViewById(2131431366));
      this.f = ((URLImageView)paramView.findViewById(2131430817));
      this.g = ((QCircleLottileAnimView)paramView.findViewById(2131444818));
      this.h = ((QCircleLottileAnimView)paramView.findViewById(2131431475));
      paramView = this.h.getLayoutParams();
      if (paramView != null)
      {
        paramView.width = DisplayUtil.d();
        paramView.height = (paramView.width * 7 / 15);
        this.h.setLayoutParams(paramView);
      }
      this.a.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.k = new QCirclePushToastView.ToastHandler(this, Looper.getMainLooper(), null);
      this.i = new DIYLottieLoader(paramContext);
      this.j = new DIYLottieLoader(paramContext);
      int m = (int)(HostAppInterfaceUtil.getAvailClassSize() / 4.0F);
      this.i.setMemoryCacheSize(m);
      this.j.setMemoryCacheSize(m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushToastView
 * JD-Core Version:    0.7.0.1
 */