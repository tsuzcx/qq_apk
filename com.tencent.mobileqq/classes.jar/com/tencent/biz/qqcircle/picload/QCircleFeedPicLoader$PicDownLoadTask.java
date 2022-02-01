package com.tencent.biz.qqcircle.picload;

import auog;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import vrd;
import vrg;
import vrh;
import vri;

public class QCircleFeedPicLoader$PicDownLoadTask
  implements Runnable
{
  protected volatile int a;
  protected vrd a;
  public vrh a;
  
  public QCircleFeedPicLoader$PicDownLoadTask(QCircleFeedPicLoader paramQCircleFeedPicLoader, @NotNull vrd paramvrd)
  {
    this.jdField_a_of_type_Vrd = paramvrd;
    this.jdField_a_of_type_Int = QCircleFeedPicLoader.jdField_a_of_type_Int;
  }
  
  public vrd a()
  {
    return this.jdField_a_of_type_Vrd;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int != QCircleFeedPicLoader.f)
    {
      this.jdField_a_of_type_Int = QCircleFeedPicLoader.d;
      if (this.jdField_a_of_type_Vrh != null) {
        this.jdField_a_of_type_Vrh.a(QCircleFeedPicLoader.d, this.jdField_a_of_type_Vrd);
      }
    }
  }
  
  public void a(vrh paramvrh)
  {
    this.jdField_a_of_type_Vrh = paramvrh;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == QCircleFeedPicLoader.d) {
      return;
    }
    long l = System.currentTimeMillis();
    QLog.i(QCircleFeedPicLoader.jdField_a_of_type_JavaLangString, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " download start cost in queue: " + (l - this.jdField_a_of_type_Vrd.b.longValue()) + " ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
    if (auog.a(this.this$0.b(this.jdField_a_of_type_Vrd)))
    {
      if (this.jdField_a_of_type_Vrd.a()) {
        QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vrd, this.jdField_a_of_type_Vrh);
      }
      QLog.i(QCircleFeedPicLoader.jdField_a_of_type_JavaLangString, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " return in downLoad file exist " + (l - this.jdField_a_of_type_Vrd.b.longValue()) + " ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
      return;
    }
    this.jdField_a_of_type_Int = QCircleFeedPicLoader.b;
    if (this.jdField_a_of_type_Vrh != null) {
      this.jdField_a_of_type_Vrh.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Vrd);
    }
    vri.a().a(this.jdField_a_of_type_Vrd, new vrg(this, this.jdField_a_of_type_Vrd, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.PicDownLoadTask
 * JD-Core Version:    0.7.0.1
 */