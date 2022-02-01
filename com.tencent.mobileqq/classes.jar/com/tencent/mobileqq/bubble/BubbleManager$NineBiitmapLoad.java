package com.tencent.mobileqq.bubble;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.NinePatch;
import com.tencent.qphone.base.util.QLog;

class BubbleManager$NineBiitmapLoad
{
  private int b;
  private BubbleInfo c;
  private boolean d;
  private String e;
  private BitmapFactory.Options f;
  
  public BubbleManager$NineBiitmapLoad(BubbleManager paramBubbleManager, int paramInt, BubbleInfo paramBubbleInfo, boolean paramBoolean, String paramString, BitmapFactory.Options paramOptions)
  {
    this.b = paramInt;
    this.c = paramBubbleInfo;
    this.d = paramBoolean;
    this.e = paramString;
    this.f = paramOptions;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public NineBiitmapLoad c()
  {
    Object localObject2;
    Object localObject1;
    if (this.d)
    {
      localObject2 = BubbleManager.a(this.c.b, this.f);
      if (localObject2 != null)
      {
        localObject1 = ((Bitmap)localObject2).getNinePatchChunk();
        if ((localObject1 != null) && (NinePatch.isNinePatchChunk((byte[])localObject1)))
        {
          this.c.c = new NinePatch((Bitmap)localObject2, (byte[])localObject1, null);
        }
        else
        {
          this.d = false;
          this.e = "nor9pngErr";
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("createBubbleInfo, normal bg chunk null or not nine patch, chunk=");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(", bubbleId=");
          ((StringBuilder)localObject2).append(this.b);
          QLog.e("BubbleManager", 1, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        this.d = false;
        this.e = "norDecodeErr";
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("createBubbleInfo, decode normal bg null, bubbleId=");
        ((StringBuilder)localObject1).append(this.b);
        QLog.e("BubbleManager", 1, ((StringBuilder)localObject1).toString());
      }
    }
    if (this.d)
    {
      localObject2 = BubbleManager.a(this.c.d, this.f);
      if (localObject2 != null)
      {
        localObject1 = ((Bitmap)localObject2).getNinePatchChunk();
        if ((localObject1 != null) && (NinePatch.isNinePatchChunk((byte[])localObject1)))
        {
          this.c.e = new NinePatch((Bitmap)localObject2, (byte[])localObject1, null);
          return this;
        }
        this.d = false;
        this.e = "9pngErr";
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("createBubbleInfo, animation bg chunk null or not nine patch, chunk=");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(", bubbleId=");
        ((StringBuilder)localObject2).append(this.b);
        QLog.e("BubbleManager", 1, ((StringBuilder)localObject2).toString());
        return this;
      }
      this.d = false;
      this.e = "decodeErr";
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createBubbleInfo, decode animation bg null, bubbleId=");
      ((StringBuilder)localObject1).append(this.b);
      QLog.e("BubbleManager", 1, ((StringBuilder)localObject1).toString());
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager.NineBiitmapLoad
 * JD-Core Version:    0.7.0.1
 */