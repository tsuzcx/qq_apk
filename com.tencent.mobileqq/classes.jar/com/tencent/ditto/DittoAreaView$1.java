package com.tencent.ditto;

import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFuncPolyInf;
import com.tencent.ditto.reflect.DittoValue;
import com.tencent.ditto.shell.DittoUIEngine.DittoUIEngineInflateListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

class DittoAreaView$1
  implements DittoUIEngine.DittoUIEngineInflateListener
{
  DittoAreaView$1(DittoAreaView paramDittoAreaView, DittoIdFuncPolyInf paramDittoIdFuncPolyInf) {}
  
  public void didInflatedArea(DittoArea paramDittoArea, String paramString)
  {
    if (paramDittoArea.getCompassExposureKey() != null) {
      this.this$0.exposureReportingAreas.add(paramDittoArea);
    }
    this.val$finalFuncPoly.inflateArea(this.this$0, paramDittoArea, paramString);
  }
  
  public void setOutKVCSet(DittoArea paramDittoArea, Map<String, DittoValue> paramMap)
  {
    DittoAreaView.access$000(this.this$0).add(new DittoAreaView.KVCNode(this.this$0, paramDittoArea, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.DittoAreaView.1
 * JD-Core Version:    0.7.0.1
 */