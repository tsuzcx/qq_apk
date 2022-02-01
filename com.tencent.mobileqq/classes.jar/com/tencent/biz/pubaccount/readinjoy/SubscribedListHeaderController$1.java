package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class SubscribedListHeaderController$1
  implements ViewFactory.FoundClickableViewListener
{
  SubscribedListHeaderController$1(SubscribedListHeaderController paramSubscribedListHeaderController, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    do
    {
      return;
    } while (!(paramViewBase instanceof RvPolymericContainer));
    ((RvPolymericContainer)paramViewBase).a(new SubscribedListHeaderController.1.1(this, paramViewBase));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.SubscribedListHeaderController.1
 * JD-Core Version:    0.7.0.1
 */