package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import xpd;
import xpe;
import xpf;
import xpg;
import xph;
import xpi;
import xpj;
import xpk;

public class NewFlowEditVideoActivity
  extends EditVideoActivity
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  private void a(Intent paramIntent)
  {
    boolean bool;
    if (paramIntent != null)
    {
      bool = paramIntent.getBooleanExtra("enable_input_text", true);
      ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_c_of_type_Boolean = bool;
      ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("enable_sync_qzone", false);
      ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("enable_priv_list", true);
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("topic_id"))) {
        ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_b_of_type_Boolean = true;
      }
      ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_b_of_type_Int = paramIntent.getIntExtra("key_font_id", -1);
      ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_d_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
      ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
    }
    for (;;)
    {
      paramIntent = (RelativeLayout)findViewById(2131364381);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2130971118, paramIntent, false));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)AIOUtils.a(2, 50, getResources()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(getResources().getColor(2131493770));
      Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      int i;
      if (bool) {
        i = 0;
      }
      for (;;)
      {
        ((RelativeLayout)localObject).setVisibility(i);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = AIOUtils.a(50.0F, getResources());
        localObject = new View(this);
        ((View)localObject).setBackgroundColor(Color.argb(128, 0, 0, 0));
        ((View)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        ((View)localObject).setVisibility(8);
        paramIntent.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
        i = getIntent().getIntExtra("entry_source", 0);
        if ((i != 3) && (i != 5))
        {
          i = 1;
          if (i != 0)
          {
            this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130971119, paramIntent, false);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(10);
            this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131373356));
            this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new xpd(this));
            this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131373354));
            this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new xpe(this));
            this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("lastLoginUin");
          }
        }
        try
        {
          this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_JavaLangString);
          this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("mIsQzoneVip", false);
          bool = getIntent().getBooleanExtra("TAKE_DANCING_VIDEO", false);
          if ((QzoneSyncQQStoryTool.a(this.jdField_a_of_type_Long, 2)) && (!bool))
          {
            this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131373359));
            this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new xpf(this));
            this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
            this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131373360);
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            if (QzoneSyncQQStoryTool.b(this.jdField_a_of_type_Long))
            {
              this.jdField_c_of_type_AndroidWidgetButton.setSelected(true);
              this.jdField_c_of_type_Boolean = true;
            }
            if (!QzoneSyncQQStoryTool.a(this.jdField_a_of_type_Long)) {
              QzoneSyncQQStoryTool.a(this, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Long);
            }
            ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).a(new xpg(this));
          }
          paramIntent.addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
          paramIntent.addView((View)localObject);
          ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_a_of_type_AndroidViewView = ((View)localObject);
          return;
          i = 8;
          continue;
          i = 0;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.i("NewFlowEditVideoActivity", 2, "parse lastLoginUin error");
          }
        }
      }
      bool = true;
    }
  }
  
  private void b()
  {
    DialogUtil.a(this, 230).setMessage(2131432441).setPositiveButton(2131432398, new xpi(this)).setNegativeButton(2131432754, new xph(this)).show();
  }
  
  private void c()
  {
    DialogUtil.a(this, 230).setMessage(2131432442).setPositiveButton(2131432398, new xpk(this)).setNegativeButton(2131432400, new xpj(this)).show();
  }
  
  private void c(String paramString)
  {
    String str = getResources().getString(2131432793);
    QZoneHelper.a(this, QZoneHelper.UserInfo.a(), paramString, this.jdField_a_of_type_Long, "", 1010, str, false);
  }
  
  protected void a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager = new QzEditVideoPartManager();
      ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_e_of_type_Int = getIntent().getIntExtra("UseQQCameraCompression", 0);
      QzEditVideoPartManager localQzEditVideoPartManager = (QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
      if (getIntent().getIntExtra("entry_source", 0) != 3) {
        bool = true;
      }
      localQzEditVideoPartManager.k = bool;
    }
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager instanceof QzEditVideoPartManager)))
    {
      paramIntent.putExtra("key_content", ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("key_topic_sync_qzone", ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_a_of_type_Boolean);
      paramIntent.putExtra("key_priv", ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_a_of_type_Int);
      paramIntent.putExtra("key_priv_uin_list", ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_a_of_type_JavaUtilArrayList);
      paramIntent.putExtra("key_font_id", ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_b_of_type_Int);
      paramIntent.putExtra("key_font_format_type", ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_c_of_type_Int);
      paramIntent.putExtra("key_font_url", ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_d_of_type_JavaLangString);
      paramIntent.putExtra("key_super_font_id", ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_d_of_type_Int);
      paramIntent.putExtra("key_super_font_info", ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_e_of_type_JavaLangString);
      paramIntent.putExtra("key_generate_gif", ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).j);
      paramIntent.putExtra("key_timer_delete", this.jdField_b_of_type_Boolean);
      paramIntent.putExtra("key_sync_to_qqstory", this.jdField_c_of_type_Boolean);
      QLog.i("NewFlowEditVideoActivity", 2, "NewFlowEditVideoActivity isTimerDelete : " + this.jdField_b_of_type_Boolean + " isyncToQQStory : " + this.jdField_c_of_type_Boolean);
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewFlowEditVideoActivity", 2, "NewFlowEditVideoActivity finish --- resultCode : " + paramInt1);
    }
    super.a(paramInt1, paramIntent, paramInt2, paramInt3);
  }
  
  protected void a(Bundle paramBundle)
  {
    a(getIntent());
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (paramInt2 == -1))
    {
      ToastUtil.a().a("开通成功");
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QzoneGuideBubbleHelper.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowEditVideoActivity
 * JD-Core Version:    0.7.0.1
 */