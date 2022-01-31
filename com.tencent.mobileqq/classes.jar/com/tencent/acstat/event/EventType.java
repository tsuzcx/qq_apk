package com.tencent.acstat.event;

public enum EventType
{
  private int a;
  
  static
  {
    ERROR = new EventType("ERROR", 2, 3);
    BACKGROUND = new EventType("BACKGROUND", 3, 4);
    CUSTOM = new EventType("CUSTOM", 4, 1000);
    ADDITION = new EventType("ADDITION", 5, 1001);
    MONITOR_STAT = new EventType("MONITOR_STAT", 6, 1002);
    MTA_GAME_USER = new EventType("MTA_GAME_USER", 7, 1003);
    NETWORK_MONITOR = new EventType("NETWORK_MONITOR", 8, 1004);
  }
  
  private EventType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final int a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.acstat.event.EventType
 * JD-Core Version:    0.7.0.1
 */