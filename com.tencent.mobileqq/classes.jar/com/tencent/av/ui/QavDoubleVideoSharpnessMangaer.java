package com.tencent.av.ui;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QavDoubleVideoSharpnessMangaer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QavDoubleVideoSharpnessMangaer.1(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new QavDoubleVideoSharpnessMangaer.2(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private AVActivity jdField_a_of_type_ComTencentAvUiAVActivity;
  private QavSharpnessSVIPHelper jdField_a_of_type_ComTencentAvUiQavSharpnessSVIPHelper;
  private Queue<Long> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[4];
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 2;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = false;
  
  public QavDoubleVideoSharpnessMangaer(View paramView, ViewStub paramViewStub, int paramInt, VideoController paramVideoController, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_ComTencentAvUiQavSharpnessSVIPHelper = new QavSharpnessSVIPHelper(paramVideoController, paramAVActivity);
    this.jdField_a_of_type_ComTencentAvUiQavSharpnessSVIPHelper.a();
    this.jdField_a_of_type_ComTencentAvUiAVActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.SVIP.PAY"));
  }
  
  private void a(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373443);
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getString(2131695564);
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a.getApp();
    int i;
    if (paramBoolean) {
      i = 2131695563;
    } else {
      i = 2131695562;
    }
    localObject = ((BaseApplication)localObject).getString(i);
    QavDoubleVideoSharpnessMangaer.QavClickableSpan localQavClickableSpan = new QavDoubleVideoSharpnessMangaer.QavClickableSpan(this);
    SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
    localSpannableString.setSpan(localQavClickableSpan, 0, ((String)localObject).length(), 18);
    localSpannableString.setSpan(new ForegroundColorSpan(-11692801), 0, ((String)localObject).length(), 17);
    localTextView.setText(str);
    localTextView.append(localSpannableString);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void h()
  {
    Object localObject4 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373598);
    Object localObject3 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373601);
    Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373607);
    Object localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373603);
    int i = (int)UITools.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getApplicationContext(), 4.0F);
    int j = (int)UITools.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getApplicationContext(), 132.0F);
    int k = (int)UITools.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getApplicationContext(), 8.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.width = j;
    ((RelativeLayout)localObject4).setLayoutParams(localLayoutParams);
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131373598);
    ((RelativeLayout.LayoutParams)localObject4).leftMargin = i;
    ((RelativeLayout.LayoutParams)localObject4).width = j;
    ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131373598);
    ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131373598);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131373598);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject3).width = j;
    ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131373601);
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131373601);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131373601);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject2).width = j;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131373609);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = k;
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373610)).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131373605);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = k;
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373606)).setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373599));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373602));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373609));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373610)).setText(this.jdField_a_of_type_ComTencentAvVideoController.a().m);
      if (AndroidCodec.sIsSupportHwCodec1080P)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373603).setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3] = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373605));
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3].setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373606)).setText(this.jdField_a_of_type_ComTencentAvVideoController.a().m);
        h();
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new QavDoubleVideoSharpnessMangaer.5(this));
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvUiQavSharpnessSVIPHelper.a();
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().w;
    j();
  }
  
  private void j()
  {
    ImageView localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0];
    Resources localResources = this.jdField_a_of_type_AndroidViewView.getResources();
    int i;
    if (this.jdField_b_of_type_Int == 0) {
      i = 2130842329;
    } else {
      i = 2130842328;
    }
    localImageView.setBackgroundDrawable(localResources.getDrawable(i));
    localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1];
    localResources = this.jdField_a_of_type_AndroidViewView.getResources();
    if (this.jdField_b_of_type_Int == 1) {
      i = 2130842327;
    } else {
      i = 2130842326;
    }
    localImageView.setBackgroundDrawable(localResources.getDrawable(i));
    localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2];
    localResources = this.jdField_a_of_type_AndroidViewView.getResources();
    if (this.jdField_b_of_type_Int == 2) {
      i = 2130842333;
    } else {
      i = 2130842332;
    }
    localImageView.setBackgroundDrawable(localResources.getDrawable(i));
    if (AndroidCodec.sIsSupportHwCodec1080P)
    {
      localImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3];
      localResources = this.jdField_a_of_type_AndroidViewView.getResources();
      if (this.jdField_b_of_type_Int == 3) {
        i = 2130842331;
      } else {
        i = 2130842330;
      }
      localImageView.setBackgroundDrawable(localResources.getDrawable(i));
    }
  }
  
  private void k()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null)
    {
      if (localRelativeLayout.getVisibility() != 0) {
        return;
      }
      a();
    }
  }
  
  private void l()
  {
    j();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).a();
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(Long.valueOf(((SessionInfo)localObject).c).longValue(), this.jdField_b_of_type_Int);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int + 1;
  }
  
  public void a()
  {
    i();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvUiAVActivity;
      if ((localObject != null) && (((AVActivity)localObject).a != null))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if ((localObject != null) && (((SessionInfo)localObject).d == 2))
        {
          if (((SessionInfo)localObject).r()) {
            return;
          }
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
            return;
          }
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().w != 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().w != 2)) {
            return;
          }
          if (this.jdField_a_of_type_ComTencentAvUiAVActivity.b() != 2) {
            return;
          }
          localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131373524);
          if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
            return;
          }
          if (this.jdField_a_of_type_AndroidViewView.findViewById(2131373634).getVisibility() != 0) {
            return;
          }
          if (paramInt >= 2)
          {
            if ((AndroidCodec.sIsSupportHwCodec1080P) && (!this.jdField_c_of_type_Boolean))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onNetworkQualityChanged. networkQuality = ");
              ((StringBuilder)localObject).append(paramInt);
              QLog.i("QavDoubleVideoSharpnessMangaer", 1, ((StringBuilder)localObject).toString());
              this.jdField_a_of_type_ComTencentAvUiAVActivity.a.N();
              this.jdField_a_of_type_ComTencentAvUiAVActivity.a.C(AudioHelper.b());
              localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373442);
              a(true);
              ((RelativeLayout)localObject).setVisibility(0);
              this.jdField_c_of_type_Boolean = true;
              ReportController.b(null, "CliOper", "", "", "0X800AA5D", "0X800AA5D", 4, 0, "", "", "", "");
            }
          }
          else if ((paramInt >= 1) && (!this.jdField_b_of_type_Boolean))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onNetworkQualityChanged. networkQuality = ");
            ((StringBuilder)localObject).append(paramInt);
            QLog.i("QavDoubleVideoSharpnessMangaer", 1, ((StringBuilder)localObject).toString());
            this.jdField_a_of_type_ComTencentAvUiAVActivity.a.N();
            this.jdField_a_of_type_ComTencentAvUiAVActivity.a.C(AudioHelper.b());
            localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373442);
            a(true);
            ((RelativeLayout)localObject).setVisibility(0);
            this.jdField_b_of_type_Boolean = true;
            ReportController.b(null, "CliOper", "", "", "0X800AA5D", "0X800AA5D", 3, 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject != null)
    {
      if (((VideoController)localObject).a == null) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((localObject != null) && (((SessionInfo)localObject).d == 2))
      {
        if (((SessionInfo)localObject).r()) {
          return;
        }
        if ((paramInt1 >= 1920) && (paramInt2 >= 1080))
        {
          if (!this.e)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onRecvVideoResolutionChanged. w = ");
            ((StringBuilder)localObject).append(paramInt1);
            ((StringBuilder)localObject).append(", h = ");
            ((StringBuilder)localObject).append(paramInt2);
            QLog.i("QavDoubleVideoSharpnessMangaer", 1, ((StringBuilder)localObject).toString());
            TipsUtil.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1058, this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getString(2131695787));
            this.e = true;
            ReportController.b(null, "CliOper", "", "", "0X800AA60", "0X800AA60", 4, 0, "", "", "", "");
          }
        }
        else if ((paramInt1 >= 1280) && (paramInt2 >= 720) && (!this.d))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onRecvVideoResolutionChanged. w = ");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(", h = ");
          ((StringBuilder)localObject).append(paramInt2);
          QLog.i("QavDoubleVideoSharpnessMangaer", 1, ((StringBuilder)localObject).toString());
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1058, this.jdField_a_of_type_ComTencentAvVideoController.a.getApp().getString(2131695788));
          this.d = true;
          ReportController.b(null, "CliOper", "", "", "0X800AA60", "0X800AA60", 3, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() < 5)
    {
      this.jdField_a_of_type_JavaUtilQueue.offer(Long.valueOf(paramLong2));
    }
    else
    {
      this.jdField_a_of_type_JavaUtilQueue.poll();
      this.jdField_a_of_type_JavaUtilQueue.offer(Long.valueOf(paramLong2));
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 5)
    {
      paramLong1 = 0L;
      Object localObject = this.jdField_a_of_type_JavaUtilQueue.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Long)((Iterator)localObject).next()).longValue() < QAVConfigUtils.b()) {
          paramLong1 += 1L;
        }
      }
      if (paramLong1 >= 4L)
      {
        paramLong2 = System.currentTimeMillis();
        if (paramLong2 - this.jdField_a_of_type_Long > 10000L)
        {
          this.jdField_a_of_type_Long = paramLong2;
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1057, HardCodeUtil.a(2131708899));
          ReportController.b(null, "CliOper", "", "", "0X800A346", "0X800A346", 0, 0, "", "", "", "");
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onReceiveFrameRateInfo frameRate sum/5:=");
          ((StringBuilder)localObject).append(paramLong1 / 5L);
          QLog.w("QavDoubleVideoSharpnessMangaer", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveFrameModeResultInfo. isS2CPush = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", retCode = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", wording = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", videoMode = ");
    localStringBuilder.append(paramInt2);
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, localStringBuilder.toString());
    if (!paramBoolean)
    {
      if ((paramInt1 != 0) && (!TextUtils.isEmpty(paramString))) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1057, paramString);
      }
    }
    else
    {
      int i;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().w != paramInt2) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramInt1 == 0) && (paramInt2 >= 0) && (paramInt2 < 4))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().w = paramInt2;
        this.jdField_a_of_type_JavaUtilQueue.clear();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveFrameModeResultInfo. newSharpnessMode = ");
        localStringBuilder.append(paramInt2);
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveFrameModeResultInfo. error. newSharpnessMode = ");
        localStringBuilder.append(paramInt2);
        QLog.e("QavDoubleVideoSharpnessMangaer", 1, localStringBuilder.toString());
      }
      if (paramInt1 == 10000) {
        ReportController.b(null, "CliOper", "", "", "0X800AA5F", "0X800AA5F", 4, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(paramString)) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvVideoController.a, 1057, paramString);
      }
      if ((paramInt1 == 0) && (i != 0))
      {
        k();
        long l = AudioHelper.b();
        this.jdField_a_of_type_ComTencentAvUiAVActivity.a.i(l, 1024);
      }
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().w;
    }
  }
  
  public boolean a()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    return (localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0);
  }
  
  public void b()
  {
    i();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setStartDelay(300L);
    localObjectAnimator.addListener(new QavDoubleVideoSharpnessMangaer.3(this));
    localObjectAnimator.start();
  }
  
  public void c()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public void d()
  {
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373442)).setVisibility(4);
    i();
    boolean bool1 = this.jdField_a_of_type_ComTencentAvUiQavSharpnessSVIPHelper.a();
    int k = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("switchToHDMode. curMinute = ");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(", startTime = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().x);
    ((StringBuilder)localObject).append(", endTime = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().y);
    ((StringBuilder)localObject).append(", tips = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().m);
    ((StringBuilder)localObject).append(", m1080PHDModeTipsHasShowed = ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, ((StringBuilder)localObject).toString());
    boolean bool2 = this.jdField_c_of_type_Boolean;
    int j = 3;
    int i;
    if (bool2) {
      i = 3;
    } else {
      i = 2;
    }
    ReportController.b(null, "CliOper", "", "", "0X800AA5E", "0X800AA5E", i + 1, 0, "", "", "", "");
    if ((!bool1) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().x > k) || (k >= this.jdField_a_of_type_ComTencentAvVideoController.a().y)))
    {
      this.jdField_a_of_type_Boolean = true;
      localObject = new QavDoubleVideoSharpnessMangaer.4(this);
      localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, 0, HardCodeUtil.a(2131708894), null, HardCodeUtil.a(2131708895), HardCodeUtil.a(2131708896), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (localObject != null) {
        ((QQCustomDialog)localObject).show();
      }
      ReportController.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_c_of_type_Boolean) {
      i = j;
    } else {
      i = 2;
    }
    this.jdField_b_of_type_Int = i;
    l();
  }
  
  public void e()
  {
    QavSharpnessSVIPHelper localQavSharpnessSVIPHelper = this.jdField_a_of_type_ComTencentAvUiQavSharpnessSVIPHelper;
    if (localQavSharpnessSVIPHelper != null) {
      localQavSharpnessSVIPHelper.b();
    }
  }
  
  public void f()
  {
    QavSharpnessSVIPHelper localQavSharpnessSVIPHelper = this.jdField_a_of_type_ComTencentAvUiQavSharpnessSVIPHelper;
    if (localQavSharpnessSVIPHelper != null) {
      localQavSharpnessSVIPHelper.d();
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiQavSharpnessSVIPHelper;
    if (localObject != null)
    {
      ((QavSharpnessSVIPHelper)localObject).e();
      this.jdField_a_of_type_ComTencentAvUiQavSharpnessSVIPHelper = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiAVActivity;
    if (localObject != null) {
      ((AVActivity)localObject).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (QLog.isColorLevel()) {
      QLog.w("QavDoubleVideoSharpnessMangaer", 1, "doDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer
 * JD-Core Version:    0.7.0.1
 */