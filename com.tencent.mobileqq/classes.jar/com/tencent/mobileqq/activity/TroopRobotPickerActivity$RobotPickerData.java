package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import java.io.Serializable;

public class TroopRobotPickerActivity$RobotPickerData
  implements Serializable
{
  public static final int REQ_ROBOT_PICKER = 111;
  static final int TYPE_AGE_PICKER = 2;
  static final int TYPE_LOCATION_PICKER = 3;
  static final int TYPE_SEX_PICKER = 1;
  public int mAgeSelectIndex1;
  public int mAgeSelectIndex2;
  public int mCurAgeIndex1;
  public int mCurAgeIndex2;
  public BaseAddress[] mLocationArray;
  public String[] mLocationCodeArray;
  public int mLocationColumCount;
  public BaseAddress mLocationCountry;
  public String mLocationCountyCode;
  public int[] mLocationIndexArray;
  public Object[] mLocationListArray;
  public int mSexIndex;
  public int pickerType = -1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity.RobotPickerData
 * JD-Core Version:    0.7.0.1
 */