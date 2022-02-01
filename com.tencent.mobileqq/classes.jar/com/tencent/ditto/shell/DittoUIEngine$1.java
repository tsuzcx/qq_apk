package com.tencent.ditto.shell;

import android.support.v4.util.ArrayMap;
import com.tencent.ditto.reflect.MustacheParser;
import java.util.Map;

class DittoUIEngine$1
  implements LayoutAttrSet.ValueIndicator
{
  DittoUIEngine$1(DittoUIEngine paramDittoUIEngine, Map paramMap) {}
  
  public boolean onJsonField(String paramString, Object paramObject)
  {
    if (((paramObject instanceof String)) && (((String)paramObject).startsWith("{{")))
    {
      paramObject = MustacheParser.parse(((String)paramObject).substring(2, ((String)paramObject).length() - 2));
      if (paramObject != null)
      {
        ((ArrayMap)this.val$kvcSet).put(paramString, paramObject);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.shell.DittoUIEngine.1
 * JD-Core Version:    0.7.0.1
 */