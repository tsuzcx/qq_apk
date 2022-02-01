package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import bgmp;
import bgng;
import bhij;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.CellTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StAnimation;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudToastshowsvr.StJumpInfo;
import feedcloud.FeedCloudToastshowsvr.StShowControl;
import feedcloud.FeedCloudToastshowsvr.StShowTime;
import feedcloud.FeedCloudToastshowsvr.StToast;
import feedcloud.FeedCloudToastshowsvr.StToastBackgroundImg;
import feedcloud.FeedCloudToastshowsvr.StToastContent;
import uxo;
import vrf;
import vtu;
import vxy;

public class QCirclePushToastView
  extends QCircleBaseWidgetView<FeedCloudToastshowsvr.StToast>
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private bhij jdField_a_of_type_Bhij;
  private CellTextView jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextCellTextView;
  private CornerURLImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsCornerURLImageView;
  private QCircleLottileAnimView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private vxy jdField_a_of_type_Vxy;
  private bhij jdField_b_of_type_Bhij;
  private CellTextView jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextCellTextView;
  private CornerURLImageView jdField_b_of_type_ComTencentBizQqcircleWidgetsCornerURLImageView;
  private QCircleLottileAnimView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView;
  
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
  
  private void d()
  {
    this.jdField_a_of_type_Vxy.removeMessages(1);
    this.jdField_a_of_type_Vxy.removeMessages(2);
  }
  
  public int a()
  {
    return 2131560772;
  }
  
  protected String a()
  {
    return "QCirclePushToastView";
  }
  
  public void a()
  {
    d();
    FeedCloudToastshowsvr.StToast localStToast = (FeedCloudToastshowsvr.StToast)a();
    if ((localStToast == null) || (TextUtils.isEmpty(localStToast.toastContent.title.get())) || (TextUtils.isEmpty(localStToast.toastContent.content.get()))) {
      return;
    }
    setVisibility(0);
    long l2 = localStToast.showControl.showTime.showDuration.get();
    long l1 = l2;
    if (l2 < 3000L) {
      l1 = 3000L;
    }
    this.jdField_a_of_type_Vxy.sendEmptyMessageDelayed(2, l1);
    Object localObject = localStToast.toastContent.coverLayerAnimation.animationUrl.get();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView.setVisibility(8);
    }
    for (;;)
    {
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772218);
      this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
      postDelayed(new QCirclePushToastView.1(this, localStToast), 320L);
      vrf.a("", 43, 1, 0, "", "", localStToast.toastId.get(), String.valueOf(localStToast.toastType.get()), "");
      return;
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView.setVisibility(0);
      this.jdField_b_of_type_Bhij.a(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView, (String)localObject);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373122);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsCornerURLImageView = ((CornerURLImageView)paramView.findViewById(2131363225));
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsCornerURLImageView = ((CornerURLImageView)paramView.findViewById(2131365124));
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsCornerURLImageView.setRadius(vtu.b(4.0F));
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextCellTextView = ((CellTextView)paramView.findViewById(2131378870));
      this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextCellTextView = ((CellTextView)paramView.findViewById(2131365029));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131364548));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView = ((QCircleLottileAnimView)paramView.findViewById(2131376540));
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView = ((QCircleLottileAnimView)paramView.findViewById(2131365130));
      paramView = this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView.getLayoutParams();
      if (paramView != null)
      {
        paramView.width = vtu.a();
        paramView.height = (paramView.width * 7 / 15);
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView.setLayoutParams(paramView);
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      this.jdField_a_of_type_Vxy = new vxy(this, Looper.getMainLooper(), null);
      this.jdField_a_of_type_Bhij = new bhij(null, paramContext);
      this.jdField_b_of_type_Bhij = new bhij(null, paramContext);
      int i = (int)(MemoryManager.a() / 4L);
      this.jdField_a_of_type_Bhij.a(i);
      this.jdField_b_of_type_Bhij.a(i);
    }
  }
  
  protected void a(FeedCloudToastshowsvr.StToast paramStToast)
  {
    if (paramStToast != null)
    {
      long l = paramStToast.showControl.showTime.showDuration.get();
      if (l <= 0L) {
        QLog.d("QCirclePushToastView", 2, "onReceivePushToastEvent, not show toast because of showDuration is " + l);
      }
      Object localObject = (FeedCloudToastshowsvr.StToastContent)paramStToast.toastContent.get();
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          str1 = ((FeedCloudToastshowsvr.StToastContent)localObject).toastBackgroundImg.backgroundImg.picUrl.get();
          if (!TextUtils.isEmpty(str1)) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsCornerURLImageView.setImageURL(str1);
          }
          float f = vtu.a(((FeedCloudToastshowsvr.StToastContent)localObject).toastBackgroundImg.cornerRadius.get() / 2.0F);
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsCornerURLImageView.setRadius(f);
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView.setRadius(f);
          if (!TextUtils.isEmpty(paramStToast.toastContent.rightIconAnimation.animationUrl.get())) {
            continue;
          }
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView.setVisibility(8);
          str1 = ((FeedCloudToastshowsvr.StToastContent)localObject).cover.picUrl.get();
          if (!TextUtils.isEmpty(str1)) {
            continue;
          }
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsCornerURLImageView.setVisibility(8);
        }
        catch (Throwable localThrowable)
        {
          String str1;
          String str2;
          QLog.e("QCirclePushToastView", 2, localThrowable, new Object[0]);
          continue;
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsCornerURLImageView.setImageURL(str1);
          this.jdField_b_of_type_ComTencentBizQqcircleWidgetsCornerURLImageView.setVisibility(0);
          continue;
          this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextCellTextView.a(str1);
          this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextCellTextView.setVisibility(0);
          continue;
          this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextCellTextView.a(str2);
          this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextCellTextView.setVisibility(0);
          continue;
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localThrowable);
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
          continue;
          this.jdField_a_of_type_Vxy.removeMessages(1);
          this.jdField_a_of_type_Vxy.sendEmptyMessageDelayed(1, 1000L);
          return;
        }
        str1 = ((FeedCloudToastshowsvr.StToastContent)localObject).title.get();
        if (!TextUtils.isEmpty(str1)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextCellTextView.setVisibility(8);
        str2 = ((FeedCloudToastshowsvr.StToastContent)localObject).content.get();
        if (!TextUtils.isEmpty(str1)) {
          continue;
        }
        this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextCellTextView.setVisibility(8);
        localObject = ((FeedCloudToastshowsvr.StToastContent)localObject).closeButtonImg.picUrl.get();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        switch (paramStToast.showControl.showTime.showTimeType.get())
        {
        default: 
          return;
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleLottileAnimView.setVisibility(4);
        }
      }
      this.jdField_a_of_type_Vxy.removeMessages(1);
      this.jdField_a_of_type_Vxy.sendEmptyMessageDelayed(1, paramStToast.showControl.showTime.value.get());
      return;
      this.jdField_a_of_type_Vxy.removeMessages(1);
      this.jdField_a_of_type_Vxy.sendEmptyMessageAtTime(1, paramStToast.showControl.showTime.value.get());
      return;
    }
    QLog.e("QCirclePushToastView", 2, "bindData: data is null!");
  }
  
  public void c()
  {
    d();
    setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FeedCloudToastshowsvr.StToast localStToast = (FeedCloudToastshowsvr.StToast)a();
      if (localStToast != null)
      {
        String str = localStToast.toastContent.jumpInfo.jumpLink.get();
        int i = localStToast.toastContent.jumpInfo.jumpType.get();
        if (QLog.isColorLevel()) {
          QLog.d("QCirclePushToastView", 2, "Push toast content clicked. jumpUrl: " + str + ", jumpType: " + i);
        }
        if (i == 1)
        {
          bgmp localbgmp = bgng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), str);
          if (localbgmp != null) {
            localbgmp.a();
          }
        }
        for (;;)
        {
          vrf.a("", 43, 2, 0, "", "", localStToast.toastId.get(), String.valueOf(localStToast.toastType.get()), "");
          break;
          QLog.e("QCirclePushToastView", 2, "Push toast content clicked, but jumpAction is null! jumpUrl: " + str);
          continue;
          uxo.a(getContext(), str);
        }
        c();
        localStToast = (FeedCloudToastshowsvr.StToast)a();
        if (localStToast != null) {
          vrf.a("", 43, 3, 0, "", "", localStToast.toastId.get(), String.valueOf(localStToast.toastType.get()), "");
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
    setQQAppInterface(null);
  }
  
  public void setQQAppInterface(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushToastView
 * JD-Core Version:    0.7.0.1
 */