package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Typeface;
import com.tencent.component.media.utils.LruCache;
import cooperation.qzone.util.MultiHashMap;
import java.util.HashSet;
import java.util.Iterator;
import vgc;
import vge;

public class QzoneFontManager$2
  implements Runnable
{
  public QzoneFontManager$2(vgc paramvgc, String paramString, int paramInt) {}
  
  public void run()
  {
    vgc.a(this.this$0, null);
    try
    {
      Typeface localTypeface = Typeface.createFromFile(this.jdField_a_of_type_JavaLangString);
      vgc.a(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), localTypeface);
      synchronized (vgc.a())
      {
        Object localObject3 = (HashSet)vgc.a(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
        if ((localObject3 == null) || (((HashSet)localObject3).isEmpty())) {
          return;
        }
        localObject3 = ((HashSet)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          vge localvge = (vge)((Iterator)localObject3).next();
          if (localvge != null) {
            localvge.a(localTypeface);
          }
        }
      }
      vgc.a(this.this$0).remove(Integer.valueOf(this.jdField_a_of_type_Int));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.QzoneFontManager.2
 * JD-Core Version:    0.7.0.1
 */