package com.tencent.mobileqq.activity.aio.audiopanel;

import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;

class RecordSoundPanel$5
  implements Runnable
{
  RecordSoundPanel$5(RecordSoundPanel paramRecordSoundPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    this.this$0.a(this.jdField_a_of_type_Int);
    this.this$0.b.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.jdField_a_of_type_Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel.5
 * JD-Core Version:    0.7.0.1
 */