import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import java.util.LinkedList;

public abstract class aobw
{
  int jdField_a_of_type_Int = 10;
  aobx jdField_a_of_type_Aobx = null;
  Hashtable<String, FaceInfo> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  LinkedList<FaceInfo> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  Hashtable<String, FaceInfo> jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  
  public abstract Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte);
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      axei.a(2, "FaceDecoderBase", "cancelPendingRequests", new Object[0]);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public abstract void a(int paramInt1, String paramString, int paramInt2, long paramLong);
  
  public void a(aobx paramaobx)
  {
    this.jdField_a_of_type_Aobx = paramaobx;
  }
  
  public abstract void a(AppInterface paramAppInterface);
  
  protected void a(FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("FaceDecoderBase", 2, "enqueueDecode, iRunningRequests=" + this.jdField_b_of_type_Int + ", pause=" + this.jdField_a_of_type_Boolean + ",faceinfo=" + paramFaceInfo.toString());
      }
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramFaceInfo);
        if (paramFaceInfo.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramFaceInfo);
          paramFaceInfo.a(FaceInfo.k);
          if ((this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Boolean)) {
            continue;
          }
          e();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("FaceDecoderBase", 2, "enqueueDecode", localException);
            continue;
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramFaceInfo);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3)
  {
    return a(paramString, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramByte, paramInt3, 100, false);
  }
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3);
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FaceDecoderBase", 2, "resume");
    }
    this.jdField_a_of_type_Boolean = false;
    while ((this.jdField_b_of_type_Int < this.jdField_a_of_type_Int) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())) {
      e();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      axei.a(2, "FaceDecoderBase", "cancelPendingRequests", new Object[0]);
    }
    this.jdField_a_of_type_JavaUtilHashtable.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      axei.a(2, "FaceDecoderBase", "destory", new Object[0]);
    }
    c();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Aobx = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobw
 * JD-Core Version:    0.7.0.1
 */