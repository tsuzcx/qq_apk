package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicReportUtils;
import org.json.JSONObject;

class ComicTipsBar$1
  implements View.OnClickListener
{
  ComicTipsBar$1(ComicTipsBar paramComicTipsBar, View paramView) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_Boolean) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("from", "19");
      label27:
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_AndroidAppActivity, VipComicJumpActivity.class);
      localIntent.putExtra("options", localJSONObject.toString());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidViewView.postDelayed(new ComicTipsBar.1.1(this), 2500L);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_Boolean) {
        VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40039", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.b, new String[0]);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_AndroidAppActivity.finish();
        break;
        VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "2", "40025", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsComicTipsBar.b, new String[] { "2" });
      }
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.ComicTipsBar.1
 * JD-Core Version:    0.7.0.1
 */