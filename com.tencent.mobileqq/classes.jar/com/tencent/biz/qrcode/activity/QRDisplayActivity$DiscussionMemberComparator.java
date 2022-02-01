package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class QRDisplayActivity$DiscussionMemberComparator
  implements Comparator<String>
{
  QRDisplayActivity$DiscussionMemberComparator(QRDisplayActivity paramQRDisplayActivity) {}
  
  public int a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return ChnToSpell.b(paramString1, 1).compareTo(ChnToSpell.b(paramString2, 1));
    }
    if (paramString1 != null) {
      return 1;
    }
    if (paramString2 != null) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.DiscussionMemberComparator
 * JD-Core Version:    0.7.0.1
 */