package com.dataline.activities;

import ajgm;
import ajjy;
import ajom;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import cr;
import cs;
import ct;
import dc;
import dd;
import dg;
import java.util.ArrayList;
import java.util.List;

public class PrinterSubOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public ajgm a;
  public LayoutInflater a;
  public XListView a;
  ct jdField_a_of_type_Ct;
  private dg jdField_a_of_type_Dg = new cr(this);
  public String a;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public List<cs> b = new ArrayList();
  
  public PrinterSubOptionActivity()
  {
    this.jdField_a_of_type_Ajgm = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Ajgm.jdField_a_of_type_Dd != null)
    {
      int j = 0;
      int k = 0;
      this.b.clear();
      List localList = this.jdField_a_of_type_Ajgm.jdField_a_of_type_Dd.a();
      int i1 = localList.size();
      int i = 0;
      if (i < i1)
      {
        dc localdc = (dc)localList.get(i);
        int n;
        int m;
        if ((localdc.jdField_a_of_type_Int == 1) && (j == 0))
        {
          this.b.add(new cs(this, 1, 0L, "PC绑定的打印机"));
          n = 1;
          m = k;
        }
        for (;;)
        {
          this.b.add(new cs(this, 2, localdc.jdField_a_of_type_Long, localdc.jdField_a_of_type_JavaLangString));
          i += 1;
          k = m;
          j = n;
          break;
          m = k;
          n = j;
          if (localdc.jdField_a_of_type_Int == 2)
          {
            m = k;
            n = j;
            if (k == 0)
            {
              this.b.add(new cs(this, 1, 0L, "QQ物联打印机"));
              m = 1;
              n = j;
            }
          }
        }
      }
      this.jdField_a_of_type_Ct.notifyDataSetChanged();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_Ajgm = ((ajgm)this.app.a(8));
    this.jdField_a_of_type_Ajgm.jdField_a_of_type_Ajoj.jdField_a_of_type_JavaUtilList = null;
    getWindow().setBackgroundDrawableResource(2131099823);
    setContentView(2131493387);
    setTitle(2131625799);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_Ct = new ct(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131306239));
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131296270, "n/a");
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ct);
    if (!this.jdField_a_of_type_Ajgm.jdField_a_of_type_Dd.a())
    {
      paramBundle = findViewById(2131300063);
      paramBundle.setVisibility(0);
      paramBundle.setContentDescription(ajjy.a(2131642638));
      ((TextView)findViewById(2131311776)).setText(getString(2131625791));
      ((TextView)findViewById(2131297851)).setText(getString(2131625790));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      setLeftViewName(2131625011);
      this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131296270, "n/a");
      return true;
      a();
      this.jdField_a_of_type_Ajgm.jdField_a_of_type_Dd.a(this.jdField_a_of_type_Dg);
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Ajgm.jdField_a_of_type_Dd.a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_JavaLangString = getString(2131625792);
    this.b.clear();
    a();
    ajom localajom = (ajom)this.app.a(74);
    this.jdField_a_of_type_Boolean = localajom.a();
    localajom.a();
  }
  
  public boolean onBackEvent()
  {
    setResult(-1, new Intent());
    finish();
    return true;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity
 * JD-Core Version:    0.7.0.1
 */