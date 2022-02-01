package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class QBaseFileListContentView
  extends QBaseContentView
{
  NoFileRelativeLayout d = null;
  QfilePinnedHeaderExpandableListView e;
  List<FileManagerEntity> f = new ArrayList();
  QfileBaseExpandableListAdapter g = null;
  LinkedHashMap<String, List<FileManagerEntity>> h = new LinkedHashMap();
  protected Comparator<FileManagerEntity> i = new QBaseFileListContentView.1(this);
  
  public QBaseFileListContentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QBaseFileListContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QBaseFileListContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void i()
  {
    this.e = ((QfilePinnedHeaderExpandableListView)findViewById(2131433125));
    this.e.setSelection(0);
    this.e.setFocusable(false);
    j();
    this.g = getAdapter();
    this.g.a(this.e);
    this.e.setSelector(2131168376);
    this.e.setWhetherImageTab(false);
    this.e.setAdapter(this.g);
    this.e.setTranscriptMode(0);
  }
  
  private void j()
  {
    this.d = new NoFileRelativeLayout(this.a);
    this.d.setText(2131889283);
    this.d.setVisible(false);
    this.e.addHeaderView(this.d);
    this.d.setGone();
  }
  
  public void a()
  {
    setContentView(2131627054);
    i();
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.f.contains(paramFileManagerEntity))
    {
      this.f.add(paramFileManagerEntity);
      Collections.sort(this.f, this.i);
    }
  }
  
  public void b()
  {
    this.f.clear();
    this.h.clear();
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
    LinkedHashMap localLinkedHashMap = this.h;
    if ((localLinkedHashMap != null) && (localLinkedHashMap.size() != 0))
    {
      this.d.setGone();
      this.e.removeHeaderView(this.d);
      this.e.setEnabled(true);
    }
    else
    {
      this.d.setTopViewHeight(0.2F);
      this.d.setVisible(true);
      this.e.setEnabled(false);
    }
    this.g.notifyDataSetChanged();
  }
  
  protected void g()
  {
    this.a.runOnUiThread(new QBaseFileListContentView.2(this));
  }
  
  protected abstract QfileBaseExpandableListAdapter getAdapter();
  
  protected void getRecentFileRecords()
  {
    this.h.clear();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.bDelInFM)
      {
        String str = QfileTimeUtils.a(localFileManagerEntity.srvTime);
        if (!this.h.containsKey(str)) {
          this.h.put(str, new ArrayList());
        }
        ((List)this.h.get(str)).add(localFileManagerEntity);
      }
    }
    g();
  }
  
  public ListView getScrollableView()
  {
    return this.e;
  }
  
  protected void h()
  {
    int j = this.g.getGroupCount();
    this.a.runOnUiThread(new QBaseFileListContentView.3(this, j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QBaseFileListContentView
 * JD-Core Version:    0.7.0.1
 */