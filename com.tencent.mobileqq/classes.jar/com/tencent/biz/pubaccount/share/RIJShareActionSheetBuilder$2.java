package com.tencent.biz.pubaccount.share;

import android.widget.LinearLayout;
import com.tencent.biz.widgets.ElasticHorScrView;
import stb;

public class RIJShareActionSheetBuilder$2
  implements Runnable
{
  public RIJShareActionSheetBuilder$2(stb paramstb, ElasticHorScrView paramElasticHorScrView, LinearLayout paramLinearLayout) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth())
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.share.RIJShareActionSheetBuilder.2
 * JD-Core Version:    0.7.0.1
 */