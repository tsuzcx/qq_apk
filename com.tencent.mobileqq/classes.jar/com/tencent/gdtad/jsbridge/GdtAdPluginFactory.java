package com.tencent.gdtad.jsbridge;

public class GdtAdPluginFactory
{
  private static volatile GdtAdPluginFactory jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory;
  GdtBannerJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtBannerJsCallHandler;
  GdtC2SJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtC2SJsCallHandler;
  GdtCanvasJSONJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtCanvasJSONJsCallHandler;
  GdtCarrierJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtCarrierJsCallHandler;
  GdtDeviceDemoJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceDemoJsCallHandler;
  GdtDeviceIdJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceIdJsCallHandler;
  GdtDeviceInfoJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceInfoJsCallHandler;
  GdtGetUserInfoHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtGetUserInfoHandler;
  GdtHandleClickJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtHandleClickJsCallHandler;
  GdtHippyDemoJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtHippyDemoJsCallHandler;
  GdtInterstitialForJSHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialForJSHandler;
  GdtInterstitialJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialJsCallHandler;
  GdtLaunchAppWithDeeplinkJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtLaunchAppWithDeeplinkJsCallHandler;
  GdtLoadAdJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler;
  GdtLocationJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler;
  GdtMvWebEndcardClickHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebEndcardClickHandler;
  GdtMvWebGetAdInfoHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebGetAdInfoHandler;
  GdtMvWebOnVideoCloseHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebOnVideoCloseHandler;
  GdtMvWebOnVideoMuteHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebOnVideoMuteHandler;
  GdtMvWebReportServerAntiHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebReportServerAntiHandler;
  GdtNetTypeJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtNetTypeJsCallHandler;
  GdtOSVersionJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtOSVersionJsCallHandler;
  GdtOpenMvPageHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtOpenMvPageHandler;
  GdtPreLoadAfterAdLoadedJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtPreLoadAfterAdLoadedJsCallHandler;
  GdtReminderDemoJsCallHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtReminderDemoJsCallHandler;
  GdtWebReportFlyingStreamingHandler jdField_a_of_type_ComTencentGdtadJsbridgeGdtWebReportFlyingStreamingHandler;
  
  public static GdtAdPluginFactory a()
  {
    if (jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory == null) {
        jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory = new GdtAdPluginFactory();
      }
      return jdField_a_of_type_ComTencentGdtadJsbridgeGdtAdPluginFactory;
    }
    finally {}
  }
  
  public GdtJsCallHandler a(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 8: 
    default: 
      return null;
    case 16: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtOpenMvPageHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtOpenMvPageHandler = new GdtOpenMvPageHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtOpenMvPageHandler;
    case 17: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtGetUserInfoHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtGetUserInfoHandler = new GdtGetUserInfoHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtGetUserInfoHandler;
    case 4: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler = new GdtLocationJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLocationJsCallHandler;
    case 5: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler = new GdtLoadAdJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLoadAdJsCallHandler;
    case 15: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtC2SJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtC2SJsCallHandler = new GdtC2SJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtC2SJsCallHandler;
    case 7: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceIdJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceIdJsCallHandler = new GdtDeviceIdJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceIdJsCallHandler;
    case 9: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtCarrierJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtCarrierJsCallHandler = new GdtCarrierJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtCarrierJsCallHandler;
    case 10: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtNetTypeJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtNetTypeJsCallHandler = new GdtNetTypeJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtNetTypeJsCallHandler;
    case 11: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtOSVersionJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtOSVersionJsCallHandler = new GdtOSVersionJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtOSVersionJsCallHandler;
    case 12: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtHandleClickJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtHandleClickJsCallHandler = new GdtHandleClickJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtHandleClickJsCallHandler;
    case 13: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtBannerJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtBannerJsCallHandler = new GdtBannerJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtBannerJsCallHandler;
    case 14: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceInfoJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceInfoJsCallHandler = new GdtDeviceInfoJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceInfoJsCallHandler;
    case 18: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtPreLoadAfterAdLoadedJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtPreLoadAfterAdLoadedJsCallHandler = new GdtPreLoadAfterAdLoadedJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtPreLoadAfterAdLoadedJsCallHandler;
    case 19: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialJsCallHandler = new GdtInterstitialJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialJsCallHandler;
    case 20: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialForJSHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialForJSHandler = new GdtInterstitialForJSHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialForJSHandler;
    case 21: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtCanvasJSONJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtCanvasJSONJsCallHandler = new GdtCanvasJSONJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtCanvasJSONJsCallHandler;
    case 22: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebGetAdInfoHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebGetAdInfoHandler = new GdtMvWebGetAdInfoHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebGetAdInfoHandler;
    case 23: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebEndcardClickHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebEndcardClickHandler = new GdtMvWebEndcardClickHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebEndcardClickHandler;
    case 24: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLaunchAppWithDeeplinkJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLaunchAppWithDeeplinkJsCallHandler = new GdtLaunchAppWithDeeplinkJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtLaunchAppWithDeeplinkJsCallHandler;
    case 25: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebOnVideoCloseHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebOnVideoCloseHandler = new GdtMvWebOnVideoCloseHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebOnVideoCloseHandler;
    case 26: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebOnVideoMuteHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebOnVideoMuteHandler = new GdtMvWebOnVideoMuteHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebOnVideoMuteHandler;
    case 27: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebReportServerAntiHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebReportServerAntiHandler = new GdtMvWebReportServerAntiHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtMvWebReportServerAntiHandler;
    case 28: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceDemoJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceDemoJsCallHandler = new GdtDeviceDemoJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtDeviceDemoJsCallHandler;
    case 29: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtReminderDemoJsCallHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtReminderDemoJsCallHandler = new GdtReminderDemoJsCallHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtReminderDemoJsCallHandler;
    case 30: 
      if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtWebReportFlyingStreamingHandler == null) {
        this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtWebReportFlyingStreamingHandler = new GdtWebReportFlyingStreamingHandler();
      }
      return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtWebReportFlyingStreamingHandler;
    }
    if (this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtHippyDemoJsCallHandler == null) {
      this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtHippyDemoJsCallHandler = new GdtHippyDemoJsCallHandler();
    }
    return this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtHippyDemoJsCallHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtAdPluginFactory
 * JD-Core Version:    0.7.0.1
 */