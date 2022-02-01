package com.dataline.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
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
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.file.DLFileInfo;
import com.dataline.util.widget.WaitTextView;
import com.dataline.util.widget.WaitTextView.RefreshListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiteMutiPicViewerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, WaitTextView.RefreshListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LiteMutiPicViewerActivity.GridAdapter jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$GridAdapter;
  private WaitTextView jdField_a_of_type_ComDatalineUtilWidgetWaitTextView;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new LiteMutiPicViewerActivity.2(this);
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
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
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131373118));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368751));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368752));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368753));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167033));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131368746));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368740));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView = new WaitTextView(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setRefreshListener(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setGravity(17);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setTextColor(getResources().getColor(2131167119));
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setTextSize(1, 16.0F);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setPadding(0, 0, 0, AIOUtils.a(50.0F, getResources()));
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(a(this), -2);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(3);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetGridView.setVerticalSpacing(this.d * 2);
    this.jdField_a_of_type_AndroidWidgetGridView.setHorizontalSpacing(this.c * 2);
    this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.e, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.e, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$GridAdapter = new LiteMutiPicViewerActivity.GridAdapter(this, null);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$GridAdapter);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692776);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$GridAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692775);
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
    for (int i = 2131692790;; i = 2131692750)
    {
      str = getString(i) + str;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  private void e()
  {
    setTitle(2131693770);
    this.rightViewImg.setVisibility(4);
    this.rightViewText.setVisibility(4);
  }
  
  private void f()
  {
    Display localDisplay = ((WindowManager)getSystemService("window")).getDefaultDisplay();
    this.e = getResources().getDimensionPixelSize(2131297498);
    this.c = getResources().getDimensionPixelSize(2131297500);
    this.d = getResources().getDimensionPixelSize(2131297501);
    this.jdField_a_of_type_Int = ((localDisplay.getWidth() - this.e * 2 - this.c * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setText(String.format(getString(2131693789), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount()) }));
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isTimeOut()) && (this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$GridAdapter != null)) {
      this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$GridAdapter.notifyDataSetChanged();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560898);
    int i = getIntent().getIntExtra("dataline_group_id", -1);
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.getDataLineMsgProxy(0).a(i);
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.getDataLineMsgProxy(1).a(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null)
    {
      QLog.e("IphoneTitleBarActivity", 1, "LiteMutiPicViewerActivity mSet is null, so finish");
      finish();
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    f();
    b();
    e();
    g();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.app.getFileManagerProxy() != null) {
      this.app.getFileManagerProxy().c();
    }
    if (this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView != null) {
      this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    Object localObject2;
    Object localObject3;
    switch (paramView.getId())
    {
    default: 
    case 2131368752: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (NetworkUtil.d(this))
        {
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal(), this, new LiteMutiPicViewerActivity.1(this, localDataLineHandler));
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
            DataLineReportUtil.p(this.app);
          }
          Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          localObject2 = null;
          while (localIterator.hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
            DLFileInfo localDLFileInfo = DatalineFilesAdapter.a(localDataLineMsgRecord);
            if (localDLFileInfo.jdField_a_of_type_Int == 1)
            {
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject3 = new ArrayList();
              }
              ((ArrayList)localObject3).add(localDataLineMsgRecord);
              localObject2 = localObject3;
            }
            else
            {
              if (localDLFileInfo.jdField_a_of_type_Int != 4)
              {
                localObject3 = localObject1;
                if (localDLFileInfo.jdField_a_of_type_Int != 2) {}
              }
              else if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null))
              {
                if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
                  break label334;
                }
                DataLineReportUtil.d(this.app);
              }
              for (;;)
              {
                localObject3 = localObject1;
                if (localObject1 == null) {
                  localObject3 = new ArrayList();
                }
                ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
                int i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
                localDataLineMsgRecord.fileMsgStatus = 0L;
                this.app.getMessageFacade().a(i).d(localDataLineMsgRecord.msgId);
                localObject1 = localObject3;
                break;
                label334:
                DataLineReportUtil.e(this.app);
              }
            }
          }
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
            localDataLineHandler.a((ArrayList)localObject2, true);
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
            localDataLineHandler.a((List)localObject1);
          }
          c();
        }
        else
        {
          FMToastUtil.a(2131694510);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
      DataLineReportUtil.o(this.app);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) {
        DataLineReportUtil.m(this.app);
      }
    }
    else
    {
      label487:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335)) {
        break label541;
      }
      localDataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupId(), 0L, false);
    }
    for (;;)
    {
      c();
      break;
      DataLineReportUtil.k(this.app);
      break label487;
      label541:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DataLineMsgRecord)((Iterator)localObject1).next();
        localObject3 = DatalineFilesAdapter.a((DataLineMsgRecord)localObject2);
        if ((((DLFileInfo)localObject3).jdField_a_of_type_Int == 0) || (((DLFileInfo)localObject3).jdField_a_of_type_Int == 3)) {
          localDataLineHandler.a(((DataLineMsgRecord)localObject2).groupId, ((DataLineMsgRecord)localObject2).sessionid, false);
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteMutiPicViewerActivity
 * JD-Core Version:    0.7.0.1
 */