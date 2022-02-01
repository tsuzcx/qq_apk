package com.tencent.mobileqq.activity.aio.panel.miniapp;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class AioPanelMiniAppManager$1
  implements URLDrawable.URLDrawableListener
{
  AioPanelMiniAppManager$1(AioPanelMiniAppManager paramAioPanelMiniAppManager, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("AioPanelMiniAppManager", 1, "onLoadFialed: failed. ", paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadSuccessed: invoked.  url: ");
      paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("AioPanelMiniAppManager", 2, paramURLDrawable.toString());
    }
    AioPanelMiniAppManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelMiniappAioPanelMiniAppManager).put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager.1
 * JD-Core Version:    0.7.0.1
 */