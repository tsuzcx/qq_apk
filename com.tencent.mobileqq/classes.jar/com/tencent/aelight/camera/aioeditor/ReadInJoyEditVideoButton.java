package com.tencent.aelight.camera.aioeditor;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoButton;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class ReadInJoyEditVideoButton
  extends EditVideoButton
{
  public ReadInJoyEditVideoButton(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager, paramInt);
  }
  
  private void g()
  {
    a(2064122719).setVisibility(8);
    ((TextView)a(2064122067)).setText(HardCodeUtil.a(2131712805));
  }
  
  public void a()
  {
    super.a();
    g();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    paramView = (Long)this.a.get(i);
    if (paramView != null)
    {
      i = (int)paramView.longValue();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 8) {
            return;
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
          return;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.ReadInJoyEditVideoButton
 * JD-Core Version:    0.7.0.1
 */