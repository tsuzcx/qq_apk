package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.handlers.BaseHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.HandlerTask;
import com.tencent.widget.ListView;

class RIJInvokeHandler$3
  extends HandlerTask
{
  RIJInvokeHandler$3(RIJInvokeHandler paramRIJInvokeHandler, String paramString, View paramView, ListView paramListView)
  {
    super(paramString);
  }
  
  public void a(BaseHandler paramBaseHandler)
  {
    paramBaseHandler.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentWidgetListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler.3
 * JD-Core Version:    0.7.0.1
 */