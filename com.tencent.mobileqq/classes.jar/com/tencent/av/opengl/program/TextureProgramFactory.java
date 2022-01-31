package com.tencent.av.opengl.program;

import android.opengl.GLES20;
import com.tencent.av.opengl.utils.Utils;
import java.util.HashMap;
import java.util.Map;

public class TextureProgramFactory
{
  static Map a = new HashMap();
  
  public static TextureProgram a(int paramInt)
  {
    int j = 1;
    for (;;)
    {
      int i;
      try
      {
        String str = paramInt + "_" + Thread.currentThread().getId();
        localObject1 = (TextureProgram)a.get(str);
        if (localObject1 == null)
        {
          i = 1;
          if (i != 0) {
            break label162;
          }
          GLES20.glUseProgram(((TextureProgram)localObject1).a());
          if (Utils.a() != 0)
          {
            i = j;
            break label162;
            localObject1 = new TextureProgram();
            a.put(str, localObject1);
            return localObject1;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        i = 0;
      }
      finally {}
      Object localObject1 = new YUVTextureProgram();
      continue;
      Object localObject3 = new YUVTextureAliasingProgram();
      continue;
      localObject3 = new SharpenProgram();
      continue;
      localObject3 = new RGBToYUVProgrtam();
      continue;
      label162:
      if (i != 0) {
        switch (paramInt)
        {
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.program.TextureProgramFactory
 * JD-Core Version:    0.7.0.1
 */