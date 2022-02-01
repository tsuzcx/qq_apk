package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.os.MqqHandler;

public class LightalkBlueTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private long jdField_a_of_type_Long = 0L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
  private View jdField_a_of_type_AndroidViewView = null;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  private boolean jdField_a_of_type_Boolean = true;
  public String b;
  
  public LightalkBlueTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, BaseSessionInfo paramBaseSessionInfo, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ThreadManager.post(new LightalkBlueTipsBar.1(this), 5, null, true);
  }
  
  public static boolean a()
  {
    return LightalkBlueTipsBarData.a() != null;
  }
  
  public int a()
  {
    return 45;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightalkBlueTipsBar", 2, "getBarView()");
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558555, null);
      paramVarArgs = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370014);
      BitmapDrawable localBitmapDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      Object localObject;
      if (localBitmapDrawable != null)
      {
        paramVarArgs.setImageDrawable(localBitmapDrawable);
      }
      else
      {
        if (new File(LightalkBlueTipsBarData.c).exists()) {
          try
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), BitmapManager.a(LightalkBlueTipsBarData.c));
            if (QLog.isDevelopLevel()) {
              QLog.i("LightalkBlueTipsBar", 4, "load icon to bitmap ");
            }
          }
          catch (Throwable localThrowable)
          {
            if (QLog.isColorLevel()) {
              QLog.e("LightalkBlueTipsBar", 2, "decodeFile Failed!", localThrowable);
            }
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130844833));
            localThrowable.printStackTrace();
          }
        }
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
        if (localObject == null) {
          break label322;
        }
        paramVarArgs.setImageDrawable((Drawable)localObject);
      }
      paramVarArgs = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370017);
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getBarView() mTextWording =");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          QLog.d("LightalkBlueTipsBar", 2, ((StringBuilder)localObject).toString());
        }
        paramVarArgs.setText(this.jdField_a_of_type_JavaLangString);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131706106));
        paramVarArgs.setContentDescription(((StringBuilder)localObject).toString());
        paramVarArgs.setOnClickListener(this);
        paramVarArgs = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370016);
        if (AppSetting.d) {
          paramVarArgs.setContentDescription(HardCodeUtil.a(2131706105));
        }
        paramVarArgs.setOnClickListener(this);
      }
      else
      {
        label322:
        return null;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW");
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject = AIOUtils.a();
    ((StringBuilder)localObject).append("lightalk_tip_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!paramVarArgs.getBoolean(((StringBuilder)localObject).toString(), false)) {
      return;
    }
    localObject = paramVarArgs.getString("Lightalk_tips_frdUin", null);
    if (localObject != null)
    {
      if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LT_tip_show_times");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramInt = paramVarArgs.getInt(((StringBuilder)localObject).toString(), 0);
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("onAIOEvent() : TYPE_ON_SHOW =====> tipsum = ");
        paramVarArgs.append(paramInt);
        QLog.d("LightalkBlueTipsBar", 2, paramVarArgs.toString());
      }
      if (paramInt >= 3)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() instanceof LightalkBlueTipsBar)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]))
      {
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramInt + 1);
        ReportController.b(paramVarArgs, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
        if (this.jdField_a_of_type_Boolean) {
          ThreadManager.getSubThreadHandler().post(new LightalkBlueTipsBar.2(this));
        }
      }
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 12;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131370017: 
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long < 200L) {
        break label201;
      }
      this.jdField_a_of_type_Long = l;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("url", this.b);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005111", "0X8005111", 0, 0, "", "", "", "");
      break;
    case 2131370016: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005110", "0X8005110", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    ThreadManager.getSubThreadHandler().post(new LightalkBlueTipsBar.3(this));
    label201:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar
 * JD-Core Version:    0.7.0.1
 */