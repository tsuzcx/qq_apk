package com.tencent.gdtad.api.motivebrowsing;

import abmw;
import abop;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class GdtMotiveBrowsingDialog$Companion$startMotiveBrowsingDialog$1
  implements Runnable
{
  public GdtMotiveBrowsingDialog$Companion$startMotiveBrowsingDialog$1(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Intent paramIntent) {}
  
  public final void run()
  {
    try
    {
      abmw localabmw = new abmw((Context)this.jdField_a_of_type_AndroidAppActivity);
      localabmw.a(new abop(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData));
      localabmw.a(this.jdField_a_of_type_AndroidContentIntent);
      localabmw.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.i("GdtMotiveBrowsingDialog", 1, "dialog.show()", (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingDialog.Companion.startMotiveBrowsingDialog.1
 * JD-Core Version:    0.7.0.1
 */