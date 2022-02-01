package com.tencent.av.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class VoiceChangeChooseDialog
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  VoiceChangeAdapter jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter;
  Runnable jdField_a_of_type_JavaLangRunnable;
  boolean jdField_a_of_type_Boolean;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean;
  View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean;
  
  private void c()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ar) {
      i = 2130842382;
    } else {
      i = 2130842381;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter.getCount() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695979);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ad == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695978);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695977);
  }
  
  public void b()
  {
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localVideoController == null)
    {
      AVLog.printErrorLog("VoiceChangeChooseDialog", "updateDialogStyle mVideoController is null!!");
      return;
    }
    boolean bool;
    if ((localVideoController.a().d != 2) && (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4)) {
      bool = false;
    } else {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter.a(-1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(16777216);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-534962398);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter.a(-16777216);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-2147483648);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-2170912);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    }
    c();
  }
  
  public void dismiss()
  {
    super.dismiss();
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if (localContext != null)
    {
      localContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131364449)
    {
      if ((i != 2131370631) && (!this.jdField_c_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = true;
        localObject = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772180);
        ((Animation)localObject).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ar ^= true;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ad != 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController;
        ((VideoController)localObject).c(((VideoController)localObject).a().ar);
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().ar)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695977);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695976);
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_Int = 0;
        }
      }
      c();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().ar)
      {
        TipsUtil.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 1017);
        VoiceChangeDataReport.a("0X8007EF4", "");
      }
      else
      {
        VoiceChangeDataReport.a("0X8007EF3", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    super.show();
    int j = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.startAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772181));
    int i = j;
    if (this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter.getCount() == 0)
    {
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter.a(VoiceChangeData.a().a());
      i = j;
      if (this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter.getCount() != 0) {
        i = 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ad == 0) {
      i = 1;
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter.notifyDataSetChanged();
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog
 * JD-Core Version:    0.7.0.1
 */