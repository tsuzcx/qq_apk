package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;

public class VoicePrintUtils
{
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, PttItemBuilder.Holder paramHolder)
  {
    if ((paramQQAppInterface != null) && (paramBoolean))
    {
      Object localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramQQAppInterface, 7);
      if (localObject == null) {
        return 0;
      }
      localObject = (BubbleInfo.CommonAttrs)((Pair)localObject).first;
      int i;
      if ((paramHolder.jdField_a_of_type_AndroidViewView != null) && (paramHolder.jdField_a_of_type_AndroidViewView.getHeight() > 0))
      {
        int j = paramHolder.jdField_a_of_type_AndroidViewView.getHeight() - ((BubbleInfo.CommonAttrs)localObject).a.h - ((BubbleInfo.CommonAttrs)localObject).a.i;
        i = j;
        if (j > paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight()) {
          return paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        }
      }
      else
      {
        i = AIOUtils.b(57.0F, paramQQAppInterface.getApp().getResources()) - ((BubbleInfo.CommonAttrs)localObject).a.h - ((BubbleInfo.CommonAttrs)localObject).a.i;
      }
      return i;
    }
    return 0;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder, MessageForPtt paramMessageForPtt)
  {
    if (SimpleUIUtil.a()) {
      return false;
    }
    if (paramMessageForPtt.needVipBubble())
    {
      int j = BubbleManager.a;
      int i = j;
      if (j == 0) {
        i = ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramMessageForPtt);
      }
      if (i == 0) {
        return false;
      }
      boolean bool;
      if (!(paramContext instanceof MultiForwardActivity)) {
        bool = true;
      } else {
        bool = false;
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(i, paramQQAppInterface, bool);
      if ((paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a > 0))
      {
        paramQQAppInterface = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramQQAppInterface, 7);
        return (paramQQAppInterface != null) && (paramQQAppInterface.first != null);
      }
    }
    return false;
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, int paramInt, PttItemBuilder.Holder paramHolder)
  {
    if ((paramBoolean1) && (paramQQAppInterface != null))
    {
      float f;
      if (paramBoolean2) {
        f = 6.0F;
      } else {
        f = 24.0F;
      }
      int i = paramInt + AIOUtils.b(f, paramQQAppInterface.getApp().getResources());
      Object localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramQQAppInterface, 7);
      if (localObject == null) {
        return new int[] { i, 0, 0 };
      }
      localObject = (BubbleInfo.CommonAttrs)((Pair)localObject).first;
      if (paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft() > 0) {
        paramInt = ((BubbleInfo.CommonAttrs)localObject).a.f - paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft();
      } else {
        paramInt = ((BubbleInfo.CommonAttrs)localObject).a.f - AIOUtils.b(12.0F, paramQQAppInterface.getApp().getResources());
      }
      int j = paramInt;
      if (paramInt < 0) {
        j = 0;
      }
      int m = AIOUtils.b(6.0F, paramQQAppInterface.getApp().getResources());
      int k = i - j - m;
      paramQQAppInterface = ((BubbleInfo.CommonAttrs)localObject).a.c;
      paramInt = k;
      if (paramQQAppInterface != null)
      {
        paramInt = k;
        if (paramQQAppInterface.length > 0) {
          if (k <= paramQQAppInterface[0])
          {
            paramInt = paramQQAppInterface[0];
          }
          else
          {
            if (k >= paramQQAppInterface[(paramQQAppInterface.length - 1)])
            {
              paramInt = k - paramQQAppInterface[(paramQQAppInterface.length - 1)];
              i = paramQQAppInterface[(paramQQAppInterface.length - 1)];
              break label315;
            }
            i = 0;
            for (;;)
            {
              paramInt = k;
              if (i >= paramQQAppInterface.length - 1) {
                break;
              }
              if ((k >= paramQQAppInterface[i]) && (k < paramQQAppInterface[(i + 1)]))
              {
                paramInt = paramQQAppInterface[i];
                i = paramQQAppInterface[i];
                paramInt = k - paramInt;
                break label315;
              }
              i += 1;
            }
          }
        }
      }
      k = 0;
      i = paramInt;
      paramInt = k;
      label315:
      paramInt /= 2;
      return new int[] { i, j + paramInt, m + paramInt };
    }
    return new int[] { paramInt, 0, 0 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils
 * JD-Core Version:    0.7.0.1
 */