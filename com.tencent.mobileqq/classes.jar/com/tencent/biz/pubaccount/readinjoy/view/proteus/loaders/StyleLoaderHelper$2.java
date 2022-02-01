package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import nuz;
import tmn;
import tmo;

public class StyleLoaderHelper$2
  implements Runnable
{
  public StyleLoaderHelper$2(tmn paramtmn) {}
  
  public void run()
  {
    try
    {
      nuz.a(tmn.a(this.this$0), BaseApplicationImpl.getApplication().getRuntime(), new tmo(this.this$0, tmn.a(this.this$0), tmn.b(this.this$0)), true, 5, true);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("TemplateFactory", 1, localOutOfMemoryError, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.2
 * JD-Core Version:    0.7.0.1
 */