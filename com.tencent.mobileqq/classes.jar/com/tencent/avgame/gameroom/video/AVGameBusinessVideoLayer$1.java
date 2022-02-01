package com.tencent.avgame.gameroom.video;

import android.graphics.Rect;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import ndl;
import niq;
import nlw;
import nmr;

public class AVGameBusinessVideoLayer$1
  implements Runnable
{
  public AVGameBusinessVideoLayer$1(nlw paramnlw) {}
  
  public void run()
  {
    int i = 0;
    if ((this.this$0.jdField_b_of_type_JavaUtilList.isEmpty()) || (this.this$0.jdField_b_of_type_ArrayOfNmr == null)) {
      return;
    }
    long l1 = this.this$0.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getLongAccountUin();
    for (;;)
    {
      Object localObject3;
      synchronized (this.this$0.jdField_b_of_type_JavaUtilList)
      {
        HashSet localHashSet = new HashSet();
        localObject2 = this.this$0.jdField_b_of_type_ArrayOfNmr;
        int j = localObject2.length;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (!((nmr)localObject3).a()) {
            break label369;
          }
          long l2 = Long.valueOf(((nmr)localObject3).c()).longValue();
          if (!nlw.a(this.this$0, l2))
          {
            ((nmr)localObject3).a(null, 0);
            ((nmr)localObject3).a(1);
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
        localObject3 = (niq)((Iterator)localObject2).next();
        if ((l1 == ((niq)localObject3).jdField_a_of_type_Long) && (((niq)localObject3).c)) {
          this.this$0.d = new Rect(((niq)localObject3).f, ((niq)localObject3).g, ((niq)localObject3).f + ((niq)localObject3).h, ((niq)localObject3).g + ((niq)localObject3).i);
        }
        if ((!((niq)localObject3).jdField_a_of_type_Boolean) && (!localObject1.contains(Long.valueOf(((niq)localObject3).jdField_a_of_type_Long))))
        {
          localObject3 = Long.toString(((niq)localObject3).jdField_a_of_type_Long);
          i = this.this$0.g();
          nmr localnmr = this.this$0.jdField_b_of_type_ArrayOfNmr[i];
          localnmr.a(this.this$0.jdField_a_of_type_Ndl.a((String)localObject3, (byte)1));
          localnmr.a((String)localObject3, 0);
          localnmr.a(this.this$0.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
          localnmr.a(0);
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