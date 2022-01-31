package com.dataline.activities;

import ajuo;
import ajyc;
import akcw;
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
import ek;
import el;
import em;
import ev;
import ew;
import ez;
import java.util.ArrayList;
import java.util.List;

public class PrinterSubOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public ajuo a;
  public LayoutInflater a;
  public XListView a;
  em jdField_a_of_type_Em;
  private ez jdField_a_of_type_Ez = new ek(this);
  public String a;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public List<el> b = new ArrayList();
  
  public PrinterSubOptionActivity()
  {
    this.jdField_a_of_type_Ajuo = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Ajuo.jdField_a_of_type_Ew != null)
    {
      int j = 0;
      int k = 0;
      this.b.clear();
      List localList = this.jdField_a_of_type_Ajuo.jdField_a_of_type_Ew.a();
      int i1 = localList.size();
      int i = 0;
      if (i < i1)
      {
        ev localev = (ev)localList.get(i);
        int n;
        int m;
        if ((localev.jdField_a_of_type_Int == 1) && (j == 0))
        {
          this.b.add(new el(this, 1, 0L, "PC绑定的打印机"));
          n = 1;
          m = k;
        }
        for (;;)
        {
          this.b.add(new el(this, 2, localev.jdField_a_of_type_Long, localev.jdField_a_of_type_JavaLangString));
          i += 1;
          k = m;
          j = n;
          break;
          m = k;
          n = j;
          if (localev.jdField_a_of_type_Int == 2)
          {
            m = k;
            n = j;
            if (k == 0)
            {
              this.b.add(new el(this, 1, 0L, "QQ物联打印机"));
              m = 1;
              n = j;
            }
          }
        }
      }
      this.jdField_a_of_type_Em.notifyDataSetChanged();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_Ajuo = ((ajuo)this.app.a(8));
    this.jdField_a_of_type_Ajuo.jdField_a_of_type_Akct.jdField_a_of_type_JavaUtilList = null;
    getWindow().setBackgroundDrawableResource(2131165360);
    setContentView(2131558948);
    setTitle(2131691375);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_Em = new em(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131371934));
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131361806, "n/a");
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Em);
    if (!this.jdField_a_of_type_Ajuo.jdField_a_of_type_Ew.a())
    {
      paramBundle = findViewById(2131365660);
      paramBundle.setVisibility(0);
      paramBundle.setContentDescription(ajyc.a(2131708423));
      ((TextView)findViewById(2131377589)).setText(getString(2131691367));
      ((TextView)findViewById(2131363397)).setText(getString(2131691366));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      setLeftViewName(2131690572);
      this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131361806, "n/a");
      return true;
      a();
      this.jdField_a_of_type_Ajuo.jdField_a_of_type_Ew.a(this.jdField_a_of_type_Ez);
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Ajuo.jdField_a_of_type_Ew.a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_JavaLangString = getString(2131691368);
    this.b.clear();
    a();
    akcw localakcw = (akcw)this.app.a(74);
    this.jdField_a_of_type_Boolean = localakcw.a();
    localakcw.a();
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