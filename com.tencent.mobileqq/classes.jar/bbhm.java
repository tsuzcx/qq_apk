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

public class bbhm
  extends anxt
{
  bbhm(bbhl parambbhl) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    paramString2 = (QQAppInterface)bbhl.a(this.a).get();
    if (QLog.isColorLevel()) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    try
    {
      if (bbhl.a(this.a) != null)
      {
        bbhl.a(this.a).dismiss();
        bbhl.a(this.a);
      }
      if ((!ActiveEntitySearchFragment.a(bbhl.a(this.a), paramArrayOfLong)) || (!paramString1.equals(bbhl.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  reqKeyword=" + paramString1 + " keyword=" + bbhl.a(this.a));
        return;
      }
    }
    catch (RuntimeException paramString3)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramString3, new Object[0]);
      }
      QQToast.a(BaseApplicationImpl.context, 0, 2131718928, 0).a();
      bcst.b(paramString2, "dc00898", "", "", "0X800B0C0", "0X800B0C0", bbhl.a(bbhl.a(this.a)), 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<bbmx> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    if (!TextUtils.equals(paramString2, bbhl.b(this.a))) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + bbhl.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + bbhl.b(this.a) + " isEnd1=" + paramBoolean2);
    }
    label802:
    label840:
    label871:
    label1015:
    do
    {
      return;
      paramString3 = (Context)bbhl.b(this.a).get();
      paramList1 = (QQAppInterface)bbhl.a(this.a).get();
      try
      {
        if (bbhl.a(this.a) != null)
        {
          bbhl.a(this.a).dismiss();
          bbhl.a(this.a);
        }
        if ((paramString3 == null) || (paramList1 == null))
        {
          QLog.e("UinSearcher", 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + bbhl.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + bbhl.b(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
        }
        if ((!ActiveEntitySearchFragment.a(bbhl.a(this.a), paramArrayOfLong)) || (!paramString1.equals(bbhl.a(this.a))))
        {
          QLog.d("UinSearcher", 2, "Unify handleTabSearchResult.  reqKeyword=" + paramString1 + " keyword=" + bbhl.a(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
        paramArrayOfLong = new bblw[1];
        paramString4 = new bblw[1];
        bblw[] arrayOfbblw = new bblw[1];
        bbhl.a(this.a, 4);
        bkho localbkho = bkho.a(paramString3);
        bbhn localbbhn = new bbhn(this, paramString3, paramString1, paramList1, paramArrayOfLong, paramString4, arrayOfbblw, localbkho);
        bbho localbbho = new bbho(this, paramList1);
        paramString2 = (anmw)paramList1.getManager(51);
        if (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("UinSearcher", 2, "Unify handleTabSearchResult result is null");
          }
          localbkho.a(String.format(paramString3.getString(2131694053), new Object[] { bbhl.a(this.a) }));
          localbkho.a(2131691140, 1, 2131362318);
          localbkho.a(2131691986, 1, 2131362319);
          localbkho.a(2131691437, 1, 2131362317);
          localbkho.a(2131689604, 1, 2131362315);
          if ((!bbhl.a(this.a).isSend()) && (!bbhl.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(bbhl.a(this.a).senderuin))) {
            localbkho.a(2131689613, 1, 2131362316);
          }
          localbkho.c(2131690582);
          localbkho.a(localbbhn);
          localbkho.a(localbbho);
          localbkho.show();
          bcst.b(paramList1, "dc00898", "", "", "0X800A923", "0X800A923", bbhl.a(paramList1, bbhl.a(this.a), bbhl.d(this.a)), 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = bbhd.a(paramList, paramBoolean1, false).iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramList = (bbmw)paramArrayOfByte.next();
          if ((paramList instanceof bblw)) {
            if (((bblw)paramList).d() == 1001) {
              paramArrayOfLong[0] = ((bblw)paramList);
            } else if (((bblw)paramList).d() == 1002) {
              paramString4[0] = ((bblw)paramList);
            } else if (((bblw)paramList).d() == 8001) {
              arrayOfbblw[0] = ((bblw)paramList);
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
          bbhl.a(paramArrayOfByte, paramInt);
          paramInt = 2131694053;
          if (paramString4[0] == null) {
            break label1383;
          }
          if (paramArrayOfLong[0] != null) {
            break label1375;
          }
          paramInt = 2131718865;
          localbkho.a(String.format(paramString3.getString(paramInt), new Object[] { paramString1 }));
          localbkho.a(2131691140, 1, 2131362318);
          localbkho.a(2131691986, 1, 2131362319);
          localbkho.a(2131691437, 1, 2131362317);
          localbkho.a(2131689604, 1, 2131362315);
          if ((arrayOfbblw[0] != null) && (!TextUtils.isEmpty(arrayOfbblw[0].m)))
          {
            if (!TextUtils.isEmpty(arrayOfbblw[0].l)) {
              break label1398;
            }
            localbkho.a(paramString3.getString(2131694247) + "\n" + arrayOfbblw[0].m, 65537, 2131362323);
          }
          if ((!bbhl.a(this.a).isSend()) && (!bbhl.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(bbhl.a(this.a).senderuin))) {
            localbkho.a(2131689613, 1, 2131362316);
          }
          paramList = (aqzl)aqlk.a().a(589);
          if (paramArrayOfLong[0] != null)
          {
            if (paramString2.b(paramString1)) {
              break label1477;
            }
            if ((TextUtils.isEmpty(paramArrayOfLong[0].c)) || (!paramList.a())) {
              break label1462;
            }
            localbkho.a(paramString3.getString(2131689569) + "\n" + paramArrayOfLong[0].c, 65537, 2131362314);
          }
          if (paramString4[0] != null)
          {
            if (TroopInfo.isTroopMember(paramList1, paramString1)) {
              break label1597;
            }
            if ((TextUtils.isEmpty(paramString4[0].c)) || (!paramList.a())) {
              break label1582;
            }
            localbkho.a(paramString3.getString(2131693149) + "\n" + paramString4[0].c, 65537, 2131362320);
          }
        }
        for (;;)
        {
          localbkho.c(2131690582);
          localbkho.a(localbbhn);
          localbkho.a(localbbho);
          try
          {
            if ((!(paramString3 instanceof Activity)) || (((Activity)paramString3).isFinishing())) {
              break label1684;
            }
            ThreadManagerV2.getUIHandlerV2().post(new UinSearcher.1.3(this, localbkho, paramArrayOfLong, paramString4, paramList, paramList1, arrayOfbblw));
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
          paramInt = 2131694052;
          break label871;
          if (paramArrayOfLong[0] == null) {
            break label871;
          }
          paramInt = 2131694052;
          break label871;
          localbkho.a(paramString3.getString(2131694247) + "\n" + arrayOfbblw[0].m, 65537, 2131362323, Integer.valueOf(Color.parseColor(arrayOfbblw[0].l)));
          break label1015;
          localbkho.a(2131689569, 1, 2131362314);
          break label1174;
          paramString2 = null;
          if (paramList.a())
          {
            paramArrayOfByte = bglf.b(paramList1, paramString1, false);
            paramString2 = paramArrayOfByte;
            if (TextUtils.isEmpty(paramArrayOfByte)) {
              paramString2 = paramArrayOfLong[0].c;
            }
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            localbkho.a(paramString3.getString(2131694133) + "\n" + paramString2, 65537, 2131362321);
            break label1174;
          }
          localbkho.a(2131694133, 1, 2131362321);
          break label1174;
          localbkho.a(2131693149, 1, 2131362320);
          continue;
          if ((!TextUtils.isEmpty(paramString4[0].c)) && (paramList.a())) {
            localbkho.a(paramString3.getString(2131694151) + "\n" + paramString4[0].c, 65537, 2131362322);
          } else {
            localbkho.a(2131694151, 1, 2131362322);
          }
        }
      }
    } while (bbhl.a(this.a) == null);
    label1174:
    label1345:
    label1350:
    label1356:
    label1375:
    label1383:
    label1398:
    bbhl.a(this.a).dismiss();
    label1462:
    label1477:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhm
 * JD-Core Version:    0.7.0.1
 */