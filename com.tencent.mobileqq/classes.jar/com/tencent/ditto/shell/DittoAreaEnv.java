package com.tencent.ditto.shell;

import android.content.Context;
import com.tencent.ditto.utils.ClassLoadUtils;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.FlexLinearAreaLayout;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DittoAreaEnv
{
  public static final Map<String, Class> mAreaLib = new ConcurrentHashMap();
  
  static
  {
    mAreaLib.put("com.tencent.ditto.widget.DittoImageArea", DittoImageArea.class);
    mAreaLib.put("com.tencent.ditto.widget.DittoButtonArea", DittoButtonArea.class);
    mAreaLib.put("com.tencent.ditto.widget.DittoListArea", DittoListArea.class);
    mAreaLib.put("com.tencent.ditto.widget.DittoTextArea", DittoTextArea.class);
    mAreaLib.put("com.tencent.ditto.widget.FlexLinearAreaLayout", FlexLinearAreaLayout.class);
    mAreaLib.put("com.tencent.ditto.widget.LinearAreaLayout", LinearAreaLayout.class);
    mAreaLib.put("com.tencent.ditto.widget.RelativeAreaLayout", RelativeAreaLayout.class);
  }
  
  public static Class findAreaClass(String paramString)
  {
    if (mAreaLib.containsKey(paramString)) {
      return (Class)mAreaLib.get(paramString);
    }
    Class localClass = ClassLoadUtils.load(DittoUIEngine.g().getContext().getClassLoader(), paramString);
    mAreaLib.put(paramString, localClass);
    return localClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.shell.DittoAreaEnv
 * JD-Core Version:    0.7.0.1
 */