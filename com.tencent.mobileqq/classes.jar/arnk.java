import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class arnk
  implements Handler.Callback
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  arnl jdField_a_of_type_Arnl;
  EglHandlerThread jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread;
  String jdField_a_of_type_JavaLangString;
  List<akut> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CopyOnWriteArrayList<WeakReference<arnn>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  Handler jdField_b_of_type_AndroidOsHandler;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  
  public arnk(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("MINICODE_DETECT_THREAD");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = new EglHandlerThread("MINICODE_EGLHANDLER_THREAD", null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.start();
    paramContext = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.getLooper();
    if (paramContext != null)
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(paramContext, this);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(200);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
      return;
      QLog.i("MiniRecog.detector", 1, "MiniCodeDetector init eglHandler exception: looper=null");
    }
  }
  
  private int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "initInEGL");
    }
    this.jdField_a_of_type_Boolean = true;
    arnm localarnm = new arnm();
    localarnm.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
    localarnm.jdField_b_of_type_Int = 256;
    localarnm.jdField_c_of_type_Int = 256;
    localarnm.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localarnm.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localarnm.jdField_a_of_type_JavaLangString = arnj.a(this.jdField_b_of_type_JavaLangString);
    localarnm.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("runType").append("=").append(localarnm.jdField_a_of_type_Int).append("\n");
    localStringBuilder.append("netHeight").append("=").append(localarnm.jdField_b_of_type_Int).append("\n");
    localStringBuilder.append("netWidth").append("=").append(localarnm.jdField_c_of_type_Int).append("\n");
    localStringBuilder.append("paramPath").append("=").append(localarnm.jdField_b_of_type_JavaLangString).append("\n");
    localStringBuilder.append("anchorPath").append("=").append(localarnm.jdField_c_of_type_JavaLangString).append("\n");
    localStringBuilder.append("kernelBinaryIndex").append("=").append(localarnm.jdField_d_of_type_JavaLangString).append("\n");
    localStringBuilder.append("modelString").append("=").append(localarnm.jdField_a_of_type_JavaLangString).append("\n");
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, localStringBuilder.toString());
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int > 0)) {
      this.jdField_a_of_type_Int = arnh.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_Arnl = new arnl(localarnm);
    if (this.jdField_a_of_type_Arnl.a()) {
      return 1;
    }
    return 0;
  }
  
  private static void a(int paramInt, Bitmap paramBitmap)
  {
    GLES20.glBindTexture(3553, paramInt);
    arnh.a("glBindTexture");
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    arnh.a("glTexParameteri");
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    arnh.a("texImage2D");
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    int i = -1;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "processInEGL start **********");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, "processInEGL has not been initialized; Skipped.");
      }
      return false;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, "processInEGL mInBmp invalid");
      }
      return false;
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((((Bitmap)localObject).getWidth() != this.jdField_b_of_type_Int) || (((Bitmap)localObject).getHeight() != this.jdField_c_of_type_Int) || (this.jdField_a_of_type_Int < 0))
    {
      this.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
      this.jdField_c_of_type_Int = ((Bitmap)localObject).getHeight();
      if (this.jdField_a_of_type_Int >= 0)
      {
        auyn.b(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = -1;
      }
      try
      {
        int j = auyn.a(3553, (Bitmap)localObject);
        i = j;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
        }
      }
      this.jdField_a_of_type_Int = i;
    }
    for (;;)
    {
      ((Bitmap)localObject).recycle();
      if (this.jdField_a_of_type_Arnl != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, "processInEGL MiniCodeRecog is null");
      }
      return false;
      try
      {
        a(this.jdField_a_of_type_Int, (Bitmap)localObject);
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
    }
    localObject = null;
    if (this.jdField_a_of_type_Int >= 0)
    {
      List localList = this.jdField_a_of_type_Arnl.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramLong, paramBoolean);
      localObject = localList;
      if (QLog.isColorLevel())
      {
        QLog.i("MiniRecog.detector", 2, String.format("minicode_timecost processInEGL end consume=%d **********", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        localObject = localList;
      }
    }
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
    }
    return true;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.detector", 2, "destroyInEGL()");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int >= 0)
    {
      auyn.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    if (this.jdField_a_of_type_Arnl != null) {}
    try
    {
      this.jdField_a_of_type_Arnl.a();
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(100);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("MiniRecog.detector", 1, "destroyInEGL exception:" + localException.getLocalizedMessage(), localException);
      }
    }
  }
  
  @TargetApi(18)
  private void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.quitSafely();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
          this.jdField_a_of_type_AndroidOsHandlerThread = null;
          this.jdField_b_of_type_AndroidOsHandler = null;
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
          this.jdField_a_of_type_JavaUtilList.clear();
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, "closeLater()");
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, localException1.getMessage(), localException1);
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.detector", 2, localException2.getMessage(), localException2);
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.detector", 2, "close()");
      }
      this.jdField_c_of_type_Boolean = true;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(202);
    return;
    c();
  }
  
  public void a(arnn paramarnn)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      arnn localarnn = (arnn)((WeakReference)localIterator.next()).get();
      if ((localarnn != null) && (localarnn == paramarnn)) {
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramarnn));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
  }
  
  public boolean a(Bitmap paramBitmap, long paramLong)
  {
    boolean bool = false;
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (!QLog.isColorLevel()) {
          break label192;
        }
        QLog.i("MiniRecog.detector", 2, "detector has not been initialized; Skipped.");
        return false;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if (!QLog.isColorLevel()) {
          break label192;
        }
        QLog.i("MiniRecog.detector", 2, "detector has been closed; Skipped.");
        return false;
      }
    }
    catch (Exception paramBitmap)
    {
      QLog.i("MiniRecog.detector", 1, "detect exception: " + paramBitmap.getMessage(), paramBitmap);
      return false;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      if (QLog.isColorLevel())
      {
        QLog.i("MiniRecog.detector", 2, "detect input bitmap invalid");
        return false;
      }
    }
    else if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        QLog.i("MiniRecog.detector", 2, "detect mIsProcessing is true");
        return false;
      }
    }
    else
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("MiniRecog.detector", 2, "mEglHandler is null");
          return false;
        }
      }
      else
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        localHandler.obtainMessage(201, Long.valueOf(paramLong)).sendToTarget();
        bool = true;
      }
    }
    label192:
    return bool;
  }
  
  public void b(arnn paramarnn)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      arnn localarnn = (arnn)localWeakReference.get();
      if ((localarnn != null) && (localarnn == paramarnn)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = a();
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.obtainMessage(102, i, 0).sendToTarget();
        return false;
        long l = ((Long)paramMessage.obj).longValue();
        boolean bool1 = arni.jdField_b_of_type_Boolean;
        boolean bool2 = a(l, bool1);
        if (this.jdField_b_of_type_AndroidOsHandler != null)
        {
          paramMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(101, new Object[] { Boolean.valueOf(bool2), Long.valueOf(l) });
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramMessage);
        }
        if ((this.jdField_b_of_type_AndroidOsHandler != null) && (bool1))
        {
          paramMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(103, new Object[] { Long.valueOf(l) });
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramMessage);
          return false;
          b();
          return false;
          c();
          return false;
          paramMessage = (Object[])paramMessage.obj;
          Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          arnn localarnn;
          while (((Iterator)localObject).hasNext())
          {
            localarnn = (arnn)((WeakReference)((Iterator)localObject).next()).get();
            if (localarnn != null) {
              localarnn.a(this.jdField_a_of_type_JavaUtilList, ((Long)paramMessage[1]).longValue());
            }
          }
          this.jdField_b_of_type_Boolean = false;
          return false;
          i = paramMessage.arg1;
          paramMessage = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (paramMessage.hasNext())
          {
            localObject = (arnn)((WeakReference)paramMessage.next()).get();
            if (localObject != null) {
              ((arnn)localObject).a(i);
            }
          }
          paramMessage = (Object[])paramMessage.obj;
          localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            localarnn = (arnn)((WeakReference)((Iterator)localObject).next()).get();
            if (localarnn != null) {
              localarnn.a(((Long)paramMessage[0]).longValue());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arnk
 * JD-Core Version:    0.7.0.1
 */