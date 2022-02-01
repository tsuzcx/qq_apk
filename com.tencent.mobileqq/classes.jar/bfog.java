import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

class bfog
  extends aahi
{
  bfog(bfoe parambfoe) {}
  
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
        bfmf.c("TroopFileUploadFeedsSender", bfmf.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onGetOneFileResult. bus_id:" + paramFileInfo.uint32_bus_id.get() + " dead_time:" + paramFileInfo.uint32_dead_time.get());
        localObject2 = bfmd.a(this.a.d);
      } while (localObject2 == null);
      localObject1 = ((bgjh)localObject2).a((String)localObject1);
    } while (localObject1 == null);
    ((bfif)localObject1).a = paramFileInfo.uint32_bus_id.get();
    ((bfif)localObject1).c = paramFileInfo.uint32_dead_time.get();
    ((bgjh)localObject2).d((bfif)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfog
 * JD-Core Version:    0.7.0.1
 */