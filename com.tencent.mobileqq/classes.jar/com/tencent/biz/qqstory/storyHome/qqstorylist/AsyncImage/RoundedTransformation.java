package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StringAppendTool;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Map;

public class RoundedTransformation
  implements Transformation
{
  private float jdField_a_of_type_Float = 1.0F;
  protected final int a;
  public Bitmap a;
  private String jdField_a_of_type_JavaLangString;
  public Map<String, Bitmap> a;
  protected final int b;
  
  public RoundedTransformation(int paramInt1, int paramInt2, float paramFloat, Map<String, Bitmap> paramMap, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_JavaLangString = StringAppendTool.a(new Object[] { "rounded", "r=", Integer.valueOf(paramInt1), "dm=", Integer.valueOf(paramInt2), "ds=", Float.valueOf(paramFloat) });
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    for (;;)
    {
      try
      {
        float f1 = paramBitmap.getWidth();
        float f2 = paramBitmap.getHeight();
        float f3 = f2 / f1;
        int n = (int)f2;
        int i = (int)f1;
        int j;
        int m;
        int k;
        if (f3 > this.jdField_a_of_type_Float)
        {
          j = (int)(paramBitmap.getWidth() * this.jdField_a_of_type_Float);
          m = (paramBitmap.getHeight() - j) / 2;
          k = 0;
          n = j;
        }
        else
        {
          i = (int)(paramBitmap.getHeight() / this.jdField_a_of_type_Float);
          j = (paramBitmap.getWidth() - i) / 2;
          m = 0;
          k = j;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilMap;
        if (localObject1 != null)
        {
          localObject1 = this.jdField_a_of_type_JavaUtilMap;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RT:w=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("h=");
          ((StringBuilder)localObject2).append(n);
          localObject1 = (Bitmap)((Map)localObject1).get(((StringBuilder)localObject2).toString());
          if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
          {
            ((Bitmap)localObject1).eraseColor(0);
            StoryListUtils.a(paramBitmap, (Bitmap)localObject1, k, m, i, n, null, false);
          }
          else
          {
            paramBitmap = Bitmap.createBitmap(paramBitmap, k, m, i, n);
            localObject1 = paramBitmap;
            if (this.jdField_a_of_type_JavaUtilMap != null)
            {
              localObject1 = this.jdField_a_of_type_JavaUtilMap;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("RT:w=");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append("h=");
              ((StringBuilder)localObject2).append(n);
              ((Map)localObject1).put(((StringBuilder)localObject2).toString(), paramBitmap);
              localObject1 = paramBitmap;
            }
          }
          localObject2 = new Paint();
          ((Paint)localObject2).setAntiAlias(true);
          ((Paint)localObject2).setShader(new BitmapShader((Bitmap)localObject1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
          if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
            paramBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
          } else {
            paramBitmap = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
          }
          paramBitmap.eraseColor(0);
          new Canvas(paramBitmap).drawRoundRect(new RectF(this.b, this.b, ((Bitmap)localObject1).getWidth() - this.b, ((Bitmap)localObject1).getHeight() - this.b), this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, (Paint)localObject2);
          return paramBitmap;
        }
      }
      catch (Exception paramBitmap)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("occur error:");
        ((StringBuilder)localObject1).append(paramBitmap);
        SLog.e("RoundedTransformation", ((StringBuilder)localObject1).toString());
        return null;
      }
      Object localObject1 = null;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation
 * JD-Core Version:    0.7.0.1
 */