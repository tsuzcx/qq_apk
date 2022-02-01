import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;

class bgnd
  implements aksh
{
  bgnd(bgna parambgna) {}
  
  public void a(Bundle paramBundle)
  {
    if ((bgna.a(this.a) == null) || (bgna.a(this.a) == null) || (bgna.a(this.a) == null)) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    Intent localIntent = new Intent();
    localIntent.setClass(bgna.a(this.a), TroopAvatarWallEditActivity.class);
    localBundle.putInt("index", 0);
    localBundle.putString("troop_uin", bgna.a(this.a).troopUin);
    localBundle.putLong("troop_flag_ext", bgna.a(this.a).dwGroupFlagExt);
    localBundle.putBoolean("isUseClassAvatar", bgna.a(this.a).isUseClassAvatar);
    boolean bool = localBundle.getBoolean("IS_EDIT");
    int i;
    if (!localBundle.getBoolean("IS_COVER"))
    {
      i = 1;
      if (i == 0) {
        break label232;
      }
      paramBundle = (ArrayList)bgna.a(this.a);
      label165:
      if (!bool) {
        break label246;
      }
      localBundle.putInt("vistor_type", 1);
      label177:
      localBundle.putParcelableArrayList("PHOTO_LIST", paramBundle);
      if (i == 0) {
        break label264;
      }
      if (!bool) {
        break label257;
      }
      i = 260;
    }
    for (;;)
    {
      localIntent.putExtras(localBundle);
      localIntent.addFlags(603979776);
      bgna.a(this.a).startActivityForResult(localIntent, i);
      return;
      i = 0;
      break;
      label232:
      paramBundle = (ArrayList)bgna.b(this.a);
      break label165;
      label246:
      localBundle.putInt("vistor_type", 2);
      break label177;
      label257:
      i = 261;
      continue;
      label264:
      if (bool) {
        i = 258;
      } else {
        i = 259;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnd
 * JD-Core Version:    0.7.0.1
 */