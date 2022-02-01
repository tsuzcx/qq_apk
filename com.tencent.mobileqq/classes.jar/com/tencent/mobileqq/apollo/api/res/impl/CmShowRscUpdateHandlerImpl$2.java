package com.tencent.mobileqq.apollo.api.res.impl;

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
    Object localObject3;
    try
    {
      SparseArray localSparseArray = new SparseArray();
      localObject1 = this.jdField_a_of_type_ComTencentPbClubcontentCmShowContentUpdate$STContUpdRsp.domain_list.get();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (CmShowContentUpdate.STDomainInfo)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject3 = ((CmShowContentUpdate.STDomainInfo)localObject2).url.get().toStringUtf8();
            if ((localObject3 != null) && (!((String)localObject3).isEmpty()))
            {
              localSparseArray.put(((CmShowContentUpdate.STDomainInfo)localObject2).domain_id.get(), localObject3);
              continue;
              return;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("rscContent_CmShowRscUpdateHandler", 1, localException, new Object[0]);
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_ComTencentPbClubcontentCmShowContentUpdate$STContUpdRsp.cont_list.get();
    label164:
    Object localObject4;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (CmShowContentUpdate.STVerInfo)((Iterator)localObject2).next();
        if (localObject4 != null)
        {
          localObject3 = new CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult();
          ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_a_of_type_Long = ((CmShowContentUpdate.STVerInfo)localObject4).item_id.get();
          ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_a_of_type_Int = ((CmShowContentUpdate.STVerInfo)localObject4).biz_id.get();
          ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_a_of_type_JavaLangString = ((CmShowContentUpdate.STVerInfo)localObject4).name.get().toStringUtf8();
          ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_b_of_type_Int = ((CmShowContentUpdate.STVerInfo)localObject4).ver.get();
          ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_f_of_type_Int = ((CmShowContentUpdate.STVerInfo)localObject4).domain_id.get();
          ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_e_of_type_JavaLangString = ((CmShowContentUpdate.STVerInfo)localObject4).down_file.get().toStringUtf8();
          ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_b_of_type_JavaLangString = CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult.a((String)localException.get(((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_f_of_type_Int), ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_a_of_type_Long, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_b_of_type_Int, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_e_of_type_JavaLangString);
          if (((CmShowContentUpdate.STVerInfo)localObject4).is_patch.get() != 1) {
            break label760;
          }
        }
      }
    }
    label760:
    for (boolean bool = true;; bool = false)
    {
      ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_a_of_type_Boolean = bool;
      ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_c_of_type_Int = this.this$0.getContentVersion(((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_a_of_type_Int, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_a_of_type_Long, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_a_of_type_JavaLangString);
      ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_d_of_type_JavaLangString = ((CmShowContentUpdate.STVerInfo)localObject4).md5.get().toStringUtf8();
      localObject4 = (CmShowContentUpdate.STPatchInfo)((CmShowContentUpdate.STVerInfo)localObject4).patch_info.get();
      if (localObject4 != null)
      {
        ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_c_of_type_Int = ((CmShowContentUpdate.STPatchInfo)localObject4).base_ver.get();
        if ((((CmShowContentUpdate.STPatchInfo)localObject4).patch_data != null) && (((CmShowContentUpdate.STPatchInfo)localObject4).patch_data.get() != null) && (!((CmShowContentUpdate.STPatchInfo)localObject4).patch_data.get().isEmpty()))
        {
          ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_a_of_type_ArrayOfByte = ((CmShowContentUpdate.STPatchInfo)localObject4).patch_data.get().toByteArray();
          ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_b_of_type_Long = ((CmShowContentUpdate.STPatchInfo)localObject4).patch_size.get();
        }
        ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_f_of_type_JavaLangString = ((CmShowContentUpdate.STPatchInfo)localObject4).down_patch_file.get().toStringUtf8();
        ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_c_of_type_JavaLangString = CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult.a((String)localException.get(((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_f_of_type_Int), ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_a_of_type_Long, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_b_of_type_Int, ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_f_of_type_JavaLangString);
      }
      ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentPbClubcontentCmShowContentUpdate$STContUpdRsp.intervals_ts.get();
      ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
      ((CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)localObject3).jdField_e_of_type_Int = this.jdField_a_of_type_Int;
      ((List)localObject1).add(localObject3);
      break label164;
      CmShowRscUpdateHandlerImpl.access$000(this.this$0).edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
      if (QLog.isColorLevel()) {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "checkResults:" + localObject1);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        CmShowRscUpdateHandlerImpl.access$102(this.this$0, new ArrayList());
        CmShowRscUpdateHandlerImpl.access$100(this.this$0).addAll((Collection)localObject1);
      }
      if (!((List)localObject1).isEmpty())
      {
        CmShowRscUpdateHandlerImpl.access$200(this.this$0, this.jdField_a_of_type_Int, (List)localObject1);
        return;
      }
      CmShowRscUpdateHandlerImpl.access$300(this.this$0, this.jdField_a_of_type_Int);
      if ((!this.jdField_a_of_type_Boolean) || (!CmShowRscUpdateHandlerImpl.access$100(this.this$0).isEmpty())) {
        break;
      }
      CmShowRscUpdateHandlerImpl.access$000(this.this$0).edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, "no need update");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl.2
 * JD-Core Version:    0.7.0.1
 */