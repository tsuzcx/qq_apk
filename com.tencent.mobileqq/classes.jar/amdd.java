import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class amdd
  implements alpg
{
  public void a(List<String> paramList) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField) {}
  
  public void a(boolean paramBoolean, List<Stranger> paramList) {}
  
  public void b(boolean paramBoolean, List<Stranger> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 4) {
      a(paramBoolean, (PBRepeatMessageField)paramObject);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        a(paramBoolean, (List)paramObject);
        return;
      }
      if (paramInt == 3)
      {
        b(paramBoolean, (List)paramObject);
        return;
      }
    } while (paramInt != 5);
    a((List)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdd
 * JD-Core Version:    0.7.0.1
 */