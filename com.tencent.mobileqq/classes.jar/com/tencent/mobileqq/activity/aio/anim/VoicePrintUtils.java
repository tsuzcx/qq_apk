package com.tencent.mobileqq.activity.aio.anim;

import actj;
import acuj;
import adws;
import akfv;
import amba;
import ambg;
import ambh;
import amcg;
import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import axmv;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;

public class VoicePrintUtils
{
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, adws paramadws)
  {
    int j = 0;
    int i = j;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramBoolean)
      {
        localObject = paramadws.jdField_a_of_type_Ambg.a(paramQQAppInterface, 7);
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
      localObject = (ambh)((Pair)localObject).first;
      if ((paramadws.jdField_a_of_type_AndroidViewView == null) || (paramadws.jdField_a_of_type_AndroidViewView.getHeight() <= 0)) {
        break;
      }
      j = paramadws.jdField_a_of_type_AndroidViewView.getHeight() - ((ambh)localObject).a.h - ((ambh)localObject).a.i;
      i = j;
    } while (j <= paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
    return paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    return actj.a(57.0F, paramQQAppInterface.getApp().getResources()) - ((ambh)localObject).a.h - ((ambh)localObject).a.i;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, acuj paramacuj, MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = true;
    if (axmv.b()) {}
    label133:
    label140:
    for (;;)
    {
      return false;
      if (paramMessageForPtt.needVipBubble())
      {
        int i = BubbleManager.a;
        if (i == 0) {
          i = ((akfv)paramQQAppInterface.a(13)).a(paramMessageForPtt);
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
            paramacuj.jdField_a_of_type_Ambg = amcg.a(i, paramQQAppInterface, paramMessageForPtt, paramBaseAdapter, bool1);
            if ((paramacuj.jdField_a_of_type_Ambg == null) || (paramacuj.jdField_a_of_type_Ambg.a <= 0)) {
              break;
            }
            paramQQAppInterface = paramacuj.jdField_a_of_type_Ambg.a(paramQQAppInterface, 7);
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
  
  public static int[] a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, int paramInt, adws paramadws)
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
        i = paramInt + actj.a(f, paramQQAppInterface.getApp().getResources());
        localObject = paramadws.jdField_a_of_type_Ambg.a(paramQQAppInterface, 7);
        if (localObject != null) {
          break;
        }
        return new int[] { i, 0, 0 };
      }
      localObject = (ambh)((Pair)localObject).first;
      if (paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft() > 0)
      {
        paramInt = ((ambh)localObject).a.f - paramadws.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft();
        j = paramInt;
        if (paramInt < 0) {
          j = 0;
        }
        m = actj.a(6.0F, paramQQAppInterface.getApp().getResources());
        i = i - j - m;
        paramQQAppInterface = ((ambh)localObject).a.c;
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
      paramInt = ((ambh)localObject).a.f - actj.a(12.0F, paramQQAppInterface.getApp().getResources());
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