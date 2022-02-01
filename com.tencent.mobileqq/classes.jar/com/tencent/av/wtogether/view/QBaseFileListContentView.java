package com.tencent.av.wtogether.view;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import atab;
import aufn;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import nap;

public abstract class QBaseFileListContentView
  extends QBaseContentView
{
  atab jdField_a_of_type_Atab = null;
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  QfilePinnedHeaderExpandableListView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  protected Comparator<FileManagerEntity> a;
  LinkedHashMap<String, List<FileManagerEntity>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  List<FileManagerEntity> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public QBaseFileListContentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilComparator = new nap(this);
  }
  
  public QBaseFileListContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilComparator = new nap(this);
  }
  
  public QBaseFileListContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilComparator = new nap(this);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131366763));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setFocusable(false);
    k();
    this.jdField_a_of_type_Atab = a();
    this.jdField_a_of_type_Atab.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131167296);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Atab);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setTranscriptMode(0);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131692235);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
  }
  
  protected abstract atab a();
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  }
  
  public void a()
  {
    a(2131560831);
    j();
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramFileManagerEntity))
    {
      this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
      Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
  }
  
  public void c()
  {
    e();
    g();
  }
  
  public void d() {}
  
  protected abstract void e();
  
  protected void f()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setTopViewHeight(0.2F);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Atab.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setEnabled(true);
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new QBaseFileListContentView.2(this));
  }
  
  public void h()
  {
    int i = this.jdField_a_of_type_Atab.getGroupCount();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new QBaseFileListContentView.3(this, i));
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.bDelInFM)
      {
        String str = aufn.a(localFileManagerEntity.srvTime);
        if (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
        }
        ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFileManagerEntity);
      }
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QBaseFileListContentView
 * JD-Core Version:    0.7.0.1
 */