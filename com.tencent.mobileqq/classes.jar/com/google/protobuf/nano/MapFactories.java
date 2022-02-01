package com.google.protobuf.nano;

public final class MapFactories
{
  private static volatile MapFactories.MapFactory mapFactory = new MapFactories.DefaultMapFactory(null);
  
  public static MapFactories.MapFactory getMapFactory()
  {
    return mapFactory;
  }
  
  static void setMapFactory(MapFactories.MapFactory paramMapFactory)
  {
    mapFactory = paramMapFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.MapFactories
 * JD-Core Version:    0.7.0.1
 */