package com.tencent.gdtad.api.motivebrowsing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoModel;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GdtMotiveBrowsingDialog$Companion$startMotiveBrowsingDialog$1
  implements Runnable
{
  GdtMotiveBrowsingDialog$Companion$startMotiveBrowsingDialog$1(Activity paramActivity, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Intent paramIntent) {}
  
  public final void run()
  {
    try
    {
      GdtMotiveBrowsingDialog localGdtMotiveBrowsingDialog = new GdtMotiveBrowsingDialog((Context)this.jdField_a_of_type_AndroidAppActivity);
      localGdtMotiveBrowsingDialog.a(new GdtMotiveVideoModel(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData));
      localGdtMotiveBrowsingDialog.a(this.jdField_a_of_type_AndroidContentIntent);
      localGdtMotiveBrowsingDialog.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.i("GdtMotiveBrowsingDialog", 1, "dialog.show()", (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingDialog.Companion.startMotiveBrowsingDialog.1
 * JD-Core Version:    0.7.0.1
 */