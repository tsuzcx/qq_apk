package com.tencent.av.business.manager.magicface;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MagicfacePlayer
{
  MagicfaceBaseDecoder.MagicPlayListener jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener;
  MagicfaceBaseDecoder.MagicfaceRenderListener jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener;
  private MagicfaceBaseDecoder jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder;
  MagicfaceData jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData;
  private SoundPoolUtil jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
  String jdField_a_of_type_JavaLangString;
  MagicfaceBaseDecoder.MagicPlayListener jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener;
  String jdField_b_of_type_JavaLangString;
  MagicfaceBaseDecoder.MagicPlayListener c = new MagicfacePlayer.1(this);
  
  public MagicfacePlayer()
  {
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder == null)
    {
      if (DeviceInfoUtil.d())
      {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder = new MagicfaceNormalDecoder();
        AVLog.printErrorLog("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder = new MagicfaceNormalDecoder();
    AVLog.printErrorLog("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(long paramLong, String paramString, MagicfaceData paramMagicfaceData, MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener, MagicfaceBaseDecoder.MagicPlayListener paramMagicPlayListener)
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.a) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData = paramMagicfaceData;
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener = paramMagicfaceRenderListener;
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener = paramMagicPlayListener;
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.b();
        return;
      }
      finally {}
    }
    QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + paramString + "], seq[" + paramLong + "]");
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramMagicfaceData.a.src);
      this.jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener = paramMagicPlayListener;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData = null;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener = null;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener = null;
      if ((paramMagicfaceData.a.src != null) && (!paramMagicfaceData.a.src.equals("")) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil == null)) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = new SoundPoolUtil();
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.a(paramString);
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.a(paramMagicfaceData);
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.a(paramMagicfaceRenderListener);
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.a(this.c);
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.a();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    AVLog.printColorLog("AVMagicfacePlayer", "playSound soundSrc = " + paramString + ", loop = " + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a(paramString, paramInt, 0);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.a;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData = null;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener = null;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener = null;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder.b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfacePlayer
 * JD-Core Version:    0.7.0.1
 */