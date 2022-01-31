package com.tencent.mobileqq.activity.aio.anim;

import aciy;
import acju;
import adlv;
import ajrm;
import almn;
import almt;
import almu;
import alnt;
import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import awnu;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;

public class VoicePrintUtils
{
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, adlv paramadlv)
  {
    int j = 0;
    int i = j;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramBoolean)
      {
        localObject = paramadlv.jdField_a_of_type_Almt.a(paramQQAppInterface, 7);
        if (localObject != null) {
          break label39;
        }
        i = j;
      }
    }
    label39:
    do
    {
      return i;
      localObject = (almu)((Pair)localObject).first;
      if ((paramadlv.jdField_a_of_type_AndroidViewView == null) || (paramadlv.jdField_a_of_type_AndroidViewView.getHeight() <= 0)) {
        break;
      }
      j = paramadlv.jdField_a_of_type_AndroidViewView.getHeight() - ((almu)localObject).a.h - ((almu)localObject).a.i;
      i = j;
    } while (j <= paramadlv.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
    return paramadlv.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    return aciy.a(57.0F, paramQQAppInterface.getApp().getResources()) - ((almu)localObject).a.h - ((almu)localObject).a.i;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, acju paramacju, MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = true;
    if (awnu.b()) {}
    label133:
    label140:
    for (;;)
    {
      return false;
      if (paramMessageForPtt.needVipBubble())
      {
        int i = BubbleManager.a;
        if (i == 0) {
          i = ((ajrm)paramQQAppInterface.a(13)).a(paramMessageForPtt);
        }
        for (;;)
        {
          if (i == 0) {
            break label140;
          }
          paramMessageForPtt = paramContext.getResources();
          if (!(paramContext instanceof MultiForwardActivity))
          {
            bool1 = true;
            paramacju.jdField_a_of_type_Almt = alnt.a(i, paramQQAppInterface, paramMessageForPtt, paramBaseAdapter, bool1);
            if ((paramacju.jdField_a_of_type_Almt == null) || (paramacju.jdField_a_of_type_Almt.a <= 0)) {
              break;
            }
            paramQQAppInterface = paramacju.jdField_a_of_type_Almt.a(paramQQAppInterface, 7);
            if ((paramQQAppInterface == null) || (paramQQAppInterface.first == null)) {
              break label133;
            }
          }
          for (boolean bool1 = bool2;; bool1 = false)
          {
            return bool1;
            bool1 = false;
            break;
          }
        }
      }
    }
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, int paramInt, adlv paramadlv)
  {
    int i;
    Object localObject;
    int j;
    int m;
    if ((paramBoolean1) && (paramQQAppInterface != null))
    {
      if (paramBoolean2) {}
      for (float f = 6.0F;; f = 24.0F)
      {
        i = paramInt + aciy.a(f, paramQQAppInterface.getApp().getResources());
        localObject = paramadlv.jdField_a_of_type_Almt.a(paramQQAppInterface, 7);
        if (localObject != null) {
          break;
        }
        return new int[] { i, 0, 0 };
      }
      localObject = (almu)((Pair)localObject).first;
      if (paramadlv.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft() > 0)
      {
        paramInt = ((almu)localObject).a.f - paramadlv.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft();
        j = paramInt;
        if (paramInt < 0) {
          j = 0;
        }
        m = aciy.a(6.0F, paramQQAppInterface.getApp().getResources());
        i = i - j - m;
        paramQQAppInterface = ((almu)localObject).a.c;
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length <= 0)) {
          break label338;
        }
        if (i > paramQQAppInterface[0]) {
          break label232;
        }
        i = paramQQAppInterface[0];
        paramInt = 0;
      }
    }
    label338:
    for (;;)
    {
      return new int[] { i, paramInt / 2 + j, paramInt / 2 + m };
      paramInt = ((almu)localObject).a.f - aciy.a(12.0F, paramQQAppInterface.getApp().getResources());
      break;
      label232:
      if (i >= paramQQAppInterface[(paramQQAppInterface.length - 1)])
      {
        paramInt = i - paramQQAppInterface[(paramQQAppInterface.length - 1)];
        i = paramQQAppInterface[(paramQQAppInterface.length - 1)];
      }
      else
      {
        paramInt = 0;
        for (;;)
        {
          if (paramInt < paramQQAppInterface.length - 1)
          {
            if ((i >= paramQQAppInterface[paramInt]) && (i < paramQQAppInterface[(paramInt + 1)]))
            {
              int n = paramQQAppInterface[paramInt];
              int k = paramQQAppInterface[paramInt];
              paramInt = i - n;
              i = k;
              break;
            }
            paramInt += 1;
            continue;
            return new int[] { paramInt, 0, 0 };
          }
        }
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils
 * JD-Core Version:    0.7.0.1
 */