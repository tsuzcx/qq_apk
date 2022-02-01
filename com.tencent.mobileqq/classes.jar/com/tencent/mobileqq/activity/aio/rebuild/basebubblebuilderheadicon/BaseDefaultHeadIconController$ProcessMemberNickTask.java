package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import java.io.UnsupportedEncodingException;

class BaseDefaultHeadIconController$ProcessMemberNickTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  View jdField_a_of_type_AndroidViewView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public BaseDefaultHeadIconController$ProcessMemberNickTask(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, String paramString1, String paramString2, int paramInt, View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject1 != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (this.jdField_a_of_type_AndroidViewView$OnLongClickListener == null) {
        return;
      }
      int i = this.jdField_a_of_type_Int;
      if (i == 1) {
        localObject1 = ContactUtils.b((AppInterface)localObject1, this.jdField_a_of_type_JavaLangString, this.b);
      } else if (i == 3000) {
        localObject1 = ContactUtils.a((BaseQQAppInterface)localObject1, this.jdField_a_of_type_JavaLangString, this.b);
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).getBytes().length > 3)
        {
          byte[] arrayOfByte = ((String)localObject1).getBytes();
          localObject2 = localObject1;
          if (arrayOfByte[0] == -17)
          {
            localObject2 = localObject1;
            if (arrayOfByte[1] == -69)
            {
              localObject2 = localObject1;
              if (arrayOfByte[2] == -65)
              {
                localObject2 = new byte[arrayOfByte.length - 3];
                System.arraycopy(arrayOfByte, 3, localObject2, 0, localObject2.length);
                try
                {
                  localObject2 = new String((byte[])localObject2, "UTF-8");
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  localUnsupportedEncodingException.printStackTrace();
                  localObject3 = localObject1;
                }
              }
            }
          }
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      if ((localObject1 instanceof Activity)) {
        ((Activity)localObject1).runOnUiThread(new BaseDefaultHeadIconController.ProcessMemberNickTask.1(this, localObject3));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.BaseDefaultHeadIconController.ProcessMemberNickTask
 * JD-Core Version:    0.7.0.1
 */