package com.tencent.av.opengl.program;

import android.opengl.GLES20;
import com.tencent.av.opengl.utils.Utils;
import java.util.HashMap;
import java.util.Map;

public class TextureProgramFactory
{
  static Map<String, TextureProgram> a = new HashMap();
  
  public static TextureProgram a(int paramInt)
  {
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(Thread.currentThread().getId());
      str = ((StringBuilder)localObject1).toString();
      localObject1 = (TextureProgram)a.get(str);
      if (localObject1 != null) {
        break label213;
      }
      i = 1;
    }
    finally
    {
      label213:
      label218:
      label223:
      for (;;)
      {
        Object localObject1;
        String str;
        for (;;)
        {
          throw localObject2;
        }
        int i = 0;
        continue;
        int j = 0;
      }
    }
    j = i;
    if (i == 0)
    {
      GLES20.glUseProgram(((TextureProgram)localObject1).a());
      if (Utils.a() == 0) {
        break label218;
      }
      j = 1;
    }
    if (j != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6) {
                localObject1 = new TextureProgram();
              } else {
                localObject1 = new RGBToI420Program();
              }
            }
            else {
              localObject1 = new RGBToYUVProgrtam();
            }
          }
          else {
            localObject1 = new SharpenProgram();
          }
        }
        else {
          localObject1 = new YUVTextureAliasingProgram();
        }
      }
      else
      {
        localObject1 = new YUVTextureProgram();
        break label223;
        a.put(str, localObject1);
      }
    }
    else {
      return localObject1;
    }
  }
  
  public static void a()
  {
    try
    {
      a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.program.TextureProgramFactory
 * JD-Core Version:    0.7.0.1
 */