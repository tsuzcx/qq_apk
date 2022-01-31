package com.tencent.mobileqq.app;

import alro;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;

public class MayknowRecommendManager$4
  implements Runnable
{
  public MayknowRecommendManager$4(alro paramalro, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    alro.a(this.this$0, this.jdField_a_of_type_Int);
    for (;;)
    {
      synchronized (alro.b(this.this$0))
      {
        ArrayList localArrayList = (ArrayList)alro.a(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
        if ((localArrayList == null) || (localArrayList.isEmpty()))
        {
          i = 1;
          if (i != 0) {
            break label124;
          }
          bool = this.this$0.b(this.b);
          if (bool) {
            ((FriendListHandler)alro.a(this.this$0).a(1)).a(this.b, this.jdField_a_of_type_Int, null, true, this.jdField_a_of_type_AndroidOsBundle);
          }
          return;
        }
      }
      int i = 0;
      continue;
      label124:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.4
 * JD-Core Version:    0.7.0.1
 */