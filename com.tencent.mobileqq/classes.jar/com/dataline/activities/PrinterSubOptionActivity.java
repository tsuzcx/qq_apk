package com.dataline.activities;

import alqo;
import alud;
import alyz;
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
import ct;
import cu;
import cv;
import de;
import df;
import di;
import java.util.ArrayList;
import java.util.List;

public class PrinterSubOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public alqo a;
  public LayoutInflater a;
  public XListView a;
  cv jdField_a_of_type_Cv;
  private di jdField_a_of_type_Di = new ct(this);
  public String a;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  public List<cu> b = new ArrayList();
  
  public PrinterSubOptionActivity()
  {
    this.jdField_a_of_type_Alqo = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Alqo.jdField_a_of_type_Df != null)
    {
      int j = 0;
      int k = 0;
      this.b.clear();
      List localList = this.jdField_a_of_type_Alqo.jdField_a_of_type_Df.a();
      int i1 = localList.size();
      int i = 0;
      if (i < i1)
      {
        de localde = (de)localList.get(i);
        int n;
        int m;
        if ((localde.jdField_a_of_type_Int == 1) && (j == 0))
        {
          this.b.add(new cu(this, 1, 0L, "PC绑定的打印机"));
          n = 1;
          m = k;
        }
        for (;;)
        {
          this.b.add(new cu(this, 2, localde.jdField_a_of_type_Long, localde.jdField_a_of_type_JavaLangString));
          i += 1;
          k = m;
          j = n;
          break;
          m = k;
          n = j;
          if (localde.jdField_a_of_type_Int == 2)
          {
            m = k;
            n = j;
            if (k == 0)
            {
              this.b.add(new cu(this, 1, 0L, "QQ物联打印机"));
              m = 1;
              n = j;
            }
          }
        }
      }
      this.jdField_a_of_type_Cv.notifyDataSetChanged();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_a_of_type_Alqo = ((alqo)this.app.a(8));
    this.jdField_a_of_type_Alqo.jdField_a_of_type_Alyw.jdField_a_of_type_JavaUtilList = null;
    getWindow().setBackgroundDrawableResource(2131165395);
    setContentView(2131558984);
    setTitle(2131691429);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_Cv = new cv(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131372273));
    this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131361806, "n/a");
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Cv);
    if (!this.jdField_a_of_type_Alqo.jdField_a_of_type_Df.a())
    {
      paramBundle = findViewById(2131365745);
      paramBundle.setVisibility(0);
      paramBundle.setContentDescription(alud.a(2131708818));
      ((TextView)findViewById(2131378180)).setText(getString(2131691421));
      ((TextView)findViewById(2131363435)).setText(getString(2131691420));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      setLeftViewName(2131690623);
      this.jdField_a_of_type_ComTencentWidgetXListView.setTag(2131361806, "n/a");
      return true;
      a();
      this.jdField_a_of_type_Alqo.jdField_a_of_type_Df.a(this.jdField_a_of_type_Di);
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Alqo.jdField_a_of_type_Df.a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_JavaLangString = getString(2131691422);
    this.b.clear();
    a();
    alyz localalyz = (alyz)this.app.a(74);
    this.jdField_a_of_type_Boolean = localalyz.a();
    localalyz.a();
  }
  
  public boolean onBackEvent()
  {
    setResult(-1, new Intent());
    finish();
    return true;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity
 * JD-Core Version:    0.7.0.1
 */