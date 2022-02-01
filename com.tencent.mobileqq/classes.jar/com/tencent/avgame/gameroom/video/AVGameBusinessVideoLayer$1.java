package com.tencent.avgame.gameroom.video;

import android.graphics.Rect;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mxo;
import nbr;
import ndx;
import nes;

public class AVGameBusinessVideoLayer$1
  implements Runnable
{
  public AVGameBusinessVideoLayer$1(ndx paramndx) {}
  
  public void run()
  {
    int i = 0;
    if ((this.this$0.jdField_b_of_type_JavaUtilList.isEmpty()) || (this.this$0.jdField_b_of_type_ArrayOfNes == null)) {
      return;
    }
    long l1 = this.this$0.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getLongAccountUin();
    for (;;)
    {
      Object localObject3;
      synchronized (this.this$0.jdField_b_of_type_JavaUtilList)
      {
        HashSet localHashSet = new HashSet();
        localObject2 = this.this$0.jdField_b_of_type_ArrayOfNes;
        int j = localObject2.length;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (!((nes)localObject3).a()) {
            break label369;
          }
          long l2 = Long.valueOf(((nes)localObject3).b()).longValue();
          if (!ndx.a(this.this$0, l2))
          {
            ((nes)localObject3).a(null, 0);
            ((nes)localObject3).a(1);
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
        localObject3 = (nbr)((Iterator)localObject2).next();
        if ((l1 == ((nbr)localObject3).jdField_a_of_type_Long) && (((nbr)localObject3).c)) {
          this.this$0.d = new Rect(((nbr)localObject3).f, ((nbr)localObject3).g, ((nbr)localObject3).f + ((nbr)localObject3).h, ((nbr)localObject3).g + ((nbr)localObject3).i);
        }
        if ((!((nbr)localObject3).jdField_a_of_type_Boolean) && (!localObject1.contains(Long.valueOf(((nbr)localObject3).jdField_a_of_type_Long))))
        {
          localObject3 = Long.toString(((nbr)localObject3).jdField_a_of_type_Long);
          i = this.this$0.g();
          nes localnes = this.this$0.jdField_b_of_type_ArrayOfNes[i];
          localnes.a(this.this$0.jdField_a_of_type_Mxo.a((String)localObject3, (byte)1));
          localnes.a((String)localObject3, 0);
          localnes.a(this.this$0.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
          localnes.a(0);
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