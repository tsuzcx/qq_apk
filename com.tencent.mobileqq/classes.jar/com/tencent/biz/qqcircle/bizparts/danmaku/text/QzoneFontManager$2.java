package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Typeface;
import com.tencent.component.media.utils.LruCache;
import cooperation.qzone.util.MultiHashMap;
import java.util.HashSet;
import java.util.Iterator;
import vig;
import vii;

public class QzoneFontManager$2
  implements Runnable
{
  public QzoneFontManager$2(vig paramvig, String paramString, int paramInt) {}
  
  public void run()
  {
    vig.a(this.this$0, null);
    try
    {
      Typeface localTypeface = Typeface.createFromFile(this.jdField_a_of_type_JavaLangString);
      vig.a(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), localTypeface);
      synchronized (vig.a())
      {
        Object localObject3 = (HashSet)vig.a(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
        if ((localObject3 == null) || (((HashSet)localObject3).isEmpty())) {
          return;
        }
        localObject3 = ((HashSet)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          vii localvii = (vii)((Iterator)localObject3).next();
          if (localvii != null) {
            localvii.a(localTypeface);
          }
        }
      }
      vig.a(this.this$0).remove(Integer.valueOf(this.jdField_a_of_type_Int));
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