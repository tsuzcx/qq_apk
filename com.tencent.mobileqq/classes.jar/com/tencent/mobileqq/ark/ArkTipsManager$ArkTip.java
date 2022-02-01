package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.tips.ArkTipsBar;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.data.MessageForArkApp;
import java.lang.ref.WeakReference;

class ArkTipsManager$ArkTip
{
  public int a;
  public long a;
  ArkAioContainerWrapper a;
  public MessageForArkApp a;
  public String a;
  public WeakReference<TipsBar> a;
  public long b;
  public String b;
  public WeakReference<ArkTipsBar> b;
  public String c;
  public String d;
  
  ArkTipsManager$ArkTip(ArkAioContainerWrapper paramArkAioContainerWrapper, String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt, String paramString3, MessageForArkApp paramMessageForArkApp)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
    a(paramArkAioContainerWrapper, paramString1, paramLong1, paramLong2, paramString2, paramInt, paramString3, paramMessageForArkApp);
  }
  
  void a(ArkAioContainerWrapper paramArkAioContainerWrapper, String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt, String paramString3, MessageForArkApp paramMessageForArkApp)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper = paramArkAioContainerWrapper;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramLong1;
    this.c = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Long = paramLong2;
    this.d = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp = paramMessageForArkApp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.ArkTip
 * JD-Core Version:    0.7.0.1
 */