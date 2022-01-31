package com.tencent.map.core.interfaces;

import android.content.Context;

public abstract interface IMapFactory<M extends IMap, V extends IMapView, O extends IMapOptions>
{
  public abstract M build(Context paramContext, V paramV, O paramO);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.core.interfaces.IMapFactory
 * JD-Core Version:    0.7.0.1
 */