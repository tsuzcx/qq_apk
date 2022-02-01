import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import java.util.ArrayList;

public class bcdh
{
  public static bcdd a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new bcdk(paramQQAppInterface);
  }
  
  public static bcdf a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    return new bcdq(paramQQAppInterface, paramString, paramArrayList, paramFTSEntity);
  }
  
  public static bcmq a(int paramInt, String paramString, FTSEntity paramFTSEntity)
  {
    paramString = new bcmq(paramString);
    paramFTSEntity = (FTSMessage)paramFTSEntity;
    paramString.a = new Bundle();
    paramString.a.putLong("uin", paramFTSEntity.uin);
    paramString.a.putInt("uinType", paramFTSEntity.istroop);
    return paramString;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return paramContext.getString(2131717751);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    String str = paramString;
    if (paramString.length() > 13) {
      str = paramString.substring(0, 10) + "…";
    }
    return paramContext.getString(2131717750, new Object[] { Integer.valueOf(paramInt1), str });
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    return anzj.a(2131703845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdh
 * JD-Core Version:    0.7.0.1
 */