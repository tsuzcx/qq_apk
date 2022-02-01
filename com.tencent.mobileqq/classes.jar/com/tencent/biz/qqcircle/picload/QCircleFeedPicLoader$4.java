package com.tencent.biz.qqcircle.picload;

import atwl;
import vou;
import voy;

class QCircleFeedPicLoader$4
  implements Runnable
{
  QCircleFeedPicLoader$4(QCircleFeedPicLoader paramQCircleFeedPicLoader, vou paramvou, voy paramvoy) {}
  
  public void run()
  {
    QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vou, this.jdField_a_of_type_Vou.a());
    if (atwl.a(this.this$0.b(this.jdField_a_of_type_Vou)))
    {
      if (this.jdField_a_of_type_Vou.a())
      {
        this.jdField_a_of_type_Vou.d = 1;
        QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vou, this.jdField_a_of_type_Voy);
      }
      return;
    }
    vou localvou1 = this.jdField_a_of_type_Vou;
    vou localvou2 = this.jdField_a_of_type_Vou;
    localvou1.d = 2;
    QCircleFeedPicLoader.b(this.this$0, this.jdField_a_of_type_Vou, this.jdField_a_of_type_Voy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.4
 * JD-Core Version:    0.7.0.1
 */