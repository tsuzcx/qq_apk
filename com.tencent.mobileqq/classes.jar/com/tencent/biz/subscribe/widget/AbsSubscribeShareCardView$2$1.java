package com.tencent.biz.subscribe.widget;

import android.widget.ImageView;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class AbsSubscribeShareCardView$2$1
  implements INetEngineListener
{
  AbsSubscribeShareCardView$2$1(AbsSubscribeShareCardView.2 param2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 0)
    {
      ((ImageView)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_Int)).setImageBitmap(SafeBitmapFactory.decodeFile(this.a.jdField_a_of_type_JavaLangString));
      AbsSubscribeShareCardView.a(this.a.this$0);
      if (AbsSubscribeShareCardView.b(this.a.this$0) == this.a.b.size()) {
        ThreadManager.getUIHandler().post(new AbsSubscribeShareCardView.2.1.1(this));
      }
      return;
    }
    ThreadManager.getUIHandler().post(new AbsSubscribeShareCardView.2.1.2(this));
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2.1
 * JD-Core Version:    0.7.0.1
 */