package com.dataline.activities;

import actj;
import ajum;
import ajut;
import akpf;
import aksy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aper;
import aptx;
import apug;
import bbfj;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.WaitTextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;
import eb;
import ec;
import ed;
import fc;
import fd;
import gu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiteMutiPicViewerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, gu
{
  private int jdField_a_of_type_Int;
  private ajut jdField_a_of_type_Ajut = new ec(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WaitTextView jdField_a_of_type_ComDatalineUtilWidgetWaitTextView;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private ed jdField_a_of_type_Ed;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  private int d;
  private int e;
  
  private int a(Activity paramActivity)
  {
    return paramActivity.getWindowManager().getDefaultDisplay().getWidth();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131371609));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367796));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367797));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367798));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166854));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131367791));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367785));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView = new WaitTextView(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setRefreshListener(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setGravity(17);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setTextColor(getResources().getColor(2131166933));
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setTextSize(1, 16.0F);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setPadding(0, 0, 0, actj.a(50.0F, getResources()));
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(a(this), -2);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(3);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetGridView.setVerticalSpacing(this.d * 2);
    this.jdField_a_of_type_AndroidWidgetGridView.setHorizontalSpacing(this.c * 2);
    this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.e, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.e, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_Ed = new ed(this, null);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Ed);
    c();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isCanReciveOrResend()) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.hasSendingOrRecving()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal()) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692872);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ed.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692871);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.hasSendingOrRecving())
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        d();
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalProcess() * 100.0F));
    String str = "(" + this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getCompletedCount() + "/" + this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount() + ")";
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal()) {}
    for (int i = 2131692886;; i = 2131692847)
    {
      str = getString(i) + str;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  private void e()
  {
    setTitle(2131693909);
    this.rightViewImg.setVisibility(4);
    this.rightViewText.setVisibility(4);
  }
  
  private void f()
  {
    Display localDisplay = ((WindowManager)getSystemService("window")).getDefaultDisplay();
    this.e = getResources().getDimensionPixelSize(2131297280);
    this.c = getResources().getDimensionPixelSize(2131297282);
    this.d = getResources().getDimensionPixelSize(2131297283);
    this.jdField_a_of_type_Int = ((localDisplay.getWidth() - this.e * 2 - this.c * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setText(String.format(getString(2131693928), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount()) }));
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isTimeOut()) && (this.jdField_a_of_type_Ed != null)) {
      this.jdField_a_of_type_Ed.notifyDataSetChanged();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560443);
    int i = getIntent().getIntExtra("dataline_group_id", -1);
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.a(0).a(i);
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.a(1).a(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null)
    {
      QLog.e("IphoneTitleBarActivity", 1, "LiteMutiPicViewerActivity mSet is null, so finish");
      finish();
    }
    addObserver(this.jdField_a_of_type_Ajut);
    f();
    b();
    e();
    g();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ajut != null) {
      removeObserver(this.jdField_a_of_type_Ajut);
    }
    if (this.app.a() != null) {
      this.app.a().e();
    }
    if (this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView != null) {
      this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = null;
    ajum localajum = (ajum)this.app.a(8);
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367797: 
      if (bbfj.d(this))
      {
        apug.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal(), this, new eb(this, localajum));
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
          fc.p(this.app);
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
        localObject1 = null;
        paramView = (View)localObject2;
        while (localIterator.hasNext())
        {
          DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
          DLFileInfo localDLFileInfo = fd.a(localDataLineMsgRecord);
          if (localDLFileInfo.jdField_a_of_type_Int == 1)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localDataLineMsgRecord);
            localObject1 = localObject2;
          }
          else
          {
            if (localDLFileInfo.jdField_a_of_type_Int != 4)
            {
              localObject2 = paramView;
              if (localDLFileInfo.jdField_a_of_type_Int != 2) {}
            }
            else if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null))
            {
              if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
                break label326;
              }
              fc.d(this.app);
            }
            for (;;)
            {
              localObject2 = paramView;
              if (paramView == null) {
                localObject2 = new ArrayList();
              }
              ((List)localObject2).add(Long.valueOf(localDataLineMsgRecord.sessionid));
              int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
              localDataLineMsgRecord.fileMsgStatus = 0L;
              this.app.a().a(i).c(localDataLineMsgRecord.msgId);
              paramView = (View)localObject2;
              break;
              label326:
              fc.e(this.app);
            }
          }
        }
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
          localajum.a((ArrayList)localObject1, true);
        }
        if ((paramView != null) && (paramView.size() > 0)) {
          localajum.a(paramView);
        }
        c();
        return;
      }
      aptx.a(2131694673);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
      fc.o(this.app);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) {
        fc.m(this.app);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335)) {
        break label524;
      }
      localajum.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupId(), 0L, false);
    }
    for (;;)
    {
      c();
      return;
      fc.k(this.app);
      break;
      label524:
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
      while (paramView.hasNext())
      {
        localObject1 = (DataLineMsgRecord)paramView.next();
        localObject2 = fd.a((DataLineMsgRecord)localObject1);
        if ((((DLFileInfo)localObject2).jdField_a_of_type_Int == 0) || (((DLFileInfo)localObject2).jdField_a_of_type_Int == 3)) {
          localajum.a(((DataLineMsgRecord)localObject1).groupId, ((DataLineMsgRecord)localObject1).sessionid, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.LiteMutiPicViewerActivity
 * JD-Core Version:    0.7.0.1
 */