import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.UinSearcher.1.3;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class batk
  extends andq
{
  batk(batj parambatj) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    paramString2 = (QQAppInterface)batj.a(this.a).get();
    if (QLog.isColorLevel()) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    try
    {
      if (batj.a(this.a) != null)
      {
        batj.a(this.a).dismiss();
        batj.a(this.a);
      }
      if ((!ActiveEntitySearchFragment.a(batj.a(this.a), paramArrayOfLong)) || (!paramString1.equals(batj.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  reqKeyword=" + paramString1 + " keyword=" + batj.a(this.a));
        return;
      }
    }
    catch (RuntimeException paramString3)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramString3, new Object[0]);
      }
      QQToast.a(BaseApplicationImpl.context, 0, 2131719363, 0).a();
      bcef.b(paramString2, "dc00898", "", "", "0X800B0C0", "0X800B0C0", batj.a(batj.a(this.a)), 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<bays> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    if (!TextUtils.equals(paramString2, batj.b(this.a))) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + batj.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + batj.b(this.a) + " isEnd1=" + paramBoolean2);
    }
    label802:
    label840:
    label871:
    label1015:
    do
    {
      return;
      paramString3 = (Context)batj.b(this.a).get();
      paramList1 = (QQAppInterface)batj.a(this.a).get();
      try
      {
        if (batj.a(this.a) != null)
        {
          batj.a(this.a).dismiss();
          batj.a(this.a);
        }
        if ((paramString3 == null) || (paramList1 == null))
        {
          QLog.e("UinSearcher", 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + batj.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + batj.b(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
        }
        if ((!ActiveEntitySearchFragment.a(batj.a(this.a), paramArrayOfLong)) || (!paramString1.equals(batj.a(this.a))))
        {
          QLog.d("UinSearcher", 2, "Unify handleTabSearchResult.  reqKeyword=" + paramString1 + " keyword=" + batj.a(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
        paramArrayOfLong = new baxr[1];
        paramString4 = new baxr[1];
        baxr[] arrayOfbaxr = new baxr[1];
        batj.a(this.a, 4);
        bjnw localbjnw = bjnw.a(paramString3);
        batl localbatl = new batl(this, paramString3, paramString1, paramList1, paramArrayOfLong, paramString4, arrayOfbaxr, localbjnw);
        batm localbatm = new batm(this, paramList1);
        paramString2 = (amsw)paramList1.getManager(51);
        if (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("UinSearcher", 2, "Unify handleTabSearchResult result is null");
          }
          localbjnw.a(String.format(paramString3.getString(2131694172), new Object[] { batj.a(this.a) }));
          localbjnw.a(2131691179, 1, 2131362333);
          localbjnw.a(2131692036, 1, 2131362334);
          localbjnw.a(2131691480, 1, 2131362332);
          localbjnw.a(2131689605, 1, 2131362330);
          if ((!batj.a(this.a).isSend()) && (!batj.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(batj.a(this.a).senderuin))) {
            localbjnw.a(2131689614, 1, 2131362331);
          }
          localbjnw.c(2131690620);
          localbjnw.a(localbatl);
          localbjnw.a(localbatm);
          localbjnw.show();
          bcef.b(paramList1, "dc00898", "", "", "0X800A923", "0X800A923", batj.a(paramList1, batj.a(this.a), batj.d(this.a)), 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = batb.a(paramList, paramBoolean1, false).iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramList = (bayr)paramArrayOfByte.next();
          if ((paramList instanceof baxr)) {
            if (((baxr)paramList).d() == 1001) {
              paramArrayOfLong[0] = ((baxr)paramList);
            } else if (((baxr)paramList).d() == 1002) {
              paramString4[0] = ((baxr)paramList);
            } else if (((baxr)paramList).d() == 8001) {
              arrayOfbaxr[0] = ((baxr)paramList);
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder().append("search result: person is null=");
          if (paramArrayOfLong[0] == null)
          {
            paramBoolean1 = true;
            paramArrayOfByte = paramArrayOfByte.append(paramBoolean1).append(", troop is null=");
            if (paramString4[0] != null) {
              break label1345;
            }
            paramBoolean1 = true;
            QLog.d("UinSearcher", 2, paramBoolean1);
          }
        }
        else
        {
          paramArrayOfByte = this.a;
          if (paramArrayOfLong[0] != null) {
            break label1356;
          }
          if (paramString4[0] != null) {
            break label1350;
          }
          paramInt = 4;
          batj.a(paramArrayOfByte, paramInt);
          paramInt = 2131694172;
          if (paramString4[0] == null) {
            break label1383;
          }
          if (paramArrayOfLong[0] != null) {
            break label1375;
          }
          paramInt = 2131719289;
          localbjnw.a(String.format(paramString3.getString(paramInt), new Object[] { paramString1 }));
          localbjnw.a(2131691179, 1, 2131362333);
          localbjnw.a(2131692036, 1, 2131362334);
          localbjnw.a(2131691480, 1, 2131362332);
          localbjnw.a(2131689605, 1, 2131362330);
          if ((arrayOfbaxr[0] != null) && (!TextUtils.isEmpty(arrayOfbaxr[0].m)))
          {
            if (!TextUtils.isEmpty(arrayOfbaxr[0].l)) {
              break label1398;
            }
            localbjnw.a(paramString3.getString(2131694399) + "\n" + arrayOfbaxr[0].m, 65537, 2131362338);
          }
          if ((!batj.a(this.a).isSend()) && (!batj.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(batj.a(this.a).senderuin))) {
            localbjnw.a(2131689614, 1, 2131362331);
          }
          paramList = (aqja)apub.a().a(589);
          if (paramArrayOfLong[0] != null)
          {
            if (paramString2.b(paramString1)) {
              break label1477;
            }
            if ((TextUtils.isEmpty(paramArrayOfLong[0].c)) || (!paramList.a())) {
              break label1462;
            }
            localbjnw.a(paramString3.getString(2131689570) + "\n" + paramArrayOfLong[0].c, 65537, 2131362329);
          }
          if (paramString4[0] != null)
          {
            if (TroopInfo.isTroopMember(paramList1, paramString1)) {
              break label1597;
            }
            if ((TextUtils.isEmpty(paramString4[0].c)) || (!paramList.a())) {
              break label1582;
            }
            localbjnw.a(paramString3.getString(2131693221) + "\n" + paramString4[0].c, 65537, 2131362335);
          }
        }
        for (;;)
        {
          localbjnw.c(2131690620);
          localbjnw.a(localbatl);
          localbjnw.a(localbatm);
          try
          {
            if ((!(paramString3 instanceof Activity)) || (((Activity)paramString3).isFinishing())) {
              break label1684;
            }
            ThreadManagerV2.getUIHandlerV2().post(new UinSearcher.1.3(this, localbjnw, paramArrayOfLong, paramString4, paramList, paramList1, arrayOfbaxr));
            return;
          }
          catch (RuntimeException paramString1)
          {
            QLog.e("UinSearcher", 1, paramString1, new Object[0]);
            return;
          }
          paramBoolean1 = false;
          break;
          paramBoolean1 = false;
          break label802;
          paramInt = 2;
          break label840;
          if (paramString4[0] == null)
          {
            paramInt = 1;
            break label840;
          }
          paramInt = 3;
          break label840;
          paramInt = 2131694171;
          break label871;
          if (paramArrayOfLong[0] == null) {
            break label871;
          }
          paramInt = 2131694171;
          break label871;
          localbjnw.a(paramString3.getString(2131694399) + "\n" + arrayOfbaxr[0].m, 65537, 2131362338, Integer.valueOf(Color.parseColor(arrayOfbaxr[0].l)));
          break label1015;
          localbjnw.a(2131689570, 1, 2131362329);
          break label1174;
          paramString2 = null;
          if (paramList.a())
          {
            paramArrayOfByte = ContactUtils.getBuddyName(paramList1, paramString1, false);
            paramString2 = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              paramString2 = paramArrayOfLong[0].c;
            }
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            localbjnw.a(paramString3.getString(2131694254) + "\n" + paramString2, 65537, 2131362336);
            break label1174;
          }
          localbjnw.a(2131694254, 1, 2131362336);
          break label1174;
          localbjnw.a(2131693221, 1, 2131362335);
          continue;
          if ((!TextUtils.isEmpty(paramString4[0].c)) && (paramList.a())) {
            localbjnw.a(paramString3.getString(2131694272) + "\n" + paramString4[0].c, 65537, 2131362337);
          } else {
            localbjnw.a(2131694272, 1, 2131362337);
          }
        }
      }
    } while (batj.a(this.a) == null);
    label1174:
    label1345:
    label1350:
    label1356:
    label1375:
    label1383:
    label1398:
    batj.a(this.a).dismiss();
    label1462:
    label1477:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batk
 * JD-Core Version:    0.7.0.1
 */