package com.tencent.lbssearch.object.param;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrivingParam$Travel
{
  public List<DrivingParam.Travel.Point> points = new ArrayList();
  
  public void addPoints(DrivingParam.Travel.Point... paramVarArgs)
  {
    if (paramVarArgs != null) {
      this.points.addAll(Arrays.asList(paramVarArgs));
    }
  }
  
  public String toString()
  {
    int i = 50;
    int j = this.points.size();
    if (j > 50) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      j = 0;
      while (j < i)
      {
        localStringBuilder.append(this.points.get(j)).append(";");
        j += 1;
      }
      return super.toString();
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.DrivingParam.Travel
 * JD-Core Version:    0.7.0.1
 */