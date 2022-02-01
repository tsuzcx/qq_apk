package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import com.dataline.activities.PrinterActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import java.util.ArrayList;

class PrinterHandler$4
  implements FMDialogUtil.FMDialogInterface
{
  PrinterHandler$4(PrinterHandler paramPrinterHandler, Context paramContext, String paramString) {}
  
  public void a()
  {
    Intent localIntent = new Intent(this.a, PrinterActivity.class);
    localIntent.putExtra(AlbumConstants.h, 55);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    this.a.startActivity(localIntent);
    ReportController.b(this.c.d, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterHandler.4
 * JD-Core Version:    0.7.0.1
 */