package com.tencent.av.tips;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.av.VideoUtils;
import com.tencent.av.tips.data.AvTipsItemBase;
import com.tencent.av.tips.data.HypeLinkAvTipsItem;
import com.tencent.av.tips.data.NormalAvTipsItem;
import com.tencent.av.tips.data.WaitingAvTipsItem;

class AvTipsView$TipsInfo
{
  int jdField_a_of_type_Int = -1;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  SpannableString jdField_a_of_type_AndroidTextSpannableString = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -1;
  boolean jdField_c_of_type_Boolean = false;
  int d = -1;
  
  static TipsInfo a(Resources paramResources, AvTipsItemBase paramAvTipsItemBase, AvTipsView.BaseTips paramBaseTips)
  {
    TipsInfo localTipsInfo = new TipsInfo();
    if (!TextUtils.isEmpty(paramAvTipsItemBase.a())) {
      localTipsInfo.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramAvTipsItemBase.a());
    }
    localTipsInfo.jdField_a_of_type_Int = paramBaseTips.d;
    localTipsInfo.jdField_b_of_type_Int = paramBaseTips.jdField_a_of_type_Int;
    localTipsInfo.jdField_c_of_type_Int = paramBaseTips.jdField_b_of_type_Int;
    localTipsInfo.d = paramBaseTips.jdField_c_of_type_Int;
    int i = paramAvTipsItemBase.a();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return localTipsInfo;
        }
        paramResources = (HypeLinkAvTipsItem)paramAvTipsItemBase;
        if (paramResources.h() != -1) {
          localTipsInfo.jdField_a_of_type_Int = paramResources.h();
        }
        if (paramResources.j() != -1) {
          localTipsInfo.jdField_c_of_type_Int = paramResources.j();
        }
        if (paramResources.i() != -1) {
          localTipsInfo.d = paramResources.i();
        }
        if (localTipsInfo.jdField_a_of_type_AndroidTextSpannableString != null)
        {
          int j = paramResources.f();
          if (paramResources.g() == -1) {
            i = paramAvTipsItemBase.a().length();
          } else {
            i = paramResources.g();
          }
          i += j;
          localTipsInfo.jdField_a_of_type_AndroidTextSpannableString.setSpan(new AvTipsView.TipsInfo.1(paramResources), j, i, 33);
          paramResources = new ForegroundColorSpan(localTipsInfo.jdField_c_of_type_Int);
          localTipsInfo.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramResources, j, i, 17);
          return localTipsInfo;
        }
      }
      else
      {
        localTipsInfo.jdField_c_of_type_Boolean = ((WaitingAvTipsItem)paramAvTipsItemBase).b();
        return localTipsInfo;
      }
    }
    else
    {
      paramAvTipsItemBase = (NormalAvTipsItem)paramAvTipsItemBase;
      if ((paramAvTipsItemBase.a() instanceof BitmapDrawable))
      {
        localTipsInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)paramAvTipsItemBase.a()).getBitmap();
      }
      else
      {
        paramBaseTips = paramAvTipsItemBase.b();
        if (!TextUtils.isEmpty(paramBaseTips)) {
          localTipsInfo.jdField_a_of_type_AndroidGraphicsBitmap = VideoUtils.a(paramResources, paramBaseTips);
        }
      }
      i = paramAvTipsItemBase.k();
      if (i != 1)
      {
        if (i != 2) {
          return localTipsInfo;
        }
        localTipsInfo.jdField_b_of_type_Boolean = true;
        return localTipsInfo;
      }
      localTipsInfo.jdField_a_of_type_Boolean = true;
    }
    return localTipsInfo;
  }
  
  static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTag(2131378294, Integer.valueOf(paramInt2));
    paramTextView.setTag(2131378295, Integer.valueOf(paramInt1));
    paramTextView.setHighlightColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.AvTipsView.TipsInfo
 * JD-Core Version:    0.7.0.1
 */