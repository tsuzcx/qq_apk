import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedPackPreviewFragment;
import com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer;
import com.tencent.mobileqq.activity.qwallet.emoj.IBaseRecognizer;
import com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.11;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.12;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.13;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.7;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.8;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.9;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCountTimeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class bnbz
  extends QIMEffectCameraCaptureUnit
  implements baow
{
  public static long d;
  public long a;
  private bole jdField_a_of_type_Bole = new bncb(this);
  IBaseRecognizer jdField_a_of_type_ComTencentMobileqqActivityQwalletEmojIBaseRecognizer = new bncg(this);
  protected AnimationQIMCircleProgress a;
  public TextView c;
  public int d;
  public Button d;
  public TextView d;
  public int e;
  private long e;
  public int f;
  public View f;
  public int g = 90;
  int h;
  public int i = 0;
  private int j;
  public String l = "https://i.gtimg.cn/channel/static/expression/aEModel_1558597938237.zip";
  public String m;
  public String n;
  
  static
  {
    jdField_d_of_type_Long = 200L;
  }
  
  public bnbz(boyn paramboyn, boym paramboym)
  {
    super(paramboyn, paramboym);
    this.jdField_a_of_type_Boyf = new boyf(10022, 100, 13);
  }
  
  private String a(bolr parambolr)
  {
    Object localObject = null;
    if (parambolr != null) {}
    for (;;)
    {
      try
      {
        parambolr = parambolr.b.iterator();
        if (!parambolr.hasNext()) {
          break label76;
        }
        localObject = (bokw)parambolr.next();
        if (!(localObject instanceof boof)) {
          continue;
        }
        parambolr = (boof)localObject;
        if (parambolr != null)
        {
          parambolr = Uri.parse(parambolr.b()).getPath();
          localObject = parambolr;
          return localObject;
        }
      }
      catch (Throwable parambolr)
      {
        parambolr.printStackTrace();
        return null;
      }
      parambolr = null;
      continue;
      label76:
      parambolr = null;
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Camera paramCamera)
  {
    if (this.jdField_f_of_type_Int == 0) {
      HandRecognizer.getInstance().onPreviewFrameHandler(paramArrayOfByte, paramInt1, paramInt2, paramCamera, paramInt3, new bnce(this));
    }
    while (this.jdField_f_of_type_Int != 1) {
      return;
    }
    QWalletFaceTracker.getInstance().onPreviewFrameHandler(paramArrayOfByte, this.g, paramInt1, paramInt2, paramInt3, new bncf(this));
  }
  
  private void ae()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText("根据提示做动作 \n 识别成功即可领取红包~");
  }
  
  private void af()
  {
    ae();
    this.jdField_e_of_type_Int = a().getIntent().getIntExtra("emoji_feeds_id", 0);
    if ((this.jdField_e_of_type_Int < 0) || (this.jdField_e_of_type_Int >= 200)) {
      this.jdField_e_of_type_Int = 0;
    }
    if (this.jdField_e_of_type_Int < 100)
    {
      this.jdField_f_of_type_Int = 0;
      if (this.jdField_f_of_type_Int != 0) {
        break label318;
      }
    }
    label318:
    for (int k = 90;; k = 50)
    {
      this.g = a().getIntent().getIntExtra("emoji_threshold", k);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(3000.0F);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.b.setContentDescription(anni.a(2131708562));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setUseVideoOrientation(true);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setPreviewCallback(this);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(3);
      this.jdField_d_of_type_Int = a().getIntent().getIntExtra("emoji_combo_id", 0);
      this.h = a().getIntent().getIntExtra("emoji_capture_tag", 0);
      this.m = a().getIntent().getStringExtra("emoji_face_config_path");
      this.n = a().getIntent().getStringExtra("emoji_hand_res_folder_path");
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(new bncc(this));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setOnTouchListener(new bncd(this));
      this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.d(false);
      if (QLog.isColorLevel()) {
        QLog.i("QIMEmojiRedPacketCameraCapture", 2, "init setting mFeedsId=" + this.jdField_e_of_type_Int + ",threshold=" + this.g + ",mComboId=" + this.jdField_d_of_type_Int);
      }
      return;
      this.jdField_f_of_type_Int = 1;
      this.jdField_e_of_type_Int -= 100;
      break;
    }
  }
  
  private void ag()
  {
    try
    {
      if (this.jdField_f_of_type_Int == 0)
      {
        HandRecognizer.getInstance().unInit();
        return;
      }
      if (this.jdField_f_of_type_Int == 1)
      {
        QWalletFaceTracker.getInstance().unInit();
        return;
      }
    }
    catch (Throwable localThrowable) {}
  }
  
  private boolean i()
  {
    return (this.j >= 3) && (System.currentTimeMillis() - this.jdField_e_of_type_Long >= 1000L);
  }
  
  private void o(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "initRecognizer  mRecogType=" + this.jdField_f_of_type_Int);
    }
    if (this.jdField_f_of_type_Int == 0) {
      HandRecognizer.getInstance().init(a(), this.n, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletEmojIBaseRecognizer);
    }
    while ((this.jdField_f_of_type_Int != 1) || (!paramBoolean)) {
      return;
    }
    QWalletFaceTracker.getInstance().init(a(), this.m, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletEmojIBaseRecognizer);
  }
  
  public void F()
  {
    g();
    L();
    QQToast.a(BaseApplicationImpl.getContext(), anni.a(2131708564), 0).a();
  }
  
  public void I() {}
  
  public void L()
  {
    super.L();
    bcst.b(null, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.video.short", 0, 0, "", "", "", "");
  }
  
  public void V()
  {
    int k = 100;
    super.V();
    this.jdField_a_of_type_Bojo.b(100);
    bojo localbojo = this.jdField_a_of_type_Bojo;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.k) {}
    for (;;)
    {
      localbojo.c(k);
      return;
      k = -1;
    }
  }
  
  public int a()
  {
    return 2131560947;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    ac();
    af();
    return localView;
  }
  
  protected baou a()
  {
    baou localbaou = super.a();
    localbaou.a(0.33F);
    localbaou.a(false);
    localbaou.b(false);
    localbaou.i(1);
    return localbaou;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      a().setResult(-1, paramIntent);
      a().finish();
      return;
    }
    EmojiGifHelper.removeTask(this.h);
    ae();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onVideoCaptured isSuccReg()=" + i() + "，mSuccRecogs=" + this.j);
    }
    if (i())
    {
      EmojiRedPackPreviewFragment.start(a(), 1, this.h, paramVideoCaptureResult, paramLocalMediaInfo);
      bcst.b(null, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.video.success", 0, 0, "", "", "", "");
      return;
    }
    if (System.currentTimeMillis() - this.jdField_e_of_type_Long < 1000L)
    {
      ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.8(this));
      return;
    }
    ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.9(this));
  }
  
  public void a(QQFilterRenderManager.ChainBuilder paramChainBuilder)
  {
    super.a(paramChainBuilder);
    if (paramChainBuilder != null) {
      paramChainBuilder.addFilter(185, null);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    int k = 100;
    super.a(paramBoolean, paramString);
    this.jdField_a_of_type_Bojo.b(100);
    paramString = this.jdField_a_of_type_Bojo;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.k) {}
    for (;;)
    {
      paramString.c(k);
      return;
      k = -1;
    }
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.f()) {}
    do
    {
      return;
      if (i())
      {
        ad();
        return;
      }
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= jdField_d_of_type_Long);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(paramArrayOfByte, paramCamera.getParameters().getPreviewSize().width, paramCamera.getParameters().getPreviewSize().height, this.jdField_e_of_type_Int, paramCamera);
  }
  
  public void a_(boolean paramBoolean)
  {
    super.a_(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onSoLoad" + paramBoolean);
    }
    ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.12(this));
    o(paramBoolean);
  }
  
  public void ac()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380100));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380053));
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131380874);
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363741));
    akww.a(this.jdField_d_of_type_AndroidWidgetButton, 0.3F);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(new bnca(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)this.jdField_a_of_type_AndroidViewView.findViewById(2131365143));
    Object localObject = (QIMCameraCountTimeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364160);
    ((QIMCameraCountTimeLayout)localObject).setDotView(2130847257);
    ((QIMCameraCountTimeLayout)localObject).setTextColor(7829367);
    localObject = (AnimationQIMCircleProgress)this.jdField_a_of_type_AndroidViewView.findViewById(2131365143);
    ((AnimationQIMCircleProgress)localObject).setProgressColor(-1694379);
    ((AnimationQIMCircleProgress)localObject).setCenterCircleColor(-1694379);
    this.jdField_a_of_type_JavaLangString = anni.a(2131708563);
  }
  
  public void ad()
  {
    ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.7(this));
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "initCombo begin comboId:" + paramInt);
    }
    bolb localbolb = (bolb)bojv.a(5);
    localbolb.a(this.jdField_a_of_type_Bole);
    localbolb.a().a(this.i);
    localbolb.j();
    localbolb.a(false);
    QIMFilterCategoryItem localQIMFilterCategoryItem = localbolb.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "initCombo:" + localQIMFilterCategoryItem);
    }
    if (localQIMFilterCategoryItem == null) {}
    do
    {
      return;
      localObject = localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString;
      if (!localbolb.a().a((String)localObject, a())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QIMEmojiRedPacketCameraCapture", 2, "initCombo lock return");
    return;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("apply_source", 1);
    ((Bundle)localObject).putInt("capture_scene", this.i);
    bolr localbolr = localbolb.a(localQIMFilterCategoryItem);
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "combo.outState=" + localbolr.a);
    }
    if ((localbolr.a == 1) || (localbolr.a == 2)) {
      boud.a(localbolr).a();
    }
    ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.13(this, localbolb, localQIMFilterCategoryItem, (Bundle)localObject));
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onDestroy@" + hashCode());
    }
    bolb localbolb = (bolb)bojv.a(5);
    if (localbolb != null) {
      localbolb.b(this.jdField_a_of_type_Bole);
    }
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_Bojo.a(8);
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    ae();
  }
  
  public void h()
  {
    super.h();
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onCaptureButtonVideoStart");
    }
    super.j();
    this.j = 0;
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_AndroidWidgetTextView.setText(anni.a(2131708561));
    bcst.b(null, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.video.click", 0, 0, "", "", "", "");
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Int != 0) {
      ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.11(this));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onResourceDownload" + paramBoolean);
    }
  }
  
  public void m()
  {
    super.m();
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onDestroyFilters@" + hashCode());
    }
    ag();
  }
  
  public void o()
  {
    super.o();
    this.u = false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbz
 * JD-Core Version:    0.7.0.1
 */