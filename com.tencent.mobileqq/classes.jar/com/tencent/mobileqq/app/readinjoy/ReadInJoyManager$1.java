package com.tencent.mobileqq.app.readinjoy;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.net.Uri.Builder;
import bkcc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.readinjoy.content.ReadInJoyDataProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class ReadInJoyManager$1
  implements Runnable
{
  ReadInJoyManager$1(ReadInJoyManager paramReadInJoyManager, List paramList) {}
  
  public void run()
  {
    Object localObject1 = ReadInJoyDataProvider.c.buildUpon();
    ((Uri.Builder)localObject1).appendQueryParameter("uin", ReadInJoyManager.a(this.this$0).getAccount());
    localObject1 = ((Uri.Builder)localObject1).build();
    Iterator localIterator = this.a.iterator();
    label495:
    while (localIterator.hasNext())
    {
      bkcc localbkcc = (bkcc)localIterator.next();
      Object localObject2 = new HashSet(ReadInJoyManager.a(this.this$0).keySet()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        int i = ((Integer)((Iterator)localObject2).next()).intValue();
        int j = (int)NetConnInfoCenter.getServerTime();
        if ((i < j) && (j - i > 300)) {
          ReadInJoyManager.a(this.this$0).remove(Integer.valueOf(i));
        }
      }
      if (!ReadInJoyManager.a(this.this$0).containsValue(Integer.valueOf(localbkcc.jdField_b_of_type_Int)))
      {
        ReadInJoyManager.a(this.this$0).put(Integer.valueOf(localbkcc.a), Integer.valueOf(localbkcc.jdField_b_of_type_Int));
        long l = ReadInJoyManager.a(this.this$0);
        if ((localbkcc.c == 10) || (localbkcc.c == 11) || (localbkcc.c == 12) || (localbkcc.c == 999999)) {
          if (ReadInJoyManager.a(this.this$0, (Uri)localObject1, localbkcc, l)) {
            ReadInJoyManager.a(this.this$0);
          }
        }
        for (;;)
        {
          if (localbkcc.c == 999999) {
            break label495;
          }
          break;
          ContentValues localContentValues;
          if (localbkcc.c == 14)
          {
            localObject2 = String.format("%s = '%s' and %s = %d", new Object[] { "commentID", localbkcc.jdField_b_of_type_JavaLangString, "notifyType", Integer.valueOf(11) });
            localContentValues = new ContentValues();
            localContentValues.put("isDelete", Integer.valueOf(1));
            ReadInJoyManager.a(this.this$0).getApp().getContentResolver().update((Uri)localObject1, localContentValues, (String)localObject2, null);
            ReadInJoyManager.a(this.this$0, (Uri)localObject1, localbkcc, l);
          }
          else if (localbkcc.c == 13)
          {
            localObject2 = String.format("%s = %s and %s = %d", new Object[] { "feedsID", Long.toString(localbkcc.jdField_b_of_type_Long), "notifyType", Integer.valueOf(10) });
            localContentValues = new ContentValues();
            localContentValues.put("isDelete", Integer.valueOf(1));
            ReadInJoyManager.a(this.this$0).getApp().getContentResolver().update((Uri)localObject1, localContentValues, (String)localObject2, null);
            ReadInJoyManager.a(this.this$0, (Uri)localObject1, localbkcc, l);
          }
        }
      }
    }
    ReadInJoyManager.a(this.this$0).getApp().getContentResolver().notifyChange(ReadInJoyDataProvider.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.1
 * JD-Core Version:    0.7.0.1
 */