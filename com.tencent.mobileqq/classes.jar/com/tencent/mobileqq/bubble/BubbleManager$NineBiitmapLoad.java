package com.tencent.mobileqq.bubble;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.NinePatch;
import com.tencent.qphone.base.util.QLog;

class BubbleManager$NineBiitmapLoad
{
  private int jdField_a_of_type_Int;
  private BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options;
  private BubbleInfo jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public BubbleManager$NineBiitmapLoad(BubbleManager paramBubbleManager, int paramInt, BubbleInfo paramBubbleInfo, boolean paramBoolean, String paramString, BitmapFactory.Options paramOptions)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = paramBubbleInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = paramOptions;
  }
  
  public NineBiitmapLoad a()
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = BubbleManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      if (localObject2 != null)
      {
        localObject1 = ((Bitmap)localObject2).getNinePatchChunk();
        if ((localObject1 != null) && (NinePatch.isNinePatchChunk((byte[])localObject1)))
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject2, (byte[])localObject1, null);
        }
        else
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_JavaLangString = "nor9pngErr";
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("createBubbleInfo, normal bg chunk null or not nine patch, chunk=");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(", bubbleId=");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
          QLog.e("BubbleManager", 1, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangString = "norDecodeErr";
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("createBubbleInfo, decode normal bg null, bubbleId=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        QLog.e("BubbleManager", 1, ((StringBuilder)localObject1).toString());
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = BubbleManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      if (localObject2 != null)
      {
        localObject1 = ((Bitmap)localObject2).getNinePatchChunk();
        if ((localObject1 != null) && (NinePatch.isNinePatchChunk((byte[])localObject1)))
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_b_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject2, (byte[])localObject1, null);
          return this;
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangString = "9pngErr";
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("createBubbleInfo, animation bg chunk null or not nine patch, chunk=");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(", bubbleId=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        QLog.e("BubbleManager", 1, ((StringBuilder)localObject2).toString());
        return this;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = "decodeErr";
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createBubbleInfo, decode animation bg null, bubbleId=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      QLog.e("BubbleManager", 1, ((StringBuilder)localObject1).toString());
    }
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager.NineBiitmapLoad
 * JD-Core Version:    0.7.0.1
 */