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

public class ayef
  extends amao
{
  ayef(ayee paramayee) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    try
    {
      if (ayee.a(this.a) != null)
      {
        ayee.a(this.a).dismiss();
        ayee.a(this.a);
      }
      if ((!ActiveEntitySearchFragment.a(ayee.a(this.a), paramArrayOfLong)) || (!paramString1.equals(ayee.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  reqKeyword=" + paramString1 + " keyword=" + ayee.a(this.a));
        return;
      }
    }
    catch (RuntimeException paramString2)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramString2, new Object[0]);
      }
      QQToast.a(BaseApplicationImpl.context, 0, 2131721180, 0).a();
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<ayjk> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4)
  {
    if (!TextUtils.equals(paramString2, ayee.b(this.a))) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + ayee.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + ayee.b(this.a) + " isEnd1=" + paramBoolean2);
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
      paramString3 = (Context)ayee.a(this.a).get();
      paramList1 = (QQAppInterface)ayee.b(this.a).get();
      try
      {
        if (ayee.a(this.a) != null)
        {
          ayee.a(this.a).dismiss();
          ayee.a(this.a);
        }
        if ((paramString3 == null) || (paramList1 == null))
        {
          QLog.e("UinSearcher", 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + ayee.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + ayee.b(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
        }
        if ((!ActiveEntitySearchFragment.a(ayee.a(this.a), paramArrayOfLong)) || (!paramString1.equals(ayee.a(this.a))))
        {
          QLog.d("UinSearcher", 2, "Unify handleTabSearchResult.  reqKeyword=" + paramString1 + " keyword=" + ayee.a(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
        paramArrayOfLong = new ayij[1];
        paramString4 = new ayij[1];
        ayee.a(this.a, 4);
        bhpy localbhpy = bhpy.a(paramString3);
        ayeg localayeg = new ayeg(this, paramString3, paramString1, paramList1, paramArrayOfLong, paramString4, localbhpy);
        ayeh localayeh = new ayeh(this, paramList1);
        paramString2 = (aloz)paramList1.getManager(51);
        if (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("UinSearcher", 2, "Unify handleTabSearchResult result is null");
          }
          localbhpy.a(String.format(paramString3.getString(2131694909), new Object[] { ayee.a(this.a) }));
          localbhpy.a(2131691360, 1, 2131362243);
          localbhpy.a(2131692400, 1, 2131362244);
          localbhpy.a(2131691699, 1, 2131362242);
          localbhpy.a(2131689686, 1, 2131362240);
          if ((!ayee.a(this.a).isSend()) && (!ayee.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(ayee.a(this.a).senderuin))) {
            localbhpy.a(2131689696, 1, 2131362241);
          }
          localbhpy.c(2131690648);
          localbhpy.a(localayeg);
          localbhpy.a(localayeh);
          localbhpy.show();
          azmj.b(paramList1, "dc00898", "", "", "0X800A923", "0X800A923", ayee.a(paramList1, ayee.b(this.a), ayee.d(this.a)), 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = aydw.a(paramList, paramBoolean1, false).iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramList = (ayjj)paramArrayOfByte.next();
          if ((paramList instanceof ayij)) {
            if (((ayij)paramList).d() == 1001) {
              paramArrayOfLong[0] = ((ayij)paramList);
            } else if (((ayij)paramList).d() == 1002) {
              paramString4[0] = ((ayij)paramList);
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
          ayee.a(paramArrayOfByte, i);
          i = 2131694909;
          if (paramString4[0] == null) {
            break label1266;
          }
          if (paramArrayOfLong[0] != null) {
            break label1258;
          }
          i = 2131721112;
          localbhpy.a(String.format(paramString3.getString(i), new Object[] { paramString1 }));
          localbhpy.a(2131691360, 1, 2131362243);
          localbhpy.a(2131692400, 1, 2131362244);
          localbhpy.a(2131691699, 1, 2131362242);
          localbhpy.a(2131689686, 1, 2131362240);
          if ((!ayee.a(this.a).isSend()) && (!ayee.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(ayee.a(this.a).senderuin))) {
            localbhpy.a(2131689696, 1, 2131362241);
          }
          paramList = (aosc)aogj.a().a(589);
          if (paramArrayOfLong[0] != null)
          {
            if (paramString2.b(paramString1)) {
              break label1296;
            }
            if ((TextUtils.isEmpty(paramArrayOfLong[0].c)) || (!paramList.a())) {
              break label1281;
            }
            localbhpy.a(paramString3.getString(2131689648) + "\n" + paramArrayOfLong[0].c, 65537, 2131362239);
          }
          if (paramString4[0] != null)
          {
            if (TroopInfo.isTroopMember(paramList1, paramString1)) {
              break label1416;
            }
            if ((TextUtils.isEmpty(paramString4[0].c)) || (!paramList.a())) {
              break label1401;
            }
            localbhpy.a(paramString3.getString(2131693805) + "\n" + paramString4[0].c, 65537, 2131362245);
          }
        }
        for (;;)
        {
          localbhpy.c(2131690648);
          localbhpy.a(localayeg);
          localbhpy.a(localayeh);
          try
          {
            if ((!(paramString3 instanceof Activity)) || (((Activity)paramString3).isFinishing())) {
              break label1503;
            }
            ThreadManagerV2.getUIHandlerV2().post(new UinSearcher.1.3(this, localbhpy, paramArrayOfLong, paramString4, paramList, paramList1));
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
          i = 2131694908;
          break label837;
          if (paramArrayOfLong[0] == null) {
            break label837;
          }
          i = 2131694908;
          break label837;
          localbhpy.a(2131689648, 1, 2131362239);
          break label1059;
          paramString2 = null;
          if (paramList.a())
          {
            paramArrayOfByte = bdbt.b(paramList1, paramString1, false);
            paramString2 = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              paramString2 = paramArrayOfLong[0].c;
            }
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            localbhpy.a(paramString3.getString(2131695053) + "\n" + paramString2, 65537, 2131362246);
            break label1059;
          }
          localbhpy.a(2131695053, 1, 2131362246);
          break label1059;
          localbhpy.a(2131693805, 1, 2131362245);
          continue;
          if ((!TextUtils.isEmpty(paramString4[0].c)) && (paramList.a())) {
            localbhpy.a(paramString3.getString(2131695077) + "\n" + paramString4[0].c, 65537, 2131362247);
          } else {
            localbhpy.a(2131695077, 1, 2131362247);
          }
        }
      }
    } while (ayee.a(this.a) == null);
    label1059:
    label1503:
    ayee.a(this.a).dismiss();
    label1281:
    label1296:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayef
 * JD-Core Version:    0.7.0.1
 */