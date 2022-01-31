package com.tencent.biz.subscribe.baseUI;

import java.io.Serializable;

public class ExtraTypeInfo
  implements Serializable
{
  public static final String KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO = "key_subscribe_intent_extra_type_info";
  public static final int PAGE_TYPE_H5_DEFAULT = 8000;
  public static final int PAGE_TYPE_H5_PIC_TEXT = 8001;
  public static final int PAGE_TYPE_H5_YOUZAN_DETAIL = 8002;
  public static final int PAGE_TYPE_SUBSCRIBE_FOLLOW = 7003;
  public static final int PAGE_TYPE_SUBSCRIBE_MULTI_PIC_TEXT = 7001;
  public static final int PAGE_TYPE_SUBSCRIBE_PERSONAL = 7002;
  public static final int PAGE_TYPE_SUBSCRIBE_PERSONAL_DRAFT = 7005;
  public static final int PAGE_TYPE_SUBSCRIBE_RECOMMEND = 7004;
  public static final int PAGE_TYPE_SUBSCRIBE_VIDEO = 7000;
  public static final int SOURCE_TYPE_COLOR_NOTE = 9003;
  public static final int SOURCE_TYPE_DEFAULT = 0;
  public static final int SOURCE_TYPE_FROM_MSG_TAB = 9004;
  public static final int SOURCE_TYPE_FROM_SEARCH = 9005;
  public static final int SOURCE_TYPE_IS_MINI_PROJECT = 9001;
  public static final int SOURCE_TYPE_QZONE = 9002;
  public int pageType;
  public int sourceType;
  
  public ExtraTypeInfo() {}
  
  public ExtraTypeInfo(int paramInt)
  {
    this.pageType = paramInt;
  }
  
  public ExtraTypeInfo(int paramInt1, int paramInt2)
  {
    this.pageType = paramInt1;
    this.sourceType = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.baseUI.ExtraTypeInfo
 * JD-Core Version:    0.7.0.1
 */