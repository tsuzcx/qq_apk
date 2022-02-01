package com.dataline.activities;

import Override;
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
import anjx;
import anrd;
import anrg;
import antz;
import atvo;
import bcst;
import bgkb;
import bgnt;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.MyCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cw;
import cx;
import dj;
import dk;
import dn;
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
  private anjx jdField_a_of_type_Anjx;
  private MyCheckBox jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox;
  private dn jdField_a_of_type_Dn = new cw(this);
  private ArrayList<FileInfo> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  
  private void a(boolean paramBoolean)
  {
    startActivityForResult(new Intent(this, PrinterSubOptionActivity.class), 103);
  }
  
  private boolean a()
  {
    antz localantz = (antz)this.app.a(10);
    anrg localanrg = (anrg)this.app.a(74);
    if (!bgnt.d(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : network error");
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691187);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    }
    for (;;)
    {
      return false;
      if (!a(true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrinterOptionActivity", 4, "UpdateStatus : Null printer has been selected");
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691203);
        if (!this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#808080"));
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      }
      else if (localantz.a() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrinterOptionActivity", 4, "UpdateStatus : PCQQ is not login");
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691188);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      else if (!localanrg.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrinterOptionActivity", 4, "UpdateStatus : PCQQ is not outdate");
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691186);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      else
      {
        if (b()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PrinterOptionActivity", 4, "UpdateStatus : The file is not support print");
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691191);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      }
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691190);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      return true;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    if (this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a == null)
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        localObject = this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a();
        this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a = ((dj)localObject);
        if (localObject != null) {
          break label122;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      localObject = "";
      if (bool1)
      {
        String str = this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a(str);
        localObject = str;
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          localObject = str;
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return bool1;
      label122:
      bool1 = true;
      continue;
      bool1 = true;
    }
  }
  
  private boolean b()
  {
    int i = 1;
    dj localdj = this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a;
    Iterator localIterator1;
    FileInfo localFileInfo;
    String str;
    int j;
    boolean bool1;
    int k;
    if (localdj != null) {
      if (localdj.jdField_a_of_type_Int == 2)
      {
        localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator1.hasNext())
        {
          localFileInfo = (FileInfo)localIterator1.next();
          str = localFileInfo.d().toLowerCase();
          j = atvo.a(str);
          if ((j != 9) && (j != 0)) {
            this.jdField_d_of_type_Boolean = true;
          }
          if (!this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("IphoneTitleBarActivity", 1, "printer unsupport file printer : " + localdj.jdField_a_of_type_JavaLangString + " file : " + localFileInfo.d());
            }
            bool1 = false;
            k = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      label242:
      label383:
      int m;
      label398:
      label413:
      boolean bool2;
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        return bool1;
        if (localdj.jdField_a_of_type_Int == 1)
        {
          if (this.jdField_a_of_type_Anjx.jdField_a_of_type_Anrd.a() == null) {
            break label562;
          }
          localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          j = 1;
          i = 1;
          bool1 = false;
          if (!localIterator1.hasNext()) {
            break label553;
          }
          localFileInfo = (FileInfo)localIterator1.next();
          str = localFileInfo.d().toLowerCase();
          k = atvo.a(str);
          if ((k != 9) || (k != 0)) {
            this.jdField_d_of_type_Boolean = true;
          }
          Iterator localIterator2 = this.jdField_a_of_type_Anjx.jdField_a_of_type_Anrd.b.iterator();
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo localSupportFileInfo = (C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo)localIterator2.next();
              if (str.endsWith("." + localSupportFileInfo.str_file_suffix.get())) {
                if (localSupportFileInfo.uint32_copies.get() == 1)
                {
                  k = 1;
                  if (localSupportFileInfo.uint32_duplex.get() != 1) {
                    break label498;
                  }
                  m = 1;
                  j = m & j;
                  m = i & k;
                  bool1 = true;
                  i = j;
                  if (bool1) {
                    break label504;
                  }
                  j = i;
                  k = m;
                  bool2 = bool1;
                  if (QLog.isDevelopLevel())
                  {
                    QLog.i("IphoneTitleBarActivity", 1, "printer unsupport file printer : " + localdj.jdField_a_of_type_JavaLangString + " file : " + localFileInfo.d());
                    bool2 = bool1;
                    k = m;
                    j = i;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        i = j;
        bool1 = bool2;
        break;
        k = 0;
        break label383;
        label498:
        m = 0;
        break label398;
        label504:
        j = i;
        i = m;
        break label242;
        i = 0;
        k = 0;
        bool1 = false;
        break;
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return bool1;
        m = i;
        bool1 = false;
        i = j;
        break label413;
        label553:
        k = i;
        bool2 = bool1;
        continue;
        label562:
        j = 1;
        k = 1;
        bool2 = false;
      }
      bool1 = true;
      break;
      k = 1;
      bool1 = false;
    }
  }
  
  void a()
  {
    boolean bool2 = true;
    Object localObject = getString(2131691193) + this.jdField_a_of_type_Int;
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (this.jdField_a_of_type_Int > 1)
    {
      bool1 = true;
      ((View)localObject).setEnabled(bool1);
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Int >= 99) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((View)localObject).setEnabled(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 103) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("sPrinterName");
      long l = paramIntent.getLongExtra("sPrintDin", 0L);
      if ((str == null) && (l == 0L)) {
        this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a = null;
      }
      if ((a()) && (this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a != null)) {
        this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a(this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Anjx = ((anjx)this.app.a(8));
    this.jdField_a_of_type_JavaUtilArrayList = super.getIntent().getParcelableArrayListExtra("sFilesSelected");
    this.jdField_a_of_type_Boolean = super.getIntent().getBooleanExtra("sIsCloudPrinter", false);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("sIsCloudPrinter", false);
    super.getWindow().setBackgroundDrawableResource(2131165431);
    setContentView(2131559051);
    setTitle(2131691199);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131365228));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131361807, "n/a");
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131372865);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372866));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131361937));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368563));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372860));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131365280);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131368539);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372867));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131372862));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox = ((MyCheckBox)super.findViewById(2131377806));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.setOnCheckedChangeListener(new cx(this));
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130841549);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130841548);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130841551);
    }
    this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a = null;
    this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a(this.jdField_a_of_type_Dn);
    if (!a(true))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131691203);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    a();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Anjx.jdField_a_of_type_Dk.a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView) {
      a(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        if ((this.jdField_b_of_type_Boolean) && (a()))
        {
          this.jdField_b_of_type_Boolean = false;
          Intent localIntent = new Intent();
          for (;;)
          {
            try
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("printCopies", this.jdField_a_of_type_Int);
              if (!this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.isChecked()) {
                continue;
              }
              ((JSONObject)localObject).put("duplexMode", 2);
              ((JSONObject)localObject).put("printerName", this.jdField_a_of_type_Anjx.jdField_a_of_type_Anrd.jdField_a_of_type_JavaLangString);
              localObject = ((JSONObject)localObject).toString();
              if (QLog.isDevelopLevel()) {
                QLog.i("IphoneTitleBarActivity", 1, "printer params : " + (String)localObject);
              }
              localIntent.putExtra("sPrintParam", (String)localObject);
              localIntent.putParcelableArrayListExtra("sFilesSelected", this.jdField_a_of_type_JavaUtilArrayList);
              localIntent.putExtra(bgkb.h, super.getIntent().getIntExtra(bgkb.h, 0));
            }
            catch (JSONException localJSONException)
            {
              Object localObject;
              this.jdField_b_of_type_Boolean = true;
              continue;
            }
            setResult(-1, localIntent);
            finish();
            bcst.b(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
            break;
            ((JSONObject)localObject).put("duplexMode", 1);
          }
        }
      }
      else if (paramView == this.jdField_b_of_type_AndroidViewView)
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
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.dataline.activities.PrinterOptionActivity
 * JD-Core Version:    0.7.0.1
 */