package com.dataline.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.dataline.data.PrinterEntity;
import com.dataline.data.PrinterManager;
import com.dataline.data.PrinterManager.PrinterUpdateObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class PrinterSubOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  PrinterSubOptionActivity.PrinterItemAdapter jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter;
  private PrinterManager.PrinterUpdateObserver jdField_a_of_type_ComDatalineDataPrinterManager$PrinterUpdateObserver = new PrinterSubOptionActivity.1(this);
  DataLineHandler jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  List<PrinterSubOptionActivity.CloudPrinter> b = new ArrayList();
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager != null)
    {
      this.b.clear();
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a();
      int i1 = localList.size();
      int j = 0;
      int k = 0;
      int n;
      for (int i = 0; j < i1; i = n)
      {
        PrinterEntity localPrinterEntity = (PrinterEntity)localList.get(j);
        int m;
        if ((localPrinterEntity.jdField_a_of_type_Int == 1) && (k == 0))
        {
          this.b.add(new PrinterSubOptionActivity.CloudPrinter(this, 1, 0L, "PC绑定的打印机"));
          m = 1;
          n = i;
        }
        else
        {
          m = k;
          n = i;
          if (localPrinterEntity.jdField_a_of_type_Int == 2)
          {
            m = k;
            n = i;
            if (i == 0)
            {
              this.b.add(new PrinterSubOptionActivity.CloudPrinter(this, 1, 0L, "QQ物联打印机"));
              n = 1;
              m = k;
            }
          }
        }
        this.b.add(new PrinterSubOptionActivity.CloudPrinter(this, 2, localPrinterEntity.jdField_a_of_type_Long, localPrinterEntity.jdField_a_of_type_JavaLangString));
        j += 1;
        k = m;
      }
      this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter.notifyDataSetChanged();
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
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_JavaUtilList = null;
    getWindow().setBackgroundDrawableResource(2131165419);
    setContentView(2131559023);
    setTitle(2131691368);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter = new PrinterSubOptionActivity.PrinterItemAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131373058));
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131361813, "n/a");
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a())
    {
      paramBundle = findViewById(2131366222);
      paramBundle.setVisibility(0);
      paramBundle.setContentDescription(HardCodeUtil.a(2131708415));
      ((TextView)findViewById(2131379031)).setText(getString(2131691360));
      ((TextView)findViewById(2131363780)).setText(getString(2131691359));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    else
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a(this.jdField_a_of_type_ComDatalineDataPrinterManager$PrinterUpdateObserver);
    }
    setLeftViewName(2131690706);
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131361813, "n/a");
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_JavaLangString = getString(2131691361);
    this.b.clear();
    a();
    PrinterStatusHandler localPrinterStatusHandler = (PrinterStatusHandler)this.app.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER);
    this.jdField_a_of_type_Boolean = localPrinterStatusHandler.a();
    localPrinterStatusHandler.a();
  }
  
  protected boolean onBackEvent()
  {
    setResult(-1, new Intent());
    finish();
    return true;
  }
  
  public void onClick(View paramView) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity
 * JD-Core Version:    0.7.0.1
 */