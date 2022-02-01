package com.tencent.ditto;

import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.reflect.DittoValue;
import java.util.Map;

class DittoAreaView$KVCNode
{
  DittoArea area;
  String id;
  Map<String, DittoValue> kvcSet;
  
  DittoAreaView$KVCNode(DittoArea paramDittoArea, Map<String, DittoValue> paramMap)
  {
    this.area = paramMap;
    this.id = paramMap.getId();
    Object localObject;
    this.kvcSet = localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.DittoAreaView.KVCNode
 * JD-Core Version:    0.7.0.1
 */