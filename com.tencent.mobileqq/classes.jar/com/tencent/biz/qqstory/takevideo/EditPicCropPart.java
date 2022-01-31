package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropView.CropListener;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.ocr.SearchQuestionCameraFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import obm;

public class EditPicCropPart
  extends EditVideoPart
  implements View.OnClickListener, CropView.CropListener
{
  int jdField_a_of_type_Int = 0;
  public Bitmap a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CropView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView;
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[5];
  public Bitmap b;
  View jdField_b_of_type_AndroidViewView;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean = false;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  boolean jdField_f_of_type_Boolean = false;
  
  public EditPicCropPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
      if (QLog.isColorLevel()) {
        QLog.d("EditPicCropPart", 2, "onBussiRestoreClick , bussiId = " + i + ",hasModified" + paramBoolean);
      }
    } while (i != 105);
    c(paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
  }
  
  private boolean b()
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
    if ((i == 103) || (i == 105))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.f();
      if (i != 105) {
        break label124;
      }
      ReportController.b(null, "dc00898", "", "", "0X80085CF", "0X80085CF", 0, 0, "", "", "", "");
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicCropPart", 2, "onBussiCropClick , bussiId = " + i + ",clickHit = " + bool);
      }
      return bool;
      if (i == 11)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.f();
        bool = true;
        continue;
        label124:
        bool = true;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiCropRectChanged , bussiId = " + i + ",hasModified" + paramBoolean);
    }
    if (i == 105)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a().getDrawable(2130838504));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#BBBBBB"));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a().getDrawable(2130845705));
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
    boolean bool1 = bool2;
    if (i == 105)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicCropPart", 2, "onBussiCropClickIntercept , bussiId = " + i + ",hasCropViewModify = " + this.jdField_f_of_type_Boolean + ",hasClickCropButton = " + this.jdField_e_of_type_Boolean);
      }
      if (this.jdField_f_of_type_Boolean) {
        break label187;
      }
      if (!this.jdField_e_of_type_Boolean)
      {
        obm localobm = new obm(this);
        DialogUtil.b(a(), 230, a().getString(2131439036), a().getString(2131439037), 2131438517, 2131438517, null, localobm).show();
      }
      bool1 = true;
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("EditPicCropPart", 2, "onBussiCropClickIntercept , bussiId = " + i + ",intercepte = " + bool1);
      }
      return bool1;
      label187:
      bool1 = bool2;
      if (this.jdField_f_of_type_Boolean)
      {
        bool1 = bool2;
        if (!NetworkUtil.g(a()))
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439015, 0).a();
          bool1 = true;
        }
      }
    }
  }
  
  private boolean d()
  {
    boolean bool = false;
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
    if ((i == 103) || (i == 105) || (i == 11))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.d();
      if (i == 105) {
        ReportController.b(null, "dc00898", "", "", "0X80085D0", "0X80085D0", 0, 0, "", "", "", "");
      }
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicCropPart", 2, "onBussiBackPressed , bussiId = " + i + ",clickHit = " + bool);
    }
    return bool;
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364332));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView = ((CropView)a(2131364376));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setCropListener(this);
      this.jdField_a_of_type_AndroidViewView = a(2131364374);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = a(2131364375);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364379));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364378));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131364369));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364371));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131364377));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131364370));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131371771));
    }
  }
  
  private void h()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      j();
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void i()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
    if ((localBitmap != null) && (!localBitmap.isRecycled()) && (localBitmap != this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())) {
      localBitmap.recycle();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsBitmap != this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 103)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131439014);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() != 105) {
          break;
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView))
        {
          Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
          ((TextView)localObject).setTextColor(a().getColor(2131494229));
          ((TextView)localObject).setText(a().getString(2131434517));
          ((TextView)localObject).setTextColor(Color.parseColor("#BBBBBB"));
          ((TextView)localObject).setTextSize(1, 14.0F);
          ((TextView)localObject).setBackgroundDrawable(a().getDrawable(2130845705));
          localObject = (ViewGroup.MarginLayoutParams)((TextView)localObject).getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).width = AIOUtils.a(60.0F, a());
          ((ViewGroup.MarginLayoutParams)localObject).height = AIOUtils.a(30.0F, a());
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.getLayoutParams()).topMargin = AIOUtils.a(70.0F, a());
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(a().getString(2131439031));
        this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 20.0F);
        ((ViewGroup.MarginLayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.a(16.0F, a());
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(a().getString(2131439030));
        this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
        ((ViewGroup.MarginLayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.a(6.0F, a());
      } while (Build.VERSION.SDK_INT < 18);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      ((ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.a(16.0F, a());
      return;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() != 11);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2131439293));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(2131439294));
    this.jdField_f_of_type_AndroidWidgetTextView.setText(a(2131439295));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a().getColor(2131494229));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a().getDrawable(2130845696));
    this.jdField_a_of_type_AndroidWidgetTextView.setMinWidth(AIOUtils.a(62.0F, a()));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    TroopReportor.a("Grp_edu", "Grp_oral", "Oral_Photoedit_In", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 105)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.e();
      Intent localIntent = new Intent();
      localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent().getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME"));
      localIntent.addFlags(603979776);
      PublicFragmentActivityForTool.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), localIntent, SearchQuestionCameraFragment.class);
      ReportController.b(null, "dc00898", "", "", "0X80085D3", "0X80085D3", 0, 0, "", "", "", "");
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 7) {
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getResources().getString(2131438705), 0).a();
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    GeneratePicArgs localGeneratePicArgs = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs;
    localGeneratePicArgs.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      VideoEditReport.b("0X80075E9", VideoEditReport.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    e();
    if (paramInt == 11) {
      if (!this.jdField_b_of_type_Boolean) {
        h();
      }
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    i();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.b()) && (paramBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      this.jdField_f_of_type_Boolean = true;
    }
    for (;;)
    {
      c(paramBoolean);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_b_of_type_Boolean)
    {
      if (!d()) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      }
      bool = true;
      VideoEditReport.b("0X80075D5");
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131364376: 
    default: 
    case 2131364374: 
    case 2131364375: 
    case 2131364379: 
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 2);
          }
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 11)) {
            TroopReportor.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Renew", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidViewView.setEnabled(false);
          if (!this.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          }
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 103)) {
            this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
          }
          this.jdField_f_of_type_Boolean = false;
          b(this.jdField_f_of_type_Boolean);
          VideoEditReport.b("0X80075D3");
          return;
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 3);
          }
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 11)) {
            TroopReportor.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Rotate", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a(270);
          VideoEditReport.b("0X80075D4");
          return;
        } while (c());
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 2, 4);
        }
        this.jdField_a_of_type_Int += 1;
        this.jdField_c_of_type_Boolean = true;
      } while (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a());
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(this.jdField_a_of_type_AndroidGraphicsBitmap, false);
      if (!b()) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.u();
      }
      VideoEditReport.b("0X80075D2");
      GeneratePicArgs.a(this.jdField_a_of_type_ArrayOfInt);
      return;
    case 2131364378: 
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 2, 5);
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 11)) {
        TroopReportor.a("Grp_edu", "Grp_oral", "Oral_Photoedit_Rephotograph", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getString("troop_uin", ""), "" });
      }
      a();
      return;
    }
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicCropPart
 * JD-Core Version:    0.7.0.1
 */