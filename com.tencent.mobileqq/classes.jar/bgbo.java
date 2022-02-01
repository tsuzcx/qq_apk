import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.qphone.base.util.QLog;

class bgbo
  extends aofu
{
  bgbo(bgbn parambgbn) {}
  
  protected void onGetTroopInfoExtComplete(boolean paramBoolean, String paramString, TroopInfoExt paramTroopInfoExt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansBeatRankProcessor", 2, new Object[] { "onGetTroopInfoExtComplete,", Boolean.valueOf(paramBoolean), " troopUin=", paramString });
    }
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((!TextUtils.equals(bgbn.a(this.a), paramString)) || (!bghc.a(bgbn.a(this.a), paramString, paramTroopInfoExt))) {
      return;
    }
    bgbn.a(this.a);
  }
  
  protected void onTroopClassExtChanged(boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while (!TextUtils.equals(paramString, bgbn.a(this.a))) {
      return;
    }
    bgbn.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbo
 * JD-Core Version:    0.7.0.1
 */