package com.tencent.av.redpacket;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class SoundPoolHelper$1
  implements SoundPool.OnLoadCompleteListener
{
  SoundPoolHelper$1(SoundPoolHelper paramSoundPoolHelper, SoundPoolHelper.OnLoadFinishListener paramOnLoadFinishListener) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    paramSoundPool = this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper;
    paramSoundPool.c += 1;
    if (QLog.isColorLevel()) {
      QLog.d("SoundPoolHelper", 2, "loadMusic onLoadComplete,sampleId = " + paramInt1 + ",status = " + paramInt2 + ",loadedCount = " + this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.c + ",musicCount = " + this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.b);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.a.add(Integer.valueOf(paramInt1));
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.c == this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper.b) {
      this.jdField_a_of_type_ComTencentAvRedpacketSoundPoolHelper$OnLoadFinishListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.SoundPoolHelper.1
 * JD-Core Version:    0.7.0.1
 */