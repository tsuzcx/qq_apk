import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class bagh
  extends akim
{
  bagh(bagc parambagc) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      if (bagc.a(this.a) == null) {
        break label86;
      }
    }
    for (;;)
    {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
      if ((bagc.a(this.a) != null) && (bagc.a(this.a) != null)) {
        break;
      }
      return;
      label86:
      bool = false;
    }
    bagc.a(this.a).a(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label111;
      }
      str = "";
      if (bagc.a(this.a) == null) {
        break label117;
      }
    }
    label111:
    label117:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", str, ", hasTroopInfoData=", Boolean.valueOf(bool) });
      if ((bagc.a(this.a) != null) && (bagc.a(this.a) != null)) {
        break label123;
      }
      return;
      str = paramString;
      break;
    }
    label123:
    bagc.a(this.a).a(paramInt1, paramInt2, paramString);
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (bagc.a(this.a) == null) {
      return;
    }
    bagc.a(this.a).e(paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if ((bagc.a(this.a) == null) || (bagc.a(this.a) == null)) {
      return;
    }
    bagc.a(this.a).a(paramBoolean, paramLong, paramTroopInfo);
  }
  
  protected void a(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess)
  {
    if ((paramRespBatchProcess == null) || (paramRespBatchProcess.batch_response_list == null) || (paramRespBatchProcess.batch_response_list.size() == 0) || (bagc.a(this.a) == null)) {}
    int j;
    do
    {
      do
      {
        do
        {
          return;
        } while ((!String.valueOf(paramLong).equals(bagc.a(this.a).troopUin)) || (bagc.a(this.a) == null) || (bagc.a(this.a) == null));
        if (bagc.a(this.a).a != null) {
          bagc.a(this.a).a.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      } while (!String.valueOf(paramLong).equals(bagc.a(this.a).troopUin));
      j = paramRespBatchProcess.batch_response_list.size();
      int i = 0;
      if (i < j)
      {
        BatchResponse localBatchResponse = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((localBatchResponse == null) || (localBatchResponse.result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (localBatchResponse.type == 1) {
            bagc.a(this.a, localBatchResponse);
          }
        }
      }
    } while (j <= 0);
    this.a.c();
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if ((bagc.a(this.a) == null) || (bagc.a(this.a) == null)) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!bbbd.a(paramString1, bagc.a(this.a).troopUin)));
      if (paramInt1 == 0)
      {
        this.a.a(paramList, true);
        return;
      }
    } while (paramString2 != null);
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      paramString2 = bagc.a(this.a).getString(2131696369);
    }
    for (;;)
    {
      bagc.a(this.a).a(paramString2);
      return;
      if (paramInt1 == 19) {
        paramString2 = bagc.a(this.a).getString(2131696367);
      } else if (paramInt1 == 65) {
        paramString2 = bagc.a(this.a).getString(2131696368);
      }
    }
  }
  
  protected void b(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.b(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (paramInt1 != 2) {}
    while ((!paramBoolean) || (bagc.a(this.a) == null) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    bagc.a(this.a).a(paramLong1, paramList);
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if ((bagc.a(this.a) == null) || (bagc.a(this.a) == null)) {}
    while (!bbbd.a(paramString1, bagc.a(this.a).troopUin)) {
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
      paramString1 = bagc.a(this.a).getString(2131696369);
    }
    for (;;)
    {
      bagc.a(this.a).a(paramString1);
      return;
      label106:
      if (paramInt1 == 2) {
        paramString1 = bagc.a(this.a).getString(2131696367);
      } else if (paramInt1 == 3) {
        paramString1 = bagc.a(this.a).getString(2131696380);
      } else if (paramInt1 == 4) {
        paramString1 = bagc.a(this.a).getString(2131696381);
      } else {
        paramString1 = bagc.a(this.a).getString(2131696378);
      }
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (bagc.a(this.a) != null)) {
      bagc.a(this.a).c(paramString);
    }
  }
  
  protected void c(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (bagc.a(this.a) != null) && (paramString.equals(bagc.a(this.a).troopUin))) {
      this.a.a = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bagh
 * JD-Core Version:    0.7.0.1
 */