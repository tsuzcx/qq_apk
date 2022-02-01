package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
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

class SubscribeBaseFragment$2
  implements IServiceInfo
{
  SubscribeBaseFragment$2(SubscribeBaseFragment paramSubscribeBaseFragment) {}
  
  public ColorNote getColorNote()
  {
    if ((this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null))
    {
      byte[] arrayOfByte = ObjectTransformUtil.a(new SubscribeColorNoteReserveBean(this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray(), this.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType));
      ShareInfoBean localShareInfoBean = new ShareInfoBean();
      localShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      localShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.a.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      Object localObject = "";
      String str2 = localShareInfoBean.c();
      String str1 = localShareInfoBean.d();
      String str3 = localShareInfoBean.e();
      switch (localShareInfoBean.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType)
      {
      default: 
        break;
      case 7002: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(localShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
        localObject = ((StringBuilder)localObject).toString();
        break;
      case 7000: 
      case 7001: 
        str1 = localShareInfoBean.f();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(localShareInfoBean.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get());
        localObject = ((StringBuilder)localObject).toString();
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      return new ColorNote.Builder().a(16908291).a((String)localObject).b(str2).c(str1).d(str3).a(arrayOfByte).a();
    }
    QLog.e("SubscribeBaseFragment", 1, "initColorNote, shareInfoBean is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */