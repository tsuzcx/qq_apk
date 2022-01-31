package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class MultiVideoCtrlLayerUIBase$6
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$6(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, Pair paramPair, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (this.jdField_a_of_type_ComTencentUtilPair.second == null)) {
      return;
    }
    ArrayList localArrayList = this.this$0.a.a(((Integer)this.jdField_a_of_type_ComTencentUtilPair.first).intValue(), (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.second);
    ThreadManager.getUIHandler().post(new MultiVideoCtrlLayerUIBase.6.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.6
 * JD-Core Version:    0.7.0.1
 */