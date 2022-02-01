package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyTabFrame$20
  implements DialogInterface.OnClickListener
{
  ReadinjoyTabFrame$20(ReadinjoyTabFrame paramReadinjoyTabFrame, SelectPositionModule.PositionData paramPositionData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyTabFrame", 2, "showLocationChangedDialog change confirm");
    }
    paramDialogInterface = ReadInJoyLogicEngine.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
    }
    paramDialogInterface = ReadInJoyLogicEngine.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.a().b(41695);
    }
    ReadInJoyLogicEngine.a().a(41695, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.city);
    ReadInJoyLogicEngineEventDispatcher.a().h(41695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.20
 * JD-Core Version:    0.7.0.1
 */