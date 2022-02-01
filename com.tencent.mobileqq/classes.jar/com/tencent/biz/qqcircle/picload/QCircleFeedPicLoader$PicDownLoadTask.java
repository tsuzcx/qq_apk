package com.tencent.biz.qqcircle.picload;

import atwl;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import vou;
import vox;
import voy;
import voz;

public class QCircleFeedPicLoader$PicDownLoadTask
  implements Runnable
{
  protected volatile int a;
  public vou a;
  public voy a;
  
  public QCircleFeedPicLoader$PicDownLoadTask(QCircleFeedPicLoader paramQCircleFeedPicLoader, @NotNull vou paramvou)
  {
    this.jdField_a_of_type_Vou = paramvou;
    this.jdField_a_of_type_Int = QCircleFeedPicLoader.jdField_a_of_type_Int;
  }
  
  public vou a()
  {
    return this.jdField_a_of_type_Vou;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int != QCircleFeedPicLoader.f)
    {
      this.jdField_a_of_type_Int = QCircleFeedPicLoader.d;
      if (this.jdField_a_of_type_Voy != null) {
        this.jdField_a_of_type_Voy.a(QCircleFeedPicLoader.d, this.jdField_a_of_type_Vou);
      }
    }
  }
  
  public void a(voy paramvoy)
  {
    this.jdField_a_of_type_Voy = paramvoy;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == QCircleFeedPicLoader.d) {
      return;
    }
    long l = System.currentTimeMillis();
    QLog.d(QCircleFeedPicLoader.jdField_a_of_type_JavaLangString, 1, "seq = " + this.jdField_a_of_type_Vou.a() + " , download start cost in queue: " + (l - this.jdField_a_of_type_Vou.b.longValue()) + " ifFromPreload:" + this.jdField_a_of_type_Vou.b());
    if (atwl.a(this.this$0.b(this.jdField_a_of_type_Vou)))
    {
      if (this.jdField_a_of_type_Vou.a()) {
        QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vou, this.jdField_a_of_type_Voy);
      }
      QLog.d(QCircleFeedPicLoader.jdField_a_of_type_JavaLangString, 1, "seq = " + this.jdField_a_of_type_Vou.a() + " , return in downLoad file exist " + (l - this.jdField_a_of_type_Vou.b.longValue()) + " ifFromPreload:" + this.jdField_a_of_type_Vou.b());
      return;
    }
    this.jdField_a_of_type_Int = QCircleFeedPicLoader.b;
    if (this.jdField_a_of_type_Voy != null) {
      this.jdField_a_of_type_Voy.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Vou);
    }
    voz.a().a(this.jdField_a_of_type_Vou, new vox(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.PicDownLoadTask
 * JD-Core Version:    0.7.0.1
 */