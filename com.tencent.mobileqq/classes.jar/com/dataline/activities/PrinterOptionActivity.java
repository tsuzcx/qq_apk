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
  private int jdField_a_of_type_Int = 1;
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PrinterManager.PrinterUpdateObserver jdField_a_of_type_ComDatalineDataPrinterManager$PrinterUpdateObserver = new PrinterOptionActivity.1(this);
  private DataLineHandler jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = null;
  private MyCheckBox jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox;
  private ArrayList<FileInfo> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  
  private void a(boolean paramBoolean)
  {
    startActivityForResult(new Intent(this, PrinterSubOptionActivity.class), 103);
  }
  
  private boolean a()
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    PrinterStatusHandler localPrinterStatusHandler = (PrinterStatusHandler)this.app.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : network error");
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691346);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      return false;
    }
    if (!a(true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : Null printer has been selected");
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691362);
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#808080"));
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      return false;
    }
    if (localRegisterProxySvcPackHandler.a() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : PCQQ is not login");
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691347);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return false;
    }
    if (!localPrinterStatusHandler.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : PCQQ is not outdate");
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691345);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return false;
    }
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : The file is not support print");
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691350);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      return false;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691349);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a;
    boolean bool2 = false;
    if (localObject == null)
    {
      bool1 = bool2;
      if (!paramBoolean) {
        break label61;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a();
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a = ((PrinterEntity)localObject);
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
      String str = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a(str);
      localObject = str;
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        localObject = str;
      }
    }
    else
    {
      localObject = "";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    return bool1;
  }
  
  private boolean b()
  {
    PrinterEntity localPrinterEntity = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a;
    int i = 1;
    int k = 1;
    boolean bool;
    if (localPrinterEntity != null)
    {
      Object localObject;
      FileInfo localFileInfo;
      String str;
      if (localPrinterEntity.jdField_a_of_type_Int == 2)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localFileInfo = (FileInfo)((Iterator)localObject).next();
          str = localFileInfo.d().toLowerCase();
          j = FileManagerUtil.a(str);
          if ((j != 9) && (j != 0)) {
            this.jdField_d_of_type_Boolean = true;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a(str))
          {
            if (!QLog.isDevelopLevel()) {
              break label514;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("printer unsupport file printer : ");
            ((StringBuilder)localObject).append(localPrinterEntity.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject).append(" file : ");
            ((StringBuilder)localObject).append(localFileInfo.d());
            QLog.i("IphoneTitleBarActivity", 1, ((StringBuilder)localObject).toString());
            break label514;
          }
        }
        bool = true;
      }
      else
      {
        if (localPrinterEntity.jdField_a_of_type_Int == 1)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a() != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            i = 1;
            bool = false;
            j = 1;
            while (((Iterator)localObject).hasNext())
            {
              localFileInfo = (FileInfo)((Iterator)localObject).next();
              str = localFileInfo.d().toLowerCase();
              k = FileManagerUtil.a(str);
              if ((k != 9) && (k != 0)) {
                this.jdField_d_of_type_Boolean = true;
              }
              Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.b.iterator();
              while (localIterator.hasNext())
              {
                C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo localSupportFileInfo = (C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo)localIterator.next();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(".");
                localStringBuilder.append(localSupportFileInfo.str_file_suffix.get());
                if (str.endsWith(localStringBuilder.toString()))
                {
                  if (localSupportFileInfo.uint32_copies.get() == 1) {
                    k = 1;
                  } else {
                    k = 0;
                  }
                  int m;
                  if (localSupportFileInfo.uint32_duplex.get() == 1) {
                    m = 1;
                  } else {
                    m = 0;
                  }
                  j = m & j;
                  i &= k;
                  bool = true;
                  break label416;
                }
              }
              bool = false;
              label416:
              if (!bool)
              {
                if (QLog.isDevelopLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("printer unsupport file printer : ");
                  ((StringBuilder)localObject).append(localPrinterEntity.jdField_a_of_type_JavaLangString);
                  ((StringBuilder)localObject).append(" file : ");
                  ((StringBuilder)localObject).append(localFileInfo.d());
                  QLog.i("IphoneTitleBarActivity", 1, ((StringBuilder)localObject).toString());
                }
                break;
              }
            }
          }
          else
          {
            bool = false;
            j = 1;
            i = k;
          }
          break label519;
        }
        bool = false;
        i = 0;
        j = 0;
        break label519;
      }
    }
    else
    {
      label514:
      bool = false;
    }
    int j = 1;
    label519:
    if (i == 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (j != 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return bool;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    return bool;
  }
  
  void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getString(2131691352));
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = this.jdField_b_of_type_AndroidViewView;
    int i = this.jdField_a_of_type_Int;
    boolean bool2 = false;
    if (i > 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((View)localObject).setEnabled(bool1);
    localObject = this.jdField_c_of_type_AndroidViewView;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Int < 99) {
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
      long l = paramIntent.getLongExtra("sPrintDin", 0L);
      if ((str == null) && (l == 0L)) {
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a = null;
      }
      if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = ((DataLineHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER));
    this.jdField_a_of_type_JavaUtilArrayList = super.getIntent().getParcelableArrayListExtra("sFilesSelected");
    this.jdField_a_of_type_Boolean = super.getIntent().getBooleanExtra("sIsCloudPrinter", false);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("sIsCloudPrinter", false);
    super.getWindow().setBackgroundDrawableResource(2131165419);
    setContentView(2131559022);
    setTitle(2131691358);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131365396));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131361813, "n/a");
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131373060);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373061));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131361945));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368773));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373055));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131365451);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131368750);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373062));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131373057));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox = ((MyCheckBox)super.findViewById(2131377843));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.setOnCheckedChangeListener(new PrinterOptionActivity.2(this));
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130841631);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130841630);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130841633);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a = null;
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a(this.jdField_a_of_type_ComDatalineDataPrinterManager$PrinterUpdateObserver);
    if (!a(true))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691362);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComDatalineDataPrinterManager.a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
    a();
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      a(true);
    }
    else if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if ((!this.jdField_b_of_type_Boolean) || (!a())) {
        break label328;
      }
      this.jdField_b_of_type_Boolean = false;
      localIntent = new Intent();
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("printCopies", this.jdField_a_of_type_Int);
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.isChecked();
      if (bool) {
        ((JSONObject)localObject).put("duplexMode", 2);
      } else {
        ((JSONObject)localObject).put("duplexMode", 1);
      }
      ((JSONObject)localObject).put("printerName", this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("printer params : ");
        localStringBuilder.append((String)localObject);
        QLog.i("IphoneTitleBarActivity", 1, localStringBuilder.toString());
      }
      localIntent.putExtra("sPrintParam", (String)localObject);
      localIntent.putParcelableArrayListExtra("sFilesSelected", this.jdField_a_of_type_JavaUtilArrayList);
      localIntent.putExtra(AlbumConstants.h, super.getIntent().getIntExtra(AlbumConstants.h, 0));
    }
    catch (JSONException localJSONException)
    {
      label221:
      break label221;
    }
    this.jdField_b_of_type_Boolean = true;
    setResult(-1, localIntent);
    finish();
    ReportController.b(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
    break label328;
    if (paramView == this.jdField_b_of_type_AndroidViewView)
    {
      this.jdField_a_of_type_Int -= 1;
      this.jdField_a_of_type_Int = Math.max(1, this.jdField_a_of_type_Int);
      a();
    }
    else if (paramView == this.jdField_c_of_type_AndroidViewView)
    {
      this.jdField_a_of_type_Int += 1;
      a();
    }
    label328:
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