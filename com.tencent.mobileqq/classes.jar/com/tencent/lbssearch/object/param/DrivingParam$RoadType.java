package com.tencent.lbssearch.object.param;

public enum DrivingParam$RoadType
{
  static
  {
    ABOVE_BRIDGE = new RoadType("ABOVE_BRIDGE", 1);
    BELOW_BRIDGE = new RoadType("BELOW_BRIDGE", 2);
    ON_MAIN_ROAD = new RoadType("ON_MAIN_ROAD", 3);
    ON_SIDE_ROAD = new RoadType("ON_SIDE_ROAD", 4);
    OPPOSITE_SIDE = new RoadType("OPPOSITE_SIDE", 5);
  }
  
  private DrivingParam$RoadType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.DrivingParam.RoadType
 * JD-Core Version:    0.7.0.1
 */