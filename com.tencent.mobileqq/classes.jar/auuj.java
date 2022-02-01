import android.content.Intent;
import android.text.TextUtils;

class auuj
  implements auus
{
  auuj(auui paramauui) {}
  
  public void onSharMsgcallback(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      this.a.callJs(paramString1, new String[] { paramString2 });
      return;
    }
    this.a.callJs4OpenApiIfNeeded("shareMsg", 0, paramString2);
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    this.a.startActivityForResult(paramIntent, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auuj
 * JD-Core Version:    0.7.0.1
 */