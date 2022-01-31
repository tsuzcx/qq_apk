import android.os.Bundle;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.music.BroadcastMusicInfo;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import org.json.JSONObject;

public class andm
  implements Runnable
{
  public andm(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, Bundle paramBundle) {}
  
  public void run()
  {
    if (QzoneWebMusicJsPlugin.access$500(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin)) {
      for (;;)
      {
        try
        {
          localJSONObject1 = new JSONObject();
          if (this.jdField_a_of_type_AndroidOsBundle == null) {
            continue;
          }
          SongInfo localSongInfo = (SongInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("param.song");
          if ((localSongInfo == null) || (localSongInfo.jdField_a_of_type_Int != 9) || (localSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo == null)) {
            continue;
          }
          i = this.jdField_a_of_type_AndroidOsBundle.getInt("param.state");
          localJSONObject1.put("code", 0);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("uin", this.jdField_a_of_type_AndroidOsBundle.getLong("param.uin"));
          localJSONObject2.put("detailUrl", localSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.detailUrl);
          localJSONObject2.put("broadcastID", localSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.broadcastID);
          localJSONObject2.put("broadcastName", localSongInfo.jdField_a_of_type_CooperationQzoneMusicBroadcastMusicInfo.broadcastName);
          if (i != 2) {
            continue;
          }
          localJSONObject2.put("state", "playing");
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject1;
          int i;
          JSONObject localJSONObject2;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e(QzoneWebMusicJsPlugin.access$600(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin), 2, "callNetWorkInterfaceForGetttingLiveInfo error");
          return;
          localJSONObject2.put("state", "paused");
          continue;
          localException.put("code", 1);
          continue;
          QzoneWebMusicJsPlugin.access$700().a(localException);
        }
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.e(QzoneWebMusicJsPlugin.access$600(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin), 2, "callNetWorkInterfaceForGetttingLiveInfo  isDestroy " + this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin.isDestroy + "  result " + localJSONObject1.toString());
        }
        if ((this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin.isDestroy) || (QzoneWebMusicJsPlugin.access$700() == null)) {
          return;
        }
        if (!QzoneWebMusicJsPlugin.access$700().a) {
          continue;
        }
        this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin.callJs4OpenApi(QzoneWebMusicJsPlugin.access$700(), 0, localJSONObject1.toString());
        return;
        if (i != 1) {
          continue;
        }
        localJSONObject2.put("state", "buffering");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andm
 * JD-Core Version:    0.7.0.1
 */