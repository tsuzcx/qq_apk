import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

class bbxn
  extends yud
{
  bbxn(bbxl parambbxl) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if ((!paramBoolean) || (paramFileInfo == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject2 = paramFileInfo.str_file_id.get();
          } while (TextUtils.isEmpty((CharSequence)localObject2));
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("/")) {
            localObject1 = "/" + (String)localObject2;
          }
        } while (!((String)localObject1).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath));
        bbvl.c("TroopFileUploadFeedsSender", bbvl.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onGetOneFileResult. bus_id:" + paramFileInfo.uint32_bus_id.get() + " dead_time:" + paramFileInfo.uint32_dead_time.get());
        localObject2 = bbvj.a(this.a.d);
      } while (localObject2 == null);
      localObject1 = ((bcmu)localObject2).a((String)localObject1);
    } while (localObject1 == null);
    ((bbsa)localObject1).a = paramFileInfo.uint32_bus_id.get();
    ((bbsa)localObject1).c = paramFileInfo.uint32_dead_time.get();
    ((bcmu)localObject2).d((bbsa)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxn
 * JD-Core Version:    0.7.0.1
 */