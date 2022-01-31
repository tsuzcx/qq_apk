import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.Matrix;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.minicode.RecogProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class auaq
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private auar jdField_a_of_type_Auar;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = "MiniRecog.recog";
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  public auaq(auar paramauar)
  {
    this.jdField_a_of_type_Auar = paramauar;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_a_of_type_Int = auam.a(paramauar.jdField_c_of_type_Int, paramauar.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramauar.jdField_c_of_type_Int, paramauar.jdField_b_of_type_Int);
    auan.a(false);
    this.jdField_a_of_type_Long = RecogProxy.QCodeInit(this.jdField_a_of_type_Auar.jdField_a_of_type_Int, this.jdField_a_of_type_Auar.jdField_b_of_type_Int, this.jdField_a_of_type_Auar.jdField_c_of_type_Int, this.jdField_a_of_type_Auar.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Auar.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Auar.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Auar.d, 0.35F);
    QLog.i("MiniRecog.recog", 1, String.format("RecogProxy.QCodeInit native_handler=0x%x", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
    if (this.jdField_a_of_type_Long != 0L) {
      auan.b(false);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private Rect a(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if (paramInt1 > paramInt2)
    {
      i = 0;
      paramArrayOfFloat[i] = ((paramArrayOfFloat[i] - 0.5F) / this.jdField_a_of_type_Float + 0.5F);
      paramArrayOfFloat[(i + 2)] = ((paramArrayOfFloat[(i + 2)] - 0.5F) / this.jdField_a_of_type_Float + 0.5F);
      float f1 = paramArrayOfFloat[0];
      float f2 = paramArrayOfFloat[1];
      float f3 = paramArrayOfFloat[2];
      float f4 = paramArrayOfFloat[3];
      paramArrayOfFloat[0] = (1.0F - (f1 - 0.02F) * 2.0F);
      paramArrayOfFloat[1] = ((f2 - 0.02F) * 2.0F - 1.0F);
      paramArrayOfFloat[2] = (1.0F - 2.0F * (f3 + 0.02F));
      paramArrayOfFloat[3] = (2.0F * (f4 + 0.02F) - 1.0F);
      i = 0;
      label121:
      if (i >= 4) {
        break label175;
      }
      if (paramArrayOfFloat[i] <= 1.0F) {
        break label156;
      }
      paramArrayOfFloat[i] = 1.0F;
    }
    for (;;)
    {
      i += 1;
      break label121;
      i = 1;
      break;
      label156:
      if (paramArrayOfFloat[i] < -1.0F) {
        paramArrayOfFloat[i] = -1.0F;
      }
    }
    label175:
    int j = (int)(paramArrayOfFloat[0] * 0.5F * paramInt2);
    int k = (int)(paramArrayOfFloat[2] * 0.5F * paramInt2);
    int i = (int)(paramArrayOfFloat[1] * 0.5F * paramInt1);
    int m = (int)(paramArrayOfFloat[3] * 0.5F * paramInt1);
    int n = Math.abs(m - i);
    int i1 = Math.abs(k - j);
    if (i < m) {
      if (j <= k) {
        break label322;
      }
    }
    for (;;)
    {
      paramInt1 = (int)(i + paramInt1 * 0.5F);
      paramInt2 = (int)(paramInt2 * 0.5F - j);
      paramArrayOfFloat = new Rect();
      paramArrayOfFloat.left = paramInt1;
      paramArrayOfFloat.top = paramInt2;
      paramArrayOfFloat.right = (paramInt1 + n);
      paramArrayOfFloat.bottom = (paramInt2 + i1);
      return paramArrayOfFloat;
      i = m;
      break;
      label322:
      j = k;
    }
  }
  
  public List<amzu> a(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    ArrayList localArrayList;
    if (paramInt2 > paramInt3)
    {
      this.jdField_a_of_type_Float = (paramInt3 / paramInt2);
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_Float, 1.0F, 1.0F);
      Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, 180.0F, 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, -90.0F, 0.0F, 0.0F, 1.0F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.setUserTextureId(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      GLES31.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES31.glClear(16384);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt1, null, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      GLES20.glFlush();
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      Object localObject2;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Long != 0L)
        {
          RecogProxy.QCodeProcess(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, 0);
          j = RecogProxy.getBoxCnt(this.jdField_a_of_type_Long);
          int i = j;
          if (j < 2) {
            break label680;
          }
          i = 2;
          break label680;
          if (j < i)
          {
            localObject2 = new float[5];
            Object tmp207_205 = localObject2;
            tmp207_205[0] = 0.0F;
            Object tmp211_207 = tmp207_205;
            tmp211_207[1] = 0.0F;
            Object tmp215_211 = tmp211_207;
            tmp215_211[2] = 0.0F;
            Object tmp219_215 = tmp215_211;
            tmp219_215[3] = 0.0F;
            Object tmp223_219 = tmp219_215;
            tmp223_219[4] = 0.0F;
            tmp223_219;
            int k = RecogProxy.getBox(this.jdField_a_of_type_Long, j, (float[])localObject2);
            int m = RecogProxy.getBoxType(this.jdField_a_of_type_Long, j);
            if ((k < 0) || (m < 0))
            {
              j += 1;
              continue;
              this.jdField_a_of_type_Float = (paramInt2 / paramInt3);
              Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, 1.0F, this.jdField_a_of_type_Float, 1.0F);
              break;
            }
            if (QLog.isDevelopLevel()) {
              QLog.i("MiniRecog.recog", 2, String.format("debug_minicode_point=[%f,%f,%f,%f,%f,%d]", new Object[] { Float.valueOf(localObject2[0]), Float.valueOf(localObject2[1]), Float.valueOf(localObject2[2]), Float.valueOf(localObject2[3]), Float.valueOf(localObject2[4]), Integer.valueOf(m) }));
            }
            Rect localRect = a(paramInt2, paramInt3, (float[])localObject2);
            amzu localamzu = new amzu();
            localamzu.jdField_a_of_type_AndroidGraphicsRect.set(localRect);
            localamzu.jdField_a_of_type_Int = m;
            localamzu.jdField_a_of_type_Float = localObject2[4];
            localArrayList.add(localamzu);
          }
        }
      }
      if (paramBoolean)
      {
        Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
        if (paramInt2 <= paramInt3) {
          break label658;
        }
        Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_Float, 1.0F, 1.0F);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.setUserTextureId(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        GLES31.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES31.glClear(16384);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt1, null, this.jdField_a_of_type_ArrayOfFloat);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        GLES20.glFlush();
        try
        {
          ??? = auam.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Auar.jdField_c_of_type_Int, this.jdField_a_of_type_Auar.jdField_b_of_type_Int);
          localObject2 = new SimpleDateFormat("MM-dd HH:mm:ss", BaseApplicationImpl.getContext().getResources().getConfiguration().locale);
          localObject2 = paramLong + "-" + ((SimpleDateFormat)localObject2).format(new Date(paramLong));
          auan.a((Bitmap)???, (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.recog", 2, String.format("debug_minicode_validBmpData %s", new Object[] { localObject2 }));
          }
          label655:
          return localList;
          label658:
          Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, 1.0F, this.jdField_a_of_type_Float, 1.0F);
        }
        catch (Throwable localThrowable)
        {
          break label655;
        }
      }
      label680:
      int j = 0;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
    }
    if (this.jdField_a_of_type_Int >= 0)
    {
      axqh.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.jdField_a_of_type_Long != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.recog", 2, String.format("RecogProxy.QCodeDestroy native_handler=0x%x", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
      }
      RecogProxy.QCodeDestroy(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auaq
 * JD-Core Version:    0.7.0.1
 */