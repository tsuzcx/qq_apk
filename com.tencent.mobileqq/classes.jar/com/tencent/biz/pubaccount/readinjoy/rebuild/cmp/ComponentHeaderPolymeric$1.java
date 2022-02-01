package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.qphone.base.util.QLog;

class ComponentHeaderPolymeric$1
  implements UserOperationModule.Ox978RespCallBack
{
  ComponentHeaderPolymeric$1(ComponentHeaderPolymeric paramComponentHeaderPolymeric, ArticleInfo paramArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString + " followStatus = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e);
    }
    if (!paramString.equals(ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric).getTag())) {}
    label227:
    do
    {
      do
      {
        return;
        ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, true);
        if (!paramBoolean) {
          break label271;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e == 1) {
          ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, true);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e != 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e != 2)) {
            break label227;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e != 1) {
            break;
          }
          ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2);
          return;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e == 2) {
            ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, false);
          }
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e != 2);
      ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1);
      return;
      QLog.e("ComponentHeaderPolymeric", 2, "978 resp error, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e == 1)
      {
        ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, 1);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e != 2);
    label271:
    ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric.1
 * JD-Core Version:    0.7.0.1
 */