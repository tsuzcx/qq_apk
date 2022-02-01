package com.tencent.biz.pubaccount.readinjoy.video.column;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import nkl;
import ryj;
import ryk;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class VideoColumnDataManager$fetchVideoColumnList$2
  implements Runnable
{
  public VideoColumnDataManager$fetchVideoColumnList$2(ryk paramryk, String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public final void run()
  {
    NewIntent localNewIntent = new NewIntent((Context)BaseApplicationImpl.context, nkl.class);
    localNewIntent.putExtra("cmd", "MQUpdateSvc_com_qq_kandian.web.JsOidbProxy.oidb_0xdd7_1");
    localNewIntent.putExtra("data", ryk.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b).toByteArray());
    localNewIntent.setObserver((BusinessObserver)new ryj(this.this$0, this.jdField_a_of_type_JavaLangString, this.b));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnDataManager.fetchVideoColumnList.2
 * JD-Core Version:    0.7.0.1
 */