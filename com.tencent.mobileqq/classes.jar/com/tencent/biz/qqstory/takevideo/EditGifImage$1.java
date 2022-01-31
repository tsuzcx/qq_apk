package com.tencent.biz.qqstory.takevideo;

import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import befq;
import bgfc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import usa;
import uut;

class EditGifImage$1
  implements Runnable
{
  EditGifImage$1(EditGifImage paramEditGifImage, LruCache paramLruCache) {}
  
  public void run()
  {
    if (!this.this$0.b)
    {
      if ((!(this.this$0.jdField_a_of_type_Uut.a.a instanceof EditLocalGifSource)) || (((EditLocalGifSource)this.this$0.jdField_a_of_type_Uut.a.a).a == null) || (((EditLocalGifSource)this.this$0.jdField_a_of_type_Uut.a.a).a.size() <= 0)) {
        break label284;
      }
      ArrayList localArrayList = ((EditLocalGifSource)this.this$0.jdField_a_of_type_Uut.a.a).a;
      if (!bgfc.a().a(localArrayList, this.a)) {
        break label247;
      }
      this.this$0.c = true;
      this.this$0.jdField_a_of_type_Befq.sendEmptyMessage(996);
      if ((this.a != null) && (this.a.size() == localArrayList.size()))
      {
        localArrayList = new ArrayList();
        int i = 0;
        while (i < this.a.size())
        {
          BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.a.get(Integer.valueOf(i));
          if (localBitmapDrawable != null) {
            localArrayList.add(localBitmapDrawable.getBitmap());
          }
          i += 1;
        }
        this.this$0.jdField_a_of_type_Usa = new usa(this.this$0);
        this.this$0.jdField_a_of_type_Usa.execute(new ArrayList[] { localArrayList });
      }
    }
    label247:
    do
    {
      do
      {
        return;
        this.this$0.c = false;
        this.this$0.jdField_a_of_type_Befq.sendEmptyMessage(997);
      } while (!QLog.isColorLevel());
      QLog.d("QzoneVision", 2, "MSG_CANNOT_ANTISHAKE");
      return;
      this.this$0.c = false;
      this.this$0.jdField_a_of_type_Befq.sendEmptyMessage(997);
    } while (!QLog.isColorLevel());
    label284:
    QLog.d("QzoneVision", 2, "MSG_CANNOT_ANTISHAKE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditGifImage.1
 * JD-Core Version:    0.7.0.1
 */