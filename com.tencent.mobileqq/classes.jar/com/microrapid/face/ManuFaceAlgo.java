package com.microrapid.face;

import com.tencent.filter.MRect;
import com.tencent.filter.QImage;

public class ManuFaceAlgo
{
  public static native long nativeEnalrgeEyeInit(QImage paramQImage);
  
  public static native void nativeEnalrgeEyeTouchEnd(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public static native boolean nativeHandleCanRedo(long paramLong);
  
  public static native boolean nativeHandleCanUndo(long paramLong);
  
  public static native void nativeHandleDispose(long paramLong);
  
  public static native boolean nativeHandleIsRawImage(long paramLong);
  
  public static native void nativeHandleRedoProcess(long paramLong);
  
  public static native void nativeHandleReset(long paramLong);
  
  public static native void nativeHandleUndoProcess(long paramLong);
  
  public static native long nativeLightEyeInit(QImage paramQImage);
  
  public static native void nativeLightEyeTouchEnd(long paramLong, QImage paramQImage, int paramInt, MRect paramMRect);
  
  public static native long nativeManualSmoothInit(QImage paramQImage);
  
  public static native void nativeManualSmoothTouchEnd(long paramLong, QImage paramQImage1, QImage paramQImage2, int paramInt, MRect paramMRect);
  
  public static native long nativeRepairMoleInit(QImage paramQImage);
  
  public static native void nativeRepairMoleTouchEnd(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public static native long nativeReshapeInit(QImage paramQImage);
  
  public static native void nativeReshapeTouchBegin(long paramLong);
  
  public static native void nativeReshapeTouchEnd(long paramLong);
  
  public static native void nativeReshapeTouchMove(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native long nativeSlimNoseInit(QImage paramQImage);
  
  public static native void nativeSlimNoseSetStrength(long paramLong, float paramFloat);
  
  public static native void nativeSlimNoseTouchEndAt(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSpringMorphGetRange(long paramLong, int[] paramArrayOfInt);
  
  public static native long nativeSpringMorphInit(QImage paramQImage);
  
  public static native void nativeSpringMorphSetMag(long paramLong, float paramFloat);
  
  public static native void nativeSpringMorphSetRange(long paramLong, int paramInt1, int paramInt2);
  
  public static native long nativeWhitenPouchInit(QImage paramQImage);
  
  public static native void nativeWhitenPouchTouchEnd(long paramLong, QImage paramQImage, int paramInt, MRect paramMRect);
  
  public static native long nativeWhitenToothInit(QImage paramQImage);
  
  public static native void nativeWhitenToothSetLipsRect(long paramLong, MRect paramMRect);
  
  public static native void nativeWhitenToothTouchEnd(long paramLong, QImage paramQImage, int paramInt, MRect paramMRect);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.face.ManuFaceAlgo
 * JD-Core Version:    0.7.0.1
 */