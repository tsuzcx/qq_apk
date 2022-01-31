import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.List;

public class bcor
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, List<String> paramList, long paramLong)
  {
    long l = LocalMultiProcConfig.getLong4Uin("aio_qzone_troop_gray_tips", 0L, Long.parseLong(paramString2));
    if (System.currentTimeMillis() <= l * 1000L) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGrayTipUtils", 2, "Unable to display gray tips during cool down");
      }
    }
    do
    {
      return;
      i = QzoneConfig.getInstance().getConfig("aio_qzone_troop_gray_tips", "troop_gray_tips_min_photo_count", 9);
      if (paramList.size() >= i) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopGrayTipUtils", 2, "Unable to display gray tips, current photos count: " + paramList.size() + " required min photos count: " + i);
    return;
    Object localObject = alud.a(2131721054);
    String str2 = alud.a(2131721052);
    String str1 = alud.a(2131721053);
    str2 = (String)localObject + " " + str2 + " " + str1;
    paramString1 = new aspy(paramString1, paramString2, str2, 1, -5040, 131086, System.currentTimeMillis() / 1000L);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramList.size())
    {
      if (i != paramList.size() - 1) {
        localStringBuilder.append((String)paramList.get(i)).append(",");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append((String)paramList.get(i));
      }
    }
    paramList = new ArrayList();
    i = BaseApplicationImpl.getApplication().getResources().getColor(2131167167);
    localObject = new MessageForGrayTips.HightlightItem(0, ((String)localObject).length(), Long.parseLong(paramString2), 0, 50, localStringBuilder.toString(), "", "", "", i);
    paramString2 = new MessageForGrayTips.HightlightItem(str2.length() - str1.length(), str2.length(), Long.parseLong(paramString2), 0, 51, "", "", "", "", i);
    paramList.add(localObject);
    paramList.add(paramString2);
    paramString1.a = paramList;
    paramString2 = new MessageForUniteGrayTip();
    paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
    paramString2.saveExtInfoToExtStr("grayLastUniseq", paramLong + "");
    aspz.a(paramQQAppInterface, paramString2);
    LpReportInfo_pf00064.allReport(40, 3, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcor
 * JD-Core Version:    0.7.0.1
 */