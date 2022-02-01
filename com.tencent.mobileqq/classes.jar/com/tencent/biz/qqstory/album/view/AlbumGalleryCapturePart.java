package com.tencent.biz.qqstory.album.view;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import dov.com.qq.im.capture.view.CustomLinearSnapHelper;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import java.util.List;
import mqq.os.MqqHandler;

public class AlbumGalleryCapturePart
  implements Handler.Callback, View.OnClickListener, AlbumVideoGalleryAdapter.IOnAlbumGalleryAdapterCallback
{
  public static float a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private StoryScanManager jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager;
  private AlbumGalleryAdapterHolder jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder;
  private AlbumGalleryCapturePart.IOnAlbumGalleryPartCallback jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$IOnAlbumGalleryPartCallback;
  private AlbumVideoGalleryAdapter jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter;
  private StoryFormSwitchItem jdField_a_of_type_ComTencentBizQqstoryAlbumViewStoryFormSwitchItem;
  private SlideProgressNotifier jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier;
  private CustomLinearSnapHelper jdField_a_of_type_DovComQqImCaptureViewCustomLinearSnapHelper;
  private SpeedFlexibleRecyclerView jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private boolean k;
  
  static
  {
    jdField_a_of_type_Float = 0.85F;
  }
  
  private static float a(int paramInt1, int paramInt2, float paramFloat)
  {
    return 1.0F - (paramInt1 - paramInt2) * paramFloat / paramInt1;
  }
  
  public static float a(AlbumGalleryAdapterHolder paramAlbumGalleryAdapterHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAlbumGalleryAdapterHolder.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.width = ((int)(paramAlbumGalleryAdapterHolder.jdField_a_of_type_AndroidViewView.getWidth() * 0.95F));
    paramAlbumGalleryAdapterHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    paramAlbumGalleryAdapterHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramAlbumGalleryAdapterHolder.jdField_a_of_type_AndroidWidgetTextView.getTextColors().withAlpha((int)(255.0F * paramFloat)));
    paramAlbumGalleryAdapterHolder.c.setTextColor(paramAlbumGalleryAdapterHolder.c.getTextColors().withAlpha((int)(178.5F * paramFloat)));
    paramAlbumGalleryAdapterHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramAlbumGalleryAdapterHolder.jdField_b_of_type_AndroidWidgetTextView.getTextColors().withAlpha((int)(153.0F * paramFloat)));
    float f1 = 0.2F * paramFloat + 0.8F;
    paramAlbumGalleryAdapterHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setScaleX(f1);
    paramAlbumGalleryAdapterHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setScaleY(f1);
    paramAlbumGalleryAdapterHolder.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setAlpha(jdField_a_of_type_Float);
    f1 = a(paramInt2, paramInt1, 1.0F - paramFloat);
    float f2 = a(paramInt4, paramInt3, 1.0F - paramFloat);
    paramAlbumGalleryAdapterHolder.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setScaleX(f1);
    paramAlbumGalleryAdapterHolder.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setScaleY(f2);
    f1 = jdField_a_of_type_Float;
    f2 = jdField_a_of_type_Float;
    paramAlbumGalleryAdapterHolder.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setAlpha(f1 * paramFloat + f2);
    QLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", 4, " setVideoItemScale i=" + paramInt5 + " percent=" + paramFloat);
    return paramFloat;
  }
  
  private void a(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AlbumGalleryCapturePart.8(this), paramLong);
  }
  
  private void b(StoryAlbum paramStoryAlbum)
  {
    SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "preload album :%s", paramStoryAlbum);
    if ((this.jdField_b_of_type_Long == -1L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 30000L))
    {
      SlideShowPhotoListManager.a().a(paramStoryAlbum);
      SlideShowPhotoListManager.a().h();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700237));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700259));
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.a())
    {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data error ,detect user close scan!");
      return;
    }
    Bosses.get().postJob(new AlbumGalleryCapturePart.7(this));
  }
  
  private void c(StoryAlbum paramStoryAlbum)
  {
    if (paramStoryAlbum.jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$IOnAlbumGalleryPartCallback.b();
      StoryReportor.a("video_shoot_slides", "clk_selectbutton", 0, 0, new String[0]);
    }
    do
    {
      return;
      if (paramStoryAlbum.jdField_d_of_type_Int == 4)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$IOnAlbumGalleryPartCallback.b();
        StoryReportor.a("video_shoot_slides", "clk_noalbum", 0, 0, new String[0]);
        return;
      }
      if (paramStoryAlbum.jdField_d_of_type_Int == 5)
      {
        StoryReportor.a("video_shoot_slides", "clk_research", 0, 0, new String[0]);
        if (!NetworkUtils.a(this.jdField_a_of_type_AndroidAppActivity))
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131700268), 0).a();
          return;
        }
        c();
        return;
      }
    } while (paramStoryAlbum.jdField_d_of_type_Int != 3);
    d();
    StoryReportor.a("video_shoot_slides", "clk_onalbum", 0, 0, new String[0]);
  }
  
  private void d()
  {
    SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "open album");
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.a(true);
    c();
    a();
  }
  
  private void d(StoryAlbum paramStoryAlbum)
  {
    if (this.k)
    {
      SLog.e("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "you have clicked album when handling");
      return;
    }
    this.k = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    StoryReportor.a("video_shoot_slides", "clk_makebutton", 0, 0, new String[] { String.valueOf(paramStoryAlbum.d()) });
    Bosses.get().postJob(new AlbumGalleryCapturePart.12(this, paramStoryAlbum));
  }
  
  private void e()
  {
    SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "close album");
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.a(false);
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.b();
    a();
  }
  
  private void f()
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryAlbumStoryScanManager.a();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewStoryFormSwitchItem.setChecked(bool);
    b(bool);
  }
  
  private void g()
  {
    StoryAlbum localStoryAlbum = this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.a();
    if (localStoryAlbum != null)
    {
      if (!localStoryAlbum.a()) {
        break label173;
      }
      if ((localStoryAlbum.jdField_d_of_type_Int == 1) || (localStoryAlbum.jdField_d_of_type_Int == 4))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700269));
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
    }
    else
    {
      return;
    }
    if (localStoryAlbum.jdField_d_of_type_Int == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700244));
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    if (localStoryAlbum.jdField_d_of_type_Int == 5)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700249));
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    if (localStoryAlbum.jdField_d_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700238));
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700240));
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
    return;
    label173:
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700245));
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  private void h() {}
  
  public float a(View paramView)
  {
    int m = Math.min(paramView.getLeft(), this.jdField_a_of_type_Int - paramView.getRight());
    float f1 = this.jdField_c_of_type_Int / 2.0F;
    f1 = (m + f1) / (this.jdField_a_of_type_Int / 2.0F);
    if (f1 < 0.0F) {
      return 0.0F;
    }
    if (f1 > 1.0F) {
      return 1.0F;
    }
    return f1;
  }
  
  public void a()
  {
    int n = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildCount();
    int m = 0;
    for (;;)
    {
      if (m < n)
      {
        Object localObject = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildAt(m);
        float f1 = a((View)localObject);
        localObject = (AlbumGalleryAdapterHolder)this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildViewHolder((View)localObject);
        if (localObject != null) {
          a((AlbumGalleryAdapterHolder)localObject, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, f1, m);
        }
        if (f1 <= 0.8F) {
          break label134;
        }
        if (this.jdField_j_of_type_Int == m) {
          break label107;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
      }
      for (;;)
      {
        this.jdField_j_of_type_Int = m;
        return;
        label107:
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1003, 300L);
      }
      label134:
      m += 1;
    }
  }
  
  public void a(StoryAlbum paramStoryAlbum)
  {
    if (this.jdField_j_of_type_Boolean) {
      SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "album scrolling , select ignore :%s", new Object[] { paramStoryAlbum });
    }
    while (paramStoryAlbum == null) {
      return;
    }
    SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on album select :%s", paramStoryAlbum);
    if (paramStoryAlbum.a())
    {
      c(paramStoryAlbum);
      return;
    }
    d(paramStoryAlbum);
  }
  
  public void a(StoryAlbum paramStoryAlbum, int paramInt)
  {
    a(300L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1005);
    if ((paramBoolean) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1006, 6000L);
      this.jdField_d_of_type_Boolean = true;
    }
    SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "onReceiveScanResult :%s", Boolean.valueOf(paramBoolean));
  }
  
  public void b()
  {
    g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = 0;
    boolean bool2 = false;
    switch (paramMessage.what)
    {
    }
    label215:
    label353:
    do
    {
      do
      {
        return true;
        paramMessage = this.jdField_a_of_type_DovComQqImCaptureViewCustomLinearSnapHelper.a(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getLayoutManager());
        if (paramMessage == null)
        {
          SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on handle find snap msg , not found snap view !");
          return true;
        }
        AlbumGalleryAdapterHolder localAlbumGalleryAdapterHolder = (AlbumGalleryAdapterHolder)this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildViewHolder(paramMessage);
        if ((this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder != null) && (this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder != localAlbumGalleryAdapterHolder)) {
          this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder.c();
        }
        if ((localAlbumGalleryAdapterHolder != null) && (this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder != localAlbumGalleryAdapterHolder))
        {
          localAlbumGalleryAdapterHolder.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setAlpha(1.0F);
          SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "SNAP, startPlay");
          localAlbumGalleryAdapterHolder.b();
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.getPosition(paramMessage) == 0) && (!this.jdField_a_of_type_Boolean)) {
            this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.postDelayed(new AlbumGalleryCapturePart.11(this), 3500L);
          }
        }
        this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryAdapterHolder = localAlbumGalleryAdapterHolder;
        int n = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildAdapterPosition(paramMessage);
        if (n != this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.a())
        {
          m = 1;
          this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.a(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView, n);
          boolean bool1 = bool2;
          if (this.jdField_d_of_type_Boolean)
          {
            bool1 = bool2;
            if (m != 0) {
              bool1 = true;
            }
          }
          this.jdField_d_of_type_Boolean = bool1;
          g();
          this.jdField_i_of_type_Int = Math.max(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.a(), this.jdField_i_of_type_Int);
          paramMessage = this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.a();
          if ((paramMessage != null) && (!paramMessage.a()) && (m != 0)) {
            b(this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.a());
          }
          if ((paramMessage != null) && (paramMessage.a()))
          {
            if (paramMessage.jdField_d_of_type_Int != 1) {
              break label353;
            }
            this.jdField_e_of_type_Boolean = true;
          }
        }
        while (this.jdField_c_of_type_Boolean)
        {
          h();
          return true;
          m = 0;
          break label215;
          if (paramMessage.jdField_d_of_type_Int == 4) {
            this.jdField_f_of_type_Boolean = true;
          } else if (paramMessage.jdField_d_of_type_Int == 3) {
            this.jdField_h_of_type_Boolean = true;
          } else if (paramMessage.jdField_d_of_type_Int == 5) {
            this.jdField_g_of_type_Boolean = true;
          } else if (paramMessage.jdField_d_of_type_Int != 2) {}
        }
        paramMessage = this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.a();
        if (this.jdField_a_of_type_Long != -1L) {
          while (m < paramMessage.size())
          {
            if (((StoryAlbum)paramMessage.get(m)).a() == this.jdField_a_of_type_Long)
            {
              this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.scrollToPosition(m);
              a(200L);
              this.jdField_a_of_type_Long = -1L;
              SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "start ,scroll to position %d automatically", Integer.valueOf(m));
              return true;
            }
            m += 1;
          }
        }
      } while ((this.jdField_h_of_type_Int < 0) || (this.jdField_h_of_type_Int >= paramMessage.size()));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.scrollToPosition(this.jdField_h_of_type_Int);
      a(200L);
      this.jdField_h_of_type_Int = -1;
      SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "start ,scroll to position %d automatically", Integer.valueOf(this.jdField_h_of_type_Int));
      return true;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131700255), 0).a();
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.c();
      return true;
      SLog.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "handle msg ,showAfterLoadingTip : %s", Boolean.valueOf(this.jdField_d_of_type_Boolean));
    } while (!this.jdField_d_of_type_Boolean);
    m = this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.a();
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.smoothScrollToPosition(m + 1);
    a(200L);
    this.jdField_d_of_type_Boolean = false;
    return true;
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
      StoryAlbum localStoryAlbum = this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumVideoGalleryAdapter.a();
      if (localStoryAlbum != null)
      {
        long l = SystemClock.uptimeMillis();
        if (l - this.jdField_c_of_type_Long > 500L) {
          a(localStoryAlbum);
        }
        for (;;)
        {
          this.jdField_c_of_type_Long = l;
          break;
          SLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "you click too fast, wait...");
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$IOnAlbumGalleryPartCallback != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewAlbumGalleryCapturePart$IOnAlbumGalleryPartCallback.a();
          continue;
          if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
          {
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846781);
          }
          for (;;)
          {
            StoryReportor.a("video_shoot_slides", "clk_setting", 0, 0, new String[0]);
            break;
            this.jdField_i_of_type_Boolean = true;
            f();
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846782);
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846781);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart
 * JD-Core Version:    0.7.0.1
 */