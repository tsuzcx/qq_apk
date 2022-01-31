package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class MultiVideoCtrlLayerUIBase$5
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$5(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, Pair paramPair, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (this.jdField_a_of_type_ComTencentUtilPair.second == null)) {
      return;
    }
    ArrayList localArrayList = this.this$0.a.a(((Integer)this.jdField_a_of_type_ComTencentUtilPair.first).intValue(), (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.second);
    ThreadManager.getUIHandler().post(new MultiVideoCtrlLayerUIBase.5.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.5
 * JD-Core Version:    0.7.0.1
 */