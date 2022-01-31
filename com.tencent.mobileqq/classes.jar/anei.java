import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class anei
  implements aufb
{
  anei(aneh paramaneh, Rect paramRect, long paramLong, Object paramObject, auey paramauey, boolean[] paramArrayOfBoolean, Bitmap paramBitmap) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Auey != null) && (aneh.a(this.jdField_a_of_type_Aneh) != null)) {
      this.jdField_a_of_type_ArrayOfBoolean[0] = this.jdField_a_of_type_Auey.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, "detectSync onDetectReady exec=" + this.jdField_a_of_type_ArrayOfBoolean[0]);
      }
      if (this.jdField_a_of_type_ArrayOfBoolean[0] == 0) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
        this.jdField_a_of_type_ArrayOfBoolean[0] = false;
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(List<aned> arg1, long paramLong)
  {
    int i = 0;
    label55:
    boolean bool;
    label68:
    int j;
    int k;
    int m;
    if (i < ???.size())
    {
      if (((aned)???.get(i)).jdField_a_of_type_Int != 2) {
        break label217;
      }
      ??? = (aned)???.get(i);
      this.jdField_a_of_type_AndroidGraphicsRect.set(???.jdField_a_of_type_AndroidGraphicsRect);
      if (QLog.isColorLevel())
      {
        if (??? == null) {
          break label226;
        }
        bool = true;
        i = this.jdField_a_of_type_AndroidGraphicsRect.left;
        j = this.jdField_a_of_type_AndroidGraphicsRect.top;
        k = this.jdField_a_of_type_AndroidGraphicsRect.width();
        m = this.jdField_a_of_type_AndroidGraphicsRect.height();
        if (??? == null) {
          break label232;
        }
      }
    }
    label217:
    label226:
    label232:
    for (float f = ???.jdField_a_of_type_Float;; f = 0.0F)
    {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync onDetectResult=%b [left,top,w,h,score]=[%d, %d, %d, %d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f) }));
      if (paramLong == this.jdField_a_of_type_Long)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaLangObject.notifyAll();
          return;
        }
        ??? = null;
        break label55;
      }
      return;
      i += 1;
      break;
      bool = false;
      break label68;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anei
 * JD-Core Version:    0.7.0.1
 */