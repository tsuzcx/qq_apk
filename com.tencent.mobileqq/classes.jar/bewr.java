import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class bewr
  extends andd
{
  bewr(bewm parambewm) {}
  
  protected void onBatchGetTroopInfoResp(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle)
  {
    if ((paramRespBatchProcess == null) || (paramRespBatchProcess.batch_response_list == null) || (paramRespBatchProcess.batch_response_list.size() == 0) || (bewm.a(this.a) == null)) {}
    int j;
    do
    {
      do
      {
        do
        {
          return;
        } while ((!String.valueOf(paramLong).equals(bewm.a(this.a).troopUin)) || (bewm.a(this.a) == null) || (bewm.a(this.a) == null));
        if (bewm.a(this.a).a != null) {
          bewm.a(this.a).a.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      } while (!String.valueOf(paramLong).equals(bewm.a(this.a).troopUin));
      j = paramRespBatchProcess.batch_response_list.size();
      int i = 0;
      if (i < j)
      {
        paramBundle = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((paramBundle == null) || (paramBundle.result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (paramBundle.type == 1) {
            bewm.a(this.a, paramBundle);
          }
        }
      }
    } while (j <= 0);
    this.a.c();
  }
  
  protected void onCmdTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if ((bewm.a(this.a) == null) || (bewm.a(this.a) == null)) {}
    while (!bftf.a(paramString1, bewm.a(this.a).troopUin)) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.a.a(paramList, true);
      return;
    }
    this.a.a(paramList, true);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramInt1 != 1) {
        break label106;
      }
      paramString1 = bewm.a(this.a).getString(2131695552);
    }
    for (;;)
    {
      bewm.a(this.a).a(paramString1);
      return;
      label106:
      if (paramInt1 == 2) {
        paramString1 = bewm.a(this.a).getString(2131695550);
      } else if (paramInt1 == 3) {
        paramString1 = bewm.a(this.a).getString(2131695563);
      } else if (paramInt1 == 4) {
        paramString1 = bewm.a(this.a).getString(2131695564);
      } else {
        paramString1 = bewm.a(this.a).getString(2131695561);
      }
    }
  }
  
  protected void onGetAddTroopWebInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (bewm.a(this.a) == null) {
      return;
    }
    bewm.a(this.a).e(paramString);
  }
  
  protected void onGetTroopAuthSubmitTime(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (bewm.a(this.a) != null) && (paramString.equals(bewm.a(this.a).troopUin))) {
      this.a.a = paramInt;
    }
  }
  
  protected void onGetTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if ((bewm.a(this.a) == null) || (bewm.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!bftf.a(paramString1, bewm.a(this.a).troopUin)));
      if (paramInt1 == 0)
      {
        this.a.a(paramList, true);
        return;
      }
    } while (paramString2 != null);
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      paramString2 = bewm.a(this.a).getString(2131695552);
    }
    for (;;)
    {
      bewm.a(this.a).a(paramString2);
      return;
      if (paramInt1 == 19) {
        paramString2 = bewm.a(this.a).getString(2131695550);
      } else if (paramInt1 == 65) {
        paramString2 = bewm.a(this.a).getString(2131695551);
      }
    }
  }
  
  protected void onGetTroopTagResult(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (bewm.a(this.a) != null)) {
      bewm.a(this.a).c(paramString);
    }
  }
  
  protected void onJoinTroopSecurityTips(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, "onTroopRankSwitchUpdate. troopUin = " + paramString + ",isSucc = " + paramBoolean + ", tId" + paramInt + ",time = " + paramLong);
    }
    if ((bewm.a(this.a) == null) || (TextUtils.isEmpty(bewm.a(this.a).troopUin)) || (TextUtils.isEmpty(paramString)) || (!bewm.a(this.a).troopUin.equals(paramString)) || (paramBoolean)) {
      return;
    }
    bewm.a(this.a).a(paramBoolean, paramString, paramInt, paramLong);
  }
  
  protected void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if ((bewm.a(this.a) == null) || (bewm.a(this.a) == null)) {
      return;
    }
    bewm.a(this.a).a(paramBoolean, paramLong, paramTroopInfo);
  }
  
  protected void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_1_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (paramInt1 != 2) {}
    while ((!paramBoolean) || (bewm.a(this.a) == null) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    bewm.a(this.a).a(paramLong1, paramList);
  }
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      if (bewm.a(this.a) == null) {
        break label86;
      }
    }
    for (;;)
    {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
      if ((bewm.a(this.a) != null) && (bewm.a(this.a) != null)) {
        break;
      }
      return;
      label86:
      bool = false;
    }
    bewm.a(this.a).a(paramInt1, paramInt2);
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label111;
      }
      str = "";
      if (bewm.a(this.a) == null) {
        break label117;
      }
    }
    label111:
    label117:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", str, ", hasTroopInfoData=", Boolean.valueOf(bool) });
      if ((bewm.a(this.a) != null) && (bewm.a(this.a) != null)) {
        break label123;
      }
      return;
      str = paramString;
      break;
    }
    label123:
    bewm.a(this.a).a(paramInt1, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bewr
 * JD-Core Version:    0.7.0.1
 */