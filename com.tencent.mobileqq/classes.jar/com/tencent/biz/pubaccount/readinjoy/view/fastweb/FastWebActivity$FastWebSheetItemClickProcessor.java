package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.BaseSheetItemClickProcessor;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class FastWebActivity$FastWebSheetItemClickProcessor
  extends ReadInJoyShareHelperV2.BaseSheetItemClickProcessor
{
  FastWebActivity$FastWebSheetItemClickProcessor(FastWebActivity paramFastWebActivity) {}
  
  public boolean a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    FastWebActivity.c(this.a, true);
    FastWebActivity.a(this.a, paramInt);
    this.a.a(paramInt, paramActionSheetItem);
    return super.a(paramInt, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.FastWebSheetItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */