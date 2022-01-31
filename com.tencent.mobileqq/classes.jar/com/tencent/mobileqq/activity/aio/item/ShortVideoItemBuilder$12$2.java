package com.tencent.mobileqq.activity.aio.item;

import adzf;
import adzi;
import adzp;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class ShortVideoItemBuilder$12$2
  implements Runnable
{
  public ShortVideoItemBuilder$12$2(adzi paramadzi, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    adzp localadzp = adzf.a(this.jdField_a_of_type_Adzi.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    if (localadzp != null)
    {
      localadzp.a.setVisibility(8);
      localadzp.d.setVisibility(8);
      adzf.a(this.jdField_a_of_type_Adzi.a, localadzp, 2131718790);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.12.2
 * JD-Core Version:    0.7.0.1
 */