package com.tencent.biz.pubaccount.weishi_new.util;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

final class WeishiShareUtil$7
  implements ShareActionSheet.OnItemClickListener
{
  WeishiShareUtil$7(Context paramContext, WSShareParam paramWSShareParam) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    WeishiShareUtil.a(this.a, paramActionSheetItem, this.b);
    paramShareActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil.7
 * JD-Core Version:    0.7.0.1
 */