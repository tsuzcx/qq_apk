package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.util.DelayReportUtils;
import java.util.ArrayList;
import java.util.List;

public class DelayReportManager
  extends BaseAccountLifecycle
{
  private final List<IDelayReporter> a = new ArrayList();
  
  public DelayReportManager()
  {
    this.a.add(new SmsQuickLoginReporter());
  }
  
  public void b()
  {
    if (DelayReportUtils.a()) {
      DelayReportUtils.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.DelayReportManager
 * JD-Core Version:    0.7.0.1
 */