package com.tencent.mobileqq.activity.aio.anim;

import agej;
import aggl;
import ahoc;
import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import aogu;
import aqkn;
import aqkt;
import aqku;
import aqlt;
import bdgb;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;

public class VoicePrintUtils
{
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, ahoc paramahoc)
  {
    int j = 0;
    int i = j;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramBoolean)
      {
        localObject = paramahoc.jdField_a_of_type_Aqkt.a(paramQQAppInterface, 7);
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
      localObject = (aqku)((Pair)localObject).first;
      if ((paramahoc.jdField_a_of_type_AndroidViewView == null) || (paramahoc.jdField_a_of_type_AndroidViewView.getHeight() <= 0)) {
        break;
      }
      j = paramahoc.jdField_a_of_type_AndroidViewView.getHeight() - ((aqku)localObject).a.h - ((aqku)localObject).a.i;
      i = j;
    } while (j <= paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
    return paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    return agej.a(57.0F, paramQQAppInterface.getApp().getResources()) - ((aqku)localObject).a.h - ((aqku)localObject).a.i;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, aggl paramaggl, MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = true;
    if (bdgb.b()) {}
    label133:
    label140:
    for (;;)
    {
      return false;
      if (paramMessageForPtt.needVipBubble())
      {
        int i = BubbleManager.a;
        if (i == 0) {
          i = ((aogu)paramQQAppInterface.a(13)).a(paramMessageForPtt);
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
            paramaggl.jdField_a_of_type_Aqkt = aqlt.a(i, paramQQAppInterface, paramMessageForPtt, paramBaseAdapter, bool1);
            if ((paramaggl.jdField_a_of_type_Aqkt == null) || (paramaggl.jdField_a_of_type_Aqkt.a <= 0)) {
              break;
            }
            paramQQAppInterface = paramaggl.jdField_a_of_type_Aqkt.a(paramQQAppInterface, 7);
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
  
  public static int[] a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, int paramInt, ahoc paramahoc)
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
        i = paramInt + agej.a(f, paramQQAppInterface.getApp().getResources());
        localObject = paramahoc.jdField_a_of_type_Aqkt.a(paramQQAppInterface, 7);
        if (localObject != null) {
          break;
        }
        return new int[] { i, 0, 0 };
      }
      localObject = (aqku)((Pair)localObject).first;
      if (paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft() > 0)
      {
        paramInt = ((aqku)localObject).a.f - paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft();
        j = paramInt;
        if (paramInt < 0) {
          j = 0;
        }
        m = agej.a(6.0F, paramQQAppInterface.getApp().getResources());
        i = i - j - m;
        paramQQAppInterface = ((aqku)localObject).a.c;
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
      paramInt = ((aqku)localObject).a.f - agej.a(12.0F, paramQQAppInterface.getApp().getResources());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils
 * JD-Core Version:    0.7.0.1
 */