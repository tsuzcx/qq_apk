package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;

class GdtDeviceDemoFragment$1$1
  implements Runnable
{
  GdtDeviceDemoFragment$1$1(GdtDeviceDemoFragment.1 param1) {}
  
  public void run()
  {
    Object localObject = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject).a = "d61533";
    localObject = GdtDeviceInfoHelper.a(this.a.a.getActivity(), (GdtDeviceInfoHelper.Params)localObject);
    GdtDeviceDemoFragment localGdtDeviceDemoFragment = this.a.a;
    if (localObject != null) {}
    for (localObject = GdtJsonPbUtil.a(((GdtDeviceInfoHelper.Result)localObject).a).toString();; localObject = null)
    {
      GdtDeviceDemoFragment.a(localGdtDeviceDemoFragment, String.format("getDeviceInfo %s", new Object[] { localObject }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.1.1
 * JD-Core Version:    0.7.0.1
 */