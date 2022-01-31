import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import java.util.ArrayList;

public class awly
{
  public static awlu a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new awmb(paramQQAppInterface);
  }
  
  public static awlw a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    return new awmh(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
  }
  
  public static awvi a(int paramInt, String paramString, FTSEntity paramFTSEntity)
  {
    paramString = new awvi(paramString);
    paramFTSEntity = (FTSMessage)paramFTSEntity;
    paramString.a = new Bundle();
    paramString.a.putLong("uin", paramFTSEntity.uin);
    paramString.a.putInt("uinType", paramFTSEntity.istroop);
    return paramString;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return paramContext.getString(2131719090);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    String str = paramString;
    if (paramString.length() > 13) {
      str = paramString.substring(0, 10) + "…";
    }
    return paramContext.getString(2131719089, new Object[] { Integer.valueOf(paramInt1), str });
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    return ajya.a(2131704958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awly
 * JD-Core Version:    0.7.0.1
 */