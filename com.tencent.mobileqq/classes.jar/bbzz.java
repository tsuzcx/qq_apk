import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class bbzz
  extends aogh
{
  bbzz(bbzy parambbzy) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    paramString2 = (QQAppInterface)bbzy.a(this.a).get();
    if (QLog.isColorLevel()) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    try
    {
      if (bbzy.a(this.a) != null)
      {
        bbzy.a(this.a).dismiss();
        bbzy.a(this.a);
      }
      if ((!ActiveEntitySearchFragment.a(bbzy.a(this.a), paramArrayOfLong)) || (!paramString1.equals(bbzy.a(this.a))))
      {
        QLog.d("UinSearcher", 2, "Unify handleTabSearchError.  reqKeyword=" + paramString1 + " keyword=" + bbzy.a(this.a));
        return;
      }
    }
    catch (RuntimeException paramString3)
    {
      for (;;)
      {
        QLog.e("UinSearcher", 1, paramString3, new Object[0]);
      }
      QQToast.a(BaseApplicationImpl.context, 0, 2131719786, 0).a();
      bdla.b(paramString2, "dc00898", "", "", "0X800B0C0", "0X800B0C0", bbzy.a(bbzy.a(this.a)), 0, "", "", "", "");
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<bcfi> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    if (!TextUtils.equals(paramString2, bbzy.b(this.a))) {
      QLog.d("UinSearcher", 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + bbzy.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + bbzy.b(this.a) + " isEnd1=" + paramBoolean2);
    }
    label803:
    label841:
    label872:
    label1016:
    do
    {
      return;
      paramString3 = (Context)bbzy.b(this.a).get();
      paramList1 = (QQAppInterface)bbzy.a(this.a).get();
      try
      {
        if (bbzy.a(this.a) != null)
        {
          bbzy.a(this.a).dismiss();
          bbzy.a(this.a);
        }
        if ((paramString3 == null) || (paramList1 == null))
        {
          QLog.e("UinSearcher", 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + bbzy.a(this.a) + " reqTime=" + paramString2 + " lastReqTime=" + bbzy.b(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
      }
      catch (RuntimeException paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e("UinSearcher", 1, paramArrayOfByte, new Object[0]);
        }
        if ((!ActiveEntitySearchFragment.a(bbzy.a(this.a), paramArrayOfLong)) || (!paramString1.equals(bbzy.a(this.a))))
        {
          QLog.d("UinSearcher", 2, "Unify handleTabSearchResult.  reqKeyword=" + paramString1 + " keyword=" + bbzy.a(this.a) + " isEnd1=" + paramBoolean2);
          return;
        }
        paramArrayOfLong = new bceh[1];
        paramString4 = new bceh[1];
        bceh[] arrayOfbceh = new bceh[1];
        bbzy.a(this.a, 4);
        bkzi localbkzi = bkzi.a(paramString3);
        bcaa localbcaa = new bcaa(this, paramString3, paramString1, paramList1, paramArrayOfLong, paramString4, arrayOfbceh, localbkzi);
        bcab localbcab = new bcab(this, paramList1);
        paramString2 = (anvk)paramList1.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("UinSearcher", 2, "Unify handleTabSearchResult result is null");
          }
          localbkzi.a(String.format(paramString3.getString(2131694370), new Object[] { bbzy.a(this.a) }));
          localbkzi.a(2131691264, 1, 2131362338);
          localbkzi.a(2131692126, 1, 2131362339);
          localbkzi.a(2131691565, 1, 2131362337);
          localbkzi.a(2131689605, 1, 2131362335);
          if ((!bbzy.a(this.a).isSend()) && (!bbzy.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(bbzy.a(this.a).senderuin))) {
            localbkzi.a(2131689614, 1, 2131362336);
          }
          localbkzi.c(2131690697);
          localbkzi.a(localbcaa);
          localbkzi.a(localbcab);
          localbkzi.show();
          bdla.b(paramList1, "dc00898", "", "", "0X800A923", "0X800A923", bbzy.a(paramList1, bbzy.a(this.a), bbzy.d(this.a)), 0, "", "", "", "");
          return;
        }
        paramArrayOfByte = bbzq.a(paramList, paramBoolean1, false).iterator();
        while (paramArrayOfByte.hasNext())
        {
          paramList = (bcfh)paramArrayOfByte.next();
          if ((paramList instanceof bceh)) {
            if (((bceh)paramList).d() == 1001) {
              paramArrayOfLong[0] = ((bceh)paramList);
            } else if (((bceh)paramList).d() == 1002) {
              paramString4[0] = ((bceh)paramList);
            } else if (((bceh)paramList).d() == 8001) {
              arrayOfbceh[0] = ((bceh)paramList);
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
              break label1346;
            }
            paramBoolean1 = true;
            QLog.d("UinSearcher", 2, paramBoolean1);
          }
        }
        else
        {
          paramArrayOfByte = this.a;
          if (paramArrayOfLong[0] != null) {
            break label1357;
          }
          if (paramString4[0] != null) {
            break label1351;
          }
          paramInt = 4;
          bbzy.a(paramArrayOfByte, paramInt);
          paramInt = 2131694370;
          if (paramString4[0] == null) {
            break label1384;
          }
          if (paramArrayOfLong[0] != null) {
            break label1376;
          }
          paramInt = 2131719712;
          localbkzi.a(String.format(paramString3.getString(paramInt), new Object[] { paramString1 }));
          localbkzi.a(2131691264, 1, 2131362338);
          localbkzi.a(2131692126, 1, 2131362339);
          localbkzi.a(2131691565, 1, 2131362337);
          localbkzi.a(2131689605, 1, 2131362335);
          if ((arrayOfbceh[0] != null) && (!TextUtils.isEmpty(arrayOfbceh[0].n)))
          {
            if (!TextUtils.isEmpty(arrayOfbceh[0].m)) {
              break label1399;
            }
            localbkzi.a(paramString3.getString(2131694600) + "\n" + arrayOfbceh[0].n, 65537, 2131362343);
          }
          if ((!bbzy.a(this.a).isSend()) && (!bbzy.a(this.a).senderuin.equals(paramList1.getCurrentAccountUin())) && (paramString2.b(bbzy.a(this.a).senderuin))) {
            localbkzi.a(2131689614, 1, 2131362336);
          }
          paramList = (arml)aqxe.a().a(589);
          if (paramArrayOfLong[0] != null)
          {
            if (paramString2.b(paramString1)) {
              break label1478;
            }
            if ((TextUtils.isEmpty(paramArrayOfLong[0].c)) || (!paramList.a())) {
              break label1463;
            }
            localbkzi.a(paramString3.getString(2131689570) + "\n" + paramArrayOfLong[0].c, 65537, 2131362334);
          }
          if (paramString4[0] != null)
          {
            if (TroopInfo.isTroopMember(paramList1, paramString1)) {
              break label1598;
            }
            if ((TextUtils.isEmpty(paramString4[0].c)) || (!paramList.a())) {
              break label1583;
            }
            localbkzi.a(paramString3.getString(2131693401) + "\n" + paramString4[0].c, 65537, 2131362340);
          }
        }
        for (;;)
        {
          localbkzi.c(2131690697);
          localbkzi.a(localbcaa);
          localbkzi.a(localbcab);
          try
          {
            if ((!(paramString3 instanceof Activity)) || (((Activity)paramString3).isFinishing())) {
              break label1685;
            }
            ThreadManagerV2.getUIHandlerV2().post(new UinSearcher.1.3(this, localbkzi, paramArrayOfLong, paramString4, paramList, paramList1, arrayOfbceh));
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
          break label803;
          paramInt = 2;
          break label841;
          if (paramString4[0] == null)
          {
            paramInt = 1;
            break label841;
          }
          paramInt = 3;
          break label841;
          paramInt = 2131694369;
          break label872;
          if (paramArrayOfLong[0] == null) {
            break label872;
          }
          paramInt = 2131694369;
          break label872;
          localbkzi.a(paramString3.getString(2131694600) + "\n" + arrayOfbceh[0].n, 65537, 2131362343, Integer.valueOf(Color.parseColor(arrayOfbceh[0].m)));
          break label1016;
          localbkzi.a(2131689570, 1, 2131362334);
          break label1175;
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
            localbkzi.a(paramString3.getString(2131694452) + "\n" + paramString2, 65537, 2131362341);
            break label1175;
          }
          localbkzi.a(2131694452, 1, 2131362341);
          break label1175;
          localbkzi.a(2131693401, 1, 2131362340);
          continue;
          if ((!TextUtils.isEmpty(paramString4[0].c)) && (paramList.a())) {
            localbkzi.a(paramString3.getString(2131694470) + "\n" + paramString4[0].c, 65537, 2131362342);
          } else {
            localbkzi.a(2131694470, 1, 2131362342);
          }
        }
      }
    } while (bbzy.a(this.a) == null);
    label1175:
    label1346:
    label1351:
    label1357:
    label1376:
    label1384:
    label1399:
    bbzy.a(this.a).dismiss();
    label1463:
    label1478:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzz
 * JD-Core Version:    0.7.0.1
 */