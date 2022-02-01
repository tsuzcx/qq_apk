package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Typeface;
import android.util.LruCache;
import com.tencent.biz.qqcircle.bizparts.danmaku.model.MultiHashMap;
import java.util.HashSet;
import java.util.Iterator;

class QzoneFontManager$2
  implements Runnable
{
  QzoneFontManager$2(QzoneFontManager paramQzoneFontManager, String paramString, int paramInt) {}
  
  public void run()
  {
    QzoneFontManager.a(this.this$0, null);
    try
    {
      Typeface localTypeface = Typeface.createFromFile(this.a);
      QzoneFontManager.b(this.this$0).put(Integer.valueOf(this.b), localTypeface);
      synchronized (QzoneFontManager.b())
      {
        Object localObject3 = (HashSet)QzoneFontManager.a(this.this$0).get(Integer.valueOf(this.b));
        if ((localObject3 != null) && (!((HashSet)localObject3).isEmpty()))
        {
          localObject3 = ((HashSet)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            QzoneFontManager.OnFontLoadListener localOnFontLoadListener = (QzoneFontManager.OnFontLoadListener)((Iterator)localObject3).next();
            if (localOnFontLoadListener != null) {
              localOnFontLoadListener.a(localTypeface);
            }
          }
          QzoneFontManager.a(this.this$0).remove(Integer.valueOf(this.b));
          return;
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.QzoneFontManager.2
 * JD-Core Version:    0.7.0.1
 */