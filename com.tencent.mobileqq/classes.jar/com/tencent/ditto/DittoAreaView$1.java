package com.tencent.ditto;

import android.support.v4.util.ArrayMap;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.reflect.DittoValue;
import com.tencent.ditto.shell.DittoUIEngine.DittoUIEngineInflateListener;
import com.tencent.ditto.utils.DittoLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

class DittoAreaView$1
  implements DittoUIEngine.DittoUIEngineInflateListener
{
  DittoAreaView$1(DittoAreaView paramDittoAreaView, ArrayMap paramArrayMap1, ArrayMap paramArrayMap2, ArrayMap paramArrayMap3) {}
  
  public void didInflatedArea(DittoArea paramDittoArea, String paramString)
  {
    if (paramDittoArea.getCompassExposureKey() != null) {
      this.this$0.exposureReportingAreas.add(paramDittoArea);
    }
    Field localField;
    if (this.val$finalAreaFields.containsKey(paramString))
    {
      localField = (Field)this.val$finalAreaFields.get(paramString);
      if (localField != null) {
        localField.setAccessible(true);
      }
    }
    try
    {
      localField.set(this.this$0, paramDittoArea);
      if (this.val$finalClickMethods.containsKey(paramString)) {
        paramDittoArea.clickListener = DittoAreaView.access$000((Method)this.val$finalClickMethods.get(paramString), paramDittoArea, this.this$0);
      }
      if (this.val$finalLongClickMethods.containsKey(paramString)) {
        paramDittoArea.longClickListener = DittoAreaView.access$100((Method)this.val$finalLongClickMethods.get(paramString), paramDittoArea, this.this$0);
      }
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        DittoLog.e("DITTO_UI", "inflateErr : " + paramString, localIllegalAccessException);
      }
    }
  }
  
  public void setOutKVCSet(DittoArea paramDittoArea, Map<String, DittoValue> paramMap)
  {
    DittoAreaView.access$200(this.this$0).add(new DittoAreaView.KVCNode(this.this$0, paramDittoArea, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.DittoAreaView.1
 * JD-Core Version:    0.7.0.1
 */