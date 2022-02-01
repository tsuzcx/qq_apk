package com.tencent.av.business.manager.magicface;

import com.tencent.av.AVLog;
import com.tencent.qphone.base.util.QLog;

class MagicfacePlayer$1
  implements MagicfaceBaseDecoder.MagicPlayListener
{
  MagicfacePlayer$1(MagicfacePlayer paramMagicfacePlayer) {}
  
  public void a(long paramLong, String paramString)
  {
    AVLog.printColorLog("AVMagicfacePlayer", "play video begin." + paramString);
    if (this.a.jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener != null) {
      this.a.jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener.a(paramLong, paramString);
    }
  }
  
  public void a(long paramLong, String arg3, int paramInt)
  {
    QLog.w("AVMagicfacePlayer", 1, "onEndMagicPlay, id[" + ??? + "], reason[" + paramInt + "], seq[" + paramLong + "]");
    if (this.a.jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener != null) {
      this.a.jdField_b_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener.a(paramLong, ???, paramInt);
    }
    synchronized (this.a)
    {
      if ((this.a.jdField_b_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData != null)) {
        this.a.a(paramLong, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData, this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener, this.a.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceBaseDecoder$MagicPlayListener);
      }
      return;
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    AVLog.printColorLog("AVMagicfacePlayer", "play audio begin. id = " + paramString + ", repeat = " + paramBoolean);
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString, 100);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_JavaLangString, 1);
  }
  
  public void b(long paramLong, String paramString)
  {
    AVLog.printColorLog("AVMagicfacePlayer", "play audio end. id = " + paramString);
    this.a.a(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfacePlayer.1
 * JD-Core Version:    0.7.0.1
 */