import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class aujd<T extends MessageRecord>
  extends auiw
{
  protected T a;
  protected MessageRecord b;
  
  public aujd(T paramT)
  {
    this.a = paramT;
  }
  
  protected abstract int a();
  
  protected MsgBackupResEntity a()
  {
    MsgBackupResEntity localMsgBackupResEntity = new MsgBackupResEntity();
    localMsgBackupResEntity.msgType = a();
    if (this.b != null)
    {
      aujq.a(this.b, localMsgBackupResEntity);
      return localMsgBackupResEntity;
    }
    aujq.a(this.a, localMsgBackupResEntity);
    return localMsgBackupResEntity;
  }
  
  protected String a(Map paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Exception paramMap) {}
    return null;
  }
  
  protected HashMap<String, String> a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(a()));
    localHashMap.put("msgSubType", String.valueOf(paramInt));
    return localHashMap;
  }
  
  public abstract List<MsgBackupResEntity> a();
  
  public abstract void a();
  
  protected void a(MessageRecord paramMessageRecord)
  {
    this.b = paramMessageRecord;
  }
  
  protected void a(String paramString, MsgBackupResEntity paramMsgBackupResEntity)
  {
    try
    {
      new File(paramString);
      paramMsgBackupResEntity.fileSize = new File(paramString).length();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aujd
 * JD-Core Version:    0.7.0.1
 */