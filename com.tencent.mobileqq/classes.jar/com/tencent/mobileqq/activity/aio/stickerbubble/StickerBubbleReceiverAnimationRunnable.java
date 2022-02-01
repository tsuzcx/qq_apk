package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class StickerBubbleReceiverAnimationRunnable
  implements StickerBubbleAnimationViewHolder.AnimationViewCallback, Runnable
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StickerBubbleReceiverAnimationRunnable.1(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public StickerBubbleReceiverAnimationRunnable(QQAppInterface paramQQAppInterface, int paramInt, @NonNull View paramView, @NonNull String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApp().getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) ^ true);
    StickerBubbleAnimationViewHolder.a().a(this);
  }
  
  @NonNull
  private int[] a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Int * 80 < 5000) {
      return StickerBubbleAnimationHelper.a((QQAppInterface)localObject);
    }
    localObject = StickerBubbleAnimationHelper.a((QQAppInterface)localObject);
    int n = localObject.length;
    int m = 0;
    int j = 0;
    int k;
    for (int i = 0; j < n; i = k)
    {
      k = i;
      if (localObject[j] <= this.jdField_a_of_type_Int) {
        k = i + 1;
      }
      j += 1;
    }
    localObject = new int[i];
    n = 62 / i;
    for (j = m; j < i; j = k)
    {
      k = j + 1;
      localObject[j] = (n * k);
    }
    return localObject;
  }
  
  public void a()
  {
    if (AIOUtils.jdField_b_of_type_Int > 0) {
      AIOUtils.jdField_b_of_type_Int -= 1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    StickerBubbleAnimationHelper.a(this, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Boolean = true;
    AIOUtils.jdField_b_of_type_Int = 0;
    if (this.c)
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "StickerBubble", false);
      this.d = true;
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.c) && (!this.d))
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "StickerBubble", true);
      this.d = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleRunnable", 2, "showReceiveAnimationView from runnable");
    }
    Object localObject = StickerBubbleAnimationViewHolder.a().b((ViewGroup)this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidContentContext);
    if (!this.jdField_b_of_type_Boolean)
    {
      ((StickerBubbleAnimationView)localObject).bringToFront();
      this.jdField_b_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = a();
    }
    this.jdField_b_of_type_Int += 1;
    int i = this.jdField_b_of_type_Int;
    if ((i <= this.jdField_a_of_type_Int) && (i * 80 <= 5000))
    {
      if (i == 2)
      {
        StickerBubbleAnimationHelper.b(this, this.jdField_a_of_type_AndroidViewView);
        this.e = false;
      }
      ((StickerBubbleAnimationView)localObject).a(StickerBubbleAnimationHelper.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 80L);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Sticker bubble receiver animation sending finished ");
      ((StringBuilder)localObject).append(this);
      QLog.d("StickerBubbleRunnable", 2, ((StringBuilder)localObject).toString());
    }
    this.e = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleReceiverAnimationRunnable
 * JD-Core Version:    0.7.0.1
 */