package com.tencent.av.business.manager.makeup;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import lil;

public class MakeupMng$1
  implements Runnable
{
  public void run()
  {
    long l = AudioHelper.b();
    Object localObject1 = lil.a(this.this$0).getAccount();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences("QAVPreSetting", 0);
    this.this$0.d = localSharedPreferences.getString("makeup_sel_id_" + (String)localObject1, null);
    lil.a(this.this$0, localSharedPreferences.getString("makeup_value_map_" + (String)localObject1, null));
    this.this$0.c = this.this$0.a(this.this$0.d);
    if (!TextUtils.isEmpty(this.this$0.d)) {}
    try
    {
      lil.a(this.this$0);
      i = 0;
      if ((lil.a(this.this$0) == null) || (i >= lil.b(this.this$0).size())) {
        break label332;
      }
      localObject1 = (PendantItem)lil.c(this.this$0).get(i);
      if ((localObject1 == null) || (!TextUtils.equals(((PendantItem)localObject1).getId(), this.this$0.d))) {
        break label297;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i;
        label297:
        continue;
        Object localObject2 = null;
      }
    }
    if (localObject1 != null) {
      this.this$0.a(l, (PendantItem)localObject1);
    }
    for (;;)
    {
      this.this$0.b = 2;
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.a, 2, "initMakeup, id[" + this.this$0.d + "], value[" + this.this$0.c + "]");
      }
      return;
      i += 1;
      break;
      this.this$0.a(null, 0, false);
      this.this$0.a(l, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.makeup.MakeupMng.1
 * JD-Core Version:    0.7.0.1
 */