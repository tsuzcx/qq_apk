package com.tencent.mobileqq.app;

import android.util.SparseArray;

public enum UinType
{
  private static final SparseArray<UinType> S_ID_INSTANCE_MAP;
  private final int id;
  
  static
  {
    int i = 0;
    TEMP_GAME_MSG = new UinType.1("TEMP_GAME_MSG", 0, 10007);
    $VALUES = new UinType[] { TEMP_GAME_MSG };
    S_ID_INSTANCE_MAP = new SparseArray();
    UinType[] arrayOfUinType = values();
    int j = arrayOfUinType.length;
    while (i < j)
    {
      UinType localUinType = arrayOfUinType[i];
      S_ID_INSTANCE_MAP.put(localUinType.id, localUinType);
      i += 1;
    }
  }
  
  private UinType(int paramInt)
  {
    this.id = paramInt;
  }
  
  public static UinType valueOf(int paramInt)
  {
    return (UinType)S_ID_INSTANCE_MAP.get(paramInt);
  }
  
  public abstract boolean isC2CConversation();
  
  public abstract boolean isInvalidUinTypeWhenRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.UinType
 * JD-Core Version:    0.7.0.1
 */