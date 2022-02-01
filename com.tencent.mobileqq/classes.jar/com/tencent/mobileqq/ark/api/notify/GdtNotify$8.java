package com.tencent.mobileqq.ark.api.notify;

import android.content.Context;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ark.ark;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class GdtNotify$8
  implements Runnable
{
  GdtNotify$8(String paramString1, String paramString2, JSONObject paramJSONObject, WeakReference paramWeakReference, boolean paramBoolean) {}
  
  public void run()
  {
    ark.arkNotify(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_OrgJsonJSONObject.toString(), "json");
    AdAnalysisHelperForUtil.reportForARKSendNotification((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_JavaLangString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.8
 * JD-Core Version:    0.7.0.1
 */