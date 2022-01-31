package com.tencent.mobileqq.activity;

import abnh;
import abni;
import abnj;
import ajsl;
import ajxj;
import ajxl;
import ajya;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import auko;
import axqy;
import bbfj;
import bcqf;
import bcql;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class MoveToGroupActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public byte a;
  private abnj jdField_a_of_type_Abnj;
  private ajxj jdField_a_of_type_Ajxj = new abnh(this);
  private bcqf jdField_a_of_type_Bcqf;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  public List<auko> a;
  private boolean jdField_a_of_type_Boolean;
  private byte b;
  
  public MoveToGroupActivity()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  private void a()
  {
    bcqf localbcqf = new bcqf(this);
    this.jdField_a_of_type_Bcqf = localbcqf;
    localbcqf.b(getTitleBarHeight());
    localbcqf.show();
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing()))
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      this.jdField_a_of_type_Bcqf = null;
    }
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.jdField_a_of_type_Byte);
    Groups localGroups = ((ajxl)this.app.getManager(51)).a(String.valueOf(this.jdField_a_of_type_Byte));
    if (localGroups == null) {
      localIntent.putExtra("group_name", "");
    }
    for (;;)
    {
      setResult(-1, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "AIO_edit_category_move");
      }
      axqy.b(this.app, "CliOper", "", "", "AIO", "AIO_edit_category_move", 0, 0, "", "", "", "");
      finish();
      return;
      localIntent.putExtra("group_name", localGroups.group_name);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559315);
    setTitle(getString(2131694327));
    paramBundle = (TextView)findViewById(2131368429);
    paramBundle.setContentDescription(ajya.a(2131706912));
    this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("friendUin");
    this.jdField_a_of_type_Boolean = getIntent().getExtras().getBoolean("key_from_babyq_web_plugin", false);
    this.b = getIntent().getExtras().getByte("mgid");
    this.jdField_a_of_type_Byte = this.b;
    this.jdField_a_of_type_JavaUtilList = ((ajxl)this.app.getManager(51)).e();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370444));
    this.jdField_a_of_type_Abnj = new abnj(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Abnj);
    paramBundle.setOnClickListener(new abni(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Ajxj);
    b();
    if (this.jdField_a_of_type_Boolean) {
      ajsl.a().a();
    }
  }
  
  public boolean onBackEvent()
  {
    c();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.jdField_a_of_type_Byte = ((byte)((Groups)this.jdField_a_of_type_JavaUtilList.get(i)).group_id);
    if (this.jdField_a_of_type_Abnj != null) {
      this.jdField_a_of_type_Abnj.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true))
    {
      if ((this.jdField_a_of_type_Byte >= 0) && (this.jdField_a_of_type_Byte != this.b))
      {
        if (bbfj.d(this))
        {
          paramView = (FriendListHandler)this.app.a(1);
          addObserver(this.jdField_a_of_type_Ajxj);
          paramView.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Byte, this.b);
          a();
          return;
        }
        bcql.a(this.app.getApp(), getString(2131694671), 1).b(getTitleBarHeight());
        finish();
        return;
      }
      if (this.jdField_a_of_type_Byte == this.b) {
        bcql.a(this, getString(2131694325), 0).b(getTitleBarHeight());
      }
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */