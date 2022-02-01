package com.tencent.mobileqq.activity.richmedia;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.app.HardCodeUtil;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.lang.ref.WeakReference;

class EditLocalVideoActivity$TrimHandler
  extends Handler
{
  private WeakReference<EditLocalVideoActivity> a;
  
  EditLocalVideoActivity$TrimHandler(EditLocalVideoActivity paramEditLocalVideoActivity)
  {
    this.a = new WeakReference(paramEditLocalVideoActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (EditLocalVideoActivity)this.a.get();
      int i = paramMessage.what;
      if (i != 1000) {
        if (i != 1001)
        {
          if (i != 1006)
          {
            if (i != 1007)
            {
              if (i != 1009)
              {
                if (i != 9999)
                {
                  switch (i)
                  {
                  default: 
                    return;
                  case 1103: 
                    EditLocalVideoActivity.a((EditLocalVideoActivity)localObject);
                    return;
                  case 1102: 
                    EditLocalVideoActivity.a((EditLocalVideoActivity)localObject, paramMessage);
                    return;
                  case 1101: 
                    Toast.makeText(((EditLocalVideoActivity)localObject).getApplicationContext(), HardCodeUtil.a(2131703813), 1).show();
                    EditLocalVideoActivity.d((EditLocalVideoActivity)localObject);
                    return;
                  }
                  if (EditLocalVideoActivity.a((EditLocalVideoActivity)localObject) != null) {
                    EditLocalVideoActivity.a((EditLocalVideoActivity)localObject).requestLayout();
                  }
                }
                else
                {
                  EditLocalVideoActivity.c((EditLocalVideoActivity)localObject);
                }
              }
              else {
                EditLocalVideoActivity.e((EditLocalVideoActivity)localObject);
              }
            }
            else {
              ((EditLocalVideoActivity)localObject).a("608", "3", "2", true);
            }
          }
          else
          {
            ((EditLocalVideoActivity)localObject).a("608", "3", "1", true);
            LpReportInfo_pf00064.allReport(664, 3, 4);
            paramMessage = (String)paramMessage.obj;
          }
        }
        else {
          EditLocalVideoActivity.b((EditLocalVideoActivity)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.TrimHandler
 * JD-Core Version:    0.7.0.1
 */