package com.tencent.biz.qqstory.playvideo;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.ContactSorter;
import java.util.Comparator;

class MyVideoVisiblePersonPageView$3
  implements Comparator<QQUserUIItem>
{
  MyVideoVisiblePersonPageView$3(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public int a(QQUserUIItem paramQQUserUIItem1, QQUserUIItem paramQQUserUIItem2)
  {
    return ContactSorter.a(paramQQUserUIItem1.mComparePartInt, paramQQUserUIItem1.mCompareSpell, paramQQUserUIItem2.mComparePartInt, paramQQUserUIItem2.mCompareSpell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView.3
 * JD-Core Version:    0.7.0.1
 */