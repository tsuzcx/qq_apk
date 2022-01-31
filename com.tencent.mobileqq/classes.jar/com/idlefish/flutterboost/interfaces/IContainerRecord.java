package com.idlefish.flutterboost.interfaces;

public abstract interface IContainerRecord
  extends IOperateSyncer
{
  public static final int STATE_APPEAR = 2;
  public static final int STATE_CREATED = 1;
  public static final int STATE_DESTROYED = 4;
  public static final int STATE_DISAPPEAR = 3;
  public static final int STATE_UNKNOW = 0;
  public static final String UNIQ_KEY = "__container_uniqueId_key__";
  
  public abstract IFlutterViewContainer getContainer();
  
  public abstract int getState();
  
  public abstract String uniqueId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.idlefish.flutterboost.interfaces.IContainerRecord
 * JD-Core Version:    0.7.0.1
 */