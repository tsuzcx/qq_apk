package com.tencent.aekit.api.standard.filter;

public abstract interface AEFilterManager$MaterialInnerEffectListener
{
  public static final int LUT_IN_LIGHT_NODE = 1001;
  public static final int LUT_IN_MATERIAL = 1000;
  public static final int MESH_IN_LIGHT_NODE = 2001;
  public static final int MESH_IN_MATERIAL = 2000;
  
  public abstract void notifyEnableLutType(int paramInt);
  
  public abstract void notifyEnableMeshType(int paramInt);
  
  public abstract void onDeviceNotSupportMaterial();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener
 * JD-Core Version:    0.7.0.1
 */