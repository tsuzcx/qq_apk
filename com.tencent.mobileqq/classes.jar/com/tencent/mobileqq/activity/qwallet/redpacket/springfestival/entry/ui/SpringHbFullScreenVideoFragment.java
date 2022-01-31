package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import aguu;
import agve;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import axwd;
import baip;
import bjeh;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class SpringHbFullScreenVideoFragment
  extends PublicBaseFragment
  implements agve, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SpringHbVideoView jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int c;
  
  private void a(int paramInt1, String paramString, int paramInt2, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent("open_video_callback");
    localIntent.putExtra("retcode", paramInt1);
    localIntent.putExtra("retmsg", paramString);
    localIntent.putExtra("isDownloaded", paramInt2);
    localIntent.putExtra("played_time", paramLong1);
    localIntent.putExtra("total_time", paramLong2);
    if (getActivity() != null) {
      getActivity().sendBroadcast(localIntent);
    }
  }
  
  private void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent("open_video_callback");
    localIntent.putExtra("retcode", paramInt);
    localIntent.putExtra("retmsg", paramString);
    localIntent.putExtra("played_time", paramLong1);
    localIntent.putExtra("total_time", paramLong2);
    if (getActivity() != null) {
      getActivity().sendBroadcast(localIntent);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent(ApolloGameUtil.a(), SpringHbFullScreenVideoFragment.class);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("videoUrl", paramString2);
    localIntent.putExtra("showSkip", paramInt1);
    localIntent.putExtra("fadeInOut", paramInt2);
    localIntent.putExtra("bgColor", paramString3);
    localIntent.putExtra("bgImguUrl", paramString4);
    PublicTransFragmentActivity.b(ApolloGameUtil.a(), localIntent, SpringHbFullScreenVideoFragment.class);
  }
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new SpringHbFullScreenVideoFragment.3(this));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null)
    {
      if (isVisible())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a();
        a(0, "start play!", this.c, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.b() / 1000L, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a() / 1000L);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.f();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    QLog.e("QQFudaiVideoFragment", 1, "what:" + paramInt1 + "detailInfo:" + paramString);
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView == null)
    {
      l1 = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null) {
        break label105;
      }
    }
    label105:
    for (long l2 = 0L;; l2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a() / 1000L)
    {
      a(4, paramString, l1, l2);
      if (getActivity() != null)
      {
        getActivity().finish();
        getActivity().overridePendingTransition(0, 2130772040);
      }
      return;
      l1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.b() / 1000L;
      break;
    }
  }
  
  public void au_()
  {
    this.jdField_a_of_type_Boolean = true;
    if (getActivity() != null)
    {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 2130772040);
    }
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView == null)
    {
      l1 = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null) {
        break label72;
      }
    }
    label72:
    for (long l2 = 0L;; l2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a() / 1000L)
    {
      a(1, "play end!", l1, l2);
      return;
      l1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a() / 1000L;
      break;
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("QQFudaiVideoFragment", 2, "[initWindowStyleAndAnimation] activity is null");
      }
    }
    Window localWindow;
    do
    {
      return;
      localWindow = paramActivity.getWindow();
      if (localWindow != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QQFudaiVideoFragment", 2, "[initWindowStyleAndAnimation] window is null");
    return;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = localWindow.getAttributes();
      if (localObject == null) {
        break label134;
      }
      ((WindowManager.LayoutParams)localObject).layoutInDisplayCutoutMode = 1;
      localWindow.setAttributes((WindowManager.LayoutParams)localObject);
    }
    for (;;)
    {
      localWindow.setFlags(1024, 1024);
      localObject = (ViewGroup)localWindow.getDecorView();
      ((ViewGroup)localObject).setSystemUiVisibility(3846);
      if (Build.VERSION.SDK_INT >= 19) {
        ((ViewGroup)localObject).setOnSystemUiVisibilityChangeListener(new aguu(this, (ViewGroup)localObject));
      }
      localWindow.setSoftInputMode(17);
      paramActivity.overridePendingTransition(0, 0);
      return;
      label134:
      if (QLog.isColorLevel()) {
        QLog.i("QQFudaiVideoFragment", 2, "[set LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES] window attributes is null");
      }
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity().getIntent();
    String str1;
    String str2;
    Object localObject;
    if (paramBundle != null)
    {
      str1 = paramBundle.getStringExtra("uin");
      str2 = paramBundle.getStringExtra("videoUrl");
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("showSkip", 0);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("fadeInOut", 0);
      localObject = paramBundle.getStringExtra("bgImguUrl");
      if (baip.a((String)localObject)) {
        break label344;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_AndroidWidgetImageView.getHeight();
        localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_AndroidWidgetImageView.getWidth();
        localURLDrawableOptions.mLoadingDrawable = axwd.a;
        localURLDrawableOptions.mFailedDrawable = axwd.a;
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        if (localObject != null)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
      }
      catch (Exception localException)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
      }
      paramBundle = paramBundle.getStringExtra("bgColor");
      j = -16777216;
      i = j;
      if (!baip.a(paramBundle))
      {
        localObject = paramBundle.trim();
        paramBundle = (Bundle)localObject;
      }
      try
      {
        if (!((String)localObject).startsWith("#")) {
          paramBundle = "#" + (String)localObject;
        }
        i = Color.parseColor(paramBundle);
      }
      catch (Exception paramBundle)
      {
        QLog.e("QQFudaiVideoFragment", 2, paramBundle, new Object[0]);
        i = j;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQFudaiVideoFragment", 2, "uin:" + str1 + " videoUrl:" + str2 + " showSkip:" + this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.setFitView(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.setVideoListener(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.setVideoViewBlackColor(i);
        ThreadManagerV2.excute(new SpringHbFullScreenVideoFragment.2(this, str2), 16, null, true);
      }
      return;
      label344:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (getActivity() == null);
    getActivity().finish();
    getActivity().overridePendingTransition(0, 2130772040);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = getActivity();
    bjeh.a(paramBundle);
    if (bjeh.b()) {
      bjeh.c(paramBundle);
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131497017, paramViewGroup, false);
    paramLayoutInflater = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301252);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView = new SpringHbVideoView(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.setLoop(false);
    paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
    paramViewGroup.addRule(13);
    paramLayoutInflater.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301250));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301249));
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.g();
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.b();
      }
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    long l1;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null) {
        break label45;
      }
      l1 = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null) {
        break label60;
      }
    }
    label45:
    label60:
    for (long l2 = 0L;; l2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a() / 1000L)
    {
      a(2, "jump play", l1, l2);
      this.jdField_a_of_type_Boolean = true;
      return;
      l1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.b() / 1000L;
      break;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.e();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbFullScreenVideoFragment
 * JD-Core Version:    0.7.0.1
 */