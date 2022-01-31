package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.TroopManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import ste;
import tdk;
import tdm;

public class TroopNickNameManager$2
  implements Runnable
{
  public TroopNickNameManager$2(tdk paramtdk, String paramString, QQUserUIItem paramQQUserUIItem, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.this$0.a.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq) != null)
    {
      localtdm = new tdm();
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq);
      localtdm.jdField_a_of_type_JavaUtilList = localArrayList;
      localtdm.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ste.a().dispatch(localtdm);
    }
    while (this.jdField_a_of_type_Boolean)
    {
      tdm localtdm;
      ArrayList localArrayList;
      return;
    }
    this.this$0.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.2
 * JD-Core Version:    0.7.0.1
 */