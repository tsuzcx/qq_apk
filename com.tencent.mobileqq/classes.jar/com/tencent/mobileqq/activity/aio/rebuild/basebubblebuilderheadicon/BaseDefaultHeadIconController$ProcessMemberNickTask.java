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
  QQAppInterface a;
  Context b;
  View c;
  String d;
  String e;
  int f;
  View.OnLongClickListener g;
  
  public BaseDefaultHeadIconController$ProcessMemberNickTask(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, String paramString1, String paramString2, int paramInt, View.OnLongClickListener paramOnLongClickListener)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.c = paramView;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramInt;
    this.g = paramOnLongClickListener;
  }
  
  public void run()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (this.b != null) && (this.c != null))
    {
      if (this.g == null) {
        return;
      }
      int i = this.f;
      if (i == 1) {
        localObject1 = ContactUtils.b((AppInterface)localObject1, this.d, this.e);
      } else if (i == 3000) {
        localObject1 = ContactUtils.a((BaseQQAppInterface)localObject1, this.d, this.e);
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
      localObject1 = this.b;
      if ((localObject1 instanceof Activity)) {
        ((Activity)localObject1).runOnUiThread(new BaseDefaultHeadIconController.ProcessMemberNickTask.1(this, localObject3));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.BaseDefaultHeadIconController.ProcessMemberNickTask
 * JD-Core Version:    0.7.0.1
 */