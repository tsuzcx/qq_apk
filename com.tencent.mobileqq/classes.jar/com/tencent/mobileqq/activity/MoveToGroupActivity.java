package com.tencent.mobileqq.activity;

import abdn;
import abdo;
import abdp;
import ajel;
import ajjh;
import ajjj;
import ajjy;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import atmo;
import awqx;
import badq;
import bbms;
import bbmy;
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
  private abdp jdField_a_of_type_Abdp;
  private ajjh jdField_a_of_type_Ajjh = new abdn(this);
  private bbms jdField_a_of_type_Bbms;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  public List<atmo> a;
  private boolean jdField_a_of_type_Boolean;
  private byte b;
  
  public MoveToGroupActivity()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  private void a()
  {
    bbms localbbms = new bbms(this);
    this.jdField_a_of_type_Bbms = localbbms;
    localbbms.b(getTitleBarHeight());
    localbbms.show();
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()))
    {
      this.jdField_a_of_type_Bbms.dismiss();
      this.jdField_a_of_type_Bbms = null;
    }
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.jdField_a_of_type_Byte);
    Groups localGroups = ((ajjj)this.app.getManager(51)).a(String.valueOf(this.jdField_a_of_type_Byte));
    if (localGroups == null) {
      localIntent.putExtra("group_name", "");
    }
    for (;;)
    {
      setResult(-1, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "AIO_edit_category_move");
      }
      awqx.b(this.app, "CliOper", "", "", "AIO", "AIO_edit_category_move", 0, 0, "", "", "", "");
      finish();
      return;
      localIntent.putExtra("group_name", localGroups.group_name);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131493743);
    setTitle(getString(2131628674));
    paramBundle = (TextView)findViewById(2131302804);
    paramBundle.setContentDescription(ajjy.a(2131641116));
    this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("friendUin");
    this.jdField_a_of_type_Boolean = getIntent().getExtras().getBoolean("key_from_babyq_web_plugin", false);
    this.b = getIntent().getExtras().getByte("mgid");
    this.jdField_a_of_type_Byte = this.b;
    this.jdField_a_of_type_JavaUtilList = ((ajjj)this.app.getManager(51)).e();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131304784));
    this.jdField_a_of_type_Abdp = new abdp(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Abdp);
    paramBundle.setOnClickListener(new abdo(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Ajjh);
    b();
    if (this.jdField_a_of_type_Boolean) {
      ajel.a().a();
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
    if (this.jdField_a_of_type_Abdp != null) {
      this.jdField_a_of_type_Abdp.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true))
    {
      if ((this.jdField_a_of_type_Byte >= 0) && (this.jdField_a_of_type_Byte != this.b))
      {
        if (badq.d(this))
        {
          paramView = (FriendListHandler)this.app.a(1);
          addObserver(this.jdField_a_of_type_Ajjh);
          paramView.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Byte, this.b);
          a();
          return;
        }
        bbmy.a(this.app.getApp(), getString(2131629006), 1).b(getTitleBarHeight());
        finish();
        return;
      }
      if (this.jdField_a_of_type_Byte == this.b) {
        bbmy.a(this, getString(2131628672), 0).b(getTitleBarHeight());
      }
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */