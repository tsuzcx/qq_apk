package com.tencent.av.doodle;

import android.os.SystemClock;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class DoodleReportController
{
  public boolean a = false;
  private DoodleLogic b = null;
  private long c = 0L;
  private boolean d = false;
  
  public DoodleReportController(DoodleLogic paramDoodleLogic)
  {
    this.b = paramDoodleLogic;
  }
  
  private void b()
  {
    if (this.a)
    {
      this.c = SystemClock.elapsedRealtime();
      return;
    }
    b(this.b.d);
  }
  
  private void b(int paramInt)
  {
    if (this.c != 0L)
    {
      long l = SystemClock.elapsedRealtime() - this.c;
      if (l > 3000L)
      {
        Object localObject = new HashMap();
        String str1 = Integer.toHexString(paramInt);
        String str2 = String.valueOf(l);
        ((Map)localObject).put("color", str1);
        ((Map)localObject).put("duration", str2);
        UserAction.onUserAction("actAVFunChatDrawing", true, -1L, -1L, (Map)localObject, true);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onUserAction colorString = ");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(", durationString = ");
          ((StringBuilder)localObject).append(str2);
          QLog.d("DoodleReportController", 2, ((StringBuilder)localObject).toString());
        }
        this.d = true;
      }
    }
  }
  
  public void a()
  {
    a(false);
    if (this.d)
    {
      DoodleUtils.a("0X80077C2");
      return;
    }
    DoodleUtils.a("0X80077C1");
  }
  
  public void a(int paramInt)
  {
    if ((this.a) && (paramInt != this.b.d))
    {
      b(paramInt);
      this.c = SystemClock.elapsedRealtime();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleReportController
 * JD-Core Version:    0.7.0.1
 */