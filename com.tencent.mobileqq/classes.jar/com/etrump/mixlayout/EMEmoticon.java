package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class EMEmoticon
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Bitmap a;
  private EMCollection jdField_a_of_type_ComEtrumpMixlayoutEMCollection;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  private int d;
  
  public EMEmoticon(ETEngine paramETEngine, int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = paramETEngine;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramInt1, paramString, paramInt2);
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutEMCollection = new EMCollection(this.jdField_a_of_type_ComEtrumpMixlayoutETEngine);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bitmap a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() < this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize())) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize(), Bitmap.Config.ARGB_8888);
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (paramInt >= 0) && (paramInt < this.c))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(0);
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_emoticonDrawFrame(this.jdField_a_of_type_Long, paramInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("EMEmoticon", 1, "drawFrame error: ", localException);
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramInt1, paramString, paramInt2);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(paramInt);
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_emoticonDeleteDescriptor(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComEtrumpMixlayoutEMCollection.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      this.d = this.jdField_a_of_type_ComEtrumpMixlayoutEMCollection.a(0);
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_emoticonCreateDescriptor(this.jdField_a_of_type_JavaLangString, this.d, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      bool1 = bool2;
      if (this.jdField_a_of_type_Long != 0L)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_emoticonGetWidth(this.jdField_a_of_type_Long);
        this.b = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_emoticonGetHeight(this.jdField_a_of_type_Long);
        this.c = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_emoticonGetFrameNum(this.jdField_a_of_type_Long);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    return false;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.EMEmoticon
 * JD-Core Version:    0.7.0.1
 */