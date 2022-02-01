package com.tencent.featuretoggle.utils;

import android.content.Context;
import com.getkeepsafe.relinker.ReLinker;
import com.tencent.mmkv.MMKV.LibLoader;

class PreferenceUtil$1
  implements MMKV.LibLoader
{
  PreferenceUtil$1(PreferenceUtil paramPreferenceUtil, Context paramContext) {}
  
  public void loadLibrary(String paramString)
  {
    ReLinker.a(this.jdField_a_of_type_AndroidContentContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.PreferenceUtil.1
 * JD-Core Version:    0.7.0.1
 */