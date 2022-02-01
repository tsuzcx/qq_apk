package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

class QAVPtvTemplateAdapter$6
  implements Runnable
{
  QAVPtvTemplateAdapter$6(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter, String paramString, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    int k = this.this$0.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int m = this.this$0.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = 0;
    Object localObject1;
    while (i < this.this$0.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (QavListItemBase.ItemInfo)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localObject1 != null) && (((QavListItemBase.ItemInfo)localObject1).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
      {
        ((QavListItemBase.ItemInfo)localObject1).b = false;
        ((QavListItemBase.ItemInfo)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
        j = i;
        if (i < k) {
          break label195;
        }
        j = i;
        if (i > m) {
          break label195;
        }
        localObject1 = this.this$0.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - k);
        j = i;
        if (!(localObject1 instanceof QavListItemBase)) {
          break label195;
        }
        j = i;
        if (!this.this$0.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter().equals(this.this$0)) {
          break label195;
        }
        localObject1 = (QavListItemBase)localObject1;
        if (this.jdField_a_of_type_Boolean) {
          j = 1000;
        } else {
          j = -1;
        }
        ((QavListItemBase)localObject1).a(j);
        j = i;
        break label195;
      }
      i += 1;
    }
    int j = -1;
    label195:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDownloadFinish, seq[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject1).append("], id[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("], suc[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject1).append("], sel[");
      ((StringBuilder)localObject1).append(this.this$0.d);
      ((StringBuilder)localObject1).append("]");
      QLog.i("QAVPtvTemplateAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.this$0.d == j)
      {
        localObject1 = localObject2;
        if (j != -1) {
          localObject1 = (QavListItemBase.ItemInfo)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(j);
        }
      }
      if (localObject1 != null) {
        this.this$0.a(this.jdField_a_of_type_Long, (QavListItemBase.ItemInfo)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter.6
 * JD-Core Version:    0.7.0.1
 */