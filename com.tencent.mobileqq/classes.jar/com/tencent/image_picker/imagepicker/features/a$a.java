package com.tencent.image_picker.imagepicker.features;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import com.tencent.luggage.wxa.av.c;
import com.tencent.luggage.wxa.az.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class a$a
  implements Runnable
{
  private boolean b;
  private boolean c;
  private ArrayList<File> d;
  private c e;
  
  public a$a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<File> paramArrayList, c paramc)
  {
    this.b = paramBoolean2;
    this.c = paramArrayList;
    this.d = paramc;
    Object localObject;
    this.e = localObject;
  }
  
  public void run()
  {
    if (this.c) {
      localObject1 = a.b(this.a).getContentResolver().query(MediaStore.Files.getContentUri("external"), a.a(this.a), "media_type=1 OR media_type=3", null, "date_added");
    } else {
      localObject1 = a.b(this.a).getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, a.a(this.a), null, null, "date_added");
    }
    if (localObject1 == null)
    {
      this.e.a(new NullPointerException());
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    boolean bool = this.b;
    Object localObject3 = null;
    HashMap localHashMap;
    if (bool) {
      localHashMap = new HashMap();
    } else {
      localHashMap = null;
    }
    if (((Cursor)localObject1).moveToLast()) {
      do
      {
        long l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex(a.a(this.a)[0]));
        Object localObject2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex(a.a(this.a)[1]));
        Object localObject4 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex(a.a(this.a)[2]));
        String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex(a.a(this.a)[3]));
        Object localObject5 = a.a((String)localObject4);
        if (localObject5 != null)
        {
          ArrayList localArrayList2 = this.d;
          if ((localArrayList2 == null) || (!localArrayList2.contains(localObject5)))
          {
            localObject5 = new b(l, (String)localObject2, (String)localObject4);
            localArrayList1.add(localObject5);
            if (localHashMap != null)
            {
              localObject4 = (com.tencent.luggage.wxa.az.a)localHashMap.get(str);
              localObject2 = localObject4;
              if (localObject4 == null)
              {
                localObject2 = new com.tencent.luggage.wxa.az.a(str);
                localHashMap.put(str, localObject2);
              }
              ((com.tencent.luggage.wxa.az.a)localObject2).b().add(localObject5);
            }
          }
        }
      } while (((Cursor)localObject1).moveToPrevious());
    }
    ((Cursor)localObject1).close();
    Object localObject1 = localObject3;
    if (localHashMap != null) {
      localObject1 = new ArrayList(localHashMap.values());
    }
    this.e.a(localArrayList1, (List)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.features.a.a
 * JD-Core Version:    0.7.0.1
 */