package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;

public class VoicePrintUtils
{
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, PttItemBuilder.Holder paramHolder)
  {
    int j = 0;
    int i = j;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramBoolean)
      {
        localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramQQAppInterface, 7);
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
      localObject = (BubbleInfo.CommonAttrs)((Pair)localObject).first;
      if ((paramHolder.jdField_a_of_type_AndroidViewView == null) || (paramHolder.jdField_a_of_type_AndroidViewView.getHeight() <= 0)) {
        break;
      }
      j = paramHolder.jdField_a_of_type_AndroidViewView.getHeight() - ((BubbleInfo.CommonAttrs)localObject).a.h - ((BubbleInfo.CommonAttrs)localObject).a.i;
      i = j;
    } while (j <= paramHolder.jdField_a_of_type_AndroidViewViewGroup.getHeight());
    return paramHolder.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    return AIOUtils.a(57.0F, paramQQAppInterface.getApp().getResources()) - ((BubbleInfo.CommonAttrs)localObject).a.h - ((BubbleInfo.CommonAttrs)localObject).a.i;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, BaseBubbleBuilder.ViewHolder paramViewHolder, MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = true;
    int i;
    if (paramMessageForPtt.needVipBubble())
    {
      i = BubbleManager.a;
      if (i != 0) {
        break label133;
      }
      i = ((SVIPHandler)paramQQAppInterface.a(13)).a(paramMessageForPtt);
    }
    label133:
    for (;;)
    {
      if (i == 0) {}
      do
      {
        return false;
        paramMessageForPtt = paramContext.getResources();
        if ((paramContext instanceof MultiForwardActivity)) {
          break;
        }
        bool1 = true;
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(i, paramQQAppInterface, paramMessageForPtt, paramBaseAdapter, bool1);
      } while ((paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo == null) || (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a <= 0));
      paramQQAppInterface = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramQQAppInterface, 7);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.first != null)) {}
      for (boolean bool1 = bool2;; bool1 = false)
      {
        return bool1;
        bool1 = false;
        break;
      }
    }
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, int paramInt, PttItemBuilder.Holder paramHolder)
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
        i = paramInt + AIOUtils.a(f, paramQQAppInterface.getApp().getResources());
        localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramQQAppInterface, 7);
        if (localObject != null) {
          break;
        }
        return new int[] { i, 0, 0 };
      }
      localObject = (BubbleInfo.CommonAttrs)((Pair)localObject).first;
      if (paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLeft() > 0)
      {
        paramInt = ((BubbleInfo.CommonAttrs)localObject).a.f - paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLeft();
        j = paramInt;
        if (paramInt < 0) {
          j = 0;
        }
        m = AIOUtils.a(6.0F, paramQQAppInterface.getApp().getResources());
        i = i - j - m;
        paramQQAppInterface = ((BubbleInfo.CommonAttrs)localObject).a.c;
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
      paramInt = ((BubbleInfo.CommonAttrs)localObject).a.f - AIOUtils.a(12.0F, paramQQAppInterface.getApp().getResources());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils
 * JD-Core Version:    0.7.0.1
 */