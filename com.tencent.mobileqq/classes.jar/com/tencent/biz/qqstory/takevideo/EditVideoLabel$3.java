package com.tencent.biz.qqstory.takevideo;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.label.QQStoryAddVideoLabelViewPart;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditVideoLabel$3
  implements View.OnClickListener
{
  EditVideoLabel$3(EditVideoLabel paramEditVideoLabel) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.jdField_a_of_type_JavaLangString;
      str = this.a.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      if ((str.equals("##")) || (TextUtils.isEmpty(str)) || (!str.equals("# " + this.a.jdField_a_of_type_JavaLangString)))
      {
        EditVideoPartManager localEditVideoPartManager = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())
        {
          str = "2";
          localEditVideoPartManager.a("use_custom_tag", 0, 0, new String[] { str });
        }
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("# " + this.a.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str = "1";
      break;
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoLabel.3
 * JD-Core Version:    0.7.0.1
 */