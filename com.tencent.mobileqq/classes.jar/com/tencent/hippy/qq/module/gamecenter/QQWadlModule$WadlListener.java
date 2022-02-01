package com.tencent.hippy.qq.module.gamecenter;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.mtt.hippy.common.HippyArray;
import java.util.ArrayList;
import java.util.Iterator;

abstract class QQWadlModule$WadlListener
  implements WadlProxyServiceCallBackInterface
{
  protected abstract void onCallback(String paramString, Object paramObject);
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null)
    {
      HippyArray localHippyArray = new HippyArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localHippyArray.pushMap(QQWadlModule.toHippyMap((WadlResult)paramArrayList.next()));
      }
      onCallback("onQueryCallback", localHippyArray);
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onReceiveYYBInstall(String paramString1, String paramString2) {}
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    onCallback("onWadlTaskStatusChanged", QQWadlModule.toHippyMap(paramWadlResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.gamecenter.QQWadlModule.WadlListener
 * JD-Core Version:    0.7.0.1
 */