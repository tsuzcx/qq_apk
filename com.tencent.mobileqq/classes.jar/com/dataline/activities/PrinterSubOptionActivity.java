package com.dataline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import co;
import com.dataline.data.PrinterEntity;
import com.dataline.data.PrinterManager;
import com.dataline.data.PrinterManager.PrinterUpdateObserver;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import cp;
import java.util.ArrayList;
import java.util.List;

public class PrinterSubOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  PrinterSubOptionActivity.PrinterItemAdapter jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter;
  private PrinterManager.PrinterUpdateObserver jdField_a_of_type_ComDatalineDataPrinterManager$PrinterUpdateObserver = new co(this);
  public DataLineHandler a;
  public XListView a;
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public List b = new ArrayList();
  
  public PrinterSubOptionActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager != null)
    {
      int j = 0;
      int k = 0;
      this.b.clear();
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a();
      int i1 = localList.size();
      int i = 0;
      if (i < i1)
      {
        PrinterEntity localPrinterEntity = (PrinterEntity)localList.get(i);
        int n;
        int m;
        if ((localPrinterEntity.jdField_a_of_type_Int == 1) && (j == 0))
        {
          this.b.add(new cp(this, 1, 0L, "PC绑定的打印机"));
          n = 1;
          m = k;
        }
        for (;;)
        {
          this.b.add(new cp(this, 2, localPrinterEntity.jdField_a_of_type_Long, localPrinterEntity.jdField_a_of_type_JavaLangString));
          i += 1;
          k = m;
          j = n;
          break;
          m = k;
          n = j;
          if (localPrinterEntity.jdField_a_of_type_Int == 2)
          {
            m = k;
            n = j;
            if (k == 0)
            {
              this.b.add(new cp(this, 1, 0L, "QQ物联打印机"));
              m = 1;
              n = j;
            }
          }
        }
      }
      this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter.notifyDataSetChanged();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = ((DataLineHandler)this.app.a(8));
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_JavaUtilList = null;
    getWindow().setBackgroundDrawableResource(2131492895);
    setContentView(2130968887);
    setTitle(2131427675);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter = new PrinterSubOptionActivity.PrinterItemAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131364166));
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131362036, "n/a");
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a())
    {
      paramBundle = findViewById(2131364167);
      paramBundle.setVisibility(0);
      paramBundle.setContentDescription("请先在电脑端登录QQ，文件会传到电脑打印机打印。");
      ((TextView)findViewById(2131364168)).setText(getString(2131427684));
      ((TextView)findViewById(2131364169)).setText(getString(2131427685));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      setLeftViewName(2131433698);
      this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131362036, "n/a");
      return true;
      a();
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a(this.jdField_a_of_type_ComDatalineDataPrinterManager$PrinterUpdateObserver);
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_JavaLangString = getString(2131427692);
    this.b.clear();
    a();
    PrinterStatusHandler localPrinterStatusHandler = (PrinterStatusHandler)this.app.a(74);
    this.jdField_a_of_type_Boolean = localPrinterStatusHandler.a();
    localPrinterStatusHandler.b();
  }
  
  protected boolean onBackEvent()
  {
    setResult(-1, new Intent());
    finish();
    return true;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity
 * JD-Core Version:    0.7.0.1
 */