package com.tencent.mobileqq.activity.photo;

import akps;
import aksb;
import bgqu;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopPhotoController$3
  implements Runnable
{
  public TroopPhotoController$3(aksb paramaksb, akps paramakps, String paramString) {}
  
  public void run()
  {
    if (!this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin)) {
      this.this$0.jdField_a_of_type_Bgqu.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
    }
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
      if (localTroopClipPic.ts == this.jdField_a_of_type_Akps.a) {
        this.this$0.jdField_a_of_type_JavaUtilArrayList.remove(localTroopClipPic);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Akps);
    this.this$0.b(this.jdField_a_of_type_Akps);
    aksb.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.3
 * JD-Core Version:    0.7.0.1
 */