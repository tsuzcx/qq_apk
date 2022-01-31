package com.tencent.av.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.BidirectionSeekBar;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jsq;
import jsr;
import jss;
import jst;
import jsu;
import jsv;

public class BeautySettingUi
  implements SeekBar.OnSeekBarChangeListener
{
  int jdField_a_of_type_Int;
  public Resources a;
  public Drawable a;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  public VideoAppInterface a;
  ControlUIObserver jdField_a_of_type_ComTencentAvUiControlUIObserver;
  TipsManager jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
  public BidirectionSeekBar a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  public Drawable b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public int c;
  public Drawable c;
  boolean c;
  int d;
  public Drawable d;
  
  BeautySettingUi(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("BeautySettingUi", 2, "BeautySettingUi");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = paramControlUIObserver;
  }
  
  static boolean a(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoController.a().i) || (!paramVideoController.a().jdField_f_of_type_Boolean) || (!AVNotifyCenter.e(paramVideoAppInterface.getCurrentAccountUin())) || (!paramVideoController.a().j)) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BeautySettingUi", 2, "onCreate");
    }
    b();
    f();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams());
    }
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_b_of_type_Int = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      this.jdField_a_of_type_Int = (((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.getLayoutParams()).leftMargin + this.jdField_b_of_type_Int / 2);
    }
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getWidth();
    int j = this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.getWidth();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = (this.jdField_a_of_type_Int - i / 2 + (j - this.jdField_b_of_type_Int) * paramInt / 100);
    this.jdField_b_of_type_AndroidWidgetTextView.requestLayout();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt + "%");
  }
  
  void a(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131365899: 
    case 2131365900: 
    default: 
      return;
    case 2131365901: 
      AVNotifyCenter.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(117) });
      if (this.jdField_c_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X800501E", "0X800501E", 0, 0, "", "", "", "");
        if (this.jdField_c_of_type_Int == 0) {
          ReportController.b(null, "CliOper", "", "", "0X800501F", "0X800501F", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_c_of_type_Int <= 0) {
          break;
        }
        paramView = SessionMgr.a().a();
        if (paramView == null) {
          break;
        }
        paramView.s = true;
        return;
        ReportController.b(null, "CliOper", "", "", "0X8005019", "0X8005019", 0, 0, "", "", "", "");
        if (this.jdField_c_of_type_Int == 0) {
          ReportController.b(null, "CliOper", "", "", "0X800501A", "0X800501A", 0, 0, "", "", "", "");
        }
      }
    }
    a();
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = paramBoolean;
    int i = AVNotifyCenter.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_d_of_type_Int = i;
    this.jdField_c_of_type_Int = i;
    if (this.jdField_c_of_type_Int == -1)
    {
      this.jdField_c_of_type_Int = AVNotifyCenter.e;
      this.jdField_d_of_type_Int = 0;
    }
    d(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setProgress(this.jdField_c_of_type_Int);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131429258);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429259));
      ReportController.b(null, "CliOper", "", "", "0X800501C", "0X800501C", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429260));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131429256);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429257));
      ReportController.b(null, "CliOper", "", "", "0X8005017", "0X8005017", 0, 0, "", "", "", "");
    }
  }
  
  boolean a()
  {
    g();
    d(this.jdField_d_of_type_Int);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(117) });
      return true;
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), str, Boolean.valueOf(true) });
    ReportController.b(null, "CliOper", "", "", "0X8005018", "0X8005018", 0, 0, "", "", "", "");
    return false;
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        localAVActivity.getLayoutInflater().inflate(2130969267, this.jdField_a_of_type_AndroidViewViewGroup);
        this.jdField_a_of_type_AndroidContentResResources = localAVActivity.getResources();
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365898));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365901));
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar = ((BidirectionSeekBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365902));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365903));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    ThreadManager.post(new jsq(this), 5, null, false);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setMax(100);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.getViewTreeObserver().addOnGlobalLayoutListener(new jsr(this));
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    String str = "";
    Object localObject = "";
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramInt == 1) || (paramInt == 2))
    {
      str = localAVActivity.getString(2131429204);
      localObject = localAVActivity.getString(2131429206);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("BeautySettingUi", 1, "请求相机权限, issueType[" + paramInt + "], msg[" + str + "], title[" + (String)localObject + "]");
      }
      if (i == 0) {
        break;
      }
      return;
      i = 1;
    }
    localObject = DialogUtil.a(localAVActivity, 230).setMessage(str).setTitle((String)localObject).setNegativeButton(2131433029, new jsu(this, localAVActivity));
    if (UITools.a(localAVActivity)) {}
    for (i = 2131429208;; i = 2131429209)
    {
      localObject = ((QQCustomDialog)localObject).setPositiveButton(i, new jst(this, localAVActivity));
      ((QQCustomDialog)localObject).setOnDismissListener(new jsv(this, paramInt));
      ((QQCustomDialog)localObject).show();
      return;
    }
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void c()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, 1);
    if (i != -1) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.remove(i);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentAvVideoController.a().Q = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(117), Integer.valueOf(paramInt) });
    if (this.jdField_c_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X800501E", "0X800501E", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_Int == 0) {
        ReportController.b(null, "CliOper", "", "", "0X800501F", "0X800501F", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
      ReportController.b(null, "CliOper", "", "", "0X8005019", "0X8005019", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_Int == 0) {
        ReportController.b(null, "CliOper", "", "", "0X800501A", "0X800501A", 0, 0, "", "", "", "");
      }
    }
  }
  
  void d() {}
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()).a(paramInt);
  }
  
  void e() {}
  
  void f()
  {
    jss localjss = new jss(this);
    new Handler().post(localjss);
  }
  
  void g()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Int != paramInt)
    {
      d(paramInt);
      a(paramInt);
      if ((paramInt != 0) || (this.jdField_c_of_type_Int <= 0)) {
        break label88;
      }
      this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131429260) + paramInt + "%");
      }
      this.jdField_c_of_type_Int = paramInt;
      return;
      label88:
      if ((paramInt > 0) && (paramInt <= 30) && ((this.jdField_c_of_type_Int <= 0) || (this.jdField_c_of_type_Int > 30))) {
        this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      } else if ((paramInt > 30) && (paramInt <= 60) && ((this.jdField_c_of_type_Int <= 30) || (this.jdField_c_of_type_Int > 60))) {
        this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
      } else if ((paramInt > 60) && (paramInt <= 100) && ((this.jdField_c_of_type_Int <= 60) || (this.jdField_c_of_type_Int > 100))) {
        this.jdField_a_of_type_ComTencentAvWidgetBidirectionSeekBar.setThumb(this.jdField_d_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.BeautySettingUi
 * JD-Core Version:    0.7.0.1
 */