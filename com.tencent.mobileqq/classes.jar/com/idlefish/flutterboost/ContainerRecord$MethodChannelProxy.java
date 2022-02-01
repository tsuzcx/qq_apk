package com.idlefish.flutterboost;

import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import java.util.HashMap;
import java.util.Map;

class ContainerRecord$MethodChannelProxy
{
  private int mState = 0;
  
  private ContainerRecord$MethodChannelProxy(ContainerRecord paramContainerRecord) {}
  
  private void appear()
  {
    invokeChannelUnsafe("didShowPageContainer", ContainerRecord.access$500(this.this$0).getContainerUrl(), ContainerRecord.access$500(this.this$0).getContainerUrlParams(), ContainerRecord.access$600(this.this$0));
    this.mState = 2;
  }
  
  private void create()
  {
    if (this.mState == 0)
    {
      invokeChannelUnsafe("didInitPageContainer", ContainerRecord.access$500(this.this$0).getContainerUrl(), ContainerRecord.access$500(this.this$0).getContainerUrlParams(), ContainerRecord.access$600(this.this$0));
      this.mState = 1;
    }
  }
  
  private void destroy()
  {
    if (this.mState < 4)
    {
      invokeChannel("willDeallocPageContainer", ContainerRecord.access$500(this.this$0).getContainerUrl(), ContainerRecord.access$500(this.this$0).getContainerUrlParams(), ContainerRecord.access$600(this.this$0));
      this.mState = 4;
    }
  }
  
  private void disappear()
  {
    if (this.mState < 3)
    {
      invokeChannel("didDisappearPageContainer", ContainerRecord.access$500(this.this$0).getContainerUrl(), ContainerRecord.access$500(this.this$0).getContainerUrlParams(), ContainerRecord.access$600(this.this$0));
      this.mState = 3;
    }
  }
  
  public void invokeChannel(String paramString1, String paramString2, Map paramMap, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pageName", paramString2);
    localHashMap.put("params", paramMap);
    localHashMap.put("uniqueId", paramString3);
    FlutterBoost.instance().channel().invokeMethod(paramString1, localHashMap);
  }
  
  public void invokeChannelUnsafe(String paramString1, String paramString2, Map paramMap, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pageName", paramString2);
    localHashMap.put("params", paramMap);
    localHashMap.put("uniqueId", paramString3);
    FlutterBoost.instance().channel().invokeMethodUnsafe(paramString1, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.idlefish.flutterboost.ContainerRecord.MethodChannelProxy
 * JD-Core Version:    0.7.0.1
 */