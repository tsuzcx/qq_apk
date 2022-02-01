package com.tencent.mobileqq.apollo.res.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdRsp;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STDomainInfo;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STPatchInfo;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STVerInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class CmShowRscUpdateHandlerImpl$2
  implements Runnable
{
  CmShowRscUpdateHandlerImpl$2(CmShowRscUpdateHandlerImpl paramCmShowRscUpdateHandlerImpl, CmShowContentUpdate.STContUpdRsp paramSTContUpdRsp, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new SparseArray();
        Object localObject2 = this.jdField_a_of_type_ComTencentPbClubcontentCmShowContentUpdate$STContUpdRsp.domain_list.get();
        Object localObject4;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (CmShowContentUpdate.STDomainInfo)((Iterator)localObject2).next();
            if (localObject3 == null) {
              continue;
            }
            localObject4 = ((CmShowContentUpdate.STDomainInfo)localObject3).url.get().toStringUtf8();
            if ((localObject4 == null) || (((String)localObject4).isEmpty())) {
              continue;
            }
            ((SparseArray)localObject1).put(((CmShowContentUpdate.STDomainInfo)localObject3).domain_id.get(), localObject4);
            continue;
          }
        }
        localObject2 = new ArrayList();
        Object localObject3 = this.jdField_a_of_type_ComTencentPbClubcontentCmShowContentUpdate$STContUpdRsp.cont_list.get();
        if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
        {
          localObject3 = ((List)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            Object localObject5 = (CmShowContentUpdate.STVerInfo)((Iterator)localObject3).next();
            if (localObject5 == null) {
              continue;
            }
            localObject4 = new CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult();
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_a_of_type_Long = ((CmShowContentUpdate.STVerInfo)localObject5).item_id.get();
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_a_of_type_Int = ((CmShowContentUpdate.STVerInfo)localObject5).biz_id.get();
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_a_of_type_JavaLangString = ((CmShowContentUpdate.STVerInfo)localObject5).name.get().toStringUtf8();
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_b_of_type_Int = ((CmShowContentUpdate.STVerInfo)localObject5).ver.get();
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_f_of_type_Int = ((CmShowContentUpdate.STVerInfo)localObject5).domain_id.get();
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_e_of_type_JavaLangString = ((CmShowContentUpdate.STVerInfo)localObject5).down_file.get().toStringUtf8();
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_b_of_type_JavaLangString = CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult.a((String)((SparseArray)localObject1).get(((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_f_of_type_Int), ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_a_of_type_Long, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_b_of_type_Int, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_e_of_type_JavaLangString);
            if (((CmShowContentUpdate.STVerInfo)localObject5).is_patch.get() != 1) {
              break label772;
            }
            bool = true;
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_a_of_type_Boolean = bool;
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_c_of_type_Int = this.this$0.getContentVersion(((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_a_of_type_Int, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_a_of_type_Long, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_a_of_type_JavaLangString);
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_d_of_type_JavaLangString = ((CmShowContentUpdate.STVerInfo)localObject5).md5.get().toStringUtf8();
            localObject5 = (CmShowContentUpdate.STPatchInfo)((CmShowContentUpdate.STVerInfo)localObject5).patch_info.get();
            if (localObject5 != null)
            {
              ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_c_of_type_Int = ((CmShowContentUpdate.STPatchInfo)localObject5).base_ver.get();
              if ((((CmShowContentUpdate.STPatchInfo)localObject5).patch_data != null) && (((CmShowContentUpdate.STPatchInfo)localObject5).patch_data.get() != null) && (!((CmShowContentUpdate.STPatchInfo)localObject5).patch_data.get().isEmpty()))
              {
                ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_a_of_type_ArrayOfByte = ((CmShowContentUpdate.STPatchInfo)localObject5).patch_data.get().toByteArray();
                ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_b_of_type_Long = ((CmShowContentUpdate.STPatchInfo)localObject5).patch_size.get();
              }
              ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_f_of_type_JavaLangString = ((CmShowContentUpdate.STPatchInfo)localObject5).down_patch_file.get().toStringUtf8();
              ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_c_of_type_JavaLangString = CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult.a((String)((SparseArray)localObject1).get(((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_f_of_type_Int), ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_a_of_type_Long, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_b_of_type_Int, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_f_of_type_JavaLangString);
            }
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentPbClubcontentCmShowContentUpdate$STContUpdRsp.intervals_ts.get();
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
            ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject4).jdField_e_of_type_Int = this.jdField_a_of_type_Int;
            ((List)localObject2).add(localObject4);
            continue;
          }
        }
        else
        {
          CmShowRscUpdateHandlerImpl.access$000(this.this$0).edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkResults:");
          ((StringBuilder)localObject1).append(localObject2);
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject1).toString());
        }
        if (this.jdField_a_of_type_Boolean)
        {
          CmShowRscUpdateHandlerImpl.access$102(this.this$0, new ArrayList());
          CmShowRscUpdateHandlerImpl.access$100(this.this$0).addAll((Collection)localObject2);
        }
        if (!((List)localObject2).isEmpty())
        {
          CmShowRscUpdateHandlerImpl.access$200(this.this$0, this.jdField_a_of_type_Int, (List)localObject2);
          return;
        }
        CmShowRscUpdateHandlerImpl.access$300(this.this$0, this.jdField_a_of_type_Int);
        if ((this.jdField_a_of_type_Boolean) && (CmShowRscUpdateHandlerImpl.access$100(this.this$0).isEmpty()))
        {
          CmShowRscUpdateHandlerImpl.access$000(this.this$0).edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "no need update");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("rscContent_CmShowRscUpdateHandler", 1, localException, new Object[0]);
      }
      return;
      label772:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl.2
 * JD-Core Version:    0.7.0.1
 */