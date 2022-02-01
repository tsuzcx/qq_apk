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
    if (i < this.this$0.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (QavListItemBase.ItemInfo)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localObject1 != null) && (((QavListItemBase.ItemInfo)localObject1).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
      {
        ((QavListItemBase.ItemInfo)localObject1).b = false;
        ((QavListItemBase.ItemInfo)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
        j = i;
        if (i >= k)
        {
          j = i;
          if (i <= m)
          {
            localObject1 = this.this$0.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - k);
            j = i;
            if ((localObject1 instanceof QavListItemBase))
            {
              j = i;
              if (this.this$0.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter().equals(this.this$0))
              {
                localObject1 = (QavListItemBase)localObject1;
                if (!this.jdField_a_of_type_Boolean) {
                  break label325;
                }
                j = 1000;
                label170:
                ((QavListItemBase)localObject1).a(j);
              }
            }
          }
        }
      }
    }
    for (int j = i;; j = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QAVPtvTemplateAdapter", 2, "onDownloadFinish, seq[" + this.jdField_a_of_type_Long + "], id[" + this.jdField_a_of_type_JavaLangString + "], suc[" + this.jdField_a_of_type_Boolean + "], sel[" + this.this$0.d + "]");
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
      return;
      label325:
      j = -1;
      break label170;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter.6
 * JD-Core Version:    0.7.0.1
 */