package com.etrump.mixlayout;

import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class FontManager$10
  implements Runnable
{
  FontManager$10(FontManager paramFontManager, String paramString, int paramInt) {}
  
  public void run()
  {
    if (FontManager.d(this.this$0).containsKey(this.a))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)FontManager.d(this.this$0).get(this.a);
      if (localConcurrentHashMap.containsKey(Integer.valueOf(this.b)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateDiyConfig uin = ");
          localStringBuilder.append(this.a);
          localStringBuilder.append(" fontId = ");
          localStringBuilder.append(this.b);
          QLog.d("VasFont", 2, localStringBuilder.toString());
        }
        localConcurrentHashMap.remove(Integer.valueOf(this.b));
        VasUtils.a(FontManager.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.10
 * JD-Core Version:    0.7.0.1
 */