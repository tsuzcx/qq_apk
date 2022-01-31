package com.qq.im.poi;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anw;
import anx;
import any;
import anz;
import aoa;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class LbsStrangerPoiDialog
  extends Dialog
  implements ResDownloadManager.IResDownloadListener
{
  int jdField_a_of_type_Int;
  public long a;
  Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public LbsPackInfo a;
  public LbsPackManager a;
  public LbsPackObserver a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  ARMapActivity jdField_a_of_type_ComTencentMobileqqArmapARMapActivity;
  ArMapInterface jdField_a_of_type_ComTencentMobileqqArmapArMapInterface;
  NonMainAppHeadLoader.FaceObserver jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver = new aoa(this);
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  public RelativeLayout b;
  public TextView b;
  LbsPackInfo jdField_b_of_type_ComQqImPoiLbsPackInfo;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public TextView c;
  public int d = 0;
  
  public LbsStrangerPoiDialog(ARMapActivity paramARMapActivity, ArMapInterface paramArMapInterface, long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, long paramLong3)
  {
    super(paramARMapActivity, 2131624516);
    this.jdField_a_of_type_AndroidOsHandler = new any(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComQqImPoiLbsPackObserver = new anz(this);
    this.jdField_a_of_type_AndroidContentContext = paramARMapActivity;
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity = paramARMapActivity;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Long = paramLong3;
    this.jdField_a_of_type_ComQqImPoiLbsPackManager = ((LbsPackManager)paramArMapInterface.getManager(214));
    setContentView(2130970228);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369729));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369727));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369725));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369728));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369731));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369732));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new anw(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369721));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369723));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369724));
    paramString1 = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramString1.getAttributes();
    localLayoutParams.width = paramARMapActivity.getResources().getDisplayMetrics().widthPixels;
    localLayoutParams.height = paramARMapActivity.getResources().getDisplayMetrics().heightPixels;
    paramString1.setAttributes(localLayoutParams);
    LbsPackMapPoiPackServlet.a(paramArMapInterface, paramLong1, paramString2, true, this.jdField_c_of_type_Long);
    if (paramARMapActivity.app != null)
    {
      paramARMapActivity.app.a.a(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
      paramArMapInterface.registObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "LbsStrangerPoiDialog init mPoiId=" + this.jdField_a_of_type_Long + " taskID=" + paramLong2 + "tasktype=" + paramLong2 + " packid=" + paramString2 + " madcode=" + this.jdField_c_of_type_Long);
    }
  }
  
  public void a()
  {
    int j = getWindow().getAttributes().width;
    int i = getWindow().getAttributes().height;
    j = (j - AIOUtils.a(320.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    i = (i - AIOUtils.a(420.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 0, this.jdField_a_of_type_Int - j, 0, this.jdField_b_of_type_Int - i);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimationSet);
    localAnimationSet.setAnimationListener(new anx(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.show();
    int j = getWindow().getAttributes().width;
    int i = getWindow().getAttributes().height;
    j = (j - AIOUtils.a(320.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    i = (i - AIOUtils.a(420.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / 2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    Object localObject = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 0, paramInt1 - j, 0, paramInt2 - i);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    ((AnimationSet)localObject).addAnimation(localScaleAnimation);
    ((AnimationSet)localObject).setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject);
    this.jdField_b_of_type_ComQqImPoiLbsPackInfo = this.jdField_a_of_type_ComQqImPoiLbsPackManager.a(this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString);
    if (this.jdField_b_of_type_ComQqImPoiLbsPackInfo != null) {}
    for (localObject = String.valueOf(this.jdField_b_of_type_ComQqImPoiLbsPackInfo.jdField_a_of_type_Long);; localObject = "")
    {
      ReportController.b(null, "dc01440", "", "", "0X8007A54", "0X8007A54", 0, 0, (String)localObject, String.valueOf(this.jdField_a_of_type_Long), "", this.jdField_b_of_type_JavaLangString);
      return;
    }
  }
  
  public void a(LbsPackInfo paramLbsPackInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "LbsStrangerPoiDialog bindView LbsPackInfo:" + paramLbsPackInfo);
    }
    this.jdField_a_of_type_ComQqImPoiLbsPackInfo = paramLbsPackInfo;
    this.d = paramInt;
    if (this.jdField_a_of_type_ComQqImPoiLbsPackInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "bindData failed");
      }
      return;
    }
    this.jdField_b_of_type_ComTencentImageURLImageView.setImageBitmap(((ARMapActivity)this.jdField_a_of_type_AndroidContentContext).app.a.a(paramLbsPackInfo.jdField_a_of_type_Long + "", true));
    Object localObject = this.jdField_a_of_type_ComQqImPoiLbsPackInfo.c;
    paramLbsPackInfo = (LbsPackInfo)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.jdField_a_of_type_ComQqImPoiLbsPackManager.b(this.jdField_a_of_type_ComQqImPoiLbsPackInfo.jdField_a_of_type_Long + "");
      paramLbsPackInfo = (LbsPackInfo)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramLbsPackInfo = this.jdField_a_of_type_ComQqImPoiLbsPackInfo.jdField_a_of_type_Long + "";
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.jdField_a_of_type_ComQqImPoiLbsPackInfo.jdField_a_of_type_Long + "");
        this.jdField_a_of_type_ComQqImPoiLbsPackManager.a((ArrayList)localObject);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("AR红包");
    if (paramInt > 1)
    {
      localObject = "等" + paramInt + "人";
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramLbsPackInfo + (String)localObject);
      if (paramInt <= 1) {
        break label391;
      }
    }
    label391:
    for (localObject = "等" + paramInt + "人发" + getContext().getString(2131438776);; localObject = getContext().getString(2131438776))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramLbsPackInfo + (String)localObject);
      return;
      localObject = "";
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(Drawable.createFromPath(paramString3 + File.separator + "banner.png"));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(Drawable.createFromPath(paramString3 + File.separator + "background.png"));
    }
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.a.b(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.unRegistObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.unRegistObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.isFinishing()) {
      super.dismiss();
    }
  }
  
  public void show()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.isFinishing()) {
      super.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsStrangerPoiDialog
 * JD-Core Version:    0.7.0.1
 */