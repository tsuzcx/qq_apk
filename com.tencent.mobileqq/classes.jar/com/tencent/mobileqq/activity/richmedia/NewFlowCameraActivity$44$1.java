package com.tencent.mobileqq.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class NewFlowCameraActivity$44$1
  implements DialogInterface.OnClickListener
{
  NewFlowCameraActivity$44$1(NewFlowCameraActivity.44 param44) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.this$0.getIntent();
    paramDialogInterface.putExtra("flow_back", 0);
    this.a.this$0.setResult(1001, paramDialogInterface);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.44.1
 * JD-Core Version:    0.7.0.1
 */