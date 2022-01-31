package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uuc;
import uud;
import uuj;
import uzc;

public class MsgTabNodeListLoader$1$1
  implements Runnable
{
  public MsgTabNodeListLoader$1$1(uud paramuud, uzc paramuzc) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Uzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {
      this.jdField_a_of_type_Uud.a.a(this.jdField_a_of_type_Uzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
    }
    Object localObject2;
    if (this.jdField_a_of_type_Uzc.jdField_a_of_type_JavaUtilList != null)
    {
      ??? = this.jdField_a_of_type_Uzc.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (QQUserUIItem)((Iterator)???).next();
        this.jdField_a_of_type_Uud.a.a(this.jdField_a_of_type_Uzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      }
    }
    synchronized (this.jdField_a_of_type_Uud.a.d)
    {
      localObject2 = this.jdField_a_of_type_Uud.a.d.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((uuj)((Iterator)localObject2).next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.1.1
 * JD-Core Version:    0.7.0.1
 */