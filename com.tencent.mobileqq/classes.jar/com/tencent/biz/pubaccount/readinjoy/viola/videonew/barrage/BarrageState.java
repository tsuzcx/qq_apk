package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageState;", "", "(Ljava/lang/String;I)V", "IDLE", "PLAYING", "PAUSE", "STOPED", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum BarrageState
{
  static
  {
    BarrageState localBarrageState1 = new BarrageState("IDLE", 0);
    IDLE = localBarrageState1;
    BarrageState localBarrageState2 = new BarrageState("PLAYING", 1);
    PLAYING = localBarrageState2;
    BarrageState localBarrageState3 = new BarrageState("PAUSE", 2);
    PAUSE = localBarrageState3;
    BarrageState localBarrageState4 = new BarrageState("STOPED", 3);
    STOPED = localBarrageState4;
    $VALUES = new BarrageState[] { localBarrageState1, localBarrageState2, localBarrageState3, localBarrageState4 };
  }
  
  private BarrageState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageState
 * JD-Core Version:    0.7.0.1
 */