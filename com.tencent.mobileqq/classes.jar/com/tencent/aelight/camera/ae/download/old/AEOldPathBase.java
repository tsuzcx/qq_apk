package com.tencent.aelight.camera.ae.download.old;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class AEOldPathBase
{
  protected static final String a = BaseApplicationImpl.getContext().getCacheDir().getPath();
  protected static final String b;
  protected static final String c = BaseApplicationImpl.getContext().getFilesDir().getParent();
  
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
      return;
    }
    b = BaseApplicationImpl.getContext().getFilesDir().getPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.old.AEOldPathBase
 * JD-Core Version:    0.7.0.1
 */