package com.tencent.avgame.gameroom.video;

import android.graphics.Rect;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mwp;
import nan;
import nck;
import nda;

public class AVGameBusinessVideoLayer$1
  implements Runnable
{
  public AVGameBusinessVideoLayer$1(nck paramnck) {}
  
  public void run()
  {
    int i = 0;
    if ((this.this$0.jdField_b_of_type_JavaUtilList.isEmpty()) || (this.this$0.jdField_b_of_type_ArrayOfNda == null)) {
      return;
    }
    long l1 = this.this$0.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getLongAccountUin();
    for (;;)
    {
      Object localObject3;
      synchronized (this.this$0.jdField_b_of_type_JavaUtilList)
      {
        HashSet localHashSet = new HashSet();
        localObject2 = this.this$0.jdField_b_of_type_ArrayOfNda;
        int j = localObject2.length;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (!((nda)localObject3).a()) {
            break label369;
          }
          long l2 = Long.valueOf(((nda)localObject3).b()).longValue();
          if (!nck.a(this.this$0, l2))
          {
            ((nda)localObject3).a(null, 0);
            ((nda)localObject3).a(1);
          }
          else
          {
            localHashSet.add(Long.valueOf(l2));
          }
        }
      }
      Object localObject2 = this.this$0.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (nan)((Iterator)localObject2).next();
        if ((l1 == ((nan)localObject3).jdField_a_of_type_Long) && (((nan)localObject3).c)) {
          this.this$0.d = new Rect(((nan)localObject3).f, ((nan)localObject3).g, ((nan)localObject3).f + ((nan)localObject3).h, ((nan)localObject3).g + ((nan)localObject3).i);
        }
        if ((!((nan)localObject3).jdField_a_of_type_Boolean) && (!localObject1.contains(Long.valueOf(((nan)localObject3).jdField_a_of_type_Long))))
        {
          localObject3 = Long.toString(((nan)localObject3).jdField_a_of_type_Long);
          i = this.this$0.g();
          nda localnda = this.this$0.jdField_b_of_type_ArrayOfNda[i];
          localnda.a(this.this$0.jdField_a_of_type_Mwp.a((String)localObject3, (byte)1));
          localnda.a((String)localObject3, 0);
          localnda.a(this.this$0.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
          localnda.a(0);
        }
      }
      this.this$0.b();
      return;
      label369:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameBusinessVideoLayer.1
 * JD-Core Version:    0.7.0.1
 */