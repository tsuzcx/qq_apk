package com.tencent.avgame.ui;

import java.util.ArrayList;
import java.util.List;
import mwr;
import nfh;
import nfi;

public class AVGameRoomListFragment$AVGameRoomListAdapter$1$1
  implements Runnable
{
  public AVGameRoomListFragment$AVGameRoomListAdapter$1$1(nfi paramnfi, mwr parammwr) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Mwr == null) || (this.jdField_a_of_type_Mwr.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_Mwr.jdField_a_of_type_JavaUtilList == null) || (!nfh.a(this.jdField_a_of_type_Nfi.a).equals(this.jdField_a_of_type_Mwr.jdField_a_of_type_JavaLangString))) {}
    while ((nfh.a(this.jdField_a_of_type_Nfi.a) > 0) && (this.jdField_a_of_type_Mwr.c == 0) && (this.jdField_a_of_type_Mwr.b <= nfh.a(this.jdField_a_of_type_Nfi.a))) {
      return;
    }
    Object localObject = new ArrayList();
    if (nfh.a(this.jdField_a_of_type_Nfi.a) > 0)
    {
      ((List)localObject).addAll(nfh.a(this.jdField_a_of_type_Nfi.a));
      nfh.a(this.jdField_a_of_type_Nfi.a, (List)localObject, this.jdField_a_of_type_Mwr.jdField_a_of_type_JavaUtilList);
      nfh.a(this.jdField_a_of_type_Nfi.a, (List)localObject);
      nfh.a(this.jdField_a_of_type_Nfi.a, this.jdField_a_of_type_Mwr.b);
      localObject = this.jdField_a_of_type_Nfi.a;
      if (this.jdField_a_of_type_Mwr.c <= 0) {
        break label234;
      }
    }
    label234:
    for (boolean bool = true;; bool = false)
    {
      nfh.a((nfh)localObject, bool);
      this.jdField_a_of_type_Nfi.a.notifyDataSetChanged();
      return;
      ((List)localObject).addAll(this.jdField_a_of_type_Mwr.jdField_a_of_type_JavaUtilList);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.AVGameRoomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */