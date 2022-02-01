package com.enrique.stackblur;

import android.content.Context;
import android.content.res.Resources;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.FieldPacker;
import android.support.v8.renderscript.RSRuntimeException;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.Script.FieldID;
import android.support.v8.renderscript.Script.KernelID;
import android.support.v8.renderscript.Script.LaunchOptions;
import android.support.v8.renderscript.ScriptC;
import android.support.v8.renderscript.Type;

public class ScriptC_blur
  extends ScriptC
{
  private static final String __rs_resource_name = "blur";
  private static final int mExportForEachIdx_blur_h = 2;
  private static final int mExportForEachIdx_blur_v = 1;
  private static final int mExportVarIdx_gIn = 0;
  private static final int mExportVarIdx_height = 2;
  private static final int mExportVarIdx_radius = 3;
  private static final int mExportVarIdx_width = 1;
  private Element __ALLOCATION;
  private Element __U32;
  private FieldPacker __rs_fp_ALLOCATION;
  private FieldPacker __rs_fp_U32;
  private Allocation mExportVar_gIn;
  private long mExportVar_height;
  private long mExportVar_radius;
  private long mExportVar_width;
  
  public ScriptC_blur(RenderScript paramRenderScript)
  {
    this(paramRenderScript, paramRenderScript.getApplicationContext().getResources(), paramRenderScript.getApplicationContext().getResources().getIdentifier("blur", "raw", paramRenderScript.getApplicationContext().getPackageName()));
  }
  
  public ScriptC_blur(RenderScript paramRenderScript, Resources paramResources, int paramInt)
  {
    super(paramRenderScript, paramResources, paramInt);
    this.__ALLOCATION = Element.ALLOCATION(paramRenderScript);
    this.__U32 = Element.U32(paramRenderScript);
  }
  
  public void forEach_blur_h(Allocation paramAllocation)
  {
    forEach_blur_h(paramAllocation, null);
  }
  
  public void forEach_blur_h(Allocation paramAllocation, Script.LaunchOptions paramLaunchOptions)
  {
    if (paramAllocation.getType().getElement().isCompatible(this.__U32))
    {
      forEach(2, paramAllocation, null, null, paramLaunchOptions);
      return;
    }
    throw new RSRuntimeException("Type mismatch with U32!");
  }
  
  public void forEach_blur_v(Allocation paramAllocation)
  {
    forEach_blur_v(paramAllocation, null);
  }
  
  public void forEach_blur_v(Allocation paramAllocation, Script.LaunchOptions paramLaunchOptions)
  {
    if (paramAllocation.getType().getElement().isCompatible(this.__U32))
    {
      forEach(1, paramAllocation, null, null, paramLaunchOptions);
      return;
    }
    throw new RSRuntimeException("Type mismatch with U32!");
  }
  
  public Script.FieldID getFieldID_gIn()
  {
    return createFieldID(0, null);
  }
  
  public Script.FieldID getFieldID_height()
  {
    return createFieldID(2, null);
  }
  
  public Script.FieldID getFieldID_radius()
  {
    return createFieldID(3, null);
  }
  
  public Script.FieldID getFieldID_width()
  {
    return createFieldID(1, null);
  }
  
  public Script.KernelID getKernelID_blur_h()
  {
    return createKernelID(2, 33, null, null);
  }
  
  public Script.KernelID getKernelID_blur_v()
  {
    return createKernelID(1, 33, null, null);
  }
  
  public Allocation get_gIn()
  {
    return this.mExportVar_gIn;
  }
  
  public long get_height()
  {
    return this.mExportVar_height;
  }
  
  public long get_radius()
  {
    return this.mExportVar_radius;
  }
  
  public long get_width()
  {
    return this.mExportVar_width;
  }
  
  public void set_gIn(Allocation paramAllocation)
  {
    try
    {
      setVar(0, paramAllocation);
      this.mExportVar_gIn = paramAllocation;
      return;
    }
    finally
    {
      paramAllocation = finally;
      throw paramAllocation;
    }
  }
  
  public void set_height(long paramLong)
  {
    try
    {
      if (this.__rs_fp_U32 != null) {
        this.__rs_fp_U32.reset();
      } else {
        this.__rs_fp_U32 = new FieldPacker(4);
      }
      this.__rs_fp_U32.addU32(paramLong);
      setVar(2, this.__rs_fp_U32);
      this.mExportVar_height = paramLong;
      return;
    }
    finally {}
  }
  
  public void set_radius(long paramLong)
  {
    try
    {
      if (this.__rs_fp_U32 != null) {
        this.__rs_fp_U32.reset();
      } else {
        this.__rs_fp_U32 = new FieldPacker(4);
      }
      this.__rs_fp_U32.addU32(paramLong);
      setVar(3, this.__rs_fp_U32);
      this.mExportVar_radius = paramLong;
      return;
    }
    finally {}
  }
  
  public void set_width(long paramLong)
  {
    try
    {
      if (this.__rs_fp_U32 != null) {
        this.__rs_fp_U32.reset();
      } else {
        this.__rs_fp_U32 = new FieldPacker(4);
      }
      this.__rs_fp_U32.addU32(paramLong);
      setVar(1, this.__rs_fp_U32);
      this.mExportVar_width = paramLong;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.enrique.stackblur.ScriptC_blur
 * JD-Core Version:    0.7.0.1
 */