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
  private boolean c = false;
  
  public DynamicFaceLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public static Drawable a(String paramString)
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
  
  public int a()
  {
    return 2147483647;
  }
  
  public String a()
  {
    return "DynamicFaceLayer";
  }
  
  public String a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int;
    int k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.b;
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
    float f1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int * 1.0F / this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.b;
    float f2 = j * 1.0F / i;
    j = 0;
    i = 0;
    paramInt1 = m;
    paramInt2 = k;
    if (f2 != f1) {
      if (f1 > f2)
      {
        paramInt1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int;
        paramInt2 = Math.round(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int / f2);
        i = (paramInt2 - this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.b) / 2;
      }
      else
      {
        paramInt1 = Math.round(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.b * f2);
        paramInt2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.b;
        i = (paramInt1 - this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int) / 2;
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
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b())
    {
      localObject1 = new ArrayList();
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject2).next();
        DynamicStickerData localDynamicStickerData = new DynamicStickerData();
        localDynamicStickerData.centerP = localFaceItem.jdField_a_of_type_AndroidGraphicsPointF;
        localDynamicStickerData.scale = localFaceItem.j;
        localDynamicStickerData.rotate = localFaceItem.k;
        localDynamicStickerData.translateX = (localFaceItem.l + i);
        localDynamicStickerData.translateY = (localFaceItem.m + j);
        localDynamicStickerData.height = localFaceItem.o;
        localDynamicStickerData.width = localFaceItem.n;
        localDynamicStickerData.path = localFaceItem.jdField_f_of_type_JavaLangString;
        localDynamicStickerData.type = localFaceItem.h;
        localDynamicStickerData.data = localFaceItem.jdField_g_of_type_JavaLangString;
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
  
  public void a()
  {
    super.a();
    this.b.clear();
  }
  
  public void a(Canvas paramCanvas, float paramFloat) {}
  
  public void a(ArrayList<PasterParcelData> paramArrayList, boolean paramBoolean, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      PasterParcelData localPasterParcelData = (PasterParcelData)paramArrayList.get(i);
      if ((localPasterParcelData.jdField_d_of_type_Int == 3) && (!TextUtils.isEmpty(localPasterParcelData.jdField_e_of_type_JavaLangString)))
      {
        if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b())) {
          j = 1;
        } else {
          j = 0;
        }
        InfoStickerDrawable localInfoStickerDrawable = InformationFaceConstant.a(BaseApplicationImpl.getContext(), localPasterParcelData.jdField_e_of_type_JavaLangString);
        if (j != 0) {
          paramJSONArray = localInfoStickerDrawable;
        } else if (localInfoStickerDrawable != null) {
          paramJSONArray = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localInfoStickerDrawable.a());
        } else {
          paramJSONArray = null;
        }
        int j = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.left;
        int k = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.right;
        int m = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.top;
        int n = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.bottom;
        if (paramJSONArray != null)
        {
          paramJSONArray.setBounds(j, m, k, n);
          SLog.b("DynamicFaceLayer", "Create Normal FaceItem.");
          FaceLayer.FaceItem localFaceItem = new FaceLayer.FaceItem(this, paramJSONArray, new FaceLayer.LayerParams(localPasterParcelData.jdField_a_of_type_AndroidGraphicsPointF.x, localPasterParcelData.jdField_a_of_type_AndroidGraphicsPointF.y, localPasterParcelData.jdField_a_of_type_Float, localPasterParcelData.jdField_b_of_type_Float, localPasterParcelData.jdField_c_of_type_Float, localPasterParcelData.jdField_d_of_type_Float, (int)localPasterParcelData.jdField_e_of_type_Float, (int)localPasterParcelData.f), localPasterParcelData.jdField_a_of_type_JavaLangString, localPasterParcelData.jdField_b_of_type_JavaLangString, localPasterParcelData.jdField_c_of_type_JavaLangString, localPasterParcelData.jdField_d_of_type_Int);
          localFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(localPasterParcelData.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
          localFaceItem.jdField_g_of_type_JavaLangString = localPasterParcelData.jdField_e_of_type_JavaLangString;
          localFaceItem.jdField_g_of_type_Int = localPasterParcelData.jdField_e_of_type_Int;
          localFaceItem.jdField_e_of_type_Int = 0;
          localFaceItem.jdField_f_of_type_Int = 1;
          localFaceItem.b = InformationFaceConstant.a(localInfoStickerDrawable.a());
          localFaceItem.c = InformationFaceConstant.b(localInfoStickerDrawable.a());
          if (localFaceItem.b)
          {
            this.b.add(localFaceItem);
            if (!TextUtils.isEmpty(localPasterParcelData.jdField_d_of_type_JavaLangString))
            {
              localFaceItem.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI = new TroopBarPOI("-1", "", localPasterParcelData.jdField_d_of_type_JavaLangString, 0, "", 0, "");
              localFaceItem.jdField_a_of_type_Long = System.currentTimeMillis();
            }
          }
          if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b()))
          {
            paramJSONArray.setCallback(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView);
            this.jdField_a_of_type_JavaUtilList.add(localFaceItem);
          }
          else
          {
            localFaceItem.h = 0;
            paramJSONArray = (FaceLayer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(FaceLayer.jdField_a_of_type_JavaLangString);
            if (paramJSONArray != null) {
              paramJSONArray.jdField_a_of_type_JavaUtilList.add(localFaceItem);
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
    if ((!this.c) && (!paramBoolean)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (FaceLayer.FaceItem)localIterator.next();
        if ((((FaceLayer.FaceItem)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((((FaceLayer.FaceItem)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
        {
          localObject = (URLDrawable)((FaceLayer.FaceItem)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          if (localObject != null)
          {
            localObject = ((URLDrawable)localObject).getCurrDrawable();
            if ((localObject != null) && ((localObject instanceof ApngDrawable)) && (((ApngDrawable)localObject).getImage() != null)) {
              if (paramBoolean)
              {
                this.c = true;
                ApngImage.pauseByTag(13);
              }
              else
              {
                this.c = false;
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
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Drawable localDrawable = ((FaceLayer.FaceItem)localIterator.next()).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if ((localDrawable instanceof WeatherStickerDrawable)) {
          ((WeatherStickerDrawable)localDrawable).a();
        }
      }
    }
    super.b();
  }
  
  protected boolean b()
  {
    return b() >= 10;
  }
  
  public void c(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b()) {
      return;
    }
    paramCanvas.save();
    paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
      Drawable localDrawable = a(a(localFaceItem.jdField_f_of_type_JavaLangString));
      if (localDrawable != null) {
        localDrawable.setBounds(0, 0, (int)localFaceItem.n, (int)localFaceItem.o);
      }
      Object localObject = localDrawable;
      if (localFaceItem.h == 3)
      {
        localObject = localDrawable;
        if (localFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localObject = localDrawable;
          if ((localFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof InfoStickerDrawable)) {
            try
            {
              localObject = (InfoStickerDrawable)localFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), ((InfoStickerDrawable)localObject).a());
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
        paramCanvas.concat(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUtilGestureHelper.a(localFaceItem));
        paramCanvas.save();
        paramCanvas.translate(-localFaceItem.n / 2.0F, -localFaceItem.o / 2.0F);
        ((Drawable)localObject).draw(paramCanvas);
        paramCanvas.restore();
        paramCanvas.restore();
      }
    }
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer
 * JD-Core Version:    0.7.0.1
 */