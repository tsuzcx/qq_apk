package com.tencent.av.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import lfu;
import lhe;
import mje;
import mjf;
import mjg;
import mjh;
import mji;
import mqq.app.BaseActivity;

public class MultiVideoMembersListviewAvtivity
  extends BaseActivity
{
  public int a;
  public long a;
  public LayoutInflater a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new mjg(this);
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = null;
  ListView jdField_a_of_type_AndroidWidgetListView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public VideoController a;
  public VideoAppInterface a;
  public String a;
  public ArrayList<lfu> a;
  lhe jdField_a_of_type_Lhe = new mjh(this);
  public mji a;
  public boolean a;
  TextView b = null;
  
  public MultiVideoMembersListviewAvtivity()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Mji = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  void a()
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersListviewAvtivity", 2, "can not get intent");
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("RelationUin");
        if (this.jdField_a_of_type_JavaLangString != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoMembersListviewAvtivity", 2, "processExtraData-->can not get relationuin from intent");
      return;
      this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_Int = localIntent.getIntExtra("uinType", -1);
    } while ((this.jdField_a_of_type_Int != -1) || (!QLog.isColorLevel()));
    QLog.e("MultiVideoMembersListviewAvtivity", 2, "processExtraData-->can not get uintype from intent");
  }
  
  public void b()
  {
    super.finish();
  }
  
  public void c()
  {
    String str = String.format(super.getResources().getString(2131695996), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.c().size()) });
    if (this.b != null) {
      this.b.setText(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Boolean = super.getIntent().getBooleanExtra("KEY_ISFORGVIDEO", false);
    if (this.jdField_a_of_type_Boolean) {
      super.setContentView(2131559579);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersListviewAvtivity", 2, "onCreate-->can not get the VideoAppInterface");
      }
      super.finish();
      return;
      super.setContentView(2131559592);
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersListviewAvtivity", 2, "onCreate-->can not get the VideoController");
      }
      super.finish();
      return;
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(super.getApplicationContext());
    a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lhe);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369356));
    this.b = ((TextView)super.findViewById(2131370232));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131370155));
    this.jdField_a_of_type_Mji = new mji(this);
    if (super.getIntent().getIntExtra("needDataSimple", 0) == 1) {}
    for (paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.e();; paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.c())
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        lfu locallfu = (lfu)paramBundle.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(locallfu);
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, new mje(this));
    }
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Mji);
    paramBundle = String.format(super.getResources().getString(2131695996), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
    this.b.setText(paramBundle);
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new mjf(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lhe);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Mji = null;
    this.jdField_a_of_type_AndroidWidgetListView = null;
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.b = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_a_of_type_Lhe = null;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoMembersListviewAvtivity
 * JD-Core Version:    0.7.0.1
 */