package com.tencent.avgame.ui;

import java.util.ArrayList;
import java.util.List;
import mxq;
import nhb;
import nhc;

public class AVGameRoomListFragment$AVGameRoomListAdapter$1$1
  implements Runnable
{
  public AVGameRoomListFragment$AVGameRoomListAdapter$1$1(nhc paramnhc, mxq parammxq) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Mxq == null) || (this.jdField_a_of_type_Mxq.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_Mxq.jdField_a_of_type_JavaUtilList == null) || (!nhb.a(this.jdField_a_of_type_Nhc.a).equals(this.jdField_a_of_type_Mxq.jdField_a_of_type_JavaLangString))) {}
    while ((nhb.a(this.jdField_a_of_type_Nhc.a) > 0) && (this.jdField_a_of_type_Mxq.c == 0) && (this.jdField_a_of_type_Mxq.b <= nhb.a(this.jdField_a_of_type_Nhc.a))) {
      return;
    }
    Object localObject = new ArrayList();
    if (nhb.a(this.jdField_a_of_type_Nhc.a) > 0)
    {
      ((List)localObject).addAll(nhb.a(this.jdField_a_of_type_Nhc.a));
      nhb.a(this.jdField_a_of_type_Nhc.a, (List)localObject, this.jdField_a_of_type_Mxq.jdField_a_of_type_JavaUtilList);
      nhb.a(this.jdField_a_of_type_Nhc.a, (List)localObject);
      nhb.a(this.jdField_a_of_type_Nhc.a, this.jdField_a_of_type_Mxq.b);
      localObject = this.jdField_a_of_type_Nhc.a;
      if (this.jdField_a_of_type_Mxq.c <= 0) {
        break label234;
      }
    }
    label234:
    for (boolean bool = true;; bool = false)
    {
      nhb.a((nhb)localObject, bool);
      this.jdField_a_of_type_Nhc.a.notifyDataSetChanged();
      return;
      ((List)localObject).addAll(this.jdField_a_of_type_Mxq.jdField_a_of_type_JavaUtilList);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.AVGameRoomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */