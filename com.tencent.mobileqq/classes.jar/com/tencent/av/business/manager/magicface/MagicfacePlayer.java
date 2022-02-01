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
        return;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder = new MagicfaceNormalDecoder();
      AVLog.printErrorLog("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playMagicface, srcPath[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("AVMagicfacePlayer", 1, localStringBuilder.toString());
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("audio");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramMagicfaceData.a.src);
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
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
    SoundPoolUtil localSoundPoolUtil = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
    if (localSoundPoolUtil != null) {
      localSoundPoolUtil.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("playSound soundSrc = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", loop = ");
    ((StringBuilder)localObject).append(paramInt);
    AVLog.printColorLog("AVMagicfacePlayer", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
    if (localObject != null) {
      ((SoundPoolUtil)localObject).a(paramString, paramInt, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfacePlayer
 * JD-Core Version:    0.7.0.1
 */