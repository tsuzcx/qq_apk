package com.tencent.biz.qcircleshadow.lib;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneTextApi;

public class QCircleHostTextBuilder
{
  public static SpannableStringBuilder createQzoneTextBuilder(String paramString)
  {
    return ((IQzoneTextApi)QRoute.api(IQzoneTextApi.class)).createQzoneTextBuilder(paramString);
  }
  
  public static Editable.Factory getEmoctationFacory()
  {
    return ((IQzoneTextApi)QRoute.api(IQzoneTextApi.class)).getEmoctationFacory();
  }
  
  public static String toPlainText(Editable paramEditable)
  {
    return ((IQzoneTextApi)QRoute.api(IQzoneTextApi.class)).toPlainText(paramEditable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostTextBuilder
 * JD-Core Version:    0.7.0.1
 */