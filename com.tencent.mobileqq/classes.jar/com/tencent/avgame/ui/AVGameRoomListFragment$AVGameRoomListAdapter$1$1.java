package com.tencent.avgame.ui;

import java.util.ArrayList;
import java.util.List;
import myb;
import nio;
import nip;

public class AVGameRoomListFragment$AVGameRoomListAdapter$1$1
  implements Runnable
{
  public AVGameRoomListFragment$AVGameRoomListAdapter$1$1(nip paramnip, myb parammyb) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Myb == null) || (this.jdField_a_of_type_Myb.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_Myb.jdField_a_of_type_JavaUtilList == null) || (!nio.a(this.jdField_a_of_type_Nip.a).equals(this.jdField_a_of_type_Myb.jdField_a_of_type_JavaLangString))) {}
    while ((nio.a(this.jdField_a_of_type_Nip.a) > 0) && (this.jdField_a_of_type_Myb.c == 0) && (this.jdField_a_of_type_Myb.b <= nio.a(this.jdField_a_of_type_Nip.a))) {
      return;
    }
    Object localObject = new ArrayList();
    if (nio.a(this.jdField_a_of_type_Nip.a) > 0)
    {
      ((List)localObject).addAll(nio.a(this.jdField_a_of_type_Nip.a));
      nio.a(this.jdField_a_of_type_Nip.a, (List)localObject, this.jdField_a_of_type_Myb.jdField_a_of_type_JavaUtilList);
      nio.a(this.jdField_a_of_type_Nip.a, (List)localObject);
      nio.a(this.jdField_a_of_type_Nip.a, this.jdField_a_of_type_Myb.b);
      localObject = this.jdField_a_of_type_Nip.a;
      if (this.jdField_a_of_type_Myb.c <= 0) {
        break label234;
      }
    }
    label234:
    for (boolean bool = true;; bool = false)
    {
      nio.a((nio)localObject, bool);
      this.jdField_a_of_type_Nip.a.notifyDataSetChanged();
      return;
      ((List)localObject).addAll(this.jdField_a_of_type_Myb.jdField_a_of_type_JavaUtilList);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.AVGameRoomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */