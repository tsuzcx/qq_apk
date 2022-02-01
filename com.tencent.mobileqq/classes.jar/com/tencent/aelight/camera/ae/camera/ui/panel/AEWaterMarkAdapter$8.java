package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.log.AEQLog;

class AEWaterMarkAdapter$8
  implements Runnable
{
  AEWaterMarkAdapter$8(AEWaterMarkAdapter paramAEWaterMarkAdapter, int paramInt, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    int i = this.a;
    Object[] arrayOfObject;
    if (i == 114)
    {
      AEQLog.a("AEWaterMarkAdapter", "water mark notify SHOW_WATERMARK_EDITPICTURE");
      arrayOfObject = this.b;
      if ((arrayOfObject != null) && (arrayOfObject.length == 1)) {
        AEWaterMarkAdapter.a(this.this$0, true, arrayOfObject[0]);
      }
    }
    else if (i == 115)
    {
      AEQLog.a("AEWaterMarkAdapter", "water mark notify SHOW_WATERMARK_EDITPICTURE");
      arrayOfObject = this.b;
      if ((arrayOfObject != null) && (arrayOfObject.length == 1)) {
        AEWaterMarkAdapter.a(this.this$0, false, arrayOfObject[0]);
      }
    }
    else
    {
      if (i == 1025)
      {
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (i == 113) {
        this.this$0.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkAdapter.8
 * JD-Core Version:    0.7.0.1
 */