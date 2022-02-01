package com.tencent.aelight.camera.ae;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class AEPathBase
{
  protected static final String a;
  protected static final String b;
  protected static final String c = BaseApplicationImpl.getContext().getFilesDir().getParent();
  protected static final String d = BaseApplicationImpl.getContext().getCacheDir().getPath();
  protected static final String e;
  
  static
  {
    int i;
    if ((BaseApplicationImpl.getContext().getExternalFilesDir(null) != null) && (BaseApplicationImpl.getContext().getExternalCacheDir() != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      b = BaseApplicationImpl.getContext().getExternalFilesDir(null).getPath();
      a = BaseApplicationImpl.getContext().getExternalCacheDir().getPath();
    }
    else
    {
      b = BaseApplicationImpl.getContext().getFilesDir().getPath();
      a = BaseApplicationImpl.getContext().getCacheDir().getPath();
    }
    e = BaseApplicationImpl.getContext().getFilesDir().getPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPathBase
 * JD-Core Version:    0.7.0.1
 */