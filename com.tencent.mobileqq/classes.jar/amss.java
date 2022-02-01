import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

public class amss
  implements amze
{
  public amss(ApolloGameInterfaceProxy paramApolloGameInterfaceProxy, int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new Bundle();
      paramString1.putInt("type", this.jdField_a_of_type_Int);
      paramString1.putString("uin", paramString2);
      paramString2 = new amst(this);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_get_accountInfo", paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amss
 * JD-Core Version:    0.7.0.1
 */