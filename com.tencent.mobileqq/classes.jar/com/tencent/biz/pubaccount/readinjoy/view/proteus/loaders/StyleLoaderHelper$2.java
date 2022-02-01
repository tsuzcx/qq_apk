package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class StyleLoaderHelper$2
  implements Runnable
{
  StyleLoaderHelper$2(StyleLoaderHelper paramStyleLoaderHelper) {}
  
  public void run()
  {
    try
    {
      HtmlOffline.a(StyleLoaderHelper.a(this.this$0), BaseApplicationImpl.getApplication().getRuntime(), new StyleLoaderHelper.DummyCallback(this.this$0, StyleLoaderHelper.a(this.this$0), StyleLoaderHelper.b(this.this$0)), true, 5, true);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("TemplateFactory", 1, localOutOfMemoryError, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.2
 * JD-Core Version:    0.7.0.1
 */