package com.dataline.activities;

import Override;
import af;
import ah;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;
import ansr;
import ansy;
import aoxv;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import dr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class DLFilesViewerActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static String a;
  private ansy jdField_a_of_type_Ansy = new ah(this);
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private dr jdField_a_of_type_Dr;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DLFilesViewerActivity";
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
    int i = 1;
    int j = 0;
    DataLineMsgRecord localDataLineMsgRecord;
    DLFileInfo localDLFileInfo;
    if (localIterator.hasNext())
    {
      localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      localDLFileInfo = dr.a(localDataLineMsgRecord);
      if (((localDLFileInfo.a != 0) && (localDLFileInfo.a != 3)) || (j != 0)) {
        break label218;
      }
      j = 1;
    }
    label129:
    label152:
    label215:
    label218:
    for (;;)
    {
      int k;
      if ((localDLFileInfo.a == 5) && (localDataLineMsgRecord.strMoloKey != null))
      {
        ansr localansr = (ansr)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        if (!localDataLineMsgRecord.bIsApkFile) {
          break label152;
        }
        if (localansr.a(localDataLineMsgRecord.strMoloKey))
        {
          k = 1;
          label123:
          localDataLineMsgRecord.nAppStatus = k;
        }
      }
      else
      {
        if ((localDLFileInfo.a == 5) || (i == 0)) {
          break label215;
        }
        i = 0;
      }
      for (;;)
      {
        break;
        k = 0;
        break label123;
        localDataLineMsgRecord.nAppStatus = 1;
        break label129;
        if (i == 0)
        {
          this.rightViewText.setVisibility(0);
          if (j != 0)
          {
            this.rightViewText.setText(getString(2131693584));
            return;
          }
          this.rightViewText.setText(getString(2131693583));
          return;
        }
        this.rightViewText.setVisibility(8);
        return;
      }
    }
  }
  
  private void b()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getFirstItem();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgRecord.bIsApkFile)) {
      setTitle(2131693585);
    }
    for (;;)
    {
      this.leftView.setVisibility(0);
      this.leftView.setText(getString(2131693667));
      a();
      this.rightViewText.setOnClickListener(new af(this));
      return;
      setTitle(2131693609);
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
    int i = getIntent().getIntExtra("dl_files_groupid", 0);
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.getProxyManager().a(0).a(i);
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.getProxyManager().a(1).a(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null)
    {
      finish();
      return false;
    }
    getWindow().setBackgroundDrawableResource(2131165443);
    setContentView(2131559073);
    getWindow().setBackgroundDrawable(null);
    b();
    findViewById(2131366782);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131366781));
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    this.jdField_a_of_type_Dr = new dr(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet, this, this.app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dr);
    paramBundle = LayoutInflater.from(getActivity()).inflate(2131558966, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getActivity().getResources().getDrawable(2130844766));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(paramBundle);
    addObserver(this.jdField_a_of_type_Ansy);
    paramBundle = this.app.getMessageFacade();
    if (paramBundle != null) {
      paramBundle.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount() - 1);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ansy != null) {
      removeObserver(this.jdField_a_of_type_Ansy);
    }
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Dr.notifyDataSetChanged();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof DataLineMsgRecord))
    {
      this.jdField_a_of_type_Dr.notifyDataSetChanged();
      a();
    }
    do
    {
      do
      {
        return;
        if (!(paramObject instanceof QQMessageFacade.Message)) {
          break;
        }
      } while (!((QQMessageFacade.Message)paramObject).frienduin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN)));
      this.jdField_a_of_type_Dr.notifyDataSetChanged();
      a();
      return;
    } while ((!(paramObject instanceof RecentUser)) || (!((RecentUser)paramObject).uin.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))));
    this.jdField_a_of_type_Dr.notifyDataSetChanged();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.DLFilesViewerActivity
 * JD-Core Version:    0.7.0.1
 */