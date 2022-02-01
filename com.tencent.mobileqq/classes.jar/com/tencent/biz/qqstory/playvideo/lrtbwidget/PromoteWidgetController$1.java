package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PromoteTaskEntry;
import com.tencent.biz.qqstory.model.StoryPromoteTaskManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;

class PromoteWidgetController$1
  implements Runnable
{
  PromoteWidgetController$1(PromoteWidgetController paramPromoteWidgetController, ArrayList paramArrayList, String paramString, int paramInt) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    SLog.a("PromoteWidgetController", "checkValidateAsync(%s, %s, %d)", this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int));
    if (this.this$0.jdField_a_of_type_Int == 0)
    {
      SLog.e("PromoteWidgetController", "checkValidateAsync() should not check validate of the promotetask, promotetype = 0");
      this.this$0.jdField_a_of_type_Long = -1L;
      return;
    }
    Object localObject1 = (StoryPromoteTaskManager)SuperManager.a(29);
    ArrayList localArrayList = new ArrayList();
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      localArrayList.addAll(((StoryPromoteTaskManager)localObject1).a(this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_Int));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localArrayList.addAll(((StoryPromoteTaskManager)localObject1).b(this.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int));
    }
    Object localObject2 = null;
    int i = 0;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= localArrayList.size()) {
        break;
      }
      localObject1 = (PromoteTaskEntry)localArrayList.get(i);
      if ((this.jdField_a_of_type_Int >= ((PromoteTaskEntry)localObject1).minimalVideoCount) && (l <= ((PromoteTaskEntry)localObject1).expireTime)) {
        break;
      }
      i += 1;
    }
    if (localObject1 == null)
    {
      SLog.d("PromoteWidgetController", "checkValidateAsync() didn't find promote task for feedId: %s, unionId: %s, size: %d, now=%s(%d)", new Object[] { this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), DateUtils.a(l), Long.valueOf(l) });
      this.this$0.jdField_a_of_type_Long = -1L;
      return;
    }
    SLog.d("PromoteWidgetController", "checkValidateAsync() find the promote task %s", new Object[] { localObject1 });
    this.this$0.jdField_a_of_type_Long = ((PromoteTaskEntry)localObject1).taskId;
    this.this$0.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ThreadManager.getUIHandlerV2().post(new PromoteWidgetController.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PromoteWidgetController.1
 * JD-Core Version:    0.7.0.1
 */