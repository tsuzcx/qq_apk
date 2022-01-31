package com.tencent.mobileqq.activity.aio.item;

import afvt;
import afvw;
import afwd;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$12$2
  implements Runnable
{
  public ShortVideoItemBuilder$12$2(afvw paramafvw, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    afwd localafwd = afvt.a(this.jdField_a_of_type_Afvw.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    if (localafwd != null)
    {
      localafwd.a.setVisibility(8);
      localafwd.d.setVisibility(8);
      afvt.a(this.jdField_a_of_type_Afvw.a, localafwd, 2131719264);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.12.2
 * JD-Core Version:    0.7.0.1
 */