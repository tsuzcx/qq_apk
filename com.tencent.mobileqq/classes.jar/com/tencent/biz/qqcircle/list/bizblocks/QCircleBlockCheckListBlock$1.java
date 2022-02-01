package com.tencent.biz.qqcircle.list.bizblocks;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper.BlockLooperListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

final class QCircleBlockCheckListBlock$1
  implements QCircleHostDropFrameMonitorHelper.BlockLooperListener
{
  public void onBlockLooper(FrameLayout paramFrameLayout, JSONObject paramJSONObject)
  {
    QLog.d("QAPM_looper_GetStackRunnable", 4, "onBlockLooper enter");
    if (paramFrameLayout != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("looperMeta:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("QAPM_looper_GetStackRunnable", 4, localStringBuilder.toString());
      paramJSONObject.remove("event_time");
      QCircleBlockCheckListBlock.getBlockLooperInfoList().add(paramJSONObject);
      paramJSONObject = QCircleBlockCheckListBlock.access$300(paramFrameLayout);
      if (paramJSONObject == null)
      {
        paramFrameLayout = QCircleBlockCheckListBlock.access$400(paramFrameLayout);
      }
      else
      {
        paramJSONObject.setVisibility(0);
        paramFrameLayout = paramJSONObject;
      }
      paramFrameLayout.setText(String.format("存在耗时操作:%d个", new Object[] { Integer.valueOf(QCircleBlockCheckListBlock.getBlockLooperInfoList().size()) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleBlockCheckListBlock.1
 * JD-Core Version:    0.7.0.1
 */