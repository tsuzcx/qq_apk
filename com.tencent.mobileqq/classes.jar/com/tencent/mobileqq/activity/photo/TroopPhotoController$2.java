package com.tencent.mobileqq.activity.photo;

import aglg;
import agqk;
import bamm;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopPhotoController$2
  implements Runnable
{
  public TroopPhotoController$2(agqk paramagqk, bamm parambamm, aglg paramaglg, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bamm.c;
    this.jdField_a_of_type_Aglg.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aglg.b = 1;
    this.jdField_a_of_type_Aglg.c = false;
    this.this$0.c(this.jdField_a_of_type_Aglg);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1)) {
      this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Aglg);
    }
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
      if (localTroopClipPic.ts == this.jdField_a_of_type_Aglg.jdField_a_of_type_Long) {
        this.this$0.a.remove(localTroopClipPic);
      }
    }
    this.this$0.a(this.jdField_a_of_type_Aglg, this.jdField_a_of_type_Bamm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.2
 * JD-Core Version:    0.7.0.1
 */