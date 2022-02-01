package com.tencent.biz.pubaccount.weishi_new.openws;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSReportParams;

class WSOpenWeiShiHelper$1
  implements WSOnDialogItemClickListener
{
  WSOpenWeiShiHelper$1(WSOpenWeiShiHelper paramWSOpenWeiShiHelper, WSReportParams paramWSReportParams, Context paramContext) {}
  
  public void a()
  {
    WSOpenWeiShiReport.c(this.a);
    WSOpenWeiShiHelper.a(this.c, 2);
  }
  
  public void a(@Nullable String paramString)
  {
    WSOpenWeiShiReport.b(this.a);
    WSOpenWeiShiHelper.a(this.c, 1);
    WSOpenWeiShiHelper.a(this.c, this.b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiHelper.1
 * JD-Core Version:    0.7.0.1
 */