import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

public class bakc
  extends xay
{
  public bakc(TroopFileTransferManager paramTroopFileTransferManager) {}
  
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
        ((azpg)localObject).a = paramFileInfo.uint32_bus_id.get();
        ((azpg)localObject).c = paramFileInfo.uint32_dead_time.get();
      }
      this.a.a().d((azpg)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bakc
 * JD-Core Version:    0.7.0.1
 */