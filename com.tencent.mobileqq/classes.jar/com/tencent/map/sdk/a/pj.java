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
    pn localpn = this.a;
    if (localpn == null) {
      return false;
    }
    localpn.onIndoorBuildingDeactivated();
    if (this.a.y != null) {
      this.a.y.onIndoorBuildingDeactivated();
    }
    return true;
  }
  
  public final boolean onIndoorBuildingFocused()
  {
    pn localpn = this.a;
    if (localpn == null) {
      return false;
    }
    localpn.onIndoorBuildingFocused();
    if (this.a.y != null) {
      this.a.y.onIndoorBuildingFocused();
    }
    return true;
  }
  
  public final boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding)
  {
    pn localpn = this.a;
    if (localpn == null) {
      return false;
    }
    localpn.onIndoorLevelActivated(paramIndoorBuilding);
    if (this.a.y != null) {
      this.a.y.onIndoorLevelActivated(paramIndoorBuilding);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pj
 * JD-Core Version:    0.7.0.1
 */