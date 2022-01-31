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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class ayio
  extends amfd
{
  ayio(ayin paramayin) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    try
    {
      if (ayin.a(this.a) != null)
      {
        ayin.a(this.a).dismiss();
        ayin.a(this.a);
      }
      if ((!ActiveEntitySearchFragment.a(ayin.a(this.a), paramArrayOfLong)) || (!paramString1.equals(ayin.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  reqKeyword=" + paramString1 + " keyword=" + ayin.a(this.a));
        return;
      }
    }
    catch (RuntimeException paramString2)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramString2, new Object[0]);
      }
      QQToast.a(BaseApplicationImpl.context, 0, 2131721193, 0).a();
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<aynt> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4)
  {
    if (!TextUtils.equals(paramString2, ayin.b(this.a))) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + ayin.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + ayin.b(this.a) + " isEnd1=" + paramBoolean2);
    }
    label768:
    label806:
    label837:
    label1228:
    label1233:
    label1239:
    label1258:
    label1266:
    label1401:
    do
    {
      return;
      paramString3 = (Context)ayin.a(this.a).get();
      paramList1 = (QQAppInterface)ayin.b(this.a).get();
      try
      {
        if (ayin.a(this.a) != null)
        {
          ayin.a(this.a).dismiss();
          ayin.a(this.a);
        }
        if ((paramString3 == null) || (paramList1 == null))
        {
          QLog.e("UinSearcher", 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + ayin.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + ayin.b(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
        }
        if ((!ActiveEntitySearchFragment.a(ayin.a(this.a), paramArrayOfLong)) || (!paramString1.equals(ayin.a(this.a))))
        {
          QLog.d("UinSearcher", 2, "Unify handleTabSearchResult.  reqKeyword=" + paramString1 + " keyword=" + ayin.a(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
        paramArrayOfLong = new ayms[1];
        paramString4 = new ayms[1];
        ayin.a(this.a, 4);
        bhuf localbhuf = bhuf.a(paramString3);
        ayip localayip = new ayip(this, paramString3, paramString1, paramList1, paramArrayOfLong, paramString4, localbhuf);
        ayiq localayiq = new ayiq(this, paramList1);
        paramString2 = (alto)paramList1.getManager(51);
        if (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("UinSearcher", 2, "Unify handleTabSearchResult result is null");
          }
          localbhuf.a(String.format(paramString3.getString(2131694911), new Object[] { ayin.a(this.a) }));
          localbhuf.a(2131691361, 1, 2131362243);
          localbhuf.a(2131692401, 1, 2131362244);
          localbhuf.a(2131691700, 1, 2131362242);
          localbhuf.a(2131689686, 1, 2131362240);
          if ((!ayin.a(this.a).isSend()) && (!ayin.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(ayin.a(this.a).senderuin))) {
            localbhuf.a(2131689696, 1, 2131362241);
          }
          localbhuf.c(2131690648);
          localbhuf.a(localayip);
          localbhuf.a(localayiq);
          localbhuf.show();
          azqs.b(paramList1, "dc00898", "", "", "0X800A923", "0X800A923", ayin.a(paramList1, ayin.b(this.a), ayin.d(this.a)), 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = ayif.a(paramList, paramBoolean1, false).iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramList = (ayns)paramArrayOfByte.next();
          if ((paramList instanceof ayms)) {
            if (((ayms)paramList).d() == 1001) {
              paramArrayOfLong[0] = ((ayms)paramList);
            } else if (((ayms)paramList).d() == 1002) {
              paramString4[0] = ((ayms)paramList);
            }
          }
        }
        int i;
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder().append("search result: person is null=");
          if (paramArrayOfLong[0] == null)
          {
            paramBoolean1 = true;
            paramArrayOfByte = paramArrayOfByte.append(paramBoolean1).append(", troop is null=");
            if (paramString4[0] != null) {
              break label1228;
            }
            paramBoolean1 = true;
            QLog.d("UinSearcher", 2, paramBoolean1);
          }
        }
        else
        {
          paramArrayOfByte = this.a;
          if (paramArrayOfLong[0] != null) {
            break label1239;
          }
          if (paramString4[0] != null) {
            break label1233;
          }
          i = 4;
          ayin.a(paramArrayOfByte, i);
          i = 2131694911;
          if (paramString4[0] == null) {
            break label1266;
          }
          if (paramArrayOfLong[0] != null) {
            break label1258;
          }
          i = 2131721124;
          localbhuf.a(String.format(paramString3.getString(i), new Object[] { paramString1 }));
          localbhuf.a(2131691361, 1, 2131362243);
          localbhuf.a(2131692401, 1, 2131362244);
          localbhuf.a(2131691700, 1, 2131362242);
          localbhuf.a(2131689686, 1, 2131362240);
          if ((!ayin.a(this.a).isSend()) && (!ayin.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(ayin.a(this.a).senderuin))) {
            localbhuf.a(2131689696, 1, 2131362241);
          }
          paramList = (aowl)aoks.a().a(589);
          if (paramArrayOfLong[0] != null)
          {
            if (paramString2.b(paramString1)) {
              break label1296;
            }
            if ((TextUtils.isEmpty(paramArrayOfLong[0].c)) || (!paramList.a())) {
              break label1281;
            }
            localbhuf.a(paramString3.getString(2131689648) + "\n" + paramArrayOfLong[0].c, 65537, 2131362239);
          }
          if (paramString4[0] != null)
          {
            if (TroopInfo.isTroopMember(paramList1, paramString1)) {
              break label1416;
            }
            if ((TextUtils.isEmpty(paramString4[0].c)) || (!paramList.a())) {
              break label1401;
            }
            localbhuf.a(paramString3.getString(2131693807) + "\n" + paramString4[0].c, 65537, 2131362245);
          }
        }
        for (;;)
        {
          localbhuf.c(2131690648);
          localbhuf.a(localayip);
          localbhuf.a(localayiq);
          try
          {
            if ((!(paramString3 instanceof Activity)) || (((Activity)paramString3).isFinishing())) {
              break label1503;
            }
            ThreadManagerV2.getUIHandlerV2().post(new UinSearcher.1.3(this, localbhuf, paramArrayOfLong, paramString4, paramList, paramList1));
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
          break label768;
          i = 2;
          break label806;
          if (paramString4[0] == null)
          {
            i = 1;
            break label806;
          }
          i = 3;
          break label806;
          i = 2131694910;
          break label837;
          if (paramArrayOfLong[0] == null) {
            break label837;
          }
          i = 2131694910;
          break label837;
          localbhuf.a(2131689648, 1, 2131362239);
          break label1059;
          paramString2 = null;
          if (paramList.a())
          {
            paramArrayOfByte = bdgc.b(paramList1, paramString1, false);
            paramString2 = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              paramString2 = paramArrayOfLong[0].c;
            }
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            localbhuf.a(paramString3.getString(2131695055) + "\n" + paramString2, 65537, 2131362246);
            break label1059;
          }
          localbhuf.a(2131695055, 1, 2131362246);
          break label1059;
          localbhuf.a(2131693807, 1, 2131362245);
          continue;
          if ((!TextUtils.isEmpty(paramString4[0].c)) && (paramList.a())) {
            localbhuf.a(paramString3.getString(2131695079) + "\n" + paramString4[0].c, 65537, 2131362247);
          } else {
            localbhuf.a(2131695079, 1, 2131362247);
          }
        }
      }
    } while (ayin.a(this.a) == null);
    label1059:
    label1503:
    ayin.a(this.a).dismiss();
    label1281:
    label1296:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayio
 * JD-Core Version:    0.7.0.1
 */