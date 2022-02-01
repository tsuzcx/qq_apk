package com.tencent.component.media.image;

import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class ProgressTracer
{
  public static final int CANCEL = 1003;
  public static final int DECODE_FAIL = 1002;
  public static final int DOWNLOAD_FAIL = 1001;
  public static final int END = 5;
  public static final int END_CALLBACK_UI = 6;
  public static final int END_DECODE = 4;
  public static final int END_DOWNLOAD = 2;
  public static final int END_SUPER_RESOLUTION = 9;
  public static final int PUT_SUPER_RESOLUTION = 7;
  public static final String SEPARATOR = " : ";
  public static final int START = 0;
  public static final int START_DECODE = 3;
  public static final int START_DOWNLOAD = 1;
  public static final int START_SUPER_RESOLUTION = 8;
  public static final String TAG = "IProgress";
  
  public static void print(int paramInt, String paramString)
  {
    if (ImageManagerEnv.g().openProgressTracer())
    {
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            ImageManagerEnv.getLogger().e("IProgress", new Object[] { Long.valueOf(System.currentTimeMillis()), " : ", Integer.valueOf(paramInt), "error function call, please check" });
            return;
          case 1003: 
            ImageManagerEnv.getLogger().w("IProgress", new Object[] { Long.valueOf(System.currentTimeMillis()), " : ", Integer.valueOf(paramInt), " : ", paramString });
            return;
          }
          ImageManagerEnv.getLogger().e("IProgress", new Object[] { Long.valueOf(System.currentTimeMillis()), " : ", Integer.valueOf(paramInt), " : ", paramString });
          return;
        }
      }
      ImageManagerEnv.getLogger().i("IProgress", new Object[] { Long.valueOf(System.currentTimeMillis()), " : ", Integer.valueOf(paramInt), " : ", paramString });
    }
  }
  
  public static void printI(Object... paramVarArgs)
  {
    if (ImageManagerEnv.g().openProgressTracer()) {
      ImageManagerEnv.getLogger().i("IProgress", paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ProgressTracer
 * JD-Core Version:    0.7.0.1
 */