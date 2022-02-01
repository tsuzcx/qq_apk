package com.tencent.avgame.qav.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class GuessPictureGamePaintLogic
{
  public int a;
  private GameImageData jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  public int b;
  private int c;
  private int d;
  
  public int a(ArrayList<GameImageData> paramArrayList)
  {
    boolean bool = false;
    Bitmap localBitmap;
    Canvas localCanvas;
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      if (((GameImageData)paramArrayList.get(0)).jdField_a_of_type_AndroidGraphicsBitmap == null) {
        return 0;
      }
      localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.b, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      a(localCanvas, (GameImageData)paramArrayList.get(0), true);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (QLog.isColorLevel())
        {
          if (this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData == null) {
            bool = true;
          }
          QLog.d("GuessPictureGamePaintLogic", 2, new Object[] { "generateTexture, AnswerImageDataIsNull:", Boolean.valueOf(bool) });
        }
        if (this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData == null) {
          break label207;
        }
        localCanvas.drawColor(this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData.e);
        b(localCanvas, this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData, true);
        continue;
        if (i < paramArrayList.size())
        {
          b(localCanvas, (GameImageData)paramArrayList.get(i), true);
          i += 1;
          continue;
        }
        i = GlUtil.createTexture(3553, localBitmap);
        localBitmap.recycle();
        return i;
      }
      return 0;
      label207:
      int i = 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_Int = paramInt3;
    this.b = paramInt4;
  }
  
  public void a(Canvas paramCanvas, GameImageData paramGameImageData, boolean paramBoolean)
  {
    paramGameImageData = paramGameImageData.jdField_a_of_type_AndroidGraphicsBitmap;
    Matrix localMatrix = new Matrix();
    localMatrix.setRectToRect(new RectF(0.0F, 0.0F, paramGameImageData.getWidth(), paramGameImageData.getHeight()), new RectF(0.0F, 0.0F, this.jdField_a_of_type_Int, this.b), Matrix.ScaleToFit.FILL);
    if (paramBoolean) {
      localMatrix.postScale(1.0F, -1.0F, this.jdField_a_of_type_Int / 2, this.b / 2);
    }
    if (!paramGameImageData.isRecycled()) {
      paramCanvas.drawBitmap(paramGameImageData, localMatrix, null);
    }
  }
  
  public void a(View arg1)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData != null) && (!this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData = null;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    ThreadManager.getUIHandler().postDelayed(new GuessPictureGamePaintLogic.1(this, paramView, paramInt, paramBoolean), 200L);
  }
  
  public boolean a()
  {
    GameImageData localGameImageData = this.jdField_a_of_type_ComTencentAvgameQavVideorecordGameImageData;
    return (localGameImageData != null) && (localGameImageData.jdField_a_of_type_Boolean);
  }
  
  public void b(Canvas paramCanvas, GameImageData paramGameImageData, boolean paramBoolean)
  {
    if (paramGameImageData.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    int i = paramGameImageData.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int j = paramGameImageData.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    float f1 = this.c / this.jdField_a_of_type_Int;
    float f2 = this.d / this.b;
    Matrix localMatrix = new Matrix();
    localMatrix.setRectToRect(new RectF(0.0F, 0.0F, i, j), new RectF(paramGameImageData.c / f1, paramGameImageData.d / f2, (paramGameImageData.c + i) / f1, (paramGameImageData.d + j) / f2), Matrix.ScaleToFit.CENTER);
    if (paramBoolean) {
      localMatrix.postScale(1.0F, -1.0F, this.jdField_a_of_type_Int / 2, this.b / 2);
    }
    if (!paramGameImageData.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
      paramCanvas.drawBitmap(paramGameImageData.jdField_a_of_type_AndroidGraphicsBitmap, localMatrix, null);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GuessPictureGamePaintLogic
 * JD-Core Version:    0.7.0.1
 */