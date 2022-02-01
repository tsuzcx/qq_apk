package android.support.v8.renderscript;

public class BaseObj
{
  private boolean mDestroyed;
  private int mID;
  RenderScript mRS;
  
  BaseObj(int paramInt, RenderScript paramRenderScript)
  {
    paramRenderScript.validate();
    this.mRS = paramRenderScript;
    this.mID = paramInt;
    this.mDestroyed = false;
  }
  
  void checkValid()
  {
    if (this.mID == 0)
    {
      if (getNObj() != null) {
        return;
      }
      throw new RSIllegalArgumentException("Invalid object.");
    }
  }
  
  public void destroy()
  {
    try
    {
      if (!this.mDestroyed)
      {
        this.mDestroyed = true;
        this.mRS.nObjDestroy(this.mID);
        return;
      }
      throw new RSInvalidStateException("Object already destroyed.");
    }
    finally {}
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (BaseObj)paramObject;
    return this.mID == paramObject.mID;
  }
  
  protected void finalize()
  {
    if (!this.mDestroyed)
    {
      if ((this.mID != 0) && (this.mRS.isAlive())) {
        this.mRS.nObjDestroy(this.mID);
      }
      this.mRS = null;
      this.mID = 0;
      this.mDestroyed = true;
    }
    super.finalize();
  }
  
  int getID(RenderScript paramRenderScript)
  {
    this.mRS.validate();
    if (RenderScript.isNative)
    {
      RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
      if (getNObj() != null) {
        return getNObj().hashCode();
      }
    }
    if (!this.mDestroyed)
    {
      if (this.mID != 0)
      {
        if ((paramRenderScript != null) && (paramRenderScript != this.mRS)) {
          throw new RSInvalidStateException("using object with mismatched context.");
        }
        return this.mID;
      }
      throw new RSRuntimeException("Internal error: Object id 0.");
    }
    throw new RSInvalidStateException("using a destroyed object.");
  }
  
  android.renderscript.BaseObj getNObj()
  {
    return null;
  }
  
  public int hashCode()
  {
    return this.mID;
  }
  
  void setID(int paramInt)
  {
    if (this.mID == 0)
    {
      this.mID = paramInt;
      return;
    }
    throw new RSRuntimeException("Internal Error, reset of object ID.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.BaseObj
 * JD-Core Version:    0.7.0.1
 */