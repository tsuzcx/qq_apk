import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;

public class azwy
  implements anui
{
  public void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo, int paramInt, byte[] paramArrayOfByte) {}
  
  public void a(boolean paramBoolean, String paramString, PersonalityLabel paramPersonalityLabel, byte[] paramArrayOfByte, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        a(true, (String)paramObject[0], (PersonalityLabel)paramObject[1], (byte[])paramObject[2], ((Integer)paramObject[3]).intValue());
        return;
      }
      a(false, null, null, null, 0);
      return;
      paramObject = (Object[])paramObject;
      if (paramBoolean)
      {
        a(true, (String)paramObject[0], ((Long)paramObject[1]).longValue(), (PersonalityLabelInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (byte[])paramObject[4]);
        return;
      }
      if ((paramObject != null) && (paramObject.length > 0))
      {
        a(false, (String)paramObject[0], ((Long)paramObject[1]).longValue(), null, 0, null);
        return;
      }
      a(false, "", -1L, null, 0, null);
      return;
      paramObject = (Object[])paramObject;
      if (paramBoolean)
      {
        a(true, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
        return;
      }
    } while (paramObject == null);
    a(false, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwy
 * JD-Core Version:    0.7.0.1
 */