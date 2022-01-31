package com.dataline.activities;

import aa;
import ac;
import ajed;
import ajgm;
import ajgs;
import aken;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.TextView;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.widget.XListView;
import dk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class DLFilesViewerActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static String a;
  private ajgs jdField_a_of_type_Ajgs = new ac(this);
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private dk jdField_a_of_type_Dk;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DLFilesViewerActivity";
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
    int i = 1;
    int j = 0;
    DataLineMsgRecord localDataLineMsgRecord;
    DLFileInfo localDLFileInfo;
    if (localIterator.hasNext())
    {
      localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      localDLFileInfo = dk.a(localDataLineMsgRecord);
      if (((localDLFileInfo.a != 0) && (localDLFileInfo.a != 3)) || (j != 0)) {
        break label217;
      }
      j = 1;
    }
    label128:
    label151:
    label214:
    label217:
    for (;;)
    {
      int k;
      if ((localDLFileInfo.a == 5) && (localDataLineMsgRecord.strMoloKey != null))
      {
        ajgm localajgm = (ajgm)this.app.a(8);
        if (!localDataLineMsgRecord.bIsApkFile) {
          break label151;
        }
        if (localajgm.a(localDataLineMsgRecord.strMoloKey))
        {
          k = 1;
          label122:
          localDataLineMsgRecord.nAppStatus = k;
        }
      }
      else
      {
        if ((localDLFileInfo.a == 5) || (i == 0)) {
          break label214;
        }
        i = 0;
      }
      for (;;)
      {
        break;
        k = 0;
        break label122;
        localDataLineMsgRecord.nAppStatus = 1;
        break label128;
        if (i == 0)
        {
          this.rightViewText.setVisibility(0);
          if (j != 0)
          {
            this.rightViewText.setText(getString(2131628240));
            return;
          }
          this.rightViewText.setText(getString(2131628239));
          return;
        }
        this.rightViewText.setVisibility(8);
        return;
      }
    }
  }
  
  private void b()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getFirstItem();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335) && (localDataLineMsgRecord.bIsApkFile)) {
      setTitle(2131628241);
    }
    for (;;)
    {
      this.leftView.setVisibility(0);
      this.leftView.setText(getString(2131628323));
      a();
      this.rightViewText.setOnClickListener(new aa(this));
      return;
      setTitle(2131628265);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("dl_files_groupid", 0);
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.a().a(0).a(i);
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = this.app.a().a(1).a(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet == null)
    {
      finish();
      return false;
    }
    getWindow().setBackgroundDrawableResource(2131099823);
    setContentView(2131493373);
    getWindow().setBackgroundDrawable(null);
    b();
    findViewById(2131300650);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131300649));
    this.jdField_a_of_type_ComTencentWidgetXListView.setStackFromBottom(true);
    this.jdField_a_of_type_Dk = new dk(this, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet, this, this.app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dk);
    paramBundle = LayoutInflater.from(getActivity()).inflate(2131493267, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getActivity().getResources().getDrawable(2130843917));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(paramBundle);
    addObserver(this.jdField_a_of_type_Ajgs);
    paramBundle = this.app.a();
    if (paramBundle != null) {
      paramBundle.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getTotalCount() - 1);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ajgs != null) {
      removeObserver(this.jdField_a_of_type_Ajgs);
    }
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_Dk.notifyDataSetChanged();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof DataLineMsgRecord))
    {
      this.jdField_a_of_type_Dk.notifyDataSetChanged();
      a();
    }
    do
    {
      do
      {
        return;
        if (!(paramObject instanceof QQMessageFacade.Message)) {
          break;
        }
      } while (!((QQMessageFacade.Message)paramObject).frienduin.endsWith(String.valueOf(ajed.z)));
      this.jdField_a_of_type_Dk.notifyDataSetChanged();
      a();
      return;
    } while ((!(paramObject instanceof RecentUser)) || (!((RecentUser)paramObject).uin.endsWith(String.valueOf(ajed.z))));
    this.jdField_a_of_type_Dk.notifyDataSetChanged();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.DLFilesViewerActivity
 * JD-Core Version:    0.7.0.1
 */