package com.tencent.avgame.util;

import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.config.data.AvGameConfBean.RecordParam;
import java.util.Iterator;
import java.util.List;

public class RecordUtils
{
  public static AvGameConfBean.RecordParam a()
  {
    return a(1);
  }
  
  public static AvGameConfBean.RecordParam a(int paramInt)
  {
    Object localObject = AvGameConfigUtil.a().a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AvGameConfBean.RecordParam localRecordParam = (AvGameConfBean.RecordParam)((Iterator)localObject).next();
        if (localRecordParam.a == paramInt) {
          return localRecordParam;
        }
      }
    }
    return new AvGameConfBean.RecordParam(0, 10, 15);
  }
  
  public static AvGameConfBean.RecordParam b()
  {
    return a(2);
  }
  
  public static AvGameConfBean.RecordParam c()
  {
    return a(3);
  }
  
  public static AvGameConfBean.RecordParam d()
  {
    return a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.RecordUtils
 * JD-Core Version:    0.7.0.1
 */