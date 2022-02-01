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
  private static String a = "MsgNotifyPushForSpecialCareDialog";
  private static String b = HardCodeUtil.a(2131904830);
  private static String c = HardCodeUtil.a(2131904827);
  private Context d;
  private QQAppInterface e;
  private RoundImageView f;
  private String g;
  private IFaceDecoder h;
  private INonMainProcAvatarLoader i;
  private FaceObserver j;
  
  @TargetApi(14)
  public MsgNotifyPushForSpecialCareDialog(Context paramContext, @Nullable QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, 2131953338);
    super.getWindow().setWindowAnimations(2131951986);
    getWindow().setDimAmount(0.5F);
    this.d = paramContext;
    this.e = paramQQAppInterface;
    this.g = paramString;
  }
  
  public void a()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((INonMainProcAvatarLoader)localObject).b(this.j);
      this.i.c();
    }
  }
  
  public void onBackPressed() {}
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131624622);
    this.f = ((RoundImageView)findViewById(2131431868));
    paramBundle = (TextView)findViewById(2131431880);
    TextView localTextView = (TextView)findViewById(2131431844);
    Button localButton = (Button)findViewById(2131431841);
    ImageView localImageView = (ImageView)findViewById(2131430817);
    Object localObject = this.e;
    if (localObject != null)
    {
      this.h = ((IQQAvatarService)((QQAppInterface)localObject).getRuntimeService(IQQAvatarService.class, "")).getInstance(this.e);
      this.h.setDecodeTaskCompletionListener(this);
      localObject = this.h.getBitmapFromCache(1, this.g, 0);
      if (localObject == null)
      {
        if (!this.h.isPausing()) {
          this.h.requestDecodeFace(this.g, 1, true);
        }
        this.f.setBackgroundDrawable(ImageUtil.m());
      }
      else
      {
        this.f.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
      }
    }
    else
    {
      this.i = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.d, 1);
      this.i.a();
      this.j = new MsgNotifyPushForSpecialCareDialog.1(this);
      this.i.a(this.j);
      this.f.setImageBitmap(this.i.a(this.g, true));
    }
    paramBundle.setText(b);
    localTextView.setText(c);
    localButton.setText(HardCodeUtil.a(2131904829));
    localButton.setOnClickListener(new MsgNotifyPushForSpecialCareDialog.2(this));
    localImageView.setOnClickListener(new MsgNotifyPushForSpecialCareDialog.3(this));
    localImageView.setOnTouchListener(new MsgNotifyPushForSpecialCareDialog.4(this, localImageView));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
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
      if (this.h.isPausing()) {
        return;
      }
      this.f.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog
 * JD-Core Version:    0.7.0.1
 */