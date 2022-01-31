package com.tencent.av.opengl.effects;

import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class EffectsRenderController$TempTime
{
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  long c;
  long d;
  long e;
  long f;
  private long g;
  private long h;
  private long i;
  
  public EffectsRenderController$TempTime(EffectsRenderController paramEffectsRenderController) {}
  
  void a()
  {
    this.jdField_b_of_type_Boolean = QLog.isDevelopLevel();
    this.h = AudioHelper.b();
  }
  
  void a(EffectsRenderController.CameraFrame paramCameraFrame, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.i = AudioHelper.b();
    if (this.jdField_b_of_type_Boolean) {
      QLog.d(EffectsRenderController.a + "|costtime", 4, String.format("realyProcessFrame, CameraFrame[%d], usePendant[%d], funoffset[%d], msgCost[%d], rendercost[%d], Beauty2[%d], preRender[%d], Beauty3[%d], Pendant[%d], FaceFeature[%d]", new Object[] { Long.valueOf(paramCameraFrame.c), Integer.valueOf(paramInt), Long.valueOf(this.h - this.g), Long.valueOf(this.h - paramCameraFrame.d), Long.valueOf(this.i - this.h), Long.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long), Long.valueOf(this.c - this.jdField_b_of_type_Long), Long.valueOf(this.d - this.c), Long.valueOf(this.e - this.d), Long.valueOf(this.f - this.e) }));
    }
    for (;;)
    {
      this.g = this.h;
      return;
      if (QLog.isColorLevel()) {
        QLog.d(EffectsRenderController.a + "|costtime", 2, String.format("realyProcessFrame, CameraFrame[%d], usePendant[%d], funoffset[%d], msgCost[%d], rendercost[%d]", new Object[] { Long.valueOf(paramCameraFrame.c), Integer.valueOf(paramInt), Long.valueOf(this.h - this.g), Long.valueOf(this.h - paramCameraFrame.d), Long.valueOf(this.i - this.h) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectsRenderController.TempTime
 * JD-Core Version:    0.7.0.1
 */