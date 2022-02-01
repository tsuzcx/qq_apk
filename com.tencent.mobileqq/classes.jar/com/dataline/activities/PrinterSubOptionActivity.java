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
  XListView a;
  PrinterSubOptionActivity.PrinterItemAdapter b;
  DataLineHandler c = null;
  LayoutInflater d = null;
  String e;
  List<String> f = new ArrayList();
  boolean g = false;
  List<PrinterSubOptionActivity.CloudPrinter> h = new ArrayList();
  private PrinterManager.PrinterUpdateObserver i = new PrinterSubOptionActivity.1(this);
  
  private void a()
  {
    if (this.c.h != null)
    {
      this.h.clear();
      List localList = this.c.h.a();
      int i2 = localList.size();
      int k = 0;
      int m = 0;
      int i1;
      for (int j = 0; k < i2; j = i1)
      {
        PrinterEntity localPrinterEntity = (PrinterEntity)localList.get(k);
        int n;
        if ((localPrinterEntity.b == 1) && (m == 0))
        {
          this.h.add(new PrinterSubOptionActivity.CloudPrinter(this, 1, 0L, "PC绑定的打印机"));
          n = 1;
          i1 = j;
        }
        else
        {
          n = m;
          i1 = j;
          if (localPrinterEntity.b == 2)
          {
            n = m;
            i1 = j;
            if (j == 0)
            {
              this.h.add(new PrinterSubOptionActivity.CloudPrinter(this, 1, 0L, "QQ物联打印机"));
              i1 = 1;
              n = m;
            }
          }
        }
        this.h.add(new PrinterSubOptionActivity.CloudPrinter(this, 2, localPrinterEntity.c, localPrinterEntity.a));
        k += 1;
        m = n;
      }
      this.b.notifyDataSetChanged();
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
    this.d = LayoutInflater.from(this);
    this.c = ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER));
    this.c.e.c = null;
    getWindow().setBackgroundDrawableResource(2131165716);
    setContentView(2131624657);
    setTitle(2131888323);
    getWindow().setBackgroundDrawable(null);
    this.b = new PrinterSubOptionActivity.PrinterItemAdapter(this);
    this.a = ((XListView)findViewById(2131440641));
    this.a.setTag(2131427359, "n/a");
    this.a.setAdapter(this.b);
    if (!this.c.h.d())
    {
      paramBundle = findViewById(2131432510);
      paramBundle.setVisibility(0);
      paramBundle.setContentDescription(HardCodeUtil.a(2131906201));
      ((TextView)findViewById(2131447754)).setText(getString(2131888315));
      ((TextView)findViewById(2131429712)).setText(getString(2131888314));
      this.a.setVisibility(8);
    }
    else
    {
      a();
      this.c.h.a(this.i);
    }
    setLeftViewName(2131887625);
    this.a.setTag(2131427359, "n/a");
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.c.h.c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.e = getString(2131888316);
    this.h.clear();
    a();
    PrinterStatusHandler localPrinterStatusHandler = (PrinterStatusHandler)this.app.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER);
    this.g = localPrinterStatusHandler.a();
    localPrinterStatusHandler.b();
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