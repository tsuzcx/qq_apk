package com.tencent.mobileqq.activity.photo;

import akps;
import aksb;
import bgup;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopPhotoController$2
  implements Runnable
{
  public TroopPhotoController$2(aksb paramaksb, bgup parambgup, akps paramakps, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Bgup.c;
    this.jdField_a_of_type_Akps.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Akps.b = 1;
    this.jdField_a_of_type_Akps.c = false;
    this.this$0.c(this.jdField_a_of_type_Akps);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i >= 1)) {
      this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Akps);
    }
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
      if (localTroopClipPic.ts == this.jdField_a_of_type_Akps.jdField_a_of_type_Long) {
        this.this$0.a.remove(localTroopClipPic);
      }
    }
    this.this$0.a(this.jdField_a_of_type_Akps, this.jdField_a_of_type_Bgup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.2
 * JD-Core Version:    0.7.0.1
 */