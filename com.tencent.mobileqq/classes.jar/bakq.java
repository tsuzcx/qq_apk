import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

public class bakq
  extends xav
{
  public bakq(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if ((paramBoolean) && (paramFileInfo != null))
    {
      String str = paramFileInfo.str_file_id.get();
      Object localObject = str;
      if (!str.startsWith("/")) {
        localObject = "/" + str;
      }
      localObject = this.a.a().a((String)localObject);
      if (localObject != null)
      {
        ((azpi)localObject).a = paramFileInfo.uint32_bus_id.get();
        ((azpi)localObject).c = paramFileInfo.uint32_dead_time.get();
      }
      this.a.a().d((azpi)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bakq
 * JD-Core Version:    0.7.0.1
 */