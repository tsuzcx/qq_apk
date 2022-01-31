package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext.Callback;
import com.tencent.qphone.base.util.QLog;

class TaskManager$8
  implements JSContext.Callback
{
  TaskManager$8(TaskManager paramTaskManager, Task paramTask) {}
  
  public Object invoke(JSContext paramJSContext, int paramInt, Object[] paramArrayOfObject)
  {
    paramInt = 0;
    Task.CONFIG_ITEM[] arrayOfCONFIG_ITEM = this.this$0.getNextScript(paramJSContext, (String)paramArrayOfObject[0]);
    if (arrayOfCONFIG_ITEM != null) {
      while (paramInt < arrayOfCONFIG_ITEM.length)
      {
        String str1 = arrayOfCONFIG_ITEM[paramInt].value;
        String str2 = (String)paramArrayOfObject[1];
        StringBuffer localStringBuffer = new StringBuffer();
        str1 = str1 + "('" + str2 + "'," + TaskManager.access$600(this.this$0, arrayOfCONFIG_ITEM[paramInt].args) + ")";
        if (paramJSContext != null)
        {
          paramJSContext.evaluteStringWithException(str1, localStringBuffer);
          if (!TextUtils.isEmpty(localStringBuffer))
          {
            this.this$0.markTaskFail(this.val$task);
            QLog.d("kandianreport.taskmanager", 1, "evaluate js exception: " + str1 + " " + localStringBuffer);
            TaskException.reportException(this.val$task.id, "evaluate js exception: " + str1 + " " + localStringBuffer);
          }
        }
        paramInt += 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.8
 * JD-Core Version:    0.7.0.1
 */