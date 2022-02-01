package com.tencent.biz.qqstory.newshare.callback;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class OnSimpleShareListener
  implements OnShareListener
{
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (paramInt == 6) {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2131886635, 0).show();
    }
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131905658), 0).show();
  }
  
  public void d() {}
  
  public void d(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener
 * JD-Core Version:    0.7.0.1
 */