package com.tencent.mobileqq.app;

import com.dataline.activities.LiteActivity;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.litetransfersdk.Session;

class PrinterHandler$3
  extends DataLineObserver
{
  PrinterHandler$3(PrinterHandler paramPrinterHandler) {}
  
  protected void a(Session paramSession)
  {
    if (paramSession.isFileAssist) {
      return;
    }
    this.a.a(3, paramSession, 0.0D, false);
    if (this.a.i != null)
    {
      this.a.i.e();
      this.a.i.notifyDataSetChanged();
      LiteActivity.a(this.a.i.c.d, this.a.i.c.c);
      LiteActivity.a(this.a.i.c.c);
    }
  }
  
  protected void a(Session paramSession, float paramFloat)
  {
    this.a.a(1, paramSession, paramFloat, false);
    if (this.a.i != null) {
      this.a.i.notifyDataSetChanged();
    }
  }
  
  protected void a(Session paramSession, boolean paramBoolean)
  {
    this.a.a(2, paramSession, 0.0D, paramBoolean);
    if (this.a.i != null) {
      this.a.i.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    this.a.a(paramLong, paramBoolean);
    if (this.a.i != null) {
      this.a.i.notifyDataSetChanged();
    }
  }
  
  protected void b(Session paramSession)
  {
    if (paramSession.isFileAssist) {
      return;
    }
    this.a.a(0, paramSession, 0.0D, false);
    if (this.a.i != null) {
      this.a.i.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterHandler.3
 * JD-Core Version:    0.7.0.1
 */