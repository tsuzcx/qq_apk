package com.tencent.mobileqq.app.msgnotify;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.armap.FaceObserver;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class MsgNotifyPushForSpecialCareDialog
  extends ReportDialog
  implements DecodeTaskCompletionListener
{
  private static String jdField_a_of_type_JavaLangString = "MsgNotifyPushForSpecialCareDialog";
  private static String b = HardCodeUtil.a(2131706988);
  private static String c = HardCodeUtil.a(2131706985);
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private FaceObserver jdField_a_of_type_ComTencentMobileqqArmapFaceObserver;
  private INonMainProcAvatarLoader jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private String d;
  
  @TargetApi(14)
  public MsgNotifyPushForSpecialCareDialog(Context paramContext, @Nullable QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, 2131756189);
    super.getWindow().setWindowAnimations(2131755294);
    getWindow().setDimAmount(0.5F);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramString;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
    if (localObject != null)
    {
      ((INonMainProcAvatarLoader)localObject).b(this.jdField_a_of_type_ComTencentMobileqqArmapFaceObserver);
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.b();
    }
  }
  
  public void onBackPressed() {}
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131558989);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)findViewById(2131365637));
    paramBundle = (TextView)findViewById(2131365648);
    TextView localTextView = (TextView)findViewById(2131365613);
    Button localButton = (Button)findViewById(2131365610);
    ImageView localImageView = (ImageView)findViewById(2131364711);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)((QQAppInterface)localObject).getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, this.d, 0);
      if (localObject == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.d, 1, true);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(ImageUtil.f());
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidContentContext, 1);
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a();
      this.jdField_a_of_type_ComTencentMobileqqArmapFaceObserver = new MsgNotifyPushForSpecialCareDialog.1(this);
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(this.jdField_a_of_type_ComTencentMobileqqArmapFaceObserver);
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(this.d, true));
    }
    paramBundle.setText(b);
    localTextView.setText(c);
    localButton.setText(HardCodeUtil.a(2131706987));
    localButton.setOnClickListener(new MsgNotifyPushForSpecialCareDialog.2(this));
    localImageView.setOnClickListener(new MsgNotifyPushForSpecialCareDialog.3(this));
    localImageView.setOnTouchListener(new MsgNotifyPushForSpecialCareDialog.4(this, localImageView));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",avatar= ");
      localStringBuilder.append(paramBitmap);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBitmap != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog
 * JD-Core Version:    0.7.0.1
 */