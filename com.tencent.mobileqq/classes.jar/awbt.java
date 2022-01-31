import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbt
  extends awch
{
  public awbt()
  {
    this.a = 55;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawbv = (EmoticonPackage)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramawbv.wordingId = paramCursor.getLong(paramCursor.getColumnIndex("wordingId"));
      paramawbv.childEpId = paramCursor.getString(paramCursor.getColumnIndex("childEpId"));
      paramawbv.minQQVersion = paramCursor.getString(paramCursor.getColumnIndex("minQQVersion"));
      paramawbv.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawbv.mark = paramCursor.getString(paramCursor.getColumnIndex("mark"));
      paramawbv.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramawbv.author = paramCursor.getString(paramCursor.getColumnIndex("author"));
      paramawbv.expiretime = paramCursor.getLong(paramCursor.getColumnIndex("expiretime"));
      paramawbv.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasSound")))
      {
        paramBoolean = true;
        paramawbv.hasSound = paramBoolean;
        paramawbv.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramawbv.kinId = paramCursor.getString(paramCursor.getColumnIndex("kinId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("valid"))) {
          break label1078;
        }
        paramBoolean = true;
        label277:
        paramawbv.valid = paramBoolean;
        paramawbv.downloadCount = paramCursor.getInt(paramCursor.getColumnIndex("downloadCount"));
        paramawbv.mobileFeetype = paramCursor.getInt(paramCursor.getColumnIndex("mobileFeetype"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecommendation"))) {
          break label1083;
        }
        paramBoolean = true;
        label338:
        paramawbv.isRecommendation = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isMagicFaceDownloading"))) {
          break label1088;
        }
        paramBoolean = true;
        label363:
        paramawbv.isMagicFaceDownloading = paramBoolean;
        paramawbv.firstEmotionId = paramCursor.getString(paramCursor.getColumnIndex("firstEmotionId"));
        paramawbv.upperLeftLable = paramCursor.getInt(paramCursor.getColumnIndex("upperLeftLable"));
        paramawbv.localVersion = paramCursor.getInt(paramCursor.getColumnIndex("localVersion"));
        paramawbv.latestVersion = paramCursor.getInt(paramCursor.getColumnIndex("latestVersion"));
        paramawbv.jsonVersion = paramCursor.getInt(paramCursor.getColumnIndex("jsonVersion"));
        paramawbv.updateFlag = paramCursor.getInt(paramCursor.getColumnIndex("updateFlag"));
        paramawbv.updateTip = paramCursor.getString(paramCursor.getColumnIndex("updateTip"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasReadUpdatePage"))) {
          break label1093;
        }
        paramBoolean = true;
        label514:
        paramawbv.hasReadUpdatePage = paramBoolean;
        paramawbv.rscType = paramCursor.getInt(paramCursor.getColumnIndex("rscType"));
        paramawbv.supportSize = paramCursor.getString(paramCursor.getColumnIndex("supportSize"));
        paramawbv.extraFlags = paramCursor.getInt(paramCursor.getColumnIndex("extraFlags"));
        paramawbv.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        paramawbv.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramawbv.isAPNG = paramCursor.getInt(paramCursor.getColumnIndex("isAPNG"));
        paramawbv.copywritingType = paramCursor.getInt(paramCursor.getColumnIndex("copywritingType"));
        paramawbv.diversionName = paramCursor.getString(paramCursor.getColumnIndex("diversionName"));
        paramawbv.copywritingContent = paramCursor.getString(paramCursor.getColumnIndex("copywritingContent"));
        paramawbv.jumpUrl = paramCursor.getString(paramCursor.getColumnIndex("jumpUrl"));
        paramawbv.imageUrl = paramCursor.getString(paramCursor.getColumnIndex("imageUrl"));
        paramawbv.beginTime = paramCursor.getLong(paramCursor.getColumnIndex("beginTime"));
        paramawbv.endTime = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
        paramawbv.buttonWording = paramCursor.getString(paramCursor.getColumnIndex("buttonWording"));
        paramawbv.comeFom = paramCursor.getString(paramCursor.getColumnIndex("comeFom"));
        paramawbv.ipUrl = paramCursor.getString(paramCursor.getColumnIndex("ipUrl"));
        paramawbv.ipName = paramCursor.getString(paramCursor.getColumnIndex("ipName"));
        paramawbv.ipDetail = paramCursor.getString(paramCursor.getColumnIndex("ipDetail"));
        paramawbv.ipOpName = paramCursor.getString(paramCursor.getColumnIndex("ipOpName"));
        paramawbv.ipJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("ipJumpUrl"));
        paramawbv.ipReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipReqTime"));
        paramawbv.ipLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("aio"))) {
          break label1098;
        }
        paramBoolean = true;
        label935:
        paramawbv.aio = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandian"))) {
          break label1103;
        }
        paramBoolean = true;
        label960:
        paramawbv.kandian = paramBoolean;
        paramawbv.richIPReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPReqTime"));
        paramawbv.richIPLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasIpProduct"))) {
          break label1108;
        }
        paramBoolean = true;
        label1021:
        paramawbv.hasIpProduct = paramBoolean;
        paramawbv.ipSiteInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("ipSiteInfoBytes"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("newSoundEp"))) {
          break label1113;
        }
      }
      label1078:
      label1083:
      label1088:
      label1093:
      label1098:
      label1103:
      label1108:
      label1113:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramawbv.newSoundEp = paramBoolean;
        return paramawbv;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label277;
        paramBoolean = false;
        break label338;
        paramBoolean = false;
        break label363;
        paramBoolean = false;
        break label514;
        paramBoolean = false;
        break label935;
        paramBoolean = false;
        break label960;
        paramBoolean = false;
        break label1021;
      }
    }
    int i = paramCursor.getColumnIndex("epId");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("epId", String.class));
      i = paramCursor.getColumnIndex("wordingId");
      if (i != -1) {
        break label3062;
      }
      paramawcg.a(new NoColumnError("wordingId", Long.TYPE));
      label1188:
      i = paramCursor.getColumnIndex("childEpId");
      if (i != -1) {
        break label3077;
      }
      paramawcg.a(new NoColumnError("childEpId", String.class));
      label1223:
      i = paramCursor.getColumnIndex("minQQVersion");
      if (i != -1) {
        break label3092;
      }
      paramawcg.a(new NoColumnError("minQQVersion", String.class));
      label1258:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3107;
      }
      paramawcg.a(new NoColumnError("name", String.class));
      label1293:
      i = paramCursor.getColumnIndex("mark");
      if (i != -1) {
        break label3122;
      }
      paramawcg.a(new NoColumnError("mark", String.class));
      label1328:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label3137;
      }
      paramawcg.a(new NoColumnError("type", Integer.TYPE));
      label1363:
      i = paramCursor.getColumnIndex("author");
      if (i != -1) {
        break label3152;
      }
      paramawcg.a(new NoColumnError("author", String.class));
      label1398:
      i = paramCursor.getColumnIndex("expiretime");
      if (i != -1) {
        break label3167;
      }
      paramawcg.a(new NoColumnError("expiretime", Long.TYPE));
      label1433:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3182;
      }
      paramawcg.a(new NoColumnError("status", Integer.TYPE));
      label1468:
      i = paramCursor.getColumnIndex("hasSound");
      if (i != -1) {
        break label3197;
      }
      paramawcg.a(new NoColumnError("hasSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label3224;
      }
      paramawcg.a(new NoColumnError("jobType", Integer.TYPE));
      label1538:
      i = paramCursor.getColumnIndex("kinId");
      if (i != -1) {
        break label3239;
      }
      paramawcg.a(new NoColumnError("kinId", String.class));
      label1573:
      i = paramCursor.getColumnIndex("valid");
      if (i != -1) {
        break label3254;
      }
      paramawcg.a(new NoColumnError("valid", Boolean.TYPE));
      i = paramCursor.getColumnIndex("downloadCount");
      if (i != -1) {
        break label3281;
      }
      paramawcg.a(new NoColumnError("downloadCount", Integer.TYPE));
      label1643:
      i = paramCursor.getColumnIndex("mobileFeetype");
      if (i != -1) {
        break label3296;
      }
      paramawcg.a(new NoColumnError("mobileFeetype", Integer.TYPE));
      label1678:
      i = paramCursor.getColumnIndex("isRecommendation");
      if (i != -1) {
        break label3311;
      }
      paramawcg.a(new NoColumnError("isRecommendation", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isMagicFaceDownloading");
      if (i != -1) {
        break label3338;
      }
      paramawcg.a(new NoColumnError("isMagicFaceDownloading", Boolean.TYPE));
      i = paramCursor.getColumnIndex("firstEmotionId");
      if (i != -1) {
        break label3365;
      }
      paramawcg.a(new NoColumnError("firstEmotionId", String.class));
      label1783:
      i = paramCursor.getColumnIndex("upperLeftLable");
      if (i != -1) {
        break label3380;
      }
      paramawcg.a(new NoColumnError("upperLeftLable", Integer.TYPE));
      label1818:
      i = paramCursor.getColumnIndex("localVersion");
      if (i != -1) {
        break label3395;
      }
      paramawcg.a(new NoColumnError("localVersion", Integer.TYPE));
      label1853:
      i = paramCursor.getColumnIndex("latestVersion");
      if (i != -1) {
        break label3410;
      }
      paramawcg.a(new NoColumnError("latestVersion", Integer.TYPE));
      label1888:
      i = paramCursor.getColumnIndex("jsonVersion");
      if (i != -1) {
        break label3425;
      }
      paramawcg.a(new NoColumnError("jsonVersion", Integer.TYPE));
      label1923:
      i = paramCursor.getColumnIndex("updateFlag");
      if (i != -1) {
        break label3440;
      }
      paramawcg.a(new NoColumnError("updateFlag", Integer.TYPE));
      label1958:
      i = paramCursor.getColumnIndex("updateTip");
      if (i != -1) {
        break label3455;
      }
      paramawcg.a(new NoColumnError("updateTip", String.class));
      label1993:
      i = paramCursor.getColumnIndex("hasReadUpdatePage");
      if (i != -1) {
        break label3470;
      }
      paramawcg.a(new NoColumnError("hasReadUpdatePage", Boolean.TYPE));
      i = paramCursor.getColumnIndex("rscType");
      if (i != -1) {
        break label3497;
      }
      paramawcg.a(new NoColumnError("rscType", Integer.TYPE));
      label2063:
      i = paramCursor.getColumnIndex("supportSize");
      if (i != -1) {
        break label3512;
      }
      paramawcg.a(new NoColumnError("supportSize", String.class));
      label2098:
      i = paramCursor.getColumnIndex("extraFlags");
      if (i != -1) {
        break label3527;
      }
      paramawcg.a(new NoColumnError("extraFlags", Integer.TYPE));
      label2133:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label3542;
      }
      paramawcg.a(new NoColumnError("businessExtra", String.class));
      label2168:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label3557;
      }
      paramawcg.a(new NoColumnError("subType", Integer.TYPE));
      label2203:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label3572;
      }
      paramawcg.a(new NoColumnError("isAPNG", Integer.TYPE));
      label2238:
      i = paramCursor.getColumnIndex("copywritingType");
      if (i != -1) {
        break label3587;
      }
      paramawcg.a(new NoColumnError("copywritingType", Integer.TYPE));
      label2273:
      i = paramCursor.getColumnIndex("diversionName");
      if (i != -1) {
        break label3602;
      }
      paramawcg.a(new NoColumnError("diversionName", String.class));
      label2308:
      i = paramCursor.getColumnIndex("copywritingContent");
      if (i != -1) {
        break label3617;
      }
      paramawcg.a(new NoColumnError("copywritingContent", String.class));
      label2343:
      i = paramCursor.getColumnIndex("jumpUrl");
      if (i != -1) {
        break label3632;
      }
      paramawcg.a(new NoColumnError("jumpUrl", String.class));
      label2378:
      i = paramCursor.getColumnIndex("imageUrl");
      if (i != -1) {
        break label3647;
      }
      paramawcg.a(new NoColumnError("imageUrl", String.class));
      label2413:
      i = paramCursor.getColumnIndex("beginTime");
      if (i != -1) {
        break label3662;
      }
      paramawcg.a(new NoColumnError("beginTime", Long.TYPE));
      label2448:
      i = paramCursor.getColumnIndex("endTime");
      if (i != -1) {
        break label3677;
      }
      paramawcg.a(new NoColumnError("endTime", Long.TYPE));
      label2483:
      i = paramCursor.getColumnIndex("buttonWording");
      if (i != -1) {
        break label3692;
      }
      paramawcg.a(new NoColumnError("buttonWording", String.class));
      label2518:
      i = paramCursor.getColumnIndex("comeFom");
      if (i != -1) {
        break label3707;
      }
      paramawcg.a(new NoColumnError("comeFom", String.class));
      label2553:
      i = paramCursor.getColumnIndex("ipUrl");
      if (i != -1) {
        break label3722;
      }
      paramawcg.a(new NoColumnError("ipUrl", String.class));
      label2588:
      i = paramCursor.getColumnIndex("ipName");
      if (i != -1) {
        break label3737;
      }
      paramawcg.a(new NoColumnError("ipName", String.class));
      label2623:
      i = paramCursor.getColumnIndex("ipDetail");
      if (i != -1) {
        break label3752;
      }
      paramawcg.a(new NoColumnError("ipDetail", String.class));
      label2658:
      i = paramCursor.getColumnIndex("ipOpName");
      if (i != -1) {
        break label3767;
      }
      paramawcg.a(new NoColumnError("ipOpName", String.class));
      label2693:
      i = paramCursor.getColumnIndex("ipJumpUrl");
      if (i != -1) {
        break label3782;
      }
      paramawcg.a(new NoColumnError("ipJumpUrl", String.class));
      label2728:
      i = paramCursor.getColumnIndex("ipReqTime");
      if (i != -1) {
        break label3797;
      }
      paramawcg.a(new NoColumnError("ipReqTime", Long.TYPE));
      label2763:
      i = paramCursor.getColumnIndex("ipLastReqTime");
      if (i != -1) {
        break label3812;
      }
      paramawcg.a(new NoColumnError("ipLastReqTime", Long.TYPE));
      label2798:
      i = paramCursor.getColumnIndex("aio");
      if (i != -1) {
        break label3827;
      }
      paramawcg.a(new NoColumnError("aio", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandian");
      if (i != -1) {
        break label3854;
      }
      paramawcg.a(new NoColumnError("kandian", Boolean.TYPE));
      i = paramCursor.getColumnIndex("richIPReqTime");
      if (i != -1) {
        break label3881;
      }
      paramawcg.a(new NoColumnError("richIPReqTime", Long.TYPE));
      label2903:
      i = paramCursor.getColumnIndex("richIPLastReqTime");
      if (i != -1) {
        break label3896;
      }
      paramawcg.a(new NoColumnError("richIPLastReqTime", Long.TYPE));
      label2938:
      i = paramCursor.getColumnIndex("hasIpProduct");
      if (i != -1) {
        break label3911;
      }
      paramawcg.a(new NoColumnError("hasIpProduct", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipSiteInfoBytes");
      if (i != -1) {
        break label3938;
      }
      paramawcg.a(new NoColumnError("ipSiteInfoBytes", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("newSoundEp");
      if (i != -1) {
        break label3953;
      }
      paramawcg.a(new NoColumnError("newSoundEp", Boolean.TYPE));
      return paramawbv;
      paramawbv.epId = paramCursor.getString(i);
      break;
      label3062:
      paramawbv.wordingId = paramCursor.getLong(i);
      break label1188;
      label3077:
      paramawbv.childEpId = paramCursor.getString(i);
      break label1223;
      label3092:
      paramawbv.minQQVersion = paramCursor.getString(i);
      break label1258;
      label3107:
      paramawbv.name = paramCursor.getString(i);
      break label1293;
      label3122:
      paramawbv.mark = paramCursor.getString(i);
      break label1328;
      label3137:
      paramawbv.type = paramCursor.getInt(i);
      break label1363;
      label3152:
      paramawbv.author = paramCursor.getString(i);
      break label1398;
      label3167:
      paramawbv.expiretime = paramCursor.getLong(i);
      break label1433;
      label3182:
      paramawbv.status = paramCursor.getInt(i);
      break label1468;
      label3197:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasSound = paramBoolean;
        break;
      }
      label3224:
      paramawbv.jobType = paramCursor.getInt(i);
      break label1538;
      label3239:
      paramawbv.kinId = paramCursor.getString(i);
      break label1573;
      label3254:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.valid = paramBoolean;
        break;
      }
      label3281:
      paramawbv.downloadCount = paramCursor.getInt(i);
      break label1643;
      label3296:
      paramawbv.mobileFeetype = paramCursor.getInt(i);
      break label1678;
      label3311:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isRecommendation = paramBoolean;
        break;
      }
      label3338:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.isMagicFaceDownloading = paramBoolean;
        break;
      }
      label3365:
      paramawbv.firstEmotionId = paramCursor.getString(i);
      break label1783;
      label3380:
      paramawbv.upperLeftLable = paramCursor.getInt(i);
      break label1818;
      label3395:
      paramawbv.localVersion = paramCursor.getInt(i);
      break label1853;
      label3410:
      paramawbv.latestVersion = paramCursor.getInt(i);
      break label1888;
      label3425:
      paramawbv.jsonVersion = paramCursor.getInt(i);
      break label1923;
      label3440:
      paramawbv.updateFlag = paramCursor.getInt(i);
      break label1958;
      label3455:
      paramawbv.updateTip = paramCursor.getString(i);
      break label1993;
      label3470:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasReadUpdatePage = paramBoolean;
        break;
      }
      label3497:
      paramawbv.rscType = paramCursor.getInt(i);
      break label2063;
      label3512:
      paramawbv.supportSize = paramCursor.getString(i);
      break label2098;
      label3527:
      paramawbv.extraFlags = paramCursor.getInt(i);
      break label2133;
      label3542:
      paramawbv.businessExtra = paramCursor.getString(i);
      break label2168;
      label3557:
      paramawbv.subType = paramCursor.getInt(i);
      break label2203;
      label3572:
      paramawbv.isAPNG = paramCursor.getInt(i);
      break label2238;
      label3587:
      paramawbv.copywritingType = paramCursor.getInt(i);
      break label2273;
      label3602:
      paramawbv.diversionName = paramCursor.getString(i);
      break label2308;
      label3617:
      paramawbv.copywritingContent = paramCursor.getString(i);
      break label2343;
      label3632:
      paramawbv.jumpUrl = paramCursor.getString(i);
      break label2378;
      label3647:
      paramawbv.imageUrl = paramCursor.getString(i);
      break label2413;
      label3662:
      paramawbv.beginTime = paramCursor.getLong(i);
      break label2448;
      label3677:
      paramawbv.endTime = paramCursor.getLong(i);
      break label2483;
      label3692:
      paramawbv.buttonWording = paramCursor.getString(i);
      break label2518;
      label3707:
      paramawbv.comeFom = paramCursor.getString(i);
      break label2553;
      label3722:
      paramawbv.ipUrl = paramCursor.getString(i);
      break label2588;
      label3737:
      paramawbv.ipName = paramCursor.getString(i);
      break label2623;
      label3752:
      paramawbv.ipDetail = paramCursor.getString(i);
      break label2658;
      label3767:
      paramawbv.ipOpName = paramCursor.getString(i);
      break label2693;
      label3782:
      paramawbv.ipJumpUrl = paramCursor.getString(i);
      break label2728;
      label3797:
      paramawbv.ipReqTime = paramCursor.getLong(i);
      break label2763;
      label3812:
      paramawbv.ipLastReqTime = paramCursor.getLong(i);
      break label2798;
      label3827:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.aio = paramBoolean;
        break;
      }
      label3854:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.kandian = paramBoolean;
        break;
      }
      label3881:
      paramawbv.richIPReqTime = paramCursor.getLong(i);
      break label2903;
      label3896:
      paramawbv.richIPLastReqTime = paramCursor.getLong(i);
      break label2938;
      label3911:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawbv.hasIpProduct = paramBoolean;
        break;
      }
      label3938:
      paramawbv.ipSiteInfoBytes = paramCursor.getBlob(i);
    }
    label3953:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramawbv.newSoundEp = paramBoolean;
      return paramawbv;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,wordingId INTEGER ,childEpId TEXT ,minQQVersion TEXT ,name TEXT ,mark TEXT ,type INTEGER ,author TEXT ,expiretime INTEGER ,status INTEGER ,hasSound INTEGER ,jobType INTEGER ,kinId TEXT ,valid INTEGER ,downloadCount INTEGER ,mobileFeetype INTEGER ,isRecommendation INTEGER ,isMagicFaceDownloading INTEGER ,firstEmotionId TEXT ,upperLeftLable INTEGER ,localVersion INTEGER ,latestVersion INTEGER ,jsonVersion INTEGER default 0 ,updateFlag INTEGER ,updateTip TEXT ,hasReadUpdatePage INTEGER ,rscType INTEGER ,supportSize TEXT ,extraFlags INTEGER ,businessExtra TEXT ,subType INTEGER ,isAPNG INTEGER ,copywritingType INTEGER ,diversionName TEXT ,copywritingContent TEXT ,jumpUrl TEXT ,imageUrl TEXT ,beginTime INTEGER ,endTime INTEGER ,buttonWording TEXT ,comeFom TEXT ,ipUrl TEXT ,ipName TEXT ,ipDetail TEXT ,ipOpName TEXT ,ipJumpUrl TEXT ,ipReqTime INTEGER ,ipLastReqTime INTEGER ,aio INTEGER ,kandian INTEGER ,richIPReqTime INTEGER ,richIPLastReqTime INTEGER ,hasIpProduct INTEGER ,ipSiteInfoBytes BLOB ,newSoundEp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (EmoticonPackage)paramawbv;
    paramContentValues.put("epId", paramawbv.epId);
    paramContentValues.put("wordingId", Long.valueOf(paramawbv.wordingId));
    paramContentValues.put("childEpId", paramawbv.childEpId);
    paramContentValues.put("minQQVersion", paramawbv.minQQVersion);
    paramContentValues.put("name", paramawbv.name);
    paramContentValues.put("mark", paramawbv.mark);
    paramContentValues.put("type", Integer.valueOf(paramawbv.type));
    paramContentValues.put("author", paramawbv.author);
    paramContentValues.put("expiretime", Long.valueOf(paramawbv.expiretime));
    paramContentValues.put("status", Integer.valueOf(paramawbv.status));
    paramContentValues.put("hasSound", Boolean.valueOf(paramawbv.hasSound));
    paramContentValues.put("jobType", Integer.valueOf(paramawbv.jobType));
    paramContentValues.put("kinId", paramawbv.kinId);
    paramContentValues.put("valid", Boolean.valueOf(paramawbv.valid));
    paramContentValues.put("downloadCount", Integer.valueOf(paramawbv.downloadCount));
    paramContentValues.put("mobileFeetype", Integer.valueOf(paramawbv.mobileFeetype));
    paramContentValues.put("isRecommendation", Boolean.valueOf(paramawbv.isRecommendation));
    paramContentValues.put("isMagicFaceDownloading", Boolean.valueOf(paramawbv.isMagicFaceDownloading));
    paramContentValues.put("firstEmotionId", paramawbv.firstEmotionId);
    paramContentValues.put("upperLeftLable", Integer.valueOf(paramawbv.upperLeftLable));
    paramContentValues.put("localVersion", Integer.valueOf(paramawbv.localVersion));
    paramContentValues.put("latestVersion", Integer.valueOf(paramawbv.latestVersion));
    paramContentValues.put("jsonVersion", Integer.valueOf(paramawbv.jsonVersion));
    paramContentValues.put("updateFlag", Integer.valueOf(paramawbv.updateFlag));
    paramContentValues.put("updateTip", paramawbv.updateTip);
    paramContentValues.put("hasReadUpdatePage", Boolean.valueOf(paramawbv.hasReadUpdatePage));
    paramContentValues.put("rscType", Integer.valueOf(paramawbv.rscType));
    paramContentValues.put("supportSize", paramawbv.supportSize);
    paramContentValues.put("extraFlags", Integer.valueOf(paramawbv.extraFlags));
    paramContentValues.put("businessExtra", paramawbv.businessExtra);
    paramContentValues.put("subType", Integer.valueOf(paramawbv.subType));
    paramContentValues.put("isAPNG", Integer.valueOf(paramawbv.isAPNG));
    paramContentValues.put("copywritingType", Integer.valueOf(paramawbv.copywritingType));
    paramContentValues.put("diversionName", paramawbv.diversionName);
    paramContentValues.put("copywritingContent", paramawbv.copywritingContent);
    paramContentValues.put("jumpUrl", paramawbv.jumpUrl);
    paramContentValues.put("imageUrl", paramawbv.imageUrl);
    paramContentValues.put("beginTime", Long.valueOf(paramawbv.beginTime));
    paramContentValues.put("endTime", Long.valueOf(paramawbv.endTime));
    paramContentValues.put("buttonWording", paramawbv.buttonWording);
    paramContentValues.put("comeFom", paramawbv.comeFom);
    paramContentValues.put("ipUrl", paramawbv.ipUrl);
    paramContentValues.put("ipName", paramawbv.ipName);
    paramContentValues.put("ipDetail", paramawbv.ipDetail);
    paramContentValues.put("ipOpName", paramawbv.ipOpName);
    paramContentValues.put("ipJumpUrl", paramawbv.ipJumpUrl);
    paramContentValues.put("ipReqTime", Long.valueOf(paramawbv.ipReqTime));
    paramContentValues.put("ipLastReqTime", Long.valueOf(paramawbv.ipLastReqTime));
    paramContentValues.put("aio", Boolean.valueOf(paramawbv.aio));
    paramContentValues.put("kandian", Boolean.valueOf(paramawbv.kandian));
    paramContentValues.put("richIPReqTime", Long.valueOf(paramawbv.richIPReqTime));
    paramContentValues.put("richIPLastReqTime", Long.valueOf(paramawbv.richIPLastReqTime));
    paramContentValues.put("hasIpProduct", Boolean.valueOf(paramawbv.hasIpProduct));
    paramContentValues.put("ipSiteInfoBytes", paramawbv.ipSiteInfoBytes);
    paramContentValues.put("newSoundEp", Boolean.valueOf(paramawbv.newSoundEp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbt
 * JD-Core Version:    0.7.0.1
 */