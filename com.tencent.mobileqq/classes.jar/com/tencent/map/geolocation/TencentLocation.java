package com.tencent.map.geolocation;

import android.os.Bundle;
import java.util.List;

public abstract interface TencentLocation
{
  public static final String CELL_PROVIDER = "cell";
  public static final int ERROR_BAD_JSON = 2;
  public static final int ERROR_NETWORK = 1;
  public static final int ERROR_OK = 0;
  public static final int ERROR_UNKNOWN = 404;
  public static final int ERROR_WGS84 = 4;
  public static final String EXTRA_ADDRDESP_LANDMARK = "addrdesp.landmark";
  public static final String EXTRA_ADDRDESP_OTHERS_RESULTS = "addrdesp.results";
  public static final String EXTRA_ADDRDESP_SECOND_LANDMARK = "addrdesp.second_landmark";
  public static final String EXTRA_DIRECTION = "direction";
  public static final String EXTRA_RESP_JSON = "resp_json";
  public static final String FAKE = "fake";
  public static final String GPS_PROVIDER = "gps";
  public static final String NETWORK_PROVIDER = "network";
  public static final String PEDESTRIAN_MODE = "pedestrian";
  public static final String RUN_MODE = "run";
  public static final String STATIC_MODE = "static";
  public static final String UNKNOWN = "unknown";
  public static final String VEHICLE_MODE = "vehicle";
  public static final int VERIFYKEY_ERROR_NETWORK = 5;
  public static final String WIFI_PROVIDER = "wifi";
  
  public abstract float getAccuracy();
  
  public abstract String getAddress();
  
  public abstract double getAltitude();
  
  public abstract Integer getAreaStat();
  
  public abstract float getBearing();
  
  public abstract String getCity();
  
  public abstract String getCityCode();
  
  public abstract int getCoordinateType();
  
  public abstract double getDirection();
  
  public abstract String getDistrict();
  
  public abstract long getElapsedRealtime();
  
  public abstract Bundle getExtra();
  
  public abstract int getFakeReason();
  
  public abstract String getIndoorBuildingFloor();
  
  public abstract String getIndoorBuildingId();
  
  public abstract int getIndoorLocationType();
  
  public abstract double getLatitude();
  
  public abstract double getLongitude();
  
  public abstract String getMotion();
  
  public abstract String getName();
  
  public abstract String getNation();
  
  public abstract List<TencentPoi> getPoiList();
  
  @Deprecated
  public abstract String getProvider();
  
  public abstract String getProvince();
  
  public abstract String getRawData();
  
  public abstract int getRssi();
  
  public abstract String getSourceProvider();
  
  public abstract float getSpeed();
  
  public abstract String getStreet();
  
  public abstract String getStreetNo();
  
  public abstract long getTime();
  
  public abstract String getTown();
  
  public abstract String getVerifyKey();
  
  public abstract String getVillage();
  
  public abstract int isMockGps();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocation
 * JD-Core Version:    0.7.0.1
 */