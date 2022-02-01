package com.tencent.mobileqq.activity;

import Override;
import aeyt;
import aeyu;
import aeyv;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import antn;
import anyu;
import anyw;
import anzj;
import bdll;
import bhnv;
import bjbs;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.List;

public class MoveToGroupActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public byte a;
  private aeyv jdField_a_of_type_Aeyv;
  private anyu jdField_a_of_type_Anyu = new aeyt(this);
  private bjbs jdField_a_of_type_Bjbs;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  public List<Entity> a;
  private boolean jdField_a_of_type_Boolean;
  private byte b;
  
  public MoveToGroupActivity()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  private void a()
  {
    bjbs localbjbs = new bjbs(this);
    this.jdField_a_of_type_Bjbs = localbjbs;
    localbjbs.b(getTitleBarHeight());
    localbjbs.show();
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing()))
    {
      this.jdField_a_of_type_Bjbs.dismiss();
      this.jdField_a_of_type_Bjbs = null;
    }
  }
  
  private void c()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.jdField_a_of_type_Byte);
    Groups localGroups = ((anyw)this.app.getManager(51)).a(String.valueOf(this.jdField_a_of_type_Byte));
    if (localGroups == null) {
      localIntent.putExtra("group_name", "");
    }
    for (;;)
    {
      setResult(-1, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "AIO_edit_category_move");
      }
      bdll.b(this.app, "CliOper", "", "", "AIO", "AIO_edit_category_move", 0, 0, "", "", "", "");
      finish();
      return;
      localIntent.putExtra("group_name", localGroups.group_name);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559486);
    setTitle(getString(2131693769));
    paramBundle = (TextView)findViewById(2131369042);
    paramBundle.setContentDescription(anzj.a(2131705794));
    this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("friendUin");
    this.jdField_a_of_type_Boolean = getIntent().getExtras().getBoolean("key_from_babyq_web_plugin", false);
    this.b = getIntent().getExtras().getByte("mgid");
    this.jdField_a_of_type_Byte = this.b;
    this.jdField_a_of_type_JavaUtilList = ((anyw)this.app.getManager(51)).e();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131371437));
    this.jdField_a_of_type_Aeyv = new aeyv(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aeyv);
    paramBundle.setOnClickListener(new aeyu(this));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Anyu);
    b();
    if (this.jdField_a_of_type_Boolean) {
      antn.a().a();
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
    if (this.jdField_a_of_type_Aeyv != null) {
      this.jdField_a_of_type_Aeyv.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true)) {
      if ((this.jdField_a_of_type_Byte >= 0) && (this.jdField_a_of_type_Byte != this.b)) {
        if (bhnv.d(this))
        {
          FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
          addObserver(this.jdField_a_of_type_Anyu);
          localFriendListHandler.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Byte, this.b);
          a();
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.app.getApp(), getString(2131694005), 1).b(getTitleBarHeight());
      finish();
      continue;
      if (this.jdField_a_of_type_Byte == this.b) {
        QQToast.a(this, getString(2131693767), 0).b(getTitleBarHeight());
      }
      c();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */