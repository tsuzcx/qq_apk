package com.tencent.av.ui;

import alpo;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

class PipeLinearLayout$1$2
  implements Runnable
{
  PipeLinearLayout$1$2(PipeLinearLayout.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (!PipeLinearLayout.a(this.jdField_a_of_type_ComTencentAvUiPipeLinearLayout$1.this$0))
    {
      int i = 0;
      while ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i < PipeLinearLayout.a(this.jdField_a_of_type_ComTencentAvUiPipeLinearLayout$1.this$0).length))
      {
        ImageView localImageView = (ImageView)this.jdField_a_of_type_ComTencentAvUiPipeLinearLayout$1.this$0.findViewById(PipeLinearLayout.a(this.jdField_a_of_type_ComTencentAvUiPipeLinearLayout$1.this$0)[i]);
        localImageView.setImageBitmap(PipeLinearLayout.a(this.jdField_a_of_type_ComTencentAvUiPipeLinearLayout$1.this$0, ((Long)PipeLinearLayout.a(this.jdField_a_of_type_ComTencentAvUiPipeLinearLayout$1.this$0).get(i)).longValue()));
        localImageView.setVisibility(0);
        i += 1;
      }
      ((TextView)this.jdField_a_of_type_ComTencentAvUiPipeLinearLayout$1.this$0.findViewById(2131370127)).setText(PipeLinearLayout.b(this.jdField_a_of_type_ComTencentAvUiPipeLinearLayout$1.this$0).size() + alpo.a(2131708561));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.PipeLinearLayout.1.2
 * JD-Core Version:    0.7.0.1
 */