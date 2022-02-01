package com.tencent.mobileqq.activity.richmedia;

import alhq;
import alhv;
import android.os.Handler;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import zdw;

public class EditLocalVideoMusicMixRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private alhv jdField_a_of_type_Alhv;
  private String jdField_a_of_type_JavaLangString;
  private zdw jdField_a_of_type_Zdw;
  private long b;
  private long c;
  
  public EditLocalVideoMusicMixRunnable(long paramLong1, long paramLong2, long paramLong3, String paramString, zdw paramzdw, alhv paramalhv)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Zdw = paramzdw;
    this.jdField_a_of_type_Alhv = paramalhv;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Alhv != null) {
      QzoneHandlerThreadFactory.getMainHandler().post(new EditLocalVideoMusicMixRunnable.3(this));
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Alhv != null) {
      QzoneHandlerThreadFactory.getMainHandler().post(new EditLocalVideoMusicMixRunnable.2(this, paramString));
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null)
    {
      if (this.jdField_a_of_type_Alhv != null) {
        QzoneHandlerThreadFactory.getMainHandler().post(new EditLocalVideoMusicMixRunnable.1(this));
      }
      return true;
    }
    return false;
  }
  
  public void run()
  {
    a();
    if (this.jdField_a_of_type_Zdw.b == 0) {
      a(alhq.a(this.jdField_a_of_type_JavaLangString));
    }
    ArrayList localArrayList;
    String str;
    do
    {
      do
      {
        return;
        localArrayList = new ArrayList();
        localObject1 = alhq.c(this.jdField_a_of_type_Zdw.g);
        QZLog.d("EditLocalVideoMusicMixR", 2, "step 1, run() returned: " + (String)localObject1);
        localArrayList.add(localObject1);
      } while (a((String)localObject1));
      str = alhq.b((String)localObject1);
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 2, run() returned: " + str);
      localArrayList.add(str);
    } while (a(str));
    Object localObject1 = this.jdField_a_of_type_Zdw;
    ((zdw)localObject1).d -= 1000;
    if (this.jdField_a_of_type_Zdw.d > 0) {}
    for (Object localObject2 = alhq.a(this.jdField_a_of_type_Zdw.d, this.jdField_a_of_type_Zdw.e - this.jdField_a_of_type_Zdw.d, str);; localObject2 = str)
    {
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 3, run() returned: " + (String)localObject2);
      localArrayList.add(localObject2);
      if (a((String)localObject2)) {
        break;
      }
      localObject1 = localObject2;
      if (this.b - this.jdField_a_of_type_Long > this.jdField_a_of_type_Zdw.f) {
        localObject1 = alhq.a((String)localObject2, (int)((this.b - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Zdw.f + 1L));
      }
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 4, run() returned: " + (String)localObject1);
      localArrayList.add(localObject1);
      if (a((String)localObject1)) {
        break;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Long > 0L)
      {
        str = alhq.a(this.jdField_a_of_type_Long, str, this.jdField_a_of_type_Zdw.f);
        localObject2 = alhq.a(Arrays.asList(new String[] { str, localObject1 }));
        localArrayList.add(str);
      }
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 5, run() returned: " + (String)localObject2);
      localArrayList.add(localObject2);
      if (a((String)localObject2)) {
        break;
      }
      localObject1 = alhq.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.c);
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 6, run() returned: " + (String)localObject1);
      if (a((String)localObject1)) {
        break;
      }
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if ((str != null) && (new File(str).delete())) {
          QZLog.d("EditLocalVideoMusicMixR", 2, "step 7, run() clear: " + str);
        }
      }
      a((String)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixRunnable
 * JD-Core Version:    0.7.0.1
 */