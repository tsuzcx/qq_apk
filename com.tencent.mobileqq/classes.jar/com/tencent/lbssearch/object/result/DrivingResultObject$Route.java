package com.tencent.lbssearch.object.result;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public final class DrivingResultObject$Route
{
  public String direction;
  public float distance;
  public float duration;
  public String mode;
  public List<LatLng> polyline;
  public DrivingResultObject.Restriction restriction;
  public List<RoutePlanningObject.Step> steps;
  public List<String> tags;
  public DrivingResultObject.TaxiFare taxi_fare;
  public List<DrivingResultObject.WayPoint> waypoints;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.DrivingResultObject.Route
 * JD-Core Version:    0.7.0.1
 */