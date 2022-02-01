package com.tencent.av.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MutiMemberThumbList$1$1
  implements Runnable
{
  MutiMemberThumbList$1$1(MutiMemberThumbList.1 param1, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (MutiMemberThumbList.b(this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0))
    {
      QLog.d("MutiMemberThumbList", 1, "doDisplay quit by destroyed in UI_Thread");
      return;
    }
    View localView = this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0.findViewById(2131364868);
    if (this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.a > 0)
    {
      localView.setVisibility(0);
      int i = 0;
      while (i < MutiMemberThumbList.a(this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0).length)
      {
        localView = this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0.findViewById(MutiMemberThumbList.a(this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0)[i]);
        ImageView localImageView = (ImageView)localView.findViewById(2131373409);
        TextView localTextView = (TextView)localView.findViewById(2131373411);
        localTextView.setVisibility(8);
        localImageView.setImageDrawable(null);
        if ((this.jdField_a_of_type_Boolean) && (i == MutiMemberThumbList.a(this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0).length - 1))
        {
          localTextView.setText(String.format("%d+", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.a - MutiMemberThumbList.a(this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0).length + 1) }));
          localTextView.setVisibility(0);
          ((ImageView)localView.findViewById(2131373409)).setImageDrawable(MutiMemberThumbList.a(this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0));
          localView.setVisibility(0);
          break;
        }
        if ((i < this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.a) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          localView.setVisibility(0);
        }
        else
        {
          localView.setVisibility(8);
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0.setVisibility(0);
      if (MutiMemberThumbList.a(this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0) != null) {
        MutiMemberThumbList.a(this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0).setVisibility(0);
      }
      return;
    }
    localView.setVisibility(4);
    this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList$1.this$0.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MutiMemberThumbList.1.1
 * JD-Core Version:    0.7.0.1
 */