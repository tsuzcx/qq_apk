package com.tencent.mobileqq.arcard;

import aart;
import aaru;
import aarv;
import aarw;
import aarx;
import aary;
import aarz;
import aasc;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.arcard.ARWordingBless.RubberStamp;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ARBlessWordFragment
  extends Fragment
  implements View.OnClickListener
{
  private volatile int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ARCardLoadingProgressView jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView;
  ARRelationShipFileUpload jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload;
  private RubberStamp jdField_a_of_type_ComTencentMobileqqArcardARWordingBlessRubberStamp;
  private OnCameraVideoRecordListener jdField_a_of_type_ComTencentMobileqqArcardOnCameraVideoRecordListener;
  final Runnable jdField_a_of_type_JavaLangRunnable = new aart(this);
  private String jdField_a_of_type_JavaLangString = "";
  public boolean a;
  long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private String jdField_d_of_type_JavaLangString = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  
  public ARBlessWordFragment()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    localTextPaint.setTypeface(this.jdField_a_of_type_AndroidWidgetEditText.getTypeface());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams();
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() == 0) {}
    for (Object localObject = "新年快乐";; localObject = "新年快乐啊")
    {
      localLayoutParams.width = ((int)localTextPaint.measureText((String)localObject) + this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft() + this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight() + 4);
      localObject = localTextPaint.getFontMetrics();
      localLayoutParams.height = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).ascent) * paramInt + this.jdField_a_of_type_AndroidWidgetEditText.getPaddingTop() + this.jdField_a_of_type_AndroidWidgetEditText.getPaddingBottom() + 4);
      localLayoutParams.addRule(14);
      this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  private void a(boolean paramBoolean, Runnable paramRunnable)
  {
    System.currentTimeMillis();
    Object localObject = (ARCardCameraRecordActivity)getActivity();
    this.jdField_b_of_type_Boolean = true;
    if (!this.jdField_a_of_type_AndroidViewView.isDrawingCacheEnabled()) {}
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(true);
      }
      this.jdField_a_of_type_AndroidViewView.buildDrawingCache();
      localObject = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
      this.jdField_b_of_type_AndroidOsHandler.post(new aasc(this, (Bitmap)localObject, paramRunnable));
      return;
    }
  }
  
  private void c()
  {
    DialogUtil.b(getActivity(), 233, null, "AR贺卡发送失败，请重新发送。", 2131433029, 2131433045, new aarx(this), new aary(this)).show();
  }
  
  private void d()
  {
    if (!NetworkUtil.g(getActivity().getApplicationContext())) {
      QQToast.a(getActivity(), 2131437550, 1).a();
    }
    do
    {
      return;
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        this.jdField_b_of_type_Long = ((File)localObject).length();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload == null);
    this.jdField_a_of_type_Long = 0L;
    Object localObject = new ARRelationShipFileUpload.ARRelationShipReqInfo();
    ((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject).jdField_a_of_type_Int = 1;
    ((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload.a();
    ((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload.a((ARRelationShipFileUpload.ARRelationShipReqInfo)localObject, new aarz(this));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload != null) {
      this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload.a();
    }
    b();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView == null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.width = AIOUtils.a(225.0F, getActivity().getResources());
      localLayoutParams.height = AIOUtils.a(400.0F, getActivity().getResources());
      localLayoutParams.setMargins(0, AIOUtils.a(8.0F, getActivity().getResources()), 0, 0);
      localLayoutParams.addRule(14);
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView = new ARCardLoadingProgressView(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView.setBackgroundColor(637534208);
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView.setScale(ScreenUtil.jdField_a_of_type_Int);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView, localLayoutParams);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    int j = (int)(this.jdField_a_of_type_Long * 100L / this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView.setTotalProgress(j);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(OnCameraVideoRecordListener paramOnCameraVideoRecordListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArcardOnCameraVideoRecordListener = paramOnCameraVideoRecordListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.e = paramString4;
    this.f = paramString5.replace("\\n", "\n");
    this.g = paramString6;
    this.h = paramString7;
    this.i = paramString8;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView != null)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView);
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardLoadingProgressView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131363516) && (paramView.getId() != 2131369547))
    {
      ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      this.jdField_a_of_type_AndroidViewView.requestFocus();
    }
    if (paramView.getId() == 2131369545)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
      }
    }
    else
    {
      if (paramView.getId() != 2131369549) {
        break label155;
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label133;
      }
      ARRecordUtils.a("正在合成贺卡图片，请稍后再试", false);
    }
    label133:
    label155:
    while (paramView.getId() != 2131369535)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      break;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      a();
      a(false, this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ARBlessWordFragment", 2, "onCreate  this=");
    }
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARBlessWordFragment", 2, "onCreateView");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.inflate(2130970218, null));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369542));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362772));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369544));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369548));
    try
    {
      paramLayoutInflater = new BitmapFactory.Options();
      paramLayoutInflater.inJustDecodeBounds = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeFile(ARResouceDir.c() + "arcard_textbg.png", paramLayoutInflater));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeFile(ARResouceDir.c() + "arcard_videorecord_bg.png", paramLayoutInflater));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369543);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369547));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369232));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369545));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aaru(this));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369546));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363516));
      this.jdField_a_of_type_AndroidWidgetEditText.setHorizontallyScrolling(false);
      paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
      paramLayoutInflater.setTypeface(this.jdField_a_of_type_AndroidWidgetEditText.getTypeface());
      int m = (int)paramLayoutInflater.measureText("新年快乐") + 4;
      int i1 = (int)paramLayoutInflater.measureText("i");
      int n = (int)paramLayoutInflater.measureText(this.f);
      int k = n / m;
      int j = k;
      if (n % m > i1) {
        j = k + 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARBlessWordFragment", 2, "mEditText onCreateView  lineWidth=" + m + " allWidth=" + n + " lineCount=" + j);
      }
      a(j);
      this.jdField_a_of_type_AndroidWidgetEditText.setMaxEms(5);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.f);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aarv(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new aarw(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369549));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369535));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqArcardARWordingBlessRubberStamp = new RubberStamp(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload = new ARRelationShipFileUpload(getActivity().getAppInterface());
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    catch (OutOfMemoryError paramLayoutInflater)
    {
      for (;;)
      {
        paramLayoutInflater.printStackTrace();
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("ARBlessWordFragment", 1, "onDestroy start.");
    e();
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("ARBlessWordFragment", 1, "onPause start.");
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("ARBlessWordFragment", 1, "onResume start.");
    super.onResume();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARBlessWordFragment
 * JD-Core Version:    0.7.0.1
 */