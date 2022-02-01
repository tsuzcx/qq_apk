package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.text.TextUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.biz.subscribe.utils.ObjectTransformUtil;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

class SubscribeHybirdFragment$2
  implements IServiceInfo
{
  SubscribeHybirdFragment$2(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public ColorNote getColorNote()
  {
    if ((SubscribeHybirdFragment.c(this.a) != null) && (SubscribeHybirdFragment.d(this.a) != null))
    {
      byte[] arrayOfByte = ObjectTransformUtil.a(new SubscribeColorNoteReserveBean(SubscribeHybirdFragment.c(this.a).toByteArray(), SubscribeHybirdFragment.d(this.a).pageType));
      Object localObject = new ShareInfoBean();
      ((ShareInfoBean)localObject).b = SubscribeHybirdFragment.c(this.a);
      ((ShareInfoBean)localObject).e = SubscribeHybirdFragment.d(this.a);
      String str1 = SubscribeHybirdFragment.c(this.a).id.get();
      String str2 = ((ShareInfoBean)localObject).d();
      ((ShareInfoBean)localObject).e();
      String str3 = ((ShareInfoBean)localObject).f();
      localObject = ((ShareInfoBean)localObject).g();
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      return new ColorNote.Builder().a(16908291).a(str1).b(str2).c((String)localObject).d(str3).a(arrayOfByte).a();
    }
    QLog.e("SubscribeHybirdFragment", 1, "initColorNote, shareInfoBean is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment.2
 * JD-Core Version:    0.7.0.1
 */