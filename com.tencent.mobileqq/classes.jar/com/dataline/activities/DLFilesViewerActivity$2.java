package com.dataline.activities;

import com.dataline.util.DatalineFilesAdapter;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;

class DLFilesViewerActivity$2
  extends DataLineObserver
{
  DLFilesViewerActivity$2(DLFilesViewerActivity paramDLFilesViewerActivity) {}
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new DLFilesViewerActivity.2.1(this, paramLong, paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    DLFilesViewerActivity.b(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.d(this.a);
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    Iterator localIterator = DLFilesViewerActivity.a(this.a).values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if (paramString.equals(localDataLineMsgRecord.strMoloKey))
      {
        localDataLineMsgRecord.nAppStatus = 1;
        DLFilesViewerActivity.b(this.a).notifyDataSetChanged();
      }
    }
    DLFilesViewerActivity.d(this.a);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    DLFilesViewerActivity.b(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.d(this.a);
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    DLFilesViewerActivity.b(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.d(this.a);
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    DLFilesViewerActivity.b(this.a).notifyDataSetChanged();
    DLFilesViewerActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.DLFilesViewerActivity.2
 * JD-Core Version:    0.7.0.1
 */