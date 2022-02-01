package com.tencent.av.video.effect.utils;

import android.os.Environment;
import java.io.File;

public class StorageUtils
{
  public static String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
  public static String VIDEO_EFFECT_PATH = SDCARD_ROOT + "/VideoEffectSDK/";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.utils.StorageUtils
 * JD-Core Version:    0.7.0.1
 */