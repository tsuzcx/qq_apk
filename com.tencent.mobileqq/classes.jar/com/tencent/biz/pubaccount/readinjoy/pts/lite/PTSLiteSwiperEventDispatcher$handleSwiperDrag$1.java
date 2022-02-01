package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ocd;
import ozs;
import paa;
import qia;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class PTSLiteSwiperEventDispatcher$handleSwiperDrag$1
  implements Runnable
{
  public PTSLiteSwiperEventDispatcher$handleSwiperDrag$1(String paramString, HashMap paramHashMap) {}
  
  public final void run()
  {
    if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString)) {
      QLog.i("PTSLiteSwiperEventDispatcher", 1, "[handleSwiperDrag] identifier is null.");
    }
    Object localObject = ozs.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyUtils.baseR5Builder()");
    ((paa)localObject).a("type", "1");
    localObject = qia.a(((paa)localObject).a(), this.jdField_a_of_type_JavaUtilHashMap);
    QLog.i("PTSLiteSwiperEventDispatcher", 1, "[handleSwiperDrag], actionName = 0X800A5CC, r5 = " + (String)localObject);
    ocd.a(null, "", "0X800A5CC", "0X800A5CC", 0, 0, "", "", "", (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteSwiperEventDispatcher.handleSwiperDrag.1
 * JD-Core Version:    0.7.0.1
 */