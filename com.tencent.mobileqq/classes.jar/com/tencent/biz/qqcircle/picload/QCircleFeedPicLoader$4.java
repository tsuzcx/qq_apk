package com.tencent.biz.qqcircle.picload;

import auog;
import vrd;
import vrh;

class QCircleFeedPicLoader$4
  implements Runnable
{
  QCircleFeedPicLoader$4(QCircleFeedPicLoader paramQCircleFeedPicLoader, vrd paramvrd, vrh paramvrh) {}
  
  public void run()
  {
    QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vrd, this.jdField_a_of_type_Vrd.a());
    if (auog.a(this.this$0.b(this.jdField_a_of_type_Vrd)))
    {
      if (this.jdField_a_of_type_Vrd.a())
      {
        this.jdField_a_of_type_Vrd.d = 1;
        QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vrd, this.jdField_a_of_type_Vrh);
      }
      return;
    }
    vrd localvrd1 = this.jdField_a_of_type_Vrd;
    vrd localvrd2 = this.jdField_a_of_type_Vrd;
    localvrd1.d = 2;
    QCircleFeedPicLoader.b(this.this$0, this.jdField_a_of_type_Vrd, this.jdField_a_of_type_Vrh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.4
 * JD-Core Version:    0.7.0.1
 */