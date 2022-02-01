import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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

public class bcag
  extends aokf
{
  bcag(bcaf parambcaf) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    paramString2 = (QQAppInterface)bcaf.a(this.a).get();
    if (QLog.isColorLevel()) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    try
    {
      if (bcaf.a(this.a) != null)
      {
        bcaf.a(this.a).dismiss();
        bcaf.a(this.a);
      }
      if ((!ActiveEntitySearchFragment.a(bcaf.a(this.a), paramArrayOfLong)) || (!paramString1.equals(bcaf.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  reqKeyword=" + paramString1 + " keyword=" + bcaf.a(this.a));
        return;
      }
    }
    catch (RuntimeException paramString3)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramString3, new Object[0]);
      }
      QQToast.a(BaseApplicationImpl.context, 0, 2131719078, 0).a();
      bdll.b(paramString2, "dc00898", "", "", "0X800B0C0", "0X800B0C0", bcaf.a(bcaf.a(this.a)), 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<bcfq> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    if (!TextUtils.equals(paramString2, bcaf.b(this.a))) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + bcaf.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + bcaf.b(this.a) + " isEnd1=" + paramBoolean2);
    }
    label802:
    label840:
    label871:
    label1015:
    do
    {
      return;
      paramString3 = (Context)bcaf.b(this.a).get();
      paramList1 = (QQAppInterface)bcaf.a(this.a).get();
      try
      {
        if (bcaf.a(this.a) != null)
        {
          bcaf.a(this.a).dismiss();
          bcaf.a(this.a);
        }
        if ((paramString3 == null) || (paramList1 == null))
        {
          QLog.e("UinSearcher", 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + bcaf.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + bcaf.b(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
        }
        if ((!ActiveEntitySearchFragment.a(bcaf.a(this.a), paramArrayOfLong)) || (!paramString1.equals(bcaf.a(this.a))))
        {
          QLog.d("UinSearcher", 2, "Unify handleTabSearchResult.  reqKeyword=" + paramString1 + " keyword=" + bcaf.a(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
        paramArrayOfLong = new bcep[1];
        paramString4 = new bcep[1];
        bcep[] arrayOfbcep = new bcep[1];
        bcaf.a(this.a, 4);
        blir localblir = blir.a(paramString3);
        bcah localbcah = new bcah(this, paramString3, paramString1, paramList1, paramArrayOfLong, paramString4, arrayOfbcep, localblir);
        bcai localbcai = new bcai(this, paramList1);
        paramString2 = (anyw)paramList1.getManager(51);
        if (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("UinSearcher", 2, "Unify handleTabSearchResult result is null");
          }
          localblir.a(String.format(paramString3.getString(2131694070), new Object[] { bcaf.a(this.a) }));
          localblir.a(2131691140, 1, 2131362330);
          localblir.a(2131691990, 1, 2131362331);
          localblir.a(2131691440, 1, 2131362329);
          localblir.a(2131689606, 1, 2131362327);
          if ((!bcaf.a(this.a).isSend()) && (!bcaf.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(bcaf.a(this.a).senderuin))) {
            localblir.a(2131689615, 1, 2131362328);
          }
          localblir.c(2131690580);
          localblir.a(localbcah);
          localblir.a(localbcai);
          localblir.show();
          bdll.b(paramList1, "dc00898", "", "", "0X800A923", "0X800A923", bcaf.a(paramList1, bcaf.a(this.a), bcaf.d(this.a)), 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = bbzx.a(paramList, paramBoolean1, false).iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramList = (bcfp)paramArrayOfByte.next();
          if ((paramList instanceof bcep)) {
            if (((bcep)paramList).d() == 1001) {
              paramArrayOfLong[0] = ((bcep)paramList);
            } else if (((bcep)paramList).d() == 1002) {
              paramString4[0] = ((bcep)paramList);
            } else if (((bcep)paramList).d() == 8001) {
              arrayOfbcep[0] = ((bcep)paramList);
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
          bcaf.a(paramArrayOfByte, paramInt);
          paramInt = 2131694070;
          if (paramString4[0] == null) {
            break label1383;
          }
          if (paramArrayOfLong[0] != null) {
            break label1375;
          }
          paramInt = 2131719015;
          localblir.a(String.format(paramString3.getString(paramInt), new Object[] { paramString1 }));
          localblir.a(2131691140, 1, 2131362330);
          localblir.a(2131691990, 1, 2131362331);
          localblir.a(2131691440, 1, 2131362329);
          localblir.a(2131689606, 1, 2131362327);
          if ((arrayOfbcep[0] != null) && (!TextUtils.isEmpty(arrayOfbcep[0].m)))
          {
            if (!TextUtils.isEmpty(arrayOfbcep[0].l)) {
              break label1398;
            }
            localblir.a(paramString3.getString(2131694285) + "\n" + arrayOfbcep[0].m, 65537, 2131362335);
          }
          if ((!bcaf.a(this.a).isSend()) && (!bcaf.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(bcaf.a(this.a).senderuin))) {
            localblir.a(2131689615, 1, 2131362328);
          }
          paramList = (arpc)aran.a().a(589);
          if (paramArrayOfLong[0] != null)
          {
            if (paramString2.b(paramString1)) {
              break label1477;
            }
            if ((TextUtils.isEmpty(paramArrayOfLong[0].c)) || (!paramList.a())) {
              break label1462;
            }
            localblir.a(paramString3.getString(2131689571) + "\n" + paramArrayOfLong[0].c, 65537, 2131362326);
          }
          if (paramString4[0] != null)
          {
            if (TroopInfo.isTroopMember(paramList1, paramString1)) {
              break label1597;
            }
            if ((TextUtils.isEmpty(paramString4[0].c)) || (!paramList.a())) {
              break label1582;
            }
            localblir.a(paramString3.getString(2131693158) + "\n" + paramString4[0].c, 65537, 2131362332);
          }
        }
        for (;;)
        {
          localblir.c(2131690580);
          localblir.a(localbcah);
          localblir.a(localbcai);
          try
          {
            if ((!(paramString3 instanceof Activity)) || (((Activity)paramString3).isFinishing())) {
              break label1684;
            }
            ThreadManagerV2.getUIHandlerV2().post(new UinSearcher.1.3(this, localblir, paramArrayOfLong, paramString4, paramList, paramList1, arrayOfbcep));
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
          paramInt = 2131694069;
          break label871;
          if (paramArrayOfLong[0] == null) {
            break label871;
          }
          paramInt = 2131694069;
          break label871;
          localblir.a(paramString3.getString(2131694285) + "\n" + arrayOfbcep[0].m, 65537, 2131362335, Integer.valueOf(Color.parseColor(arrayOfbcep[0].l)));
          break label1015;
          localblir.a(2131689571, 1, 2131362326);
          break label1174;
          paramString2 = null;
          if (paramList.a())
          {
            paramArrayOfByte = bhlg.b(paramList1, paramString1, false);
            paramString2 = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              paramString2 = paramArrayOfLong[0].c;
            }
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            localblir.a(paramString3.getString(2131694151) + "\n" + paramString2, 65537, 2131362333);
            break label1174;
          }
          localblir.a(2131694151, 1, 2131362333);
          break label1174;
          localblir.a(2131693158, 1, 2131362332);
          continue;
          if ((!TextUtils.isEmpty(paramString4[0].c)) && (paramList.a())) {
            localblir.a(paramString3.getString(2131694169) + "\n" + paramString4[0].c, 65537, 2131362334);
          } else {
            localblir.a(2131694169, 1, 2131362334);
          }
        }
      }
    } while (bcaf.a(this.a) == null);
    label1174:
    label1345:
    label1350:
    label1356:
    label1375:
    label1383:
    label1398:
    bcaf.a(this.a).dismiss();
    label1462:
    label1477:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcag
 * JD-Core Version:    0.7.0.1
 */