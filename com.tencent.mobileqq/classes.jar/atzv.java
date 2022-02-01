import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.FileExtInfo;
import cooperation.weiyun.channel.pb.WeiyunPB.FileItem;
import cooperation.weiyun.channel.pb.WeiyunPB.LibInfoListGetMsgRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class atzv
  implements bmyw<WeiyunPB.LibInfoListGetMsgRsp>
{
  atzv(atzu paramatzu, String paramString) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.LibInfoListGetMsgRsp paramLibInfoListGetMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList onFailed: errcode[" + paramInt + "], errmsg[" + paramString + "]");
    }
    atzu.a(this.jdField_a_of_type_Atzu).a().a(false, 31, new Object[] { Integer.valueOf(paramInt), paramString, this.jdField_a_of_type_JavaLangString });
  }
  
  public void a(WeiyunPB.LibInfoListGetMsgRsp paramLibInfoListGetMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList onSucceed, num[" + paramLibInfoListGetMsgRsp.FileItem_items.size() + "]");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramLibInfoListGetMsgRsp.FileItem_items.get().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeiyunPB.FileItem)((Iterator)localObject1).next();
      WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
      localWeiYunFileInfo.jdField_b_of_type_Long = ((WeiyunPB.FileItem)localObject2).file_mtime.get();
      localWeiYunFileInfo.jdField_a_of_type_Long = ((WeiyunPB.FileItem)localObject2).file_size.get();
      localWeiYunFileInfo.jdField_a_of_type_Int = ((WeiyunPB.FileItem)localObject2).ext_info.from_source.get();
      localWeiYunFileInfo.jdField_a_of_type_JavaLangString = ((WeiyunPB.FileItem)localObject2).file_id.get();
      localWeiYunFileInfo.jdField_b_of_type_JavaLangString = bnau.a(((WeiyunPB.FileItem)localObject2).pdir_key.get());
      localWeiYunFileInfo.c = ((WeiyunPB.FileItem)localObject2).filename.get();
      localWeiYunFileInfo.f = ((WeiyunPB.FileItem)localObject2).ext_info.cookie_name.get();
      localWeiYunFileInfo.g = ((WeiyunPB.FileItem)localObject2).ext_info.cookie_value.get();
      localWeiYunFileInfo.e = ((WeiyunPB.FileItem)localObject2).ext_info.thumb_url.get();
      localWeiYunFileInfo.d = ((WeiyunPB.FileItem)localObject2).ext_info.weiyun_host.get();
      localWeiYunFileInfo.jdField_b_of_type_Int = ((WeiyunPB.FileItem)localObject2).ext_info.weiyun_port.get();
      localWeiYunFileInfo.i = bnau.a(((WeiyunPB.FileItem)localObject2).file_md5.get());
      localWeiYunFileInfo.j = bnau.a(((WeiyunPB.FileItem)localObject2).file_sha.get());
      if (!atzu.a(this.jdField_a_of_type_Atzu).containsKey(localWeiYunFileInfo.jdField_a_of_type_JavaLangString))
      {
        atzu.a(this.jdField_a_of_type_Atzu).put(localWeiYunFileInfo.jdField_a_of_type_JavaLangString, localWeiYunFileInfo);
        localArrayList.add(localWeiYunFileInfo);
      }
    }
    localObject1 = atzu.a(this.jdField_a_of_type_Atzu).a();
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    if (paramLibInfoListGetMsgRsp.finish_flag.get() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((atcx)localObject1).a(true, 31, new Object[] { localObject2, Boolean.valueOf(bool), Integer.valueOf(paramLibInfoListGetMsgRsp.FileItem_items.size()), paramLibInfoListGetMsgRsp.server_version.get(), localArrayList, Integer.valueOf(atzu.a(this.jdField_a_of_type_Atzu)) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzv
 * JD-Core Version:    0.7.0.1
 */