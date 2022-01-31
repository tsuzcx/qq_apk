package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;

public final class pj
  implements TencentMap.OnIndoorStateChangeListener
{
  private pn a;
  
  public pj(pn parampn)
  {
    this.a = parampn;
  }
  
  public final boolean onIndoorBuildingDeactivated()
  {
    if (this.a == null) {
      return false;
    }
    this.a.onIndoorBuildingDeactivated();
    if (this.a.y != null) {
      this.a.y.onIndoorBuildingDeactivated();
    }
    return true;
  }
  
  public final boolean onIndoorBuildingFocused()
  {
    if (this.a == null) {
      return false;
    }
    this.a.onIndoorBuildingFocused();
    if (this.a.y != null) {
      this.a.y.onIndoorBuildingFocused();
    }
    return true;
  }
  
  public final boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding)
  {
    if (this.a == null) {
      return false;
    }
    this.a.onIndoorLevelActivated(paramIndoorBuilding);
    if (this.a.y != null) {
      this.a.y.onIndoorLevelActivated(paramIndoorBuilding);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.pj
 * JD-Core Version:    0.7.0.1
 */