import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.CodecDecodeRunnable;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.DecodeRunnable;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.3;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.4;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class bkkl
  implements bkkf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private bkyb jdField_a_of_type_Bkyb;
  private DecodeRunnable jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoDecodeRunnable;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<bkkm> jdField_a_of_type_JavaLangRefWeakReference;
  private List<Bitmap> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public bkkl(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  private Bitmap a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i;
    int j;
    if (paramBoolean)
    {
      i = paramBitmap.getHeight();
      if (!paramBoolean) {
        break label181;
      }
      j = paramBitmap.getWidth();
      label26:
      int k = bkxu.jdField_a_of_type_Int;
      if (j <= k) {
        break label226;
      }
      i = (int)(i * k / j);
      j = k;
    }
    label181:
    label226:
    for (;;)
    {
      i = avte.a(i);
      j = avte.a(j);
      GaussianBlurFilter localGaussianBlurFilter = new GaussianBlurFilter();
      localGaussianBlurFilter.init(paramBitmap.getWidth(), paramBitmap.getHeight());
      Object localObject;
      if (localGaussianBlurFilter.isInitSucc())
      {
        localObject = bbef.a(paramContext, bbef.c(paramBitmap), 0.4F, 25.0F);
        paramContext = (Context)localObject;
        if (localObject != null)
        {
          paramContext = new Canvas();
          paramContext.setBitmap((Bitmap)localObject);
          paramContext.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
          paramContext = (Context)localObject;
        }
      }
      for (;;)
      {
        paramContext = vxv.a(vxv.a(paramContext, i, j, true), paramBitmap);
        localGaussianBlurFilter.destroy();
        return paramContext;
        i = paramBitmap.getWidth();
        break;
        j = paramBitmap.getHeight();
        break label26;
        paramContext = Bitmap.createBitmap(paramBitmap);
        localObject = new Canvas();
        ((Canvas)localObject).setBitmap(paramContext);
        ((Canvas)localObject).drawColor(Color.parseColor("#CC000000"), PorterDuff.Mode.SRC_OVER);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeStart， useretriever:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.getUIHandler().post(new VideoFrameLoader.1(this));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeError , code:" + paramInt);
    }
    ThreadManager.getUIHandler().post(new VideoFrameLoader.4(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "start， nCount:" + paramInt1 + " nFrameWidth:" + this.jdField_a_of_type_Int + " nFrameHeight:" + paramInt3);
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt3 <= 0)) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoDecodeRunnable = new CodecDecodeRunnable(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.d, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this);
    ThreadManager.post(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoDecodeRunnable, 10, null, true);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, long paramLong, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onDecodeFrame, index:").append(paramInt).append(" ltimeus:").append(paramLong).append(" bitmap:");
      if (paramBitmap == null) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VideoFrameLoader", 2, bool);
      if ((paramInt >= 0) && (paramInt < this.jdField_c_of_type_Int)) {
        ThreadManager.getUIHandler().post(new VideoFrameLoader.2(this, paramInt, paramBitmap));
      }
      return;
    }
  }
  
  public void a(List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeKeyFrameList");
    }
    ThreadManager.getUIHandler().post(new VideoFrameLoader.5(this, paramList));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeEnd, finish:" + paramBoolean);
    }
    ThreadManager.getUIHandler().post(new VideoFrameLoader.3(this));
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, int paramInt, bkkm parambkkm)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambkkm);
    this.jdField_a_of_type_Long = paramLong1;
    this.d = paramInt;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long <= 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "init error, path:" + this.jdField_a_of_type_JavaLangString + " time:" + this.jdField_a_of_type_Long + "-" + this.jdField_b_of_type_Long);
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "stop， mListItems: :" + this.jdField_a_of_type_JavaUtilList.size() + " useRetriever:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoDecodeRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoDecodeRunnable.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMultivideoDecodeRunnable = null;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "uinit..");
    }
    b();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_Bkyb != null) {
      this.jdField_a_of_type_Bkyb.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkkl
 * JD-Core Version:    0.7.0.1
 */