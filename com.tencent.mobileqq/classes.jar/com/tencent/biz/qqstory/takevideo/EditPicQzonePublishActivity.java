package com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.qqonly.QzEditPicPartManager;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.QzoneSyncQQStoryTool;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import mqq.app.AppRuntime;
import obo;
import obp;
import obq;
import obr;

public class EditPicQzonePublishActivity
  extends EditPicActivity
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean;
  
  private long a()
  {
    try
    {
      if (getAppRuntime() != null)
      {
        long l = Long.parseLong(getAppRuntime().getAccount());
        return l;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.i("EditPicQzonePublishActivity", 2, "parse lastLoginUin error");
    }
    return 0L;
  }
  
  private void a()
  {
    long l = a();
    if (QzoneSyncQQStoryTool.a(l, 1))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131365513);
      View localView1 = LayoutInflater.from(this).inflate(2130971120, localRelativeLayout, false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = ViewUtils.a(12.0F);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(0, 2131365514);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView1.findViewById(2131373359));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new obp(this, l));
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      View localView2 = localView1.findViewById(2131373360);
      localView2.setVisibility(0);
      localRelativeLayout.addView(localView1, localLayoutParams);
      if (QzoneSyncQQStoryTool.b(l))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setSelected(true);
        this.jdField_b_of_type_Boolean = true;
      }
      if (!QzoneSyncQQStoryTool.a(l)) {
        QzoneSyncQQStoryTool.a(this, localView2, l);
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    paramIntent = (RelativeLayout)findViewById(2131365513);
    this.jdField_a_of_type_AndroidViewView = ((LinearLayout)findViewById(2131365514));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131373354));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new obo(this));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2130971118, paramIntent, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)AIOUtils.a(2, 50, getResources()));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131493770));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = AIOUtils.a(50.0F, getResources());
    View localView = new View(this);
    localView.setBackgroundColor(Color.argb(128, 0, 0, 0));
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localView.setVisibility(8);
    paramIntent.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
    paramIntent.addView(localView);
    a();
    ((QzEditPicPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_a_of_type_AndroidViewView = localView;
  }
  
  private void b()
  {
    DialogUtil.a(this, 230).setMessage(2131432442).setPositiveButton(2131432398, new obr(this)).setNegativeButton(2131432400, new obq(this)).show();
  }
  
  public Intent a(GenerateContext paramGenerateContext)
  {
    return super.a(paramGenerateContext);
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager instanceof QzEditPicPartManager)))
    {
      paramIntent.putExtra("key_content", ((QzEditPicPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("key_priv", ((QzEditPicPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_a_of_type_Int);
      paramIntent.putExtra("key_priv_uin_list", ((QzEditPicPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_a_of_type_JavaUtilArrayList);
      paramIntent.putExtra("key_font_id", ((QzEditPicPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).b);
      paramIntent.putExtra("key_font_format_type", ((QzEditPicPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_c_of_type_Int);
      paramIntent.putExtra("key_font_url", ((QzEditPicPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_d_of_type_JavaLangString);
      paramIntent.putExtra("key_super_font_id", ((QzEditPicPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_d_of_type_Int);
      paramIntent.putExtra("key_super_font_info", ((QzEditPicPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).e);
      paramIntent.putExtra("key_timer_delete", this.jdField_a_of_type_Boolean);
      paramIntent.putExtra("key_sync_to_qqstory", this.jdField_b_of_type_Boolean);
      QLog.i("EditPicQzonePublishActivity", 2, "EditPic mSetTimerDelete: " + this.jdField_a_of_type_Boolean + " isyncToQQStory : " + this.jdField_b_of_type_Boolean);
    }
    if (QLog.isColorLevel()) {
      QLog.i("EditPicQzonePublishActivity", 2, "EditPicQzonePublishActivity finish --- resultCode : " + paramInt1);
    }
    super.a(paramInt1, paramIntent, paramInt2, paramInt3);
  }
  
  protected void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager = new QzEditPicPartManager();
    ((QzEditPicPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).f = QzoneSyncQQStoryTool.a(a(), 1);
    a(getIntent());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QzoneGuideBubbleHelper.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicQzonePublishActivity
 * JD-Core Version:    0.7.0.1
 */