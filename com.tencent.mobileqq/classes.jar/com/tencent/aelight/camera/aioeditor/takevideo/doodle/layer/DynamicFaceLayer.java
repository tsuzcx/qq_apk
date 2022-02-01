package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterParcelData;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFaceConstant;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.WeatherStickerDrawable;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DoodleUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class DynamicFaceLayer
  extends FaceLayer
{
  private boolean t = false;
  
  public DynamicFaceLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public static String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".apng"))) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDynamicStaticPicPath|path= ");
      localStringBuilder.append(paramString);
      QLog.d("DynamicFaceLayer", 2, localStringBuilder.toString());
    }
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, i - 5));
    localStringBuilder.append(".bpng");
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("newPath= ");
      localStringBuilder.append(paramString);
      QLog.d("DynamicFaceLayer", 2, localStringBuilder.toString());
    }
    if (new File(paramString).exists()) {
      return paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DynamicFaceLayer", 2, "file not exist");
    }
    return null;
  }
  
  public static Drawable b(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    if (paramString == null) {
      return null;
    }
    String str;
    try
    {
      Bitmap localBitmap = BitmapUtils.a(paramString);
      if (localBitmap != null)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("bitmap= ");
          paramString.append(localBitmap.getWidth());
          paramString.append("*");
          paramString.append(localBitmap.getHeight());
          QLog.d("DynamicFaceLayer", 2, paramString.toString());
        }
        paramString = new BitmapDrawable(localBitmap);
        try
        {
          paramString.setBounds(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
          return paramString;
        }
        catch (OutOfMemoryError localOutOfMemoryError1) {}
      }
      else
      {
        Object localObject1 = localObject3;
        if (!QLog.isColorLevel()) {
          return localObject1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("bitmap is null path=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("DynamicFaceLayer", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject3;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      paramString = localObject2;
      localOutOfMemoryError2.printStackTrace();
      str = paramString;
    }
    return str;
  }
  
  public String a()
  {
    return "DynamicFaceLayer";
  }
  
  public String a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int m = this.z.c;
    int k = this.z.d;
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt1 > paramInt2)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramBoolean)
      {
        i = paramInt1;
        j = paramInt2;
      }
    }
    float f1 = this.z.c * 1.0F / this.z.d;
    float f2 = j * 1.0F / i;
    j = 0;
    i = 0;
    paramInt1 = m;
    paramInt2 = k;
    if (f2 != f1) {
      if (f1 > f2)
      {
        paramInt1 = this.z.c;
        paramInt2 = Math.round(this.z.c / f2);
        i = (paramInt2 - this.z.d) / 2;
      }
      else
      {
        paramInt1 = Math.round(this.z.d * f2);
        paramInt2 = this.z.d;
        i = (paramInt1 - this.z.c) / 2;
        break label194;
      }
    }
    k = 0;
    j = i;
    i = k;
    label194:
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("layerParams=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("*");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(",heightOffset=");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(",widthOffset=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("DynamicFaceLayer", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.z.h.c())
    {
      localObject1 = new ArrayList();
      Object localObject2 = this.b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject2).next();
        DynamicStickerData localDynamicStickerData = new DynamicStickerData();
        localDynamicStickerData.centerP = localFaceItem.A;
        localDynamicStickerData.scale = localFaceItem.B;
        localDynamicStickerData.rotate = localFaceItem.C;
        localDynamicStickerData.translateX = (localFaceItem.D + i);
        localDynamicStickerData.translateY = (localFaceItem.E + j);
        localDynamicStickerData.height = localFaceItem.H;
        localDynamicStickerData.width = localFaceItem.G;
        localDynamicStickerData.path = localFaceItem.p;
        localDynamicStickerData.type = localFaceItem.y;
        localDynamicStickerData.data = localFaceItem.w;
        localDynamicStickerData.layerWidth = paramInt1;
        localDynamicStickerData.layerHeight = paramInt2;
        ((ArrayList)localObject1).add(localDynamicStickerData);
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("generateDynamicStickers|size= ");
          ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
          QLog.d("DynamicFaceLayer", 2, ((StringBuilder)localObject2).toString());
        }
        return DoodleUtil.a((ArrayList)localObject1);
      }
    }
    return null;
  }
  
  public void a(Canvas paramCanvas, float paramFloat) {}
  
  public void a(ArrayList<PasterParcelData> paramArrayList, boolean paramBoolean, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      PasterParcelData localPasterParcelData = (PasterParcelData)paramArrayList.get(i);
      if ((localPasterParcelData.p == 3) && (!TextUtils.isEmpty(localPasterParcelData.q)))
      {
        if ((this.z.h != null) && (this.z.h.c())) {
          j = 1;
        } else {
          j = 0;
        }
        InfoStickerDrawable localInfoStickerDrawable = InformationFaceConstant.a(BaseApplicationImpl.getContext(), localPasterParcelData.q);
        if (j != 0) {
          paramJSONArray = localInfoStickerDrawable;
        } else if (localInfoStickerDrawable != null) {
          paramJSONArray = new BitmapDrawable(this.y.getResources(), localInfoStickerDrawable.h());
        } else {
          paramJSONArray = null;
        }
        int j = (int)localPasterParcelData.k.left;
        int k = (int)localPasterParcelData.k.right;
        int m = (int)localPasterParcelData.k.top;
        int n = (int)localPasterParcelData.k.bottom;
        if (paramJSONArray != null)
        {
          paramJSONArray.setBounds(j, m, k, n);
          SLog.b("DynamicFaceLayer", "Create Normal FaceItem.");
          FaceLayer.FaceItem localFaceItem = new FaceLayer.FaceItem(this, paramJSONArray, new FaceLayer.LayerParams(localPasterParcelData.d.x, localPasterParcelData.d.y, localPasterParcelData.e, localPasterParcelData.f, localPasterParcelData.g, localPasterParcelData.h, (int)localPasterParcelData.i, (int)localPasterParcelData.j), localPasterParcelData.l, localPasterParcelData.m, localPasterParcelData.n, localPasterParcelData.p);
          localFaceItem.U.set(localPasterParcelData.v);
          localFaceItem.w = localPasterParcelData.q;
          localFaceItem.x = localPasterParcelData.r;
          localFaceItem.q = 0;
          localFaceItem.r = 1;
          localFaceItem.s = InformationFaceConstant.a(localInfoStickerDrawable.f());
          localFaceItem.t = InformationFaceConstant.b(localInfoStickerDrawable.f());
          if (localFaceItem.s)
          {
            this.r.add(localFaceItem);
            if (!TextUtils.isEmpty(localPasterParcelData.o))
            {
              localFaceItem.u = new TroopBarPOI("-1", "", localPasterParcelData.o, 0, "", 0, "");
              localFaceItem.v = System.currentTimeMillis();
            }
          }
          if ((this.z.h != null) && (this.z.h.c()))
          {
            paramJSONArray.setCallback(this.z);
            this.b.add(localFaceItem);
          }
          else
          {
            localFaceItem.y = 0;
            paramJSONArray = (FaceLayer)this.z.a(FaceLayer.a);
            if (paramJSONArray != null) {
              paramJSONArray.b.add(localFaceItem);
            }
          }
        }
      }
      i += 1;
    }
    ThreadManager.post(new DynamicFaceLayer.1(this, paramArrayList), 8, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!this.t) && (!paramBoolean)) {
      return;
    }
    if (this.b != null)
    {
      if (this.b.isEmpty()) {
        return;
      }
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (FaceLayer.FaceItem)localIterator.next();
        if ((((FaceLayer.FaceItem)localObject).l != null) && ((((FaceLayer.FaceItem)localObject).l instanceof URLDrawable)))
        {
          localObject = (URLDrawable)((FaceLayer.FaceItem)localObject).l;
          if (localObject != null)
          {
            localObject = ((URLDrawable)localObject).getCurrDrawable();
            if ((localObject != null) && ((localObject instanceof ApngDrawable)) && (((ApngDrawable)localObject).getImage() != null)) {
              if (paramBoolean)
              {
                this.t = true;
                ApngImage.pauseByTag(13);
              }
              else
              {
                this.t = false;
                ApngImage.playByTag(13);
              }
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.r.clear();
  }
  
  public void c(Canvas paramCanvas)
  {
    if (!this.z.h.c()) {
      return;
    }
    paramCanvas.save();
    paramCanvas.scale(this.J, this.J);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
      Drawable localDrawable = b(a(localFaceItem.p));
      if (localDrawable != null) {
        localDrawable.setBounds(0, 0, (int)localFaceItem.G, (int)localFaceItem.H);
      }
      Object localObject = localDrawable;
      if (localFaceItem.y == 3)
      {
        localObject = localDrawable;
        if (localFaceItem.l != null)
        {
          localObject = localDrawable;
          if ((localFaceItem.l instanceof InfoStickerDrawable)) {
            try
            {
              localObject = (InfoStickerDrawable)localFaceItem.l;
              localObject = new BitmapDrawable(this.y.getResources(), ((InfoStickerDrawable)localObject).h());
              try
              {
                ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
              }
              catch (Exception localException1)
              {
                Exception localException2 = localException1;
              }
              QLog.e("DynamicFaceLayer", 1, "saveStaticFrame fail, ", localException3);
            }
            catch (Exception localException3)
            {
              localObject = localException1;
            }
          }
        }
      }
      if (localObject != null)
      {
        paramCanvas.save();
        paramCanvas.concat(this.m.b(localFaceItem));
        paramCanvas.save();
        paramCanvas.translate(-localFaceItem.G / 2.0F, -localFaceItem.H / 2.0F);
        ((Drawable)localObject).draw(paramCanvas);
        paramCanvas.restore();
        paramCanvas.restore();
      }
    }
    paramCanvas.restore();
  }
  
  protected boolean d()
  {
    return g() >= 10;
  }
  
  public int e()
  {
    return 2147483647;
  }
  
  public void f()
  {
    if (this.b != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Drawable localDrawable = ((FaceLayer.FaceItem)localIterator.next()).l;
        if ((localDrawable instanceof WeatherStickerDrawable)) {
          ((WeatherStickerDrawable)localDrawable).a();
        }
      }
    }
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer
 * JD-Core Version:    0.7.0.1
 */