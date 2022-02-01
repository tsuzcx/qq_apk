package com.tencent.gdtad.basics.motivevideo.data;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;

public class StartGdtMotiveVideoParams
{
  public int a;
  public Activity a;
  public Bundle a;
  public ResultReceiver a;
  public GdtMotiveVideoPageData a;
  public boolean a;
  
  public StartGdtMotiveVideoParams()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_Int = 101;
  }
  
  public static StartGdtMotiveVideoParams a(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    StartGdtMotiveVideoParams localStartGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
    localStartGdtMotiveVideoParams.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localStartGdtMotiveVideoParams.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData = paramGdtMotiveVideoPageData;
    return localStartGdtMotiveVideoParams;
  }
  
  public static StartGdtMotiveVideoParams a(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, int paramInt)
  {
    StartGdtMotiveVideoParams localStartGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
    localStartGdtMotiveVideoParams.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localStartGdtMotiveVideoParams.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData = paramGdtMotiveVideoPageData;
    localStartGdtMotiveVideoParams.jdField_a_of_type_Int = paramInt;
    return localStartGdtMotiveVideoParams;
  }
  
  public static StartGdtMotiveVideoParams a(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, ResultReceiver paramResultReceiver)
  {
    StartGdtMotiveVideoParams localStartGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
    localStartGdtMotiveVideoParams.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localStartGdtMotiveVideoParams.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData = paramGdtMotiveVideoPageData;
    localStartGdtMotiveVideoParams.jdField_a_of_type_AndroidOsResultReceiver = paramResultReceiver;
    return localStartGdtMotiveVideoParams;
  }
  
  public static StartGdtMotiveVideoParams a(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString)
  {
    StartGdtMotiveVideoParams localStartGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
    localStartGdtMotiveVideoParams.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localStartGdtMotiveVideoParams.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData = paramGdtMotiveVideoPageData;
    localStartGdtMotiveVideoParams.jdField_a_of_type_AndroidOsBundle.putString("arg_callback", paramString);
    return localStartGdtMotiveVideoParams;
  }
  
  public static StartGdtMotiveVideoParams b(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, ResultReceiver paramResultReceiver)
  {
    StartGdtMotiveVideoParams localStartGdtMotiveVideoParams = new StartGdtMotiveVideoParams();
    localStartGdtMotiveVideoParams.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localStartGdtMotiveVideoParams.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData = paramGdtMotiveVideoPageData;
    localStartGdtMotiveVideoParams.jdField_a_of_type_AndroidOsResultReceiver = paramResultReceiver;
    localStartGdtMotiveVideoParams.jdField_a_of_type_Boolean = true;
    return localStartGdtMotiveVideoParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams
 * JD-Core Version:    0.7.0.1
 */