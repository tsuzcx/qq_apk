package com.tencent.avgame.ui;

import com.tencent.avgame.adapter.DigitsProviderAdapter;
import java.util.ArrayList;

class AVGameJoinRoomFragment$3
  implements Runnable
{
  AVGameJoinRoomFragment$3(AVGameJoinRoomFragment paramAVGameJoinRoomFragment) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    this.this$0.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter.a(this.this$0.jdField_a_of_type_JavaUtilArrayList);
    this.this$0.jdField_a_of_type_ComTencentAvgameAdapterDigitsProviderAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameJoinRoomFragment.3
 * JD-Core Version:    0.7.0.1
 */