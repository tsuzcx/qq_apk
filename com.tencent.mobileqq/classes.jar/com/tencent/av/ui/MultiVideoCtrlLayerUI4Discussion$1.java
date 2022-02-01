package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

class MultiVideoCtrlLayerUI4Discussion$1
  implements Runnable
{
  MultiVideoCtrlLayerUI4Discussion$1(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject2 = null;
    if (this.jdField_a_of_type_Int == 2131695542)
    {
      if (this.this$0.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_JavaLangString)) {
        localObject2 = (String)this.this$0.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!TextUtils.equals((CharSequence)localObject2, "QQ")) {}
      }
      else
      {
        localObject1 = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, String.valueOf(this.this$0.b), this.this$0.jdField_e_of_type_Int);
      }
    }
    else
    {
      localObject2 = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, String.valueOf(this.this$0.b), this.this$0.jdField_e_of_type_Int);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!TextUtils.equals((CharSequence)localObject2, "QQ")) {}
      }
      else
      {
        localObject1 = localObject2;
        if (this.this$0.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_JavaLangString)) {
          localObject1 = (String)this.this$0.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    float f = this.this$0.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297162);
    Object localObject1 = UITools.a((Context)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject1, this.this$0.jdField_e_of_type_AndroidWidgetTextView, f);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.this$0.jdField_a_of_type_AndroidContentResResources.getString(this.jdField_a_of_type_Int));
    localObject1 = ((StringBuilder)localObject2).toString();
    TipsUtil.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3009, (String)localObject1);
    localObject2 = this.this$0.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showHrMeetingInOrOutWordingWithDelay str=");
    localStringBuilder.append((String)localObject1);
    QLog.e((String)localObject2, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.1
 * JD-Core Version:    0.7.0.1
 */