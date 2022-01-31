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

public class bkjf
  extends QIMEffectCameraCaptureUnit
  implements axmm
{
  public static long d;
  public long a;
  private blno jdField_a_of_type_Blno = new bkjh(this);
  IBaseRecognizer jdField_a_of_type_ComTencentMobileqqActivityQwalletEmojIBaseRecognizer = new bkjm(this);
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
  public String l = "http://i.gtimg.cn/channel/static/expression/aEModel_1558597938237.zip";
  public String m;
  public String n;
  
  static
  {
    jdField_d_of_type_Long = 200L;
  }
  
  public bkjf(bmcv parambmcv, bmcu parambmcu)
  {
    super(parambmcv, parambmcu);
    this.jdField_a_of_type_Bmcn = new bmcn(10022, 100, 13);
  }
  
  private String a(blob paramblob)
  {
    Object localObject = null;
    if (paramblob != null) {}
    for (;;)
    {
      try
      {
        paramblob = paramblob.b.iterator();
        if (!paramblob.hasNext()) {
          break label76;
        }
        localObject = (blng)paramblob.next();
        if (!(localObject instanceof blqp)) {
          continue;
        }
        paramblob = (blqp)localObject;
        if (paramblob != null)
        {
          paramblob = Uri.parse(paramblob.b()).getPath();
          localObject = paramblob;
          return localObject;
        }
      }
      catch (Throwable paramblob)
      {
        paramblob.printStackTrace();
        return null;
      }
      paramblob = null;
      continue;
      label76:
      paramblob = null;
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Camera paramCamera)
  {
    if (this.jdField_f_of_type_Int == 0) {
      HandRecognizer.getInstance().onPreviewFrameHandler(paramArrayOfByte, paramInt1, paramInt2, paramCamera, paramInt3, new bkjk(this));
    }
    while (this.jdField_f_of_type_Int != 1) {
      return;
    }
    QWalletFaceTracker.getInstance().onPreviewFrameHandler(paramArrayOfByte, this.g, paramInt1, paramInt2, paramInt3, new bkjl(this));
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
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.b.setContentDescription(alpo.a(2131710174));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setUseVideoOrientation(true);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setPreviewCallback(this);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(3);
      this.jdField_d_of_type_Int = a().getIntent().getIntExtra("emoji_combo_id", 0);
      this.h = a().getIntent().getIntExtra("emoji_capture_tag", 0);
      this.m = a().getIntent().getStringExtra("emoji_face_config_path");
      this.n = a().getIntent().getStringExtra("emoji_hand_res_folder_path");
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(new bkji(this));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setOnTouchListener(new bkjj(this));
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
    QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131710176), 0).a();
  }
  
  public void I() {}
  
  public void L()
  {
    super.L();
    azmj.b(null, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.video.short", 0, 0, "", "", "", "");
  }
  
  public void V()
  {
    int k = 100;
    super.V();
    this.jdField_a_of_type_Blly.b(100);
    blly localblly = this.jdField_a_of_type_Blly;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.k) {}
    for (;;)
    {
      localblly.c(k);
      return;
      k = -1;
    }
  }
  
  public int a()
  {
    return 2131560724;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    ac();
    af();
    return localView;
  }
  
  protected axmk a()
  {
    axmk localaxmk = super.a();
    localaxmk.a(0.33F);
    localaxmk.a(false);
    localaxmk.b(false);
    localaxmk.i(1);
    return localaxmk;
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
      azmj.b(null, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.video.success", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_Blly.b(100);
    paramString = this.jdField_a_of_type_Blly;
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
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379119));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379067));
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379859);
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363541));
    ajaf.a(this.jdField_d_of_type_AndroidWidgetButton, 0.3F);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(new bkjg(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_DovComQqImStoryViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)this.jdField_a_of_type_AndroidViewView.findViewById(2131364906));
    Object localObject = (QIMCameraCountTimeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363957);
    ((QIMCameraCountTimeLayout)localObject).setDotView(2130846734);
    ((QIMCameraCountTimeLayout)localObject).setTextColor(7829367);
    localObject = (AnimationQIMCircleProgress)this.jdField_a_of_type_AndroidViewView.findViewById(2131364906);
    ((AnimationQIMCircleProgress)localObject).setProgressColor(-1694379);
    ((AnimationQIMCircleProgress)localObject).setCenterCircleColor(-1694379);
    this.jdField_a_of_type_JavaLangString = alpo.a(2131710175);
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
    blnl localblnl = (blnl)blmf.a(5);
    localblnl.a(this.jdField_a_of_type_Blno);
    localblnl.a().a(this.i);
    localblnl.i();
    localblnl.a(false);
    QIMFilterCategoryItem localQIMFilterCategoryItem = localblnl.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "initCombo:" + localQIMFilterCategoryItem);
    }
    if (localQIMFilterCategoryItem == null) {}
    do
    {
      return;
      localObject = localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString;
      if (!localblnl.a().a((String)localObject, a())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QIMEmojiRedPacketCameraCapture", 2, "initCombo lock return");
    return;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("apply_source", 1);
    ((Bundle)localObject).putInt("capture_scene", this.i);
    blob localblob = localblnl.a(localQIMFilterCategoryItem);
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "combo.outState=" + localblob.a);
    }
    if ((localblob.a == 1) || (localblob.a == 2)) {
      blwn.a(localblob).a();
    }
    ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.13(this, localblnl, localQIMFilterCategoryItem, (Bundle)localObject));
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onDestroy@" + hashCode());
    }
    blnl localblnl = (blnl)blmf.a(5);
    if (localblnl != null) {
      localblnl.b(this.jdField_a_of_type_Blno);
    }
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_Blly.a(8);
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
    this.jdField_c_of_type_AndroidWidgetTextView.setText(alpo.a(2131710173));
    azmj.b(null, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.video.click", 0, 0, "", "", "", "");
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
 * Qualified Name:     bkjf
 * JD-Core Version:    0.7.0.1
 */