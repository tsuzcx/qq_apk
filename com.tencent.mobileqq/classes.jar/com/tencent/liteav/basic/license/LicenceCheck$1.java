package com.tencent.liteav.basic.license;

import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.File;

class LicenceCheck$1
  implements b
{
  LicenceCheck$1(LicenceCheck paramLicenceCheck, LicenceCheck.a parama) {}
  
  public void a()
  {
    TXCLog.i("LicenceCheck", "downloadLicense, onProcessEnd");
    this.a.f = false;
  }
  
  public void a(int paramInt)
  {
    TXCLog.i("LicenceCheck", "downloadLicense, onProgressUpdate");
  }
  
  public void a(File paramFile, Exception paramException)
  {
    TXCLog.i("LicenceCheck", "downloadLicense, onSaveFailed");
  }
  
  public void a(File paramFile, String paramString)
  {
    if (paramFile == null)
    {
      TXCLog.i("LicenceCheck", "downloadLicense, license not modified");
      return;
    }
    LicenceCheck.a(this.b, this.a, paramString);
    TXCLog.i("LicenceCheck", "downloadLicense, onSaveSuccess");
    paramFile = LicenceCheck.a(this.b, this.a);
    if (TextUtils.isEmpty(paramFile))
    {
      TXCLog.e("LicenceCheck", "downloadLicense, readDownloadTempLicence is empty!");
      this.a.f = false;
      return;
    }
    if (LicenceCheck.b(this.b, this.a, paramFile) == 0) {
      LicenceCheck.b(this.b, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.license.LicenceCheck.1
 * JD-Core Version:    0.7.0.1
 */