package com.tencent.avgame.gameroom.video;

import android.graphics.Rect;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mxz;
import ncs;
import nfe;
import nfz;

public class AVGameBusinessVideoLayer$1
  implements Runnable
{
  public AVGameBusinessVideoLayer$1(nfe paramnfe) {}
  
  public void run()
  {
    int i = 0;
    if ((this.this$0.jdField_b_of_type_JavaUtilList.isEmpty()) || (this.this$0.jdField_b_of_type_ArrayOfNfz == null)) {
      return;
    }
    long l1 = this.this$0.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getLongAccountUin();
    for (;;)
    {
      Object localObject3;
      synchronized (this.this$0.jdField_b_of_type_JavaUtilList)
      {
        HashSet localHashSet = new HashSet();
        localObject2 = this.this$0.jdField_b_of_type_ArrayOfNfz;
        int j = localObject2.length;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (!((nfz)localObject3).a()) {
            break label369;
          }
          long l2 = Long.valueOf(((nfz)localObject3).b()).longValue();
          if (!nfe.a(this.this$0, l2))
          {
            ((nfz)localObject3).a(null, 0);
            ((nfz)localObject3).a(1);
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
        localObject3 = (ncs)((Iterator)localObject2).next();
        if ((l1 == ((ncs)localObject3).jdField_a_of_type_Long) && (((ncs)localObject3).c)) {
          this.this$0.d = new Rect(((ncs)localObject3).f, ((ncs)localObject3).g, ((ncs)localObject3).f + ((ncs)localObject3).h, ((ncs)localObject3).g + ((ncs)localObject3).i);
        }
        if ((!((ncs)localObject3).jdField_a_of_type_Boolean) && (!localObject1.contains(Long.valueOf(((ncs)localObject3).jdField_a_of_type_Long))))
        {
          localObject3 = Long.toString(((ncs)localObject3).jdField_a_of_type_Long);
          i = this.this$0.g();
          nfz localnfz = this.this$0.jdField_b_of_type_ArrayOfNfz[i];
          localnfz.a(this.this$0.jdField_a_of_type_Mxz.a((String)localObject3, (byte)1));
          localnfz.a((String)localObject3, 0);
          localnfz.a(this.this$0.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
          localnfz.a(0);
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