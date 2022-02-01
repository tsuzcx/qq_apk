package com.tencent.beacon.event.open;

public final class EventResult$a
{
  public static EventResult a(int paramInt)
  {
    switch (paramInt)
    {
    case 104: 
    default: 
      return null;
    case 106: 
      return new EventResult(paramInt, -1L, "event code isEmpty!");
    case 105: 
      return new EventResult(paramInt, -1L, "event params length > 45K!");
    case 103: 
      return new EventResult(paramInt, -1L, "insert event to db error!");
    case 102: 
      return new EventResult(paramInt, -1L, "event report not enable!");
    case 101: 
      return new EventResult(paramInt, -1L, "sampled by svr rate (false).");
    }
    return new EventResult(paramInt, -1L, "not allowed in strategy (false).");
  }
  
  public static EventResult a(long paramLong)
  {
    return new EventResult(0, paramLong, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.open.EventResult.a
 * JD-Core Version:    0.7.0.1
 */