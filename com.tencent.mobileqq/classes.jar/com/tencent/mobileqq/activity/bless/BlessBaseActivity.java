package com.tencent.mobileqq.activity.bless;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;
import wex;

public abstract class BlessBaseActivity
  extends BaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, BusinessObserver
{
  protected int a;
  public long a;
  protected ProgressDialog a;
  protected CheckBox a;
  protected ImageView a;
  protected TextView a;
  protected BlessManager a;
  private MessageObserver a;
  protected String a;
  protected ArrayList a;
  public boolean a;
  private long b;
  protected String b;
  
  public BlessBaseActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new wex(this);
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessBaseActivity", 2, paramString);
    }
    if (paramBoolean) {
      QQToast.a(this, paramInt, 1).a();
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("BlessBaseActivity", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(long paramLong)
  {
    long l = 300L;
    if (paramLong > 300L) {
      paramLong = l;
    }
    for (;;)
    {
      l = paramLong;
      if (paramLong <= 0L) {
        l = 15L;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BlessBaseActivity", 2, "setSendMsgOverloadDuration: " + l);
      }
      this.jdField_b_of_type_Long = l;
      return;
    }
  }
  
  protected abstract void a(boolean paramBoolean);
  
  public void b()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006195", "0X8006195", 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
    finish();
    overridePendingTransition(2131034134, 2131034135);
  }
  
  public abstract void b(boolean paramBoolean);
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("data");
        try
        {
          paramIntent = new JSONObject(paramIntent);
          this.jdField_a_of_type_JavaLangString = paramIntent.getString("token_id");
          this.jdField_b_of_type_JavaLangString = paramIntent.getString("total_amount");
          if (QLog.isColorLevel()) {
            QLog.d("BlessBaseActivity", 2, "doOnActivityResult MASS_BLESS_ORDER token=" + this.jdField_a_of_type_JavaLangString + " amount=" + this.jdField_b_of_type_JavaLangString);
          }
          if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals("")) || (this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.equals("")))
          {
            a("no token or amount", 2131434455, true);
            return;
          }
        }
        catch (Throwable paramIntent)
        {
          paramIntent.printStackTrace();
          a("order result not OK", 2131434455, false);
          return;
        }
        float f = Float.valueOf(this.jdField_b_of_type_JavaLangString).floatValue() / 100.0F;
        paramIntent = String.format(getResources().getString(2131438281), new Object[] { Float.valueOf(f) });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramIntent);
        return;
      }
      a("order result not OK", 2131434455, false);
      return;
    }
    paramIntent = paramIntent.getStringExtra("result");
    for (;;)
    {
      try
      {
        paramInt1 = new JSONObject(paramIntent).getInt("resultCode");
        if (paramInt1 != 0) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        boolean bool = false;
        continue;
        a(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("BlessBaseActivity", 2, "onActivityResult: mPayAction=" + bool);
      }
      if (!bool) {
        continue;
      }
      a(true);
      return;
      bool = false;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager = ((BlessManager)this.app.getManager(137));
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getStringArrayListExtra("uin_list");
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      finish();
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder().append("BlessSendTextActivity doOnCreate uinList=");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label139;
      }
    }
    label139:
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size();; i = 0)
    {
      QLog.d("BlessManager", 2, i);
      this.app.registObserver(this);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.unRegistObserver(this);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void doOnPostCreate(Bundle paramBundle)
  {
    super.doOnPostCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131363405));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363406));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363407));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    findViewById(2131362868).setOnClickListener(this);
    findViewById(2131363374).setOnClickListener(this);
    findViewById(2131363372).setOnClickListener(this);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    b();
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.onTouchEvent(paramMotionEvent)) {
      b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessBaseActivity
 * JD-Core Version:    0.7.0.1
 */