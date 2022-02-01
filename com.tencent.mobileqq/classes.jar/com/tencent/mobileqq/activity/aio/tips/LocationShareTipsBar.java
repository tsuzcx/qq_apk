package com.tencent.mobileqq.activity.aio.tips;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import java.util.HashMap;
import java.util.List;

public class LocationShareTipsBar
  implements View.OnClickListener, TipsBarTask, DecodeTaskCompletionListener
{
  private static long jdField_a_of_type_Long = 0L;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LocationShareTipsBar.1(this);
  private HashMap<String, ImageView> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  
  public LocationShareTipsBar(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(3);
    paramBaseChatPie = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramBaseChatPie.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  @TargetApi(19)
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374588));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    if (AppSetting.d) {
      paramView.setContentDescription(paramString);
    }
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != BaseActivity.sTopActivity) {
      return;
    }
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
    if (localBitmap != null)
    {
      paramImageView.setImageBitmap(localBitmap);
      paramImageView.setVisibility(0);
      return;
    }
    paramImageView.setVisibility(4);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramImageView);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, true);
  }
  
  public static void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramTextView.getWidth() == 0)
    {
      paramTextView.post(new LocationShareTipsBar.2(paramString1, paramString2, paramTextView));
      return;
    }
    String str = paramString1 + paramString2;
    float f2 = paramTextView.getWidth();
    float f1 = paramTextView.getPaint().measureText(paramString1);
    float f3 = paramTextView.getPaint().measureText(paramString2);
    if (f1 + f3 <= f2)
    {
      paramTextView.setText(str);
      return;
    }
    float f4 = paramTextView.getPaint().measureText("...");
    while ((f1 + f4 + f3 > f2) && (paramString1.length() > 0))
    {
      paramString1 = paramString1.substring(0, paramString1.length() - 1);
      f1 = paramTextView.getPaint().measureText(paramString1);
    }
    paramTextView.setText(paramString1 + "..." + paramString2);
  }
  
  private void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374594);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374587);
    if (ThemeImageWrapper.isNightMode())
    {
      localView.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localImageView.setImageResource(2130839601);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    }
    localImageView.setImageResource(2130839600);
  }
  
  private void b(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)View.inflate((Context)localObject, 2131561083, null));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setClickable(true);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374590).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374591).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374592).setVisibility(8);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374589);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      localTextView.setTextColor(Color.parseColor("#A8A8A8"));
    }
    a();
    if (paramBoolean)
    {
      paramString = "你" + ((Activity)localObject).getString(2131696029);
      localTextView.setText(paramString);
      if (!this.jdField_a_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X800A767", "0X800A767", 1, 0, "", "0", "0", "");
        this.jdField_a_of_type_Boolean = true;
      }
      a(this.jdField_a_of_type_AndroidViewViewGroup, paramString);
      if ((paramList.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramList.get(0)))) {
        a((String)paramList.get(0), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374590));
      }
      if ((paramList.size() > 1) && (!TextUtils.isEmpty((CharSequence)paramList.get(1)))) {
        a((String)paramList.get(1), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374591));
      }
      if ((paramList.size() > 2) && (!TextUtils.isEmpty((CharSequence)paramList.get(2)))) {
        a((String)paramList.get(2), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374592));
      }
      this.jdField_a_of_type_AndroidViewViewGroup.addOnAttachStateChangeListener(new LocationShareTipsBar.3(this));
      b();
      return;
    }
    if (paramInt == 1) {}
    for (localObject = ((Activity)localObject).getString(2131696029);; localObject = String.format(((Activity)localObject).getString(2131696028), new Object[] { Integer.valueOf(paramInt) }))
    {
      String str = paramString + (String)localObject;
      a(paramString, (String)localObject, localTextView);
      if (!this.jdField_a_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X800A767", "0X800A767", 2, 0, "", "0", "0", "");
        this.jdField_a_of_type_Boolean = true;
      }
      a(this.jdField_a_of_type_AndroidViewViewGroup, str + " 点击加入位置共享");
      break;
    }
  }
  
  public int a()
  {
    return 60;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
      }
    }
    while ((paramInt != 1003) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null)) {
      return;
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    b(paramBoolean, paramString, paramInt, paramList);
  }
  
  public int[] a()
  {
    return new int[0];
  }
  
  public int b()
  {
    return 25;
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareTipsBar", 2, new Object[] { "onClick: invoked. ", " v: ", paramView });
      }
      jdField_a_of_type_Long = System.currentTimeMillis();
      LocationShareServiceHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).launchShareUi(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3);
      ReportController.b(null, "CliOper", "", "", "0X800A768", "0X800A768", 0, 0, "", "0", "0", "");
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (ImageView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null)
    {
      paramString.setImageBitmap(paramBitmap);
      paramString.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LocationShareTipsBar
 * JD-Core Version:    0.7.0.1
 */