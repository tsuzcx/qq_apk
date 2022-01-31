package com.tencent.biz.pubaccount.readinjoy.comment;

import agwq;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import oks;

public class ReadInJoyCommentComponentFragment$8$1
  implements Runnable
{
  public ReadInJoyCommentComponentFragment$8$1(oks paramoks) {}
  
  public void run()
  {
    agwq localagwq = ReadInJoyCommentComponentFragment.a(this.a.a);
    if ((localagwq != null) && (ReadInJoyCommentComponentFragment.a(this.a.a)))
    {
      localagwq.c();
      ReadInJoyCommentComponentFragment.a(this.a.a, false);
      this.a.a.f.setSelected(false);
    }
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ReadInJoyDeliverUGCActivity.a(this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData));
    this.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    ReadInJoyCommentComponentFragment.a(this.a.a);
    if (this.a.a.jdField_a_of_type_Boolean)
    {
      this.a.a.g.setImageResource(2130842451);
      ReadInJoyCommentComponentFragment.b(this.a.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.8.1
 * JD-Core Version:    0.7.0.1
 */