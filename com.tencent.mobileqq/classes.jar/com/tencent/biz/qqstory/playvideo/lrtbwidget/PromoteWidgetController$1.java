package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PromoteTaskEntry;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;
import urp;
import urr;
import vor;
import wsv;
import xmq;

public class PromoteWidgetController$1
  implements Runnable
{
  public PromoteWidgetController$1(vor paramvor, ArrayList paramArrayList, String paramString, int paramInt) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    wsv.a("PromoteWidgetController", "checkValidateAsync(%s, %s, %d)", this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int));
    if (this.this$0.jdField_a_of_type_Int == 0)
    {
      wsv.e("PromoteWidgetController", "checkValidateAsync() should not check validate of the promotetask, promotetype = 0");
      this.this$0.jdField_a_of_type_Long = -1L;
      return;
    }
    Object localObject = (urp)urr.a(29);
    ArrayList localArrayList = new ArrayList();
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      localArrayList.addAll(((urp)localObject).a(this.jdField_a_of_type_JavaUtilArrayList, this.this$0.jdField_a_of_type_Int));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localArrayList.addAll(((urp)localObject).b(this.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int));
    }
    int i = 0;
    if (i < localArrayList.size())
    {
      localObject = (PromoteTaskEntry)localArrayList.get(i);
      if ((this.jdField_a_of_type_Int < ((PromoteTaskEntry)localObject).minimalVideoCount) || (l > ((PromoteTaskEntry)localObject).expireTime)) {}
    }
    for (;;)
    {
      if (localObject == null)
      {
        wsv.d("PromoteWidgetController", "checkValidateAsync() didn't find promote task for feedId: %s, unionId: %s, size: %d, now=%s(%d)", new Object[] { this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), xmq.a(l), Long.valueOf(l) });
        this.this$0.jdField_a_of_type_Long = -1L;
        return;
        i += 1;
        break;
      }
      wsv.d("PromoteWidgetController", "checkValidateAsync() find the promote task %s", new Object[] { localObject });
      this.this$0.jdField_a_of_type_Long = ((PromoteTaskEntry)localObject).taskId;
      this.this$0.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ThreadManager.getUIHandlerV2().post(new PromoteWidgetController.1.1(this));
      return;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PromoteWidgetController.1
 * JD-Core Version:    0.7.0.1
 */