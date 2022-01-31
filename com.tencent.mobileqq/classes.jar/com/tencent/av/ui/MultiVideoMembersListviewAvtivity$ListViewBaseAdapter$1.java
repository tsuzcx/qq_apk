package com.tencent.av.ui;

import android.os.Handler;
import android.widget.ImageView;
import com.tencent.av.app.VideoAppInterface;
import kth;
import lwd;
import lwe;

public class MultiVideoMembersListviewAvtivity$ListViewBaseAdapter$1
  implements Runnable
{
  public MultiVideoMembersListviewAvtivity$ListViewBaseAdapter$1(lwd paramlwd, lwe paramlwe, kth paramkth) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Lwe.jdField_a_of_type_Long == this.jdField_a_of_type_Kth.jdField_a_of_type_Long) && (this.jdField_a_of_type_Kth.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      this.jdField_a_of_type_Kth.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Lwd.a(String.valueOf(this.jdField_a_of_type_Kth.jdField_a_of_type_Long));
      if (this.jdField_a_of_type_Kth.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label104;
      }
      if (this.jdField_a_of_type_Lwd.a.a != null) {
        this.jdField_a_of_type_Lwd.a.a.a().postDelayed(new MultiVideoMembersListviewAvtivity.ListViewBaseAdapter.1.1(this), 1000L);
      }
    }
    return;
    label104:
    this.jdField_a_of_type_Lwe.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Kth.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoMembersListviewAvtivity.ListViewBaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */