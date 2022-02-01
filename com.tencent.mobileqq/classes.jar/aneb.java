import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

public class aneb
  implements DialogInterface.OnClickListener
{
  public aneb(ApolloGameActivity paramApolloGameActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Bundle();
    paramDialogInterface.putBoolean("key_open_voice", true);
    paramDialogInterface.putString("key_game_friUin", ApolloGameActivity.a(this.a).mTempAIOUin);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_aduio_enter_room", paramDialogInterface, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aneb
 * JD-Core Version:    0.7.0.1
 */