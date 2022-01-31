import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class biiw
  extends biiy
{
  private boolean b;
  
  public biiw(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  /* Error */
  public static Drawable a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokestatic 20	vlc:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +74 -> 86
    //   15: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +43 -> 61
    //   21: ldc 28
    //   23: iconst_2
    //   24: new 30	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   31: ldc 35
    //   33: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 45	android/graphics/Bitmap:getWidth	()I
    //   40: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: ldc 50
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 53	android/graphics/Bitmap:getHeight	()I
    //   52: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: new 63	android/graphics/drawable/BitmapDrawable
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 66	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   69: astore_0
    //   70: aload_0
    //   71: iconst_0
    //   72: iconst_0
    //   73: aload_1
    //   74: invokevirtual 45	android/graphics/Bitmap:getWidth	()I
    //   77: aload_1
    //   78: invokevirtual 53	android/graphics/Bitmap:getHeight	()I
    //   81: invokevirtual 72	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   84: aload_0
    //   85: areturn
    //   86: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +28 -> 117
    //   92: ldc 28
    //   94: iconst_2
    //   95: new 30	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   102: ldc 74
    //   104: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aconst_null
    //   118: astore_0
    //   119: goto -35 -> 84
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_1
    //   126: invokevirtual 77	java/lang/OutOfMemoryError:printStackTrace	()V
    //   129: goto -45 -> 84
    //   132: astore_1
    //   133: goto -8 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   10	68	1	localBitmap	android.graphics.Bitmap
    //   122	4	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   132	1	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   6	11	122	java/lang/OutOfMemoryError
    //   15	61	122	java/lang/OutOfMemoryError
    //   61	70	122	java/lang/OutOfMemoryError
    //   86	117	122	java/lang/OutOfMemoryError
    //   70	84	132	java/lang/OutOfMemoryError
  }
  
  public static String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".apng"))) {}
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("DynamicFaceLayer", 2, "getDynamicStaticPicPath|path= " + paramString);
      }
      int i = paramString.length();
      paramString = paramString.substring(0, i - 5) + ".bpng";
      if (QLog.isColorLevel()) {
        QLog.d("DynamicFaceLayer", 2, "newPath= " + paramString);
      }
      if (new File(paramString).exists()) {
        return paramString;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DynamicFaceLayer", 2, "file not exist");
    return null;
  }
  
  public String a()
  {
    return "DynamicFaceLayer";
  }
  
  public String a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int;
    int k = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b;
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
    float f1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int * 1.0F / this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b;
    float f2 = j * 1.0F / i;
    if (f2 != f1) {
      if (f1 > f2)
      {
        j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int;
        i = Math.round(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int / f2);
        paramInt2 = (i - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b) / 2;
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("layerParams=").append(j).append("*").append(i).append(",heightOffset=").append(paramInt2).append(",widthOffset=").append(paramInt1);
        QLog.d("DynamicFaceLayer", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
      {
        localObject = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            bijc localbijc = (bijc)localIterator.next();
            DynamicStickerData localDynamicStickerData = new DynamicStickerData();
            localDynamicStickerData.centerP = localbijc.jdField_b_of_type_AndroidGraphicsPointF;
            localDynamicStickerData.scale = localbijc.q;
            localDynamicStickerData.rotate = localbijc.r;
            localDynamicStickerData.translateX = (localbijc.s + paramInt1);
            localDynamicStickerData.translateY = (localbijc.t + paramInt2);
            localDynamicStickerData.height = localbijc.v;
            localDynamicStickerData.width = localbijc.u;
            localDynamicStickerData.path = localbijc.jdField_f_of_type_JavaLangString;
            localDynamicStickerData.type = localbijc.h;
            localDynamicStickerData.data = localbijc.jdField_g_of_type_JavaLangString;
            localDynamicStickerData.layerWidth = j;
            localDynamicStickerData.layerHeight = i;
            localDynamicStickerData.mapMotionTrack = localbijc.jdField_a_of_type_JavaUtilMap;
            localDynamicStickerData.setSegmentList(localbijc.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.getSegmentList());
            localDynamicStickerData.mSegmentKeeper.setAdjustTimeValid(false);
            ((ArrayList)localObject).add(localDynamicStickerData);
            continue;
            j = Math.round(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b * f2);
            i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b;
            paramInt1 = (j - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int) / 2;
            paramInt2 = 0;
            break;
          }
        }
        if (((ArrayList)localObject).size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "generateDynamicStickers|size= " + ((ArrayList)localObject).size());
          }
          return biqz.a((ArrayList)localObject);
        }
      }
      return null;
      j = m;
      i = k;
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public void a(Canvas paramCanvas, float paramFloat) {}
  
  public void a(ArrayList<PasterParcelData> paramArrayList, boolean paramBoolean, JSONArray paramJSONArray)
  {
    int i = 0;
    PasterParcelData localPasterParcelData;
    int j;
    label69:
    biql localbiql;
    if (i < paramArrayList.size())
    {
      localPasterParcelData = (PasterParcelData)paramArrayList.get(i);
      if ((localPasterParcelData.jdField_d_of_type_Int == 3) && (!TextUtils.isEmpty(localPasterParcelData.jdField_e_of_type_JavaLangString)))
      {
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {
          break label437;
        }
        j = 1;
        localbiql = bios.a(BaseApplicationImpl.getContext(), localPasterParcelData.jdField_e_of_type_JavaLangString);
        if (j == 0) {
          break label443;
        }
        paramJSONArray = localbiql;
      }
    }
    for (;;)
    {
      label90:
      j = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.left;
      int k = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.right;
      int m = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.top;
      int n = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.bottom;
      bijc localbijc;
      if (paramJSONArray != null)
      {
        paramJSONArray.setBounds(j, m, k, n);
        urk.b("DynamicFaceLayer", "Create Normal FaceItem.");
        localbijc = new bijc(this, paramJSONArray, new bijg(localPasterParcelData.jdField_a_of_type_AndroidGraphicsPointF.x, localPasterParcelData.jdField_a_of_type_AndroidGraphicsPointF.y, localPasterParcelData.jdField_a_of_type_Float, localPasterParcelData.jdField_b_of_type_Float, localPasterParcelData.jdField_c_of_type_Float, localPasterParcelData.jdField_d_of_type_Float, (int)localPasterParcelData.jdField_e_of_type_Float, (int)localPasterParcelData.f), localPasterParcelData.jdField_a_of_type_JavaLangString, localPasterParcelData.jdField_b_of_type_JavaLangString, localPasterParcelData.jdField_c_of_type_JavaLangString, localPasterParcelData.jdField_d_of_type_Int);
        localbijc.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(localPasterParcelData.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
        localbijc.jdField_g_of_type_JavaLangString = localPasterParcelData.jdField_e_of_type_JavaLangString;
        localbijc.jdField_g_of_type_Int = localPasterParcelData.jdField_e_of_type_Int;
        localbijc.jdField_e_of_type_Int = 0;
        localbijc.jdField_f_of_type_Int = 1;
        localbijc.jdField_b_of_type_Boolean = bios.a(localbiql.a());
        localbijc.c = bios.b(localbiql.a());
        if (localbijc.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_JavaUtilList.add(localbijc);
          if (!TextUtils.isEmpty(localPasterParcelData.jdField_d_of_type_JavaLangString))
          {
            localbijc.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", localPasterParcelData.jdField_d_of_type_JavaLangString, 0, "", 0, "");
            localbijc.jdField_a_of_type_Long = System.currentTimeMillis();
          }
        }
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {
          break label471;
        }
        paramJSONArray.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        this.jdField_a_of_type_JavaUtilList.add(localbijc);
      }
      for (;;)
      {
        i += 1;
        break;
        label437:
        j = 0;
        break label69;
        label443:
        if (localbiql == null) {
          break label527;
        }
        paramJSONArray = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localbiql.a());
        break label90;
        label471:
        localbijc.h = 0;
        paramJSONArray = (biiy)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(biiy.jdField_a_of_type_JavaLangString);
        if (paramJSONArray != null) {
          paramJSONArray.jdField_a_of_type_JavaUtilList.add(localbijc);
        }
      }
      ThreadManager.post(new DynamicFaceLayer.1(this, paramArrayList), 8, null, false);
      return;
      label527:
      paramJSONArray = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!this.jdField_b_of_type_Boolean) && (!paramBoolean)) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (bijc)localIterator.next();
          if ((((bijc)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((((bijc)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
          {
            localObject = (URLDrawable)((bijc)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (localObject != null)
            {
              localObject = ((URLDrawable)localObject).getCurrDrawable();
              if ((localObject != null) && ((localObject instanceof ApngDrawable)) && (((ApngDrawable)localObject).getImage() != null)) {
                if (paramBoolean)
                {
                  this.jdField_b_of_type_Boolean = true;
                  ApngImage.pauseByTag(13);
                }
                else
                {
                  this.jdField_b_of_type_Boolean = false;
                  ApngImage.playByTag(13);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "DynamicFaceLayer";
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Drawable localDrawable = ((bijc)localIterator.next()).jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if ((localDrawable instanceof biqw)) {
          ((biqw)localDrawable).a();
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
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {
      return;
    }
    paramCanvas.save();
    paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      bijc localbijc = (bijc)localIterator.next();
      Object localObject2 = a(a(localbijc.jdField_f_of_type_JavaLangString));
      if (localObject2 != null) {
        ((Drawable)localObject2).setBounds(0, 0, (int)localbijc.u, (int)localbijc.v);
      }
      Object localObject1 = localObject2;
      if (localbijc.h == 3)
      {
        localObject1 = localObject2;
        if (localbijc.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localObject1 = localObject2;
          if (!(localbijc.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof biql)) {}
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = (biql)localbijc.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localObject1 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), ((biql)localObject1).a());
        }
        catch (Exception localException2)
        {
          try
          {
            ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
            if (localObject1 == null) {
              break;
            }
            paramCanvas.save();
            paramCanvas.concat(this.jdField_a_of_type_Bira.a(localbijc));
            paramCanvas.save();
            paramCanvas.translate(-localbijc.u / 2.0F, -localbijc.v / 2.0F);
            ((Drawable)localObject1).draw(paramCanvas);
            paramCanvas.restore();
            paramCanvas.restore();
          }
          catch (Exception localException1)
          {
            break label244;
          }
          localException2 = localException2;
          localObject1 = localObject2;
          localObject2 = localException2;
        }
        label244:
        QLog.e("DynamicFaceLayer", 1, "saveStaticFrame fail, ", (Throwable)localObject2);
      }
    }
    paramCanvas.restore();
  }
  
  public int i_()
  {
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biiw
 * JD-Core Version:    0.7.0.1
 */