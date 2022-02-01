package com.tencent.gdtad.jsbridge;

import acgf;
import achn;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;

public class GdtDeviceDemoFragment$1$1
  implements Runnable
{
  public GdtDeviceDemoFragment$1$1(acgf paramacgf) {}
  
  public void run()
  {
    Object localObject = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject).businessIdForAidTicketAndTaidTicket = "d61533";
    localObject = GdtDeviceInfoHelper.create(this.a.a.getActivity(), (GdtDeviceInfoHelper.Params)localObject);
    GdtDeviceDemoFragment localGdtDeviceDemoFragment = this.a.a;
    if (localObject != null) {}
    for (localObject = achn.a(((GdtDeviceInfoHelper.Result)localObject).deviceInfo).toString();; localObject = null)
    {
      GdtDeviceDemoFragment.a(localGdtDeviceDemoFragment, String.format("getDeviceInfo %s", new Object[] { localObject }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.1.1
 * JD-Core Version:    0.7.0.1
 */