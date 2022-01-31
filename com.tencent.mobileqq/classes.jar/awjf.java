import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.UinSearcher.1.3;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class awjf
  extends akiy
{
  awjf(awje paramawje) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    try
    {
      if (awje.a(this.a) != null)
      {
        awje.a(this.a).dismiss();
        awje.a(this.a);
      }
      if ((!ActiveEntitySearchFragment.a(awje.a(this.a), paramArrayOfLong)) || (!paramString1.equals(awje.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  reqKeyword=" + paramString1 + " keyword=" + awje.a(this.a));
        return;
      }
    }
    catch (RuntimeException paramString2)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramString2, new Object[0]);
      }
      bcql.a(BaseApplicationImpl.context, 0, 2131720640, 0).a();
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<awoh> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4)
  {
    if (!TextUtils.equals(paramString2, awje.b(this.a))) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + awje.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + awje.b(this.a) + " isEnd1=" + paramBoolean2);
    }
    label784:
    label828:
    label865:
    label1270:
    label1275:
    do
    {
      return;
      paramString3 = (Context)awje.a(this.a).get();
      paramList1 = (QQAppInterface)awje.b(this.a).get();
      try
      {
        if (awje.a(this.a) != null)
        {
          awje.a(this.a).dismiss();
          awje.a(this.a);
        }
        if ((paramString3 == null) || (paramList1 == null))
        {
          QLog.e("UinSearcher", 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + awje.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + awje.b(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
        }
        if ((!ActiveEntitySearchFragment.a(awje.a(this.a), paramArrayOfLong)) || (!paramString1.equals(awje.a(this.a))))
        {
          QLog.d("UinSearcher", 2, "Unify handleTabSearchResult.  reqKeyword=" + paramString1 + " keyword=" + awje.a(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
        awje.a(this.a, null);
        awje.b(this.a, null);
        awje.a(this.a, 4);
        paramArrayOfLong = bfpc.a(paramString3);
        paramString4 = new awjg(this, paramString3, paramString1, paramList1, paramArrayOfLong);
        awjh localawjh = new awjh(this, paramList1);
        paramString2 = (ajxl)paramList1.getManager(51);
        if (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("UinSearcher", 2, "Unify handleTabSearchResult result is null");
          }
          paramArrayOfLong.a(String.format(paramString3.getString(2131694752), new Object[] { awje.a(this.a) }));
          paramArrayOfLong.a(2131691307, 1, 2131362222);
          paramArrayOfLong.a(2131692324, 1, 2131362223);
          paramArrayOfLong.a(2131691644, 1, 2131362221);
          paramArrayOfLong.a(2131689685, 1, 2131362219);
          if ((!awje.a(this.a).isSend()) && (!awje.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(awje.a(this.a).senderuin))) {
            paramArrayOfLong.a(2131689695, 1, 2131362220);
          }
          paramArrayOfLong.c(2131690596);
          paramArrayOfLong.a(paramString4);
          paramArrayOfLong.a(localawjh);
          paramArrayOfLong.show();
          axqy.b(paramList1, "dc00898", "", "", "0X800A923", "0X800A923", awje.a(paramList1, awje.b(this.a), awje.d(this.a)), 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = awiw.a(paramList, paramBoolean1, false).iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramList = (awog)paramArrayOfByte.next();
          if ((paramList instanceof awng)) {
            if (((awng)paramList).d() == 1001) {
              awje.a(this.a, (awng)paramList);
            } else if (((awng)paramList).d() == 1002) {
              awje.b(this.a, (awng)paramList);
            }
          }
        }
        int i;
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder().append("search result: person is null=");
          if (awje.a(this.a) == null)
          {
            paramBoolean1 = true;
            paramArrayOfByte = paramArrayOfByte.append(paramBoolean1).append(", troop is null=");
            if (awje.b(this.a) != null) {
              break label1270;
            }
            paramBoolean1 = true;
            QLog.d("UinSearcher", 2, paramBoolean1);
          }
        }
        else
        {
          paramArrayOfByte = this.a;
          if (awje.a(this.a) != null) {
            break label1281;
          }
          if (awje.b(this.a) != null) {
            break label1275;
          }
          i = 4;
          awje.a(paramArrayOfByte, i);
          i = 2131694752;
          if (awje.b(this.a) == null) {
            break label1311;
          }
          if (awje.a(this.a) != null) {
            break label1303;
          }
          i = 2131720572;
          paramArrayOfLong.a(String.format(paramString3.getString(i), new Object[] { paramString1 }));
          paramArrayOfLong.a(2131691307, 1, 2131362222);
          paramArrayOfLong.a(2131692324, 1, 2131362223);
          paramArrayOfLong.a(2131691644, 1, 2131362221);
          paramArrayOfLong.a(2131689685, 1, 2131362219);
          if ((!awje.a(this.a).isSend()) && (!awje.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(awje.a(this.a).senderuin))) {
            paramArrayOfLong.a(2131689695, 1, 2131362220);
          }
          paramList = (anav)ampl.a().a(589);
          if (awje.a(this.a) != null)
          {
            if (paramString2.b(paramString1)) {
              break label1344;
            }
            if ((TextUtils.isEmpty(awje.a(this.a).c)) || (!paramList.a())) {
              break label1329;
            }
            paramArrayOfLong.a(paramString3.getString(2131689648) + "\n" + awje.a(this.a).c, 65537, 2131362218);
          }
          if (awje.b(this.a) != null)
          {
            if (TroopInfo.isTroopMember(paramList1, paramString1)) {
              break label1467;
            }
            if ((TextUtils.isEmpty(awje.b(this.a).c)) || (!paramList.a())) {
              break label1452;
            }
            paramArrayOfLong.a(paramString3.getString(2131693689) + "\n" + awje.b(this.a).c, 65537, 2131362224);
          }
        }
        for (;;)
        {
          paramArrayOfLong.c(2131690596);
          paramArrayOfLong.a(paramString4);
          paramArrayOfLong.a(localawjh);
          try
          {
            if ((!(paramString3 instanceof Activity)) || (((Activity)paramString3).isFinishing())) {
              break label1560;
            }
            ThreadManagerV2.getUIHandlerV2().post(new UinSearcher.1.3(this, paramArrayOfLong, paramList, paramList1));
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
          break label784;
          i = 2;
          break label828;
          if (awje.b(this.a) == null)
          {
            i = 1;
            break label828;
          }
          i = 3;
          break label828;
          i = 2131694751;
          break label865;
          if (awje.a(this.a) == null) {
            break label865;
          }
          i = 2131694751;
          break label865;
          paramArrayOfLong.a(2131689648, 1, 2131362218);
          break label1096;
          paramString2 = null;
          if (paramList.a())
          {
            paramArrayOfByte = bbcz.b(paramList1, paramString1, false);
            paramString2 = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              paramString2 = awje.a(this.a).c;
            }
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            paramArrayOfLong.a(paramString3.getString(2131694896) + "\n" + paramString2, 65537, 2131362225);
            break label1096;
          }
          paramArrayOfLong.a(2131694896, 1, 2131362225);
          break label1096;
          paramArrayOfLong.a(2131693689, 1, 2131362224);
          continue;
          if ((!TextUtils.isEmpty(awje.b(this.a).c)) && (paramList.a())) {
            paramArrayOfLong.a(paramString3.getString(2131694920) + "\n" + awje.b(this.a).c, 65537, 2131362226);
          } else {
            paramArrayOfLong.a(2131694920, 1, 2131362226);
          }
        }
      }
    } while (awje.a(this.a) == null);
    label1096:
    awje.a(this.a).dismiss();
    label1281:
    label1303:
    label1311:
    label1329:
    label1344:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjf
 * JD-Core Version:    0.7.0.1
 */