package com.tencent.mobileqq.activity;

import adel;
import adem;
import aden;
import aljy;
import alox;
import aloz;
import alpo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import awbv;
import azmj;
import bdee;
import bepp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class MoveToGroupActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public byte a;
  private aden jdField_a_of_type_Aden;
  private alox jdField_a_of_type_Alox = new adel(this);
  private bepp jdField_a_of_type_Bepp;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  public List<awbv> a;
  private boolean jdField_a_of_type_Boolean;
  private byte b;
  
  public MoveToGroupActivity()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  private void a()
  {
    bepp localbepp = new bepp(this);
    this.jdField_a_of_type_Bepp = localbepp;
    localbepp.b(getTitleBarHeight());
    localbepp.show();
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing()))
    {
      this.jdField_a_of_type_Bepp.dismiss();
      this.jdField_a_of_type_Bepp = null;
    }
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.jdField_a_of_type_Byte);
    Groups localGroups = ((aloz)this.app.getManager(51)).a(String.valueOf(this.jdField_a_of_type_Byte));
    if (localGroups == null) {
      localIntent.putExtra("group_name", "");
    }
    for (;;)
    {
      setResult(-1, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "AIO_edit_category_move");
      }
      azmj.b(this.app, "CliOper", "", "", "AIO", "AIO_edit_category_move", 0, 0, "", "", "", "");
      finish();
      return;
      localIntent.putExtra("group_name", localGroups.group_name);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559366);
    setTitle(getString(2131694484));
    paramBundle = (TextView)findViewById(2131368613);
    paramBundle.setContentDescription(alpo.a(2131707284));
    this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("friendUin");
    this.jdField_a_of_type_Boolean = getIntent().getExtras().getBoolean("key_from_babyq_web_plugin", false);
    this.b = getIntent().getExtras().getByte("mgid");
    this.jdField_a_of_type_Byte = this.b;
    this.jdField_a_of_type_JavaUtilList = ((aloz)this.app.getManager(51)).e();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370750));
    this.jdField_a_of_type_Aden = new aden(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aden);
    paramBundle.setOnClickListener(new adem(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Alox);
    b();
    if (this.jdField_a_of_type_Boolean) {
      aljy.a().a();
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
    if (this.jdField_a_of_type_Aden != null) {
      this.jdField_a_of_type_Aden.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true))
    {
      if ((this.jdField_a_of_type_Byte >= 0) && (this.jdField_a_of_type_Byte != this.b))
      {
        if (bdee.d(this))
        {
          paramView = (FriendListHandler)this.app.a(1);
          addObserver(this.jdField_a_of_type_Alox);
          paramView.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Byte, this.b);
          a();
          return;
        }
        QQToast.a(this.app.getApp(), getString(2131694827), 1).b(getTitleBarHeight());
        finish();
        return;
      }
      if (this.jdField_a_of_type_Byte == this.b) {
        QQToast.a(this, getString(2131694482), 0).b(getTitleBarHeight());
      }
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */