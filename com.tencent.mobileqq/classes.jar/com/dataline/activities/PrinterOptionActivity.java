package com.dataline.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dataline.data.PrinterEntity;
import com.dataline.data.PrinterManager;
import com.dataline.data.PrinterManager.PrinterUpdateObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.MyCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo;

public class PrinterOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public ViewGroup a;
  private TextView b;
  private View c;
  private Button d;
  private TextView e;
  private View f;
  private View g;
  private TextView h;
  private TextView i;
  private LinearLayout j;
  private MyCheckBox k;
  private int l = 1;
  private ArrayList<FileInfo> m;
  private DataLineHandler n = null;
  private boolean o = false;
  private boolean p = true;
  private boolean q = false;
  private boolean r = false;
  private PrinterManager.PrinterUpdateObserver s = new PrinterOptionActivity.1(this);
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = this.n.h.a;
    boolean bool2 = false;
    if (localObject == null)
    {
      bool1 = bool2;
      if (!paramBoolean) {
        break label61;
      }
      localObject = this.n.h.b();
      this.n.h.a = ((PrinterEntity)localObject);
      if (localObject == null)
      {
        bool1 = bool2;
        break label61;
      }
    }
    boolean bool1 = true;
    label61:
    if (bool1)
    {
      String str = this.n.h.a.a;
      this.n.h.d(str);
      localObject = str;
      if (!this.q)
      {
        this.b.setTextColor(-16777216);
        localObject = str;
      }
    }
    else
    {
      localObject = "";
    }
    this.b.setText((CharSequence)localObject);
    return bool1;
  }
  
  private void b(boolean paramBoolean)
  {
    startActivityForResult(new Intent(this, PrinterSubOptionActivity.class), 103);
  }
  
  private boolean b()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    PrinterStatusHandler localPrinterStatusHandler = (PrinterStatusHandler)this.app.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : network error");
      }
      this.h.setText(2131888301);
      this.h.setVisibility(0);
      this.d.setEnabled(false);
      this.c.setEnabled(false);
      return false;
    }
    if (!a(true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : Null printer has been selected");
      }
      this.h.setVisibility(4);
      this.b.setText(2131888317);
      if (!this.q) {
        this.b.setTextColor(Color.parseColor("#808080"));
      }
      this.d.setEnabled(false);
      this.c.setEnabled(true);
      return false;
    }
    if (localRegisterProxySvcPackHandler.d() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : PCQQ is not login");
      }
      this.h.setText(2131888302);
      this.h.setVisibility(0);
      this.d.setEnabled(false);
      return false;
    }
    if (!localPrinterStatusHandler.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : PCQQ is not outdate");
      }
      this.h.setText(2131888300);
      this.h.setVisibility(0);
      this.d.setEnabled(false);
      return false;
    }
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : The file is not support print");
      }
      this.h.setText(2131888305);
      this.h.setVisibility(0);
      this.d.setEnabled(false);
      this.c.setEnabled(true);
      return false;
    }
    if (this.r)
    {
      this.h.setVisibility(0);
      this.h.setText(2131888304);
    }
    else
    {
      this.h.setVisibility(4);
    }
    this.d.setEnabled(true);
    this.c.setEnabled(true);
    return true;
  }
  
  private boolean c()
  {
    PrinterEntity localPrinterEntity = this.n.h.a;
    int i1 = 1;
    int i3 = 1;
    boolean bool;
    if (localPrinterEntity != null)
    {
      Object localObject;
      FileInfo localFileInfo;
      String str;
      if (localPrinterEntity.b == 2)
      {
        localObject = this.m.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localFileInfo = (FileInfo)((Iterator)localObject).next();
          str = localFileInfo.e().toLowerCase();
          i2 = FileManagerUtil.c(str);
          if ((i2 != 9) && (i2 != 0)) {
            this.r = true;
          }
          if (!this.n.h.c(str))
          {
            if (!QLog.isDevelopLevel()) {
              break label518;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("printer unsupport file printer : ");
            ((StringBuilder)localObject).append(localPrinterEntity.a);
            ((StringBuilder)localObject).append(" file : ");
            ((StringBuilder)localObject).append(localFileInfo.e());
            QLog.i("IphoneTitleBarActivity", 1, ((StringBuilder)localObject).toString());
            break label518;
          }
        }
        bool = true;
      }
      else
      {
        if (localPrinterEntity.b == 1)
        {
          if (this.n.e.d() != null)
          {
            localObject = this.m.iterator();
            i1 = 1;
            bool = false;
            i2 = 1;
            while (((Iterator)localObject).hasNext())
            {
              localFileInfo = (FileInfo)((Iterator)localObject).next();
              str = localFileInfo.e().toLowerCase();
              i3 = FileManagerUtil.c(str);
              if ((i3 != 9) && (i3 != 0)) {
                this.r = true;
              }
              Iterator localIterator = this.n.e.f.iterator();
              while (localIterator.hasNext())
              {
                C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo localSupportFileInfo = (C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo)localIterator.next();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append(localSupportFileInfo.str_file_suffix.get());
                if (str.endsWith(localStringBuilder.toString()))
                {
                  if (localSupportFileInfo.uint32_copies.get() == 1) {
                    i3 = 1;
                  } else {
                    i3 = 0;
                  }
                  int i4;
                  if (localSupportFileInfo.uint32_duplex.get() == 1) {
                    i4 = 1;
                  } else {
                    i4 = 0;
                  }
                  i2 = i4 & i2;
                  i1 &= i3;
                  bool = true;
                  break label418;
                }
              }
              bool = false;
              label418:
              if (!bool)
              {
                if (QLog.isDevelopLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("printer unsupport file printer : ");
                  ((StringBuilder)localObject).append(localPrinterEntity.a);
                  ((StringBuilder)localObject).append(" file : ");
                  ((StringBuilder)localObject).append(localFileInfo.e());
                  QLog.i("IphoneTitleBarActivity", 1, ((StringBuilder)localObject).toString());
                }
                break;
              }
            }
          }
          else
          {
            bool = false;
            i2 = 1;
            i1 = i3;
          }
          break label523;
        }
        bool = false;
        i1 = 0;
        i2 = 0;
        break label523;
      }
    }
    else
    {
      label518:
      bool = false;
    }
    int i2 = 1;
    label523:
    if (i1 == 0)
    {
      this.f.setVisibility(8);
      this.g.setVisibility(8);
    }
    if (i2 != 0)
    {
      this.j.setVisibility(0);
      this.i.setVisibility(8);
      return bool;
    }
    this.i.setVisibility(0);
    this.j.setVisibility(8);
    return bool;
  }
  
  void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getString(2131888307));
    ((StringBuilder)localObject).append(this.l);
    localObject = ((StringBuilder)localObject).toString();
    this.e.setText((CharSequence)localObject);
    localObject = this.f;
    int i1 = this.l;
    boolean bool2 = false;
    if (i1 > 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((View)localObject).setEnabled(bool1);
    localObject = this.g;
    boolean bool1 = bool2;
    if (this.l < 99) {
      bool1 = true;
    }
    ((View)localObject).setEnabled(bool1);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 103) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("sPrinterName");
      long l1 = paramIntent.getLongExtra("sPrintDin", 0L);
      if ((str == null) && (l1 == 0L)) {
        this.n.h.a = null;
      }
      if ((b()) && (this.n.h.a != null)) {
        this.n.h.d(this.n.h.a.a);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.n = ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER));
    this.m = super.getIntent().getParcelableArrayListExtra("sFilesSelected");
    this.o = super.getIntent().getBooleanExtra("sIsCloudPrinter", false);
    this.o = getIntent().getBooleanExtra("sIsCloudPrinter", false);
    super.getWindow().setBackgroundDrawableResource(2131165716);
    setContentView(2131624656);
    setTitle(2131888313);
    super.getWindow().setBackgroundDrawable(null);
    this.a = ((ViewGroup)super.findViewById(2131431596));
    this.a.setTag(2131427359, "n/a");
    this.c = super.findViewById(2131440643);
    this.c.setOnClickListener(this);
    this.b = ((TextView)super.findViewById(2131440644));
    this.d = ((Button)super.findViewById(2131427499));
    this.d.setOnClickListener(this);
    this.h = ((TextView)super.findViewById(2131435692));
    this.e = ((TextView)super.findViewById(2131440638));
    this.f = super.findViewById(2131431657);
    this.f.setOnClickListener(this);
    this.g = super.findViewById(2131435665);
    this.g.setOnClickListener(this);
    this.i = ((TextView)super.findViewById(2131440645));
    this.j = ((LinearLayout)super.findViewById(2131440640));
    this.k = ((MyCheckBox)super.findViewById(2131446316));
    this.k.setOnClickListener(this);
    this.k.setOnCheckedChangeListener(new PrinterOptionActivity.2(this));
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      this.q = true;
      this.g.setBackgroundResource(2130842534);
      this.f.setBackgroundResource(2130842533);
      this.d.setBackgroundResource(2130842536);
    }
    this.n.h.a = null;
    this.n.h.a(this.s);
    if (!a(true))
    {
      this.h.setText(2131888317);
      this.h.setVisibility(0);
    }
    this.i.setVisibility(8);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.n.h.c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.a);
    b();
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if (paramView == this.c)
    {
      b(true);
    }
    else if (paramView == this.d)
    {
      if ((!this.p) || (!b())) {
        break label329;
      }
      this.p = false;
      localIntent = new Intent();
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("printCopies", this.l);
      boolean bool = this.k.isChecked();
      if (bool) {
        ((JSONObject)localObject).put("duplexMode", 2);
      } else {
        ((JSONObject)localObject).put("duplexMode", 1);
      }
      ((JSONObject)localObject).put("printerName", this.n.e.a);
      localObject = ((JSONObject)localObject).toString();
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("printer params : ");
        localStringBuilder.append((String)localObject);
        QLog.i("IphoneTitleBarActivity", 1, localStringBuilder.toString());
      }
      localIntent.putExtra("sPrintParam", (String)localObject);
      localIntent.putParcelableArrayListExtra("sFilesSelected", this.m);
      localIntent.putExtra(AlbumConstants.h, super.getIntent().getIntExtra(AlbumConstants.h, 0));
    }
    catch (JSONException localJSONException)
    {
      label222:
      break label222;
    }
    this.p = true;
    setResult(-1, localIntent);
    finish();
    ReportController.b(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
    break label329;
    if (paramView == this.f)
    {
      this.l -= 1;
      this.l = Math.max(1, this.l);
      a();
    }
    else if (paramView == this.g)
    {
      this.l += 1;
      a();
    }
    label329:
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
 * Qualified Name:     com.dataline.activities.PrinterOptionActivity
 * JD-Core Version:    0.7.0.1
 */