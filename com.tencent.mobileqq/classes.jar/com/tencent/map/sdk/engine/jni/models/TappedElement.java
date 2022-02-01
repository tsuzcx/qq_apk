package com.tencent.map.sdk.engine.jni.models;

import com.tencent.map.sdk.a.pa;

public class TappedElement
{
  private static final int BUILDING_ID_LENGTH = 128;
  private static final int BUILDING_NAME_LENGTH = 68;
  private static final int FLOOR_NAME_LENGTH = 32;
  public static final int TYPE_ANNO = 1;
  public static final int TYPE_ANNO_INDOOR_MAP = 1;
  public static final int TYPE_BLOCKROUTE_ANNO = 7;
  public static final int TYPE_COMPASS = 3;
  public static final int TYPE_INDOORMAP_AREA = 8;
  public static final int TYPE_LINE = 5;
  public static final int TYPE_LOCATION_MARKER = 6;
  public static final int TYPE_NONE = 0;
  public String buildingId;
  public String buildingName;
  public String floorName;
  public long itemId;
  public int itemType;
  public String name;
  public int nameLen;
  public int pixelX;
  public int pixelY;
  public int type;
  
  public static TappedElement fromBytes(byte[] paramArrayOfByte)
  {
    TappedElement localTappedElement = new TappedElement();
    byte[] arrayOfByte1 = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 4);
    localTappedElement.type = pa.a(arrayOfByte1);
    System.arraycopy(paramArrayOfByte, 4, arrayOfByte1, 0, 4);
    localTappedElement.pixelX = pa.a(arrayOfByte1);
    System.arraycopy(paramArrayOfByte, 8, arrayOfByte1, 0, 4);
    localTappedElement.pixelY = pa.a(arrayOfByte1);
    System.arraycopy(paramArrayOfByte, 12, arrayOfByte1, 0, 4);
    localTappedElement.itemType = pa.a(arrayOfByte1);
    System.arraycopy(paramArrayOfByte, 16, arrayOfByte1, 0, 4);
    localTappedElement.nameLen = pa.a(arrayOfByte1);
    int j = localTappedElement.type;
    int i = 20;
    if (j != 7)
    {
      byte[] arrayOfByte2 = new byte[64];
      System.arraycopy(paramArrayOfByte, 20, arrayOfByte2, 0, 64);
      i = 84;
      if (localTappedElement.type != 8) {
        localTappedElement.name = pa.b(arrayOfByte2);
      } else {
        localTappedElement.name = pa.a(arrayOfByte2, "UTF-8");
      }
    }
    System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 4);
    j = pa.a(arrayOfByte1);
    i += 4;
    System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 4);
    int k = pa.a(arrayOfByte1);
    localTappedElement.itemId = ((j << 32) + k);
    i += 4;
    if (localTappedElement.itemType == 1)
    {
      arrayOfByte1 = new byte[''];
      System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 128);
      i += 128;
      localTappedElement.buildingId = pa.a(arrayOfByte1, "UTF-8");
      arrayOfByte1 = new byte[68];
      System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 68);
      localTappedElement.buildingName = pa.b(arrayOfByte1);
      arrayOfByte1 = new byte[32];
      System.arraycopy(paramArrayOfByte, i + 68, arrayOfByte1, 0, 32);
      localTappedElement.floorName = pa.a(arrayOfByte1, "UTF-8");
    }
    return localTappedElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.engine.jni.models.TappedElement
 * JD-Core Version:    0.7.0.1
 */