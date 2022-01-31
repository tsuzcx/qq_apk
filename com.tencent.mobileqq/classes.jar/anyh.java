import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;

public class anyh
  extends aoam
{
  public EmojiStickerManager.StickerInfo a;
  public boolean a;
  public int c = -1;
  public int d;
  public int e;
  public int f = 0;
  public int g;
  public String h;
  public String i;
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return aylc.a(paramContext.getResources(), this.e);
  }
  
  public Drawable a(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return aylc.a(paramContext.getResources(), this.e);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return a(paramContext, paramFloat);
  }
  
  @NonNull
  public String toString()
  {
    return "EmoticonInfo[type: " + this.c + "  action: " + this.h + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyh
 * JD-Core Version:    0.7.0.1
 */