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
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mobileqq.app.BusinessObserver;
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
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131372697));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368483));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368484));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368485));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167056));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131368478));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368472));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView = new WaitTextView(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setRefreshListener(this);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setGravity(17);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setTextColor(getResources().getColor(2131167144));
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setTextSize(1, 16.0F);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setPadding(0, 0, 0, AIOUtils.b(50.0F, getResources()));
    Object localObject = new AbsListView.LayoutParams(a(this), -2);
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(3);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetGridView.setVerticalSpacing(this.d * 2);
    this.jdField_a_of_type_AndroidWidgetGridView.setHorizontalSpacing(this.c * 2);
    localObject = this.jdField_a_of_type_AndroidWidgetGridView;
    ((GridView)localObject).setPadding(this.e, ((GridView)localObject).getPaddingTop(), this.e, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692734);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692733);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.hasSendingOrRecving())
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
    this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$GridAdapter.notifyDataSetChanged();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalProcess() * 100.0F));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("(");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getCompletedCount());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal()) {
      i = 2131692748;
    } else {
      i = 2131692707;
    }
    localStringBuilder.append(getString(i));
    localStringBuilder.append((String)localObject);
    localObject = localStringBuilder.toString();
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  private void e()
  {
    setTitle(2131693723);
    this.rightViewImg.setVisibility(4);
    this.rightViewText.setVisibility(4);
  }
  
  private void f()
  {
    Display localDisplay = ((WindowManager)getSystemService("window")).getDefaultDisplay();
    this.e = getResources().getDimensionPixelSize(2131297487);
    this.c = getResources().getDimensionPixelSize(2131297489);
    this.d = getResources().getDimensionPixelSize(2131297490);
    this.jdField_a_of_type_Int = ((localDisplay.getWidth() - this.e * 2 - this.c * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView.setText(String.format(getString(2131693742), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount()) }));
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
    if ((localObject != null) && (((DataLineMsgSet)localObject).isTimeOut()))
    {
      localObject = this.jdField_a_of_type_ComDatalineActivitiesLiteMutiPicViewerActivity$GridAdapter;
      if (localObject != null) {
        ((LiteMutiPicViewerActivity.GridAdapter)localObject).notifyDataSetChanged();
      }
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560772);
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
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    if (this.app.getFileManagerProxy() != null) {
      this.app.getFileManagerProxy().b();
    }
    localObject = this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView;
    if (localObject != null) {
      ((WaitTextView)localObject).b();
    }
  }
  
  public void onClick(View paramView)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    int i = paramView.getId();
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (i != 2131368472)
    {
      if (i == 2131368484) {
        if (NetworkUtil.isNetSupport(this))
        {
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSendFromLocal(), this, new LiteMutiPicViewerActivity.1(this, localDataLineHandler));
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
            DataLineReportUtil.p(this.app);
          }
          Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          localObject2 = null;
          localObject1 = null;
          while (localIterator.hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
            localObject3 = DatalineFilesAdapter.a(localDataLineMsgRecord);
            if (((DLFileInfo)localObject3).jdField_a_of_type_Int == 1)
            {
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject3 = new ArrayList();
              }
              ((ArrayList)localObject3).add(localDataLineMsgRecord);
              localObject2 = localObject3;
            }
            else if ((((DLFileInfo)localObject3).jdField_a_of_type_Int == 4) || (((DLFileInfo)localObject3).jdField_a_of_type_Int == 2))
            {
              if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
                if (DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
                  DataLineReportUtil.d(this.app);
                } else {
                  DataLineReportUtil.e(this.app);
                }
              }
              localObject3 = localObject1;
              if (localObject1 == null) {
                localObject3 = new ArrayList();
              }
              ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
              i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
              localDataLineMsgRecord.fileMsgStatus = 0L;
              this.app.getMessageFacade().a(i).d(localDataLineMsgRecord.msgId);
              localObject1 = localObject3;
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
          FMToastUtil.a(2131694475);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
        DataLineReportUtil.o(this.app);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335) && (!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
        ((DataLineMsgSet)localObject1).isReportPause = true;
        if (!((DataLineMsgSet)localObject1).isSingle()) {
          DataLineReportUtil.m(this.app);
        } else {
          DataLineReportUtil.k(this.app);
        }
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() != -2335))
      {
        localDataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupId(), 0L, false);
      }
      else
      {
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
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteMutiPicViewerActivity
 * JD-Core Version:    0.7.0.1
 */