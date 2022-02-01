package com.tencent.gdtad.jsbridge;

public class GdtAdPluginFactory
{
  private static volatile GdtAdPluginFactory C;
  GdtFeedbackJsCallHandler A;
  GdtMotiveVideoDemoHandler B;
  GdtLocationJsCallHandler a;
  GdtLoadAdJsCallHandler b;
  GdtDeviceIdJsCallHandler c;
  GdtCarrierJsCallHandler d;
  GdtNetTypeJsCallHandler e;
  GdtOSVersionJsCallHandler f;
  GdtHandleClickJsCallHandler g;
  GdtBannerJsCallHandler h;
  GdtDeviceInfoJsCallHandler i;
  GdtC2SJsCallHandler j;
  GdtOpenMvPageHandler k;
  GdtGetUserInfoHandler l;
  GdtPreLoadAfterAdLoadedJsCallHandler m;
  GdtInterstitialJsCallHandler n;
  GdtInterstitialForJSHandler o;
  GdtCanvasJSONJsCallHandler p;
  GdtMvWebGetAdInfoHandler q;
  GdtMvWebEndcardClickHandler r;
  GdtLaunchAppWithDeeplinkJsCallHandler s;
  GdtMvWebOnVideoCloseHandler t;
  GdtMvWebOnVideoMuteHandler u;
  GdtWebReportFlyingStreamingHandler v;
  GdtMvWebReportServerAntiHandler w;
  GdtDeviceDemoJsCallHandler x;
  GdtReminderDemoJsCallHandler y;
  GdtHippyDemoJsCallHandler z;
  
  public static GdtAdPluginFactory a()
  {
    if (C == null) {
      try
      {
        if (C == null) {
          C = new GdtAdPluginFactory();
        }
      }
      finally {}
    }
    return C;
  }
  
  public GdtJsCallHandler a(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 8: 
    default: 
      return null;
    case 33: 
      if (this.B == null) {
        this.B = new GdtMotiveVideoDemoHandler();
      }
      return this.B;
    case 32: 
      if (this.A == null) {
        this.A = new GdtFeedbackJsCallHandler();
      }
      return this.A;
    case 31: 
      if (this.z == null) {
        this.z = new GdtHippyDemoJsCallHandler();
      }
      return this.z;
    case 30: 
      if (this.v == null) {
        this.v = new GdtWebReportFlyingStreamingHandler();
      }
      return this.v;
    case 29: 
      if (this.y == null) {
        this.y = new GdtReminderDemoJsCallHandler();
      }
      return this.y;
    case 28: 
      if (this.x == null) {
        this.x = new GdtDeviceDemoJsCallHandler();
      }
      return this.x;
    case 27: 
      if (this.w == null) {
        this.w = new GdtMvWebReportServerAntiHandler();
      }
      return this.w;
    case 26: 
      if (this.u == null) {
        this.u = new GdtMvWebOnVideoMuteHandler();
      }
      return this.u;
    case 25: 
      if (this.t == null) {
        this.t = new GdtMvWebOnVideoCloseHandler();
      }
      return this.t;
    case 24: 
      if (this.s == null) {
        this.s = new GdtLaunchAppWithDeeplinkJsCallHandler();
      }
      return this.s;
    case 23: 
      if (this.r == null) {
        this.r = new GdtMvWebEndcardClickHandler();
      }
      return this.r;
    case 22: 
      if (this.q == null) {
        this.q = new GdtMvWebGetAdInfoHandler();
      }
      return this.q;
    case 21: 
      if (this.p == null) {
        this.p = new GdtCanvasJSONJsCallHandler();
      }
      return this.p;
    case 20: 
      if (this.o == null) {
        this.o = new GdtInterstitialForJSHandler();
      }
      return this.o;
    case 19: 
      if (this.n == null) {
        this.n = new GdtInterstitialJsCallHandler();
      }
      return this.n;
    case 18: 
      if (this.m == null) {
        this.m = new GdtPreLoadAfterAdLoadedJsCallHandler();
      }
      return this.m;
    case 17: 
      if (this.l == null) {
        this.l = new GdtGetUserInfoHandler();
      }
      return this.l;
    case 16: 
      if (this.k == null) {
        this.k = new GdtOpenMvPageHandler();
      }
      return this.k;
    case 15: 
      if (this.j == null) {
        this.j = new GdtC2SJsCallHandler();
      }
      return this.j;
    case 14: 
      if (this.i == null) {
        this.i = new GdtDeviceInfoJsCallHandler();
      }
      return this.i;
    case 13: 
      if (this.h == null) {
        this.h = new GdtBannerJsCallHandler();
      }
      return this.h;
    case 12: 
      if (this.g == null) {
        this.g = new GdtHandleClickJsCallHandler();
      }
      return this.g;
    case 11: 
      if (this.f == null) {
        this.f = new GdtOSVersionJsCallHandler();
      }
      return this.f;
    case 10: 
      if (this.e == null) {
        this.e = new GdtNetTypeJsCallHandler();
      }
      return this.e;
    case 9: 
      if (this.d == null) {
        this.d = new GdtCarrierJsCallHandler();
      }
      return this.d;
    case 7: 
      if (this.c == null) {
        this.c = new GdtDeviceIdJsCallHandler();
      }
      return this.c;
    case 5: 
      if (this.b == null) {
        this.b = new GdtLoadAdJsCallHandler();
      }
      return this.b;
    }
    if (this.a == null) {
      this.a = new GdtLocationJsCallHandler();
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtAdPluginFactory
 * JD-Core Version:    0.7.0.1
 */