import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import pb.unite.search.DynamicTabSearch.SubHotWord;

class avjk
  extends ajup
{
  avjk(avjj paramavjj) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    try
    {
      if (avjj.a(this.a) != null)
      {
        avjj.a(this.a).dismiss();
        avjj.a(this.a);
      }
      if ((!ActiveEntitySearchFragment.a(avjj.a(this.a), paramArrayOfLong)) || (!paramString1.equals(avjj.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  reqKeyword=" + paramString1 + " keyword=" + avjj.a(this.a));
        return;
      }
    }
    catch (RuntimeException paramString2)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramString2, new Object[0]);
      }
      bbmy.a(BaseApplicationImpl.context, 0, 2131654731, 0).a();
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<avom> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4)
  {
    if (!TextUtils.equals(paramString2, avjj.b(this.a)))
    {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + avjj.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + avjj.b(this.a) + " isEnd1=" + paramBoolean2);
      return;
    }
    paramList1 = (Context)avjj.a(this.a).get();
    paramString3 = (QQAppInterface)avjj.b(this.a).get();
    avjm localavjm;
    try
    {
      if (avjj.a(this.a) != null)
      {
        avjj.a(this.a).dismiss();
        avjj.a(this.a);
      }
      if ((paramList1 == null) || (paramString3 == null))
      {
        QLog.e("UinSearcher", 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + avjj.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + avjj.b(this.a) + " isEnd1=" + paramBoolean2);
        return;
      }
    }
    catch (RuntimeException paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
      }
      if ((!ActiveEntitySearchFragment.a(avjj.a(this.a), paramArrayOfLong)) || (!paramString1.equals(avjj.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchResult.  reqKeyword=" + paramString1 + " keyword=" + avjj.a(this.a) + " isEnd1=" + paramBoolean2);
        return;
      }
      avjj.a(this.a, null);
      avjj.b(this.a, null);
      avjj.a(this.a, 4);
      paramArrayOfLong = begr.a(paramList1);
      paramString4 = new avjl(this, paramList1, paramString1, paramString3, paramArrayOfLong);
      localavjm = new avjm(this, paramString3);
      paramString2 = (ajjj)paramString3.getManager(51);
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("UinSearcher", 2, "Unify handleTabSearchResult result is null");
        }
        paramArrayOfLong.a(String.format(paramList1.getString(2131629086), new Object[] { avjj.a(this.a) }));
        paramArrayOfLong.a(2131625731, 1, 2131296682);
        paramArrayOfLong.a(2131626722, 1, 2131296683);
        paramArrayOfLong.a(2131626068, 1, 2131296681);
        paramArrayOfLong.a(2131624145, 1, 2131296679);
        if ((!avjj.a(this.a).isSend()) && (!avjj.a(this.a).senderuin.equals(paramString3.getCurrentAccountUin())) && (paramString2.b(avjj.a(this.a).senderuin))) {
          paramArrayOfLong.a(2131624155, 1, 2131296680);
        }
        paramArrayOfLong.c(2131625035);
        paramArrayOfLong.a(paramString4);
        paramArrayOfLong.a(localavjm);
        paramArrayOfLong.show();
        awqx.b(paramString3, "dc00898", "", "", "0X800A923", "0X800A923", avjj.a(paramString3, avjj.b(this.a), avjj.d(this.a)), 0, "", "", "", "");
        return;
      }
      paramArrayOfByte = avjb.a(paramList, paramBoolean1, false).iterator();
      while (paramArrayOfByte.hasNext())
      {
        paramList = (avol)paramArrayOfByte.next();
        if ((paramList instanceof avnl)) {
          if (((avnl)paramList).d() == 1001) {
            avjj.a(this.a, (avnl)paramList);
          } else if (((avnl)paramList).d() == 1002) {
            avjj.b(this.a, (avnl)paramList);
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break label799;
      }
    }
    paramArrayOfByte = new StringBuilder().append("search result: person is null=");
    label758:
    int i;
    if (avjj.a(this.a) == null)
    {
      paramBoolean1 = true;
      paramArrayOfByte = paramArrayOfByte.append(paramBoolean1).append(", troop is null=");
      if (avjj.b(this.a) != null) {
        break label1340;
      }
      paramBoolean1 = true;
      label784:
      QLog.d("UinSearcher", 2, paramBoolean1);
      label799:
      paramArrayOfByte = this.a;
      if (avjj.a(this.a) != null) {
        break label1351;
      }
      if (avjj.b(this.a) != null) {
        break label1345;
      }
      i = 4;
      label828:
      avjj.a(paramArrayOfByte, i);
      i = 2131629086;
      if (avjj.b(this.a) == null) {
        break label1381;
      }
      if (avjj.a(this.a) != null) {
        break label1373;
      }
      i = 2131654663;
      label865:
      paramArrayOfLong.a(String.format(paramList1.getString(i), new Object[] { paramString1 }));
      paramArrayOfLong.a(2131625731, 1, 2131296682);
      paramArrayOfLong.a(2131626722, 1, 2131296683);
      paramArrayOfLong.a(2131626068, 1, 2131296681);
      paramArrayOfLong.a(2131624145, 1, 2131296679);
      if ((!avjj.a(this.a).isSend()) && (!avjj.a(this.a).senderuin.equals(paramString3.getCurrentAccountUin())) && (paramString2.b(avjj.a(this.a).senderuin))) {
        paramArrayOfLong.a(2131624155, 1, 2131296680);
      }
      paramList = (amkk)alzw.a().a(589);
      if (avjj.a(this.a) != null)
      {
        if (paramString2.b(paramString1)) {
          break label1414;
        }
        if ((TextUtils.isEmpty(avjj.a(this.a).c)) || (!paramList.a())) {
          break label1399;
        }
        paramArrayOfLong.a(paramList1.getString(2131624108) + "\n" + avjj.a(this.a).c, 65537, 2131296678);
      }
      label1096:
      if (avjj.b(this.a) != null)
      {
        if (TroopInfo.isTroopMember(paramString3, paramString1)) {
          break label1537;
        }
        if ((TextUtils.isEmpty(avjj.b(this.a).c)) || (!paramList.a())) {
          break label1522;
        }
        paramArrayOfLong.a(paramList1.getString(2131628047) + "\n" + avjj.b(this.a).c, 65537, 2131296684);
      }
      label1190:
      paramArrayOfLong.c(2131625035);
      paramArrayOfLong.a(paramString4);
      paramArrayOfLong.a(localavjm);
    }
    for (;;)
    {
      try
      {
        if ((!(paramList1 instanceof Activity)) || (((Activity)paramList1).isFinishing())) {
          break label1712;
        }
        paramArrayOfLong.show();
        if (avjj.a(this.a) != null) {
          break label1637;
        }
        if (avjj.b(this.a) != null) {
          break label1630;
        }
        paramString1 = "0X800A923";
        if ((avjj.a(this.a) != null) || (avjj.b(this.a) != null)) {
          break label1654;
        }
        paramString2 = "";
        awqx.b(paramString3, "dc00898", "", "", paramString1, paramString1, avjj.a(paramString3, avjj.b(this.a), avjj.d(this.a)), 0, paramString2, "", "", "");
        return;
      }
      catch (RuntimeException paramString1)
      {
        QLog.e("UinSearcher", 1, paramString1, new Object[0]);
        return;
      }
      paramBoolean1 = false;
      break label758;
      label1340:
      paramBoolean1 = false;
      break label784;
      label1345:
      i = 2;
      break label828;
      label1351:
      if (avjj.b(this.a) == null)
      {
        i = 1;
        break label828;
      }
      i = 3;
      break label828;
      label1373:
      i = 2131629085;
      break label865;
      label1381:
      if (avjj.a(this.a) == null) {
        break label865;
      }
      i = 2131629085;
      break label865;
      label1399:
      paramArrayOfLong.a(2131624108, 1, 2131296678);
      break label1096;
      label1414:
      paramString2 = null;
      if (paramList.a())
      {
        paramArrayOfByte = babh.b(paramString3, paramString1, false);
        paramString2 = paramArrayOfByte;
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          paramString2 = avjj.a(this.a).c;
        }
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramArrayOfLong.a(paramList1.getString(2131629218) + "\n" + paramString2, 65537, 2131296685);
        break label1096;
      }
      paramArrayOfLong.a(2131629218, 1, 2131296685);
      break label1096;
      label1522:
      paramArrayOfLong.a(2131628047, 1, 2131296684);
      break label1190;
      label1537:
      if ((!TextUtils.isEmpty(avjj.b(this.a).c)) && (paramList.a()))
      {
        paramArrayOfLong.a(paramList1.getString(2131629242) + "\n" + avjj.b(this.a).c, 65537, 2131296686);
        break label1190;
      }
      paramArrayOfLong.a(2131629242, 1, 2131296686);
      break label1190;
      label1630:
      paramString1 = "0X800A921";
      continue;
      label1637:
      if (avjj.b(this.a) == null)
      {
        paramString1 = "0X800A920";
        continue;
        label1654:
        if (paramList.a())
        {
          paramString2 = amkk.a + "";
          continue;
        }
        paramString2 = amkk.b + "";
        continue;
        if (avjj.a(this.a) == null) {
          break;
        }
        avjj.a(this.a).dismiss();
        return;
      }
      label1712:
      paramString1 = "0X800A922";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjk
 * JD-Core Version:    0.7.0.1
 */