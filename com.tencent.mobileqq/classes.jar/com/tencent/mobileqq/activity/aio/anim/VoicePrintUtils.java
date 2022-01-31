package com.tencent.mobileqq.activity.aio.anim;

import aekt;
import aelt;
import aftf;
import alxl;
import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import anrz;
import ansf;
import ansg;
import antf;
import azib;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;

public class VoicePrintUtils
{
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aftf paramaftf)
  {
    int j = 0;
    int i = j;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramBoolean)
      {
        localObject = paramaftf.jdField_a_of_type_Ansf.a(paramQQAppInterface, 7);
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
      localObject = (ansg)((Pair)localObject).first;
      if ((paramaftf.jdField_a_of_type_AndroidViewView == null) || (paramaftf.jdField_a_of_type_AndroidViewView.getHeight() <= 0)) {
        break;
      }
      j = paramaftf.jdField_a_of_type_AndroidViewView.getHeight() - ((ansg)localObject).a.h - ((ansg)localObject).a.i;
      i = j;
    } while (j <= paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
    return paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    return aekt.a(57.0F, paramQQAppInterface.getApp().getResources()) - ((ansg)localObject).a.h - ((ansg)localObject).a.i;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, aelt paramaelt, MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = true;
    if (azib.b()) {}
    label133:
    label140:
    for (;;)
    {
      return false;
      if (paramMessageForPtt.needVipBubble())
      {
        int i = BubbleManager.a;
        if (i == 0) {
          i = ((alxl)paramQQAppInterface.a(13)).a(paramMessageForPtt);
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
            paramaelt.jdField_a_of_type_Ansf = antf.a(i, paramQQAppInterface, paramMessageForPtt, paramBaseAdapter, bool1);
            if ((paramaelt.jdField_a_of_type_Ansf == null) || (paramaelt.jdField_a_of_type_Ansf.a <= 0)) {
              break;
            }
            paramQQAppInterface = paramaelt.jdField_a_of_type_Ansf.a(paramQQAppInterface, 7);
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
  
  public static int[] a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, int paramInt, aftf paramaftf)
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
        i = paramInt + aekt.a(f, paramQQAppInterface.getApp().getResources());
        localObject = paramaftf.jdField_a_of_type_Ansf.a(paramQQAppInterface, 7);
        if (localObject != null) {
          break;
        }
        return new int[] { i, 0, 0 };
      }
      localObject = (ansg)((Pair)localObject).first;
      if (paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft() > 0)
      {
        paramInt = ((ansg)localObject).a.f - paramaftf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft();
        j = paramInt;
        if (paramInt < 0) {
          j = 0;
        }
        m = aekt.a(6.0F, paramQQAppInterface.getApp().getResources());
        i = i - j - m;
        paramQQAppInterface = ((ansg)localObject).a.c;
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
      paramInt = ((ansg)localObject).a.f - aekt.a(12.0F, paramQQAppInterface.getApp().getResources());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils
 * JD-Core Version:    0.7.0.1
 */