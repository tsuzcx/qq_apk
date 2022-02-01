package com.tencent.avgame.ui;

import java.util.ArrayList;
import java.util.List;
import ndn;
import npl;
import npm;

public class AVGameRoomListFragment$AVGameRoomListAdapter$1$1
  implements Runnable
{
  public AVGameRoomListFragment$AVGameRoomListAdapter$1$1(npm paramnpm, ndn paramndn) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ndn == null) || (this.jdField_a_of_type_Ndn.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_Ndn.jdField_a_of_type_JavaUtilList == null) || (!npl.a(this.jdField_a_of_type_Npm.a).equals(this.jdField_a_of_type_Ndn.jdField_a_of_type_JavaLangString))) {}
    while ((npl.a(this.jdField_a_of_type_Npm.a) > 0) && (this.jdField_a_of_type_Ndn.c == 0) && (this.jdField_a_of_type_Ndn.b <= npl.a(this.jdField_a_of_type_Npm.a))) {
      return;
    }
    Object localObject = new ArrayList();
    if (npl.a(this.jdField_a_of_type_Npm.a) > 0)
    {
      ((List)localObject).addAll(npl.a(this.jdField_a_of_type_Npm.a));
      npl.a(this.jdField_a_of_type_Npm.a, (List)localObject, this.jdField_a_of_type_Ndn.jdField_a_of_type_JavaUtilList);
      npl.a(this.jdField_a_of_type_Npm.a, (List)localObject);
      npl.a(this.jdField_a_of_type_Npm.a, this.jdField_a_of_type_Ndn.b);
      localObject = this.jdField_a_of_type_Npm.a;
      if (this.jdField_a_of_type_Ndn.c <= 0) {
        break label234;
      }
    }
    label234:
    for (boolean bool = true;; bool = false)
    {
      npl.a((npl)localObject, bool);
      this.jdField_a_of_type_Npm.a.notifyDataSetChanged();
      return;
      ((List)localObject).addAll(this.jdField_a_of_type_Ndn.jdField_a_of_type_JavaUtilList);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.AVGameRoomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */