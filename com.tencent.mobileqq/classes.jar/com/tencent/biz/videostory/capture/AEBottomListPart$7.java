package com.tencent.biz.videostory.capture;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import bgxx;
import bgya;
import bhci;
import bhcm;
import bhcw;
import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import wql;
import wqq;
import wsh;
import wsi;

public class AEBottomListPart$7
  implements Runnable
{
  public AEBottomListPart$7(wqq paramwqq, List paramList, long paramLong) {}
  
  public void run()
  {
    Object localObject = null;
    int j = 0;
    bgya localbgya;
    String str;
    if ((this.this$0.a != null) && (!this.this$0.a.isFinishing()))
    {
      if ((wqq.a(this.this$0).b()) && (!wqq.a(this.this$0))) {
        wqq.a(this.this$0).setVisibility(0);
      }
      wqq.a(this.this$0).a(this.jdField_a_of_type_JavaUtilList);
      localbgya = bgxx.a();
      if ((this.this$0.a == null) || (this.this$0.a.isFinishing())) {
        break label521;
      }
      localObject = this.this$0.a.getIntent();
      str = ((Intent)localObject).getStringExtra("KEY_CURRENT_SELECT_ID");
      localObject = ((Intent)localObject).getStringExtra("KEY_CURRENT_TAB");
    }
    for (;;)
    {
      int i;
      if (localObject != null)
      {
        i = j;
        if (!((String)localObject).equals(String.valueOf(wsh.jdField_a_of_type_Wsh.jdField_a_of_type_Int))) {}
      }
      else
      {
        if (str == null) {
          break label477;
        }
        bhcm.a().e("-1");
        j = wqq.a(this.this$0, str);
        if (j == -1) {
          break label361;
        }
        this.this$0.a.getIntent().putExtra("widgetinfo", "camera^" + str);
        localObject = wqq.a(this.this$0, j);
        i = j;
        if (localObject != null)
        {
          bhci.a().b(((bgya)localObject).a);
          ((bgya)localObject).b = true;
          i = j;
        }
      }
      for (;;)
      {
        long l = 0L;
        if (QLog.isDevelopLevel())
        {
          l = System.currentTimeMillis();
          QLog.d("AEWaterMarkListPart", 4, "foundInitPosition cost=" + (l - this.jdField_a_of_type_Long));
        }
        if (i < wqq.a(this.this$0).getItemCount()) {
          wqq.a(this.this$0).scrollToPosition(i);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("AEWaterMarkListPart", 4, "hot data is real, updatePackage, cost=" + (System.currentTimeMillis() - l));
        }
        return;
        label361:
        localObject = wqq.a(this.this$0).a(str);
        if (localObject != null)
        {
          wqq.a(this.this$0).a((bgya)localObject);
          this.this$0.a.getIntent().putExtra("widgetinfo", "camera^" + ((bgya)localObject).a);
          bhci.a().b(((bgya)localObject).a);
          ((bgya)localObject).b = true;
          i = 1;
        }
        else
        {
          Toast.makeText(wqq.a(this.this$0).a(), 2131624240, 1).show();
          i = 0;
          continue;
          label477:
          i = j;
          if (localbgya != null)
          {
            j = wqq.a(this.this$0, localbgya.a);
            i = j;
            if (j == -1)
            {
              wqq.a(this.this$0).a(localbgya);
              i = 1;
            }
          }
        }
      }
      label521:
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.AEBottomListPart.7
 * JD-Core Version:    0.7.0.1
 */