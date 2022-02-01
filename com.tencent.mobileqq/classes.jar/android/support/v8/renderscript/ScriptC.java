package android.support.v8.renderscript;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ScriptC
  extends Script
{
  private static final String TAG = "ScriptC";
  
  protected ScriptC(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  protected ScriptC(RenderScript paramRenderScript, Resources paramResources, int paramInt)
  {
    super(0, paramRenderScript);
    if (RenderScript.isNative)
    {
      this.mT = new ScriptCThunker((RenderScriptThunker)paramRenderScript, paramResources, paramInt);
      return;
    }
    paramInt = internalCreate(paramRenderScript, paramResources, paramInt);
    if (paramInt != 0)
    {
      setID(paramInt);
      return;
    }
    throw new RSRuntimeException("Loading of ScriptC script failed.");
  }
  
  private static int internalCreate(RenderScript paramRenderScript, Resources paramResources, int paramInt)
  {
    for (;;)
    {
      try
      {
        InputStream localInputStream = paramResources.openRawResource(paramInt);
        try
        {
          localObject1 = new byte[1024];
          i = 0;
          int k = localObject1.length - i;
          localObject2 = localObject1;
          j = k;
          if (k == 0)
          {
            localObject2 = new byte[localObject1.length * 2];
            System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
            j = localObject2.length - i;
          }
          j = localInputStream.read((byte[])localObject2, i, j);
          if (j > 0) {}
        }
        finally
        {
          Object localObject1;
          int i;
          Object localObject2;
          int j;
          localInputStream.close();
        }
      }
      finally
      {
        continue;
        throw paramRenderScript;
        continue;
      }
      try
      {
        localInputStream.close();
        paramInt = paramRenderScript.nScriptCCreate(paramResources.getResourceEntryName(paramInt), paramRenderScript.getApplicationContext().getCacheDir().toString(), (byte[])localObject2, i);
        return paramInt;
      }
      catch (IOException paramRenderScript)
      {
        continue;
      }
      i += j;
      localObject1 = localObject2;
    }
    throw new Resources.NotFoundException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptC
 * JD-Core Version:    0.7.0.1
 */