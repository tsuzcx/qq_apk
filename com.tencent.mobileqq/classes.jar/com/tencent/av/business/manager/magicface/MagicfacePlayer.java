package com.tencent.av.business.manager.magicface;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.File;
import jgm;

public class MagicfacePlayer
{
  public MagicfaceBaseDecoder.MagicPlayListener a;
  public MagicfaceBaseDecoder.MagicfaceRenderListener a;
  private MagicfaceBaseDecoder jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder;
  public MagicfaceData a;
  private SoundPoolUtil jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
  public String a;
  public MagicfaceBaseDecoder.MagicPlayListener b;
  public String b;
  MagicfaceBaseDecoder.MagicPlayListener c = new jgm(this);
  
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
        AVLog.e("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder = new MagicfaceNormalDecoder();
    AVLog.e("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a(paramString, paramInt, 0);
    }
  }
  
  public void a(String paramString, MagicfaceData paramMagicfaceData, MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener, MagicfaceBaseDecoder.MagicPlayListener paramMagicPlayListener)
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
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramMagicfaceData.a.src);
      this.jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener = paramMagicPlayListener;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData = null;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener = null;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener = null;
      if ((paramMagicfaceData.a.src != null) && (!paramMagicfaceData.a.src.equals(""))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfacePlayer
 * JD-Core Version:    0.7.0.1
 */