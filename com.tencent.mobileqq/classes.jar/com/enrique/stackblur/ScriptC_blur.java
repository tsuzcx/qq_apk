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
    if (!paramAllocation.getType().getElement().isCompatible(this.__U32)) {
      throw new RSRuntimeException("Type mismatch with U32!");
    }
    forEach(2, paramAllocation, null, null, paramLaunchOptions);
  }
  
  public void forEach_blur_v(Allocation paramAllocation)
  {
    forEach_blur_v(paramAllocation, null);
  }
  
  public void forEach_blur_v(Allocation paramAllocation, Script.LaunchOptions paramLaunchOptions)
  {
    if (!paramAllocation.getType().getElement().isCompatible(this.__U32)) {
      throw new RSRuntimeException("Type mismatch with U32!");
    }
    forEach(1, paramAllocation, null, null, paramLaunchOptions);
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
  
  /* Error */
  public void set_height(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   6: ifnull +35 -> 41
    //   9: aload_0
    //   10: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   13: invokevirtual 155	android/support/v8/renderscript/FieldPacker:reset	()V
    //   16: aload_0
    //   17: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   20: lload_1
    //   21: invokevirtual 158	android/support/v8/renderscript/FieldPacker:addU32	(J)V
    //   24: aload_0
    //   25: iconst_2
    //   26: aload_0
    //   27: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   30: invokevirtual 161	com/enrique/stackblur/ScriptC_blur:setVar	(ILandroid/support/v8/renderscript/FieldPacker;)V
    //   33: aload_0
    //   34: lload_1
    //   35: putfield 134	com/enrique/stackblur/ScriptC_blur:mExportVar_height	J
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: new 151	android/support/v8/renderscript/FieldPacker
    //   45: dup
    //   46: iconst_4
    //   47: invokespecial 164	android/support/v8/renderscript/FieldPacker:<init>	(I)V
    //   50: putfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   53: goto -37 -> 16
    //   56: astore_3
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_3
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	ScriptC_blur
    //   0	61	1	paramLong	long
    //   56	4	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	16	56	finally
    //   16	38	56	finally
    //   41	53	56	finally
  }
  
  /* Error */
  public void set_radius(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   6: ifnull +35 -> 41
    //   9: aload_0
    //   10: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   13: invokevirtual 155	android/support/v8/renderscript/FieldPacker:reset	()V
    //   16: aload_0
    //   17: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   20: lload_1
    //   21: invokevirtual 158	android/support/v8/renderscript/FieldPacker:addU32	(J)V
    //   24: aload_0
    //   25: iconst_3
    //   26: aload_0
    //   27: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   30: invokevirtual 161	com/enrique/stackblur/ScriptC_blur:setVar	(ILandroid/support/v8/renderscript/FieldPacker;)V
    //   33: aload_0
    //   34: lload_1
    //   35: putfield 137	com/enrique/stackblur/ScriptC_blur:mExportVar_radius	J
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: new 151	android/support/v8/renderscript/FieldPacker
    //   45: dup
    //   46: iconst_4
    //   47: invokespecial 164	android/support/v8/renderscript/FieldPacker:<init>	(I)V
    //   50: putfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   53: goto -37 -> 16
    //   56: astore_3
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_3
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	ScriptC_blur
    //   0	61	1	paramLong	long
    //   56	4	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	16	56	finally
    //   16	38	56	finally
    //   41	53	56	finally
  }
  
  /* Error */
  public void set_width(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   6: ifnull +35 -> 41
    //   9: aload_0
    //   10: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   13: invokevirtual 155	android/support/v8/renderscript/FieldPacker:reset	()V
    //   16: aload_0
    //   17: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   20: lload_1
    //   21: invokevirtual 158	android/support/v8/renderscript/FieldPacker:addU32	(J)V
    //   24: aload_0
    //   25: iconst_1
    //   26: aload_0
    //   27: getfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   30: invokevirtual 161	com/enrique/stackblur/ScriptC_blur:setVar	(ILandroid/support/v8/renderscript/FieldPacker;)V
    //   33: aload_0
    //   34: lload_1
    //   35: putfield 140	com/enrique/stackblur/ScriptC_blur:mExportVar_width	J
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: new 151	android/support/v8/renderscript/FieldPacker
    //   45: dup
    //   46: iconst_4
    //   47: invokespecial 164	android/support/v8/renderscript/FieldPacker:<init>	(I)V
    //   50: putfield 149	com/enrique/stackblur/ScriptC_blur:__rs_fp_U32	Landroid/support/v8/renderscript/FieldPacker;
    //   53: goto -37 -> 16
    //   56: astore_3
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_3
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	ScriptC_blur
    //   0	61	1	paramLong	long
    //   56	4	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	16	56	finally
    //   16	38	56	finally
    //   41	53	56	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.enrique.stackblur.ScriptC_blur
 * JD-Core Version:    0.7.0.1
 */